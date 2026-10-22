package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.lisitem.OListItemSettings;
import obric.widget.ListContentItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public final class WifiSettingsBottomSwitchesBinding implements ViewBinding {
    public final ViewStub advanceWifiVs;
    public final OListItemSettings itemIdWifiDisplay;
    public final OListItemSettings itemIdWifiP2p;
    public final OListItemSettings itemSavedWifiSettings;
    private final RelativeLayout rootView;
    public final ListContentItemSwitch switchKeepConnection;
    public final RelativeLayout switches;
    public final OListItemSettings wifiAssistantLocationPosition;
    public final TextView wifiAssistantLocationPositionTips;
    public final OListItemSettings wifiCellularDataFallback;
    public final TextView wifiCellularDataFallbackTips;
    public final TextView wifiDisplayTips;
    public final LinearLayout wifiKeepConnectionContainer;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private WifiSettingsBottomSwitchesBinding(RelativeLayout r1, ViewStub r2, OListItemSettings r3, OListItemSettings r4, OListItemSettings r5, ListContentItemSwitch r6, RelativeLayout r7, OListItemSettings r8, TextView r9, OListItemSettings r10, TextView r11, TextView r12, LinearLayout r13) {
        this.rootView = r1;
        this.advanceWifiVs = r2;
        this.itemIdWifiDisplay = r3;
        this.itemIdWifiP2p = r4;
        this.itemSavedWifiSettings = r5;
        this.switchKeepConnection = r6;
        this.switches = r7;
        this.wifiAssistantLocationPosition = r8;
        this.wifiAssistantLocationPositionTips = r9;
        this.wifiCellularDataFallback = r10;
        this.wifiCellularDataFallbackTips = r11;
        this.wifiDisplayTips = r12;
        this.wifiKeepConnectionContainer = r13;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static WifiSettingsBottomSwitchesBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static WifiSettingsBottomSwitchesBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.wifi_settings_bottom_switches, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static WifiSettingsBottomSwitchesBinding bind(View r17) {
        int r1 = R.id.advance_wifi_vs;
        ViewStub r5 = (ViewStub) ViewBindings.findChildViewById(r17, R.id.advance_wifi_vs);
        if (r5 == null) goto L27;
        r1 = R.id.item_id_wifi_display;
        OListItemSettings r6 = (OListItemSettings) ViewBindings.findChildViewById(r17, R.id.item_id_wifi_display);
        if (r6 == null) goto L27;
        r1 = R.id.item_id_wifi_p2p;
        OListItemSettings r7 = (OListItemSettings) ViewBindings.findChildViewById(r17, R.id.item_id_wifi_p2p);
        if (r7 == null) goto L27;
        r1 = R.id.item_saved_wifi_settings;
        OListItemSettings r8 = (OListItemSettings) ViewBindings.findChildViewById(r17, R.id.item_saved_wifi_settings);
        if (r8 == null) goto L27;
        r1 = R.id.switch_keep_connection;
        ListContentItemSwitch r9 = (ListContentItemSwitch) ViewBindings.findChildViewById(r17, R.id.switch_keep_connection);
        if (r9 == null) goto L27;
        RelativeLayout r10 = (RelativeLayout) r17;
        r1 = R.id.wifi_assistant_location_position;
        OListItemSettings r11 = (OListItemSettings) ViewBindings.findChildViewById(r17, R.id.wifi_assistant_location_position);
        if (r11 == null) goto L27;
        r1 = R.id.wifi_assistant_location_position_tips;
        TextView r12 = (TextView) ViewBindings.findChildViewById(r17, R.id.wifi_assistant_location_position_tips);
        if (r12 == null) goto L27;
        r1 = R.id.wifi_cellular_data_fallback;
        OListItemSettings r13 = (OListItemSettings) ViewBindings.findChildViewById(r17, R.id.wifi_cellular_data_fallback);
        if (r13 == null) goto L27;
        r1 = R.id.wifi_cellular_data_fallback_tips;
        TextView r14 = (TextView) ViewBindings.findChildViewById(r17, R.id.wifi_cellular_data_fallback_tips);
        if (r14 == null) goto L27;
        r1 = R.id.wifi_display_tips;
        TextView r15 = (TextView) ViewBindings.findChildViewById(r17, R.id.wifi_display_tips);
        if (r15 == null) goto L27;
        r1 = R.id.wifi_keep_connection_container;
        LinearLayout r16 = (LinearLayout) ViewBindings.findChildViewById(r17, R.id.wifi_keep_connection_container);
        if (r16 == null) goto L27;
        return new WifiSettingsBottomSwitchesBinding(r10, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16);
    L27:
        throw new NullPointerException("Missing required view with ID: ".concat(r17.getResources().getResourceName(r1)));
    }
}
