package com.android.settings.applications;

import android.app.AppOpsManager;
import android.content.Context;
import android.widget.CompoundButton;

/* JADX INFO: loaded from: classes2.dex */
public class AppStateWriteSettingsBridge extends AppStateAppOpsBridge implements AppStateBaseSwitchInterface {
    private static final int APP_OPS_OP_CODE = 23;
    public static final com.android.settingslib.applications.ApplicationsState.AppFilter FILTER_WRITE_SETTINGS = null;
    private static final String[] PM_PERMISSIONS = null;
    private static final String PM_WRITE_SETTINGS = "android.permission.WRITE_SETTINGS";
    private static final String TAG = "AppStateWriteSettingsBridge";
    private final AppOpsManager mAppOpsManager;

    public static class WriteSettingsState extends AppStateAppOpsBridge.PermissionState {
        public WriteSettingsState(AppStateAppOpsBridge.PermissionState r3) {
            super(r3.packageName, r3.userHandle);
            this.packageInfo = r3.packageInfo;
            this.appOpMode = r3.appOpMode;
            this.permissionDeclared = r3.permissionDeclared;
            this.staticPermissionGranted = r3.staticPermissionGranted;
        }
    }

    static {
        PM_PERMISSIONS = new String[]{PM_WRITE_SETTINGS};
        FILTER_WRITE_SETTINGS = new AnonymousClass1();
    }

    public AppStateWriteSettingsBridge(Context r7, com.android.settingslib.applications.ApplicationsState r8, AppStateBaseBridge.Callback r9) {
        super(r7, r8, r9, 23, PM_PERMISSIONS);
        this.mAppOpsManager = (AppOpsManager) r7.getSystemService("appops");
    }

    @Override // com.android.settings.applications.AppStateAppOpsBridge, com.android.settings.applications.AppStateBaseBridge
    protected void updateExtraInfo(com.android.settingslib.applications.ApplicationsState.AppEntry r1, String r2, int r3) {
        r1.extraInfo = getWriteSettingsInfo(r2, r3);
    }

    public WriteSettingsState getWriteSettingsInfo(String r1, int r2) {
        return new WriteSettingsState(super.getPermissionInfo(r1, r2));
    }

    public int getNumberOfPackagesWithPermission() {
        return super.getNumPackagesDeclaredPermission();
    }

    public int getNumberOfPackagesCanWriteSettings() {
        return super.getNumPackagesAllowedByAppOps();
    }

    private AppStateAppOpsBridge.PermissionState getWriteSettingsInfo(com.android.settingslib.applications.ApplicationsState.AppEntry r2) {
        return getWriteSettingsInfo(r2.info.packageName, r2.info.uid);
    }

    private void setPermissionState(com.android.settingslib.applications.ApplicationsState.AppEntry r3, boolean r4) {
        AppOpsManager r2 = this.mAppOpsManager;
        int r0 = r3.info.uid;
        String r5 = r3.info.packageName;
        if (r4 == false) goto L5;
        int r6 = 0;
    L6:
        r2.setMode(23, r0, r5, r6);
        return;
    L5:
        r6 = 2;
        goto L6
    }

    @Override // com.android.settings.applications.AppStateBaseSwitchInterface
    public CompoundButton.OnCheckedChangeListener getSwitchOnCheckedListener(final com.android.settingslib.applications.ApplicationsState.AppEntry r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return new AppStateWriteSettingsBridge$$ExternalSyntheticLambda0(this, r2);
    }

    /* JADX INFO: renamed from: lambda$getSwitchOnCheckedListener$0$com-android-settings-applications-AppStateWriteSettingsBridge, reason: not valid java name */
    /* synthetic */ void m285x12983328(com.android.settingslib.applications.ApplicationsState.AppEntry r1, CompoundButton r2, boolean r3) {
        AppStateAppOpsBridge.PermissionState r4 = getWriteSettingsInfo(r1);
        if (r4 != null) goto L5;
        return;
    L5:
        if (r3 == r4.isPermissible()) goto L9;
        setPermissionState(r1, Boolean.valueOf(r3).booleanValue());
        return;
    }

    @Override // com.android.settings.applications.AppStateBaseSwitchInterface
    public final boolean enableSwitch(com.android.settingslib.applications.ApplicationsState.AppEntry r1) {
        AppStateAppOpsBridge.PermissionState r0 = getWriteSettingsInfo(r1);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.permissionDeclared;
    }

    @Override // com.android.settings.applications.AppStateBaseSwitchInterface
    public final boolean checkSwitch(com.android.settingslib.applications.ApplicationsState.AppEntry r1) {
        AppStateAppOpsBridge.PermissionState r0 = getWriteSettingsInfo(r1);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isPermissible();
    }
}
