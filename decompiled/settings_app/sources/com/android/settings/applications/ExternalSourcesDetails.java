package com.android.settings.applications;

import android.app.AlertDialog;
import android.app.AppOpsManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.UserHandle;
import android.os.UserManager;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import com.android.settings.R;
import com.android.settings.Settings;
import com.android.settings.base.BaseActivity;
import com.android.settings.riskcontrol.RiskPermissionControlGuard;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.NullSafe;
import com.android.settingslib.RestrictedSwitchPreference;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class ExternalSourcesDetails extends AppInfoWithHeader implements Preference.OnPreferenceChangeListener {
    private static final String KEY_EXTERNAL_SOURCE_SWITCH = "external_sources_settings_switch";
    private AppStateInstallAppsBridge mAppBridge;
    private AppOpsManager mAppOpsManager;
    private AppStateInstallAppsBridge.InstallAppsState mInstallAppsState;
    private RestrictedSwitchPreference mSwitchPref;
    private UserManager mUserManager;

    public void com_android_settings_applications_ExternalSourcesDetails__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.applications.AppInfoBase
    protected AlertDialog createDialog(int r1, int r2) {
        return null;
    }

    @Override // com.android.settings.InstrumentedPreferenceFragment
    public int getMetricsCategory() {
        return 808;
    }

    @Override // com.android.settings.applications.AppInfoBase, com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_applications_ExternalSourcesDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.applications.AppInfoBase, com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_applications_ExternalSourcesDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public ExternalSourcesDetails() {
    }

    public void com_android_settings_applications_ExternalSourcesDetails__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        FragmentActivity r5 = getActivity();
        if (r5 != null) goto L5;
        finish();
    L5:
        this.mAppBridge = new AppStateInstallAppsBridge(r5, this.mState, null);
        this.mAppOpsManager = (AppOpsManager) r5.getSystemService("appops");
        this.mUserManager = UserManager.get(r5);
        addPreferencesFromResource(R.xml.external_sources_details);
        if ((r5 instanceof BaseActivity) == false) goto L8;
        ((BaseActivity) r5).setTitle(getPreferenceScreen().getTitle());
    L8:
        RestrictedSwitchPreference r6 = (RestrictedSwitchPreference) findPreference(KEY_EXTERNAL_SOURCE_SWITCH);
        this.mSwitchPref = r6;
        if (r6 == null) goto L12;
        r6.setOnPreferenceChangeListener(this);
        return;
    }

    @Override // androidx.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference r5, Object r6) {
        boolean r7 = ((Boolean) r6).booleanValue();
        int r1 = 0;
        if (r5 == this.mSwitchPref) goto L5;
        return false;
    L5:
        if (this.mPackageInfo != null) goto L7;
    L11:
        AppStateInstallAppsBridge.InstallAppsState r8 = this.mInstallAppsState;
        if (r8 != null) goto L14;
        return true;
    L14:
        if (r7 != r8.canInstallApps()) goto L16;
        return true;
    L16:
        if (Settings.ManageAppExternalSourcesActivity.class.getName().equals(((Intent) NullSafe.nonNull(getIntent())).getComponent().getClassName()) == false) goto L20;
        if (r7 == false) goto L19;
        r1 = -1;
    L19:
        setResult(r1);
    L20:
        setCanInstallApps(r7);
        refreshUi();
        return true;
    L7:
        if (this.mPackageInfo.applicationInfo == null) goto L11;
        if (RiskPermissionControlGuard.intercept(getActivity(), this.mPackageName, UserHandle.getUserId(this.mPackageInfo.applicationInfo.uid), 16) == false) goto L11;
        return false;
    }

    private void setCanInstallApps(boolean r4) {
        AppOpsManager r0 = this.mAppOpsManager;
        int r1 = this.mPackageInfo.applicationInfo.uid;
        String r3 = this.mPackageName;
        if (r4 == false) goto L5;
        int r5 = 0;
    L6:
        r0.setMode(66, r1, r3, r5);
        return;
    L5:
        r5 = 2;
        goto L6
    }

    @Override // com.android.settings.applications.AppInfoBase
    protected boolean refreshUi() {
        if (this.mPackageInfo != null) goto L5;
    L20:
        return false;
    L5:
        if (this.mSwitchPref == null) goto L20;
        if (this.mUserManager.hasBaseUserRestriction("no_install_unknown_sources", UserHandle.of(UserHandle.myUserId())) == false) goto L11;
        this.mSwitchPref.setChecked(false);
        this.mSwitchPref.setSummary(R.string.disabled);
        this.mSwitchPref.setEnabled(false);
        return true;
    L11:
        this.mSwitchPref.checkRestrictionAndSetDisabled("no_install_unknown_sources");
        if (this.mSwitchPref.isDisabledByAdmin() == false) goto L14;
        return true;
    L14:
        AppStateInstallAppsBridge.InstallAppsState r0 = this.mAppBridge.createInstallAppsStateFor(this.mPackageName, this.mPackageInfo.applicationInfo.uid);
        this.mInstallAppsState = r0;
        if (r0.isPotentialAppSource() == true) goto L18;
        this.mSwitchPref.setEnabled(false);
        return true;
    L18:
        this.mSwitchPref.setChecked(this.mInstallAppsState.canInstallApps());
        return true;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_applications_ExternalSourcesDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ExternalSourcesDetails r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_ExternalSourcesDetails__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_ExternalSourcesDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ExternalSourcesDetails r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_applications_ExternalSourcesDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_ExternalSourcesDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ExternalSourcesDetails r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_ExternalSourcesDetails__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
