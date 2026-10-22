package com.bytedance.frameworks.encryptor;

/* JADX INFO: loaded from: classes.dex */
public class EncryptorUtil {
    static {
        System.loadLibrary("Encryptor");     // Catch: UnsatisfiedLinkError -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public EncryptorUtil() {
    }

    public static byte[] a(byte[] r2, int r3) {
        if (r2 == null) goto L10;
        if (r3 <= 0) goto L10;
        if (r2.length != r3) goto L10;
        return ttEncrypt(r2, r3);
    L10:
        return null;
    }

    private static native byte[] ttEncrypt(byte[] r0, int r1);
}
