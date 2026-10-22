package cz.msebera.android.httpclient.impl;

import cz.msebera.android.httpclient.HttpConnection;
import cz.msebera.android.httpclient.HttpConnectionFactory;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.config.ConnectionConfig;
import cz.msebera.android.httpclient.entity.ContentLengthStrategy;
import cz.msebera.android.httpclient.io.HttpMessageParserFactory;
import cz.msebera.android.httpclient.io.HttpMessageWriterFactory;
import java.io.IOException;
import java.net.Socket;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultBHttpClientConnectionFactory implements HttpConnectionFactory<DefaultBHttpClientConnection> {
    public static final DefaultBHttpClientConnectionFactory INSTANCE = null;
    private final ConnectionConfig cconfig;
    private final ContentLengthStrategy incomingContentStrategy;
    private final ContentLengthStrategy outgoingContentStrategy;
    private final HttpMessageWriterFactory<HttpRequest> requestWriterFactory;
    private final HttpMessageParserFactory<HttpResponse> responseParserFactory;

    @Override // cz.msebera.android.httpclient.HttpConnectionFactory
    public /* bridge */ /* synthetic */ HttpConnection createConnection(Socket r1) throws IOException {
        return createConnection(r1);
    }

    static {
        INSTANCE = new DefaultBHttpClientConnectionFactory();
    }

    public DefaultBHttpClientConnectionFactory(ConnectionConfig r1, ContentLengthStrategy r2, ContentLengthStrategy r3, HttpMessageWriterFactory<HttpRequest> r4, HttpMessageParserFactory<HttpResponse> r5) {
        if (r1 != null) goto L6;
        r1 = ConnectionConfig.DEFAULT;
    L6:
        this.cconfig = r1;
        this.incomingContentStrategy = r2;
        this.outgoingContentStrategy = r3;
        this.requestWriterFactory = r4;
        this.responseParserFactory = r5;
    }

    public DefaultBHttpClientConnectionFactory(ConnectionConfig r7, HttpMessageWriterFactory<HttpRequest> r8, HttpMessageParserFactory<HttpResponse> r9) {
        this(r7, null, null, r8, r9);
    }

    public DefaultBHttpClientConnectionFactory(ConnectionConfig r7) {
        this(r7, null, null, null, null);
    }

    public DefaultBHttpClientConnectionFactory() {
        this(null, null, null, null, null);
    }

    @Override // cz.msebera.android.httpclient.HttpConnectionFactory
    public DefaultBHttpClientConnection createConnection(Socket r12) throws IOException {
        DefaultBHttpClientConnection r10 = new DefaultBHttpClientConnection(this.cconfig.getBufferSize(), this.cconfig.getFragmentSizeHint(), ConnSupport.createDecoder(this.cconfig), ConnSupport.createEncoder(this.cconfig), this.cconfig.getMessageConstraints(), this.incomingContentStrategy, this.outgoingContentStrategy, this.requestWriterFactory, this.responseParserFactory);
        r10.bind(r12);
        return r10;
    }
}
