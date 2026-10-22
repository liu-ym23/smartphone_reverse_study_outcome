package com.loc;

import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes2.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static byte[] f7578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String[] f7579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int[] f7580c;

    static {
        f7579b = new String[]{"kp6SsA", "cHE4dQ", "JKekrA", "XBxOHQ", "CSnpKw", "VwcThw", "wkp6Sg", "1cHE4Q"};
    }

    private static int a(int r3, int r4) {
        int r0 = 0;
        int r1 = 0;
    L3:
        if (r0 >= r4) goto L6;
        r1 = (r1 >> 1) | Integer.MIN_VALUE;
        r0 = r0 + 1;
        goto L3
    L6:
        return (r3 << r4) | ((r3 & r1) >>> (32 - r4));
    }

    public static String b() {
        SecureRandom r0 = new SecureRandom();
        KeyGenerator r1 = KeyGenerator.getInstance(u5.u("EQUVT"));     // Catch: Throwable -> L5
        r1.init(128, r0);     // Catch: Throwable -> L5
        return j.a(r1.generateKey().getEncoded());
    L5:
        return null;
    }

    private static String c(int r9) {
        char[] r1 = new char[4];
        int r3 = 0;
    L3:
        if (r3 >= 4) goto L10;
        int r4 = (4 - r3) - 1;
        r1[r4] = (char) ((r9 >>> (r3 * 8)) & 255);
        char r5 = r1[r4];
        String r6 = " ";
        int r7 = 0;
    L6:
        if (r7 >= 32) goto L8;
        r6 = r6 + (((Integer.MIN_VALUE >>> r7) & r5) >>> (31 - r7));
        r7 = r7 + 1;
        goto L6
    L8:
        r3 = r3 + 1;
        goto L3
    L10:
        return new String(r1);
    }

    public static String d(String r0) {
        return p5.a(r0);
    }

    private static String e(int[] r3) {
        StringBuilder r0 = new StringBuilder();
        if (r3 == null) goto L9;
        int r1 = 0;
    L6:
        if (r1 >= r3.length) goto L9;
        r0.append(c(a(g(r3[r1]), r1)));
        r1 = r1 + 1;
    L9:
        return r0.toString();
    }

    private static byte[] f(byte[] r4) {
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    L3:
        if (f7578a != null) goto L5;
        f7578a = u5.u("YAAAAAAAAAAAAAAAAAAAAAA").getBytes();     // Catch: Exception -> L7
    L5:
        IvParameterSpec r0 = new IvParameterSpec(f7578a);     // Catch: Exception -> L7
        SecretKeySpec r2 = new SecretKeySpec(e(i()).getBytes("UTF-8"), u5.u("EQUVT"));     // Catch: Exception -> L7
        Cipher r1 = Cipher.getInstance(u5.u("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));     // Catch: Exception -> L7
        r1.init(1, r2, r0);     // Catch: Exception -> L7
        return r1.doFinal(r4);
    }

    private static int g(int r4) {
        int r1 = 0;
        int r2 = 1;
    L4:
        if (r1 >= 15) goto L7;
        r2 = (r2 << 2) | 1;
        r1 = r1 + 1;
        goto L4
    L7:
        return ((r4 & r2) << 1) | (((r2 << 1) & r4) >>> 1);
    }

    public static String h(String r1) {
        return j.a(f(r1.getBytes("UTF-8")));
    L4:
        return null;
    }

    private static int[] i() {
        int[] r0 = f7580c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        int[] r1 = new int[8];
        int r3 = 0;
    L6:
        String[] r4 = f7579b;
        if (r3 >= r4.length) goto L9;
        byte[] r5 = m5.g(r4[r3]);
        r1[r3] = ((r5[0] & 255) << 24) | (((r5[3] & 255) | ((r5[2] & 255) << 8)) | ((r5[1] & 255) << 16));
        r3 = r3 + 1;
        goto L6
    L9:
        return r1;
    }
}
