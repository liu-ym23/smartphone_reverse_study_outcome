package com.bytedance.news.common.settings.i;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.news.common.service.manager.d;
import com.bytedance.news.common.settings.SettingsConfigProvider;
import com.bytedance.news.common.settings.g.f;
import com.bytedance.services.apm.api.IEnsure;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
class b implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SharedPreferences f5335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SharedPreferences.Editor f5336b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private IEnsure f5337c;

    public b(Context r5, String r6) {
        SettingsConfigProvider r0 = (SettingsConfigProvider) d.a(SettingsConfigProvider.class);
        if (r0 == null) goto L8;
        if (r0.getConfig() == null) goto L8;
        this.f5335a = r0.getConfig().g(r5, r6 + ".sp", 0);
    L8:
        if (this.f5335a != null) goto L10;
        this.f5335a = c(r5, r6 + ".sp", 0);
    L10:
        this.f5336b = this.f5335a.edit();
        this.f5337c = (IEnsure) d.a(IEnsure.class);
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences c(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    private void f(Exception r1) {
        IEnsure r0 = this.f5337c;
        if (r0 == null) goto L6;
        r0.reportLogException(r1);
        return;
    }

    @Override // com.bytedance.news.common.settings.g.f
    public boolean a(String r2) {
        return d(r2, false);
    }

    @Override // com.bytedance.news.common.settings.g.f
    public void apply() {
        this.f5336b.apply();
    }

    @Override // com.bytedance.news.common.settings.g.f
    public String b(String r2) {
        return e(r2, "");
    }

    @Override // com.bytedance.news.common.settings.g.f
    public boolean contains(String r1) {
        return this.f5335a.contains(r1);
    }

    public boolean d(String r2, boolean r3) {
        return this.f5335a.getBoolean(r2, r3);
    L4:
        e = move-exception;
        f(e);
        return r3;
    }

    public String e(String r2, String r3) {
        return this.f5335a.getString(r2, r3);
    L4:
        e = move-exception;
        f(e);
        return r3;
    }

    @Override // com.bytedance.news.common.settings.g.f
    public void putBoolean(String r1, boolean r2) {
        this.f5336b.putBoolean(r1, r2);
    }

    @Override // com.bytedance.news.common.settings.g.f
    public void putString(String r1, String r2) {
        this.f5336b.putString(r1, r2);
    }
}
