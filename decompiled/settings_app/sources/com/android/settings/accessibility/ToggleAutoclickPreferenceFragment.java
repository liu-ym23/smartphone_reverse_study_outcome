package com.android.settings.accessibility;

import android.content.res.Resources;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Switch;
import androidx.preference.Preference;
import com.android.settings.R;
import com.android.settings.SeekBarPreference;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.NullSafe;
import com.android.settings.widget.SwitchBar;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class ToggleAutoclickPreferenceFragment extends ToggleFeaturePreferenceFragment implements SwitchBar.OnSwitchChangeListener, Preference.OnPreferenceChangeListener {
    private static final int AUTOCLICK_DELAY_STEP = 100;
    private static final int MAX_AUTOCLICK_DELAY = 1000;
    private static final int MIN_AUTOCLICK_DELAY = 200;
    private static final int[] mAutoclickPreferenceSummaries = null;
    private SeekBarPreference mDelay;

    private int seekBarProgressToDelay(int r1) {
        return (r1 * 100) + 200;
    }

    public void com_android_settings_accessibility_ToggleAutoclickPreferenceFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.accessibility.ToggleFeaturePreferenceFragment, com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_accessibility_ToggleAutoclickPreferenceFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_accessibility_ToggleAutoclickPreferenceFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public ToggleAutoclickPreferenceFragment() {
    }

    static {
        mAutoclickPreferenceSummaries = new int[]{R.plurals.accessibilty_autoclick_preference_subtitle_extremely_short_delay, R.plurals.accessibilty_autoclick_preference_subtitle_very_short_delay, R.plurals.accessibilty_autoclick_preference_subtitle_short_delay, R.plurals.accessibilty_autoclick_preference_subtitle_long_delay, R.plurals.accessibilty_autoclick_preference_subtitle_very_long_delay};
    }

    static CharSequence getAutoclickPreferenceSummary(Resources r4, int r5) {
        return r4.getQuantityString(mAutoclickPreferenceSummaries[getAutoclickPreferenceSummaryIndex(r5)], r5, new Object[]{Integer.valueOf(r5)});
    }

    private static int getAutoclickPreferenceSummaryIndex(int r3) {
        if (r3 > 200) goto L7;
        return 0;
    L7:
        if (r3 < 1000) goto L11;
        return mAutoclickPreferenceSummaries.length - 1;
    L11:
        return (r3 - 200) / (800 / (mAutoclickPreferenceSummaries.length - 1));
    }

    @Override // com.android.settings.accessibility.ToggleFeaturePreferenceFragment
    protected void onPreferenceToggled(String r2, boolean r3) {
        Settings.Secure.putInt(getContentResolver(), r2, r3 ? 1 : 0);
        this.mDelay.setEnabled(r3);
    }

    public void com_android_settings_accessibility_ToggleAutoclickPreferenceFragment__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        addPreferencesFromResource(R.xml.accessibility_autoclick_settings);
        int r4 = Settings.Secure.getInt(getContentResolver(), "accessibility_autoclick_delay", 600);
        SeekBarPreference r0 = (SeekBarPreference) NullSafe.nonNull(findPreference("autoclick_delay"));
        this.mDelay = r0;
        r0.setMax(delayToSeekBarProgress(1000));
        this.mDelay.setProgress(delayToSeekBarProgress(r4));
        this.mDelay.setOnPreferenceChangeListener(this);
    }

    @Override // com.android.settings.accessibility.ToggleFeaturePreferenceFragment
    protected void onInstallSwitchBarToggleSwitch() {
        super.onInstallSwitchBarToggleSwitch();
        boolean r2 = false;
        int r0 = Settings.Secure.getInt(getContentResolver(), "accessibility_autoclick_enabled", 0);
        SwitchBar r1 = this.mSwitchBar;
        if (r0 != 1) goto L5;
        boolean r4 = true;
    L6:
        r1.setCheckedInternal(r4);
        this.mSwitchBar.addOnSwitchChangeListener(this);
        SeekBarPreference r5 = this.mDelay;
        if (r0 != 1) goto L9;
        r2 = true;
    L9:
        r5.setEnabled(r2);
        return;
    L5:
        r4 = false;
        goto L6
    }

    @Override // com.android.settings.accessibility.ToggleFeaturePreferenceFragment
    protected void onRemoveSwitchBarToggleSwitch() {
        super.onRemoveSwitchBarToggleSwitch();
        this.mSwitchBar.removeOnSwitchChangeListener(this);
    }

    @Override // com.android.settings.widget.SwitchBar.OnSwitchChangeListener
    public void onSwitchChanged(Switch r1, boolean r2) {
        onPreferenceToggled("accessibility_autoclick_enabled", r2);
    }

    @Override // com.android.settings.accessibility.ToggleFeaturePreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        setTitle(getString(R.string.accessibility_autoclick_preference_title));
    }

    @Override // androidx.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference r2, Object r3) {
        if (r2 == this.mDelay) goto L5;
        return false;
    L5:
        if ((r3 instanceof Integer) == false) goto L10;
        Settings.Secure.putInt(getContentResolver(), "accessibility_autoclick_delay", seekBarProgressToDelay(((Integer) r3).intValue()));
        return true;
    L10:
        return false;
    }

    private int delayToSeekBarProgress(int r1) {
        return (r1 - 200) / 100;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_accessibility_ToggleAutoclickPreferenceFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ToggleAutoclickPreferenceFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_accessibility_ToggleAutoclickPreferenceFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_accessibility_ToggleAutoclickPreferenceFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ToggleAutoclickPreferenceFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_accessibility_ToggleAutoclickPreferenceFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_accessibility_ToggleAutoclickPreferenceFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ToggleAutoclickPreferenceFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_accessibility_ToggleAutoclickPreferenceFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
