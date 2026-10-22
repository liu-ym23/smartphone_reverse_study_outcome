package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.exifinterface.media.ExifInterface;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class YAxisRenderer extends AxisRenderer {
    protected Path mDrawZeroLinePath;
    protected float[] mGetTransformedPositionsBuffer;
    protected RectF mGridClippingRect;
    protected RectF mLimitLineClippingRect;
    protected Path mRenderGridLinesPath;
    protected Path mRenderLimitLines;
    protected float[] mRenderLimitLinesBuffer;
    protected YAxis mYAxis;
    protected RectF mZeroLineClippingRect;
    protected Paint mZeroLinePaint;

    public YAxisRenderer(ViewPortHandler r1, YAxis r2, Transformer r3) {
        super(r1, r3, r2);
        this.mRenderGridLinesPath = new Path();
        this.mGridClippingRect = new RectF();
        this.mGetTransformedPositionsBuffer = new float[2];
        this.mDrawZeroLinePath = new Path();
        this.mZeroLineClippingRect = new RectF();
        this.mRenderLimitLines = new Path();
        this.mRenderLimitLinesBuffer = new float[2];
        this.mLimitLineClippingRect = new RectF();
        this.mYAxis = r2;
        if (this.mViewPortHandler == null) goto L6;
        this.mAxisLabelPaint.setColor(-16777216);
        this.mAxisLabelPaint.setTextSize(Utils.convertDpToPixel(10.0f));
        Paint r4 = new Paint(1);
        this.mZeroLinePaint = r4;
        r4.setColor(-7829368);
        this.mZeroLinePaint.setStrokeWidth(1.0f);
        this.mZeroLinePaint.setStyle(Paint.Style.STROKE);
        return;
    }

    @Override // com.github.mikephil.charting.renderer.AxisRenderer
    public void renderAxisLabels(Canvas r7) {
        if (this.mYAxis.isEnabled() == true) goto L5;
        return;
    L5:
        if (this.mYAxis.isDrawLabelsEnabled() == false) goto L22;
        float[] r0 = getTransformedPositions();
        this.mAxisLabelPaint.setTypeface(this.mYAxis.getTypeface());
        this.mAxisLabelPaint.setTextSize(this.mYAxis.getTextSize());
        this.mAxisLabelPaint.setColor(this.mYAxis.getTextColor());
        float r1 = this.mYAxis.getXOffset();
        float r2 = (Utils.calcTextHeight(this.mAxisLabelPaint, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS) / 2.5f) + this.mYAxis.getYOffset();
        YAxis.AxisDependency r3 = this.mYAxis.getAxisDependency();
        YAxis.YAxisLabelPosition r4 = this.mYAxis.getLabelPosition();
        if (r3 != YAxis.AxisDependency.LEFT) goto L14;
        if (r4 != YAxis.YAxisLabelPosition.OUTSIDE_CHART) goto L12;
        this.mAxisLabelPaint.setTextAlign(Paint.Align.RIGHT);
        float r5 = this.mViewPortHandler.offsetLeft();
    L18:
        float r6 = r5 - r1;
    L19:
        drawYLabels(r7, r6, r0, r2);
        return;
    L12:
        this.mAxisLabelPaint.setTextAlign(Paint.Align.LEFT);
        float r8 = this.mViewPortHandler.offsetLeft();
    L16:
        r6 = r8 + r1;
        goto L19
    L14:
        if (r4 != YAxis.YAxisLabelPosition.OUTSIDE_CHART) goto L17;
        this.mAxisLabelPaint.setTextAlign(Paint.Align.LEFT);
        r8 = this.mViewPortHandler.contentRight();
        goto L16
    L17:
        this.mAxisLabelPaint.setTextAlign(Paint.Align.RIGHT);
        r5 = this.mViewPortHandler.contentRight();
        goto L18
    }

    @Override // com.github.mikephil.charting.renderer.AxisRenderer
    public void renderAxisLine(Canvas r8) {
        if (this.mYAxis.isEnabled() == true) goto L5;
        return;
    L5:
        if (this.mYAxis.isDrawAxisLineEnabled() == false) goto L14;
        this.mAxisLinePaint.setColor(this.mYAxis.getAxisLineColor());
        this.mAxisLinePaint.setStrokeWidth(this.mYAxis.getAxisLineWidth());
        if (this.mYAxis.getAxisDependency() != YAxis.AxisDependency.LEFT) goto L10;
        r8.drawLine(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop(), this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentBottom(), this.mAxisLinePaint);
        return;
    L10:
        r8.drawLine(this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentTop(), this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentBottom(), this.mAxisLinePaint);
        return;
    }

    protected void drawYLabels(Canvas r6, float r7, float[] r8, float r9) {
        int r0 = !this.mYAxis.isDrawBottomYLabelEntryEnabled() ? 1 : 0;
        if (this.mYAxis.isDrawTopYLabelEntryEnabled() == false) goto L5;
        int r1 = this.mYAxis.mEntryCount;
    L6:
        if (r0 >= r1) goto L8;
        r6.drawText(this.mYAxis.getFormattedLabel(r0), r7, r8[(r0 * 2) + 1] + r9, this.mAxisLabelPaint);
        r0 = r0 + 1;
        goto L6
    L8:
        return;
    L5:
        r1 = this.mYAxis.mEntryCount - 1;
        goto L6
    }

    @Override // com.github.mikephil.charting.renderer.AxisRenderer
    public void renderGridLines(Canvas r7) {
        if (this.mYAxis.isEnabled() == true) goto L6;
        return;
    L6:
        if (this.mYAxis.isDrawGridLinesEnabled() == false) goto L13;
        int r0 = r7.save();
        r7.clipRect(getGridClippingRect());
        float[] r1 = getTransformedPositions();
        this.mGridPaint.setColor(this.mYAxis.getGridColor());
        this.mGridPaint.setStrokeWidth(this.mYAxis.getGridLineWidth());
        this.mGridPaint.setPathEffect(this.mYAxis.getGridDashPathEffect());
        Path r2 = this.mRenderGridLinesPath;
        r2.reset();
        int r3 = 0;
    L9:
        if (r3 >= r1.length) goto L11;
        r7.drawPath(linePath(r2, r3, r1), this.mGridPaint);
        r2.reset();
        r3 = r3 + 2;
        goto L9
    L11:
        r7.restoreToCount(r0);
    L13:
        if (this.mYAxis.isDrawZeroLineEnabled() == false) goto L17;
        drawZeroLine(r7);
        return;
    }

    public RectF getGridClippingRect() {
        this.mGridClippingRect.set(this.mViewPortHandler.getContentRect());
        this.mGridClippingRect.inset(0.0f, -this.mAxis.getGridLineWidth());
        return this.mGridClippingRect;
    }

    protected Path linePath(Path r3, int r4, float[] r5) {
        int r6 = r4 + 1;
        r3.moveTo(this.mViewPortHandler.offsetLeft(), r5[r6]);
        r3.lineTo(this.mViewPortHandler.contentRight(), r5[r6]);
        return r3;
    }

    protected float[] getTransformedPositions() {
        if (this.mGetTransformedPositionsBuffer.length == (this.mYAxis.mEntryCount * 2)) goto L5;
        this.mGetTransformedPositionsBuffer = new float[this.mYAxis.mEntryCount * 2];
    L5:
        float[] r0 = this.mGetTransformedPositionsBuffer;
        int r1 = 0;
    L7:
        if (r1 >= r0.length) goto L9;
        r0[r1 + 1] = this.mYAxis.mEntries[r1 / 2];
        r1 = r1 + 2;
        goto L7
    L9:
        this.mTrans.pointValuesToPixel(r0);
        return r0;
    }

    protected void drawZeroLine(Canvas r7) {
        int r0 = r7.save();
        this.mZeroLineClippingRect.set(this.mViewPortHandler.getContentRect());
        this.mZeroLineClippingRect.inset(0.0f, -this.mYAxis.getZeroLineWidth());
        r7.clipRect(this.mZeroLineClippingRect);
        MPPointD r1 = this.mTrans.getPixelForValues(0.0f, 0.0f);
        this.mZeroLinePaint.setColor(this.mYAxis.getZeroLineColor());
        this.mZeroLinePaint.setStrokeWidth(this.mYAxis.getZeroLineWidth());
        Path r2 = this.mDrawZeroLinePath;
        r2.reset();
        r2.moveTo(this.mViewPortHandler.contentLeft(), (float) r1.y);
        r2.lineTo(this.mViewPortHandler.contentRight(), (float) r1.y);
        r7.drawPath(r2, this.mZeroLinePaint);
        r7.restoreToCount(r0);
    }

    @Override // com.github.mikephil.charting.renderer.AxisRenderer
    public void renderLimitLines(Canvas r14) {
        List<LimitLine> r0 = this.mYAxis.getLimitLines();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.size() <= 0) goto L33;
        float[] r1 = this.mRenderLimitLinesBuffer;
        int r2 = 0;
        r1[0] = 0.0f;
        r1[1] = 0.0f;
        Path r5 = this.mRenderLimitLines;
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
        this.mLimitLinePaint.setTypeface(r6.getTypeface());
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
