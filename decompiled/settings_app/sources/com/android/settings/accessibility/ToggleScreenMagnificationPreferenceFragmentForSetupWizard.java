package com.android.settings.accessibility;

import android.os.Bundle;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class ToggleScreenMagnificationPreferenceFragmentForSetupWizard extends ToggleScreenMagnificationPreferenceFragment {
    private boolean mToggleSwitchWasInitiallyChecked;

    public void com_android_settings_accessibility_ToggleScreenMagnificationPreferenceFragmentForSetupWizard__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_accessibility_ToggleScreenMagnificationPreferenceFragmentForSetupWizard__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.accessibility.ToggleScreenMagnificationPreferenceFragment, com.android.settings.accessibility.ToggleFeaturePreferenceFragment, com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_accessibility_ToggleScreenMagnificationPreferenceFragmentForSetupWizard_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.accessibility.ToggleScreenMagnificationPreferenceFragment, com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_accessibility_ToggleScreenMagnificationPreferenceFragmentForSetupWizard_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public ToggleScreenMagnificationPreferenceFragmentForSetupWizard() {
    }

    @Override // com.android.settings.accessibility.ToggleFeaturePreferenceFragment
    protected void onProcessArguments(Bundle r1) {
        super.onProcessArguments(r1);
        this.mToggleSwitchWasInitiallyChecked = this.mToggleSwitch.isChecked();
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onStop() {
        this.mToggleSwitch.isChecked();
        super.onStop();
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_accessibility_ToggleScreenMagnificationPreferenceFragmentForSetupWizard_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ToggleScreenMagnificationPreferenceFragmentForSetupWizard r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_accessibility_ToggleScreenMagnificationPreferenceFragmentForSetupWizard__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_accessibility_ToggleScreenMagnificationPreferenceFragmentForSetupWizard_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ToggleScreenMagnificationPreferenceFragmentForSetupWizard r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_accessibility_ToggleScreenMagnificationPreferenceFragmentForSetupWizard_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_accessibility_ToggleScreenMagnificationPreferenceFragmentForSetupWizard_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ToggleScreenMagnificationPreferenceFragmentForSetupWizard r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_accessibility_ToggleScreenMagnificationPreferenceFragmentForSetupWizard__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
