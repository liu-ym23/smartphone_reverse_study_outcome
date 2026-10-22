package com.google.crypto.tink.mac.internal;

import android.icu.lang.UCharacter;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class AesUtil {
    public static final int BLOCK_SIZE = 16;

    public static byte[] dbl(final byte[] value) {
        if (value.length != 16) goto L14;
        byte[] r0 = new byte[16];
        int r3 = 0;
    L6:
        if (r3 >= 16) goto L11;
        byte r5 = (byte) ((value[r3] << 1) & UCharacter.UnicodeBlock.ANATOLIAN_HIEROGLYPHS_ID);
        r0[r3] = r5;
        if (r3 >= 15) goto L10;
        r0[r3] = (byte) (((byte) ((value[r3 + 1] >> 7) & 1)) | r5);
    L10:
        r3 = r3 + 1;
        goto L6
    L11:
        r0[15] = (byte) (((byte) ((value[0] >> 7) & 135)) ^ r0[15]);
        return r0;
    L14:
        throw new IllegalArgumentException("value must be a block.");
    }

    public static byte[] cmacPad(final byte[] x) {
        if (x.length >= 16) goto L7;
        byte[] r0 = Arrays.copyOf(x, 16);
        r0[x.length] = -128;
        return r0;
    L7:
        throw new IllegalArgumentException("x must be smaller than a block.");
    }

    private AesUtil() {
    }
}
