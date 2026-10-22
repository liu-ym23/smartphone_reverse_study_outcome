package com.android.settings.applications;

import android.app.AppOpsManager;
import android.apphibernation.AppHibernationManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.permission.PermissionControllerManager;
import android.provider.DeviceConfig;
import android.util.Slog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;

/* JADX INFO: loaded from: classes2.dex */
public final class HibernationSwitchPreferenceController {
    private static final String TAG = "HibernationSwitchPrefController";
    private final AppOpsManager mAppOpsManager;
    Context mContext;
    private int mHibernationEligibility;
    private boolean mHibernationEligibilityLoaded;
    private boolean mIsPackageExemptByDefault;
    boolean mIsPackageSet;
    private String mPackageName;
    private int mPackageUid;
    private final PermissionControllerManager mPermissionControllerManager;

    public HibernationSwitchPreferenceController(Context r2) {
        this.mHibernationEligibility = -1;
        this.mContext = r2;
        this.mAppOpsManager = (AppOpsManager) r2.getSystemService(AppOpsManager.class);
        this.mPermissionControllerManager = (PermissionControllerManager) r2.getSystemService(PermissionControllerManager.class);
    }

    public int getAvailabilityStatus() {
        if (isHibernationEnabled() == true) goto L5;
    L7:
        return 2;
    L5:
        if (this.mIsPackageSet == false) goto L7;
        return 0;
    }

    void setPackage(String r6) {
        this.mPackageName = r6;
        PackageManager r0 = this.mContext.getPackageManager();
        if (r0.hasSystemFeature("android.hardware.type.automotive") == false) goto L5;
        int r1 = 30;
    L17:
        this.mPackageUid = r0.getPackageUid(r6, 0);     // Catch: PackageManager.NameNotFoundException -> L15
        if (hibernationTargetsPreSApps() == false) goto L11;
    L9:
        boolean r7 = false;
    L13:
        this.mIsPackageExemptByDefault = r7;     // Catch: PackageManager.NameNotFoundException -> L15
        this.mIsPackageSet = true;     // Catch: PackageManager.NameNotFoundException -> L15
        return;
    L11:
        if (r0.getTargetSdkVersion(r6) > r1) goto L9;
        r7 = true;
    L15:
        Slog.w(TAG, "Package [" + this.mPackageName + "] is not found!");
        this.mIsPackageSet = false;
        return;
    L5:
        r1 = 29;
        goto L17
    }

    private boolean isAppEligibleForHibernation() {
        if (this.mHibernationEligibilityLoaded == false) goto L9;
        int r2 = this.mHibernationEligibility;
        if (r2 == 1) goto L9;
        if (r2 == (-1)) goto L9;
        return true;
    L9:
        return false;
    }

    public void updateState(final OSwitch r5, final OCardListItem r6) {
        if (isAppEligibleForHibernation() == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        r5.setChecked(r0);
        r6.setEnabled(isAppEligibleForHibernation());
        r5.setEnabled(isAppEligibleForHibernation());
        if (this.mHibernationEligibilityLoaded == true) goto L12;
        this.mPermissionControllerManager.getHibernationEligibility(this.mPackageName, this.mContext.getMainExecutor(), new HibernationSwitchPreferenceController$$ExternalSyntheticLambda0(this, r5, r6));
        return;
    L12:
        return;
    L5:
        if (isPackageHibernationExemptByUser() == true) goto L7;
        r0 = true;
        goto L8
    }

    /* JADX INFO: renamed from: lambda$updateState$0$com-android-settings-applications-HibernationSwitchPreferenceController, reason: not valid java name */
    /* synthetic */ void m287x1923c6c9(OSwitch r1, OCardListItem r2, int r3) {
        this.mHibernationEligibility = r3;
        this.mHibernationEligibilityLoaded = true;
        updateState(r1, r2);
    }

    boolean isPackageHibernationExemptByUser() {
        if (this.mIsPackageSet == true) goto L5;
        return true;
    L5:
        int r0 = this.mAppOpsManager.unsafeCheckOpNoThrow("android:auto_revoke_permissions_if_unused", this.mPackageUid, this.mPackageName);
        if (r0 == 3) goto L12;
        if (r0 != 0) goto L13;
        return false;
    L13:
        return true;
    L12:
        return this.mIsPackageExemptByDefault;
    }

    public boolean onPreferenceChange(Object r7) {
        boolean r8 = ((Boolean) r7).booleanValue();     // Catch: RuntimeException -> L11
        AppOpsManager r1 = this.mAppOpsManager;     // Catch: RuntimeException -> L11
        int r3 = this.mPackageUid;     // Catch: RuntimeException -> L11
        if (r8 == false) goto L6;
        int r5 = 0;
    L7:
        r1.setUidMode("android:auto_revoke_permissions_if_unused", r3, r5);     // Catch: RuntimeException -> L11
        if (r8 == true) goto L10;
        AppHibernationManager r9 = (AppHibernationManager) this.mContext.getSystemService(AppHibernationManager.class);     // Catch: RuntimeException -> L11
        r9.setHibernatingForUser(this.mPackageName, false);     // Catch: RuntimeException -> L11
        r9.setHibernatingGlobally(this.mPackageName, false);     // Catch: RuntimeException -> L11
    L10:
        return true;
    L6:
        r5 = 1;
    L11:
        return false;
    }

    private static boolean isHibernationEnabled() {
        return DeviceConfig.getBoolean("app_hibernation", "app_hibernation_enabled", true);
    }

    private static boolean hibernationTargetsPreSApps() {
        return DeviceConfig.getBoolean("app_hibernation", "app_hibernation_targets_pre_s_apps", false);
    }
}
