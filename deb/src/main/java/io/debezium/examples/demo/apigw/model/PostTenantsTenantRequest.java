/**
 * null
 */
package io.debezium.examples.demo.apigw.model;

import java.io.Serializable;
import javax.annotation.Generated;

import com.amazonaws.auth.RequestSigner;
import com.amazonaws.opensdk.protect.auth.RequestSignerAware;

/**
 * 
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/8dn7h7f45e-2021-01-26T09:23:34Z/PostTenantsTenant"
 *      target="_top">AWS API Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class PostTenantsTenantRequest extends com.amazonaws.opensdk.BaseRequest implements Serializable, Cloneable, RequestSignerAware {

    private DebezmodelM5EUNDJ1BWH9 debezmodelM5EUNDJ1BWH9;

    private String tenant;

    /**
     * @param debezmodelM5EUNDJ1BWH9
     */

    public void setDebezmodelM5EUNDJ1BWH9(DebezmodelM5EUNDJ1BWH9 debezmodelM5EUNDJ1BWH9) {
        this.debezmodelM5EUNDJ1BWH9 = debezmodelM5EUNDJ1BWH9;
    }

    /**
     * @return
     */

    public DebezmodelM5EUNDJ1BWH9 getDebezmodelM5EUNDJ1BWH9() {
        return this.debezmodelM5EUNDJ1BWH9;
    }

    /**
     * @param debezmodelM5EUNDJ1BWH9
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public PostTenantsTenantRequest debezmodelM5EUNDJ1BWH9(DebezmodelM5EUNDJ1BWH9 debezmodelM5EUNDJ1BWH9) {
        setDebezmodelM5EUNDJ1BWH9(debezmodelM5EUNDJ1BWH9);
        return this;
    }

    /**
     * @param tenant
     */

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    /**
     * @return
     */

    public String getTenant() {
        return this.tenant;
    }

    /**
     * @param tenant
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public PostTenantsTenantRequest tenant(String tenant) {
        setTenant(tenant);
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
        if (getDebezmodelM5EUNDJ1BWH9() != null)
            sb.append("DebezmodelM5EUNDJ1BWH9: ").append(getDebezmodelM5EUNDJ1BWH9()).append(",");
        if (getTenant() != null)
            sb.append("Tenant: ").append(getTenant());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof PostTenantsTenantRequest == false)
            return false;
        PostTenantsTenantRequest other = (PostTenantsTenantRequest) obj;
        if (other.getDebezmodelM5EUNDJ1BWH9() == null ^ this.getDebezmodelM5EUNDJ1BWH9() == null)
            return false;
        if (other.getDebezmodelM5EUNDJ1BWH9() != null && other.getDebezmodelM5EUNDJ1BWH9().equals(this.getDebezmodelM5EUNDJ1BWH9()) == false)
            return false;
        if (other.getTenant() == null ^ this.getTenant() == null)
            return false;
        if (other.getTenant() != null && other.getTenant().equals(this.getTenant()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getDebezmodelM5EUNDJ1BWH9() == null) ? 0 : getDebezmodelM5EUNDJ1BWH9().hashCode());
        hashCode = prime * hashCode + ((getTenant() == null) ? 0 : getTenant().hashCode());
        return hashCode;
    }

    @Override
    public PostTenantsTenantRequest clone() {
        return (PostTenantsTenantRequest) super.clone();
    }

    @Override
    public Class<? extends RequestSigner> signerType() {
        return com.amazonaws.opensdk.protect.auth.IamRequestSigner.class;
    }

    /**
     * Set the configuration for this request.
     *
     * @param sdkRequestConfig
     *        Request configuration.
     * @return This object for method chaining.
     */
    public PostTenantsTenantRequest sdkRequestConfig(com.amazonaws.opensdk.SdkRequestConfig sdkRequestConfig) {
        super.sdkRequestConfig(sdkRequestConfig);
        return this;
    }

}
