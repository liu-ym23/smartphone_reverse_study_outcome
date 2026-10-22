package com.obric.matrix.r.c;

import android.util.Log;
import com.ss.android.agilelogger.ALog;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f9920a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ALog.i f9921b;

    static {
    }

    public static void a(String r0, String r1) {
        d(r0, r1);
    }

    public static void b(String r2, String r3, Throwable r4) {
        if (f9920a == false) goto L5;
        Log.d(r2, "matrix_sensitive_log: " + r3, r4);
    L5:
        f(r2, r3, r4);
    }

    public static void c(String r2, String r3) {
        if (f9920a == false) goto L5;
        Log.e(r2, "matrix_sensitive_log: " + r3);
    L5:
        g(r2, r3);
    }

    public static void d(String r2, String r3) {
        if (f9920a == false) goto L5;
        Log.i(r2, "matrix_sensitive_log: " + r3);
    L5:
        ALog.i r0 = f9921b;
        if (r0 == null) goto L9;
        r0.b(r2, r3);
        return;
    }

    public static void e(com.ss.android.agilelogger.a r1, boolean r2) {
        f9921b = ALog.createInstance("SensitiveContent", r1);
        f9920a = r2;
    }

    private static void f(String r0, String r1, Throwable r2) {
        ALog.i r3 = f9921b;
        if (r3 == null) goto L6;
        r3.b(r0, r1);
        return;
    }

    private static void g(String r1, String r2) {
        ALog.i r0 = f9921b;
        if (r0 == null) goto L6;
        r0.a(r1, r2);
        return;
    }

    private static void h(String r1, String r2) {
        f9921b.b(r1, r2);
    }

    public static void i(String r0, String r1) {
        d(r0, r1);
    }

    public static void j(String r2, String r3, Throwable r4) {
        if (f9920a == false) goto L5;
        Log.v(r2, "matrix_sensitive_log: " + r3, r4);
    L5:
        d(r2, r3);
    }

    public static void k(String r2, String r3) {
        if (f9920a == false) goto L5;
        Log.w(r2, "matrix_sensitive_log: " + r3);
    L5:
        h(r2, r3);
    }
}
