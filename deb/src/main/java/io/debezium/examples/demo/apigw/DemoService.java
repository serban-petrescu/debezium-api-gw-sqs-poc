/**
 * null
 */
package io.debezium.examples.demo.apigw;

import javax.annotation.Generated;

import com.amazonaws.*;
import com.amazonaws.opensdk.*;
import com.amazonaws.opensdk.model.*;
import com.amazonaws.regions.*;

import io.debezium.examples.demo.apigw.model.*;

/**
 * Interface for accessing DemoService.
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public interface DemoService {

    /**
     * @param postTenantsTenantRequest
     * @return Result of the PostTenantsTenant operation returned by the service.
     * @sample DemoService.PostTenantsTenant
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/8dn7h7f45e-2021-01-26T09:23:34Z/PostTenantsTenant"
     *      target="_top">AWS API Documentation</a>
     */
    PostTenantsTenantResult postTenantsTenant(PostTenantsTenantRequest postTenantsTenantRequest);

    /**
     * @return Create new instance of builder with all defaults set.
     */
    public static DemoServiceClientBuilder builder() {
        return new DemoServiceClientBuilder();
    }

    /**
     * Shuts down this client object, releasing any resources that might be held open. This is an optional method, and
     * callers are not expected to call it, but can if they want to explicitly release any open resources. Once a client
     * has been shutdown, it should not be used to make any more requests.
     */
    void shutdown();

}
