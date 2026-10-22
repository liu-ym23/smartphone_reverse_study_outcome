package cz.msebera.android.httpclient.client.protocol;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.auth.AuthState;
import cz.msebera.android.httpclient.conn.HttpRoutedConnection;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class RequestProxyAuthentication extends RequestAuthenticationBase {
    public RequestProxyAuthentication() {
    }

    @Override // cz.msebera.android.httpclient.HttpRequestInterceptor
    public void process(HttpRequest r5, HttpContext r6) throws HttpException, IOException {
        Args.notNull(r5, "HTTP request");
        Args.notNull(r6, "HTTP context");
        if (r5.containsHeader("Proxy-Authorization") == false) goto L5;
        return;
    L5:
        HttpRoutedConnection r0 = (HttpRoutedConnection) r6.getAttribute("http.connection");
        if (r0 != null) goto L10;
        this.log.debug("HTTP connection not set in the context");
        return;
    L10:
        if (r0.getRoute().isTunnelled() == false) goto L12;
        return;
    L12:
        AuthState r1 = (AuthState) r6.getAttribute("http.auth.proxy-scope");
        if (r1 != null) goto L17;
        this.log.debug("Proxy auth state not set in the context");
        return;
    L17:
        if (this.log.isDebugEnabled() == false) goto L19;
        this.log.debug("Proxy auth state: " + r1.getState());
    L19:
        process(r1, r5, r6);
    }
}
