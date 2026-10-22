package cz.msebera.android.httpclient.impl.conn;

import com.android.settings.utils.HanziToPinyin;
import cz.msebera.android.httpclient.HttpClientConnection;
import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.conn.ClientConnectionOperator;
import cz.msebera.android.httpclient.conn.ClientConnectionRequest;
import cz.msebera.android.httpclient.conn.ManagedClientConnection;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.conn.scheme.SchemeRegistry;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class BasicClientConnectionManager implements ClientConnectionManager {
    private static final AtomicLong COUNTER = null;
    public static final String MISUSE_MESSAGE = "Invalid use of BasicClientConnManager: connection still allocated.\nMake sure to release the connection before allocating another one.";
    private ManagedClientConnectionImpl conn;
    private final ClientConnectionOperator connOperator;
    public HttpClientAndroidLog log;
    private HttpPoolEntry poolEntry;
    private final SchemeRegistry schemeRegistry;
    private volatile boolean shutdown;

    static {
        COUNTER = new AtomicLong();
    }

    public BasicClientConnectionManager(SchemeRegistry r3) {
        this.log = new HttpClientAndroidLog(getClass());
        Args.notNull(r3, "Scheme registry");
        this.schemeRegistry = r3;
        this.connOperator = createConnectionOperator(r3);
    }

    public BasicClientConnectionManager() {
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

    @Override // cz.msebera.android.httpclient.conn.ClientConnectionManager
    public final ClientConnectionRequest requestConnection(final HttpRoute r2, final Object r3) {
        return new AnonymousClass1(this, r2, r3);
    }

    private void assertNotShutdown() {
        Asserts.check(!this.shutdown, "Connection manager has been shut down");
    }

    ManagedClientConnection getConnection(HttpRoute r11, Object r12) {
        Args.notNull(r11, "Route");
        monitor-enter(this);
        assertNotShutdown();     // Catch: Throwable -> L25
        if (this.log.isDebugEnabled() == false) goto L8;
        this.log.debug("Get connection for route " + r11);     // Catch: Throwable -> L25
    L8:
        if (this.conn != null) goto L10;
        boolean r13 = true;
    L11:
        Asserts.check(r13, MISUSE_MESSAGE);     // Catch: Throwable -> L25
        HttpPoolEntry r14 = this.poolEntry;     // Catch: Throwable -> L25
        if (r14 == null) goto L17;
        if (r14.getPlannedRoute().equals(r11) == true) goto L17;
        this.poolEntry.close();     // Catch: Throwable -> L25
        this.poolEntry = null;     // Catch: Throwable -> L25
    L17:
        if (this.poolEntry != null) goto L20;
        this.poolEntry = new HttpPoolEntry(this.log, Long.toString(COUNTER.getAndIncrement()), r11, this.connOperator.createConnection(), 0, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L25
    L20:
        if (this.poolEntry.isExpired(System.currentTimeMillis()) == false) goto L22;
        this.poolEntry.close();     // Catch: Throwable -> L25
        this.poolEntry.getTracker().reset();     // Catch: Throwable -> L25
    L22:
        ManagedClientConnectionImpl r15 = new ManagedClientConnectionImpl(this, this.connOperator, this.poolEntry);     // Catch: Throwable -> L25
        this.conn = r15;     // Catch: Throwable -> L25
        monitor-exit(this);     // Catch: Throwable -> L25
        return r15;
    L10:
        r13 = false;
    L25:
        th = move-exception;
        throw th;
    }

    private void shutdownConnection(HttpClientConnection r2) {
        r2.shutdown();     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        if (this.log.isDebugEnabled() == false) goto L11;
        this.log.debug("I/O exception shutting down connection", e);
        return;
    }

    @Override // cz.msebera.android.httpclient.conn.ClientConnectionManager
    public void releaseConnection(ManagedClientConnection r7, long r8, TimeUnit r10) {
        Args.check(r7 instanceof ManagedClientConnectionImpl, "Connection class mismatch, connection not obtained from this manager");
        ManagedClientConnectionImpl r3 = (ManagedClientConnectionImpl) r7;
        monitor-enter(r3);
    L56:
        th = move-exception;
        throw th;
    L5:
        if (this.log.isDebugEnabled() == false) goto L8;
        this.log.debug("Releasing connection " + r7);     // Catch: Throwable -> L56
    L8:
        if (r3.getPoolEntry() != null) goto L12;
        monitor-exit(r3);     // Catch: Throwable -> L56
        return;
    L12:
        if (r3.getManager() != this) goto L14;
        boolean r9 = true;
    L15:
        Asserts.check(r9, "Connection not obtained from this manager");     // Catch: Throwable -> L56
        monitor-enter(this);     // Catch: Throwable -> L56
    L53:
        th = move-exception;
        throw th;     // Catch: Throwable -> L56
    L18:
        if (this.shutdown == false) goto L59;
        shutdownConnection(r3);     // Catch: Throwable -> L53
        monitor-exit(this);     // Catch: Throwable -> L53
        monitor-exit(r3);     // Catch: Throwable -> L56
        return;
    L59:
    L48:
        th = move-exception;
        r3.detach();     // Catch: Throwable -> L53
        this.conn = null;     // Catch: Throwable -> L53
        if (this.poolEntry.isClosed() == false) goto L52;
        this.poolEntry = null;     // Catch: Throwable -> L53
    L52:
        throw th;     // Catch: Throwable -> L53
    L25:
        if (r3.isOpen() == false) goto L30;
        if (r3.isMarkedReusable() == true) goto L30;
        shutdownConnection(r3);     // Catch: Throwable -> L48
    L30:
        if (r3.isMarkedReusable() == false) goto L42;
        HttpPoolEntry r2 = this.poolEntry;     // Catch: Throwable -> L48
        if (r10 == null) goto L34;
        TimeUnit r4 = r10;
    L35:
        r2.updateExpiry(r8, r4);     // Catch: Throwable -> L48
        if (this.log.isDebugEnabled() == false) goto L42;
        if (r8 <= 0) goto L40;
        String r11 = "for " + r8 + HanziToPinyin.Token.SEPARATOR + r10;     // Catch: Throwable -> L48
    L41:
        this.log.debug("Connection can be kept alive " + r11);     // Catch: Throwable -> L48
    L40:
        r11 = "indefinitely";
        goto L41
    L34:
        r4 = TimeUnit.MILLISECONDS;     // Catch: Throwable -> L48
    L42:
        r3.detach();     // Catch: Throwable -> L53
        this.conn = null;     // Catch: Throwable -> L53
        if (this.poolEntry.isClosed() == false) goto L45;
        this.poolEntry = null;     // Catch: Throwable -> L53
    L45:
        monitor-exit(this);     // Catch: Throwable -> L53
        monitor-exit(r3);     // Catch: Throwable -> L56
        return;
    L14:
        r9 = false;
        goto L15
    }

    @Override // cz.msebera.android.httpclient.conn.ClientConnectionManager
    public void closeExpiredConnections() {
        monitor-enter(this);
        assertNotShutdown();     // Catch: Throwable -> L10
        long r0 = System.currentTimeMillis();     // Catch: Throwable -> L10
        HttpPoolEntry r2 = this.poolEntry;     // Catch: Throwable -> L10
        if (r2 != null) goto L6;
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L6:
        if (r2.isExpired(r0) == false) goto L8;
        this.poolEntry.close();     // Catch: Throwable -> L10
        this.poolEntry.getTracker().reset();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    @Override // cz.msebera.android.httpclient.conn.ClientConnectionManager
    public void closeIdleConnections(long r3, TimeUnit r5) {
        Args.notNull(r5, "Time unit");
        monitor-enter(this);
        assertNotShutdown();     // Catch: Throwable -> L14
        long r4 = r5.toMillis(r3);     // Catch: Throwable -> L14
        if (r4 >= 0) goto L7;
        r4 = 0;
    L7:
        long r0 = System.currentTimeMillis() - r4;     // Catch: Throwable -> L14
        HttpPoolEntry r6 = this.poolEntry;     // Catch: Throwable -> L14
        if (r6 != null) goto L10;
    L12:
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    L10:
        if (r6.getUpdated() > r0) goto L12;
        this.poolEntry.close();     // Catch: Throwable -> L14
        this.poolEntry.getTracker().reset();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    @Override // cz.msebera.android.httpclient.conn.ClientConnectionManager
    public void shutdown() {
        monitor-enter(this);
        this.shutdown = true;     // Catch: Throwable -> L15
        HttpPoolEntry r1 = this.poolEntry;     // Catch: Throwable -> L12
        if (r1 == null) goto L9;
        r1.close();     // Catch: Throwable -> L12
    L9:
        this.poolEntry = null;     // Catch: Throwable -> L15
        this.conn = null;     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
        return;
    L12:
        th = move-exception;
        this.poolEntry = null;     // Catch: Throwable -> L15
        this.conn = null;     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }
}
