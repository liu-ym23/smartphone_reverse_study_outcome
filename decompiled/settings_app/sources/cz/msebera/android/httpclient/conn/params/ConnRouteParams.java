package cz.msebera.android.httpclient.conn.params;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import java.net.InetAddress;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class ConnRouteParams implements ConnRoutePNames {
    public static final HttpHost NO_HOST = null;
    public static final HttpRoute NO_ROUTE = null;

    static {
        HttpHost r0 = new HttpHost("127.0.0.255", 0, "no-host");
        NO_HOST = r0;
        NO_ROUTE = new HttpRoute(r0);
    }

    private ConnRouteParams() {
    }

    public static HttpHost getDefaultProxy(HttpParams r1) {
        Args.notNull(r1, "Parameters");
        HttpHost r2 = (HttpHost) r1.getParameter(ConnRoutePNames.DEFAULT_PROXY);
        if (r2 != null) goto L5;
        return r2;
    L5:
        if (NO_HOST.equals(r2) == false) goto L9;
        return null;
    L9:
        return r2;
    }

    public static void setDefaultProxy(HttpParams r1, HttpHost r2) {
        Args.notNull(r1, "Parameters");
        r1.setParameter(ConnRoutePNames.DEFAULT_PROXY, r2);
    }

    public static HttpRoute getForcedRoute(HttpParams r1) {
        Args.notNull(r1, "Parameters");
        HttpRoute r2 = (HttpRoute) r1.getParameter(ConnRoutePNames.FORCED_ROUTE);
        if (r2 != null) goto L5;
        return r2;
    L5:
        if (NO_ROUTE.equals(r2) == false) goto L9;
        return null;
    L9:
        return r2;
    }

    public static void setForcedRoute(HttpParams r1, HttpRoute r2) {
        Args.notNull(r1, "Parameters");
        r1.setParameter(ConnRoutePNames.FORCED_ROUTE, r2);
    }

    public static InetAddress getLocalAddress(HttpParams r1) {
        Args.notNull(r1, "Parameters");
        return (InetAddress) r1.getParameter(ConnRoutePNames.LOCAL_ADDRESS);
    }

    public static void setLocalAddress(HttpParams r1, InetAddress r2) {
        Args.notNull(r1, "Parameters");
        r1.setParameter(ConnRoutePNames.LOCAL_ADDRESS, r2);
    }
}
