package cz.msebera.android.httpclient.message;

import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.util.BitSet;

/* JADX INFO: loaded from: classes5.dex */
public class TokenParser {
    public static final char CR = '\r';
    public static final char DQUOTE = '\"';
    public static final char ESCAPE = '\\';
    public static final char HT = '\t';
    public static final TokenParser INSTANCE = null;
    public static final char LF = '\n';
    public static final char SP = ' ';

    public static boolean isWhitespace(char r1) {
        if (r1 != ' ') goto L5;
    L12:
        return true;
    L5:
        if (r1 == '\t') goto L12;
        if (r1 == '\r') goto L12;
        if (r1 == '\n') goto L12;
        return false;
    }

    public TokenParser() {
    }

    public static BitSet INIT_BITSET(int... r4) {
        BitSet r0 = new BitSet();
        int r1 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0.set(r4[r2]);
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    static {
        INSTANCE = new TokenParser();
    }

    public String parseToken(CharArrayBuffer r6, ParserCursor r7, BitSet r8) {
        StringBuilder r0 = new StringBuilder();
    L3:
        boolean r2 = false;
    L5:
        if (r7.atEnd() == true) goto L20;
        char r3 = r6.charAt(r7.getPos());
        if (r8 == null) goto L12;
        if (r8.get(r3) == true) goto L20;
    L12:
        if (isWhitespace(r3) == false) goto L14;
        skipWhiteSpace(r6, r7);
        r2 = true;
        goto L5
    L14:
        if (r2 == false) goto L18;
        if (r0.length() <= 0) goto L18;
        r0.append(SP);
    L18:
        copyContent(r6, r7, r8, r0);
    L20:
        return r0.toString();
    }

    public String parseValue(CharArrayBuffer r7, ParserCursor r8, BitSet r9) {
        StringBuilder r0 = new StringBuilder();
    L3:
        boolean r2 = false;
    L5:
        if (r8.atEnd() == true) goto L27;
        char r3 = r7.charAt(r8.getPos());
        if (r9 == null) goto L12;
        if (r9.get(r3) == true) goto L27;
    L12:
        if (isWhitespace(r3) == false) goto L15;
        skipWhiteSpace(r7, r8);
        r2 = true;
        goto L5
    L15:
        if (r3 == '\"') goto L16;
        if (r2 == true) goto L23;
    L25:
        copyUnquotedContent(r7, r8, r9, r0);
        goto L3
    L23:
        if (r0.length() <= 0) goto L25;
        r0.append(SP);
        goto L25
    L16:
        if (r2 == true) goto L18;
    L20:
        copyQuotedContent(r7, r8, r0);
        goto L3
    L18:
        if (r0.length() <= 0) goto L20;
        r0.append(SP);
    L27:
        return r0.toString();
    }

    public void skipWhiteSpace(CharArrayBuffer r4, ParserCursor r5) {
        int r3 = r5.getPos();
        int r0 = r5.getPos();
        int r1 = r5.getUpperBound();
    L3:
        if (r0 >= r1) goto L8;
        if (isWhitespace(r4.charAt(r0)) == false) goto L8;
        r3 = r3 + 1;
        r0 = r0 + 1;
    L8:
        r5.updatePos(r3);
    }

    public void copyContent(CharArrayBuffer r5, ParserCursor r6, BitSet r7, StringBuilder r8) {
        int r4 = r6.getPos();
        int r0 = r6.getPos();
        int r1 = r6.getUpperBound();
    L3:
        if (r0 >= r1) goto L12;
        char r2 = r5.charAt(r0);
        if (r7 == null) goto L9;
        if (r7.get(r2) == true) goto L12;
    L9:
        if (isWhitespace(r2) == true) goto L12;
        r4 = r4 + 1;
        r8.append(r2);
        r0 = r0 + 1;
    L12:
        r6.updatePos(r4);
    }

    public void copyUnquotedContent(CharArrayBuffer r5, ParserCursor r6, BitSet r7, StringBuilder r8) {
        int r4 = r6.getPos();
        int r0 = r6.getPos();
        int r1 = r6.getUpperBound();
    L3:
        if (r0 >= r1) goto L14;
        char r2 = r5.charAt(r0);
        if (r7 == null) goto L9;
        if (r7.get(r2) == true) goto L14;
    L9:
        if (isWhitespace(r2) == true) goto L14;
        if (r2 == '\"') goto L14;
        r4 = r4 + 1;
        r8.append(r2);
        r0 = r0 + 1;
    L14:
        r6.updatePos(r4);
    }

    public void copyQuotedContent(CharArrayBuffer r9, ParserCursor r10, StringBuilder r11) {
        if (r10.atEnd() == false) goto L5;
        return;
    L5:
        int r8 = r10.getPos();
        int r0 = r10.getPos();
        int r1 = r10.getUpperBound();
        if (r9.charAt(r8) == '\"') goto L8;
        return;
    L8:
        int r12 = r8 + 1;
        int r2 = r0 + 1;
        boolean r5 = false;
    L9:
        if (r2 >= r1) goto L26;
        char r6 = r9.charAt(r2);
        if (r5 == false) goto L16;
        if (r6 == '\"') goto L15;
        if (r6 == '\\') goto L15;
        r11.append('\\');
    L15:
        r11.append(r6);
        r5 = false;
    L25:
        r2 = r2 + 1;
        r12 = r12 + 1;
        goto L9
    L16:
        if (r6 == '\"') goto L17;
        if (r6 != '\\') goto L21;
        r5 = true;
        goto L25
    L21:
        if (r6 == '\r') goto L25;
        if (r6 == '\n') goto L25;
        r11.append(r6);
        goto L25
    L17:
        r12 = r12 + 1;
    L26:
        r10.updatePos(r12);
    }
}
