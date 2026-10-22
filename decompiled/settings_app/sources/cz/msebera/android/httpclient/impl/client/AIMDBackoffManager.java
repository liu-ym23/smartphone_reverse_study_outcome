package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.client.BackoffManager;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.pool.ConnPoolControl;
import cz.msebera.android.httpclient.util.Args;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class AIMDBackoffManager implements BackoffManager {
    private double backoffFactor;
    private int cap;
    private final Clock clock;
    private final ConnPoolControl<HttpRoute> connPerRoute;
    private long coolDown;
    private final Map<HttpRoute, Long> lastRouteBackoffs;
    private final Map<HttpRoute, Long> lastRouteProbes;

    public AIMDBackoffManager(ConnPoolControl<HttpRoute> r2) {
        this(r2, new SystemClock());
    }

    AIMDBackoffManager(ConnPoolControl<HttpRoute> r3, Clock r4) {
        this.coolDown = 5000;
        this.backoffFactor = 0.5d;
        this.cap = 2;
        this.clock = r4;
        this.connPerRoute = r3;
        this.lastRouteProbes = new HashMap();
        this.lastRouteBackoffs = new HashMap();
    }

    @Override // cz.msebera.android.httpclient.client.BackoffManager
    public void backOff(HttpRoute r10) {
        ConnPoolControl<HttpRoute> r0 = this.connPerRoute;
        monitor-enter(r0);
        int r1 = this.connPerRoute.getMaxPerRoute(r10);     // Catch: Throwable -> L11
        Long r2 = getLastUpdate(this.lastRouteBackoffs, r10);     // Catch: Throwable -> L11
        long r3 = this.clock.getCurrentTime();     // Catch: Throwable -> L11
        if ((r3 - r2.longValue()) >= this.coolDown) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        this.connPerRoute.setMaxPerRoute(r10, getBackedOffPoolSize(r1));     // Catch: Throwable -> L11
        this.lastRouteBackoffs.put(r10, Long.valueOf(r3));     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private int getBackedOffPoolSize(int r3) {
        if (r3 > 1) goto L6;
        return 1;
    L6:
        return (int) Math.floor(this.backoffFactor * ((double) r3));
    }

    @Override // cz.msebera.android.httpclient.client.BackoffManager
    public void probe(HttpRoute r11) {
        ConnPoolControl<HttpRoute> r0 = this.connPerRoute;
        monitor-enter(r0);
        int r1 = this.connPerRoute.getMaxPerRoute(r11);     // Catch: Throwable -> L18
        int r2 = this.cap;     // Catch: Throwable -> L18
        if (r1 >= r2) goto L8;
        r2 = r1 + 1;     // Catch: Throwable -> L18
    L8:
        Long r3 = getLastUpdate(this.lastRouteProbes, r11);     // Catch: Throwable -> L18
        Long r4 = getLastUpdate(this.lastRouteBackoffs, r11);     // Catch: Throwable -> L18
        long r5 = this.clock.getCurrentTime();     // Catch: Throwable -> L18
        if ((r5 - r3.longValue()) >= this.coolDown) goto L11;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L11:
        if ((r5 - r4.longValue()) < this.coolDown) goto L16;
        this.connPerRoute.setMaxPerRoute(r11, r2);     // Catch: Throwable -> L18
        this.lastRouteProbes.put(r11, Long.valueOf(r5));     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    }

    private Long getLastUpdate(Map<HttpRoute, Long> r1, HttpRoute r2) {
        Long r0 = r1.get(r2);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return 0L;
    }

    public void setBackoffFactor(double r3) {
        if (r3 > 0.0d) goto L5;
    L7:
        boolean r0 = false;
    L8:
        Args.check(r0, "Backoff factor must be 0.0 < f < 1.0");
        this.backoffFactor = r3;
        return;
    L5:
        if (r3 >= 1.0d) goto L7;
        r0 = true;
        goto L8
    }

    public void setCooldownMillis(long r4) {
        Args.positive(this.coolDown, "Cool down");
        this.coolDown = r4;
    }

    public void setPerHostConnectionCap(int r2) {
        Args.positive(r2, "Per host connection cap");
        this.cap = r2;
    }
}
