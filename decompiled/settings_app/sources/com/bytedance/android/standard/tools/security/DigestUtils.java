package com.bytedance.android.standard.tools.security;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes3.dex */
public final class DigestUtils {
    private static final int BYTE_RANGE = 8192;
    static final char[] HEX_CHARS = null;
    private static final int MAX_STRING = 4;
    private static final int RADIX = 16;
    private static final int RADIX_OFFSET = 4;
    private static final int STRING_MASK_F = 15;
    private static final int STRING_MASK_FF = 255;

    static {
        HEX_CHARS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    private DigestUtils() {
    }

    public static String toHexString(byte[] r2) {
        if (r2 == null) goto L6;
        return toHexString(r2, 0, r2.length);
    L6:
        throw new NullPointerException("bytes is null");
    }

    public static String toHexString(byte[] r9, int r10, int r11) {
        if (r9 == null) goto L14;
        if (r10 < 0) goto L12;
        if ((r10 + r11) > r9.length) goto L12;
        int r0 = r11 * 2;
        char[] r1 = new char[r0];
        int r3 = 0;
        int r4 = 0;
    L7:
        if (r3 >= r11) goto L10;
        int r5 = r9[r3 + r10] & 255;
        int r6 = r4 + 1;
        char[] r7 = HEX_CHARS;
        r1[r4] = r7[r5 >> 4];
        r4 = r6 + 1;
        r1[r6] = r7[r5 & 15];
        r3 = r3 + 1;
        goto L7
    L10:
        return new String(r1, 0, r0);
    L12:
        throw new IndexOutOfBoundsException();
    L14:
        throw new NullPointerException("bytes is null");
    }

    public static byte[] hexStringToBytes(String r7) throws IllegalArgumentException {
        if (r7 == null) goto L10;
        if ((r7.length() % 2) == 1) goto L10;
        char[] r8 = r7.toCharArray();
        int r0 = r8.length;
        byte[] r1 = new byte[r0 / 2];
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L8;
        r1[r2 / 2] = (byte) ((Character.digit(r8[r2], 16) << 4) + Character.digit(r8[r2 + 1], 16));
        r2 = r2 + 2;
        goto L6
    L8:
        return r1;
    L10:
        throw new IllegalArgumentException("hexBinary needs to be even-length: " + r7);
    }

    public static String md5Hex(File r6) {
        FileInputStream r0 = null;
        MessageDigest r1 = MessageDigest.getInstance("MD5");     // Catch: Throwable -> L20 Exception -> L27
        if (r1 != null) goto L6;
        return null;
    L6:
        FileInputStream r2 = new FileInputStream(r6);     // Catch: Throwable -> L20 Exception -> L27
    L41:
        byte[] r3 = new byte[8192];     // Catch: Throwable -> L18 Exception -> L34
    L9:
        int r5 = r2.read(r3, 0, 8192);     // Catch: Throwable -> L18 Exception -> L34
        if (r5 <= 0) goto L12;
        r1.update(r3, 0, r5);     // Catch: Throwable -> L18 Exception -> L34
        goto L9
    L12:
        String r7 = toHexString(r1.digest());     // Catch: Throwable -> L18 Exception -> L34
        r2.close();     // Catch: IOException -> L15
    L17:
        return r7;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    L18:
        th = th;
        r0 = r2;
    L21:
        if (r0 != null) goto L35;
    L26:
        throw th;
    L35:
        r0.close();     // Catch: IOException -> L24
    L24:
        e = move-exception;
        e.printStackTrace();
    L28:
        if (r2 != null) goto L39;
    L33:
        return null;
    L39:
        r2.close();     // Catch: IOException -> L31
    L31:
        e = move-exception;
        e.printStackTrace();
    L27:
        r2 = null;
    L20:
        th = th;
        goto L21
    }

    public static String md5Hex(String r3) {
        if (r3 != null) goto L11;
    L9:
        return null;
    L11:
        if (r3.length() == 0) goto L9;
        MessageDigest r1 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L10
        r1.update(r3.getBytes("UTF-8"));     // Catch: Exception -> L10
        return toHexString(r1.digest());
    }

    public static String md5Hex(byte[] r2) {
        if (r2 != null) goto L11;
    L9:
        return null;
    L11:
        if (r2.length == 0) goto L9;
        MessageDigest r1 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L10
        r1.update(r2);     // Catch: Exception -> L10
        return toHexString(r1.digest());
    }

    public static String md5Hex(byte[] r3, int r4, int r5) {
        if (r3 == null) goto L12;
        if (r4 < 0) goto L12;
        if (r5 <= 0) goto L12;
        if ((r4 + r5) > r3.length) goto L12;
        MessageDigest r1 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L13
        r1.update(r3, r4, r5);     // Catch: Exception -> L13
        return toHexString(r1.digest());
    L12:
        return null;
    }
}
