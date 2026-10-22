package com.android.apksigner;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
class HexEncoding {
    private static final char[] HEX_DIGITS = null;

    static {
        HEX_DIGITS = "0123456789abcdef".toCharArray();
    }

    private HexEncoding() {
    }

    public static String encode(byte[] r5, int r6, int r7) {
        StringBuilder r0 = new StringBuilder(r7 * 2);
        int r1 = 0;
    L3:
        if (r1 >= r7) goto L6;
        byte r2 = r5[r6 + r1];
        char[] r3 = HEX_DIGITS;
        r0.append(r3[(r2 >>> 4) & 15]);
        r0.append(r3[r2 & 15]);
        r1 = r1 + 1;
        goto L3
    L6:
        return r0.toString();
    }

    public static String encodeRemaining(ByteBuffer r3) {
        return encode(r3.array(), r3.arrayOffset() + r3.position(), r3.remaining());
    }

    public static String encode(byte[] r2) {
        return encode(r2, 0, r2.length);
    }
}
