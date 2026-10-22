package com.bytedanceos.security.permission;

import android.app.AppOpsManager;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.bytedanceos.security.reflect.OpsManagerHelper;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AppNativePermission {
    private List<String> mAppHasPermission;
    private String mBackgroundPermission;
    private int mBackgroundStatusMode;
    private NativePermission mNativePermission;
    private int mPermissionStatusMode;

    public AppNativePermission(NativePermission permission) {
        this.mPermissionStatusMode = -1;
        this.mBackgroundStatusMode = -1;
        this.mNativePermission = permission;
    }

    public AppNativePermission(NativePermission permission, List<String> appPermissions) {
        this.mPermissionStatusMode = -1;
        this.mBackgroundStatusMode = -1;
        this.mNativePermission = permission;
        this.mAppHasPermission = appPermissions;
        if (permission != null) goto L5;
        return;
    L5:
        if (permission.hasBackgroundPermission() == true) goto L7;
        return;
    L7:
        if (appPermissions.contains(permission.getBackgroundPermission()) == false) goto L12;
        String r2 = permission.getBackgroundPermission();
        this.mBackgroundPermission = r2;
        this.mAppHasPermission.remove(r2);
        return;
    }

    public void setPermissionStatus(int mode) {
        this.mPermissionStatusMode = mode;
    }

    public int getPermissionStatusMode() {
        return this.mPermissionStatusMode;
    }

    public boolean foregroundPermissionGranted() {
        if (this.mPermissionStatusMode == OpsManagerHelper.get_MODE_IGNORED()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean backgroudPermissionGranted() {
        if (this.mBackgroundStatusMode != OpsManagerHelper.get_MODE_ALLOWED()) goto L5;
        return true;
    L5:
        return false;
    }

    public String getBackgroundPermission() {
        return this.mBackgroundPermission;
    }

    public boolean isInUseMode() {
        return this.mNativePermission.isInUseMode();
    }

    public boolean hasBackgroundPermission() {
        if (this.mBackgroundPermission == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void setBackgroudStatusMode(int mode) {
        this.mBackgroundStatusMode = mode;
    }

    public int getOpCode() {
        return this.mNativePermission.getOpCode();
    }

    public List<String> getAppPermissions() {
        return this.mAppHasPermission;
    }

    public boolean isDangerous() {
        return this.mNativePermission.isDangerous();
    }

    public boolean isSpecial() {
        return this.mNativePermission.isSpecial();
    }

    public int getGroupType() {
        return this.mNativePermission.getGroupType();
    }

    public String getPermissionName() {
        return this.mNativePermission.getPermissionName();
    }

    public int getLabelRes() {
        return this.mNativePermission.getLabelRes();
    }

    public String getDangerousGroupName() {
        return this.mNativePermission.getDangerousGroupName();
    }

    public boolean isSepicalPermission() {
        return this.mNativePermission.isSepicalPermission();
    }

    public int getShowMode() {
        return this.mNativePermission.getShowMode();
    }

    public void grantBackgroundPermission(AppOpsManager appops, PackageManager packageManager, PackageInfo packageInfo) {
        if (RiskPermissionControlGuard.isSensitivePermissionChangeBlocked(packageInfo) == false) goto L6;
        return;
    L6:
        if (hasBackgroundPermission() == true) goto L8;
        return;
    L8:
        DangerousPermissionUtil.grantBackgroundPermission(appops, packageManager, packageInfo, getBackgroundPermission());
        setBackgroudStatusMode(OpsManagerHelper.get_MODE_ALLOWED());
        Iterator<String> r1 = this.mAppHasPermission.iterator();
    L10:
        if (r1.hasNext() == false) goto L12;
        DangerousPermissionUtil.setOpsMode(appops, packageInfo, r1.next(), OpsManagerHelper.get_MODE_ALLOWED());
        goto L10
    }

    public void grantRuntimePermissions(AppOpsManager appops, PackageManager packageManager, PackageInfo packageInfo) {
        if (RiskPermissionControlGuard.isSensitivePermissionChangeBlocked(packageInfo) == false) goto L5;
        return;
    L5:
        DangerousPermissionUtil.grantDangrousRuntimePermission(appops, packageManager, packageInfo, this.mAppHasPermission, this.mNativePermission.getOpCode());
        setPermissionStatus(OpsManagerHelper.get_MODE_ALLOWED());
        if (hasBackgroundPermission() == false) goto L11;
        Iterator<String> r2 = this.mAppHasPermission.iterator();
    L9:
        if (r2.hasNext() == false) goto L13;
        DangerousPermissionUtil.setOpsMode(appops, packageInfo, r2.next(), OpsManagerHelper.get_MODE_FOREGROUND());
        goto L9
    L13:
        return;
    }

    public void grantSpecialPermissions(AppOpsManager appops, int uid, boolean grant) {
        SpecailPermissionUtil.grantPermission(appops, uid, grant);
    }

    public void grantSpecialPermissions(AppOpsManager appops, PackageInfo packageInfo, boolean grant) {
        if (RiskPermissionControlGuard.isSensitivePermissionChangeBlocked(packageInfo) == false) goto L5;
        return;
    L5:
        if (packageInfo != null) goto L7;
        return;
    L7:
        if (packageInfo.applicationInfo == null) goto L12;
        SpecailPermissionUtil.grantPermission(appops, packageInfo.applicationInfo.uid, grant);
        return;
    }

    public void revokeBackgroundPermission(AppOpsManager appops, PackageManager packageManager, PackageInfo packageInfo) {
        if (RiskPermissionControlGuard.isSensitivePermissionChangeBlocked(packageInfo) == false) goto L6;
        return;
    L6:
        if (hasBackgroundPermission() == true) goto L8;
        return;
    L8:
        DangerousPermissionUtil.revokeBackgroundPermission(appops, packageManager, packageInfo, getBackgroundPermission());
        setBackgroudStatusMode(OpsManagerHelper.get_MODE_IGNORED());
        if (this.mPermissionStatusMode == OpsManagerHelper.get_MODE_IGNORED()) goto L14;
        Iterator<String> r1 = this.mAppHasPermission.iterator();
    L12:
        if (r1.hasNext() == false) goto L16;
        DangerousPermissionUtil.setOpsMode(appops, packageInfo, r1.next(), OpsManagerHelper.get_MODE_FOREGROUND());
        goto L12
    L16:
        return;
    }

    public void revokeRuntimePermissions(AppOpsManager appops, PackageManager packageManager, PackageInfo packageInfo) {
        if (RiskPermissionControlGuard.isSensitivePermissionChangeBlocked(packageInfo) == false) goto L5;
        return;
    L5:
        DangerousPermissionUtil.revokePermissions(appops, packageManager, packageInfo, this.mAppHasPermission, this.mNativePermission.getOpCode());
        setPermissionStatus(OpsManagerHelper.get_MODE_IGNORED());
    }
}
