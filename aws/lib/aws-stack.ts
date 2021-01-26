import * as cdk from '@aws-cdk/core';
import * as sqs from '@aws-cdk/aws-sqs';
import * as iam from '@aws-cdk/aws-iam';
import * as apigw from '@aws-cdk/aws-apigateway';

export class AwsStack extends cdk.Stack {
  constructor(scope: cdk.Construct, id: string, props?: cdk.StackProps) {
    super(scope, id, props);

    const queue = new sqs.Queue(this, 'queue', {
      fifo: true,
      contentBasedDeduplication: true
    });

    const api = new apigw.RestApi(this, 'api', {
      deployOptions: {
        loggingLevel: apigw.MethodLoggingLevel.INFO,
        dataTraceEnabled: true
      }
    });

    const role = new iam.Role(this, 'apigw-role', {
      assumedBy: new iam.ServicePrincipal('apigateway.amazonaws.com')
    });
    queue.grantSendMessages(role);

    api.root.addResource('tenants').addResource('{tenant}').addMethod('POST', new apigw.AwsIntegration({
      service: 'sqs',
      integrationHttpMethod: 'POST',
      path: this.account + '/' + queue.queueName,
      options: {
        credentialsRole: role,
        passthroughBehavior: apigw.PassthroughBehavior.NEVER,
        requestParameters: {
          'integration.request.header.Content-Type': "'application/x-www-form-urlencoded'",
        },
        requestTemplates: {
          'application/json': `Version=2012-11-05&Action=SendMessage&MessageGroupId=$input.params('tenant')&MessageBody=$input.body`
        },
        integrationResponses: [{
          statusCode: '204',
          responseTemplates: {
            'application/json': ''
          }
        }]
      },
    }), {
      authorizationType: apigw.AuthorizationType.IAM,
      methodResponses: [{
        statusCode: '204',
      }],
      requestParameters: {
        'method.request.path.tenant': true
      },
      requestModels: {
        'application/json': new apigw.Model(this, 'model', {
          restApi: api,
          schema: {
            type: apigw.JsonSchemaType.OBJECT,
            properties: {
              data: {
                type: apigw.JsonSchemaType.STRING
              }
            }
          }
        })
      }
    });

    const userArn = new cdk.CfnParameter(this, 'user-which-assumes', {
      default: 'arn:aws:iam::162174280605:user/serban.petrescu'
    });

    const debeziumRole = new iam.Role(this, 'debezium-role', {
      assumedBy: new iam.ArnPrincipal(userArn.valueAsString),
      inlinePolicies: {
        'inline': new iam.PolicyDocument({
          statements: [
            new iam.PolicyStatement({
              effect: iam.Effect.ALLOW,
              actions: ["execute-api:Invoke"],
              resources: [api.arnForExecuteApi("POST", "/tenants/A")]
            })
          ]
        })
      }
    });

    new cdk.CfnOutput(this, 'debezium-role-output', {
      value: debeziumRole.roleArn
    })

  }
}
