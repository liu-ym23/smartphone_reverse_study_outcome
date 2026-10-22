package cz.msebera.android.httpclient.impl.conn;

import com.android.settings.utils.HanziToPinyin;
import cz.msebera.android.httpclient.HttpClientConnection;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.config.ConnectionConfig;
import cz.msebera.android.httpclient.config.Lookup;
import cz.msebera.android.httpclient.config.Registry;
import cz.msebera.android.httpclient.config.RegistryBuilder;
import cz.msebera.android.httpclient.config.SocketConfig;
import cz.msebera.android.httpclient.conn.ConnectionPoolTimeoutException;
import cz.msebera.android.httpclient.conn.ConnectionRequest;
import cz.msebera.android.httpclient.conn.DnsResolver;
import cz.msebera.android.httpclient.conn.HttpClientConnectionManager;
import cz.msebera.android.httpclient.conn.HttpClientConnectionOperator;
import cz.msebera.android.httpclient.conn.HttpConnectionFactory;
import cz.msebera.android.httpclient.conn.ManagedHttpClientConnection;
import cz.msebera.android.httpclient.conn.SchemePortResolver;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.conn.socket.ConnectionSocketFactory;
import cz.msebera.android.httpclient.conn.socket.PlainConnectionSocketFactory;
import cz.msebera.android.httpclient.conn.ssl.SSLConnectionSocketFactory;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.pool.ConnFactory;
import cz.msebera.android.httpclient.pool.ConnPoolControl;
import cz.msebera.android.httpclient.pool.PoolEntryCallback;
import cz.msebera.android.httpclient.pool.PoolStats;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import java.io.Closeable;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import obric.time.HttpHeadTimeFetcher;

/* JADX INFO: loaded from: classes5.dex */
public class PoolingHttpClientConnectionManager implements HttpClientConnectionManager, ConnPoolControl<HttpRoute>, Closeable {
    private final ConfigData configData;
    private final HttpClientConnectionOperator connectionOperator;
    private final AtomicBoolean isShutDown;
    public HttpClientAndroidLog log;
    private final CPool pool;

    static class ConfigData {
        private final Map<HttpHost, ConnectionConfig> connectionConfigMap;
        private volatile ConnectionConfig defaultConnectionConfig;
        private volatile SocketConfig defaultSocketConfig;
        private final Map<HttpHost, SocketConfig> socketConfigMap;

        ConfigData() {
            this.socketConfigMap = new ConcurrentHashMap();
            this.connectionConfigMap = new ConcurrentHashMap();
        }

        public SocketConfig getDefaultSocketConfig() {
            return this.defaultSocketConfig;
        }

        public void setDefaultSocketConfig(SocketConfig r1) {
            this.defaultSocketConfig = r1;
        }

        public ConnectionConfig getDefaultConnectionConfig() {
            return this.defaultConnectionConfig;
        }

        public void setDefaultConnectionConfig(ConnectionConfig r1) {
            this.defaultConnectionConfig = r1;
        }

        public SocketConfig getSocketConfig(HttpHost r1) {
            return this.socketConfigMap.get(r1);
        }

        public void setSocketConfig(HttpHost r1, SocketConfig r2) {
            this.socketConfigMap.put(r1, r2);
        }

        public ConnectionConfig getConnectionConfig(HttpHost r1) {
            return this.connectionConfigMap.get(r1);
        }

        public void setConnectionConfig(HttpHost r1, ConnectionConfig r2) {
            this.connectionConfigMap.put(r1, r2);
        }
    }

    static class InternalConnectionFactory implements ConnFactory<HttpRoute, ManagedHttpClientConnection> {
        private final ConfigData configData;
        private final HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> connFactory;

        @Override // cz.msebera.android.httpclient.pool.ConnFactory
        public /* bridge */ /* synthetic */ ManagedHttpClientConnection create(HttpRoute r1) throws IOException {
            return create2(r1);
        }

        InternalConnectionFactory(ConfigData r1, HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> r2) {
            if (r1 != null) goto L6;
            r1 = new ConfigData();
        L6:
            this.configData = r1;
            if (r2 != null) goto L10;
            r2 = ManagedHttpClientConnectionFactory.INSTANCE;
        L10:
            this.connFactory = r2;
        }

        /* JADX INFO: renamed from: create, reason: avoid collision after fix types in other method */
        public ManagedHttpClientConnection create2(HttpRoute r3) throws IOException {
            if (r3.getProxyHost() == null) goto L5;
            ConnectionConfig r0 = this.configData.getConnectionConfig(r3.getProxyHost());
        L6:
            if (r0 != null) goto L8;
            r0 = this.configData.getConnectionConfig(r3.getTargetHost());
        L8:
            if (r0 != null) goto L10;
            r0 = this.configData.getDefaultConnectionConfig();
        L10:
            if (r0 != null) goto L13;
            r0 = ConnectionConfig.DEFAULT;
        L13:
            return (ManagedHttpClientConnection) this.connFactory.create(r3, r0);
        L5:
            r0 = null;
            goto L6
        }
    }

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

    static /* synthetic */ SocketConfig access$000(PoolingHttpClientConnectionManager r0, HttpHost r1) {
        return r0.resolveSocketConfig(r1);
    }

    private static Registry<ConnectionSocketFactory> getDefaultRegistry() {
        return RegistryBuilder.create().register("http", PlainConnectionSocketFactory.getSocketFactory()).register(HttpHeadTimeFetcher.FETCHER_TYPE, SSLConnectionSocketFactory.getSocketFactory()).build();
    }

    public PoolingHttpClientConnectionManager() {
        this(getDefaultRegistry());
    }

    public PoolingHttpClientConnectionManager(long r9, TimeUnit r11) {
        this(getDefaultRegistry(), null, null, null, r9, r11);
    }

    public PoolingHttpClientConnectionManager(Registry<ConnectionSocketFactory> r2) {
        this(r2, null, null);
    }

    public PoolingHttpClientConnectionManager(Registry<ConnectionSocketFactory> r2, DnsResolver r3) {
        this(r2, null, r3);
    }

    public PoolingHttpClientConnectionManager(Registry<ConnectionSocketFactory> r2, HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> r3) {
        this(r2, r3, null);
    }

    public PoolingHttpClientConnectionManager(HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> r3) {
        this(getDefaultRegistry(), r3, null);
    }

    public PoolingHttpClientConnectionManager(Registry<ConnectionSocketFactory> r9, HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> r10, DnsResolver r11) {
        this(r9, r10, null, r11, -1, TimeUnit.MILLISECONDS);
    }

    public PoolingHttpClientConnectionManager(Registry<ConnectionSocketFactory> r7, HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> r8, SchemePortResolver r9, DnsResolver r10, long r11, TimeUnit r13) {
        this(new DefaultHttpClientConnectionOperator(r7, r9, r10), r8, r11, r13);
    }

    public PoolingHttpClientConnectionManager(HttpClientConnectionOperator r10, HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> r11, long r12, TimeUnit r14) {
        this.log = new HttpClientAndroidLog(getClass());
        ConfigData r0 = new ConfigData();
        this.configData = r0;
        CPool r8 = new CPool(new InternalConnectionFactory(r0, r11), 2, 20, r12, r14);
        this.pool = r8;
        r8.setValidateAfterInactivity(2000);
        this.connectionOperator = (HttpClientConnectionOperator) Args.notNull(r10, "HttpClientConnectionOperator");
        this.isShutDown = new AtomicBoolean(false);
    }

    PoolingHttpClientConnectionManager(CPool r3, Lookup<ConnectionSocketFactory> r4, SchemePortResolver r5, DnsResolver r6) {
        this.log = new HttpClientAndroidLog(getClass());
        this.configData = new ConfigData();
        this.pool = r3;
        this.connectionOperator = new DefaultHttpClientConnectionOperator(r4, r5, r6);
        this.isShutDown = new AtomicBoolean(false);
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

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        shutdown();
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

    private String format(CPoolEntry r3) {
        StringBuilder r2 = new StringBuilder("[id: ");
        r2.append(r3.getId()).append("][route: ");
        r2.append(r3.getRoute()).append("]");
        Object r4 = r3.getState();
        if (r4 == null) goto L6;
        r2.append("[state: ").append(r4).append("]");
    L6:
        return r2.toString();
    }

    private SocketConfig resolveSocketConfig(HttpHost r2) {
        SocketConfig r3 = this.configData.getSocketConfig(r2);
        if (r3 != null) goto L5;
        r3 = this.configData.getDefaultSocketConfig();
    L5:
        if (r3 == null) goto L7;
        return r3;
    L7:
        return SocketConfig.DEFAULT;
    }

    @Override // cz.msebera.android.httpclient.conn.HttpClientConnectionManager
    public ConnectionRequest requestConnection(final HttpRoute r4, Object r5) {
        Args.notNull(r4, "HTTP route");
        if (this.log.isDebugEnabled() == false) goto L5;
        this.log.debug("Connection request: " + format(r4, r5) + formatStats(r4));
    L5:
        final Future<CPoolEntry> r6 = this.pool.lease(r4, r5, null);
        return new AnonymousClass1(this, r6, r4);
    }

    protected HttpClientConnection leaseConnection(Future<CPoolEntry> r2, long r3, TimeUnit r5) throws InterruptedException, ExecutionException, ConnectionPoolTimeoutException {
        CPoolEntry r4 = r2.get(r3, r5);     // Catch: TimeoutException -> L18
        if (r4 == null) goto L17;
        if (r2.isCancelled() == true) goto L17;
        if (r4.getConnection() == null) goto L10;
        boolean r6 = true;
    L11:
        Asserts.check(r6, "Pool entry with no connection");     // Catch: TimeoutException -> L18
        if (this.log.isDebugEnabled() == false) goto L15;
        this.log.debug("Connection leased: " + format(r4) + formatStats(r4.getRoute()));     // Catch: TimeoutException -> L18
    L15:
        return CPoolProxy.newProxy(r4);
    L10:
        r6 = false;
    L17:
        throw new ExecutionException(new CancellationException("Operation cancelled"));     // Catch: TimeoutException -> L18
    L19:
        throw new ConnectionPoolTimeoutException("Timeout waiting for connection from pool");
    }

    @Override // cz.msebera.android.httpclient.conn.HttpClientConnectionManager
    public void releaseConnection(HttpClientConnection r11, Object r12, long r13, TimeUnit r15) {
        Args.notNull(r11, "Managed connection");
        monitor-enter(r11);
        CPoolEntry r4 = CPoolProxy.detach(r11);     // Catch: Throwable -> L45
        if (r4 != null) goto L8;
        monitor-exit(r11);     // Catch: Throwable -> L45
        return;
    L8:
        ManagedHttpClientConnection r5 = r4.getConnection();     // Catch: Throwable -> L45
        boolean r6 = true;
    L34:
        th = move-exception;
        CPool r14 = this.pool;     // Catch: Throwable -> L45
        if (r5.isOpen() == true) goto L38;
    L40:
        r6 = false;
    L41:
        r14.release(r4, r6);     // Catch: Throwable -> L45
        if (this.log.isDebugEnabled() == false) goto L44;
        this.log.debug("Connection released: " + format(r4) + formatStats(r4.getRoute()));     // Catch: Throwable -> L45
    L44:
        throw th;     // Catch: Throwable -> L45
    L38:
        if (r4.isRouteComplete() == false) goto L40;
    L11:
        if (r5.isOpen() == false) goto L23;
        if (r15 != null) goto L15;
        r15 = TimeUnit.MILLISECONDS;     // Catch: Throwable -> L34
    L15:
        r4.setState(r12);     // Catch: Throwable -> L34
        r4.updateExpiry(r13, r15);     // Catch: Throwable -> L34
        if (this.log.isDebugEnabled() == true) goto L18;
    L22:
        r5.setSocketTimeout(0);     // Catch: Throwable -> L34
    L18:
        if (r13 <= 0) goto L20;
        String r16 = "for " + (r15.toMillis(r13) / 1000.0d) + " seconds";     // Catch: Throwable -> L34
    L21:
        this.log.debug("Connection " + format(r4) + " can be kept alive " + r16);     // Catch: Throwable -> L34
        goto L22
    L20:
        r16 = "indefinitely";
    L23:
        CPool r17 = this.pool;     // Catch: Throwable -> L45
        if (r5.isOpen() == true) goto L26;
    L28:
        r6 = false;
    L29:
        r17.release(r4, r6);     // Catch: Throwable -> L45
        if (this.log.isDebugEnabled() == false) goto L32;
        this.log.debug("Connection released: " + format(r4) + formatStats(r4.getRoute()));     // Catch: Throwable -> L45
    L32:
        monitor-exit(r11);     // Catch: Throwable -> L45
        return;
    L26:
        if (r4.isRouteComplete() == false) goto L28;
    L45:
        th = move-exception;
        throw th;
    }

    @Override // cz.msebera.android.httpclient.conn.HttpClientConnectionManager
    public void connect(HttpClientConnection r9, HttpRoute r10, int r11, HttpContext r12) throws IOException {
        Args.notNull(r9, "Managed Connection");
        Args.notNull(r10, "HTTP route");
        monitor-enter(r9);
        ManagedHttpClientConnection r2 = CPoolProxy.getPoolEntry(r9).getConnection();     // Catch: Throwable -> L12
        monitor-exit(r9);     // Catch: Throwable -> L12
        if (r10.getProxyHost() == null) goto L9;
        HttpHost r13 = r10.getProxyHost();
    L10:
        HttpHost r3 = r13;
        this.connectionOperator.connect(r2, r3, r10.getLocalSocketAddress(), r11, resolveSocketConfig(r3), r12);
        return;
    L9:
        r13 = r10.getTargetHost();
    L12:
        th = move-exception;
        throw th;
    }

    @Override // cz.msebera.android.httpclient.conn.HttpClientConnectionManager
    public void upgrade(HttpClientConnection r2, HttpRoute r3, HttpContext r4) throws IOException {
        Args.notNull(r2, "Managed Connection");
        Args.notNull(r3, "HTTP route");
        monitor-enter(r2);
        ManagedHttpClientConnection r0 = CPoolProxy.getPoolEntry(r2).getConnection();     // Catch: Throwable -> L8
        monitor-exit(r2);     // Catch: Throwable -> L8
        this.connectionOperator.upgrade(r0, r3.getTargetHost(), r4);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // cz.msebera.android.httpclient.conn.HttpClientConnectionManager
    public void routeComplete(HttpClientConnection r1, HttpRoute r2, HttpContext r3) throws IOException {
        Args.notNull(r1, "Managed Connection");
        Args.notNull(r2, "HTTP route");
        monitor-enter(r1);
        CPoolProxy.getPoolEntry(r1).markRouteComplete();     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // cz.msebera.android.httpclient.conn.HttpClientConnectionManager
    public void shutdown() {
        if (this.isShutDown.compareAndSet(false, true) == false) goto L13;
        this.log.debug("Connection manager is shutting down");
        this.pool.shutdown();     // Catch: IOException -> L7
    L9:
        this.log.debug("Connection manager shut down");
        return;
    L7:
        e = move-exception;
        this.log.debug("I/O exception shutting down connection manager", e);
        goto L9
    }

    @Override // cz.msebera.android.httpclient.conn.HttpClientConnectionManager
    public void closeIdleConnections(long r4, TimeUnit r6) {
        if (this.log.isDebugEnabled() == false) goto L5;
        this.log.debug("Closing connections idle longer than " + r4 + HanziToPinyin.Token.SEPARATOR + r6);
    L5:
        this.pool.closeIdle(r4, r6);
    }

    @Override // cz.msebera.android.httpclient.conn.HttpClientConnectionManager
    public void closeExpiredConnections() {
        this.log.debug("Closing expired connections");
        this.pool.closeExpired();
    }

    protected void enumAvailable(PoolEntryCallback<HttpRoute, ManagedHttpClientConnection> r1) {
        this.pool.enumAvailable(r1);
    }

    protected void enumLeased(PoolEntryCallback<HttpRoute, ManagedHttpClientConnection> r1) {
        this.pool.enumLeased(r1);
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

    public Set<HttpRoute> getRoutes() {
        return this.pool.getRoutes();
    }

    public SocketConfig getDefaultSocketConfig() {
        return this.configData.getDefaultSocketConfig();
    }

    public void setDefaultSocketConfig(SocketConfig r1) {
        this.configData.setDefaultSocketConfig(r1);
    }

    public ConnectionConfig getDefaultConnectionConfig() {
        return this.configData.getDefaultConnectionConfig();
    }

    public void setDefaultConnectionConfig(ConnectionConfig r1) {
        this.configData.setDefaultConnectionConfig(r1);
    }

    public SocketConfig getSocketConfig(HttpHost r1) {
        return this.configData.getSocketConfig(r1);
    }

    public void setSocketConfig(HttpHost r1, SocketConfig r2) {
        this.configData.setSocketConfig(r1, r2);
    }

    public ConnectionConfig getConnectionConfig(HttpHost r1) {
        return this.configData.getConnectionConfig(r1);
    }

    public void setConnectionConfig(HttpHost r1, ConnectionConfig r2) {
        this.configData.setConnectionConfig(r1, r2);
    }

    public int getValidateAfterInactivity() {
        return this.pool.getValidateAfterInactivity();
    }

    public void setValidateAfterInactivity(int r1) {
        this.pool.setValidateAfterInactivity(r1);
    }
}
