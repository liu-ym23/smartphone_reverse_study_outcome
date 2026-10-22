package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpMessage;
import cz.msebera.android.httpclient.HttpResponseFactory;
import cz.msebera.android.httpclient.NoHttpResponseException;
import cz.msebera.android.httpclient.ParseException;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.io.SessionInputBuffer;
import cz.msebera.android.httpclient.message.LineParser;
import cz.msebera.android.httpclient.message.ParserCursor;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class HttpResponseParser extends AbstractMessageParser<HttpMessage> {
    private final CharArrayBuffer lineBuf;
    private final HttpResponseFactory responseFactory;

    public HttpResponseParser(SessionInputBuffer r1, LineParser r2, HttpResponseFactory r3, HttpParams r4) {
        super(r1, r2, r4);
        this.responseFactory = (HttpResponseFactory) Args.notNull(r3, "Response factory");
        this.lineBuf = new CharArrayBuffer(128);
    }

    @Override // cz.msebera.android.httpclient.impl.io.AbstractMessageParser
    protected HttpMessage parseHead(SessionInputBuffer r3) throws IOException, HttpException, ParseException {
        this.lineBuf.clear();
        if (r3.readLine(this.lineBuf) == (-1)) goto L7;
        ParserCursor r4 = new ParserCursor(0, this.lineBuf.length());
        StatusLine r5 = this.lineParser.parseStatusLine(this.lineBuf, r4);
        return this.responseFactory.newHttpResponse(r5, null);
    L7:
        throw new NoHttpResponseException("The target server failed to respond");
    }
}
