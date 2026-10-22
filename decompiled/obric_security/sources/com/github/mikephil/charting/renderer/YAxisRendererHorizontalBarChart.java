package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class YAxisRendererHorizontalBarChart extends YAxisRenderer {
    protected Path mDrawZeroLinePathBuffer;
    protected float[] mRenderLimitLinesBuffer;
    protected Path mRenderLimitLinesPathBuffer;

    public YAxisRendererHorizontalBarChart(ViewPortHandler r1, YAxis r2, Transformer r3) {
        super(r1, r2, r3);
        this.mDrawZeroLinePathBuffer = new Path();
        this.mRenderLimitLinesPathBuffer = new Path();
        this.mRenderLimitLinesBuffer = new float[4];
        this.mLimitLinePaint.setTextAlign(Paint.Align.LEFT);
    }

    @Override // com.github.mikephil.charting.renderer.AxisRenderer
    public void computeAxis(float r3, float r4, boolean r5) {
        if (this.mViewPortHandler.contentHeight() > 10.0f) goto L5;
    L11:
        computeAxisValues(r3, r4);
        return;
    L5:
        if (this.mViewPortHandler.isFullyZoomedOutX() == true) goto L11;
        MPPointD r6 = this.mTrans.getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop());
        MPPointD r7 = this.mTrans.getValuesByTouchPoint(this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentTop());
        if (r5 == true) goto L9;
        float r8 = (float) r6.x;
        double r0 = r7.x;
    L10:
        MPPointD.recycleInstance(r6);
        MPPointD.recycleInstance(r7);
        r3 = r8;
        r4 = (float) r0;
        goto L11
    L9:
        r8 = (float) r7.x;
        r0 = r6.x;
        goto L10
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer, com.github.mikephil.charting.renderer.AxisRenderer
    public void renderAxisLabels(Canvas r7) {
        if (this.mYAxis.isEnabled() == true) goto L5;
        return;
    L5:
        if (this.mYAxis.isDrawLabelsEnabled() == false) goto L22;
        float[] r0 = getTransformedPositions();
        this.mAxisLabelPaint.setTypeface(this.mYAxis.getTypeface());
        this.mAxisLabelPaint.setTextSize(this.mYAxis.getTextSize());
        this.mAxisLabelPaint.setColor(this.mYAxis.getTextColor());
        this.mAxisLabelPaint.setTextAlign(Paint.Align.CENTER);
        float r1 = Utils.convertDpToPixel(2.5f);
        float r2 = Utils.calcTextHeight(this.mAxisLabelPaint, "Q");
        YAxis.AxisDependency r3 = this.mYAxis.getAxisDependency();
        YAxis.YAxisLabelPosition r4 = this.mYAxis.getLabelPosition();
        if (r3 != YAxis.AxisDependency.LEFT) goto L15;
        if (r4 != YAxis.YAxisLabelPosition.OUTSIDE_CHART) goto L12;
        float r5 = this.mViewPortHandler.contentTop();
    L13:
        float r6 = r5 - r1;
    L19:
        drawYLabels(r7, r6, r0, this.mYAxis.getYOffset());
        return;
    L12:
        r5 = this.mViewPortHandler.contentTop();
        goto L13
    L15:
        if (r4 != YAxis.YAxisLabelPosition.OUTSIDE_CHART) goto L17;
        float r8 = this.mViewPortHandler.contentBottom();
    L18:
        r6 = (r8 + r2) + r1;
        goto L19
    L17:
        r8 = this.mViewPortHandler.contentBottom();
        goto L18
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer, com.github.mikephil.charting.renderer.AxisRenderer
    public void renderAxisLine(Canvas r8) {
        if (this.mYAxis.isEnabled() == true) goto L5;
        return;
    L5:
        if (this.mYAxis.isDrawAxisLineEnabled() == false) goto L14;
        this.mAxisLinePaint.setColor(this.mYAxis.getAxisLineColor());
        this.mAxisLinePaint.setStrokeWidth(this.mYAxis.getAxisLineWidth());
        if (this.mYAxis.getAxisDependency() != YAxis.AxisDependency.LEFT) goto L10;
        r8.drawLine(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop(), this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentTop(), this.mAxisLinePaint);
        return;
    L10:
        r8.drawLine(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentBottom(), this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentBottom(), this.mAxisLinePaint);
        return;
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer
    protected void drawYLabels(Canvas r7, float r8, float[] r9, float r10) {
        this.mAxisLabelPaint.setTypeface(this.mYAxis.getTypeface());
        this.mAxisLabelPaint.setTextSize(this.mYAxis.getTextSize());
        this.mAxisLabelPaint.setColor(this.mYAxis.getTextColor());
        int r0 = !this.mYAxis.isDrawBottomYLabelEntryEnabled() ? 1 : 0;
        if (this.mYAxis.isDrawTopYLabelEntryEnabled() == false) goto L5;
        int r1 = this.mYAxis.mEntryCount;
    L6:
        if (r0 >= r1) goto L8;
        r7.drawText(this.mYAxis.getFormattedLabel(r0), r9[r0 * 2], r8 - r10, this.mAxisLabelPaint);
        r0 = r0 + 1;
        goto L6
    L8:
        return;
    L5:
        r1 = this.mYAxis.mEntryCount - 1;
        goto L6
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer
    protected float[] getTransformedPositions() {
        if (this.mGetTransformedPositionsBuffer.length == (this.mYAxis.mEntryCount * 2)) goto L5;
        this.mGetTransformedPositionsBuffer = new float[this.mYAxis.mEntryCount * 2];
    L5:
        float[] r0 = this.mGetTransformedPositionsBuffer;
        int r1 = 0;
    L7:
        if (r1 >= r0.length) goto L9;
        r0[r1] = this.mYAxis.mEntries[r1 / 2];
        r1 = r1 + 2;
        goto L7
    L9:
        this.mTrans.pointValuesToPixel(r0);
        return r0;
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer
    public RectF getGridClippingRect() {
        this.mGridClippingRect.set(this.mViewPortHandler.getContentRect());
        this.mGridClippingRect.inset(-this.mAxis.getGridLineWidth(), 0.0f);
        return this.mGridClippingRect;
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer
    protected Path linePath(Path r3, int r4, float[] r5) {
        r3.moveTo(r5[r4], this.mViewPortHandler.contentTop());
        r3.lineTo(r5[r4], this.mViewPortHandler.contentBottom());
        return r3;
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer
    protected void drawZeroLine(Canvas r8) {
        int r0 = r8.save();
        this.mZeroLineClippingRect.set(this.mViewPortHandler.getContentRect());
        this.mZeroLineClippingRect.inset(-this.mYAxis.getZeroLineWidth(), 0.0f);
        r8.clipRect(this.mLimitLineClippingRect);
        MPPointD r1 = this.mTrans.getPixelForValues(0.0f, 0.0f);
        this.mZeroLinePaint.setColor(this.mYAxis.getZeroLineColor());
        this.mZeroLinePaint.setStrokeWidth(this.mYAxis.getZeroLineWidth());
        Path r2 = this.mDrawZeroLinePathBuffer;
        r2.reset();
        r2.moveTo(((float) r1.x) - 1.0f, this.mViewPortHandler.contentTop());
        r2.lineTo(((float) r1.x) - 1.0f, this.mViewPortHandler.contentBottom());
        r8.drawPath(r2, this.mZeroLinePaint);
        r8.restoreToCount(r0);
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer, com.github.mikephil.charting.renderer.AxisRenderer
    public void renderLimitLines(Canvas r18) {
        List<LimitLine> r2 = this.mYAxis.getLimitLines();
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.size() <= 0) goto L33;
        float[] r3 = this.mRenderLimitLinesBuffer;
        float r5 = 0.0f;
        r3[0] = 0.0f;
        char r6 = 1;
        r3[1] = 0.0f;
        r3[2] = 0.0f;
        r3[3] = 0.0f;
        Path r9 = this.mRenderLimitLinesPathBuffer;
        r9.reset();
        int r10 = 0;
    L9:
        if (r10 >= r2.size()) goto L34;
        LimitLine r11 = r2.get(r10);
        if (r11.isEnabled() == false) goto L28;
        int r12 = r18.save();
        this.mLimitLineClippingRect.set(this.mViewPortHandler.getContentRect());
        this.mLimitLineClippingRect.inset(-r11.getLineWidth(), r5);
        r18.clipRect(this.mLimitLineClippingRect);
        r3[0] = r11.getLimit();
        r3[2] = r11.getLimit();
        this.mTrans.pointValuesToPixel(r3);
        r3[r6] = this.mViewPortHandler.contentTop();
        r3[3] = this.mViewPortHandler.contentBottom();
        r9.moveTo(r3[0], r3[r6]);
        r9.lineTo(r3[2], r3[3]);
        this.mLimitLinePaint.setStyle(Paint.Style.STROKE);
        this.mLimitLinePaint.setColor(r11.getLineColor());
        this.mLimitLinePaint.setPathEffect(r11.getDashPathEffect());
        this.mLimitLinePaint.setStrokeWidth(r11.getLineWidth());
        r18.drawPath(r9, this.mLimitLinePaint);
        r9.reset();
        String r13 = r11.getLabel();
        if (r13 != null) goto L16;
    L27:
        r18.restoreToCount(r12);
        goto L28
    L16:
        if (r13.equals("") == true) goto L27;
        this.mLimitLinePaint.setStyle(r11.getTextStyle());
        this.mLimitLinePaint.setPathEffect(null);
        this.mLimitLinePaint.setColor(r11.getTextColor());
        this.mLimitLinePaint.setTypeface(r11.getTypeface());
        this.mLimitLinePaint.setStrokeWidth(0.5f);
        this.mLimitLinePaint.setTextSize(r11.getTextSize());
        float r14 = r11.getLineWidth() + r11.getXOffset();
        float r15 = Utils.convertDpToPixel(2.0f) + r11.getYOffset();
        LimitLine.LimitLabelPosition r16 = r11.getLabelPosition();
        if (r16 != LimitLine.LimitLabelPosition.RIGHT_TOP) goto L21;
        float r7 = Utils.calcTextHeight(this.mLimitLinePaint, r13);
        this.mLimitLinePaint.setTextAlign(Paint.Align.LEFT);
        r18.drawText(r13, r3[0] + r14, (this.mViewPortHandler.contentTop() + r15) + r7, this.mLimitLinePaint);
        goto L27
    L21:
        if (r16 != LimitLine.LimitLabelPosition.RIGHT_BOTTOM) goto L24;
        this.mLimitLinePaint.setTextAlign(Paint.Align.LEFT);
        r18.drawText(r13, r3[0] + r14, this.mViewPortHandler.contentBottom() - r15, this.mLimitLinePaint);
        goto L27
    L24:
        if (r16 != LimitLine.LimitLabelPosition.LEFT_TOP) goto L26;
        this.mLimitLinePaint.setTextAlign(Paint.Align.RIGHT);
        r18.drawText(r13, r3[0] - r14, (this.mViewPortHandler.contentTop() + r15) + Utils.calcTextHeight(this.mLimitLinePaint, r13), this.mLimitLinePaint);
        goto L27
    L26:
        this.mLimitLinePaint.setTextAlign(Paint.Align.RIGHT);
        r18.drawText(r13, r3[0] - r14, this.mViewPortHandler.contentBottom() - r15, this.mLimitLinePaint);
    L28:
        r10 = r10 + 1;
        r5 = 0.0f;
        r6 = 1;
        goto L9
    L34:
        return;
    }
}
