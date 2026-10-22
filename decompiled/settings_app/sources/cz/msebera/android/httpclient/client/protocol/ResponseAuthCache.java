package cz.msebera.android.httpclient.client.protocol;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpResponseInterceptor;
import cz.msebera.android.httpclient.auth.AuthProtocolState;
import cz.msebera.android.httpclient.auth.AuthScheme;
import cz.msebera.android.httpclient.auth.AuthState;
import cz.msebera.android.httpclient.client.AuthCache;
import cz.msebera.android.httpclient.conn.scheme.SchemeRegistry;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.impl.client.BasicAuthCache;
import cz.msebera.android.httpclient.protocol.ExecutionContext;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class ResponseAuthCache implements HttpResponseInterceptor {
    public HttpClientAndroidLog log;

    /* JADX INFO: renamed from: cz.msebera.android.httpclient.client.protocol.ResponseAuthCache$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState = null;

        static {
            int[] r0 = new int[AuthProtocolState.values().length];
            $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState = r0;
            r0[AuthProtocolState.CHALLENGED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState[AuthProtocolState.FAILURE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public ResponseAuthCache() {
        this.log = new HttpClientAndroidLog(getClass());
    }

    @Override // cz.msebera.android.httpclient.HttpResponseInterceptor
    public void process(HttpResponse r10, HttpContext r11) throws HttpException, IOException {
        Args.notNull(r10, "HTTP request");
        Args.notNull(r11, "HTTP context");
        AuthCache r0 = (AuthCache) r11.getAttribute("http.auth.auth-cache");
        HttpHost r1 = (HttpHost) r11.getAttribute("http.target_host");
        AuthState r2 = (AuthState) r11.getAttribute("http.auth.target-scope");
        if (r1 == null) goto L21;
        if (r2 == null) goto L21;
        if (this.log.isDebugEnabled() == false) goto L9;
        this.log.debug("Target auth state: " + r2.getState());
    L9:
        if (isCachable(r2) == false) goto L21;
        SchemeRegistry r5 = (SchemeRegistry) r11.getAttribute(ClientContext.SCHEME_REGISTRY);
        if (r1.getPort() >= 0) goto L13;
        r1 = new HttpHost(r1.getHostName(), r5.getScheme(r1).resolvePort(r1.getPort()), r1.getSchemeName());
    L13:
        if (r0 != null) goto L15;
        r0 = new BasicAuthCache();
        r11.setAttribute("http.auth.auth-cache", r0);
    L15:
        int r6 = AnonymousClass1.$SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState[r2.getState().ordinal()];
        if (r6 == 1) goto L20;
        if (r6 != 2) goto L21;
        uncache(r0, r1, r2.getAuthScheme());
        goto L21
    L20:
        cache(r0, r1, r2.getAuthScheme());
    L21:
        HttpHost r3 = (HttpHost) r11.getAttribute(ExecutionContext.HTTP_PROXY_HOST);
        AuthState r4 = (AuthState) r11.getAttribute("http.auth.proxy-scope");
        if (r3 == null) goto L38;
        if (r4 != null) goto L25;
        return;
    L25:
        if (this.log.isDebugEnabled() == false) goto L28;
        this.log.debug("Proxy auth state: " + r4.getState());
    L28:
        if (isCachable(r4) == false) goto L40;
        if (r0 != null) goto L31;
        r0 = new BasicAuthCache();
        r11.setAttribute("http.auth.auth-cache", r0);
    L31:
        int r12 = AnonymousClass1.$SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState[r4.getState().ordinal()];
        if (r12 == 1) goto L36;
        if (r12 != 2) goto L42;
        uncache(r0, r3, r4.getAuthScheme());
        return;
    L42:
        return;
    L36:
        cache(r0, r3, r4.getAuthScheme());
        return;
    L40:
        return;
    }

    private boolean isCachable(AuthState r2) {
        AuthScheme r1 = r2.getAuthScheme();
        if (r1 != null) goto L5;
        return false;
    L5:
        if (r1.isComplete() == false) goto L15;
        String r3 = r1.getSchemeName();
        if (r3.equalsIgnoreCase("Basic") == false) goto L10;
    L11:
        return true;
    L10:
        if (r3.equalsIgnoreCase("Digest") == true) goto L11;
        return false;
    L15:
        return false;
    }

    private void cache(AuthCache r3, HttpHost r4, AuthScheme r5) {
        if (this.log.isDebugEnabled() == false) goto L5;
        this.log.debug("Caching '" + r5.getSchemeName() + "' auth scheme for " + r4);
    L5:
        r3.put(r4, r5);
    }

    private void uncache(AuthCache r3, HttpHost r4, AuthScheme r5) {
        if (this.log.isDebugEnabled() == false) goto L5;
        this.log.debug("Removing from cache '" + r5.getSchemeName() + "' auth scheme for " + r4);
    L5:
        r3.remove(r4);
    }
}
