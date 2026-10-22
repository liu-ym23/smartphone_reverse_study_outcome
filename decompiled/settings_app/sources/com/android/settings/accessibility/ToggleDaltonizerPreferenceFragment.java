package com.android.settings.accessibility;

import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Switch;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import com.android.settings.R;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.widget.SwitchBar;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class ToggleDaltonizerPreferenceFragment extends ToggleFeaturePreferenceFragment implements Preference.OnPreferenceChangeListener, SwitchBar.OnSwitchChangeListener {
    private static final int DEFAULT_TYPE = 12;
    private static final String ENABLED = "accessibility_display_daltonizer_enabled";
    private static final String TYPE = "accessibility_display_daltonizer";
    private ListPreference mType;

    public void com_android_settings_accessibility_ToggleDaltonizerPreferenceFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.accessibility.ToggleFeaturePreferenceFragment, com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_accessibility_ToggleDaltonizerPreferenceFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_accessibility_ToggleDaltonizerPreferenceFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public ToggleDaltonizerPreferenceFragment() {
    }

    public void com_android_settings_accessibility_ToggleDaltonizerPreferenceFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
        addPreferencesFromResource(R.xml.accessibility_daltonizer_settings);
        this.mType = (ListPreference) findPreference("type");
        initPreferences();
    }

    @Override // com.android.settings.accessibility.ToggleFeaturePreferenceFragment
    protected void onPreferenceToggled(String r1, boolean r2) {
        Settings.Secure.putInt(getContentResolver(), ENABLED, r2 ? 1 : 0);
    }

    @Override // androidx.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference r2, Object r3) {
        if (r2 != this.mType) goto L7;
        Settings.Secure.putInt(getContentResolver(), TYPE, Integer.parseInt((String) r3));
        r2.setSummary("%s");
        return true;
    L7:
        return true;
    }

    @Override // com.android.settings.accessibility.ToggleFeaturePreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        setTitle(getString(R.string.accessibility_display_daltonizer_preference_title));
    }

    @Override // com.android.settings.accessibility.ToggleFeaturePreferenceFragment
    protected void onInstallSwitchBarToggleSwitch() {
        super.onInstallSwitchBarToggleSwitch();
        SwitchBar r0 = this.mSwitchBar;
        boolean r3 = false;
        if (Settings.Secure.getInt(getContentResolver(), ENABLED, 0) != 1) goto L5;
        r3 = true;
    L5:
        r0.setCheckedInternal(r3);
        this.mSwitchBar.addOnSwitchChangeListener(this);
    }

    @Override // com.android.settings.accessibility.ToggleFeaturePreferenceFragment
    protected void onRemoveSwitchBarToggleSwitch() {
        super.onRemoveSwitchBarToggleSwitch();
        this.mSwitchBar.removeOnSwitchChangeListener(this);
    }

    private void initPreferences() {
        String r0 = Integer.toString(Settings.Secure.getInt(getContentResolver(), TYPE, 12));
        this.mType.setValue(r0);
        this.mType.setOnPreferenceChangeListener(this);
        if (this.mType.findIndexOfValue(r0) >= 0) goto L6;
        this.mType.setSummary(getString(R.string.daltonizer_type_overridden, new Object[]{getString(R.string.simulate_color_space)}));
        return;
    }

    @Override // com.android.settings.widget.SwitchBar.OnSwitchChangeListener
    public void onSwitchChanged(Switch r1, boolean r2) {
        onPreferenceToggled(this.mPreferenceKey, r2);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_accessibility_ToggleDaltonizerPreferenceFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ToggleDaltonizerPreferenceFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_accessibility_ToggleDaltonizerPreferenceFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_accessibility_ToggleDaltonizerPreferenceFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ToggleDaltonizerPreferenceFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_accessibility_ToggleDaltonizerPreferenceFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_accessibility_ToggleDaltonizerPreferenceFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ToggleDaltonizerPreferenceFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_accessibility_ToggleDaltonizerPreferenceFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
