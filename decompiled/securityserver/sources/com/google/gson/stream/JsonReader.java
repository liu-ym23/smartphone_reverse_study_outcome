package com.google.gson.stream;

import a.a;
import com.google.gson.internal.JsonReaderInternalAccess;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class JsonReader implements Closeable {
    private static final long MIN_INCOMPLETE_INTEGER = -922337203685477580L;
    private static final int NUMBER_CHAR_DECIMAL = 3;
    private static final int NUMBER_CHAR_DIGIT = 2;
    private static final int NUMBER_CHAR_EXP_DIGIT = 7;
    private static final int NUMBER_CHAR_EXP_E = 5;
    private static final int NUMBER_CHAR_EXP_SIGN = 6;
    private static final int NUMBER_CHAR_FRACTION_DIGIT = 4;
    private static final int NUMBER_CHAR_NONE = 0;
    private static final int NUMBER_CHAR_SIGN = 1;
    private static final int PEEKED_BEGIN_ARRAY = 3;
    private static final int PEEKED_BEGIN_OBJECT = 1;
    private static final int PEEKED_BUFFERED = 11;
    private static final int PEEKED_DOUBLE_QUOTED = 9;
    private static final int PEEKED_DOUBLE_QUOTED_NAME = 13;
    private static final int PEEKED_END_ARRAY = 4;
    private static final int PEEKED_END_OBJECT = 2;
    private static final int PEEKED_EOF = 17;
    private static final int PEEKED_FALSE = 6;
    private static final int PEEKED_LONG = 15;
    private static final int PEEKED_NONE = 0;
    private static final int PEEKED_NULL = 7;
    private static final int PEEKED_NUMBER = 16;
    private static final int PEEKED_SINGLE_QUOTED = 8;
    private static final int PEEKED_SINGLE_QUOTED_NAME = 12;
    private static final int PEEKED_TRUE = 5;
    private static final int PEEKED_UNQUOTED = 10;
    private static final int PEEKED_UNQUOTED_NAME = 14;
    private final char[] buffer;
    private final Reader in;
    private boolean lenient;
    private int limit;
    private int lineNumber;
    private int lineStart;
    private int[] pathIndices;
    private String[] pathNames;
    int peeked;
    private long peekedLong;
    private int peekedNumberLength;
    private String peekedString;
    private int pos;
    private int[] stack;
    private int stackSize;

    static {
        JsonReaderInternalAccess.INSTANCE = new AnonymousClass1();
    }

    public JsonReader(Reader r5) {
        this.lenient = false;
        this.buffer = new char[1024];
        this.pos = 0;
        this.limit = 0;
        this.lineNumber = 0;
        this.lineStart = 0;
        this.peeked = 0;
        int[] r2 = new int[32];
        this.stack = r2;
        this.stackSize = 1;
        r2[0] = 6;
        this.pathNames = new String[32];
        this.pathIndices = new int[32];
        if (r5 == null) goto L7;
        this.in = r5;
        return;
    L7:
        throw new NullPointerException("in == null");
    }

    private void checkLenient() {
        if (this.lenient == false) goto L6;
        return;
    L6:
        throw syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
    }

    private void consumeNonExecutePrefix() {
        nextNonWhitespace(true);
        int r0 = this.pos;
        int r1 = r0 - 1;
        this.pos = r1;
        if ((r0 + 4) > this.limit) goto L5;
    L7:
        char[] r2 = this.buffer;
        if (r2[r1] == ')') goto L10;
        return;
    L10:
        if (r2[r0] == ']') goto L12;
        return;
    L12:
        if (r2[r0 + 1] == '}') goto L14;
        return;
    L14:
        if (r2[r0 + 2] == '\'') goto L16;
        return;
    L16:
        if (r2[r0 + 3] != '\n') goto L24;
        this.pos += 5;
        return;
    L24:
        return;
    L5:
        if (fillBuffer(5) == true) goto L7;
    }

    private boolean fillBuffer(int r8) {
        char[] r0 = this.buffer;
        int r1 = this.lineStart;
        int r2 = this.pos;
        this.lineStart = r1 - r2;
        int r3 = this.limit;
        if (r3 == r2) goto L5;
        int r4 = r3 - r2;
        this.limit = r4;
        System.arraycopy(r0, r2, r0, 0, r4);
    L6:
        this.pos = 0;
    L7:
        Reader r5 = this.in;
        int r6 = this.limit;
        int r7 = r5.read(r0, r6, r0.length - r6);
        if (r7 == (-1)) goto L19;
        int r9 = this.limit + r7;
        this.limit = r9;
        if (this.lineNumber != 0) goto L17;
        int r10 = this.lineStart;
        if (r10 != 0) goto L17;
        if (r9 <= 0) goto L17;
        if (r0[0] != 65279) goto L17;
        this.pos++;
        this.lineStart = r10 + 1;
        r8 = r8 + 1;
    L17:
        if (r9 < r8) goto L7;
        return true;
    L19:
        return false;
    L5:
        this.limit = 0;
        goto L6
    }

    private boolean isLiteral(char r2) {
        if (r2 != '\t') goto L5;
        return false;
    L5:
        if (r2 != '\n') goto L7;
        return false;
    L7:
        if (r2 != '\f') goto L9;
        return false;
    L9:
        if (r2 != '\r') goto L11;
        return false;
    L11:
        if (r2 != ' ') goto L13;
        return false;
    L13:
        if (r2 != '#') goto L15;
    L31:
        checkLenient();
        return false;
    L15:
        if (r2 != ',') goto L17;
        return false;
    L17:
        if (r2 == '/') goto L31;
        if (r2 == '=') goto L31;
        if (r2 != '{') goto L23;
        return false;
    L23:
        if (r2 != '}') goto L25;
        return false;
    L25:
        if (r2 != ':') goto L27;
        return false;
    L27:
        if (r2 == ';') goto L31;
        switch(r2) {
            case 91: goto L43;
            case 92: goto L31;
            case 93: goto L43;
            default: goto L29;
        };
    L29:
        return true;
    L43:
        return false;
    }

    private int nextNonWhitespace(boolean r9) {
        char[] r0 = this.buffer;
        int r1 = this.pos;
        int r2 = this.limit;
    L4:
        if (r1 != r2) goto L13;
        this.pos = r1;
        if (fillBuffer(1) == false) goto L7;
        r1 = this.pos;
        r2 = this.limit;
        goto L13
    L7:
        if (r9 == true) goto L11;
        return -1;
    L11:
        throw new EOFException("End of input" + locationString());
    L13:
        int r4 = r1 + 1;
        char r5 = r0[r1];
        if (r5 == '\n') goto L15;
        if (r5 == ' ') goto L45;
        if (r5 == '\r') goto L45;
        if (r5 == '\t') goto L45;
        if (r5 == '/') goto L25;
        if (r5 != '#') goto L43;
        this.pos = r4;
        checkLenient();
        skipToEndOfLine();
        r1 = this.pos;
        r2 = this.limit;
        goto L4
    L43:
        this.pos = r4;
        return r5;
    L25:
        this.pos = r4;
        if (r4 != r2) goto L30;
        this.pos = r1;
        boolean r3 = fillBuffer(2);
        this.pos++;
        if (r3 == true) goto L30;
        return r5;
    L30:
        checkLenient();
        int r6 = this.pos;
        char r7 = r0[r6];
        if (r7 != '*') goto L32;
        this.pos = r6 + 1;
        if (skipTo("*/") == false) goto L39;
        r1 = this.pos + 2;
        r2 = this.limit;
        goto L4
    L39:
        throw syntaxError("Unterminated comment");
    L32:
        if (r7 != '/') goto L33;
        this.pos = r6 + 1;
        skipToEndOfLine();
        r1 = this.pos;
        r2 = this.limit;
        goto L4
    L33:
        return r5;
    L45:
        r1 = r4;
        goto L4
    L15:
        this.lineNumber++;
        this.lineStart = r4;
        goto L45
    }

    private String nextQuotedValue(char r10) {
        char[] r0 = this.buffer;
        StringBuilder r1 = null;
    L3:
        int r2 = this.pos;
        int r3 = this.limit;
    L4:
        int r4 = r3;
        int r5 = r2;
    L6:
        if (r2 >= r4) goto L25;
        int r7 = r2 + 1;
        char r6 = r0[r2];
        if (r6 == r10) goto L9;
        if (r6 == '\\') goto L17;
        if (r6 != '\n') goto L24;
        this.lineNumber++;
        this.lineStart = r7;
    L24:
        r2 = r7;
        goto L6
    L17:
        this.pos = r7;
        int r8 = r7 - r5;
        int r9 = r8 - 1;
        if (r1 != null) goto L20;
        r1 = new StringBuilder(Math.max(r8 * 2, 16));
    L20:
        r1.append(r0, r5, r9);
        r1.append(readEscapeCharacter());
        r2 = this.pos;
        r3 = this.limit;
        goto L4
    L9:
        this.pos = r7;
        int r11 = (r7 - r5) - 1;
        if (r1 == null) goto L12;
        r1.append(r0, r5, r11);
        return r1.toString();
    L12:
        return new String(r0, r5, r11);
    L25:
        if (r1 != null) goto L27;
        r1 = new StringBuilder(Math.max((r2 - r5) * 2, 16));
    L27:
        r1.append(r0, r5, r2 - r5);
        this.pos = r2;
        if (fillBuffer(1) == true) goto L3;
        throw syntaxError("Unterminated string");
    }

    private String nextUnquotedValue() {
        StringBuilder r0 = null;
        int r1 = 0;
    L3:
        int r2 = 0;
    L4:
        int r3 = this.pos;
        if ((r3 + r2) < this.limit) goto L6;
        if (r2 >= this.buffer.length) goto L41;
        if (fillBuffer(r2 + 1) == true) goto L4;
    L40:
        r1 = r2;
    L45:
        if (r0 != null) goto L47;
        String r4 = new String(this.buffer, this.pos, r1);
    L48:
        this.pos += r1;
        return r4;
    L47:
        r0.append(this.buffer, this.pos, r1);
        r4 = r0.toString();
        goto L48
    L41:
        if (r0 != null) goto L43;
        r0 = new StringBuilder(Math.max(r2, 16));
    L43:
        r0.append(this.buffer, this.pos, r2);
        this.pos += r2;
        if (fillBuffer(1) == true) goto L3;
    L6:
        char r5 = this.buffer[r3 + r2];
        if (r5 == '\t') goto L40;
        if (r5 == '\n') goto L40;
        if (r5 == '\f') goto L40;
        if (r5 == '\r') goto L40;
        if (r5 == ' ') goto L40;
        if (r5 == '#') goto L34;
        if (r5 == ',') goto L40;
        if (r5 == '/') goto L34;
        if (r5 == '=') goto L34;
        if (r5 == '{') goto L40;
        if (r5 == '}') goto L40;
        if (r5 == ':') goto L40;
        if (r5 == ';') goto L34;
        switch(r5) {
            case 91: goto L40;
            case 92: goto L34;
            case 93: goto L40;
            default: goto L33;
        };
    L33:
        r2 = r2 + 1;
    L34:
        checkLenient();
        goto L40
    }

    private int peekKeyword() {
        char r0 = this.buffer[this.pos];
        if (r0 != 't') goto L5;
    L20:
        String r1 = "true";
        String r2 = "TRUE";
        int r3 = 5;
    L21:
        int r4 = r1.length();
        int r5 = 1;
    L22:
        if (r5 >= r4) goto L35;
        if ((this.pos + r5) >= this.limit) goto L26;
    L28:
        char r6 = this.buffer[this.pos + r5];
        if (r6 == r1.charAt(r5)) goto L33;
        if (r6 == r2.charAt(r5)) goto L33;
        return 0;
    L33:
        r5 = r5 + 1;
        goto L22
    L26:
        if (fillBuffer(r5 + 1) == true) goto L28;
        return 0;
    L35:
        if ((this.pos + r4) < this.limit) goto L39;
        if (fillBuffer(r4 + 1) == true) goto L39;
    L41:
        this.pos += r4;
        this.peeked = r3;
        return r3;
    L39:
        if (isLiteral(this.buffer[this.pos + r4]) == false) goto L41;
        return 0;
    L5:
        if (r0 == 'T') goto L20;
        if (r0 != 'f') goto L10;
    L19:
        r1 = "false";
        r2 = "FALSE";
        r3 = 6;
        goto L21
    L10:
        if (r0 == 'F') goto L19;
        if (r0 != 'n') goto L15;
    L18:
        r1 = "null";
        r2 = "NULL";
        r3 = 7;
        goto L21
    L15:
        if (r0 == 'N') goto L18;
        return 0;
    }

    private int peekNumber() {
        char[] r1 = this.buffer;
        int r2 = this.pos;
        int r3 = this.limit;
        int r6 = 0;
        int r8 = 0;
        char r9 = 0;
        boolean r13 = false;
        boolean r10 = true;
        long r11 = 0;
    L4:
        if ((r2 + r8) == r3) goto L6;
    L12:
        char r14 = r1[r2 + r8];
        if (r14 != '+') goto L15;
        char r4 = 6;
        r6 = 0;
        if (r9 != 5) goto L101;
    L82:
        r9 = r4;
    L100:
        r8 = r8 + 1;
        goto L4
    L101:
        return 0;
    L15:
        if (r14 != 'E') goto L17;
    L90:
        r6 = 0;
        if (r9 != 2) goto L93;
    L96:
        r9 = 5;
        goto L100
    L93:
        if (r9 == 4) goto L96;
        return 0;
    L17:
        if (r14 == 'e') goto L90;
        if (r14 == '-') goto L84;
        r4 = 3;
        if (r14 != '.') goto L23;
        r6 = 0;
        if (r9 == 2) goto L82;
        return 0;
    L23:
        if (r14 < '0') goto L54;
        if (r14 > '9') goto L54;
        if (r9 == 1) goto L52;
        if (r9 == 0) goto L52;
        if (r9 == 2) goto L32;
        if (r9 != 3) goto L48;
        r6 = 0;
        r9 = 4;
        goto L100
    L48:
        if (r9 != 5) goto L50;
    L51:
        r6 = 0;
        r9 = 7;
        goto L100
    L50:
        if (r9 == 6) goto L51;
    L44:
        r6 = 0;
        goto L100
    L32:
        if (r11 == 0) goto L33;
        long r5 = (10 * r11) - ((long) (r14 - '0'));
        if (r11 > (-922337203685477580L)) goto L42;
        if (r11 == (-922337203685477580L)) goto L39;
    L41:
        boolean r7 = false;
    L43:
        r10 = r10 & r7;
        r11 = r5;
        goto L44
    L39:
        if (r5 >= r11) goto L41;
    L42:
        r7 = true;
        goto L43
    L33:
        return 0;
    L52:
        r11 = -(r14 - '0');
        r9 = 2;
    L54:
        if (isLiteral(r14) == true) goto L78;
    L55:
        if (r9 != 2) goto L68;
        if (r10 == false) goto L68;
        if (r11 != Long.MIN_VALUE) goto L61;
        if (r13 == false) goto L68;
    L61:
        if (r11 != 0) goto L63;
        if (r13 == true) goto L68;
    L63:
        if (r13 == true) goto L66;
        r11 = -r11;
    L66:
        this.peekedLong = r11;
        this.pos += r8;
        this.peeked = 15;
        return 15;
    L68:
        if (r9 != 2) goto L70;
    L76:
        this.peekedNumberLength = r8;
        this.peeked = 16;
        return 16;
    L70:
        if (r9 == 4) goto L76;
        if (r9 == 7) goto L76;
        return 0;
    L78:
        return 0;
    L84:
        r4 = 6;
        r6 = 0;
        if (r9 != 0) goto L87;
        r9 = 1;
        r13 = true;
        goto L100
    L87:
        if (r9 == 5) goto L82;
        return 0;
    L6:
        if (r8 == r1.length) goto L7;
        if (fillBuffer(r8 + 1) == false) goto L55;
        r2 = this.pos;
        r3 = this.limit;
        goto L12
    L7:
        return r6;
    }

    private void push(int r4) {
        int r0 = this.stackSize;
        int[] r1 = this.stack;
        if (r0 != r1.length) goto L5;
        int r2 = r0 * 2;
        this.stack = Arrays.copyOf(r1, r2);
        this.pathIndices = Arrays.copyOf(this.pathIndices, r2);
        this.pathNames = (String[]) Arrays.copyOf(this.pathNames, r2);
    L5:
        int[] r3 = this.stack;
        int r5 = this.stackSize;
        this.stackSize = r5 + 1;
        r3[r5] = r4;
    }

    private char readEscapeCharacter() {
        if (this.pos == this.limit) goto L5;
    L9:
        char[] r0 = this.buffer;
        int r1 = this.pos;
        int r4 = r1 + 1;
        this.pos = r4;
        char r2 = r0[r1];
        if (r2 != '\n') goto L12;
        this.lineNumber++;
        this.lineStart = r4;
    L72:
        return r2;
    L12:
        if (r2 == '\"') goto L72;
        if (r2 == '\'') goto L72;
        if (r2 == '/') goto L72;
        if (r2 == '\\') goto L72;
        if (r2 != 'b') goto L22;
        return '\b';
    L22:
        if (r2 != 'f') goto L24;
        return '\f';
    L24:
        if (r2 != 'n') goto L26;
        return '\n';
    L26:
        if (r2 != 'r') goto L28;
        return '\r';
    L28:
        if (r2 != 't') goto L30;
        return '\t';
    L30:
        if (r2 != 'u') goto L61;
        if ((r1 + 5) > this.limit) goto L34;
    L38:
        int r3 = this.pos;
        int r5 = r3 + 4;
        char r6 = 0;
    L39:
        if (r3 >= r5) goto L58;
        char r7 = this.buffer[r3];
        char r8 = (char) (r6 << 4);
        if (r7 < '0') goto L47;
        if (r7 > '9') goto L47;
        int r9 = r7 - '0';
    L45:
        r6 = (char) (r9 + r8);
        r3 = r3 + 1;
    L47:
        if (r7 < 'a') goto L51;
        if (r7 > 'f') goto L51;
        r9 = r7 - 'W';
    L51:
        if (r7 < 'A') goto L57;
        if (r7 > 'F') goto L57;
        r9 = r7 - '7';
    L57:
        throw new NumberFormatException("\\u".concat(new String(this.buffer, this.pos, 4)));
    L58:
        this.pos += 4;
        return r6;
    L34:
        if (fillBuffer(4) == true) goto L38;
        throw syntaxError("Unterminated escape sequence");
    L61:
        throw syntaxError("Invalid escape sequence");
    L5:
        if (fillBuffer(1) == true) goto L9;
        throw syntaxError("Unterminated escape sequence");
    }

    private void skipQuotedValue(char r7) {
        char[] r0 = this.buffer;
    L3:
        int r1 = this.pos;
        int r2 = this.limit;
    L5:
        if (r1 >= r2) goto L17;
        int r4 = r1 + 1;
        char r3 = r0[r1];
        if (r3 == r7) goto L8;
        if (r3 == '\\') goto L12;
        if (r3 != '\n') goto L16;
        this.lineNumber++;
        this.lineStart = r4;
    L16:
        r1 = r4;
        goto L5
    L12:
        this.pos = r4;
        readEscapeCharacter();
        r1 = this.pos;
        r2 = this.limit;
        goto L5
    L8:
        this.pos = r4;
        return;
    L17:
        this.pos = r1;
        if (fillBuffer(1) == true) goto L3;
        throw syntaxError("Unterminated string");
    }

    private boolean skipTo(String r7) {
        int r0 = r7.length();
    L3:
        int r3 = 0;
        if ((this.pos + r0) > this.limit) goto L6;
    L9:
        char[] r1 = this.buffer;
        int r2 = this.pos;
        if (r1[r2] != '\n') goto L12;
        this.lineNumber++;
        this.lineStart = r2 + 1;
    L15:
        this.pos++;
    L12:
        if (r3 >= r0) goto L17;
        if (this.buffer[this.pos + r3] != r7.charAt(r3)) goto L15;
        r3 = r3 + 1;
        goto L12
    L17:
        return true;
    L6:
        if (fillBuffer(r0) == true) goto L9;
        return false;
    }

    private void skipToEndOfLine() {
    L3:
        if (this.pos >= this.limit) goto L5;
    L6:
        char[] r0 = this.buffer;
        int r1 = this.pos;
        int r3 = r1 + 1;
        this.pos = r3;
        char r2 = r0[r1];
        if (r2 == '\n') goto L8;
        if (r2 != '\r') goto L3;
        return;
    L8:
        this.lineNumber++;
        this.lineStart = r3;
        return;
    L5:
        if (fillBuffer(1) == true) goto L6;
    }

    private void skipUnquotedValue() {
    L2:
        int r0 = 0;
    L3:
        int r1 = this.pos;
        if ((r1 + r0) >= this.limit) goto L36;
        char r2 = this.buffer[r1 + r0];
        if (r2 == '\t') goto L34;
        if (r2 == '\n') goto L34;
        if (r2 == '\f') goto L34;
        if (r2 == '\r') goto L34;
        if (r2 == ' ') goto L34;
        if (r2 == '#') goto L33;
        if (r2 == ',') goto L34;
        if (r2 == '/') goto L33;
        if (r2 == '=') goto L33;
        if (r2 == '{') goto L34;
        if (r2 == '}') goto L34;
        if (r2 == ':') goto L34;
        if (r2 == ';') goto L33;
        switch(r2) {
            case 91: goto L34;
            case 92: goto L33;
            case 93: goto L34;
            default: goto L32;
        };
    L32:
        r0 = r0 + 1;
    L33:
        checkLenient();
    L34:
        this.pos += r0;
        return;
    L36:
        this.pos = r1 + r0;
        if (fillBuffer(1) == true) goto L2;
    }

    private IOException syntaxError(String r2) {
        StringBuilder r3 = a.q(r2);
        r3.append(locationString());
        throw new MalformedJsonException(r3.toString());
    }

    public void beginArray() {
        int r0 = this.peeked;
        if (r0 != 0) goto L6;
        r0 = doPeek();
    L6:
        if (r0 != 3) goto L10;
        push(1);
        this.pathIndices[this.stackSize - 1] = 0;
        this.peeked = 0;
        return;
    L10:
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + peek() + locationString());
    }

    public void beginObject() {
        int r0 = this.peeked;
        if (r0 != 0) goto L6;
        r0 = doPeek();
    L6:
        if (r0 != 1) goto L10;
        push(3);
        this.peeked = 0;
        return;
    L10:
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + peek() + locationString());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.peeked = 0;
        this.stack[0] = 8;
        this.stackSize = 1;
        this.in.close();
    }

    public int doPeek() {
        int[] r0 = this.stack;
        int r1 = this.stackSize;
        int r2 = r0[r1 - 1];
        if (r2 != 1) goto L5;
        r0[r1 - 1] = 2;
    L46:
        int r3 = nextNonWhitespace(true);
        if (r3 == 34) goto L84;
        if (r3 == 39) goto L82;
        if (r3 == 44) goto L75;
        if (r3 == 59) goto L75;
        if (r3 == 91) goto L73;
        if (r3 != 93) goto L55;
        if (r2 != 1) goto L75;
        this.peeked = 4;
        return 4;
    L55:
        if (r3 == 123) goto L68;
        this.pos--;
        int r4 = peekKeyword();
        if (r4 == 0) goto L59;
        return r4;
    L59:
        int r5 = peekNumber();
        if (r5 == 0) goto L63;
        return r5;
    L63:
        if (isLiteral(this.buffer[this.pos]) == false) goto L67;
        checkLenient();
        this.peeked = 10;
        return 10;
    L67:
        throw syntaxError("Expected value");
    L68:
        this.peeked = 1;
        return 1;
    L73:
        this.peeked = 3;
        return 3;
    L75:
        if (r2 == 1) goto L80;
        if (r2 == 2) goto L80;
        throw syntaxError("Unexpected value");
    L80:
        checkLenient();
        this.pos--;
        this.peeked = 7;
        return 7;
    L82:
        checkLenient();
        this.peeked = 8;
        return 8;
    L84:
        this.peeked = 9;
        return 9;
    L5:
        if (r2 != 2) goto L16;
        int r6 = nextNonWhitespace(true);
        if (r6 == 44) goto L46;
        if (r6 == 59) goto L14;
        if (r6 != 93) goto L13;
        this.peeked = 4;
        return 4;
    L13:
        throw syntaxError("Unterminated array");
    L14:
        checkLenient();
        goto L46
    L16:
        if (r2 == 3) goto L88;
        if (r2 == 5) goto L88;
        if (r2 != 4) goto L34;
        r0[r1 - 1] = 5;
        int r7 = nextNonWhitespace(true);
        if (r7 == 58) goto L46;
        if (r7 != 61) goto L32;
        checkLenient();
        if (this.pos >= this.limit) goto L27;
    L28:
        char[] r8 = this.buffer;
        int r9 = this.pos;
        if (r8[r9] != '>') goto L46;
        this.pos = r9 + 1;
        goto L46
    L27:
        if (fillBuffer(1) == false) goto L46;
    L32:
        throw syntaxError("Expected ':'");
    L34:
        if (r2 == 6) goto L36;
        if (r2 == 7) goto L41;
        if (r2 != 8) goto L46;
        throw new IllegalStateException("JsonReader is closed");
    L41:
        if (nextNonWhitespace(false) != (-1)) goto L44;
        this.peeked = 17;
        return 17;
    L44:
        checkLenient();
        this.pos--;
        goto L46
    L36:
        if (this.lenient == false) goto L38;
        consumeNonExecutePrefix();
    L38:
        this.stack[this.stackSize - 1] = 7;
    L88:
        r0[r1 - 1] = 4;
        if (r2 != 5) goto L99;
        int r10 = nextNonWhitespace(true);
        if (r10 == 44) goto L99;
        if (r10 == 59) goto L98;
        if (r10 != 125) goto L97;
        this.peeked = 2;
        return 2;
    L97:
        throw syntaxError("Unterminated object");
    L98:
        checkLenient();
    L99:
        int r11 = nextNonWhitespace(true);
        if (r11 == 34) goto L117;
        if (r11 != 39) goto L103;
        checkLenient();
        this.peeked = 12;
        return 12;
    L103:
        if (r11 == 125) goto L110;
        checkLenient();
        this.pos--;
        if (isLiteral((char) r11) == false) goto L109;
        this.peeked = 14;
        return 14;
    L109:
        throw syntaxError("Expected name");
    L110:
        if (r2 == 5) goto L114;
        this.peeked = 2;
        return 2;
    L114:
        throw syntaxError("Expected name");
    L117:
        this.peeked = 13;
        return 13;
    }

    public void endArray() {
        int r0 = this.peeked;
        if (r0 != 0) goto L6;
        r0 = doPeek();
    L6:
        if (r0 != 4) goto L10;
        int r1 = this.stackSize;
        this.stackSize = r1 - 1;
        int[] r2 = this.pathIndices;
        int r3 = r1 - 2;
        r2[r3] = r2[r3] + 1;
        this.peeked = 0;
        return;
    L10:
        throw new IllegalStateException("Expected END_ARRAY but was " + peek() + locationString());
    }

    public void endObject() {
        int r0 = this.peeked;
        if (r0 != 0) goto L6;
        r0 = doPeek();
    L6:
        if (r0 != 2) goto L10;
        int r1 = this.stackSize;
        int r2 = r1 - 1;
        this.stackSize = r2;
        this.pathNames[r2] = null;
        int[] r3 = this.pathIndices;
        int r4 = r1 - 2;
        r3[r4] = r3[r4] + 1;
        this.peeked = 0;
        return;
    L10:
        throw new IllegalStateException("Expected END_OBJECT but was " + peek() + locationString());
    }

    public String getPath() {
        StringBuilder r0 = new StringBuilder("$");
        int r1 = this.stackSize;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L21;
        int r3 = this.stack[r2];
        if (r3 != 1) goto L7;
    L18:
        r0.append('[');
        r0.append(this.pathIndices[r2]);
        r0.append(']');
    L19:
        r2 = r2 + 1;
        goto L3
    L7:
        if (r3 == 2) goto L18;
        if (r3 != 3) goto L11;
    L15:
        r0.append('.');
        String r4 = this.pathNames[r2];
        if (r4 == null) goto L19;
        r0.append(r4);
        goto L19
    L11:
        if (r3 == 4) goto L15;
        if (r3 == 5) goto L15;
    L21:
        return r0.toString();
    }

    public boolean hasNext() {
        int r0 = this.peeked;
        if (r0 != 0) goto L6;
        r0 = doPeek();
    L6:
        if (r0 != 2) goto L8;
    L10:
        return false;
    L8:
        if (r0 == 4) goto L10;
        return true;
    }

    public final boolean isLenient() {
        return this.lenient;
    }

    public String locationString() {
        StringBuilder r0 = a.r(" at line ", this.lineNumber + 1, " column ", (this.pos - this.lineStart) + 1, " path ");
        r0.append(getPath());
        return r0.toString();
    }

    public boolean nextBoolean() {
        int r0 = this.peeked;
        if (r0 != 0) goto L6;
        r0 = doPeek();
    L6:
        if (r0 != 5) goto L10;
        this.peeked = 0;
        int[] r1 = this.pathIndices;
        int r4 = this.stackSize - 1;
        r1[r4] = r1[r4] + 1;
        return true;
    L10:
        if (r0 != 6) goto L14;
        this.peeked = 0;
        int[] r2 = this.pathIndices;
        int r5 = this.stackSize - 1;
        r2[r5] = r2[r5] + 1;
        return false;
    L14:
        throw new IllegalStateException("Expected a boolean but was " + peek() + locationString());
    }

    public double nextDouble() {
        int r0 = this.peeked;
        if (r0 != 0) goto L6;
        r0 = doPeek();
    L6:
        if (r0 != 15) goto L10;
        this.peeked = 0;
        int[] r1 = this.pathIndices;
        int r2 = this.stackSize - 1;
        r1[r2] = r1[r2] + 1;
        return this.peekedLong;
    L10:
        if (r0 != 16) goto L13;
        this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
        this.pos += this.peekedNumberLength;
    L28:
        this.peeked = 11;
        double r3 = Double.parseDouble(this.peekedString);
        if (this.lenient == false) goto L31;
    L37:
        this.peekedString = null;
        this.peeked = 0;
        int[] r4 = this.pathIndices;
        int r6 = this.stackSize - 1;
        r4[r6] = r4[r6] + 1;
        return r3;
    L31:
        if (Double.isNaN(r3) == true) goto L36;
        if (Double.isInfinite(r3) == false) goto L37;
    L36:
        throw new MalformedJsonException("JSON forbids NaN and infinities: " + r3 + locationString());
    L13:
        if (r0 != 8) goto L15;
    L24:
        if (r0 != 8) goto L26;
        char r5 = '\'';
    L27:
        this.peekedString = nextQuotedValue(r5);
        goto L28
    L26:
        r5 = '\"';
        goto L27
    L15:
        if (r0 == 9) goto L24;
        if (r0 != 10) goto L20;
        this.peekedString = nextUnquotedValue();
        goto L28
    L20:
        if (r0 == 11) goto L28;
        throw new IllegalStateException("Expected a double but was " + peek() + locationString());
    }

    public int nextInt() {
        int r0 = this.peeked;
        if (r0 != 0) goto L6;
        r0 = doPeek();
    L6:
        if (r0 != 15) goto L14;
        long r1 = this.peekedLong;
        int r4 = (int) r1;
        if (r1 != r4) goto L12;
        this.peeked = 0;
        int[] r2 = this.pathIndices;
        int r7 = this.stackSize - 1;
        r2[r7] = r2[r7] + 1;
        return r4;
    L12:
        throw new NumberFormatException("Expected an int but was " + this.peekedLong + locationString());
    L14:
        if (r0 != 16) goto L17;
        this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
        this.pos += this.peekedNumberLength;
    L32:
        this.peeked = 11;
        double r3 = Double.parseDouble(this.peekedString);
        int r5 = (int) r3;
        if (r5 != r3) goto L37;
        this.peekedString = null;
        this.peeked = 0;
        int[] r6 = this.pathIndices;
        int r8 = this.stackSize - 1;
        r6[r8] = r6[r8] + 1;
        return r5;
    L37:
        throw new NumberFormatException("Expected an int but was " + this.peekedString + locationString());
    L17:
        if (r0 != 8) goto L19;
    L24:
        if (r0 != 10) goto L26;
        this.peekedString = nextUnquotedValue();
    L39:
        int r9 = Integer.parseInt(this.peekedString);     // Catch: NumberFormatException -> L38
        this.peeked = 0;     // Catch: NumberFormatException -> L38
        int[] r10 = this.pathIndices;     // Catch: NumberFormatException -> L38
        int r11 = this.stackSize - 1;     // Catch: NumberFormatException -> L38
        r10[r11] = r10[r11] + 1;     // Catch: NumberFormatException -> L38
        return r9;
    L26:
        if (r0 != 8) goto L28;
        char r12 = '\'';
    L29:
        this.peekedString = nextQuotedValue(r12);
        goto L39
    L28:
        r12 = '\"';
        goto L29
    L19:
        if (r0 == 9) goto L24;
        if (r0 == 10) goto L24;
        throw new IllegalStateException("Expected an int but was " + peek() + locationString());
    }

    public long nextLong() {
        int r0 = this.peeked;
        if (r0 != 0) goto L6;
        r0 = doPeek();
    L6:
        if (r0 != 15) goto L10;
        this.peeked = 0;
        int[] r1 = this.pathIndices;
        int r2 = this.stackSize - 1;
        r1[r2] = r1[r2] + 1;
        return this.peekedLong;
    L10:
        if (r0 != 16) goto L13;
        this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
        this.pos += this.peekedNumberLength;
    L28:
        this.peeked = 11;
        double r3 = Double.parseDouble(this.peekedString);
        long r4 = (long) r3;
        if (r4 != r3) goto L33;
        this.peekedString = null;
        this.peeked = 0;
        int[] r5 = this.pathIndices;
        int r8 = this.stackSize - 1;
        r5[r8] = r5[r8] + 1;
        return r4;
    L33:
        throw new NumberFormatException("Expected a long but was " + this.peekedString + locationString());
    L13:
        if (r0 != 8) goto L15;
    L20:
        if (r0 != 10) goto L22;
        this.peekedString = nextUnquotedValue();
    L35:
        long r6 = Long.parseLong(this.peekedString);     // Catch: NumberFormatException -> L34
        this.peeked = 0;     // Catch: NumberFormatException -> L34
        int[] r7 = this.pathIndices;     // Catch: NumberFormatException -> L34
        int r9 = this.stackSize - 1;     // Catch: NumberFormatException -> L34
        r7[r9] = r7[r9] + 1;     // Catch: NumberFormatException -> L34
        return r6;
    L22:
        if (r0 != 8) goto L24;
        char r10 = '\'';
    L25:
        this.peekedString = nextQuotedValue(r10);
        goto L35
    L24:
        r10 = '\"';
        goto L25
    L15:
        if (r0 == 9) goto L20;
        if (r0 == 10) goto L20;
        throw new IllegalStateException("Expected a long but was " + peek() + locationString());
    }

    public String nextName() {
        int r0 = this.peeked;
        if (r0 != 0) goto L6;
        r0 = doPeek();
    L6:
        if (r0 != 14) goto L9;
        String r1 = nextUnquotedValue();
    L14:
        this.peeked = 0;
        this.pathNames[this.stackSize - 1] = r1;
        return r1;
    L9:
        if (r0 != 12) goto L12;
        r1 = nextQuotedValue('\'');
        goto L14
    L12:
        if (r0 != 13) goto L17;
        r1 = nextQuotedValue('\"');
        goto L14
    L17:
        throw new IllegalStateException("Expected a name but was " + peek() + locationString());
    }

    public void nextNull() {
        int r0 = this.peeked;
        if (r0 != 0) goto L6;
        r0 = doPeek();
    L6:
        if (r0 != 7) goto L10;
        this.peeked = 0;
        int[] r1 = this.pathIndices;
        int r3 = this.stackSize - 1;
        r1[r3] = r1[r3] + 1;
        return;
    L10:
        throw new IllegalStateException("Expected null but was " + peek() + locationString());
    }

    public String nextString() {
        int r0 = this.peeked;
        if (r0 != 0) goto L6;
        r0 = doPeek();
    L6:
        if (r0 != 10) goto L9;
        String r1 = nextUnquotedValue();
    L23:
        this.peeked = 0;
        int[] r2 = this.pathIndices;
        int r4 = this.stackSize - 1;
        r2[r4] = r2[r4] + 1;
        return r1;
    L9:
        if (r0 != 8) goto L12;
        r1 = nextQuotedValue('\'');
        goto L23
    L12:
        if (r0 != 9) goto L15;
        r1 = nextQuotedValue('\"');
        goto L23
    L15:
        if (r0 != 11) goto L18;
        r1 = this.peekedString;
        this.peekedString = null;
        goto L23
    L18:
        if (r0 != 15) goto L21;
        r1 = Long.toString(this.peekedLong);
        goto L23
    L21:
        if (r0 != 16) goto L26;
        r1 = new String(this.buffer, this.pos, this.peekedNumberLength);
        this.pos += this.peekedNumberLength;
        goto L23
    L26:
        throw new IllegalStateException("Expected a string but was " + peek() + locationString());
    }

    public JsonToken peek() {
        int r0 = this.peeked;
        if (r0 != 0) goto L5;
        r0 = doPeek();
    L5:
        switch(r0) {
            case 1: goto L27;
            case 2: goto L25;
            case 3: goto L23;
            case 4: goto L21;
            case 5: goto L19;
            case 6: goto L19;
            case 7: goto L17;
            case 8: goto L15;
            case 9: goto L15;
            case 10: goto L15;
            case 11: goto L15;
            case 12: goto L13;
            case 13: goto L13;
            case 14: goto L13;
            case 15: goto L11;
            case 16: goto L11;
            case 17: goto L9;
            default: goto L7;
        };
    L7:
        throw new AssertionError();
    L9:
        return JsonToken.END_DOCUMENT;
    L11:
        return JsonToken.NUMBER;
    L13:
        return JsonToken.NAME;
    L15:
        return JsonToken.STRING;
    L17:
        return JsonToken.NULL;
    L19:
        return JsonToken.BOOLEAN;
    L21:
        return JsonToken.END_ARRAY;
    L23:
        return JsonToken.BEGIN_ARRAY;
    L25:
        return JsonToken.END_OBJECT;
    L27:
        return JsonToken.BEGIN_OBJECT;
    }

    public final void setLenient(boolean r1) {
        this.lenient = r1;
    }

    public void skipValue() {
        int r1 = 0;
    L3:
        int r2 = this.peeked;
        if (r2 != 0) goto L7;
        r2 = doPeek();
    L7:
        if (r2 != 3) goto L10;
        push(1);
    L9:
        r1 = r1 + 1;
    L40:
        this.peeked = 0;
        if (r1 != 0) goto L3;
        int[] r0 = this.pathIndices;
        int r3 = this.stackSize;
        int r4 = r3 - 1;
        r0[r4] = r0[r4] + 1;
        this.pathNames[r3 - 1] = "null";
        return;
    L10:
        if (r2 != 1) goto L13;
        push(3);
        goto L9
    L13:
        if (r2 != 4) goto L17;
        this.stackSize--;
    L15:
        r1 = r1 - 1;
        goto L40
    L17:
        if (r2 != 2) goto L20;
        this.stackSize--;
        goto L15
    L20:
        if (r2 != 14) goto L22;
    L39:
        skipUnquotedValue();
        goto L40
    L22:
        if (r2 == 10) goto L39;
        if (r2 != 8) goto L27;
    L38:
        skipQuotedValue('\'');
        goto L40
    L27:
        if (r2 == 12) goto L38;
        if (r2 != 9) goto L32;
    L37:
        skipQuotedValue('\"');
        goto L40
    L32:
        if (r2 == 13) goto L37;
        if (r2 != 16) goto L40;
        this.pos += this.peekedNumberLength;
        goto L40
    }

    public String toString() {
        return getClass().getSimpleName() + locationString();
    }
}
