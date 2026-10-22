package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.PowerUsageCycleView;
import obric.widget.ListContentItemSwitch;
import obric.widget.ListContentItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class PowerUsageHeaderBinding implements ViewBinding {
    public final ListContentItemText appBatteryUseOptimization;
    public final TextView batteryLevel;
    public final ImageView batteryStatus;
    public final PowerUsageCycleView cycleView;
    public final ListContentItemText dynamicResolution;
    public final ListContentItemSwitch networkOptimizationControl;
    public final ListContentItemText networkOptimizationSettings;
    public final ListContentItemText powerUsageCycle;
    public final RadioButton powerUsageMonth;
    public final TextView powerUsageRank;
    public final LinearLayout powerUsageSummary;
    public final RadioButton powerUsageToday;
    public final RadioButton powerUsageWeek;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private PowerUsageHeaderBinding(LinearLayout r1, ListContentItemText r2, TextView r3, ImageView r4, PowerUsageCycleView r5, ListContentItemText r6, ListContentItemSwitch r7, ListContentItemText r8, ListContentItemText r9, RadioButton r10, TextView r11, LinearLayout r12, RadioButton r13, RadioButton r14) {
        this.rootView = r1;
        this.appBatteryUseOptimization = r2;
        this.batteryLevel = r3;
        this.batteryStatus = r4;
        this.cycleView = r5;
        this.dynamicResolution = r6;
        this.networkOptimizationControl = r7;
        this.networkOptimizationSettings = r8;
        this.powerUsageCycle = r9;
        this.powerUsageMonth = r10;
        this.powerUsageRank = r11;
        this.powerUsageSummary = r12;
        this.powerUsageToday = r13;
        this.powerUsageWeek = r14;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static PowerUsageHeaderBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static PowerUsageHeaderBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.power_usage_header, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static PowerUsageHeaderBinding bind(View r18) {
        int r1 = R.id.app_battery_use_optimization;
        ListContentItemText r5 = (ListContentItemText) ViewBindings.findChildViewById(r18, R.id.app_battery_use_optimization);
        if (r5 == null) goto L31;
        r1 = R.id.battery_level;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r18, R.id.battery_level);
        if (r6 == null) goto L31;
        r1 = R.id.battery_status;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(r18, R.id.battery_status);
        if (r7 == null) goto L31;
        r1 = R.id.cycle_view;
        PowerUsageCycleView r8 = (PowerUsageCycleView) ViewBindings.findChildViewById(r18, R.id.cycle_view);
        if (r8 == null) goto L31;
        r1 = R.id.dynamic_resolution;
        ListContentItemText r9 = (ListContentItemText) ViewBindings.findChildViewById(r18, R.id.dynamic_resolution);
        if (r9 == null) goto L31;
        r1 = R.id.network_optimization_control;
        ListContentItemSwitch r10 = (ListContentItemSwitch) ViewBindings.findChildViewById(r18, R.id.network_optimization_control);
        if (r10 == null) goto L31;
        r1 = R.id.network_optimization_settings;
        ListContentItemText r11 = (ListContentItemText) ViewBindings.findChildViewById(r18, R.id.network_optimization_settings);
        if (r11 == null) goto L31;
        r1 = R.id.power_usage_cycle;
        ListContentItemText r12 = (ListContentItemText) ViewBindings.findChildViewById(r18, R.id.power_usage_cycle);
        if (r12 == null) goto L31;
        r1 = R.id.power_usage_month;
        RadioButton r13 = (RadioButton) ViewBindings.findChildViewById(r18, R.id.power_usage_month);
        if (r13 == null) goto L31;
        r1 = R.id.power_usage_rank;
        TextView r14 = (TextView) ViewBindings.findChildViewById(r18, R.id.power_usage_rank);
        if (r14 == null) goto L31;
        r1 = R.id.power_usage_summary;
        LinearLayout r15 = (LinearLayout) ViewBindings.findChildViewById(r18, R.id.power_usage_summary);
        if (r15 == null) goto L31;
        r1 = R.id.power_usage_today;
        RadioButton r16 = (RadioButton) ViewBindings.findChildViewById(r18, R.id.power_usage_today);
        if (r16 == null) goto L31;
        r1 = R.id.power_usage_week;
        RadioButton r17 = (RadioButton) ViewBindings.findChildViewById(r18, R.id.power_usage_week);
        if (r17 == null) goto L31;
        return new PowerUsageHeaderBinding((LinearLayout) r18, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);
    L31:
        throw new NullPointerException("Missing required view with ID: ".concat(r18.getResources().getResourceName(r1)));
    }
}
