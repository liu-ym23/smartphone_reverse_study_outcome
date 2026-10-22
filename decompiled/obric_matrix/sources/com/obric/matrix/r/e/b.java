package com.obric.matrix.r.e;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0004J\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\u000f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0016"}, d2 = {"Lcom/obric/matrix/common_utils/utils/AppUtils;", "", "()V", "getAppIdFromManifest", "", "packageName", "getAppName", "context", "Landroid/content/Context;", "platformPackageName", "getAppVersion", "", "getInstalledPackages", "", "Landroid/content/pm/PackageInfo;", "getPvrSdkVersion", "getVersionCode", "", "isAppEnable", "", "isAppInstalled", "isSystemApp", "common_utils_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f9938a = null;

    static {
        f9938a = new b();
    }

    private b() {
    }

    public final String a(String r5) {
        boolean r4 = false;
        if (r5 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L12;
        return "";
    L12:
        Context r2 = com.obric.matrix.r.a.c();
        if (r2 != null) goto L29;
        return "";
    L29:
        PackageManager r3 = r2.getPackageManager();     // Catch: Exception -> L26
        kotlin.n0.d.o.e(r3, "context.packageManager");     // Catch: Exception -> L26
        ApplicationInfo r6 = r3.getApplicationInfo(r5, 128);     // Catch: Exception -> L26
        kotlin.n0.d.o.e(r6, "packageManager.getApplic…ageManager.GET_META_DATA)");     // Catch: Exception -> L26
        Bundle r7 = r6.metaData;     // Catch: Exception -> L26
        if (r7 == null) goto L18;
        String r8 = r7.getString("pvr.app.id");     // Catch: Exception -> L26
    L19:
        if (r8 == null) goto L22;
        if (r8.length() == 0) goto L22;
    L23:
        if (r4 == false) goto L31;
        return "";
    L31:
        return r8;
    L22:
        r4 = true;
        goto L23
    L18:
        r8 = null;
    L26:
        e = move-exception;
        com.obric.matrix.r.c.c.s("AppUtils", "getAppId() with exception = " + e);
        return "";
    L5:
        if (r5.length() == 0) goto L8;
        r1 = false;
        goto L10
    }

    public final int b(Context r4, String r5) {
        if (r4 != null) goto L5;
    L22:
        return -1;
    L5:
        if (r5 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == true) goto L22;
        if (TextUtils.isEmpty(r5) == true) goto L22;
        PackageInfo r6 = r4.getPackageManager().getPackageInfo(r5, 1);     // Catch: Exception -> L20
        if (r6 == null) goto L22;
        com.obric.matrix.r.c.c.b("getAppVersion", "packageInfo  platformPackageName " + r5 + " versionName " + r6.versionName + "  packageInfo versioncode " + r6.versionCode);     // Catch: Exception -> L20
        return r6.versionCode;
    L20:
        e = move-exception;
        com.obric.matrix.r.c.c.g("AppUtils", "getAppVersion: " + e.getMessage(), e);
        goto L22
    L7:
        if (r5.length() == 0) goto L10;
        r1 = false;
        goto L11
    }

    public final String c(String r5) {
        boolean r4 = false;
        if (r5 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L12;
        return "";
    L12:
        Context r2 = com.obric.matrix.r.a.c();
        if (r2 != null) goto L29;
        return "";
    L29:
        PackageManager r3 = r2.getPackageManager();     // Catch: Exception -> L26
        kotlin.n0.d.o.e(r3, "context.packageManager");     // Catch: Exception -> L26
        ApplicationInfo r6 = r3.getApplicationInfo(r5, 128);     // Catch: Exception -> L26
        kotlin.n0.d.o.e(r6, "packageManager.getApplic…ageManager.GET_META_DATA)");     // Catch: Exception -> L26
        Bundle r7 = r6.metaData;     // Catch: Exception -> L26
        if (r7 == null) goto L18;
        String r8 = r7.getString("pvr.sdk.version");     // Catch: Exception -> L26
    L19:
        if (r8 == null) goto L22;
        if (r8.length() == 0) goto L22;
    L23:
        if (r4 == false) goto L31;
        return "";
    L31:
        return r8;
    L22:
        r4 = true;
        goto L23
    L18:
        r8 = null;
    L26:
        e = move-exception;
        com.obric.matrix.r.c.c.s("AppUtils", "getPvrSdkVersion() with exception = " + e);
        return "";
    L5:
        if (r5.length() == 0) goto L8;
        r1 = false;
        goto L10
    }

    public final long d(Context r2) {
        kotlin.n0.d.o.f(r2, "context");
        PackageInfo r1 = r2.getPackageManager().getPackageInfo(r2.getPackageName(), 0);     // Catch: Exception -> L5
        kotlin.n0.d.o.e(r1, "packageManager.getPackag…o(context.packageName, 0)");     // Catch: Exception -> L5
        return r1.getLongVersionCode();
    L5:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }
}
