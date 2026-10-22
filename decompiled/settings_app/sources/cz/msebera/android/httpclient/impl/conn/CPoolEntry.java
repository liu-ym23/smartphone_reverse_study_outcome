package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.conn.ManagedHttpClientConnection;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.pool.PoolEntry;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
class CPoolEntry extends PoolEntry<HttpRoute, ManagedHttpClientConnection> {
    private final HttpClientAndroidLog log;
    private volatile boolean routeComplete;

    public CPoolEntry(HttpClientAndroidLog r8, String r9, HttpRoute r10, ManagedHttpClientConnection r11, long r12, TimeUnit r14) {
        super(r9, r10, r11, r12, r14);
        this.log = r8;
    }

    public void markRouteComplete() {
        this.routeComplete = true;
    }

    public boolean isRouteComplete() {
        return this.routeComplete;
    }

    public void closeConnection() throws IOException {
        getConnection().close();
    }

    public void shutdownConnection() throws IOException {
        getConnection().shutdown();
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

    @Override // cz.msebera.android.httpclient.pool.PoolEntry
    public boolean isClosed() {
        return !getConnection().isOpen();
    }

    @Override // cz.msebera.android.httpclient.pool.PoolEntry
    public void close() {
        closeConnection();     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        this.log.debug("I/O error closing connection", e);
    }
}
