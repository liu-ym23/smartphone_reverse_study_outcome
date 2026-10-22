package com.android.settings.applications;

import android.app.AppOpsManager;
import android.content.Context;
import android.widget.CompoundButton;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class AppStateTurnScreenOnBridge extends AppStateAppOpsBridge implements AppStateBaseSwitchInterface {
    private static final String APP_OP_STR = "android:turn_screen_on";
    public static final com.android.settingslib.applications.ApplicationsState.AppFilter FILTER_TURN_SCREEN_ON_APPS = null;
    private static final String[] PERMISSIONS = null;
    private AppOpsManager mAppOpsManager;

    static {
        PERMISSIONS = new String[]{"android.permission.TURN_SCREEN_ON"};
        FILTER_TURN_SCREEN_ON_APPS = new AnonymousClass1();
    }

    public AppStateTurnScreenOnBridge(Context r8, com.android.settingslib.applications.ApplicationsState r9, AppStateBaseBridge.Callback r10) {
        super(r8, r9, r10, AppOpsManager.strOpToOp(APP_OP_STR), PERMISSIONS);
        this.mAppOpsManager = (AppOpsManager) r8.getSystemService(AppOpsManager.class);
    }

    @Override // com.android.settings.applications.AppStateAppOpsBridge, com.android.settings.applications.AppStateBaseBridge
    protected void updateExtraInfo(com.android.settingslib.applications.ApplicationsState.AppEntry r1, String r2, int r3) {
        r1.extraInfo = getPermissionInfo(r2, r3);
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

    private void setNewState(com.android.settingslib.applications.ApplicationsState.AppEntry r2, boolean r3) {
        AppOpsManager r1 = this.mAppOpsManager;
        int r4 = r2.info.uid;
        if (r3 == false) goto L5;
        int r5 = 0;
    L6:
        r1.setUidMode(APP_OP_STR, r4, r5);
        return;
    L5:
        r5 = 2;
        goto L6
    }

    private AppStateAppOpsBridge.PermissionState createPermissionState(com.android.settingslib.applications.ApplicationsState.AppEntry r2) {
        return getPermissionInfo(r2.info.packageName, r2.info.uid);
    }

    @Override // com.android.settings.applications.AppStateBaseSwitchInterface
    public CompoundButton.OnCheckedChangeListener getSwitchOnCheckedListener(final com.android.settingslib.applications.ApplicationsState.AppEntry r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return new AppStateTurnScreenOnBridge$$ExternalSyntheticLambda0(this, r2);
    }

    /* JADX INFO: renamed from: lambda$getSwitchOnCheckedListener$0$com-android-settings-applications-AppStateTurnScreenOnBridge, reason: not valid java name */
    /* synthetic */ void m282xf892d534(com.android.settingslib.applications.ApplicationsState.AppEntry r1, CompoundButton r2, boolean r3) {
        AppStateAppOpsBridge.PermissionState r4 = createPermissionState(r1);
        if (r4 != null) goto L5;
        return;
    L5:
        if (r3 == r4.isPermissible()) goto L9;
        setNewState(r1, Boolean.valueOf(r3).booleanValue());
        return;
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
