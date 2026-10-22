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
import com.android.settings.widget.DataUsageCycleView;
import obric.widget.ListContentItemSwitch;
import obric.widget.ListContentItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class DataUsageHeaderBytedanceBinding implements ViewBinding {
    public final DataUsageCycleView cycleView;
    public final ListContentItemSwitch dataUsageAlarm;
    public final ListContentItemText dataUsageLimit;
    public final TextView dataUsageLimitTips;
    public final TextView empty;
    public final RadioButton powerUsageMonth;
    public final RadioButton powerUsageToday;
    public final RadioButton powerUsageWeek;
    private final LinearLayout rootView;
    public final ImageView simGuide;
    public final LinearLayout simGuideLayout;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private DataUsageHeaderBytedanceBinding(LinearLayout r1, DataUsageCycleView r2, ListContentItemSwitch r3, ListContentItemText r4, TextView r5, TextView r6, RadioButton r7, RadioButton r8, RadioButton r9, ImageView r10, LinearLayout r11) {
        this.rootView = r1;
        this.cycleView = r2;
        this.dataUsageAlarm = r3;
        this.dataUsageLimit = r4;
        this.dataUsageLimitTips = r5;
        this.empty = r6;
        this.powerUsageMonth = r7;
        this.powerUsageToday = r8;
        this.powerUsageWeek = r9;
        this.simGuide = r10;
        this.simGuideLayout = r11;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DataUsageHeaderBytedanceBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static DataUsageHeaderBytedanceBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.data_usage_header_bytedance, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static DataUsageHeaderBytedanceBinding bind(View r14) {
        int r0 = R.id.cycle_view;
        DataUsageCycleView r4 = (DataUsageCycleView) ViewBindings.findChildViewById(r14, R.id.cycle_view);
        if (r4 == null) goto L25;
        r0 = R.id.data_usage_alarm;
        ListContentItemSwitch r5 = (ListContentItemSwitch) ViewBindings.findChildViewById(r14, R.id.data_usage_alarm);
        if (r5 == null) goto L25;
        r0 = R.id.data_usage_limit;
        ListContentItemText r6 = (ListContentItemText) ViewBindings.findChildViewById(r14, R.id.data_usage_limit);
        if (r6 == null) goto L25;
        r0 = R.id.data_usage_limit_tips;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r14, R.id.data_usage_limit_tips);
        if (r7 == null) goto L25;
        r0 = android.R.id.empty;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r14, android.R.id.empty);
        if (r8 == null) goto L25;
        r0 = R.id.power_usage_month;
        RadioButton r9 = (RadioButton) ViewBindings.findChildViewById(r14, R.id.power_usage_month);
        if (r9 == null) goto L25;
        r0 = R.id.power_usage_today;
        RadioButton r10 = (RadioButton) ViewBindings.findChildViewById(r14, R.id.power_usage_today);
        if (r10 == null) goto L25;
        r0 = R.id.power_usage_week;
        RadioButton r11 = (RadioButton) ViewBindings.findChildViewById(r14, R.id.power_usage_week);
        if (r11 == null) goto L25;
        r0 = R.id.sim_guide;
        ImageView r12 = (ImageView) ViewBindings.findChildViewById(r14, R.id.sim_guide);
        if (r12 == null) goto L25;
        r0 = R.id.sim_guide_layout;
        LinearLayout r13 = (LinearLayout) ViewBindings.findChildViewById(r14, R.id.sim_guide_layout);
        if (r13 == null) goto L25;
        return new DataUsageHeaderBytedanceBinding((LinearLayout) r14, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r14.getResources().getResourceName(r0)));
    }
}
