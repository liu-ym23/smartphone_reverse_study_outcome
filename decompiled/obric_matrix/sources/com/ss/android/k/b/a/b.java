package com.ss.android.k.b.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AppOpsManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import com.bytedance.common.utility.Logger;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f11958a = "b";

    static {
    }

    public static boolean a(Context r2, String r3) {
        if (Build.VERSION.SDK_INT < 19) goto L7;
        return c(r2, r3);
    L7:
        return b(r2, r3);
    }

    private static boolean b(Context r1, String r2) {
        if (r1.getPackageManager().checkPermission(r2, r1.getPackageName()) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @TargetApi(19)
    private static boolean c(Context r9, String r10) {
    L17:
        e = move-exception;
        Logger.e(f11958a, "权限检查出错时默认返回有权限，异常代码：" + e);
        return true;
    L4:
        if ("android.permission.ACCESS_COARSE_LOCATION".equals(r10) == false) goto L7;
        String r11 = "COARSE_LOCATION";
    L10:
        AppOpsManager r1 = (AppOpsManager) r9.getSystemService("appops");     // Catch: Exception -> L17
        PackageInfo r12 = r9.getPackageManager().getPackageInfo(r9.getPackageName(), 1);     // Catch: Exception -> L17
        Field r13 = AppOpsManager.class.getField("OP_" + r11);     // Catch: Exception -> L17
        Class r6 = Integer.TYPE;     // Catch: Exception -> L17
        Method r2 = AppOpsManager.class.getDeclaredMethod("checkOp", new Class[]{r6, r6, String.class});     // Catch: Exception -> L17
        r2.setAccessible(true);     // Catch: Exception -> L17
        int r14 = ((Integer) r2.invoke(r1, new Object[]{Integer.valueOf(r13.getInt(r1)), Integer.valueOf(r12.applicationInfo.uid), r12.packageName})).intValue();     // Catch: Exception -> L17
        if (r14 == 2) goto L22;
        if (r14 == 1) goto L22;
        if (r14 == 4) goto L22;
        return true;
    L22:
        return false;
    L7:
        if ("android.permission.ACCESS_FINE_LOCATION".equals(r10) == false) goto L9;
        r11 = "FINE_LOCATION";
        goto L10
    L9:
        r11 = r10.replaceFirst("android.permission.", "");     // Catch: Exception -> L17
        goto L10
    }

    private static void d(Intent r2) {
        r2.setAction("android.intent.action.MAIN");
        r2.setClassName("com.android.settings", "com.android.settings.ManageApplications");
    }

    private static void e(Intent r2, String r3) {
        r2.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        r2.setData(Uri.parse("package://" + r3));
        r2.putExtra("package", r3);
        r2.setClassName("com.android.settings", "com.android.settings..applications.InstalledAppDetails");
    }

    private static boolean f(Intent r0, Activity r1) {
        r1.startActivity(r0);     // Catch: ActivityNotFoundException -> L4
        return true;
    L4:
        return false;
    }

    public static void g(Activity r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        Intent r0 = new Intent();
        String r1 = r4.getPackageName();
        boolean r2 = false;
        if (com.bytedance.common.utility.b.a() == false) goto L7;
        r0.setAction("miui.intent.action.APP_PERM_EDITOR");
        r0.putExtra("extra_pkgname", r1);
        r0.putExtra("extra_package_uid", Process.myUid());
        r2 = true;
    L9:
        if (f(r0, r4) == true) goto L15;
        if (r2 == false) goto L13;
        e(r0, r1);
        if (f(r0, r4) == false) goto L13;
        return;
    L13:
        d(r0);
        f(r0, r4);
        return;
    L15:
        return;
    L7:
        e(r0, r1);
        goto L9
    }
}
