package cz.msebera.android.httpclient.client.params;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.auth.params.AuthPNames;
import cz.msebera.android.httpclient.client.config.RequestConfig;
import cz.msebera.android.httpclient.conn.params.ConnRoutePNames;
import cz.msebera.android.httpclient.params.CoreConnectionPNames;
import cz.msebera.android.httpclient.params.HttpParams;
import java.net.InetAddress;
import java.util.Collection;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public final class HttpClientParamConfig {
    private HttpClientParamConfig() {
    }

    public static RequestConfig getRequestConfig(HttpParams r1) {
        return getRequestConfig(r1, RequestConfig.DEFAULT);
    }

    public static RequestConfig getRequestConfig(HttpParams r4, RequestConfig r5) {
        RequestConfig.Builder r6 = RequestConfig.copy(r5).setSocketTimeout(r4.getIntParameter(CoreConnectionPNames.SO_TIMEOUT, r5.getSocketTimeout())).setStaleConnectionCheckEnabled(r4.getBooleanParameter(CoreConnectionPNames.STALE_CONNECTION_CHECK, r5.isStaleConnectionCheckEnabled())).setConnectTimeout(r4.getIntParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, r5.getConnectTimeout())).setExpectContinueEnabled(r4.getBooleanParameter("http.protocol.expect-continue", r5.isExpectContinueEnabled())).setAuthenticationEnabled(r4.getBooleanParameter(ClientPNames.HANDLE_AUTHENTICATION, r5.isAuthenticationEnabled())).setCircularRedirectsAllowed(r4.getBooleanParameter(ClientPNames.ALLOW_CIRCULAR_REDIRECTS, r5.isCircularRedirectsAllowed())).setConnectionRequestTimeout((int) r4.getLongParameter("http.conn-manager.timeout", r5.getConnectionRequestTimeout())).setMaxRedirects(r4.getIntParameter(ClientPNames.MAX_REDIRECTS, r5.getMaxRedirects())).setRedirectsEnabled(r4.getBooleanParameter(ClientPNames.HANDLE_REDIRECTS, r5.isRedirectsEnabled())).setRelativeRedirectsAllowed(!r4.getBooleanParameter(ClientPNames.REJECT_RELATIVE_REDIRECT, !r5.isRelativeRedirectsAllowed()));
        HttpHost r0 = (HttpHost) r4.getParameter(ConnRoutePNames.DEFAULT_PROXY);
        if (r0 == null) goto L5;
        r6.setProxy(r0);
    L5:
        InetAddress r1 = (InetAddress) r4.getParameter(ConnRoutePNames.LOCAL_ADDRESS);
        if (r1 == null) goto L8;
        r6.setLocalAddress(r1);
    L8:
        Collection<String> r2 = (Collection) r4.getParameter(AuthPNames.TARGET_AUTH_PREF);
        if (r2 == null) goto L11;
        r6.setTargetPreferredAuthSchemes(r2);
    L11:
        Collection<String> r3 = (Collection) r4.getParameter(AuthPNames.PROXY_AUTH_PREF);
        if (r3 == null) goto L14;
        r6.setProxyPreferredAuthSchemes(r3);
    L14:
        String r7 = (String) r4.getParameter(ClientPNames.COOKIE_POLICY);
        if (r7 == null) goto L18;
        r6.setCookieSpec(r7);
    L18:
        return r6.build();
    }
}
