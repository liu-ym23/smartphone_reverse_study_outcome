package com.android.settings.applications;

import android.app.AlertDialog;
import android.app.AppOpsManager;
import android.app.admin.DevicePolicyManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.UserHandle;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.SwitchPreference;
import com.android.settings.R;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class UsageAccessDetails extends AppInfoWithHeader implements Preference.OnPreferenceChangeListener, Preference.OnPreferenceClickListener {
    private static final String KEY_APP_OPS_PREFERENCE_SCREEN = "app_ops_preference_screen";
    private static final String KEY_APP_OPS_SETTINGS_DESC = "app_ops_settings_description";
    private static final String KEY_APP_OPS_SETTINGS_PREFS = "app_ops_settings_preference";
    private static final String KEY_APP_OPS_SETTINGS_SWITCH = "app_ops_settings_switch";
    private AppOpsManager mAppOpsManager;
    private DevicePolicyManager mDpm;
    private Intent mSettingsIntent;
    private SwitchPreference mSwitchPref;
    private AppStateUsageBridge mUsageBridge;
    private Preference mUsageDesc;
    private Preference mUsagePrefs;
    private AppStateUsageBridge.UsageState mUsageState;

    public void com_android_settings_applications_UsageAccessDetails__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.applications.AppInfoBase
    protected AlertDialog createDialog(int r1, int r2) {
        return null;
    }

    @Override // com.android.settings.applications.AppInfoBase, com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_applications_UsageAccessDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.applications.AppInfoBase, com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_applications_UsageAccessDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public UsageAccessDetails() {
    }

    public void com_android_settings_applications_UsageAccessDetails__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        FragmentActivity r5 = getActivity();
        this.mUsageBridge = new AppStateUsageBridge(r5, this.mState, null);
        this.mAppOpsManager = (AppOpsManager) r5.getSystemService("appops");
        this.mDpm = (DevicePolicyManager) r5.getSystemService(DevicePolicyManager.class);
        addPreferencesFromResource(R.xml.app_ops_permissions_details);
        this.mSwitchPref = (SwitchPreference) findPreference(KEY_APP_OPS_SETTINGS_SWITCH);
        this.mUsagePrefs = findPreference(KEY_APP_OPS_SETTINGS_PREFS);
        this.mUsageDesc = findPreference(KEY_APP_OPS_SETTINGS_DESC);
        getPreferenceScreen().setTitle(R.string.usage_access);
        this.mSwitchPref.setTitle(R.string.permit_usage_access);
        this.mUsagePrefs.setTitle(R.string.app_usage_preference);
        this.mUsageDesc.setSummary(R.string.usage_access_description);
        this.mSwitchPref.setOnPreferenceChangeListener(this);
        this.mUsagePrefs.setOnPreferenceClickListener(this);
        this.mSettingsIntent = new Intent("android.intent.action.MAIN").addCategory("android.intent.category.USAGE_ACCESS_CONFIG").setPackage(this.mPackageName);
    }

    @Override // androidx.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference r4) {
        if (r4 == this.mUsagePrefs) goto L5;
        return false;
    L5:
        if (this.mSettingsIntent == null) goto L16;
        getActivity().startActivityAsUser(this.mSettingsIntent, new UserHandle(this.mUserId));     // Catch: ActivityNotFoundException -> L8
        return true;
    L8:
        e = move-exception;
        OLog.w(TAG, "Unable to launch app usage access settings " + this.mSettingsIntent, e);
        return true;
    L16:
        return true;
    }

    @Override // androidx.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference r3, Object r4) {
        if (r3 == this.mSwitchPref) goto L5;
        return false;
    L5:
        if (this.mUsageState != null) goto L7;
    L14:
        return true;
    L7:
        if (((Boolean) r4).booleanValue() == this.mUsageState.isPermissible()) goto L14;
        if (this.mUsageState.isPermissible() == true) goto L11;
    L13:
        setHasAccess(!this.mUsageState.isPermissible());
        refreshUi();
        goto L14
    L11:
        if (this.mDpm.isProfileOwnerApp(this.mPackageName) == false) goto L13;
        new AlertDialog.Builder(getContext()).setIcon(android.R.drawable.ic_zen_mode_icon_piano).setTitle(android.R.string.dialog_alert_title).setMessage(R.string.work_profile_usage_access_warning).setPositiveButton(R.string.okay, null).show();
        goto L13
    }

    private void setHasAccess(boolean r4) {
        this.mAppOpsManager.setMode(43, this.mPackageInfo.applicationInfo.uid, this.mPackageName, !r4 ? 1 : 0);
    }

    @Override // com.android.settings.applications.AppInfoBase
    protected boolean refreshUi() {
        if (this.mPackageInfo != null) goto L6;
        return false;
    L6:
        AppStateUsageBridge.UsageState r0 = this.mUsageBridge.getUsageInfo(this.mPackageName, this.mPackageInfo.applicationInfo.uid);
        this.mUsageState = r0;
        boolean r1 = r0.isPermissible();
        this.mSwitchPref.setChecked(r1);
        this.mSwitchPref.setEnabled(this.mUsageState.permissionDeclared);
        this.mUsagePrefs.setEnabled(r1);
        ResolveInfo r2 = this.mPm.resolveActivityAsUser(this.mSettingsIntent, 128, this.mUserId);
        if (r2 == null) goto L17;
        if (findPreference(KEY_APP_OPS_SETTINGS_PREFS) != null) goto L11;
        getPreferenceScreen().addPreference(this.mUsagePrefs);
    L11:
        Bundle r3 = r2.activityInfo.metaData;
        this.mSettingsIntent.setComponent(new ComponentName(r2.activityInfo.packageName, r2.activityInfo.name));
        if (r3 != null) goto L14;
        return true;
    L14:
        if (r3.containsKey("android.settings.metadata.USAGE_ACCESS_REASON") == false) goto L22;
        this.mSwitchPref.setSummary(r3.getString("android.settings.metadata.USAGE_ACCESS_REASON"));
        return true;
    L22:
        return true;
    L17:
        if (findPreference(KEY_APP_OPS_SETTINGS_PREFS) == null) goto L24;
        getPreferenceScreen().removePreference(this.mUsagePrefs);
        return true;
    L24:
        return true;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_applications_UsageAccessDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(UsageAccessDetails r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_UsageAccessDetails__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_UsageAccessDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(UsageAccessDetails r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_applications_UsageAccessDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_UsageAccessDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(UsageAccessDetails r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_UsageAccessDetails__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
