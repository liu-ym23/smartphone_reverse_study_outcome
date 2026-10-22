package com.ss.android.http.legacy.message;

import com.bytedance.frameworks.baselib.network.http.util.CharArrayBuffer;
import com.ss.android.http.legacy.HeaderElement;
import com.ss.android.http.legacy.NameValuePair;
import com.ss.android.http.legacy.protocol.HTTP;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class BasicHeaderValueParser implements HeaderValueParser {
    private static final char[] ALL_DELIMITERS = null;
    public static final BasicHeaderValueParser DEFAULT = null;
    private static final char ELEM_DELIMITER = ',';
    private static final char PARAM_DELIMITER = ';';

    static {
        DEFAULT = new BasicHeaderValueParser();
        ALL_DELIMITERS = new char[]{PARAM_DELIMITER, ELEM_DELIMITER};
    }

    public BasicHeaderValueParser() {
    }

    private static boolean isOneOf(char r3, char[] r4) {
        if (r4 == null) goto L12;
        int r1 = 0;
    L6:
        if (r1 >= r4.length) goto L12;
        if (r3 == r4[r1]) goto L9;
        r1 = r1 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    public static final HeaderElement[] parseElements(String r3, HeaderValueParser r4) {
        if (r3 == null) goto L8;
        if (r4 != null) goto L5;
        r4 = DEFAULT;
    L5:
        CharArrayBuffer r0 = new CharArrayBuffer(r3.length());
        r0.append(r3);
        return r4.parseElements(r0, new ParserCursor(0, r3.length()));
    L8:
        throw new IllegalArgumentException("Value to parse may not be null");
    }

    public static final HeaderElement parseHeaderElement(String r3, HeaderValueParser r4) {
        if (r3 == null) goto L8;
        if (r4 != null) goto L5;
        r4 = DEFAULT;
    L5:
        CharArrayBuffer r0 = new CharArrayBuffer(r3.length());
        r0.append(r3);
        return r4.parseHeaderElement(r0, new ParserCursor(0, r3.length()));
    L8:
        throw new IllegalArgumentException("Value to parse may not be null");
    }

    public static final NameValuePair parseNameValuePair(String r3, HeaderValueParser r4) {
        if (r3 == null) goto L8;
        if (r4 != null) goto L5;
        r4 = DEFAULT;
    L5:
        CharArrayBuffer r0 = new CharArrayBuffer(r3.length());
        r0.append(r3);
        return r4.parseNameValuePair(r0, new ParserCursor(0, r3.length()));
    L8:
        throw new IllegalArgumentException("Value to parse may not be null");
    }

    public static final NameValuePair[] parseParameters(String r3, HeaderValueParser r4) {
        if (r3 == null) goto L8;
        if (r4 != null) goto L5;
        r4 = DEFAULT;
    L5:
        CharArrayBuffer r0 = new CharArrayBuffer(r3.length());
        r0.append(r3);
        return r4.parseParameters(r0, new ParserCursor(0, r3.length()));
    L8:
        throw new IllegalArgumentException("Value to parse may not be null");
    }

    public HeaderElement createHeaderElement(String r1, String r2, NameValuePair[] r3) {
        return new BasicHeaderElement(r1, r2, r3);
    }

    public NameValuePair createNameValuePair(String r1, String r2) {
        return new BasicNameValuePair(r1, r2);
    }

    @Override // com.ss.android.http.legacy.message.HeaderValueParser
    public HeaderElement[] parseElements(CharArrayBuffer r4, ParserCursor r5) {
        if (r4 == null) goto L17;
        if (r5 == null) goto L15;
        ArrayList r0 = new ArrayList();
    L6:
        if (r5.atEnd() == true) goto L13;
        HeaderElement r1 = parseHeaderElement(r4, r5);
        if (r1.getName().length() != 0) goto L11;
        if (r1.getValue() == null) goto L6;
    L11:
        r0.add(r1);
        goto L6
    L13:
        return (HeaderElement[]) r0.toArray(new HeaderElement[r0.size()]);
    L15:
        throw new IllegalArgumentException("Parser cursor may not be null");
    L17:
        throw new IllegalArgumentException("Char array buffer may not be null");
    }

    @Override // com.ss.android.http.legacy.message.HeaderValueParser
    public HeaderElement parseHeaderElement(CharArrayBuffer r4, ParserCursor r5) {
        if (r4 == null) goto L15;
        if (r5 == null) goto L13;
        NameValuePair r0 = parseNameValuePair(r4, r5);
        if (r5.atEnd() == false) goto L7;
    L9:
        NameValuePair[] r6 = null;
    L11:
        return createHeaderElement(r0.getName(), r0.getValue(), r6);
    L7:
        if (r4.charAt(r5.getPos() - 1) == ',') goto L9;
        r6 = parseParameters(r4, r5);
        goto L11
    L13:
        throw new IllegalArgumentException("Parser cursor may not be null");
    L15:
        throw new IllegalArgumentException("Char array buffer may not be null");
    }

    @Override // com.ss.android.http.legacy.message.HeaderValueParser
    public NameValuePair parseNameValuePair(CharArrayBuffer r2, ParserCursor r3) {
        return parseNameValuePair(r2, r3, ALL_DELIMITERS);
    }

    @Override // com.ss.android.http.legacy.message.HeaderValueParser
    public NameValuePair[] parseParameters(CharArrayBuffer r4, ParserCursor r5) {
        if (r4 == null) goto L23;
        if (r5 == null) goto L21;
        int r0 = r5.getPos();
        int r1 = r5.getUpperBound();
    L5:
        if (r0 >= r1) goto L9;
        if (HTTP.isWhitespace(r4.charAt(r0)) == false) goto L9;
        r0 = r0 + 1;
    L9:
        r5.updatePos(r0);
        if (r5.atEnd() == true) goto L12;
        ArrayList r2 = new ArrayList();
    L15:
        if (r5.atEnd() == true) goto L19;
        r2.add(parseNameValuePair(r4, r5));
        if (r4.charAt(r5.getPos() - 1) != ',') goto L15;
    L19:
        return (NameValuePair[]) r2.toArray(new NameValuePair[r2.size()]);
    L12:
        return new NameValuePair[0];
    L21:
        throw new IllegalArgumentException("Parser cursor may not be null");
    L23:
        throw new IllegalArgumentException("Char array buffer may not be null");
    }

    public NameValuePair parseNameValuePair(CharArrayBuffer r13, ParserCursor r14, char[] r15) {
        if (r13 == null) goto L65;
        if (r14 == null) goto L63;
        int r0 = r14.getPos();
        int r1 = r14.getPos();
        int r2 = r14.getUpperBound();
    L5:
        boolean r4 = true;
        if (r0 >= r2) goto L14;
        char r5 = r13.charAt(r0);
        if (r5 == '=') goto L14;
        if (isOneOf(r5, r15) == true) goto L12;
        r0 = r0 + 1;
        goto L5
    L12:
        boolean r6 = true;
    L15:
        if (r0 != r2) goto L17;
        String r3 = r13.substringTrimmed(r1, r2);
        r6 = true;
    L18:
        if (r6 == false) goto L21;
        r14.updatePos(r0);
        return createNameValuePair(r3, null);
    L21:
        int r7 = r0;
        boolean r8 = false;
        boolean r9 = false;
    L23:
        if (r7 >= r2) goto L40;
        char r10 = r13.charAt(r7);
        if (r10 != '\"') goto L28;
        if (r8 == true) goto L28;
        r9 = !r9;
    L28:
        if (r9 == true) goto L33;
        if (r8 == true) goto L33;
        if (isOneOf(r10, r15) == false) goto L33;
    L41:
        if (r0 >= r7) goto L45;
        if (HTTP.isWhitespace(r13.charAt(r0)) == false) goto L45;
        r0 = r0 + 1;
    L45:
        int r16 = r7;
    L46:
        if (r16 <= r0) goto L51;
        if (HTTP.isWhitespace(r13.charAt(r16 - 1)) == false) goto L51;
        r16 = r16 - 1;
    L51:
        if ((r16 - r0) >= 2) goto L53;
    L57:
        String r17 = r13.substring(r0, r16);
        if (r4 == false) goto L60;
        r7 = r7 + 1;
    L60:
        r14.updatePos(r7);
        return createNameValuePair(r3, r17);
    L53:
        if (r13.charAt(r0) != '\"') goto L57;
        if (r13.charAt(r16 - 1) != '\"') goto L57;
        r0 = r0 + 1;
        r16 = r16 - 1;
    L33:
        if (r8 == false) goto L35;
    L34:
        r8 = false;
    L39:
        r7 = r7 + 1;
        goto L23
    L35:
        if (r9 == false) goto L34;
        if (r10 != '\\') goto L34;
        r8 = true;
        goto L39
    L40:
        r4 = r6;
        goto L41
    L17:
        r3 = r13.substringTrimmed(r1, r0);
        r0 = r0 + 1;
    L14:
        r6 = false;
        goto L15
    L63:
        throw new IllegalArgumentException("Parser cursor may not be null");
    L65:
        throw new IllegalArgumentException("Char array buffer may not be null");
    }
}
