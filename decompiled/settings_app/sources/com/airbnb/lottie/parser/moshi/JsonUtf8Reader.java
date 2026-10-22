package com.airbnb.lottie.parser.moshi;

import cz.msebera.android.httpclient.message.BasicHeaderValueFormatter;
import cz.msebera.android.httpclient.message.TokenParser;
import java.io.EOFException;
import java.io.IOException;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: loaded from: classes.dex */
final class JsonUtf8Reader extends JsonReader {
    private static final ByteString CLOSING_BLOCK_COMMENT = null;
    private static final ByteString DOUBLE_QUOTE_OR_SLASH = null;
    private static final ByteString LINEFEED_OR_CARRIAGE_RETURN = null;
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
    private static final int PEEKED_BUFFERED_NAME = 15;
    private static final int PEEKED_DOUBLE_QUOTED = 9;
    private static final int PEEKED_DOUBLE_QUOTED_NAME = 13;
    private static final int PEEKED_END_ARRAY = 4;
    private static final int PEEKED_END_OBJECT = 2;
    private static final int PEEKED_EOF = 18;
    private static final int PEEKED_FALSE = 6;
    private static final int PEEKED_LONG = 16;
    private static final int PEEKED_NONE = 0;
    private static final int PEEKED_NULL = 7;
    private static final int PEEKED_NUMBER = 17;
    private static final int PEEKED_SINGLE_QUOTED = 8;
    private static final int PEEKED_SINGLE_QUOTED_NAME = 12;
    private static final int PEEKED_TRUE = 5;
    private static final int PEEKED_UNQUOTED = 10;
    private static final int PEEKED_UNQUOTED_NAME = 14;
    private static final ByteString SINGLE_QUOTE_OR_SLASH = null;
    private static final ByteString UNQUOTED_STRING_TERMINALS = null;
    private final Buffer buffer;
    private int peeked;
    private long peekedLong;
    private int peekedNumberLength;
    private String peekedString;
    private final BufferedSource source;

    static {
        SINGLE_QUOTE_OR_SLASH = ByteString.encodeUtf8("'\\");
        DOUBLE_QUOTE_OR_SLASH = ByteString.encodeUtf8(BasicHeaderValueFormatter.UNSAFE_CHARS);
        UNQUOTED_STRING_TERMINALS = ByteString.encodeUtf8("{}[]:, \n\t\r\f/\\;#=");
        LINEFEED_OR_CARRIAGE_RETURN = ByteString.encodeUtf8("\n\r");
        CLOSING_BLOCK_COMMENT = ByteString.encodeUtf8("*/");
    }

    JsonUtf8Reader(BufferedSource r2) {
        this.peeked = 0;
        if (r2 == null) goto L7;
        this.source = r2;
        this.buffer = r2.getBuffer();
        pushScope(6);
        return;
    L7:
        throw new NullPointerException("source == null");
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void beginArray() throws IOException {
        int r0 = this.peeked;
        if (r0 != 0) goto L6;
        r0 = doPeek();
    L6:
        if (r0 != 3) goto L10;
        pushScope(1);
        this.pathIndices[this.stackSize - 1] = 0;
        this.peeked = 0;
        return;
    L10:
        throw new JsonDataException("Expected BEGIN_ARRAY but was " + peek() + " at path " + getPath());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void endArray() throws IOException {
        int r0 = this.peeked;
        if (r0 != 0) goto L6;
        r0 = doPeek();
    L6:
        if (r0 != 4) goto L10;
        this.stackSize--;
        int[] r1 = this.pathIndices;
        int r2 = this.stackSize - 1;
        r1[r2] = r1[r2] + 1;
        this.peeked = 0;
        return;
    L10:
        throw new JsonDataException("Expected END_ARRAY but was " + peek() + " at path " + getPath());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void beginObject() throws IOException {
        int r0 = this.peeked;
        if (r0 != 0) goto L6;
        r0 = doPeek();
    L6:
        if (r0 != 1) goto L10;
        pushScope(3);
        this.peeked = 0;
        return;
    L10:
        throw new JsonDataException("Expected BEGIN_OBJECT but was " + peek() + " at path " + getPath());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void endObject() throws IOException {
        int r0 = this.peeked;
        if (r0 != 0) goto L6;
        r0 = doPeek();
    L6:
        if (r0 != 2) goto L10;
        this.stackSize--;
        this.pathNames[this.stackSize] = null;
        int[] r1 = this.pathIndices;
        int r2 = this.stackSize - 1;
        r1[r2] = r1[r2] + 1;
        this.peeked = 0;
        return;
    L10:
        throw new JsonDataException("Expected END_OBJECT but was " + peek() + " at path " + getPath());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public boolean hasNext() throws IOException {
        int r0 = this.peeked;
        if (r0 != 0) goto L6;
        r0 = doPeek();
    L6:
        if (r0 != 2) goto L8;
    L12:
        return false;
    L8:
        if (r0 == 4) goto L12;
        if (r0 == 18) goto L12;
        return true;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public JsonReader.Token peek() throws IOException {
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
            case 15: goto L13;
            case 16: goto L11;
            case 17: goto L11;
            case 18: goto L9;
            default: goto L7;
        };
    L7:
        throw new AssertionError();
    L9:
        return JsonReader.Token.END_DOCUMENT;
    L11:
        return JsonReader.Token.NUMBER;
    L13:
        return JsonReader.Token.NAME;
    L15:
        return JsonReader.Token.STRING;
    L17:
        return JsonReader.Token.NULL;
    L19:
        return JsonReader.Token.BOOLEAN;
    L21:
        return JsonReader.Token.END_ARRAY;
    L23:
        return JsonReader.Token.BEGIN_ARRAY;
    L25:
        return JsonReader.Token.END_OBJECT;
    L27:
        return JsonReader.Token.BEGIN_OBJECT;
    }

    private int doPeek() throws IOException {
        int r1 = this.scopes[this.stackSize - 1];
        if (r1 != 1) goto L5;
        this.scopes[this.stackSize - 1] = 2;
    L41:
        int r6 = nextNonWhitespace(true);
        if (r6 != 34) goto L44;
        this.buffer.readByte();
        this.peeked = 9;
        return 9;
    L44:
        if (r6 == 39) goto L79;
        if (r6 == 44) goto L71;
        if (r6 == 59) goto L71;
        if (r6 == 91) goto L69;
        if (r6 != 93) goto L51;
        if (r1 != 1) goto L71;
        this.buffer.readByte();
        this.peeked = 4;
        return 4;
    L51:
        if (r6 == 123) goto L64;
        int r2 = peekKeyword();
        if (r2 == 0) goto L55;
        return r2;
    L55:
        int r3 = peekNumber();
        if (r3 == 0) goto L59;
        return r3;
    L59:
        if (isLiteral(this.buffer.getByte(0)) == false) goto L63;
        checkLenient();
        this.peeked = 10;
        return 10;
    L63:
        throw syntaxError("Expected value");
    L64:
        this.buffer.readByte();
        this.peeked = 1;
        return 1;
    L69:
        this.buffer.readByte();
        this.peeked = 3;
        return 3;
    L71:
        if (r1 != 1) goto L73;
    L77:
        checkLenient();
        this.peeked = 7;
        return 7;
    L73:
        if (r1 == 2) goto L77;
        throw syntaxError("Unexpected value");
    L79:
        checkLenient();
        this.buffer.readByte();
        this.peeked = 8;
        return 8;
    L5:
        if (r1 != 2) goto L16;
        int r7 = nextNonWhitespace(true);
        this.buffer.readByte();
        if (r7 == 44) goto L41;
        if (r7 == 59) goto L14;
        if (r7 != 93) goto L13;
        this.peeked = 4;
        return 4;
    L13:
        throw syntaxError("Unterminated array");
    L14:
        checkLenient();
        goto L41
    L16:
        if (r1 == 3) goto L85;
        if (r1 == 5) goto L85;
        if (r1 != 4) goto L32;
        this.scopes[this.stackSize - 1] = 5;
        int r8 = nextNonWhitespace(true);
        this.buffer.readByte();
        if (r8 == 58) goto L41;
        if (r8 != 61) goto L30;
        checkLenient();
        if (this.source.request(1) == false) goto L41;
        if (this.buffer.getByte(0) != 62) goto L41;
        this.buffer.readByte();
        goto L41
    L30:
        throw syntaxError("Expected ':'");
    L32:
        if (r1 != 6) goto L34;
        this.scopes[this.stackSize - 1] = 7;
        goto L41
    L34:
        if (r1 == 7) goto L36;
        if (r1 != 8) goto L41;
        throw new IllegalStateException("JsonReader is closed");
    L36:
        if (nextNonWhitespace(false) != (-1)) goto L39;
        this.peeked = 18;
        return 18;
    L39:
        checkLenient();
    L85:
        this.scopes[this.stackSize - 1] = 4;
        if (r1 != 5) goto L96;
        int r4 = nextNonWhitespace(true);
        this.buffer.readByte();
        if (r4 == 44) goto L96;
        if (r4 == 59) goto L95;
        if (r4 != 125) goto L94;
        this.peeked = 2;
        return 2;
    L94:
        throw syntaxError("Unterminated object");
    L95:
        checkLenient();
    L96:
        int r5 = nextNonWhitespace(true);
        if (r5 != 34) goto L99;
        this.buffer.readByte();
        this.peeked = 13;
        return 13;
    L99:
        if (r5 != 39) goto L101;
        this.buffer.readByte();
        checkLenient();
        this.peeked = 12;
        return 12;
    L101:
        if (r5 == 125) goto L108;
        checkLenient();
        if (isLiteral((char) r5) == false) goto L107;
        this.peeked = 14;
        return 14;
    L107:
        throw syntaxError("Expected name");
    L108:
        if (r1 == 5) goto L112;
        this.buffer.readByte();
        this.peeked = 2;
        return 2;
    L112:
        throw syntaxError("Expected name");
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private int peekKeyword() throws IOException {
        byte r0 = this.buffer.getByte(0);
        if (r0 != 116) goto L5;
    L20:
        String r1 = "true";
        String r2 = "TRUE";
        int r3 = 5;
    L21:
        int r4 = r1.length();
        int r5 = 1;
    L22:
        if (r5 >= r4) goto L33;
        int r7 = r5 + 1;
        if (this.source.request(r7) == false) goto L25;
        byte r6 = this.buffer.getByte(r5);
        if (r6 == r1.charAt(r5)) goto L31;
        if (r6 == r2.charAt(r5)) goto L31;
        return 0;
    L31:
        r5 = r7;
        goto L22
    L25:
        return 0;
    L33:
        if (this.source.request(r4 + 1) == true) goto L35;
    L37:
        this.buffer.skip(r4);
        this.peeked = r3;
        return r3;
    L35:
        if (isLiteral(this.buffer.getByte(r4)) == false) goto L37;
        return 0;
    L5:
        if (r0 == 84) goto L20;
        if (r0 != 102) goto L10;
    L19:
        r1 = "false";
        r2 = "FALSE";
        r3 = 6;
        goto L21
    L10:
        if (r0 == 70) goto L19;
        if (r0 != 110) goto L15;
    L18:
        r1 = "null";
        r2 = "NULL";
        r3 = 7;
        goto L21
    L15:
        if (r0 == 78) goto L18;
        return 0;
    }

    private int peekNumber() throws IOException {
        boolean r4 = true;
        long r8 = 0;
        int r5 = 0;
        char r6 = 0;
        boolean r10 = false;
        boolean r7 = true;
    L3:
        int r12 = r5 + 1;
        if (this.source.request(r12) == false) goto L47;
        byte r11 = this.buffer.getByte(r5);
        if (r11 != 43) goto L9;
        char r9 = 6;
        if (r6 != 5) goto L91;
    L89:
        r6 = r9;
    L90:
        r5 = r12;
        r4 = true;
        goto L3
    L91:
        return 0;
    L9:
        if (r11 == 69) goto L81;
        if (r11 == 101) goto L81;
        if (r11 != 45) goto L15;
        r9 = 6;
        if (r6 != 0) goto L77;
        r6 = 1;
        r10 = true;
        goto L90
    L77:
        if (r6 == 5) goto L89;
        return 0;
    L15:
        if (r11 != 46) goto L17;
        if (r6 != 2) goto L72;
        r6 = 3;
        goto L90
    L72:
        return 0;
    L17:
        if (r11 < 48) goto L46;
        if (r11 > 57) goto L46;
        if (r6 == r4) goto L44;
        if (r6 == 0) goto L44;
        if (r6 == 2) goto L26;
        if (r6 != 3) goto L40;
        r6 = 4;
        goto L90
    L40:
        if (r6 != 5) goto L42;
    L43:
        r6 = 7;
        goto L90
    L42:
        if (r6 != 6) goto L90;
    L26:
        if (r8 == 0) goto L27;
        long r13 = (10 * r8) - ((long) (r11 - 48));
        if (r8 > (-922337203685477580L)) goto L35;
        if (r8 == (-922337203685477580L)) goto L32;
    L34:
        boolean r14 = false;
    L36:
        r7 = r7 & r14;
        r8 = r13;
        goto L90
    L32:
        if (r13 >= r8) goto L34;
    L35:
        r14 = true;
        goto L36
    L27:
        return 0;
    L44:
        r8 = -(r11 - 48);
        r6 = 2;
    L46:
        if (isLiteral(r11) == false) goto L47;
        return 0;
    L81:
        if (r6 != 2) goto L83;
    L86:
        r6 = 5;
        goto L90
    L83:
        if (r6 == 4) goto L86;
        return 0;
    L47:
        if (r6 != 2) goto L60;
        if (r7 == false) goto L60;
        if (r8 != Long.MIN_VALUE) goto L53;
        if (r10 == false) goto L60;
    L53:
        if (r8 != 0) goto L55;
        if (r10 == true) goto L60;
    L55:
        if (r10 == true) goto L58;
        r8 = -r8;
    L58:
        this.peekedLong = r8;
        this.buffer.skip(r5);
        this.peeked = 16;
        return 16;
    L60:
        if (r6 != 2) goto L62;
    L67:
        this.peekedNumberLength = r5;
        this.peeked = 17;
        return 17;
    L62:
        if (r6 == 4) goto L67;
        if (r6 == 7) goto L67;
        return 0;
    }

    private boolean isLiteral(int r2) throws IOException {
        if (r2 != 9) goto L5;
        return false;
    L5:
        if (r2 != 10) goto L7;
        return false;
    L7:
        if (r2 != 12) goto L9;
        return false;
    L9:
        if (r2 != 13) goto L11;
        return false;
    L11:
        if (r2 != 32) goto L13;
        return false;
    L13:
        if (r2 != 35) goto L15;
    L31:
        checkLenient();
        return false;
    L15:
        if (r2 != 44) goto L17;
        return false;
    L17:
        if (r2 == 47) goto L31;
        if (r2 == 61) goto L31;
        if (r2 != 123) goto L23;
        return false;
    L23:
        if (r2 != 125) goto L25;
        return false;
    L25:
        if (r2 != 58) goto L27;
        return false;
    L27:
        if (r2 == 59) goto L31;
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

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public String nextName() throws IOException {
        int r0 = this.peeked;
        if (r0 != 0) goto L6;
        r0 = doPeek();
    L6:
        if (r0 != 14) goto L9;
        String r1 = nextUnquotedValue();
    L17:
        this.peeked = 0;
        this.pathNames[this.stackSize - 1] = r1;
        return r1;
    L9:
        if (r0 != 13) goto L12;
        r1 = nextQuotedValue(DOUBLE_QUOTE_OR_SLASH);
        goto L17
    L12:
        if (r0 != 12) goto L15;
        r1 = nextQuotedValue(SINGLE_QUOTE_OR_SLASH);
        goto L17
    L15:
        if (r0 != 15) goto L20;
        r1 = this.peekedString;
        goto L17
    L20:
        throw new JsonDataException("Expected a name but was " + peek() + " at path " + getPath());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public int selectName(JsonReader.Options r5) throws IOException {
        int r0 = this.peeked;
        if (r0 != 0) goto L6;
        r0 = doPeek();
    L6:
        if (r0 >= 12) goto L8;
    L21:
        return -1;
    L8:
        if (r0 > 15) goto L21;
        if (r0 == 15) goto L12;
        int r1 = this.source.select(r5.doubleQuoteSuffix);
        if (r1 == (-1)) goto L17;
        this.peeked = 0;
        this.pathNames[this.stackSize - 1] = r5.strings[r1];
        return r1;
    L17:
        String r2 = this.pathNames[this.stackSize - 1];
        String r3 = nextName();
        int r6 = findName(r3, r5);
        if (r6 != (-1)) goto L20;
        this.peeked = 15;
        this.peekedString = r3;
        this.pathNames[this.stackSize - 1] = r2;
    L20:
        return r6;
    L12:
        return findName(this.peekedString, r5);
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void skipName() throws IOException {
        if (this.failOnUnknown == true) goto L23;
        int r0 = this.peeked;
        if (r0 != 0) goto L8;
        r0 = doPeek();
    L8:
        if (r0 != 14) goto L11;
        skipUnquotedValue();
    L18:
        this.peeked = 0;
        this.pathNames[this.stackSize - 1] = "null";
        return;
    L11:
        if (r0 != 13) goto L14;
        skipQuotedValue(DOUBLE_QUOTE_OR_SLASH);
        goto L18
    L14:
        if (r0 != 12) goto L17;
        skipQuotedValue(SINGLE_QUOTE_OR_SLASH);
        goto L18
    L17:
        if (r0 == 15) goto L18;
        throw new JsonDataException("Expected a name but was " + peek() + " at path " + getPath());
    L23:
        throw new JsonDataException("Cannot skip unexpected " + peek() + " at " + getPath());
    }

    private int findName(String r5, JsonReader.Options r6) {
        int r0 = r6.strings.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (r5.equals(r6.strings[r2]) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        this.peeked = 0;
        this.pathNames[this.stackSize - 1] = r5;
        return r2;
    L9:
        return -1;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public String nextString() throws IOException {
        int r0 = this.peeked;
        if (r0 != 0) goto L6;
        r0 = doPeek();
    L6:
        if (r0 != 10) goto L9;
        String r1 = nextUnquotedValue();
    L23:
        this.peeked = 0;
        int[] r2 = this.pathIndices;
        int r3 = this.stackSize - 1;
        r2[r3] = r2[r3] + 1;
        return r1;
    L9:
        if (r0 != 9) goto L12;
        r1 = nextQuotedValue(DOUBLE_QUOTE_OR_SLASH);
        goto L23
    L12:
        if (r0 != 8) goto L15;
        r1 = nextQuotedValue(SINGLE_QUOTE_OR_SLASH);
        goto L23
    L15:
        if (r0 != 11) goto L18;
        r1 = this.peekedString;
        this.peekedString = null;
        goto L23
    L18:
        if (r0 != 16) goto L21;
        r1 = Long.toString(this.peekedLong);
        goto L23
    L21:
        if (r0 != 17) goto L26;
        r1 = this.buffer.readUtf8(this.peekedNumberLength);
        goto L23
    L26:
        throw new JsonDataException("Expected a string but was " + peek() + " at path " + getPath());
    }

    private int findString(String r5, JsonReader.Options r6) {
        int r0 = r6.strings.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (r5.equals(r6.strings[r2]) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        this.peeked = 0;
        int[] r7 = this.pathIndices;
        int r4 = this.stackSize - 1;
        r7[r4] = r7[r4] + 1;
        return r2;
    L9:
        return -1;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public boolean nextBoolean() throws IOException {
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
        throw new JsonDataException("Expected a boolean but was " + peek() + " at path " + getPath());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public double nextDouble() throws IOException {
        int r0 = this.peeked;
        if (r0 != 0) goto L6;
        r0 = doPeek();
    L6:
        if (r0 != 16) goto L10;
        this.peeked = 0;
        int[] r1 = this.pathIndices;
        int r2 = this.stackSize - 1;
        r1[r2] = r1[r2] + 1;
        return this.peekedLong;
    L10:
        if (r0 != 17) goto L13;
        this.peekedString = this.buffer.readUtf8(this.peekedNumberLength);
    L22:
        this.peeked = 11;
        double r3 = Double.parseDouble(this.peekedString);     // Catch: NumberFormatException -> L35
        if (this.lenient == false) goto L27;
    L33:
        this.peekedString = null;
        this.peeked = 0;
        int[] r4 = this.pathIndices;
        int r8 = this.stackSize - 1;
        r4[r8] = r4[r8] + 1;
        return r3;
    L27:
        if (Double.isNaN(r3) == true) goto L32;
        if (Double.isInfinite(r3) == false) goto L33;
    L32:
        throw new JsonEncodingException("JSON forbids NaN and infinities: " + r3 + " at path " + getPath());
    L36:
        throw new JsonDataException("Expected a double but was " + this.peekedString + " at path " + getPath());
    L13:
        if (r0 != 9) goto L16;
        this.peekedString = nextQuotedValue(DOUBLE_QUOTE_OR_SLASH);
        goto L22
    L16:
        if (r0 != 8) goto L19;
        this.peekedString = nextQuotedValue(SINGLE_QUOTE_OR_SLASH);
        goto L22
    L19:
        if (r0 != 10) goto L21;
        this.peekedString = nextUnquotedValue();
        goto L22
    L21:
        if (r0 == 11) goto L22;
        throw new JsonDataException("Expected a double but was " + peek() + " at path " + getPath());
    }

    private String nextQuotedValue(ByteString r6) throws IOException {
        StringBuilder r0 = null;
    L3:
        long r1 = this.source.indexOfElement(r6);
        if (r1 == (-1)) goto L16;
        if (this.buffer.getByte(r1) != 92) goto L10;
        if (r0 != null) goto L9;
        r0 = new StringBuilder();
    L9:
        r0.append(this.buffer.readUtf8(r1));
        this.buffer.readByte();
        r0.append(readEscapeCharacter());
        goto L3
    L10:
        if (r0 != null) goto L13;
        String r7 = this.buffer.readUtf8(r1);
        this.buffer.readByte();
        return r7;
    L13:
        r0.append(this.buffer.readUtf8(r1));
        this.buffer.readByte();
        return r0.toString();
    L16:
        throw syntaxError("Unterminated string");
    }

    private String nextUnquotedValue() throws IOException {
        long r0 = this.source.indexOfElement(UNQUOTED_STRING_TERMINALS);
        Buffer r4 = this.buffer;
        if (r0 == (-1)) goto L6;
        return r4.readUtf8(r0);
    L6:
        return r4.readUtf8();
    }

    private void skipQuotedValue(ByteString r7) throws IOException {
    L2:
        long r0 = this.source.indexOfElement(r7);
        if (r0 == (-1)) goto L10;
        if (this.buffer.getByte(r0) != 92) goto L7;
        this.buffer.skip(r0 + 1);
        readEscapeCharacter();
        goto L2
    L7:
        this.buffer.skip(r0 + 1);
        return;
    L10:
        throw syntaxError("Unterminated string");
    }

    private void skipUnquotedValue() throws IOException {
        long r0 = this.source.indexOfElement(UNQUOTED_STRING_TERMINALS);
        Buffer r4 = this.buffer;
        if (r0 != (-1)) goto L6;
        r0 = r4.size();
    L6:
        r4.skip(r0);
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public int nextInt() throws IOException {
        int r0 = this.peeked;
        if (r0 != 0) goto L6;
        r0 = doPeek();
    L6:
        if (r0 != 16) goto L14;
        long r1 = this.peekedLong;
        int r5 = (int) r1;
        if (r1 != r5) goto L12;
        this.peeked = 0;
        int[] r2 = this.pathIndices;
        int r8 = this.stackSize - 1;
        r2[r8] = r2[r8] + 1;
        return r5;
    L12:
        throw new JsonDataException("Expected an int but was " + this.peekedLong + " at path " + getPath());
    L14:
        if (r0 != 17) goto L17;
        this.peekedString = this.buffer.readUtf8(this.peekedNumberLength);
    L31:
        this.peeked = 11;
        double r3 = Double.parseDouble(this.peekedString);     // Catch: NumberFormatException -> L39
        int r6 = (int) r3;
        if (r6 != r3) goto L38;
        this.peekedString = null;
        this.peeked = 0;
        int[] r4 = this.pathIndices;
        int r9 = this.stackSize - 1;
        r4[r9] = r4[r9] + 1;
        return r6;
    L38:
        throw new JsonDataException("Expected an int but was " + this.peekedString + " at path " + getPath());
    L40:
        throw new JsonDataException("Expected an int but was " + this.peekedString + " at path " + getPath());
    L17:
        if (r0 != 9) goto L19;
    L25:
        if (r0 != 9) goto L27;
        String r7 = nextQuotedValue(DOUBLE_QUOTE_OR_SLASH);
    L28:
        this.peekedString = r7;
        int r10 = Integer.parseInt(r7);     // Catch: NumberFormatException -> L41
        this.peeked = 0;     // Catch: NumberFormatException -> L41
        int[] r11 = this.pathIndices;     // Catch: NumberFormatException -> L41
        int r12 = this.stackSize - 1;     // Catch: NumberFormatException -> L41
        r11[r12] = r11[r12] + 1;     // Catch: NumberFormatException -> L41
        return r10;
    L27:
        r7 = nextQuotedValue(SINGLE_QUOTE_OR_SLASH);
        goto L28
    L19:
        if (r0 == 8) goto L25;
        if (r0 == 11) goto L31;
        throw new JsonDataException("Expected an int but was " + peek() + " at path " + getPath());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.peeked = 0;
        this.scopes[0] = 8;
        this.stackSize = 1;
        this.buffer.clear();
        this.source.close();
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void skipValue() throws IOException {
        if (this.failOnUnknown == true) goto L59;
        int r1 = 0;
    L5:
        int r2 = this.peeked;
        if (r2 != 0) goto L9;
        r2 = doPeek();
    L9:
        if (r2 != 3) goto L12;
        pushScope(1);
    L11:
        r1 = r1 + 1;
    L54:
        this.peeked = 0;
        if (r1 != 0) goto L5;
        int[] r0 = this.pathIndices;
        int r3 = this.stackSize - 1;
        r0[r3] = r0[r3] + 1;
        this.pathNames[this.stackSize - 1] = "null";
        return;
    L12:
        if (r2 != 1) goto L15;
        pushScope(3);
        goto L11
    L15:
        if (r2 != 4) goto L22;
        r1 = r1 - 1;
        if (r1 < 0) goto L20;
        this.stackSize--;
        goto L54
    L20:
        throw new JsonDataException("Expected a value but was " + peek() + " at path " + getPath());
    L22:
        if (r2 != 2) goto L29;
        r1 = r1 - 1;
        if (r1 < 0) goto L27;
        this.stackSize--;
        goto L54
    L27:
        throw new JsonDataException("Expected a value but was " + peek() + " at path " + getPath());
    L29:
        if (r2 != 14) goto L31;
    L53:
        skipUnquotedValue();
        goto L54
    L31:
        if (r2 == 10) goto L53;
        if (r2 != 9) goto L36;
    L52:
        skipQuotedValue(DOUBLE_QUOTE_OR_SLASH);
        goto L54
    L36:
        if (r2 == 13) goto L52;
        if (r2 != 8) goto L41;
    L51:
        skipQuotedValue(SINGLE_QUOTE_OR_SLASH);
        goto L54
    L41:
        if (r2 == 12) goto L51;
        if (r2 != 17) goto L47;
        this.buffer.skip(this.peekedNumberLength);
        goto L54
    L47:
        if (r2 != 18) goto L54;
        throw new JsonDataException("Expected a value but was " + peek() + " at path " + getPath());
    L59:
        throw new JsonDataException("Cannot skip unexpected " + peek() + " at " + getPath());
    }

    private int nextNonWhitespace(boolean r7) throws IOException {
    L3:
        int r1 = 0;
    L4:
        int r3 = r1 + 1;
        if (this.source.request(r3) == false) goto L35;
        byte r2 = this.buffer.getByte(r1);
        if (r2 == 10) goto L34;
        if (r2 == 32) goto L34;
        if (r2 == 13) goto L34;
        if (r2 == 9) goto L34;
        this.buffer.skip(r3 - 1);
        if (r2 == 47) goto L18;
        if (r2 != 35) goto L33;
        checkLenient();
        skipToEndOfLine();
        goto L3
    L33:
        return r2;
    L18:
        if (this.source.request(2) == false) goto L19;
        checkLenient();
        byte r4 = this.buffer.getByte(1);
        if (r4 != 42) goto L22;
        this.buffer.readByte();
        this.buffer.readByte();
        if (skipToEndOfBlockComment() == true) goto L3;
        throw syntaxError("Unterminated comment");
    L22:
        if (r4 != 47) goto L23;
        this.buffer.readByte();
        this.buffer.readByte();
        skipToEndOfLine();
        goto L3
    L23:
        return r2;
    L19:
        return r2;
    L34:
        r1 = r3;
        goto L4
    L35:
        if (r7 == true) goto L39;
        return -1;
    L39:
        throw new EOFException("End of input");
    }

    private void checkLenient() throws IOException {
        if (this.lenient == false) goto L6;
        return;
    L6:
        throw syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
    }

    private void skipToEndOfLine() throws IOException {
        long r0 = this.source.indexOfElement(LINEFEED_OR_CARRIAGE_RETURN);
        Buffer r4 = this.buffer;
        if (r0 == (-1)) goto L5;
        long r1 = r0 + 1;
    L6:
        r4.skip(r1);
        return;
    L5:
        r1 = r4.size();
        goto L6
    }

    private boolean skipToEndOfBlockComment() throws IOException {
        BufferedSource r0 = this.source;
        ByteString r1 = CLOSING_BLOCK_COMMENT;
        long r2 = r0.indexOf(r1);
        if (r2 == (-1)) goto L5;
        boolean r3 = true;
    L6:
        Buffer r6 = this.buffer;
        if (r3 == false) goto L9;
        long r4 = r2 + ((long) r1.size());
    L10:
        r6.skip(r4);
        return r3;
    L9:
        r4 = r6.size();
        goto L10
    L5:
        r3 = false;
        goto L6
    }

    public String toString() {
        return "JsonReader(" + this.source + ")";
    }

    private char readEscapeCharacter() throws IOException {
        if (this.source.request(1) == false) goto L72;
        byte r0 = this.buffer.readByte();
        if (r0 == 10) goto L70;
        if (r0 == 34) goto L70;
        if (r0 == 39) goto L70;
        if (r0 == 47) goto L70;
        if (r0 == 92) goto L70;
        if (r0 != 98) goto L17;
        return '\b';
    L17:
        if (r0 != 102) goto L19;
        return '\f';
    L19:
        if (r0 != 110) goto L21;
        return '\n';
    L21:
        if (r0 != 114) goto L23;
        return TokenParser.CR;
    L23:
        if (r0 != 116) goto L25;
        return '\t';
    L25:
        if (r0 == 117) goto L33;
        if (this.lenient == false) goto L31;
        return (char) r0;
    L31:
        throw syntaxError("Invalid escape sequence: \\" + ((char) r0));
    L33:
        if (this.source.request(4) == false) goto L59;
        int r1 = 0;
        char r5 = 0;
    L36:
        if (r1 >= 4) goto L56;
        byte r6 = this.buffer.getByte(r1);
        char r7 = (char) (r5 << 4);
        if (r6 < 48) goto L44;
        if (r6 > 57) goto L44;
        int r8 = r6 - 48;
    L42:
        r5 = (char) (r7 + r8);
        r1 = r1 + 1;
    L44:
        if (r6 < 97) goto L49;
        if (r6 > 102) goto L49;
        int r9 = r6 - 97;
    L47:
        r8 = r9 + 10;
    L49:
        if (r6 < 65) goto L55;
        if (r6 > 70) goto L55;
        r9 = r6 - 65;
    L55:
        throw syntaxError("\\u" + this.buffer.readUtf8(4));
    L56:
        this.buffer.skip(4);
        return r5;
    L59:
        throw new EOFException("Unterminated escape sequence at path " + getPath());
    L70:
        return (char) r0;
    L72:
        throw syntaxError("Unterminated escape sequence");
    }
}
