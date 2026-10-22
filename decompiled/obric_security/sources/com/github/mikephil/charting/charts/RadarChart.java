package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.highlight.RadarHighlighter;
import com.github.mikephil.charting.renderer.RadarChartRenderer;
import com.github.mikephil.charting.renderer.XAxisRendererRadarChart;
import com.github.mikephil.charting.renderer.YAxisRendererRadarChart;
import com.github.mikephil.charting.utils.Utils;
import com.obric.oui.utils.AnimTokens;

/* JADX INFO: loaded from: classes2.dex */
public class RadarChart extends PieRadarChartBase<RadarData> {
    private boolean mDrawWeb;
    private float mInnerWebLineWidth;
    private int mSkipWebLineCount;
    private int mWebAlpha;
    private int mWebColor;
    private int mWebColorInner;
    private float mWebLineWidth;
    protected XAxisRendererRadarChart mXAxisRenderer;
    private YAxis mYAxis;
    protected YAxisRendererRadarChart mYAxisRenderer;

    public RadarChart(Context r2) {
        super(r2);
        this.mWebLineWidth = 2.5f;
        this.mInnerWebLineWidth = 1.5f;
        this.mWebColor = Color.rgb(122, 122, 122);
        this.mWebColorInner = Color.rgb(122, 122, 122);
        this.mWebAlpha = AnimTokens.OUI_ANIMATION_DURATION_SHORT_3;
        this.mDrawWeb = true;
        this.mSkipWebLineCount = 0;
    }

    public RadarChart(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mWebLineWidth = 2.5f;
        this.mInnerWebLineWidth = 1.5f;
        this.mWebColor = Color.rgb(122, 122, 122);
        this.mWebColorInner = Color.rgb(122, 122, 122);
        this.mWebAlpha = AnimTokens.OUI_ANIMATION_DURATION_SHORT_3;
        this.mDrawWeb = true;
        this.mSkipWebLineCount = 0;
    }

    public RadarChart(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.mWebLineWidth = 2.5f;
        this.mInnerWebLineWidth = 1.5f;
        this.mWebColor = Color.rgb(122, 122, 122);
        this.mWebColorInner = Color.rgb(122, 122, 122);
        this.mWebAlpha = AnimTokens.OUI_ANIMATION_DURATION_SHORT_3;
        this.mDrawWeb = true;
        this.mSkipWebLineCount = 0;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    protected void init() {
        super.init();
        this.mYAxis = new YAxis(YAxis.AxisDependency.LEFT);
        this.mWebLineWidth = Utils.convertDpToPixel(1.5f);
        this.mInnerWebLineWidth = Utils.convertDpToPixel(0.75f);
        this.mRenderer = new RadarChartRenderer(this, this.mAnimator, this.mViewPortHandler);
        this.mYAxisRenderer = new YAxisRendererRadarChart(this.mViewPortHandler, this.mYAxis, this);
        this.mXAxisRenderer = new XAxisRendererRadarChart(this.mViewPortHandler, this.mXAxis, this);
        this.mHighlighter = new RadarHighlighter(this);
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    protected void calcMinMax() {
        super.calcMinMax();
        this.mYAxis.calculate(((RadarData) this.mData).getYMin(YAxis.AxisDependency.LEFT), ((RadarData) this.mData).getYMax(YAxis.AxisDependency.LEFT));
        this.mXAxis.calculate(0.0f, ((RadarData) this.mData).getMaxEntryCountSet().getEntryCount());
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    public void notifyDataSetChanged() {
        if (this.mData != 0) goto L5;
        return;
    L5:
        calcMinMax();
        this.mYAxisRenderer.computeAxis(this.mYAxis.mAxisMinimum, this.mYAxis.mAxisMaximum, this.mYAxis.isInverted());
        this.mXAxisRenderer.computeAxis(this.mXAxis.mAxisMinimum, this.mXAxis.mAxisMaximum, false);
        if (this.mLegend != null) goto L8;
    L10:
        calculateOffsets();
        return;
    L8:
        if (this.mLegend.isLegendCustom() == true) goto L10;
        this.mLegendRenderer.computeLegend(this.mData);
        goto L10
    }

    @Override // com.github.mikephil.charting.charts.Chart, android.view.View
    protected void onDraw(Canvas r5) {
        super.onDraw(r5);
        if (this.mData != 0) goto L6;
        return;
    L6:
        if (this.mXAxis.isEnabled() == false) goto L8;
        this.mXAxisRenderer.computeAxis(this.mXAxis.mAxisMinimum, this.mXAxis.mAxisMaximum, false);
    L8:
        this.mXAxisRenderer.renderAxisLabels(r5);
        if (this.mDrawWeb == false) goto L12;
        this.mRenderer.drawExtras(r5);
    L12:
        if (this.mYAxis.isEnabled() == true) goto L14;
    L16:
        this.mRenderer.drawData(r5);
        if (valuesToHighlight() == false) goto L20;
        this.mRenderer.drawHighlighted(r5, this.mIndicesToHighlight);
    L20:
        if (this.mYAxis.isEnabled() == true) goto L22;
    L24:
        this.mYAxisRenderer.renderAxisLabels(r5);
        this.mRenderer.drawValues(r5);
        this.mLegendRenderer.renderLegend(r5);
        drawDescription(r5);
        drawMarkers(r5);
        return;
    L22:
        if (this.mYAxis.isDrawLimitLinesBehindDataEnabled() == true) goto L24;
        this.mYAxisRenderer.renderLimitLines(r5);
        goto L24
    L14:
        if (this.mYAxis.isDrawLimitLinesBehindDataEnabled() == false) goto L16;
        this.mYAxisRenderer.renderLimitLines(r5);
        goto L16
    }

    public float getFactor() {
        RectF r0 = this.mViewPortHandler.getContentRect();
        return Math.min(r0.width() / 2.0f, r0.height() / 2.0f) / this.mYAxis.mAxisRange;
    }

    public float getSliceAngle() {
        return 360.0f / ((RadarData) this.mData).getMaxEntryCountSet().getEntryCount();
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public int getIndexForAngle(float r7) {
        float r8 = Utils.getNormalizedAngle(r7 - getRotationAngle());
        float r0 = getSliceAngle();
        int r6 = ((RadarData) this.mData).getMaxEntryCountSet().getEntryCount();
        int r2 = 0;
    L3:
        if (r2 >= r6) goto L11;
        int r3 = r2 + 1;
        if (((r3 * r0) - (r0 / 2.0f)) > r8) goto L8;
        r2 = r3;
        goto L3
    L8:
        return r2;
    L11:
        return 0;
    }

    public YAxis getYAxis() {
        return this.mYAxis;
    }

    public void setWebLineWidth(float r1) {
        this.mWebLineWidth = Utils.convertDpToPixel(r1);
    }

    public float getWebLineWidth() {
        return this.mWebLineWidth;
    }

    public void setWebLineWidthInner(float r1) {
        this.mInnerWebLineWidth = Utils.convertDpToPixel(r1);
    }

    public float getWebLineWidthInner() {
        return this.mInnerWebLineWidth;
    }

    public void setWebAlpha(int r1) {
        this.mWebAlpha = r1;
    }

    public int getWebAlpha() {
        return this.mWebAlpha;
    }

    public void setWebColor(int r1) {
        this.mWebColor = r1;
    }

    public int getWebColor() {
        return this.mWebColor;
    }

    public void setWebColorInner(int r1) {
        this.mWebColorInner = r1;
    }

    public int getWebColorInner() {
        return this.mWebColorInner;
    }

    public void setDrawWeb(boolean r1) {
        this.mDrawWeb = r1;
    }

    public void setSkipWebLineCount(int r2) {
        this.mSkipWebLineCount = Math.max(0, r2);
    }

    public int getSkipWebLineCount() {
        return this.mSkipWebLineCount;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    protected float getRequiredLegendOffset() {
        return this.mLegendRenderer.getLabelPaint().getTextSize() * 4.0f;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    protected float getRequiredBaseOffset() {
        if (this.mXAxis.isEnabled() == false) goto L8;
        if (this.mXAxis.isDrawLabelsEnabled() == false) goto L8;
        return this.mXAxis.mLabelRotatedWidth;
    L8:
        return Utils.convertDpToPixel(10.0f);
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public float getRadius() {
        RectF r2 = this.mViewPortHandler.getContentRect();
        return Math.min(r2.width() / 2.0f, r2.height() / 2.0f);
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public float getYChartMax() {
        return this.mYAxis.mAxisMaximum;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public float getYChartMin() {
        return this.mYAxis.mAxisMinimum;
    }

    public float getYRange() {
        return this.mYAxis.mAxisRange;
    }
}
