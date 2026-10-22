package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.lisitem.OListItemSettings;
import obric.widget.SettingItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public final class IncludeEldershipModeSettingsBinding implements ViewBinding {
    public final LinearLayout eldershipAllSettings;
    public final TextView eldershipModeTips;
    public final OListItemSettings itemFontSize;
    public final OListItemSettings itemHandInHand;
    public final OListItemSettings itemLauncherGrids;
    public final OListItemSettings itemRingtone;
    public final OListItemSettings itemScreenZoom;
    public final SettingItemSwitch itemSwitchIdeaPills;
    public final OListItemSettings itemSwitchMuteDoubleCheck;
    public final SettingItemSwitch itemSwitchOneStep;
    public final SettingItemSwitch itemSwitchTextBoom;
    private final LinearLayout rootView;
    public final TextView shortcutContactsTips;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private IncludeEldershipModeSettingsBinding(LinearLayout r1, LinearLayout r2, TextView r3, OListItemSettings r4, OListItemSettings r5, OListItemSettings r6, OListItemSettings r7, OListItemSettings r8, SettingItemSwitch r9, OListItemSettings r10, SettingItemSwitch r11, SettingItemSwitch r12, TextView r13) {
        this.rootView = r1;
        this.eldershipAllSettings = r2;
        this.eldershipModeTips = r3;
        this.itemFontSize = r4;
        this.itemHandInHand = r5;
        this.itemLauncherGrids = r6;
        this.itemRingtone = r7;
        this.itemScreenZoom = r8;
        this.itemSwitchIdeaPills = r9;
        this.itemSwitchMuteDoubleCheck = r10;
        this.itemSwitchOneStep = r11;
        this.itemSwitchTextBoom = r12;
        this.shortcutContactsTips = r13;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static IncludeEldershipModeSettingsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static IncludeEldershipModeSettingsBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.include_eldership_mode_settings, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static IncludeEldershipModeSettingsBinding bind(View r14) {
        LinearLayout r2 = (LinearLayout) r14;
        int r0 = R.id.eldership_mode_tips;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r14, R.id.eldership_mode_tips);
        if (r3 == null) goto L27;
        r0 = R.id.item_font_size;
        OListItemSettings r4 = (OListItemSettings) ViewBindings.findChildViewById(r14, R.id.item_font_size);
        if (r4 == null) goto L27;
        r0 = R.id.item_hand_in_hand;
        OListItemSettings r5 = (OListItemSettings) ViewBindings.findChildViewById(r14, R.id.item_hand_in_hand);
        if (r5 == null) goto L27;
        r0 = R.id.item_launcher_grids;
        OListItemSettings r6 = (OListItemSettings) ViewBindings.findChildViewById(r14, R.id.item_launcher_grids);
        if (r6 == null) goto L27;
        r0 = R.id.item_ringtone;
        OListItemSettings r7 = (OListItemSettings) ViewBindings.findChildViewById(r14, R.id.item_ringtone);
        if (r7 == null) goto L27;
        r0 = R.id.item_screen_zoom;
        OListItemSettings r8 = (OListItemSettings) ViewBindings.findChildViewById(r14, R.id.item_screen_zoom);
        if (r8 == null) goto L27;
        r0 = R.id.item_switch_idea_pills;
        SettingItemSwitch r9 = (SettingItemSwitch) ViewBindings.findChildViewById(r14, R.id.item_switch_idea_pills);
        if (r9 == null) goto L27;
        r0 = R.id.item_switch_mute_double_check;
        OListItemSettings r10 = (OListItemSettings) ViewBindings.findChildViewById(r14, R.id.item_switch_mute_double_check);
        if (r10 == null) goto L27;
        r0 = R.id.item_switch_one_step;
        SettingItemSwitch r11 = (SettingItemSwitch) ViewBindings.findChildViewById(r14, R.id.item_switch_one_step);
        if (r11 == null) goto L27;
        r0 = R.id.item_switch_text_boom;
        SettingItemSwitch r12 = (SettingItemSwitch) ViewBindings.findChildViewById(r14, R.id.item_switch_text_boom);
        if (r12 == null) goto L27;
        r0 = R.id.shortcut_contacts_tips;
        TextView r13 = (TextView) ViewBindings.findChildViewById(r14, R.id.shortcut_contacts_tips);
        if (r13 == null) goto L27;
        return new IncludeEldershipModeSettingsBinding(r2, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    L27:
        throw new NullPointerException("Missing required view with ID: ".concat(r14.getResources().getResourceName(r0)));
    }
}
