package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class AdvancedAccessPointSettingsFragmentBinding implements ViewBinding {
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    public final OCardListItem proxyExclusionlist;
    public final OCardListItem proxyHostname;
    public final OCardListItem proxyMode;
    public final OCardListItem proxyPort;
    public final OCardListItem proxySettingAuto;
    public final LinearLayout proxySettingAutoContainer;
    public final LinearLayout proxySettingManualContainer;
    private final RelativeLayout rootView;
    public final OCardListItem staticIpAddressSwitch;
    public final OFloatingTitleBar viewTitle;
    public final OCardListItem wifiDns1;
    public final OCardListItem wifiDns2;
    public final OCardListItem wifiGateway;
    public final OCardListItem wifiIpAddress;
    public final OCardListItem wifiNetworkPrefixLen;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private AdvancedAccessPointSettingsFragmentBinding(RelativeLayout r3, LinearLayout r4, OScrollView r5, OCardListItem r6, OCardListItem r7, OCardListItem r8, OCardListItem r9, OCardListItem r10, LinearLayout r11, LinearLayout r12, OCardListItem r13, OFloatingTitleBar r14, OCardListItem r15, OCardListItem r16, OCardListItem r17, OCardListItem r18, OCardListItem r19) {
        this.rootView = r3;
        this.pageContainer = r4;
        this.pageScrollview = r5;
        this.proxyExclusionlist = r6;
        this.proxyHostname = r7;
        this.proxyMode = r8;
        this.proxyPort = r9;
        this.proxySettingAuto = r10;
        this.proxySettingAutoContainer = r11;
        this.proxySettingManualContainer = r12;
        this.staticIpAddressSwitch = r13;
        this.viewTitle = r14;
        this.wifiDns1 = r15;
        this.wifiDns2 = r16;
        this.wifiGateway = r17;
        this.wifiIpAddress = r18;
        this.wifiNetworkPrefixLen = r19;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static AdvancedAccessPointSettingsFragmentBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static AdvancedAccessPointSettingsFragmentBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.advanced_access_point_settings_fragment, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static AdvancedAccessPointSettingsFragmentBinding bind(View r21) {
        int r1 = R.id.page_container;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r21, R.id.page_container);
        if (r5 == null) goto L37;
        r1 = R.id.page_scrollview;
        OScrollView r6 = (OScrollView) ViewBindings.findChildViewById(r21, R.id.page_scrollview);
        if (r6 == null) goto L37;
        r1 = R.id.proxy_exclusionlist;
        OCardListItem r7 = (OCardListItem) ViewBindings.findChildViewById(r21, R.id.proxy_exclusionlist);
        if (r7 == null) goto L37;
        r1 = R.id.proxy_hostname;
        OCardListItem r8 = (OCardListItem) ViewBindings.findChildViewById(r21, R.id.proxy_hostname);
        if (r8 == null) goto L37;
        r1 = R.id.proxy_mode;
        OCardListItem r9 = (OCardListItem) ViewBindings.findChildViewById(r21, R.id.proxy_mode);
        if (r9 == null) goto L37;
        r1 = R.id.proxy_port;
        OCardListItem r10 = (OCardListItem) ViewBindings.findChildViewById(r21, R.id.proxy_port);
        if (r10 == null) goto L37;
        r1 = R.id.proxy_setting_auto;
        OCardListItem r11 = (OCardListItem) ViewBindings.findChildViewById(r21, R.id.proxy_setting_auto);
        if (r11 == null) goto L37;
        r1 = R.id.proxy_setting_auto_container;
        LinearLayout r12 = (LinearLayout) ViewBindings.findChildViewById(r21, R.id.proxy_setting_auto_container);
        if (r12 == null) goto L37;
        r1 = R.id.proxy_setting_manual_container;
        LinearLayout r13 = (LinearLayout) ViewBindings.findChildViewById(r21, R.id.proxy_setting_manual_container);
        if (r13 == null) goto L37;
        r1 = R.id.static_ip_address_switch;
        OCardListItem r14 = (OCardListItem) ViewBindings.findChildViewById(r21, R.id.static_ip_address_switch);
        if (r14 == null) goto L37;
        r1 = R.id.view_title;
        OFloatingTitleBar r15 = (OFloatingTitleBar) ViewBindings.findChildViewById(r21, R.id.view_title);
        if (r15 == null) goto L37;
        r1 = R.id.wifi_dns1;
        OCardListItem r16 = (OCardListItem) ViewBindings.findChildViewById(r21, R.id.wifi_dns1);
        if (r16 == null) goto L37;
        r1 = R.id.wifi_dns2;
        OCardListItem r17 = (OCardListItem) ViewBindings.findChildViewById(r21, R.id.wifi_dns2);
        if (r17 == null) goto L37;
        r1 = R.id.wifi_gateway;
        OCardListItem r18 = (OCardListItem) ViewBindings.findChildViewById(r21, R.id.wifi_gateway);
        if (r18 == null) goto L37;
        r1 = R.id.wifi_ip_address;
        OCardListItem r19 = (OCardListItem) ViewBindings.findChildViewById(r21, R.id.wifi_ip_address);
        if (r19 == null) goto L37;
        r1 = R.id.wifi_network_prefix_len;
        OCardListItem r20 = (OCardListItem) ViewBindings.findChildViewById(r21, R.id.wifi_network_prefix_len);
        if (r20 == null) goto L37;
        return new AdvancedAccessPointSettingsFragmentBinding((RelativeLayout) r21, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20);
    L37:
        throw new NullPointerException("Missing required view with ID: ".concat(r21.getResources().getResourceName(r1)));
    }
}
