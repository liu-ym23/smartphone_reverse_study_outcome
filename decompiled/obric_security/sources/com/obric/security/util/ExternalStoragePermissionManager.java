package com.obric.security.util;

import android.app.AppOpsManager;
import android.content.Context;
import com.bytedanceos.security.permission.SpecailPermissionUtil;
import com.bytedanceos.securitycenter.SecurityCenterApplication;
import com.bytedanceos.storage.StorageUtils;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ExternalStoragePermissionManager {
    private final List<String> DEFAULT_WHITE_LIST;
    private final AppOpsManager mAppOpsManager;
    private final Context mContext;

    public ExternalStoragePermissionManager() {
        this.DEFAULT_WHITE_LIST = Arrays.asList(new String[]{"com.obric.security", "com.android.gallery3d", "com.obric.appstore", "com.obric.browser", StorageUtils.PACKAGE_NAME_FILEMANAGER, "com.android.contacts"});
        SecurityCenterApplication r0 = SecurityCenterApplication.getApplication();
        this.mContext = r0;
        this.mAppOpsManager = (AppOpsManager) r0.getSystemService("appops");
    }

    public boolean[] processWhiteList() {
        List<String> r0 = this.DEFAULT_WHITE_LIST;
        int r1 = 0;
        if (r0 == null) goto L13;
        if (r0.isEmpty() == true) goto L13;
        boolean[] r2 = new boolean[this.DEFAULT_WHITE_LIST.size()];
    L9:
        if (r1 >= this.DEFAULT_WHITE_LIST.size()) goto L11;
        r2[r1] = checkAndForceEnableStoragePermission(this.DEFAULT_WHITE_LIST.get(r1));
        r1 = r1 + 1;
        goto L9
    L11:
        return r2;
    L13:
        return new boolean[0];
    }

    public boolean checkAndForceEnableStoragePermission(String targetPackage) {
        int r1 = this.mContext.getPackageManager().getApplicationInfo(targetPackage, 128).uid;     // Catch: Throwable -> L12
        int r2 = AppOpsManager.strOpToOp(SpecailPermissionUtil.OP_MANAGE_EXTERNAL_STORAGE);     // Catch: Throwable -> L12
        if (r2 != (-1)) goto L6;
        return false;
    L6:
        int r3 = this.mAppOpsManager.checkOpNoThrow(r2, r1, targetPackage);     // Catch: Throwable -> L12
        if (r3 == 0) goto L9;
        this.mAppOpsManager.setUidMode(r2, r1, 0);     // Catch: Throwable -> L12
        r3 = this.mAppOpsManager.checkOpNoThrow(r2, r1, targetPackage);     // Catch: Throwable -> L12
    L9:
        if (r3 != 0) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }
}
