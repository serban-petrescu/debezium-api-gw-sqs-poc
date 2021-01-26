/**
 * null
 */
package io.debezium.examples.demo.apigw;

import com.amazonaws.annotation.NotThreadSafe;
import com.amazonaws.client.AwsSyncClientParams;
import com.amazonaws.opensdk.protect.client.SdkSyncClientBuilder;
import com.amazonaws.opensdk.internal.config.ApiGatewayClientConfigurationFactory;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.Signer;
import com.amazonaws.util.RuntimeHttpUtils;
import com.amazonaws.Protocol;

import java.net.URI;
import javax.annotation.Generated;

/**
 * Fluent builder for {@link io.debezium.examples.demo.apigw.DemoService}.
 * 
 * @see io.debezium.examples.demo.apigw.DemoService#builder
 **/
@NotThreadSafe
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public final class DemoServiceClientBuilder extends SdkSyncClientBuilder<DemoServiceClientBuilder, DemoService> {

    private static final URI DEFAULT_ENDPOINT = RuntimeHttpUtils.toUri("8dn7h7f45e.execute-api.us-east-1.amazonaws.com", Protocol.HTTPS);
    private static final String DEFAULT_REGION = "us-east-1";

    /**
     * Package private constructor - builder should be created via {@link DemoService#builder()}
     */
    DemoServiceClientBuilder() {
        super(new ApiGatewayClientConfigurationFactory());
    }

    /**
     * Specify an implementation of {@link AWSCredentialsProvider} to be used when signing IAM auth'd requests
     *
     * @param iamCredentials
     *        the credential provider
     */
    @Override
    public void setIamCredentials(AWSCredentialsProvider iamCredentials) {
        super.setIamCredentials(iamCredentials);
    }

    /**
     * Specify an implementation of {@link AWSCredentialsProvider} to be used when signing IAM auth'd requests
     *
     * @param iamCredentials
     *        the credential provider
     * @return This object for method chaining.
     */
    public DemoServiceClientBuilder iamCredentials(AWSCredentialsProvider iamCredentials) {
        setIamCredentials(iamCredentials);
        return this;
    }

    /**
     * Sets the IAM region to use when using IAM auth'd requests against a service in any of it's non-default regions.
     * This is only expected to be used when a custom endpoint has also been set.
     *
     * @param iamRegion
     *        the IAM region string to use when signing
     */
    public void setIamRegion(String iamRegion) {
        super.setIamRegion(iamRegion);
    }

    /**
     * Sets the IAM region to use when using IAM auth'd requests against a service in any of it's non-default regions.
     * This is only expected to be used when a custom endpoint has also been set.
     *
     * @param iamRegion
     *        the IAM region string to use when signing
     * @return This object for method chaining.
     */
    public DemoServiceClientBuilder iamRegion(String iamRegion) {
        setIamRegion(iamRegion);
        return this;
    }

    /**
     * Construct a synchronous implementation of DemoService using the current builder configuration.
     *
     * @param params
     *        Current builder configuration represented as a parameter object.
     * @return Fully configured implementation of DemoService.
     */
    @Override
    protected DemoService build(AwsSyncClientParams params) {
        return new DemoServiceClient(params);
    }

    @Override
    protected URI defaultEndpoint() {
        return DEFAULT_ENDPOINT;
    }

    @Override
    protected String defaultRegion() {
        return DEFAULT_REGION;
    }

    @Override
    protected Signer defaultIamSigner() {
        return signerFactory().createSigner();
    }
}
