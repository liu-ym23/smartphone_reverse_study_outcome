package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class WifiConfigUiForSetupWizardBinding implements ViewBinding {
    public final EditText anonymous;
    public final Spinner caCert;
    public final EditText dns1;
    public final EditText dns2;
    public final LinearLayout eap;
    public final FrameLayout eapNotSupported;
    public final FrameLayout eapNotSupportedForAddNetwork;
    public final EditText gateway;
    public final EditText identity;
    public final LinearLayout info;
    public final LinearLayout ipFields;
    public final Spinner ipSettings;
    public final EditText ipaddress;
    public final Spinner method;
    public final EditText networkPrefixLength;
    public final EditText password;
    public final LinearLayout passwordLayout;
    public final TextView passwordText;
    public final Spinner phase2;
    public final EditText proxyExclusionlist;
    public final LinearLayout proxyFields;
    public final EditText proxyHostname;
    public final EditText proxyPort;
    public final Spinner proxySettings;
    public final LinearLayout proxySettingsFields;
    public final TextView proxySettingsTitle;
    public final LinearLayout proxyWarningLimitedSupport;
    private final LinearLayout rootView;
    public final Spinner security;
    public final TableRow securityFields;
    public final TextView securityText;
    public final CheckBox showPassword;
    public final EditText ssid;
    public final FrameLayout ssidLayout;
    public final TextView ssidText;
    public final LinearLayout staticip;
    public final TableRow typeSecurity;
    public final TableRow typeSsid;
    public final Spinner userCert;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private WifiConfigUiForSetupWizardBinding(LinearLayout r3, EditText r4, Spinner r5, EditText r6, EditText r7, LinearLayout r8, FrameLayout r9, FrameLayout r10, EditText r11, EditText r12, LinearLayout r13, LinearLayout r14, Spinner r15, EditText r16, Spinner r17, EditText r18, EditText r19, LinearLayout r20, TextView r21, Spinner r22, EditText r23, LinearLayout r24, EditText r25, EditText r26, Spinner r27, LinearLayout r28, TextView r29, LinearLayout r30, Spinner r31, TableRow r32, TextView r33, CheckBox r34, EditText r35, FrameLayout r36, TextView r37, LinearLayout r38, TableRow r39, TableRow r40, Spinner r41) {
        this.rootView = r3;
        this.anonymous = r4;
        this.caCert = r5;
        this.dns1 = r6;
        this.dns2 = r7;
        this.eap = r8;
        this.eapNotSupported = r9;
        this.eapNotSupportedForAddNetwork = r10;
        this.gateway = r11;
        this.identity = r12;
        this.info = r13;
        this.ipFields = r14;
        this.ipSettings = r15;
        this.ipaddress = r16;
        this.method = r17;
        this.networkPrefixLength = r18;
        this.password = r19;
        this.passwordLayout = r20;
        this.passwordText = r21;
        this.phase2 = r22;
        this.proxyExclusionlist = r23;
        this.proxyFields = r24;
        this.proxyHostname = r25;
        this.proxyPort = r26;
        this.proxySettings = r27;
        this.proxySettingsFields = r28;
        this.proxySettingsTitle = r29;
        this.proxyWarningLimitedSupport = r30;
        this.security = r31;
        this.securityFields = r32;
        this.securityText = r33;
        this.showPassword = r34;
        this.ssid = r35;
        this.ssidLayout = r36;
        this.ssidText = r37;
        this.staticip = r38;
        this.typeSecurity = r39;
        this.typeSsid = r40;
        this.userCert = r41;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static WifiConfigUiForSetupWizardBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static WifiConfigUiForSetupWizardBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.wifi_config_ui_for_setup_wizard, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static WifiConfigUiForSetupWizardBinding bind(View r43) {
        int r1 = R.id.anonymous;
        EditText r5 = (EditText) ViewBindings.findChildViewById(r43, R.id.anonymous);
        if (r5 == null) goto L81;
        r1 = R.id.ca_cert;
        Spinner r6 = (Spinner) ViewBindings.findChildViewById(r43, R.id.ca_cert);
        if (r6 == null) goto L81;
        r1 = R.id.dns1;
        EditText r7 = (EditText) ViewBindings.findChildViewById(r43, R.id.dns1);
        if (r7 == null) goto L81;
        r1 = R.id.dns2;
        EditText r8 = (EditText) ViewBindings.findChildViewById(r43, R.id.dns2);
        if (r8 == null) goto L81;
        r1 = R.id.eap;
        LinearLayout r9 = (LinearLayout) ViewBindings.findChildViewById(r43, R.id.eap);
        if (r9 == null) goto L81;
        r1 = R.id.eap_not_supported;
        FrameLayout r10 = (FrameLayout) ViewBindings.findChildViewById(r43, R.id.eap_not_supported);
        if (r10 == null) goto L81;
        r1 = R.id.eap_not_supported_for_add_network;
        FrameLayout r11 = (FrameLayout) ViewBindings.findChildViewById(r43, R.id.eap_not_supported_for_add_network);
        if (r11 == null) goto L81;
        r1 = R.id.gateway;
        EditText r12 = (EditText) ViewBindings.findChildViewById(r43, R.id.gateway);
        if (r12 == null) goto L81;
        r1 = R.id.identity;
        EditText r13 = (EditText) ViewBindings.findChildViewById(r43, R.id.identity);
        if (r13 == null) goto L81;
        r1 = R.id.info;
        LinearLayout r14 = (LinearLayout) ViewBindings.findChildViewById(r43, R.id.info);
        if (r14 == null) goto L81;
        r1 = R.id.ip_fields;
        LinearLayout r15 = (LinearLayout) ViewBindings.findChildViewById(r43, R.id.ip_fields);
        if (r15 == null) goto L81;
        r1 = R.id.ip_settings;
        Spinner r16 = (Spinner) ViewBindings.findChildViewById(r43, R.id.ip_settings);
        if (r16 == null) goto L81;
        r1 = R.id.ipaddress;
        EditText r17 = (EditText) ViewBindings.findChildViewById(r43, R.id.ipaddress);
        if (r17 == null) goto L81;
        r1 = R.id.method;
        Spinner r18 = (Spinner) ViewBindings.findChildViewById(r43, R.id.method);
        if (r18 == null) goto L81;
        r1 = R.id.network_prefix_length;
        EditText r19 = (EditText) ViewBindings.findChildViewById(r43, R.id.network_prefix_length);
        if (r19 == null) goto L81;
        r1 = R.id.password;
        EditText r20 = (EditText) ViewBindings.findChildViewById(r43, R.id.password);
        if (r20 == null) goto L81;
        r1 = R.id.password_layout;
        LinearLayout r21 = (LinearLayout) ViewBindings.findChildViewById(r43, R.id.password_layout);
        if (r21 == null) goto L81;
        r1 = R.id.password_text;
        TextView r22 = (TextView) ViewBindings.findChildViewById(r43, R.id.password_text);
        if (r22 == null) goto L81;
        r1 = R.id.phase2;
        Spinner r23 = (Spinner) ViewBindings.findChildViewById(r43, R.id.phase2);
        if (r23 == null) goto L81;
        r1 = R.id.proxy_exclusionlist;
        EditText r24 = (EditText) ViewBindings.findChildViewById(r43, R.id.proxy_exclusionlist);
        if (r24 == null) goto L81;
        r1 = R.id.proxy_fields;
        LinearLayout r25 = (LinearLayout) ViewBindings.findChildViewById(r43, R.id.proxy_fields);
        if (r25 == null) goto L81;
        r1 = R.id.proxy_hostname;
        EditText r26 = (EditText) ViewBindings.findChildViewById(r43, R.id.proxy_hostname);
        if (r26 == null) goto L81;
        r1 = R.id.proxy_port;
        EditText r27 = (EditText) ViewBindings.findChildViewById(r43, R.id.proxy_port);
        if (r27 == null) goto L81;
        r1 = R.id.proxy_settings;
        Spinner r28 = (Spinner) ViewBindings.findChildViewById(r43, R.id.proxy_settings);
        if (r28 == null) goto L81;
        r1 = R.id.proxy_settings_fields;
        LinearLayout r29 = (LinearLayout) ViewBindings.findChildViewById(r43, R.id.proxy_settings_fields);
        if (r29 == null) goto L81;
        r1 = R.id.proxy_settings_title;
        TextView r30 = (TextView) ViewBindings.findChildViewById(r43, R.id.proxy_settings_title);
        if (r30 == null) goto L81;
        r1 = R.id.proxy_warning_limited_support;
        LinearLayout r31 = (LinearLayout) ViewBindings.findChildViewById(r43, R.id.proxy_warning_limited_support);
        if (r31 == null) goto L81;
        r1 = R.id.security;
        Spinner r32 = (Spinner) ViewBindings.findChildViewById(r43, R.id.security);
        if (r32 == null) goto L81;
        r1 = R.id.security_fields;
        TableRow r33 = (TableRow) ViewBindings.findChildViewById(r43, R.id.security_fields);
        if (r33 == null) goto L81;
        r1 = R.id.security_text;
        TextView r34 = (TextView) ViewBindings.findChildViewById(r43, R.id.security_text);
        if (r34 == null) goto L81;
        r1 = R.id.show_password;
        CheckBox r35 = (CheckBox) ViewBindings.findChildViewById(r43, R.id.show_password);
        if (r35 == null) goto L81;
        r1 = R.id.ssid;
        EditText r36 = (EditText) ViewBindings.findChildViewById(r43, R.id.ssid);
        if (r36 == null) goto L81;
        r1 = R.id.ssid_layout;
        FrameLayout r37 = (FrameLayout) ViewBindings.findChildViewById(r43, R.id.ssid_layout);
        if (r37 == null) goto L81;
        r1 = R.id.ssid_text;
        TextView r38 = (TextView) ViewBindings.findChildViewById(r43, R.id.ssid_text);
        if (r38 == null) goto L81;
        r1 = R.id.staticip;
        LinearLayout r39 = (LinearLayout) ViewBindings.findChildViewById(r43, R.id.staticip);
        if (r39 == null) goto L81;
        r1 = R.id.type_security;
        TableRow r40 = (TableRow) ViewBindings.findChildViewById(r43, R.id.type_security);
        if (r40 == null) goto L81;
        r1 = R.id.type_ssid;
        TableRow r41 = (TableRow) ViewBindings.findChildViewById(r43, R.id.type_ssid);
        if (r41 == null) goto L81;
        r1 = R.id.user_cert;
        Spinner r42 = (Spinner) ViewBindings.findChildViewById(r43, R.id.user_cert);
        if (r42 == null) goto L81;
        return new WifiConfigUiForSetupWizardBinding((LinearLayout) r43, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42);
    L81:
        throw new NullPointerException("Missing required view with ID: ".concat(r43.getResources().getResourceName(r1)));
    }
}
