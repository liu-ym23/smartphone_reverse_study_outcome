package com.loc;

import android.os.SystemClock;
import android.text.TextUtils;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f7581a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f7582b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static HashMap<String, String> f7583c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static HashMap<String, String> f7584d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static HashMap<String, String> f7585e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static o0 f7586f;

    public interface a {
        URLConnection a();
    }

    static {
    }

    public o0() {
        j5.M();
    }

    private static int a(t0 r3, long r4) {
        k(r3);     // Catch: Throwable -> L21
        long r0 = 0;
        if (r4 == 0) goto L6;
        r0 = SystemClock.elapsedRealtime() - r4;     // Catch: Throwable -> L21
    L6:
        int r5 = r3.w();     // Catch: Throwable -> L21
        if (r3.y() != t0.a.f7804i) goto L9;
    L20:
        return r5;
    L9:
        if (r3.y() == t0.a.f7805j) goto L20;
        long r6 = r5;
        if (r0 >= r6) goto L19;
        long r7 = r6 - r0;     // Catch: Throwable -> L21
        if (r7 < 1000) goto L19;
        return (int) r7;
    L19:
        return Math.min(1000, r3.w());
    L21:
        return 5000;
    }

    public static o0 b() {
        if (f7586f != null) goto L6;
        f7586f = new o0();
    L6:
        return f7586f;
    }

    public static u0 c(t0 r1) {
        return e(r1, r1.B());
    }

    private static u0 d(t0 r0, t0.b r1, int r2) {
        k(r0);     // Catch: Throwable -> L4 h5 -> L7
        r0.e(r1);     // Catch: Throwable -> L4 h5 -> L7
        r0.o(r2);     // Catch: Throwable -> L4 h5 -> L7
        return new r0().c(r0);
    L7:
        e = move-exception;
        throw e;
    L4:
        th = move-exception;
        th.printStackTrace();
        throw new h5("未知的错误");
    }

    @Deprecated
    private static u0 e(t0 r7, boolean r8) {
        k(r7);
        if (r8 == false) goto L5;
        t0.c r9 = t0.c.f7815g;
    L6:
        r7.f(r9);
        u0 r10 = null;
        long r0 = 0;
        boolean r2 = false;
        if (g(r7) == false) goto L21;
        boolean r3 = i(r7);
        r0 = SystemClock.elapsedRealtime();     // Catch: h5 -> L11
        r10 = d(r7, f(r7, r3), j(r7, r3));     // Catch: h5 -> L11
    L11:
        e = move-exception;
        if (e.h() == 21) goto L15;
    L18:
        if (r3 == false) goto L20;
        r2 = true;
        goto L21
    L20:
        throw e;
    L15:
        if (r7.y() != t0.a.f7802g) goto L18;
        throw e;
    L21:
        if (r10 == null) goto L32;
        byte[] r4 = r10.f7856a;
        if (r4 == null) goto L32;
        if (r4.length <= 0) goto L32;
        return r10;
    L32:
        return d(r7, h(r7, r2), a(r7, r0));
    L30:
        e = move-exception;
        throw e;
    L5:
        r9 = t0.c.f7814f;
        goto L6
    }

    private static t0.b f(t0 r2, boolean r3) {
        if (r2.y() != t0.a.f7804i) goto L7;
        return t0.b.f7811k;
    L7:
        if (r2.y() == t0.a.f7805j) goto L9;
        if (r3 == false) goto L14;
        return t0.b.f7807g;
    L14:
        return t0.b.f7808h;
    L9:
        return t0.b.f7808h;
    }

    private static boolean g(t0 r2) {
        k(r2);
        String r0 = r2.m();     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r0) == false) goto L7;
        return false;
    L7:
        String r1 = new URL(r0).getHost();     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r2.s()) == true) goto L10;
        r1 = r2.s();     // Catch: Throwable -> L12
    L10:
        return j5.S(r1);
    L12:
        return true;
    }

    private static t0.b h(t0 r1, boolean r2) {
        if (r1.y() != t0.a.f7804i) goto L9;
        if (r2 == false) goto L8;
        return t0.b.f7812l;
    L8:
        return t0.b.m;
    L9:
        if (r2 == false) goto L13;
        return t0.b.f7809i;
    L13:
        return t0.b.f7810j;
    }

    private static boolean i(t0 r3) {
        k(r3);
        if (g(r3) == true) goto L6;
        return true;
    L6:
        String r1 = r3.m();     // Catch: Throwable -> L16
        if (r3.j().equals(r1) == false) goto L10;
        return false;
    L10:
        if (r3.y() != t0.a.f7805j) goto L12;
        return false;
    L12:
        if (j5.w == true) goto L15;
        return false;
    L15:
        return true;
    }

    private static int j(t0 r4, boolean r5) {
        k(r4);     // Catch: Throwable -> L12
        int r0 = r4.w();     // Catch: Throwable -> L12
        int r1 = j5.s;     // Catch: Throwable -> L12
        if (r4.y() == t0.a.f7804i) goto L11;
        if (r4.y() == t0.a.f7805j) goto L11;
        if (r0 >= r1) goto L9;
        return r0;
    L9:
        if (r5 == false) goto L11;
        return r1;
    L11:
        return r0;
    L12:
        return 5000;
    }

    private static void k(t0 r1) {
        if (r1 == null) goto L11;
        if (r1.j() == null) goto L9;
        if ("".equals(r1.j()) == true) goto L9;
        return;
    L9:
        throw new h5("request url is empty");
    L11:
        throw new h5("requeust is null");
    }
}
