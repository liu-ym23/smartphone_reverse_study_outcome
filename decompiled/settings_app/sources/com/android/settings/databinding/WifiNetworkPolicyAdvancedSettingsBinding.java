package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.SettingItemSwitch;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class WifiNetworkPolicyAdvancedSettingsBinding implements ViewBinding {
    public final SettingItemSwitch autoConnect;
    public final SettingItemText macAddress;
    public final SettingItemText mobileToWlanPolicy;
    public final SettingItemSwitch networkHandoverSwitch;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private WifiNetworkPolicyAdvancedSettingsBinding(RelativeLayout r1, SettingItemSwitch r2, SettingItemText r3, SettingItemText r4, SettingItemSwitch r5, OFloatingTitleBar r6) {
        this.rootView = r1;
        this.autoConnect = r2;
        this.macAddress = r3;
        this.mobileToWlanPolicy = r4;
        this.networkHandoverSwitch = r5;
        this.viewTitle = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static WifiNetworkPolicyAdvancedSettingsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static WifiNetworkPolicyAdvancedSettingsBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.wifi_network_policy_advanced_settings, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static WifiNetworkPolicyAdvancedSettingsBinding bind(View r9) {
        int r0 = R.id.auto_connect;
        SettingItemSwitch r4 = (SettingItemSwitch) ViewBindings.findChildViewById(r9, R.id.auto_connect);
        if (r4 == null) goto L15;
        r0 = R.id.mac_address;
        SettingItemText r5 = (SettingItemText) ViewBindings.findChildViewById(r9, R.id.mac_address);
        if (r5 == null) goto L15;
        r0 = R.id.mobile_to_wlan_policy;
        SettingItemText r6 = (SettingItemText) ViewBindings.findChildViewById(r9, R.id.mobile_to_wlan_policy);
        if (r6 == null) goto L15;
        r0 = R.id.network_handover_switch;
        SettingItemSwitch r7 = (SettingItemSwitch) ViewBindings.findChildViewById(r9, R.id.network_handover_switch);
        if (r7 == null) goto L15;
        r0 = R.id.view_title;
        OFloatingTitleBar r8 = (OFloatingTitleBar) ViewBindings.findChildViewById(r9, R.id.view_title);
        if (r8 == null) goto L15;
        return new WifiNetworkPolicyAdvancedSettingsBinding((RelativeLayout) r9, r4, r5, r6, r7, r8);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }
}
