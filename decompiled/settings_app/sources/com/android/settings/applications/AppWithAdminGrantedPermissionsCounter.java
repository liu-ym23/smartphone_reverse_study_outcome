package com.android.settings.applications;

import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageManager;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.UserHandle;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AppWithAdminGrantedPermissionsCounter extends AppCounter {
    private final DevicePolicyManager mDevicePolicyManager;
    private final IPackageManager mPackageManagerService;
    private final String[] mPermissions;

    public AppWithAdminGrantedPermissionsCounter(Context r1, String[] r2, PackageManager r3, IPackageManager r4, DevicePolicyManager r5) {
        super(r1, r3);
        this.mPermissions = r2;
        this.mPackageManagerService = r4;
        this.mDevicePolicyManager = r5;
    }

    @Override // com.android.settings.applications.AppCounter
    protected boolean includeInCount(ApplicationInfo r4) {
        return includeInCount(this.mPermissions, this.mDevicePolicyManager, this.mPm, this.mPackageManagerService, r4);
    }

    public static boolean includeInCount(String[] r5, DevicePolicyManager r6, PackageManager r7, IPackageManager r8, ApplicationInfo r9) {
        if (r9.targetSdkVersion < 23) goto L12;
        int r10 = r5.length;
        int r11 = 0;
    L5:
        if (r11 >= r10) goto L10;
        if (r6.getPermissionGrantState(null, r9.packageName, r5[r11]) == 1) goto L8;
        r11 = r11 + 1;
        goto L5
    L8:
        return true;
    L10:
        return false;
    L12:
        if (r7.getInstallReason(r9.packageName, new UserHandle(UserHandle.getUserId(r9.uid))) == 1) goto L22;
        return false;
    L22:
        int r12 = r5.length;     // Catch: RemoteException -> L21
        int r13 = 0;
    L15:
        if (r13 >= r12) goto L20;
        if (r8.checkUidPermission(r5[r13], r9.uid) == 0) goto L18;
        r13 = r13 + 1;
        goto L15
    L18:
        return true;
    L20:
        return false;
    }
}
