package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.graph.UsageView;

/* JADX INFO: loaded from: classes2.dex */
public final class BatteryHistoryDetailBinding implements ViewBinding {
    public final UsageView batteryUsage;
    public final BatteryActiveViewBinding cameraGroup;
    public final BatteryActiveViewBinding cellNetworkGroup;
    public final TextView charge;
    public final BatteryActiveViewBinding chargingGroup;
    public final BatteryActiveViewBinding cpuGroup;
    public final TextView estimation;
    public final BatteryActiveViewBinding flashlightGroup;
    public final BatteryActiveViewBinding gpsGroup;
    private final LinearLayout rootView;
    public final BatteryActiveViewBinding screenOnGroup;
    public final BatteryActiveViewBinding wifiGroup;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private BatteryHistoryDetailBinding(LinearLayout r1, UsageView r2, BatteryActiveViewBinding r3, BatteryActiveViewBinding r4, TextView r5, BatteryActiveViewBinding r6, BatteryActiveViewBinding r7, TextView r8, BatteryActiveViewBinding r9, BatteryActiveViewBinding r10, BatteryActiveViewBinding r11, BatteryActiveViewBinding r12) {
        this.rootView = r1;
        this.batteryUsage = r2;
        this.cameraGroup = r3;
        this.cellNetworkGroup = r4;
        this.charge = r5;
        this.chargingGroup = r6;
        this.cpuGroup = r7;
        this.estimation = r8;
        this.flashlightGroup = r9;
        this.gpsGroup = r10;
        this.screenOnGroup = r11;
        this.wifiGroup = r12;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BatteryHistoryDetailBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static BatteryHistoryDetailBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.battery_history_detail, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static BatteryHistoryDetailBinding bind(View r15) {
        int r0 = R.id.battery_usage;
        UsageView r4 = (UsageView) ViewBindings.findChildViewById(r15, R.id.battery_usage);
        if (r4 == null) goto L27;
        r0 = R.id.camera_group;
        View r1 = ViewBindings.findChildViewById(r15, R.id.camera_group);
        if (r1 == null) goto L27;
        BatteryActiveViewBinding r5 = BatteryActiveViewBinding.bind(r1);
        r0 = R.id.cell_network_group;
        View r2 = ViewBindings.findChildViewById(r15, R.id.cell_network_group);
        if (r2 == null) goto L27;
        BatteryActiveViewBinding r6 = BatteryActiveViewBinding.bind(r2);
        r0 = R.id.charge;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r15, R.id.charge);
        if (r7 == null) goto L27;
        r0 = R.id.charging_group;
        View r3 = ViewBindings.findChildViewById(r15, R.id.charging_group);
        if (r3 == null) goto L27;
        BatteryActiveViewBinding r8 = BatteryActiveViewBinding.bind(r3);
        r0 = R.id.cpu_group;
        View r9 = ViewBindings.findChildViewById(r15, R.id.cpu_group);
        if (r9 == null) goto L27;
        BatteryActiveViewBinding r10 = BatteryActiveViewBinding.bind(r9);
        r0 = R.id.estimation;
        TextView r11 = (TextView) ViewBindings.findChildViewById(r15, R.id.estimation);
        if (r11 == null) goto L27;
        r0 = R.id.flashlight_group;
        View r12 = ViewBindings.findChildViewById(r15, R.id.flashlight_group);
        if (r12 == null) goto L27;
        BatteryActiveViewBinding r13 = BatteryActiveViewBinding.bind(r12);
        r0 = R.id.gps_group;
        View r14 = ViewBindings.findChildViewById(r15, R.id.gps_group);
        if (r14 == null) goto L27;
        BatteryActiveViewBinding r16 = BatteryActiveViewBinding.bind(r14);
        r0 = R.id.screen_on_group;
        View r17 = ViewBindings.findChildViewById(r15, R.id.screen_on_group);
        if (r17 == null) goto L27;
        BatteryActiveViewBinding r18 = BatteryActiveViewBinding.bind(r17);
        r0 = R.id.wifi_group;
        View r19 = ViewBindings.findChildViewById(r15, R.id.wifi_group);
        if (r19 == null) goto L27;
        LinearLayout r20 = (LinearLayout) r15;
        return new BatteryHistoryDetailBinding(r20, r4, r5, r6, r7, r8, r10, r11, r13, r16, r18, BatteryActiveViewBinding.bind(r19));
    L27:
        throw new NullPointerException("Missing required view with ID: ".concat(r15.getResources().getResourceName(r0)));
    }
}
