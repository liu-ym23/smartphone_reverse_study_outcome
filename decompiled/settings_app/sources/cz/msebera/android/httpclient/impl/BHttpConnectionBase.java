package cz.msebera.android.httpclient.impl;

import cz.msebera.android.httpclient.ConnectionClosedException;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpConnectionMetrics;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpInetConnection;
import cz.msebera.android.httpclient.HttpMessage;
import cz.msebera.android.httpclient.config.MessageConstraints;
import cz.msebera.android.httpclient.entity.BasicHttpEntity;
import cz.msebera.android.httpclient.entity.ContentLengthStrategy;
import cz.msebera.android.httpclient.impl.entity.LaxContentLengthStrategy;
import cz.msebera.android.httpclient.impl.entity.StrictContentLengthStrategy;
import cz.msebera.android.httpclient.impl.io.ChunkedInputStream;
import cz.msebera.android.httpclient.impl.io.ChunkedOutputStream;
import cz.msebera.android.httpclient.impl.io.ContentLengthInputStream;
import cz.msebera.android.httpclient.impl.io.ContentLengthOutputStream;
import cz.msebera.android.httpclient.impl.io.EmptyInputStream;
import cz.msebera.android.httpclient.impl.io.HttpTransportMetricsImpl;
import cz.msebera.android.httpclient.impl.io.IdentityInputStream;
import cz.msebera.android.httpclient.impl.io.IdentityOutputStream;
import cz.msebera.android.httpclient.impl.io.SessionInputBufferImpl;
import cz.msebera.android.httpclient.impl.io.SessionOutputBufferImpl;
import cz.msebera.android.httpclient.io.SessionInputBuffer;
import cz.msebera.android.httpclient.io.SessionOutputBuffer;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.NetUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public class BHttpConnectionBase implements HttpInetConnection {
    private final HttpConnectionMetricsImpl connMetrics;
    private final SessionInputBufferImpl inBuffer;
    private final ContentLengthStrategy incomingContentStrategy;
    private final MessageConstraints messageConstraints;
    private final SessionOutputBufferImpl outbuffer;
    private final ContentLengthStrategy outgoingContentStrategy;
    private final AtomicReference<Socket> socketHolder;

    protected BHttpConnectionBase(int r13, int r14, CharsetDecoder r15, CharsetEncoder r16, MessageConstraints r17, ContentLengthStrategy r18, ContentLengthStrategy r19) {
        Args.positive(r13, "Buffer size");
        HttpTransportMetricsImpl r9 = new HttpTransportMetricsImpl();
        HttpTransportMetricsImpl r10 = new HttpTransportMetricsImpl();
        if (r17 == null) goto L5;
        MessageConstraints r5 = r17;
    L6:
        this.inBuffer = new SessionInputBufferImpl(r9, r13, -1, r5, r15);
        this.outbuffer = new SessionOutputBufferImpl(r10, r13, r14, r16);
        this.messageConstraints = r17;
        this.connMetrics = new HttpConnectionMetricsImpl(r9, r10);
        if (r18 == null) goto L9;
        ContentLengthStrategy r1 = r18;
    L10:
        this.incomingContentStrategy = r1;
        if (r19 == null) goto L13;
        ContentLengthStrategy r2 = r19;
    L14:
        this.outgoingContentStrategy = r2;
        this.socketHolder = new AtomicReference();
        return;
    L13:
        r2 = StrictContentLengthStrategy.INSTANCE;
        goto L14
    L9:
        r1 = LaxContentLengthStrategy.INSTANCE;
        goto L10
    L5:
        r5 = MessageConstraints.DEFAULT;
        goto L6
    }

    protected void ensureOpen() throws IOException {
        Socket r0 = this.socketHolder.get();
        if (r0 == null) goto L12;
        if (this.inBuffer.isBound() == true) goto L8;
        this.inBuffer.bind(getSocketInputStream(r0));
    L8:
        if (this.outbuffer.isBound() == true) goto L13;
        this.outbuffer.bind(getSocketOutputStream(r0));
        return;
    L13:
        return;
    L12:
        throw new ConnectionClosedException();
    }

    protected InputStream getSocketInputStream(Socket r1) throws IOException {
        return r1.getInputStream();
    }

    protected OutputStream getSocketOutputStream(Socket r1) throws IOException {
        return r1.getOutputStream();
    }

    protected void bind(Socket r2) throws IOException {
        Args.notNull(r2, "Socket");
        this.socketHolder.set(r2);
        this.inBuffer.bind(null);
        this.outbuffer.bind(null);
    }

    protected SessionInputBuffer getSessionInputBuffer() {
        return this.inBuffer;
    }

    protected SessionOutputBuffer getSessionOutputBuffer() {
        return this.outbuffer;
    }

    protected void doFlush() throws IOException {
        this.outbuffer.flush();
    }

    @Override // cz.msebera.android.httpclient.HttpConnection
    public boolean isOpen() {
        if (this.socketHolder.get() == null) goto L5;
        return true;
    L5:
        return false;
    }

    protected Socket getSocket() {
        return this.socketHolder.get();
    }

    protected OutputStream createOutputStream(long r3, SessionOutputBuffer r5) {
        if (r3 != (-2)) goto L7;
        return new ChunkedOutputStream(2048, r5);
    L7:
        if (r3 != (-1)) goto L11;
        return new IdentityOutputStream(r5);
    L11:
        return new ContentLengthOutputStream(r5, r3);
    }

    protected OutputStream prepareOutput(HttpMessage r3) throws HttpException {
        return createOutputStream(this.outgoingContentStrategy.determineLength(r3), this.outbuffer);
    }

    protected InputStream createInputStream(long r3, SessionInputBuffer r5) {
        if (r3 != (-2)) goto L7;
        return new ChunkedInputStream(r5, this.messageConstraints);
    L7:
        if (r3 != (-1)) goto L11;
        return new IdentityInputStream(r5);
    L11:
        if (r3 != 0) goto L15;
        return EmptyInputStream.INSTANCE;
    L15:
        return new ContentLengthInputStream(r5, r3);
    }

    protected HttpEntity prepareInput(HttpMessage r8) throws HttpException {
        BasicHttpEntity r0 = new BasicHttpEntity();
        long r1 = this.incomingContentStrategy.determineLength(r8);
        InputStream r7 = createInputStream(r1, this.inBuffer);
        if (r1 != (-2)) goto L6;
        r0.setChunked(true);
        r0.setContentLength(-1);
        r0.setContent(r7);
    L9:
        Header r9 = r8.getFirstHeader("Content-Type");
        if (r9 == null) goto L12;
        r0.setContentType(r9);
    L12:
        Header r10 = r8.getFirstHeader("Content-Encoding");
        if (r10 == null) goto L15;
        r0.setContentEncoding(r10);
    L15:
        return r0;
    L6:
        if (r1 != (-1)) goto L8;
        r0.setChunked(false);
        r0.setContentLength(-1);
        r0.setContent(r7);
        goto L9
    L8:
        r0.setChunked(false);
        r0.setContentLength(r1);
        r0.setContent(r7);
        goto L9
    }

    @Override // cz.msebera.android.httpclient.HttpInetConnection
    public InetAddress getLocalAddress() {
        Socket r0 = this.socketHolder.get();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLocalAddress();
    }

    @Override // cz.msebera.android.httpclient.HttpInetConnection
    public int getLocalPort() {
        Socket r0 = this.socketHolder.get();
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.getLocalPort();
    }

    @Override // cz.msebera.android.httpclient.HttpInetConnection
    public InetAddress getRemoteAddress() {
        Socket r0 = this.socketHolder.get();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getInetAddress();
    }

    @Override // cz.msebera.android.httpclient.HttpInetConnection
    public int getRemotePort() {
        Socket r0 = this.socketHolder.get();
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.getPort();
    }

    @Override // cz.msebera.android.httpclient.HttpConnection
    public void setSocketTimeout(int r1) {
        Socket r0 = this.socketHolder.get();
        if (r0 == null) goto L9;
        r0.setSoTimeout(r1);     // Catch: SocketException -> L6
        return;
    L10:
        return;
    }

    @Override // cz.msebera.android.httpclient.HttpConnection
    public int getSocketTimeout() {
        Socket r1 = this.socketHolder.get();
        if (r1 != null) goto L8;
    L6:
        return -1;
    L8:
        return r1.getSoTimeout();
    }

    @Override // cz.msebera.android.httpclient.HttpConnection
    public void shutdown() throws IOException {
        Socket r2 = this.socketHolder.getAndSet(null);
        if (r2 != null) goto L12;
        return;
    L12:
        r2.setSoLinger(true, 0);     // Catch: IOException -> L11 Throwable -> L7
    L7:
        th = move-exception;
        r2.close();
        throw th;
    L6:
        r2.close();
    }

    @Override // cz.msebera.android.httpclient.HttpConnection, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Socket r0 = this.socketHolder.getAndSet(null);
        if (r0 != null) goto L17;
        return;
    L17:
        this.inBuffer.clear();     // Catch: Throwable -> L8
        this.outbuffer.flush();     // Catch: Throwable -> L8
        r0.shutdownOutput();     // Catch: IOException -> L12 Throwable -> L13 Throwable -> L8
    L6:
        r0.shutdownInput();     // Catch: Throwable -> L13 Throwable -> L8
    L7:
        r0.close();
        return;
    L8:
        th = move-exception;
        r0.close();
        throw th;
    }

    private int fillInputBuffer(int r3) throws IOException {
        Socket r0 = this.socketHolder.get();
        int r1 = r0.getSoTimeout();
        r0.setSoTimeout(r3);     // Catch: Throwable -> L6
        int r2 = this.inBuffer.fillBuffer();     // Catch: Throwable -> L6
        r0.setSoTimeout(r1);
        return r2;
    L6:
        th = move-exception;
        r0.setSoTimeout(r1);
        throw th;
    }

    protected boolean awaitInput(int r2) throws IOException {
        if (this.inBuffer.hasBufferedData() == false) goto L6;
        return true;
    L6:
        fillInputBuffer(r2);
        return this.inBuffer.hasBufferedData();
    }

    @Override // cz.msebera.android.httpclient.HttpConnection
    public boolean isStale() {
        if (isOpen() == true) goto L13;
        return true;
    L13:
        if (fillInputBuffer(1) >= 0) goto L10;
        return true;
    L10:
        return false;
    L11:
        return false;
    L16:
        return true;
    }

    protected void incrementRequestCount() {
        this.connMetrics.incrementRequestCount();
    }

    protected void incrementResponseCount() {
        this.connMetrics.incrementResponseCount();
    }

    @Override // cz.msebera.android.httpclient.HttpConnection
    public HttpConnectionMetrics getMetrics() {
        return this.connMetrics;
    }

    public String toString() {
        Socket r2 = this.socketHolder.get();
        if (r2 == null) goto L10;
        StringBuilder r0 = new StringBuilder();
        SocketAddress r1 = r2.getRemoteSocketAddress();
        SocketAddress r3 = r2.getLocalSocketAddress();
        if (r1 == null) goto L9;
        if (r3 == null) goto L9;
        NetUtils.formatAddress(r0, r3);
        r0.append("<->");
        NetUtils.formatAddress(r0, r1);
    L9:
        return r0.toString();
    L10:
        return "[Not bound]";
    }
}
