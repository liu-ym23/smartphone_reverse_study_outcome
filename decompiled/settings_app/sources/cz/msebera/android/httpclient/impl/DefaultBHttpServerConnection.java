package cz.msebera.android.httpclient.impl;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpServerConnection;
import cz.msebera.android.httpclient.config.MessageConstraints;
import cz.msebera.android.httpclient.entity.ContentLengthStrategy;
import cz.msebera.android.httpclient.impl.entity.DisallowIdentityContentLengthStrategy;
import cz.msebera.android.httpclient.impl.io.DefaultHttpRequestParserFactory;
import cz.msebera.android.httpclient.impl.io.DefaultHttpResponseWriterFactory;
import cz.msebera.android.httpclient.io.HttpMessageParser;
import cz.msebera.android.httpclient.io.HttpMessageParserFactory;
import cz.msebera.android.httpclient.io.HttpMessageWriter;
import cz.msebera.android.httpclient.io.HttpMessageWriterFactory;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultBHttpServerConnection extends BHttpConnectionBase implements HttpServerConnection {
    private final HttpMessageParser<HttpRequest> requestParser;
    private final HttpMessageWriter<HttpResponse> responseWriter;

    protected void onRequestReceived(HttpRequest r1) {
    }

    protected void onResponseSubmitted(HttpResponse r1) {
    }

    public DefaultBHttpServerConnection(int r10, int r11, CharsetDecoder r12, CharsetEncoder r13, MessageConstraints r14, ContentLengthStrategy r15, ContentLengthStrategy r16, HttpMessageParserFactory<HttpRequest> r17, HttpMessageWriterFactory<HttpResponse> r18) {
        if (r15 == null) goto L5;
        ContentLengthStrategy r6 = r15;
    L6:
        super(r10, r11, r12, r13, r14, r6, r16);
        if (r17 == null) goto L9;
        HttpMessageParserFactory<HttpRequest> r0 = r17;
    L10:
        this.requestParser = r0.create(getSessionInputBuffer(), r14);
        if (r18 == null) goto L13;
        HttpMessageWriterFactory<HttpResponse> r1 = r18;
    L14:
        this.responseWriter = r1.create(getSessionOutputBuffer());
        return;
    L13:
        r1 = DefaultHttpResponseWriterFactory.INSTANCE;
        goto L14
    L9:
        r0 = DefaultHttpRequestParserFactory.INSTANCE;
        goto L10
    L5:
        r6 = DisallowIdentityContentLengthStrategy.INSTANCE;
        goto L6
    }

    public DefaultBHttpServerConnection(int r11, CharsetDecoder r12, CharsetEncoder r13, MessageConstraints r14) {
        this(r11, r11, r12, r13, r14, null, null, null, null);
    }

    public DefaultBHttpServerConnection(int r11) {
        this(r11, r11, null, null, null, null, null, null, null);
    }

    @Override // cz.msebera.android.httpclient.impl.BHttpConnectionBase
    public void bind(Socket r1) throws IOException {
        super.bind(r1);
    }

    @Override // cz.msebera.android.httpclient.HttpServerConnection
    public HttpRequest receiveRequestHeader() throws HttpException, IOException {
        ensureOpen();
        HttpRequest r0 = (HttpRequest) this.requestParser.parse();
        onRequestReceived(r0);
        incrementRequestCount();
        return r0;
    }

    @Override // cz.msebera.android.httpclient.HttpServerConnection
    public void receiveRequestEntity(HttpEntityEnclosingRequest r2) throws HttpException, IOException {
        Args.notNull(r2, "HTTP request");
        ensureOpen();
        r2.setEntity(prepareInput(r2));
    }

    @Override // cz.msebera.android.httpclient.HttpServerConnection
    public void sendResponseHeader(HttpResponse r2) throws HttpException, IOException {
        Args.notNull(r2, "HTTP response");
        ensureOpen();
        this.responseWriter.write(r2);
        onResponseSubmitted(r2);
        if (r2.getStatusLine().getStatusCode() < 200) goto L6;
        incrementResponseCount();
        return;
    }

    @Override // cz.msebera.android.httpclient.HttpServerConnection
    public void sendResponseEntity(HttpResponse r2) throws HttpException, IOException {
        Args.notNull(r2, "HTTP response");
        ensureOpen();
        HttpEntity r0 = r2.getEntity();
        if (r0 != null) goto L5;
        return;
    L5:
        OutputStream r1 = prepareOutput(r2);
        r0.writeTo(r1);
        r1.close();
    }

    @Override // cz.msebera.android.httpclient.HttpServerConnection
    public void flush() throws IOException {
        ensureOpen();
        doFlush();
    }
}
