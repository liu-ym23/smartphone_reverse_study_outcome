package com.android.settings.applications;

import android.app.AppOpsManager;
import android.content.Context;
import android.widget.CompoundButton;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AppStateOverlayBridge extends AppStateAppOpsBridge implements AppStateBaseSwitchInterface {
    private static final int APP_OPS_OP_CODE = 24;
    public static final com.android.settingslib.applications.ApplicationsState.AppFilter FILTER_SYSTEM_ALERT_WINDOW = null;
    private static final String[] PM_PERMISSION = null;
    private static final String PM_SYSTEM_ALERT_WINDOW = "android.permission.SYSTEM_ALERT_WINDOW";
    private static final String TAG = "AppStateOverlayBridge";
    private final AppOpsManager mAppOpsManager;

    public static class OverlayState extends AppStateAppOpsBridge.PermissionState {
        private static final List<String> DISABLE_PACKAGE_LIST = null;
        public final boolean controlEnabled;

        static {
            ArrayList r0 = new ArrayList();
            DISABLE_PACKAGE_LIST = r0;
            r0.add("com.android.systemui");
        }

        public OverlayState(AppStateAppOpsBridge.PermissionState r3) {
            super(r3.packageName, r3.userHandle);
            this.packageInfo = r3.packageInfo;
            this.appOpMode = r3.appOpMode;
            this.permissionDeclared = r3.permissionDeclared;
            this.staticPermissionGranted = r3.staticPermissionGranted;
            this.controlEnabled = !DISABLE_PACKAGE_LIST.contains(r3.packageName);
        }
    }

    static {
        PM_PERMISSION = new String[]{PM_SYSTEM_ALERT_WINDOW};
        FILTER_SYSTEM_ALERT_WINDOW = new AnonymousClass1();
    }

    public AppStateOverlayBridge(Context r7, com.android.settingslib.applications.ApplicationsState r8, AppStateBaseBridge.Callback r9) {
        super(r7, r8, r9, 24, PM_PERMISSION);
        this.mAppOpsManager = (AppOpsManager) r7.getSystemService("appops");
    }

    @Override // com.android.settings.applications.AppStateAppOpsBridge, com.android.settings.applications.AppStateBaseBridge
    protected void updateExtraInfo(com.android.settingslib.applications.ApplicationsState.AppEntry r1, String r2, int r3) {
        r1.extraInfo = getOverlayInfo(r2, r3);
    }

    public OverlayState getOverlayInfo(String r1, int r2) {
        return new OverlayState(super.getPermissionInfo(r1, r2));
    }

    public int getNumberOfPackagesWithPermission() {
        return super.getNumPackagesDeclaredPermission();
    }

    public int getNumberOfPackagesCanDrawOverlay() {
        return super.getNumPackagesAllowedByAppOps();
    }

    private AppStateAppOpsBridge.PermissionState createPermissionState(com.android.settingslib.applications.ApplicationsState.AppEntry r2) {
        return getOverlayInfo(r2.info.packageName, r2.info.uid);
    }

    private void setNewState(com.android.settingslib.applications.ApplicationsState.AppEntry r3, boolean r4) {
        AppOpsManager r2 = this.mAppOpsManager;
        int r0 = r3.info.uid;
        String r5 = r3.info.packageName;
        if (r4 == false) goto L5;
        int r6 = 0;
    L6:
        r2.setMode(24, r0, r5, r6);
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
        return new AppStateOverlayBridge$$ExternalSyntheticLambda0(this, r2);
    }

    /* JADX INFO: renamed from: lambda$getSwitchOnCheckedListener$0$com-android-settings-applications-AppStateOverlayBridge, reason: not valid java name */
    /* synthetic */ void m281x5aeb1d96(com.android.settingslib.applications.ApplicationsState.AppEntry r1, CompoundButton r2, boolean r3) {
        AppStateAppOpsBridge.PermissionState r4 = createPermissionState(r1);
        if (r4 != null) goto L5;
        return;
    L5:
        if (r3 == r4.isPermissible()) goto L9;
        setNewState(r1, Boolean.valueOf(r3).booleanValue());
        return;
    }

    @Override // com.android.settings.applications.AppStateBaseSwitchInterface
    public final boolean enableSwitch(com.android.settingslib.applications.ApplicationsState.AppEntry r2) {
        OverlayState r1 = (OverlayState) createPermissionState(r2);
        if (r1 != null) goto L6;
        return false;
    L6:
        if (r1.permissionDeclared == true) goto L8;
        return false;
    L8:
        if (r1.controlEnabled == false) goto L12;
        return true;
    L12:
        return false;
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
