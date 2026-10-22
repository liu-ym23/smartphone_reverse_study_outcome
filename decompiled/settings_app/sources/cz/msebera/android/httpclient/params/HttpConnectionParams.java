package cz.msebera.android.httpclient.params;

import cz.msebera.android.httpclient.util.Args;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public final class HttpConnectionParams implements CoreConnectionPNames {
    private HttpConnectionParams() {
    }

    public static int getSoTimeout(HttpParams r2) {
        Args.notNull(r2, "HTTP parameters");
        return r2.getIntParameter(CoreConnectionPNames.SO_TIMEOUT, 0);
    }

    public static void setSoTimeout(HttpParams r1, int r2) {
        Args.notNull(r1, "HTTP parameters");
        r1.setIntParameter(CoreConnectionPNames.SO_TIMEOUT, r2);
    }

    public static boolean getSoReuseaddr(HttpParams r2) {
        Args.notNull(r2, "HTTP parameters");
        return r2.getBooleanParameter(CoreConnectionPNames.SO_REUSEADDR, false);
    }

    public static void setSoReuseaddr(HttpParams r1, boolean r2) {
        Args.notNull(r1, "HTTP parameters");
        r1.setBooleanParameter(CoreConnectionPNames.SO_REUSEADDR, r2);
    }

    public static boolean getTcpNoDelay(HttpParams r2) {
        Args.notNull(r2, "HTTP parameters");
        return r2.getBooleanParameter(CoreConnectionPNames.TCP_NODELAY, true);
    }

    public static void setTcpNoDelay(HttpParams r1, boolean r2) {
        Args.notNull(r1, "HTTP parameters");
        r1.setBooleanParameter(CoreConnectionPNames.TCP_NODELAY, r2);
    }

    public static int getSocketBufferSize(HttpParams r2) {
        Args.notNull(r2, "HTTP parameters");
        return r2.getIntParameter(CoreConnectionPNames.SOCKET_BUFFER_SIZE, -1);
    }

    public static void setSocketBufferSize(HttpParams r1, int r2) {
        Args.notNull(r1, "HTTP parameters");
        r1.setIntParameter(CoreConnectionPNames.SOCKET_BUFFER_SIZE, r2);
    }

    public static int getLinger(HttpParams r2) {
        Args.notNull(r2, "HTTP parameters");
        return r2.getIntParameter(CoreConnectionPNames.SO_LINGER, -1);
    }

    public static void setLinger(HttpParams r1, int r2) {
        Args.notNull(r1, "HTTP parameters");
        r1.setIntParameter(CoreConnectionPNames.SO_LINGER, r2);
    }

    public static int getConnectionTimeout(HttpParams r2) {
        Args.notNull(r2, "HTTP parameters");
        return r2.getIntParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 0);
    }

    public static void setConnectionTimeout(HttpParams r1, int r2) {
        Args.notNull(r1, "HTTP parameters");
        r1.setIntParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, r2);
    }

    public static boolean isStaleCheckingEnabled(HttpParams r2) {
        Args.notNull(r2, "HTTP parameters");
        return r2.getBooleanParameter(CoreConnectionPNames.STALE_CONNECTION_CHECK, true);
    }

    public static void setStaleCheckingEnabled(HttpParams r1, boolean r2) {
        Args.notNull(r1, "HTTP parameters");
        r1.setBooleanParameter(CoreConnectionPNames.STALE_CONNECTION_CHECK, r2);
    }

    public static boolean getSoKeepalive(HttpParams r2) {
        Args.notNull(r2, "HTTP parameters");
        return r2.getBooleanParameter(CoreConnectionPNames.SO_KEEPALIVE, false);
    }

    public static void setSoKeepalive(HttpParams r1, boolean r2) {
        Args.notNull(r1, "HTTP parameters");
        r1.setBooleanParameter(CoreConnectionPNames.SO_KEEPALIVE, r2);
    }
}
