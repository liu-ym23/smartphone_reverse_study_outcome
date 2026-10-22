package com.android.settings.location;

import android.os.Bundle;
import android.provider.Settings;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import androidx.preference.SwitchPreference;
import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.NullSafe;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class ScanningSettings extends SettingsPreferenceFragment {
    private static final String KEY_BLUETOOTH_SCAN_ALWAYS_AVAILABLE = "bluetooth_always_scanning";
    private static final String KEY_WIFI_SCAN_ALWAYS_AVAILABLE = "wifi_always_scanning";

    public void com_android_settings_location_ScanningSettings__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_location_ScanningSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_location_ScanningSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public ScanningSettings() {
    }

    public void com_android_settings_location_ScanningSettings__onResume$___twin___() {
        super.onResume();
        createPreferenceHierarchy();
    }

    private PreferenceScreen createPreferenceHierarchy() {
        PreferenceScreen r0 = getPreferenceScreen();
        if (r0 == null) goto L5;
        r0.removeAll();
    L5:
        addPreferencesFromResource(R.xml.location_scanning);
        PreferenceScreen r1 = getPreferenceScreen();
        initPreferences();
        return r1;
    }

    private void initPreferences() {
        SwitchPreference r0 = (SwitchPreference) findPreference(KEY_WIFI_SCAN_ALWAYS_AVAILABLE);
        boolean r3 = false;
        if (Settings.Global.getInt(getContentResolver(), "wifi_scan_always_enabled", 0) != 1) goto L5;
        boolean r1 = true;
    L6:
        r0.setChecked(r1);
        SwitchPreference r2 = (SwitchPreference) NullSafe.nonNull(findPreference(KEY_BLUETOOTH_SCAN_ALWAYS_AVAILABLE));
        if (Settings.Global.getInt(getContentResolver(), "ble_scan_always_enabled", 0) != 1) goto L9;
        r3 = true;
    L9:
        r2.setChecked(r3);
        return;
    L5:
        r1 = false;
        goto L6
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.preference.PreferenceManager.OnPreferenceTreeClickListener
    public boolean onPreferenceTreeClick(Preference r3) {
        String r0 = r3.getKey();
        if (KEY_WIFI_SCAN_ALWAYS_AVAILABLE.equals(r0) == false) goto L6;
        Settings.Global.putInt(getContentResolver(), "wifi_scan_always_enabled", ((SwitchPreference) r3).isChecked() ? 1 : 0);
        return true;
    L6:
        if (KEY_BLUETOOTH_SCAN_ALWAYS_AVAILABLE.equals(r0) == false) goto L11;
        Settings.Global.putInt(getContentResolver(), "ble_scan_always_enabled", ((SwitchPreference) r3).isChecked() ? 1 : 0);
        return true;
    L11:
        return super.onPreferenceTreeClick(r3);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_location_ScanningSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ScanningSettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_location_ScanningSettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_location_ScanningSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ScanningSettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_location_ScanningSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_location_ScanningSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ScanningSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_location_ScanningSettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
