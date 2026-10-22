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
public class DefaultBHttpServerConnectionFactory implements HttpConnectionFactory<DefaultBHttpServerConnection> {
    public static final DefaultBHttpServerConnectionFactory INSTANCE = null;
    private final ConnectionConfig cconfig;
    private final ContentLengthStrategy incomingContentStrategy;
    private final ContentLengthStrategy outgoingContentStrategy;
    private final HttpMessageParserFactory<HttpRequest> requestParserFactory;
    private final HttpMessageWriterFactory<HttpResponse> responseWriterFactory;

    @Override // cz.msebera.android.httpclient.HttpConnectionFactory
    public /* bridge */ /* synthetic */ HttpConnection createConnection(Socket r1) throws IOException {
        return createConnection(r1);
    }

    static {
        INSTANCE = new DefaultBHttpServerConnectionFactory();
    }

    public DefaultBHttpServerConnectionFactory(ConnectionConfig r1, ContentLengthStrategy r2, ContentLengthStrategy r3, HttpMessageParserFactory<HttpRequest> r4, HttpMessageWriterFactory<HttpResponse> r5) {
        if (r1 != null) goto L6;
        r1 = ConnectionConfig.DEFAULT;
    L6:
        this.cconfig = r1;
        this.incomingContentStrategy = r2;
        this.outgoingContentStrategy = r3;
        this.requestParserFactory = r4;
        this.responseWriterFactory = r5;
    }

    public DefaultBHttpServerConnectionFactory(ConnectionConfig r7, HttpMessageParserFactory<HttpRequest> r8, HttpMessageWriterFactory<HttpResponse> r9) {
        this(r7, null, null, r8, r9);
    }

    public DefaultBHttpServerConnectionFactory(ConnectionConfig r7) {
        this(r7, null, null, null, null);
    }

    public DefaultBHttpServerConnectionFactory() {
        this(null, null, null, null, null);
    }

    @Override // cz.msebera.android.httpclient.HttpConnectionFactory
    public DefaultBHttpServerConnection createConnection(Socket r12) throws IOException {
        DefaultBHttpServerConnection r10 = new DefaultBHttpServerConnection(this.cconfig.getBufferSize(), this.cconfig.getFragmentSizeHint(), ConnSupport.createDecoder(this.cconfig), ConnSupport.createEncoder(this.cconfig), this.cconfig.getMessageConstraints(), this.incomingContentStrategy, this.outgoingContentStrategy, this.requestParserFactory, this.responseWriterFactory);
        r10.bind(r12);
        return r10;
    }
}
