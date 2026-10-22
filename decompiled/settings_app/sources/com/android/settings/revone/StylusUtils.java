package com.android.settings.revone;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class StylusUtils {
    private static final int BYTE_MASK = 255;
    private static final int LEFT_SHIFT_FOUR = 4;

    public static int byteToInt(byte r0) {
        return r0 & 255;
    }

    public StylusUtils() {
    }

    public static byte[] hexStringToBytes(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L6;
        return null;
    L6:
        String r6 = r5.trim().toUpperCase();
        int r0 = r6.length() / 2;
        char[] r7 = r6.toCharArray();
        byte[] r1 = new byte[r0];
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L9;
        int r3 = r2 * 2;
        int r4 = charToByte(r7[r3]) << 4;
        r1[r2] = (byte) (charToByte(r7[r3 + 1]) | r4);
        r2 = r2 + 1;
        goto L7
    L9:
        return r1;
    }

    public static byte charToByte(char r1) {
        return (byte) "0123456789ABCDEF".indexOf(r1);
    }
}
