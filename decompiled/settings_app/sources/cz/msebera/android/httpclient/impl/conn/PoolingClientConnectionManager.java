package cz.msebera.android.httpclient.impl.conn;

import com.android.settings.utils.HanziToPinyin;
import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.conn.ClientConnectionOperator;
import cz.msebera.android.httpclient.conn.ClientConnectionRequest;
import cz.msebera.android.httpclient.conn.ConnectionPoolTimeoutException;
import cz.msebera.android.httpclient.conn.DnsResolver;
import cz.msebera.android.httpclient.conn.ManagedClientConnection;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.conn.scheme.SchemeRegistry;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.pool.ConnPoolControl;
import cz.msebera.android.httpclient.pool.PoolStats;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class PoolingClientConnectionManager implements ClientConnectionManager, ConnPoolControl<HttpRoute> {
    private final DnsResolver dnsResolver;
    public HttpClientAndroidLog log;
    private final ClientConnectionOperator operator;
    private final HttpConnPool pool;
    private final SchemeRegistry schemeRegistry;

    @Override // cz.msebera.android.httpclient.pool.ConnPoolControl
    public /* bridge */ /* synthetic */ int getMaxPerRoute(HttpRoute r1) {
        return getMaxPerRoute2(r1);
    }

    @Override // cz.msebera.android.httpclient.pool.ConnPoolControl
    public /* bridge */ /* synthetic */ PoolStats getStats(HttpRoute r1) {
        return getStats2(r1);
    }

    @Override // cz.msebera.android.httpclient.pool.ConnPoolControl
    public /* bridge */ /* synthetic */ void setMaxPerRoute(HttpRoute r1, int r2) {
        setMaxPerRoute2(r1, r2);
    }

    public PoolingClientConnectionManager(SchemeRegistry r4) {
        this(r4, -1, TimeUnit.MILLISECONDS);
    }

    public PoolingClientConnectionManager(SchemeRegistry r7, DnsResolver r8) {
        this(r7, -1, TimeUnit.MILLISECONDS, r8);
    }

    public PoolingClientConnectionManager() {
        this(SchemeRegistryFactory.createDefault());
    }

    public PoolingClientConnectionManager(SchemeRegistry r7, long r8, TimeUnit r10) {
        this(r7, r8, r10, new SystemDefaultDnsResolver());
    }

    public PoolingClientConnectionManager(SchemeRegistry r10, long r11, TimeUnit r13, DnsResolver r14) {
        this.log = new HttpClientAndroidLog(getClass());
        Args.notNull(r10, "Scheme registry");
        Args.notNull(r14, "DNS resolver");
        this.schemeRegistry = r10;
        this.dnsResolver = r14;
        ClientConnectionOperator r3 = createConnectionOperator(r10);
        this.operator = r3;
        this.pool = new HttpConnPool(this.log, r3, 2, 20, r11, r13);
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

    protected ClientConnectionOperator createConnectionOperator(SchemeRegistry r2) {
        return new DefaultClientConnectionOperator(r2, this.dnsResolver);
    }

    @Override // cz.msebera.android.httpclient.conn.ClientConnectionManager
    public SchemeRegistry getSchemeRegistry() {
        return this.schemeRegistry;
    }

    private String format(HttpRoute r2, Object r3) {
        StringBuilder r1 = new StringBuilder("[route: ");
        r1.append(r2).append("]");
        if (r3 == null) goto L6;
        r1.append("[state: ").append(r3).append("]");
    L6:
        return r1.toString();
    }

    private String formatStats(HttpRoute r4) {
        StringBuilder r0 = new StringBuilder("[total kept alive: ");
        PoolStats r1 = this.pool.getTotalStats();
        PoolStats r3 = this.pool.getStats(r4);
        r0.append(r1.getAvailable()).append("; route allocated: ");
        r0.append(r3.getLeased() + r3.getAvailable());
        r0.append(" of ").append(r3.getMax()).append("; total allocated: ");
        r0.append(r1.getLeased() + r1.getAvailable());
        r0.append(" of ").append(r1.getMax()).append("]");
        return r0.toString();
    }

    private String format(HttpPoolEntry r3) {
        StringBuilder r2 = new StringBuilder("[id: ");
        r2.append(r3.getId()).append("][route: ");
        r2.append(r3.getRoute()).append("]");
        Object r4 = r3.getState();
        if (r4 == null) goto L6;
        r2.append("[state: ").append(r4).append("]");
    L6:
        return r2.toString();
    }

    @Override // cz.msebera.android.httpclient.conn.ClientConnectionManager
    public ClientConnectionRequest requestConnection(HttpRoute r4, Object r5) {
        Args.notNull(r4, "HTTP route");
        if (this.log.isDebugEnabled() == false) goto L5;
        this.log.debug("Connection request: " + format(r4, r5) + formatStats(r4));
    L5:
        final Future<HttpPoolEntry> r6 = this.pool.lease(r4, r5);
        return new AnonymousClass1(this, r6);
    }

    ManagedClientConnection leaseConnection(Future<HttpPoolEntry> r2, long r3, TimeUnit r5) throws InterruptedException, ConnectionPoolTimeoutException {
        HttpPoolEntry r4 = r2.get(r3, r5);     // Catch: TimeoutException -> L18 ExecutionException -> L20
        if (r4 == null) goto L17;
        if (r2.isCancelled() == true) goto L17;
        if (r4.getConnection() == null) goto L10;
        boolean r6 = true;
    L11:
        Asserts.check(r6, "Pool entry with no connection");     // Catch: TimeoutException -> L18 ExecutionException -> L20
        if (this.log.isDebugEnabled() == false) goto L15;
        this.log.debug("Connection leased: " + format(r4) + formatStats(r4.getRoute()));     // Catch: TimeoutException -> L18 ExecutionException -> L20
    L15:
        return new ManagedClientConnectionImpl(this, this.operator, r4);
    L10:
        r6 = false;
    L17:
        throw new InterruptedException();     // Catch: TimeoutException -> L18 ExecutionException -> L20
    L20:
        e = e;
        Throwable r7 = e.getCause();
        if (r7 == null) goto L25;
        e = r7;
    L25:
        this.log.error("Unexpected exception leasing connection from pool", e);
        throw new InterruptedException();
    L19:
        throw new ConnectionPoolTimeoutException("Timeout waiting for connection from pool");
    }

    @Override // cz.msebera.android.httpclient.conn.ClientConnectionManager
    public void releaseConnection(ManagedClientConnection r8, long r9, TimeUnit r11) {
        Args.check(r8 instanceof ManagedClientConnectionImpl, "Connection class mismatch, connection not obtained from this manager");
        ManagedClientConnectionImpl r10 = (ManagedClientConnectionImpl) r8;
        if (r10.getManager() != this) goto L5;
        boolean r3 = true;
    L6:
        Asserts.check(r3, "Connection not obtained from this manager");
        monitor-enter(r10);
        HttpPoolEntry r4 = r10.detach();     // Catch: Throwable -> L42
        if (r4 != null) goto L45;
        monitor-exit(r10);     // Catch: Throwable -> L42
        return;
    L45:
    L39:
        th = move-exception;
        this.pool.release(r4, r10.isMarkedReusable());     // Catch: Throwable -> L42
        throw th;     // Catch: Throwable -> L42
    L13:
        if (r10.isOpen() == false) goto L23;
        if (r10.isMarkedReusable() == true) goto L23;
        r10.shutdown();     // Catch: IOException -> L18 Throwable -> L39
    L18:
        e = move-exception;
        if (this.log.isDebugEnabled() == false) goto L23;
        this.log.debug("I/O exception shutting down released connection", e);     // Catch: Throwable -> L39
    L23:
        if (r10.isMarkedReusable() == false) goto L34;
        if (r11 == null) goto L26;
        TimeUnit r5 = r11;
    L27:
        r4.updateExpiry(r9, r5);     // Catch: Throwable -> L39
        if (this.log.isDebugEnabled() == false) goto L34;
        if (r9 <= 0) goto L32;
        String r12 = "for " + r9 + HanziToPinyin.Token.SEPARATOR + r11;     // Catch: Throwable -> L39
    L33:
        this.log.debug("Connection " + format(r4) + " can be kept alive " + r12);     // Catch: Throwable -> L39
    L32:
        r12 = "indefinitely";
        goto L33
    L26:
        r5 = TimeUnit.MILLISECONDS;     // Catch: Throwable -> L39
    L34:
        this.pool.release(r4, r10.isMarkedReusable());     // Catch: Throwable -> L42
        if (this.log.isDebugEnabled() == false) goto L37;
        this.log.debug("Connection released: " + format(r4) + formatStats(r4.getRoute()));     // Catch: Throwable -> L42
    L37:
        monitor-exit(r10);     // Catch: Throwable -> L42
        return;
    L42:
        th = move-exception;
        throw th;
    L5:
        r3 = false;
        goto L6
    }

    @Override // cz.msebera.android.httpclient.conn.ClientConnectionManager
    public void shutdown() {
        this.log.debug("Connection manager is shutting down");
        this.pool.shutdown();     // Catch: IOException -> L5
    L7:
        this.log.debug("Connection manager shut down");
        return;
    L5:
        e = move-exception;
        this.log.debug("I/O exception shutting down connection manager", e);
        goto L7
    }

    @Override // cz.msebera.android.httpclient.conn.ClientConnectionManager
    public void closeIdleConnections(long r4, TimeUnit r6) {
        if (this.log.isDebugEnabled() == false) goto L5;
        this.log.debug("Closing connections idle longer than " + r4 + HanziToPinyin.Token.SEPARATOR + r6);
    L5:
        this.pool.closeIdle(r4, r6);
    }

    @Override // cz.msebera.android.httpclient.conn.ClientConnectionManager
    public void closeExpiredConnections() {
        this.log.debug("Closing expired connections");
        this.pool.closeExpired();
    }

    @Override // cz.msebera.android.httpclient.pool.ConnPoolControl
    public int getMaxTotal() {
        return this.pool.getMaxTotal();
    }

    @Override // cz.msebera.android.httpclient.pool.ConnPoolControl
    public void setMaxTotal(int r1) {
        this.pool.setMaxTotal(r1);
    }

    @Override // cz.msebera.android.httpclient.pool.ConnPoolControl
    public int getDefaultMaxPerRoute() {
        return this.pool.getDefaultMaxPerRoute();
    }

    @Override // cz.msebera.android.httpclient.pool.ConnPoolControl
    public void setDefaultMaxPerRoute(int r1) {
        this.pool.setDefaultMaxPerRoute(r1);
    }

    /* JADX INFO: renamed from: getMaxPerRoute, reason: avoid collision after fix types in other method */
    public int getMaxPerRoute2(HttpRoute r1) {
        return this.pool.getMaxPerRoute(r1);
    }

    /* JADX INFO: renamed from: setMaxPerRoute, reason: avoid collision after fix types in other method */
    public void setMaxPerRoute2(HttpRoute r1, int r2) {
        this.pool.setMaxPerRoute(r1, r2);
    }

    @Override // cz.msebera.android.httpclient.pool.ConnPoolControl
    public PoolStats getTotalStats() {
        return this.pool.getTotalStats();
    }

    /* JADX INFO: renamed from: getStats, reason: avoid collision after fix types in other method */
    public PoolStats getStats2(HttpRoute r1) {
        return this.pool.getStats(r1);
    }
}
