package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.ChartDataUsageView;
import com.android.settings.widget.ChartGridView;
import com.android.settings.widget.ChartNetworkSeriesView;
import com.android.settings.widget.ChartSweepView;

/* JADX INFO: loaded from: classes2.dex */
public final class DataUsageChartBinding implements ViewBinding {
    public final ChartDataUsageView chart;
    public final ChartNetworkSeriesView detailSeries;
    public final ChartGridView grid;
    private final ChartDataUsageView rootView;
    public final ChartNetworkSeriesView series;
    public final ChartSweepView sweepLeft;
    public final ChartSweepView sweepLimit;
    public final ChartSweepView sweepRight;
    public final ChartSweepView sweepWarning;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private DataUsageChartBinding(ChartDataUsageView r1, ChartDataUsageView r2, ChartNetworkSeriesView r3, ChartGridView r4, ChartNetworkSeriesView r5, ChartSweepView r6, ChartSweepView r7, ChartSweepView r8, ChartSweepView r9) {
        this.rootView = r1;
        this.chart = r2;
        this.detailSeries = r3;
        this.grid = r4;
        this.series = r5;
        this.sweepLeft = r6;
        this.sweepLimit = r7;
        this.sweepRight = r8;
        this.sweepWarning = r9;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ChartDataUsageView getRoot() {
        return this.rootView;
    }

    public static DataUsageChartBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static DataUsageChartBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.data_usage_chart, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static DataUsageChartBinding bind(View r10) {
        ChartDataUsageView r2 = (ChartDataUsageView) r10;
        int r0 = R.id.detail_series;
        ChartNetworkSeriesView r3 = (ChartNetworkSeriesView) ViewBindings.findChildViewById(r10, R.id.detail_series);
        if (r3 == null) goto L19;
        r0 = R.id.grid;
        ChartGridView r4 = (ChartGridView) ViewBindings.findChildViewById(r10, R.id.grid);
        if (r4 == null) goto L19;
        r0 = R.id.series;
        ChartNetworkSeriesView r5 = (ChartNetworkSeriesView) ViewBindings.findChildViewById(r10, R.id.series);
        if (r5 == null) goto L19;
        r0 = R.id.sweep_left;
        ChartSweepView r6 = (ChartSweepView) ViewBindings.findChildViewById(r10, R.id.sweep_left);
        if (r6 == null) goto L19;
        r0 = R.id.sweep_limit;
        ChartSweepView r7 = (ChartSweepView) ViewBindings.findChildViewById(r10, R.id.sweep_limit);
        if (r7 == null) goto L19;
        r0 = R.id.sweep_right;
        ChartSweepView r8 = (ChartSweepView) ViewBindings.findChildViewById(r10, R.id.sweep_right);
        if (r8 == null) goto L19;
        r0 = R.id.sweep_warning;
        ChartSweepView r9 = (ChartSweepView) ViewBindings.findChildViewById(r10, R.id.sweep_warning);
        if (r9 == null) goto L19;
        return new DataUsageChartBinding(r2, r2, r3, r4, r5, r6, r7, r8, r9);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }
}
