package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.charts.BarChart;
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
public class XAxisRendererHorizontalBarChart extends XAxisRenderer {
    protected BarChart mChart;
    protected Path mRenderLimitLinesPathBuffer;

    public XAxisRendererHorizontalBarChart(ViewPortHandler r1, XAxis r2, Transformer r3, BarChart r4) {
        super(r1, r2, r3);
        this.mRenderLimitLinesPathBuffer = new Path();
        this.mChart = r4;
    }

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer, com.github.mikephil.charting.renderer.AxisRenderer
    public void computeAxis(float r3, float r4, boolean r5) {
        if (this.mViewPortHandler.contentWidth() > 10.0f) goto L5;
    L11:
        computeAxisValues(r3, r4);
        return;
    L5:
        if (this.mViewPortHandler.isFullyZoomedOutY() == true) goto L11;
        MPPointD r6 = this.mTrans.getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentBottom());
        MPPointD r7 = this.mTrans.getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop());
        if (r5 == false) goto L9;
        float r8 = (float) r7.y;
        double r0 = r6.y;
    L10:
        MPPointD.recycleInstance(r6);
        MPPointD.recycleInstance(r7);
        r3 = r8;
        r4 = (float) r0;
        goto L11
    L9:
        r8 = (float) r6.y;
        r0 = r7.y;
        goto L10
    }

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer
    protected void computeSize() {
        this.mAxisLabelPaint.setTypeface(this.mXAxis.getTypeface());
        this.mAxisLabelPaint.setTextSize(this.mXAxis.getTextSize());
        FSize r0 = Utils.calcTextSize(this.mAxisLabelPaint, this.mXAxis.getLongestLabel());
        float r1 = (int) (r0.width + (this.mXAxis.getXOffset() * 3.5f));
        float r2 = r0.height;
        FSize r3 = Utils.getSizeOfRotatedRectangleByDegrees(r0.width, r2, this.mXAxis.getLabelRotationAngle());
        this.mXAxis.mLabelWidth = Math.round(r1);
        this.mXAxis.mLabelHeight = Math.round(r2);
        this.mXAxis.mLabelRotatedWidth = (int) (r3.width + (this.mXAxis.getXOffset() * 3.5f));
        this.mXAxis.mLabelRotatedHeight = Math.round(r3.height);
        FSize.recycleInstance(r3);
    }

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer, com.github.mikephil.charting.renderer.AxisRenderer
    public void renderAxisLabels(Canvas r8) {
        if (this.mXAxis.isEnabled() == true) goto L5;
        return;
    L5:
        if (this.mXAxis.isDrawLabelsEnabled() == false) goto L23;
        float r0 = this.mXAxis.getXOffset();
        this.mAxisLabelPaint.setTypeface(this.mXAxis.getTypeface());
        this.mAxisLabelPaint.setTextSize(this.mXAxis.getTextSize());
        this.mAxisLabelPaint.setColor(this.mXAxis.getTextColor());
        MPPointF r2 = MPPointF.getInstance(0.0f, 0.0f);
        if (this.mXAxis.getPosition() != XAxis.XAxisPosition.TOP) goto L11;
        r2.x = 0.0f;
        r2.y = 0.5f;
        drawLabels(r8, this.mViewPortHandler.contentRight() + r0, r2);
    L20:
        MPPointF.recycleInstance(r2);
        return;
    L11:
        if (this.mXAxis.getPosition() != XAxis.XAxisPosition.TOP_INSIDE) goto L14;
        r2.x = 1.0f;
        r2.y = 0.5f;
        drawLabels(r8, this.mViewPortHandler.contentRight() - r0, r2);
        goto L20
    L14:
        if (this.mXAxis.getPosition() != XAxis.XAxisPosition.BOTTOM) goto L17;
        r2.x = 1.0f;
        r2.y = 0.5f;
        drawLabels(r8, this.mViewPortHandler.contentLeft() - r0, r2);
        goto L20
    L17:
        if (this.mXAxis.getPosition() != XAxis.XAxisPosition.BOTTOM_INSIDE) goto L19;
        r2.x = 1.0f;
        r2.y = 0.5f;
        drawLabels(r8, this.mViewPortHandler.contentLeft() + r0, r2);
        goto L20
    L19:
        r2.x = 0.0f;
        r2.y = 0.5f;
        drawLabels(r8, this.mViewPortHandler.contentRight() + r0, r2);
        r2.x = 1.0f;
        r2.y = 0.5f;
        drawLabels(r8, this.mViewPortHandler.contentLeft() - r0, r2);
        goto L20
    }

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer
    protected void drawLabels(Canvas r12, float r13, MPPointF r14) {
        float r0 = this.mXAxis.getLabelRotationAngle();
        boolean r1 = this.mXAxis.isCenterAxisLabelsEnabled();
        int r8 = this.mXAxis.mEntryCount * 2;
        float[] r9 = new float[r8];
        int r3 = 0;
    L3:
        if (r3 >= r8) goto L8;
        if (r1 == false) goto L6;
        r9[r3 + 1] = this.mXAxis.mCenteredEntries[r3 / 2];
    L7:
        r3 = r3 + 2;
        goto L3
    L6:
        r9[r3 + 1] = this.mXAxis.mEntries[r3 / 2];
        goto L7
    L8:
        this.mTrans.pointValuesToPixel(r9);
        int r10 = 0;
    L9:
        if (r10 >= r8) goto L14;
        float r5 = r9[r10 + 1];
        if (this.mViewPortHandler.isInBoundsY(r5) == false) goto L13;
        drawLabel(r12, this.mXAxis.getValueFormatter().getAxisLabel(this.mXAxis.mEntries[r10 / 2], this.mXAxis), r13, r5, r14, r0);
    L13:
        r10 = r10 + 2;
        goto L9
    }

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer
    public RectF getGridClippingRect() {
        this.mGridClippingRect.set(this.mViewPortHandler.getContentRect());
        this.mGridClippingRect.inset(0.0f, -this.mAxis.getGridLineWidth());
        return this.mGridClippingRect;
    }

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer
    protected void drawGridLine(Canvas r1, float r2, float r3, Path r4) {
        r4.moveTo(this.mViewPortHandler.contentRight(), r3);
        r4.lineTo(this.mViewPortHandler.contentLeft(), r3);
        r1.drawPath(r4, this.mGridPaint);
        r4.reset();
    }

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer, com.github.mikephil.charting.renderer.AxisRenderer
    public void renderAxisLine(Canvas r8) {
        if (this.mXAxis.isDrawAxisLineEnabled() == true) goto L5;
        return;
    L5:
        if (this.mXAxis.isEnabled() == false) goto L24;
        this.mAxisLinePaint.setColor(this.mXAxis.getAxisLineColor());
        this.mAxisLinePaint.setStrokeWidth(this.mXAxis.getAxisLineWidth());
        if (this.mXAxis.getPosition() != XAxis.XAxisPosition.TOP) goto L10;
    L13:
        r8.drawLine(this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentTop(), this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentBottom(), this.mAxisLinePaint);
    L15:
        if (this.mXAxis.getPosition() != XAxis.XAxisPosition.BOTTOM) goto L17;
    L20:
        r8.drawLine(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop(), this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentBottom(), this.mAxisLinePaint);
        return;
    L17:
        if (this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTTOM_INSIDE) goto L20;
        if (this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTH_SIDED) goto L20;
        return;
    L10:
        if (this.mXAxis.getPosition() == XAxis.XAxisPosition.TOP_INSIDE) goto L13;
        if (this.mXAxis.getPosition() != XAxis.XAxisPosition.BOTH_SIDED) goto L15;
    }

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer, com.github.mikephil.charting.renderer.AxisRenderer
    public void renderLimitLines(Canvas r14) {
        List<LimitLine> r0 = this.mXAxis.getLimitLines();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.size() <= 0) goto L33;
        float[] r1 = this.mRenderLimitLinesBuffer;
        int r2 = 0;
        r1[0] = 0.0f;
        r1[1] = 0.0f;
        Path r5 = this.mRenderLimitLinesPathBuffer;
        r5.reset();
    L9:
        if (r2 >= r0.size()) goto L34;
        LimitLine r6 = r0.get(r2);
        if (r6.isEnabled() == false) goto L28;
        int r7 = r14.save();
        this.mLimitLineClippingRect.set(this.mViewPortHandler.getContentRect());
        this.mLimitLineClippingRect.inset(0.0f, -r6.getLineWidth());
        r14.clipRect(this.mLimitLineClippingRect);
        this.mLimitLinePaint.setStyle(Paint.Style.STROKE);
        this.mLimitLinePaint.setColor(r6.getLineColor());
        this.mLimitLinePaint.setStrokeWidth(r6.getLineWidth());
        this.mLimitLinePaint.setPathEffect(r6.getDashPathEffect());
        r1[1] = r6.getLimit();
        this.mTrans.pointValuesToPixel(r1);
        r5.moveTo(this.mViewPortHandler.contentLeft(), r1[1]);
        r5.lineTo(this.mViewPortHandler.contentRight(), r1[1]);
        r14.drawPath(r5, this.mLimitLinePaint);
        r5.reset();
        String r8 = r6.getLabel();
        if (r8 != null) goto L16;
    L27:
        r14.restoreToCount(r7);
        goto L28
    L16:
        if (r8.equals("") == true) goto L27;
        this.mLimitLinePaint.setStyle(r6.getTextStyle());
        this.mLimitLinePaint.setPathEffect(null);
        this.mLimitLinePaint.setColor(r6.getTextColor());
        this.mLimitLinePaint.setStrokeWidth(0.5f);
        this.mLimitLinePaint.setTextSize(r6.getTextSize());
        float r9 = Utils.calcTextHeight(this.mLimitLinePaint, r8);
        float r10 = Utils.convertDpToPixel(4.0f) + r6.getXOffset();
        float r11 = (r6.getLineWidth() + r9) + r6.getYOffset();
        LimitLine.LimitLabelPosition r12 = r6.getLabelPosition();
        if (r12 != LimitLine.LimitLabelPosition.RIGHT_TOP) goto L21;
        this.mLimitLinePaint.setTextAlign(Paint.Align.RIGHT);
        r14.drawText(r8, this.mViewPortHandler.contentRight() - r10, (r1[1] - r11) + r9, this.mLimitLinePaint);
        goto L27
    L21:
        if (r12 != LimitLine.LimitLabelPosition.RIGHT_BOTTOM) goto L24;
        this.mLimitLinePaint.setTextAlign(Paint.Align.RIGHT);
        r14.drawText(r8, this.mViewPortHandler.contentRight() - r10, r1[1] + r11, this.mLimitLinePaint);
        goto L27
    L24:
        if (r12 != LimitLine.LimitLabelPosition.LEFT_TOP) goto L26;
        this.mLimitLinePaint.setTextAlign(Paint.Align.LEFT);
        r14.drawText(r8, this.mViewPortHandler.contentLeft() + r10, (r1[1] - r11) + r9, this.mLimitLinePaint);
        goto L27
    L26:
        this.mLimitLinePaint.setTextAlign(Paint.Align.LEFT);
        r14.drawText(r8, this.mViewPortHandler.offsetLeft() + r10, r1[1] + r11, this.mLimitLinePaint);
    L28:
        r2 = r2 + 1;
        goto L9
    L34:
        return;
    }
}
