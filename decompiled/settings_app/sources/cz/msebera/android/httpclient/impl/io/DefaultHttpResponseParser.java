package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpMessage;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpResponseFactory;
import cz.msebera.android.httpclient.NoHttpResponseException;
import cz.msebera.android.httpclient.ParseException;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.config.MessageConstraints;
import cz.msebera.android.httpclient.impl.DefaultHttpResponseFactory;
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
    private final HttpResponseFactory responseFactory;

    @Override // cz.msebera.android.httpclient.impl.io.AbstractMessageParser
    protected /* bridge */ /* synthetic */ HttpMessage parseHead(SessionInputBuffer r1) throws IOException, HttpException, ParseException {
        return parseHead(r1);
    }

    @Deprecated
    public DefaultHttpResponseParser(SessionInputBuffer r1, LineParser r2, HttpResponseFactory r3, HttpParams r4) {
        super(r1, r2, r4);
        this.responseFactory = (HttpResponseFactory) Args.notNull(r3, "Response factory");
        this.lineBuf = new CharArrayBuffer(128);
    }

    public DefaultHttpResponseParser(SessionInputBuffer r1, LineParser r2, HttpResponseFactory r3, MessageConstraints r4) {
        super(r1, r2, r4);
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
    protected HttpResponse parseHead(SessionInputBuffer r3) throws IOException, HttpException, ParseException {
        this.lineBuf.clear();
        if (r3.readLine(this.lineBuf) == (-1)) goto L7;
        ParserCursor r4 = new ParserCursor(0, this.lineBuf.length());
        StatusLine r5 = this.lineParser.parseStatusLine(this.lineBuf, r4);
        return this.responseFactory.newHttpResponse(r5, null);
    L7:
        throw new NoHttpResponseException("The target server failed to respond");
    }
}
