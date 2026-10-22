package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class RadarChartRenderer extends LineRadarRenderer {
    protected RadarChart mChart;
    protected Path mDrawDataSetSurfacePathBuffer;
    protected Path mDrawHighlightCirclePathBuffer;
    protected Paint mHighlightCirclePaint;
    protected Paint mWebPaint;

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
    }

    public RadarChartRenderer(RadarChart r3, ChartAnimator r4, ViewPortHandler r5) {
        super(r4, r5);
        this.mDrawDataSetSurfacePathBuffer = new Path();
        this.mDrawHighlightCirclePathBuffer = new Path();
        this.mChart = r3;
        this.mHighlightPaint = new Paint(1);
        this.mHighlightPaint.setStyle(Paint.Style.STROKE);
        this.mHighlightPaint.setStrokeWidth(2.0f);
        this.mHighlightPaint.setColor(Color.rgb(255, 187, 115));
        Paint r6 = new Paint(1);
        this.mWebPaint = r6;
        r6.setStyle(Paint.Style.STROKE);
        this.mHighlightCirclePaint = new Paint(1);
    }

    public Paint getWebPaint() {
        return this.mWebPaint;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawData(Canvas r5) {
        RadarData r0 = (RadarData) this.mChart.getData();
        int r1 = r0.getMaxEntryCountSet().getEntryCount();
        Iterator<IRadarDataSet> r2 = r0.getDataSets().iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        IRadarDataSet r3 = r2.next();
        if (r3.isVisible() == false) goto L4;
        drawDataSet(r5, r3, r1);
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void drawDataSet(Canvas r13, IRadarDataSet r14, int r15) {
        float r0 = this.mAnimator.getPhaseX();
        float r1 = this.mAnimator.getPhaseY();
        float r2 = this.mChart.getSliceAngle();
        float r3 = this.mChart.getFactor();
        MPPointF r4 = this.mChart.getCenterOffsets();
        MPPointF r5 = MPPointF.getInstance(0.0f, 0.0f);
        Path r6 = this.mDrawDataSetSurfacePathBuffer;
        r6.reset();
        int r7 = 0;
        boolean r8 = false;
    L4:
        if (r7 >= r14.getEntryCount()) goto L13;
        this.mRenderPaint.setColor(r14.getColor(r7));
        Utils.getPosition(r4, ((((RadarEntry) r14.getEntryForIndex(r7)).getY() - this.mChart.getYChartMin()) * r3) * r1, ((r7 * r2) * r0) + this.mChart.getRotationAngle(), r5);
        if (Float.isNaN(r5.x) == true) goto L11;
        if (r8 == true) goto L10;
        r6.moveTo(r5.x, r5.y);
        r8 = true;
        goto L11
    L10:
        r6.lineTo(r5.x, r5.y);
    L11:
        r7 = r7 + 1;
        goto L4
    L13:
        if (r14.getEntryCount() <= r15) goto L15;
        r6.lineTo(r4.x, r4.y);
    L15:
        r6.close();
        if (r14.isDrawFilledEnabled() == false) goto L21;
        Drawable r16 = r14.getFillDrawable();
        if (r16 == null) goto L20;
        drawFilledPath(r13, r6, r16);
        goto L21
    L20:
        drawFilledPath(r13, r6, r14.getFillColor(), r14.getFillAlpha());
    L21:
        this.mRenderPaint.setStrokeWidth(r14.getLineWidth());
        this.mRenderPaint.setStyle(Paint.Style.STROKE);
        if (r14.isDrawFilledEnabled() == true) goto L24;
    L25:
        r13.drawPath(r6, this.mRenderPaint);
    L26:
        MPPointF.recycleInstance(r4);
        MPPointF.recycleInstance(r5);
        return;
    L24:
        if (r14.getFillAlpha() >= 255) goto L26;
        goto L25
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValues(Canvas r30) {
        float r7 = this.mAnimator.getPhaseX();
        float r8 = this.mAnimator.getPhaseY();
        float r9 = this.mChart.getSliceAngle();
        float r10 = this.mChart.getFactor();
        MPPointF r11 = this.mChart.getCenterOffsets();
        MPPointF r12 = MPPointF.getInstance(0.0f, 0.0f);
        MPPointF r13 = MPPointF.getInstance(0.0f, 0.0f);
        float r14 = Utils.convertDpToPixel(5.0f);
        int r5 = 0;
    L4:
        if (r5 >= ((RadarData) this.mChart.getData()).getDataSetCount()) goto L23;
        IRadarDataSet r4 = ((RadarData) this.mChart.getData()).getDataSetByIndex(r5);
        if (shouldDrawValues(r4) == true) goto L8;
        int r19 = r5;
        float r22 = r7;
    L22:
        r5 = r19 + 1;
        r7 = r22;
        goto L4
    L8:
        applyValueTextStyle(r4);
        ValueFormatter r3 = r4.getValueFormatter();
        MPPointF r2 = MPPointF.getInstance(r4.getIconsOffset());
        r2.x = Utils.convertDpToPixel(r2.x);
        r2.y = Utils.convertDpToPixel(r2.y);
        int r1 = 0;
    L10:
        if (r1 >= r4.getEntryCount()) goto L21;
        RadarEntry r0 = (RadarEntry) r4.getEntryForIndex(r1);
        MPPointF r16 = r2;
        float r17 = (r1 * r9) * r7;
        Utils.getPosition(r11, ((r0.getY() - this.mChart.getYChartMin()) * r10) * r8, r17 + this.mChart.getRotationAngle(), r12);
        if (r4.isDrawValuesEnabled() == false) goto L16;
        drawValue(r30, r3.getRadarLabel(r0), r12.x, r12.y - r14, r4.getValueTextColor(r1));
    L16:
        if (r0.getIcon() == null) goto L20;
        if (r4.isDrawIconsEnabled() == false) goto L20;
        Drawable r24 = r0.getIcon();
        Utils.getPosition(r11, ((r0.getY() * r10) * r8) + r16.y, r17 + this.mChart.getRotationAngle(), r13);
        r13.y += r16.x;
        Utils.drawImage(r30, r24, (int) r13.x, (int) r13.y, r24.getIntrinsicWidth(), r24.getIntrinsicHeight());
    L20:
        r1 = r1 + 1;
        r2 = r16;
        r4 = r4;
        r3 = r3;
        r5 = r5;
        r7 = r7;
        goto L10
    L21:
        r19 = r5;
        r22 = r7;
        MPPointF.recycleInstance(r2);
        goto L22
    L23:
        MPPointF.recycleInstance(r11);
        MPPointF.recycleInstance(r12);
        MPPointF.recycleInstance(r13);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValue(Canvas r2, String r3, float r4, float r5, int r6) {
        this.mValuePaint.setColor(r6);
        r2.drawText(r3, r4, r5, this.mValuePaint);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawExtras(Canvas r1) {
        drawWeb(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void drawWeb(Canvas r20) {
        float r1 = this.mChart.getSliceAngle();
        float r2 = this.mChart.getFactor();
        float r3 = this.mChart.getRotationAngle();
        MPPointF r4 = this.mChart.getCenterOffsets();
        this.mWebPaint.setStrokeWidth(this.mChart.getWebLineWidth());
        this.mWebPaint.setColor(this.mChart.getWebColor());
        this.mWebPaint.setAlpha(this.mChart.getWebAlpha());
        int r5 = this.mChart.getSkipWebLineCount() + 1;
        int r6 = ((RadarData) this.mChart.getData()).getMaxEntryCountSet().getEntryCount();
        MPPointF r8 = MPPointF.getInstance(0.0f, 0.0f);
        int r10 = 0;
    L3:
        if (r10 >= r6) goto L5;
        Utils.getPosition(r4, this.mChart.getYRange() * r2, (r10 * r1) + r3, r8);
        r20.drawLine(r4.x, r4.y, r8.x, r8.y, this.mWebPaint);
        r10 = r10 + r5;
        goto L3
    L5:
        MPPointF.recycleInstance(r8);
        this.mWebPaint.setStrokeWidth(this.mChart.getWebLineWidthInner());
        this.mWebPaint.setColor(this.mChart.getWebColorInner());
        this.mWebPaint.setAlpha(this.mChart.getWebAlpha());
        int r7 = this.mChart.getYAxis().mEntryCount;
        MPPointF r9 = MPPointF.getInstance(0.0f, 0.0f);
        MPPointF r11 = MPPointF.getInstance(0.0f, 0.0f);
        int r12 = 0;
    L6:
        if (r12 >= r7) goto L12;
        int r13 = 0;
    L9:
        if (r13 >= ((RadarData) this.mChart.getData()).getEntryCount()) goto L11;
        float r14 = (this.mChart.getYAxis().mEntries[r12] - this.mChart.getYChartMin()) * r2;
        Utils.getPosition(r4, r14, (r13 * r1) + r3, r9);
        r13 = r13 + 1;
        Utils.getPosition(r4, r14, (r13 * r1) + r3, r11);
        r20.drawLine(r9.x, r9.y, r11.x, r11.y, this.mWebPaint);
        goto L9
    L11:
        r12 = r12 + 1;
        goto L6
    L12:
        MPPointF.recycleInstance(r9);
        MPPointF.recycleInstance(r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawHighlighted(Canvas r20, Highlight[] r21) {
        float r10 = this.mChart.getSliceAngle();
        float r11 = this.mChart.getFactor();
        MPPointF r12 = this.mChart.getCenterOffsets();
        MPPointF r13 = MPPointF.getInstance(0.0f, 0.0f);
        RadarData r14 = (RadarData) this.mChart.getData();
        int r15 = r21.length;
        int r7 = 0;
        int r6 = 0;
    L3:
        if (r6 >= r15) goto L27;
        Highlight r0 = r21[r6];
        IRadarDataSet r1 = r14.getDataSetByIndex(r0.getDataSetIndex());
        if (r1 == null) goto L26;
        if (r1.isHighlightEnabled() == false) goto L26;
        Entry r2 = (RadarEntry) r1.getEntryForIndex((int) r0.getX());
        if (isInBoundsX(r2, r1) == false) goto L26;
        Utils.getPosition(r12, ((r2.getY() - this.mChart.getYChartMin()) * r11) * this.mAnimator.getPhaseY(), ((r0.getX() * r10) * this.mAnimator.getPhaseX()) + this.mChart.getRotationAngle(), r13);
        r0.setDraw(r13.x, r13.y);
        drawHighlightLines(r20, r13.x, r13.y, r1);
        if (r1.isDrawHighlightCircleEnabled() == false) goto L26;
        if (Float.isNaN(r13.x) == true) goto L26;
        if (Float.isNaN(r13.y) == true) goto L26;
        int r3 = r1.getHighlightCircleStrokeColor();
        if (r3 != 1122867) goto L22;
        r3 = r1.getColor(r7);
    L22:
        if (r1.getHighlightCircleStrokeAlpha() >= 255) goto L24;
        r3 = ColorTemplate.colorWithAlpha(r3, r1.getHighlightCircleStrokeAlpha());
    L24:
        drawHighlightCircle(r20, r13, r1.getHighlightCircleInnerRadius(), r1.getHighlightCircleOuterRadius(), r1.getHighlightCircleFillColor(), r3, r1.getHighlightCircleStrokeWidth());
    L26:
        r6 = r6 + 1;
        r7 = r7;
        goto L3
    L27:
        MPPointF.recycleInstance(r12);
        MPPointF.recycleInstance(r13);
    }

    public void drawHighlightCircle(Canvas r6, MPPointF r7, float r8, float r9, int r10, int r11, float r12) {
        r6.save();
        float r13 = Utils.convertDpToPixel(r9);
        float r14 = Utils.convertDpToPixel(r8);
        if (r10 == 1122867) goto L8;
        Path r1 = this.mDrawHighlightCirclePathBuffer;
        r1.reset();
        r1.addCircle(r7.x, r7.y, r13, Path.Direction.CW);
        if (r14 <= 0.0f) goto L7;
        r1.addCircle(r7.x, r7.y, r14, Path.Direction.CCW);
    L7:
        this.mHighlightCirclePaint.setColor(r10);
        this.mHighlightCirclePaint.setStyle(Paint.Style.FILL);
        r6.drawPath(r1, this.mHighlightCirclePaint);
    L8:
        if (r11 == 1122867) goto L10;
        this.mHighlightCirclePaint.setColor(r11);
        this.mHighlightCirclePaint.setStyle(Paint.Style.STROKE);
        this.mHighlightCirclePaint.setStrokeWidth(Utils.convertDpToPixel(r12));
        r6.drawCircle(r7.x, r7.y, r13, this.mHighlightCirclePaint);
    L10:
        r6.restore();
    }
}
