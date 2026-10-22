package com.android.settings;

import android.app.SmtPCUtils;
import android.content.ContentResolver;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.android.settings.base.BaseFragment;
import com.android.settings.http.ResultHandle;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OListItemSettings;
import com.obric.oui.oswitch.OSwitch;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.app.settings.search.SettingsSwitchKeyUtil;
import obric.widget.SettingItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public class ObsessionModeFragment extends BaseFragment implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    private static final int BATTERY_STYLE_NORMAL = 0;
    private static final int BYTEDANCE_BATTERY_PERCENTAGE_STYLE = 3;
    private View mBadgeSwipeCleanSettingView;
    private PreviewSettingItemView mClassicKeypadMode;
    private View mHideBadgeSettingView;
    private PreviewSettingItemView mImproveKeypadMode;
    private SettingItemSwitch mItemBadgeSwipeClean;
    private SettingItemSwitch mItemDisplayChargeTime;
    private SettingItemSwitch mItemDisplayLargeBattery;
    private OListItemSettings mItemDisplayPower;
    private OSwitch mItemDisplayPowerSwitch;
    private OListItemSettings mItemHideAxis;
    private OSwitch mItemHideAxisSwitch;
    private SettingItemSwitch mItemHideBadge;
    private SettingItemSwitch mItemHideLabel;
    private SettingItemSwitch mShowNetworkSpeed;

    public void com_android_settings_ObsessionModeFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_ObsessionModeFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_ObsessionModeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_ObsessionModeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public ObsessionModeFragment() {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.obsession_settings_layout, r3, false);
        this.mItemDisplayPower = (OListItemSettings) findViewByIdNullable(R.id.item_id_display_power);
        OSwitch r5 = new OSwitch(this.mContext);
        this.mItemDisplayPowerSwitch = r5;
        r5.setClickable(true);
        this.mItemDisplayPower.setTrailingView(this.mItemDisplayPowerSwitch);
        this.mItemDisplayChargeTime = (SettingItemSwitch) findViewByIdNullable(R.id.item_id_display_charge_time);
        this.mItemDisplayLargeBattery = (SettingItemSwitch) findViewByIdNullable(R.id.item_id_display_large_battery);
        this.mShowNetworkSpeed = (SettingItemSwitch) findViewByIdNullable(R.id.show_network_speed);
        this.mItemHideLabel = (SettingItemSwitch) findViewByIdNullable(R.id.item_id_hide_label);
        this.mItemHideBadge = (SettingItemSwitch) findViewByIdNullable(R.id.item_id_hide_badge);
        this.mItemBadgeSwipeClean = (SettingItemSwitch) findViewByIdNullable(R.id.item_id_badge_swipe_clean);
        this.mItemHideAxis = (OListItemSettings) findViewByIdNullable(R.id.item_id_hide_axis);
        OSwitch r6 = new OSwitch(this.mContext);
        this.mItemHideAxisSwitch = r6;
        r6.setClickable(true);
        this.mItemHideAxis.setTrailingView(this.mItemHideAxisSwitch);
        this.mBadgeSwipeCleanSettingView = findViewByIdNullable(R.id.badge_swipe_clean_setting_layout);
        this.mHideBadgeSettingView = findViewByIdNullable(R.id.hide_badge_setting_layout);
        PreviewSettingItemView r7 = (PreviewSettingItemView) findViewByIdNullable(R.id.item_preview_left);
        this.mClassicKeypadMode = r7;
        r7.setOnClickListener(this);
        this.mClassicKeypadMode.setTitle(getString(R.string.keypad_mode_classic));
        PreviewSettingItemView r8 = (PreviewSettingItemView) findViewByIdNullable(R.id.item_preview_right);
        this.mImproveKeypadMode = r8;
        r8.setOnClickListener(this);
        this.mImproveKeypadMode.setTitle(getString(R.string.keypad_mode_improve));
        ((TextView) findViewByIdNullable(R.id.text_item_title)).setText(R.string.keypad_mode);
        if (SettingsFeature.OBSESSION_DISPLAY_LARGE_BATTERY_IN_LOCKSCREEN == false) goto L6;
        this.mItemDisplayLargeBattery.setVisibility(0);
    L6:
        if (this.mIsExtDisplaying == false) goto L11;
        this.mItemDisplayLargeBattery.setVisibility(8);
        if (SmtPCUtils.isTntDisplay() == true) goto L11;
        setSwipeCleanViewVisibility(8);
    L11:
        return this.mRootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
        this.mItemDisplayPowerSwitch.setOnCheckedChangeListener(this);
        this.mItemDisplayChargeTime.setOnCheckedChangeListener(this);
        this.mItemDisplayLargeBattery.setOnCheckedChangeListener(this);
        this.mShowNetworkSpeed.setOnCheckedChangeListener(this);
        this.mItemHideLabel.setOnCheckedChangeListener(this);
        this.mItemHideBadge.setOnCheckedChangeListener(this);
        this.mItemBadgeSwipeClean.setOnCheckedChangeListener(this);
        this.mItemHideAxisSwitch.setOnCheckedChangeListener(this);
    }

    private boolean hideBadge() {
        String r1 = android.provider.Settings.System.getString(getContentResolver(), "launcher_hide_badge");
        if (r1 != null) goto L7;
        return false;
    L7:
        return Boolean.parseBoolean(r1);
    }

    private void updateViews() {
        ContentResolver r0 = getContentResolver();
        this.mItemHideLabel.setChecked(Boolean.parseBoolean(android.provider.Settings.System.getString(r0, "launcher_hide_lable")));
        this.mItemHideBadge.setChecked(hideBadge());
        Utils.isThirdPartHome(this.mContext);
        setSwipeCleanViewVisibility(8);
        this.mHideBadgeSettingView.setVisibility(8);
        this.mItemHideLabel.setVisibility(8);
        this.mItemBadgeSwipeClean.setChecked(Boolean.parseBoolean(android.provider.Settings.System.getString(r0, "launcher_badge_swipe_clean")));
        this.mItemDisplayChargeTime.setChecked(Boolean.parseBoolean(android.provider.Settings.System.getString(r0, "display_charge_remain_time")));
        boolean r3 = true;
        if (android.provider.Settings.Global.getInt(r0, "display_large_battery_in_lockscreen", 1) != 1) goto L5;
        boolean r2 = true;
    L6:
        this.mItemDisplayLargeBattery.setChecked(r2);
        SettingItemSwitch r4 = this.mShowNetworkSpeed;
        if (android.provider.Settings.Global.getInt(r0, "show_network_speed", 0) != 1) goto L9;
        boolean r5 = true;
    L10:
        r4.setChecked(r5);
        if (android.provider.Settings.System.getInt(getContentResolver(), "status_bar_show_battery_percent", 0) != 1) goto L13;
        this.mItemDisplayPowerSwitch.setChecked(true);
    L14:
        OSwitch r6 = this.mItemHideAxisSwitch;
        if (android.provider.Settings.System.getInt(r0, SettingsSwitchKeyUtil.FACE_RECOGNITION_ENABLED, 1) == 0) goto L18;
        r3 = false;
    L18:
        r6.setChecked(r3);
        if (this.mIsExtDisplaying == false) goto L23;
        this.mShowNetworkSpeed.setVisibility(8);
        View r1 = findViewByIdNullable(R.id.show_network_speed_gap_below);
        if (r1 == null) goto L23;
        r1.setVisibility(8);
    L23:
        updateContactItems();
        return;
    L13:
        this.mItemDisplayPowerSwitch.setChecked(false);
        goto L14
    L9:
        r5 = false;
        goto L10
    L5:
        r2 = false;
        goto L6
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    public void updateContactItems() {
        boolean r2 = false;
        if (android.provider.Settings.Global.getInt(getContentResolver(), "contacts_dialpad_change_layout", 0) != 1) goto L5;
        boolean r0 = true;
    L6:
        this.mClassicKeypadMode.setChecked(!r0);
        this.mClassicKeypadMode.setPreview(getResources().getDrawable(R.drawable.keypad_mode_left));
        this.mImproveKeypadMode.setChecked(r0);
        if (android.provider.Settings.Global.getInt(getContentResolver(), "contacts_dialpad_left_mode", 1) != 1) goto L9;
        r2 = true;
    L9:
        PreviewSettingItemView r1 = this.mImproveKeypadMode;
        Resources r6 = getResources();
        if (r2 == false) goto L12;
        int r3 = R.drawable.keypad_mode_improve_left;
    L13:
        r1.setPreview(r6.getDrawable(r3));
        return;
    L12:
        r3 = R.drawable.keypad_mode_improve_right;
        goto L13
    L5:
        r0 = false;
        goto L6
    }

    private void setSwipeCleanViewVisibility(int r1) {
        this.mBadgeSwipeCleanSettingView.setVisibility(r1);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r3, boolean r4) {
        ContentResolver r0 = getContentResolver();
        if (this.mItemHideLabel.getSwitch() != r3) goto L6;
        android.provider.Settings.System.putString(r0, "launcher_hide_lable", Boolean.toString(r4));
        SettingsTracker.onSwitcherClick(1303, r4);
        return;
    L6:
        if (this.mItemHideBadge.getSwitch() != r3) goto L9;
        android.provider.Settings.System.putString(r0, "launcher_hide_badge", Boolean.toString(r4));
        SettingsTracker.onSwitcherClick(1304, r4);
        setSwipeCleanViewVisibility(8);
        return;
    L9:
        if (this.mItemBadgeSwipeClean.getSwitch() != r3) goto L12;
        android.provider.Settings.System.putString(r0, "launcher_badge_swipe_clean", Boolean.toString(r4));
        SettingsTracker.onSwitcherClick(1305, r4);
        return;
    L12:
        if (this.mItemDisplayPowerSwitch != r3) goto L19;
        if (r4 == false) goto L16;
        android.provider.Settings.System.putInt(getContentResolver(), "status_bar_show_battery_percent", 1);
    L17:
        SettingsTracker.onSwitcherClick(EntityType.DOUBAO_ACCOUNT, r4);
        return;
    L16:
        android.provider.Settings.System.putInt(getContentResolver(), "status_bar_show_battery_percent", 0);
        goto L17
    L19:
        if (this.mItemDisplayChargeTime.getSwitch() != r3) goto L22;
        android.provider.Settings.System.putString(r0, "display_charge_remain_time", Boolean.toString(r4));
        return;
    L22:
        if (this.mItemHideAxisSwitch != r3) goto L25;
        android.provider.Settings.System.putInt(r0, SettingsSwitchKeyUtil.FACE_RECOGNITION_ENABLED, !r4 ? 1 : 0);
        SettingsTracker.onSwitcherClick(1306, r4);
        return;
    L25:
        if (this.mItemDisplayLargeBattery.getSwitch() != r3) goto L28;
        android.provider.Settings.Global.putInt(r0, "display_large_battery_in_lockscreen", r4 ? 1 : 0);
        SettingsTracker.onSwitcherClick(ResultHandle.RESULT_CODE_CAPTCHA_ERROR, r4);
        return;
    L28:
        if (this.mShowNetworkSpeed.getSwitch() != r3) goto L38;
        android.provider.Settings.Global.putInt(r0, "show_network_speed", r4 ? 1 : 0);
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r5) {
        if (r5 != this.mClassicKeypadMode) goto L5;
        android.provider.Settings.Global.putInt(getContentResolver(), "contacts_dialpad_change_layout", 0);
        this.mClassicKeypadMode.setChecked(true);
        this.mImproveKeypadMode.setChecked(false);
        return;
    L5:
        android.provider.Settings.Global.putInt(getContentResolver(), "contacts_dialpad_change_layout", 1);
        this.mClassicKeypadMode.setChecked(false);
        this.mImproveKeypadMode.setChecked(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        SettingsTracker.trackObsessionSettings(this.mContext);
        super.onDestroy();
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_ObsessionModeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ObsessionModeFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_ObsessionModeFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_ObsessionModeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ObsessionModeFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_ObsessionModeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_ObsessionModeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ObsessionModeFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_ObsessionModeFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
