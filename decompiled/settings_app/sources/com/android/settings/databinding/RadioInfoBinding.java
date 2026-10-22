package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class RadioInfoBinding implements ViewBinding {
    public final TextView call;
    public final Spinner cellInfoRateSelect;
    public final TextView cellinfo;
    public final TextView cfi;
    public final TextView dataNetwork;
    public final TextView dbm;
    public final TextView dcrtinfo;
    public final TextView dnsCheckState;
    public final Button dnsCheckToggle;
    public final TextView gprs;
    public final TextView gsm;
    public final TextView httpClientTest;
    public final TextView imei;
    public final TextView location;
    public final TextView mwi;
    public final TextView neighboring;
    public final TextView number;
    public final Button oemInfo;
    public final TextView operator;
    public final TextView pingHostnameV4;
    public final TextView pingHostnameV6;
    public final Button pingTest;
    public final Spinner preferredNetworkType;
    public final Switch radioPower;
    public final TextView received;
    public final Button refreshSmsc;
    public final TextView roaming;
    private final RelativeLayout rootView;
    public final TextView sent;
    public final TextView sentSinceReceived;
    public final EditText smsc;
    public final TextView smscLabel;
    public final Button updateSmsc;
    public final OFloatingTitleBar viewTitle;
    public final TextView voiceNetwork;
    public final Switch volteProvisionedSwitch;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private RadioInfoBinding(RelativeLayout r3, TextView r4, Spinner r5, TextView r6, TextView r7, TextView r8, TextView r9, TextView r10, TextView r11, Button r12, TextView r13, TextView r14, TextView r15, TextView r16, TextView r17, TextView r18, TextView r19, TextView r20, Button r21, TextView r22, TextView r23, TextView r24, Button r25, Spinner r26, Switch r27, TextView r28, Button r29, TextView r30, TextView r31, TextView r32, EditText r33, TextView r34, Button r35, OFloatingTitleBar r36, TextView r37, Switch r38) {
        this.rootView = r3;
        this.call = r4;
        this.cellInfoRateSelect = r5;
        this.cellinfo = r6;
        this.cfi = r7;
        this.dataNetwork = r8;
        this.dbm = r9;
        this.dcrtinfo = r10;
        this.dnsCheckState = r11;
        this.dnsCheckToggle = r12;
        this.gprs = r13;
        this.gsm = r14;
        this.httpClientTest = r15;
        this.imei = r16;
        this.location = r17;
        this.mwi = r18;
        this.neighboring = r19;
        this.number = r20;
        this.oemInfo = r21;
        this.operator = r22;
        this.pingHostnameV4 = r23;
        this.pingHostnameV6 = r24;
        this.pingTest = r25;
        this.preferredNetworkType = r26;
        this.radioPower = r27;
        this.received = r28;
        this.refreshSmsc = r29;
        this.roaming = r30;
        this.sent = r31;
        this.sentSinceReceived = r32;
        this.smsc = r33;
        this.smscLabel = r34;
        this.updateSmsc = r35;
        this.viewTitle = r36;
        this.voiceNetwork = r37;
        this.volteProvisionedSwitch = r38;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static RadioInfoBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static RadioInfoBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.radio_info, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static RadioInfoBinding bind(View r40) {
        int r1 = R.id.call;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r40, R.id.call);
        if (r5 == null) goto L75;
        r1 = R.id.cell_info_rate_select;
        Spinner r6 = (Spinner) ViewBindings.findChildViewById(r40, R.id.cell_info_rate_select);
        if (r6 == null) goto L75;
        r1 = R.id.cellinfo;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r40, R.id.cellinfo);
        if (r7 == null) goto L75;
        r1 = R.id.cfi;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r40, R.id.cfi);
        if (r8 == null) goto L75;
        r1 = R.id.data_network;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r40, R.id.data_network);
        if (r9 == null) goto L75;
        r1 = R.id.dbm;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r40, R.id.dbm);
        if (r10 == null) goto L75;
        r1 = R.id.dcrtinfo;
        TextView r11 = (TextView) ViewBindings.findChildViewById(r40, R.id.dcrtinfo);
        if (r11 == null) goto L75;
        r1 = R.id.dnsCheckState;
        TextView r12 = (TextView) ViewBindings.findChildViewById(r40, R.id.dnsCheckState);
        if (r12 == null) goto L75;
        r1 = R.id.dns_check_toggle;
        Button r13 = (Button) ViewBindings.findChildViewById(r40, R.id.dns_check_toggle);
        if (r13 == null) goto L75;
        r1 = R.id.gprs;
        TextView r14 = (TextView) ViewBindings.findChildViewById(r40, R.id.gprs);
        if (r14 == null) goto L75;
        r1 = R.id.gsm;
        TextView r15 = (TextView) ViewBindings.findChildViewById(r40, R.id.gsm);
        if (r15 == null) goto L75;
        r1 = R.id.httpClientTest;
        TextView r16 = (TextView) ViewBindings.findChildViewById(r40, R.id.httpClientTest);
        if (r16 == null) goto L75;
        r1 = R.id.imei;
        TextView r17 = (TextView) ViewBindings.findChildViewById(r40, R.id.imei);
        if (r17 == null) goto L75;
        r1 = R.id.location;
        TextView r18 = (TextView) ViewBindings.findChildViewById(r40, R.id.location);
        if (r18 == null) goto L75;
        r1 = R.id.mwi;
        TextView r19 = (TextView) ViewBindings.findChildViewById(r40, R.id.mwi);
        if (r19 == null) goto L75;
        r1 = R.id.neighboring;
        TextView r20 = (TextView) ViewBindings.findChildViewById(r40, R.id.neighboring);
        if (r20 == null) goto L75;
        r1 = R.id.number;
        TextView r21 = (TextView) ViewBindings.findChildViewById(r40, R.id.number);
        if (r21 == null) goto L75;
        r1 = R.id.oem_info;
        Button r22 = (Button) ViewBindings.findChildViewById(r40, R.id.oem_info);
        if (r22 == null) goto L75;
        r1 = R.id.operator;
        TextView r23 = (TextView) ViewBindings.findChildViewById(r40, R.id.operator);
        if (r23 == null) goto L75;
        r1 = R.id.pingHostnameV4;
        TextView r24 = (TextView) ViewBindings.findChildViewById(r40, R.id.pingHostnameV4);
        if (r24 == null) goto L75;
        r1 = R.id.pingHostnameV6;
        TextView r25 = (TextView) ViewBindings.findChildViewById(r40, R.id.pingHostnameV6);
        if (r25 == null) goto L75;
        r1 = R.id.ping_test;
        Button r26 = (Button) ViewBindings.findChildViewById(r40, R.id.ping_test);
        if (r26 == null) goto L75;
        r1 = R.id.preferredNetworkType;
        Spinner r27 = (Spinner) ViewBindings.findChildViewById(r40, R.id.preferredNetworkType);
        if (r27 == null) goto L75;
        r1 = R.id.radio_power;
        Switch r28 = (Switch) ViewBindings.findChildViewById(r40, R.id.radio_power);
        if (r28 == null) goto L75;
        r1 = R.id.received;
        TextView r29 = (TextView) ViewBindings.findChildViewById(r40, R.id.received);
        if (r29 == null) goto L75;
        r1 = R.id.refresh_smsc;
        Button r30 = (Button) ViewBindings.findChildViewById(r40, R.id.refresh_smsc);
        if (r30 == null) goto L75;
        r1 = R.id.roaming;
        TextView r31 = (TextView) ViewBindings.findChildViewById(r40, R.id.roaming);
        if (r31 == null) goto L75;
        r1 = R.id.sent;
        TextView r32 = (TextView) ViewBindings.findChildViewById(r40, R.id.sent);
        if (r32 == null) goto L75;
        r1 = R.id.sentSinceReceived;
        TextView r33 = (TextView) ViewBindings.findChildViewById(r40, R.id.sentSinceReceived);
        if (r33 == null) goto L75;
        r1 = R.id.smsc;
        EditText r34 = (EditText) ViewBindings.findChildViewById(r40, R.id.smsc);
        if (r34 == null) goto L75;
        r1 = R.id.smsc_label;
        TextView r35 = (TextView) ViewBindings.findChildViewById(r40, R.id.smsc_label);
        if (r35 == null) goto L75;
        r1 = R.id.update_smsc;
        Button r36 = (Button) ViewBindings.findChildViewById(r40, R.id.update_smsc);
        if (r36 == null) goto L75;
        r1 = R.id.view_title;
        OFloatingTitleBar r37 = (OFloatingTitleBar) ViewBindings.findChildViewById(r40, R.id.view_title);
        if (r37 == null) goto L75;
        r1 = R.id.voice_network;
        TextView r38 = (TextView) ViewBindings.findChildViewById(r40, R.id.voice_network);
        if (r38 == null) goto L75;
        r1 = R.id.volte_provisioned_switch;
        Switch r39 = (Switch) ViewBindings.findChildViewById(r40, R.id.volte_provisioned_switch);
        if (r39 == null) goto L75;
        return new RadioInfoBinding((RelativeLayout) r40, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39);
    L75:
        throw new NullPointerException("Missing required view with ID: ".concat(r40.getResources().getResourceName(r1)));
    }
}
