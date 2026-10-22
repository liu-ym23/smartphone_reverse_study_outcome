package com.bytedance.android.alog;

import java.io.File;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Alog f618a;

    static {
    }

    public static void a() {
        Alog r0 = f618a;
        if (r0 == null) goto L6;
        r0.h();
        return;
    }

    public static void b() {
        Alog.nativeSetDefaultInstance(0);
        f618a.i();
        f618a = null;
    }

    public static void c(String r1, String r2) {
        t(1, r1, r2);
    }

    public static void d(String r1, String r2) {
        t(4, r1, r2);
    }

    public static HashMap<String, String> e() {
        Alog r0 = f618a;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.l();
    }

    public static long f() {
        Alog r0 = f618a;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.m();
    }

    public static long g() {
        Alog r0 = f618a;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.n();
    }

    public static long h() {
        Alog r0 = f618a;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.o();
    }

    public static File[] i(String r7, String r8, long r9, long r11) {
        Alog r0 = f618a;
        if (r0 == null) goto L7;
        return r0.p(r7, r8, r9, r11);
    L7:
        return new File[0];
    }

    public static long j() {
        Alog r0 = f618a;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.r();
    }

    public static String k() {
        Alog r0 = f618a;
        if (r0 != null) goto L5;
        return "default log instance is null";
    L5:
        return r0.s();
    }

    public static void l(String r1, String r2) {
        t(2, r1, r2);
    }

    public static void m(Alog r2) {
        f618a = r2;
        if (r2 != null) goto L5;
        long r0 = 0;
    L6:
        Alog.nativeSetDefaultInstance(r0);
        return;
    L5:
        r0 = r2.q();
        goto L6
    }

    public static void n(int r1) {
        Alog r0 = f618a;
        if (r0 == null) goto L6;
        r0.v(r1);
        return;
    }

    public static void o(boolean r1) {
        Alog r0 = f618a;
        if (r0 == null) goto L6;
        r0.w(r1);
        return;
    }

    public static void p() {
        Alog r0 = f618a;
        if (r0 == null) goto L6;
        r0.x();
        return;
    }

    public static void q(int r1) {
        Alog r0 = f618a;
        if (r0 == null) goto L6;
        r0.y(r1);
        return;
    }

    public static void r(String r1, String r2) {
        t(0, r1, r2);
    }

    public static void s(String r1, String r2) {
        t(3, r1, r2);
    }

    public static void t(int r1, String r2, String r3) {
        Alog r0 = f618a;
        if (r0 == null) goto L6;
        r0.B(r1, r2, r3);
        return;
    }

    public static void u(int r8, String r9, String r10, long r11, long r13) {
        Alog r0 = f618a;
        if (r0 == null) goto L6;
        r0.C(r8, r9, r10, r11, r13);
        return;
    }
}
