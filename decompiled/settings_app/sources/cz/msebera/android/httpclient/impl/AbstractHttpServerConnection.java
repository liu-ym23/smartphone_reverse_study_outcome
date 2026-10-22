package cz.msebera.android.httpclient.impl;

import cz.msebera.android.httpclient.HttpConnectionMetrics;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestFactory;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpServerConnection;
import cz.msebera.android.httpclient.impl.entity.DisallowIdentityContentLengthStrategy;
import cz.msebera.android.httpclient.impl.entity.EntityDeserializer;
import cz.msebera.android.httpclient.impl.entity.EntitySerializer;
import cz.msebera.android.httpclient.impl.entity.LaxContentLengthStrategy;
import cz.msebera.android.httpclient.impl.entity.StrictContentLengthStrategy;
import cz.msebera.android.httpclient.impl.io.DefaultHttpRequestParser;
import cz.msebera.android.httpclient.impl.io.HttpResponseWriter;
import cz.msebera.android.httpclient.io.EofSensor;
import cz.msebera.android.httpclient.io.HttpMessageParser;
import cz.msebera.android.httpclient.io.HttpMessageWriter;
import cz.msebera.android.httpclient.io.HttpTransportMetrics;
import cz.msebera.android.httpclient.io.SessionInputBuffer;
import cz.msebera.android.httpclient.io.SessionOutputBuffer;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public abstract class AbstractHttpServerConnection implements HttpServerConnection {
    private final EntityDeserializer entitydeserializer;
    private final EntitySerializer entityserializer;
    private EofSensor eofSensor;
    private SessionInputBuffer inBuffer;
    private HttpConnectionMetricsImpl metrics;
    private SessionOutputBuffer outbuffer;
    private HttpMessageParser<HttpRequest> requestParser;
    private HttpMessageWriter<HttpResponse> responseWriter;

    protected abstract void assertOpen() throws IllegalStateException;

    public AbstractHttpServerConnection() {
        this.inBuffer = null;
        this.outbuffer = null;
        this.eofSensor = null;
        this.requestParser = null;
        this.responseWriter = null;
        this.metrics = null;
        this.entityserializer = createEntitySerializer();
        this.entitydeserializer = createEntityDeserializer();
    }

    protected EntityDeserializer createEntityDeserializer() {
        return new EntityDeserializer(new DisallowIdentityContentLengthStrategy(new LaxContentLengthStrategy(0)));
    }

    protected EntitySerializer createEntitySerializer() {
        return new EntitySerializer(new StrictContentLengthStrategy());
    }

    protected HttpRequestFactory createHttpRequestFactory() {
        return DefaultHttpRequestFactory.INSTANCE;
    }

    protected HttpMessageParser<HttpRequest> createRequestParser(SessionInputBuffer r2, HttpRequestFactory r3, HttpParams r4) {
        return new DefaultHttpRequestParser(r2, null, r3, r4);
    }

    protected HttpMessageWriter<HttpResponse> createResponseWriter(SessionOutputBuffer r2, HttpParams r3) {
        return new HttpResponseWriter(r2, null, r3);
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
        this.requestParser = createRequestParser(r2, createHttpRequestFactory(), r4);
        this.responseWriter = createResponseWriter(r3, r4);
        this.metrics = createConnectionMetrics(r2.getMetrics(), r3.getMetrics());
    }

    @Override // cz.msebera.android.httpclient.HttpServerConnection
    public HttpRequest receiveRequestHeader() throws HttpException, IOException {
        assertOpen();
        HttpRequest r0 = (HttpRequest) this.requestParser.parse();
        this.metrics.incrementRequestCount();
        return r0;
    }

    @Override // cz.msebera.android.httpclient.HttpServerConnection
    public void receiveRequestEntity(HttpEntityEnclosingRequest r2) throws HttpException, IOException {
        Args.notNull(r2, "HTTP request");
        assertOpen();
        r2.setEntity(this.entitydeserializer.deserialize(this.inBuffer, r2));
    }

    protected void doFlush() throws IOException {
        this.outbuffer.flush();
    }

    @Override // cz.msebera.android.httpclient.HttpServerConnection
    public void flush() throws IOException {
        assertOpen();
        doFlush();
    }

    @Override // cz.msebera.android.httpclient.HttpServerConnection
    public void sendResponseHeader(HttpResponse r2) throws HttpException, IOException {
        Args.notNull(r2, "HTTP response");
        assertOpen();
        this.responseWriter.write(r2);
        if (r2.getStatusLine().getStatusCode() < 200) goto L6;
        this.metrics.incrementResponseCount();
        return;
    }

    @Override // cz.msebera.android.httpclient.HttpServerConnection
    public void sendResponseEntity(HttpResponse r3) throws HttpException, IOException {
        if (r3.getEntity() != null) goto L5;
        return;
    L5:
        this.entityserializer.serialize(this.outbuffer, r3, r3.getEntity());
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
        if (isEof() == false) goto L11;
        return true;
    L11:
        this.inBuffer.isDataAvailable(1);     // Catch: IOException -> L10
        return isEof();
    L10:
        return true;
    }

    @Override // cz.msebera.android.httpclient.HttpConnection
    public HttpConnectionMetrics getMetrics() {
        return this.metrics;
    }
}
