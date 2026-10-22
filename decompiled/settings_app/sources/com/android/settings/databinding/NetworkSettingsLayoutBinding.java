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
import com.obric.oui.bouncelayout.ONestedScrollView;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class NetworkSettingsLayoutBinding implements ViewBinding {
    public final OCardListItem chargeButton;
    public final OCardListItem itemCbs;
    public final TextView itemFastTransferTips;
    public final OCardListItem itemNubiaShare;
    public final OCardListItem itemOtgSwitch;
    public final OCardListItem itemUsbTetherConfig;
    public final OCardListItem itemUsbTetherSwitch;
    public final OCardListItem itemVpn;
    public final OCardListItem nfcSetting;
    public final LinearLayout pageContainer;
    public final ONestedScrollView pageScrollview;
    public final OCardListItem personalApp;
    public final OCardListItem print;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;
    public final OCardListItem voipSettingEntry;
    public final ItemSubSettingsPaddingLayout2Binding voipSettingEntryBottom;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private NetworkSettingsLayoutBinding(RelativeLayout r3, OCardListItem r4, OCardListItem r5, TextView r6, OCardListItem r7, OCardListItem r8, OCardListItem r9, OCardListItem r10, OCardListItem r11, OCardListItem r12, LinearLayout r13, ONestedScrollView r14, OCardListItem r15, OCardListItem r16, OFloatingTitleBar r17, OCardListItem r18, ItemSubSettingsPaddingLayout2Binding r19) {
        this.rootView = r3;
        this.chargeButton = r4;
        this.itemCbs = r5;
        this.itemFastTransferTips = r6;
        this.itemNubiaShare = r7;
        this.itemOtgSwitch = r8;
        this.itemUsbTetherConfig = r9;
        this.itemUsbTetherSwitch = r10;
        this.itemVpn = r11;
        this.nfcSetting = r12;
        this.pageContainer = r13;
        this.pageScrollview = r14;
        this.personalApp = r15;
        this.print = r16;
        this.viewTitle = r17;
        this.voipSettingEntry = r18;
        this.voipSettingEntryBottom = r19;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static NetworkSettingsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static NetworkSettingsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.network_settings_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static NetworkSettingsLayoutBinding bind(View r21) {
        int r1 = R.id.charge_button;
        OCardListItem r5 = (OCardListItem) ViewBindings.findChildViewById(r21, R.id.charge_button);
        if (r5 == null) goto L37;
        r1 = R.id.item_cbs;
        OCardListItem r6 = (OCardListItem) ViewBindings.findChildViewById(r21, R.id.item_cbs);
        if (r6 == null) goto L37;
        r1 = R.id.item_fast_transfer_tips;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r21, R.id.item_fast_transfer_tips);
        if (r7 == null) goto L37;
        r1 = R.id.item_nubia_share;
        OCardListItem r8 = (OCardListItem) ViewBindings.findChildViewById(r21, R.id.item_nubia_share);
        if (r8 == null) goto L37;
        r1 = R.id.item_otg_switch;
        OCardListItem r9 = (OCardListItem) ViewBindings.findChildViewById(r21, R.id.item_otg_switch);
        if (r9 == null) goto L37;
        r1 = R.id.item_usb_tether_config;
        OCardListItem r10 = (OCardListItem) ViewBindings.findChildViewById(r21, R.id.item_usb_tether_config);
        if (r10 == null) goto L37;
        r1 = R.id.item_usb_tether_switch;
        OCardListItem r11 = (OCardListItem) ViewBindings.findChildViewById(r21, R.id.item_usb_tether_switch);
        if (r11 == null) goto L37;
        r1 = R.id.item_vpn;
        OCardListItem r12 = (OCardListItem) ViewBindings.findChildViewById(r21, R.id.item_vpn);
        if (r12 == null) goto L37;
        r1 = R.id.nfc_setting;
        OCardListItem r13 = (OCardListItem) ViewBindings.findChildViewById(r21, R.id.nfc_setting);
        if (r13 == null) goto L37;
        r1 = R.id.page_container;
        LinearLayout r14 = (LinearLayout) ViewBindings.findChildViewById(r21, R.id.page_container);
        if (r14 == null) goto L37;
        r1 = R.id.page_scrollview;
        ONestedScrollView r15 = (ONestedScrollView) ViewBindings.findChildViewById(r21, R.id.page_scrollview);
        if (r15 == null) goto L37;
        r1 = R.id.personal_app;
        OCardListItem r16 = (OCardListItem) ViewBindings.findChildViewById(r21, R.id.personal_app);
        if (r16 == null) goto L37;
        r1 = R.id.print;
        OCardListItem r17 = (OCardListItem) ViewBindings.findChildViewById(r21, R.id.print);
        if (r17 == null) goto L37;
        r1 = R.id.view_title;
        OFloatingTitleBar r18 = (OFloatingTitleBar) ViewBindings.findChildViewById(r21, R.id.view_title);
        if (r18 == null) goto L37;
        r1 = R.id.voip_setting_entry;
        OCardListItem r19 = (OCardListItem) ViewBindings.findChildViewById(r21, R.id.voip_setting_entry);
        if (r19 == null) goto L37;
        r1 = R.id.voip_setting_entry_bottom;
        View r2 = ViewBindings.findChildViewById(r21, R.id.voip_setting_entry_bottom);
        if (r2 == null) goto L37;
        RelativeLayout r4 = (RelativeLayout) r21;
        return new NetworkSettingsLayoutBinding(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, ItemSubSettingsPaddingLayout2Binding.bind(r2));
    L37:
        throw new NullPointerException("Missing required view with ID: ".concat(r21.getResources().getResourceName(r1)));
    }
}
