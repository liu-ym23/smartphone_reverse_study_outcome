package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class WifiApiTestActivityBinding implements ViewBinding {
    public final SettingItemText disableNetwork;
    public final SettingItemText disconnect;
    public final SettingItemText enableNetwork;
    public final SettingItemText getConfiguredNetworks;
    public final SettingItemText getConnectionInfo;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private WifiApiTestActivityBinding(RelativeLayout r1, SettingItemText r2, SettingItemText r3, SettingItemText r4, SettingItemText r5, SettingItemText r6, OFloatingTitleBar r7) {
        this.rootView = r1;
        this.disableNetwork = r2;
        this.disconnect = r3;
        this.enableNetwork = r4;
        this.getConfiguredNetworks = r5;
        this.getConnectionInfo = r6;
        this.viewTitle = r7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static WifiApiTestActivityBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static WifiApiTestActivityBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.wifi_api_test_activity, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static WifiApiTestActivityBinding bind(View r10) {
        int r0 = R.id.disable_network;
        SettingItemText r4 = (SettingItemText) ViewBindings.findChildViewById(r10, R.id.disable_network);
        if (r4 == null) goto L17;
        r0 = R.id.disconnect;
        SettingItemText r5 = (SettingItemText) ViewBindings.findChildViewById(r10, R.id.disconnect);
        if (r5 == null) goto L17;
        r0 = R.id.enable_network;
        SettingItemText r6 = (SettingItemText) ViewBindings.findChildViewById(r10, R.id.enable_network);
        if (r6 == null) goto L17;
        r0 = R.id.getConfiguredNetworks;
        SettingItemText r7 = (SettingItemText) ViewBindings.findChildViewById(r10, R.id.getConfiguredNetworks);
        if (r7 == null) goto L17;
        r0 = R.id.getConnectionInfo;
        SettingItemText r8 = (SettingItemText) ViewBindings.findChildViewById(r10, R.id.getConnectionInfo);
        if (r8 == null) goto L17;
        r0 = R.id.view_title;
        OFloatingTitleBar r9 = (OFloatingTitleBar) ViewBindings.findChildViewById(r10, R.id.view_title);
        if (r9 == null) goto L17;
        return new WifiApiTestActivityBinding((RelativeLayout) r10, r4, r5, r6, r7, r8, r9);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }
}
