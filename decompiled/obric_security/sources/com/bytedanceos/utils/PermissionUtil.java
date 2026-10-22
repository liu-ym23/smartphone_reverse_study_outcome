package com.bytedanceos.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.provider.Settings;

/* JADX INFO: loaded from: classes2.dex */
public class PermissionUtil {
    public PermissionUtil() {
    }

    public static boolean hasPermission(PackageManager pm, String packageName, String permissionName) {
        PackageInfo r3 = pm.getPackageInfo(packageName, 4096);     // Catch: PackageManager.NameNotFoundException -> L5
    L7:
        String[] r4 = r3.requestedPermissions;
        int r5 = r4.length;
        int r1 = 0;
    L8:
        if (r1 >= r5) goto L18;
        if (permissionName.equals(r4[r1]) == true) goto L11;
        r1 = r1 + 1;
        goto L8
    L11:
        return true;
    L18:
        return false;
    L5:
        e = move-exception;
        e.printStackTrace();
        r3 = null;
        goto L7
    }

    public static boolean hasNotificationAccess(Context context, String packageName) {
        String r1 = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        if (r1 != null) goto L7;
        return false;
    L7:
        return r1.contains(packageName);
    }
}
