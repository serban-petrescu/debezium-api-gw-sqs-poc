/**
 * null
 */
package io.debezium.examples.demo.apigw.model.transform;

import java.math.*;

import javax.annotation.Generated;

import io.debezium.examples.demo.apigw.model.*;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.*;
import com.amazonaws.transform.*;

import static com.fasterxml.jackson.core.JsonToken.*;

/**
 * PostTenantsTenantResult JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class PostTenantsTenantResultJsonUnmarshaller implements Unmarshaller<PostTenantsTenantResult, JsonUnmarshallerContext> {

    public PostTenantsTenantResult unmarshall(JsonUnmarshallerContext context) throws Exception {
        PostTenantsTenantResult postTenantsTenantResult = new PostTenantsTenantResult();

        return postTenantsTenantResult;
    }

    private static PostTenantsTenantResultJsonUnmarshaller instance;

    public static PostTenantsTenantResultJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new PostTenantsTenantResultJsonUnmarshaller();
        return instance;
    }
}
