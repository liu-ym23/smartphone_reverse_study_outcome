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
import com.obric.oui.lisitem.OListItemSettings;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.widget.SizeChangedLinearLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class WifiSetupFragmentBinding implements ViewBinding {
    public final OCardListItem anonymous;
    public final OCardListItem caCert;
    public final LinearLayout caCertContainer;
    public final OCardListItem domain;
    public final LinearLayout eap;
    public final OCardListItem identity;
    public final LinearLayout lAnonymous;
    public final LinearLayout lDomain;
    public final LinearLayout lIdentity;
    public final OCardListItem lSimCard;
    public final LinearLayout lSimCardContainer;
    public final OCardListItem method;
    public final LinearLayout noCaCertWarning;
    public final LinearLayout noDomainWarning;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    public final OCardListItem password;
    public final SizeChangedLinearLayout passwordEditorContainer;
    public final OCardListItem phase2;
    public final LinearLayout phase2Container;
    public final OCardListItem privacy;
    private final RelativeLayout rootView;
    public final OCardListItem security;
    public final LinearLayout securityFields;
    public final OCardListItem ssid;
    public final LinearLayout type;
    public final OCardListItem userCert;
    public final LinearLayout userCertContainer;
    public final OFloatingTitleBar viewTitle;
    public final OListItemSettings wapiAsCert;
    public final LinearLayout wapiCert;
    public final OCardListItem wapiPskType;
    public final LinearLayout wapiPskTypeContainer;
    public final OCardListItem wapiUserCert;
    public final OCardListItem wepKeyIndex;
    public final LinearLayout wepKeyIndexContainer;
    public final OCardListItem wifiAdvancedTogglebox;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private WifiSetupFragmentBinding(RelativeLayout r3, OCardListItem r4, OCardListItem r5, LinearLayout r6, OCardListItem r7, LinearLayout r8, OCardListItem r9, LinearLayout r10, LinearLayout r11, LinearLayout r12, OCardListItem r13, LinearLayout r14, OCardListItem r15, LinearLayout r16, LinearLayout r17, LinearLayout r18, OScrollView r19, OCardListItem r20, SizeChangedLinearLayout r21, OCardListItem r22, LinearLayout r23, OCardListItem r24, OCardListItem r25, LinearLayout r26, OCardListItem r27, LinearLayout r28, OCardListItem r29, LinearLayout r30, OFloatingTitleBar r31, OListItemSettings r32, LinearLayout r33, OCardListItem r34, LinearLayout r35, OCardListItem r36, OCardListItem r37, LinearLayout r38, OCardListItem r39) {
        this.rootView = r3;
        this.anonymous = r4;
        this.caCert = r5;
        this.caCertContainer = r6;
        this.domain = r7;
        this.eap = r8;
        this.identity = r9;
        this.lAnonymous = r10;
        this.lDomain = r11;
        this.lIdentity = r12;
        this.lSimCard = r13;
        this.lSimCardContainer = r14;
        this.method = r15;
        this.noCaCertWarning = r16;
        this.noDomainWarning = r17;
        this.pageContainer = r18;
        this.pageScrollview = r19;
        this.password = r20;
        this.passwordEditorContainer = r21;
        this.phase2 = r22;
        this.phase2Container = r23;
        this.privacy = r24;
        this.security = r25;
        this.securityFields = r26;
        this.ssid = r27;
        this.type = r28;
        this.userCert = r29;
        this.userCertContainer = r30;
        this.viewTitle = r31;
        this.wapiAsCert = r32;
        this.wapiCert = r33;
        this.wapiPskType = r34;
        this.wapiPskTypeContainer = r35;
        this.wapiUserCert = r36;
        this.wepKeyIndex = r37;
        this.wepKeyIndexContainer = r38;
        this.wifiAdvancedTogglebox = r39;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static WifiSetupFragmentBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static WifiSetupFragmentBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.wifi_setup_fragment, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static WifiSetupFragmentBinding bind(View r41) {
        int r1 = R.id.anonymous;
        OCardListItem r5 = (OCardListItem) ViewBindings.findChildViewById(r41, R.id.anonymous);
        if (r5 == null) goto L77;
        r1 = R.id.ca_cert;
        OCardListItem r6 = (OCardListItem) ViewBindings.findChildViewById(r41, R.id.ca_cert);
        if (r6 == null) goto L77;
        r1 = R.id.ca_cert_container;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r41, R.id.ca_cert_container);
        if (r7 == null) goto L77;
        r1 = R.id.domain;
        OCardListItem r8 = (OCardListItem) ViewBindings.findChildViewById(r41, R.id.domain);
        if (r8 == null) goto L77;
        r1 = R.id.eap;
        LinearLayout r9 = (LinearLayout) ViewBindings.findChildViewById(r41, R.id.eap);
        if (r9 == null) goto L77;
        r1 = R.id.identity;
        OCardListItem r10 = (OCardListItem) ViewBindings.findChildViewById(r41, R.id.identity);
        if (r10 == null) goto L77;
        r1 = R.id.l_anonymous;
        LinearLayout r11 = (LinearLayout) ViewBindings.findChildViewById(r41, R.id.l_anonymous);
        if (r11 == null) goto L77;
        r1 = R.id.l_domain;
        LinearLayout r12 = (LinearLayout) ViewBindings.findChildViewById(r41, R.id.l_domain);
        if (r12 == null) goto L77;
        r1 = R.id.l_identity;
        LinearLayout r13 = (LinearLayout) ViewBindings.findChildViewById(r41, R.id.l_identity);
        if (r13 == null) goto L77;
        r1 = R.id.l_sim_card;
        OCardListItem r14 = (OCardListItem) ViewBindings.findChildViewById(r41, R.id.l_sim_card);
        if (r14 == null) goto L77;
        r1 = R.id.l_sim_card_container;
        LinearLayout r15 = (LinearLayout) ViewBindings.findChildViewById(r41, R.id.l_sim_card_container);
        if (r15 == null) goto L77;
        r1 = R.id.method;
        OCardListItem r16 = (OCardListItem) ViewBindings.findChildViewById(r41, R.id.method);
        if (r16 == null) goto L77;
        r1 = R.id.no_ca_cert_warning;
        LinearLayout r17 = (LinearLayout) ViewBindings.findChildViewById(r41, R.id.no_ca_cert_warning);
        if (r17 == null) goto L77;
        r1 = R.id.no_domain_warning;
        LinearLayout r18 = (LinearLayout) ViewBindings.findChildViewById(r41, R.id.no_domain_warning);
        if (r18 == null) goto L77;
        r1 = R.id.page_container;
        LinearLayout r19 = (LinearLayout) ViewBindings.findChildViewById(r41, R.id.page_container);
        if (r19 == null) goto L77;
        r1 = R.id.page_scrollview;
        OScrollView r20 = (OScrollView) ViewBindings.findChildViewById(r41, R.id.page_scrollview);
        if (r20 == null) goto L77;
        r1 = R.id.password;
        OCardListItem r21 = (OCardListItem) ViewBindings.findChildViewById(r41, R.id.password);
        if (r21 == null) goto L77;
        r1 = R.id.password_editor_container;
        SizeChangedLinearLayout r22 = (SizeChangedLinearLayout) ViewBindings.findChildViewById(r41, R.id.password_editor_container);
        if (r22 == null) goto L77;
        r1 = R.id.phase2;
        OCardListItem r23 = (OCardListItem) ViewBindings.findChildViewById(r41, R.id.phase2);
        if (r23 == null) goto L77;
        r1 = R.id.phase2_container;
        LinearLayout r24 = (LinearLayout) ViewBindings.findChildViewById(r41, R.id.phase2_container);
        if (r24 == null) goto L77;
        r1 = R.id.privacy;
        OCardListItem r25 = (OCardListItem) ViewBindings.findChildViewById(r41, R.id.privacy);
        if (r25 == null) goto L77;
        r1 = R.id.security;
        OCardListItem r26 = (OCardListItem) ViewBindings.findChildViewById(r41, R.id.security);
        if (r26 == null) goto L77;
        r1 = R.id.security_fields;
        LinearLayout r27 = (LinearLayout) ViewBindings.findChildViewById(r41, R.id.security_fields);
        if (r27 == null) goto L77;
        r1 = R.id.ssid;
        OCardListItem r28 = (OCardListItem) ViewBindings.findChildViewById(r41, R.id.ssid);
        if (r28 == null) goto L77;
        r1 = R.id.type;
        LinearLayout r29 = (LinearLayout) ViewBindings.findChildViewById(r41, R.id.type);
        if (r29 == null) goto L77;
        r1 = R.id.user_cert;
        OCardListItem r30 = (OCardListItem) ViewBindings.findChildViewById(r41, R.id.user_cert);
        if (r30 == null) goto L77;
        r1 = R.id.user_cert_container;
        LinearLayout r31 = (LinearLayout) ViewBindings.findChildViewById(r41, R.id.user_cert_container);
        if (r31 == null) goto L77;
        r1 = R.id.view_title;
        OFloatingTitleBar r32 = (OFloatingTitleBar) ViewBindings.findChildViewById(r41, R.id.view_title);
        if (r32 == null) goto L77;
        r1 = R.id.wapi_as_cert;
        OListItemSettings r33 = (OListItemSettings) ViewBindings.findChildViewById(r41, R.id.wapi_as_cert);
        if (r33 == null) goto L77;
        r1 = R.id.wapi_cert;
        LinearLayout r34 = (LinearLayout) ViewBindings.findChildViewById(r41, R.id.wapi_cert);
        if (r34 == null) goto L77;
        r1 = R.id.wapi_psk_type;
        OCardListItem r35 = (OCardListItem) ViewBindings.findChildViewById(r41, R.id.wapi_psk_type);
        if (r35 == null) goto L77;
        r1 = R.id.wapi_psk_type_container;
        LinearLayout r36 = (LinearLayout) ViewBindings.findChildViewById(r41, R.id.wapi_psk_type_container);
        if (r36 == null) goto L77;
        r1 = R.id.wapi_user_cert;
        OCardListItem r37 = (OCardListItem) ViewBindings.findChildViewById(r41, R.id.wapi_user_cert);
        if (r37 == null) goto L77;
        r1 = R.id.wep_key_index;
        OCardListItem r38 = (OCardListItem) ViewBindings.findChildViewById(r41, R.id.wep_key_index);
        if (r38 == null) goto L77;
        r1 = R.id.wep_key_index_container;
        LinearLayout r39 = (LinearLayout) ViewBindings.findChildViewById(r41, R.id.wep_key_index_container);
        if (r39 == null) goto L77;
        r1 = R.id.wifi_advanced_togglebox;
        OCardListItem r40 = (OCardListItem) ViewBindings.findChildViewById(r41, R.id.wifi_advanced_togglebox);
        if (r40 == null) goto L77;
        return new WifiSetupFragmentBinding((RelativeLayout) r41, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40);
    L77:
        throw new NullPointerException("Missing required view with ID: ".concat(r41.getResources().getResourceName(r1)));
    }
}
