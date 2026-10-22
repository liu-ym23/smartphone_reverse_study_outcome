package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpClientConnection;
import cz.msebera.android.httpclient.HttpConnectionMetrics;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.conn.ManagedHttpClientConnection;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: classes5.dex */
class CPoolProxy implements ManagedHttpClientConnection, HttpContext {
    private volatile CPoolEntry poolEntry;

    CPoolProxy(CPoolEntry r1) {
        this.poolEntry = r1;
    }

    CPoolEntry getPoolEntry() {
        return this.poolEntry;
    }

    CPoolEntry detach() {
        CPoolEntry r0 = this.poolEntry;
        this.poolEntry = null;
        return r0;
    }

    ManagedHttpClientConnection getConnection() {
        CPoolEntry r0 = this.poolEntry;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getConnection();
    }

    ManagedHttpClientConnection getValidConnection() {
        ManagedHttpClientConnection r0 = getConnection();
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new ConnectionShutdownException();
    }

    @Override // cz.msebera.android.httpclient.HttpConnection, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        CPoolEntry r0 = this.poolEntry;
        if (r0 == null) goto L6;
        r0.closeConnection();
        return;
    }

    @Override // cz.msebera.android.httpclient.HttpConnection
    public void shutdown() throws IOException {
        CPoolEntry r0 = this.poolEntry;
        if (r0 == null) goto L6;
        r0.shutdownConnection();
        return;
    }

    @Override // cz.msebera.android.httpclient.HttpConnection
    public boolean isOpen() {
        CPoolEntry r1 = this.poolEntry;
        if (r1 != null) goto L5;
        return false;
    L5:
        if (r1.isClosed() == true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // cz.msebera.android.httpclient.HttpConnection
    public boolean isStale() {
        ManagedHttpClientConnection r0 = getConnection();
        if (r0 != null) goto L7;
        return true;
    L7:
        return r0.isStale();
    }

    @Override // cz.msebera.android.httpclient.HttpConnection
    public void setSocketTimeout(int r1) {
        getValidConnection().setSocketTimeout(r1);
    }

    @Override // cz.msebera.android.httpclient.HttpConnection
    public int getSocketTimeout() {
        return getValidConnection().getSocketTimeout();
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedHttpClientConnection
    public String getId() {
        return getValidConnection().getId();
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedHttpClientConnection
    public void bind(Socket r1) throws IOException {
        getValidConnection().bind(r1);
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedHttpClientConnection
    public Socket getSocket() {
        return getValidConnection().getSocket();
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedHttpClientConnection
    public SSLSession getSSLSession() {
        return getValidConnection().getSSLSession();
    }

    @Override // cz.msebera.android.httpclient.HttpClientConnection
    public boolean isResponseAvailable(int r1) throws IOException {
        return getValidConnection().isResponseAvailable(r1);
    }

    @Override // cz.msebera.android.httpclient.HttpClientConnection
    public void sendRequestHeader(HttpRequest r1) throws HttpException, IOException {
        getValidConnection().sendRequestHeader(r1);
    }

    @Override // cz.msebera.android.httpclient.HttpClientConnection
    public void sendRequestEntity(HttpEntityEnclosingRequest r1) throws HttpException, IOException {
        getValidConnection().sendRequestEntity(r1);
    }

    @Override // cz.msebera.android.httpclient.HttpClientConnection
    public HttpResponse receiveResponseHeader() throws HttpException, IOException {
        return getValidConnection().receiveResponseHeader();
    }

    @Override // cz.msebera.android.httpclient.HttpClientConnection
    public void receiveResponseEntity(HttpResponse r1) throws HttpException, IOException {
        getValidConnection().receiveResponseEntity(r1);
    }

    @Override // cz.msebera.android.httpclient.HttpClientConnection
    public void flush() throws IOException {
        getValidConnection().flush();
    }

    @Override // cz.msebera.android.httpclient.HttpConnection
    public HttpConnectionMetrics getMetrics() {
        return getValidConnection().getMetrics();
    }

    @Override // cz.msebera.android.httpclient.HttpInetConnection
    public InetAddress getLocalAddress() {
        return getValidConnection().getLocalAddress();
    }

    @Override // cz.msebera.android.httpclient.HttpInetConnection
    public int getLocalPort() {
        return getValidConnection().getLocalPort();
    }

    @Override // cz.msebera.android.httpclient.HttpInetConnection
    public InetAddress getRemoteAddress() {
        return getValidConnection().getRemoteAddress();
    }

    @Override // cz.msebera.android.httpclient.HttpInetConnection
    public int getRemotePort() {
        return getValidConnection().getRemotePort();
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpContext
    public Object getAttribute(String r2) {
        ManagedHttpClientConnection r1 = getValidConnection();
        if ((r1 instanceof HttpContext) == true) goto L7;
        return null;
    L7:
        return ((HttpContext) r1).getAttribute(r2);
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpContext
    public void setAttribute(String r2, Object r3) {
        ManagedHttpClientConnection r1 = getValidConnection();
        if ((r1 instanceof HttpContext) == false) goto L6;
        ((HttpContext) r1).setAttribute(r2, r3);
        return;
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpContext
    public Object removeAttribute(String r2) {
        ManagedHttpClientConnection r1 = getValidConnection();
        if ((r1 instanceof HttpContext) == true) goto L7;
        return null;
    L7:
        return ((HttpContext) r1).removeAttribute(r2);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("CPoolProxy{");
        ManagedHttpClientConnection r2 = getConnection();
        if (r2 == null) goto L5;
        r0.append(r2);
    L6:
        r0.append('}');
        return r0.toString();
    L5:
        r0.append("detached");
        goto L6
    }

    public static HttpClientConnection newProxy(CPoolEntry r1) {
        return new CPoolProxy(r1);
    }

    private static CPoolProxy getProxy(HttpClientConnection r3) {
        if (CPoolProxy.class.isInstance(r3) == false) goto L7;
        return (CPoolProxy) CPoolProxy.class.cast(r3);
    L7:
        throw new IllegalStateException("Unexpected connection proxy class: " + r3.getClass());
    }

    public static CPoolEntry getPoolEntry(HttpClientConnection r0) {
        CPoolEntry r1 = getProxy(r0).getPoolEntry();
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new ConnectionShutdownException();
    }

    public static CPoolEntry detach(HttpClientConnection r0) {
        return getProxy(r0).detach();
    }
}
