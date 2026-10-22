package com.android.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public class SmartDenoiseSettings extends BaseFragment implements CompoundButton.OnCheckedChangeListener {
    private SettingItemSwitch mSwitchSmartDenoiseNormalApps;
    private SettingItemSwitch mSwitchSmartDenoisePhoneCall;

    public void com_android_settings_SmartDenoiseSettings__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_SmartDenoiseSettings__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_SmartDenoiseSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_SmartDenoiseSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public SmartDenoiseSettings() {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.fragment_smart_denoise_settings, r3, false);
        this.mSwitchSmartDenoisePhoneCall = (SettingItemSwitch) findViewByIdNullable(R.id.switch_smart_denoise_phone_call);
        this.mSwitchSmartDenoiseNormalApps = (SettingItemSwitch) findViewByIdNullable(R.id.switch_smart_denoise_normal_apps);
        if (SettingsFeature.isNormalAppsSmartDenoiseSupport() == false) goto L5;
        this.mSwitchSmartDenoiseNormalApps.setOnCheckedChangeListener(this);
    L7:
        return this.mRootView;
    L5:
        this.mSwitchSmartDenoiseNormalApps.setVisibility(8);
        findViewByIdNullable(R.id.smart_denoise_normal_apps_tips).setVisibility(8);
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
        this.mSwitchSmartDenoisePhoneCall.setOnCheckedChangeListener(this);
        this.mSwitchSmartDenoiseNormalApps.setOnCheckedChangeListener(this);
    }

    public void updateViews() {
        this.mSwitchSmartDenoisePhoneCall.setChecked(isPhoneCallSmartDenoiseEnabled());
        this.mSwitchSmartDenoiseNormalApps.setChecked(isNormalAppsSmartDenoiseEnabled());
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    private boolean isPhoneCallSmartDenoiseEnabled() {
        if (android.provider.Settings.System.getInt(getContentResolver(), "smart_denoise_phone_call", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    private boolean isNormalAppsSmartDenoiseEnabled() {
        if (android.provider.Settings.System.getInt(getContentResolver(), "smart_denoise_normal_apps", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, boolean r3) {
        if (r2 != this.mSwitchSmartDenoisePhoneCall.getSwitch()) goto L6;
        android.provider.Settings.System.putInt(getContentResolver(), "smart_denoise_phone_call", r3 ? 1 : 0);
        return;
    L6:
        if (r2 != this.mSwitchSmartDenoiseNormalApps.getSwitch()) goto L10;
        android.provider.Settings.System.putInt(getContentResolver(), "smart_denoise_normal_apps", r3 ? 1 : 0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_SmartDenoiseSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(SmartDenoiseSettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_SmartDenoiseSettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_SmartDenoiseSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(SmartDenoiseSettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_SmartDenoiseSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_SmartDenoiseSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(SmartDenoiseSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_SmartDenoiseSettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
