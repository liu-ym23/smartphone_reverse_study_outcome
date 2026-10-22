package com.android.settings.applications;

import android.app.AlarmManager;
import android.app.AppOpsManager;
import android.app.compat.CompatChanges;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.PowerExemptionManager;
import android.os.UserHandle;
import android.widget.CompoundButton;
import com.android.internal.util.ArrayUtils;
import com.obric.olog.OLog;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class AppStateAlarmsAndRemindersBridge extends AppStateBaseBridge implements AppStateBaseSwitchInterface {
    public static final com.android.settingslib.applications.ApplicationsState.AppFilter FILTER_CLOCK_APPS = null;
    private static final String SEA_PERMISSION = "android.permission.SCHEDULE_EXACT_ALARM";
    private static final String TAG = "AlarmsAndRemindersBridge";
    private static final String UEA_PERMISSION = "android.permission.USE_EXACT_ALARM";
    AlarmManager mAlarmManager;
    private AppOpsManager mAppOpsManager;
    PackageManager mPackageManager;
    PowerExemptionManager mPowerExemptionManager;

    public static class AlarmsAndRemindersState {
        private boolean mAllowListed;
        private boolean mSeaPermissionGranted;
        private boolean mSeaPermissionRequested;
        private boolean mUeaPermissionRequested;

        AlarmsAndRemindersState(boolean r1, boolean r2, boolean r3, boolean r4) {
            this.mSeaPermissionRequested = r1;
            this.mUeaPermissionRequested = r2;
            this.mSeaPermissionGranted = r3;
            this.mAllowListed = r4;
        }

        public boolean shouldBeVisible() {
            if (this.mSeaPermissionRequested == true) goto L5;
        L9:
            return false;
        L5:
            if (this.mUeaPermissionRequested == true) goto L9;
            if (this.mAllowListed == true) goto L9;
            return true;
        }

        public boolean isAllowed() {
            if (this.mSeaPermissionGranted == false) goto L5;
        L10:
            return true;
        L5:
            if (this.mUeaPermissionRequested == true) goto L10;
            if (this.mAllowListed == true) goto L10;
            return false;
        }
    }

    private boolean isAppSpecific() {
        return true;
    }

    public AppStateAlarmsAndRemindersBridge(Context r1, com.android.settingslib.applications.ApplicationsState r2, AppStateBaseBridge.Callback r3) {
        super(r2, r3);
        this.mPowerExemptionManager = (PowerExemptionManager) r1.getSystemService(PowerExemptionManager.class);
        this.mAlarmManager = (AlarmManager) r1.getSystemService(AlarmManager.class);
        this.mPackageManager = r1.getPackageManager();
        this.mAppOpsManager = (AppOpsManager) r1.getSystemService(AppOpsManager.class);
    }

    private boolean isChangeEnabled(String r3, int r4) {
        return CompatChanges.isChangeEnabled(171306433, r3, UserHandle.of(r4));
    }

    private boolean isUeaChangeEnabled(String r3, int r4) {
        return CompatChanges.isChangeEnabled(218533173, r3, UserHandle.of(r4));
    }

    private String[] getRequestedPermissions(String r2, int r3) {
        return this.mPackageManager.getPackageInfoAsUser(r2, 4096, r3).requestedPermissions;
    L4:
        e = move-exception;
        OLog.e(TAG, "Could not find package " + r2, e);
        return null;
    }

    public AlarmsAndRemindersState createPermissionState(String r6, int r7) {
        int r8 = UserHandle.getUserId(r7);
        String[] r0 = getRequestedPermissions(r6, r8);
        boolean r2 = false;
        if (ArrayUtils.contains(r0, SEA_PERMISSION) == true) goto L5;
    L7:
        boolean r1 = false;
    L9:
        if (ArrayUtils.contains(r0, UEA_PERMISSION) == false) goto L14;
        if (isUeaChangeEnabled(r6, r8) == false) goto L14;
        r2 = true;
    L14:
        return new AlarmsAndRemindersState(r1, r2, this.mAlarmManager.hasScheduleExactAlarm(r6, r8), this.mPowerExemptionManager.isAllowListed(r6, true));
    L5:
        if (isChangeEnabled(r6, r8) == false) goto L7;
        r1 = true;
        goto L9
    }

    @Override // com.android.settings.applications.AppStateBaseBridge
    protected void updateExtraInfo(com.android.settingslib.applications.ApplicationsState.AppEntry r1, String r2, int r3) {
        r1.extraInfo = createPermissionState(r2, r3);
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

    static {
        FILTER_CLOCK_APPS = new AnonymousClass1();
    }

    private AlarmsAndRemindersState createPermissionState(com.android.settingslib.applications.ApplicationsState.AppEntry r2) {
        return createPermissionState(r2.info.packageName, r2.info.uid);
    }

    private void setNewState(com.android.settingslib.applications.ApplicationsState.AppEntry r2, boolean r3) {
        int r4 = r2.info.uid;
        AppOpsManager r1 = this.mAppOpsManager;
        if (r3 == false) goto L5;
        int r5 = 0;
    L6:
        r1.setUidMode("android:schedule_exact_alarm", r4, r5);
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
        return new AppStateAlarmsAndRemindersBridge$$ExternalSyntheticLambda0(this, r2);
    }

    /* JADX INFO: renamed from: lambda$getSwitchOnCheckedListener$0$com-android-settings-applications-AppStateAlarmsAndRemindersBridge, reason: not valid java name */
    /* synthetic */ void m276xda952478(com.android.settingslib.applications.ApplicationsState.AppEntry r1, CompoundButton r2, boolean r3) {
        AlarmsAndRemindersState r4 = createPermissionState(r1);
        if (r4 != null) goto L5;
        return;
    L5:
        if (r3 == r4.isAllowed()) goto L9;
        setNewState(r1, Boolean.valueOf(r3).booleanValue());
        return;
    }

    @Override // com.android.settings.applications.AppStateBaseSwitchInterface
    public final boolean enableSwitch(com.android.settingslib.applications.ApplicationsState.AppEntry r1) {
        AlarmsAndRemindersState r0 = createPermissionState(r1);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.shouldBeVisible();
    }

    @Override // com.android.settings.applications.AppStateBaseSwitchInterface
    public final boolean checkSwitch(com.android.settingslib.applications.ApplicationsState.AppEntry r1) {
        AlarmsAndRemindersState r0 = createPermissionState(r1);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isAllowed();
    }
}
