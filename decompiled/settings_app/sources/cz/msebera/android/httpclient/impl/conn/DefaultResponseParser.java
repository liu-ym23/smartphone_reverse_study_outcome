package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpMessage;
import cz.msebera.android.httpclient.HttpResponseFactory;
import cz.msebera.android.httpclient.NoHttpResponseException;
import cz.msebera.android.httpclient.ProtocolException;
import cz.msebera.android.httpclient.conn.params.ConnConnectionPNames;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.impl.io.AbstractMessageParser;
import cz.msebera.android.httpclient.io.SessionInputBuffer;
import cz.msebera.android.httpclient.message.LineParser;
import cz.msebera.android.httpclient.message.ParserCursor;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class DefaultResponseParser extends AbstractMessageParser<HttpMessage> {
    private final CharArrayBuffer lineBuf;
    public HttpClientAndroidLog log;
    private final int maxGarbageLines;
    private final HttpResponseFactory responseFactory;

    public DefaultResponseParser(SessionInputBuffer r1, LineParser r2, HttpResponseFactory r3, HttpParams r4) {
        super(r1, r2, r4);
        this.log = new HttpClientAndroidLog(getClass());
        Args.notNull(r3, "Response factory");
        this.responseFactory = r3;
        this.lineBuf = new CharArrayBuffer(128);
        this.maxGarbageLines = getMaxGarbageLines(r4);
    }

    protected int getMaxGarbageLines(HttpParams r2) {
        return r2.getIntParameter(ConnConnectionPNames.MAX_STATUS_LINE_GARBAGE, Integer.MAX_VALUE);
    }

    @Override // cz.msebera.android.httpclient.impl.io.AbstractMessageParser
    protected HttpMessage parseHead(SessionInputBuffer r8) throws IOException, HttpException {
        int r1 = 0;
    L3:
        this.lineBuf.clear();
        int r2 = r8.readLine(this.lineBuf);
        if (r2 != (-1)) goto L9;
        if (r1 != 0) goto L9;
        throw new NoHttpResponseException("The target server failed to respond");
    L9:
        ParserCursor r4 = new ParserCursor(0, this.lineBuf.length());
        if (this.lineParser.hasProtocolVersion(this.lineBuf, r4) == true) goto L12;
        if (r2 == (-1)) goto L21;
        if (r1 >= this.maxGarbageLines) goto L21;
        if (this.log.isDebugEnabled() == false) goto L19;
        this.log.debug("Garbage in response: " + this.lineBuf.toString());
    L19:
        r1 = r1 + 1;
    L21:
        throw new ProtocolException("The server failed to respond with a valid HTTP response");
    L12:
        return this.responseFactory.newHttpResponse(this.lineParser.parseStatusLine(this.lineBuf, r4), null);
    }
}
