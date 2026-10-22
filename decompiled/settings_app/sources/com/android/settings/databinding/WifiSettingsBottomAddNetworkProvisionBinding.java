package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.button.OButton;

/* JADX INFO: loaded from: classes2.dex */
public final class WifiSettingsBottomAddNetworkProvisionBinding implements ViewBinding {
    public final Button addNetwork;
    public final TextView qrTips;
    private final RelativeLayout rootView;
    public final OButton scanQRcode;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private WifiSettingsBottomAddNetworkProvisionBinding(RelativeLayout r1, Button r2, TextView r3, OButton r4) {
        this.rootView = r1;
        this.addNetwork = r2;
        this.qrTips = r3;
        this.scanQRcode = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static WifiSettingsBottomAddNetworkProvisionBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static WifiSettingsBottomAddNetworkProvisionBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.wifi_settings_bottom_add_network_provision, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static WifiSettingsBottomAddNetworkProvisionBinding bind(View r4) {
        int r0 = R.id.add_network;
        Button r1 = (Button) ViewBindings.findChildViewById(r4, R.id.add_network);
        if (r1 == null) goto L11;
        r0 = R.id.qr_tips;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r4, R.id.qr_tips);
        if (r2 == null) goto L11;
        r0 = R.id.scan_QRcode;
        OButton r3 = (OButton) ViewBindings.findChildViewById(r4, R.id.scan_QRcode);
        if (r3 == null) goto L11;
        return new WifiSettingsBottomAddNetworkProvisionBinding((RelativeLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
