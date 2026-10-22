package cz.msebera.android.httpclient.client.params;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.params.HttpAbstractParamBean;
import cz.msebera.android.httpclient.params.HttpParams;
import java.util.Collection;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class ClientParamBean extends HttpAbstractParamBean {
    public ClientParamBean(HttpParams r1) {
        super(r1);
    }

    @Deprecated
    public void setConnectionManagerFactoryClassName(String r2) {
        this.params.setParameter(ClientPNames.CONNECTION_MANAGER_FACTORY_CLASS_NAME, r2);
    }

    public void setHandleRedirects(boolean r2) {
        this.params.setBooleanParameter(ClientPNames.HANDLE_REDIRECTS, r2);
    }

    public void setRejectRelativeRedirect(boolean r2) {
        this.params.setBooleanParameter(ClientPNames.REJECT_RELATIVE_REDIRECT, r2);
    }

    public void setMaxRedirects(int r2) {
        this.params.setIntParameter(ClientPNames.MAX_REDIRECTS, r2);
    }

    public void setAllowCircularRedirects(boolean r2) {
        this.params.setBooleanParameter(ClientPNames.ALLOW_CIRCULAR_REDIRECTS, r2);
    }

    public void setHandleAuthentication(boolean r2) {
        this.params.setBooleanParameter(ClientPNames.HANDLE_AUTHENTICATION, r2);
    }

    public void setCookiePolicy(String r2) {
        this.params.setParameter(ClientPNames.COOKIE_POLICY, r2);
    }

    public void setVirtualHost(HttpHost r2) {
        this.params.setParameter(ClientPNames.VIRTUAL_HOST, r2);
    }

    public void setDefaultHeaders(Collection<Header> r2) {
        this.params.setParameter(ClientPNames.DEFAULT_HEADERS, r2);
    }

    public void setDefaultHost(HttpHost r2) {
        this.params.setParameter(ClientPNames.DEFAULT_HOST, r2);
    }

    public void setConnectionManagerTimeout(long r2) {
        this.params.setLongParameter("http.conn-manager.timeout", r2);
    }
}
