package com.android.settings.sidedial;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import bytedanceos.util.SettingsUtil;
import com.android.settings.Constants;
import com.android.settings.PreferenceMgr;
import com.android.settings.R;
import com.android.settings.SettingsApplication;
import com.android.settings.Utils;
import com.android.settings.base.BaseFragment;
import com.android.settings.bluetooth.DeviceRenameDialogFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.SettingsProviderUtils;
import com.obric.olog.OLog;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public class SideDialCustomFragment extends BaseFragment implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    private static int sLaunchType;
    private SettingItemSwitch mCustomModeAlwaysOnScreen;
    private SettingItemSwitch mCustomModeAutoBrightness;
    private SettingItemSwitch mCustomModeFeedbackVibration;
    private SettingItemSwitch mCustomModeGlobalVibration;
    private SettingItemSwitch mCustomModeMute;
    private SettingItemSwitch mCustomModeProtectEyes;
    private SettingItemSwitch mCustomModeReadMode;
    private SettingItemSwitch mCustomModeScreenRotation;
    private SettingItemSwitch mCustomModeTelephonyVibrate;
    private DeviceRenameDialogFragment mRenameFragment;
    private HashMap<String, String> mSwitches;

    public void com_android_settings_sidedial_SideDialCustomFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_sidedial_SideDialCustomFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_sidedial_SideDialCustomFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public SideDialCustomFragment() {
        super(R.layout.side_dial_custom_setting_layout);
        this.mRenameFragment = null;
    }

    public void com_android_settings_sidedial_SideDialCustomFragment__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        Bundle r4 = getArguments();
        if (r4 == null) goto L6;
        sLaunchType = r4.getInt("launch_mode", -1);
        this.mTitleResId = Integer.valueOf(r4.getInt(SideDialOptionsFragment.TITLE_RES, R.string.side_dial_title));
        return;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r3, Bundle r4) {
        super.onViewCreated(r3, r4);
        String r5 = getCustomModeTitleName();
        OFloatingTitleBar r6 = this.mTitleView;
        if (r6 == null) goto L5;
        r6.setCenterTitle(r5);
        r6.addEndAction(R.drawable.standard_icon_edit_selector, -1, null).setOnClickListener(new SideDialCustomFragment$$ExternalSyntheticLambda1(this));
    L5:
        this.mCustomModeScreenRotation = (SettingItemSwitch) findViewByIdNullable(R.id.custom_mode_screen_rotation);
        this.mCustomModeAutoBrightness = (SettingItemSwitch) findViewByIdNullable(R.id.custom_mode_auto_brightness);
        this.mCustomModeProtectEyes = (SettingItemSwitch) findViewByIdNullable(R.id.custom_mode_protect_eyes);
        this.mCustomModeReadMode = (SettingItemSwitch) findViewByIdNullable(R.id.custom_mode_read_mode);
        this.mCustomModeAlwaysOnScreen = (SettingItemSwitch) findViewByIdNullable(R.id.custom_mode_always_on_screen);
        this.mCustomModeMute = (SettingItemSwitch) findViewByIdNullable(R.id.custom_mode_mute);
        this.mCustomModeTelephonyVibrate = (SettingItemSwitch) findViewByIdNullable(R.id.custom_mode_telephony_vibrate);
        this.mCustomModeFeedbackVibration = (SettingItemSwitch) findViewByIdNullable(R.id.custom_mode_feedback_vibration);
        this.mCustomModeGlobalVibration = (SettingItemSwitch) findViewByIdNullable(R.id.custom_mode_global_vibrate);
    }

    /* JADX INFO: renamed from: lambda$onViewCreated$0$com-android-settings-sidedial-SideDialCustomFragment, reason: not valid java name */
    /* synthetic */ void m596x160fde7f(View r1) {
        createRenameProfileDialog(getCustomModeTitleName());
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
        this.mCustomModeScreenRotation.setOnCheckedChangeListener(this);
        this.mCustomModeAutoBrightness.setOnCheckedChangeListener(this);
        this.mCustomModeProtectEyes.setOnCheckedChangeListener(this);
        this.mCustomModeReadMode.setOnCheckedChangeListener(this);
        this.mCustomModeAlwaysOnScreen.setOnCheckedChangeListener(this);
        this.mCustomModeMute.setOnCheckedChangeListener(this);
        this.mCustomModeTelephonyVibrate.setOnCheckedChangeListener(this);
        this.mCustomModeGlobalVibration.setOnCheckedChangeListener(this);
    }

    public void updateViews() {
        HashMap<String, String> r0 = (HashMap) Utils.fromJson(getModeSwitch(sLaunchType), SideDialHelper.TYPE_TOKEN);
        this.mSwitches = r0;
        if (r0 != null) goto L5;
        return;
    L5:
        this.mCustomModeScreenRotation.setChecked(getState(r0.get(Constants.SIDE_DIAL_CUSTOM_MODE_SCREEN_ROTATION)));
        this.mCustomModeAutoBrightness.setChecked(getState(this.mSwitches.get(Constants.SIDE_DIAL_CUSTOM_MODE_AUTO_BRIGHTNESS)));
        this.mCustomModeProtectEyes.setChecked(getState(this.mSwitches.get(Constants.SIDE_DIAL_CUSTOM_MODE_PROTECT_EYES)));
        this.mCustomModeReadMode.setChecked(getState(this.mSwitches.get(Constants.SIDE_DIAL_CUSTOM_MODE_READ_MODE)));
        this.mCustomModeAlwaysOnScreen.setChecked(getState(this.mSwitches.get(Constants.SIDE_DIAL_CUSTOM_MODE_ALWAYS_ON_SCREEN)));
        this.mCustomModeMute.setChecked(getState(this.mSwitches.get(Constants.SIDE_DIAL_CUSTOM_MODE_MUTE)));
        this.mCustomModeTelephonyVibrate.setChecked(getState(this.mSwitches.get(Constants.SIDE_DIAL_CUSTOM_MODE_TELEPHONY_VIBRATE)));
        this.mCustomModeGlobalVibration.setChecked(getState(this.mSwitches.get(Constants.SIDE_DIAL_CUSTOM_MODE_GLOBAL_VIBRATE)));
        updateFeedbackVibration();
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r4, boolean r5) {
        if (this.mSwitches != null) goto L5;
        return;
    L5:
        String r1 = "1";
        if (r4 != this.mCustomModeScreenRotation.getSwitch()) goto L13;
        HashMap<String, String> r6 = this.mSwitches;
        if (r5 == true) goto L11;
        r1 = "0";
    L11:
        r6.put(Constants.SIDE_DIAL_CUSTOM_MODE_SCREEN_ROTATION, r1);
    L69:
        if (sLaunchType != 5) goto L72;
        SideDialHelper.setSideDialCustomPageModify(this.mContext);
        SettingsProviderUtils.setSideDialCustomModeSwitch(this.mContext, Utils.toJson(this.mSwitches));
        return;
    L72:
        return;
    L13:
        if (r4 != this.mCustomModeAutoBrightness.getSwitch()) goto L20;
        HashMap<String, String> r7 = this.mSwitches;
        if (r5 == true) goto L18;
        r1 = "0";
    L18:
        r7.put(Constants.SIDE_DIAL_CUSTOM_MODE_AUTO_BRIGHTNESS, r1);
        goto L69
    L20:
        if (r4 != this.mCustomModeProtectEyes.getSwitch()) goto L27;
        HashMap<String, String> r8 = this.mSwitches;
        if (r5 == true) goto L25;
        r1 = "0";
    L25:
        r8.put(Constants.SIDE_DIAL_CUSTOM_MODE_PROTECT_EYES, r1);
        goto L69
    L27:
        if (r4 != this.mCustomModeReadMode.getSwitch()) goto L34;
        HashMap<String, String> r9 = this.mSwitches;
        if (r5 == true) goto L32;
        r1 = "0";
    L32:
        r9.put(Constants.SIDE_DIAL_CUSTOM_MODE_READ_MODE, r1);
        goto L69
    L34:
        if (r4 != this.mCustomModeAlwaysOnScreen.getSwitch()) goto L41;
        HashMap<String, String> r10 = this.mSwitches;
        if (r5 == true) goto L39;
        r1 = "0";
    L39:
        r10.put(Constants.SIDE_DIAL_CUSTOM_MODE_ALWAYS_ON_SCREEN, r1);
        goto L69
    L41:
        if (r4 != this.mCustomModeMute.getSwitch()) goto L48;
        HashMap<String, String> r11 = this.mSwitches;
        if (r5 == true) goto L46;
        r1 = "0";
    L46:
        r11.put(Constants.SIDE_DIAL_CUSTOM_MODE_MUTE, r1);
        goto L69
    L48:
        if (r4 != this.mCustomModeTelephonyVibrate.getSwitch()) goto L55;
        HashMap<String, String> r12 = this.mSwitches;
        if (r5 == true) goto L53;
        r1 = "0";
    L53:
        r12.put(Constants.SIDE_DIAL_CUSTOM_MODE_TELEPHONY_VIBRATE, r1);
        goto L69
    L55:
        if (r4 != this.mCustomModeFeedbackVibration.getSwitch()) goto L62;
        HashMap<String, String> r13 = this.mSwitches;
        if (r5 == true) goto L60;
        r1 = "0";
    L60:
        r13.put(Constants.SIDE_DIAL_CUSTOM_MODE_FEEDBACK_VIBRATION, r1);
        goto L69
    L62:
        if (r4 != this.mCustomModeGlobalVibration.getSwitch()) goto L69;
        HashMap<String, String> r14 = this.mSwitches;
        if (r5 == true) goto L67;
        r1 = "0";
    L67:
        r14.put(Constants.SIDE_DIAL_CUSTOM_MODE_GLOBAL_VIBRATE, r1);
        goto L69
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (r2.getId() != R.id.car_mode_navigation) goto L6;
        start(new SideDialNavigationFragment());
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        DeviceRenameDialogFragment r0 = this.mRenameFragment;
        if (r0 == null) goto L6;
        r0.dismissAllowingStateLoss();
        return;
    }

    private String getModeSwitch(int r2) {
        if (r2 == 5) goto L5;
        return null;
    L5:
        return SettingsProviderUtils.getSideDialCustomModeSwitch(this.mContext);
    }

    private void createRenameProfileDialog(String r3) {
        DeviceRenameDialogFragment r0 = this.mRenameFragment;
        if (r0 == null) goto L5;
        r0.dismiss();
        this.mRenameFragment = null;
    L5:
        DeviceRenameDialogFragment r1 = new DeviceRenameDialogFragment(r3);
        this.mRenameFragment = r1;
        r1.setDialogTitle(this.mContext.getString(R.string.bluetooth_rename_device));
        this.mRenameFragment.setPositiveButtonText(this.mContext.getString(R.string.bluetooth_rename_button));
        this.mRenameFragment.setPositiveButtonClickListener(new SideDialCustomFragment$$ExternalSyntheticLambda0(this));
        this.mRenameFragment.show(getParentFragmentManager(), this.TAG);
    }

    /* JADX INFO: renamed from: lambda$createRenameProfileDialog$1$com-android-settings-sidedial-SideDialCustomFragment, reason: not valid java name */
    /* synthetic */ void m595xe9149a4b(View r2) {
        if ((r2 instanceof TextView) == false) goto L8;
        String r3 = ((TextView) r2).getText().toString();
        putCustomModeTitleName(r3);
        OFloatingTitleBar r1 = this.mTitleView;
        if (r1 == null) goto L9;
        r1.setCenterTitle(r3);
        return;
    L9:
        return;
    }

    private void updateFeedbackVibration() {
        if (SettingsUtil.hasNavigationBar() == false) goto L6;
        this.mCustomModeFeedbackVibration.setVisibility(0);
        String r0 = Utils.getNavbarVibrationValueByMode(this.mContext);
        this.mCustomModeFeedbackVibration.setTitle(r0);
        this.mCustomModeFeedbackVibration.setOnCheckedChangeListener(this);
        this.mCustomModeFeedbackVibration.setChecked(getState(this.mSwitches.get(Constants.SIDE_DIAL_CUSTOM_MODE_FEEDBACK_VIBRATION)));
        return;
    }

    private boolean getState(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L7;
        return false;
    L7:
        return "1".equals(r1);
    }

    protected static void putCustomModeTitleName(String r2) {
        PreferenceMgr.getInstance(SettingsApplication.getContext()).putString(Constants.SIDE_DIAL_CUSTOM_TITLE_NAME, r2);
    }

    protected static String getCustomModeTitleName() {
        return PreferenceMgr.getInstance(SettingsApplication.getContext()).getString(Constants.SIDE_DIAL_CUSTOM_TITLE_NAME, SettingsApplication.getContext().getString(R.string.side_dial_custom_mode_title));
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_sidedial_SideDialCustomFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(SideDialCustomFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_sidedial_SideDialCustomFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_sidedial_SideDialCustomFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(SideDialCustomFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_sidedial_SideDialCustomFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_sidedial_SideDialCustomFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(SideDialCustomFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_sidedial_SideDialCustomFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
