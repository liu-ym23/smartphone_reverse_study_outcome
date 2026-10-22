package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.ConnectionClosedException;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpMessage;
import cz.msebera.android.httpclient.HttpRequestFactory;
import cz.msebera.android.httpclient.ParseException;
import cz.msebera.android.httpclient.RequestLine;
import cz.msebera.android.httpclient.io.SessionInputBuffer;
import cz.msebera.android.httpclient.message.LineParser;
import cz.msebera.android.httpclient.message.ParserCursor;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class HttpRequestParser extends AbstractMessageParser<HttpMessage> {
    private final CharArrayBuffer lineBuf;
    private final HttpRequestFactory requestFactory;

    public HttpRequestParser(SessionInputBuffer r1, LineParser r2, HttpRequestFactory r3, HttpParams r4) {
        super(r1, r2, r4);
        this.requestFactory = (HttpRequestFactory) Args.notNull(r3, "Request factory");
        this.lineBuf = new CharArrayBuffer(128);
    }

    @Override // cz.msebera.android.httpclient.impl.io.AbstractMessageParser
    protected HttpMessage parseHead(SessionInputBuffer r3) throws IOException, HttpException, ParseException {
        this.lineBuf.clear();
        if (r3.readLine(this.lineBuf) == (-1)) goto L7;
        ParserCursor r4 = new ParserCursor(0, this.lineBuf.length());
        RequestLine r5 = this.lineParser.parseRequestLine(this.lineBuf, r4);
        return this.requestFactory.newHttpRequest(r5);
    L7:
        throw new ConnectionClosedException("Client closed connection");
    }
}
