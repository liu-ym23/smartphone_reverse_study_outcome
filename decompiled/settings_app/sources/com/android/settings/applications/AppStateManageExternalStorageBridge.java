package com.android.settings.applications;

import android.app.AppOpsManager;
import android.content.Context;
import android.widget.CompoundButton;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class AppStateManageExternalStorageBridge extends AppStateAppOpsBridge implements AppStateBaseSwitchInterface {
    private static final String APP_OP_STR = "android:manage_external_storage";
    public static final com.android.settingslib.applications.ApplicationsState.AppFilter FILTER_MANAGE_EXTERNAL_STORAGE = null;
    private static final String[] PERMISSIONS = null;
    private final AppOpsManager mAppOpsManager;

    static {
        PERMISSIONS = new String[]{"android.permission.MANAGE_EXTERNAL_STORAGE"};
        FILTER_MANAGE_EXTERNAL_STORAGE = new AnonymousClass1();
    }

    public AppStateManageExternalStorageBridge(Context r8, com.android.settingslib.applications.ApplicationsState r9, AppStateBaseBridge.Callback r10) {
        super(r8, r9, r10, AppOpsManager.strOpToOp(APP_OP_STR), PERMISSIONS);
        this.mAppOpsManager = (AppOpsManager) r8.getSystemService("appops");
    }

    @Override // com.android.settings.applications.AppStateAppOpsBridge, com.android.settings.applications.AppStateBaseBridge
    protected void updateExtraInfo(com.android.settingslib.applications.ApplicationsState.AppEntry r1, String r2, int r3) {
        r1.extraInfo = getManageExternalStoragePermState(r2, r3);
    }

    @Override // com.android.settings.applications.AppStateAppOpsBridge, com.android.settings.applications.AppStateBaseBridge
    protected void loadAllExtraInfo() {
        super.loadAllExtraInfo();
        Iterator<com.android.settingslib.applications.ApplicationsState.AppEntry> r0 = this.mAppSession.getAllApps().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        com.android.settingslib.applications.ApplicationsState.AppEntry r1 = r0.next();
        if ((r1.extraInfo instanceof AppStateAppOpsBridge.PermissionState) == false) goto L4;
        AppStateAppOpsBridge.PermissionState r2 = (AppStateAppOpsBridge.PermissionState) r1.extraInfo;
        r2.appOpMode = this.mAppOpsManager.unsafeCheckOpNoThrow(APP_OP_STR, r1.info.uid, r1.info.packageName);
        goto L4
    }

    @Override // com.android.settings.applications.AppStateAppOpsBridge
    public AppStateAppOpsBridge.PermissionState getPermissionInfo(String r3, int r4) {
        AppStateAppOpsBridge.PermissionState r0 = super.getPermissionInfo(r3, r4);
        r0.appOpMode = this.mAppOpsManager.unsafeCheckOpNoThrow(APP_OP_STR, r4, r3);
        return r0;
    }

    public AppStateAppOpsBridge.PermissionState getManageExternalStoragePermState(String r1, int r2) {
        return getPermissionInfo(r1, r2);
    }

    private AppStateAppOpsBridge.PermissionState getManageExternalStoragePermState(com.android.settingslib.applications.ApplicationsState.AppEntry r2) {
        return getManageExternalStoragePermState(r2.info.packageName, r2.info.uid);
    }

    private void setManageExternalStorageState(com.android.settingslib.applications.ApplicationsState.AppEntry r2, boolean r3) {
        AppOpsManager r1 = this.mAppOpsManager;
        int r0 = AppOpsManager.strOpToOp(APP_OP_STR);
        int r4 = r2.info.uid;
        if (r3 == false) goto L5;
        int r5 = 0;
    L6:
        r1.setUidMode(r0, r4, r5);
        return;
    L5:
        r5 = 2;
        goto L6
    }

    @Override // com.android.settings.applications.AppStateBaseSwitchInterface
    public CompoundButton.OnCheckedChangeListener getSwitchOnCheckedListener(final com.android.settingslib.applications.ApplicationsState.AppEntry r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return new AppStateManageExternalStorageBridge$$ExternalSyntheticLambda0(this, r2);
    }

    /* JADX INFO: renamed from: lambda$getSwitchOnCheckedListener$0$com-android-settings-applications-AppStateManageExternalStorageBridge, reason: not valid java name */
    /* synthetic */ void m278xa15afa51(com.android.settingslib.applications.ApplicationsState.AppEntry r1, CompoundButton r2, boolean r3) {
        AppStateAppOpsBridge.PermissionState r4 = getManageExternalStoragePermState(r1);
        if (r4 != null) goto L5;
        return;
    L5:
        if (r3 == r4.isPermissible()) goto L9;
        setManageExternalStorageState(r1, Boolean.valueOf(r3).booleanValue());
        return;
    }

    @Override // com.android.settings.applications.AppStateBaseSwitchInterface
    public final boolean enableSwitch(com.android.settingslib.applications.ApplicationsState.AppEntry r1) {
        AppStateAppOpsBridge.PermissionState r0 = getManageExternalStoragePermState(r1);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.permissionDeclared;
    }

    @Override // com.android.settings.applications.AppStateBaseSwitchInterface
    public final boolean checkSwitch(com.android.settingslib.applications.ApplicationsState.AppEntry r1) {
        AppStateAppOpsBridge.PermissionState r0 = getManageExternalStoragePermState(r1);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isPermissible();
    }
}
