package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.config.MessageConstraints;
import cz.msebera.android.httpclient.conn.ManagedHttpClientConnection;
import cz.msebera.android.httpclient.entity.ContentLengthStrategy;
import cz.msebera.android.httpclient.impl.DefaultBHttpClientConnection;
import cz.msebera.android.httpclient.io.HttpMessageParserFactory;
import cz.msebera.android.httpclient.io.HttpMessageWriterFactory;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultManagedHttpClientConnection extends DefaultBHttpClientConnection implements ManagedHttpClientConnection, HttpContext {
    private final Map<String, Object> attributes;
    private final String id;
    private volatile boolean shutdown;

    public DefaultManagedHttpClientConnection(String r12, int r13, int r14, CharsetDecoder r15, CharsetEncoder r16, MessageConstraints r17, ContentLengthStrategy r18, ContentLengthStrategy r19, HttpMessageWriterFactory<HttpRequest> r20, HttpMessageParserFactory<HttpResponse> r21) {
        super(r13, r14, r15, r16, r17, r18, r19, r20, r21);
        this.id = r12;
        this.attributes = new ConcurrentHashMap();
    }

    public DefaultManagedHttpClientConnection(String r12, int r13) {
        this(r12, r13, r13, null, null, null, null, null, null, null);
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedHttpClientConnection
    public String getId() {
        return this.id;
    }

    @Override // cz.msebera.android.httpclient.impl.BHttpConnectionBase, cz.msebera.android.httpclient.HttpConnection
    public void shutdown() throws IOException {
        this.shutdown = true;
        super.shutdown();
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

    @Override // cz.msebera.android.httpclient.impl.DefaultBHttpClientConnection, cz.msebera.android.httpclient.impl.BHttpConnectionBase
    public void bind(Socket r2) throws IOException {
        if (this.shutdown == true) goto L6;
        super.bind(r2);
        return;
    L6:
        r2.close();
        throw new InterruptedIOException("Connection already shutdown");
    }

    @Override // cz.msebera.android.httpclient.impl.BHttpConnectionBase, cz.msebera.android.httpclient.conn.ManagedHttpClientConnection
    public Socket getSocket() {
        return super.getSocket();
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedHttpClientConnection
    public SSLSession getSSLSession() {
        Socket r1 = super.getSocket();
        if ((r1 instanceof SSLSocket) == true) goto L7;
        return null;
    L7:
        return ((SSLSocket) r1).getSession();
    }
}
