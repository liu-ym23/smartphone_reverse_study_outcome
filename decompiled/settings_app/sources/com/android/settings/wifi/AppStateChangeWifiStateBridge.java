package com.android.settings.wifi;

import android.app.AppOpsManager;
import android.content.Context;
import android.widget.CompoundButton;
import com.android.settings.applications.AppStateAppOpsBridge;
import com.android.settings.applications.AppStateBaseBridge;
import com.android.settings.applications.AppStateBaseSwitchInterface;
import com.android.settingslib.applications.ApplicationsState;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class AppStateChangeWifiStateBridge extends AppStateAppOpsBridge implements AppStateBaseSwitchInterface {
    private static final int APP_OPS_OP_CODE = 71;
    public static final ApplicationsState.AppFilter FILTER_CHANGE_WIFI_STATE = null;
    private static final String PM_CHANGE_WIFI_STATE = "android.permission.CHANGE_WIFI_STATE";
    private static final String PM_NETWORK_SETTINGS = "android.permission.NETWORK_SETTINGS";
    private static final String[] PM_PERMISSIONS = null;
    private static final String TAG = "AppStateChangeWifiStateBridge";
    private AppOpsManager mAppOpsManager;

    public static class WifiSettingsState extends AppStateAppOpsBridge.PermissionState {
        public WifiSettingsState(AppStateAppOpsBridge.PermissionState r3) {
            super(r3.packageName, r3.userHandle);
            this.packageInfo = r3.packageInfo;
            this.appOpMode = r3.appOpMode;
            this.permissionDeclared = r3.permissionDeclared;
            this.staticPermissionGranted = r3.staticPermissionGranted;
        }
    }

    static {
        PM_PERMISSIONS = new String[]{PM_CHANGE_WIFI_STATE};
        FILTER_CHANGE_WIFI_STATE = new AnonymousClass1();
    }

    public AppStateChangeWifiStateBridge(Context r7, ApplicationsState r8, AppStateBaseBridge.Callback r9) {
        super(r7, r8, r9, 71, PM_PERMISSIONS);
        this.mAppOpsManager = (AppOpsManager) r7.getSystemService("appops");
    }

    @Override // com.android.settings.applications.AppStateAppOpsBridge, com.android.settings.applications.AppStateBaseBridge
    protected void updateExtraInfo(ApplicationsState.AppEntry r1, String r2, int r3) {
        r1.extraInfo = getWifiSettingsInfo(r2, r3);
    }

    @Override // com.android.settings.applications.AppStateAppOpsBridge, com.android.settings.applications.AppStateBaseBridge
    protected void loadAllExtraInfo() {
        Iterator<ApplicationsState.AppEntry> r0 = this.mAppSession.getAllApps().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ApplicationsState.AppEntry r1 = r0.next();
        updateExtraInfo(r1, r1.info.packageName, r1.info.uid);
        goto L4
    }

    public WifiSettingsState getWifiSettingsInfo(String r1, int r2) {
        return new WifiSettingsState(super.getPermissionInfo(r1, r2));
    }

    private void setNewState(ApplicationsState.AppEntry r3, boolean r4) {
        this.mAppOpsManager.setMode(71, r3.info.uid, r3.info.packageName, !r4 ? 1 : 0);
    }

    private AppStateAppOpsBridge.PermissionState createPermissionState(ApplicationsState.AppEntry r2) {
        return getWifiSettingsInfo(r2.info.packageName, r2.info.uid);
    }

    @Override // com.android.settings.applications.AppStateBaseSwitchInterface
    public CompoundButton.OnCheckedChangeListener getSwitchOnCheckedListener(final ApplicationsState.AppEntry r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return new AppStateChangeWifiStateBridge$$ExternalSyntheticLambda0(this, r2);
    }

    /* JADX INFO: renamed from: lambda$getSwitchOnCheckedListener$0$com-android-settings-wifi-AppStateChangeWifiStateBridge, reason: not valid java name */
    /* synthetic */ void m665x84813164(ApplicationsState.AppEntry r1, CompoundButton r2, boolean r3) {
        AppStateAppOpsBridge.PermissionState r4 = createPermissionState(r1);
        if (r4 != null) goto L5;
        return;
    L5:
        if (r3 == r4.isPermissible()) goto L9;
        setNewState(r1, Boolean.valueOf(r3).booleanValue());
        return;
    }

    @Override // com.android.settings.applications.AppStateBaseSwitchInterface
    public final boolean enableSwitch(ApplicationsState.AppEntry r1) {
        AppStateAppOpsBridge.PermissionState r0 = createPermissionState(r1);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.permissionDeclared;
    }

    @Override // com.android.settings.applications.AppStateBaseSwitchInterface
    public final boolean checkSwitch(ApplicationsState.AppEntry r1) {
        AppStateAppOpsBridge.PermissionState r0 = createPermissionState(r1);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isPermissible();
    }
}
