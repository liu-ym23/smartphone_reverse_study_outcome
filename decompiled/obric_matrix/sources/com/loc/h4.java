package com.loc;

import com.bytedance.bdlocation.exception.BDLocationException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes2.dex */
public final class h4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f7352a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte[] f7353b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final byte[] f7354c = null;

    static {
        f7352a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        f7353b = new byte[]{61, 61, 81, 65, 65, 69, 119, 65, 67, 48, 74, 80, 115, 116, 54, 75, 104, 76, 122, 97, 88, 99, 53, 71, 49, 122, 68, 70, 79, 104, 113, 113, 65, 97, 76, 54, 65, 66, 87, 53, 103, 85, 84, 113, 71, 68, 69, 76, 80, 82, 106, 51, 66, 75, 75, 69, 98, 55, 84, 108, 115, 122, 51, 106, 76, 55, 88, 122, 70, 121, 73, 75, 52, 50, 43, 101, 70, 121, 56, 105, 115, 105, 89, 120, 117, 112, 53, 48, 76, 81, 70, 86, 108, 110, 73, 65, 66, 74, 65, 83, 119, 65, 119, 83, 68, 65, 81, 66, 66, 69, 81, 65, 78, 99, 118, 104, 73, 90, 111, 75, 74, 89, 81, 68, 119, 119, 70, 77};
        byte[] r0 = {0, 1, 1, 2, 3, 5, 8, 13, 8, 7, 6, 5, 4, 3, 2, 1};
        f7354c = r0;
        new IvParameterSpec(r0);
    }

    public static String a(String r4) {
        if (r4 != null) goto L12;
    L11:
        return null;
    L12:
    L9:
        th = move-exception;
        s4.h(th, "Encrypt", "generatorKey");
        goto L11
    L5:
        if (r4.length() == 0) goto L11;
        return b("MD5", b("SHA1", r4) + r4);
    }

    public static String b(String r2, String r3) {
        if (r3 != null) goto L10;
        return null;
    L10:
        return i(p5.c(r3.getBytes("UTF-8"), r2));
    L7:
        th = move-exception;
        s4.h(th, "Encrypt", "encode");
        return null;
    }

    private static byte[] c() {
        return u5.v();
    }

    public static byte[] d(byte[] r3) {
        X509EncodedKeySpec r1 = new X509EncodedKeySpec(p3.a(new StringBuilder(new String(f7353b)).reverse().toString().getBytes()));
        PublicKey r0 = KeyFactory.getInstance("RSA").generatePublic(r1);
        Cipher r2 = Cipher.getInstance(u5.u("WUlNBL0VDQi9PQUVQV0lUSFNIQS0xQU5ETUdGMVBBRERJTkc"));
        r2.init(1, r0);
        return r2.doFinal(r3);
    }

    public static byte[] e(byte[] r3, String r4) {
        SecretKeySpec r5 = f(r4);     // Catch: Throwable -> L4
        IvParameterSpec r1 = new IvParameterSpec(c());     // Catch: Throwable -> L4
        Cipher r0 = Cipher.getInstance("AES/CBC/PKCS5Padding");     // Catch: Throwable -> L4
        r0.init(1, r5, r1);     // Catch: Throwable -> L4
        return r0.doFinal(r3);
    L4:
        th = move-exception;
        s4.h(th, "Encrypt", "aesEncrypt");
        return null;
    }

    private static SecretKeySpec f(String r2) {
        if (r2 != null) goto L4;
        r2 = "";
    L4:
        StringBuffer r0 = new StringBuffer(16);
    L5:
        r0.append(r2);
        if (r0.length() >= 16) goto L9;
        r2 = BDLocationException.ERROR_TIMEOUT;
        goto L5
    L9:
        if (r0.length() <= 16) goto L17;
        r0.setLength(16);
    L17:
        byte[] r3 = r0.toString().getBytes("UTF-8");     // Catch: Throwable -> L13
    L16:
        return new SecretKeySpec(r3, "AES");
    L13:
        th = move-exception;
        s4.h(th, "Encrypt", "createKey");
        r3 = null;
        goto L16
    }

    public static byte[] g(byte[] r6) {
        int r0 = 0;
        byte[] r2 = new byte[16];     // Catch: Throwable -> L5
        byte[] r3 = new byte[r6.length - 16];     // Catch: Throwable -> L5
        System.arraycopy(r6, 0, r2, 0, 16);     // Catch: Throwable -> L5
        System.arraycopy(r6, 16, r3, 0, r6.length - 16);     // Catch: Throwable -> L5
        SecretKeySpec r1 = new SecretKeySpec(r2, "AES");     // Catch: Throwable -> L5
        Cipher r4 = Cipher.getInstance("AES/CBC/PKCS5Padding");     // Catch: Throwable -> L5
        r4.init(2, r1, new IvParameterSpec(u5.v()));     // Catch: Throwable -> L5
        return r4.doFinal(r3);
    L5:
        th = move-exception;
        if (r6 == null) goto L8;
        r0 = r6.length;
    L8:
        s4.h(th, "Encrypt", "decryptRsponse length = ".concat(String.valueOf(r0)));
        return null;
    }

    public static byte[] h(byte[] r3, String r4) {
        SecretKeySpec r5 = f(r4);     // Catch: Throwable -> L4
        IvParameterSpec r1 = new IvParameterSpec(c());     // Catch: Throwable -> L4
        Cipher r0 = Cipher.getInstance("AES/CBC/PKCS5Padding");     // Catch: Throwable -> L4
        r0.init(2, r5, r1);     // Catch: Throwable -> L4
        return r0.doFinal(r3);
    L4:
        th = move-exception;
        s4.h(th, "Encrypt", "aesDecrypt");
        return null;
    }

    private static String i(byte[] r5) {
        int r0 = r5.length;
        StringBuilder r1 = new StringBuilder(r0 * 2);
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L6;
        char[] r3 = f7352a;
        r1.append(r3[(r5[r2] >> 4) & 15]);
        r1.append(r3[r5[r2] & 15]);
        r2 = r2 + 1;
        goto L3
    L6:
        return r1.toString();
    }
}
