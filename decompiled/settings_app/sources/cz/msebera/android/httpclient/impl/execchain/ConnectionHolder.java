package cz.msebera.android.httpclient.impl.execchain;

import cz.msebera.android.httpclient.HttpClientConnection;
import cz.msebera.android.httpclient.concurrent.Cancellable;
import cz.msebera.android.httpclient.conn.ConnectionReleaseTrigger;
import cz.msebera.android.httpclient.conn.HttpClientConnectionManager;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes5.dex */
class ConnectionHolder implements ConnectionReleaseTrigger, Cancellable, Closeable {
    private final HttpClientAndroidLog log;
    private final HttpClientConnection managedConn;
    private final HttpClientConnectionManager manager;
    private final AtomicBoolean released;
    private volatile boolean reusable;
    private volatile Object state;
    private volatile TimeUnit timeUnit;
    private volatile long validDuration;

    public ConnectionHolder(HttpClientAndroidLog r1, HttpClientConnectionManager r2, HttpClientConnection r3) {
        this.log = r1;
        this.manager = r2;
        this.managedConn = r3;
        this.released = new AtomicBoolean(false);
    }

    public boolean isReusable() {
        return this.reusable;
    }

    public void markReusable() {
        this.reusable = true;
    }

    public void markNonReusable() {
        this.reusable = false;
    }

    public void setState(Object r1) {
        this.state = r1;
    }

    public void setValidFor(long r2, TimeUnit r4) {
        HttpClientConnection r0 = this.managedConn;
        monitor-enter(r0);
        this.validDuration = r2;     // Catch: Throwable -> L7
        this.timeUnit = r4;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void releaseConnection(boolean r9) {
        if (this.released.compareAndSet(false, true) == false) goto L27;
        HttpClientConnection r0 = this.managedConn;
        monitor-enter(r0);
        if (r9 == false) goto L28;
        this.manager.releaseConnection(this.managedConn, this.state, this.validDuration, this.timeUnit);     // Catch: Throwable -> L9
    L21:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L28:
        this.managedConn.close();     // Catch: Throwable -> L14 IOException -> L16
        this.log.debug("Connection discarded");     // Catch: Throwable -> L14 IOException -> L16
        this.manager.releaseConnection(this.managedConn, null, 0, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L9
        goto L21
    L16:
        e = move-exception;
        if (this.log.isDebugEnabled() == false) goto L20;
        this.log.debug(e.getMessage(), e);     // Catch: Throwable -> L14
    L20:
        this.manager.releaseConnection(this.managedConn, null, 0, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L9
    L14:
        th = move-exception;
        this.manager.releaseConnection(this.managedConn, null, 0, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L9
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    @Override // cz.msebera.android.httpclient.conn.ConnectionReleaseTrigger
    public void releaseConnection() {
        releaseConnection(this.reusable);
    }

    @Override // cz.msebera.android.httpclient.conn.ConnectionReleaseTrigger
    public void abortConnection() {
        if (this.released.compareAndSet(false, true) == false) goto L23;
        HttpClientConnection r0 = this.managedConn;
        monitor-enter(r0);
        this.managedConn.shutdown();     // Catch: Throwable -> L9 IOException -> L11
        this.log.debug("Connection discarded");     // Catch: Throwable -> L9 IOException -> L11
        this.manager.releaseConnection(this.managedConn, null, 0, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L20
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L20
        return;
    L11:
        e = move-exception;
        if (this.log.isDebugEnabled() == false) goto L15;
        this.log.debug(e.getMessage(), e);     // Catch: Throwable -> L9
    L15:
        this.manager.releaseConnection(this.managedConn, null, 0, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L20
    L9:
        th = move-exception;
        this.manager.releaseConnection(this.managedConn, null, 0, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    @Override // cz.msebera.android.httpclient.concurrent.Cancellable
    public boolean cancel() {
        boolean r0 = this.released.get();
        this.log.debug("Cancelling request execution");
        abortConnection();
        return !r0;
    }

    public boolean isReleased() {
        return this.released.get();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        releaseConnection(false);
    }
}
