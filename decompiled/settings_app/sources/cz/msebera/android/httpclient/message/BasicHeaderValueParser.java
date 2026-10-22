package cz.msebera.android.httpclient.message;

import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.ParseException;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.util.ArrayList;
import java.util.BitSet;

/* JADX INFO: loaded from: classes5.dex */
public class BasicHeaderValueParser implements HeaderValueParser {

    @Deprecated
    public static final BasicHeaderValueParser DEFAULT = null;
    private static final char ELEM_DELIMITER = ',';
    public static final BasicHeaderValueParser INSTANCE = null;
    private static final char PARAM_DELIMITER = ';';
    private static final BitSet TOKEN_DELIMS = null;
    private static final BitSet VALUE_DELIMS = null;
    private final TokenParser tokenParser;

    static {
        DEFAULT = new BasicHeaderValueParser();
        INSTANCE = new BasicHeaderValueParser();
        TOKEN_DELIMS = TokenParser.INIT_BITSET(new int[]{61, 59, 44});
        VALUE_DELIMS = TokenParser.INIT_BITSET(new int[]{59, 44});
    }

    public BasicHeaderValueParser() {
        this.tokenParser = TokenParser.INSTANCE;
    }

    public static HeaderElement[] parseElements(String r3, HeaderValueParser r4) throws ParseException {
        Args.notNull(r3, "Value");
        CharArrayBuffer r0 = new CharArrayBuffer(r3.length());
        r0.append(r3);
        ParserCursor r1 = new ParserCursor(0, r3.length());
        if (r4 != null) goto L7;
        r4 = INSTANCE;
    L7:
        return r4.parseElements(r0, r1);
    }

    @Override // cz.msebera.android.httpclient.message.HeaderValueParser
    public HeaderElement[] parseElements(CharArrayBuffer r4, ParserCursor r5) {
        Args.notNull(r4, "Char array buffer");
        Args.notNull(r5, "Parser cursor");
        ArrayList r0 = new ArrayList();
    L4:
        if (r5.atEnd() == true) goto L11;
        HeaderElement r1 = parseHeaderElement(r4, r5);
        if (r1.getName().isEmpty() == false) goto L9;
        if (r1.getValue() == null) goto L4;
    L9:
        r0.add(r1);
        goto L4
    L11:
        return (HeaderElement[]) r0.toArray(new HeaderElement[r0.size()]);
    }

    public static HeaderElement parseHeaderElement(String r3, HeaderValueParser r4) throws ParseException {
        Args.notNull(r3, "Value");
        CharArrayBuffer r0 = new CharArrayBuffer(r3.length());
        r0.append(r3);
        ParserCursor r1 = new ParserCursor(0, r3.length());
        if (r4 != null) goto L7;
        r4 = INSTANCE;
    L7:
        return r4.parseHeaderElement(r0, r1);
    }

    @Override // cz.msebera.android.httpclient.message.HeaderValueParser
    public HeaderElement parseHeaderElement(CharArrayBuffer r4, ParserCursor r5) {
        Args.notNull(r4, "Char array buffer");
        Args.notNull(r5, "Parser cursor");
        NameValuePair r0 = parseNameValuePair(r4, r5);
        if (r5.atEnd() == false) goto L5;
    L7:
        NameValuePair[] r6 = null;
    L9:
        return createHeaderElement(r0.getName(), r0.getValue(), r6);
    L5:
        if (r4.charAt(r5.getPos() - 1) == ',') goto L7;
        r6 = parseParameters(r4, r5);
        goto L9
    }

    protected HeaderElement createHeaderElement(String r1, String r2, NameValuePair[] r3) {
        return new BasicHeaderElement(r1, r2, r3);
    }

    public static NameValuePair[] parseParameters(String r3, HeaderValueParser r4) throws ParseException {
        Args.notNull(r3, "Value");
        CharArrayBuffer r0 = new CharArrayBuffer(r3.length());
        r0.append(r3);
        ParserCursor r1 = new ParserCursor(0, r3.length());
        if (r4 != null) goto L7;
        r4 = INSTANCE;
    L7:
        return r4.parseParameters(r0, r1);
    }

    @Override // cz.msebera.android.httpclient.message.HeaderValueParser
    public NameValuePair[] parseParameters(CharArrayBuffer r4, ParserCursor r5) {
        Args.notNull(r4, "Char array buffer");
        Args.notNull(r5, "Parser cursor");
        this.tokenParser.skipWhiteSpace(r4, r5);
        ArrayList r0 = new ArrayList();
    L4:
        if (r5.atEnd() == true) goto L8;
        r0.add(parseNameValuePair(r4, r5));
        if (r4.charAt(r5.getPos() - 1) != ',') goto L4;
    L8:
        return (NameValuePair[]) r0.toArray(new NameValuePair[r0.size()]);
    }

    public static NameValuePair parseNameValuePair(String r3, HeaderValueParser r4) throws ParseException {
        Args.notNull(r3, "Value");
        CharArrayBuffer r0 = new CharArrayBuffer(r3.length());
        r0.append(r3);
        ParserCursor r1 = new ParserCursor(0, r3.length());
        if (r4 != null) goto L7;
        r4 = INSTANCE;
    L7:
        return r4.parseNameValuePair(r0, r1);
    }

    @Override // cz.msebera.android.httpclient.message.HeaderValueParser
    public NameValuePair parseNameValuePair(CharArrayBuffer r5, ParserCursor r6) {
        Args.notNull(r5, "Char array buffer");
        Args.notNull(r6, "Parser cursor");
        String r0 = this.tokenParser.parseToken(r5, r6, TOKEN_DELIMS);
        if (r6.atEnd() == true) goto L5;
        char r1 = r5.charAt(r6.getPos());
        r6.updatePos(r6.getPos() + 1);
        if (r1 != '=') goto L9;
        String r7 = this.tokenParser.parseValue(r5, r6, VALUE_DELIMS);
        if (r6.atEnd() == true) goto L14;
        r6.updatePos(r6.getPos() + 1);
    L14:
        return createNameValuePair(r0, r7);
    L9:
        return createNameValuePair(r0, null);
    L5:
        return new BasicNameValuePair(r0, null);
    }

    @Deprecated
    public NameValuePair parseNameValuePair(CharArrayBuffer r6, ParserCursor r7, char[] r8) {
        Args.notNull(r6, "Char array buffer");
        Args.notNull(r7, "Parser cursor");
        BitSet r0 = new BitSet();
        if (r8 == null) goto L7;
        int r1 = r8.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L7;
        r0.set(r8[r2]);
        r2 = r2 + 1;
    L7:
        r0.set(61);
        String r3 = this.tokenParser.parseToken(r6, r7, r0);
        if (r7.atEnd() == true) goto L10;
        char r4 = r6.charAt(r7.getPos());
        r7.updatePos(r7.getPos() + 1);
        if (r4 != '=') goto L14;
        r0.clear(61);
        String r9 = this.tokenParser.parseValue(r6, r7, r0);
        if (r7.atEnd() == true) goto L19;
        r7.updatePos(r7.getPos() + 1);
    L19:
        return createNameValuePair(r3, r9);
    L14:
        return createNameValuePair(r3, null);
    L10:
        return new BasicNameValuePair(r3, null);
    }

    protected NameValuePair createNameValuePair(String r1, String r2) {
        return new BasicNameValuePair(r1, r2);
    }
}
