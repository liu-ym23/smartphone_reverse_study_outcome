package com.bytedance.ttnet.j;

import android.content.Context;
import android.content.SharedPreferences;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile d f6354f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Object f6355g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile SharedPreferences f6356h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile Context f6357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile int f6358b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile long f6359c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile int f6360d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile int f6361e;

    static {
        f6355g = new Object();
    }

    private d(Context r1) {
        if (r1 == null) goto L5;
        this.f6357a = r1.getApplicationContext();
    L5:
        e();
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences a(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    public static d b(Context r2) {
        if (f6354f != null) goto L15;
        Object r0 = f6355g;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f6354f != null) goto L9;
        f6354f = new d(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L15:
        return f6354f;
    }

    public static d c() {
        return f6354f;
    }

    private SharedPreferences d() {
        if (f6356h != null) goto L6;
        f6356h = a(this.f6357a, "image_opt_table", 0);
    L6:
        return f6356h;
    }

    private void e() {
        SharedPreferences r0 = d();     // Catch: Throwable -> L4
        this.f6358b = r0.getInt("image_opt_switch", 0);     // Catch: Throwable -> L4
        this.f6359c = r0.getLong("image_opt_black_interval", 0);     // Catch: Throwable -> L4
        this.f6360d = r0.getInt("image_opt_failed_times", 0);     // Catch: Throwable -> L4
        this.f6361e = r0.getInt("image_opt_limit_count", 0);     // Catch: Throwable -> L4
        return;
    }

    public void f(JSONObject r12) {
        if (r12 == null) goto L24;
        if (r12.length() <= 0) goto L25;
        int r5 = r12.optInt("image_opt_switch", 0);     // Catch: Throwable -> L21
        long r6 = r12.optLong("image_opt_black_interval", 0);     // Catch: Throwable -> L21
        int r8 = r12.optInt("image_opt_failed_times", 0);     // Catch: Throwable -> L21
        int r13 = r12.optInt("image_opt_limit_count", 0);     // Catch: Throwable -> L21
        SharedPreferences.Editor r4 = d().edit();     // Catch: Throwable -> L21
        if (r5 == this.f6358b) goto L11;
        r4.putInt("image_opt_switch", r5);     // Catch: Throwable -> L21
    L11:
        if (r6 == this.f6359c) goto L14;
        r4.putLong("image_opt_black_interval", r6);     // Catch: Throwable -> L21
    L14:
        if (r8 == this.f6360d) goto L17;
        r4.putInt("image_opt_failed_times", r8);     // Catch: Throwable -> L21
    L17:
        if (r13 == this.f6361e) goto L19;
        r4.putInt("image_opt_limit_count", r13);     // Catch: Throwable -> L21
    L19:
        r4.apply();     // Catch: Throwable -> L21
        this.f6358b = r5;     // Catch: Throwable -> L21
        this.f6359c = r6;     // Catch: Throwable -> L21
        this.f6360d = r8;     // Catch: Throwable -> L21
        this.f6361e = r13;     // Catch: Throwable -> L21
        return;
    L25:
        return;
    L26:
        return;
    }
}
