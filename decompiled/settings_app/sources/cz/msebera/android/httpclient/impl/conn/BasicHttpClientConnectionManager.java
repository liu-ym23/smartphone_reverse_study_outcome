package cz.msebera.android.httpclient.impl.conn;

import com.android.settings.utils.HanziToPinyin;
import cz.msebera.android.httpclient.HttpClientConnection;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.config.ConnectionConfig;
import cz.msebera.android.httpclient.config.Lookup;
import cz.msebera.android.httpclient.config.Registry;
import cz.msebera.android.httpclient.config.RegistryBuilder;
import cz.msebera.android.httpclient.config.SocketConfig;
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
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import cz.msebera.android.httpclient.util.LangUtils;
import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import obric.time.HttpHeadTimeFetcher;

/* JADX INFO: loaded from: classes5.dex */
public class BasicHttpClientConnectionManager implements HttpClientConnectionManager, Closeable {
    private ManagedHttpClientConnection conn;
    private ConnectionConfig connConfig;
    private final HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> connFactory;
    private final HttpClientConnectionOperator connectionOperator;
    private long expiry;
    private final AtomicBoolean isShutdown;
    private boolean leased;
    public HttpClientAndroidLog log;
    private HttpRoute route;
    private SocketConfig socketConfig;
    private Object state;
    private long updated;

    @Override // cz.msebera.android.httpclient.conn.HttpClientConnectionManager
    public void routeComplete(HttpClientConnection r1, HttpRoute r2, HttpContext r3) throws IOException {
    }

    private static Registry<ConnectionSocketFactory> getDefaultRegistry() {
        return RegistryBuilder.create().register("http", PlainConnectionSocketFactory.getSocketFactory()).register(HttpHeadTimeFetcher.FETCHER_TYPE, SSLConnectionSocketFactory.getSocketFactory()).build();
    }

    public BasicHttpClientConnectionManager(Lookup<ConnectionSocketFactory> r2, HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> r3, SchemePortResolver r4, DnsResolver r5) {
        this(new DefaultHttpClientConnectionOperator(r2, r4, r5), r3);
    }

    public BasicHttpClientConnectionManager(HttpClientConnectionOperator r3, HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> r4) {
        this.log = new HttpClientAndroidLog(getClass());
        this.connectionOperator = (HttpClientConnectionOperator) Args.notNull(r3, "Connection operator");
        if (r4 != null) goto L6;
        r4 = ManagedHttpClientConnectionFactory.INSTANCE;
    L6:
        this.connFactory = r4;
        this.expiry = Long.MAX_VALUE;
        this.socketConfig = SocketConfig.DEFAULT;
        this.connConfig = ConnectionConfig.DEFAULT;
        this.isShutdown = new AtomicBoolean(false);
    }

    public BasicHttpClientConnectionManager(Lookup<ConnectionSocketFactory> r2, HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> r3) {
        this(r2, r3, null, null);
    }

    public BasicHttpClientConnectionManager(Lookup<ConnectionSocketFactory> r2) {
        this(r2, null, null, null);
    }

    public BasicHttpClientConnectionManager() {
        this(getDefaultRegistry(), null, null, null);
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
        if (this.isShutdown.compareAndSet(false, true) == false) goto L6;
        closeConnection();
        return;
    }

    HttpRoute getRoute() {
        return this.route;
    }

    Object getState() {
        return this.state;
    }

    public synchronized SocketConfig getSocketConfig() {
        monitor-enter(this);
        SocketConfig r0 = this.socketConfig;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void setSocketConfig(SocketConfig r1) {
        monitor-enter(this);
        if (r1 == null) goto L12;
    L6:
        this.socketConfig = r1;     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    L12:
        r1 = SocketConfig.DEFAULT;     // Catch: Throwable -> L9
        goto L6
    }

    public synchronized ConnectionConfig getConnectionConfig() {
        monitor-enter(this);
        ConnectionConfig r0 = this.connConfig;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void setConnectionConfig(ConnectionConfig r1) {
        monitor-enter(this);
        if (r1 == null) goto L12;
    L6:
        this.connConfig = r1;     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    L12:
        r1 = ConnectionConfig.DEFAULT;     // Catch: Throwable -> L9
        goto L6
    }

    @Override // cz.msebera.android.httpclient.conn.HttpClientConnectionManager
    public final ConnectionRequest requestConnection(final HttpRoute r2, final Object r3) {
        Args.notNull(r2, "Route");
        return new AnonymousClass1(this, r2, r3);
    }

    private synchronized void closeConnection() {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.conn == null) goto L13;
        this.log.debug("Closing connection");     // Catch: Throwable -> L15
        this.conn.close();     // Catch: IOException -> L8 Throwable -> L15
    L12:
        this.conn = null;     // Catch: Throwable -> L15
        goto L13
    L8:
        e = move-exception;
        if (this.log.isDebugEnabled() == false) goto L12;
        this.log.debug("I/O exception closing connection", e);     // Catch: Throwable -> L15
    L13:
        monitor-exit(this);
    }

    private void checkExpiry() {
        if (this.conn != null) goto L5;
        return;
    L5:
        if (System.currentTimeMillis() >= this.expiry) goto L7;
        return;
    L7:
        if (this.log.isDebugEnabled() == false) goto L9;
        this.log.debug("Connection expired @ " + new Date(this.expiry));
    L9:
        closeConnection();
    }

    synchronized HttpClientConnection getConnection(HttpRoute r6, Object r7) {
        monitor-enter(this);
        boolean r2 = false;
        if (this.isShutdown.get() == true) goto L7;
        boolean r1 = true;
    L8:
        Asserts.check(r1, "Connection manager has been shut down");     // Catch: Throwable -> L25
        if (this.log.isDebugEnabled() == false) goto L12;
        this.log.debug("Get connection for route " + r6);     // Catch: Throwable -> L25
    L12:
        if (this.leased == true) goto L14;
        r2 = true;
    L14:
        Asserts.check(r2, "Connection is still allocated");     // Catch: Throwable -> L25
        if (LangUtils.equals(this.route, r6) == true) goto L17;
    L18:
        closeConnection();     // Catch: Throwable -> L25
    L19:
        this.route = r6;     // Catch: Throwable -> L25
        this.state = r7;     // Catch: Throwable -> L25
        checkExpiry();     // Catch: Throwable -> L25
        if (this.conn != null) goto L22;
        this.conn = (ManagedHttpClientConnection) this.connFactory.create(r6, this.connConfig);     // Catch: Throwable -> L25
    L22:
        this.conn.setSocketTimeout(this.socketConfig.getSoTimeout());     // Catch: Throwable -> L25
        this.leased = true;     // Catch: Throwable -> L25
        ManagedHttpClientConnection r8 = this.conn;     // Catch: Throwable -> L25
        monitor-exit(this);
        return r8;
    L17:
        if (LangUtils.equals(this.state, r7) == true) goto L19;
    L7:
        r1 = false;
    L25:
        th = move-exception;
        throw th;
    }

    @Override // cz.msebera.android.httpclient.conn.HttpClientConnectionManager
    public synchronized void releaseConnection(HttpClientConnection r8, Object r9, long r10, TimeUnit r12) {
        monitor-enter(this);
        Args.notNull(r8, "Connection");     // Catch: Throwable -> L35
        if (r8 != this.conn) goto L7;
        boolean r3 = true;
    L8:
        Asserts.check(r3, "Connection not obtained from this manager");     // Catch: Throwable -> L35
        if (this.log.isDebugEnabled() == false) goto L12;
        this.log.debug("Releasing connection " + r8);     // Catch: Throwable -> L35
    L12:
        if (this.isShutdown.get() == false) goto L39;
        monitor-exit(this);
        return;
    L39:
        this.updated = System.currentTimeMillis();     // Catch: Throwable -> L32
        if (this.conn.isOpen() == true) goto L18;
        this.route = null;     // Catch: Throwable -> L32
        this.conn = null;     // Catch: Throwable -> L32
        this.expiry = Long.MAX_VALUE;     // Catch: Throwable -> L32
    L29:
        this.leased = false;     // Catch: Throwable -> L35
        monitor-exit(this);
        return;
    L18:
        this.state = r9;     // Catch: Throwable -> L32
        this.conn.setSocketTimeout(0);     // Catch: Throwable -> L32
        if (this.log.isDebugEnabled() == false) goto L26;
        if (r10 <= 0) goto L23;
        String r11 = "for " + r10 + HanziToPinyin.Token.SEPARATOR + r12;     // Catch: Throwable -> L32
    L24:
        this.log.debug("Connection can be kept alive " + r11);     // Catch: Throwable -> L32
        goto L26
    L23:
        r11 = "indefinitely";
    L26:
        if (r10 <= 0) goto L28;
        this.expiry = this.updated + r12.toMillis(r10);     // Catch: Throwable -> L32
        goto L29
    L28:
        this.expiry = Long.MAX_VALUE;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        this.leased = false;     // Catch: Throwable -> L35
        throw th;     // Catch: Throwable -> L35
    L7:
        r3 = false;
    L35:
        th = move-exception;
        throw th;
    }

    @Override // cz.msebera.android.httpclient.conn.HttpClientConnectionManager
    public void connect(HttpClientConnection r8, HttpRoute r9, int r10, HttpContext r11) throws IOException {
        Args.notNull(r8, "Connection");
        Args.notNull(r9, "HTTP route");
        if (r8 != this.conn) goto L5;
        boolean r12 = true;
    L6:
        Asserts.check(r12, "Connection not obtained from this manager");
        if (r9.getProxyHost() == null) goto L9;
        HttpHost r13 = r9.getProxyHost();
    L10:
        InetSocketAddress r3 = r9.getLocalSocketAddress();
        HttpClientConnectionOperator r0 = this.connectionOperator;
        ManagedHttpClientConnection r1 = this.conn;
        r0.connect(r1, r13, r3, r10, this.socketConfig, r11);
        return;
    L9:
        r13 = r9.getTargetHost();
        goto L10
    L5:
        r12 = false;
        goto L6
    }

    @Override // cz.msebera.android.httpclient.conn.HttpClientConnectionManager
    public void upgrade(HttpClientConnection r2, HttpRoute r3, HttpContext r4) throws IOException {
        Args.notNull(r2, "Connection");
        Args.notNull(r3, "HTTP route");
        if (r2 != this.conn) goto L5;
        boolean r5 = true;
    L6:
        Asserts.check(r5, "Connection not obtained from this manager");
        this.connectionOperator.upgrade(this.conn, r3.getTargetHost(), r4);
        return;
    L5:
        r5 = false;
        goto L6
    }

    @Override // cz.msebera.android.httpclient.conn.HttpClientConnectionManager
    public synchronized void closeExpiredConnections() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.isShutdown.get() == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (this.leased == true) goto L10;
        checkExpiry();     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
    }

    @Override // cz.msebera.android.httpclient.conn.HttpClientConnectionManager
    public synchronized void closeIdleConnections(long r3, TimeUnit r5) {
        monitor-enter(this);
        Args.notNull(r5, "Time unit");     // Catch: Throwable -> L17
        if (this.isShutdown.get() == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (this.leased == true) goto L15;
        long r4 = r5.toMillis(r3);     // Catch: Throwable -> L17
        if (r4 >= 0) goto L13;
        r4 = 0;
    L13:
        if (this.updated > (System.currentTimeMillis() - r4)) goto L15;
        closeConnection();     // Catch: Throwable -> L17
    L15:
        monitor-exit(this);
        return;
    L17:
        th = move-exception;
        throw th;
    }

    @Override // cz.msebera.android.httpclient.conn.HttpClientConnectionManager
    public void shutdown() {
        close();
    }
}
