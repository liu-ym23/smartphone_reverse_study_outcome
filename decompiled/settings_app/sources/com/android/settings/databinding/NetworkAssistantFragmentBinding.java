package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class NetworkAssistantFragmentBinding implements ViewBinding {
    public final OCardListItem autoOpenWifi;
    public final LinearLayout dynamicItems;
    public final OCardListItem itemIdWapiCertManage;
    public final OCardListItem itemIdWifiDataUsage;
    public final OCardListItem itemIdWifiDisplay;
    public final OCardListItem itemIdWifiP2p;
    public final OCardListItem multiWifi;
    public final ConstraintLayout pageContainer;
    private final RelativeLayout rootView;
    public final OScrollView scrollView;
    public final OFloatingTitleBar titleBar;
    public final OCardListItem wifiAssistantLocationPosition;
    public final OCardListItem wifiCellularDataFallback;
    public final OCardListItem wlanSecurityCheck;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private NetworkAssistantFragmentBinding(RelativeLayout r1, OCardListItem r2, LinearLayout r3, OCardListItem r4, OCardListItem r5, OCardListItem r6, OCardListItem r7, OCardListItem r8, ConstraintLayout r9, OScrollView r10, OFloatingTitleBar r11, OCardListItem r12, OCardListItem r13, OCardListItem r14) {
        this.rootView = r1;
        this.autoOpenWifi = r2;
        this.dynamicItems = r3;
        this.itemIdWapiCertManage = r4;
        this.itemIdWifiDataUsage = r5;
        this.itemIdWifiDisplay = r6;
        this.itemIdWifiP2p = r7;
        this.multiWifi = r8;
        this.pageContainer = r9;
        this.scrollView = r10;
        this.titleBar = r11;
        this.wifiAssistantLocationPosition = r12;
        this.wifiCellularDataFallback = r13;
        this.wlanSecurityCheck = r14;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static NetworkAssistantFragmentBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static NetworkAssistantFragmentBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.network_assistant_fragment, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static NetworkAssistantFragmentBinding bind(View r18) {
        int r1 = R.id.auto_open_wifi;
        OCardListItem r5 = (OCardListItem) ViewBindings.findChildViewById(r18, R.id.auto_open_wifi);
        if (r5 == null) goto L31;
        r1 = R.id.dynamicItems;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r18, R.id.dynamicItems);
        if (r6 == null) goto L31;
        r1 = R.id.item_id_wapi_cert_manage;
        OCardListItem r7 = (OCardListItem) ViewBindings.findChildViewById(r18, R.id.item_id_wapi_cert_manage);
        if (r7 == null) goto L31;
        r1 = R.id.item_id_wifi_data_usage;
        OCardListItem r8 = (OCardListItem) ViewBindings.findChildViewById(r18, R.id.item_id_wifi_data_usage);
        if (r8 == null) goto L31;
        r1 = R.id.item_id_wifi_display;
        OCardListItem r9 = (OCardListItem) ViewBindings.findChildViewById(r18, R.id.item_id_wifi_display);
        if (r9 == null) goto L31;
        r1 = R.id.item_id_wifi_p2p;
        OCardListItem r10 = (OCardListItem) ViewBindings.findChildViewById(r18, R.id.item_id_wifi_p2p);
        if (r10 == null) goto L31;
        r1 = R.id.multi_wifi;
        OCardListItem r11 = (OCardListItem) ViewBindings.findChildViewById(r18, R.id.multi_wifi);
        if (r11 == null) goto L31;
        r1 = R.id.page_container;
        ConstraintLayout r12 = (ConstraintLayout) ViewBindings.findChildViewById(r18, R.id.page_container);
        if (r12 == null) goto L31;
        r1 = R.id.scroll_view;
        OScrollView r13 = (OScrollView) ViewBindings.findChildViewById(r18, R.id.scroll_view);
        if (r13 == null) goto L31;
        r1 = R.id.title_bar;
        OFloatingTitleBar r14 = (OFloatingTitleBar) ViewBindings.findChildViewById(r18, R.id.title_bar);
        if (r14 == null) goto L31;
        r1 = R.id.wifi_assistant_location_position;
        OCardListItem r15 = (OCardListItem) ViewBindings.findChildViewById(r18, R.id.wifi_assistant_location_position);
        if (r15 == null) goto L31;
        r1 = R.id.wifi_cellular_data_fallback;
        OCardListItem r16 = (OCardListItem) ViewBindings.findChildViewById(r18, R.id.wifi_cellular_data_fallback);
        if (r16 == null) goto L31;
        r1 = R.id.wlan_security_check;
        OCardListItem r17 = (OCardListItem) ViewBindings.findChildViewById(r18, R.id.wlan_security_check);
        if (r17 == null) goto L31;
        return new NetworkAssistantFragmentBinding((RelativeLayout) r18, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);
    L31:
        throw new NullPointerException("Missing required view with ID: ".concat(r18.getResources().getResourceName(r1)));
    }
}
