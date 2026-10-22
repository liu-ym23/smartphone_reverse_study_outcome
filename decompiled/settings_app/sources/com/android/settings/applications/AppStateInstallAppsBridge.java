package com.android.settings.applications;

import android.app.AppGlobals;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.IPackageManager;
import android.os.UserHandle;
import android.os.UserManager;
import android.widget.CompoundButton;
import com.android.internal.util.ArrayUtils;
import com.obric.olog.OLog;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class AppStateInstallAppsBridge extends AppStateBaseBridge implements AppStateBaseSwitchInterface {
    public static final com.android.settingslib.applications.ApplicationsState.AppFilter FILTER_APP_SOURCES = null;
    private static final String TAG = "AppStateInstallAppsBridge";
    private final AppOpsManager mAppOpsManager;
    private Context mContext;
    private final IPackageManager mIpm;
    private UserManager mUserManager;

    public static class InstallAppsState {
        int appOpMode;
        boolean permissionGranted;
        boolean permissionRequested;

        public InstallAppsState() {
            this.appOpMode = 3;
        }

        public boolean canInstallApps() {
            if (this.appOpMode != 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isPotentialAppSource() {
            if (this.appOpMode == 3) goto L5;
        L8:
            return true;
        L5:
            if (this.permissionRequested == true) goto L8;
            return false;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder("[permissionGranted: " + this.permissionGranted);
            r0.append(", permissionRequested: " + this.permissionRequested);
            r0.append(", appOpMode: " + this.appOpMode);
            r0.append("]");
            return r0.toString();
        }
    }

    static /* synthetic */ Context access$000(AppStateInstallAppsBridge r0) {
        return r0.mContext;
    }

    static /* synthetic */ InstallAppsState access$100(AppStateInstallAppsBridge r0, com.android.settingslib.applications.ApplicationsState.AppEntry r1) {
        return r0.getPermissionState(r1);
    }

    static /* synthetic */ void access$200(AppStateInstallAppsBridge r0, com.android.settingslib.applications.ApplicationsState.AppEntry r1, boolean r2) {
        r0.setPermissionState(r1, r2);
    }

    public AppStateInstallAppsBridge(Context r1, com.android.settingslib.applications.ApplicationsState r2, AppStateBaseBridge.Callback r3) {
        super(r2, r3);
        this.mIpm = AppGlobals.getPackageManager();
        this.mContext = r1;
        this.mAppOpsManager = (AppOpsManager) r1.getSystemService("appops");
        this.mUserManager = UserManager.get(r1);
    }

    @Override // com.android.settings.applications.AppStateBaseBridge
    protected void updateExtraInfo(com.android.settingslib.applications.ApplicationsState.AppEntry r1, String r2, int r3) {
        r1.extraInfo = createInstallAppsStateFor(r2, r3);
    }

    @Override // com.android.settings.applications.AppStateBaseBridge
    protected void loadAllExtraInfo() {
        ArrayList<com.android.settingslib.applications.ApplicationsState.AppEntry> r0 = this.mAppSession.getAllApps();
        int r1 = 0;
    L4:
        if (r1 >= r0.size()) goto L6;
        com.android.settingslib.applications.ApplicationsState.AppEntry r2 = r0.get(r1);
        updateExtraInfo(r2, r2.info.packageName, r2.info.uid);
        r1 = r1 + 1;
        goto L4
    }

    private boolean hasRequestedAppOpPermission(String r1, String r2, int r3) {
        return ArrayUtils.contains(this.mIpm.getAppOpPermissionPackages(r1, this.mContext.getUserId()), r2);
    L4:
        OLog.e(TAG, "PackageManager dead. Cannot get permission info");
        return false;
    }

    private boolean hasPermission(String r2, int r3) {
        if (this.mIpm.checkUidPermission(r2, r3) != 0) goto L11;
        return true;
    L11:
        return false;
    L7:
        OLog.e(TAG, "PackageManager dead. Cannot get permission info");
        return false;
    }

    private int getAppOpMode(int r1, int r2, String r3) {
        return this.mAppOpsManager.checkOpNoThrow(r1, r2, r3);
    }

    InstallAppsState createInstallAppsStateFor(String r4, int r5) {
        InstallAppsState r0 = new InstallAppsState();
        r0.permissionRequested = hasRequestedAppOpPermission("android.permission.REQUEST_INSTALL_PACKAGES", r4, UserHandle.getUserId(r5));
        r0.permissionGranted = hasPermission("android.permission.REQUEST_INSTALL_PACKAGES", r5);
        r0.appOpMode = getAppOpMode(66, r5, r4);
        return r0;
    }

    static {
        FILTER_APP_SOURCES = new AnonymousClass1();
    }

    private InstallAppsState getPermissionState(com.android.settingslib.applications.ApplicationsState.AppEntry r2) {
        return createInstallAppsStateFor(r2.info.packageName, r2.info.uid);
    }

    private void setPermissionState(com.android.settingslib.applications.ApplicationsState.AppEntry r3, boolean r4) {
        AppOpsManager r2 = this.mAppOpsManager;
        int r0 = r3.info.uid;
        String r5 = r3.info.packageName;
        if (r4 == false) goto L5;
        int r6 = 0;
    L6:
        r2.setMode(66, r0, r5, r6);
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
        return new AnonymousClass2(this, r2);
    }

    @Override // com.android.settings.applications.AppStateBaseSwitchInterface
    public final boolean enableSwitch(com.android.settingslib.applications.ApplicationsState.AppEntry r4) {
        InstallAppsState r5 = getPermissionState(r4);
        if (r5 != null) goto L6;
        return false;
    L6:
        if (this.mUserManager.hasBaseUserRestriction("no_install_unknown_sources", UserHandle.of(UserHandle.myUserId())) == false) goto L9;
        return false;
    L9:
        return r5.isPotentialAppSource();
    }

    @Override // com.android.settings.applications.AppStateBaseSwitchInterface
    public final boolean checkSwitch(com.android.settingslib.applications.ApplicationsState.AppEntry r4) {
        InstallAppsState r5 = getPermissionState(r4);
        if (r5 != null) goto L6;
        return false;
    L6:
        if (this.mUserManager.hasBaseUserRestriction("no_install_unknown_sources", UserHandle.of(UserHandle.myUserId())) == false) goto L9;
        return false;
    L9:
        return r5.canInstallApps();
    }
}
