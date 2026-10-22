package cz.msebera.android.httpclient.client.protocol;

import cz.msebera.android.httpclient.auth.AuthSchemeRegistry;
import cz.msebera.android.httpclient.client.CookieStore;
import cz.msebera.android.httpclient.client.CredentialsProvider;
import cz.msebera.android.httpclient.cookie.CookieSpecRegistry;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class ClientContextConfigurer implements ClientContext {
    private final HttpContext context;

    public ClientContextConfigurer(HttpContext r2) {
        Args.notNull(r2, "HTTP context");
        this.context = r2;
    }

    public void setCookieSpecRegistry(CookieSpecRegistry r2) {
        this.context.setAttribute("http.cookiespec-registry", r2);
    }

    public void setAuthSchemeRegistry(AuthSchemeRegistry r2) {
        this.context.setAttribute("http.authscheme-registry", r2);
    }

    public void setCookieStore(CookieStore r2) {
        this.context.setAttribute("http.cookie-store", r2);
    }

    public void setCredentialsProvider(CredentialsProvider r2) {
        this.context.setAttribute("http.auth.credentials-provider", r2);
    }
}
