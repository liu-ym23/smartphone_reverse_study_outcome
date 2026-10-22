package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.AboutStaticItem;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class DeviceLandeStatusLayoutBinding implements ViewBinding {
    public final AboutStaticItem batteryLevel;
    public final AboutStaticItem batteryStatus;
    public final AboutStaticItem btAddress;
    public final AboutStaticItem cmiitId;
    public final AboutStaticItem fccId;
    public final AboutStaticItem imei;
    public final AboutStaticItem imeiSv;
    private final RelativeLayout rootView;
    public final AboutStaticItem serialNumber;
    public final AboutStaticItem sim1;
    public final AboutStaticItem sim2;
    public final LinearLayout simStatusEntranceLayout;
    public final FrameLayout simStatusFragmentContainer;
    public final OScrollView statusContainer;
    public final AboutStaticItem upTime;
    public final OFloatingTitleBar viewTitle;
    public final AboutStaticItem wifiIpAddress;
    public final AboutStaticItem wifiMacAddress;
    public final AboutStaticItem wimaxMacAddress;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private DeviceLandeStatusLayoutBinding(RelativeLayout r3, AboutStaticItem r4, AboutStaticItem r5, AboutStaticItem r6, AboutStaticItem r7, AboutStaticItem r8, AboutStaticItem r9, AboutStaticItem r10, AboutStaticItem r11, AboutStaticItem r12, AboutStaticItem r13, LinearLayout r14, FrameLayout r15, OScrollView r16, AboutStaticItem r17, OFloatingTitleBar r18, AboutStaticItem r19, AboutStaticItem r20, AboutStaticItem r21) {
        this.rootView = r3;
        this.batteryLevel = r4;
        this.batteryStatus = r5;
        this.btAddress = r6;
        this.cmiitId = r7;
        this.fccId = r8;
        this.imei = r9;
        this.imeiSv = r10;
        this.serialNumber = r11;
        this.sim1 = r12;
        this.sim2 = r13;
        this.simStatusEntranceLayout = r14;
        this.simStatusFragmentContainer = r15;
        this.statusContainer = r16;
        this.upTime = r17;
        this.viewTitle = r18;
        this.wifiIpAddress = r19;
        this.wifiMacAddress = r20;
        this.wimaxMacAddress = r21;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static DeviceLandeStatusLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static DeviceLandeStatusLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.device_lande_status_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static DeviceLandeStatusLayoutBinding bind(View r23) {
        int r1 = R.id.battery_level;
        AboutStaticItem r5 = (AboutStaticItem) ViewBindings.findChildViewById(r23, R.id.battery_level);
        if (r5 == null) goto L41;
        r1 = R.id.battery_status;
        AboutStaticItem r6 = (AboutStaticItem) ViewBindings.findChildViewById(r23, R.id.battery_status);
        if (r6 == null) goto L41;
        r1 = R.id.bt_address;
        AboutStaticItem r7 = (AboutStaticItem) ViewBindings.findChildViewById(r23, R.id.bt_address);
        if (r7 == null) goto L41;
        r1 = R.id.cmiit_id;
        AboutStaticItem r8 = (AboutStaticItem) ViewBindings.findChildViewById(r23, R.id.cmiit_id);
        if (r8 == null) goto L41;
        r1 = R.id.fcc_id;
        AboutStaticItem r9 = (AboutStaticItem) ViewBindings.findChildViewById(r23, R.id.fcc_id);
        if (r9 == null) goto L41;
        r1 = R.id.imei;
        AboutStaticItem r10 = (AboutStaticItem) ViewBindings.findChildViewById(r23, R.id.imei);
        if (r10 == null) goto L41;
        r1 = R.id.imei_sv;
        AboutStaticItem r11 = (AboutStaticItem) ViewBindings.findChildViewById(r23, R.id.imei_sv);
        if (r11 == null) goto L41;
        r1 = R.id.serial_number;
        AboutStaticItem r12 = (AboutStaticItem) ViewBindings.findChildViewById(r23, R.id.serial_number);
        if (r12 == null) goto L41;
        r1 = R.id.sim_1;
        AboutStaticItem r13 = (AboutStaticItem) ViewBindings.findChildViewById(r23, R.id.sim_1);
        if (r13 == null) goto L41;
        r1 = R.id.sim_2;
        AboutStaticItem r14 = (AboutStaticItem) ViewBindings.findChildViewById(r23, R.id.sim_2);
        if (r14 == null) goto L41;
        r1 = R.id.sim_status_entrance_layout;
        LinearLayout r15 = (LinearLayout) ViewBindings.findChildViewById(r23, R.id.sim_status_entrance_layout);
        if (r15 == null) goto L41;
        r1 = R.id.sim_status_fragment_container;
        FrameLayout r16 = (FrameLayout) ViewBindings.findChildViewById(r23, R.id.sim_status_fragment_container);
        if (r16 == null) goto L41;
        r1 = R.id.status_container;
        OScrollView r17 = (OScrollView) ViewBindings.findChildViewById(r23, R.id.status_container);
        if (r17 == null) goto L41;
        r1 = R.id.up_time;
        AboutStaticItem r18 = (AboutStaticItem) ViewBindings.findChildViewById(r23, R.id.up_time);
        if (r18 == null) goto L41;
        r1 = R.id.view_title;
        OFloatingTitleBar r19 = (OFloatingTitleBar) ViewBindings.findChildViewById(r23, R.id.view_title);
        if (r19 == null) goto L41;
        r1 = R.id.wifi_ip_address;
        AboutStaticItem r20 = (AboutStaticItem) ViewBindings.findChildViewById(r23, R.id.wifi_ip_address);
        if (r20 == null) goto L41;
        r1 = R.id.wifi_mac_address;
        AboutStaticItem r21 = (AboutStaticItem) ViewBindings.findChildViewById(r23, R.id.wifi_mac_address);
        if (r21 == null) goto L41;
        r1 = R.id.wimax_mac_address;
        AboutStaticItem r22 = (AboutStaticItem) ViewBindings.findChildViewById(r23, R.id.wimax_mac_address);
        if (r22 == null) goto L41;
        return new DeviceLandeStatusLayoutBinding((RelativeLayout) r23, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    L41:
        throw new NullPointerException("Missing required view with ID: ".concat(r23.getResources().getResourceName(r1)));
    }
}
