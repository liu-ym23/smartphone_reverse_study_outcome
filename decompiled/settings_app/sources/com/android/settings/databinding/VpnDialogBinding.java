package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;

/* JADX INFO: loaded from: classes2.dex */
public final class VpnDialogBinding implements ViewBinding {
    public final CheckBox alwaysOnVpn;
    public final EditText dnsServers;
    public final LinearLayout editor;
    public final Spinner ipsecCaCert;
    public final EditText ipsecIdentifier;
    public final LinearLayout ipsecPeer;
    public final LinearLayout ipsecPsk;
    public final EditText ipsecSecret;
    public final Spinner ipsecServerCert;
    public final LinearLayout ipsecUser;
    public final Spinner ipsecUserCert;
    public final LinearLayout l2tp;
    public final EditText l2tpSecret;
    public final LinearLayout login;
    public final CheckBox mppe;
    public final EditText name;
    public final LinearLayout options;
    public final EditText password;
    private final OScrollView rootView;
    public final EditText routes;
    public final CheckBox saveLogin;
    public final EditText searchDomains;
    public final EditText server;
    public final CheckBox showOptions;
    public final Spinner type;
    public final EditText username;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private VpnDialogBinding(OScrollView r3, CheckBox r4, EditText r5, LinearLayout r6, Spinner r7, EditText r8, LinearLayout r9, LinearLayout r10, EditText r11, Spinner r12, LinearLayout r13, Spinner r14, LinearLayout r15, EditText r16, LinearLayout r17, CheckBox r18, EditText r19, LinearLayout r20, EditText r21, EditText r22, CheckBox r23, EditText r24, EditText r25, CheckBox r26, Spinner r27, EditText r28) {
        this.rootView = r3;
        this.alwaysOnVpn = r4;
        this.dnsServers = r5;
        this.editor = r6;
        this.ipsecCaCert = r7;
        this.ipsecIdentifier = r8;
        this.ipsecPeer = r9;
        this.ipsecPsk = r10;
        this.ipsecSecret = r11;
        this.ipsecServerCert = r12;
        this.ipsecUser = r13;
        this.ipsecUserCert = r14;
        this.l2tp = r15;
        this.l2tpSecret = r16;
        this.login = r17;
        this.mppe = r18;
        this.name = r19;
        this.options = r20;
        this.password = r21;
        this.routes = r22;
        this.saveLogin = r23;
        this.searchDomains = r24;
        this.server = r25;
        this.showOptions = r26;
        this.type = r27;
        this.username = r28;
    }

    @Override // androidx.viewbinding.ViewBinding
    public OScrollView getRoot() {
        return this.rootView;
    }

    public static VpnDialogBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static VpnDialogBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.vpn_dialog, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static VpnDialogBinding bind(View r30) {
        int r1 = R.id.always_on_vpn;
        CheckBox r5 = (CheckBox) ViewBindings.findChildViewById(r30, R.id.always_on_vpn);
        if (r5 == null) goto L55;
        r1 = R.id.dns_servers;
        EditText r6 = (EditText) ViewBindings.findChildViewById(r30, R.id.dns_servers);
        if (r6 == null) goto L55;
        r1 = R.id.editor;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r30, R.id.editor);
        if (r7 == null) goto L55;
        r1 = R.id.ipsec_ca_cert;
        Spinner r8 = (Spinner) ViewBindings.findChildViewById(r30, R.id.ipsec_ca_cert);
        if (r8 == null) goto L55;
        r1 = R.id.ipsec_identifier;
        EditText r9 = (EditText) ViewBindings.findChildViewById(r30, R.id.ipsec_identifier);
        if (r9 == null) goto L55;
        r1 = R.id.ipsec_peer;
        LinearLayout r10 = (LinearLayout) ViewBindings.findChildViewById(r30, R.id.ipsec_peer);
        if (r10 == null) goto L55;
        r1 = R.id.ipsec_psk;
        LinearLayout r11 = (LinearLayout) ViewBindings.findChildViewById(r30, R.id.ipsec_psk);
        if (r11 == null) goto L55;
        r1 = R.id.ipsec_secret;
        EditText r12 = (EditText) ViewBindings.findChildViewById(r30, R.id.ipsec_secret);
        if (r12 == null) goto L55;
        r1 = R.id.ipsec_server_cert;
        Spinner r13 = (Spinner) ViewBindings.findChildViewById(r30, R.id.ipsec_server_cert);
        if (r13 == null) goto L55;
        r1 = R.id.ipsec_user;
        LinearLayout r14 = (LinearLayout) ViewBindings.findChildViewById(r30, R.id.ipsec_user);
        if (r14 == null) goto L55;
        r1 = R.id.ipsec_user_cert;
        Spinner r15 = (Spinner) ViewBindings.findChildViewById(r30, R.id.ipsec_user_cert);
        if (r15 == null) goto L55;
        r1 = R.id.l2tp;
        LinearLayout r16 = (LinearLayout) ViewBindings.findChildViewById(r30, R.id.l2tp);
        if (r16 == null) goto L55;
        r1 = R.id.l2tp_secret;
        EditText r17 = (EditText) ViewBindings.findChildViewById(r30, R.id.l2tp_secret);
        if (r17 == null) goto L55;
        r1 = R.id.login;
        LinearLayout r18 = (LinearLayout) ViewBindings.findChildViewById(r30, R.id.login);
        if (r18 == null) goto L55;
        r1 = R.id.mppe;
        CheckBox r19 = (CheckBox) ViewBindings.findChildViewById(r30, R.id.mppe);
        if (r19 == null) goto L55;
        r1 = R.id.name;
        EditText r20 = (EditText) ViewBindings.findChildViewById(r30, R.id.name);
        if (r20 == null) goto L55;
        r1 = R.id.options;
        LinearLayout r21 = (LinearLayout) ViewBindings.findChildViewById(r30, R.id.options);
        if (r21 == null) goto L55;
        r1 = R.id.password;
        EditText r22 = (EditText) ViewBindings.findChildViewById(r30, R.id.password);
        if (r22 == null) goto L55;
        r1 = R.id.routes;
        EditText r23 = (EditText) ViewBindings.findChildViewById(r30, R.id.routes);
        if (r23 == null) goto L55;
        r1 = R.id.save_login;
        CheckBox r24 = (CheckBox) ViewBindings.findChildViewById(r30, R.id.save_login);
        if (r24 == null) goto L55;
        r1 = R.id.search_domains;
        EditText r25 = (EditText) ViewBindings.findChildViewById(r30, R.id.search_domains);
        if (r25 == null) goto L55;
        r1 = R.id.server;
        EditText r26 = (EditText) ViewBindings.findChildViewById(r30, R.id.server);
        if (r26 == null) goto L55;
        r1 = R.id.show_options;
        CheckBox r27 = (CheckBox) ViewBindings.findChildViewById(r30, R.id.show_options);
        if (r27 == null) goto L55;
        r1 = R.id.type;
        Spinner r28 = (Spinner) ViewBindings.findChildViewById(r30, R.id.type);
        if (r28 == null) goto L55;
        r1 = R.id.username;
        EditText r29 = (EditText) ViewBindings.findChildViewById(r30, R.id.username);
        if (r29 == null) goto L55;
        return new VpnDialogBinding((OScrollView) r30, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29);
    L55:
        throw new NullPointerException("Missing required view with ID: ".concat(r30.getResources().getResourceName(r1)));
    }
}
