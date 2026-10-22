package cz.msebera.android.httpclient.impl;

import cz.msebera.android.httpclient.HttpClientConnection;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.config.MessageConstraints;
import cz.msebera.android.httpclient.entity.ContentLengthStrategy;
import cz.msebera.android.httpclient.impl.io.DefaultHttpRequestWriterFactory;
import cz.msebera.android.httpclient.impl.io.DefaultHttpResponseParserFactory;
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
public class DefaultBHttpClientConnection extends BHttpConnectionBase implements HttpClientConnection {
    private final HttpMessageWriter<HttpRequest> requestWriter;
    private final HttpMessageParser<HttpResponse> responseParser;

    protected void onRequestSubmitted(HttpRequest r1) {
    }

    protected void onResponseReceived(HttpResponse r1) {
    }

    public DefaultBHttpClientConnection(int r1, int r2, CharsetDecoder r3, CharsetEncoder r4, MessageConstraints r5, ContentLengthStrategy r6, ContentLengthStrategy r7, HttpMessageWriterFactory<HttpRequest> r8, HttpMessageParserFactory<HttpResponse> r9) {
        super(r1, r2, r3, r4, r5, r6, r7);
        if (r8 != null) goto L6;
        r8 = DefaultHttpRequestWriterFactory.INSTANCE;
    L6:
        this.requestWriter = r8.create(getSessionOutputBuffer());
        if (r9 != null) goto L10;
        r9 = DefaultHttpResponseParserFactory.INSTANCE;
    L10:
        this.responseParser = r9.create(getSessionInputBuffer(), r5);
    }

    public DefaultBHttpClientConnection(int r11, CharsetDecoder r12, CharsetEncoder r13, MessageConstraints r14) {
        this(r11, r11, r12, r13, r14, null, null, null, null);
    }

    public DefaultBHttpClientConnection(int r11) {
        this(r11, r11, null, null, null, null, null, null, null);
    }

    @Override // cz.msebera.android.httpclient.impl.BHttpConnectionBase
    public void bind(Socket r1) throws IOException {
        super.bind(r1);
    }

    @Override // cz.msebera.android.httpclient.HttpClientConnection
    public boolean isResponseAvailable(int r1) throws IOException {
        ensureOpen();
        return awaitInput(r1);
    L5:
        return false;
    }

    @Override // cz.msebera.android.httpclient.HttpClientConnection
    public void sendRequestHeader(HttpRequest r2) throws HttpException, IOException {
        Args.notNull(r2, "HTTP request");
        ensureOpen();
        this.requestWriter.write(r2);
        onRequestSubmitted(r2);
        incrementRequestCount();
    }

    @Override // cz.msebera.android.httpclient.HttpClientConnection
    public void sendRequestEntity(HttpEntityEnclosingRequest r2) throws HttpException, IOException {
        Args.notNull(r2, "HTTP request");
        ensureOpen();
        HttpEntity r0 = r2.getEntity();
        if (r0 != null) goto L5;
        return;
    L5:
        OutputStream r1 = prepareOutput(r2);
        r0.writeTo(r1);
        r1.close();
    }

    @Override // cz.msebera.android.httpclient.HttpClientConnection
    public HttpResponse receiveResponseHeader() throws HttpException, IOException {
        ensureOpen();
        HttpResponse r0 = (HttpResponse) this.responseParser.parse();
        onResponseReceived(r0);
        if (r0.getStatusLine().getStatusCode() < 200) goto L5;
        incrementResponseCount();
    L5:
        return r0;
    }

    @Override // cz.msebera.android.httpclient.HttpClientConnection
    public void receiveResponseEntity(HttpResponse r2) throws HttpException, IOException {
        Args.notNull(r2, "HTTP response");
        ensureOpen();
        r2.setEntity(prepareInput(r2));
    }

    @Override // cz.msebera.android.httpclient.HttpClientConnection
    public void flush() throws IOException {
        ensureOpen();
        doFlush();
    }
}
