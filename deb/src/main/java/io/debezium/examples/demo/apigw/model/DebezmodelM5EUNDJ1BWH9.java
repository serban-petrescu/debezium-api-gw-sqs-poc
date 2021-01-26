/**
 * null
 */
package io.debezium.examples.demo.apigw.model;

import java.io.Serializable;
import javax.annotation.Generated;
import com.amazonaws.protocol.StructuredPojo;
import com.amazonaws.protocol.ProtocolMarshaller;

/**
 * 
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/8dn7h7f45e-2021-01-26T09:23:34Z/DebezmodelM5EUNDJ1BWH9"
 *      target="_top">AWS API Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class DebezmodelM5EUNDJ1BWH9 implements Serializable, Cloneable, StructuredPojo {

    private String data;

    /**
     * @param data
     */

    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return
     */

    public String getData() {
        return this.data;
    }

    /**
     * @param data
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public DebezmodelM5EUNDJ1BWH9 data(String data) {
        setData(data);
        return this;
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     *
     * @return A string representation of this object.
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getData() != null)
            sb.append("Data: ").append(getData());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof DebezmodelM5EUNDJ1BWH9 == false)
            return false;
        DebezmodelM5EUNDJ1BWH9 other = (DebezmodelM5EUNDJ1BWH9) obj;
        if (other.getData() == null ^ this.getData() == null)
            return false;
        if (other.getData() != null && other.getData().equals(this.getData()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getData() == null) ? 0 : getData().hashCode());
        return hashCode;
    }

    @Override
    public DebezmodelM5EUNDJ1BWH9 clone() {
        try {
            return (DebezmodelM5EUNDJ1BWH9) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }

    @com.amazonaws.annotation.SdkInternalApi
    @Override
    public void marshall(ProtocolMarshaller protocolMarshaller) {
        io.debezium.examples.demo.apigw.model.transform.DebezmodelM5EUNDJ1BWH9Marshaller.getInstance().marshall(this, protocolMarshaller);
    }
}
