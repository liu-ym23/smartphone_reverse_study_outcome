package com.loc;

import java.security.MessageDigest;

/* JADX INFO: loaded from: classes2.dex */
public final class p5 {
    public static String a(String r0) {
        if (r0 != null) goto L6;
        return null;
    L6:
        return u5.B(e(r0));
    }

    public static String b(byte[] r1) {
        return u5.B(c(r1, u5.u("ETUQ1")));
    }

    public static byte[] c(byte[] r1, String r2) {
        MessageDigest r3 = MessageDigest.getInstance(r2);     // Catch: Throwable -> L4
        r3.update(r1);     // Catch: Throwable -> L4
        return r3.digest();
    L4:
        th = move-exception;
        s.e(th, "MD5", "gmb");
        return null;
    }

    public static String d(String r0) {
        return u5.C(f(r0));
    }

    private static byte[] e(String r2) {
        return g(r2);
    L4:
        th = move-exception;
        s.e(th, "MD5", "gmb");
        return new byte[0];
    }

    private static byte[] f(String r0) {
        return g(r0);
    L4:
        th = move-exception;
        th.printStackTrace();
        return new byte[0];
    }

    private static byte[] g(String r1) {
        if (r1 != null) goto L5;
        return null;
    L5:
        MessageDigest r0 = MessageDigest.getInstance(u5.u("ETUQ1"));
        r0.update(u5.o(r1));
        return r0.digest();
    }
}
