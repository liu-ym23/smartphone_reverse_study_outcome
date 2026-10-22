package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieEntry;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes2.dex */
public class PercentFormatter extends ValueFormatter {
    public DecimalFormat mFormat;
    private PieChart pieChart;

    public PercentFormatter() {
        this.mFormat = new DecimalFormat("###,###,##0.0");
    }

    public PercentFormatter(PieChart r1) {
        this();
        this.pieChart = r1;
    }

    @Override // com.github.mikephil.charting.formatter.ValueFormatter
    public String getFormattedValue(float r4) {
        return this.mFormat.format(r4) + " %";
    }

    @Override // com.github.mikephil.charting.formatter.ValueFormatter
    public String getPieLabel(float r1, PieEntry r2) {
        PieChart r3 = this.pieChart;
        if (r3 == null) goto L9;
        if (r3.isUsePercentValuesEnabled() == false) goto L9;
        return getFormattedValue(r1);
    L9:
        return this.mFormat.format(r1);
    }
}
