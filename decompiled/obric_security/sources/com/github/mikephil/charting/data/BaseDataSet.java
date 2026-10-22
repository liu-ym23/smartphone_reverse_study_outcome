package com.github.mikephil.charting.data;

import android.content.Context;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Typeface;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.model.GradientColor;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseDataSet<T extends Entry> implements IDataSet<T> {
    protected YAxis.AxisDependency mAxisDependency;
    protected List<Integer> mColors;
    protected boolean mDrawIcons;
    protected boolean mDrawValues;
    private Legend.LegendForm mForm;
    private DashPathEffect mFormLineDashEffect;
    private float mFormLineWidth;
    private float mFormSize;
    protected GradientColor mGradientColor;
    protected List<GradientColor> mGradientColors;
    protected boolean mHighlightEnabled;
    protected MPPointF mIconsOffset;
    private String mLabel;
    protected List<Integer> mValueColors;
    protected transient ValueFormatter mValueFormatter;
    protected float mValueTextSize;
    protected Typeface mValueTypeface;
    protected boolean mVisible;

    public BaseDataSet() {
        this.mColors = null;
        this.mGradientColor = null;
        this.mGradientColors = null;
        this.mValueColors = null;
        this.mLabel = "DataSet";
        this.mAxisDependency = YAxis.AxisDependency.LEFT;
        this.mHighlightEnabled = true;
        this.mForm = Legend.LegendForm.DEFAULT;
        this.mFormSize = Float.NaN;
        this.mFormLineWidth = Float.NaN;
        this.mFormLineDashEffect = null;
        this.mDrawValues = true;
        this.mDrawIcons = true;
        this.mIconsOffset = new MPPointF();
        this.mValueTextSize = 17.0f;
        this.mVisible = true;
        this.mColors = new ArrayList();
        this.mValueColors = new ArrayList();
        this.mColors.add(Integer.valueOf(Color.rgb(140, 234, 255)));
        this.mValueColors.add(-16777216);
    }

    public BaseDataSet(String r1) {
        this();
        this.mLabel = r1;
    }

    public void notifyDataSetChanged() {
        calcMinMax();
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public List<Integer> getColors() {
        return this.mColors;
    }

    public List<Integer> getValueColors() {
        return this.mValueColors;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public int getColor() {
        return this.mColors.get(0).intValue();
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public int getColor(int r2) {
        List<Integer> r1 = this.mColors;
        return r1.get(r2 % r1.size()).intValue();
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public GradientColor getGradientColor() {
        return this.mGradientColor;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public List<GradientColor> getGradientColors() {
        return this.mGradientColors;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public GradientColor getGradientColor(int r2) {
        List<GradientColor> r1 = this.mGradientColors;
        return r1.get(r2 % r1.size());
    }

    public void setColors(List<Integer> r1) {
        this.mColors = r1;
    }

    public void setColors(int... r1) {
        this.mColors = ColorTemplate.createColors(r1);
    }

    public void setColors(int[] r6, Context r7) {
        if (this.mColors != null) goto L5;
        this.mColors = new ArrayList();
    L5:
        this.mColors.clear();
        int r0 = r6.length;
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L8;
        int r2 = r6[r1];
        this.mColors.add(Integer.valueOf(r7.getResources().getColor(r2)));
        r1 = r1 + 1;
        goto L6
    }

    public void addColor(int r2) {
        if (this.mColors != null) goto L5;
        this.mColors = new ArrayList();
    L5:
        this.mColors.add(Integer.valueOf(r2));
    }

    public void setColor(int r1) {
        resetColors();
        this.mColors.add(Integer.valueOf(r1));
    }

    public void setGradientColor(int r2, int r3) {
        this.mGradientColor = new GradientColor(r2, r3);
    }

    public void setGradientColors(List<GradientColor> r1) {
        this.mGradientColors = r1;
    }

    public void setColor(int r3, int r4) {
        setColor(Color.argb(r4, Color.red(r3), Color.green(r3), Color.blue(r3)));
    }

    public void setColors(int[] r6, int r7) {
        resetColors();
        int r0 = r6.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        int r2 = r6[r1];
        addColor(Color.argb(r7, Color.red(r2), Color.green(r2), Color.blue(r2)));
        r1 = r1 + 1;
        goto L3
    }

    public void resetColors() {
        if (this.mColors != null) goto L5;
        this.mColors = new ArrayList();
    L5:
        this.mColors.clear();
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public void setLabel(String r1) {
        this.mLabel = r1;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public String getLabel() {
        return this.mLabel;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public void setHighlightEnabled(boolean r1) {
        this.mHighlightEnabled = r1;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public boolean isHighlightEnabled() {
        return this.mHighlightEnabled;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public void setValueFormatter(ValueFormatter r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.mValueFormatter = r1;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public ValueFormatter getValueFormatter() {
        if (needsFormatter() == false) goto L7;
        return Utils.getDefaultValueFormatter();
    L7:
        return this.mValueFormatter;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public boolean needsFormatter() {
        if (this.mValueFormatter != null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public void setValueTextColor(int r2) {
        this.mValueColors.clear();
        this.mValueColors.add(Integer.valueOf(r2));
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public void setValueTextColors(List<Integer> r1) {
        this.mValueColors = r1;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public void setValueTypeface(Typeface r1) {
        this.mValueTypeface = r1;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public void setValueTextSize(float r1) {
        this.mValueTextSize = Utils.convertDpToPixel(r1);
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public int getValueTextColor() {
        return this.mValueColors.get(0).intValue();
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public int getValueTextColor(int r2) {
        List<Integer> r1 = this.mValueColors;
        return r1.get(r2 % r1.size()).intValue();
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public Typeface getValueTypeface() {
        return this.mValueTypeface;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public float getValueTextSize() {
        return this.mValueTextSize;
    }

    public void setForm(Legend.LegendForm r1) {
        this.mForm = r1;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public Legend.LegendForm getForm() {
        return this.mForm;
    }

    public void setFormSize(float r1) {
        this.mFormSize = r1;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public float getFormSize() {
        return this.mFormSize;
    }

    public void setFormLineWidth(float r1) {
        this.mFormLineWidth = r1;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public float getFormLineWidth() {
        return this.mFormLineWidth;
    }

    public void setFormLineDashEffect(DashPathEffect r1) {
        this.mFormLineDashEffect = r1;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public DashPathEffect getFormLineDashEffect() {
        return this.mFormLineDashEffect;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public void setDrawValues(boolean r1) {
        this.mDrawValues = r1;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public boolean isDrawValuesEnabled() {
        return this.mDrawValues;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public void setDrawIcons(boolean r1) {
        this.mDrawIcons = r1;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public boolean isDrawIconsEnabled() {
        return this.mDrawIcons;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public void setIconsOffset(MPPointF r3) {
        MPPointF r0 = this.mIconsOffset;
        r0.x = r3.x;
        MPPointF r2 = this.mIconsOffset;
        r2.y = r3.y;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public MPPointF getIconsOffset() {
        return this.mIconsOffset;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public void setVisible(boolean r1) {
        this.mVisible = r1;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public boolean isVisible() {
        return this.mVisible;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public YAxis.AxisDependency getAxisDependency() {
        return this.mAxisDependency;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public void setAxisDependency(YAxis.AxisDependency r1) {
        this.mAxisDependency = r1;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public int getIndexInEntries(int r4) {
        int r0 = 0;
    L4:
        if (r0 >= getEntryCount()) goto L9;
        if (r4 == getEntryForIndex(r0).getX()) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r0;
    L9:
        return -1;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public boolean removeFirst() {
        if (getEntryCount() > 0) goto L5;
        return false;
    L5:
        return removeEntry(getEntryForIndex(0));
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public boolean removeLast() {
        if (getEntryCount() > 0) goto L5;
        return false;
    L5:
        return removeEntry(getEntryForIndex(getEntryCount() - 1));
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public boolean removeEntryByXValue(float r2) {
        return removeEntry(getEntryForXValue(r2, Float.NaN));
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public boolean removeEntry(int r1) {
        return removeEntry(getEntryForIndex(r1));
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public boolean contains(T r4) {
        int r1 = 0;
    L4:
        if (r1 >= getEntryCount()) goto L10;
        if (getEntryForIndex(r1).equals(r4) == true) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    protected void copy(BaseDataSet r2) {
        r2.mAxisDependency = this.mAxisDependency;
        r2.mColors = this.mColors;
        r2.mDrawIcons = this.mDrawIcons;
        r2.mDrawValues = this.mDrawValues;
        r2.mForm = this.mForm;
        r2.mFormLineDashEffect = this.mFormLineDashEffect;
        r2.mFormLineWidth = this.mFormLineWidth;
        r2.mFormSize = this.mFormSize;
        r2.mGradientColor = this.mGradientColor;
        r2.mGradientColors = this.mGradientColors;
        r2.mHighlightEnabled = this.mHighlightEnabled;
        r2.mIconsOffset = this.mIconsOffset;
        r2.mValueColors = this.mValueColors;
        r2.mValueFormatter = this.mValueFormatter;
        r2.mValueColors = this.mValueColors;
        r2.mValueTextSize = this.mValueTextSize;
        r2.mVisible = this.mVisible;
    }
}
