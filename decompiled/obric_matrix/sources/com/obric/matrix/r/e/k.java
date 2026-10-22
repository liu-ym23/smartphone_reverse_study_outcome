package com.obric.matrix.r.e;

import android.content.Context;
import android.content.pm.Signature;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class k {
    static {
    }

    public static PublicKey a(Signature r2) {
        return CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(r2.toByteArray())).getPublicKey();
    }

    public static String b(Context r1, String r2) {
        ArrayList<String> r3 = c(r1, r2, "SHA256");
        if (r3 != null) goto L5;
        return "";
    L5:
        if (r3.isEmpty() == false) goto L7;
        return "";
    L7:
        return r3.get(0);
    }

    private static ArrayList<String> c(Context r5, String r6, String r7) {
        if (r5 == null) goto L21;
        if (r7 == null) goto L26;
        ArrayList<String> r0 = new ArrayList();
        Signature[] r8 = h(r5, r6);
        if (r8 == null) goto L20;
        int r9 = r8.length;
        int r1 = 0;
    L8:
        if (r1 >= r9) goto L20;
        Signature r2 = r8[r1];
        String r3 = "MD5";
        if ("MD5".equals(r7) == false) goto L12;
    L11:
        String r4 = f(r2, r3);
    L19:
        r0.add(r4);
        r1 = r1 + 1;
        goto L8
    L12:
        r3 = "SHA1";
        if ("SHA1".equals(r7) == true) goto L11;
        r3 = "SHA256";
        if ("SHA256".equals(r7) == true) goto L11;
        r4 = "error!";
    L20:
        return r0;
    L26:
        return null;
    L21:
        return null;
    }

    private static ArrayList<String> d(Context r5, String r6, String r7) {
        if (r5 == null) goto L21;
        if (r7 == null) goto L26;
        ArrayList<String> r0 = new ArrayList();
        Signature[] r8 = h(r5, r6);
        if (r8 == null) goto L20;
        int r9 = r8.length;
        int r1 = 0;
    L8:
        if (r1 >= r9) goto L20;
        Signature r2 = r8[r1];
        String r3 = "MD5";
        if ("MD5".equals(r7) == false) goto L12;
    L11:
        String r4 = g(r2, r3);
    L19:
        r0.add(r4);
        r1 = r1 + 1;
        goto L8
    L12:
        r3 = "SHA1";
        if ("SHA1".equals(r7) == true) goto L11;
        r3 = "SHA256";
        if ("SHA256".equals(r7) == true) goto L11;
        r4 = "";
    L20:
        return r0;
    L26:
        return null;
    L21:
        return null;
    }

    public static String e(Context r1, String r2) {
        ArrayList<String> r3 = d(r1, r2, "SHA256");
        if (r3 != null) goto L5;
        return "";
    L5:
        if (r3.isEmpty() == false) goto L7;
        return "";
    L7:
        return r3.get(0);
    }

    private static String f(Signature r5, String r6) {
        byte[] r7 = r5.toByteArray();
        byte[] r8 = MessageDigest.getInstance(r6).digest(r7);     // Catch: NoSuchAlgorithmException -> L8
        StringBuilder r9 = new StringBuilder();     // Catch: NoSuchAlgorithmException -> L8
        int r0 = r8.length;     // Catch: NoSuchAlgorithmException -> L8
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L6;
        r9.append(Integer.toHexString((r8[r1] & 255) | 256).substring(1, 3).toUpperCase());     // Catch: NoSuchAlgorithmException -> L8
        r1 = r1 + 1;     // Catch: NoSuchAlgorithmException -> L8
        goto L4
    L6:
        return r9.toString();
    L8:
        return "error!";
    }

    private static String g(Signature r5, String r6) {
        byte[] r7 = a(r5).getEncoded();     // Catch: Exception -> L7
        byte[] r8 = MessageDigest.getInstance(r6).digest(r7);     // Catch: Exception -> L7
        StringBuilder r9 = new StringBuilder();     // Catch: Exception -> L7
        int r0 = r8.length;     // Catch: Exception -> L7
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r9.append(Integer.toHexString((r8[r1] & 255) | 256).substring(1, 3).toUpperCase());     // Catch: Exception -> L7
        r1 = r1 + 1;     // Catch: Exception -> L7
        goto L3
    L5:
        return r9.toString();
    L7:
        return "";
    }

    private static Signature[] h(Context r1, String r2) {
        return r1.getPackageManager().getPackageInfo(r2, 64).signatures;
    L4:
        return null;
    }
}
