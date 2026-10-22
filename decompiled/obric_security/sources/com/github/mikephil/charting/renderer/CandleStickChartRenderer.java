package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.CandleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.ICandleDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CandleStickChartRenderer extends LineScatterCandleRadarRenderer {
    private float[] mBodyBuffers;
    protected CandleDataProvider mChart;
    private float[] mCloseBuffers;
    private float[] mOpenBuffers;
    private float[] mRangeBuffers;
    private float[] mShadowBuffers;

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawExtras(Canvas r1) {
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
    }

    public CandleStickChartRenderer(CandleDataProvider r1, ChartAnimator r2, ViewPortHandler r3) {
        super(r2, r3);
        this.mShadowBuffers = new float[8];
        this.mBodyBuffers = new float[4];
        this.mRangeBuffers = new float[4];
        this.mOpenBuffers = new float[4];
        this.mCloseBuffers = new float[4];
        this.mChart = r1;
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawData(Canvas r4) {
        Iterator r0 = this.mChart.getCandleData().getDataSets().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        ICandleDataSet r1 = (ICandleDataSet) r0.next();
        if (r1.isVisible() == false) goto L4;
        drawDataSet(r4, r1);
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void drawDataSet(Canvas r27, ICandleDataSet r28) {
        Transformer r2 = this.mChart.getTransformer(r28.getAxisDependency());
        float r3 = this.mAnimator.getPhaseY();
        float r4 = r28.getBarSpace();
        boolean r5 = r28.getShowCandleBar();
        this.mXBounds.set(this.mChart, r28);
        this.mRenderPaint.setStrokeWidth(r28.getShadowWidth());
        int r6 = this.mXBounds.min;
    L4:
        if (r6 > (this.mXBounds.range + this.mXBounds.min)) goto L79;
        CandleEntry r7 = (CandleEntry) r28.getEntryForIndex(r6);
        if (r7 == null) goto L78;
        float r8 = r7.getX();
        float r9 = r7.getOpen();
        float r10 = r7.getClose();
        float r11 = r7.getHigh();
        float r12 = r7.getLow();
        if (r5 == false) goto L61;
        float[] r13 = this.mShadowBuffers;
        r13[0] = r8;
        r13[2] = r8;
        r13[4] = r8;
        r13[6] = r8;
        if (r9 <= r10) goto L14;
        r13[1] = r11 * r3;
        r13[3] = r9 * r3;
        r13[5] = r12 * r3;
        r13[7] = r10 * r3;
    L17:
        r2.pointValuesToPixel(r13);
        if (r28.getShadowColorSameAsCandle() == false) goto L37;
        if (r9 <= r10) goto L26;
        Paint r14 = this.mRenderPaint;
        if (r28.getDecreasingColor() != 1122867) goto L23;
        int r15 = r28.getColor(r6);
    L24:
        r14.setColor(r15);
    L42:
        this.mRenderPaint.setStyle(Paint.Style.STROKE);
        r27.drawLines(this.mShadowBuffers, this.mRenderPaint);
        float[] r16 = this.mBodyBuffers;
        r16[0] = (r8 - 0.5f) + r4;
        r16[1] = r10 * r3;
        r16[2] = (r8 + 0.5f) - r4;
        r16[3] = r9 * r3;
        r2.pointValuesToPixel(r16);
        if (r9 <= r10) goto L50;
        if (r28.getDecreasingColor() != 1122867) goto L47;
        this.mRenderPaint.setColor(r28.getColor(r6));
    L48:
        this.mRenderPaint.setStyle(r28.getDecreasingPaintStyle());
        float[] r17 = this.mBodyBuffers;
        r27.drawRect(r17[0], r17[3], r17[2], r17[1], this.mRenderPaint);
        goto L78
    L47:
        this.mRenderPaint.setColor(r28.getDecreasingColor());
        goto L48
    L50:
        if (r9 >= r10) goto L57;
        if (r28.getIncreasingColor() != 1122867) goto L54;
        this.mRenderPaint.setColor(r28.getColor(r6));
    L55:
        this.mRenderPaint.setStyle(r28.getIncreasingPaintStyle());
        float[] r18 = this.mBodyBuffers;
        r27.drawRect(r18[0], r18[1], r18[2], r18[3], this.mRenderPaint);
        goto L78
    L54:
        this.mRenderPaint.setColor(r28.getIncreasingColor());
        goto L55
    L57:
        if (r28.getNeutralColor() != 1122867) goto L59;
        this.mRenderPaint.setColor(r28.getColor(r6));
    L60:
        float[] r19 = this.mBodyBuffers;
        r27.drawLine(r19[0], r19[1], r19[2], r19[3], this.mRenderPaint);
        goto L78
    L59:
        this.mRenderPaint.setColor(r28.getNeutralColor());
        goto L60
    L23:
        r15 = r28.getDecreasingColor();
        goto L24
    L26:
        if (r9 >= r10) goto L32;
        Paint r20 = this.mRenderPaint;
        if (r28.getIncreasingColor() != 1122867) goto L30;
        int r110 = r28.getColor(r6);
    L31:
        r20.setColor(r110);
        goto L42
    L30:
        r110 = r28.getIncreasingColor();
        goto L31
    L32:
        Paint r21 = this.mRenderPaint;
        if (r28.getNeutralColor() != 1122867) goto L35;
        int r111 = r28.getColor(r6);
    L36:
        r21.setColor(r111);
        goto L42
    L35:
        r111 = r28.getNeutralColor();
        goto L36
    L37:
        Paint r22 = this.mRenderPaint;
        if (r28.getShadowColor() != 1122867) goto L40;
        int r112 = r28.getColor(r6);
    L41:
        r22.setColor(r112);
        goto L42
    L40:
        r112 = r28.getShadowColor();
        goto L41
    L14:
        if (r9 >= r10) goto L16;
        r13[1] = r11 * r3;
        r13[3] = r10 * r3;
        r13[5] = r12 * r3;
        r13[7] = r9 * r3;
        goto L17
    L16:
        r13[1] = r11 * r3;
        float r113 = r9 * r3;
        r13[3] = r113;
        r13[5] = r12 * r3;
        r13[7] = r113;
        goto L17
    L61:
        float[] r114 = this.mRangeBuffers;
        r114[0] = r8;
        r114[1] = r11 * r3;
        r114[2] = r8;
        r114[3] = r12 * r3;
        float[] r23 = this.mOpenBuffers;
        r23[0] = (r8 - 0.5f) + r4;
        float r115 = r9 * r3;
        r23[1] = r115;
        r23[2] = r8;
        r23[3] = r115;
        float[] r24 = this.mCloseBuffers;
        r24[0] = (0.5f + r8) - r4;
        float r116 = r10 * r3;
        r24[1] = r116;
        r24[2] = r8;
        r24[3] = r116;
        r2.pointValuesToPixel(r114);
        r2.pointValuesToPixel(this.mOpenBuffers);
        r2.pointValuesToPixel(this.mCloseBuffers);
        if (r9 <= r10) goto L68;
        if (r28.getDecreasingColor() != 1122867) goto L66;
        int r25 = r28.getColor(r6);
    L77:
        this.mRenderPaint.setColor(r25);
        float[] r26 = this.mRangeBuffers;
        r27.drawLine(r26[0], r26[1], r26[2], r26[3], this.mRenderPaint);
        float[] r29 = this.mOpenBuffers;
        r27.drawLine(r29[0], r29[1], r29[2], r29[3], this.mRenderPaint);
        float[] r30 = this.mCloseBuffers;
        r27.drawLine(r30[0], r30[1], r30[2], r30[3], this.mRenderPaint);
        goto L78
    L66:
        r25 = r28.getDecreasingColor();
        goto L77
    L68:
        if (r9 >= r10) goto L74;
        if (r28.getIncreasingColor() != 1122867) goto L72;
        r25 = r28.getColor(r6);
        goto L77
    L72:
        r25 = r28.getIncreasingColor();
        goto L77
    L74:
        if (r28.getNeutralColor() != 1122867) goto L76;
        r25 = r28.getColor(r6);
        goto L77
    L76:
        r25 = r28.getNeutralColor();
    L78:
        r6 = r6 + 1;
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValues(Canvas r27) {
        if (isDrawingValuesAllowed(this.mChart) == false) goto L36;
        List<T> r7 = this.mChart.getCandleData().getDataSets();
        int r9 = 0;
    L6:
        if (r9 >= r7.size()) goto L47;
        ICandleDataSet r5 = (ICandleDataSet) r7.get(r9);
        if (shouldDrawValues(r5) == false) goto L35;
        if (r5.getEntryCount() < 1) goto L35;
        applyValueTextStyle(r5);
        Transformer r10 = this.mChart.getTransformer(r5.getAxisDependency());
        this.mXBounds.set(this.mChart, r5);
        float[] r11 = r10.generateTransformedValuesCandle(r5, this.mAnimator.getPhaseX(), this.mAnimator.getPhaseY(), this.mXBounds.min, this.mXBounds.max);
        float r12 = Utils.convertDpToPixel(5.0f);
        ValueFormatter r13 = r5.getValueFormatter();
        MPPointF r14 = MPPointF.getInstance(r5.getIconsOffset());
        r14.x = Utils.convertDpToPixel(r14.x);
        r14.y = Utils.convertDpToPixel(r14.y);
        int r15 = 0;
    L14:
        if (r15 >= r11.length) goto L34;
        float r16 = r11[r15];
        float r4 = r11[r15 + 1];
        if (this.mViewPortHandler.isInBoundsRight(r16) == false) goto L34;
        if (this.mViewPortHandler.isInBoundsLeft(r16) == true) goto L21;
    L32:
        r5 = r5;
    L33:
        r15 = r15 + 2;
        r5 = r5;
        goto L14
    L21:
        if (this.mViewPortHandler.isInBoundsY(r4) == false) goto L32;
        int r0 = r15 / 2;
        CandleEntry r3 = (CandleEntry) r5.getEntryForIndex(this.mXBounds.min + r0);
        if (r5.isDrawValuesEnabled() == false) goto L28;
        drawValue(r27, r13.getCandleLabel(r3), r16, r4 - r12, r5.getValueTextColor(r0));
    L28:
        if (r3.getIcon() == null) goto L33;
        if (r5.isDrawIconsEnabled() == false) goto L33;
        Drawable r21 = r3.getIcon();
        Utils.drawImage(r27, r21, (int) (r16 + r14.x), (int) (r4 + r14.y), r21.getIntrinsicWidth(), r21.getIntrinsicHeight());
    L34:
        MPPointF.recycleInstance(r14);
    L35:
        r9 = r9 + 1;
        goto L6
    L47:
        return;
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValue(Canvas r2, String r3, float r4, float r5, int r6) {
        this.mValuePaint.setColor(r6);
        r2.drawText(r3, r4, r5, this.mValuePaint);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawHighlighted(Canvas r10, Highlight[] r11) {
        CandleData r0 = this.mChart.getCandleData();
        int r1 = r11.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L14;
        Highlight r3 = r11[r2];
        ILineScatterCandleRadarDataSet r4 = (ICandleDataSet) r0.getDataSetByIndex(r3.getDataSetIndex());
        if (r4 == null) goto L13;
        if (r4.isHighlightEnabled() == false) goto L13;
        CandleEntry r5 = (CandleEntry) r4.getEntryForXValue(r3.getX(), r3.getY());
        if (isInBoundsX(r5, r4) == false) goto L13;
        float r6 = ((r5.getLow() * this.mAnimator.getPhaseY()) + (r5.getHigh() * this.mAnimator.getPhaseY())) / 2.0f;
        MPPointD r7 = this.mChart.getTransformer(r4.getAxisDependency()).getPixelForValues(r5.getX(), r6);
        r3.setDraw((float) r7.x, (float) r7.y);
        drawHighlightLines(r10, (float) r7.x, (float) r7.y, r4);
    L13:
        r2 = r2 + 1;
        goto L3
    }
}
