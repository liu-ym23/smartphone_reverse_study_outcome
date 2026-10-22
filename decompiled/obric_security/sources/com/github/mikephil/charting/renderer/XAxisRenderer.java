package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class XAxisRenderer extends AxisRenderer {
    protected RectF mGridClippingRect;
    protected RectF mLimitLineClippingRect;
    private Path mLimitLinePath;
    float[] mLimitLineSegmentsBuffer;
    protected float[] mRenderGridLinesBuffer;
    protected Path mRenderGridLinesPath;
    protected float[] mRenderLimitLinesBuffer;
    protected XAxis mXAxis;

    public XAxisRenderer(ViewPortHandler r1, XAxis r2, Transformer r3) {
        super(r1, r3, r2);
        this.mRenderGridLinesPath = new Path();
        this.mRenderGridLinesBuffer = new float[2];
        this.mGridClippingRect = new RectF();
        this.mRenderLimitLinesBuffer = new float[2];
        this.mLimitLineClippingRect = new RectF();
        this.mLimitLineSegmentsBuffer = new float[4];
        this.mLimitLinePath = new Path();
        this.mXAxis = r2;
        this.mAxisLabelPaint.setColor(-16777216);
        this.mAxisLabelPaint.setTextAlign(Paint.Align.CENTER);
        this.mAxisLabelPaint.setTextSize(Utils.convertDpToPixel(10.0f));
    }

    protected void setupGridPaint() {
        this.mGridPaint.setColor(this.mXAxis.getGridColor());
        this.mGridPaint.setStrokeWidth(this.mXAxis.getGridLineWidth());
        this.mGridPaint.setPathEffect(this.mXAxis.getGridDashPathEffect());
    }

    @Override // com.github.mikephil.charting.renderer.AxisRenderer
    public void computeAxis(float r3, float r4, boolean r5) {
        if (this.mViewPortHandler.contentWidth() > 10.0f) goto L5;
    L11:
        computeAxisValues(r3, r4);
        return;
    L5:
        if (this.mViewPortHandler.isFullyZoomedOutX() == true) goto L11;
        MPPointD r6 = this.mTrans.getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop());
        MPPointD r7 = this.mTrans.getValuesByTouchPoint(this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentTop());
        if (r5 == false) goto L9;
        float r8 = (float) r7.x;
        double r0 = r6.x;
    L10:
        MPPointD.recycleInstance(r6);
        MPPointD.recycleInstance(r7);
        r3 = r8;
        r4 = (float) r0;
        goto L11
    L9:
        r8 = (float) r6.x;
        r0 = r7.x;
        goto L10
    }

    @Override // com.github.mikephil.charting.renderer.AxisRenderer
    protected void computeAxisValues(float r1, float r2) {
        super.computeAxisValues(r1, r2);
        computeSize();
    }

    protected void computeSize() {
        String r0 = this.mXAxis.getLongestLabel();
        this.mAxisLabelPaint.setTypeface(this.mXAxis.getTypeface());
        this.mAxisLabelPaint.setTextSize(this.mXAxis.getTextSize());
        FSize r1 = Utils.calcTextSize(this.mAxisLabelPaint, r0);
        float r2 = r1.width;
        float r3 = Utils.calcTextHeight(this.mAxisLabelPaint, "Q");
        FSize r4 = Utils.getSizeOfRotatedRectangleByDegrees(r2, r3, this.mXAxis.getLabelRotationAngle());
        this.mXAxis.mLabelWidth = Math.round(r2);
        this.mXAxis.mLabelHeight = Math.round(r3);
        this.mXAxis.mLabelRotatedWidth = Math.round(r4.width);
        this.mXAxis.mLabelRotatedHeight = Math.round(r4.height);
        FSize.recycleInstance(r4);
        FSize.recycleInstance(r1);
    }

    @Override // com.github.mikephil.charting.renderer.AxisRenderer
    public void renderAxisLabels(Canvas r8) {
        if (this.mXAxis.isEnabled() == true) goto L5;
        return;
    L5:
        if (this.mXAxis.isDrawLabelsEnabled() == false) goto L23;
        float r0 = this.mXAxis.getYOffset();
        this.mAxisLabelPaint.setTypeface(this.mXAxis.getTypeface());
        this.mAxisLabelPaint.setTextSize(this.mXAxis.getTextSize());
        this.mAxisLabelPaint.setColor(this.mXAxis.getTextColor());
        MPPointF r2 = MPPointF.getInstance(0.0f, 0.0f);
        if (this.mXAxis.getPosition() != XAxis.XAxisPosition.TOP) goto L11;
        r2.x = 0.5f;
        r2.y = 1.0f;
        drawLabels(r8, this.mViewPortHandler.contentTop() - r0, r2);
    L20:
        MPPointF.recycleInstance(r2);
        return;
    L11:
        if (this.mXAxis.getPosition() != XAxis.XAxisPosition.TOP_INSIDE) goto L14;
        r2.x = 0.5f;
        r2.y = 1.0f;
        drawLabels(r8, (this.mViewPortHandler.contentTop() + r0) + this.mXAxis.mLabelRotatedHeight, r2);
        goto L20
    L14:
        if (this.mXAxis.getPosition() != XAxis.XAxisPosition.BOTTOM) goto L17;
        r2.x = 0.5f;
        r2.y = 0.0f;
        drawLabels(r8, this.mViewPortHandler.contentBottom() + r0, r2);
        goto L20
    L17:
        if (this.mXAxis.getPosition() != XAxis.XAxisPosition.BOTTOM_INSIDE) goto L19;
        r2.x = 0.5f;
        r2.y = 0.0f;
        drawLabels(r8, (this.mViewPortHandler.contentBottom() - r0) - this.mXAxis.mLabelRotatedHeight, r2);
        goto L20
    L19:
        r2.x = 0.5f;
        r2.y = 1.0f;
        drawLabels(r8, this.mViewPortHandler.contentTop() - r0, r2);
        r2.x = 0.5f;
        r2.y = 0.0f;
        drawLabels(r8, this.mViewPortHandler.contentBottom() + r0, r2);
        goto L20
    }

    @Override // com.github.mikephil.charting.renderer.AxisRenderer
    public void renderAxisLine(Canvas r8) {
        if (this.mXAxis.isDrawAxisLineEnabled() == true) goto L5;
        return;
    L5:
        if (this.mXAxis.isEnabled() == false) goto L24;
        this.mAxisLinePaint.setColor(this.mXAxis.getAxisLineColor());
        this.mAxisLinePaint.setStrokeWidth(this.mXAxis.getAxisLineWidth());
        this.mAxisLinePaint.setPathEffect(this.mXAxis.getAxisLineDashPathEffect());
        if (this.mXAxis.getPosition() != XAxis.XAxisPosition.TOP) goto L10;
    L13:
        r8.drawLine(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop(), this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentTop(), this.mAxisLinePaint);
    L15:
        if (this.mXAxis.getPosition() != XAxis.XAxisPosition.BOTTOM) goto L17;
    L20:
        r8.drawLine(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentBottom(), this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentBottom(), this.mAxisLinePaint);
        return;
    L17:
        if (this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTTOM_INSIDE) goto L20;
        if (this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTH_SIDED) goto L20;
        return;
    L10:
        if (this.mXAxis.getPosition() == XAxis.XAxisPosition.TOP_INSIDE) goto L13;
        if (this.mXAxis.getPosition() != XAxis.XAxisPosition.BOTH_SIDED) goto L15;
    }

    protected void drawLabels(Canvas r12, float r13, MPPointF r14) {
        float r0 = this.mXAxis.getLabelRotationAngle();
        boolean r1 = this.mXAxis.isCenterAxisLabelsEnabled();
        int r8 = this.mXAxis.mEntryCount * 2;
        float[] r9 = new float[r8];
        int r3 = 0;
    L3:
        if (r3 >= r8) goto L8;
        if (r1 == false) goto L6;
        r9[r3] = this.mXAxis.mCenteredEntries[r3 / 2];
    L7:
        r3 = r3 + 2;
        goto L3
    L6:
        r9[r3] = this.mXAxis.mEntries[r3 / 2];
        goto L7
    L8:
        this.mTrans.pointValuesToPixel(r9);
        int r10 = 0;
    L9:
        if (r10 >= r8) goto L27;
        float r2 = r9[r10];
        if (this.mViewPortHandler.isInBoundsX(r2) == false) goto L26;
        int r4 = r10 / 2;
        String r5 = this.mXAxis.getValueFormatter().getAxisLabel(this.mXAxis.mEntries[r4], this.mXAxis);
        if (this.mXAxis.isAvoidFirstLastClippingEnabled() == true) goto L15;
    L25:
        drawLabel(r12, r5, r2, r13, r14, r0);
        goto L26
    L15:
        if (r4 == (this.mXAxis.mEntryCount - 1)) goto L17;
    L23:
        if (r10 != 0) goto L25;
        r2 = r2 + (Utils.calcTextWidth(this.mAxisLabelPaint, r5) / 2.0f);
        goto L25
    L17:
        if (this.mXAxis.mEntryCount <= 1) goto L23;
        float r6 = Utils.calcTextWidth(this.mAxisLabelPaint, r5);
        if (r6 <= (this.mViewPortHandler.offsetRight() * 2.0f)) goto L25;
        if ((r2 + r6) <= this.mViewPortHandler.getChartWidth()) goto L25;
        r2 = r2 - (r6 / 2.0f);
    L26:
        r10 = r10 + 2;
        goto L9
    }

    protected void drawLabel(Canvas r8, String r9, float r10, float r11, MPPointF r12, float r13) {
        Utils.drawXAxisValue(r8, r9, r10, r11, this.mAxisLabelPaint, r12, r13);
    }

    @Override // com.github.mikephil.charting.renderer.AxisRenderer
    public void renderGridLines(Canvas r8) {
        if (this.mXAxis.isDrawGridLinesEnabled() == true) goto L5;
        return;
    L5:
        if (this.mXAxis.isEnabled() == false) goto L23;
        int r0 = r8.save();
        r8.clipRect(getGridClippingRect());
        if (this.mRenderGridLinesBuffer.length == (this.mAxis.mEntryCount * 2)) goto L10;
        this.mRenderGridLinesBuffer = new float[this.mXAxis.mEntryCount * 2];
    L10:
        float[] r1 = this.mRenderGridLinesBuffer;
        int r2 = 0;
        int r3 = 0;
    L12:
        if (r3 >= r1.length) goto L14;
        int r5 = r3 / 2;
        r1[r3] = this.mXAxis.mEntries[r5];
        r1[r3 + 1] = this.mXAxis.mEntries[r5];
        r3 = r3 + 2;
        goto L12
    L14:
        this.mTrans.pointValuesToPixel(r1);
        setupGridPaint();
        Path r4 = this.mRenderGridLinesPath;
        r4.reset();
    L16:
        if (r2 >= r1.length) goto L18;
        drawGridLine(r8, r1[r2], r1[r2 + 1], r4);
        r2 = r2 + 2;
        goto L16
    L18:
        r8.restoreToCount(r0);
        return;
    }

    public RectF getGridClippingRect() {
        this.mGridClippingRect.set(this.mViewPortHandler.getContentRect());
        this.mGridClippingRect.inset(-this.mAxis.getGridLineWidth(), 0.0f);
        return this.mGridClippingRect;
    }

    protected void drawGridLine(Canvas r1, float r2, float r3, Path r4) {
        r4.moveTo(r2, this.mViewPortHandler.contentBottom());
        r4.lineTo(r2, this.mViewPortHandler.contentTop());
        r1.drawPath(r4, this.mGridPaint);
        r4.reset();
    }

    @Override // com.github.mikephil.charting.renderer.AxisRenderer
    public void renderLimitLines(Canvas r11) {
        List<LimitLine> r0 = this.mXAxis.getLimitLines();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.size() <= 0) goto L19;
        float[] r1 = this.mRenderLimitLinesBuffer;
        r1[0] = 0.0f;
        r1[1] = 0.0f;
        int r5 = 0;
    L9:
        if (r5 >= r0.size()) goto L20;
        LimitLine r6 = r0.get(r5);
        if (r6.isEnabled() == false) goto L14;
        int r7 = r11.save();
        this.mLimitLineClippingRect.set(this.mViewPortHandler.getContentRect());
        this.mLimitLineClippingRect.inset(-r6.getLineWidth(), 0.0f);
        r11.clipRect(this.mLimitLineClippingRect);
        r1[0] = r6.getLimit();
        r1[1] = 0.0f;
        this.mTrans.pointValuesToPixel(r1);
        renderLimitLineLine(r11, r6, r1);
        renderLimitLineLabel(r11, r6, r1, r6.getYOffset() + 2.0f);
        r11.restoreToCount(r7);
    L14:
        r5 = r5 + 1;
        goto L9
    L20:
        return;
    }

    public void renderLimitLineLine(Canvas r6, LimitLine r7, float[] r8) {
        float[] r0 = this.mLimitLineSegmentsBuffer;
        r0[0] = r8[0];
        r0[1] = this.mViewPortHandler.contentTop();
        float[] r1 = this.mLimitLineSegmentsBuffer;
        r1[2] = r8[0];
        r1[3] = this.mViewPortHandler.contentBottom();
        this.mLimitLinePath.reset();
        Path r9 = this.mLimitLinePath;
        float[] r2 = this.mLimitLineSegmentsBuffer;
        r9.moveTo(r2[0], r2[1]);
        Path r10 = this.mLimitLinePath;
        float[] r3 = this.mLimitLineSegmentsBuffer;
        r10.lineTo(r3[2], r3[3]);
        this.mLimitLinePaint.setStyle(Paint.Style.STROKE);
        this.mLimitLinePaint.setColor(r7.getLineColor());
        this.mLimitLinePaint.setStrokeWidth(r7.getLineWidth());
        this.mLimitLinePaint.setPathEffect(r7.getDashPathEffect());
        r6.drawPath(this.mLimitLinePath, this.mLimitLinePaint);
    }

    public void renderLimitLineLabel(Canvas r6, LimitLine r7, float[] r8, float r9) {
        String r0 = r7.getLabel();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.equals("") == true) goto L18;
        this.mLimitLinePaint.setStyle(r7.getTextStyle());
        this.mLimitLinePaint.setPathEffect(null);
        this.mLimitLinePaint.setColor(r7.getTextColor());
        this.mLimitLinePaint.setStrokeWidth(0.5f);
        this.mLimitLinePaint.setTextSize(r7.getTextSize());
        float r1 = r7.getLineWidth() + r7.getXOffset();
        LimitLine.LimitLabelPosition r10 = r7.getLabelPosition();
        if (r10 != LimitLine.LimitLabelPosition.RIGHT_TOP) goto L10;
        float r11 = Utils.calcTextHeight(this.mLimitLinePaint, r0);
        this.mLimitLinePaint.setTextAlign(Paint.Align.LEFT);
        r6.drawText(r0, r8[0] + r1, (this.mViewPortHandler.contentTop() + r9) + r11, this.mLimitLinePaint);
        return;
    L10:
        if (r10 != LimitLine.LimitLabelPosition.RIGHT_BOTTOM) goto L13;
        this.mLimitLinePaint.setTextAlign(Paint.Align.LEFT);
        r6.drawText(r0, r8[0] + r1, this.mViewPortHandler.contentBottom() - r9, this.mLimitLinePaint);
        return;
    L13:
        if (r10 != LimitLine.LimitLabelPosition.LEFT_TOP) goto L15;
        this.mLimitLinePaint.setTextAlign(Paint.Align.RIGHT);
        r6.drawText(r0, r8[0] - r1, (this.mViewPortHandler.contentTop() + r9) + Utils.calcTextHeight(this.mLimitLinePaint, r0), this.mLimitLinePaint);
        return;
    L15:
        this.mLimitLinePaint.setTextAlign(Paint.Align.RIGHT);
        r6.drawText(r0, r8[0] - r1, this.mViewPortHandler.contentBottom() - r9, this.mLimitLinePaint);
        return;
    }
}
