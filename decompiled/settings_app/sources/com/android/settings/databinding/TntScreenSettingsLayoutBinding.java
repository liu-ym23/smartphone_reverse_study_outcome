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
import com.obric.oui.lisitem.OListItemSettings;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.ListContentItemCheck;
import obric.widget.ListContentItemCustom;
import obric.widget.SettingItemSwitch;
import obric.widget.SettingItemText;
import obric.widget.SliderWithIcons;

/* JADX INFO: loaded from: classes2.dex */
public final class TntScreenSettingsLayoutBinding implements ViewBinding {
    public final GroupListItemVerticalGapLayoutBinding brightnessGap;
    public final ListContentItemCustom brightnessSeekBarCustomLayout;
    public final SliderWithIcons brightnessSeekbar;
    public final ListContentItemCheck id2kDisplay1080p;
    public final ListContentItemCheck id2kDisplay2k;
    public final GroupListItemVerticalGapLayoutBinding id2kDisplayGap;
    public final TextView id2kDisplayTitle;
    public final SettingItemText idScreenColor;
    public final OListItemSettings itemAutoLockScreenTime;
    public final SettingItemText itemDpiSettings;
    public final SettingItemText itemFontScale;
    public final SettingItemText itemProtectEyes;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    public final GroupListItemVerticalGapLayoutBinding protectEyesVerticalGapLayout;
    private final RelativeLayout rootView;
    public final SettingItemSwitch switchReadMode;
    public final TextView switchReadModeTips;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private TntScreenSettingsLayoutBinding(RelativeLayout r3, GroupListItemVerticalGapLayoutBinding r4, ListContentItemCustom r5, SliderWithIcons r6, ListContentItemCheck r7, ListContentItemCheck r8, GroupListItemVerticalGapLayoutBinding r9, TextView r10, SettingItemText r11, OListItemSettings r12, SettingItemText r13, SettingItemText r14, SettingItemText r15, LinearLayout r16, OScrollView r17, GroupListItemVerticalGapLayoutBinding r18, SettingItemSwitch r19, TextView r20, OFloatingTitleBar r21) {
        this.rootView = r3;
        this.brightnessGap = r4;
        this.brightnessSeekBarCustomLayout = r5;
        this.brightnessSeekbar = r6;
        this.id2kDisplay1080p = r7;
        this.id2kDisplay2k = r8;
        this.id2kDisplayGap = r9;
        this.id2kDisplayTitle = r10;
        this.idScreenColor = r11;
        this.itemAutoLockScreenTime = r12;
        this.itemDpiSettings = r13;
        this.itemFontScale = r14;
        this.itemProtectEyes = r15;
        this.pageContainer = r16;
        this.pageScrollview = r17;
        this.protectEyesVerticalGapLayout = r18;
        this.switchReadMode = r19;
        this.switchReadModeTips = r20;
        this.viewTitle = r21;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static TntScreenSettingsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static TntScreenSettingsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.tnt_screen_settings_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static TntScreenSettingsLayoutBinding bind(View r23) {
        int r1 = R.id.brightness_gap;
        View r2 = ViewBindings.findChildViewById(r23, R.id.brightness_gap);
        if (r2 == null) goto L41;
        GroupListItemVerticalGapLayoutBinding r5 = GroupListItemVerticalGapLayoutBinding.bind(r2);
        r1 = R.id.brightness_seek_bar_custom_layout;
        ListContentItemCustom r6 = (ListContentItemCustom) ViewBindings.findChildViewById(r23, R.id.brightness_seek_bar_custom_layout);
        if (r6 == null) goto L41;
        r1 = R.id.brightness_seekbar;
        SliderWithIcons r7 = (SliderWithIcons) ViewBindings.findChildViewById(r23, R.id.brightness_seekbar);
        if (r7 == null) goto L41;
        r1 = R.id.id_2k_display_1080p;
        ListContentItemCheck r8 = (ListContentItemCheck) ViewBindings.findChildViewById(r23, R.id.id_2k_display_1080p);
        if (r8 == null) goto L41;
        r1 = R.id.id_2k_display_2k;
        ListContentItemCheck r9 = (ListContentItemCheck) ViewBindings.findChildViewById(r23, R.id.id_2k_display_2k);
        if (r9 == null) goto L41;
        r1 = R.id.id_2k_display_gap;
        View r3 = ViewBindings.findChildViewById(r23, R.id.id_2k_display_gap);
        if (r3 == null) goto L41;
        GroupListItemVerticalGapLayoutBinding r10 = GroupListItemVerticalGapLayoutBinding.bind(r3);
        r1 = R.id.id_2k_display_title;
        TextView r11 = (TextView) ViewBindings.findChildViewById(r23, R.id.id_2k_display_title);
        if (r11 == null) goto L41;
        r1 = R.id.id_screen_color;
        SettingItemText r12 = (SettingItemText) ViewBindings.findChildViewById(r23, R.id.id_screen_color);
        if (r12 == null) goto L41;
        r1 = R.id.item_auto_lock_screen_time;
        OListItemSettings r13 = (OListItemSettings) ViewBindings.findChildViewById(r23, R.id.item_auto_lock_screen_time);
        if (r13 == null) goto L41;
        r1 = R.id.item_dpi_settings;
        SettingItemText r14 = (SettingItemText) ViewBindings.findChildViewById(r23, R.id.item_dpi_settings);
        if (r14 == null) goto L41;
        r1 = R.id.item_font_scale;
        SettingItemText r15 = (SettingItemText) ViewBindings.findChildViewById(r23, R.id.item_font_scale);
        if (r15 == null) goto L41;
        r1 = R.id.item_protect_eyes;
        SettingItemText r16 = (SettingItemText) ViewBindings.findChildViewById(r23, R.id.item_protect_eyes);
        if (r16 == null) goto L41;
        r1 = R.id.page_container;
        LinearLayout r17 = (LinearLayout) ViewBindings.findChildViewById(r23, R.id.page_container);
        if (r17 == null) goto L41;
        r1 = R.id.page_scrollview;
        OScrollView r18 = (OScrollView) ViewBindings.findChildViewById(r23, R.id.page_scrollview);
        if (r18 == null) goto L41;
        r1 = R.id.protect_eyes_vertical_gap_layout;
        View r4 = ViewBindings.findChildViewById(r23, R.id.protect_eyes_vertical_gap_layout);
        if (r4 == null) goto L41;
        GroupListItemVerticalGapLayoutBinding r19 = GroupListItemVerticalGapLayoutBinding.bind(r4);
        r1 = R.id.switch_read_mode;
        SettingItemSwitch r20 = (SettingItemSwitch) ViewBindings.findChildViewById(r23, R.id.switch_read_mode);
        if (r20 == null) goto L41;
        r1 = R.id.switch_read_mode_tips;
        TextView r21 = (TextView) ViewBindings.findChildViewById(r23, R.id.switch_read_mode_tips);
        if (r21 == null) goto L41;
        r1 = R.id.view_title;
        OFloatingTitleBar r22 = (OFloatingTitleBar) ViewBindings.findChildViewById(r23, R.id.view_title);
        if (r22 == null) goto L41;
        return new TntScreenSettingsLayoutBinding((RelativeLayout) r23, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    L41:
        throw new NullPointerException("Missing required view with ID: ".concat(r23.getResources().getResourceName(r1)));
    }
}
