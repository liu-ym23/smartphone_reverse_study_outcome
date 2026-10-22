package com.obric.android.alog;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Alog f8082a;

    static {
    }

    public static void a() {
        Alog r0 = f8082a;
        if (r0 == null) goto L6;
        r0.h();
        return;
    }

    public static long b() {
        Alog r0 = f8082a;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.l();
    }

    @Deprecated
    public static void c(String r1, String r2) {
        j(1, r1, r2);
    }

    @Deprecated
    public static void d(String r1, String r2) {
        j(4, r1, r2);
    }

    @Deprecated
    public static void e(String r1, String r2) {
        j(2, r1, r2);
    }

    @Deprecated
    public static void f(int r1, String r2, String r3) {
        Alog r0 = f8082a;
        if (r0 == null) goto L6;
        r0.q(r1, r2, r3);
        return;
    }

    @Deprecated
    public static void g(int r8, String r9, String r10, long r11, long r13) {
        Alog r0 = f8082a;
        if (r0 == null) goto L6;
        r0.r(r8, r9, r10, r11, r13);
        return;
    }

    public static void h(Alog r2) {
        f8082a = r2;
        if (r2 != null) goto L5;
        long r0 = 0;
    L6:
        Alog.nativeSetDefaultInstance(r0);
        return;
    L5:
        r0 = r2.m();
        goto L6
    }

    public static void i(int r1) {
        Alog r0 = f8082a;
        if (r0 == null) goto L6;
        r0.p(r1);
        return;
    }

    @Deprecated
    public static void j(int r1, String r2, String r3) {
        Alog r0 = f8082a;
        if (r0 == null) goto L6;
        r0.q(r1, r2, r3);
        return;
    }
}
