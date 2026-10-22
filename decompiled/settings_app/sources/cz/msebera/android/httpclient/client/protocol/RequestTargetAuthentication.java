package cz.msebera.android.httpclient.client.protocol;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.auth.AuthState;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class RequestTargetAuthentication extends RequestAuthenticationBase {
    public RequestTargetAuthentication() {
    }

    @Override // cz.msebera.android.httpclient.HttpRequestInterceptor
    public void process(HttpRequest r5, HttpContext r6) throws HttpException, IOException {
        Args.notNull(r5, "HTTP request");
        Args.notNull(r6, "HTTP context");
        if (r5.getRequestLine().getMethod().equalsIgnoreCase("CONNECT") == false) goto L6;
        return;
    L6:
        if (r5.containsHeader("Authorization") == false) goto L8;
        return;
    L8:
        AuthState r0 = (AuthState) r6.getAttribute("http.auth.target-scope");
        if (r0 != null) goto L13;
        this.log.debug("Target auth state not set in the context");
        return;
    L13:
        if (this.log.isDebugEnabled() == false) goto L15;
        this.log.debug("Target auth state: " + r0.getState());
    L15:
        process(r0, r5, r6);
    }
}
