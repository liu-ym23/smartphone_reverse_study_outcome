package com.obric.matrix.server.t.b;

import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f10031a = false;

    static {
    }

    public static void a(String r1, String r2) {
        b(r1, r2, null);
    }

    public static void b(String r2, String r3, Throwable r4) {
        Log.d("MatrixThird", "d: sPrintable = " + f10031a);
        if (f10031a == false) goto L5;
        Log.d(r2, "PlatformLoader: " + r3, r4);
    L5:
        e(r2, r3, r4);
    }

    public static void c(String r1, String r2) {
        d(r1, r2, null);
    }

    public static void d(String r2, String r3, Throwable r4) {
        if (f10031a == false) goto L5;
        Log.e(r2, "PlatformLoader: " + r3, r4);
    L5:
        f(r2, r3, r4);
    }

    private static void e(String r2, String r3, Throwable r4) {
        a.f10022a.b(3, r2, "PlatformLoader: " + r3);
    }

    private static void f(String r3, String r4, Throwable r5) {
        if (r5 != null) goto L5;
        a.f10022a.b(6, r3, "PlatformLoader: " + r4);
        return;
    L5:
        a.f10022a.a(r3, "PlatformLoader: " + r4, r5);
    }

    private static void g(String r2, String r3, Throwable r4) {
        a.f10022a.b(2, r2, "PlatformLoader: " + r3);
    }

    private static void h(String r3, String r4, Throwable r5) {
        if (r5 != null) goto L5;
        a.f10022a.b(5, r3, "PlatformLoader: " + r4);
        return;
    L5:
        a.f10022a.c(r3, "PlatformLoader: " + r4, r5);
    }

    public static void i(String r2, String r3, Throwable r4) {
        if (f10031a == false) goto L5;
        Log.v(r2, "PlatformLoader: " + r3, r4);
    L5:
        g(r2, r3, r4);
    }

    public static void j(String r1, String r2) {
        k(r1, r2, null);
    }

    public static void k(String r2, String r3, Throwable r4) {
        if (f10031a == false) goto L5;
        Log.w(r2, "PlatformLoader: " + r3, r4);
    L5:
        h(r2, r3, r4);
    }
}
