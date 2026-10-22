package com.loc;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.exception.BDLocationException;
import java.io.ByteArrayOutputStream;
import java.security.PublicKey;

/* JADX INFO: loaded from: classes2.dex */
public final class k5 {

    private static class a {
        String A;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f7467a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f7468b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f7469c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        String f7470d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        String f7471e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        String f7472f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        String f7473g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        String f7474h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        String f7475i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        String f7476j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        String f7477k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        String f7478l;
        String m;
        String n;
        String o;
        String p;
        String q;
        String r;
        String s;
        String t;
        String u;
        String v;
        String w;
        String x;
        String y;
        String z;

        private a() {
        }

        /* synthetic */ a(byte r1) {
            this();
        }
    }

    public static String a() {
        String r0 = String.valueOf(System.currentTimeMillis());     // Catch: Throwable -> L8
        String r1 = LocationInfoConst.ALLOW_USE_LOCATION;
        if (i5.d() == true) goto L6;
        r1 = BDLocationException.ERROR_TIMEOUT;
    L6:
        int r2 = r0.length();     // Catch: Throwable -> L8
        return r0.substring(0, r2 - 2) + r1 + r0.substring(r2 - 1);
    L8:
        th = move-exception;
        s.e(th, "CI", "TS");
        return null;
    }

    public static String b(Context r0) {
        return i(r0);
    }

    public static String c(Context r3, String r4, String r5) {
        return p5.a(i5.i(r3) + ":" + r4.substring(0, r4.length() - 3) + ":" + r5);
    L5:
        th = move-exception;
        s.e(th, "CI", "Sco");
        return null;
    }

    private static String d(a r0) {
        return m5.f(j(r0));
    }

    private static void e(ByteArrayOutputStream r2, String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        u5.j(r2, (byte) 0, new byte[0]);
        return;
    L5:
        if (r3.getBytes().length <= 255) goto L7;
        byte r0 = -1;
    L8:
        u5.j(r2, r0, u5.o(r3));
        return;
    L7:
        r0 = (byte) r3.getBytes().length;
        goto L8
    }

    public static byte[] f(Context r0, boolean r1, boolean r2) {
        return j(h(r0, r1, r2));
    L4:
        th = move-exception;
        s.e(th, "CI", "gz");
        return null;
    }

    public static byte[] g(byte[] r0) {
        return m5.b(r0);
    }

    private static a h(Context r5, boolean r6, boolean r7) {
        a r0 = new a(0);
        r0.f7467a = l5.P();
        r0.f7468b = l5.I();
        String r2 = l5.F(r5);
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        r0.f7469c = r2;
        r0.f7470d = i5.g(r5);
        r0.f7471e = Build.MODEL;
        r0.f7472f = Build.MANUFACTURER;
        r0.f7473g = Build.DEVICE;
        r0.f7474h = i5.e(r5);
        r0.f7475i = i5.h(r5);
        r0.f7476j = String.valueOf(Build.VERSION.SDK_INT);
        r0.f7477k = l5.U();
        r0.f7478l = l5.T(r5);
        StringBuilder r3 = new StringBuilder();
        r3.append(l5.M(r5));
        r0.m = r3.toString();
        StringBuilder r4 = new StringBuilder();
        r4.append(l5.K(r5));
        r0.n = r4.toString();
        r0.o = l5.d0(r5);
        r0.p = l5.J(r5);
        r0.q = "";
        r0.r = "";
        if (r6 == false) goto L8;
        r0.s = "";
        r0.t = "";
    L9:
        r0.w = l5.o();
        String r1 = l5.p(r5);
        if (TextUtils.isEmpty(r1) == true) goto L12;
        r0.x = r1;
    L13:
        r0.y = "aid=" + l5.G();
        if (r7 == false) goto L18;
        if (g.f7306e == false) goto L18;
    L19:
        String r8 = l5.D(r5);
        if (TextUtils.isEmpty(r8) == true) goto L22;
        r0.y += "|oaid=" + r8;
    L22:
        String r9 = l5.N();
        if (TextUtils.isEmpty(r9) == true) goto L25;
        r0.y += "|multiImeis=" + r9;
    L25:
        String r10 = l5.S();
        if (TextUtils.isEmpty(r10) == true) goto L28;
        r0.y += "|meid=" + r10;
    L28:
        r0.y += "|serial=" + l5.E();
        String r11 = l5.v();
        if (TextUtils.isEmpty(r11) == true) goto L31;
        r0.y += "|adiuExtras=" + r11;
    L31:
        r0.y += "|storage=" + l5.W() + "|ram=" + l5.b0(r5) + "|arch=" + l5.Y();
        String r12 = r.a().g();
        if (TextUtils.isEmpty(r12) == true) goto L34;
        r0.z = r12;
    L35:
        if (r6 == false) goto L39;
        String r13 = c.a(r5).b();
        if (TextUtils.isEmpty(r13) == true) goto L39;
        r0.A = r13;
    L39:
        return r0;
    L34:
        r0.z = "";
    L18:
        if (g.f7307f == false) goto L22;
    L12:
        r0.x = "";
        goto L13
    L8:
        String[] r14 = l5.L();
        r0.s = r14[0];
        r0.t = r14[1];
        goto L9
    }

    private static String i(Context r2) {
        return d(h(r2, false, false));
    L5:
        th = move-exception;
        s.e(th, "CI", "gCXi");
        return null;
    }

    private static byte[] j(a r4) {
        ByteArrayOutputStream r1 = new ByteArrayOutputStream();     // Catch: Throwable -> L12
        e(r1, r4.f7467a);     // Catch: Throwable -> L10
        e(r1, r4.f7468b);     // Catch: Throwable -> L10
        e(r1, r4.f7469c);     // Catch: Throwable -> L10
        e(r1, r4.f7470d);     // Catch: Throwable -> L10
        e(r1, r4.f7471e);     // Catch: Throwable -> L10
        e(r1, r4.f7472f);     // Catch: Throwable -> L10
        e(r1, r4.f7473g);     // Catch: Throwable -> L10
        e(r1, r4.f7474h);     // Catch: Throwable -> L10
        e(r1, r4.f7475i);     // Catch: Throwable -> L10
        e(r1, r4.f7476j);     // Catch: Throwable -> L10
        e(r1, r4.f7477k);     // Catch: Throwable -> L10
        e(r1, r4.f7478l);     // Catch: Throwable -> L10
        e(r1, r4.m);     // Catch: Throwable -> L10
        e(r1, r4.n);     // Catch: Throwable -> L10
        e(r1, r4.o);     // Catch: Throwable -> L10
        e(r1, r4.p);     // Catch: Throwable -> L10
        e(r1, r4.q);     // Catch: Throwable -> L10
        e(r1, r4.r);     // Catch: Throwable -> L10
        e(r1, r4.s);     // Catch: Throwable -> L10
        e(r1, r4.t);     // Catch: Throwable -> L10
        e(r1, r4.u);     // Catch: Throwable -> L10
        e(r1, r4.v);     // Catch: Throwable -> L10
        e(r1, r4.w);     // Catch: Throwable -> L10
        e(r1, r4.x);     // Catch: Throwable -> L10
        e(r1, r4.y);     // Catch: Throwable -> L10
        e(r1, r4.z);     // Catch: Throwable -> L10
        e(r1, r4.A);     // Catch: Throwable -> L10
        byte[] r5 = r1.toByteArray();     // Catch: Throwable -> L10
        new String(r5);     // Catch: Throwable -> L10
        byte[] r6 = k(u5.t(r5));     // Catch: Throwable -> L10
        r1.close();     // Catch: Throwable -> L7
    L9:
        return r6;
    L7:
        th = move-exception;
        th.printStackTrace();
    L10:
        th = th;
    L38:
        s.e(th, "CI", "gzx");     // Catch: Throwable -> L21
        if (r1 != null) goto L34;
    L20:
        return null;
    L34:
        r1.close();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        th.printStackTrace();
    L21:
        th = move-exception;
        if (r1 != null) goto L30;
    L27:
        throw th;
    L30:
        r1.close();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        th.printStackTrace();
    L12:
        th = th;
        r1 = null;
        goto L38
    }

    private static byte[] k(byte[] r5) {
        PublicKey r0 = u5.x();
        if (r5.length <= 117) goto L6;
        byte[] r1 = new byte[117];
        System.arraycopy(r5, 0, r1, 0, 117);
        byte[] r2 = m5.c(r1, r0);
        byte[] r3 = new byte[(r5.length + 128) - 117];
        System.arraycopy(r2, 0, r3, 0, 128);
        System.arraycopy(r5, 117, r3, 128, r5.length - 117);
        return r3;
    L6:
        return m5.c(r5, r0);
    }
}
