package okio;

import kotlin.UByte;

/* JADX INFO: loaded from: classes5.dex */
final class Base64 {
    private static final byte[] MAP = null;
    private static final byte[] URL_MAP = null;

    private Base64() {
    }

    public static byte[] decode(String r15) {
        int r0 = r15.length();
    L4:
        if (r0 <= 0) goto L13;
        char r5 = r15.charAt(r0 - 1);
        if (r5 == '=') goto L12;
        if (r5 == '\n') goto L12;
        if (r5 == '\r') goto L12;
        if (r5 == ' ') goto L12;
        if (r5 != '\t') goto L13;
    L12:
        r0 = r0 - 1;
    L13:
        int r6 = (int) ((((long) r0) * 6) / 8);
        byte[] r7 = new byte[r6];
        int r8 = 0;
        int r9 = 0;
        int r10 = 0;
        int r11 = 0;
    L15:
        if (r8 >= r0) goto L53;
        char r13 = r15.charAt(r8);
        if (r13 < 'A') goto L22;
        if (r13 > 'Z') goto L22;
        int r14 = r13 - 'A';
    L49:
        r10 = (r10 << 6) | ((byte) r14);
        r9 = r9 + 1;
        if ((r9 % 4) != 0) goto L52;
        int r12 = r11 + 1;
        r7[r11] = (byte) (r10 >> 16);
        int r16 = r12 + 1;
        r7[r12] = (byte) (r10 >> 8);
        r7[r16] = (byte) r10;
        r11 = r16 + 1;
    L52:
        r8 = r8 + 1;
    L22:
        if (r13 < 'a') goto L27;
        if (r13 > 'z') goto L27;
        r14 = r13 - 'G';
    L27:
        if (r13 < '0') goto L32;
        if (r13 > '9') goto L32;
        r14 = r13 + 4;
    L32:
        if (r13 != '+') goto L34;
    L48:
        r14 = 62;
        goto L49
    L34:
        if (r13 == '-') goto L48;
        if (r13 != '/') goto L39;
    L47:
        r14 = 63;
        goto L49
    L39:
        if (r13 == '_') goto L47;
        if (r13 == '\n') goto L52;
        if (r13 == '\r') goto L52;
        if (r13 == ' ') goto L52;
        if (r13 == '\t') goto L52;
        return null;
    L53:
        int r17 = r9 % 4;
        if (r17 != 1) goto L57;
        return null;
    L57:
        if (r17 != 2) goto L60;
        r7[r11] = (byte) ((r10 << 12) >> 16);
        r11 = r11 + 1;
    L62:
        if (r11 != r6) goto L64;
        return r7;
    L64:
        byte[] r18 = new byte[r11];
        System.arraycopy(r7, 0, r18, 0, r11);
        return r18;
    L60:
        if (r17 != 3) goto L62;
        int r19 = r10 << 6;
        int r1 = r11 + 1;
        r7[r11] = (byte) (r19 >> 16);
        r11 = r1 + 1;
        r7[r1] = (byte) (r19 >> 8);
        goto L62
    }

    static {
        MAP = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        URL_MAP = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    }

    public static String encode(byte[] r1) {
        return encode(r1, MAP);
    }

    public static String encodeUrl(byte[] r1) {
        return encode(r1, URL_MAP);
    }

    private static String encode(byte[] r9, byte[] r10) {
        byte[] r0 = new byte[((r9.length + 2) / 3) * 4];
        int r2 = r9.length - (r9.length % 3);
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r3 >= r2) goto L5;
        int r5 = r4 + 1;
        r0[r4] = r10[(r9[r3] & UByte.MAX_VALUE) >> 2];
        int r6 = r5 + 1;
        int r7 = r3 + 1;
        r0[r5] = r10[((r9[r3] & 3) << 4) | ((r9[r7] & UByte.MAX_VALUE) >> 4)];
        int r8 = r6 + 1;
        int r11 = (r9[r7] & 15) << 2;
        int r12 = r3 + 2;
        r0[r6] = r10[r11 | ((r9[r12] & UByte.MAX_VALUE) >> 6)];
        r4 = r8 + 1;
        r0[r8] = r10[r9[r12] & 63];
        r3 = r3 + 3;
        goto L3
    L5:
        int r13 = r9.length % 3;
        if (r13 == 1) goto L10;
        if (r13 != 2) goto L16;
        int r14 = r4 + 1;
        r0[r4] = r10[(r9[r2] & UByte.MAX_VALUE) >> 2];
        int r15 = r14 + 1;
        int r16 = (r9[r2] & 3) << 4;
        int r17 = r2 + 1;
        r0[r14] = r10[((r9[r17] & UByte.MAX_VALUE) >> 4) | r16];
        r0[r15] = r10[(r9[r17] & 15) << 2];
        r0[r15 + 1] = 61;
    L16:
        return new String(r0, "US-ASCII");
    L13:
        e = move-exception;
        throw new AssertionError(e);
    L10:
        int r18 = r4 + 1;
        r0[r4] = r10[(r9[r2] & UByte.MAX_VALUE) >> 2];
        int r1 = r18 + 1;
        r0[r18] = r10[(r9[r2] & 3) << 4];
        r0[r1] = 61;
        r0[r1 + 1] = 61;
        goto L16
    }
}
