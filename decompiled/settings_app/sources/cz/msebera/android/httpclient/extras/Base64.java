package cz.msebera.android.httpclient.extras;

/* JADX INFO: loaded from: classes5.dex */
public class Base64 {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int CRLF = 4;
    public static final int DEFAULT = 0;
    public static final int NO_CLOSE = 16;
    public static final int NO_PADDING = 1;
    public static final int NO_WRAP = 2;
    public static final int URL_SAFE = 8;

    static abstract class Coder {
        public int op;
        public byte[] output;

        public abstract int maxOutputSize(int r1);

        public abstract boolean process(byte[] r1, int r2, int r3, boolean r4);

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

        public Decoder(int r1, byte[] r2) {
            this.output = r2;
            if ((r1 & 8) != 0) goto L5;
            int[] r3 = DECODE;
        L6:
            this.alphabet = r3;
            this.state = 0;
            this.value = 0;
            return;
        L5:
            r3 = DECODE_WEBSAFE;
            goto L6
        }

        @Override // cz.msebera.android.httpclient.extras.Base64.Coder
        public int maxOutputSize(int r1) {
            return ((r1 * 3) / 4) + 10;
        }

        @Override // cz.msebera.android.httpclient.extras.Base64.Coder
        public boolean process(byte[] r17, int r18, int r19, boolean r20) {
            int r1 = this.state;
            if (r1 != 6) goto L5;
            return false;
        L5:
            int r4 = r19 + r18;
            int r5 = this.value;
            byte[] r6 = this.output;
            int[] r7 = this.alphabet;
            int r9 = 0;
            int r8 = r5;
            int r10 = r1;
            int r2 = r18;
        L7:
            if (r2 >= r4) goto L59;
            if (r10 != 0) goto L16;
        L9:
            int r14 = r2 + 4;
            if (r14 > r4) goto L14;
            r8 = (((r7[r17[r2] & 255] << 18) | (r7[r17[r2 + 1] & 255] << 12)) | (r7[r17[r2 + 2] & 255] << 6)) | r7[r17[r2 + 3] & 255];
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
            int r3 = r7[r17[r2] & 255];
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
            if (r20 == true) goto L62;
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
        public final boolean do_cr;
        public final boolean do_newline;
        public final boolean do_padding;
        private final byte[] tail;
        int tailLen;

        static {
            ENCODE = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
            ENCODE_WEBSAFE = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        }

        public Encoder(int r4, byte[] r5) {
            this.output = r5;
            boolean r1 = true;
            if ((r4 & 1) != 0) goto L5;
            boolean r6 = true;
        L6:
            this.do_padding = r6;
            if ((r4 & 2) != 0) goto L9;
            boolean r7 = true;
        L10:
            this.do_newline = r7;
            if ((r4 & 4) != 0) goto L14;
            r1 = false;
        L14:
            this.do_cr = r1;
            if ((r4 & 8) != 0) goto L17;
            byte[] r8 = ENCODE;
        L18:
            this.alphabet = r8;
            this.tail = new byte[2];
            this.tailLen = 0;
            if (r7 == false) goto L21;
            int r9 = 19;
        L22:
            this.count = r9;
            return;
        L21:
            r9 = -1;
            goto L22
        L17:
            r8 = ENCODE_WEBSAFE;
            goto L18
        L9:
            r7 = false;
            goto L10
        L5:
            r6 = false;
            goto L6
        }

        @Override // cz.msebera.android.httpclient.extras.Base64.Coder
        public int maxOutputSize(int r1) {
            return ((r1 * 8) / 5) + 10;
        }

        @Override // cz.msebera.android.httpclient.extras.Base64.Coder
        public boolean process(byte[] r18, int r19, int r20, boolean r21) {
            byte[] r1 = this.alphabet;
            byte[] r2 = this.output;
            int r3 = this.count;
            int r4 = r20 + r19;
            int r5 = this.tailLen;
            int r8 = 0;
            if (r5 == 1) goto L10;
            if (r5 != 2) goto L12;
            int r6 = r19 + 1;
            if (r6 > r4) goto L12;
            byte[] r10 = this.tail;
            int r11 = (((r10[1] & 255) << 8) | ((r10[0] & 255) << 16)) | (r18[r19] & 255);
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
            int r7 = (((r18[r12 + 1] & 255) << 8) | ((r18[r12] & 255) << 16)) | (r18[r12 + 2] & 255);
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
            if (this.do_cr == false) goto L32;
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
            if (r21 == false) goto L79;
            int r15 = this.tailLen;
            if ((r12 - r15) != (r4 - 1)) goto L51;
            if (r15 <= 0) goto L39;
            byte r16 = this.tail[0];
            r8 = 1;
        L40:
            int r17 = (r16 & 255) << 4;
            this.tailLen = r15 - r8;
            int r22 = r9 + 1;
            r2[r9] = r1[(r17 >> 6) & 63];
            int r23 = r22 + 1;
            r2[r22] = r1[r17 & 63];
            if (this.do_padding == false) goto L44;
            int r24 = r23 + 1;
            r2[r23] = kotlin.io.encoding.Base64.padSymbol;
            r23 = r24 + 1;
            r2[r24] = kotlin.io.encoding.Base64.padSymbol;
        L44:
            if (this.do_newline == true) goto L46;
        L49:
            r9 = r23;
        L84:
            this.op = r9;
            this.count = r3;
            return true;
        L46:
            if (this.do_cr == false) goto L48;
            r2[r23] = 13;
            r23 = r23 + 1;
        L48:
            r2[r23] = 10;
            r23 = r23 + 1;
            goto L49
        L39:
            r16 = r18[r12];
            goto L40
        L51:
            if ((r12 - r15) != (r4 - 2)) goto L70;
            if (r15 <= 1) goto L54;
            byte r25 = this.tail[0];
            r8 = 1;
        L55:
            int r26 = (r25 & 255) << 10;
            if (r15 <= 0) goto L58;
            int r110 = r8 + 1;
            byte r27 = this.tail[r8];
        L59:
            int r28 = r26 | ((r27 & 255) << 2);
            this.tailLen = r15 - r110;
            int r29 = r9 + 1;
            r2[r9] = r1[(r28 >> 12) & 63];
            int r30 = r29 + 1;
            r2[r29] = r1[(r28 >> 6) & 63];
            int r31 = r30 + 1;
            r2[r30] = r1[r28 & 63];
            if (this.do_padding == false) goto L63;
            r2[r31] = kotlin.io.encoding.Base64.padSymbol;
            r31 = r31 + 1;
        L63:
            if (this.do_newline == true) goto L65;
        L68:
            r9 = r31;
            goto L84
        L65:
            if (this.do_cr == false) goto L67;
            r2[r31] = 13;
            r31 = r31 + 1;
        L67:
            r2[r31] = 10;
            r31 = r31 + 1;
            goto L68
        L58:
            byte r111 = r18[r12];
            r110 = r8;
            r27 = r111;
            goto L59
        L54:
            byte r112 = r18[r12];
            r12 = r12 + 1;
            r25 = r112;
            goto L55
        L70:
            if (this.do_newline == false) goto L84;
            if (r9 <= 0) goto L84;
            if (r3 == 19) goto L84;
            if (this.do_cr == false) goto L77;
            r2[r9] = 13;
            r9 = r9 + 1;
        L77:
            r2[r9] = 10;
            r9 = r9 + 1;
            goto L84
        L79:
            if (r12 != (r4 - 1)) goto L82;
            byte[] r32 = this.tail;
            int r33 = this.tailLen;
            this.tailLen = r33 + 1;
            r32[r33] = r18[r12];
            goto L84
        L82:
            if (r12 != (r4 - 2)) goto L84;
            byte[] r34 = this.tail;
            int r35 = this.tailLen;
            int r36 = r35 + 1;
            r34[r35] = r18[r12];
            this.tailLen = r36 + 1;
            r34[r36] = r18[r12 + 1];
            goto L84
        L18:
            if (this.do_cr == false) goto L20;
            r2[4] = 13;
            int r37 = 5;
        L21:
            r9 = r37 + 1;
            r2[r37] = 10;
            goto L22
        L20:
            r37 = 4;
            goto L21
        L24:
            r9 = 0;
        L12:
            r12 = r19;
            r11 = -1;
            goto L14
        L10:
            if ((r19 + 2) > r4) goto L12;
            int r113 = r19 + 1;
            r12 = r113 + 1;
            r11 = (r18[r113] & 255) | (((this.tail[0] & 255) << 16) | ((r18[r19] & 255) << 8));
            this.tailLen = 0;
            goto L14
        }
    }

    static {
    }

    public static byte[] decode(String r0, int r1) {
        return decode(r0.getBytes(), r1);
    }

    public static byte[] decode(byte[] r2, int r3) {
        return decode(r2, 0, r2.length, r3);
    }

    public static byte[] decode(byte[] r2, int r3, int r4, int r5) {
        Decoder r0 = new Decoder(r5, new byte[(r4 * 3) / 4]);
        if (r0.process(r2, r3, r4, true) == false) goto L11;
        if (r0.op == r0.output.length) goto L7;
        byte[] r6 = new byte[r0.op];
        System.arraycopy(r0.output, 0, r6, 0, r0.op);
        return r6;
    L7:
        return r0.output;
    L11:
        throw new IllegalArgumentException("bad base-64");
    }

    public static String encodeToString(byte[] r1, int r2) {
        return new String(encode(r1, r2), "US-ASCII");
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    public static String encodeToString(byte[] r1, int r2, int r3, int r4) {
        return new String(encode(r1, r2, r3, r4), "US-ASCII");
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    public static byte[] encode(byte[] r2, int r3) {
        return encode(r2, 0, r2.length, r3);
    }

    public static byte[] encode(byte[] r5, int r6, int r7, int r8) {
        Encoder r0 = new Encoder(r8, null);
        int r9 = (r7 / 3) * 4;
        int r2 = 2;
        if (r0.do_padding == true) goto L5;
        int r1 = r7 % 3;
        if (r1 == 1) goto L12;
        if (r1 != 2) goto L14;
        r9 = r9 + 3;
    L14:
        if (r0.do_newline == false) goto L21;
        if (r7 <= 0) goto L21;
        int r3 = ((r7 - 1) / 57) + 1;
        if (r0.do_cr == true) goto L20;
        r2 = 1;
    L20:
        r9 = r9 + (r3 * r2);
    L21:
        r0.output = new byte[r9];
        r0.process(r5, r6, r7, true);
        return r0.output;
    L12:
        r9 = r9 + 2;
        goto L14
    L5:
        if ((r7 % 3) <= 0) goto L14;
        r9 = r9 + 4;
        goto L14
    }

    private Base64() {
    }
}
