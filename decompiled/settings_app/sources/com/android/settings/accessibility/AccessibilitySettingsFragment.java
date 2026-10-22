package com.android.settings.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.UserHandle;
import android.provider.Settings;
import android.speech.tts.TtsEngines;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.android.internal.content.PackageMonitor;
import com.android.settings.AccessibilitySettingsHelp;
import com.android.settings.BackCoverCalibration;
import com.android.settings.Constants;
import com.android.settings.FontScaleSettingsActivity;
import com.android.settings.HeadsetCalibrationFragment;
import com.android.settings.LawInfoActivity;
import com.android.settings.MultiSDKAdapterNew;
import com.android.settings.R;
import com.android.settings.SettingsFeature;
import com.android.settings.SettingsTracker;
import com.android.settings.SmartDenoiseSettings;
import com.android.settings.ToastUtils;
import com.android.settings.Utils;
import com.android.settings.accounts.obric.ObricIconUtils;
import com.android.settings.applications.utils.XTSUtils;
import com.android.settings.base.BaseFragment;
import com.android.settings.scheduledpower.ScheduledPowerOnAndOffActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.Enable16kUtils;
import com.android.settings.utils.RegisterUtils;
import com.android.settings.utils.StringClickBuilder;
import com.android.settingslib.RestrictedLockUtils;
import com.android.settingslib.accessibility.AccessibilityUtils;
import com.bytedance.apm.constant.PerfConsts;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.obric.oui.text.OTextView;
import com.obric.privacy.GrantUtil;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class AccessibilitySettingsFragment extends BaseFragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    static final ComponentName BIG_BANG_CN = null;
    private static final String DEFAULT_SCREENREADER_MARKET_LINK = "market://search?q=pname:com.google.android.marvin.talkback";
    private static final long DELAY_UPDATE_SERVICES_MILLIS = 1000;
    static final ComponentName DESKTOP_SCROLL_SCEENSHOT = null;
    private static final String EARTHQUAKE_WARNING_ACTION = "com.android.emergency.Earthquake";
    public static final String EARTHQUAKE_WARNING_PACKAGE_NAME = "com.android.emergency";
    static final char ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR = ':';
    static final String EXTRA_CHECKED = "checked";
    static final String EXTRA_COMPONENT_NAME = "component_name";
    static final String EXTRA_INFO = "info";
    static final String EXTRA_PREFERENCE_KEY = "preference_key";
    static final String EXTRA_SETTINGS_COMPONENT_NAME = "settings_component_name";
    static final String EXTRA_SETTINGS_TITLE = "settings_title";
    static final String EXTRA_SUMMARY = "summary";
    static final String EXTRA_TITLE = "title";
    static final ComponentName IDEA_PILLS_CN = null;
    private static final String KEY_INSTALL_ACCESSIBILITY_SERVICE_OFFERED_ONCE = "key_install_accessibility_service_offered_once";
    private static final String LOG_TAG = "AccessibilitySettingsFragment";
    public static final String POCKET_MODE = "pocket_mode_enable";
    static final ComponentName SCROLL_SCEENSHOT = null;
    private static final String SYSTEM_PROPERTY_MARKET_URL = "ro.screenreader.market";
    public static final String SYSTEM_UI_ACCESS_MENU = "com.android.systemui.accessibility.accessibilitymenu";
    static final ComponentName TALK_BACK_CN = null;
    static final ComponentName TALK_BACK_SELECT_SPEAK = null;
    static final ComponentName TALK_BACK_SWITCH = null;
    public static final String VOICE_ACCESS_SERVICE = "android.apps.accessibility.voiceaccess";
    static final ComponentName VOICE_ASSIST = null;
    public static final ComponentName sFillPasswordServiceComponentName = null;
    static final Set<ComponentName> sInstalledServices = null;
    static final List<ComponentName> sWhiteServices = null;
    private OCardListItem mAccessibilityExpertiseSettingsItem;
    private int mCurrentValue;
    private int mDetectedValue;
    String[] mDisplayNameArray;
    private OCardListItem mEarthquakeWarningItem;
    private OCardListItem mFontSize;
    private final Handler mHandler;
    private OCardListItem mItemCoverCaribration;
    private OCardListItem mItemHeadsetCaribration;
    private OCardListItem mItemSmartDenoise;
    private OCardListItem mLeftScreenItem;
    private TextView mNoServicesMessagePreference;
    private OCardListItem mPocketMode;
    private OSwitch mPocketModeSwitch;
    private OSwitch mPreventWrongTouchSwitch;
    private OCardListItem mPreventWrongTouchSwitcher;
    private OCardListItem mScheduledPowerOnAndOffItem;
    private View mSensorSwitcherView;
    private LinearLayout mServiceViewContainer;
    private LinearLayout mServicesCategory;
    private final SettingsContentObserver mSettingsContentObserver;
    private final PackageMonitor mSettingsPackageMonitor;
    private OCardListItem mTriggerSmartScreenMode;
    private OCardListItem mTtsSettings;
    private OSectionSupportiveText mUELicense;
    private OCardListItem mUESwitch;
    private OSwitch mUESwitchSwitch;
    private final Runnable mUpdateRunnable;
    int[] mValueArray;

    public void com_android_settings_accessibility_AccessibilitySettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_accessibility_AccessibilitySettingsFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_accessibility_AccessibilitySettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_accessibility_AccessibilitySettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public AccessibilitySettingsFragment() {
        final Handler r0 = new Handler();
        this.mHandler = r0;
        this.mUpdateRunnable = new AnonymousClass1(this);
        this.mSettingsPackageMonitor = new AnonymousClass2(this);
        this.mSettingsContentObserver = new AnonymousClass3(this, r0);
    }

    static /* synthetic */ void access$000(AccessibilitySettingsFragment r0) {
        r0.loadInstalledServices();
    }

    static /* synthetic */ void access$100(AccessibilitySettingsFragment r0) {
        r0.updateServicesPreferences();
    }

    static /* synthetic */ Runnable access$200(AccessibilitySettingsFragment r0) {
        return r0.mUpdateRunnable;
    }

    static /* synthetic */ Handler access$300(AccessibilitySettingsFragment r0) {
        return r0.mHandler;
    }

    static {
        sInstalledServices = new HashSet();
        TALK_BACK_CN = new ComponentName(Constants.PKG_TALK_BACK, Constants.TALK_BACK_SERVICE_NAME);
        ComponentName r0 = new ComponentName(Constants.PKG_BIG_BANG, Constants.TEXT_BOOM_SERVICE_NAME);
        BIG_BANG_CN = r0;
        ComponentName r1 = new ComponentName("com.bytedanceos.sara", Constants.VOICE_COMMAND_SERVICE_NAME);
        IDEA_PILLS_CN = r1;
        ComponentName r3 = new ComponentName("com.android.systemui", Constants.SCROLL_SERVICE_NAME);
        SCROLL_SCEENSHOT = r3;
        ComponentName r5 = new ComponentName(Constants.PKG_TALK_BACK, Constants.TB_SWITCH_SERVICE_NAME);
        TALK_BACK_SWITCH = r5;
        ComponentName r6 = new ComponentName(Constants.PKG_TALK_BACK, Constants.TB_SELECT_SPEECH_SERVICE_NAME);
        TALK_BACK_SELECT_SPEAK = r6;
        ComponentName r2 = new ComponentName("com.android.desktop.systemui", Constants.DESKTOP_SCROLL_SERVICE_NAME);
        DESKTOP_SCROLL_SCEENSHOT = r2;
        ComponentName r7 = new ComponentName("com.bytedanceos.sara", Constants.VOICE_ASSIST_SERVICE_NAME);
        VOICE_ASSIST = r7;
        ComponentName r4 = new ComponentName("com.bytedanceos.tpassword", "com.bytedanceos.tpassword.fill.PasswordAccessibilityService");
        sFillPasswordServiceComponentName = r4;
        sWhiteServices = Arrays.asList(new ComponentName[]{r4, r0, r1, r3, r5, r6, r2, r7});
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        int r0 = 0;
        this.mRootView = r4.inflate(R.layout.accessibility_settings_layout, r5, false);
        OCardListItem r7 = (OCardListItem) findViewByIdNullable(R.id.bytedance_desktop_left_screen);
        this.mLeftScreenItem = r7;
        r7.setOnContentClickListener(new AccessibilitySettingsFragment$$ExternalSyntheticLambda13(this));
        this.mTriggerSmartScreenMode = (OCardListItem) findViewByIdNullable(R.id.trigger_smart_screen_mode);
        if (SettingsFeature.isSupportSmartScreenProtection() == false) goto L5;
        this.mTriggerSmartScreenMode.setVisibility(0);
        this.mTriggerSmartScreenMode.setOnContentClickListener(new AccessibilitySettingsFragment$$ExternalSyntheticLambda14(this));
    L6:
        OCardListItem r8 = (OCardListItem) findViewByIdNullable(R.id.item_font_scale);
        this.mFontSize = r8;
        r8.setOnContentClickListener(new AccessibilitySettingsFragment$$ExternalSyntheticLambda15(this));
        this.mFontSize.setDefaultCustomEndView(3);
        this.mFontSize.showCustomEnd(true);
        OCardListItem r9 = (OCardListItem) findViewByIdNullable(R.id.headset_caribrition);
        this.mItemHeadsetCaribration = r9;
        r9.setOnContentClickListener(new AccessibilitySettingsFragment$$ExternalSyntheticLambda1(this));
        this.mItemSmartDenoise = (OCardListItem) findViewByIdNullable(R.id.smart_denoise);
        View r10 = findViewByIdNullable(R.id.shadow_below_smart_denoise);
        if (SettingsFeature.isSmartDenoiseSupport() == true) goto L9;
    L11:
        this.mItemSmartDenoise.setVisibility(8);
        r10.setVisibility(8);
    L12:
        this.mAccessibilityExpertiseSettingsItem = (OCardListItem) findViewByIdNullable(R.id.id_accessibility_expertise_settings);
        if (SettingsFeature.isAccessibilitySupport(this.mContext) == true) goto L15;
    L17:
        this.mAccessibilityExpertiseSettingsItem.setVisibility(8);
        findViewByIdNullable(R.id.shadow_below_accessibility).setVisibility(8);
    L18:
        this.mItemCoverCaribration = (OCardListItem) findViewByIdNullable(R.id.backcover_caribrition);
        if (Utils.isVisiableCoverCaribrationItem() == false) goto L21;
        this.mItemCoverCaribration.setVisibility(0);
        findViewByIdNullable(R.id.gap).setVisibility(0);
        this.mDisplayNameArray = getResources().getStringArray(R.array.back_cover_name);
        this.mValueArray = getResources().getIntArray(R.array.cover_value_list);
    L21:
        this.mItemCoverCaribration.setOnContentClickListener(new AccessibilitySettingsFragment$$ExternalSyntheticLambda4(this));
        this.mSensorSwitcherView = findViewByIdNullable(R.id.sensor_switcher_container);
        OCardListItem r11 = (OCardListItem) findViewByIdNullable(R.id.id_pocket_mode);
        this.mPocketMode = r11;
        r11.setDefaultCustomEndView(1);
        this.mPocketMode.showCustomEnd(true);
        this.mPocketModeSwitch = (OSwitch) this.mPocketMode.getCustomEndView();
        OCardListItem r12 = (OCardListItem) findViewByIdNullable(R.id.id_scheduled_power_on_and_off);
        this.mScheduledPowerOnAndOffItem = r12;
        r12.setOnContentClickListener(new AccessibilitySettingsFragment$$ExternalSyntheticLambda5(this));
        this.mEarthquakeWarningItem = (OCardListItem) findViewByIdNullable(R.id.id_earthquake_warning);
        if (Utils.isPackageInstalled(this.mContext, EARTHQUAKE_WARNING_PACKAGE_NAME) == false) goto L24;
        this.mEarthquakeWarningItem.setVisibility(0);
        this.mEarthquakeWarningItem.setOnContentClickListener(new AccessibilitySettingsFragment$$ExternalSyntheticLambda6(this));
    L25:
        this.mEarthquakeWarningItem.setVisibility(8);
        OCardListItem r13 = (OCardListItem) findViewByIdNullable(R.id.prevent_wrong_touch);
        this.mPreventWrongTouchSwitcher = r13;
        r13.setDefaultCustomEndView(1);
        this.mPreventWrongTouchSwitcher.showCustomEnd(true);
        this.mPreventWrongTouchSwitch = (OSwitch) this.mPreventWrongTouchSwitcher.getCustomEndView();
        if (SettingsFeature.isPalmRejectionSupport() == false) goto L28;
        this.mPreventWrongTouchSwitcher.setVisibility(0);
        findViewByIdNullable(R.id.prevent_wrong_touch_tips).setVisibility(0);
    L30:
        if (SettingsFeature.SENSOR_SWITHCER_SUPPORT == true) goto L32;
    L34:
        this.mSensorSwitcherView.setVisibility(8);
    L36:
        if (this.mIsExtDisplaying == false) goto L38;
        this.mFontSize.setVisibility(8);
        findViewByIdNullable(R.id.item_font_scale_gap_below).setVisibility(8);
    L38:
        this.mServiceViewContainer = (LinearLayout) findViewByIdNullable(R.id.accessibility_services);
        this.mServicesCategory = (LinearLayout) findViewByIdNullable(R.id.services_container);
        OCardListItem r14 = (OCardListItem) findViewByIdNullable(R.id.tts_settings);
        this.mTtsSettings = r14;
        if (showTtsSettings() == true) goto L42;
        r0 = 8;
    L42:
        r14.setVisibility(r0);
        this.mTtsSettings.setOnContentClickListener(new AnonymousClass4(this));
        return this.mRootView;
    L32:
        if (this.mIsExtDisplaying == true) goto L34;
        this.mSensorSwitcherView.setVisibility(0);
        goto L36
    L28:
        this.mPreventWrongTouchSwitcher.setVisibility(8);
        findViewByIdNullable(R.id.prevent_wrong_touch_tips).setVisibility(8);
        goto L30
    L24:
        this.mEarthquakeWarningItem.setVisibility(8);
        goto L25
    L15:
        if (this.mIsExtDisplaying == true) goto L17;
        this.mAccessibilityExpertiseSettingsItem.setVisibility(0);
        this.mAccessibilityExpertiseSettingsItem.setOnContentClickListener(new AccessibilitySettingsFragment$$ExternalSyntheticLambda3(this));
        findViewByIdNullable(R.id.shadow_below_accessibility).setVisibility(0);
        goto L18
    L9:
        if (this.mIsExtDisplaying == true) goto L11;
        this.mItemSmartDenoise.setVisibility(0);
        r10.setVisibility(0);
        this.mItemSmartDenoise.setOnContentClickListener(new AccessibilitySettingsFragment$$ExternalSyntheticLambda2(this));
        goto L12
    L5:
        this.mTriggerSmartScreenMode.setVisibility(8);
        findViewByIdNullable(R.id.shadow_below_trigger_smart_screen_mode).setVisibility(8);
        goto L6
    }

    /* JADX INFO: renamed from: lambda$onCreateView$0$com-android-settings-accessibility-AccessibilitySettingsFragment, reason: not valid java name */
    /* synthetic */ void m246xd0ea689d(View r1) {
        onClick(this.mLeftScreenItem);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$1$com-android-settings-accessibility-AccessibilitySettingsFragment, reason: not valid java name */
    /* synthetic */ void m247x3b19f0bc(View r1) {
        onClick(this.mTriggerSmartScreenMode);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$2$com-android-settings-accessibility-AccessibilitySettingsFragment, reason: not valid java name */
    /* synthetic */ void m248xa54978db(View r1) {
        onClick(this.mFontSize);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$3$com-android-settings-accessibility-AccessibilitySettingsFragment, reason: not valid java name */
    /* synthetic */ void m249xf7900fa(View r1) {
        onClick(this.mItemHeadsetCaribration);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$4$com-android-settings-accessibility-AccessibilitySettingsFragment, reason: not valid java name */
    /* synthetic */ void m250x79a88919(View r1) {
        onClick(this.mItemSmartDenoise);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$5$com-android-settings-accessibility-AccessibilitySettingsFragment, reason: not valid java name */
    /* synthetic */ void m251xe3d81138(View r1) {
        onClick(this.mAccessibilityExpertiseSettingsItem);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$6$com-android-settings-accessibility-AccessibilitySettingsFragment, reason: not valid java name */
    /* synthetic */ void m252x4e079957(View r1) {
        onClick(this.mItemCoverCaribration);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$7$com-android-settings-accessibility-AccessibilitySettingsFragment, reason: not valid java name */
    /* synthetic */ void m253xb8372176(View r1) {
        onClick(this.mScheduledPowerOnAndOffItem);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$8$com-android-settings-accessibility-AccessibilitySettingsFragment, reason: not valid java name */
    /* synthetic */ void m254x2266a995(View r1) {
        onClick(this.mEarthquakeWarningItem);
    }

    private void initUEView() {
        this.mUESwitch = (OCardListItem) findViewByIdNullable(R.id.ue_switch);
        this.mUELicense = (OSectionSupportiveText) findViewByIdNullable(R.id.item_ue_licence);
        if (isHideUEEntry() == false) goto L6;
        this.mUESwitch.setVisibility(8);
        this.mUELicense.setVisibility(8);
        return;
    L6:
        this.mUESwitch.setDefaultCustomEndView(1);
        this.mUESwitch.showCustomEnd(true);
        OSwitch r0 = (OSwitch) this.mUESwitch.getCustomEndView();
        this.mUESwitchSwitch = r0;
        r0.setOnCheckedChangeListener(this);
        TextView r1 = (TextView) this.mUELicense.findViewById(R.id.section_des);
        if (r1 == null) goto L10;
        r1.setText(getStringClickBuilder(r1, this._mActivity.getColor(R.color.highlight_text)).build());
        r1.setMovementMethod(LinkMovementMethod.getInstance());
        return;
    }

    private boolean isHideUEEntry() {
        return !AccessibilitySettingsHelp.INSTANCE.isShowUserExperienceEntry();
    }

    private StringClickBuilder getStringClickBuilder(TextView r3, int r4) {
        StringClickBuilder r0 = new StringClickBuilder(r3);
        r0.onClick(R.string.user_analytics_pr, r4, new AccessibilitySettingsFragment$$ExternalSyntheticLambda8(this));
        r0.onClick(R.string.user_analytics_u_its, r4, new AccessibilitySettingsFragment$$ExternalSyntheticLambda9(this));
        r0.onClick(R.string.user_analytics_s_its, r4, new AccessibilitySettingsFragment$$ExternalSyntheticLambda10(this));
        return r0;
    }

    /* JADX INFO: renamed from: lambda$getStringClickBuilder$9$com-android-settings-accessibility-AccessibilitySettingsFragment, reason: not valid java name */
    /* synthetic */ void m245x3af06bf4(View r2) {
        LawInfoActivity.loadUrlWithExplorer(this._mActivity, getString(R.string.user_analytics_pr_url));
    }

    /* JADX INFO: renamed from: lambda$getStringClickBuilder$10$com-android-settings-accessibility-AccessibilitySettingsFragment, reason: not valid java name */
    /* synthetic */ void m243x31de20a0(View r2) {
        LawInfoActivity.loadUrlWithExplorer(this._mActivity, getString(R.string.user_analytics_u_its_url));
    }

    /* JADX INFO: renamed from: lambda$getStringClickBuilder$11$com-android-settings-accessibility-AccessibilitySettingsFragment, reason: not valid java name */
    /* synthetic */ void m244x9c0da8bf(View r2) {
        LawInfoActivity.loadUrlWithExplorer(this._mActivity, getString(R.string.user_analytics_s_its_url));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        initUEView();
        updateViews();
        this.mPocketModeSwitch.setOnCheckedChangeListener(this);
        this.mPreventWrongTouchSwitch.setOnCheckedChangeListener(this);
    }

    public void updateViews() {
        this.mFontSize.setEndDetailText(Utils.getCurrentFontScaleStr(this.mContext));
        updateLeftScreenItem();
        loadInstalledServices();
        updateServicesPreferences();
        RegisterUtils.registerSafely(this.TAG + "_mSettingsPackageMonitor", new AccessibilitySettingsFragment$$ExternalSyntheticLambda0(this));
        RegisterUtils.registerSafely(this.TAG + "_mSettingsContentObserver", new AccessibilitySettingsFragment$$ExternalSyntheticLambda7(this));
        this.mPocketModeSwitch.setChecked(isPocketModeEnabled());
        if (SettingsFeature.isPalmRejectionSupport() == false) goto L5;
        this.mPreventWrongTouchSwitch.setChecked(isPreventWrongTouchModeEnabled());
    L5:
        OSwitch r0 = this.mUESwitchSwitch;
        if (r0 == null) goto L13;
        boolean r3 = true;
        if (Settings.Global.getInt(getContentResolver(), "join_ue_on", 1) == 1) goto L11;
        r3 = false;
    L11:
        r0.setChecked(r3);
    L13:
        if (Utils.isVisiableCoverCaribrationItem() == false) goto L16;
        this.mDetectedValue = Utils.getDetectedColor(this.mContext);
        this.mCurrentValue = Utils.getCurrentColor(this.mContext, this.mDetectedValue);
        updateCoverColor();
        return;
    }

    /* JADX INFO: renamed from: lambda$updateViews$12$com-android-settings-accessibility-AccessibilitySettingsFragment, reason: not valid java name */
    /* synthetic */ Unit m257xef88f4a9() {
        this.mSettingsPackageMonitor.register(this._mActivity, getMainLooper(), false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: lambda$updateViews$13$com-android-settings-accessibility-AccessibilitySettingsFragment, reason: not valid java name */
    /* synthetic */ Unit m258x59b87cc8() {
        this.mSettingsContentObserver.register(getContentResolver());
        return Unit.INSTANCE;
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mSettingsPackageMonitor.unregister();     // Catch: Exception -> L5
        this.mSettingsContentObserver.unregister(getContentResolver());     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        OLog.e(this.TAG, "onPause, error_msg: " + e);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r6) {
        if (this.mItemHeadsetCaribration != r6) goto L10;
        start(HeadsetCalibrationFragment.class);
        if (Utils.isHeadsetConnected(this.mContext) == false) goto L7;
        start(HeadsetCalibrationFragment.class);
    L8:
        SettingsTracker.onItemClick(260302);
        return;
    L7:
        ToastUtils.show(this._mActivity, R.string.headset_calibration_headset_disconnected);
        goto L8
    L10:
        if (this.mItemCoverCaribration != r6) goto L13;
        Intent r7 = new Intent(this._mActivity, BackCoverCalibration.class);
        r7.putExtra("back_text_id", R.string.advanced_item_assistant);
        r7.putExtra(PerfConsts.KEY_CURRENT_GALVANIC, this.mCurrentValue);
        r7.putExtra("detected", this.mDetectedValue);
        Utils.startActivity(this._mActivity, r7);
        return;
    L13:
        if (this.mFontSize != r6) goto L16;
        Intent r8 = new Intent(this._mActivity, FontScaleSettingsActivity.class);
        r8.putExtra("title", getString(R.string.font_size));
        r8.putExtra("back_text_id", R.string.advanced_item_assistant);
        Utils.startActivity(this._mActivity, r8);
        SettingsTracker.onItemClick(260301);
        return;
    L16:
        if (this.mUELicense != r6) goto L19;
        LawInfoActivity.loadUrlWithExplorer(this._mActivity, "https://account.nubia.com/res/html/user_behavior_statistics_privacy_policy.html");
        SettingsTracker.onItemClick(260304);
        return;
    L19:
        if (r6 != this.mTriggerSmartScreenMode) goto L22;
        start(SmartScreenFragment.class);
        SettingsTracker.onItemClick(260308);
        return;
    L22:
        if (r6 != this.mAccessibilityExpertiseSettingsItem) goto L25;
        start(AccessibilityExpertiseSettingsFragment.class);
        return;
    L25:
        if (r6 != this.mItemSmartDenoise) goto L28;
        start(SmartDenoiseSettings.class);
        return;
    L28:
        if (r6 != this.mLeftScreenItem) goto L35;
        Intent r9 = new Intent();
        if (Utils.isPackageInstalled(this.mContext, Constants.PKG_BYTEDANCE_MAGICFLOW) == false) goto L32;
        r9.setClassName(Constants.PKG_BYTEDANCE_MAGICFLOW, "com.bytedanceos.magicflow.view.MagicFlowActivity");
        r9.putExtra("extra_view_type", "MainSetting");
    L33:
        r9.putExtra("back_text", getString(R.string.advanced_item_assistant));
        r9.putExtra(Utils.EXTRA_FROM_SETTINGS, true);
        Utils.startActivity(this._mActivity, r9, 0, 0);
        return;
    L32:
        r9.setClassName("com.bytedanceos.launcher", "com.bytedanceos.magicflow.view.MagicFlowActivity");
        r9.putExtra("extra_view_type", "LeftScreen");
        goto L33
    L35:
        if (r6 != this.mScheduledPowerOnAndOffItem) goto L38;
        Utils.startActivity(this._mActivity, new Intent(this.mContext, ScheduledPowerOnAndOffActivity.class));
        return;
    L38:
        if (r6 != this.mEarthquakeWarningItem) goto L55;
        startActivity(new Intent(EARTHQUAKE_WARNING_ACTION));     // Catch: ActivityNotFoundException -> L41
        return;
    L41:
        e = move-exception;
        OLog.e(this.TAG, "start earthquake warning failed, error_msg: ", e);
        ToastUtils.show(this._mActivity, R.string.earthquake_warning_activity_not_found);
        return;
    }

    public static int getLongPressTimeoutIndex(Context r5) {
        String[] r1 = r5.getResources().getStringArray(R.array.long_press_timeout_selector_values);
        int r2 = 400;
        int r3 = Settings.Secure.getInt(r5.getContentResolver(), "long_press_timeout");     // Catch: Settings.SettingNotFoundException -> L5
    L8:
        if (r3 != 500) goto L10;
        Settings.Secure.putInt(r5.getContentResolver(), "long_press_timeout", 400);
    L11:
        int r0 = 0;
    L13:
        if (r0 >= r1.length) goto L23;
        if (Integer.parseInt(r1[r0]) == r2) goto L18;
        r0 = r0 + 1;
        goto L13
    L18:
        return r0;
    L23:
        return 0;
    L10:
        r2 = r3;
    L5:
        e = move-exception;
        e.printStackTrace();
        r3 = 400;
        goto L8
    }

    public static Drawable getA11yActivityIcon(Context r1, AccessibilityServiceInfo r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        ResolveInfo r3 = r2.getResolveInfo();
        if (r3.getIconResource() != 0) goto L8;
        ContextCompat.getDrawable(r1, R.drawable.ic_accessibility_generic);
    L10:
        return ObricIconUtils.getDrawable(r3.serviceInfo.packageName);
    L8:
        r3.loadIcon(r1.getPackageManager());
        goto L10
    }

    static RestrictedLockUtils.EnforcedAdmin getEnforcedAdmin(Activity r3, String r4, ResolveInfo r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        RestrictedLockUtils.EnforcedAdmin r0 = MultiSDKAdapterNew.checkIfAccessibilityServiceDisallowed(r3, r4, UserHandle.myUserId());
        if (r0 != null) goto L20;
        List r1 = ((DevicePolicyManager) r3.getSystemService("device_policy")).getPermittedAccessibilityServices(UserHandle.myUserId());
        if (r1 != null) goto L10;
        return r0;
    L10:
        if (r1.contains(r4) == false) goto L12;
        return r0;
    L12:
        if ((r5.serviceInfo.applicationInfo.flags & 129) == 0) goto L14;
        boolean r6 = true;
    L15:
        if (r6 == true) goto L23;
        RestrictedLockUtils.EnforcedAdmin r2 = MultiSDKAdapterNew.checkIfRestrictionEnforced(r3, "disallow_config_accessibility", UserHandle.myUserId());
        if (r2 == null) goto L19;
        return r2;
    L19:
        return RestrictedLockUtils.getProfileOrDeviceOwner(r3, UserHandle.of(UserHandle.myUserId()));
    L23:
        return r0;
    L14:
        r6 = false;
        goto L15
    L20:
        return r0;
    }

    private void updateServicesPreferences() {
        if (isAdded() == true) goto L5;
        return;
    L5:
        this.mServicesCategory.removeAllViews();
        List<AccessibilityServiceInfo> r1 = AccessibilityManager.getInstance(this.mContext).getInstalledAccessibilityServiceList();
        Set<ComponentName> r2 = AccessibilityUtils.getEnabledServicesFromSettings(this.mContext);
        int r5 = 0;
        if (Settings.Secure.getInt(getContentResolver(), "accessibility_enabled", 0) != 1) goto L8;
        boolean r3 = true;
    L9:
        int r6 = r1.size();
        OCardListItem r7 = null;
        int r9 = 0;
        OCardListItem r8 = null;
    L10:
        if (r9 >= r6) goto L66;
        AccessibilityServiceInfo r11 = r1.get(r9);
        if (r11 == null) goto L64;
        if (r11.getResolveInfo() == null) goto L64;
        if (r11.getResolveInfo().loadLabel(getPackageManager()) == null) goto L64;
        ResolveInfo r12 = r11.getResolveInfo();
        String r13 = r12.serviceInfo.packageName;
        if (r13.contains(VOICE_ACCESS_SERVICE) == false) goto L23;
        if (Enable16kUtils.isPageAgnosticModeOn(this.mContext) == true) goto L64;
    L23:
        if (r13.contains(SYSTEM_UI_ACCESS_MENU) == true) goto L64;
        String r14 = r11.getResolveInfo().loadLabel(getPackageManager()).toString();
        if (TextUtils.isEmpty(r14) == true) goto L64;
        ServiceInfo r15 = r11.getResolveInfo().serviceInfo;
        ComponentName r10 = new ComponentName(r15.packageName, r15.name);
        if (sWhiteServices.contains(r10) == true) goto L64;
        OCardListItem r4 = new OCardListItem(this._mActivity);
        r4.setDefaultTailIcon(r5);
        r4.showTailIcon(true);
        r4.setDefaultCustomEndView(3);
        OTextView r16 = (OTextView) r4.getCustomEndView();
        r4.setCardPosition(2);
        r4.setTitle(r14);
        r4.setAppIcon(getA11yActivityIcon(getContext(), r11));
        r4.showIcon(true);
        if (r3 == true) goto L34;
    L36:
        boolean r17 = false;
    L38:
        if (ToggleAccessibilityServiceFragment.ACCESSIBILITY_MEMORY_PACKAGE_NAME.equals(r10.getPackageName()) == false) goto L46;
        if (r17 == false) goto L41;
    L44:
        boolean r18 = true;
    L45:
        r17 = r18;
        goto L46
    L41:
        if (Settings.Secure.getInt(getContentResolver(), ToggleAccessibilityServiceFragment.ENABLED_ACCESSIBILITY_MEMORY_SERVICES, 0) == 1) goto L44;
        r18 = false;
    L46:
        if (r17 == false) goto L48;
        r16.setText(getString(R.string.accessibility_feature_state_on));
    L49:
        r4.showCustomEnd(true);
        final Bundle r19 = new Bundle();
        r19.putString("preference_key", r10.flattenToString());
        r19.putBoolean("checked", r17);
        r19.putString("title", r14);
        String r20 = r11.loadDescription(getPackageManager());
        if (TextUtils.isEmpty(r20) == false) goto L52;
        r20 = "";
    L52:
        r19.putString("summary", r20);
        String r21 = r11.getSettingsActivityName();
        if (TextUtils.isEmpty(r21) == true) goto L55;
        r19.putString("settings_title", getString(R.string.accessibility_menu_item_settings));
        r19.putString("settings_component_name", new ComponentName(r11.getResolveInfo().serviceInfo.packageName, r21).flattenToString());
    L55:
        r19.putParcelable("component_name", r10);
        r19.putParcelable("info", r11);
        final RestrictedLockUtils.EnforcedAdmin r22 = getEnforcedAdmin(this._mActivity, r13, r12);
        if (r22 == null) goto L58;
        r4.showSubTitle(true);
        r4.setSubTitle(getString(R.string.disabled_by_administrator_summary));
        r4.setOnContentClickListener(new AccessibilitySettingsFragment$$ExternalSyntheticLambda11(this, r22));
    L59:
        this.mServicesCategory.addView(r4);
        if (r7 != null) goto L62;
        r7 = r4;
    L62:
        r8 = r4;
        goto L64
    L58:
        r4.setOnContentClickListener(new AccessibilitySettingsFragment$$ExternalSyntheticLambda12(this, r19));
        goto L59
    L48:
        r16.setText(getString(R.string.accessibility_feature_state_off));
        goto L49
    L34:
        if (r2.contains(r10) == false) goto L36;
        r17 = true;
    L64:
        r9 = r9 + 1;
        r2 = r2;
        r5 = 0;
        goto L10
    L66:
        if (this.mServicesCategory.getChildCount() == 0) goto L68;
    L71:
        this.mServicesCategory.addView(Utils.inflateListTransparentHeader(this._mActivity));
        if (r1.size() <= 0) goto L74;
        this.mServiceViewContainer.setVisibility(0);
    L75:
        if (r7 == null) goto L77;
        r7.setCardPosition(1);
    L77:
        if (r8 == null) goto L79;
        r8.setCardPosition(3);
    L79:
        if (r7 == null) goto L86;
        if (r7 != r8) goto L87;
        r7.setCardPosition(0);
        return;
    L87:
        return;
    L86:
        return;
    L74:
        this.mServiceViewContainer.setVisibility(8);
        goto L75
    L68:
        if (this.mNoServicesMessagePreference != null) goto L70;
        TextView r23 = new TextView(this._mActivity);
        this.mNoServicesMessagePreference = r23;
        r23.setText(R.string.accessibility_no_services_installed);
        this.mNoServicesMessagePreference.setTextAppearance(this._mActivity, R.style.SettingItemTipsStyle);
        this.mNoServicesMessagePreference.setClickable(false);
        this.mNoServicesMessagePreference.setFocusable(false);
    L70:
        this.mServicesCategory.addView(this.mNoServicesMessagePreference);
        goto L71
    L8:
        r3 = false;
        goto L9
    }

    /* JADX INFO: renamed from: lambda$updateServicesPreferences$14$com-android-settings-accessibility-AccessibilitySettingsFragment, reason: not valid java name */
    /* synthetic */ void m255x62ac0eb3(RestrictedLockUtils.EnforcedAdmin r1, View r2) {
        RestrictedLockUtils.sendShowAdminSupportDetailsIntent(this._mActivity, r1);
    }

    /* JADX INFO: renamed from: lambda$updateServicesPreferences$15$com-android-settings-accessibility-AccessibilitySettingsFragment, reason: not valid java name */
    /* synthetic */ void m256xccdb96d2(Bundle r1, View r2) {
        start(new ToggleAccessibilityServiceFragment(), r1);
    }

    private void loadInstalledServices() {
        Set<ComponentName> r0 = sInstalledServices;
        r0.clear();
        List<AccessibilityServiceInfo> r6 = AccessibilityManager.getInstance(this.mContext).getInstalledAccessibilityServiceList();
        if (r6 != null) goto L5;
        return;
    L5:
        int r1 = r6.size();
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L13;
        ResolveInfo r3 = r6.get(r2).getResolveInfo();
        if (r3 == null) goto L12;
        if (r3.serviceInfo == null) goto L12;
        r0.add(new ComponentName(r3.serviceInfo.packageName, r3.serviceInfo.name));
    L12:
        r2 = r2 + 1;
        goto L6
    }

    private void updateCoverColor() {
        int r0 = 0;
    L3:
        int[] r1 = this.mValueArray;
        if (r0 >= r1.length) goto L10;
        if (this.mCurrentValue == r1[r0]) goto L7;
        r0 = r0 + 1;
        goto L3
    L7:
        this.mItemCoverCaribration.setSubTitle(this.mDisplayNameArray[r0]);
        return;
    }

    private boolean isGloveModeEnabled() {
        if (Settings.Global.getInt(getContentResolver(), "glove_mode_enable", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    private boolean isPocketModeEnabled() {
        if (Settings.System.getInt(getContentResolver(), POCKET_MODE, 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private boolean isPreventWrongTouchModeEnabled() {
        if (Settings.Global.getInt(getContentResolver(), "prevent_locked_screen_wrong_touch_enable", 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private void updateLeftScreenItem() {
        int r1 = 0;
        if (Utils.isBytedanceLauncher(this.mContext) == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        OCardListItem r2 = this.mLeftScreenItem;
        if (r0 == false) goto L11;
        int r4 = 0;
    L12:
        r2.setVisibility(r4);
        View r3 = findViewByIdNullable(R.id.bytedance_desktop_left_screen_gap);
        if (r0 == true) goto L16;
        r1 = 8;
    L16:
        r3.setVisibility(r1);
        OCardListItem r5 = this.mLeftScreenItem;
        boolean r6 = isLauncherLeftScreenEnabled();
        Context r7 = this.mContext;
        if (r6 == false) goto L19;
        int r8 = R.string.settings_state_on;
    L20:
        r5.setSubTitle(r7.getString(r8));
        return;
    L19:
        r8 = R.string.settings_state_off;
        goto L20
    L11:
        r4 = 8;
        goto L12
    L5:
        if (this.mIsExtDisplaying == true) goto L7;
        r0 = true;
        goto L8
    }

    private boolean isLauncherLeftScreenEnabled() {
        if (Settings.Global.getInt(getContentResolver(), "sm_launcher_left_screen_state", 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, boolean r3) {
        if (r2 != this.mUESwitchSwitch) goto L6;
        Settings.Global.putInt(getContentResolver(), "join_ue_on", r3 ? 1 : 0);
        SettingsTracker.onSwitcherClick(260305, r3);
        return;
    L6:
        if (r2 != this.mPreventWrongTouchSwitch) goto L9;
        Settings.Global.putInt(getContentResolver(), "prevent_locked_screen_wrong_touch_enable", r3 ? 1 : 0);
        return;
    L9:
        if (r2 != this.mPocketModeSwitch) goto L14;
        Settings.System.putInt(getContentResolver(), POCKET_MODE, r3 ? 1 : 0);
        return;
    }

    private boolean showTtsSettings() {
        if (XTSUtils.isInXtsMode() == true) goto L7;
        return false;
    L7:
        return !new TtsEngines(this.mContext).getEngines().isEmpty();
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_accessibility_AccessibilitySettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(AccessibilitySettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_accessibility_AccessibilitySettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_accessibility_AccessibilitySettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(AccessibilitySettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_accessibility_AccessibilitySettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_accessibility_AccessibilitySettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(AccessibilitySettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_accessibility_AccessibilitySettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
