package com.airbnb.lottie.parser.moshi;

import com.android.vcard.VCardConstants;
import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: loaded from: classes.dex */
public abstract class JsonReader implements Closeable {
    private static final String[] REPLACEMENT_CHARS = null;
    boolean failOnUnknown;
    boolean lenient;
    int[] pathIndices;
    String[] pathNames;
    int[] scopes;
    int stackSize;

    public static final class Options {
        final okio.Options doubleQuoteSuffix;
        final String[] strings;

        private Options(String[] r1, okio.Options r2) {
            this.strings = r1;
            this.doubleQuoteSuffix = r2;
        }

        public static Options of(String... r4) {
            ByteString[] r0 = new ByteString[r4.length];     // Catch: IOException -> L8
            Buffer r1 = new Buffer();     // Catch: IOException -> L8
            int r2 = 0;
        L4:
            if (r2 >= r4.length) goto L6;
            JsonReader.access$000(r1, r4[r2]);     // Catch: IOException -> L8
            r1.readByte();     // Catch: IOException -> L8
            r0[r2] = r1.readByteString();     // Catch: IOException -> L8
            r2 = r2 + 1;     // Catch: IOException -> L8
            goto L4
        L6:
            return new Options((String[]) r4.clone(), okio.Options.of(r0));
        L8:
            e = move-exception;
            throw new AssertionError(e);
        }
    }

    public static final enum Token extends Enum<Token> {
        private static final /* synthetic */ Token[] $VALUES = null;
        public static final Token BEGIN_ARRAY = null;
        public static final Token BEGIN_OBJECT = null;
        public static final Token BOOLEAN = null;
        public static final Token END_ARRAY = null;
        public static final Token END_DOCUMENT = null;
        public static final Token END_OBJECT = null;
        public static final Token NAME = null;
        public static final Token NULL = null;
        public static final Token NUMBER = null;
        public static final Token STRING = null;

        private Token(String r1, int r2) {
            super(r1, r2);
        }

        public static Token valueOf(String r1) {
            return (Token) Enum.valueOf(Token.class, r1);
        }

        public static Token[] values() {
            return (Token[]) $VALUES.clone();
        }

        static {
            Token r0 = new Token("BEGIN_ARRAY", 0);
            BEGIN_ARRAY = r0;
            Token r1 = new Token("END_ARRAY", 1);
            END_ARRAY = r1;
            Token r3 = new Token("BEGIN_OBJECT", 2);
            BEGIN_OBJECT = r3;
            Token r5 = new Token("END_OBJECT", 3);
            END_OBJECT = r5;
            Token r7 = new Token(VCardConstants.PROPERTY_NAME, 4);
            NAME = r7;
            Token r9 = new Token("STRING", 5);
            STRING = r9;
            Token r11 = new Token("NUMBER", 6);
            NUMBER = r11;
            Token r13 = new Token("BOOLEAN", 7);
            BOOLEAN = r13;
            Token r15 = new Token("NULL", 8);
            NULL = r15;
            Token r14 = new Token("END_DOCUMENT", 9);
            END_DOCUMENT = r14;
            $VALUES = new Token[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
        }
    }

    public abstract void beginArray() throws IOException;

    public abstract void beginObject() throws IOException;

    public abstract void endArray() throws IOException;

    public abstract void endObject() throws IOException;

    public abstract boolean hasNext() throws IOException;

    public abstract boolean nextBoolean() throws IOException;

    public abstract double nextDouble() throws IOException;

    public abstract int nextInt() throws IOException;

    public abstract String nextName() throws IOException;

    public abstract String nextString() throws IOException;

    public abstract Token peek() throws IOException;

    public abstract int selectName(Options r1) throws IOException;

    public abstract void skipName() throws IOException;

    public abstract void skipValue() throws IOException;

    static /* synthetic */ void access$000(BufferedSink r0, String r1) throws IOException {
        string(r0, r1);
    }

    static {
        REPLACEMENT_CHARS = new String[128];
        int r1 = 0;
    L4:
        if (r1 > 31) goto L6;
        REPLACEMENT_CHARS[r1] = String.format("\\u%04x", new Object[]{Integer.valueOf(r1)});
        r1 = r1 + 1;
        goto L4
    L6:
        String[] r0 = REPLACEMENT_CHARS;
        r0[34] = "\\\"";
        r0[92] = "\\\\";
        r0[9] = "\\t";
        r0[8] = "\\b";
        r0[10] = "\\n";
        r0[13] = "\\r";
        r0[12] = "\\f";
    }

    public static JsonReader of(BufferedSource r1) {
        return new JsonUtf8Reader(r1);
    }

    JsonReader() {
        this.scopes = new int[32];
        this.pathNames = new String[32];
        this.pathIndices = new int[32];
    }

    final void pushScope(int r4) {
        int r0 = this.stackSize;
        int[] r1 = this.scopes;
        if (r0 == r1.length) goto L5;
    L9:
        int[] r2 = this.scopes;
        int r3 = this.stackSize;
        this.stackSize = r3 + 1;
        r2[r3] = r4;
        return;
    L5:
        if (r0 == 256) goto L8;
        this.scopes = Arrays.copyOf(r1, r1.length * 2);
        String[] r5 = this.pathNames;
        this.pathNames = (String[]) Arrays.copyOf(r5, r5.length * 2);
        int[] r6 = this.pathIndices;
        this.pathIndices = Arrays.copyOf(r6, r6.length * 2);
        goto L9
    L8:
        throw new JsonDataException("Nesting too deep at " + getPath());
    }

    final JsonEncodingException syntaxError(String r3) throws JsonEncodingException {
        throw new JsonEncodingException(r3 + " at path " + getPath());
    }

    public final String getPath() {
        return JsonScope.getPath(this.stackSize, this.scopes, this.pathNames, this.pathIndices);
    }

    private static void string(BufferedSink r7, String r8) throws IOException {
        String[] r0 = REPLACEMENT_CHARS;
        r7.writeByte(34);
        int r2 = r8.length();
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r3 >= r2) goto L19;
        char r5 = r8.charAt(r3);
        if (r5 >= 128) goto L10;
        String r6 = r0[r5];
        if (r6 == null) goto L18;
    L15:
        if (r4 >= r3) goto L17;
        r7.writeUtf8(r8, r4, r3);
    L17:
        r7.writeUtf8(r6);
        r4 = r3 + 1;
    L18:
        r3 = r3 + 1;
        goto L3
    L10:
        if (r5 != 8232) goto L13;
        r6 = "\\u2028";
        goto L15
    L13:
        if (r5 != 8233) goto L18;
        r6 = "\\u2029";
        goto L15
    L19:
        if (r4 >= r2) goto L21;
        r7.writeUtf8(r8, r4, r2);
    L21:
        r7.writeByte(34);
    }
}
