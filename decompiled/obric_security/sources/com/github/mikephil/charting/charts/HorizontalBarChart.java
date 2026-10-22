package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.HorizontalBarHighlighter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.renderer.HorizontalBarChartRenderer;
import com.github.mikephil.charting.renderer.XAxisRendererHorizontalBarChart;
import com.github.mikephil.charting.renderer.YAxisRendererHorizontalBarChart;
import com.github.mikephil.charting.utils.HorizontalViewPortHandler;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.TransformerHorizontalBarChart;
import com.github.mikephil.charting.utils.Utils;

/* JADX INFO: loaded from: classes2.dex */
public class HorizontalBarChart extends BarChart {
    protected float[] mGetPositionBuffer;
    private RectF mOffsetsBuffer;

    public HorizontalBarChart(Context r1) {
        super(r1);
        this.mOffsetsBuffer = new RectF();
        this.mGetPositionBuffer = new float[2];
    }

    public HorizontalBarChart(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mOffsetsBuffer = new RectF();
        this.mGetPositionBuffer = new float[2];
    }

    public HorizontalBarChart(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.mOffsetsBuffer = new RectF();
        this.mGetPositionBuffer = new float[2];
    }

    @Override // com.github.mikephil.charting.charts.BarChart, com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    protected void init() {
        this.mViewPortHandler = new HorizontalViewPortHandler();
        super.init();
        this.mLeftAxisTransformer = new TransformerHorizontalBarChart(this.mViewPortHandler);
        this.mRightAxisTransformer = new TransformerHorizontalBarChart(this.mViewPortHandler);
        this.mRenderer = new HorizontalBarChartRenderer(this, this.mAnimator, this.mViewPortHandler);
        setHighlighter(new HorizontalBarHighlighter(this));
        this.mAxisRendererLeft = new YAxisRendererHorizontalBarChart(this.mViewPortHandler, this.mAxisLeft, this.mLeftAxisTransformer);
        this.mAxisRendererRight = new YAxisRendererHorizontalBarChart(this.mViewPortHandler, this.mAxisRight, this.mRightAxisTransformer);
        this.mXAxisRenderer = new XAxisRendererHorizontalBarChart(this.mViewPortHandler, this.mXAxis, this.mLeftAxisTransformer, this);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    public void calculateOffsets() {
        calculateLegendOffsets(this.mOffsetsBuffer);
        float r0 = this.mOffsetsBuffer.left + 0.0f;
        float r2 = this.mOffsetsBuffer.top + 0.0f;
        float r3 = this.mOffsetsBuffer.right + 0.0f;
        float r4 = this.mOffsetsBuffer.bottom + 0.0f;
        if (this.mAxisLeft.needsOffset() == false) goto L6;
        r2 = r2 + this.mAxisLeft.getRequiredHeightSpace(this.mAxisRendererLeft.getPaintAxisLabels());
    L6:
        if (this.mAxisRight.needsOffset() == false) goto L8;
        r4 = r4 + this.mAxisRight.getRequiredHeightSpace(this.mAxisRendererRight.getPaintAxisLabels());
    L8:
        float r1 = this.mXAxis.mLabelRotatedWidth;
        if (this.mXAxis.isEnabled() == true) goto L11;
    L19:
        float r5 = r2 + getExtraTopOffset();
        float r6 = r3 + getExtraRightOffset();
        float r7 = r4 + getExtraBottomOffset();
        float r8 = r0 + getExtraLeftOffset();
        float r9 = Utils.convertDpToPixel(this.mMinOffset);
        this.mViewPortHandler.restrainViewPort(Math.max(r9, r8), Math.max(r9, r5), Math.max(r9, r6), Math.max(r9, r7));
        if (this.mLogEnabled == false) goto L22;
        Log.i(Chart.LOG_TAG, "offsetLeft: " + r8 + ", offsetTop: " + r5 + ", offsetRight: " + r6 + ", offsetBottom: " + r7);
        Log.i(Chart.LOG_TAG, "Content: " + this.mViewPortHandler.getContentRect().toString());
    L22:
        prepareOffsetMatrix();
        prepareValuePxMatrix();
        return;
    L11:
        if (this.mXAxis.getPosition() != XAxis.XAxisPosition.BOTTOM) goto L14;
        r0 = r0 + r1;
        goto L19
    L14:
        if (this.mXAxis.getPosition() != XAxis.XAxisPosition.TOP) goto L17;
    L15:
        r3 = r3 + r1;
        goto L19
    L17:
        if (this.mXAxis.getPosition() != XAxis.XAxisPosition.BOTH_SIDED) goto L19;
        r0 = r0 + r1;
        goto L15
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    protected void prepareValuePxMatrix() {
        this.mRightAxisTransformer.prepareMatrixValuePx(this.mAxisRight.mAxisMinimum, this.mAxisRight.mAxisRange, this.mXAxis.mAxisRange, this.mXAxis.mAxisMinimum);
        this.mLeftAxisTransformer.prepareMatrixValuePx(this.mAxisLeft.mAxisMinimum, this.mAxisLeft.mAxisRange, this.mXAxis.mAxisRange, this.mXAxis.mAxisMinimum);
    }

    @Override // com.github.mikephil.charting.charts.Chart
    protected float[] getMarkerPosition(Highlight r3) {
        return new float[]{r3.getDrawY(), r3.getDrawX()};
    }

    @Override // com.github.mikephil.charting.charts.BarChart
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
        r8.set(r4, r3, r1, r10);
        getTransformer(r0.getAxisDependency()).rectValueToPixel(r8);
        return;
    L9:
        r4 = 0.0f;
        goto L11
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public MPPointF getPosition(Entry r4, YAxis.AxisDependency r5) {
        if (r4 != null) goto L5;
        return null;
    L5:
        float[] r0 = this.mGetPositionBuffer;
        r0[0] = r4.getY();
        r0[1] = r4.getX();
        getTransformer(r5).pointValuesToPixel(r0);
        return MPPointF.getInstance(r0[0], r0[1]);
    }

    @Override // com.github.mikephil.charting.charts.BarChart, com.github.mikephil.charting.charts.Chart
    public Highlight getHighlightByTouchPoint(float r2, float r3) {
        if (this.mData != 0) goto L10;
        if (this.mLogEnabled == false) goto L11;
        Log.e(Chart.LOG_TAG, "Can't select by touch. No data set.");
        return null;
    L11:
        return null;
    L10:
        return getHighlighter().getHighlight(r3, r2);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider
    public float getLowestVisibleX() {
        getTransformer(YAxis.AxisDependency.LEFT).getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentBottom(), this.posForGetLowestVisibleX);
        return (float) Math.max(this.mXAxis.mAxisMinimum, this.posForGetLowestVisibleX.y);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider
    public float getHighestVisibleX() {
        getTransformer(YAxis.AxisDependency.LEFT).getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop(), this.posForGetHighestVisibleX);
        return (float) Math.min(this.mXAxis.mAxisMaximum, this.posForGetHighestVisibleX.y);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public void setVisibleXRangeMaximum(float r2) {
        float r0 = this.mXAxis.mAxisRange / r2;
        this.mViewPortHandler.setMinimumScaleY(r0);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public void setVisibleXRangeMinimum(float r2) {
        float r0 = this.mXAxis.mAxisRange / r2;
        this.mViewPortHandler.setMaximumScaleY(r0);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public void setVisibleXRange(float r2, float r3) {
        float r0 = this.mXAxis.mAxisRange / r2;
        float r4 = this.mXAxis.mAxisRange / r3;
        this.mViewPortHandler.setMinMaxScaleY(r0, r4);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public void setVisibleYRangeMaximum(float r1, YAxis.AxisDependency r2) {
        float r3 = getAxisRange(r2) / r1;
        this.mViewPortHandler.setMinimumScaleX(r3);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public void setVisibleYRangeMinimum(float r1, YAxis.AxisDependency r2) {
        float r3 = getAxisRange(r2) / r1;
        this.mViewPortHandler.setMaximumScaleX(r3);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public void setVisibleYRange(float r2, float r3, YAxis.AxisDependency r4) {
        float r0 = getAxisRange(r4) / r2;
        float r5 = getAxisRange(r4) / r3;
        this.mViewPortHandler.setMinMaxScaleX(r0, r5);
    }
}
