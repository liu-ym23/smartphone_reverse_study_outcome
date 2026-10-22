package com.android.settings.applications;

import android.R;
import android.app.AppOpsManager;
import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.CompoundButton;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;

/* JADX INFO: loaded from: classes2.dex */
public class AppStateUsageBridge extends AppStateAppOpsBridge implements AppStateBaseSwitchInterface {
    private static final int APP_OPS_LOADER_STATS = 95;
    private static final int[] APP_OPS_OP_CODES = null;
    private static final int APP_OPS_USAGE_STATS = 43;
    public static final com.android.settingslib.applications.ApplicationsState.AppFilter FILTER_APP_USAGE = null;
    private static final String PM_LOADER_STATS = "android.permission.LOADER_USAGE_STATS";
    private static final String[] PM_PERMISSIONS = null;
    private static final String PM_USAGE_STATS = "android.permission.PACKAGE_USAGE_STATS";
    private static final String TAG = "AppStateUsageBridge";
    private final AppOpsManager mAppOpsManager;
    private final Context mContext;
    private DevicePolicyManager mDpm;

    public static class UsageState extends AppStateAppOpsBridge.PermissionState {
        public UsageState(AppStateAppOpsBridge.PermissionState r3) {
            super(r3.packageName, r3.userHandle);
            this.packageInfo = r3.packageInfo;
            this.appOpMode = r3.appOpMode;
            this.permissionDeclared = r3.permissionDeclared;
            this.staticPermissionGranted = r3.staticPermissionGranted;
        }
    }

    static /* synthetic */ void lambda$getSwitchOnCheckedListener$1(DialogInterface r0, int r1) {
    }

    static {
        APP_OPS_OP_CODES = new int[]{43, 95};
        PM_PERMISSIONS = new String[]{PM_USAGE_STATS, PM_LOADER_STATS};
        FILTER_APP_USAGE = new AnonymousClass1();
    }

    public AppStateUsageBridge(Context r7, com.android.settingslib.applications.ApplicationsState r8, AppStateBaseBridge.Callback r9) {
        super(r7, r8, r9, APP_OPS_OP_CODES, PM_PERMISSIONS);
        this.mContext = r7;
        this.mAppOpsManager = (AppOpsManager) r7.getSystemService("appops");
        this.mDpm = (DevicePolicyManager) r7.getSystemService(DevicePolicyManager.class);
    }

    @Override // com.android.settings.applications.AppStateAppOpsBridge, com.android.settings.applications.AppStateBaseBridge
    protected void updateExtraInfo(com.android.settingslib.applications.ApplicationsState.AppEntry r1, String r2, int r3) {
        r1.extraInfo = getUsageInfo(r2, r3);
    }

    public UsageState getUsageInfo(String r1, int r2) {
        return new UsageState(super.getPermissionInfo(r1, r2));
    }

    private AppStateAppOpsBridge.PermissionState createPermissionState(com.android.settingslib.applications.ApplicationsState.AppEntry r2) {
        return getUsageInfo(r2.info.packageName, r2.info.uid);
    }

    private static boolean doesAnyPermissionMatch(String r4, String[] r5) {
        int r0 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (r4.equals(r5[r2]) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private void setNewState(com.android.settingslib.applications.ApplicationsState.AppEntry r4, AppStateAppOpsBridge.PermissionState r5, boolean r6) {
        int r7 = !r6 ? 1 : 0;
        int r0 = r4.info.uid;
        String r8 = r4.info.packageName;
        if (doesAnyPermissionMatch(PM_USAGE_STATS, r5.packageInfo.requestedPermissions) == false) goto L6;
        this.mAppOpsManager.setMode(43, r0, r8, r7);
    L6:
        if (doesAnyPermissionMatch(PM_LOADER_STATS, r5.packageInfo.requestedPermissions) == false) goto L9;
        this.mAppOpsManager.setMode(95, r0, r8, r7);
        return;
    }

    @Override // com.android.settings.applications.AppStateBaseSwitchInterface
    public CompoundButton.OnCheckedChangeListener getSwitchOnCheckedListener(final com.android.settingslib.applications.ApplicationsState.AppEntry r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return new AppStateUsageBridge$$ExternalSyntheticLambda0(this, r2);
    }

    /* JADX INFO: renamed from: lambda$getSwitchOnCheckedListener$2$com-android-settings-applications-AppStateUsageBridge, reason: not valid java name */
    /* synthetic */ void m284x994ec3e9(com.android.settingslib.applications.ApplicationsState.AppEntry r5, CompoundButton r6, boolean r7) {
        AppStateAppOpsBridge.PermissionState r8 = createPermissionState(r5);
        if (r8 != null) goto L5;
        return;
    L5:
        if (r7 != r8.isPermissible()) goto L7;
        return;
    L7:
        if (r8.isPermissible() == true) goto L9;
    L11:
        setNewState(r5, r8, Boolean.valueOf(r7).booleanValue());
        return;
    L9:
        if (this.mDpm.isProfileOwnerApp(r5.info.packageName) == false) goto L11;
        new OAlertDialogBuilder(this.mContext).horizontalButton().icon(R.drawable.ic_zen_mode_icon_piano).title(R.string.dialog_alert_title).message(this.mDpm.getResources().getString("Settings.WORK_PROFILE_DISABLE_USAGE_ACCESS_WARNING", new AppStateUsageBridge$$ExternalSyntheticLambda1(this))).positiveButton(com.android.settings.R.string.okay, new AppStateUsageBridge$$ExternalSyntheticLambda2()).build().show();
        goto L11
    }

    /* JADX INFO: renamed from: lambda$getSwitchOnCheckedListener$0$com-android-settings-applications-AppStateUsageBridge, reason: not valid java name */
    /* synthetic */ String m283x46a61967() {
        return this.mContext.getString(com.android.settings.R.string.work_profile_usage_access_warning);
    }

    @Override // com.android.settings.applications.AppStateBaseSwitchInterface
    public final boolean enableSwitch(com.android.settingslib.applications.ApplicationsState.AppEntry r1) {
        AppStateAppOpsBridge.PermissionState r0 = createPermissionState(r1);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.permissionDeclared;
    }

    @Override // com.android.settings.applications.AppStateBaseSwitchInterface
    public final boolean checkSwitch(com.android.settingslib.applications.ApplicationsState.AppEntry r1) {
        AppStateAppOpsBridge.PermissionState r0 = createPermissionState(r1);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isPermissible();
    }
}
