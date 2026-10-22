package com.obric.matrix.q.e;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Map<String, b> f9852b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SharedPreferences f9853a;

    static {
        f9852b = new HashMap();
    }

    private b(String r3) {
        this.f9853a = null;
        this.f9853a = a(com.bytedance.mpaas.app.a.f5245g, r3, 0);
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences a(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    public static b b() {
        return c("app_config.prefs");
    }

    public static b c(String r3) {
        b r0 = f9852b.get(r3);
        if (r0 == null) goto L5;
    L14:
        return r0;
    L5:
        monitor-enter(b.class);
        r0 = f9852b.get(r3);     // Catch: Throwable -> L11
        if (r0 != null) goto L9;
        r0 = new b(r3);     // Catch: Throwable -> L11
        f9852b.put(r3, r0);     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public String d(String r1, String r2) {
        return this.f9853a.getString(r1, r2);
    }

    public boolean e(String r1, Boolean r2) {
        return this.f9853a.getBoolean(r1, r2.booleanValue());
    }

    public void f(String r1, String r2) {
        SharedPreferences.Editor r0 = this.f9853a.edit();
        r0.putString(r1, r2);
        r0.apply();
    }

    public void g(String r1, boolean r2) {
        SharedPreferences.Editor r0 = this.f9853a.edit();
        r0.putBoolean(r1, r2);
        r0.apply();
    }
}
