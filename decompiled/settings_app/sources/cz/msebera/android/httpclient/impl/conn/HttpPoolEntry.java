package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.conn.OperatedClientConnection;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.conn.routing.RouteTracker;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.pool.PoolEntry;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
class HttpPoolEntry extends PoolEntry<HttpRoute, OperatedClientConnection> {
    private final HttpClientAndroidLog log;
    private final RouteTracker tracker;

    public HttpPoolEntry(HttpClientAndroidLog r8, String r9, HttpRoute r10, OperatedClientConnection r11, long r12, TimeUnit r14) {
        super(r9, r10, r11, r12, r14);
        this.log = r8;
        this.tracker = new RouteTracker(r10);
    }

    @Override // cz.msebera.android.httpclient.pool.PoolEntry
    public boolean isExpired(long r5) {
        boolean r6 = super.isExpired(r5);
        if (r6 == true) goto L5;
    L7:
        return r6;
    L5:
        if (this.log.isDebugEnabled() == false) goto L7;
        this.log.debug("Connection " + this + " expired @ " + new Date(getExpiry()));
        goto L7
    }

    RouteTracker getTracker() {
        return this.tracker;
    }

    HttpRoute getPlannedRoute() {
        return getRoute();
    }

    HttpRoute getEffectiveRoute() {
        return this.tracker.toRoute();
    }

    @Override // cz.msebera.android.httpclient.pool.PoolEntry
    public boolean isClosed() {
        return !getConnection().isOpen();
    }

    @Override // cz.msebera.android.httpclient.pool.PoolEntry
    public void close() {
        getConnection().close();     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        this.log.debug("I/O error closing connection", e);
    }
}
