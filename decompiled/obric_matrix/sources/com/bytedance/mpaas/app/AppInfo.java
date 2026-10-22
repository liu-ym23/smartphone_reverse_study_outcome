package com.bytedance.mpaas.app;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.bytedance.bdlocation.exception.BDLocationException;
import d.b.m.e.c;

/* JADX INFO: loaded from: classes.dex */
public class AppInfo implements AppInfoProvider {

    static /* synthetic */ class a {
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static AppInfo f5244a;

        static {
            f5244a = new AppInfo(null);
        }
    }

    private AppInfo() {
    }

    /* synthetic */ AppInfo(a r1) {
        this();
    }

    public static AppInfo getInstatnce() {
        return b.f5244a;
    }

    @Override // com.bytedance.mpaas.app.AppInfoProvider
    public String getAid() {
        return c.f14156c.b("appId");
    }

    @Override // com.bytedance.mpaas.app.AppInfoProvider
    public String getAppName() {
        Context r2 = com.bytedance.mpaas.app.a.a();
        PackageManager r0 = r2.getPackageManager();     // Catch: PackageManager.NameNotFoundException -> L5
        CharSequence r3 = r0.getApplicationInfo(r2.getPackageName(), 128).loadLabel(r0);     // Catch: PackageManager.NameNotFoundException -> L5
    L7:
        if (r3 != null) goto L11;
        return "";
    L11:
        return String.valueOf(r3);
    L5:
        e = move-exception;
        e.printStackTrace();
        r3 = null;
        goto L7
    }

    @Override // com.bytedance.mpaas.app.AppInfoProvider
    public String getBuildVersion() {
        return c.f14156c.b("lastCommitId");
    }

    @Override // com.bytedance.mpaas.app.AppInfoProvider
    public String getChannel() {
        String r1 = d.b.q.c.b(com.bytedance.mpaas.app.a.f5245g);
        if (TextUtils.isEmpty(r1) == true) goto L5;
        return r1;
    L5:
        return c.f14156c.b("channel");
    }

    @Override // com.bytedance.mpaas.app.AppInfoProvider
    public String getUpdateVersionCode() {
        return d.b.m.e.b.a("UPDATE_VERSION_CODE", BDLocationException.ERROR_TIMEOUT);
    }

    @Override // com.bytedance.mpaas.app.AppInfoProvider
    public String getVersionCode() {
        return getVersionCode(com.bytedance.mpaas.app.a.a());
    }

    public String getVersionCode(Context r3) {
        return r3.getPackageManager().getPackageInfo(r3.getPackageName(), 0).versionCode + "";
    L5:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    @Override // com.bytedance.mpaas.app.AppInfoProvider
    public String getVersionName() {
        return getVersionName(com.bytedance.mpaas.app.a.a());
    }

    public String getVersionName(Context r2) {
        PackageManager r1 = r2.getPackageManager();
        return r1.getPackageInfo(r2.getPackageName(), 0).versionName;
    L5:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    @Override // com.bytedance.mpaas.app.AppInfoProvider
    public boolean isApkDebuggable() {
        if ((com.bytedance.mpaas.app.a.f5245g.getApplicationInfo().flags & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }
}
