package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.SettingItemSwitch;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class FragmentGameModeSettingsBinding implements ViewBinding {
    public final TextView gameModeAccelerateTips;
    public final TextView gameModeLockAutoBrightnessTips;
    public final TextView gameModeNavBarBtnForbiddenTips;
    public final TextView gameModeTips;
    public final SettingItemText gameNetworkAcceleration;
    public final TextView gameNetworkAccelerationTips;
    public final SettingItemSwitch highPerformanceMode;
    public final TextView highPerformanceModeTips;
    public final TextView improvementOptionsTitle;
    public final SettingItemSwitch itemSwitchGameMode;
    public final SettingItemSwitch itemSwitchGameModeAccelerate;
    public final SettingItemSwitch itemSwitchGameModeLockAutoBrightness;
    public final SettingItemSwitch itemSwitchGameModeNavBarBtnForbidden;
    public final SettingItemSwitch itemSwitchGameModeNoDisturb;
    public final TextView itemSwitchGameModeNoDisturbTips;
    public final SettingItemSwitch itemSwitchGameModeShortcutKeyForbidden;
    public final TextView itemSwitchGameModeShortcutKeyForbiddenTip;
    public final LinearLayout llSubContainer;
    public final SettingItemSwitch messageBarrageNotification;
    public final TextView messageBarrageNotificationTips;
    public final SettingItemSwitch networkProtection;
    public final TextView networkProtectionTips;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    public final TextView performance;
    public final SettingItemText rejectCallsMenu;
    public final TextView rejectCallsTips;
    private final RelativeLayout rootView;
    public final SettingItemSwitch shieldedStatusBarNotification;
    public final TextView shieldedStatusBarNotificationTips;
    public final SettingItemText sideBarMenu;
    public final TextView sideBarMenuTips;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private FragmentGameModeSettingsBinding(RelativeLayout r3, TextView r4, TextView r5, TextView r6, TextView r7, SettingItemText r8, TextView r9, SettingItemSwitch r10, TextView r11, TextView r12, SettingItemSwitch r13, SettingItemSwitch r14, SettingItemSwitch r15, SettingItemSwitch r16, SettingItemSwitch r17, TextView r18, SettingItemSwitch r19, TextView r20, LinearLayout r21, SettingItemSwitch r22, TextView r23, SettingItemSwitch r24, TextView r25, LinearLayout r26, OScrollView r27, TextView r28, SettingItemText r29, TextView r30, SettingItemSwitch r31, TextView r32, SettingItemText r33, TextView r34, OFloatingTitleBar r35) {
        this.rootView = r3;
        this.gameModeAccelerateTips = r4;
        this.gameModeLockAutoBrightnessTips = r5;
        this.gameModeNavBarBtnForbiddenTips = r6;
        this.gameModeTips = r7;
        this.gameNetworkAcceleration = r8;
        this.gameNetworkAccelerationTips = r9;
        this.highPerformanceMode = r10;
        this.highPerformanceModeTips = r11;
        this.improvementOptionsTitle = r12;
        this.itemSwitchGameMode = r13;
        this.itemSwitchGameModeAccelerate = r14;
        this.itemSwitchGameModeLockAutoBrightness = r15;
        this.itemSwitchGameModeNavBarBtnForbidden = r16;
        this.itemSwitchGameModeNoDisturb = r17;
        this.itemSwitchGameModeNoDisturbTips = r18;
        this.itemSwitchGameModeShortcutKeyForbidden = r19;
        this.itemSwitchGameModeShortcutKeyForbiddenTip = r20;
        this.llSubContainer = r21;
        this.messageBarrageNotification = r22;
        this.messageBarrageNotificationTips = r23;
        this.networkProtection = r24;
        this.networkProtectionTips = r25;
        this.pageContainer = r26;
        this.pageScrollview = r27;
        this.performance = r28;
        this.rejectCallsMenu = r29;
        this.rejectCallsTips = r30;
        this.shieldedStatusBarNotification = r31;
        this.shieldedStatusBarNotificationTips = r32;
        this.sideBarMenu = r33;
        this.sideBarMenuTips = r34;
        this.viewTitle = r35;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentGameModeSettingsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static FragmentGameModeSettingsBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.fragment_game_mode_settings, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static FragmentGameModeSettingsBinding bind(View r37) {
        int r1 = R.id.game_mode_accelerate_tips;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r37, R.id.game_mode_accelerate_tips);
        if (r5 == null) goto L69;
        r1 = R.id.game_mode_lock_auto_brightness_tips;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r37, R.id.game_mode_lock_auto_brightness_tips);
        if (r6 == null) goto L69;
        r1 = R.id.game_mode_nav_bar_btn_forbidden_tips;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r37, R.id.game_mode_nav_bar_btn_forbidden_tips);
        if (r7 == null) goto L69;
        r1 = R.id.game_mode_tips;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r37, R.id.game_mode_tips);
        if (r8 == null) goto L69;
        r1 = R.id.game_network_acceleration;
        SettingItemText r9 = (SettingItemText) ViewBindings.findChildViewById(r37, R.id.game_network_acceleration);
        if (r9 == null) goto L69;
        r1 = R.id.game_network_acceleration_tips;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r37, R.id.game_network_acceleration_tips);
        if (r10 == null) goto L69;
        r1 = R.id.high_performance_mode;
        SettingItemSwitch r11 = (SettingItemSwitch) ViewBindings.findChildViewById(r37, R.id.high_performance_mode);
        if (r11 == null) goto L69;
        r1 = R.id.high_performance_mode_tips;
        TextView r12 = (TextView) ViewBindings.findChildViewById(r37, R.id.high_performance_mode_tips);
        if (r12 == null) goto L69;
        r1 = R.id.improvement_options_title;
        TextView r13 = (TextView) ViewBindings.findChildViewById(r37, R.id.improvement_options_title);
        if (r13 == null) goto L69;
        r1 = R.id.item_switch_game_mode;
        SettingItemSwitch r14 = (SettingItemSwitch) ViewBindings.findChildViewById(r37, R.id.item_switch_game_mode);
        if (r14 == null) goto L69;
        r1 = R.id.item_switch_game_mode_accelerate;
        SettingItemSwitch r15 = (SettingItemSwitch) ViewBindings.findChildViewById(r37, R.id.item_switch_game_mode_accelerate);
        if (r15 == null) goto L69;
        r1 = R.id.item_switch_game_mode_lock_auto_brightness;
        SettingItemSwitch r16 = (SettingItemSwitch) ViewBindings.findChildViewById(r37, R.id.item_switch_game_mode_lock_auto_brightness);
        if (r16 == null) goto L69;
        r1 = R.id.item_switch_game_mode_nav_bar_btn_forbidden;
        SettingItemSwitch r17 = (SettingItemSwitch) ViewBindings.findChildViewById(r37, R.id.item_switch_game_mode_nav_bar_btn_forbidden);
        if (r17 == null) goto L69;
        r1 = R.id.item_switch_game_mode_no_disturb;
        SettingItemSwitch r18 = (SettingItemSwitch) ViewBindings.findChildViewById(r37, R.id.item_switch_game_mode_no_disturb);
        if (r18 == null) goto L69;
        r1 = R.id.item_switch_game_mode_no_disturb_tips;
        TextView r19 = (TextView) ViewBindings.findChildViewById(r37, R.id.item_switch_game_mode_no_disturb_tips);
        if (r19 == null) goto L69;
        r1 = R.id.item_switch_game_mode_shortcut_key_forbidden;
        SettingItemSwitch r20 = (SettingItemSwitch) ViewBindings.findChildViewById(r37, R.id.item_switch_game_mode_shortcut_key_forbidden);
        if (r20 == null) goto L69;
        r1 = R.id.item_switch_game_mode_shortcut_key_forbidden_tip;
        TextView r21 = (TextView) ViewBindings.findChildViewById(r37, R.id.item_switch_game_mode_shortcut_key_forbidden_tip);
        if (r21 == null) goto L69;
        r1 = R.id.ll_sub_container;
        LinearLayout r22 = (LinearLayout) ViewBindings.findChildViewById(r37, R.id.ll_sub_container);
        if (r22 == null) goto L69;
        r1 = R.id.message_barrage_notification;
        SettingItemSwitch r23 = (SettingItemSwitch) ViewBindings.findChildViewById(r37, R.id.message_barrage_notification);
        if (r23 == null) goto L69;
        r1 = R.id.message_barrage_notification_tips;
        TextView r24 = (TextView) ViewBindings.findChildViewById(r37, R.id.message_barrage_notification_tips);
        if (r24 == null) goto L69;
        r1 = R.id.network_protection;
        SettingItemSwitch r25 = (SettingItemSwitch) ViewBindings.findChildViewById(r37, R.id.network_protection);
        if (r25 == null) goto L69;
        r1 = R.id.network_protection_tips;
        TextView r26 = (TextView) ViewBindings.findChildViewById(r37, R.id.network_protection_tips);
        if (r26 == null) goto L69;
        r1 = R.id.page_container;
        LinearLayout r27 = (LinearLayout) ViewBindings.findChildViewById(r37, R.id.page_container);
        if (r27 == null) goto L69;
        r1 = R.id.page_scrollview;
        OScrollView r28 = (OScrollView) ViewBindings.findChildViewById(r37, R.id.page_scrollview);
        if (r28 == null) goto L69;
        r1 = R.id.performance;
        TextView r29 = (TextView) ViewBindings.findChildViewById(r37, R.id.performance);
        if (r29 == null) goto L69;
        r1 = R.id.reject_calls_menu;
        SettingItemText r30 = (SettingItemText) ViewBindings.findChildViewById(r37, R.id.reject_calls_menu);
        if (r30 == null) goto L69;
        r1 = R.id.reject_calls_tips;
        TextView r31 = (TextView) ViewBindings.findChildViewById(r37, R.id.reject_calls_tips);
        if (r31 == null) goto L69;
        r1 = R.id.shielded_status_bar_notification;
        SettingItemSwitch r32 = (SettingItemSwitch) ViewBindings.findChildViewById(r37, R.id.shielded_status_bar_notification);
        if (r32 == null) goto L69;
        r1 = R.id.shielded_status_bar_notification_tips;
        TextView r33 = (TextView) ViewBindings.findChildViewById(r37, R.id.shielded_status_bar_notification_tips);
        if (r33 == null) goto L69;
        r1 = R.id.side_bar_menu;
        SettingItemText r34 = (SettingItemText) ViewBindings.findChildViewById(r37, R.id.side_bar_menu);
        if (r34 == null) goto L69;
        r1 = R.id.side_bar_menu_tips;
        TextView r35 = (TextView) ViewBindings.findChildViewById(r37, R.id.side_bar_menu_tips);
        if (r35 == null) goto L69;
        r1 = R.id.view_title;
        OFloatingTitleBar r36 = (OFloatingTitleBar) ViewBindings.findChildViewById(r37, R.id.view_title);
        if (r36 == null) goto L69;
        return new FragmentGameModeSettingsBinding((RelativeLayout) r37, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36);
    L69:
        throw new NullPointerException("Missing required view with ID: ".concat(r37.getResources().getResourceName(r1)));
    }
}
