package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class WifiApSettingsLayoutBinding implements ViewBinding {
    public final OUILinearLayout apNetworkSharing;
    public final OCardListItem itemWifiApSetting;
    public final OCardListItem itemWifiTetherConnectedStations;
    public final ImageView networkSharingQrcode;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final OCardListItem switchWifiAp;
    public final OFloatingTitleBar viewTitle;
    public final OSectionSupportiveText wifiApTips;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private WifiApSettingsLayoutBinding(RelativeLayout r1, OUILinearLayout r2, OCardListItem r3, OCardListItem r4, ImageView r5, LinearLayout r6, OScrollView r7, OCardListItem r8, OFloatingTitleBar r9, OSectionSupportiveText r10) {
        this.rootView = r1;
        this.apNetworkSharing = r2;
        this.itemWifiApSetting = r3;
        this.itemWifiTetherConnectedStations = r4;
        this.networkSharingQrcode = r5;
        this.pageContainer = r6;
        this.pageScrollview = r7;
        this.switchWifiAp = r8;
        this.viewTitle = r9;
        this.wifiApTips = r10;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static WifiApSettingsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static WifiApSettingsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.wifi_ap_settings_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static WifiApSettingsLayoutBinding bind(View r13) {
        int r0 = R.id.ap_network_sharing;
        OUILinearLayout r4 = (OUILinearLayout) ViewBindings.findChildViewById(r13, R.id.ap_network_sharing);
        if (r4 == null) goto L23;
        r0 = R.id.item_wifi_ap_setting;
        OCardListItem r5 = (OCardListItem) ViewBindings.findChildViewById(r13, R.id.item_wifi_ap_setting);
        if (r5 == null) goto L23;
        r0 = R.id.item_wifi_tether_connected_stations;
        OCardListItem r6 = (OCardListItem) ViewBindings.findChildViewById(r13, R.id.item_wifi_tether_connected_stations);
        if (r6 == null) goto L23;
        r0 = R.id.network_sharing_qrcode;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(r13, R.id.network_sharing_qrcode);
        if (r7 == null) goto L23;
        r0 = R.id.page_container;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r13, R.id.page_container);
        if (r8 == null) goto L23;
        r0 = R.id.page_scrollview;
        OScrollView r9 = (OScrollView) ViewBindings.findChildViewById(r13, R.id.page_scrollview);
        if (r9 == null) goto L23;
        r0 = R.id.switch_wifi_ap;
        OCardListItem r10 = (OCardListItem) ViewBindings.findChildViewById(r13, R.id.switch_wifi_ap);
        if (r10 == null) goto L23;
        r0 = R.id.view_title;
        OFloatingTitleBar r11 = (OFloatingTitleBar) ViewBindings.findChildViewById(r13, R.id.view_title);
        if (r11 == null) goto L23;
        r0 = R.id.wifi_ap_tips;
        OSectionSupportiveText r12 = (OSectionSupportiveText) ViewBindings.findChildViewById(r13, R.id.wifi_ap_tips);
        if (r12 == null) goto L23;
        return new WifiApSettingsLayoutBinding((RelativeLayout) r13, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r0)));
    }
}
