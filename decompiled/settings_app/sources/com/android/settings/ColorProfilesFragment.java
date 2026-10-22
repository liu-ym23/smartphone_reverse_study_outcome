package com.android.settings;

import android.content.Context;
import android.content.res.ColorStateList;
import android.database.ContentObserver;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;
import bytedanceos.util.DeviceType;
import com.android.settings.accessibility.ColorModeSettingsFragment;
import com.android.settings.base.BaseFragment;
import com.android.settings.eyesprotection.EyesProtectionAPI;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.widget.SettingItemButton;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.ListContentItem;
import obric.widget.SettingItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public class ColorProfilesFragment extends BaseFragment implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, CompoundButton.OnCheckedChangeListener {
    public static final int COLOR_LIMIT_MAX = 0;
    public static final int COLOR_LIMIT_MIN = 0;
    public static final int COLOR_MIDDLE_VALUE = 0;
    public static final String COLOR_PROFILES_SEPERATOR = ":";
    private static final int DARWIN_COLOR_LIMIT_MAX = 1050;
    private static final int DARWIN_COLOR_LIMIT_MIN = 430;
    private static final int DARWIN_COLOR_MIDDLE_VALUE = 740;
    public static final int DEF_BLUE_VALUE = 0;
    public static final int DEF_RED_VALUE = 32000;
    private static final int DELTA_COLOR_LIMIT_MAX = 10000;
    private static final int DELTA_COLOR_LIMIT_MIN = 4300;
    private static final int DELTA_COLOR_MIDDLE_VALUE = 7400;
    public static final String KEY_COLOR_PROFILES = "color_profiles";
    private static final boolean RESET_USE_NEGATIVE_NUMBER = false;
    private static final int SMART_DISPLAY_OFF = 0;
    private static final int SMART_DISPLAY_ON = 1;
    private static EyesProtectionAPI mColorTemperatureAPI;
    private static int scale;
    private SettingItemSwitch mAutoColorProfileSwitch;
    private int mBlueValue;
    private SeekBar mCalibrationBar;
    private TextView mColorProfileColdTv;
    private TextView mColorProfileWarmTv;
    private ContentObserver mEyesProtectionObserver;
    private boolean mIsSeekbarMove;
    private int mRedValue;
    private SettingItemButton mResetBtn;
    private ColorStateList textDefaultColor;
    private int textDisableColor;

    public void com_android_settings_ColorProfilesFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_ColorProfilesFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_ColorProfilesFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public ColorProfilesFragment() {
        this.mRedValue = DEF_RED_VALUE;
        this.mBlueValue = DEF_BLUE_VALUE;
        this.mIsSeekbarMove = false;
    }

    static {
        if (DeviceType.is(DeviceType.DELTA) == false) goto L5;
        int r0 = DELTA_COLOR_LIMIT_MIN;
    L6:
        COLOR_LIMIT_MIN = r0;
        if (DeviceType.is(DeviceType.DELTA) == false) goto L9;
        int r1 = 10000;
    L10:
        COLOR_LIMIT_MAX = r1;
        DEF_BLUE_VALUE = r1;
        RESET_USE_NEGATIVE_NUMBER = true;
        if (DeviceType.is(DeviceType.DELTA) == false) goto L13;
        int r2 = DELTA_COLOR_MIDDLE_VALUE;
    L14:
        COLOR_MIDDLE_VALUE = r2;
        scale = r1 - r0;
        return;
    L13:
        r2 = DARWIN_COLOR_MIDDLE_VALUE;
        goto L14
    L9:
        r1 = DARWIN_COLOR_LIMIT_MAX;
        goto L10
    L5:
        r0 = DARWIN_COLOR_LIMIT_MIN;
        goto L6
    }

    public void com_android_settings_ColorProfilesFragment__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        initColorValuesByDb();
        this.textDisableColor = getResources().getColor(R.color.setting_item_text_color_disabled, null);
    }

    private void initColorValuesByDb() {
        int[] r0 = getSavedColorTemperatureValues(this.mContext);
        this.mRedValue = r0[0];
        this.mBlueValue = r0[1];
    }

    public static String getCalibrationValuesFromDb(Context r1) {
        return android.provider.Settings.Global.getString(r1.getContentResolver(), KEY_COLOR_PROFILES);
    }

    private static void saveCalibrationValues(Context r1, int r2) {
        android.provider.Settings.Global.putString(r1.getContentResolver(), KEY_COLOR_PROFILES, r2 + "");
    }

    public static void setColorTemperatureBySavedValues(Context r2) {
        int[] r3 = getSavedColorTemperatureValues(r2);
        Calibration.setColorTemperatureValue(r3[0], r3[1]);
    }

    private static int[] getSavedColorTemperatureValues(Context r5) {
        String r6 = getCalibrationValuesFromDb(r5);
        if (TextUtils.isEmpty(r6) == true) goto L13;
        String[] r7 = r6.split(":");
        if (r7 == null) goto L13;
        if (r7.length != 2) goto L13;
        return new int[]{Integer.parseInt(r7[0]), Integer.parseInt(r7[1])};
    L10:
        e = move-exception;
        e.printStackTrace();
    L13:
        if (RESET_USE_NEGATIVE_NUMBER == false) goto L17;
        return new int[]{-32000, -DEF_BLUE_VALUE};
    L17:
        return new int[]{DEF_RED_VALUE, DEF_BLUE_VALUE};
    }

    private int getColorProfileMode(int r2) {
        return android.provider.Settings.Global.getInt(getContentResolver(), "smart_display_state", r2);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        this.mRootView = r4.inflate(R.layout.color_profiles_fragment_layout, r5, false);
        SeekBar r7 = (SeekBar) findViewByIdNullable(R.id.calibration_bar);
        this.mCalibrationBar = r7;
        r7.setOnSeekBarChangeListener(this);
        this.mCalibrationBar.setMax(scale);
        String r8 = getCalibrationValuesFromDb(this.mContext);
        if (TextUtils.isEmpty(r8) == false) goto L5;
    L8:
        this.mCalibrationBar.setProgress(scale / 2);
    L9:
        ListContentItem r9 = (ListContentItem) findViewByIdNullable(R.id.id_color_profile_overview);
        this.mColorProfileColdTv = (TextView) findViewByIdNullable(R.id.color_profiles_cold);
        this.mColorProfileWarmTv = (TextView) findViewByIdNullable(R.id.color_profiles_warm);
        this.textDefaultColor = this.mColorProfileColdTv.getTextColors();
        this.mAutoColorProfileSwitch = (SettingItemSwitch) findViewByIdNullable(R.id.switch_auto_color_profile);
        View r10 = findViewByIdNullable(R.id.id_tips_color_profiles);
        View r0 = findViewByIdNullable(R.id.id_color_profiles_eye_protection);
        SettingItemButton r1 = (SettingItemButton) findViewByIdNullable(R.id.reset_btn);
        this.mResetBtn = r1;
        r1.setOnClickListener(this);
        if (SettingsFeature.isSupportSmartDisplay() == false) goto L12;
        this.mResetBtn.setVisibility(8);
        r9.setBackgroundStyle(2);
        this.mAutoColorProfileSwitch.setOnCheckedChangeListener(this);
    L14:
        return this.mRootView;
    L12:
        this.mAutoColorProfileSwitch.setVisibility(8);
        r10.setVisibility(8);
        r0.setVisibility(8);
        goto L14
    L5:
        if (r8.equals(COLOR_MIDDLE_VALUE + "") == true) goto L8;
        this.mCalibrationBar.setProgress(Integer.parseInt(r8) - COLOR_LIMIT_MIN);
        goto L9
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
    }

    public void updateViews() {
        if (SettingsFeature.isSupportSmartDisplay() == false) goto L10;
        boolean r0 = true;
        if (getColorProfileMode(1) == 1) goto L8;
        r0 = false;
    L8:
        this.mAutoColorProfileSwitch.setChecked(r0);
        this.mCalibrationBar.setEnabled(!r0);
        changeProfileTextColor(r0);
        return;
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        SettingsTracker.flush();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (r2 != this.mResetBtn) goto L6;
        this.mRedValue = DEF_RED_VALUE;
        this.mBlueValue = COLOR_LIMIT_MAX;
        resetColorTemperature(this.mContext);
        SeekBar r1 = this.mCalibrationBar;
        r1.setProgress(r1.getMax() / 2);
        return;
    }

    public static void resetColorTemperature(Context r2) {
        if (mColorTemperatureAPI != null) goto L5;
        mColorTemperatureAPI = EyesProtectionAPI.getInstance(true);
    L5:
        EyesProtectionAPI r0 = mColorTemperatureAPI;
        int r1 = COLOR_MIDDLE_VALUE;
        r0.setProgress(r1);
        mColorTemperatureAPI.adjustColorTemperature();
        saveCalibrationValues(r2, r1);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar r1, int r2, boolean r3) {
        if (this.mIsSeekbarMove == true) goto L6;
        return;
    L6:
        if (mColorTemperatureAPI != null) goto L8;
        mColorTemperatureAPI = EyesProtectionAPI.getInstance(true);
    L8:
        mColorTemperatureAPI.setProgress(COLOR_LIMIT_MIN + r2);
        mColorTemperatureAPI.adjustColorTemperature();
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar r1) {
        this.mIsSeekbarMove = true;
        if (SettingsFeature.isScreenColorModeSupport() == false) goto L6;
        ColorModeSettingsFragment.resetColorMode(this.mContext);
        return;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar r4) {
        this.mIsSeekbarMove = false;
        if (mColorTemperatureAPI != null) goto L5;
        mColorTemperatureAPI = EyesProtectionAPI.getInstance(true);
    L5:
        EyesProtectionAPI r0 = mColorTemperatureAPI;
        int r1 = COLOR_LIMIT_MIN;
        r0.setProgress(r4.getProgress() + r1);
        mColorTemperatureAPI.adjustColorTemperature();
        saveCalibrationValues(this.mContext, r1 + r4.getProgress());
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, boolean r3) {
        if (r2 != this.mAutoColorProfileSwitch.getSwitch()) goto L6;
        android.provider.Settings.Global.putInt(getContentResolver(), "smart_display_state", r3 ? 1 : 0);
        this.mCalibrationBar.setEnabled(!r3);
        changeProfileTextColor(r3);
        return;
    }

    private void changeProfileTextColor(boolean r2) {
        if (r2 == false) goto L4;
        this.mColorProfileColdTv.setTextColor(this.textDisableColor);
        this.mColorProfileWarmTv.setTextColor(this.textDisableColor);
        return;
    L4:
        this.mColorProfileColdTv.setTextColor(this.textDefaultColor);
        this.mColorProfileWarmTv.setTextColor(this.textDefaultColor);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_ColorProfilesFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ColorProfilesFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_ColorProfilesFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_ColorProfilesFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ColorProfilesFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_ColorProfilesFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_ColorProfilesFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ColorProfilesFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_ColorProfilesFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
