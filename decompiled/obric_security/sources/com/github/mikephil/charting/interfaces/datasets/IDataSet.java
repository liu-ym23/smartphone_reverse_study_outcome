package com.github.mikephil.charting.interfaces.datasets;

import android.graphics.DashPathEffect;
import android.graphics.Typeface;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.model.GradientColor;
import com.github.mikephil.charting.utils.MPPointF;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface IDataSet<T extends Entry> {
    boolean addEntry(T r1);

    void addEntryOrdered(T r1);

    void calcMinMax();

    void calcMinMaxY(float r1, float r2);

    void clear();

    boolean contains(T r1);

    YAxis.AxisDependency getAxisDependency();

    int getColor();

    int getColor(int r1);

    List<Integer> getColors();

    List<T> getEntriesForXValue(float r1);

    int getEntryCount();

    T getEntryForIndex(int r1);

    T getEntryForXValue(float r1, float r2);

    T getEntryForXValue(float r1, float r2, DataSet.Rounding r3);

    int getEntryIndex(float r1, float r2, DataSet.Rounding r3);

    int getEntryIndex(T r1);

    Legend.LegendForm getForm();

    DashPathEffect getFormLineDashEffect();

    float getFormLineWidth();

    float getFormSize();

    GradientColor getGradientColor();

    GradientColor getGradientColor(int r1);

    List<GradientColor> getGradientColors();

    MPPointF getIconsOffset();

    int getIndexInEntries(int r1);

    String getLabel();

    ValueFormatter getValueFormatter();

    int getValueTextColor();

    int getValueTextColor(int r1);

    float getValueTextSize();

    Typeface getValueTypeface();

    float getXMax();

    float getXMin();

    float getYMax();

    float getYMin();

    boolean isDrawIconsEnabled();

    boolean isDrawValuesEnabled();

    boolean isHighlightEnabled();

    boolean isVisible();

    boolean needsFormatter();

    boolean removeEntry(int r1);

    boolean removeEntry(T r1);

    boolean removeEntryByXValue(float r1);

    boolean removeFirst();

    boolean removeLast();

    void setAxisDependency(YAxis.AxisDependency r1);

    void setDrawIcons(boolean r1);

    void setDrawValues(boolean r1);

    void setHighlightEnabled(boolean r1);

    void setIconsOffset(MPPointF r1);

    void setLabel(String r1);

    void setValueFormatter(ValueFormatter r1);

    void setValueTextColor(int r1);

    void setValueTextColors(List<Integer> r1);

    void setValueTextSize(float r1);

    void setValueTypeface(Typeface r1);

    void setVisible(boolean r1);
}
