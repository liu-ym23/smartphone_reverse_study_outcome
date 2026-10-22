package cz.msebera.android.httpclient.impl;

import cz.msebera.android.httpclient.HttpClientConnection;
import cz.msebera.android.httpclient.HttpConnectionMetrics;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpResponseFactory;
import cz.msebera.android.httpclient.impl.entity.EntityDeserializer;
import cz.msebera.android.httpclient.impl.entity.EntitySerializer;
import cz.msebera.android.httpclient.impl.entity.LaxContentLengthStrategy;
import cz.msebera.android.httpclient.impl.entity.StrictContentLengthStrategy;
import cz.msebera.android.httpclient.impl.io.DefaultHttpResponseParser;
import cz.msebera.android.httpclient.impl.io.HttpRequestWriter;
import cz.msebera.android.httpclient.io.EofSensor;
import cz.msebera.android.httpclient.io.HttpMessageParser;
import cz.msebera.android.httpclient.io.HttpMessageWriter;
import cz.msebera.android.httpclient.io.HttpTransportMetrics;
import cz.msebera.android.httpclient.io.SessionInputBuffer;
import cz.msebera.android.httpclient.io.SessionOutputBuffer;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.net.SocketTimeoutException;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public abstract class AbstractHttpClientConnection implements HttpClientConnection {
    private final EntityDeserializer entitydeserializer;
    private final EntitySerializer entityserializer;
    private EofSensor eofSensor;
    private SessionInputBuffer inBuffer;
    private HttpConnectionMetricsImpl metrics;
    private SessionOutputBuffer outbuffer;
    private HttpMessageWriter<HttpRequest> requestWriter;
    private HttpMessageParser<HttpResponse> responseParser;

    protected abstract void assertOpen() throws IllegalStateException;

    public AbstractHttpClientConnection() {
        this.inBuffer = null;
        this.outbuffer = null;
        this.eofSensor = null;
        this.responseParser = null;
        this.requestWriter = null;
        this.metrics = null;
        this.entityserializer = createEntitySerializer();
        this.entitydeserializer = createEntityDeserializer();
    }

    protected EntityDeserializer createEntityDeserializer() {
        return new EntityDeserializer(new LaxContentLengthStrategy());
    }

    protected EntitySerializer createEntitySerializer() {
        return new EntitySerializer(new StrictContentLengthStrategy());
    }

    protected HttpResponseFactory createHttpResponseFactory() {
        return DefaultHttpResponseFactory.INSTANCE;
    }

    protected HttpMessageParser<HttpResponse> createResponseParser(SessionInputBuffer r2, HttpResponseFactory r3, HttpParams r4) {
        return new DefaultHttpResponseParser(r2, null, r3, r4);
    }

    protected HttpMessageWriter<HttpRequest> createRequestWriter(SessionOutputBuffer r2, HttpParams r3) {
        return new HttpRequestWriter(r2, null, r3);
    }

    protected HttpConnectionMetricsImpl createConnectionMetrics(HttpTransportMetrics r1, HttpTransportMetrics r2) {
        return new HttpConnectionMetricsImpl(r1, r2);
    }

    protected void init(SessionInputBuffer r2, SessionOutputBuffer r3, HttpParams r4) {
        this.inBuffer = (SessionInputBuffer) Args.notNull(r2, "Input session buffer");
        this.outbuffer = (SessionOutputBuffer) Args.notNull(r3, "Output session buffer");
        if ((r2 instanceof EofSensor) == false) goto L5;
        this.eofSensor = (EofSensor) r2;
    L5:
        this.responseParser = createResponseParser(r2, createHttpResponseFactory(), r4);
        this.requestWriter = createRequestWriter(r3, r4);
        this.metrics = createConnectionMetrics(r2.getMetrics(), r3.getMetrics());
    }

    @Override // cz.msebera.android.httpclient.HttpClientConnection
    public boolean isResponseAvailable(int r1) throws IOException {
        assertOpen();
        return this.inBuffer.isDataAvailable(r1);
    L5:
        return false;
    }

    @Override // cz.msebera.android.httpclient.HttpClientConnection
    public void sendRequestHeader(HttpRequest r2) throws HttpException, IOException {
        Args.notNull(r2, "HTTP request");
        assertOpen();
        this.requestWriter.write(r2);
        this.metrics.incrementRequestCount();
    }

    @Override // cz.msebera.android.httpclient.HttpClientConnection
    public void sendRequestEntity(HttpEntityEnclosingRequest r3) throws HttpException, IOException {
        Args.notNull(r3, "HTTP request");
        assertOpen();
        if (r3.getEntity() != null) goto L5;
        return;
    L5:
        this.entityserializer.serialize(this.outbuffer, r3, r3.getEntity());
    }

    protected void doFlush() throws IOException {
        this.outbuffer.flush();
    }

    @Override // cz.msebera.android.httpclient.HttpClientConnection
    public void flush() throws IOException {
        assertOpen();
        doFlush();
    }

    @Override // cz.msebera.android.httpclient.HttpClientConnection
    public HttpResponse receiveResponseHeader() throws HttpException, IOException {
        assertOpen();
        HttpResponse r0 = (HttpResponse) this.responseParser.parse();
        if (r0.getStatusLine().getStatusCode() < 200) goto L5;
        this.metrics.incrementResponseCount();
    L5:
        return r0;
    }

    @Override // cz.msebera.android.httpclient.HttpClientConnection
    public void receiveResponseEntity(HttpResponse r2) throws HttpException, IOException {
        Args.notNull(r2, "HTTP response");
        assertOpen();
        r2.setEntity(this.entitydeserializer.deserialize(this.inBuffer, r2));
    }

    protected boolean isEof() {
        EofSensor r0 = this.eofSensor;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isEof() == false) goto L7;
        return true;
    }

    @Override // cz.msebera.android.httpclient.HttpConnection
    public boolean isStale() {
        if (isOpen() == true) goto L6;
        return true;
    L6:
        if (isEof() == false) goto L13;
        return true;
    L13:
        this.inBuffer.isDataAvailable(1);     // Catch: IOException -> L10 SocketTimeoutException -> L11
        return isEof();
    L11:
        return false;
    L10:
        return true;
    }

    @Override // cz.msebera.android.httpclient.HttpConnection
    public HttpConnectionMetrics getMetrics() {
        return this.metrics;
    }
}
