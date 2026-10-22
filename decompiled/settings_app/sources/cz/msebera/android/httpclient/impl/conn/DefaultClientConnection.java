package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpResponseFactory;
import cz.msebera.android.httpclient.conn.ManagedHttpClientConnection;
import cz.msebera.android.httpclient.conn.OperatedClientConnection;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.impl.SocketHttpClientConnection;
import cz.msebera.android.httpclient.io.HttpMessageParser;
import cz.msebera.android.httpclient.io.SessionInputBuffer;
import cz.msebera.android.httpclient.io.SessionOutputBuffer;
import cz.msebera.android.httpclient.params.BasicHttpParams;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.params.HttpProtocolParams;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class DefaultClientConnection extends SocketHttpClientConnection implements OperatedClientConnection, ManagedHttpClientConnection, HttpContext {
    private final Map<String, Object> attributes;
    private boolean connSecure;
    public HttpClientAndroidLog headerLog;
    public HttpClientAndroidLog log;
    private volatile boolean shutdown;
    private volatile Socket socket;
    private HttpHost targetHost;
    public HttpClientAndroidLog wireLog;

    @Override // cz.msebera.android.httpclient.conn.ManagedHttpClientConnection
    public String getId() {
        return null;
    }

    public DefaultClientConnection() {
        this.log = new HttpClientAndroidLog(getClass());
        this.headerLog = new HttpClientAndroidLog("cz.msebera.android.httpclient.headers");
        this.wireLog = new HttpClientAndroidLog("cz.msebera.android.httpclient.wire");
        this.attributes = new HashMap();
    }

    @Override // cz.msebera.android.httpclient.conn.OperatedClientConnection
    public final HttpHost getTargetHost() {
        return this.targetHost;
    }

    @Override // cz.msebera.android.httpclient.conn.OperatedClientConnection
    public final boolean isSecure() {
        return this.connSecure;
    }

    @Override // cz.msebera.android.httpclient.impl.SocketHttpClientConnection, cz.msebera.android.httpclient.conn.OperatedClientConnection, cz.msebera.android.httpclient.conn.ManagedHttpClientConnection
    public final Socket getSocket() {
        return this.socket;
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedHttpClientConnection
    public SSLSession getSSLSession() {
        if ((this.socket instanceof SSLSocket) == true) goto L5;
        return null;
    L5:
        return ((SSLSocket) this.socket).getSession();
    }

    @Override // cz.msebera.android.httpclient.conn.OperatedClientConnection
    public void opening(Socket r1, HttpHost r2) throws IOException {
        assertNotOpen();
        this.socket = r1;
        this.targetHost = r2;
        if (this.shutdown == true) goto L5;
        return;
    L5:
        r1.close();
        throw new InterruptedIOException("Connection already shutdown");
    }

    @Override // cz.msebera.android.httpclient.conn.OperatedClientConnection
    public void openCompleted(boolean r2, HttpParams r3) throws IOException {
        Args.notNull(r3, "Parameters");
        assertNotOpen();
        this.connSecure = r2;
        bind(this.socket, r3);
    }

    @Override // cz.msebera.android.httpclient.impl.SocketHttpClientConnection, cz.msebera.android.httpclient.HttpConnection
    public void shutdown() throws IOException {
        this.shutdown = true;
        super.shutdown();     // Catch: IOException -> L10
        if (this.log.isDebugEnabled() == false) goto L6;
        this.log.debug("Connection " + this + " shut down");     // Catch: IOException -> L10
    L6:
        Socket r0 = this.socket;     // Catch: IOException -> L10
        if (r0 == null) goto L15;
        r0.close();     // Catch: IOException -> L10
        return;
    L15:
        return;
    L10:
        e = move-exception;
        this.log.debug("I/O error shutting down connection", e);
    }

    @Override // cz.msebera.android.httpclient.impl.SocketHttpClientConnection, cz.msebera.android.httpclient.HttpConnection, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();     // Catch: IOException -> L7
        if (this.log.isDebugEnabled() == false) goto L12;
        this.log.debug("Connection " + this + " closed");     // Catch: IOException -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        this.log.debug("I/O error closing connection", e);
    }

    @Override // cz.msebera.android.httpclient.impl.SocketHttpClientConnection
    protected SessionInputBuffer createSessionInputBuffer(Socket r2, int r3, HttpParams r4) throws IOException {
        if (r3 > 0) goto L5;
        r3 = 8192;
    L5:
        SessionInputBuffer r5 = super.createSessionInputBuffer(r2, r3, r4);
        if (this.wireLog.isDebugEnabled() == true) goto L8;
        return r5;
    L8:
        return new LoggingSessionInputBuffer(r5, new Wire(this.wireLog), HttpProtocolParams.getHttpElementCharset(r4));
    }

    @Override // cz.msebera.android.httpclient.impl.SocketHttpClientConnection
    protected SessionOutputBuffer createSessionOutputBuffer(Socket r2, int r3, HttpParams r4) throws IOException {
        if (r3 > 0) goto L5;
        r3 = 8192;
    L5:
        SessionOutputBuffer r5 = super.createSessionOutputBuffer(r2, r3, r4);
        if (this.wireLog.isDebugEnabled() == true) goto L8;
        return r5;
    L8:
        return new LoggingSessionOutputBuffer(r5, new Wire(this.wireLog), HttpProtocolParams.getHttpElementCharset(r4));
    }

    @Override // cz.msebera.android.httpclient.impl.AbstractHttpClientConnection
    protected HttpMessageParser<HttpResponse> createResponseParser(SessionInputBuffer r2, HttpResponseFactory r3, HttpParams r4) {
        return new DefaultHttpResponseParser(r2, null, r3, r4);
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedHttpClientConnection
    public void bind(Socket r2) throws IOException {
        bind(r2, new BasicHttpParams());
    }

    @Override // cz.msebera.android.httpclient.conn.OperatedClientConnection
    public void update(Socket r2, HttpHost r3, boolean r4, HttpParams r5) throws IOException {
        assertOpen();
        Args.notNull(r3, "Target host");
        Args.notNull(r5, "Parameters");
        if (r2 == null) goto L5;
        this.socket = r2;
        bind(r2, r5);
    L5:
        this.targetHost = r3;
        this.connSecure = r4;
    }

    @Override // cz.msebera.android.httpclient.impl.AbstractHttpClientConnection, cz.msebera.android.httpclient.HttpClientConnection
    public HttpResponse receiveResponseHeader() throws HttpException, IOException {
        HttpResponse r0 = super.receiveResponseHeader();
        if (this.log.isDebugEnabled() == false) goto L6;
        this.log.debug("Receiving response: " + r0.getStatusLine());
    L6:
        if (this.headerLog.isDebugEnabled() == false) goto L10;
        this.headerLog.debug("<< " + r0.getStatusLine().toString());
        Header[] r1 = r0.getAllHeaders();
        int r2 = r1.length;
        int r4 = 0;
    L8:
        if (r4 >= r2) goto L10;
        this.headerLog.debug("<< " + r1[r4].toString());
        r4 = r4 + 1;
    L10:
        return r0;
    }

    @Override // cz.msebera.android.httpclient.impl.AbstractHttpClientConnection, cz.msebera.android.httpclient.HttpClientConnection
    public void sendRequestHeader(HttpRequest r7) throws HttpException, IOException {
        if (this.log.isDebugEnabled() == false) goto L5;
        this.log.debug("Sending request: " + r7.getRequestLine());
    L5:
        super.sendRequestHeader(r7);
        if (this.headerLog.isDebugEnabled() == false) goto L10;
        this.headerLog.debug(">> " + r7.getRequestLine().toString());
        Header[] r8 = r7.getAllHeaders();
        int r0 = r8.length;
        int r1 = 0;
    L8:
        if (r1 >= r0) goto L12;
        this.headerLog.debug(">> " + r8[r1].toString());
        r1 = r1 + 1;
        goto L8
    L12:
        return;
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpContext
    public Object getAttribute(String r1) {
        return this.attributes.get(r1);
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpContext
    public Object removeAttribute(String r1) {
        return this.attributes.remove(r1);
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpContext
    public void setAttribute(String r1, Object r2) {
        this.attributes.put(r1, r2);
    }
}
