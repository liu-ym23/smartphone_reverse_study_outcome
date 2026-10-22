package com.android.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.widget.SettingItemButton;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import com.ttnet.org.chromium.net.NetError;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public class TNTColorProfilesFragment extends BaseFragment implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    private static final int BLUE_MASK = 255;
    private static final int DEFAULT_BLUE = 114;
    private static final int DEFAULT_COLOR = 0;
    private static final int DEFAULT_GREEN = 120;
    private static final int DEFAULT_RED = 124;
    private static final int GREEN_MASK = 65280;
    private static final int LIMIT_COLD_BLUE = 129;
    private static final int LIMIT_COLD_GREEN = 116;
    private static final int LIMIT_COLD_RED = 106;
    private static final int LIMIT_WARM_BLUE = 87;
    private static final int LIMIT_WARM_GREEN = 110;
    private static final int LIMIT_WARM_RED = 119;
    private static final int MASK = 255;
    public static final int PROGRESS_HALF = 270;
    public static final int PROGRESS_MAX = 540;
    private static final int RED_MASK = 16711680;
    private SettingItemSwitch mAutoColorProfileSwitch;
    private SeekBar mCalibrationBar;
    private SettingItemButton mResetBtn;

    private static int getBlue(int r0) {
        return r0 & 255;
    }

    private static int getColor(int r1, int r2, int r3) {
        return (((r1 << 16) & RED_MASK) | ((r2 << 8) & 65280)) | (r3 & 255);
    }

    private static int getGreen(int r0) {
        return (r0 >> 8) & 255;
    }

    private static int getRed(int r0) {
        return (r0 >> 16) & 255;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_TNTColorProfilesFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_TNTColorProfilesFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar r1) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar r1) {
    }

    public TNTColorProfilesFragment() {
    }

    static {
        DEFAULT_COLOR = getColor(124, 120, 114);
    }

    public void com_android_settings_TNTColorProfilesFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    private void clearCalibrationValues() {
        android.provider.Settings.Global.putInt(this.mContext.getContentResolver(), "TNT_screen_color", DEFAULT_COLOR);
        PreferenceMgr.getInstance(this.mContext).putInt(PreferenceMgr.KEY_TNT_SCREEN_COLOR_PROGRESS, 270);
    }

    private void setCalibrationValuesByProgress(int r4) {
        android.provider.Settings.Global.putInt(getContentResolver(), "TNT_screen_color", progressToScreenColor(r4));
        PreferenceMgr.getInstance(this.mContext).putInt(PreferenceMgr.KEY_TNT_SCREEN_COLOR_PROGRESS, r4);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.color_profiles_fragment_layout, r3, false);
        SeekBar r5 = (SeekBar) findViewByIdNullable(R.id.calibration_bar);
        this.mCalibrationBar = r5;
        r5.setOnSeekBarChangeListener(this);
        this.mCalibrationBar.setMax(PROGRESS_MAX);
        this.mAutoColorProfileSwitch = (SettingItemSwitch) findViewByIdNullable(R.id.switch_auto_color_profile);
        View r6 = findViewByIdNullable(R.id.id_tips_color_profiles);
        View r7 = findViewByIdNullable(R.id.id_color_profiles_eye_protection);
        SettingItemButton r8 = (SettingItemButton) findViewByIdNullable(R.id.reset_btn);
        this.mResetBtn = r8;
        r8.setOnClickListener(this);
        this.mAutoColorProfileSwitch.setVisibility(8);
        r6.setVisibility(8);
        r7.setVisibility(8);
        return this.mRootView;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r2, Bundle r3) {
        super.onViewCreated(r2, r3);
        int r4 = android.provider.Settings.Global.getInt(getContentResolver(), "TNT_screen_color", DEFAULT_COLOR);
        this.mCalibrationBar.setProgress(screenColorToProgress(r4));
    }

    public void com_android_settings_TNTColorProfilesFragment__onResume$___twin___() {
        super.onResume();
        int r0 = android.provider.Settings.Global.getInt(getContentResolver(), "TNT_screen_color", DEFAULT_COLOR);
        this.mCalibrationBar.setProgress(screenColorToProgress(r0));
    }

    private int screenColorToProgress(int r17) {
        int r2 = PreferenceMgr.getInstance(this.mContext).getInt(PreferenceMgr.KEY_TNT_SCREEN_COLOR_PROGRESS, 270);
        if (progressToScreenColor(r2) != r17) goto L5;
        return r2;
    L5:
        int r3 = getRed(r17);
        int r4 = getGreen(r17);
        int r5 = getBlue(r17);
        if (r3 < 119) goto L15;
        if (r3 > 124) goto L15;
        if (r4 < 110) goto L15;
        if (r4 > 120) goto L15;
        if (r5 < 87) goto L15;
        if (r5 > 114) goto L15;
        int r6 = (int) ((((r5 - 87) * 1.0f) / 27.0f) * 270.0f);
        OLog.d(this.TAG, "color " + r17 + " r = " + r3 + " g = " + r4 + " b = " + r5 + " to progress " + r6);
        return r6;
    L15:
        if (r3 <= 124) goto L17;
    L25:
        OLog.e(this.TAG, "INVALID color " + r17 + " r = " + getRed(r17) + " g = " + getGreen(r17) + " b = " + getBlue(r17));
        return screenColorToProgress(DEFAULT_COLOR);
    L17:
        if (r3 < 106) goto L25;
        if (r4 > 120) goto L25;
        if (r4 < 116) goto L25;
        if (r5 < 114) goto L25;
        if (r5 > 129) goto L25;
        int r7 = ((int) ((((r5 + NetError.ERR_SSL_RENEGOTIATION_REQUESTED) * 1.0f) / 15.0f) * 270.0f)) + 270;
        OLog.d(this.TAG, "color " + r17 + " r = " + r3 + " g = " + r4 + " b = " + r5 + " to progress " + r7);
        return r7;
    }

    private int progressToScreenColor(int r6) {
        int r7 = Math.max(Math.min(r6, PROGRESS_MAX), 0);
        if (r7 > 270) goto L5;
        float r0 = (r7 * 1.0f) / 270.0f;
        int r1 = ((int) (5.0f * r0)) + 119;
        int r2 = ((int) (10.0f * r0)) + 110;
        int r3 = ((int) (r0 * 27.0f)) + 87;
    L6:
        OLog.d(this.TAG, "progress " + r7 + " to color " + getColor(r1, r2, r3) + " r = " + r1 + " g = " + r2 + " b = " + r3);
        return getColor(r1, r2, r3);
    L5:
        float r4 = ((r7 - 270) * 1.0f) / 270.0f;
        r1 = ((int) ((-18.0f) * r4)) + 124;
        r2 = ((int) ((-4.0f) * r4)) + 120;
        r3 = ((int) (r4 * 15.0f)) + 114;
        goto L6
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (r2 != this.mResetBtn) goto L6;
        SeekBar r3 = this.mCalibrationBar;
        r3.setProgress(r3.getMax() / 2);
        clearCalibrationValues();
        return;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar r2, int r3, boolean r4) {
        if (r2 != this.mCalibrationBar) goto L7;
        if (r4 == false) goto L8;
        setCalibrationValuesByProgress(r3);
        return;
    L8:
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_TNTColorProfilesFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(TNTColorProfilesFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_TNTColorProfilesFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_TNTColorProfilesFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(TNTColorProfilesFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_TNTColorProfilesFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_TNTColorProfilesFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(TNTColorProfilesFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_TNTColorProfilesFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
