package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.conn.ClientConnectionOperator;
import cz.msebera.android.httpclient.conn.ClientConnectionRequest;
import cz.msebera.android.httpclient.conn.ManagedClientConnection;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.conn.routing.RouteTracker;
import cz.msebera.android.httpclient.conn.scheme.SchemeRegistry;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class SingleClientConnManager implements ClientConnectionManager {
    public static final String MISUSE_MESSAGE = "Invalid use of SingleClientConnManager: connection still allocated.\nMake sure to release the connection before allocating another one.";
    protected final boolean alwaysShutDown;
    protected final ClientConnectionOperator connOperator;
    protected volatile long connectionExpiresTime;
    protected volatile boolean isShutDown;
    protected volatile long lastReleaseTime;
    public HttpClientAndroidLog log;
    protected volatile ConnAdapter managedConn;
    protected final SchemeRegistry schemeRegistry;
    protected volatile PoolEntry uniquePoolEntry;

    protected class ConnAdapter extends AbstractPooledConnAdapter {
        final /* synthetic */ SingleClientConnManager this$0;

        protected ConnAdapter(SingleClientConnManager r1, PoolEntry r2, HttpRoute r3) {
            this.this$0 = r1;
            super(r1, r2);
            markReusable();
            r2.route = r3;
        }
    }

    protected class PoolEntry extends AbstractPoolEntry {
        final /* synthetic */ SingleClientConnManager this$0;

        protected PoolEntry(SingleClientConnManager r2) {
            this.this$0 = r2;
            super(r2.connOperator, null);
        }

        protected void close() throws IOException {
            shutdownEntry();
            if (this.connection.isOpen() == false) goto L6;
            this.connection.close();
            return;
        }

        protected void shutdown() throws IOException {
            shutdownEntry();
            if (this.connection.isOpen() == false) goto L6;
            this.connection.shutdown();
            return;
        }
    }

    @Deprecated
    public SingleClientConnManager(HttpParams r1, SchemeRegistry r2) {
        this(r2);
    }

    public SingleClientConnManager(SchemeRegistry r3) {
        this.log = new HttpClientAndroidLog(getClass());
        Args.notNull(r3, "Scheme registry");
        this.schemeRegistry = r3;
        this.connOperator = createConnectionOperator(r3);
        this.uniquePoolEntry = new PoolEntry(this);
        this.managedConn = null;
        this.lastReleaseTime = -1;
        this.alwaysShutDown = false;
        this.isShutDown = false;
    }

    public SingleClientConnManager() {
        this(SchemeRegistryFactory.createDefault());
    }

    protected void finalize() throws Throwable {
        shutdown();     // Catch: Throwable -> L5
        super.finalize();
        return;
    L5:
        th = move-exception;
        super.finalize();
        throw th;
    }

    @Override // cz.msebera.android.httpclient.conn.ClientConnectionManager
    public SchemeRegistry getSchemeRegistry() {
        return this.schemeRegistry;
    }

    protected ClientConnectionOperator createConnectionOperator(SchemeRegistry r1) {
        return new DefaultClientConnectionOperator(r1);
    }

    protected final void assertStillUp() throws IllegalStateException {
        Asserts.check(!this.isShutDown, "Manager is shut down");
    }

    @Override // cz.msebera.android.httpclient.conn.ClientConnectionManager
    public final ClientConnectionRequest requestConnection(final HttpRoute r2, final Object r3) {
        return new AnonymousClass1(this, r2, r3);
    }

    public ManagedClientConnection getConnection(HttpRoute r5, Object r6) {
        Args.notNull(r5, "Route");
        assertStillUp();
        if (this.log.isDebugEnabled() == false) goto L5;
        this.log.debug("Get connection for route " + r5);
    L5:
        monitor-enter(this);
        boolean r0 = true;
        boolean r1 = false;
        if (this.managedConn != null) goto L9;
        boolean r7 = true;
    L10:
        Asserts.check(r7, MISUSE_MESSAGE);     // Catch: Throwable -> L32
        closeExpiredConnections();     // Catch: Throwable -> L32
        if (this.uniquePoolEntry.connection.isOpen() == false) goto L20;
        RouteTracker r8 = this.uniquePoolEntry.tracker;     // Catch: Throwable -> L32
        if (r8 != null) goto L15;
    L18:
        boolean r9 = true;
    L19:
        r1 = r9;
        boolean r10 = false;
    L21:
        if (r1 == true) goto L37;
        r0 = r10;
    L27:
        if (r0 == false) goto L29;
        this.uniquePoolEntry = new PoolEntry(this);     // Catch: Throwable -> L32
    L29:
        this.managedConn = new ConnAdapter(this, this.uniquePoolEntry, r5);     // Catch: Throwable -> L32
        ConnAdapter r11 = this.managedConn;     // Catch: Throwable -> L32
        monitor-exit(this);     // Catch: Throwable -> L32
        return r11;
    L37:
        this.uniquePoolEntry.shutdown();     // Catch: IOException -> L24 Throwable -> L32
    L24:
        e = move-exception;
        this.log.debug("Problem shutting down connection.", e);     // Catch: Throwable -> L32
        goto L27
    L15:
        if (r8.toRoute().equals(r5) == false) goto L18;
        r9 = false;
        goto L19
    L20:
        r10 = true;
        goto L21
    L9:
        r7 = false;
    L32:
        th = move-exception;
        throw th;
    }

    @Override // cz.msebera.android.httpclient.conn.ClientConnectionManager
    public void releaseConnection(ManagedClientConnection r9, long r10, TimeUnit r12) {
        Args.check(r9 instanceof ConnAdapter, "Connection class mismatch, connection not obtained from this manager");
        assertStillUp();
        if (this.log.isDebugEnabled() == false) goto L5;
        this.log.debug("Releasing connection " + r9);
    L5:
        ConnAdapter r11 = (ConnAdapter) r9;
        monitor-enter(r11);
    L67:
        th = move-exception;
        throw th;
    L8:
        if (r11.poolEntry != null) goto L12;
        monitor-exit(r11);     // Catch: Throwable -> L67
        return;
    L12:
        if (r11.getManager() != this) goto L14;
        boolean r0 = true;
    L15:
        Asserts.check(r0, "Connection not obtained from this manager");     // Catch: Throwable -> L67
    L40:
        e = move-exception;
        if (this.log.isDebugEnabled() == false) goto L44;
        this.log.debug("Exception shutting down released connection.", e);     // Catch: Throwable -> L38
    L44:
        r11.detach();     // Catch: Throwable -> L67
        monitor-enter(this);     // Catch: Throwable -> L67
        this.managedConn = null;     // Catch: Throwable -> L53
        this.lastReleaseTime = System.currentTimeMillis();     // Catch: Throwable -> L53
        if (r10 <= 0) goto L49;
        this.connectionExpiresTime = r12.toMillis(r10) + this.lastReleaseTime;     // Catch: Throwable -> L53
    L50:
    L51:
        monitor-exit(r11);     // Catch: Throwable -> L67
        return;
    L49:
        this.connectionExpiresTime = Long.MAX_VALUE;     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        throw th;     // Catch: Throwable -> L67
    L38:
        th = move-exception;
        r11.detach();     // Catch: Throwable -> L67
        monitor-enter(this);     // Catch: Throwable -> L67
        this.managedConn = null;     // Catch: Throwable -> L64
        this.lastReleaseTime = System.currentTimeMillis();     // Catch: Throwable -> L64
        if (r10 <= 0) goto L61;
        this.connectionExpiresTime = r12.toMillis(r10) + this.lastReleaseTime;     // Catch: Throwable -> L64
    L62:
        throw th;     // Catch: Throwable -> L67
    L61:
        this.connectionExpiresTime = Long.MAX_VALUE;     // Catch: Throwable -> L64
    L64:
        th = move-exception;
        throw th;     // Catch: Throwable -> L67
    L18:
        if (r11.isOpen() == true) goto L20;
    L27:
        r11.detach();     // Catch: Throwable -> L67
        monitor-enter(this);     // Catch: Throwable -> L67
        this.managedConn = null;     // Catch: Throwable -> L35
        this.lastReleaseTime = System.currentTimeMillis();     // Catch: Throwable -> L35
        if (r10 <= 0) goto L32;
        this.connectionExpiresTime = r12.toMillis(r10) + this.lastReleaseTime;     // Catch: Throwable -> L35
    L33:
        monitor-exit(this);     // Catch: Throwable -> L35
    L32:
        this.connectionExpiresTime = Long.MAX_VALUE;     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        throw th;     // Catch: Throwable -> L67
    L20:
        if (this.alwaysShutDown == true) goto L24;
        if (r11.isMarkedReusable() == true) goto L27;
    L24:
        if (this.log.isDebugEnabled() == false) goto L26;
        this.log.debug("Released connection open but not reusable.");     // Catch: Throwable -> L38 IOException -> L40
    L26:
        r11.shutdown();     // Catch: Throwable -> L38 IOException -> L40
    L14:
        r0 = false;
        goto L15
    }

    @Override // cz.msebera.android.httpclient.conn.ClientConnectionManager
    public void closeExpiredConnections() {
        long r0 = this.connectionExpiresTime;
        if (System.currentTimeMillis() < r0) goto L6;
        closeIdleConnections(0, TimeUnit.MILLISECONDS);
        return;
    }

    @Override // cz.msebera.android.httpclient.conn.ClientConnectionManager
    public void closeIdleConnections(long r3, TimeUnit r5) {
        assertStillUp();
        Args.notNull(r5, "Time unit");
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (this.managedConn == null) goto L7;
    L15:
        monitor-exit(this);     // Catch: Throwable -> L17
        return;
    L7:
        if (this.uniquePoolEntry.connection.isOpen() == false) goto L15;
        long r0 = System.currentTimeMillis() - r5.toMillis(r3);     // Catch: Throwable -> L17
        if (this.lastReleaseTime > r0) goto L15;
        this.uniquePoolEntry.close();     // Catch: IOException -> L13 Throwable -> L17
    L13:
        e = move-exception;
        this.log.debug("Problem closing idle connection.", e);     // Catch: Throwable -> L17
        goto L15
    }

    @Override // cz.msebera.android.httpclient.conn.ClientConnectionManager
    public void shutdown() {
        this.isShutDown = true;
        monitor-enter(this);
    L11:
        th = move-exception;
        this.uniquePoolEntry = null;     // Catch: Throwable -> L20
        this.managedConn = null;     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    L13:
        e = move-exception;
        this.log.debug("Problem while shutting down manager.", e);     // Catch: Throwable -> L11
        this.uniquePoolEntry = null;     // Catch: Throwable -> L20
    L9:
        this.managedConn = null;     // Catch: Throwable -> L20
        monitor-exit(this);     // Catch: Throwable -> L20
        return;
    L6:
        if (this.uniquePoolEntry == null) goto L8;
        this.uniquePoolEntry.shutdown();     // Catch: Throwable -> L11 IOException -> L13
    L8:
        this.uniquePoolEntry = null;     // Catch: Throwable -> L20
        goto L9
    }

    protected void revokeConnection() {
        ConnAdapter r0 = this.managedConn;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.detach();
        monitor-enter(this);
        this.uniquePoolEntry.shutdown();     // Catch: Throwable -> L9 IOException -> L11
    L13:
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L11:
        e = move-exception;
        this.log.debug("Problem while shutting down connection.", e);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }
}
