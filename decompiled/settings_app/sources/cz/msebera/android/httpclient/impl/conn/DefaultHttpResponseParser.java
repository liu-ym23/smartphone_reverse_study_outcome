package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpMessage;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpResponseFactory;
import cz.msebera.android.httpclient.NoHttpResponseException;
import cz.msebera.android.httpclient.ParseException;
import cz.msebera.android.httpclient.ProtocolException;
import cz.msebera.android.httpclient.config.MessageConstraints;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.impl.DefaultHttpResponseFactory;
import cz.msebera.android.httpclient.impl.io.AbstractMessageParser;
import cz.msebera.android.httpclient.io.SessionInputBuffer;
import cz.msebera.android.httpclient.message.LineParser;
import cz.msebera.android.httpclient.message.ParserCursor;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultHttpResponseParser extends AbstractMessageParser<HttpResponse> {
    private final CharArrayBuffer lineBuf;
    public HttpClientAndroidLog log;
    private final HttpResponseFactory responseFactory;

    protected boolean reject(CharArrayBuffer r1, int r2) {
        return false;
    }

    @Override // cz.msebera.android.httpclient.impl.io.AbstractMessageParser
    protected /* bridge */ /* synthetic */ HttpMessage parseHead(SessionInputBuffer r1) throws IOException, HttpException, ParseException {
        return parseHead(r1);
    }

    @Deprecated
    public DefaultHttpResponseParser(SessionInputBuffer r1, LineParser r2, HttpResponseFactory r3, HttpParams r4) {
        super(r1, r2, r4);
        this.log = new HttpClientAndroidLog(getClass());
        Args.notNull(r3, "Response factory");
        this.responseFactory = r3;
        this.lineBuf = new CharArrayBuffer(128);
    }

    public DefaultHttpResponseParser(SessionInputBuffer r1, LineParser r2, HttpResponseFactory r3, MessageConstraints r4) {
        super(r1, r2, r4);
        this.log = new HttpClientAndroidLog(getClass());
        if (r3 != null) goto L6;
        r3 = DefaultHttpResponseFactory.INSTANCE;
    L6:
        this.responseFactory = r3;
        this.lineBuf = new CharArrayBuffer(128);
    }

    public DefaultHttpResponseParser(SessionInputBuffer r2, MessageConstraints r3) {
        this(r2, null, null, r3);
    }

    public DefaultHttpResponseParser(SessionInputBuffer r3) {
        this(r3, null, null, MessageConstraints.DEFAULT);
    }

    @Override // cz.msebera.android.httpclient.impl.io.AbstractMessageParser
    protected HttpResponse parseHead(SessionInputBuffer r8) throws IOException, HttpException {
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
        if (reject(this.lineBuf, r1) == true) goto L21;
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
