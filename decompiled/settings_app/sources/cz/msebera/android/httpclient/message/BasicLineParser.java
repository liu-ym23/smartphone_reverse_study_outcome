package cz.msebera.android.httpclient.message;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.ParseException;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.RequestLine;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.protocol.HTTP;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes5.dex */
public class BasicLineParser implements LineParser {

    @Deprecated
    public static final BasicLineParser DEFAULT = null;
    public static final BasicLineParser INSTANCE = null;
    protected final ProtocolVersion protocol;

    static {
        DEFAULT = new BasicLineParser();
        INSTANCE = new BasicLineParser();
    }

    public BasicLineParser(ProtocolVersion r1) {
        if (r1 != null) goto L6;
        r1 = HttpVersion.HTTP_1_1;
    L6:
        this.protocol = r1;
    }

    public BasicLineParser() {
        this(null);
    }

    public static ProtocolVersion parseProtocolVersion(String r3, LineParser r4) throws ParseException {
        Args.notNull(r3, "Value");
        CharArrayBuffer r0 = new CharArrayBuffer(r3.length());
        r0.append(r3);
        ParserCursor r1 = new ParserCursor(0, r3.length());
        if (r4 != null) goto L7;
        r4 = INSTANCE;
    L7:
        return r4.parseProtocolVersion(r0, r1);
    }

    @Override // cz.msebera.android.httpclient.message.LineParser
    public ProtocolVersion parseProtocolVersion(CharArrayBuffer r13, ParserCursor r14) throws ParseException {
        Args.notNull(r13, "Char array buffer");
        Args.notNull(r14, "Parser cursor");
        String r0 = this.protocol.getProtocol();
        int r1 = r0.length();
        int r2 = r14.getPos();
        int r3 = r14.getUpperBound();
        skipWhitespace(r13, r14);
        int r4 = r14.getPos();
        int r5 = r4 + r1;
        if ((r5 + 4) > r3) goto L36;
        boolean r6 = false;
        int r10 = 0;
        boolean r9 = true;
    L5:
        if (r9 == false) goto L12;
        if (r10 >= r1) goto L12;
        if (r13.charAt(r4 + r10) != r0.charAt(r10)) goto L10;
        r9 = true;
    L11:
        r10 = r10 + 1;
        goto L5
    L10:
        r9 = false;
    L12:
        if (r9 == true) goto L14;
    L17:
        if (r9 == false) goto L34;
        int r7 = r4 + (r1 + 1);
        int r8 = r13.indexOf(46, r7, r3);
        if (r8 == (-1)) goto L32;
        int r11 = Integer.parseInt(r13.substringTrimmed(r7, r8));     // Catch: NumberFormatException -> L29
        int r12 = r8 + 1;
        int r15 = r13.indexOf(32, r12, r3);
        if (r15 != (-1)) goto L37;
        r15 = r3;
    L37:
        int r16 = Integer.parseInt(r13.substringTrimmed(r12, r15));     // Catch: NumberFormatException -> L27
        r14.updatePos(r15);
        return createProtocolVersion(r11, r16);
    L28:
        throw new ParseException("Invalid protocol minor version number: " + r13.substring(r2, r3));
    L30:
        throw new ParseException("Invalid protocol major version number: " + r13.substring(r2, r3));
    L32:
        throw new ParseException("Invalid protocol version number: " + r13.substring(r2, r3));
    L34:
        throw new ParseException("Not a valid protocol version: " + r13.substring(r2, r3));
    L14:
        if (r13.charAt(r5) != '/') goto L16;
        r6 = true;
    L16:
        r9 = r6;
        goto L17
    L36:
        throw new ParseException("Not a valid protocol version: " + r13.substring(r2, r3));
    }

    protected ProtocolVersion createProtocolVersion(int r1, int r2) {
        return this.protocol.forVersion(r1, r2);
    }

    @Override // cz.msebera.android.httpclient.message.LineParser
    public boolean hasProtocolVersion(CharArrayBuffer r8, ParserCursor r9) {
        Args.notNull(r8, "Char array buffer");
        Args.notNull(r9, "Parser cursor");
        int r10 = r9.getPos();
        String r7 = this.protocol.getProtocol();
        int r0 = r7.length();
        boolean r3 = false;
        if (r8.length() >= (r0 + 4)) goto L5;
        return false;
    L5:
        if (r10 >= 0) goto L7;
        r10 = (r8.length() - 4) - r0;
    L13:
        int r1 = r10 + r0;
        if ((r1 + 4) <= r8.length()) goto L16;
        return false;
    L16:
        boolean r4 = true;
        int r5 = 0;
    L17:
        if (r4 == false) goto L24;
        if (r5 >= r0) goto L24;
        if (r8.charAt(r10 + r5) != r7.charAt(r5)) goto L22;
        r4 = true;
    L23:
        r5 = r5 + 1;
        goto L17
    L22:
        r4 = false;
    L24:
        if (r4 == true) goto L26;
        return r4;
    L26:
        if (r8.charAt(r1) != '/') goto L29;
        r3 = true;
    L29:
        return r3;
    L7:
        if (r10 != 0) goto L13;
    L9:
        if (r10 >= r8.length()) goto L13;
        if (HTTP.isWhitespace(r8.charAt(r10)) == false) goto L13;
        r10 = r10 + 1;
        goto L9
    }

    public static RequestLine parseRequestLine(String r3, LineParser r4) throws ParseException {
        Args.notNull(r3, "Value");
        CharArrayBuffer r0 = new CharArrayBuffer(r3.length());
        r0.append(r3);
        ParserCursor r1 = new ParserCursor(0, r3.length());
        if (r4 != null) goto L7;
        r4 = INSTANCE;
    L7:
        return r4.parseRequestLine(r0, r1);
    }

    @Override // cz.msebera.android.httpclient.message.LineParser
    public RequestLine parseRequestLine(CharArrayBuffer r7, ParserCursor r8) throws ParseException {
        Args.notNull(r7, "Char array buffer");
        Args.notNull(r8, "Parser cursor");
        int r1 = r8.getPos();
        int r2 = r8.getUpperBound();
        skipWhitespace(r7, r8);     // Catch: IndexOutOfBoundsException -> L17
        int r3 = r8.getPos();     // Catch: IndexOutOfBoundsException -> L17
        int r5 = r7.indexOf(32, r3, r2);     // Catch: IndexOutOfBoundsException -> L17
        if (r5 < 0) goto L16;
        String r4 = r7.substringTrimmed(r3, r5);     // Catch: IndexOutOfBoundsException -> L17
        r8.updatePos(r5);     // Catch: IndexOutOfBoundsException -> L17
        skipWhitespace(r7, r8);     // Catch: IndexOutOfBoundsException -> L17
        int r6 = r8.getPos();     // Catch: IndexOutOfBoundsException -> L17
        int r9 = r7.indexOf(32, r6, r2);     // Catch: IndexOutOfBoundsException -> L17
        if (r9 < 0) goto L14;
        String r10 = r7.substringTrimmed(r6, r9);     // Catch: IndexOutOfBoundsException -> L17
        r8.updatePos(r9);     // Catch: IndexOutOfBoundsException -> L17
        ProtocolVersion r11 = parseProtocolVersion(r7, r8);     // Catch: IndexOutOfBoundsException -> L17
        skipWhitespace(r7, r8);     // Catch: IndexOutOfBoundsException -> L17
        if (r8.atEnd() == false) goto L12;
        return createRequestLine(r4, r10, r11);
    L12:
        throw new ParseException("Invalid request line: " + r7.substring(r1, r2));     // Catch: IndexOutOfBoundsException -> L17
    L14:
        throw new ParseException("Invalid request line: " + r7.substring(r1, r2));     // Catch: IndexOutOfBoundsException -> L17
    L16:
        throw new ParseException("Invalid request line: " + r7.substring(r1, r2));     // Catch: IndexOutOfBoundsException -> L17
    L18:
        throw new ParseException("Invalid request line: " + r7.substring(r1, r2));
    }

    protected RequestLine createRequestLine(String r1, String r2, ProtocolVersion r3) {
        return new BasicRequestLine(r1, r2, r3);
    }

    public static StatusLine parseStatusLine(String r3, LineParser r4) throws ParseException {
        Args.notNull(r3, "Value");
        CharArrayBuffer r0 = new CharArrayBuffer(r3.length());
        r0.append(r3);
        ParserCursor r1 = new ParserCursor(0, r3.length());
        if (r4 != null) goto L7;
        r4 = INSTANCE;
    L7:
        return r4.parseStatusLine(r0, r1);
    }

    @Override // cz.msebera.android.httpclient.message.LineParser
    public StatusLine parseStatusLine(CharArrayBuffer r8, ParserCursor r9) throws ParseException {
        Args.notNull(r8, "Char array buffer");
        Args.notNull(r9, "Parser cursor");
        int r0 = r9.getPos();
        int r1 = r9.getUpperBound();
        ProtocolVersion r2 = parseProtocolVersion(r8, r9);     // Catch: IndexOutOfBoundsException -> L23
        skipWhitespace(r8, r9);     // Catch: IndexOutOfBoundsException -> L23
        int r10 = r9.getPos();     // Catch: IndexOutOfBoundsException -> L23
        int r3 = r8.indexOf(32, r10, r1);     // Catch: IndexOutOfBoundsException -> L23
        if (r3 >= 0) goto L6;
        r3 = r1;
    L6:
        String r11 = r8.substringTrimmed(r10, r3);     // Catch: IndexOutOfBoundsException -> L23
        int r4 = 0;
    L9:
        if (r4 < r11.length()) goto L11;
        int r12 = Integer.parseInt(r11);     // Catch: NumberFormatException -> L21 IndexOutOfBoundsException -> L23
        if (r3 >= r1) goto L18;
        String r5 = r8.substringTrimmed(r3, r1);     // Catch: IndexOutOfBoundsException -> L23
    L20:
        return createStatusLine(r2, r12, r5);
    L18:
        r5 = "";
        goto L20
    L22:
        throw new ParseException("Status line contains invalid status code: " + r8.substring(r0, r1));     // Catch: IndexOutOfBoundsException -> L23
    L11:
        if (Character.isDigit(r11.charAt(r4)) == false) goto L14;
        r4 = r4 + 1;     // Catch: IndexOutOfBoundsException -> L23
        goto L9
    L14:
        throw new ParseException("Status line contains invalid status code: " + r8.substring(r0, r1));     // Catch: IndexOutOfBoundsException -> L23
    L24:
        throw new ParseException("Invalid status line: " + r8.substring(r0, r1));
    }

    protected StatusLine createStatusLine(ProtocolVersion r1, int r2, String r3) {
        return new BasicStatusLine(r1, r2, r3);
    }

    public static Header parseHeader(String r2, LineParser r3) throws ParseException {
        Args.notNull(r2, "Value");
        CharArrayBuffer r0 = new CharArrayBuffer(r2.length());
        r0.append(r2);
        if (r3 != null) goto L7;
        r3 = INSTANCE;
    L7:
        return r3.parseHeader(r0);
    }

    @Override // cz.msebera.android.httpclient.message.LineParser
    public Header parseHeader(CharArrayBuffer r1) throws ParseException {
        return new BufferedHeader(r1);
    }

    protected void skipWhitespace(CharArrayBuffer r3, ParserCursor r4) {
        int r2 = r4.getPos();
        int r0 = r4.getUpperBound();
    L3:
        if (r2 >= r0) goto L7;
        if (HTTP.isWhitespace(r3.charAt(r2)) == false) goto L7;
        r2 = r2 + 1;
    L7:
        r4.updatePos(r2);
    }
}
