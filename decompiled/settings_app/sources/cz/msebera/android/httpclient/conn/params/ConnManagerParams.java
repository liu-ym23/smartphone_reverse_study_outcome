package cz.msebera.android.httpclient.conn.params;

import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public final class ConnManagerParams implements ConnManagerPNames {
    private static final ConnPerRoute DEFAULT_CONN_PER_ROUTE = null;
    public static final int DEFAULT_MAX_TOTAL_CONNECTIONS = 20;

    public ConnManagerParams() {
    }

    @Deprecated
    public static long getTimeout(HttpParams r3) {
        Args.notNull(r3, "HTTP parameters");
        return r3.getLongParameter("http.conn-manager.timeout", 0);
    }

    @Deprecated
    public static void setTimeout(HttpParams r1, long r2) {
        Args.notNull(r1, "HTTP parameters");
        r1.setLongParameter("http.conn-manager.timeout", r2);
    }

    static {
        DEFAULT_CONN_PER_ROUTE = new AnonymousClass1();
    }

    public static void setMaxConnectionsPerRoute(HttpParams r1, ConnPerRoute r2) {
        Args.notNull(r1, "HTTP parameters");
        r1.setParameter(ConnManagerPNames.MAX_CONNECTIONS_PER_ROUTE, r2);
    }

    public static ConnPerRoute getMaxConnectionsPerRoute(HttpParams r1) {
        Args.notNull(r1, "HTTP parameters");
        ConnPerRoute r2 = (ConnPerRoute) r1.getParameter(ConnManagerPNames.MAX_CONNECTIONS_PER_ROUTE);
        if (r2 == null) goto L5;
        return r2;
    L5:
        return DEFAULT_CONN_PER_ROUTE;
    }

    public static void setMaxTotalConnections(HttpParams r1, int r2) {
        Args.notNull(r1, "HTTP parameters");
        r1.setIntParameter(ConnManagerPNames.MAX_TOTAL_CONNECTIONS, r2);
    }

    public static int getMaxTotalConnections(HttpParams r2) {
        Args.notNull(r2, "HTTP parameters");
        return r2.getIntParameter(ConnManagerPNames.MAX_TOTAL_CONNECTIONS, 20);
    }
}
