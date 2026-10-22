package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.lisitem.OListItemSettings;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.SettingItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public final class ObsessionSettingsLayoutBinding implements ViewBinding {
    public final LinearLayout badgeSwipeCleanSettingLayout;
    public final LinearLayout hideBadgeSettingLayout;
    public final ImageView illustrationBadgeSwipeCleanImg;
    public final ImageView illustrationHideBadgeImg;
    public final SettingItemSwitch itemIdBadgeSwipeClean;
    public final SettingItemSwitch itemIdDisplayChargeTime;
    public final SettingItemSwitch itemIdDisplayLargeBattery;
    public final OListItemSettings itemIdDisplayPower;
    public final OListItemSettings itemIdHideAxis;
    public final SettingItemSwitch itemIdHideBadge;
    public final SettingItemSwitch itemIdHideLabel;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final SettingItemSwitch showNetworkSpeed;
    public final View showNetworkSpeedGapBelow;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ObsessionSettingsLayoutBinding(RelativeLayout r3, LinearLayout r4, LinearLayout r5, ImageView r6, ImageView r7, SettingItemSwitch r8, SettingItemSwitch r9, SettingItemSwitch r10, OListItemSettings r11, OListItemSettings r12, SettingItemSwitch r13, SettingItemSwitch r14, LinearLayout r15, OScrollView r16, SettingItemSwitch r17, View r18, OFloatingTitleBar r19) {
        this.rootView = r3;
        this.badgeSwipeCleanSettingLayout = r4;
        this.hideBadgeSettingLayout = r5;
        this.illustrationBadgeSwipeCleanImg = r6;
        this.illustrationHideBadgeImg = r7;
        this.itemIdBadgeSwipeClean = r8;
        this.itemIdDisplayChargeTime = r9;
        this.itemIdDisplayLargeBattery = r10;
        this.itemIdDisplayPower = r11;
        this.itemIdHideAxis = r12;
        this.itemIdHideBadge = r13;
        this.itemIdHideLabel = r14;
        this.pageContainer = r15;
        this.pageScrollview = r16;
        this.showNetworkSpeed = r17;
        this.showNetworkSpeedGapBelow = r18;
        this.viewTitle = r19;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ObsessionSettingsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ObsessionSettingsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.obsession_settings_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ObsessionSettingsLayoutBinding bind(View r21) {
        int r1 = R.id.badge_swipe_clean_setting_layout;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r21, R.id.badge_swipe_clean_setting_layout);
        if (r5 == null) goto L37;
        r1 = R.id.hide_badge_setting_layout;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r21, R.id.hide_badge_setting_layout);
        if (r6 == null) goto L37;
        r1 = R.id.illustration_badge_swipe_clean_img;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(r21, R.id.illustration_badge_swipe_clean_img);
        if (r7 == null) goto L37;
        r1 = R.id.illustration_hide_badge_img;
        ImageView r8 = (ImageView) ViewBindings.findChildViewById(r21, R.id.illustration_hide_badge_img);
        if (r8 == null) goto L37;
        r1 = R.id.item_id_badge_swipe_clean;
        SettingItemSwitch r9 = (SettingItemSwitch) ViewBindings.findChildViewById(r21, R.id.item_id_badge_swipe_clean);
        if (r9 == null) goto L37;
        r1 = R.id.item_id_display_charge_time;
        SettingItemSwitch r10 = (SettingItemSwitch) ViewBindings.findChildViewById(r21, R.id.item_id_display_charge_time);
        if (r10 == null) goto L37;
        r1 = R.id.item_id_display_large_battery;
        SettingItemSwitch r11 = (SettingItemSwitch) ViewBindings.findChildViewById(r21, R.id.item_id_display_large_battery);
        if (r11 == null) goto L37;
        r1 = R.id.item_id_display_power;
        OListItemSettings r12 = (OListItemSettings) ViewBindings.findChildViewById(r21, R.id.item_id_display_power);
        if (r12 == null) goto L37;
        r1 = R.id.item_id_hide_axis;
        OListItemSettings r13 = (OListItemSettings) ViewBindings.findChildViewById(r21, R.id.item_id_hide_axis);
        if (r13 == null) goto L37;
        r1 = R.id.item_id_hide_badge;
        SettingItemSwitch r14 = (SettingItemSwitch) ViewBindings.findChildViewById(r21, R.id.item_id_hide_badge);
        if (r14 == null) goto L37;
        r1 = R.id.item_id_hide_label;
        SettingItemSwitch r15 = (SettingItemSwitch) ViewBindings.findChildViewById(r21, R.id.item_id_hide_label);
        if (r15 == null) goto L37;
        r1 = R.id.page_container;
        LinearLayout r16 = (LinearLayout) ViewBindings.findChildViewById(r21, R.id.page_container);
        if (r16 == null) goto L37;
        r1 = R.id.page_scrollview;
        OScrollView r17 = (OScrollView) ViewBindings.findChildViewById(r21, R.id.page_scrollview);
        if (r17 == null) goto L37;
        r1 = R.id.show_network_speed;
        SettingItemSwitch r18 = (SettingItemSwitch) ViewBindings.findChildViewById(r21, R.id.show_network_speed);
        if (r18 == null) goto L37;
        r1 = R.id.show_network_speed_gap_below;
        View r19 = ViewBindings.findChildViewById(r21, R.id.show_network_speed_gap_below);
        if (r19 == null) goto L37;
        r1 = R.id.view_title;
        OFloatingTitleBar r20 = (OFloatingTitleBar) ViewBindings.findChildViewById(r21, R.id.view_title);
        if (r20 == null) goto L37;
        return new ObsessionSettingsLayoutBinding((RelativeLayout) r21, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20);
    L37:
        throw new NullPointerException("Missing required view with ID: ".concat(r21.getResources().getResourceName(r1)));
    }
}
