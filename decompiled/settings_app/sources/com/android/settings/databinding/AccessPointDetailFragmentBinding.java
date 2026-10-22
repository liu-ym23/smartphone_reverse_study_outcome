package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.button.OButton;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.lisitem.OListItemSettings;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class AccessPointDetailFragmentBinding implements ViewBinding {
    public final OCardListItem apAdvancedOptions;
    public final View apAdvancedOptionsDivider;
    public final OCardListItem apConnectionSpeed;
    public final OCardListItem apIpAddress;
    public final OUILinearLayout apNetworkSharing;
    public final OCardListItem apSecurity;
    public final OCardListItem apSignalStrength;
    public final OCardListItem apStatusInfo;
    public final OListItemSettings apTrustNetwork;
    public final TextView apTrustNetworkTips;
    public final OCardListItem autoConnectNetwork;
    public final OCardListItem autoLoginNetwork;
    public final OListItemSettings disconnectBtn;
    public final LinearLayout disconnectLayout;
    public final OButton forgetBtn;
    public final LinearLayout forgetContainer;
    public final OCardListItem macAddress;
    public final OCardListItem modifyBtn;
    public final LinearLayout modifyLayout;
    public final ImageView networkSharingQrcode;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    public final OCardListItem prioritConnectNetwork;
    public final View prioritConnectNetworkDivider;
    public final OSectionSupportiveText prioritConnectNetworkTips;
    public final OCardListItem privacy;
    private final RelativeLayout rootView;
    public final LinearLayout trustLayout;
    public final OFloatingTitleBar viewTitle;
    public final LinearLayout wifiDppLayout;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private AccessPointDetailFragmentBinding(RelativeLayout r3, OCardListItem r4, View r5, OCardListItem r6, OCardListItem r7, OUILinearLayout r8, OCardListItem r9, OCardListItem r10, OCardListItem r11, OListItemSettings r12, TextView r13, OCardListItem r14, OCardListItem r15, OListItemSettings r16, LinearLayout r17, OButton r18, LinearLayout r19, OCardListItem r20, OCardListItem r21, LinearLayout r22, ImageView r23, LinearLayout r24, OScrollView r25, OCardListItem r26, View r27, OSectionSupportiveText r28, OCardListItem r29, LinearLayout r30, OFloatingTitleBar r31, LinearLayout r32) {
        this.rootView = r3;
        this.apAdvancedOptions = r4;
        this.apAdvancedOptionsDivider = r5;
        this.apConnectionSpeed = r6;
        this.apIpAddress = r7;
        this.apNetworkSharing = r8;
        this.apSecurity = r9;
        this.apSignalStrength = r10;
        this.apStatusInfo = r11;
        this.apTrustNetwork = r12;
        this.apTrustNetworkTips = r13;
        this.autoConnectNetwork = r14;
        this.autoLoginNetwork = r15;
        this.disconnectBtn = r16;
        this.disconnectLayout = r17;
        this.forgetBtn = r18;
        this.forgetContainer = r19;
        this.macAddress = r20;
        this.modifyBtn = r21;
        this.modifyLayout = r22;
        this.networkSharingQrcode = r23;
        this.pageContainer = r24;
        this.pageScrollview = r25;
        this.prioritConnectNetwork = r26;
        this.prioritConnectNetworkDivider = r27;
        this.prioritConnectNetworkTips = r28;
        this.privacy = r29;
        this.trustLayout = r30;
        this.viewTitle = r31;
        this.wifiDppLayout = r32;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static AccessPointDetailFragmentBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static AccessPointDetailFragmentBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.access_point_detail_fragment, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static AccessPointDetailFragmentBinding bind(View r34) {
        int r1 = R.id.ap_advanced_options;
        OCardListItem r5 = (OCardListItem) ViewBindings.findChildViewById(r34, R.id.ap_advanced_options);
        if (r5 == null) goto L63;
        r1 = R.id.ap_advanced_options_divider;
        View r6 = ViewBindings.findChildViewById(r34, R.id.ap_advanced_options_divider);
        if (r6 == null) goto L63;
        r1 = R.id.ap_connection_speed;
        OCardListItem r7 = (OCardListItem) ViewBindings.findChildViewById(r34, R.id.ap_connection_speed);
        if (r7 == null) goto L63;
        r1 = R.id.ap_ip_address;
        OCardListItem r8 = (OCardListItem) ViewBindings.findChildViewById(r34, R.id.ap_ip_address);
        if (r8 == null) goto L63;
        r1 = R.id.ap_network_sharing;
        OUILinearLayout r9 = (OUILinearLayout) ViewBindings.findChildViewById(r34, R.id.ap_network_sharing);
        if (r9 == null) goto L63;
        r1 = R.id.ap_security;
        OCardListItem r10 = (OCardListItem) ViewBindings.findChildViewById(r34, R.id.ap_security);
        if (r10 == null) goto L63;
        r1 = R.id.ap_signal_strength;
        OCardListItem r11 = (OCardListItem) ViewBindings.findChildViewById(r34, R.id.ap_signal_strength);
        if (r11 == null) goto L63;
        r1 = R.id.ap_status_info;
        OCardListItem r12 = (OCardListItem) ViewBindings.findChildViewById(r34, R.id.ap_status_info);
        if (r12 == null) goto L63;
        r1 = R.id.ap_trust_network;
        OListItemSettings r13 = (OListItemSettings) ViewBindings.findChildViewById(r34, R.id.ap_trust_network);
        if (r13 == null) goto L63;
        r1 = R.id.ap_trust_network_tips;
        TextView r14 = (TextView) ViewBindings.findChildViewById(r34, R.id.ap_trust_network_tips);
        if (r14 == null) goto L63;
        r1 = R.id.auto_connect_network;
        OCardListItem r15 = (OCardListItem) ViewBindings.findChildViewById(r34, R.id.auto_connect_network);
        if (r15 == null) goto L63;
        r1 = R.id.auto_login_network;
        OCardListItem r16 = (OCardListItem) ViewBindings.findChildViewById(r34, R.id.auto_login_network);
        if (r16 == null) goto L63;
        r1 = R.id.disconnect_btn;
        OListItemSettings r17 = (OListItemSettings) ViewBindings.findChildViewById(r34, R.id.disconnect_btn);
        if (r17 == null) goto L63;
        r1 = R.id.disconnect_layout;
        LinearLayout r18 = (LinearLayout) ViewBindings.findChildViewById(r34, R.id.disconnect_layout);
        if (r18 == null) goto L63;
        r1 = R.id.forget_btn;
        OButton r19 = (OButton) ViewBindings.findChildViewById(r34, R.id.forget_btn);
        if (r19 == null) goto L63;
        r1 = R.id.forget_container;
        LinearLayout r20 = (LinearLayout) ViewBindings.findChildViewById(r34, R.id.forget_container);
        if (r20 == null) goto L63;
        r1 = R.id.mac_address;
        OCardListItem r21 = (OCardListItem) ViewBindings.findChildViewById(r34, R.id.mac_address);
        if (r21 == null) goto L63;
        r1 = R.id.modify_btn;
        OCardListItem r22 = (OCardListItem) ViewBindings.findChildViewById(r34, R.id.modify_btn);
        if (r22 == null) goto L63;
        r1 = R.id.modify_layout;
        LinearLayout r23 = (LinearLayout) ViewBindings.findChildViewById(r34, R.id.modify_layout);
        if (r23 == null) goto L63;
        r1 = R.id.network_sharing_qrcode;
        ImageView r24 = (ImageView) ViewBindings.findChildViewById(r34, R.id.network_sharing_qrcode);
        if (r24 == null) goto L63;
        r1 = R.id.page_container;
        LinearLayout r25 = (LinearLayout) ViewBindings.findChildViewById(r34, R.id.page_container);
        if (r25 == null) goto L63;
        r1 = R.id.page_scrollview;
        OScrollView r26 = (OScrollView) ViewBindings.findChildViewById(r34, R.id.page_scrollview);
        if (r26 == null) goto L63;
        r1 = R.id.priorit_connect_network;
        OCardListItem r27 = (OCardListItem) ViewBindings.findChildViewById(r34, R.id.priorit_connect_network);
        if (r27 == null) goto L63;
        r1 = R.id.priorit_connect_network_divider;
        View r28 = ViewBindings.findChildViewById(r34, R.id.priorit_connect_network_divider);
        if (r28 == null) goto L63;
        r1 = R.id.priorit_connect_network_tips;
        OSectionSupportiveText r29 = (OSectionSupportiveText) ViewBindings.findChildViewById(r34, R.id.priorit_connect_network_tips);
        if (r29 == null) goto L63;
        r1 = R.id.privacy;
        OCardListItem r30 = (OCardListItem) ViewBindings.findChildViewById(r34, R.id.privacy);
        if (r30 == null) goto L63;
        r1 = R.id.trust_layout;
        LinearLayout r31 = (LinearLayout) ViewBindings.findChildViewById(r34, R.id.trust_layout);
        if (r31 == null) goto L63;
        r1 = R.id.view_title;
        OFloatingTitleBar r32 = (OFloatingTitleBar) ViewBindings.findChildViewById(r34, R.id.view_title);
        if (r32 == null) goto L63;
        r1 = R.id.wifi_dpp_layout;
        LinearLayout r33 = (LinearLayout) ViewBindings.findChildViewById(r34, R.id.wifi_dpp_layout);
        if (r33 == null) goto L63;
        return new AccessPointDetailFragmentBinding((RelativeLayout) r34, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33);
    L63:
        throw new NullPointerException("Missing required view with ID: ".concat(r34.getResources().getResourceName(r1)));
    }
}
