package com.obric.server.security.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.UserHandle;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class Utils {
    private static final String TAG = "SecurityUtils";

    public Utils() {
    }

    public static int getUidFromPkgName(Context context, String packageName) {
        PackageManager packageManager = context.getPackageManager();     // Catch: Exception -> L4
        ApplicationInfo applicationInfo = packageManager.getApplicationInfo(packageName, 0);     // Catch: Exception -> L4
        return applicationInfo.uid;
    L4:
        e = move-exception;
        Log.e("getUidFromPkgName", "Get uid failed, error:" + e.getMessage());
        return -1;
    }

    public static int getUserIdFromUid(int uid) {
        return UserHandle.getUserId(uid);
    }

    public static int getUidByPackageName(Context context, String packageName) {
        PackageManager pm = context.getPackageManager();     // Catch: PackageManager.NameNotFoundException -> L4
        ApplicationInfo appInfo = pm.getApplicationInfo(packageName, 0);     // Catch: PackageManager.NameNotFoundException -> L4
        return appInfo.uid;
    L4:
        e = move-exception;
        Log.i("getUidByPackageName ", e.getMessage());
        return -1;
    }
}
