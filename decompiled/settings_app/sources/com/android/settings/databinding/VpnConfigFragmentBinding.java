package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.button.OButton;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class VpnConfigFragmentBinding implements ViewBinding {
    public final OCardListItem advancedOptions;
    public final OButton deleteBtn;
    public final ItemSubSettingsPaddingLayout2Binding deleteBtnTopGap;
    public final LinearLayout editor;
    public final OCardListItem ipsecCaCert;
    public final OCardListItem ipsecIdentifier;
    public final LinearLayout ipsecPeer;
    public final LinearLayout ipsecPsk;
    public final OCardListItem ipsecSecret;
    public final OCardListItem ipsecServerCert;
    public final LinearLayout ipsecUser;
    public final OCardListItem ipsecUserCert;
    public final OCardListItem itemVpnAlwaysOn;
    public final LinearLayout l2tp;
    public final OCardListItem l2tpSecret;
    public final CheckBox mppe;
    public final OCardListItem name;
    public final LinearLayout optionsIpsecIdentity;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    public final OCardListItem password;
    private final RelativeLayout rootView;
    public final CheckBox saveLogin;
    public final OCardListItem server;
    public final OSectionSupportiveText tipsVpnAlwaysOnFailed;
    public final OCardListItem type;
    public final LinearLayout user;
    public final OCardListItem username;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private VpnConfigFragmentBinding(RelativeLayout r3, OCardListItem r4, OButton r5, ItemSubSettingsPaddingLayout2Binding r6, LinearLayout r7, OCardListItem r8, OCardListItem r9, LinearLayout r10, LinearLayout r11, OCardListItem r12, OCardListItem r13, LinearLayout r14, OCardListItem r15, OCardListItem r16, LinearLayout r17, OCardListItem r18, CheckBox r19, OCardListItem r20, LinearLayout r21, LinearLayout r22, OScrollView r23, OCardListItem r24, CheckBox r25, OCardListItem r26, OSectionSupportiveText r27, OCardListItem r28, LinearLayout r29, OCardListItem r30, OFloatingTitleBar r31) {
        this.rootView = r3;
        this.advancedOptions = r4;
        this.deleteBtn = r5;
        this.deleteBtnTopGap = r6;
        this.editor = r7;
        this.ipsecCaCert = r8;
        this.ipsecIdentifier = r9;
        this.ipsecPeer = r10;
        this.ipsecPsk = r11;
        this.ipsecSecret = r12;
        this.ipsecServerCert = r13;
        this.ipsecUser = r14;
        this.ipsecUserCert = r15;
        this.itemVpnAlwaysOn = r16;
        this.l2tp = r17;
        this.l2tpSecret = r18;
        this.mppe = r19;
        this.name = r20;
        this.optionsIpsecIdentity = r21;
        this.pageContainer = r22;
        this.pageScrollview = r23;
        this.password = r24;
        this.saveLogin = r25;
        this.server = r26;
        this.tipsVpnAlwaysOnFailed = r27;
        this.type = r28;
        this.user = r29;
        this.username = r30;
        this.viewTitle = r31;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static VpnConfigFragmentBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static VpnConfigFragmentBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.vpn_config_fragment, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static VpnConfigFragmentBinding bind(View r33) {
        int r1 = R.id.advanced_options;
        OCardListItem r5 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.advanced_options);
        if (r5 == null) goto L61;
        r1 = R.id.delete_btn;
        OButton r6 = (OButton) ViewBindings.findChildViewById(r33, R.id.delete_btn);
        if (r6 == null) goto L61;
        r1 = R.id.delete_btn_top_gap;
        View r2 = ViewBindings.findChildViewById(r33, R.id.delete_btn_top_gap);
        if (r2 == null) goto L61;
        ItemSubSettingsPaddingLayout2Binding r7 = ItemSubSettingsPaddingLayout2Binding.bind(r2);
        r1 = R.id.editor;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r33, R.id.editor);
        if (r8 == null) goto L61;
        r1 = R.id.ipsec_ca_cert;
        OCardListItem r9 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.ipsec_ca_cert);
        if (r9 == null) goto L61;
        r1 = R.id.ipsec_identifier;
        OCardListItem r10 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.ipsec_identifier);
        if (r10 == null) goto L61;
        r1 = R.id.ipsec_peer;
        LinearLayout r11 = (LinearLayout) ViewBindings.findChildViewById(r33, R.id.ipsec_peer);
        if (r11 == null) goto L61;
        r1 = R.id.ipsec_psk;
        LinearLayout r12 = (LinearLayout) ViewBindings.findChildViewById(r33, R.id.ipsec_psk);
        if (r12 == null) goto L61;
        r1 = R.id.ipsec_secret;
        OCardListItem r13 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.ipsec_secret);
        if (r13 == null) goto L61;
        r1 = R.id.ipsec_server_cert;
        OCardListItem r14 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.ipsec_server_cert);
        if (r14 == null) goto L61;
        r1 = R.id.ipsec_user;
        LinearLayout r15 = (LinearLayout) ViewBindings.findChildViewById(r33, R.id.ipsec_user);
        if (r15 == null) goto L61;
        r1 = R.id.ipsec_user_cert;
        OCardListItem r16 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.ipsec_user_cert);
        if (r16 == null) goto L61;
        r1 = R.id.item_vpn_always_on;
        OCardListItem r17 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.item_vpn_always_on);
        if (r17 == null) goto L61;
        r1 = R.id.l2tp;
        LinearLayout r18 = (LinearLayout) ViewBindings.findChildViewById(r33, R.id.l2tp);
        if (r18 == null) goto L61;
        r1 = R.id.l2tp_secret;
        OCardListItem r19 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.l2tp_secret);
        if (r19 == null) goto L61;
        r1 = R.id.mppe;
        CheckBox r20 = (CheckBox) ViewBindings.findChildViewById(r33, R.id.mppe);
        if (r20 == null) goto L61;
        r1 = R.id.name;
        OCardListItem r21 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.name);
        if (r21 == null) goto L61;
        r1 = R.id.options_ipsec_identity;
        LinearLayout r22 = (LinearLayout) ViewBindings.findChildViewById(r33, R.id.options_ipsec_identity);
        if (r22 == null) goto L61;
        r1 = R.id.page_container;
        LinearLayout r23 = (LinearLayout) ViewBindings.findChildViewById(r33, R.id.page_container);
        if (r23 == null) goto L61;
        r1 = R.id.page_scrollview;
        OScrollView r24 = (OScrollView) ViewBindings.findChildViewById(r33, R.id.page_scrollview);
        if (r24 == null) goto L61;
        r1 = R.id.password;
        OCardListItem r25 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.password);
        if (r25 == null) goto L61;
        r1 = R.id.save_login;
        CheckBox r26 = (CheckBox) ViewBindings.findChildViewById(r33, R.id.save_login);
        if (r26 == null) goto L61;
        r1 = R.id.server;
        OCardListItem r27 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.server);
        if (r27 == null) goto L61;
        r1 = R.id.tips_vpn_always_on_failed;
        OSectionSupportiveText r28 = (OSectionSupportiveText) ViewBindings.findChildViewById(r33, R.id.tips_vpn_always_on_failed);
        if (r28 == null) goto L61;
        r1 = R.id.type;
        OCardListItem r29 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.type);
        if (r29 == null) goto L61;
        r1 = R.id.user;
        LinearLayout r30 = (LinearLayout) ViewBindings.findChildViewById(r33, R.id.user);
        if (r30 == null) goto L61;
        r1 = R.id.username;
        OCardListItem r31 = (OCardListItem) ViewBindings.findChildViewById(r33, R.id.username);
        if (r31 == null) goto L61;
        r1 = R.id.view_title;
        OFloatingTitleBar r32 = (OFloatingTitleBar) ViewBindings.findChildViewById(r33, R.id.view_title);
        if (r32 == null) goto L61;
        return new VpnConfigFragmentBinding((RelativeLayout) r33, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32);
    L61:
        throw new NullPointerException("Missing required view with ID: ".concat(r33.getResources().getResourceName(r1)));
    }
}
