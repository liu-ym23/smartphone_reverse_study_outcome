package com.android.settings;

import android.content.Intent;
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
import obric.widget.SettingItemCheck;
import obric.widget.SettingItemSwitch;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public class ImmersiveModeFragment extends BaseFragment implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    public static final String THIRD_APP_STATUS_BAR_MODE = "3rd_app_status_bar_mode";
    private SettingItemSwitch mAdapterColorStatusBarSwitch;
    private SettingItemText mApplicationStatusBarDisplayMode;
    private View mApplicationStatusBarDisplayShadow;
    private boolean mIsChanged;
    private boolean mStatusBarNotch;
    private SettingItemCheck mStatusBarNotchHide;
    private SettingItemCheck mStatusBarNotchShow;

    public static void updateCustomizedStatusBarState() {
    }

    public void com_android_settings_ImmersiveModeFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_ImmersiveModeFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_ImmersiveModeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_ImmersiveModeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public ImmersiveModeFragment() {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        int r0 = 0;
        this.mRootView = r2.inflate(R.layout.immersive_mode_layout, r3, false);
        SettingItemText r5 = (SettingItemText) findViewByIdNullable(R.id.application_status_bar_display_mode);
        this.mApplicationStatusBarDisplayMode = r5;
        r5.setOnClickListener(this);
        View r6 = findViewByIdNullable(R.id.application_status_bar_display_mode_shadow);
        this.mApplicationStatusBarDisplayShadow = r6;
        if (SettingsFeature.COLOR_STATUS_BAR_ENABLED == false) goto L5;
        int r7 = 0;
    L6:
        r6.setVisibility(r7);
        SettingItemSwitch r8 = (SettingItemSwitch) findViewByIdNullable(R.id.switch_color_status_bar);
        this.mAdapterColorStatusBarSwitch = r8;
        if (SettingsFeature.COLOR_STATUS_BAR_ENABLED == false) goto L9;
        int r9 = 0;
    L10:
        r8.setVisibility(r9);
        this.mStatusBarNotchShow = (SettingItemCheck) findViewByIdNullable(R.id.status_bar_notch_title_show_camera);
        this.mStatusBarNotchHide = (SettingItemCheck) findViewByIdNullable(R.id.status_bar_notch_title_hide_camera);
        View r10 = findViewByIdNullable(R.id.status_bar_notch);
        if (Utils.isCameraInScreen() == false) goto L13;
        this.mStatusBarNotch = Utils.isNotchStatusBar(this.mContext);
        this.mStatusBarNotchShow.setOnClickListener(this);
        this.mStatusBarNotchHide.setOnClickListener(this);
        findViewByIdNullable(R.id.status_bar_notch_title_show_camera_image).setOnClickListener(this);
        findViewByIdNullable(R.id.status_bar_notch_title_hide_camera_image).setOnClickListener(this);
    L14:
        SettingItemText r11 = this.mApplicationStatusBarDisplayMode;
        if (SettingsFeature.isWaterDropScreen() == false) goto L17;
    L20:
        int r12 = 0;
    L21:
        r11.setVisibility(r12);
        View r13 = this.mApplicationStatusBarDisplayShadow;
        if (SettingsFeature.isWaterDropScreen() == false) goto L24;
    L27:
        r13.setVisibility(r0);
        return this.mRootView;
    L24:
        if (SettingsFeature.isInfiniteScreen() == true) goto L27;
        r0 = 8;
        goto L27
    L17:
        if (SettingsFeature.isInfiniteScreen() == true) goto L20;
        r12 = 8;
        goto L21
    L13:
        r10.setVisibility(8);
        goto L14
    L9:
        r9 = 8;
        goto L10
    L5:
        r7 = 8;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateUI();
        this.mAdapterColorStatusBarSwitch.setOnCheckedChangeListener(this);
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateUI();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        updateCustomizedStatusBarState();
        if (this.mIsChanged == false) goto L6;
        sendBroadcast(new Intent(Constants.ACTION.ACTION_STATUSBAR_SETTINGS_CHANGED));
        return;
    }

    public void updateUI() {
        boolean r2 = true;
        if (android.provider.Settings.System.getInt(getContentResolver(), Constants.ADAPTER_COLOR_STATUS_BAR, 1) != 1) goto L5;
        boolean r0 = true;
    L6:
        this.mAdapterColorStatusBarSwitch.setChecked(r0);
        if (Utils.isCameraInScreen() == true) goto L9;
        return;
    L9:
        if (android.provider.Settings.Global.getInt(getContentResolver(), "notch_status_bar_state", 1) == 1) goto L12;
        r2 = false;
    L12:
        this.mStatusBarNotch = r2;
        updateView(r2);
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, boolean r3) {
        this.mIsChanged = true;
        if (r2 != this.mAdapterColorStatusBarSwitch.getSwitch()) goto L6;
        android.provider.Settings.System.putInt(getContentResolver(), Constants.ADAPTER_COLOR_STATUS_BAR, r3 ? 1 : 0);
        SettingsTracker.onSwitcherClick(260201, r3);
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r4) {
        if (r4 != this.mApplicationStatusBarDisplayMode) goto L6;
        start(DisplayAreaAppsFragment.class);
        return;
    L6:
        if (r4 == this.mStatusBarNotchShow) goto L19;
        if (r4.getId() == R.id.status_bar_notch_title_show_camera_image) goto L19;
        if (r4 == this.mStatusBarNotchHide) goto L15;
        if (r4.getId() == R.id.status_bar_notch_title_hide_camera_image) goto L15;
        return;
    L15:
        if (this.mStatusBarNotchHide.isChecked() == false) goto L17;
        return;
    L17:
        android.provider.Settings.Global.putInt(getContentResolver(), "notch_status_bar_state", 0);
        updateView(false);
        return;
    L19:
        if (this.mStatusBarNotchShow.isChecked() == false) goto L21;
        return;
    L21:
        android.provider.Settings.Global.putInt(getContentResolver(), "notch_status_bar_state", 1);
        updateView(true);
    }

    public void updateView(boolean r5) {
        this.mStatusBarNotchShow.setChecked(r5);
        this.mStatusBarNotchHide.setChecked(!r5);
        SettingItemSwitch r0 = this.mAdapterColorStatusBarSwitch;
        int r1 = 0;
        if (r5 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        View r2 = this.mApplicationStatusBarDisplayShadow;
        if (r5 == false) goto L9;
        int r4 = 0;
    L10:
        r2.setVisibility(r4);
        SettingItemText r6 = this.mApplicationStatusBarDisplayMode;
        if (r5 == true) goto L14;
        r1 = 8;
    L14:
        r6.setVisibility(r1);
        return;
    L9:
        r4 = 8;
        goto L10
    L5:
        r3 = 8;
        goto L6
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_ImmersiveModeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ImmersiveModeFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_ImmersiveModeFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_ImmersiveModeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ImmersiveModeFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_ImmersiveModeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_ImmersiveModeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ImmersiveModeFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_ImmersiveModeFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
