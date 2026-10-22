package com.bytedance.applog.util;

import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public class e {
    private static String a(byte[] r5) {
        StringBuilder r0 = new StringBuilder();
        int r1 = 0;
    L3:
        if (r5 == null) goto L11;
        if (r1 >= r5.length) goto L11;
        String r2 = Integer.toHexString(r5[r1] & 255);
        if (r2.length() != 1) goto L9;
        r0.append('0');
    L9:
        r0.append(r2);
        r1 = r1 + 1;
    L11:
        return r0.toString();
    }

    public static byte[] b(byte[] r3, String r4, String r5) {
        Cipher r0 = Cipher.getInstance("AES/CBC/PKCS7PADDING");     // Catch: Throwable -> L4
        r0.init(2, new SecretKeySpec(h(r4), "AES"), new IvParameterSpec(h(r5)));     // Catch: Throwable -> L4
        return r0.doFinal(r3);
    L4:
        th = move-exception;
        n.h("Cannot decrypt aes cbc", th);
        return null;
    }

    public static byte[] c(byte[] r2) {
        if (r2 != null) goto L6;
        return new byte[0];
    L6:
        if (com.bytedance.applog.a.n() == false) goto L13;
        d.b.m.a r0 = com.bytedance.applog.a.s().l();
        if (r0 == null) goto L10;
        r2 = r0.a(r2, r2.length);
    L11:
        if (r2 != null) goto L13;
        com.bytedance.applog.o.b.d(com.bytedance.applog.r.b.a.n, com.bytedance.applog.r.b.d.t);
        goto L13
    L10:
        r2 = d.b.h.b.a.b.a(r2, r2.length);
    L13:
        return r2;
    }

    public static String[] d() {
        KeyGenerator r1 = KeyGenerator.getInstance("AES");     // Catch: Throwable -> L8
        SecureRandom r2 = new SecureRandom();     // Catch: Throwable -> L8
        r1.init(128, r2);     // Catch: Throwable -> L8
        byte[] r3 = new byte[8];     // Catch: Throwable -> L8
        r2.nextBytes(r3);     // Catch: Throwable -> L8
        String[] r0 = {a(r1.generateKey().getEncoded()), a(r3)};     // Catch: Throwable -> L8
        if (g(r0) == false) goto L6;
        return r0;
    L6:
        return null;
    L11:
        return null;
    }

    public static byte[] e(byte[] r3) {
        if (r3 == null) goto L4;
        ByteArrayOutputStream r0 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r1 = null;
        GZIPOutputStream r2 = new GZIPOutputStream(r0);     // Catch: Throwable -> L12
        r2.write(r3);     // Catch: Throwable -> L10
        r2.close();     // Catch: IOException -> L22
    L24:
    L10:
        th = th;
        r1 = r2;
    L31:
        n.i(th);     // Catch: Throwable -> L18
        if (r1 == null) goto L17;
        r1.close();     // Catch: IOException -> L22
    L18:
        th = move-exception;
        if (r1 != null) goto L27;
    L21:
        throw th;
    L27:
        r1.close();     // Catch: IOException -> L23
    L12:
        th = th;
    L17:
        return r0.toByteArray();
    L4:
        return new byte[0];
    }

    public static byte[] f(byte[] r6) {
        GZIPInputStream r0 = null;
        if (r6 != null) goto L5;
    L38:
        return null;
    L5:
        if (r6.length <= 0) goto L38;
        ByteArrayOutputStream r1 = new ByteArrayOutputStream();
        ByteArrayInputStream r2 = new ByteArrayInputStream(r6);     // Catch: Throwable -> L24 IOException -> L31
        GZIPInputStream r7 = new GZIPInputStream(r2);     // Catch: Throwable -> L22 IOException -> L43
        goto L32
    L59:
        byte[] r3 = new byte[1024];     // Catch: Throwable -> L19 IOException -> L21
    L12:
        int r4 = r7.read(r3);     // Catch: Throwable -> L19 IOException -> L21
        if (r4 < 0) goto L47;
        r1.write(r3, 0, r4);     // Catch: Throwable -> L19 IOException -> L21
    L47:
        r7.close();     // Catch: IOException -> L39
    L51:
        r2.close();     // Catch: IOException -> L40
    L37:
        return r1.toByteArray();
    L21:
        r0 = r7;
    L19:
        Throwable th = th;
    L26:
        if (r7 != null) goto L53;
    L28:
        if (r2 == null) goto L62;
        r2.close();     // Catch: IOException -> L42
        throw th;
    L63:
        throw th;
    L62:
        throw th;
    L53:
        r7.close();     // Catch: IOException -> L41
    L22:
        th = move-exception;
        th = th;
        r7 = null;
    L32:
        if (r0 != null) goto L45;
    L34:
        if (r2 == null) goto L37;
    L45:
        r0.close();     // Catch: IOException -> L44
        goto L34
    L31:
        r2 = null;
    L24:
        th = move-exception;
        r2 = null;
        th = th;
        r7 = null;
        goto L26
    }

    public static boolean g(String[] r3) {
        if (r3 != null) goto L5;
    L16:
        return false;
    L5:
        if (r3.length != 2) goto L16;
        if (TextUtils.isEmpty(r3[0]) == true) goto L16;
        if (r3[0].length() != 32) goto L16;
        if (TextUtils.isEmpty(r3[1]) == true) goto L16;
        if (r3[1].length() != 16) goto L16;
        return true;
    }

    private static byte[] h(String r4) {
        int r0 = r4.length();
        byte[] r1 = new byte[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1[r2] = (byte) r4.charAt(r2);
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    public static byte[] i(String r1) {
        byte[] r2 = r1.getBytes("UTF-8");     // Catch: UnsupportedEncodingException -> L4
    L7:
        if (com.bytedance.applog.a.n() == false) goto L10;
        r2 = e(r2);
    L10:
        return c(r2);
    L4:
        e = move-exception;
        n.i(e);
        r2 = null;
        goto L7
    }
}
