/**
 * null
 */
package io.debezium.examples.demo.apigw.model.transform;

import java.math.*;

import javax.annotation.Generated;

import io.debezium.examples.demo.apigw.model.*;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.*;
import com.amazonaws.transform.*;

import com.fasterxml.jackson.core.JsonToken;
import static com.fasterxml.jackson.core.JsonToken.*;

/**
 * DebezmodelM5EUNDJ1BWH9 JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class DebezmodelM5EUNDJ1BWH9JsonUnmarshaller implements Unmarshaller<DebezmodelM5EUNDJ1BWH9, JsonUnmarshallerContext> {

    public DebezmodelM5EUNDJ1BWH9 unmarshall(JsonUnmarshallerContext context) throws Exception {
        DebezmodelM5EUNDJ1BWH9 debezmodelM5EUNDJ1BWH9 = new DebezmodelM5EUNDJ1BWH9();

        int originalDepth = context.getCurrentDepth();
        String currentParentElement = context.getCurrentParentElement();
        int targetDepth = originalDepth + 1;

        JsonToken token = context.getCurrentToken();
        if (token == null)
            token = context.nextToken();
        if (token == VALUE_NULL) {
            return null;
        }

        while (true) {
            if (token == null)
                break;

            if (token == FIELD_NAME || token == START_OBJECT) {
                if (context.testExpression("data", targetDepth)) {
                    context.nextToken();
                    debezmodelM5EUNDJ1BWH9.setData(context.getUnmarshaller(String.class).unmarshall(context));
                }
            } else if (token == END_ARRAY || token == END_OBJECT) {
                if (context.getLastParsedParentElement() == null || context.getLastParsedParentElement().equals(currentParentElement)) {
                    if (context.getCurrentDepth() <= originalDepth)
                        break;
                }
            }
            token = context.nextToken();
        }

        return debezmodelM5EUNDJ1BWH9;
    }

    private static DebezmodelM5EUNDJ1BWH9JsonUnmarshaller instance;

    public static DebezmodelM5EUNDJ1BWH9JsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new DebezmodelM5EUNDJ1BWH9JsonUnmarshaller();
        return instance;
    }
}
