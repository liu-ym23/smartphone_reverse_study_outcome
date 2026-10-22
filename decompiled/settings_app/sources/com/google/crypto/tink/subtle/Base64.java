package com.google.crypto.tink.subtle;

import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes4.dex */
public final class Base64 {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int CRLF = 4;
    public static final int DEFAULT = 0;
    public static final int NO_CLOSE = 16;
    public static final int NO_PADDING = 1;
    public static final int NO_WRAP = 2;
    public static final int URL_SAFE = 8;
    private static final Charset UTF_8 = null;

    static abstract class Coder {
        public int op;
        public byte[] output;

        public abstract int maxOutputSize(int len);

        public abstract boolean process(byte[] input, int offset, int len, boolean finish);

        Coder() {
        }
    }

    static class Decoder extends Coder {
        private static final int[] DECODE = null;
        private static final int[] DECODE_WEBSAFE = null;
        private static final int EQUALS = -2;
        private static final int SKIP = -1;
        private final int[] alphabet;
        private int state;
        private int value;

        static {
            DECODE = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
            DECODE_WEBSAFE = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        }

        public Decoder(int flags, byte[] output) {
            this.output = output;
            if ((flags & 8) != 0) goto L5;
            int[] r1 = DECODE;
        L6:
            this.alphabet = r1;
            this.state = 0;
            this.value = 0;
            return;
        L5:
            r1 = DECODE_WEBSAFE;
            goto L6
        }

        @Override // com.google.crypto.tink.subtle.Base64.Coder
        public int maxOutputSize(int len) {
            return ((len * 3) / 4) + 10;
        }

        @Override // com.google.crypto.tink.subtle.Base64.Coder
        public boolean process(byte[] input, int offset, int len, boolean finish) {
            int r1 = this.state;
            if (r1 != 6) goto L5;
            return false;
        L5:
            int r4 = len + offset;
            int r5 = this.value;
            byte[] r6 = this.output;
            int[] r7 = this.alphabet;
            int r9 = 0;
            int r8 = r5;
            int r10 = r1;
            int r2 = offset;
        L7:
            if (r2 >= r4) goto L59;
            if (r10 != 0) goto L16;
        L9:
            int r14 = r2 + 4;
            if (r14 > r4) goto L14;
            r8 = (((r7[input[r2] & 255] << 18) | (r7[input[r2 + 1] & 255] << 12)) | (r7[input[r2 + 2] & 255] << 6)) | r7[input[r2 + 3] & 255];
            if (r8 < 0) goto L14;
            r6[r9 + 2] = (byte) r8;
            r6[r9 + 1] = (byte) (r8 >> 8);
            r6[r9] = (byte) (r8 >> 16);
            r9 = r9 + 3;
            r2 = r14;
        L14:
            if (r2 >= r4) goto L59;
        L16:
            int r15 = r2 + 1;
            int r3 = r7[input[r2] & 255];
            if (r10 == 0) goto L53;
            if (r10 != 1) goto L20;
            if (r3 < 0) goto L50;
        L49:
            r3 = r3 | (r8 << 6);
        L54:
            r10 = r10 + 1;
            r8 = r3;
        L58:
            r2 = r15;
            goto L7
        L50:
            if (r3 == (-1)) goto L58;
            this.state = 6;
            return false;
        L20:
            if (r10 != 2) goto L22;
            if (r3 >= 0) goto L49;
            if (r3 != (-2)) goto L45;
            r6[r9] = (byte) (r8 >> 4);
            r9 = r9 + 1;
            r10 = 4;
            goto L58
        L45:
            if (r3 == (-1)) goto L58;
            this.state = 6;
            return false;
        L22:
            if (r10 == 3) goto L34;
            if (r10 == 4) goto L29;
            if (r10 != 5) goto L58;
            if (r3 == (-1)) goto L58;
            this.state = 6;
            return false;
        L29:
            if (r3 != (-2)) goto L31;
            r10 = r10 + 1;
            goto L58
        L31:
            if (r3 == (-1)) goto L58;
            this.state = 6;
            return false;
        L34:
            if (r3 < 0) goto L36;
            int r11 = r3 | (r8 << 6);
            r6[r9 + 2] = (byte) r11;
            r6[r9 + 1] = (byte) (r11 >> 8);
            r6[r9] = (byte) (r11 >> 16);
            r9 = r9 + 3;
            r8 = r11;
            r10 = 0;
            goto L58
        L36:
            if (r3 != (-2)) goto L38;
            r6[r9 + 1] = (byte) (r8 >> 2);
            r6[r9] = (byte) (r8 >> 10);
            r9 = r9 + 2;
            r10 = 5;
            goto L58
        L38:
            if (r3 == (-1)) goto L58;
            this.state = 6;
            return false;
        L53:
            if (r3 >= 0) goto L54;
            if (r3 == (-1)) goto L58;
            this.state = 6;
            return false;
        L59:
            if (finish == true) goto L62;
            this.state = r10;
            this.value = r8;
            this.op = r9;
            return true;
        L62:
            if (r10 == 1) goto L73;
            if (r10 == 2) goto L70;
            if (r10 == 3) goto L69;
            if (r10 != 4) goto L71;
            this.state = 6;
            return false;
        L71:
            this.state = r10;
            this.op = r9;
            return true;
        L69:
            int r12 = r9 + 1;
            r6[r9] = (byte) (r8 >> 10);
            r9 = r12 + 1;
            r6[r12] = (byte) (r8 >> 2);
            goto L71
        L70:
            r6[r9] = (byte) (r8 >> 4);
            r9 = r9 + 1;
            goto L71
        L73:
            this.state = 6;
            return false;
        }
    }

    static class Encoder extends Coder {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final byte[] ENCODE = null;
        private static final byte[] ENCODE_WEBSAFE = null;
        public static final int LINE_GROUPS = 19;
        private final byte[] alphabet;
        private int count;
        public final boolean doCr;
        public final boolean doNewline;
        public final boolean doPadding;
        private final byte[] tail;
        int tailLen;

        static {
            ENCODE = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
            ENCODE_WEBSAFE = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        }

        public Encoder(int flags, byte[] output) {
            this.output = output;
            boolean r1 = true;
            if ((flags & 1) != 0) goto L5;
            boolean r5 = true;
        L6:
            this.doPadding = r5;
            if ((flags & 2) != 0) goto L9;
            boolean r6 = true;
        L10:
            this.doNewline = r6;
            if ((flags & 4) != 0) goto L14;
            r1 = false;
        L14:
            this.doCr = r1;
            if ((flags & 8) != 0) goto L17;
            byte[] r4 = ENCODE;
        L18:
            this.alphabet = r4;
            this.tail = new byte[2];
            this.tailLen = 0;
            if (r6 == false) goto L21;
            int r7 = 19;
        L22:
            this.count = r7;
            return;
        L21:
            r7 = -1;
            goto L22
        L17:
            r4 = ENCODE_WEBSAFE;
            goto L18
        L9:
            r6 = false;
            goto L10
        L5:
            r5 = false;
            goto L6
        }

        @Override // com.google.crypto.tink.subtle.Base64.Coder
        public int maxOutputSize(int len) {
            return ((len * 8) / 5) + 10;
        }

        @Override // com.google.crypto.tink.subtle.Base64.Coder
        public boolean process(byte[] input, int offset, int len, boolean finish) {
            byte[] r1 = this.alphabet;
            byte[] r2 = this.output;
            int r3 = this.count;
            int r4 = len + offset;
            int r5 = this.tailLen;
            int r8 = 0;
            if (r5 == 1) goto L10;
            if (r5 != 2) goto L12;
            int r6 = offset + 1;
            if (r6 > r4) goto L12;
            byte[] r10 = this.tail;
            int r11 = (((r10[1] & 255) << 8) | ((r10[0] & 255) << 16)) | (input[offset] & 255);
            this.tailLen = 0;
            int r12 = r6;
        L14:
            if (r11 == (-1)) goto L24;
            r2[0] = r1[(r11 >> 18) & 63];
            r2[1] = r1[(r11 >> 12) & 63];
            r2[2] = r1[(r11 >> 6) & 63];
            r2[3] = r1[r11 & 63];
            r3 = r3 - 1;
            if (r3 == 0) goto L18;
            int r9 = 4;
        L25:
            int r13 = r12 + 3;
            if (r13 > r4) goto L34;
            int r7 = (((input[r12 + 1] & 255) << 8) | ((input[r12] & 255) << 16)) | (input[r12 + 2] & 255);
            r2[r9] = r1[(r7 >> 18) & 63];
            r2[r9 + 1] = r1[(r7 >> 12) & 63];
            r2[r9 + 2] = r1[(r7 >> 6) & 63];
            r2[r9 + 3] = r1[r7 & 63];
            r9 = r9 + 4;
            r3 = r3 - 1;
            if (r3 == 0) goto L30;
            r12 = r13;
            goto L25
        L30:
            if (this.doCr == false) goto L32;
            int r14 = r9 + 1;
            r2[r9] = 13;
        L32:
            r2[r14] = 10;
            r9 = r14 + 1;
            r12 = r13;
        L22:
            r3 = 19;
            goto L25
        L86:
            r2[r9] = 10;
            r9 = r9 + 1;
            r12 = r13;
            goto L22
        L34:
            if (finish == false) goto L79;
            int r15 = this.tailLen;
            if ((r12 - r15) != (r4 - 1)) goto L51;
            if (r15 <= 0) goto L39;
            byte r16 = this.tail[0];
            r8 = 1;
        L40:
            int r17 = (r16 & 255) << 4;
            this.tailLen = r15 - r8;
            int r18 = r9 + 1;
            r2[r9] = r1[(r17 >> 6) & 63];
            int r19 = r18 + 1;
            r2[r18] = r1[r17 & 63];
            if (this.doPadding == false) goto L44;
            int r20 = r19 + 1;
            r2[r19] = kotlin.io.encoding.Base64.padSymbol;
            r19 = r20 + 1;
            r2[r20] = kotlin.io.encoding.Base64.padSymbol;
        L44:
            if (this.doNewline == true) goto L46;
        L49:
            r9 = r19;
        L84:
            this.op = r9;
            this.count = r3;
            return true;
        L46:
            if (this.doCr == false) goto L48;
            r2[r19] = 13;
            r19 = r19 + 1;
        L48:
            r2[r19] = 10;
            r19 = r19 + 1;
            goto L49
        L39:
            r16 = input[r12];
            goto L40
        L51:
            if ((r12 - r15) != (r4 - 2)) goto L70;
            if (r15 <= 1) goto L54;
            byte r21 = this.tail[0];
            r8 = 1;
        L55:
            int r22 = (r21 & 255) << 10;
            if (r15 <= 0) goto L58;
            int r110 = r8 + 1;
            byte r23 = this.tail[r8];
        L59:
            int r24 = r22 | ((r23 & 255) << 2);
            this.tailLen = r15 - r110;
            int r25 = r9 + 1;
            r2[r9] = r1[(r24 >> 12) & 63];
            int r26 = r25 + 1;
            r2[r25] = r1[(r24 >> 6) & 63];
            int r27 = r26 + 1;
            r2[r26] = r1[r24 & 63];
            if (this.doPadding == false) goto L63;
            r2[r27] = kotlin.io.encoding.Base64.padSymbol;
            r27 = r27 + 1;
        L63:
            if (this.doNewline == true) goto L65;
        L68:
            r9 = r27;
            goto L84
        L65:
            if (this.doCr == false) goto L67;
            r2[r27] = 13;
            r27 = r27 + 1;
        L67:
            r2[r27] = 10;
            r27 = r27 + 1;
            goto L68
        L58:
            byte r111 = input[r12];
            r110 = r8;
            r23 = r111;
            goto L59
        L54:
            byte r112 = input[r12];
            r12 = r12 + 1;
            r21 = r112;
            goto L55
        L70:
            if (this.doNewline == false) goto L84;
            if (r9 <= 0) goto L84;
            if (r3 == 19) goto L84;
            if (this.doCr == false) goto L77;
            r2[r9] = 13;
            r9 = r9 + 1;
        L77:
            r2[r9] = 10;
            r9 = r9 + 1;
            goto L84
        L79:
            if (r12 != (r4 - 1)) goto L82;
            byte[] r28 = this.tail;
            int r29 = this.tailLen;
            this.tailLen = r29 + 1;
            r28[r29] = input[r12];
            goto L84
        L82:
            if (r12 != (r4 - 2)) goto L84;
            byte[] r30 = this.tail;
            int r31 = this.tailLen;
            int r32 = r31 + 1;
            r30[r31] = input[r12];
            this.tailLen = r32 + 1;
            r30[r32] = input[r12 + 1];
            goto L84
        L18:
            if (this.doCr == false) goto L20;
            r2[4] = 13;
            int r33 = 5;
        L21:
            r9 = r33 + 1;
            r2[r33] = 10;
            goto L22
        L20:
            r33 = 4;
            goto L21
        L24:
            r9 = 0;
        L12:
            r12 = offset;
            r11 = -1;
            goto L14
        L10:
            if ((offset + 2) > r4) goto L12;
            int r113 = offset + 1;
            r12 = r113 + 1;
            r11 = (input[r113] & 255) | (((this.tail[0] & 255) << 16) | ((input[offset] & 255) << 8));
            this.tailLen = 0;
            goto L14
        }
    }

    static {
        UTF_8 = Charset.forName("UTF-8");
    }

    public static byte[] decode(String input) {
        return decode(input, 2);
    }

    public static byte[] decode(String str, int flags) {
        return decode(str.getBytes(UTF_8), flags);
    }

    public static byte[] decode(byte[] input, int flags) {
        return decode(input, 0, input.length, flags);
    }

    public static byte[] decode(byte[] input, int offset, int len, int flags) {
        Decoder r0 = new Decoder(flags, new byte[(len * 3) / 4]);
        if (r0.process(input, offset, len, true) == false) goto L11;
        if (r0.op == r0.output.length) goto L7;
        byte[] r2 = new byte[r0.op];
        System.arraycopy(r0.output, 0, r2, 0, r0.op);
        return r2;
    L7:
        return r0.output;
    L11:
        throw new IllegalArgumentException("bad base-64");
    }

    public static byte[] urlSafeDecode(String input) {
        return decode(input, 11);
    }

    public static String encode(final byte[] input) {
        return encodeToString(input, 2);
    }

    public static byte[] encode(byte[] input, int flags) {
        return encode(input, 0, input.length, flags);
    }

    public static byte[] encode(byte[] input, int offset, int len, int flags) {
        Encoder r0 = new Encoder(flags, null);
        int r8 = (len / 3) * 4;
        int r2 = 2;
        if (r0.doPadding == true) goto L5;
        int r1 = len % 3;
        if (r1 == 1) goto L12;
        if (r1 != 2) goto L14;
        r8 = r8 + 3;
    L14:
        if (r0.doNewline == false) goto L21;
        if (len <= 0) goto L21;
        int r3 = ((len - 1) / 57) + 1;
        if (r0.doCr == true) goto L20;
        r2 = 1;
    L20:
        r8 = r8 + (r3 * r2);
    L21:
        r0.output = new byte[r8];
        r0.process(input, offset, len, true);
        return r0.output;
    L12:
        r8 = r8 + 2;
        goto L14
    L5:
        if ((len % 3) <= 0) goto L14;
        r8 = r8 + 4;
        goto L14
    }

    public static String urlSafeEncode(final byte[] input) {
        return encodeToString(input, 11);
    }

    public static String encodeToString(byte[] input, int flags) {
        return new String(encode(input, flags), "US-ASCII");
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    public static String encodeToString(byte[] input, int offset, int len, int flags) {
        return new String(encode(input, offset, len, flags), "US-ASCII");
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    private Base64() {
    }
}
