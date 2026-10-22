package com.android.settings.accessibility;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.ImageView;
import com.android.settings.Calibration;
import com.android.settings.ColorProfilesFragment;
import com.android.settings.R;
import com.android.settings.SettingsFeature;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OListItemSettings;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class ColorModeSettingsFragment extends BaseFragment implements View.OnClickListener {
    private OListItemSettings mColorModeColorful;
    private OListItemSettings mColorModeDefaults;
    private OListItemSettings mColorModeStandard;
    private ContentObserver mEyesProtectionObserver;

    public void com_android_settings_accessibility_ColorModeSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_accessibility_ColorModeSettingsFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_accessibility_ColorModeSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_accessibility_ColorModeSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public ColorModeSettingsFragment() {
        super(R.layout.fragment_color_mode_settings);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        this.mColorModeDefaults = (OListItemSettings) findViewByIdNullable(R.id.color_mode_defaults);
        this.mColorModeStandard = (OListItemSettings) findViewByIdNullable(R.id.color_mode_standard);
        this.mColorModeColorful = (OListItemSettings) findViewByIdNullable(R.id.color_mode_colorful);
        this.mColorModeDefaults.setTag(0);
        this.mColorModeStandard.setTag(1);
        this.mColorModeColorful.setTag(2);
        this.mColorModeDefaults.setOnClickListener(this);
        this.mColorModeStandard.setOnClickListener(this);
        this.mColorModeColorful.setOnClickListener(this);
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
    }

    private void updateViews() {
        int r0 = getCurrentColorMode(this.mContext);
        ImageView r1 = new ImageView(this.mContext);
        r1.setImageResource(R.drawable.icon_check_confirm_rounded);
        this.mColorModeDefaults.mTrailingElement.setVisibility(4);
        this.mColorModeStandard.mTrailingElement.setVisibility(4);
        this.mColorModeColorful.mTrailingElement.setVisibility(4);
        if (r0 != 0) goto L6;
        this.mColorModeDefaults.setTrailingView(r1);
        this.mColorModeDefaults.mTrailingElement.setVisibility(0);
        return;
    L6:
        if (r0 != 1) goto L9;
        this.mColorModeStandard.setTrailingView(r1);
        this.mColorModeStandard.mTrailingElement.setVisibility(0);
        return;
    L9:
        if (r0 != 2) goto L14;
        this.mColorModeColorful.setTrailingView(r1);
        this.mColorModeColorful.mTrailingElement.setVisibility(0);
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (r2 != this.mColorModeDefaults) goto L5;
    L8:
        int r3 = ((Integer) r2.getTag()).intValue();
        if (r3 == 0) goto L11;
        ColorProfilesFragment.resetColorTemperature(this.mContext);
    L11:
        setColorMode(this.mContext, r3);
        updateViews();
        return;
    L5:
        if (r2 == this.mColorModeStandard) goto L8;
        if (r2 == this.mColorModeColorful) goto L8;
    }

    public static int getCurrentColorMode(Context r2) {
        return Settings.Global.getInt(r2.getContentResolver(), "screen_color_mode", 0);
    }

    public static void resetColorMode(Context r1) {
        if (getCurrentColorMode(r1) == 0) goto L6;
        setColorMode(r1, 0);
        return;
    }

    public static String getCurrentColorModeName(Context r2) {
        int r0 = getCurrentColorMode(r2);
        if (r0 != 1) goto L5;
        int r1 = R.string.color_mode_standard;
    L10:
        return r2.getString(r1);
    L5:
        if (r0 == 2) goto L7;
        r1 = R.string.color_mode_defaults;
        goto L10
    L7:
        r1 = R.string.color_mode_colorful;
        goto L10
    }

    private static void setColorMode(Context r2, int r3) {
        Settings.Global.putInt(r2.getContentResolver(), "screen_color_mode", r3);
        if (SettingsFeature.isEyesProtectionRejectColorMode() == false) goto L5;
        Settings.Global.putInt(r2.getContentResolver(), "screen_color_mode_previous", r3);
    L5:
        Calibration.setColorMode(r3);
        if (r3 == 0) goto L9;
        Calibration.setEyesProtectionEnable(false);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_accessibility_ColorModeSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ColorModeSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_accessibility_ColorModeSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_accessibility_ColorModeSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ColorModeSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_accessibility_ColorModeSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_accessibility_ColorModeSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ColorModeSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_accessibility_ColorModeSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
