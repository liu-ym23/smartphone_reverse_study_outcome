package com.android.settings;

import android.content.Intent;
import android.os.Bundle;
import androidx.preference.CheckBoxPreference;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class ApplicationSettings extends SettingsPreferenceFragment {
    private static final int APP_INSTALL_AUTO = 0;
    private static final String APP_INSTALL_AUTO_ID = "auto";
    private static final int APP_INSTALL_DEVICE = 1;
    private static final String APP_INSTALL_DEVICE_ID = "device";
    private static final int APP_INSTALL_SDCARD = 2;
    private static final String APP_INSTALL_SDCARD_ID = "sdcard";
    private static final String KEY_APP_INSTALL_LOCATION = "app_install_location";
    private static final String KEY_TOGGLE_ADVANCED_SETTINGS = "toggle_advanced_settings";
    private ListPreference mInstallLocation;
    private CheckBoxPreference mToggleAdvancedSettings;

    public void com_android_settings_ApplicationSettings__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_ApplicationSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_ApplicationSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public ApplicationSettings() {
    }

    public void com_android_settings_ApplicationSettings__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        addPreferencesFromResource(R.xml.application_settings);
        this.mToggleAdvancedSettings = (CheckBoxPreference) findPreference(KEY_TOGGLE_ADVANCED_SETTINGS);
        getPreferenceScreen().removePreference(this.mToggleAdvancedSettings);
        this.mInstallLocation = (ListPreference) findPreference(KEY_APP_INSTALL_LOCATION);
        boolean r1 = false;
        if (android.provider.Settings.Global.getInt(getContentResolver(), "set_install_location", 0) == 0) goto L5;
        r1 = true;
    L5:
        if (r1 == true) goto L7;
        getPreferenceScreen().removePreference(this.mInstallLocation);
        return;
    L7:
        this.mInstallLocation.setValue(getAppInstallLocation());
        this.mInstallLocation.setOnPreferenceChangeListener(new AnonymousClass1(this));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        this.mToggleAdvancedSettings.setChecked(isAdvancedSettingsEnabled());
    }

    protected void handleUpdateAppInstallLocation(String r4) {
        if ("device".equals(r4) == false) goto L6;
        android.provider.Settings.Global.putInt(getContentResolver(), "default_install_location", 1);
    L12:
        this.mInstallLocation.setValue(r4);
        return;
    L6:
        if (APP_INSTALL_SDCARD_ID.equals(r4) == false) goto L9;
        android.provider.Settings.Global.putInt(getContentResolver(), "default_install_location", 2);
        goto L12
    L9:
        if ("auto".equals(r4) == false) goto L11;
        android.provider.Settings.Global.putInt(getContentResolver(), "default_install_location", 0);
        goto L12
    L11:
        android.provider.Settings.Global.putInt(getContentResolver(), "default_install_location", 0);
        goto L12
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.preference.PreferenceManager.OnPreferenceTreeClickListener
    public boolean onPreferenceTreeClick(Preference r2) {
        CheckBoxPreference r0 = this.mToggleAdvancedSettings;
        if (r2 != r0) goto L6;
        setAdvancedSettingsEnabled(r0.isChecked());
    L6:
        return super.onPreferenceTreeClick(r2);
    }

    private boolean isAdvancedSettingsEnabled() {
        if (android.provider.Settings.System.getInt(getContentResolver(), "advanced_settings", 0) <= 0) goto L6;
        return true;
    L6:
        return false;
    }

    private void setAdvancedSettingsEnabled(boolean r3) {
        android.provider.Settings.Secure.putInt(getContentResolver(), "advanced_settings", r3 ? 1 : 0);
        Intent r0 = new Intent("android.intent.action.ADVANCED_SETTINGS");
        r0.putExtra("state", r3 ? 1 : 0);
        getActivity().sendBroadcast(r0);
    }

    private String getAppInstallLocation() {
        int r2 = android.provider.Settings.Global.getInt(getContentResolver(), "default_install_location", 0);
        if (r2 != 1) goto L7;
        return "device";
    L7:
        if (r2 != 2) goto L10;
        return APP_INSTALL_SDCARD_ID;
    L10:
        return "auto";
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_ApplicationSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ApplicationSettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_ApplicationSettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_ApplicationSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ApplicationSettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_ApplicationSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_ApplicationSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ApplicationSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_ApplicationSettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
