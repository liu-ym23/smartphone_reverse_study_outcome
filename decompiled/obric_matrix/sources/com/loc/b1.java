package com.loc;

import android.content.Context;
import java.io.InputStream;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public final class b1 {
    public static v0 a(WeakReference<v0> r1) {
        if (r1 != null) goto L4;
    L5:
        r1 = new WeakReference(new v0());
    L7:
        return r1.get();
    L4:
        if (r1.get() != null) goto L7;
        goto L5
    }

    public static String b() {
        return u5.b(System.currentTimeMillis());
    }

    public static String c(Context r3, t5 r4) {
        StringBuilder r0 = new StringBuilder();
        String r1 = l5.C();     // Catch: Throwable -> L5
        r0.append("\"sim\":\"");     // Catch: Throwable -> L5
        r0.append(r1);     // Catch: Throwable -> L5
        r0.append("\",\"sdkversion\":\"");     // Catch: Throwable -> L5
        r0.append(r4.f());     // Catch: Throwable -> L5
        r0.append("\",\"product\":\"");     // Catch: Throwable -> L5
        r0.append(r4.a());     // Catch: Throwable -> L5
        r0.append("\",\"ed\":\"");     // Catch: Throwable -> L5
        r0.append(r4.g());     // Catch: Throwable -> L5
        r0.append("\",\"nt\":\"");     // Catch: Throwable -> L5
        r0.append(l5.y(r3));     // Catch: Throwable -> L5
        r0.append("\",\"np\":\"");     // Catch: Throwable -> L5
        r0.append(l5.w(r3));     // Catch: Throwable -> L5
        r0.append("\",\"mnc\":\"");     // Catch: Throwable -> L5
        r0.append(l5.B());     // Catch: Throwable -> L5
        r0.append("\",\"ant\":\"");     // Catch: Throwable -> L5
        r0.append(l5.A(r3));     // Catch: Throwable -> L5
        r0.append("\"");     // Catch: Throwable -> L5
    L8:
        return r0.toString();
    L5:
        th = move-exception;
        th.printStackTrace();
        goto L8
    }

    public static String d(String r1, String r2, int r3, String r4, String r5) {
        StringBuffer r0 = new StringBuffer();
        r0.append(r1);
        r0.append(",\"timestamp\":\"");
        r0.append(r2);
        r0.append("\",\"et\":\"");
        r0.append(r3);
        r0.append("\",\"classname\":\"");
        r0.append(r4);
        r0.append("\",");
        r0.append("\"detail\":\"");
        r0.append(r5);
        r0.append("\"");
        return r0.toString();
    }

    public static void e(Context r0, v0 r1, String r2, int r3, int r4, String r5) {
        r1.f7880a = t.j(r0, r2);
        r1.f7883d = r3;
        r1.f7881b = r4;
        r1.f7882c = r5;
    }

    static byte[] f(l0 r4, String r5) {
        byte[] r0 = new byte[0];
        InputStream r1 = null;
        l0.e r6 = r4.a(r5);     // Catch: Throwable -> L38
        if (r6 != null) goto L68;
        if (r6 != null) goto L78;
    L37:
        return r0;
    L78:
        r6.close();     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        th.printStackTrace();
        goto L37
    L68:
        InputStream r2 = r6.a();     // Catch: Throwable -> L30
        if (r2 != null) goto L18;
        if (r2 != null) goto L74;
    L12:
        if (r6 != null) goto L64;
    L17:
        return r0;
    L64:
        r6.close();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        th.printStackTrace();
        goto L17
    L74:
        r2.close();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.printStackTrace();
        goto L12
    L18:
        r0 = new byte[r2.available()];     // Catch: Throwable -> L30
        r2.read(r0);     // Catch: Throwable -> L30
        if (r2 != null) goto L70;
    L24:
        if (r6 != null) goto L82;
    L29:
        return r0;
    L82:
        r6.close();     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        th.printStackTrace();
        goto L29
    L70:
        r2.close();     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        th.printStackTrace();
    L30:
        th = th;
    L80:
        v.m(th, "sui", "rdS");     // Catch: Throwable -> L52
        if (0 != 0) goto L86;
    L46:
        if (r6 != null) goto L76;
    L51:
        return r0;
    L76:
        r6.close();     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        th.printStackTrace();
        goto L51
    L86:
        r1.close();     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        th.printStackTrace();
    L52:
        th = move-exception;
        if (0 != 0) goto L72;
    L58:
        if (r6 == null) goto L88;
        r6.close();     // Catch: Throwable -> L61
        throw th;
    L61:
        th = move-exception;
        th.printStackTrace();
        throw th;
    L88:
        throw th;
    L72:
        r1.close();     // Catch: Throwable -> L56
    L56:
        th = move-exception;
        th.printStackTrace();
    L38:
        th = th;
        r6 = null;
        goto L80
    }
}
