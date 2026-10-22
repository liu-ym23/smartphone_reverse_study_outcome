package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ValueFormatter implements IAxisValueFormatter, IValueFormatter {
    public ValueFormatter() {
    }

    @Override // com.github.mikephil.charting.formatter.IAxisValueFormatter
    @Deprecated
    public String getFormattedValue(float r1, AxisBase r2) {
        return getFormattedValue(r1);
    }

    @Override // com.github.mikephil.charting.formatter.IValueFormatter
    @Deprecated
    public String getFormattedValue(float r1, Entry r2, int r3, ViewPortHandler r4) {
        return getFormattedValue(r1);
    }

    public String getFormattedValue(float r1) {
        return String.valueOf(r1);
    }

    public String getAxisLabel(float r1, AxisBase r2) {
        return getFormattedValue(r1);
    }

    public String getBarLabel(BarEntry r1) {
        return getFormattedValue(r1.getY());
    }

    public String getBarStackedLabel(float r1, BarEntry r2) {
        return getFormattedValue(r1);
    }

    public String getPointLabel(Entry r1) {
        return getFormattedValue(r1.getY());
    }

    public String getPieLabel(float r1, PieEntry r2) {
        return getFormattedValue(r1);
    }

    public String getRadarLabel(RadarEntry r1) {
        return getFormattedValue(r1.getY());
    }

    public String getBubbleLabel(BubbleEntry r1) {
        return getFormattedValue(r1.getSize());
    }

    public String getCandleLabel(CandleEntry r1) {
        return getFormattedValue(r1.getHigh());
    }
}
