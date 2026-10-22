package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.PieHighlighter;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.renderer.PieChartRenderer;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PieChart extends PieRadarChartBase<PieData> {
    private float[] mAbsoluteAngles;
    private CharSequence mCenterText;
    private MPPointF mCenterTextOffset;
    private float mCenterTextRadiusPercent;
    private RectF mCircleBox;
    private float[] mDrawAngles;
    private boolean mDrawCenterText;
    private boolean mDrawEntryLabels;
    private boolean mDrawHole;
    private boolean mDrawRoundedSlices;
    private boolean mDrawSlicesUnderHole;
    private float mHoleRadiusPercent;
    protected float mMaxAngle;
    private float mMinAngleForSlices;
    protected float mTransparentCircleRadiusPercent;
    private boolean mUsePercentValues;

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    protected float getRequiredBaseOffset() {
        return 0.0f;
    }

    public PieChart(Context r3) {
        super(r3);
        this.mCircleBox = new RectF();
        this.mDrawEntryLabels = true;
        this.mDrawAngles = new float[1];
        this.mAbsoluteAngles = new float[1];
        this.mDrawHole = true;
        this.mDrawSlicesUnderHole = false;
        this.mUsePercentValues = false;
        this.mDrawRoundedSlices = false;
        this.mCenterText = "";
        this.mCenterTextOffset = MPPointF.getInstance(0.0f, 0.0f);
        this.mHoleRadiusPercent = 50.0f;
        this.mTransparentCircleRadiusPercent = 55.0f;
        this.mDrawCenterText = true;
        this.mCenterTextRadiusPercent = 100.0f;
        this.mMaxAngle = 360.0f;
        this.mMinAngleForSlices = 0.0f;
    }

    public PieChart(Context r2, AttributeSet r3) {
        super(r2, r3);
        this.mCircleBox = new RectF();
        this.mDrawEntryLabels = true;
        this.mDrawAngles = new float[1];
        this.mAbsoluteAngles = new float[1];
        this.mDrawHole = true;
        this.mDrawSlicesUnderHole = false;
        this.mUsePercentValues = false;
        this.mDrawRoundedSlices = false;
        this.mCenterText = "";
        this.mCenterTextOffset = MPPointF.getInstance(0.0f, 0.0f);
        this.mHoleRadiusPercent = 50.0f;
        this.mTransparentCircleRadiusPercent = 55.0f;
        this.mDrawCenterText = true;
        this.mCenterTextRadiusPercent = 100.0f;
        this.mMaxAngle = 360.0f;
        this.mMinAngleForSlices = 0.0f;
    }

    public PieChart(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.mCircleBox = new RectF();
        this.mDrawEntryLabels = true;
        this.mDrawAngles = new float[1];
        this.mAbsoluteAngles = new float[1];
        this.mDrawHole = true;
        this.mDrawSlicesUnderHole = false;
        this.mUsePercentValues = false;
        this.mDrawRoundedSlices = false;
        this.mCenterText = "";
        this.mCenterTextOffset = MPPointF.getInstance(0.0f, 0.0f);
        this.mHoleRadiusPercent = 50.0f;
        this.mTransparentCircleRadiusPercent = 55.0f;
        this.mDrawCenterText = true;
        this.mCenterTextRadiusPercent = 100.0f;
        this.mMaxAngle = 360.0f;
        this.mMinAngleForSlices = 0.0f;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    protected void init() {
        super.init();
        this.mRenderer = new PieChartRenderer(this, this.mAnimator, this.mViewPortHandler);
        this.mXAxis = null;
        this.mHighlighter = new PieHighlighter(this);
    }

    @Override // com.github.mikephil.charting.charts.Chart, android.view.View
    protected void onDraw(Canvas r3) {
        super.onDraw(r3);
        if (this.mData != 0) goto L5;
        return;
    L5:
        this.mRenderer.drawData(r3);
        if (valuesToHighlight() == false) goto L8;
        this.mRenderer.drawHighlighted(r3, this.mIndicesToHighlight);
    L8:
        this.mRenderer.drawExtras(r3);
        this.mRenderer.drawValues(r3);
        this.mLegendRenderer.renderLegend(r3);
        drawDescription(r3);
        drawMarkers(r3);
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    public void calculateOffsets() {
        super.calculateOffsets();
        if (this.mData != 0) goto L5;
        return;
    L5:
        float r0 = getDiameter() / 2.0f;
        MPPointF r1 = getCenterOffsets();
        float r2 = ((PieData) this.mData).getDataSet().getSelectionShift();
        this.mCircleBox.set((r1.x - r0) + r2, (r1.y - r0) + r2, (r1.x + r0) - r2, (r1.y + r0) - r2);
        MPPointF.recycleInstance(r1);
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    protected void calcMinMax() {
        calcAngles();
    }

    @Override // com.github.mikephil.charting.charts.Chart
    protected float[] getMarkerPosition(Highlight r11) {
        MPPointF r0 = getCenterCircleBox();
        float r1 = getRadius();
        float r2 = (r1 / 10.0f) * 3.6f;
        if (isDrawHoleEnabled() == false) goto L5;
        r2 = (r1 - ((r1 / 100.0f) * getHoleRadius())) / 2.0f;
    L5:
        float r3 = r1 - r2;
        float r4 = getRotationAngle();
        int r12 = (int) r11.getX();
        float r5 = this.mDrawAngles[r12] / 2.0f;
        double r6 = r3;
        float r7 = (float) ((Math.cos(Math.toRadians(((this.mAbsoluteAngles[r12] + r4) - r5) * this.mAnimator.getPhaseY())) * r6) + ((double) r0.x));
        float r10 = (float) ((r6 * Math.sin(Math.toRadians(((r4 + this.mAbsoluteAngles[r12]) - r5) * this.mAnimator.getPhaseY()))) + ((double) r0.y));
        MPPointF.recycleInstance(r0);
        return new float[]{r7, r10};
    }

    private void calcAngles() {
        int r1 = ((PieData) this.mData).getEntryCount();
        if (this.mDrawAngles.length == r1) goto L5;
        this.mDrawAngles = new float[r1];
    L9:
        if (this.mAbsoluteAngles.length == r1) goto L11;
        this.mAbsoluteAngles = new float[r1];
    L14:
        float r2 = ((PieData) this.mData).getYValueSum();
        List<IPieDataSet> r5 = ((PieData) this.mData).getDataSets();
        float r6 = this.mMinAngleForSlices;
        if (r6 != 0.0f) goto L17;
    L19:
        boolean r7 = false;
    L20:
        float[] r8 = new float[r1];
        float r9 = 0.0f;
        float r10 = 0.0f;
        int r11 = 0;
        int r12 = 0;
    L22:
        if (r11 >= ((PieData) this.mData).getDataSetCount()) goto L38;
        IPieDataSet r13 = r5.get(r11);
        int r14 = 0;
    L25:
        if (r14 >= r13.getEntryCount()) goto L37;
        float r15 = calcAngle(Math.abs(r13.getEntryForIndex(r14).getY()), r2);
        if (r7 == false) goto L32;
        float r16 = this.mMinAngleForSlices;
        float r4 = r15 - r16;
        if (r4 > 0.0f) goto L31;
        r8[r12] = r16;
        r9 = r9 + (-r4);
        goto L32
    L31:
        r8[r12] = r15;
        r10 = r10 + r4;
    L32:
        this.mDrawAngles[r12] = r15;
        if (r12 != 0) goto L35;
        this.mAbsoluteAngles[r12] = r15;
    L36:
        r12 = r12 + 1;
        r14 = r14 + 1;
        goto L25
    L35:
        float[] r17 = this.mAbsoluteAngles;
        r17[r12] = r17[r12 - 1] + r15;
        goto L36
    L37:
        r11 = r11 + 1;
        goto L22
    L38:
        if (r7 == false) goto L57;
        int r3 = 0;
    L40:
        if (r3 >= r1) goto L46;
        float r18 = r8[r3];
        float r19 = r18 - (((r18 - this.mMinAngleForSlices) / r10) * r9);
        r8[r3] = r19;
        if (r3 != 0) goto L44;
        this.mAbsoluteAngles[0] = r8[0];
    L45:
        r3 = r3 + 1;
        goto L40
    L44:
        float[] r20 = this.mAbsoluteAngles;
        r20[r3] = r20[r3 - 1] + r19;
        goto L45
    L46:
        this.mDrawAngles = r8;
        return;
    L57:
        return;
    L17:
        if ((r1 * r6) > this.mMaxAngle) goto L19;
        r7 = true;
        goto L20
    L11:
        int r21 = 0;
    L12:
        if (r21 >= r1) goto L14;
        this.mAbsoluteAngles[r21] = 0.0f;
        r21 = r21 + 1;
        goto L12
    L5:
        int r22 = 0;
    L6:
        if (r22 >= r1) goto L9;
        this.mDrawAngles[r22] = 0.0f;
        r22 = r22 + 1;
        goto L6
    }

    public boolean needsHighlight(int r4) {
        if (valuesToHighlight() == true) goto L5;
        return false;
    L5:
        int r0 = 0;
    L7:
        if (r0 >= this.mIndicesToHighlight.length) goto L13;
        if (((int) this.mIndicesToHighlight[r0].getX()) == r4) goto L10;
        r0 = r0 + 1;
        goto L7
    L10:
        return true;
    L13:
        return false;
    }

    private float calcAngle(float r2) {
        return calcAngle(r2, ((PieData) this.mData).getYValueSum());
    }

    private float calcAngle(float r1, float r2) {
        return (r1 / r2) * this.mMaxAngle;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    @Deprecated
    public XAxis getXAxis() {
        throw new RuntimeException("PieChart has no XAxis");
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public int getIndexForAngle(float r4) {
        float r5 = Utils.getNormalizedAngle(r4 - getRotationAngle());
        int r0 = 0;
    L3:
        float[] r1 = this.mAbsoluteAngles;
        if (r0 >= r1.length) goto L9;
        if (r1[r0] > r5) goto L7;
        r0 = r0 + 1;
        goto L3
    L7:
        return r0;
    L9:
        return -1;
    }

    public int getDataSetIndexForIndex(int r5) {
        List<IPieDataSet> r4 = ((PieData) this.mData).getDataSets();
        int r0 = 0;
    L4:
        if (r0 >= r4.size()) goto L9;
        if (r4.get(r0).getEntryForXValue(r5, Float.NaN) != null) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r0;
    L9:
        return -1;
    }

    public float[] getDrawAngles() {
        return this.mDrawAngles;
    }

    public float[] getAbsoluteAngles() {
        return this.mAbsoluteAngles;
    }

    public void setHoleColor(int r1) {
        ((PieChartRenderer) this.mRenderer).getPaintHole().setColor(r1);
    }

    public void setDrawSlicesUnderHole(boolean r1) {
        this.mDrawSlicesUnderHole = r1;
    }

    public boolean isDrawSlicesUnderHoleEnabled() {
        return this.mDrawSlicesUnderHole;
    }

    public void setDrawHoleEnabled(boolean r1) {
        this.mDrawHole = r1;
    }

    public boolean isDrawHoleEnabled() {
        return this.mDrawHole;
    }

    public void setCenterText(CharSequence r1) {
        if (r1 != null) goto L4;
        this.mCenterText = "";
        return;
    L4:
        this.mCenterText = r1;
    }

    public CharSequence getCenterText() {
        return this.mCenterText;
    }

    public void setDrawCenterText(boolean r1) {
        this.mDrawCenterText = r1;
    }

    public boolean isDrawCenterTextEnabled() {
        return this.mDrawCenterText;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    protected float getRequiredLegendOffset() {
        return this.mLegendRenderer.getLabelPaint().getTextSize() * 2.0f;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public float getRadius() {
        RectF r0 = this.mCircleBox;
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return Math.min(r0.width() / 2.0f, this.mCircleBox.height() / 2.0f);
    }

    public RectF getCircleBox() {
        return this.mCircleBox;
    }

    public MPPointF getCenterCircleBox() {
        return MPPointF.getInstance(this.mCircleBox.centerX(), this.mCircleBox.centerY());
    }

    public void setCenterTextTypeface(Typeface r1) {
        ((PieChartRenderer) this.mRenderer).getPaintCenterText().setTypeface(r1);
    }

    public void setCenterTextSize(float r1) {
        ((PieChartRenderer) this.mRenderer).getPaintCenterText().setTextSize(Utils.convertDpToPixel(r1));
    }

    public void setCenterTextSizePixels(float r1) {
        ((PieChartRenderer) this.mRenderer).getPaintCenterText().setTextSize(r1);
    }

    public void setCenterTextOffset(float r2, float r3) {
        MPPointF r0 = this.mCenterTextOffset;
        r0.x = Utils.convertDpToPixel(r2);
        MPPointF r1 = this.mCenterTextOffset;
        r1.y = Utils.convertDpToPixel(r3);
    }

    public MPPointF getCenterTextOffset() {
        return MPPointF.getInstance(this.mCenterTextOffset.x, this.mCenterTextOffset.y);
    }

    public void setCenterTextColor(int r1) {
        ((PieChartRenderer) this.mRenderer).getPaintCenterText().setColor(r1);
    }

    public void setHoleRadius(float r1) {
        this.mHoleRadiusPercent = r1;
    }

    public float getHoleRadius() {
        return this.mHoleRadiusPercent;
    }

    public void setTransparentCircleColor(int r2) {
        Paint r1 = ((PieChartRenderer) this.mRenderer).getPaintTransparentCircle();
        int r0 = r1.getAlpha();
        r1.setColor(r2);
        r1.setAlpha(r0);
    }

    public void setTransparentCircleRadius(float r1) {
        this.mTransparentCircleRadiusPercent = r1;
    }

    public float getTransparentCircleRadius() {
        return this.mTransparentCircleRadiusPercent;
    }

    public void setTransparentCircleAlpha(int r1) {
        ((PieChartRenderer) this.mRenderer).getPaintTransparentCircle().setAlpha(r1);
    }

    @Deprecated
    public void setDrawSliceText(boolean r1) {
        this.mDrawEntryLabels = r1;
    }

    public void setDrawEntryLabels(boolean r1) {
        this.mDrawEntryLabels = r1;
    }

    public boolean isDrawEntryLabelsEnabled() {
        return this.mDrawEntryLabels;
    }

    public void setEntryLabelColor(int r1) {
        ((PieChartRenderer) this.mRenderer).getPaintEntryLabels().setColor(r1);
    }

    public void setEntryLabelTypeface(Typeface r1) {
        ((PieChartRenderer) this.mRenderer).getPaintEntryLabels().setTypeface(r1);
    }

    public void setEntryLabelTextSize(float r1) {
        ((PieChartRenderer) this.mRenderer).getPaintEntryLabels().setTextSize(Utils.convertDpToPixel(r1));
    }

    public void setDrawRoundedSlices(boolean r1) {
        this.mDrawRoundedSlices = r1;
    }

    public boolean isDrawRoundedSlicesEnabled() {
        return this.mDrawRoundedSlices;
    }

    public void setUsePercentValues(boolean r1) {
        this.mUsePercentValues = r1;
    }

    public boolean isUsePercentValuesEnabled() {
        return this.mUsePercentValues;
    }

    public void setCenterTextRadiusPercent(float r1) {
        this.mCenterTextRadiusPercent = r1;
    }

    public float getCenterTextRadiusPercent() {
        return this.mCenterTextRadiusPercent;
    }

    public float getMaxAngle() {
        return this.mMaxAngle;
    }

    public void setMaxAngle(float r3) {
        if (r3 <= 360.0f) goto L6;
        r3 = 360.0f;
    L6:
        if (r3 >= 90.0f) goto L8;
        r3 = 90.0f;
    L8:
        this.mMaxAngle = r3;
    }

    public float getMinAngleForSlices() {
        return this.mMinAngleForSlices;
    }

    public void setMinAngleForSlices(float r4) {
        float r0 = this.mMaxAngle;
        if (r4 <= (r0 / 2.0f)) goto L6;
        r4 = r0 / 2.0f;
    L8:
        this.mMinAngleForSlices = r4;
        return;
    L6:
        if (r4 >= 0.0f) goto L8;
        r4 = 0.0f;
        goto L8
    }

    @Override // com.github.mikephil.charting.charts.Chart, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.mRenderer != null) goto L5;
    L7:
        super.onDetachedFromWindow();
        return;
    L5:
        if ((this.mRenderer instanceof PieChartRenderer) == false) goto L7;
        ((PieChartRenderer) this.mRenderer).releaseBitmap();
        goto L7
    }
}
