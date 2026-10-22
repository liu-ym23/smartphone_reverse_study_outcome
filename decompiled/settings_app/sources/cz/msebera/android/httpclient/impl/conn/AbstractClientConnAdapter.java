package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpConnectionMetrics;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.conn.ManagedClientConnection;
import cz.msebera.android.httpclient.conn.OperatedClientConnection;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public abstract class AbstractClientConnAdapter implements ManagedClientConnection, HttpContext {
    private final ClientConnectionManager connManager;
    private volatile long duration;
    private volatile boolean markedReusable;
    private volatile boolean released;
    private volatile OperatedClientConnection wrappedConnection;

    protected AbstractClientConnAdapter(ClientConnectionManager r1, OperatedClientConnection r2) {
        this.connManager = r1;
        this.wrappedConnection = r2;
        this.markedReusable = false;
        this.released = false;
        this.duration = Long.MAX_VALUE;
    }

    protected synchronized void detach() {
        monitor-enter(this);
        this.wrappedConnection = null;     // Catch: Throwable -> L7
        this.duration = Long.MAX_VALUE;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    protected OperatedClientConnection getWrappedConnection() {
        return this.wrappedConnection;
    }

    protected ClientConnectionManager getManager() {
        return this.connManager;
    }

    @Deprecated
    protected final void assertNotAborted() throws InterruptedIOException {
        if (isReleased() == true) goto L6;
        return;
    L6:
        throw new InterruptedIOException("Connection has been shut down");
    }

    protected boolean isReleased() {
        return this.released;
    }

    protected final void assertValid(OperatedClientConnection r1) throws ConnectionShutdownException {
        if (isReleased() == true) goto L7;
        if (r1 == null) goto L7;
        return;
    L7:
        throw new ConnectionShutdownException();
    }

    @Override // cz.msebera.android.httpclient.HttpConnection
    public boolean isOpen() {
        OperatedClientConnection r0 = getWrappedConnection();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isOpen();
    }

    @Override // cz.msebera.android.httpclient.HttpConnection
    public boolean isStale() {
        if (isReleased() == false) goto L5;
        return true;
    L5:
        OperatedClientConnection r2 = getWrappedConnection();
        if (r2 != null) goto L9;
        return true;
    L9:
        return r2.isStale();
    }

    @Override // cz.msebera.android.httpclient.HttpConnection
    public void setSocketTimeout(int r2) {
        OperatedClientConnection r0 = getWrappedConnection();
        assertValid(r0);
        r0.setSocketTimeout(r2);
    }

    @Override // cz.msebera.android.httpclient.HttpConnection
    public int getSocketTimeout() {
        OperatedClientConnection r0 = getWrappedConnection();
        assertValid(r0);
        return r0.getSocketTimeout();
    }

    @Override // cz.msebera.android.httpclient.HttpConnection
    public HttpConnectionMetrics getMetrics() {
        OperatedClientConnection r0 = getWrappedConnection();
        assertValid(r0);
        return r0.getMetrics();
    }

    @Override // cz.msebera.android.httpclient.HttpClientConnection
    public void flush() throws IOException {
        OperatedClientConnection r0 = getWrappedConnection();
        assertValid(r0);
        r0.flush();
    }

    @Override // cz.msebera.android.httpclient.HttpClientConnection
    public boolean isResponseAvailable(int r2) throws IOException {
        OperatedClientConnection r0 = getWrappedConnection();
        assertValid(r0);
        return r0.isResponseAvailable(r2);
    }

    @Override // cz.msebera.android.httpclient.HttpClientConnection
    public void receiveResponseEntity(HttpResponse r2) throws HttpException, IOException {
        OperatedClientConnection r0 = getWrappedConnection();
        assertValid(r0);
        unmarkReusable();
        r0.receiveResponseEntity(r2);
    }

    @Override // cz.msebera.android.httpclient.HttpClientConnection
    public HttpResponse receiveResponseHeader() throws HttpException, IOException {
        OperatedClientConnection r0 = getWrappedConnection();
        assertValid(r0);
        unmarkReusable();
        return r0.receiveResponseHeader();
    }

    @Override // cz.msebera.android.httpclient.HttpClientConnection
    public void sendRequestEntity(HttpEntityEnclosingRequest r2) throws HttpException, IOException {
        OperatedClientConnection r0 = getWrappedConnection();
        assertValid(r0);
        unmarkReusable();
        r0.sendRequestEntity(r2);
    }

    @Override // cz.msebera.android.httpclient.HttpClientConnection
    public void sendRequestHeader(HttpRequest r2) throws HttpException, IOException {
        OperatedClientConnection r0 = getWrappedConnection();
        assertValid(r0);
        unmarkReusable();
        r0.sendRequestHeader(r2);
    }

    @Override // cz.msebera.android.httpclient.HttpInetConnection
    public InetAddress getLocalAddress() {
        OperatedClientConnection r0 = getWrappedConnection();
        assertValid(r0);
        return r0.getLocalAddress();
    }

    @Override // cz.msebera.android.httpclient.HttpInetConnection
    public int getLocalPort() {
        OperatedClientConnection r0 = getWrappedConnection();
        assertValid(r0);
        return r0.getLocalPort();
    }

    @Override // cz.msebera.android.httpclient.HttpInetConnection
    public InetAddress getRemoteAddress() {
        OperatedClientConnection r0 = getWrappedConnection();
        assertValid(r0);
        return r0.getRemoteAddress();
    }

    @Override // cz.msebera.android.httpclient.HttpInetConnection
    public int getRemotePort() {
        OperatedClientConnection r0 = getWrappedConnection();
        assertValid(r0);
        return r0.getRemotePort();
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedClientConnection, cz.msebera.android.httpclient.conn.HttpRoutedConnection
    public boolean isSecure() {
        OperatedClientConnection r0 = getWrappedConnection();
        assertValid(r0);
        return r0.isSecure();
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedHttpClientConnection
    public void bind(Socket r1) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedHttpClientConnection
    public Socket getSocket() {
        OperatedClientConnection r0 = getWrappedConnection();
        assertValid(r0);
        if (isOpen() == true) goto L7;
        return null;
    L7:
        return r0.getSocket();
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedClientConnection, cz.msebera.android.httpclient.conn.HttpRoutedConnection, cz.msebera.android.httpclient.conn.ManagedHttpClientConnection
    public SSLSession getSSLSession() {
        OperatedClientConnection r0 = getWrappedConnection();
        assertValid(r0);
        if (isOpen() == true) goto L5;
        return null;
    L5:
        Socket r2 = r0.getSocket();
        if ((r2 instanceof SSLSocket) == true) goto L8;
        return null;
    L8:
        return ((SSLSocket) r2).getSession();
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedClientConnection
    public void markReusable() {
        this.markedReusable = true;
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedClientConnection
    public void unmarkReusable() {
        this.markedReusable = false;
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedClientConnection
    public boolean isMarkedReusable() {
        return this.markedReusable;
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
    public synchronized void releaseConnection() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.released == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.released = true;     // Catch: Throwable -> L11
        this.connManager.releaseConnection(this, this.duration, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    @Override // cz.msebera.android.httpclient.conn.ConnectionReleaseTrigger
    public synchronized void abortConnection() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.released == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.released = true;     // Catch: Throwable -> L13
        unmarkReusable();     // Catch: Throwable -> L13
        shutdown();     // Catch: IOException -> L16 Throwable -> L13
    L10:
        this.connManager.releaseConnection(this, this.duration, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L13
        monitor-exit(this);
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpContext
    public Object getAttribute(String r2) {
        OperatedClientConnection r0 = getWrappedConnection();
        assertValid(r0);
        if ((r0 instanceof HttpContext) == true) goto L5;
        return null;
    L5:
        return ((HttpContext) r0).getAttribute(r2);
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpContext
    public Object removeAttribute(String r2) {
        OperatedClientConnection r0 = getWrappedConnection();
        assertValid(r0);
        if ((r0 instanceof HttpContext) == true) goto L5;
        return null;
    L5:
        return ((HttpContext) r0).removeAttribute(r2);
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpContext
    public void setAttribute(String r2, Object r3) {
        OperatedClientConnection r0 = getWrappedConnection();
        assertValid(r0);
        if ((r0 instanceof HttpContext) == false) goto L6;
        ((HttpContext) r0).setAttribute(r2, r3);
        return;
    }
}
