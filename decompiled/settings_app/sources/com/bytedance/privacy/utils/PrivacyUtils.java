package com.bytedance.privacy.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes3.dex */
public class PrivacyUtils {
    public static final String TAG = "PrivacyUtils";

    static {
    }

    public PrivacyUtils() {
    }

    public static String byteArrayToHexString(byte[] r6) {
        StringBuilder r0 = new StringBuilder();
        int r1 = r6.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L6;
        r0.append(String.format("%02x", new Object[]{Byte.valueOf(r6[r3])}));
        r3 = r3 + 1;
        goto L3
    L6:
        return r0.toString();
    }

    public static byte[] hexStringToByteArray(String r6) {
        if ((r6.length() % 2) == 0) goto L6;
        LogUtils.e(TAG, "Invalid hex string length:" + r6.length());
        return new byte[0];
    L6:
        int r0 = r6.length() / 2;
        byte[] r2 = new byte[r0];
        int r3 = 0;
    L7:
        if (r3 >= r0) goto L14;
        int r4 = r3 * 2;
        r2[r3] = (byte) Integer.parseInt(r6.substring(r4, r4 + 2), 16);     // Catch: Exception -> L11
        r3 = r3 + 1;
    L11:
        e = move-exception;
        LogUtils.e(TAG, "Hex string to byte array failed, error:" + e.getMessage());
        return new byte[0];
    L14:
        return r2;
    }

    public static byte[] messageDigest(byte[] r0, String r1) {
        MessageDigest r2 = MessageDigest.getInstance(r1);     // Catch: Exception -> L4
        r2.update(r0);     // Catch: Exception -> L4
        return r2.digest();
    L4:
        LogUtils.e(TAG, "SHA256 failed.");
        return new byte[0];
    }

    public static String sha256ToHexString(String r1) {
        return byteArrayToHexString(messageDigest(r1.getBytes(StandardCharsets.UTF_8), "SHA-256"));
    }
}
