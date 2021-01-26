# Debezium - API GW - SQS PoC

This is a proof of concept which sends messages via Debezium to an SQS FIFO queue fronted by an API GW. The API GW is used to perform tenant-based fine grained authorization.

## Using it

To generate the infrastructure:
 - Cd into `./aws`,
 - Run `npm install`,
 - Run `npx cdk deploy`.

After the deployment has completed, you will get an API Gateway URL as an output and an IAM role. 

Open the `./deb` in a Java IDE. Install the maven dependencies. Change the `ChangeDataSender` constructor to match the endpoint generated before.

Assume the role generated before: `aws sts assume-role --role-session-name bla --role-arn <role arn comes here>`. Set the `AWS_ACCESS_KEY_ID`, `AWS_SECRET_ACCESS_KEY` and `AWS_SESSION_TOKEN` environment variables to match the generated credentials.

Now you can start the main method in the `ChangeDataSender` Java class. If should enqueue a message in the AWS SQS queue. If you adjust the tenant at the end of the `sendRecord` method, the execution should fail. 
