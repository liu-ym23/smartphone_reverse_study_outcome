package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.highlight.BarHighlighter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.renderer.BarChartRenderer;

/* JADX INFO: loaded from: classes2.dex */
public class BarChart extends BarLineChartBase<BarData> implements BarDataProvider {
    private boolean mDrawBarShadow;
    private boolean mDrawValueAboveBar;
    private boolean mFitBars;
    protected boolean mHighlightFullBarEnabled;

    public BarChart(Context r2) {
        super(r2);
        this.mHighlightFullBarEnabled = false;
        this.mDrawValueAboveBar = true;
        this.mDrawBarShadow = false;
        this.mFitBars = false;
    }

    public BarChart(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mHighlightFullBarEnabled = false;
        this.mDrawValueAboveBar = true;
        this.mDrawBarShadow = false;
        this.mFitBars = false;
    }

    public BarChart(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.mHighlightFullBarEnabled = false;
        this.mDrawValueAboveBar = true;
        this.mDrawBarShadow = false;
        this.mFitBars = false;
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    protected void init() {
        super.init();
        this.mRenderer = new BarChartRenderer(this, this.mAnimator, this.mViewPortHandler);
        setHighlighter(new BarHighlighter(this));
        getXAxis().setSpaceMin(0.5f);
        getXAxis().setSpaceMax(0.5f);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    protected void calcMinMax() {
        if (this.mFitBars == false) goto L5;
        this.mXAxis.calculate(((BarData) this.mData).getXMin() - (((BarData) this.mData).getBarWidth() / 2.0f), ((BarData) this.mData).getXMax() + (((BarData) this.mData).getBarWidth() / 2.0f));
    L6:
        this.mAxisLeft.calculate(((BarData) this.mData).getYMin(YAxis.AxisDependency.LEFT), ((BarData) this.mData).getYMax(YAxis.AxisDependency.LEFT));
        this.mAxisRight.calculate(((BarData) this.mData).getYMin(YAxis.AxisDependency.RIGHT), ((BarData) this.mData).getYMax(YAxis.AxisDependency.RIGHT));
        return;
    L5:
        this.mXAxis.calculate(((BarData) this.mData).getXMin(), ((BarData) this.mData).getXMax());
        goto L6
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public Highlight getHighlightByTouchPoint(float r9, float r10) {
        if (this.mData != 0) goto L6;
        Log.e(Chart.LOG_TAG, "Can't select by touch. No data set.");
        return null;
    L6:
        Highlight r11 = getHighlighter().getHighlight(r9, r10);
        if (r11 != null) goto L9;
    L13:
        return r11;
    L9:
        if (isHighlightFullBarEnabled() == false) goto L13;
        return new Highlight(r11.getX(), r11.getY(), r11.getXPx(), r11.getYPx(), r11.getDataSetIndex(), -1, r11.getAxis());
    }

    public RectF getBarBounds(BarEntry r2) {
        RectF r0 = new RectF();
        getBarBounds(r2, r0);
        return r0;
    }

    public void getBarBounds(BarEntry r7, RectF r8) {
        IBarDataSet r0 = (IBarDataSet) ((BarData) this.mData).getDataSetForEntry(r7);
        if (r0 != null) goto L6;
        r8.set(Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE);
        return;
    L6:
        float r1 = r7.getY();
        float r9 = r7.getX();
        float r2 = ((BarData) this.mData).getBarWidth() / 2.0f;
        float r3 = r9 - r2;
        float r10 = r9 + r2;
        if (r1 < 0.0f) goto L9;
        float r4 = r1;
    L11:
        if (r1 <= 0.0f) goto L14;
        r1 = 0.0f;
    L14:
        r8.set(r3, r4, r10, r1);
        getTransformer(r0.getAxisDependency()).rectValueToPixel(r8);
        return;
    L9:
        r4 = 0.0f;
        goto L11
    }

    public void setDrawValueAboveBar(boolean r1) {
        this.mDrawValueAboveBar = r1;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider
    public boolean isDrawValueAboveBarEnabled() {
        return this.mDrawValueAboveBar;
    }

    public void setDrawBarShadow(boolean r1) {
        this.mDrawBarShadow = r1;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider
    public boolean isDrawBarShadowEnabled() {
        return this.mDrawBarShadow;
    }

    public void setHighlightFullBarEnabled(boolean r1) {
        this.mHighlightFullBarEnabled = r1;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider
    public boolean isHighlightFullBarEnabled() {
        return this.mHighlightFullBarEnabled;
    }

    public void highlightValue(float r2, int r3, int r4) {
        highlightValue(new Highlight(r2, r3, r4), false);
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider
    public BarData getBarData() {
        return (BarData) this.mData;
    }

    public void setFitBars(boolean r1) {
        this.mFitBars = r1;
    }

    public void groupBars(float r2, float r3, float r4) {
        if (getBarData() == null) goto L7;
        getBarData().groupBars(r2, r3, r4);
        notifyDataSetChanged();
        return;
    L7:
        throw new RuntimeException("You need to set data for the chart before grouping bars.");
    }
}
