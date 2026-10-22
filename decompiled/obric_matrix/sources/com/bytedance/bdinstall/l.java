package com.bytedance.bdinstall;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.UUID;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile String f2840a;

    class a implements u0.d {
        a() {
        }

        @Override // com.bytedance.bdinstall.u0.d
        public void b(String r1) {
            l.b(r1);
        }
    }

    static {
    }

    private l() {
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences a(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    static /* synthetic */ String b(String r0) {
        f2840a = r0;
        return r0;
    }

    public static void c(Context r3) {
        f2840a = null;
        com.bytedance.bdinstall.d1.h.a(r3).edit().remove("cdid").apply();
        SharedPreferences r4 = a(r3, com.bytedance.bdinstall.d1.h.d(), 0);
        if (r4.contains("cdid") == false) goto L6;
        r4.edit().remove("cdid").apply();
        return;
    }

    public static String d(Context r3) {
        if (f2840a != null) goto L18;
        monitor-enter(l.class);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (f2840a == null) goto L9;
    L12:
        monitor-exit(l.class);     // Catch: Throwable -> L14
        goto L18
    L9:
        if (v0.j(r3) == false) goto L11;
        f2840a = e(r3);     // Catch: Throwable -> L14
        u0.d(r3).i("cdid", f2840a);     // Catch: Throwable -> L14
        goto L12
    L11:
        f2840a = f(r3);     // Catch: Throwable -> L14
    L18:
        return f2840a;
    }

    private static String e(Context r5) {
        SharedPreferences r0 = com.bytedance.bdinstall.d1.h.a(r5);
        String r3 = r0.getString("cdid", null);
        if (TextUtils.isEmpty(r3) == false) goto L9;
        SharedPreferences r6 = a(r5, com.bytedance.bdinstall.d1.h.d(), 0);
        String r2 = r6.getString("cdid", null);
        if (TextUtils.isEmpty(r2) == false) goto L7;
        r2 = UUID.randomUUID().toString();
    L7:
        String r4 = r2;
        r6.edit().putString("cdid", r4).apply();
        r0.edit().putString("cdid", r4).putBoolean("cdid_migrate", true).apply();
        return r4;
    L9:
        return r3;
    }

    private static String f(Context r2) {
        u0.d(r2).g("cdid", new a());
        return f2840a;
    }
}
