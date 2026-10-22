package cz.msebera.android.httpclient.conn.params;

import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.util.Args;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public final class ConnPerRouteBean implements ConnPerRoute {
    public static final int DEFAULT_MAX_CONNECTIONS_PER_ROUTE = 2;
    private volatile int defaultMax;
    private final ConcurrentHashMap<HttpRoute, Integer> maxPerHostMap;

    public ConnPerRouteBean(int r2) {
        this.maxPerHostMap = new ConcurrentHashMap();
        setDefaultMaxPerRoute(r2);
    }

    public ConnPerRouteBean() {
        this(2);
    }

    public int getDefaultMax() {
        return this.defaultMax;
    }

    public int getDefaultMaxPerRoute() {
        return this.defaultMax;
    }

    public void setDefaultMaxPerRoute(int r2) {
        Args.positive(r2, "Default max per route");
        this.defaultMax = r2;
    }

    public void setMaxForRoute(HttpRoute r2, int r3) {
        Args.notNull(r2, "HTTP route");
        Args.positive(r3, "Max per route");
        this.maxPerHostMap.put(r2, Integer.valueOf(r3));
    }

    @Override // cz.msebera.android.httpclient.conn.params.ConnPerRoute
    public int getMaxForRoute(HttpRoute r2) {
        Args.notNull(r2, "HTTP route");
        Integer r3 = this.maxPerHostMap.get(r2);
        if (r3 == null) goto L7;
        return r3.intValue();
    L7:
        return this.defaultMax;
    }

    public void setMaxForRoutes(Map<HttpRoute, Integer> r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.maxPerHostMap.clear();
        this.maxPerHostMap.putAll(r2);
    }

    public String toString() {
        return this.maxPerHostMap.toString();
    }
}
