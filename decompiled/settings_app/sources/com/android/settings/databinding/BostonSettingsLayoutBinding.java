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
import com.android.settings.widget.SettingItemCheckSimpleText;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.button.OButton;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.SettingItemSwitch;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class BostonSettingsLayoutBinding implements ViewBinding {
    public final SettingItemText aboutBoston;
    public final SettingItemCheckSimpleText chargeAlways;
    public final SettingItemCheckSimpleText chargeCustom;
    public final SettingItemText ota;
    public final GroupListItemVerticalGapLayoutBinding otaGap;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    public final SettingItemSwitch relayMode;
    public final TextView relayTips;
    public final OButton reset;
    public final TextView resetTips;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;
    public final LinearLayout wirelessLayout;
    public final SettingItemText wirelessTntAuto;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private BostonSettingsLayoutBinding(RelativeLayout r1, SettingItemText r2, SettingItemCheckSimpleText r3, SettingItemCheckSimpleText r4, SettingItemText r5, GroupListItemVerticalGapLayoutBinding r6, LinearLayout r7, OScrollView r8, SettingItemSwitch r9, TextView r10, OButton r11, TextView r12, OFloatingTitleBar r13, LinearLayout r14, SettingItemText r15) {
        this.rootView = r1;
        this.aboutBoston = r2;
        this.chargeAlways = r3;
        this.chargeCustom = r4;
        this.ota = r5;
        this.otaGap = r6;
        this.pageContainer = r7;
        this.pageScrollview = r8;
        this.relayMode = r9;
        this.relayTips = r10;
        this.reset = r11;
        this.resetTips = r12;
        this.viewTitle = r13;
        this.wirelessLayout = r14;
        this.wirelessTntAuto = r15;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static BostonSettingsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static BostonSettingsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.boston_settings_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static BostonSettingsLayoutBinding bind(View r19) {
        int r1 = R.id.about_boston;
        SettingItemText r5 = (SettingItemText) ViewBindings.findChildViewById(r19, R.id.about_boston);
        if (r5 == null) goto L33;
        r1 = R.id.charge_always;
        SettingItemCheckSimpleText r6 = (SettingItemCheckSimpleText) ViewBindings.findChildViewById(r19, R.id.charge_always);
        if (r6 == null) goto L33;
        r1 = R.id.charge_custom;
        SettingItemCheckSimpleText r7 = (SettingItemCheckSimpleText) ViewBindings.findChildViewById(r19, R.id.charge_custom);
        if (r7 == null) goto L33;
        r1 = R.id.ota;
        SettingItemText r8 = (SettingItemText) ViewBindings.findChildViewById(r19, R.id.ota);
        if (r8 == null) goto L33;
        r1 = R.id.ota_gap;
        View r2 = ViewBindings.findChildViewById(r19, R.id.ota_gap);
        if (r2 == null) goto L33;
        GroupListItemVerticalGapLayoutBinding r9 = GroupListItemVerticalGapLayoutBinding.bind(r2);
        r1 = R.id.page_container;
        LinearLayout r10 = (LinearLayout) ViewBindings.findChildViewById(r19, R.id.page_container);
        if (r10 == null) goto L33;
        r1 = R.id.page_scrollview;
        OScrollView r11 = (OScrollView) ViewBindings.findChildViewById(r19, R.id.page_scrollview);
        if (r11 == null) goto L33;
        r1 = R.id.relay_mode;
        SettingItemSwitch r12 = (SettingItemSwitch) ViewBindings.findChildViewById(r19, R.id.relay_mode);
        if (r12 == null) goto L33;
        r1 = R.id.relay_tips;
        TextView r13 = (TextView) ViewBindings.findChildViewById(r19, R.id.relay_tips);
        if (r13 == null) goto L33;
        r1 = R.id.reset;
        OButton r14 = (OButton) ViewBindings.findChildViewById(r19, R.id.reset);
        if (r14 == null) goto L33;
        r1 = R.id.reset_tips;
        TextView r15 = (TextView) ViewBindings.findChildViewById(r19, R.id.reset_tips);
        if (r15 == null) goto L33;
        r1 = R.id.view_title;
        OFloatingTitleBar r16 = (OFloatingTitleBar) ViewBindings.findChildViewById(r19, R.id.view_title);
        if (r16 == null) goto L33;
        r1 = R.id.wireless_layout;
        LinearLayout r17 = (LinearLayout) ViewBindings.findChildViewById(r19, R.id.wireless_layout);
        if (r17 == null) goto L33;
        r1 = R.id.wireless_tnt_auto;
        SettingItemText r18 = (SettingItemText) ViewBindings.findChildViewById(r19, R.id.wireless_tnt_auto);
        if (r18 == null) goto L33;
        return new BostonSettingsLayoutBinding((RelativeLayout) r19, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18);
    L33:
        throw new NullPointerException("Missing required view with ID: ".concat(r19.getResources().getResourceName(r1)));
    }
}
