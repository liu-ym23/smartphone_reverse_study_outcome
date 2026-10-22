package com.bytedance.android.standard.tools.security;

import com.bytedance.android.standard.tools.string.StringUtils;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class StringEncryptUtils {
    public static final String MD5 = "MD5";
    public static final String SHA_1 = "SHA-1";
    public static final String SHA_256 = "SHA-256";

    private StringEncryptUtils() {
    }

    public static String bytes2Hex(byte[] r6) {
        if (r6 != null) goto L11;
        return null;
    L11:
        StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L10
        int r2 = r6.length;     // Catch: Throwable -> L10
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L8;
        r1.append(String.format("%02x", new Object[]{Byte.valueOf(r6[r3])}));     // Catch: Throwable -> L10
        r3 = r3 + 1;     // Catch: Throwable -> L10
        goto L6
    L8:
        return r1.toString();
    L10:
        return null;
    }

    public static String encrypt(String r2, String r3) {
        byte[] r4 = r2.getBytes();
    L8:
        return null;
    L4:
        if (StringUtils.isEmpty(r3) == false) goto L6;
        r3 = "SHA-256";
    L6:
        MessageDigest r5 = MessageDigest.getInstance(r3);     // Catch: Throwable -> L8
        r5.update(r4);     // Catch: Throwable -> L8
        return bytes2Hex(r5.digest());
    }

    public static String encryptBySHA256(String r1) {
        return encrypt(r1, "SHA-256");
    }
}
