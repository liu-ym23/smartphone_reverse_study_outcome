package com.bytedance.apm.internal;

import android.content.Context;
import android.content.SharedPreferences;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f1634a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static SharedPreferences f1635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f1636c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f1637d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static long f1638e;

    static {
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences a(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    public static long b() {
        return f1638e;
    }

    public static int c() {
        return (f1636c & (-536870912)) >>> 29;
    }

    public static boolean d(int r1) {
        if ((r1 & f1636c) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static synchronized void e(Context r4) {
        monitor-enter(a.class);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (f1634a == false) goto L9;
        monitor-exit(a.class);
        return;
    L9:
        f1634a = true;     // Catch: Throwable -> L17
        if (f1635b != null) goto L12;
        f1635b = a(r4, "monitor_switch_config", 0);     // Catch: Throwable -> L17
    L12:
        SharedPreferences r5 = f1635b;     // Catch: Throwable -> L17
        if (r5 == null) goto L15;
        int r6 = r5.getInt("monitor_switch_config_first_flag", 0);     // Catch: Throwable -> L17
        f1636c = r6;     // Catch: Throwable -> L17
        f1637d = r6;     // Catch: Throwable -> L17
        f1638e = f1635b.getLong("monitor_switch_config_atrace_flag", 0);     // Catch: Throwable -> L17
    L15:
        monitor-exit(a.class);
    }

    public static void f() {
        SharedPreferences r0 = f1635b;
        if (r0 == null) goto L6;
        r0.edit().putInt("monitor_switch_config_first_flag", f1637d).putLong("monitor_switch_config_atrace_flag", f1638e).apply();
        return;
    }

    public static void g(long r0) {
        f1638e = r0;
    }

    public static void h(int r1, int r2) {
        int r0 = f1637d;
        f1637d = (r2 & r1) + ((~r1) & r0);
    }

    public static void i(int r0, boolean r1) {
        if (r1 == false) goto L4;
        int r2 = r0 | f1637d;
    L5:
        f1637d = r2;
        return;
    L4:
        int r3 = f1637d;
        r2 = (~r0) & r3;
        goto L5
    }
}
