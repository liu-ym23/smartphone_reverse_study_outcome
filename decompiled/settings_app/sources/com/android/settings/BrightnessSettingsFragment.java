package com.android.settings;

import android.app.Activity;
import android.app.DynamicRefreshRateManager;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.ContentObserver;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import bytedanceos.api.PowerManagerSmt;
import com.android.internal.display.BrightnessSynchronizer;
import com.android.settings.applications.utils.Item;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.applications.utils.OPopoverHelper;
import com.android.settings.applications.utils.XTSUtils;
import com.android.settings.base.BaseFragment;
import com.android.settings.display.DisplayModeFragment;
import com.android.settings.display.ScreenResolutionFragment;
import com.android.settings.display.color.ScreenColorTemperatureActivity;
import com.android.settings.eyesprotection.EyesProtectionFragment;
import com.android.settings.fingerprint.FingerprintEnrollSidecar;
import com.android.settings.intelligent.GlobalAssistantFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.teaevent.TrackerEvent;
import com.android.settings.utils.DevicePolicyUtils;
import com.android.settings.utils.UIUtils;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.lisitem.OListItemSettings;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.popover.v2.OPopover;
import com.obric.oui.slider.OSlider;
import com.obric.privacy.GrantUtil;
import com.obric.settingcommon.DcDimmingEnabler;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class BrightnessSettingsFragment extends BaseFragment implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    public static final String DC_DIMMING = "dc_dimming";
    public static final float DC_REAL_WORK_BRIGHTNESS = 0.275f;
    private static Point HD_RESOLUTION = null;
    private static final boolean IS_DARWIN = false;
    private static final int LUX_THRESHOLD_LEVEL_1 = 8000;
    private static final int LUX_THRESHOLD_LEVEL_2 = 3600;
    private static final int LUX_THRESHOLD_LEVEL_3 = 500;
    private static final int SCREEN_BRIGHTNESS_DARWIN_THRESHOLD_LEVEL_1 = 1200;
    private static final int SCREEN_BRIGHTNESS_DARWIN_THRESHOLD_LEVEL_2 = 800;
    private static final int SCREEN_BRIGHTNESS_DARWIN_THRESHOLD_LEVEL_3 = 300;
    private static final int SCREEN_BRIGHTNESS_THRESHOLD_LEVEL_1 = 140;
    private static final int SCREEN_BRIGHTNESS_THRESHOLD_LEVEL_2 = 100;
    private static final int SCREEN_BRIGHTNESS_THRESHOLD_LEVEL_3 = 30;
    private static final int TYPE_RESOLUTION_HD = 1;
    private static final int TYPE_RESOLUTION_UHD = 0;
    private static Point UHD_RESOLUTION;
    private final ContentObserver mAccelerometerRotationObserver;
    private OCardListItem mAdaptiveSleep;
    private OCardListItem mAutoBrightness;
    private OCardListItem mAutoRotation;
    private boolean mAutomaticMode;
    private final ContentObserver mBrightnessModeObserver;
    private final ContentObserver mBrightnessObserver;
    private OCardListItem mDCDimming;
    private DisplayManager mDisplayManager;
    private OCardListItem mDisplayMode;
    private OCardListItem mDisplaySizeItem;
    private OCardListItem mDoubleTapToSleep;
    private OCardListItem mDozeMode;
    private OCardListItem mDozeModeClickWeekScreen;
    private OCardListItem mFontSizeItem;
    private Handler mHandler;
    private boolean mInTrack;
    private OCardListItem mItemAutoLockScreenTime;
    private OCardListItem mItemScreenColorTemperature;
    private OCardListItem mItemScreenRefreshRate;
    private OCardListItem mItemScreenResolution;
    private int mLastSetBrightness;
    private boolean mLightChange;
    private final ContentObserver mLightDoubleClickObserver;
    private OCardListItem mLightPickup;
    private final ContentObserver mLightPickupObserver;
    private Sensor mLightSensor;
    private final SensorEventListener mLightSensorListener;
    private final ContentObserver mLightSingleClickObserver;
    private int mLimitedMinBrightness;
    private OListItemSettings mLockScreenChargingAnimationItem;
    private ContentObserver mLowBatteryModeObserver;
    private final PowerManager.OnManualBrightnessRangeChangedListener mManualBrightnessRangeListener;
    private boolean mManualBrightnessRangeListenerRegistered;
    private final ContentObserver mNightDisplayObserver;
    private PowerManager mPm;
    private PowerManagerSmt mPowerManager;
    private int mPreLimitedMinBrightness;
    private OCardListItem mProtectEyes;
    private AutoRotationEnabler mRotationEnabler;
    private int mScreenBrightnessEncodedMaximum;
    private int mScreenBrightnessEncodedMinimum;
    private int mScreenBrightnessMaximum;
    private int mScreenBrightnessMinimum;
    private OPopover mScreenResolutionPopMenu;
    private OCardListItem mScreenSaverItem;
    private ScreenTimeoutController mScreenTimeoutController;
    private OSlider mSeekBar;
    private SensorManager mSensorManager;
    private OCardListItem mSingleClickWakeScreen;

    public void com_android_settings_BrightnessSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_BrightnessSettingsFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_BrightnessSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_BrightnessSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public BrightnessSettingsFragment() {
        this.mHandler = new Handler();
        this.mInTrack = false;
        this.mLastSetBrightness = 0;
        this.mPreLimitedMinBrightness = 0;
        this.mLightChange = false;
        this.mManualBrightnessRangeListener = new AnonymousClass1(this);
        this.mScreenResolutionPopMenu = null;
        final Handler r1 = this.mHandler;
        this.mAccelerometerRotationObserver = new AnonymousClass2(this, r1);
        this.mLightSensorListener = new AnonymousClass3(this);
        final Handler r2 = new Handler();
        this.mLowBatteryModeObserver = new AnonymousClass5(this, r2);
        final Handler r3 = this.mHandler;
        this.mBrightnessObserver = new AnonymousClass6(this, r3);
        final Handler r4 = this.mHandler;
        this.mBrightnessModeObserver = new AnonymousClass7(this, r4);
        final Handler r5 = this.mHandler;
        this.mNightDisplayObserver = new AnonymousClass8(this, r5);
        final Handler r6 = this.mHandler;
        this.mLightDoubleClickObserver = new AnonymousClass9(this, r6);
        final Handler r7 = this.mHandler;
        this.mLightSingleClickObserver = new AnonymousClass10(this, r7);
        final Handler r8 = this.mHandler;
        this.mLightPickupObserver = new AnonymousClass11(this, r8);
    }

    static /* synthetic */ int access$000(BrightnessSettingsFragment r0) {
        return r0.getBrightness();
    }

    static /* synthetic */ void access$100(BrightnessSettingsFragment r0, int r1, int r2, int r3, boolean r4) {
        r0.applyManualBrightnessRange(r1, r2, r3, r4);
    }

    static /* synthetic */ void access$1000(BrightnessSettingsFragment r0, int r1, boolean r2) {
        r0.setBrightness(r1, r2);
    }

    static /* synthetic */ boolean access$1102(BrightnessSettingsFragment r0, boolean r1) {
        r0.mInTrack = r1;
        return r1;
    }

    static /* synthetic */ DisplayManager access$1200(BrightnessSettingsFragment r0) {
        return r0.mDisplayManager;
    }

    static /* synthetic */ void access$1300(BrightnessSettingsFragment r0) {
        r0.setSeekBarMax();
    }

    static /* synthetic */ void access$1400(BrightnessSettingsFragment r0) {
        r0.onBrightnessChanged();
    }

    static /* synthetic */ void access$1500(BrightnessSettingsFragment r0) {
        r0.onBrightnessModeChanged();
    }

    static /* synthetic */ void access$1600(BrightnessSettingsFragment r0) {
        r0.onLightDoubleClickChanged();
    }

    static /* synthetic */ void access$1700(BrightnessSettingsFragment r0) {
        r0.onLightSingleClickChanged();
    }

    static /* synthetic */ void access$1800(BrightnessSettingsFragment r0) {
        r0.onLightPickupChanged();
    }

    static /* synthetic */ Point access$1900() {
        return UHD_RESOLUTION;
    }

    static /* synthetic */ AutoRotationEnabler access$200(BrightnessSettingsFragment r0) {
        return r0.mRotationEnabler;
    }

    static /* synthetic */ void access$2000(BrightnessSettingsFragment r0, boolean r1) {
        r0.setAutoResolutionEnabled(r1);
    }

    static /* synthetic */ OCardListItem access$2100(BrightnessSettingsFragment r0) {
        return r0.mItemScreenResolution;
    }

    static /* synthetic */ String access$2200(BrightnessSettingsFragment r0) {
        return r0.TAG;
    }

    static /* synthetic */ OPopover access$2300(BrightnessSettingsFragment r0) {
        return r0.mScreenResolutionPopMenu;
    }

    static /* synthetic */ OPopover access$2302(BrightnessSettingsFragment r0, OPopover r1) {
        r0.mScreenResolutionPopMenu = r1;
        return r1;
    }

    static /* synthetic */ boolean access$300(BrightnessSettingsFragment r0) {
        return r0.mAutomaticMode;
    }

    static /* synthetic */ boolean access$402(BrightnessSettingsFragment r0, boolean r1) {
        r0.mLightChange = r1;
        return r1;
    }

    static /* synthetic */ int access$500(BrightnessSettingsFragment r0) {
        return r0.mLimitedMinBrightness;
    }

    static /* synthetic */ int access$502(BrightnessSettingsFragment r0, int r1) {
        r0.mLimitedMinBrightness = r1;
        return r1;
    }

    static /* synthetic */ boolean access$600() {
        return IS_DARWIN;
    }

    static /* synthetic */ int access$700(BrightnessSettingsFragment r0) {
        return r0.mScreenBrightnessMinimum;
    }

    static /* synthetic */ int access$800(BrightnessSettingsFragment r0) {
        return r0.mPreLimitedMinBrightness;
    }

    static /* synthetic */ int access$802(BrightnessSettingsFragment r0, int r1) {
        r0.mPreLimitedMinBrightness = r1;
        return r1;
    }

    static /* synthetic */ int access$902(BrightnessSettingsFragment r0, int r1) {
        r0.mLastSetBrightness = r1;
        return r1;
    }

    static {
        IS_DARWIN = SettingsFeature.isDarwin();
        HD_RESOLUTION = new Point(1080, 2400);
        UHD_RESOLUTION = new Point(1260, 2800);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        this.mRootView = r4.inflate(R.layout.brightness_setting, r5, false);
        this.mTitleResId = Integer.valueOf(R.string.brightness_header_title);
        this.mPowerManager = PowerManagerSmt.getInstance();
        this.mPm = (PowerManager) getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);
        if (getBrightnessMode() != 1) goto L5;
        boolean r7 = true;
    L6:
        this.mAutomaticMode = r7;
        OCardListItem r8 = (OCardListItem) findViewByIdNullable(R.id.item_display_mode);
        this.mDisplayMode = r8;
        r8.setOnContentClickListener(this);
        OCardListItem r9 = (OCardListItem) findViewByIdNullable(R.id.switch_auto_rotation);
        this.mAutoRotation = r9;
        r9.getContentContainer().setClickable(false);
        AutoRotationEnabler r10 = new AutoRotationEnabler(this.mContext, (OSwitch) this.mAutoRotation.getCustomEndView(), this.mAccelerometerRotationObserver);
        this.mRotationEnabler = r10;
        r10.registerContentObserver();
        OCardListItem r11 = (OCardListItem) findViewByIdNullable(R.id.switch_auto_brightness);
        this.mAutoBrightness = r11;
        r11.getContentContainer().setClickable(false);
        OSlider r12 = (OSlider) findViewByIdNullable(R.id.brightness_seekbar);
        this.mSeekBar = r12;
        r12.showRightIcon();
        setSeekBarMax();
        this.mSeekBar.setProgress(clampBrightnessToSliderRange(getBrightness()), true);
        this.mSeekBar.setOnSeekBarChangeListenerExt(new AnonymousClass4(this));
        OCardListItem r13 = (OCardListItem) findViewByIdNullable(R.id.item_auto_lock_screen_time);
        this.mItemAutoLockScreenTime = r13;
        r13.setOnContentClickListener(this);
        this.mScreenTimeoutController = new ScreenTimeoutController(this.mContext, this.mItemAutoLockScreenTime, OCardListItemUtils.setCustomEndTipTextView(this.mItemAutoLockScreenTime, ""), 0);
        OListItemSettings r14 = (OListItemSettings) findViewByIdNullable(R.id.item_lock_screen_charging_animation);
        this.mLockScreenChargingAnimationItem = r14;
        r14.setOnClickListener(this);
        OCardListItem r15 = (OCardListItem) findViewByIdNullable(R.id.item_screen_color_temperature);
        this.mItemScreenColorTemperature = r15;
        r15.setOnContentClickListener(this);
        OCardListItem r16 = (OCardListItem) findViewByIdNullable(R.id.switch_adaptive_sleep);
        this.mAdaptiveSleep = r16;
        r16.getContentContainer().setClickable(false);
        OCardListItem r17 = (OCardListItem) findViewByIdNullable(R.id.item_font_scale);
        this.mFontSizeItem = r17;
        r17.setOnContentClickListener(this);
        OCardListItem r18 = (OCardListItem) findViewByIdNullable(R.id.item_display_size);
        this.mDisplaySizeItem = r18;
        r18.setOnContentClickListener(this);
        OCardListItem r19 = (OCardListItem) findViewByIdNullable(R.id.switch_doze_mode_wake_screen);
        this.mDozeModeClickWeekScreen = r19;
        r19.getContentContainer().setClickable(false);
        OCardListItem r20 = (OCardListItem) findViewByIdNullable(R.id.single_click_wake_screen);
        this.mSingleClickWakeScreen = r20;
        r20.getContentContainer().setClickable(false);
        OCardListItem r21 = (OCardListItem) findViewByIdNullable(R.id.double_tap_to_sleep);
        this.mDoubleTapToSleep = r21;
        r21.getContentContainer().setClickable(false);
        OCardListItem r22 = (OCardListItem) findViewByIdNullable(R.id.switch_light_pick_up);
        this.mLightPickup = r22;
        r22.getContentContainer().setClickable(false);
        OCardListItem r23 = (OCardListItem) findViewByIdNullable(R.id.doze_mode);
        this.mDozeMode = r23;
        r23.setOnContentClickListener(this);
        OCardListItemUtils.setCustomEndTipTextView(this.mDozeMode, DozeModeUtils.getAODDisplayPolicySummary(this.mContext)).setMaxWidth(Utils.dp2Pixels(this._mActivity, 109.2f));
        OCardListItem r24 = (OCardListItem) findViewByIdNullable(R.id.item_protect_eyes);
        this.mProtectEyes = r24;
        r24.setOnContentClickListener(this);
        OCardListItem r25 = this.mProtectEyes;
        if (isEyesProtectionEnable() == false) goto L9;
        int r26 = R.string.settings_state_on;
    L10:
        OCardListItemUtils.setCustomEndTipTextView(r25, getString(r26));
        OCardListItem r27 = (OCardListItem) findViewByIdNullable(R.id.item_screen_refresh_rate);
        this.mItemScreenRefreshRate = r27;
        r27.setOnContentClickListener(this);
        this.mItemScreenRefreshRate.setVisibility(0);
        OCardListItem r28 = (OCardListItem) findViewByIdNullable(R.id.item_screen_resolution);
        this.mItemScreenResolution = r28;
        r28.setOnContentClickListener(this);
        OCardListItem r29 = this.mItemScreenResolution;
        if (SettingsFeature.isSupportScreenResolution() == false) goto L13;
        int r30 = 0;
    L14:
        r29.setVisibility(r30);
        OCardListItem r31 = (OCardListItem) findViewByIdNullable(R.id.item_screen_saver);
        this.mScreenSaverItem = r31;
        r31.setOnContentClickListener(this);
        updateScreenSaverItem();
        if (SettingsFeature.isSupportEyesProtection() == true) goto L18;
        this.mProtectEyes.setVisibility(8);
    L18:
        if (SettingsFeature.isSupportLimitedMinBrightness() == false) goto L20;
        SensorManager r32 = (SensorManager) this.mContext.getSystemService("sensor");
        this.mSensorManager = r32;
        this.mLightSensor = r32.getDefaultSensor(5);
    L20:
        OCardListItem r33 = (OCardListItem) findViewByIdNullable(R.id.dc_dimming);
        this.mDCDimming = r33;
        r33.setVisibility(0);
        this.mDCDimming.getContentContainer().setClickable(false);
        this.mDisplayManager = (DisplayManager) this.mContext.getSystemService(DisplayManager.class);
        UIUtils.setUpBottomPaddingOnApplyWindowInsets((ViewGroup) findViewByIdNullable(R.id.page_container));
        registerContentObserver();
        this.mScreenTimeoutController.updateTimeoutItem();
        return this.mRootView;
    L13:
        r30 = 8;
        goto L14
    L9:
        r26 = R.string.settings_state_off;
        goto L10
    L5:
        r7 = false;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
        ((OSwitch) this.mAutoRotation.getCustomEndView()).setOnCheckedChangeListener(this);
        ((OSwitch) this.mAutoBrightness.getCustomEndView()).setOnCheckedChangeListener(this);
        ((OSwitch) this.mAdaptiveSleep.getCustomEndView()).setOnCheckedChangeListener(this);
        ((OSwitch) this.mDozeModeClickWeekScreen.getCustomEndView()).setOnCheckedChangeListener(this);
        ((OSwitch) this.mDCDimming.getCustomEndView()).setOnCheckedChangeListener(this);
        ((OSwitch) this.mSingleClickWakeScreen.getCustomEndView()).setOnCheckedChangeListener(this);
        ((OSwitch) this.mDoubleTapToSleep.getCustomEndView()).setOnCheckedChangeListener(this);
        ((OSwitch) this.mLightPickup.getCustomEndView()).setOnCheckedChangeListener(this);
    }

    private int dip2px(float r1) {
        return (int) ((r1 * this.mContext.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        unregisterManualBrightnessRangeListener();
        this.mScreenTimeoutController.onPause();
        if (SettingsFeature.isSupportLimitedMinBrightness() == false) goto L6;
        this.mSensorManager.unregisterListener(this.mLightSensorListener);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        unregisterManualBrightnessRangeListener();
        this.mRotationEnabler.unregisterContentObserver();
        unregisterContentObserver();
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    private void updateViews() {
        this.mRotationEnabler.updateRotationSwitchState();
        registerManualBrightnessRangeListener();
        refreshManualBrightnessRange();
        onBrightnessChanged();
        onBrightnessModeChanged();
        OCardListItemUtils.setCustomEndTipTextView(this.mDozeMode, DozeModeUtils.getAODDisplayPolicySummary(this.mContext));
        ((OSwitch) this.mAdaptiveSleep.getCustomEndView()).setChecked(isAdaptiveSleepEnable());
        updateProtectEyesUI();
        updateScreenSaverItem();
        OCardListItem r0 = this.mItemScreenResolution;
        if (r0 == null) goto L5;
        OCardListItemUtils.setCustomEndTipTextView(r0, ScreenResolutionFragment.Companion.getCurrentResolutionString(this.mContext.getContentResolver()));
    L5:
        int r1 = DynamicRefreshRateManager.getSettingConfigId();
        if (r1 != 0) goto L8;
        String r2 = getString(R.string.auto_mode);
    L15:
        if (TextUtils.isEmpty(r2) == true) goto L17;
        OCardListItemUtils.setCustomEndTipTextView(this.mItemScreenRefreshRate, r2);
    L17:
        ((OSwitch) this.mDCDimming.getCustomEndView()).setChecked(isDCDimmingEnable(this._mActivity));
        ((OSwitch) this.mDozeModeClickWeekScreen.getCustomEndView()).setChecked(isDozeModeClickWakeSrceenEnable());
        ((OSwitch) this.mSingleClickWakeScreen.getCustomEndView()).setChecked(isClickWakeScreenEnable());
        ((OSwitch) this.mDoubleTapToSleep.getCustomEndView()).setChecked(isDoubleTapToSleepEnable());
        this.mScreenTimeoutController.updateTimeoutItem();
        this.mScreenTimeoutController.onResume();
        onLightPickupChanged();
        onLightDoubleClickChanged();
        onLightSingleClickChanged();
        OCardListItemUtils.setCustomEndTipTextView(this.mFontSizeItem, Utils.getCurrentFontScaleStr(this.mContext));
        OCardListItemUtils.setCustomEndTipTextView(this.mDisplaySizeItem, Utils.getCurrentDisplayDensityStr(this.mContext));
        if (SettingsFeature.isSupportLimitedMinBrightness() == false) goto L21;
        this.mSensorManager.registerListener(this.mLightSensorListener, this.mLightSensor, 0);
    L21:
        if (DevicePolicyUtils.hasUserRestriction(this.mContext, "no_config_brightness") == false) goto L23;
        this.mSeekBar.setEnabled(false);
        findViewByIdNullable(R.id.brightness_container).setClickable(true);
        findViewByIdNullable(R.id.brightness_container).setOnClickListener(new BrightnessSettingsFragment$$ExternalSyntheticLambda0(this));
        return;
    L23:
        this.mSeekBar.setEnabled(true);
        findViewByIdNullable(R.id.brightness_container).setClickable(false);
        return;
    L8:
        if (r1 != 1) goto L11;
        r2 = getString(R.string.standard_mode);
        goto L15
    L11:
        if (r1 != 2) goto L13;
        r2 = getString(R.string.high_mode);
        goto L15
    L13:
        r2 = "";
        goto L15
    }

    /* JADX INFO: renamed from: lambda$updateViews$0$com-android-settings-BrightnessSettingsFragment, reason: not valid java name */
    /* synthetic */ void m105x7be7b714(View r1) {
        DevicePolicyUtils.trySendShowAdminSupportDetailsIntent(this.mContext, "no_config_brightness");
    }

    public void registerContentObserver() {
        ContentResolver r0 = getContentResolver();
        r0.registerContentObserver(android.provider.Settings.Global.getUriFor("low_power"), true, this.mLowBatteryModeObserver);
        r0.registerContentObserver(android.provider.Settings.System.getUriFor("screen_brightness_multi_bit"), true, this.mBrightnessObserver);
        r0.registerContentObserver(android.provider.Settings.System.getUriFor("screen_brightness_mode"), true, this.mBrightnessModeObserver);
        r0.registerContentObserver(android.provider.Settings.Secure.getUriFor("night_display_activated"), true, this.mNightDisplayObserver);
        r0.registerContentObserver(android.provider.Settings.Global.getUriFor(settings.Settings.Global.PICKUP_ENABLE), true, this.mLightPickupObserver);
        r0.registerContentObserver(android.provider.Settings.Global.getUriFor(GlobalAssistantFragment.DOUBLECLICK_ENABLE_ASSIST_ON), true, this.mLightDoubleClickObserver);
        r0.registerContentObserver(android.provider.Settings.Global.getUriFor("click_enable_screen_on"), true, this.mLightSingleClickObserver);
    }

    public void unregisterContentObserver() {
        ContentResolver r0 = getContentResolver();
        r0.unregisterContentObserver(this.mLowBatteryModeObserver);
        r0.unregisterContentObserver(this.mBrightnessObserver);
        r0.unregisterContentObserver(this.mBrightnessModeObserver);
        r0.unregisterContentObserver(this.mNightDisplayObserver);
        r0.unregisterContentObserver(this.mLightPickupObserver);
        r0.unregisterContentObserver(this.mLightDoubleClickObserver);
        r0.unregisterContentObserver(this.mLightSingleClickObserver);
    }

    private boolean isNeedShowAutolockTips() {
        boolean r0 = Utils.isUseStrictLockScreen(this.mContext);
        if (android.provider.Settings.Global.getInt(getContentResolver(), "quick_unlock_when_screen_off", 0) != 1) goto L5;
        boolean r3 = true;
    L6:
        if (r0 == false) goto L9;
        if (r3 == false) goto L9;
        return false;
    L9:
        return true;
    L5:
        r3 = false;
        goto L6
    }

    private void onLightPickupChanged() {
        boolean r2 = false;
        if (android.provider.Settings.Global.getInt(getContentResolver(), settings.Settings.Global.PICKUP_ENABLE, 0) != 1) goto L5;
        r2 = true;
    L5:
        ((OSwitch) this.mLightPickup.getCustomEndView()).setChecked(r2);
    }

    private boolean isDozeModeEnable() {
        if (android.provider.Settings.Secure.getInt(getContentResolver(), "doze_always_on", 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private boolean isDozeModeClickWakeSrceenEnable() {
        if (android.provider.Settings.Global.getInt(getContentResolver(), GlobalAssistantFragment.DOUBLECLICK_ENABLE_ASSIST_ON, 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    private boolean isSingleClickWakeScreenSrEnable() {
        if (android.provider.Settings.Global.getInt(getContentResolver(), "click_enable_screen_on", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    private void setSingleClickWakeScreen(boolean r2) {
        android.provider.Settings.Global.putInt(getContentResolver(), "click_enable_screen_on", r2 ? 1 : 0);
    }

    private boolean isClickWakeScreenEnable() {
        if (android.provider.Settings.Global.getInt(getContentResolver(), "click_enable_screen_on", 0) == 1) goto L5;
        return false;
    L5:
        if (android.provider.Settings.Global.getInt(getContentResolver(), GlobalAssistantFragment.DOUBLECLICK_ENABLE_ASSIST_ON, 0) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private void setClickWakeScreen(boolean r3) {
        android.provider.Settings.Global.putInt(getContentResolver(), "click_enable_screen_on", r3 ? 1 : 0);
        android.provider.Settings.Global.putInt(getContentResolver(), GlobalAssistantFragment.DOUBLECLICK_ENABLE_ASSIST_ON, r3 ? 1 : 0);
    }

    private boolean isDoubleTapToSleepEnable() {
        if (android.provider.Settings.Secure.getInt(getContentResolver(), "double_tap_to_sleep", 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private boolean isAdaptiveSleepEnable() {
        if (android.provider.Settings.Secure.getInt(getContentResolver(), "adaptive_sleep", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    private void onLightDoubleClickChanged() {
        boolean r2 = false;
        if (android.provider.Settings.Global.getInt(getContentResolver(), GlobalAssistantFragment.DOUBLECLICK_ENABLE_ASSIST_ON, 0) != 1) goto L5;
        r2 = true;
    L5:
        ((OSwitch) this.mDozeModeClickWeekScreen.getCustomEndView()).setChecked(r2);
    }

    private void onLightSingleClickChanged() {
        boolean r0 = isClickWakeScreenEnable();
        ((OSwitch) this.mSingleClickWakeScreen.getCustomEndView()).setChecked(r0);
    }

    private void setSeekBarMax() {
        refreshManualBrightnessRange();
    }

    private void onBrightnessChanged() {
        if (this.mInTrack == true) goto L8;
        int r0 = clampBrightnessToSliderRange(getBrightness());
        int r1 = getSeekBarRealProgress();
        OLog.d(this.TAG, "onBrightnessChanged:" + r0 + ", seekBarProgress:" + r1);
        if (r0 == r1) goto L9;
        this.mSeekBar.setProgress(r0, false);
        return;
    L9:
        return;
    }

    private int getSeekBarRealProgress() {
        return (int) (this.mSeekBar.getMinValue() + ((this.mSeekBar.getProgress() / 100.0f) * (this.mSeekBar.getMaxValue() - this.mSeekBar.getMinValue())));
    }

    private void onBrightnessModeChanged() {
        boolean r1 = true;
        if (getBrightnessMode() == 1) goto L6;
        r1 = false;
    L6:
        this.mAutomaticMode = r1;
        ((OSwitch) this.mAutoBrightness.getCustomEndView()).setChecked(this.mAutomaticMode);
    }

    private int getBrightness() {
        return AdaptUtils.getBrightness(this.mContext);
    }

    private int getBrightnessMode() {
        return getBrightnessMode(0);
    }

    private int getBrightnessMode(int r2) {
        return android.provider.Settings.System.getInt(getContentResolver(), "screen_brightness_mode");
    L7:
        return r2;
    }

    private int getProgressByCurBrightness() {
        int r0 = getBrightness();
        int r1 = this.mScreenBrightnessMinimum;
        if (r0 >= r1) goto L5;
        r0 = r1;
    L5:
        int r2 = this.mScreenBrightnessMaximum;
        if (r0 <= r2) goto L9;
        r0 = r2;
    L9:
        if (SettingsFeature.isSupportLimitedMinBrightness() == false) goto L18;
        if (this.mAutomaticMode == false) goto L18;
        if (this.mLightChange == false) goto L18;
        int r3 = this.mLimitedMinBrightness;
        if (r0 >= r3) goto L18;
        return r3 - this.mScreenBrightnessMinimum;
    L18:
        return r0 - this.mScreenBrightnessMinimum;
    }

    private int getBrightnessByProgress(int r1) {
        return this.mScreenBrightnessMinimum + r1;
    }

    private void setMode(int r2) {
        if (r2 == 1) goto L5;
        if (r2 == 0) goto L5;
        return;
    L5:
        android.provider.Settings.System.putInt(getContentResolver(), "screen_brightness_mode", r2);
    }

    private void setBrightness(int r4, boolean r5) {
        if (r5 == false) goto L10;
        AdaptUtils.setBrightness(this.mContext, r4, this.mDisplayManager, this.mScreenBrightnessEncodedMaximum, this.mScreenBrightnessEncodedMinimum);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        OLog.e(this.TAG, "Failed to set brightness due to exception: " + e);
        return;
    }

    public float getMultiBitBrightnessIntToFloatForNormal() {
        return BrightnessSynchronizer.multiBitBrightnessIntToFloatForNormal(this.mContext, this.mLastSetBrightness, this.mScreenBrightnessEncodedMinimum, this.mScreenBrightnessEncodedMaximum);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r3, boolean r4) {
        if (r3 != ((OSwitch) this.mAutoRotation.getCustomEndView())) goto L6;
        this.mRotationEnabler.setAutoRotation(r4);
        SettingsTracker.onSwitcherClick(1101, r4);
        return;
    L6:
        if (r3 != ((OSwitch) this.mAutoBrightness.getCustomEndView())) goto L13;
        if (DevicePolicyUtils.trySendShowAdminSupportDetailsIntent(this.mContext, "no_config_brightness") == false) goto L11;
        r3.setOnCheckedChangeListener(null);
        r3.setChecked(!r4);
        r3.setOnCheckedChangeListener(this);
        return;
    L11:
        setMode(r4 ? 1 : 0);
        SettingsTracker.onSwitcherClick(1102, r4);
        return;
    L13:
        if (r3 != ((OSwitch) this.mLightPickup.getCustomEndView())) goto L16;
        android.provider.Settings.Global.putInt(getContentResolver(), settings.Settings.Global.PICKUP_ENABLE, r4 ? 1 : 0);
        return;
    L16:
        if (r3 != ((OSwitch) this.mDozeModeClickWeekScreen.getCustomEndView())) goto L19;
        android.provider.Settings.Global.putInt(getContentResolver(), GlobalAssistantFragment.DOUBLECLICK_ENABLE_ASSIST_ON, r4 ? 1 : 0);
        return;
    L19:
        if (r3 != ((OSwitch) this.mSingleClickWakeScreen.getCustomEndView())) goto L22;
        setClickWakeScreen(r4);
        return;
    L22:
        if (r3 != ((OSwitch) this.mAdaptiveSleep.getCustomEndView())) goto L25;
        android.provider.Settings.Secure.putInt(getContentResolver(), "adaptive_sleep", r4 ? 1 : 0);
        TrackerEvent.switchEvent("adaptive_sleep", r4);
        return;
    L25:
        if (r3 != ((OSwitch) this.mDoubleTapToSleep.getCustomEndView())) goto L28;
        android.provider.Settings.Secure.putInt(getContentResolver(), "double_tap_to_sleep", r4 ? 1 : 0);
        return;
    L28:
        if (r3 != ((OSwitch) this.mDCDimming.getCustomEndView())) goto L38;
        showDCDimmingTips(this._mActivity, r4, r3);
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r3) {
        if (r3 != this.mDisplayMode.getContentContainer()) goto L6;
        start(DisplayModeFragment.class);
        return;
    L6:
        if (r3 != this.mItemAutoLockScreenTime.getContentContainer()) goto L16;
        if (DevicePolicyUtils.trySendShowAdminSupportDetailsIntent(this.mContext, "no_config_screen_timeout") == false) goto L11;
        return;
    L11:
        if (this.mScreenTimeoutController.lockTimeoutLessThanAll == false) goto L14;
        DevicePolicyUtils.showMaximumTimeToLock();
        return;
    L14:
        start(ScreenOffTimeoutFragment.class);
        SettingsTracker.onItemClick(FingerprintEnrollSidecar.EVENT_FINGER_UP);
        return;
    L16:
        if (r3 != this.mLockScreenChargingAnimationItem) goto L19;
        start(ChargingAnimationFragment.class);
        return;
    L19:
        if (r3 != this.mFontSizeItem.getContentContainer()) goto L25;
        Intent r4 = new Intent(getActivity(), FontScaleSettingsActivity.class);
        r4.putExtra("title", getString(R.string.font_size));
        if (this.mTitleResId == null) goto L23;
        r4.putExtra("back_text_id", this.mTitleResId);
    L23:
        Utils.startActivity(this._mActivity, r4);
        SettingsTracker.onItemClick(FingerprintEnrollSidecar.EVENT_FINGER_AREA_ENROLLED_ALREADY);
        return;
    L25:
        if (r3 != this.mDisplaySizeItem.getContentContainer()) goto L28;
        start(DisplaySizeSettingsFragment.class);
        SettingsTracker.onItemClick(1107);
        return;
    L28:
        if (r3 != this.mProtectEyes.getContentContainer()) goto L31;
        start(EyesProtectionFragment.class);
        SettingsTracker.onItemClick(FingerprintEnrollSidecar.EVENT_FINGER_ENROLLED_ALREADY);
        return;
    L31:
        if (r3 != this.mItemScreenRefreshRate.getContentContainer()) goto L34;
        start(ScreenRefreshRateFragment.class);
        return;
    L34:
        if (r3 != this.mItemScreenColorTemperature.getContentContainer()) goto L37;
        Utils.startActivity(this._mActivity, new Intent(this.mContext, ScreenColorTemperatureActivity.class));
        return;
    L37:
        if (r3 != this.mItemScreenResolution.getContentContainer()) goto L39;
        showScreenResolutionPopMenu();
        return;
    L39:
        OCardListItem r0 = this.mScreenSaverItem;
        if (r0 == null) goto L45;
        if (r3 != r0.getContentContainer()) goto L45;
        start(DreamSettings.class);
        return;
    L45:
        if (r3 != this.mDozeMode.getContentContainer()) goto L58;
        Utils.startActivity(this._mActivity, new Intent(this.mContext, DozeModeActivity.class));
        return;
    }

    private boolean isAutoResolutionEnabled() {
        if (android.provider.Settings.Global.getInt(this.mContext.getContentResolver(), "resolution_auto", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    private void setAutoResolutionEnabled(boolean r2) {
        android.provider.Settings.Global.putInt(this.mContext.getContentResolver(), "resolution_auto", r2 ? 1 : 0);
    }

    private int getCurrentResolution() {
        Rect r1 = ((WindowManager) SettingsApplication.getContext().getSystemService("window")).getCurrentWindowMetrics().getBounds();     // Catch: Exception -> L5
        int r2 = r1.width() * r1.height();
    L8:
        if (r2 <= (HD_RESOLUTION.x * HD_RESOLUTION.y)) goto L10;
        return 0;
    L10:
        return 1;
    L5:
        e = move-exception;
        OLog.d(this.TAG, "getCurrentResolution, error_msg: " + e);
        r2 = 0;
        goto L8
    }

    private void showScreenResolutionPopMenu() {
        ArrayList r0 = new ArrayList();
        final int r1 = getCurrentResolution();
        boolean r2 = isAutoResolutionEnabled();
        r0.add(new Item(getString(R.string.resolution_UHD), !r2, UHD_RESOLUTION.y + "×" + UHD_RESOLUTION.x + getString(R.string.UHD_clearer)));
        r0.add(new Item(getString(R.string.resolution_auto), r2, getString(R.string.auto_resolution_tips)));
        this.mScreenResolutionPopMenu = OPopoverHelper.showPopoverList(this._mActivity, this.mItemScreenResolution, r0, new AnonymousClass12(this, r1), true);
    }

    private void registerManualBrightnessRangeListener() {
        PowerManager r0 = this.mPm;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mManualBrightnessRangeListenerRegistered == true) goto L10;
        r0.addManualBrightnessRangeListener(this.mContext.getMainExecutor(), this.mManualBrightnessRangeListener);
        this.mManualBrightnessRangeListenerRegistered = true;
        return;
    }

    private void unregisterManualBrightnessRangeListener() {
        PowerManager r0 = this.mPm;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mManualBrightnessRangeListenerRegistered == false) goto L10;
        r0.removeManualBrightnessRangeListener(this.mManualBrightnessRangeListener);
        this.mManualBrightnessRangeListenerRegistered = false;
        return;
    }

    private void refreshManualBrightnessRange() {
        this.mScreenBrightnessEncodedMinimum = this.mPm.getMultiBitMinimumScreenBrightnessSetting();
        this.mScreenBrightnessEncodedMaximum = this.mPm.getMultiBitMaximumScreenBrightnessSetting();
        applyManualBrightnessRange(this.mPm.getManualBrightnessMinMultiBit(), this.mPm.getManualBrightnessMaxMultiBit(), getBrightness(), true);
    }

    private void applyManualBrightnessRange(int r2, int r3, int r4, boolean r5) {
        this.mScreenBrightnessMinimum = r2;
        this.mScreenBrightnessMaximum = r3;
        if (this.mLightChange == false) goto L9;
        int r0 = this.mLimitedMinBrightness;
        if (r0 < r2) goto L9;
        if (r0 <= r3) goto L10;
        this.mLimitedMinBrightness = r3;
    L10:
        OSlider r6 = this.mSeekBar;
        if (r6 == null) goto L15;
        r6.setMinValue(r2);
        this.mSeekBar.setMaxValue(this.mScreenBrightnessMaximum);
        if (this.mInTrack == true) goto L15;
        this.mSeekBar.setProgress(clampBrightnessToSliderRange(r4), false);
    L15:
        if (r5 == true) goto L17;
        return;
    L17:
        if (this.mInTrack == true) goto L21;
        onBrightnessChanged();
        return;
    L21:
        return;
    L9:
        this.mLimitedMinBrightness = r2;
        goto L10
    }

    private int clampBrightnessToSliderRange(int r2) {
        return Math.max(this.mScreenBrightnessMinimum, Math.min(this.mScreenBrightnessMaximum, r2));
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        SettingsTracker.trackerDisplaySettings(this.mContext);
        super.onDestroy();
    }

    public boolean isSetSeekBarMinProgress(SeekBar r2) {
        if (this.mAutomaticMode == true) goto L5;
    L9:
        return false;
    L5:
        if (this.mLightChange == false) goto L9;
        if (r2.getProgress() >= getMinProgress()) goto L9;
        return true;
    }

    public int getMinProgress() {
        return this.mLimitedMinBrightness - this.mScreenBrightnessMinimum;
    }

    private boolean isEyesProtectionEnable() {
        if (android.provider.Settings.Secure.getInt(getContentResolver(), "night_display_activated", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    public void updateProtectEyesUI() {
        OCardListItem r0 = this.mProtectEyes;
        if (isEyesProtectionEnable() == false) goto L5;
        int r1 = R.string.settings_state_on;
    L6:
        OCardListItemUtils.setCustomEndTipTextView(r0, getString(r1));
        return;
    L5:
        r1 = R.string.settings_state_off;
        goto L6
    }

    private void updateScreenSaverItem() {
        if (this.mScreenSaverItem != null) goto L6;
        return;
    L6:
        if (XTSUtils.isInXtsMode() == false) goto L8;
        this.mScreenSaverItem.setVisibility(0);
        OCardListItemUtils.setCustomEndTipTextView(this.mScreenSaverItem, DreamSettings.getSummaryTextWithDreamName(this.mContext).toString());
        return;
    L8:
        this.mScreenSaverItem.setVisibility(8);
    }

    private static boolean isDCDimmingEnable(Activity r2) {
        if (android.provider.Settings.System.getInt(r2.getContentResolver(), DC_DIMMING, 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    public static void showDCDimmingTips(final Activity r1, final boolean r2, final CompoundButton r3) {
        if (r2 != isDCDimmingEnable(r1)) goto L5;
        return;
    L5:
        DcDimmingEnabler.showDCDimmingTips(r1, r2, new BrightnessSettingsFragment$$ExternalSyntheticLambda1(r1, r2, r3)).show();
    }

    static /* synthetic */ void lambda$showDCDimmingTips$1(Activity r1, boolean r2, CompoundButton r3, DialogInterface r4, int r5) {
        if (r5 != (-1)) goto L5;
        android.provider.Settings.System.putInt(r1.getContentResolver(), DC_DIMMING, r2 ? 1 : 0);
        r4.dismiss();
        return;
    L5:
        r3.setChecked(!r2);
        r4.dismiss();
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_BrightnessSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(BrightnessSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_BrightnessSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_BrightnessSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(BrightnessSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_BrightnessSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_BrightnessSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(BrightnessSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_BrightnessSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
