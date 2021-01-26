/**
 * null
 */
package io.debezium.examples.demo.apigw.model.transform;

import javax.annotation.Generated;

import com.amazonaws.SdkClientException;
import io.debezium.examples.demo.apigw.model.*;

import com.amazonaws.protocol.*;
import com.amazonaws.annotation.SdkInternalApi;

/**
 * PostTenantsTenantRequestMarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
@SdkInternalApi
public class PostTenantsTenantRequestMarshaller {

    private static final MarshallingInfo<StructuredPojo> DEBEZMODELM5EUNDJ1BWH9_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
            .marshallLocation(MarshallLocation.PAYLOAD).isExplicitPayloadMember(true).build();
    private static final MarshallingInfo<String> TENANT_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PATH)
            .marshallLocationName("tenant").build();

    private static final PostTenantsTenantRequestMarshaller instance = new PostTenantsTenantRequestMarshaller();

    public static PostTenantsTenantRequestMarshaller getInstance() {
        return instance;
    }

    /**
     * Marshall the given parameter object.
     */
    public void marshall(PostTenantsTenantRequest postTenantsTenantRequest, ProtocolMarshaller protocolMarshaller) {

        if (postTenantsTenantRequest == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        try {
            protocolMarshaller.marshall(postTenantsTenantRequest.getDebezmodelM5EUNDJ1BWH9(), DEBEZMODELM5EUNDJ1BWH9_BINDING);
            protocolMarshaller.marshall(postTenantsTenantRequest.getTenant(), TENANT_BINDING);
        } catch (Exception e) {
            throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
        }
    }

}
