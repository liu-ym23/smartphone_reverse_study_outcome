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
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import obric.widget.ListContentItemSwitch;
import obric.widget.ListContentItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class DataUsageLayoutMainBinding implements ViewBinding {
    public final LinearLayout commonDataLine;
    public final TextView correctTime;
    public final TextView data4GLeftTitle;
    public final TextView dataSpareTimeLeftTitle;
    public final TextView dataUsage4GLeft;
    public final TextView dataUsage4GLeftUnit;
    public final LinearLayout dataUsage4GLeftView;
    public final RelativeLayout dataUsageDetail;
    public final ImageView dataUsageLine;
    public final TextView dayToSettlement;
    public final LinearLayout dayToSettlementDataLine;
    public final TextView dayToSettlementTitle;
    public final TextView dayToSettlementUnit;
    public final RelativeLayout dayToSettlementView;
    public final RelativeLayout extraDataLine;
    public final ListContentItemText headArea;
    public final ListContentItemText itemDataUsageSettings;
    public final ListContentItemText itemDataUsageSort;
    public final TextView itemDatausageCorrecting;
    public final ListContentItemText itemRecharge;
    public final TextView monthUsed;
    public final TextView monthUsedTitle;
    public final TextView monthUsedUnit;
    public final RelativeLayout monthUsedView;
    public final LinearLayout monthUsedViewDataLine;
    public final ListContentItemSwitch networkOptimizationControl;
    public final ListContentItemText networkOptimizationSettings;
    public final TextView noData;
    private final LinearLayout rootView;
    public final TextView scanningSize;
    public final TextView scanningSizeUnit;
    public final LinearLayout selectedSize;
    public final TextView selectedText;
    public final OSectionTitleBar simCardName;
    public final TextView spareTimeLeft;
    public final TextView spareTimeLeftUnit;
    public final LinearLayout spareTimeLeftView;
    public final TextView todayUsed;
    public final TextView todayUsedTitle;
    public final TextView todayUsedUnit;
    public final RelativeLayout todayUsedView;
    public final LinearLayout todayUsedViewDataLine;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private DataUsageLayoutMainBinding(LinearLayout r3, LinearLayout r4, TextView r5, TextView r6, TextView r7, TextView r8, TextView r9, LinearLayout r10, RelativeLayout r11, ImageView r12, TextView r13, LinearLayout r14, TextView r15, TextView r16, RelativeLayout r17, RelativeLayout r18, ListContentItemText r19, ListContentItemText r20, ListContentItemText r21, TextView r22, ListContentItemText r23, TextView r24, TextView r25, TextView r26, RelativeLayout r27, LinearLayout r28, ListContentItemSwitch r29, ListContentItemText r30, TextView r31, TextView r32, TextView r33, LinearLayout r34, TextView r35, OSectionTitleBar r36, TextView r37, TextView r38, LinearLayout r39, TextView r40, TextView r41, TextView r42, RelativeLayout r43, LinearLayout r44) {
        this.rootView = r3;
        this.commonDataLine = r4;
        this.correctTime = r5;
        this.data4GLeftTitle = r6;
        this.dataSpareTimeLeftTitle = r7;
        this.dataUsage4GLeft = r8;
        this.dataUsage4GLeftUnit = r9;
        this.dataUsage4GLeftView = r10;
        this.dataUsageDetail = r11;
        this.dataUsageLine = r12;
        this.dayToSettlement = r13;
        this.dayToSettlementDataLine = r14;
        this.dayToSettlementTitle = r15;
        this.dayToSettlementUnit = r16;
        this.dayToSettlementView = r17;
        this.extraDataLine = r18;
        this.headArea = r19;
        this.itemDataUsageSettings = r20;
        this.itemDataUsageSort = r21;
        this.itemDatausageCorrecting = r22;
        this.itemRecharge = r23;
        this.monthUsed = r24;
        this.monthUsedTitle = r25;
        this.monthUsedUnit = r26;
        this.monthUsedView = r27;
        this.monthUsedViewDataLine = r28;
        this.networkOptimizationControl = r29;
        this.networkOptimizationSettings = r30;
        this.noData = r31;
        this.scanningSize = r32;
        this.scanningSizeUnit = r33;
        this.selectedSize = r34;
        this.selectedText = r35;
        this.simCardName = r36;
        this.spareTimeLeft = r37;
        this.spareTimeLeftUnit = r38;
        this.spareTimeLeftView = r39;
        this.todayUsed = r40;
        this.todayUsedTitle = r41;
        this.todayUsedUnit = r42;
        this.todayUsedView = r43;
        this.todayUsedViewDataLine = r44;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DataUsageLayoutMainBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static DataUsageLayoutMainBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.data_usage_layout_main, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static DataUsageLayoutMainBinding bind(View r46) {
        int r1 = R.id.common_data_line;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r46, R.id.common_data_line);
        if (r5 == null) goto L87;
        r1 = R.id.correct_time;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r46, R.id.correct_time);
        if (r6 == null) goto L87;
        r1 = R.id.data_4G_left_title;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r46, R.id.data_4G_left_title);
        if (r7 == null) goto L87;
        r1 = R.id.data_spare_time_left_title;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r46, R.id.data_spare_time_left_title);
        if (r8 == null) goto L87;
        r1 = R.id.data_usage_4G_left;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r46, R.id.data_usage_4G_left);
        if (r9 == null) goto L87;
        r1 = R.id.data_usage_4G_left_unit;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r46, R.id.data_usage_4G_left_unit);
        if (r10 == null) goto L87;
        r1 = R.id.data_usage_4G_left_view;
        LinearLayout r11 = (LinearLayout) ViewBindings.findChildViewById(r46, R.id.data_usage_4G_left_view);
        if (r11 == null) goto L87;
        r1 = R.id.data_usage_detail;
        RelativeLayout r12 = (RelativeLayout) ViewBindings.findChildViewById(r46, R.id.data_usage_detail);
        if (r12 == null) goto L87;
        r1 = R.id.data_usage_line;
        ImageView r13 = (ImageView) ViewBindings.findChildViewById(r46, R.id.data_usage_line);
        if (r13 == null) goto L87;
        r1 = R.id.day_to_settlement;
        TextView r14 = (TextView) ViewBindings.findChildViewById(r46, R.id.day_to_settlement);
        if (r14 == null) goto L87;
        r1 = R.id.day_to_settlement_data_line;
        LinearLayout r15 = (LinearLayout) ViewBindings.findChildViewById(r46, R.id.day_to_settlement_data_line);
        if (r15 == null) goto L87;
        r1 = R.id.day_to_settlement_title;
        TextView r16 = (TextView) ViewBindings.findChildViewById(r46, R.id.day_to_settlement_title);
        if (r16 == null) goto L87;
        r1 = R.id.day_to_settlement_unit;
        TextView r17 = (TextView) ViewBindings.findChildViewById(r46, R.id.day_to_settlement_unit);
        if (r17 == null) goto L87;
        r1 = R.id.day_to_settlement_view;
        RelativeLayout r18 = (RelativeLayout) ViewBindings.findChildViewById(r46, R.id.day_to_settlement_view);
        if (r18 == null) goto L87;
        r1 = R.id.extra_data_line;
        RelativeLayout r19 = (RelativeLayout) ViewBindings.findChildViewById(r46, R.id.extra_data_line);
        if (r19 == null) goto L87;
        r1 = R.id.head_area;
        ListContentItemText r20 = (ListContentItemText) ViewBindings.findChildViewById(r46, R.id.head_area);
        if (r20 == null) goto L87;
        r1 = R.id.item_data_usage_settings;
        ListContentItemText r21 = (ListContentItemText) ViewBindings.findChildViewById(r46, R.id.item_data_usage_settings);
        if (r21 == null) goto L87;
        r1 = R.id.item_data_usage_sort;
        ListContentItemText r22 = (ListContentItemText) ViewBindings.findChildViewById(r46, R.id.item_data_usage_sort);
        if (r22 == null) goto L87;
        r1 = R.id.item_datausage_correcting;
        TextView r23 = (TextView) ViewBindings.findChildViewById(r46, R.id.item_datausage_correcting);
        if (r23 == null) goto L87;
        r1 = R.id.item_recharge;
        ListContentItemText r24 = (ListContentItemText) ViewBindings.findChildViewById(r46, R.id.item_recharge);
        if (r24 == null) goto L87;
        r1 = R.id.month_used;
        TextView r25 = (TextView) ViewBindings.findChildViewById(r46, R.id.month_used);
        if (r25 == null) goto L87;
        r1 = R.id.month_used_title;
        TextView r26 = (TextView) ViewBindings.findChildViewById(r46, R.id.month_used_title);
        if (r26 == null) goto L87;
        r1 = R.id.month_used_unit;
        TextView r27 = (TextView) ViewBindings.findChildViewById(r46, R.id.month_used_unit);
        if (r27 == null) goto L87;
        r1 = R.id.month_used_view;
        RelativeLayout r28 = (RelativeLayout) ViewBindings.findChildViewById(r46, R.id.month_used_view);
        if (r28 == null) goto L87;
        r1 = R.id.month_used_view_data_line;
        LinearLayout r29 = (LinearLayout) ViewBindings.findChildViewById(r46, R.id.month_used_view_data_line);
        if (r29 == null) goto L87;
        r1 = R.id.network_optimization_control;
        ListContentItemSwitch r30 = (ListContentItemSwitch) ViewBindings.findChildViewById(r46, R.id.network_optimization_control);
        if (r30 == null) goto L87;
        r1 = R.id.network_optimization_settings;
        ListContentItemText r31 = (ListContentItemText) ViewBindings.findChildViewById(r46, R.id.network_optimization_settings);
        if (r31 == null) goto L87;
        r1 = R.id.no_data;
        TextView r32 = (TextView) ViewBindings.findChildViewById(r46, R.id.no_data);
        if (r32 == null) goto L87;
        r1 = R.id.scanning_size;
        TextView r33 = (TextView) ViewBindings.findChildViewById(r46, R.id.scanning_size);
        if (r33 == null) goto L87;
        r1 = R.id.scanning_size_unit;
        TextView r34 = (TextView) ViewBindings.findChildViewById(r46, R.id.scanning_size_unit);
        if (r34 == null) goto L87;
        r1 = R.id.selected_size;
        LinearLayout r35 = (LinearLayout) ViewBindings.findChildViewById(r46, R.id.selected_size);
        if (r35 == null) goto L87;
        r1 = R.id.selected_text;
        TextView r36 = (TextView) ViewBindings.findChildViewById(r46, R.id.selected_text);
        if (r36 == null) goto L87;
        r1 = R.id.sim_card_name;
        OSectionTitleBar r37 = (OSectionTitleBar) ViewBindings.findChildViewById(r46, R.id.sim_card_name);
        if (r37 == null) goto L87;
        r1 = R.id.spare_time_left;
        TextView r38 = (TextView) ViewBindings.findChildViewById(r46, R.id.spare_time_left);
        if (r38 == null) goto L87;
        r1 = R.id.spare_time_left_unit;
        TextView r39 = (TextView) ViewBindings.findChildViewById(r46, R.id.spare_time_left_unit);
        if (r39 == null) goto L87;
        r1 = R.id.spare_time_left_view;
        LinearLayout r40 = (LinearLayout) ViewBindings.findChildViewById(r46, R.id.spare_time_left_view);
        if (r40 == null) goto L87;
        r1 = R.id.today_used;
        TextView r41 = (TextView) ViewBindings.findChildViewById(r46, R.id.today_used);
        if (r41 == null) goto L87;
        r1 = R.id.today_used_title;
        TextView r42 = (TextView) ViewBindings.findChildViewById(r46, R.id.today_used_title);
        if (r42 == null) goto L87;
        r1 = R.id.today_used_unit;
        TextView r43 = (TextView) ViewBindings.findChildViewById(r46, R.id.today_used_unit);
        if (r43 == null) goto L87;
        r1 = R.id.today_used_view;
        RelativeLayout r44 = (RelativeLayout) ViewBindings.findChildViewById(r46, R.id.today_used_view);
        if (r44 == null) goto L87;
        r1 = R.id.today_used_view_data_line;
        LinearLayout r45 = (LinearLayout) ViewBindings.findChildViewById(r46, R.id.today_used_view_data_line);
        if (r45 == null) goto L87;
        return new DataUsageLayoutMainBinding((LinearLayout) r46, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45);
    L87:
        throw new NullPointerException("Missing required view with ID: ".concat(r46.getResources().getResourceName(r1)));
    }
}
