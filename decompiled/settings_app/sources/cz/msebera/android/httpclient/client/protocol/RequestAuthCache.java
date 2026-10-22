package cz.msebera.android.httpclient.client.protocol;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.auth.AuthProtocolState;
import cz.msebera.android.httpclient.auth.AuthScheme;
import cz.msebera.android.httpclient.auth.AuthScope;
import cz.msebera.android.httpclient.auth.AuthState;
import cz.msebera.android.httpclient.auth.Credentials;
import cz.msebera.android.httpclient.client.AuthCache;
import cz.msebera.android.httpclient.client.CredentialsProvider;
import cz.msebera.android.httpclient.conn.routing.RouteInfo;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class RequestAuthCache implements HttpRequestInterceptor {
    public HttpClientAndroidLog log;

    public RequestAuthCache() {
        this.log = new HttpClientAndroidLog(getClass());
    }

    @Override // cz.msebera.android.httpclient.HttpRequestInterceptor
    public void process(HttpRequest r7, HttpContext r8) throws HttpException, IOException {
        Args.notNull(r7, "HTTP request");
        Args.notNull(r8, "HTTP context");
        HttpClientContext r9 = HttpClientContext.adapt(r8);
        AuthCache r10 = r9.getAuthCache();
        if (r10 != null) goto L6;
        this.log.debug("Auth cache not set in the context");
        return;
    L6:
        CredentialsProvider r0 = r9.getCredentialsProvider();
        if (r0 != null) goto L10;
        this.log.debug("Credentials provider not set in the context");
        return;
    L10:
        RouteInfo r1 = r9.getHttpRoute();
        if (r1 != null) goto L14;
        this.log.debug("Route info not set in the context");
        return;
    L14:
        HttpHost r2 = r9.getTargetHost();
        if (r2 != null) goto L19;
        this.log.debug("Target host not set in the context");
        return;
    L19:
        if (r2.getPort() >= 0) goto L21;
        r2 = new HttpHost(r2.getHostName(), r1.getTargetHost().getPort(), r2.getSchemeName());
    L21:
        AuthState r3 = r9.getTargetAuthState();
        if (r3 != null) goto L24;
    L28:
        HttpHost r4 = r1.getProxyHost();
        AuthState r11 = r9.getProxyAuthState();
        if (r4 == null) goto L37;
        if (r11 != null) goto L32;
        return;
    L32:
        if (r11.getState() != AuthProtocolState.UNCHALLENGED) goto L39;
        AuthScheme r12 = r10.get(r4);
        if (r12 == null) goto L40;
        doPreemptiveAuth(r4, r12, r11, r0);
        return;
    L40:
        return;
    L39:
        return;
    L37:
        return;
    L24:
        if (r3.getState() != AuthProtocolState.UNCHALLENGED) goto L28;
        AuthScheme r5 = r10.get(r2);
        if (r5 == null) goto L28;
        doPreemptiveAuth(r2, r5, r3, r0);
        goto L28
    }

    private void doPreemptiveAuth(HttpHost r5, AuthScheme r6, AuthState r7, CredentialsProvider r8) {
        String r0 = r6.getSchemeName();
        if (this.log.isDebugEnabled() == false) goto L5;
        this.log.debug("Re-using cached '" + r0 + "' auth scheme for " + r5);
    L5:
        Credentials r9 = r8.getCredentials(new AuthScope(r5, AuthScope.ANY_REALM, r0));
        if (r9 == null) goto L8;
        r7.update(r6, r9);
        return;
    L8:
        this.log.debug("No credentials for preemptive authentication");
    }
}
