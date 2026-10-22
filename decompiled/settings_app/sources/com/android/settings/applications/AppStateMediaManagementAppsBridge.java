package com.android.settings.applications;

import android.app.AppOpsManager;
import android.content.Context;
import android.widget.CompoundButton;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class AppStateMediaManagementAppsBridge extends AppStateAppOpsBridge implements AppStateBaseSwitchInterface {
    public static final com.android.settingslib.applications.ApplicationsState.AppFilter FILTER_MEDIA_MANAGEMENT_APPS = null;
    private final AppOpsManager mAppOpsManager;

    public AppStateMediaManagementAppsBridge(Context r8, com.android.settingslib.applications.ApplicationsState r9, AppStateBaseBridge.Callback r10) {
        super(r8, r9, r10, AppOpsManager.strOpToOp("android:manage_media"), new String[]{"android.permission.MANAGE_MEDIA"});
        this.mAppOpsManager = (AppOpsManager) r8.getSystemService(AppOpsManager.class);
    }

    @Override // com.android.settings.applications.AppStateAppOpsBridge, com.android.settings.applications.AppStateBaseBridge
    protected void updateExtraInfo(com.android.settingslib.applications.ApplicationsState.AppEntry r1, String r2, int r3) {
        r1.extraInfo = createPermissionState(r2, r3);
    }

    @Override // com.android.settings.applications.AppStateAppOpsBridge, com.android.settings.applications.AppStateBaseBridge
    protected void loadAllExtraInfo() {
        super.loadAllExtraInfo();
        ArrayList<com.android.settingslib.applications.ApplicationsState.AppEntry> r0 = this.mAppSession.getAllApps();
        int r1 = r0.size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        com.android.settingslib.applications.ApplicationsState.AppEntry r3 = r0.get(r2);
        if ((r3.extraInfo instanceof AppStateAppOpsBridge.PermissionState) == false) goto L7;
        updateExtraInfo(r3, r3.info.packageName, r3.info.uid);
    L7:
        r2 = r2 + 1;
        goto L3
    }

    public AppStateAppOpsBridge.PermissionState createPermissionState(String r3, int r4) {
        AppStateAppOpsBridge.PermissionState r0 = getPermissionInfo(r3, r4);
        r0.appOpMode = this.mAppOpsManager.unsafeCheckOpNoThrow("android:manage_media", r4, r3);
        return r0;
    }

    static {
        FILTER_MEDIA_MANAGEMENT_APPS = new AnonymousClass1();
    }

    private AppStateAppOpsBridge.PermissionState createPermissionState(com.android.settingslib.applications.ApplicationsState.AppEntry r2) {
        return createPermissionState(r2.info.packageName, r2.info.uid);
    }

    private void setCanManageMedia(com.android.settingslib.applications.ApplicationsState.AppEntry r2, boolean r3) {
        AppOpsManager r1 = this.mAppOpsManager;
        int r0 = AppOpsManager.strOpToOp("android:manage_media");
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
        return new AppStateMediaManagementAppsBridge$$ExternalSyntheticLambda0(this, r2);
    }

    /* JADX INFO: renamed from: lambda$getSwitchOnCheckedListener$0$com-android-settings-applications-AppStateMediaManagementAppsBridge, reason: not valid java name */
    /* synthetic */ void m279xdda6655f(com.android.settingslib.applications.ApplicationsState.AppEntry r1, CompoundButton r2, boolean r3) {
        AppStateAppOpsBridge.PermissionState r4 = createPermissionState(r1);
        if (r4 != null) goto L5;
        return;
    L5:
        if (r3 == r4.isPermissible()) goto L9;
        setCanManageMedia(r1, Boolean.valueOf(r3).booleanValue());
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
