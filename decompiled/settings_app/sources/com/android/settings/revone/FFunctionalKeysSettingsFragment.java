package com.android.settings.revone;

import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.CompoundButton;
import com.android.settings.R;
import com.android.settings.SettingsFeature;
import com.android.settings.SettingsTracker;
import com.android.settings.TrackerConstants;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemSwitch;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public class FFunctionalKeysSettingsFragment extends BaseFragment implements CompoundButton.OnCheckedChangeListener {
    private SettingItemText mF1;
    private SettingItemText mF10;
    private SettingItemText mF11;
    private SettingItemText mF12;
    private SettingItemText mF2;
    private SettingItemText mF3;
    private SettingItemText mF4;
    private SettingItemText mF5;
    private SettingItemText mF6;
    private SettingItemText mF7;
    private SettingItemText mF8;
    private SettingItemText mF9;
    private SettingItemSwitch mItemSwitchFFunctionalKeys;
    private ArrayList<SettingItemText> mItems;

    public void com_android_settings_revone_FFunctionalKeysSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_revone_FFunctionalKeysSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_revone_FFunctionalKeysSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public FFunctionalKeysSettingsFragment() {
        super(R.layout.revone_f_functional_keys_settings);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        this.mItems = new ArrayList();
        this.mItemSwitchFFunctionalKeys = (SettingItemSwitch) findViewByIdNullable(R.id.f_functional_keys);
        this.mF1 = (SettingItemText) findViewByIdNullable(R.id.btn_f1);
        this.mF2 = (SettingItemText) findViewByIdNullable(R.id.btn_f2);
        this.mF3 = (SettingItemText) findViewByIdNullable(R.id.btn_f3);
        this.mF4 = (SettingItemText) findViewByIdNullable(R.id.btn_f4);
        this.mF5 = (SettingItemText) findViewByIdNullable(R.id.btn_f5);
        this.mF6 = (SettingItemText) findViewByIdNullable(R.id.btn_f6);
        this.mF7 = (SettingItemText) findViewByIdNullable(R.id.btn_f7);
        this.mF8 = (SettingItemText) findViewByIdNullable(R.id.btn_f8);
        this.mF9 = (SettingItemText) findViewByIdNullable(R.id.btn_f9);
        this.mF10 = (SettingItemText) findViewByIdNullable(R.id.btn_f10);
        this.mF11 = (SettingItemText) findViewByIdNullable(R.id.btn_f11);
        this.mF12 = (SettingItemText) findViewByIdNullable(R.id.btn_f12);
        if (SettingsFeature.isSupportBostonKeyboard() == false) goto L5;
        initBostonFunctionalKeys();
    L6:
        setBackgroundForLastVisibleItem();
        return;
    L5:
        this.mF11.setVisibility(8);
        this.mF12.setVisibility(8);
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        this.mItemSwitchFFunctionalKeys.setOnCheckedChangeListener(this);
    }

    private void initBostonFunctionalKeys() {
        this.mItems.clear();
        this.mItemSwitchFFunctionalKeys.setVisibility(8);
        this.mF1.setSubTitle(R.string.fun_key_application_drawer);
        this.mItems.add(this.mF1);
        this.mF2.setSubTitle(R.string.fun_key_multitasking);
        this.mItems.add(this.mF2);
        this.mF7.setSubTitle(R.string.fun_key_mute);
        this.mItems.add(this.mF7);
        this.mF8.setSubTitle(R.string.fun_key_volume_down);
        this.mItems.add(this.mF8);
        this.mF9.setSubTitle(R.string.fun_key_volume_up);
        this.mItems.add(this.mF9);
        this.mF10.setSubTitle(R.string.fun_key_brightness_reduction);
        this.mItems.add(this.mF10);
        this.mF11.setSubTitle(R.string.fun_key_brightness_plus);
        this.mItems.add(this.mF11);
        this.mF12.setSubTitle(R.string.fun_key_screenshot);
        this.mItems.add(this.mF12);
        this.mF3.setVisibility(8);
        this.mF4.setVisibility(8);
        this.mF5.setVisibility(8);
        this.mF6.setVisibility(8);
    }

    public void com_android_settings_revone_FFunctionalKeysSettingsFragment__onResume$___twin___() {
        super.onResume();
        setBackgroundForLastVisibleItem();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, boolean r3) {
        if (r2 != this.mItemSwitchFFunctionalKeys.getSwitch()) goto L6;
        Settings.Global.putInt(getContentResolver(), "tablet_shortcut_buttons_with_f_keys", r3 ? 1 : 0);
        SettingsTracker.onSwitchStatus(TrackerConstants.TNT_SETTING_EVENT_ID, TrackerConstants.F1F2_KEY_FUNCTION, r3);
        return;
    }

    private void setBackgroundForLastVisibleItem() {
        int r1 = 1;
    L4:
        if (r1 >= this.mItems.size()) goto L11;
        SettingItemText r2 = this.mItems.get(r1);
        if (r2.getVisibility() != 0) goto L10;
        this.mItems.get(r1).setBackgroundStyle(3);
        if (r1 != (this.mItems.size() - 1)) goto L10;
        r2.setBackgroundStyle(4);
    L10:
        r1 = r1 + 1;
        goto L4
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_revone_FFunctionalKeysSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(FFunctionalKeysSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_FFunctionalKeysSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_FFunctionalKeysSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(FFunctionalKeysSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_revone_FFunctionalKeysSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_FFunctionalKeysSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(FFunctionalKeysSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_FFunctionalKeysSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
