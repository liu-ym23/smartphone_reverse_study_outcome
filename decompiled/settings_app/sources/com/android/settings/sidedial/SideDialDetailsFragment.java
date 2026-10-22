package com.android.settings.sidedial;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import com.android.settings.Constants;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.SettingsProviderUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemSwitch;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public class SideDialDetailsFragment extends BaseFragment implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    private static int sLaunchType;
    private SettingItemSwitch mCarModeAlwaysOnScreen;
    private SettingItemSwitch mCarModeBluetooth;
    private LinearLayout mCarModeContainer;
    private SettingItemText mCarModeNavigation;
    private SettingItemSwitch mCarModeScreenRotation;
    private HashMap<String, String> mSwitches;

    public void com_android_settings_sidedial_SideDialDetailsFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_sidedial_SideDialDetailsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_sidedial_SideDialDetailsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public void com_android_settings_sidedial_SideDialDetailsFragment__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        Bundle r4 = getArguments();
        if (r4 == null) goto L6;
        sLaunchType = r4.getInt("launch_mode", -1);
        this.mTitleResId = Integer.valueOf(r4.getInt(SideDialOptionsFragment.TITLE_RES, R.string.side_dial_title));
        return;
    }

    public SideDialDetailsFragment() {
        super(R.layout.side_dial_details_setting_layout);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        LinearLayout r3 = (LinearLayout) findViewByIdNullable(R.id.side_dial_car_mode_container);
        this.mCarModeContainer = r3;
        r3.setVisibility(0);
        this.mCarModeBluetooth = (SettingItemSwitch) findViewByIdNullable(R.id.car_mode_bluetooth);
        this.mCarModeAlwaysOnScreen = (SettingItemSwitch) findViewByIdNullable(R.id.car_mode_always_on_screen);
        this.mCarModeScreenRotation = (SettingItemSwitch) findViewByIdNullable(R.id.car_mode_screen_rotation);
        SettingItemText r4 = (SettingItemText) findViewByIdNullable(R.id.car_mode_navigation);
        this.mCarModeNavigation = r4;
        r4.setOnClickListener(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
        this.mCarModeBluetooth.setOnCheckedChangeListener(this);
        this.mCarModeAlwaysOnScreen.setOnCheckedChangeListener(this);
        this.mCarModeScreenRotation.setOnCheckedChangeListener(this);
    }

    public void updateViews() {
        HashMap<String, String> r0 = (HashMap) Utils.fromJson(getModeSwitch(sLaunchType), SideDialHelper.TYPE_TOKEN);
        this.mSwitches = r0;
        if (r0 == null) goto L6;
        this.mCarModeScreenRotation.setChecked(getState(r0.get(Constants.SIDE_DIAL_CAR_MODE_SCREEN_ROTATION)));
        this.mCarModeNavigation.setSubTitle(SideDialHelper.getNavigationAppName(this.mContext, this.mSwitches.get(Constants.SIDE_DIAL_CAR_MODE_NAVIGATION)));
        this.mCarModeBluetooth.setChecked(getState(this.mSwitches.get(Constants.SIDE_DIAL_CAR_MODE_BLUETOOTH)));
        this.mCarModeAlwaysOnScreen.setChecked(getState(this.mSwitches.get(Constants.SIDE_DIAL_CAR_MODE_ALWAYS_ON_SCREEN)));
        return;
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    private boolean getState(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L7;
        return false;
    L7:
        return "1".equals(r1);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r4, boolean r5) {
        if (this.mSwitches != null) goto L5;
        return;
    L5:
        String r1 = "1";
        if (r4 != this.mCarModeBluetooth.getSwitch()) goto L13;
        HashMap<String, String> r6 = this.mSwitches;
        if (r5 == true) goto L11;
        r1 = "0";
    L11:
        r6.put(Constants.SIDE_DIAL_CAR_MODE_BLUETOOTH, r1);
    L27:
        if (sLaunchType != 4) goto L30;
        SideDialHelper.setSideDialDetailPageModify(this.mContext);
        SettingsProviderUtils.setSideDialCarModeSwitch(this.mContext, Utils.toJson(this.mSwitches));
        return;
    L30:
        return;
    L13:
        if (r4 != this.mCarModeAlwaysOnScreen.getSwitch()) goto L20;
        HashMap<String, String> r7 = this.mSwitches;
        if (r5 == true) goto L18;
        r1 = "0";
    L18:
        r7.put(Constants.SIDE_DIAL_CAR_MODE_ALWAYS_ON_SCREEN, r1);
        goto L27
    L20:
        if (r4 != this.mCarModeScreenRotation.getSwitch()) goto L27;
        HashMap<String, String> r8 = this.mSwitches;
        if (r5 == true) goto L25;
        r1 = "0";
    L25:
        r8.put(Constants.SIDE_DIAL_CAR_MODE_SCREEN_ROTATION, r1);
        goto L27
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (r2.getId() != R.id.car_mode_navigation) goto L6;
        start(new SideDialNavigationFragment());
        return;
    }

    private String getModeSwitch(int r2) {
        if (r2 == 4) goto L5;
        return null;
    L5:
        return SettingsProviderUtils.getSideDialCarModeSwitch(this.mContext);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_sidedial_SideDialDetailsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(SideDialDetailsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_sidedial_SideDialDetailsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_sidedial_SideDialDetailsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(SideDialDetailsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_sidedial_SideDialDetailsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_sidedial_SideDialDetailsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(SideDialDetailsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_sidedial_SideDialDetailsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
