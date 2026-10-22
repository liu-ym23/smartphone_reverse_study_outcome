package com.bytedance.news.common.settings.h;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.news.common.settings.SettingsConfigProvider;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile g f5330b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SharedPreferences f5331a;

    private g(Context r5) {
        SettingsConfigProvider r0 = (SettingsConfigProvider) com.bytedance.news.common.service.manager.d.a(SettingsConfigProvider.class);
        if (r0 == null) goto L8;
        if (r0.getConfig() == null) goto L8;
        this.f5331a = r0.getConfig().g(r5, "__settings_meta.sp", 0);
    L8:
        if (this.f5331a != null) goto L11;
        this.f5331a = a(r5, "__settings_meta.sp", 0);
        return;
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences a(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    private static String b(String r1, String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return r1;
    L6:
        return r1 + "_" + r2;
    }

    public static g c(Context r2) {
        if (f5330b != null) goto L15;
        monitor-enter(g.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f5330b != null) goto L9;
        f5330b = new g(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(g.class);     // Catch: Throwable -> L11
    L15:
        return f5330b;
    }

    public String d(String r2) {
        return this.f5331a.getString(b("key_latest_update_token", r2), "");
    }

    public int e(String r5) {
        int r1 = 0;
        return this.f5331a.getInt("key_prefix_version_" + r5, 0);
    L5:
        e = move-exception;
        r1 = Integer.valueOf(this.f5331a.getString("key_prefix_version_" + r5, BDLocationException.ERROR_TIMEOUT)).intValue();     // Catch: Exception -> L8
    L10:
        e.printStackTrace();
        return r1;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    public String f(String r2) {
        return this.f5331a.getString(r2, "");
    }

    public boolean g(String r3) {
        return this.f5331a.getBoolean("key_one_sp_migrate_" + r3, false);
    }

    public boolean h(String r1, String r2) {
        return !f(r1).equals(d(r2));
    }

    public void i(String r2, String r3) {
        this.f5331a.edit().putString(b("key_latest_update_token", r3), r2).apply();
    }

    public void j(String r3) {
        this.f5331a.edit().putBoolean("key_one_sp_migrate_" + r3, true).apply();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public void k(String r4, int r5) {
        this.f5331a.edit().putInt("key_prefix_version_" + r4, r5).apply();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        this.f5331a.edit().putString("key_prefix_version_" + r4, String.valueOf(r5)).apply();
    }

    public void l(String r1, String r2) {
        this.f5331a.edit().putString(r1, r2).apply();
    }
}
