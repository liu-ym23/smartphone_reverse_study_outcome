package com.android.settings.activate;

import android.text.TextUtils;
import android.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes2.dex */
public class Keys {
    private static final String TAG = "key";

    private static native byte[] jniDecrypt(byte[] r0, byte[] r1, byte[] r2, byte[] r3, byte[] r4, byte[] r5, byte[] r6, byte[] r7, byte[] r8, int r9);

    private static native byte[] jniEncrypt(byte[] r0, byte[] r1, byte[] r2, int r3);

    public Keys() {
    }

    public static final String encrypt(String r1, String r2, String r3, int r4) {
        if (TextUtils.isEmpty(r1) == true) goto L9;
        if (TextUtils.isEmpty(r2) == true) goto L9;
        String r5 = sha256(r1);
        String r6 = sha256(r2);
        String r7 = sha256(r3);
        byte[] r8 = r6.getBytes();
        return Base64.encodeToString(jniEncrypt(r5.getBytes(), r8, r7.getBytes(), r4), 2);
    L9:
        throw new RuntimeException("key is null");
    }

    public static final String decrypt(String r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, int r19) {
        return bytesToHexString(jniDecrypt(r10.getBytes(), r11.getBytes(), r12.getBytes(), r13.getBytes(), r14.getBytes(), r15.getBytes(), r16.getBytes(), r17.getBytes(), r18.getBytes(), r19));
    }

    private static final String sha256(String r1) {
        MessageDigest r0 = MessageDigest.getInstance("SHA-256");     // Catch: NoSuchAlgorithmException -> L4
        r0.update(r1.getBytes());     // Catch: NoSuchAlgorithmException -> L4
        return bytesToHexString(r0.digest());
    L4:
        e = move-exception;
        e.printStackTrace();
        return e.toString();
    }

    private static final String bytesToHexString(byte[] r5) {
        StringBuilder r0 = new StringBuilder();
        int r1 = 0;
    L4:
        if (r1 >= r5.length) goto L10;
        String r2 = Integer.toHexString(r5[r1] & 255);
        if (r2.length() != 1) goto L8;
        r0.append('0');
    L8:
        r0.append(r2);
        r1 = r1 + 1;
        goto L4
    L10:
        return r0.toString();
    }

    static {
        System.loadLibrary("token_jni");
    }
}
