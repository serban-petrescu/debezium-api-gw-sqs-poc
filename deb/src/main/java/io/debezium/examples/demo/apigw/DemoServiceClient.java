/**
 * null
 */
package io.debezium.examples.demo.apigw;

import java.net.*;
import java.util.*;

import javax.annotation.Generated;

import org.apache.commons.logging.*;

import com.amazonaws.*;
import com.amazonaws.opensdk.*;
import com.amazonaws.opensdk.model.*;
import com.amazonaws.opensdk.protect.model.transform.*;
import com.amazonaws.auth.*;
import com.amazonaws.handlers.*;
import com.amazonaws.http.*;
import com.amazonaws.internal.*;
import com.amazonaws.metrics.*;
import com.amazonaws.regions.*;
import com.amazonaws.transform.*;
import com.amazonaws.util.*;
import com.amazonaws.protocol.json.*;

import com.amazonaws.annotation.ThreadSafe;
import com.amazonaws.client.AwsSyncClientParams;

import com.amazonaws.client.ClientHandler;
import com.amazonaws.client.ClientHandlerParams;
import com.amazonaws.client.ClientExecutionParams;
import com.amazonaws.opensdk.protect.client.SdkClientHandler;
import com.amazonaws.SdkBaseException;

import io.debezium.examples.demo.apigw.model.*;
import io.debezium.examples.demo.apigw.model.transform.*;

/**
 * Client for accessing DemoService. All service calls made using this client are blocking, and will not return until
 * the service call completes.
 * <p>
 * 
 */
@ThreadSafe
@Generated("com.amazonaws:aws-java-sdk-code-generator")
class DemoServiceClient implements DemoService {

    private final ClientHandler clientHandler;

    private static final com.amazonaws.opensdk.protect.protocol.ApiGatewayProtocolFactoryImpl protocolFactory = new com.amazonaws.opensdk.protect.protocol.ApiGatewayProtocolFactoryImpl(
            new JsonClientMetadata().withProtocolVersion("1.1").withSupportsCbor(false).withSupportsIon(false).withContentTypeOverride("application/json")
                    .withBaseServiceExceptionClass(io.debezium.examples.demo.apigw.model.DemoServiceException.class));

    /**
     * Constructs a new client to invoke service methods on DemoService using the specified parameters.
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not return until the service call
     * completes.
     *
     * @param clientParams
     *        Object providing client parameters.
     */
    DemoServiceClient(AwsSyncClientParams clientParams) {
        this.clientHandler = new SdkClientHandler(new ClientHandlerParams().withClientParams(clientParams));
    }

    /**
     * @param postTenantsTenantRequest
     * @return Result of the PostTenantsTenant operation returned by the service.
     * @sample DemoService.PostTenantsTenant
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/8dn7h7f45e-2021-01-26T09:23:34Z/PostTenantsTenant"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public PostTenantsTenantResult postTenantsTenant(PostTenantsTenantRequest postTenantsTenantRequest) {
        HttpResponseHandler<PostTenantsTenantResult> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata().withPayloadJson(true)
                .withHasStreamingSuccessResponse(false), new PostTenantsTenantResultJsonUnmarshaller());

        HttpResponseHandler<SdkBaseException> errorResponseHandler = createErrorResponseHandler();

        return clientHandler.execute(new ClientExecutionParams<PostTenantsTenantRequest, PostTenantsTenantResult>()
                .withMarshaller(new PostTenantsTenantRequestProtocolMarshaller(protocolFactory)).withResponseHandler(responseHandler)
                .withErrorResponseHandler(errorResponseHandler).withInput(postTenantsTenantRequest));
    }

    /**
     * Create the error response handler for the operation.
     * 
     * @param errorShapeMetadata
     *        Error metadata for the given operation
     * @return Configured error response handler to pass to HTTP layer
     */
    private HttpResponseHandler<SdkBaseException> createErrorResponseHandler(JsonErrorShapeMetadata... errorShapeMetadata) {
        return protocolFactory.createErrorResponseHandler(new JsonErrorResponseMetadata().withErrorShapes(Arrays.asList(errorShapeMetadata)));
    }

    @Override
    public void shutdown() {
        clientHandler.shutdown();
    }

}
