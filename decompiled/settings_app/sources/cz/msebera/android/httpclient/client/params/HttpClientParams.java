package cz.msebera.android.httpclient.client.params;

import cz.msebera.android.httpclient.params.HttpConnectionParams;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class HttpClientParams {
    private HttpClientParams() {
    }

    public static boolean isRedirecting(HttpParams r2) {
        Args.notNull(r2, "HTTP parameters");
        return r2.getBooleanParameter(ClientPNames.HANDLE_REDIRECTS, true);
    }

    public static void setRedirecting(HttpParams r1, boolean r2) {
        Args.notNull(r1, "HTTP parameters");
        r1.setBooleanParameter(ClientPNames.HANDLE_REDIRECTS, r2);
    }

    public static boolean isAuthenticating(HttpParams r2) {
        Args.notNull(r2, "HTTP parameters");
        return r2.getBooleanParameter(ClientPNames.HANDLE_AUTHENTICATION, true);
    }

    public static void setAuthenticating(HttpParams r1, boolean r2) {
        Args.notNull(r1, "HTTP parameters");
        r1.setBooleanParameter(ClientPNames.HANDLE_AUTHENTICATION, r2);
    }

    public static String getCookiePolicy(HttpParams r1) {
        Args.notNull(r1, "HTTP parameters");
        String r2 = (String) r1.getParameter(ClientPNames.COOKIE_POLICY);
        if (r2 != null) goto L6;
        return "best-match";
    L6:
        return r2;
    }

    public static void setCookiePolicy(HttpParams r1, String r2) {
        Args.notNull(r1, "HTTP parameters");
        r1.setParameter(ClientPNames.COOKIE_POLICY, r2);
    }

    public static void setConnectionManagerTimeout(HttpParams r1, long r2) {
        Args.notNull(r1, "HTTP parameters");
        r1.setLongParameter("http.conn-manager.timeout", r2);
    }

    public static long getConnectionManagerTimeout(HttpParams r2) {
        Args.notNull(r2, "HTTP parameters");
        Long r0 = (Long) r2.getParameter("http.conn-manager.timeout");
        if (r0 == null) goto L7;
        return r0.longValue();
    L7:
        return HttpConnectionParams.getConnectionTimeout(r2);
    }
}
