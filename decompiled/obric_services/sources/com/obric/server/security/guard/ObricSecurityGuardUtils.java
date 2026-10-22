package com.obric.server.security.guard;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.util.Log;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class ObricSecurityGuardUtils {
    private static final String TAG = "ObricSecurityGuardUtils";

    public ObricSecurityGuardUtils() {
    }

    public static String getCallingPackageName(Context context) {
        int callingUid = Binder.getCallingUid();
        int callingPid = Binder.getCallingPid();
        String[] packages = context.getPackageManager().getPackagesForUid(callingUid);
        if (packages != null) goto L5;
    L26:
        return "";
    L5:
        if (packages.length == 0) goto L26;
        if (packages.length == 1) goto L10;
        ActivityManager am = (ActivityManager) context.getSystemService("activity");
        if (am == null) goto L25;
        Iterator<ActivityManager.RunningAppProcessInfo> r6 = am.getRunningAppProcesses().iterator();
    L15:
        if (r6.hasNext() == false) goto L25;
        ActivityManager.RunningAppProcessInfo processInfo = r6.next();
        if (processInfo.pid != callingPid) goto L15;
        String processName = processInfo.processName;
        int r9 = packages.length;
        int r10 = 0;
    L19:
        if (r10 >= r9) goto L15;
        String pkg = packages[r10];
        if (processName.startsWith(pkg) == true) goto L22;
        r10 = r10 + 1;
        goto L19
    L22:
        return pkg;
    L25:
        return "";
    L10:
        return packages[0];
    }

    public static boolean isSystemOrPlatformApp(Context context) {
        String packageName = getCallingPackageName(context);     // Catch: Exception -> L24
        PackageManager pm = context.getPackageManager();     // Catch: Exception -> L24
        if (pm != null) goto L7;
        Log.e(TAG, "isSystemOrPlatformApp, PackageManager get null!");     // Catch: Exception -> L24
        return false;
    L7:
        ApplicationInfo info = pm.getApplicationInfo(packageName, 0);     // Catch: Exception -> L24
        if (info != null) goto L12;
        Log.e(TAG, "isSystemOrPlatformApp, ApplicationInfo get null!");     // Catch: Exception -> L24
        return false;
    L12:
        if ((info.flags & 1) == 0) goto L14;
    L17:
        boolean isSystemApp = true;
    L18:
        if (isSystemApp == false) goto L21;
        return true;
    L21:
        if (pm.checkSignatures("android", packageName) != 0) goto L23;
        return true;
    L23:
        return false;
    L14:
        if ((info.flags & 128) != 0) goto L17;
        isSystemApp = false;
    L24:
        e = move-exception;
        Log.e(TAG, "isSystemOrPlatformApp exception, error:" + e);
        return false;
    }
}
