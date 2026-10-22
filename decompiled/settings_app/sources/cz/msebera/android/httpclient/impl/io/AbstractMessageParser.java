package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpMessage;
import cz.msebera.android.httpclient.MessageConstraintException;
import cz.msebera.android.httpclient.ParseException;
import cz.msebera.android.httpclient.ProtocolException;
import cz.msebera.android.httpclient.config.MessageConstraints;
import cz.msebera.android.httpclient.io.HttpMessageParser;
import cz.msebera.android.httpclient.io.SessionInputBuffer;
import cz.msebera.android.httpclient.message.BasicLineParser;
import cz.msebera.android.httpclient.message.LineParser;
import cz.msebera.android.httpclient.message.TokenParser;
import cz.msebera.android.httpclient.params.HttpParamConfig;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractMessageParser<T extends HttpMessage> implements HttpMessageParser<T> {
    private static final int HEADERS = 1;
    private static final int HEAD_LINE = 0;
    private final List<CharArrayBuffer> headerLines;
    protected final LineParser lineParser;
    private T message;
    private final MessageConstraints messageConstraints;
    private final SessionInputBuffer sessionBuffer;
    private int state;

    protected abstract T parseHead(SessionInputBuffer r1) throws IOException, HttpException, ParseException;

    @Deprecated
    public AbstractMessageParser(SessionInputBuffer r2, LineParser r3, HttpParams r4) {
        Args.notNull(r2, "Session input buffer");
        Args.notNull(r4, "HTTP parameters");
        this.sessionBuffer = r2;
        this.messageConstraints = HttpParamConfig.getMessageConstraints(r4);
        if (r3 != null) goto L6;
        r3 = BasicLineParser.INSTANCE;
    L6:
        this.lineParser = r3;
        this.headerLines = new ArrayList();
        this.state = 0;
    }

    public AbstractMessageParser(SessionInputBuffer r2, LineParser r3, MessageConstraints r4) {
        this.sessionBuffer = (SessionInputBuffer) Args.notNull(r2, "Session input buffer");
        if (r3 != null) goto L6;
        r3 = BasicLineParser.INSTANCE;
    L6:
        this.lineParser = r3;
        if (r4 != null) goto L10;
        r4 = MessageConstraints.DEFAULT;
    L10:
        this.messageConstraints = r4;
        this.headerLines = new ArrayList();
        this.state = 0;
    }

    public static Header[] parseHeaders(SessionInputBuffer r1, int r2, int r3, LineParser r4) throws HttpException, IOException {
        ArrayList r0 = new ArrayList();
        if (r4 != null) goto L7;
        r4 = BasicLineParser.INSTANCE;
    L7:
        return parseHeaders(r1, r2, r3, r4, r0);
    }

    public static Header[] parseHeaders(SessionInputBuffer r8, int r9, int r10, LineParser r11, List<CharArrayBuffer> r12) throws HttpException, IOException {
        Args.notNull(r8, "Session input buffer");
        Args.notNull(r11, "Line parser");
        Args.notNull(r12, "Header line list");
        CharArrayBuffer r1 = null;
        CharArrayBuffer r2 = null;
    L3:
        if (r1 != null) goto L5;
        r1 = new CharArrayBuffer(64);
    L6:
        int r5 = 0;
        if (r8.readLine(r1) == (-1)) goto L37;
        if (r1.length() < 1) goto L37;
        if (r1.charAt(0) != ' ') goto L14;
    L15:
        if (r2 != null) goto L17;
    L30:
        r12.add(r1);
        r2 = r1;
        r1 = null;
    L31:
        if (r9 <= 0) goto L3;
        if (r12.size() < r9) goto L3;
        throw new MessageConstraintException("Maximum header count exceeded");
    L17:
        if (r5 >= r1.length()) goto L23;
        char r3 = r1.charAt(r5);
        if (r3 == ' ') goto L22;
        if (r3 != '\t') goto L23;
    L22:
        r5 = r5 + 1;
    L23:
        if (r10 > 0) goto L25;
    L29:
        r2.append(TokenParser.SP);
        r2.append(r1, r5, r1.length() - r5);
        goto L31
    L25:
        if ((((r2.length() + 1) + r1.length()) - r5) <= r10) goto L29;
        throw new MessageConstraintException("Maximum line length limit exceeded");
    L14:
        if (r1.charAt(0) != '\t') goto L30;
    L37:
        Header[] r13 = new Header[r12.size()];
    L39:
        if (r5 >= r12.size()) goto L46;
        r13[r5] = r11.parseHeader(r12.get(r5));     // Catch: ParseException -> L43
        r5 = r5 + 1;
    L43:
        e = move-exception;
        throw new ProtocolException(e.getMessage());
    L46:
        return r13;
    L5:
        r1.clear();
        goto L6
    }

    @Override // cz.msebera.android.httpclient.io.HttpMessageParser
    public T parse() throws IOException, HttpException {
        int r0 = this.state;
        if (r0 == 0) goto L15;
        if (r0 != 1) goto L7;
    L10:
        Header[] r1 = parseHeaders(this.sessionBuffer, this.messageConstraints.getMaxHeaderCount(), this.messageConstraints.getMaxLineLength(), this.lineParser, this.headerLines);
        this.message.setHeaders(r1);
        T r2 = this.message;
        this.message = null;
        this.headerLines.clear();
        this.state = 0;
        return r2;
    L7:
        throw new IllegalStateException("Inconsistent parser state");
    L15:
        this.message = (T) parseHead(this.sessionBuffer);     // Catch: ParseException -> L12
        this.state = 1;
    L12:
        e = move-exception;
        throw new ProtocolException(e.getMessage(), e);
    }
}
