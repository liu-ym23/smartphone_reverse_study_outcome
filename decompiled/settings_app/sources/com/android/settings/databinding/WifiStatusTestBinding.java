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
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class WifiStatusTestBinding implements ViewBinding {
    public final TextView bssid;
    public final TextView hiddenSsid;
    public final TextView httpClientTest;
    public final TextView ipaddr;
    public final TextView linkSpeed;
    public final TextView macaddr;
    public final TextView networkState;
    public final TextView networkid;
    public final TextView pingHostname;
    public final Button pingTest;
    private final RelativeLayout rootView;
    public final TextView rssi;
    public final TextView scanList;
    public final TextView ssid;
    public final TextView supplicantState;
    public final Button update;
    public final OFloatingTitleBar viewTitle;
    public final TextView wifiState;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private WifiStatusTestBinding(RelativeLayout r3, TextView r4, TextView r5, TextView r6, TextView r7, TextView r8, TextView r9, TextView r10, TextView r11, TextView r12, Button r13, TextView r14, TextView r15, TextView r16, TextView r17, Button r18, OFloatingTitleBar r19, TextView r20) {
        this.rootView = r3;
        this.bssid = r4;
        this.hiddenSsid = r5;
        this.httpClientTest = r6;
        this.ipaddr = r7;
        this.linkSpeed = r8;
        this.macaddr = r9;
        this.networkState = r10;
        this.networkid = r11;
        this.pingHostname = r12;
        this.pingTest = r13;
        this.rssi = r14;
        this.scanList = r15;
        this.ssid = r16;
        this.supplicantState = r17;
        this.update = r18;
        this.viewTitle = r19;
        this.wifiState = r20;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static WifiStatusTestBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static WifiStatusTestBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.wifi_status_test, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static WifiStatusTestBinding bind(View r22) {
        int r1 = R.id.bssid;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r22, R.id.bssid);
        if (r5 == null) goto L39;
        r1 = R.id.hidden_ssid;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r22, R.id.hidden_ssid);
        if (r6 == null) goto L39;
        r1 = R.id.httpClientTest;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r22, R.id.httpClientTest);
        if (r7 == null) goto L39;
        r1 = R.id.ipaddr;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r22, R.id.ipaddr);
        if (r8 == null) goto L39;
        r1 = R.id.link_speed;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r22, R.id.link_speed);
        if (r9 == null) goto L39;
        r1 = R.id.macaddr;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r22, R.id.macaddr);
        if (r10 == null) goto L39;
        r1 = R.id.network_state;
        TextView r11 = (TextView) ViewBindings.findChildViewById(r22, R.id.network_state);
        if (r11 == null) goto L39;
        r1 = R.id.networkid;
        TextView r12 = (TextView) ViewBindings.findChildViewById(r22, R.id.networkid);
        if (r12 == null) goto L39;
        r1 = R.id.pingHostname;
        TextView r13 = (TextView) ViewBindings.findChildViewById(r22, R.id.pingHostname);
        if (r13 == null) goto L39;
        r1 = R.id.ping_test;
        Button r14 = (Button) ViewBindings.findChildViewById(r22, R.id.ping_test);
        if (r14 == null) goto L39;
        r1 = R.id.rssi;
        TextView r15 = (TextView) ViewBindings.findChildViewById(r22, R.id.rssi);
        if (r15 == null) goto L39;
        r1 = R.id.scan_list;
        TextView r16 = (TextView) ViewBindings.findChildViewById(r22, R.id.scan_list);
        if (r16 == null) goto L39;
        r1 = R.id.ssid;
        TextView r17 = (TextView) ViewBindings.findChildViewById(r22, R.id.ssid);
        if (r17 == null) goto L39;
        r1 = R.id.supplicant_state;
        TextView r18 = (TextView) ViewBindings.findChildViewById(r22, R.id.supplicant_state);
        if (r18 == null) goto L39;
        r1 = R.id.update;
        Button r19 = (Button) ViewBindings.findChildViewById(r22, R.id.update);
        if (r19 == null) goto L39;
        r1 = R.id.view_title;
        OFloatingTitleBar r20 = (OFloatingTitleBar) ViewBindings.findChildViewById(r22, R.id.view_title);
        if (r20 == null) goto L39;
        r1 = R.id.wifi_state;
        TextView r21 = (TextView) ViewBindings.findChildViewById(r22, R.id.wifi_state);
        if (r21 == null) goto L39;
        return new WifiStatusTestBinding((RelativeLayout) r22, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21);
    L39:
        throw new NullPointerException("Missing required view with ID: ".concat(r22.getResources().getResourceName(r1)));
    }
}
