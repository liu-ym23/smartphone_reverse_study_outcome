package com.google.crypto.tink.subtle;

/* JADX INFO: loaded from: classes4.dex */
public final class Hex {
    public static String encode(final byte[] bytes) {
        StringBuilder r0 = new StringBuilder(bytes.length * 2);
        int r1 = bytes.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        int r3 = bytes[r2] & 255;
        r0.append("0123456789abcdef".charAt(r3 / 16));
        r0.append("0123456789abcdef".charAt(r3 % 16));
        r2 = r2 + 1;
        goto L3
    L6:
        return r0.toString();
    }

    public static byte[] decode(String hex) {
        if ((hex.length() % 2) != 0) goto L14;
        int r0 = hex.length() / 2;
        byte[] r1 = new byte[r0];
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L12;
        int r3 = r2 * 2;
        int r4 = Character.digit(hex.charAt(r3), 16);
        int r5 = Character.digit(hex.charAt(r3 + 1), 16);
        if (r4 == (-1)) goto L11;
        if (r5 == (-1)) goto L11;
        r1[r2] = (byte) ((r4 * 16) + r5);
        r2 = r2 + 1;
    L11:
        throw new IllegalArgumentException("input is not hexadecimal");
    L12:
        return r1;
    L14:
        throw new IllegalArgumentException("Expected a string of even length");
    }

    private Hex() {
    }
}
