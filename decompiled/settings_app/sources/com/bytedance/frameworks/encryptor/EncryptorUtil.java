package com.bytedance.frameworks.encryptor;

/* JADX INFO: loaded from: classes3.dex */
public class EncryptorUtil {
    private static native byte[] ttEncrypt(byte[] r0, int r1);

    public EncryptorUtil() {
    }

    static {
        System.loadLibrary("Encryptor");     // Catch: UnsatisfiedLinkError -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static byte[] encrypt(byte[] r2, int r3) {
        if (r2 == null) goto L10;
        if (r3 <= 0) goto L10;
        if (r2.length != r3) goto L10;
        return ttEncrypt(r2, r3);
    L10:
        return null;
    }
}
