package com.bytedanceos.security.permission;

import android.app.AppOpsManager;

/* JADX INFO: loaded from: classes2.dex */
public class SpecailPermissionUtil {
    public static final String OP_MANAGE_EXTERNAL_STORAGE = "android:manage_external_storage";
    private static final String TAG = "SpecailPermissionUtil";

    public SpecailPermissionUtil() {
    }

    public static void grantPermission(AppOpsManager opsManager, int uid, boolean grant) {
        if (grant == false) goto L4;
        int r3 = 0;
    L5:
        opsManager.setUidMode(92, uid, r3);
        return;
    L4:
        r3 = 2;
        goto L5
    }

    public static boolean checkPermission(AppOpsManager opsManager, int uid, String packageName) {
        int r1 = opsManager.noteOp(OP_MANAGE_EXTERNAL_STORAGE, uid, packageName);     // Catch: Exception -> L4
    L6:
        if (r1 != 0) goto L8;
        return true;
    L8:
        return false;
    L4:
        e = move-exception;
        e.printStackTrace();
        r1 = -1;
        goto L6
    }
}
