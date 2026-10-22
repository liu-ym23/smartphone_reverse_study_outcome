package com.bytedance.common.utility;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class StringEncryptUtils {
    public static final String MD5 = "MD5";
    public static final String SHA_1 = "SHA-1";
    public static final String SHA_256 = "SHA-256";

    private StringEncryptUtils() {
    }

    public static String bytes2Hex(byte[] r0) {
        return com.bytedance.android.standard.tools.security.StringEncryptUtils.bytes2Hex(r0);
    }

    public static String encrypt(String r0, String r1) {
        return com.bytedance.android.standard.tools.security.StringEncryptUtils.encrypt(r0, r1);
    }

    public static String encryptBySHA256(String r0) {
        return com.bytedance.android.standard.tools.security.StringEncryptUtils.encryptBySHA256(r0);
    }
}
