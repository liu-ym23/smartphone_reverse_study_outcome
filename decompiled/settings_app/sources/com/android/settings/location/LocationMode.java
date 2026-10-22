package com.android.settings.location;

import android.os.Bundle;
import androidx.preference.PreferenceScreen;
import com.android.settings.R;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.NullSafe;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class LocationMode extends LocationSettingsBase implements RadioButtonPreference.OnClickListener {
    private static final String KEY_BATTERY_SAVING = "battery_saving";
    private static final String KEY_HIGH_ACCURACY = "high_accuracy";
    private static final String KEY_SENSORS_ONLY = "sensors_only";
    private RadioButtonPreference mBatterySaving;
    private RadioButtonPreference mHighAccuracy;
    private RadioButtonPreference mSensorsOnly;

    public void com_android_settings_location_LocationMode__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment
    public int getHelpResource() {
        return R.string.help_url_location_access;
    }

    @Override // com.android.settings.location.LocationSettingsBase, com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_location_LocationMode_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.location.LocationSettingsBase, com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_location_LocationMode_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public LocationMode() {
    }

    public void com_android_settings_location_LocationMode__onResume$___twin___() {
        super.onResume();
        createPreferenceHierarchy();
    }

    @Override // com.android.settings.location.LocationSettingsBase, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    private PreferenceScreen createPreferenceHierarchy() {
        PreferenceScreen r0 = getPreferenceScreen();
        if (r0 == null) goto L5;
        r0.removeAll();
    L5:
        addPreferencesFromResource(R.xml.location_mode);
        PreferenceScreen r1 = getPreferenceScreen();
        this.mHighAccuracy = (RadioButtonPreference) NullSafe.nonNull(r1.findPreference(KEY_HIGH_ACCURACY));
        this.mBatterySaving = (RadioButtonPreference) NullSafe.nonNull(r1.findPreference(KEY_BATTERY_SAVING));
        this.mSensorsOnly = (RadioButtonPreference) NullSafe.nonNull(r1.findPreference(KEY_SENSORS_ONLY));
        this.mHighAccuracy.setOnClickListener(this);
        this.mBatterySaving.setOnClickListener(this);
        this.mSensorsOnly.setOnClickListener(this);
        refreshLocationMode();
        return r1;
    }

    private void updateRadioButtons(RadioButtonPreference r5) {
        if (r5 != null) goto L5;
        this.mHighAccuracy.setChecked(false);
        this.mBatterySaving.setChecked(false);
        this.mSensorsOnly.setChecked(false);
        return;
    L5:
        RadioButtonPreference r1 = this.mHighAccuracy;
        if (r5 != r1) goto L9;
        r1.setChecked(true);
        this.mBatterySaving.setChecked(false);
        this.mSensorsOnly.setChecked(false);
        return;
    L9:
        if (r5 != this.mBatterySaving) goto L12;
        r1.setChecked(false);
        this.mBatterySaving.setChecked(true);
        this.mSensorsOnly.setChecked(false);
        return;
    L12:
        if (r5 != this.mSensorsOnly) goto L18;
        r1.setChecked(false);
        this.mBatterySaving.setChecked(false);
        this.mSensorsOnly.setChecked(true);
        return;
    }

    @Override // com.android.settings.location.RadioButtonPreference.OnClickListener
    public void onRadioButtonClicked(RadioButtonPreference r2) {
        if (r2 != this.mHighAccuracy) goto L6;
        int r3 = 3;
    L12:
        setLocationMode(r3);
        return;
    L6:
        if (r2 != this.mBatterySaving) goto L9;
        r3 = 2;
        goto L12
    L9:
        if (r2 != this.mSensorsOnly) goto L11;
        r3 = 1;
        goto L12
    L11:
        r3 = 0;
        goto L12
    }

    @Override // com.android.settings.location.LocationSettingsBase
    public void onModeChanged(int r3, boolean r4) {
        boolean r0 = true;
        if (r3 == 0) goto L13;
        if (r3 != 1) goto L6;
        updateRadioButtons(this.mSensorsOnly);
    L14:
        if (r3 == 0) goto L17;
        if (r4 == true) goto L17;
    L18:
        this.mHighAccuracy.setEnabled(r0);
        this.mBatterySaving.setEnabled(r0);
        this.mSensorsOnly.setEnabled(r0);
        return;
    L17:
        r0 = false;
        goto L18
    L6:
        if (r3 != 2) goto L8;
        updateRadioButtons(this.mBatterySaving);
        goto L14
    L8:
        if (r3 != 3) goto L14;
        updateRadioButtons(this.mHighAccuracy);
        goto L14
    L13:
        updateRadioButtons(null);
        goto L14
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_location_LocationMode_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(LocationMode r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_location_LocationMode__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_location_LocationMode_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(LocationMode r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_location_LocationMode_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_location_LocationMode_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(LocationMode r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_location_LocationMode__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
