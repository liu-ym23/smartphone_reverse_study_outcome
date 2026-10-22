package com.android.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.UIUtils;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class OtherAlertToneFragment extends BaseFragment {
    public static final String LOW_BATTERY_SOUNDS_ENABLED = "low_battery_sounds_enabled";
    public static final String SCREENSHOT_SOUNDS_ENABLED = "screenshot_sounds_enabled";
    public static final String UNLOCK_SOUNDS_ENABLED = "unlockscreen_sounds_enabled";
    private OCardListItem mDialPadTones;
    private OCardListItem mLowBatterySound;
    private OCardListItem mScreenLockingSounds;
    private OCardListItem mScreenshotSounds;
    private OCardListItem mTouchSounds;
    private OCardListItem mUnlockSounds;

    public void com_android_settings_OtherAlertToneFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_OtherAlertToneFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_OtherAlertToneFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_OtherAlertToneFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public OtherAlertToneFragment() {
    }

    static /* synthetic */ void access$000(OtherAlertToneFragment r0, boolean r1) {
        r0.setDialPadTonesEnabled(r1);
    }

    static /* synthetic */ void access$100(OtherAlertToneFragment r0, boolean r1) {
        r0.setTouchSoundsEnabled(r1);
    }

    static /* synthetic */ void access$200(OtherAlertToneFragment r0, boolean r1) {
        r0.setScreenLockingSoundsEnabled(r1);
    }

    static /* synthetic */ void access$300(OtherAlertToneFragment r0, boolean r1) {
        r0.setScreenshotSoundsEnabled(r1);
    }

    static /* synthetic */ void access$400(OtherAlertToneFragment r0, boolean r1) {
        r0.setFingerprintUnlockSoundsEnabled(r1);
    }

    static /* synthetic */ void access$500(OtherAlertToneFragment r0, boolean r1) {
        r0.setLowBatterySoundEnabled(r1);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.other_alert_tone_layout, r3, false);
        OCardListItem r5 = (OCardListItem) this.mRootView.findViewById(R.id.dial_pad_tones);
        this.mDialPadTones = r5;
        r5.getContentContainer().setClickable(false);
        OCardListItem r6 = (OCardListItem) this.mRootView.findViewById(R.id.touch_sounds);
        this.mTouchSounds = r6;
        r6.getContentContainer().setClickable(false);
        OCardListItem r7 = (OCardListItem) this.mRootView.findViewById(R.id.screen_locking_sounds);
        this.mScreenLockingSounds = r7;
        r7.getContentContainer().setClickable(false);
        OCardListItem r8 = (OCardListItem) this.mRootView.findViewById(R.id.screenshot_sounds);
        this.mScreenshotSounds = r8;
        r8.getContentContainer().setClickable(false);
        OCardListItem r9 = (OCardListItem) this.mRootView.findViewById(R.id.unlock_sounds);
        this.mUnlockSounds = r9;
        r9.getContentContainer().setClickable(false);
        OCardListItem r10 = (OCardListItem) this.mRootView.findViewById(R.id.low_battery_sound);
        this.mLowBatterySound = r10;
        r10.getContentContainer().setClickable(false);
        UIUtils.setUpFakeStatusBarOnApplyWindowInsets(this.mRootView.findViewById(R.id.fake_status_bar));
        UIUtils.setUpBottomPaddingOnApplyWindowInsets((ViewGroup) this.mRootView.findViewById(R.id.page_container));
        return this.mRootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r2) {
        super.onViewStateRestored(r2);
        ((OSwitch) this.mDialPadTones.getCustomEndView()).setChecked(isDialPadTonesEnabled());
        ((OSwitch) this.mDialPadTones.getCustomEndView()).setOnCheckedChangeListener(new AnonymousClass1(this));
        ((OSwitch) this.mTouchSounds.getCustomEndView()).setChecked(isTouchSoundsEnabled());
        ((OSwitch) this.mTouchSounds.getCustomEndView()).setOnCheckedChangeListener(new AnonymousClass2(this));
        ((OSwitch) this.mScreenLockingSounds.getCustomEndView()).setChecked(isScreenLockingSoundsEnabled());
        ((OSwitch) this.mScreenLockingSounds.getCustomEndView()).setOnCheckedChangeListener(new AnonymousClass3(this));
        ((OSwitch) this.mScreenshotSounds.getCustomEndView()).setChecked(isScreenshotSoundsEnabled());
        ((OSwitch) this.mScreenshotSounds.getCustomEndView()).setOnCheckedChangeListener(new AnonymousClass4(this));
        ((OSwitch) this.mUnlockSounds.getCustomEndView()).setChecked(isFingerprintUnlockSoundsEnabled());
        ((OSwitch) this.mUnlockSounds.getCustomEndView()).setOnCheckedChangeListener(new AnonymousClass5(this));
        ((OSwitch) this.mLowBatterySound.getCustomEndView()).setChecked(isLowBatterySoundEnabled());
        ((OSwitch) this.mLowBatterySound.getCustomEndView()).setOnCheckedChangeListener(new AnonymousClass6(this));
    }

    private boolean isDialPadTonesEnabled() {
        if (android.provider.Settings.System.getInt(this.mContext.getContentResolver(), "dtmf_tone", 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private void setDialPadTonesEnabled(boolean r2) {
        android.provider.Settings.System.putInt(this.mContext.getContentResolver(), "dtmf_tone", r2 ? 1 : 0);
    }

    private boolean isTouchSoundsEnabled() {
        if (android.provider.Settings.System.getInt(this.mContext.getContentResolver(), "sound_effects_enabled", 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private void setTouchSoundsEnabled(boolean r2) {
        android.provider.Settings.System.putInt(this.mContext.getContentResolver(), "sound_effects_enabled", r2 ? 1 : 0);
    }

    private boolean isScreenLockingSoundsEnabled() {
        if (android.provider.Settings.System.getInt(this.mContext.getContentResolver(), "lockscreen_sounds_enabled", 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private void setScreenLockingSoundsEnabled(boolean r2) {
        android.provider.Settings.System.putInt(this.mContext.getContentResolver(), "lockscreen_sounds_enabled", r2 ? 1 : 0);
    }

    private boolean isScreenshotSoundsEnabled() {
        if (android.provider.Settings.System.getInt(this.mContext.getContentResolver(), SCREENSHOT_SOUNDS_ENABLED, 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private void setScreenshotSoundsEnabled(boolean r2) {
        android.provider.Settings.System.putInt(this.mContext.getContentResolver(), SCREENSHOT_SOUNDS_ENABLED, r2 ? 1 : 0);
    }

    private boolean isFingerprintUnlockSoundsEnabled() {
        if (android.provider.Settings.System.getInt(this.mContext.getContentResolver(), UNLOCK_SOUNDS_ENABLED, 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private void setFingerprintUnlockSoundsEnabled(boolean r2) {
        android.provider.Settings.System.putInt(this.mContext.getContentResolver(), UNLOCK_SOUNDS_ENABLED, r2 ? 1 : 0);
    }

    private boolean isLowBatterySoundEnabled() {
        if (android.provider.Settings.System.getInt(this.mContext.getContentResolver(), LOW_BATTERY_SOUNDS_ENABLED, 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private void setLowBatterySoundEnabled(boolean r2) {
        android.provider.Settings.System.putInt(this.mContext.getContentResolver(), LOW_BATTERY_SOUNDS_ENABLED, r2 ? 1 : 0);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_OtherAlertToneFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(OtherAlertToneFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_OtherAlertToneFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_OtherAlertToneFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(OtherAlertToneFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_OtherAlertToneFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_OtherAlertToneFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(OtherAlertToneFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_OtherAlertToneFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
