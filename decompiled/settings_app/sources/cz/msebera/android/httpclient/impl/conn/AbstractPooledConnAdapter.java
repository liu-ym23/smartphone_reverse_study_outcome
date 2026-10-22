package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.conn.OperatedClientConnection;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public abstract class AbstractPooledConnAdapter extends AbstractClientConnAdapter {
    protected volatile AbstractPoolEntry poolEntry;

    @Override // cz.msebera.android.httpclient.conn.ManagedHttpClientConnection
    public String getId() {
        return null;
    }

    protected AbstractPooledConnAdapter(ClientConnectionManager r2, AbstractPoolEntry r3) {
        super(r2, r3.connection);
        this.poolEntry = r3;
    }

    @Deprecated
    protected AbstractPoolEntry getPoolEntry() {
        return this.poolEntry;
    }

    protected void assertValid(AbstractPoolEntry r1) {
        if (isReleased() == true) goto L7;
        if (r1 == null) goto L7;
        return;
    L7:
        throw new ConnectionShutdownException();
    }

    @Deprecated
    protected final void assertAttached() {
        if (this.poolEntry == null) goto L6;
        return;
    L6:
        throw new ConnectionShutdownException();
    }

    @Override // cz.msebera.android.httpclient.impl.conn.AbstractClientConnAdapter
    protected synchronized void detach() {
        monitor-enter(this);
        this.poolEntry = null;     // Catch: Throwable -> L7
        super.detach();     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedClientConnection, cz.msebera.android.httpclient.conn.HttpRoutedConnection
    public HttpRoute getRoute() {
        AbstractPoolEntry r0 = getPoolEntry();
        assertValid(r0);
        if (r0.tracker != null) goto L6;
        return null;
    L6:
        return r0.tracker.toRoute();
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedClientConnection
    public void open(HttpRoute r2, HttpContext r3, HttpParams r4) throws IOException {
        AbstractPoolEntry r0 = getPoolEntry();
        assertValid(r0);
        r0.open(r2, r3, r4);
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedClientConnection
    public void tunnelTarget(boolean r2, HttpParams r3) throws IOException {
        AbstractPoolEntry r0 = getPoolEntry();
        assertValid(r0);
        r0.tunnelTarget(r2, r3);
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedClientConnection
    public void tunnelProxy(HttpHost r2, boolean r3, HttpParams r4) throws IOException {
        AbstractPoolEntry r0 = getPoolEntry();
        assertValid(r0);
        r0.tunnelProxy(r2, r3, r4);
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedClientConnection
    public void layerProtocol(HttpContext r2, HttpParams r3) throws IOException {
        AbstractPoolEntry r0 = getPoolEntry();
        assertValid(r0);
        r0.layerProtocol(r2, r3);
    }

    @Override // cz.msebera.android.httpclient.HttpConnection, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        AbstractPoolEntry r0 = getPoolEntry();
        if (r0 == null) goto L5;
        r0.shutdownEntry();
    L5:
        OperatedClientConnection r1 = getWrappedConnection();
        if (r1 == null) goto L9;
        r1.close();
        return;
    }

    @Override // cz.msebera.android.httpclient.HttpConnection
    public void shutdown() throws IOException {
        AbstractPoolEntry r0 = getPoolEntry();
        if (r0 == null) goto L5;
        r0.shutdownEntry();
    L5:
        OperatedClientConnection r1 = getWrappedConnection();
        if (r1 == null) goto L9;
        r1.shutdown();
        return;
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedClientConnection
    public Object getState() {
        AbstractPoolEntry r0 = getPoolEntry();
        assertValid(r0);
        return r0.getState();
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedClientConnection
    public void setState(Object r2) {
        AbstractPoolEntry r0 = getPoolEntry();
        assertValid(r0);
        r0.setState(r2);
    }
}
