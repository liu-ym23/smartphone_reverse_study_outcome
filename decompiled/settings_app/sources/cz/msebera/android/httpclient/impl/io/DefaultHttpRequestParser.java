package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.ConnectionClosedException;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpMessage;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestFactory;
import cz.msebera.android.httpclient.ParseException;
import cz.msebera.android.httpclient.RequestLine;
import cz.msebera.android.httpclient.config.MessageConstraints;
import cz.msebera.android.httpclient.impl.DefaultHttpRequestFactory;
import cz.msebera.android.httpclient.io.SessionInputBuffer;
import cz.msebera.android.httpclient.message.LineParser;
import cz.msebera.android.httpclient.message.ParserCursor;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultHttpRequestParser extends AbstractMessageParser<HttpRequest> {
    private final CharArrayBuffer lineBuf;
    private final HttpRequestFactory requestFactory;

    @Override // cz.msebera.android.httpclient.impl.io.AbstractMessageParser
    protected /* bridge */ /* synthetic */ HttpMessage parseHead(SessionInputBuffer r1) throws IOException, HttpException, ParseException {
        return parseHead(r1);
    }

    @Deprecated
    public DefaultHttpRequestParser(SessionInputBuffer r1, LineParser r2, HttpRequestFactory r3, HttpParams r4) {
        super(r1, r2, r4);
        this.requestFactory = (HttpRequestFactory) Args.notNull(r3, "Request factory");
        this.lineBuf = new CharArrayBuffer(128);
    }

    public DefaultHttpRequestParser(SessionInputBuffer r1, LineParser r2, HttpRequestFactory r3, MessageConstraints r4) {
        super(r1, r2, r4);
        if (r3 != null) goto L6;
        r3 = DefaultHttpRequestFactory.INSTANCE;
    L6:
        this.requestFactory = r3;
        this.lineBuf = new CharArrayBuffer(128);
    }

    public DefaultHttpRequestParser(SessionInputBuffer r2, MessageConstraints r3) {
        this(r2, null, null, r3);
    }

    public DefaultHttpRequestParser(SessionInputBuffer r3) {
        this(r3, null, null, MessageConstraints.DEFAULT);
    }

    @Override // cz.msebera.android.httpclient.impl.io.AbstractMessageParser
    protected HttpRequest parseHead(SessionInputBuffer r3) throws IOException, HttpException, ParseException {
        this.lineBuf.clear();
        if (r3.readLine(this.lineBuf) == (-1)) goto L7;
        ParserCursor r4 = new ParserCursor(0, this.lineBuf.length());
        RequestLine r5 = this.lineParser.parseRequestLine(this.lineBuf, r4);
        return this.requestFactory.newHttpRequest(r5);
    L7:
        throw new ConnectionClosedException("Client closed connection");
    }
}
