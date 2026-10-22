package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import java.util.Arrays;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static byte[] f7235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static byte[] f7236b;

    static {
    }

    public d0(String r1) {
        if (TextUtils.isDigitsOnly(r1) == false) goto L5;
        r1 = "SPUtil";
    L5:
        p5.a(r1);
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences a(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    public static int b(Context r1, String r2, String r3, int r4) {
        return a(r1, r2, 0).getInt(r3, r4);
    L5:
        th = move-exception;
        v.m(th, "csp", "giv");
        return r4;
    }

    public static long c(Context r1, String r2, String r3, long r4) {
        return a(r1, r2, 0).getLong(r3, r4);
    L5:
        th = move-exception;
        v.m(th, "csp", "glv");
        return r4;
    }

    public static SharedPreferences.Editor d(Context r2, String r3) {
        if (r2 != null) goto L12;
    L11:
        return null;
    L12:
    L9:
        th = move-exception;
        s.e(th, "sp", "ge");
        goto L11
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L11;
        return a(r2, r3, 0).edit();
    }

    public static String e(Context r2, String r3, String r4) {
        if (r2 != null) goto L9;
        return "";
    L9:
        return u5.g(r(r2, u5.y(a(r2, r3, 0).getString(r4, ""))));
    L11:
        return "";
    }

    public static void f(Context r1, String r2, String r3, String r4) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r3) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r4) == false) goto L12;
        return;
    L12:
        SharedPreferences.Editor r5 = a(r1, r2, 0).edit();     // Catch: Throwable -> L11
        r5.putString(r3, u5.E(o(r1, u5.o(r4))));     // Catch: Throwable -> L11
        g(r5);     // Catch: Throwable -> L11
        return;
    }

    public static void g(SharedPreferences.Editor r2) {
        if (r2 != null) goto L9;
        return;
    L9:
        r2.apply();     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        s.e(th, "sp", "cm");
    }

    public static void h(SharedPreferences.Editor r1, String r2) {
        if (r1 == null) goto L13;
    L8:
        th = move-exception;
        s.e(th, "sp", "rk");
        return;
    L4:
        if (TextUtils.isEmpty(r2) == true) goto L14;
        r1.remove(r2);     // Catch: Throwable -> L8
        return;
    L14:
        return;
    }

    public static void i(SharedPreferences.Editor r0, String r1, int r2) {
        r0.putInt(r1, r2);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        v.m(th, "csp", "putPrefsInt");
    }

    public static void j(SharedPreferences.Editor r1, String r2, long r3) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r2) == true) goto L14;
        r1.putLong(r2, r3);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        v.m(th, "csp", "plv");
        return;
    }

    public static void k(SharedPreferences.Editor r1, String r2, String r3) {
        if (r1 == null) goto L15;
    L10:
        th = move-exception;
        s.e(th, "sp", "ps");
        return;
    L4:
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r3) == true) goto L17;
        r1.putString(r2, r3);     // Catch: Throwable -> L10
        return;
    L17:
        return;
    }

    public static void l(SharedPreferences.Editor r0, String r1, boolean r2) {
        r0.putBoolean(r1, r2);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        v.m(th, "csp", "setPrefsStr");
    }

    public static boolean m(Context r1, String r2, String r3, boolean r4) {
        return a(r1, r2, 0).getBoolean(r3, r4);
    L5:
        th = move-exception;
        v.m(th, "csp", "gbv");
        return r4;
    }

    private static byte[] n(Context r2) {
        if (r2 == null) goto L4;
        byte[] r0 = f7235a;
        if (r0 != null) goto L8;
    L10:
        byte[] r3 = i5.j(r2).getBytes();
        f7235a = r3;
        return r3;
    L8:
        if (r0.length <= 0) goto L10;
        return r0;
    L4:
        return new byte[0];
    }

    public static byte[] o(Context r1, byte[] r2) {
        return m5.h(n(r1), r2, q(r1));
    L5:
        return new byte[0];
    }

    public static String p(Context r1, String r2, String r3, String r4) {
        if (r1 != null) goto L11;
        return null;
    L11:
        return a(r1, r2, 0).getString(r3, r4);
    L8:
        th = move-exception;
        v.m(th, "csp", "gsv");
        return r4;
    }

    private static byte[] q(Context r3) {
        byte[] r0 = f7236b;
        if (r0 != null) goto L5;
    L7:
        int r2 = 0;
        if (Build.VERSION.SDK_INT < 9) goto L10;
        f7236b = Arrays.copyOfRange(n(r3), 0, n(r3).length / 2);
    L15:
        return f7236b;
    L10:
        f7236b = new byte[n(r3).length / 2];
    L11:
        byte[] r1 = f7236b;
        if (r2 >= r1.length) goto L15;
        r1[r2] = n(r3)[r2];
        r2 = r2 + 1;
        goto L11
    L5:
        if (r0.length <= 0) goto L7;
        return r0;
    }

    public static byte[] r(Context r1, byte[] r2) {
        return m5.e(n(r1), r2, q(r1));
    L5:
        return new byte[0];
    }
}
