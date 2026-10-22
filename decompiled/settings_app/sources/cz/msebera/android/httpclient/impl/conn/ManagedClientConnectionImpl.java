package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpConnectionMetrics;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.conn.ClientConnectionOperator;
import cz.msebera.android.httpclient.conn.ManagedClientConnection;
import cz.msebera.android.httpclient.conn.OperatedClientConnection;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.conn.routing.RouteTracker;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
class ManagedClientConnectionImpl implements ManagedClientConnection {
    private volatile long duration;
    private final ClientConnectionManager manager;
    private final ClientConnectionOperator operator;
    private volatile HttpPoolEntry poolEntry;
    private volatile boolean reusable;

    @Override // cz.msebera.android.httpclient.conn.ManagedHttpClientConnection
    public String getId() {
        return null;
    }

    ManagedClientConnectionImpl(ClientConnectionManager r2, ClientConnectionOperator r3, HttpPoolEntry r4) {
        Args.notNull(r2, "Connection manager");
        Args.notNull(r3, "Connection operator");
        Args.notNull(r4, "HTTP pool entry");
        this.manager = r2;
        this.operator = r3;
        this.poolEntry = r4;
        this.reusable = false;
        this.duration = Long.MAX_VALUE;
    }

    HttpPoolEntry getPoolEntry() {
        return this.poolEntry;
    }

    HttpPoolEntry detach() {
        HttpPoolEntry r0 = this.poolEntry;
        this.poolEntry = null;
        return r0;
    }

    public ClientConnectionManager getManager() {
        return this.manager;
    }

    private OperatedClientConnection getConnection() {
        HttpPoolEntry r0 = this.poolEntry;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getConnection();
    }

    private OperatedClientConnection ensureConnection() {
        HttpPoolEntry r0 = this.poolEntry;
        if (r0 == null) goto L7;
        return r0.getConnection();
    L7:
        throw new ConnectionShutdownException();
    }

    private HttpPoolEntry ensurePoolEntry() {
        HttpPoolEntry r0 = this.poolEntry;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new ConnectionShutdownException();
    }

    @Override // cz.msebera.android.httpclient.HttpConnection, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        HttpPoolEntry r1 = this.poolEntry;
        if (r1 == null) goto L6;
        OperatedClientConnection r0 = r1.getConnection();
        r1.getTracker().reset();
        r0.close();
        return;
    }

    @Override // cz.msebera.android.httpclient.HttpConnection
    public void shutdown() throws IOException {
        HttpPoolEntry r1 = this.poolEntry;
        if (r1 == null) goto L6;
        OperatedClientConnection r0 = r1.getConnection();
        r1.getTracker().reset();
        r0.shutdown();
        return;
    }

    @Override // cz.msebera.android.httpclient.HttpConnection
    public boolean isOpen() {
        OperatedClientConnection r0 = getConnection();
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.isOpen();
    }

    @Override // cz.msebera.android.httpclient.HttpConnection
    public boolean isStale() {
        OperatedClientConnection r0 = getConnection();
        if (r0 != null) goto L5;
        return true;
    L5:
        return r0.isStale();
    }

    @Override // cz.msebera.android.httpclient.HttpConnection
    public void setSocketTimeout(int r1) {
        ensureConnection().setSocketTimeout(r1);
    }

    @Override // cz.msebera.android.httpclient.HttpConnection
    public int getSocketTimeout() {
        return ensureConnection().getSocketTimeout();
    }

    @Override // cz.msebera.android.httpclient.HttpConnection
    public HttpConnectionMetrics getMetrics() {
        return ensureConnection().getMetrics();
    }

    @Override // cz.msebera.android.httpclient.HttpClientConnection
    public void flush() throws IOException {
        ensureConnection().flush();
    }

    @Override // cz.msebera.android.httpclient.HttpClientConnection
    public boolean isResponseAvailable(int r1) throws IOException {
        return ensureConnection().isResponseAvailable(r1);
    }

    @Override // cz.msebera.android.httpclient.HttpClientConnection
    public void receiveResponseEntity(HttpResponse r1) throws HttpException, IOException {
        ensureConnection().receiveResponseEntity(r1);
    }

    @Override // cz.msebera.android.httpclient.HttpClientConnection
    public HttpResponse receiveResponseHeader() throws HttpException, IOException {
        return ensureConnection().receiveResponseHeader();
    }

    @Override // cz.msebera.android.httpclient.HttpClientConnection
    public void sendRequestEntity(HttpEntityEnclosingRequest r1) throws HttpException, IOException {
        ensureConnection().sendRequestEntity(r1);
    }

    @Override // cz.msebera.android.httpclient.HttpClientConnection
    public void sendRequestHeader(HttpRequest r1) throws HttpException, IOException {
        ensureConnection().sendRequestHeader(r1);
    }

    @Override // cz.msebera.android.httpclient.HttpInetConnection
    public InetAddress getLocalAddress() {
        return ensureConnection().getLocalAddress();
    }

    @Override // cz.msebera.android.httpclient.HttpInetConnection
    public int getLocalPort() {
        return ensureConnection().getLocalPort();
    }

    @Override // cz.msebera.android.httpclient.HttpInetConnection
    public InetAddress getRemoteAddress() {
        return ensureConnection().getRemoteAddress();
    }

    @Override // cz.msebera.android.httpclient.HttpInetConnection
    public int getRemotePort() {
        return ensureConnection().getRemotePort();
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedClientConnection, cz.msebera.android.httpclient.conn.HttpRoutedConnection
    public boolean isSecure() {
        return ensureConnection().isSecure();
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedHttpClientConnection
    public void bind(Socket r1) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedHttpClientConnection
    public Socket getSocket() {
        return ensureConnection().getSocket();
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedClientConnection, cz.msebera.android.httpclient.conn.HttpRoutedConnection, cz.msebera.android.httpclient.conn.ManagedHttpClientConnection
    public SSLSession getSSLSession() {
        Socket r1 = ensureConnection().getSocket();
        if ((r1 instanceof SSLSocket) == true) goto L7;
        return null;
    L7:
        return ((SSLSocket) r1).getSession();
    }

    public Object getAttribute(String r2) {
        OperatedClientConnection r1 = ensureConnection();
        if ((r1 instanceof HttpContext) == true) goto L5;
        return null;
    L5:
        return ((HttpContext) r1).getAttribute(r2);
    }

    public Object removeAttribute(String r2) {
        OperatedClientConnection r1 = ensureConnection();
        if ((r1 instanceof HttpContext) == true) goto L5;
        return null;
    L5:
        return ((HttpContext) r1).removeAttribute(r2);
    }

    public void setAttribute(String r2, Object r3) {
        OperatedClientConnection r1 = ensureConnection();
        if ((r1 instanceof HttpContext) == false) goto L6;
        ((HttpContext) r1).setAttribute(r2, r3);
        return;
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedClientConnection, cz.msebera.android.httpclient.conn.HttpRoutedConnection
    public HttpRoute getRoute() {
        return ensurePoolEntry().getEffectiveRoute();
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedClientConnection
    public void open(HttpRoute r9, HttpContext r10, HttpParams r11) throws IOException {
        Args.notNull(r9, "Route");
        Args.notNull(r11, "HTTP parameters");
        monitor-enter(this);
    L33:
        th = move-exception;
        throw th;
    L5:
        if (this.poolEntry == null) goto L32;
        RouteTracker r0 = this.poolEntry.getTracker();     // Catch: Throwable -> L33
        Asserts.notNull(r0, "Route tracker");     // Catch: Throwable -> L33
        if (r0.isConnected() == true) goto L9;
        boolean r1 = true;
    L10:
        Asserts.check(r1, "Connection already open");     // Catch: Throwable -> L33
        OperatedClientConnection r2 = this.poolEntry.getConnection();     // Catch: Throwable -> L33
        monitor-exit(this);     // Catch: Throwable -> L33
        HttpHost r7 = r9.getProxyHost();
        ClientConnectionOperator r3 = this.operator;
        if (r7 == null) goto L15;
        HttpHost r4 = r7;
    L16:
        r3.openConnection(r2, r4, r9.getLocalAddress(), r10, r11);
        monitor-enter(this);
    L28:
        th = move-exception;
        throw th;
    L19:
        if (this.poolEntry == null) goto L27;
        RouteTracker r12 = this.poolEntry.getTracker();     // Catch: Throwable -> L28
        if (r7 != null) goto L23;
        r12.connectTarget(r2.isSecure());     // Catch: Throwable -> L28
    L24:
        monitor-exit(this);     // Catch: Throwable -> L28
        return;
    L23:
        r12.connectProxy(r7, r2.isSecure());     // Catch: Throwable -> L28
        goto L24
    L27:
        throw new InterruptedIOException();     // Catch: Throwable -> L28
    L15:
        r4 = r9.getTargetHost();
        goto L16
    L9:
        r1 = false;
        goto L10
    L32:
        throw new ConnectionShutdownException();     // Catch: Throwable -> L33
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedClientConnection
    public void tunnelTarget(boolean r4, HttpParams r5) throws IOException {
        Args.notNull(r5, "HTTP parameters");
        monitor-enter(this);
    L26:
        th = move-exception;
        throw th;
    L5:
        if (this.poolEntry == null) goto L25;
        RouteTracker r0 = this.poolEntry.getTracker();     // Catch: Throwable -> L26
        Asserts.notNull(r0, "Route tracker");     // Catch: Throwable -> L26
        Asserts.check(r0.isConnected(), "Connection not open");     // Catch: Throwable -> L26
        if (r0.isTunnelled() == true) goto L9;
        boolean r1 = true;
    L10:
        Asserts.check(r1, "Connection is already tunnelled");     // Catch: Throwable -> L26
        HttpHost r2 = r0.getTargetHost();     // Catch: Throwable -> L26
        OperatedClientConnection r3 = this.poolEntry.getConnection();     // Catch: Throwable -> L26
        monitor-exit(this);     // Catch: Throwable -> L26
        r3.update(null, r2, r4, r5);
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L15:
        if (this.poolEntry == null) goto L20;
        this.poolEntry.getTracker().tunnelTarget(r4);     // Catch: Throwable -> L21
        monitor-exit(this);     // Catch: Throwable -> L21
        return;
    L20:
        throw new InterruptedIOException();     // Catch: Throwable -> L21
    L9:
        r1 = false;
        goto L10
    L25:
        throw new ConnectionShutdownException();     // Catch: Throwable -> L26
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedClientConnection
    public void tunnelProxy(HttpHost r3, boolean r4, HttpParams r5) throws IOException {
        Args.notNull(r3, "Next proxy");
        Args.notNull(r5, "HTTP parameters");
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L5:
        if (this.poolEntry == null) goto L21;
        RouteTracker r0 = this.poolEntry.getTracker();     // Catch: Throwable -> L22
        Asserts.notNull(r0, "Route tracker");     // Catch: Throwable -> L22
        Asserts.check(r0.isConnected(), "Connection not open");     // Catch: Throwable -> L22
        OperatedClientConnection r1 = this.poolEntry.getConnection();     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
        r1.update(null, r3, r4, r5);
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L11:
        if (this.poolEntry == null) goto L16;
        this.poolEntry.getTracker().tunnelProxy(r3, r4);     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L17
        return;
    L16:
        throw new InterruptedIOException();     // Catch: Throwable -> L17
    L21:
        throw new ConnectionShutdownException();     // Catch: Throwable -> L22
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedClientConnection
    public void layerProtocol(HttpContext r4, HttpParams r5) throws IOException {
        Args.notNull(r5, "HTTP parameters");
        monitor-enter(this);
    L26:
        th = move-exception;
        throw th;
    L5:
        if (this.poolEntry == null) goto L25;
        RouteTracker r0 = this.poolEntry.getTracker();     // Catch: Throwable -> L26
        Asserts.notNull(r0, "Route tracker");     // Catch: Throwable -> L26
        Asserts.check(r0.isConnected(), "Connection not open");     // Catch: Throwable -> L26
        Asserts.check(r0.isTunnelled(), "Protocol layering without a tunnel not supported");     // Catch: Throwable -> L26
        if (r0.isLayered() == true) goto L9;
        boolean r1 = true;
    L10:
        Asserts.check(r1, "Multiple protocol layering not supported");     // Catch: Throwable -> L26
        HttpHost r2 = r0.getTargetHost();     // Catch: Throwable -> L26
        OperatedClientConnection r3 = this.poolEntry.getConnection();     // Catch: Throwable -> L26
        monitor-exit(this);     // Catch: Throwable -> L26
        this.operator.updateSecureConnection(r3, r2, r4, r5);
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L15:
        if (this.poolEntry == null) goto L20;
        this.poolEntry.getTracker().layerProtocol(r3.isSecure());     // Catch: Throwable -> L21
        monitor-exit(this);     // Catch: Throwable -> L21
        return;
    L20:
        throw new InterruptedIOException();     // Catch: Throwable -> L21
    L9:
        r1 = false;
        goto L10
    L25:
        throw new ConnectionShutdownException();     // Catch: Throwable -> L26
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedClientConnection
    public Object getState() {
        return ensurePoolEntry().getState();
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedClientConnection
    public void setState(Object r1) {
        ensurePoolEntry().setState(r1);
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedClientConnection
    public void markReusable() {
        this.reusable = true;
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedClientConnection
    public void unmarkReusable() {
        this.reusable = false;
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedClientConnection
    public boolean isMarkedReusable() {
        return this.reusable;
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedClientConnection
    public void setIdleDuration(long r3, TimeUnit r5) {
        if (r3 <= 0) goto L5;
        this.duration = r5.toMillis(r3);
        return;
    L5:
        this.duration = -1;
    }

    @Override // cz.msebera.android.httpclient.conn.ConnectionReleaseTrigger
    public void releaseConnection() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.poolEntry != null) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L7:
        this.manager.releaseConnection(this, this.duration, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L10
        this.poolEntry = null;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
    }

    @Override // cz.msebera.android.httpclient.conn.ConnectionReleaseTrigger
    public void abortConnection() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.poolEntry != null) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L12
        return;
    L7:
        this.reusable = false;     // Catch: Throwable -> L12
        this.poolEntry.getConnection().shutdown();     // Catch: IOException -> L15 Throwable -> L12
    L9:
        this.manager.releaseConnection(this, this.duration, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L12
        this.poolEntry = null;     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
    }
}
