package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestFactory;
import cz.msebera.android.httpclient.config.MessageConstraints;
import cz.msebera.android.httpclient.impl.DefaultHttpRequestFactory;
import cz.msebera.android.httpclient.io.HttpMessageParser;
import cz.msebera.android.httpclient.io.HttpMessageParserFactory;
import cz.msebera.android.httpclient.io.SessionInputBuffer;
import cz.msebera.android.httpclient.message.BasicLineParser;
import cz.msebera.android.httpclient.message.LineParser;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultHttpRequestParserFactory implements HttpMessageParserFactory<HttpRequest> {
    public static final DefaultHttpRequestParserFactory INSTANCE = null;
    private final LineParser lineParser;
    private final HttpRequestFactory requestFactory;

    static {
        INSTANCE = new DefaultHttpRequestParserFactory();
    }

    public DefaultHttpRequestParserFactory(LineParser r1, HttpRequestFactory r2) {
        if (r1 != null) goto L6;
        r1 = BasicLineParser.INSTANCE;
    L6:
        this.lineParser = r1;
        if (r2 != null) goto L10;
        r2 = DefaultHttpRequestFactory.INSTANCE;
    L10:
        this.requestFactory = r2;
    }

    public DefaultHttpRequestParserFactory() {
        this(null, null);
    }

    @Override // cz.msebera.android.httpclient.io.HttpMessageParserFactory
    public HttpMessageParser<HttpRequest> create(SessionInputBuffer r3, MessageConstraints r4) {
        return new DefaultHttpRequestParser(r3, this.lineParser, this.requestFactory, r4);
    }
}
