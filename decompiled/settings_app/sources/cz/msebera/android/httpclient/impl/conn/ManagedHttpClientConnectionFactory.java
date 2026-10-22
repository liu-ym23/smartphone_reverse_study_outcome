package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpConnection;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.config.ConnectionConfig;
import cz.msebera.android.httpclient.conn.HttpConnectionFactory;
import cz.msebera.android.httpclient.conn.ManagedHttpClientConnection;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.entity.ContentLengthStrategy;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.impl.entity.LaxContentLengthStrategy;
import cz.msebera.android.httpclient.impl.entity.StrictContentLengthStrategy;
import cz.msebera.android.httpclient.impl.io.DefaultHttpRequestWriterFactory;
import cz.msebera.android.httpclient.io.HttpMessageParserFactory;
import cz.msebera.android.httpclient.io.HttpMessageWriterFactory;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes5.dex */
public class ManagedHttpClientConnectionFactory implements HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> {
    private static final AtomicLong COUNTER = null;
    public static final ManagedHttpClientConnectionFactory INSTANCE = null;
    public HttpClientAndroidLog headerLog;
    private final ContentLengthStrategy incomingContentStrategy;
    public HttpClientAndroidLog log;
    private final ContentLengthStrategy outgoingContentStrategy;
    private final HttpMessageWriterFactory<HttpRequest> requestWriterFactory;
    private final HttpMessageParserFactory<HttpResponse> responseParserFactory;
    public HttpClientAndroidLog wireLog;

    @Override // cz.msebera.android.httpclient.conn.HttpConnectionFactory
    public /* bridge */ /* synthetic */ HttpConnection create(HttpRoute r1, ConnectionConfig r2) {
        return create2(r1, r2);
    }

    static {
        COUNTER = new AtomicLong();
        INSTANCE = new ManagedHttpClientConnectionFactory();
    }

    public ManagedHttpClientConnectionFactory(HttpMessageWriterFactory<HttpRequest> r3, HttpMessageParserFactory<HttpResponse> r4, ContentLengthStrategy r5, ContentLengthStrategy r6) {
        this.log = new HttpClientAndroidLog(DefaultManagedHttpClientConnection.class);
        this.headerLog = new HttpClientAndroidLog("cz.msebera.android.httpclient.headers");
        this.wireLog = new HttpClientAndroidLog("cz.msebera.android.httpclient.wire");
        if (r3 != null) goto L6;
        r3 = DefaultHttpRequestWriterFactory.INSTANCE;
    L6:
        this.requestWriterFactory = r3;
        if (r4 != null) goto L10;
        r4 = DefaultHttpResponseParserFactory.INSTANCE;
    L10:
        this.responseParserFactory = r4;
        if (r5 != null) goto L14;
        r5 = LaxContentLengthStrategy.INSTANCE;
    L14:
        this.incomingContentStrategy = r5;
        if (r6 != null) goto L18;
        r6 = StrictContentLengthStrategy.INSTANCE;
    L18:
        this.outgoingContentStrategy = r6;
    }

    public ManagedHttpClientConnectionFactory(HttpMessageWriterFactory<HttpRequest> r2, HttpMessageParserFactory<HttpResponse> r3) {
        this(r2, r3, null, null);
    }

    public ManagedHttpClientConnectionFactory(HttpMessageParserFactory<HttpResponse> r2) {
        this(null, r2);
    }

    public ManagedHttpClientConnectionFactory() {
        this(null, null);
    }

    /* JADX INFO: renamed from: create, reason: avoid collision after fix types in other method */
    public ManagedHttpClientConnection create2(HttpRoute r21, ConnectionConfig r22) {
        if (r22 == null) goto L5;
        ConnectionConfig r1 = r22;
    L6:
        Charset r2 = r1.getCharset();
        if (r1.getMalformedInputAction() == null) goto L9;
        CodingErrorAction r3 = r1.getMalformedInputAction();
    L11:
        if (r1.getUnmappableInputAction() == null) goto L13;
        CodingErrorAction r4 = r1.getUnmappableInputAction();
    L14:
        if (r2 == null) goto L16;
        CharsetDecoder r5 = r2.newDecoder();
        r5.onMalformedInput(r3);
        r5.onUnmappableCharacter(r4);
        CharsetEncoder r6 = r2.newEncoder();
        r6.onMalformedInput(r3);
        r6.onUnmappableCharacter(r4);
        CharsetEncoder r14 = r6;
        CharsetDecoder r13 = r5;
    L18:
        return new LoggingManagedHttpClientConnection("http-outgoing-" + Long.toString(COUNTER.getAndIncrement()), this.log, this.headerLog, this.wireLog, r1.getBufferSize(), r1.getFragmentSizeHint(), r13, r14, r1.getMessageConstraints(), this.incomingContentStrategy, this.outgoingContentStrategy, this.requestWriterFactory, this.responseParserFactory);
    L16:
        r13 = null;
        r14 = null;
        goto L18
    L13:
        r4 = CodingErrorAction.REPORT;
        goto L14
    L9:
        r3 = CodingErrorAction.REPORT;
        goto L11
    L5:
        r1 = ConnectionConfig.DEFAULT;
        goto L6
    }
}
