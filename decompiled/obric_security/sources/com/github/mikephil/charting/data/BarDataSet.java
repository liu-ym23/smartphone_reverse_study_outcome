package com.github.mikephil.charting.data;

import android.graphics.Color;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class BarDataSet extends BarLineScatterCandleBubbleDataSet<BarEntry> implements IBarDataSet {
    private int mBarBorderColor;
    private float mBarBorderWidth;
    private int mBarShadowColor;
    private int mEntryCountStacks;
    private int mHighLightAlpha;
    private String[] mStackLabels;
    private int mStackSize;

    @Override // com.github.mikephil.charting.data.DataSet
    protected /* bridge */ /* synthetic */ void calcMinMax(Entry r1) {
        calcMinMax((BarEntry) r1);
    }

    public BarDataSet(List<BarEntry> r2, String r3) {
        super(r2, r3);
        this.mStackSize = 1;
        this.mBarShadowColor = Color.rgb(215, 215, 215);
        this.mBarBorderWidth = 0.0f;
        this.mBarBorderColor = -16777216;
        this.mHighLightAlpha = 120;
        this.mEntryCountStacks = 0;
        this.mStackLabels = new String[]{"Stack"};
        this.mHighLightColor = Color.rgb(0, 0, 0);
        calcStackSize(r2);
        calcEntryCountIncludingStacks(r2);
    }

    @Override // com.github.mikephil.charting.data.DataSet
    public DataSet<BarEntry> copy() {
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L4:
        if (r1 >= this.mValues.size()) goto L6;
        r0.add(((BarEntry) this.mValues.get(r1)).copy());
        r1 = r1 + 1;
        goto L4
    L6:
        BarDataSet r2 = new BarDataSet(r0, getLabel());
        copy(r2);
        return r2;
    }

    protected void copy(BarDataSet r2) {
        super.copy(r2);
        r2.mStackSize = this.mStackSize;
        r2.mBarShadowColor = this.mBarShadowColor;
        r2.mBarBorderWidth = this.mBarBorderWidth;
        r2.mStackLabels = this.mStackLabels;
        r2.mHighLightAlpha = this.mHighLightAlpha;
    }

    private void calcEntryCountIncludingStacks(List<BarEntry> r4) {
        int r0 = 0;
        this.mEntryCountStacks = 0;
    L4:
        if (r0 >= r4.size()) goto L10;
        float[] r1 = r4.get(r0).getYVals();
        if (r1 != null) goto L8;
        this.mEntryCountStacks++;
    L9:
        r0 = r0 + 1;
        goto L4
    L8:
        this.mEntryCountStacks += r1.length;
        goto L9
    }

    private void calcStackSize(List<BarEntry> r5) {
        int r0 = 0;
    L4:
        if (r0 >= r5.size()) goto L11;
        float[] r1 = r5.get(r0).getYVals();
        if (r1 == null) goto L10;
        if (r1.length <= this.mStackSize) goto L10;
        this.mStackSize = r1.length;
    L10:
        r0 = r0 + 1;
        goto L4
    }

    protected void calcMinMax(BarEntry r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (Float.isNaN(r3.getY()) == false) goto L6;
        return;
    L6:
        if (r3.getYVals() != null) goto L14;
        if (r3.getY() >= this.mYMin) goto L11;
        this.mYMin = r3.getY();
    L11:
        if (r3.getY() <= this.mYMax) goto L19;
        this.mYMax = r3.getY();
    L19:
        calcMinMaxX(r3);
        return;
    L14:
        if ((-r3.getNegativeSum()) >= this.mYMin) goto L17;
        this.mYMin = -r3.getNegativeSum();
    L17:
        if (r3.getPositiveSum() <= this.mYMax) goto L19;
        this.mYMax = r3.getPositiveSum();
        goto L19
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IBarDataSet
    public int getStackSize() {
        return this.mStackSize;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IBarDataSet
    public boolean isStacked() {
        if (this.mStackSize > 1) goto L7;
        return false;
    L7:
        return true;
    }

    public int getEntryCountStacks() {
        return this.mEntryCountStacks;
    }

    public void setBarShadowColor(int r1) {
        this.mBarShadowColor = r1;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IBarDataSet
    public int getBarShadowColor() {
        return this.mBarShadowColor;
    }

    public void setBarBorderWidth(float r1) {
        this.mBarBorderWidth = r1;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IBarDataSet
    public float getBarBorderWidth() {
        return this.mBarBorderWidth;
    }

    public void setBarBorderColor(int r1) {
        this.mBarBorderColor = r1;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IBarDataSet
    public int getBarBorderColor() {
        return this.mBarBorderColor;
    }

    public void setHighLightAlpha(int r1) {
        this.mHighLightAlpha = r1;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IBarDataSet
    public int getHighLightAlpha() {
        return this.mHighLightAlpha;
    }

    public void setStackLabels(String[] r1) {
        this.mStackLabels = r1;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IBarDataSet
    public String[] getStackLabels() {
        return this.mStackLabels;
    }
}
