package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public final class z4 {
    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences a(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    public static int b(Context r1, String r2, String r3, int r4) {
        return a(r1, r2, 0).getInt(r3, r4);
    L5:
        th = move-exception;
        s4.h(th, "SpUtil", "getPrefsInt");
        return r4;
    }

    public static long c(Context r1, String r2, String r3, long r4) {
        return a(r1, r2, 0).getLong(r3, r4);
    L5:
        th = move-exception;
        s4.h(th, "SpUtil", "getPrefsLong");
        return r4;
    }

    public static SharedPreferences.Editor d(Context r1, String r2) {
        return a(r1, r2, 0).edit();
    }

    public static String e(Context r3) {
        if (r3 != null) goto L6;
        return "00:00:00:00:00:00";
    L6:
        return f(r3, "pref", "smac", "00:00:00:00:00:00");
    }

    public static String f(Context r1, String r2, String r3, String r4) {
        return a(r1, r2, 0).getString(r3, r4);
    L5:
        th = move-exception;
        s4.h(th, "SpUtil", "getPrefsInt");
        return r4;
    }

    public static void g(SharedPreferences.Editor r0) {
        if (r0 != null) goto L4;
        return;
    L4:
        r0.apply();
    }

    public static void h(SharedPreferences.Editor r1, String r2) {
        r1.remove(r2);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        s4.h(th, "SpUtil", "setPrefsLong");
    }

    public static void i(SharedPreferences.Editor r0, String r1, int r2) {
        r0.putInt(r1, r2);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        s4.h(th, "SpUtil", "setPrefsInt");
    }

    public static void j(SharedPreferences.Editor r0, String r1, long r2) {
        r0.putLong(r1, r2);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        s4.h(th, "SpUtil", "setPrefsLong");
    }

    public static void k(SharedPreferences.Editor r0, String r1, String r2) {
        r0.putString(r1, r2);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        s4.h(th, "SpUtil", "setPrefsStr");
    }

    public static void l(SharedPreferences.Editor r0, String r1, boolean r2) {
        r0.putBoolean(r1, r2);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        s4.h(th, "SpUtil", "updatePrefsBoolean");
    }

    public static boolean m(Context r1, String r2, String r3, boolean r4) {
        return a(r1, r2, 0).getBoolean(r3, r4);
    L5:
        th = move-exception;
        s4.h(th, "SpUtil", "getPrefsBoolean");
        return r4;
    }
}
