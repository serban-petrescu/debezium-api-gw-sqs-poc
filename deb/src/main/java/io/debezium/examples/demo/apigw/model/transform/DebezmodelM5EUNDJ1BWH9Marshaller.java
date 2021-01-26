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
 * DebezmodelM5EUNDJ1BWH9Marshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
@SdkInternalApi
public class DebezmodelM5EUNDJ1BWH9Marshaller {

    private static final MarshallingInfo<String> DATA_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
            .marshallLocationName("data").build();

    private static final DebezmodelM5EUNDJ1BWH9Marshaller instance = new DebezmodelM5EUNDJ1BWH9Marshaller();

    public static DebezmodelM5EUNDJ1BWH9Marshaller getInstance() {
        return instance;
    }

    /**
     * Marshall the given parameter object.
     */
    public void marshall(DebezmodelM5EUNDJ1BWH9 debezmodelM5EUNDJ1BWH9, ProtocolMarshaller protocolMarshaller) {

        if (debezmodelM5EUNDJ1BWH9 == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        try {
            protocolMarshaller.marshall(debezmodelM5EUNDJ1BWH9.getData(), DATA_BINDING);
        } catch (Exception e) {
            throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
        }
    }

}
