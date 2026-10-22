package com.android.settings.applications;

import android.app.admin.DevicePolicyManager;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageManager;
import android.content.pm.PackageManager;
import android.os.UserManager;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AppWithAdminGrantedPermissionsLister extends AppLister {
    private final DevicePolicyManager mDevicePolicyManager;
    private final IPackageManager mPackageManagerService;
    private final String[] mPermissions;

    public AppWithAdminGrantedPermissionsLister(String[] r1, PackageManager r2, IPackageManager r3, DevicePolicyManager r4, UserManager r5) {
        super(r2, r5);
        this.mPermissions = r1;
        this.mPackageManagerService = r3;
        this.mDevicePolicyManager = r4;
    }

    @Override // com.android.settings.applications.AppLister
    protected boolean includeInCount(ApplicationInfo r4) {
        return AppWithAdminGrantedPermissionsCounter.includeInCount(this.mPermissions, this.mDevicePolicyManager, this.mPm, this.mPackageManagerService, r4);
    }
}
