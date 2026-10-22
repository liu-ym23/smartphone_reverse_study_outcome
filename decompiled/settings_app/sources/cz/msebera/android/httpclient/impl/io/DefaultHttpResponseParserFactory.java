package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpResponseFactory;
import cz.msebera.android.httpclient.config.MessageConstraints;
import cz.msebera.android.httpclient.impl.DefaultHttpResponseFactory;
import cz.msebera.android.httpclient.io.HttpMessageParser;
import cz.msebera.android.httpclient.io.HttpMessageParserFactory;
import cz.msebera.android.httpclient.io.SessionInputBuffer;
import cz.msebera.android.httpclient.message.BasicLineParser;
import cz.msebera.android.httpclient.message.LineParser;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultHttpResponseParserFactory implements HttpMessageParserFactory<HttpResponse> {
    public static final DefaultHttpResponseParserFactory INSTANCE = null;
    private final LineParser lineParser;
    private final HttpResponseFactory responseFactory;

    static {
        INSTANCE = new DefaultHttpResponseParserFactory();
    }

    public DefaultHttpResponseParserFactory(LineParser r1, HttpResponseFactory r2) {
        if (r1 != null) goto L6;
        r1 = BasicLineParser.INSTANCE;
    L6:
        this.lineParser = r1;
        if (r2 != null) goto L10;
        r2 = DefaultHttpResponseFactory.INSTANCE;
    L10:
        this.responseFactory = r2;
    }

    public DefaultHttpResponseParserFactory() {
        this(null, null);
    }

    @Override // cz.msebera.android.httpclient.io.HttpMessageParserFactory
    public HttpMessageParser<HttpResponse> create(SessionInputBuffer r3, MessageConstraints r4) {
        return new DefaultHttpResponseParser(r3, this.lineParser, this.responseFactory, r4);
    }
}
