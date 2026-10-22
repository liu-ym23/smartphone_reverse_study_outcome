package com.obric.matrix.r.c;

import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f9917a = false;

    static {
    }

    public static void a(String r1) {
        b("Matrix", r1);
    }

    public static void b(String r1, String r2) {
        c(r1, r2, null);
    }

    public static void c(String r2, String r3, Throwable r4) {
        if (f9917a == false) goto L5;
        Log.d(r2, "matrix_log: " + r3, r4);
    L5:
        l(r2, r3, r4);
    }

    public static void d(String r0, String r1) {
    }

    public static void e(String r1) {
        f("Matrix", r1);
    }

    public static void f(String r1, String r2) {
        g(r1, r2, null);
    }

    public static void g(String r2, String r3, Throwable r4) {
        if (f9917a == false) goto L5;
        Log.e(r2, "matrix_log: " + r3, r4);
    L5:
        m(r2, r3, r4);
    }

    public static void h(String r2, Throwable r3) {
        g("Matrix", "matrix_log: " + r2, r3);
    }

    public static String i(String r2) {
        return "Matrix" + r2;
    }

    public static void j(String r1, String r2) {
        k(r1, r2, null);
    }

    public static void k(String r2, String r3, Throwable r4) {
        if (f9917a == false) goto L5;
        Log.i(r2, "matrix_log: " + r3, r4);
    L5:
        n(r2, r3, r4);
    }

    private static void l(String r0, String r1, Throwable r2) {
        b.f9916a.a(r0, r1);
    }

    private static void m(String r1, String r2, Throwable r3) {
        if (r3 != null) goto L4;
        b.f9916a.b(r1, r2);
        return;
    L4:
        b.f9916a.c(r1, r2, r3);
    }

    private static void n(String r0, String r1, Throwable r2) {
        b.f9916a.e(r0, r1);
    }

    private static void o(String r0, String r1, Throwable r2) {
        b.f9916a.f(r0, r1);
    }

    private static void p(String r1, String r2, Throwable r3) {
        if (r3 != null) goto L4;
        b.f9916a.g(r1, r2);
        return;
    L4:
        b.f9916a.h(r1, r2, r3);
    }

    public static void q(String r1, String r2) {
        r(r1, r2, null);
    }

    public static void r(String r2, String r3, Throwable r4) {
        if (f9917a == false) goto L5;
        Log.v(r2, "matrix_log: " + r3, r4);
    L5:
        o(r2, r3, r4);
    }

    public static void s(String r1, String r2) {
        t(r1, r2, null);
    }

    public static void t(String r2, String r3, Throwable r4) {
        if (f9917a == false) goto L5;
        Log.w(r2, "matrix_log: " + r3, r4);
    L5:
        p(r2, r3, r4);
    }
}
