package com.android.settings.accessibility;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.android.settings.DialogActivity;
import com.android.settings.R;
import com.android.settings.SettingsTracker;
import com.android.settings.Utils;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.widget.VerticalOptionsCheckView;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.app.settings.search.SettingsSwitchKeyUtil;
import obric.widget.SettingItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public class SmartScreenFragment extends BaseFragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, VerticalOptionsCheckView.OptionSelectListener {
    private int mCurrentNavbarLayout;
    private int mCurrentSmartScreenState;
    private VerticalOptionsCheckView mOneHandleModeOptionView;
    private TextView mSmartScreenLearnMore;
    private SettingItemSwitch mTriggerSmartScreenMode;

    public void com_android_settings_accessibility_SmartScreenFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_accessibility_SmartScreenFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_accessibility_SmartScreenFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_accessibility_SmartScreenFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public SmartScreenFragment() {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.smart_screen_settings_layout, r3, false);
        this.mTriggerSmartScreenMode = (SettingItemSwitch) findViewByIdNullable(R.id.trigger_smart_screen_mode);
        this.mSmartScreenLearnMore = (TextView) findViewByIdNullable(R.id.id_smart_screen_learn_more);
        VerticalOptionsCheckView r5 = (VerticalOptionsCheckView) findViewByIdNullable(R.id.id_navigation_layout_one_hand_mode);
        this.mOneHandleModeOptionView = r5;
        r5.setTitle(R.string.smart_screen_setting_title);
        this.mOneHandleModeOptionView.getOptionPreview(0).setBackgroundResource(R.drawable.navigation_bar_sticker_setting_r);
        this.mOneHandleModeOptionView.getOptionPreview(2).setBackgroundResource(R.drawable.navigation_bar_sticker_setting_l);
        this.mOneHandleModeOptionView.setOptionSelectListener(this);
        this.mOneHandleModeOptionView.setPreviewHeight(getResources().getDimensionPixelSize(R.dimen.navigationbar_preview_height));
        this.mSmartScreenLearnMore.setOnClickListener(this);
        return this.mRootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
        this.mTriggerSmartScreenMode.setOnCheckedChangeListener(this);
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (r2 != this.mSmartScreenLearnMore) goto L6;
        learnMore();
        return;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r3, boolean r4) {
        if (r3 != this.mTriggerSmartScreenMode.getSwitch()) goto L9;
        if (r4 == false) goto L6;
        showSmartScreenDialog();
    L7:
        SettingsTracker.onSwitcherClick(26030801, r4);
        return;
    L6:
        Settings.Global.putInt(getContentResolver(), SettingsSwitchKeyUtil.SMART_SCREEN_PROTECTOR, 0);
        this.mOneHandleModeOptionView.setVisibility(8);
        goto L7
    }

    @Override // com.android.settings.widget.VerticalOptionsCheckView.OptionSelectListener
    public void onOptionSelected(int r5) {
        boolean r0 = false;
        if (r5 == 0) goto L5;
        int r2 = 1;
    L7:
        if (r5 != 2) goto L9;
        r0 = true;
    L9:
        updateNavbarBackStyle(r0);
        Settings.System.putInt(getContentResolver(), settings.Settings.Global.KEY_REVERSE_NAVIGATION_BAR, r2);
        return;
    L5:
        r2 = 0;
        goto L7
    }

    public void learnMore() {
        Intent r0 = new Intent();
        Uri r1 = Uri.parse("");
        r0.setAction("android.intent.action.VIEW");
        r0.setData(r1);
        startActivity(r0);
    }

    private void showSmartScreenDialog() {
        Intent r0 = new Intent();
        r0.setComponent(new ComponentName(this.mContext, DialogActivity.class));
        r0.putExtra(DialogActivity.DIALOG_TYPE, 2);
        Utils.startActivity(this.mContext, r0);
    }

    private void updateViews() {
        this.mCurrentNavbarLayout = Settings.System.getInt(getContentResolver(), settings.Settings.Global.KEY_REVERSE_NAVIGATION_BAR, 1);
        int r3 = 0;
        int r0 = Settings.Global.getInt(getContentResolver(), SettingsSwitchKeyUtil.SMART_SCREEN_PROTECTOR, 0);
        this.mCurrentSmartScreenState = r0;
        SettingItemSwitch r1 = this.mTriggerSmartScreenMode;
        if (r0 != 1) goto L5;
        boolean r2 = true;
    L6:
        r1.setChecked(r2);
        if (this.mCurrentNavbarLayout != 1) goto L9;
        boolean r4 = true;
    L10:
        updateNavbarBackStyle(r4);
        VerticalOptionsCheckView r5 = this.mOneHandleModeOptionView;
        if (this.mCurrentSmartScreenState == 1) goto L14;
        r3 = 8;
    L14:
        r5.setVisibility(r3);
        return;
    L9:
        r4 = false;
        goto L10
    L5:
        r2 = false;
        goto L6
    }

    private void updateNavbarBackStyle(boolean r1) {
        VerticalOptionsCheckView r0 = this.mOneHandleModeOptionView;
        if (r1 == false) goto L5;
        int r2 = 2;
    L6:
        r0.setCheck(r2);
        return;
    L5:
        r2 = 0;
        goto L6
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_accessibility_SmartScreenFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(SmartScreenFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_accessibility_SmartScreenFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_accessibility_SmartScreenFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(SmartScreenFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_accessibility_SmartScreenFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_accessibility_SmartScreenFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(SmartScreenFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_accessibility_SmartScreenFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
