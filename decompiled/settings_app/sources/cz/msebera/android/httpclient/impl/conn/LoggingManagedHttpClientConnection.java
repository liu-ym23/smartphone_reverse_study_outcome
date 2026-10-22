package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.config.MessageConstraints;
import cz.msebera.android.httpclient.entity.ContentLengthStrategy;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.io.HttpMessageParserFactory;
import cz.msebera.android.httpclient.io.HttpMessageWriterFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/* JADX INFO: loaded from: classes5.dex */
class LoggingManagedHttpClientConnection extends DefaultManagedHttpClientConnection {
    private final HttpClientAndroidLog headerLog;
    private final HttpClientAndroidLog log;
    private final Wire wire;

    public LoggingManagedHttpClientConnection(String r13, HttpClientAndroidLog r14, HttpClientAndroidLog r15, HttpClientAndroidLog r16, int r17, int r18, CharsetDecoder r19, CharsetEncoder r20, MessageConstraints r21, ContentLengthStrategy r22, ContentLengthStrategy r23, HttpMessageWriterFactory<HttpRequest> r24, HttpMessageParserFactory<HttpResponse> r25) {
        super(r13, r17, r18, r19, r20, r21, r22, r23, r24, r25);
        this.log = r14;
        this.headerLog = r15;
        this.wire = new Wire(r16, r13);
    }

    @Override // cz.msebera.android.httpclient.impl.BHttpConnectionBase, cz.msebera.android.httpclient.HttpConnection, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (super.isOpen() == true) goto L5;
        return;
    L5:
        if (this.log.isDebugEnabled() == false) goto L7;
        this.log.debug(getId() + ": Close connection");
    L7:
        super.close();
    }

    @Override // cz.msebera.android.httpclient.impl.BHttpConnectionBase, cz.msebera.android.httpclient.HttpConnection
    public void setSocketTimeout(int r4) {
        if (this.log.isDebugEnabled() == false) goto L5;
        this.log.debug(getId() + ": set socket timeout to " + r4);
    L5:
        super.setSocketTimeout(r4);
    }

    @Override // cz.msebera.android.httpclient.impl.conn.DefaultManagedHttpClientConnection, cz.msebera.android.httpclient.impl.BHttpConnectionBase, cz.msebera.android.httpclient.HttpConnection
    public void shutdown() throws IOException {
        if (this.log.isDebugEnabled() == false) goto L5;
        this.log.debug(getId() + ": Shutdown connection");
    L5:
        super.shutdown();
    }

    @Override // cz.msebera.android.httpclient.impl.BHttpConnectionBase
    protected InputStream getSocketInputStream(Socket r2) throws IOException {
        InputStream r3 = super.getSocketInputStream(r2);
        if (this.wire.enabled() == true) goto L5;
        return r3;
    L5:
        return new LoggingInputStream(r3, this.wire);
    }

    @Override // cz.msebera.android.httpclient.impl.BHttpConnectionBase
    protected OutputStream getSocketOutputStream(Socket r2) throws IOException {
        OutputStream r3 = super.getSocketOutputStream(r2);
        if (this.wire.enabled() == true) goto L5;
        return r3;
    L5:
        return new LoggingOutputStream(r3, this.wire);
    }

    @Override // cz.msebera.android.httpclient.impl.DefaultBHttpClientConnection
    protected void onResponseReceived(HttpResponse r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (this.headerLog.isDebugEnabled() == false) goto L10;
        this.headerLog.debug(getId() + " << " + r8.getStatusLine().toString());
        Header[] r9 = r8.getAllHeaders();
        int r0 = r9.length;
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L11;
        this.headerLog.debug(getId() + " << " + r9[r1].toString());
        r1 = r1 + 1;
        goto L6
    L11:
        return;
    }

    @Override // cz.msebera.android.httpclient.impl.DefaultBHttpClientConnection
    protected void onRequestSubmitted(HttpRequest r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (this.headerLog.isDebugEnabled() == false) goto L10;
        this.headerLog.debug(getId() + " >> " + r8.getRequestLine().toString());
        Header[] r9 = r8.getAllHeaders();
        int r0 = r9.length;
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L11;
        this.headerLog.debug(getId() + " >> " + r9[r1].toString());
        r1 = r1 + 1;
        goto L6
    L11:
        return;
    }
}
