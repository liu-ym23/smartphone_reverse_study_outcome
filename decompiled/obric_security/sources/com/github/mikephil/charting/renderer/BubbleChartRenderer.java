package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BubbleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class BubbleChartRenderer extends BarLineScatterCandleBubbleRenderer {
    private float[] _hsvBuffer;
    protected BubbleDataProvider mChart;
    private float[] pointBuffer;
    private float[] sizeBuffer;

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawExtras(Canvas r1) {
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
    }

    public BubbleChartRenderer(BubbleDataProvider r1, ChartAnimator r2, ViewPortHandler r3) {
        super(r2, r3);
        this.sizeBuffer = new float[4];
        this.pointBuffer = new float[2];
        this._hsvBuffer = new float[3];
        this.mChart = r1;
        this.mRenderPaint.setStyle(Paint.Style.FILL);
        this.mHighlightPaint.setStyle(Paint.Style.STROKE);
        this.mHighlightPaint.setStrokeWidth(Utils.convertDpToPixel(1.5f));
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawData(Canvas r4) {
        Iterator r0 = this.mChart.getBubbleData().getDataSets().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        IBubbleDataSet r1 = (IBubbleDataSet) r0.next();
        if (r1.isVisible() == false) goto L4;
        drawDataSet(r4, r1);
        goto L4
    }

    protected float getShapeSize(float r1, float r2, float r3, boolean r4) {
        if (r4 == false) goto L8;
        if (r2 != 0.0f) goto L6;
        r1 = 1.0f;
        goto L8
    L6:
        r1 = (float) Math.sqrt(r1 / r2);
    L8:
        return r3 * r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void drawDataSet(Canvas r12, IBubbleDataSet r13) {
        if (r13.getEntryCount() >= 1) goto L5;
        return;
    L5:
        Transformer r0 = this.mChart.getTransformer(r13.getAxisDependency());
        float r2 = this.mAnimator.getPhaseY();
        this.mXBounds.set(this.mChart, r13);
        float[] r3 = this.sizeBuffer;
        r3[0] = 0.0f;
        r3[2] = 1.0f;
        r0.pointValuesToPixel(r3);
        boolean r4 = r13.isNormalizeSizeEnabled();
        float[] r5 = this.sizeBuffer;
        float r6 = Math.abs(r5[2] - r5[0]);
        float r7 = Math.min(Math.abs(this.mViewPortHandler.contentBottom() - this.mViewPortHandler.contentTop()), r6);
        int r8 = this.mXBounds.min;
    L7:
        if (r8 > (this.mXBounds.range + this.mXBounds.min)) goto L28;
        BubbleEntry r9 = (BubbleEntry) r13.getEntryForIndex(r8);
        this.pointBuffer[0] = r9.getX();
        this.pointBuffer[1] = r9.getY() * r2;
        r0.pointValuesToPixel(this.pointBuffer);
        float r10 = getShapeSize(r9.getSize(), r13.getMaxSize(), r7, r4) / 2.0f;
        if (this.mViewPortHandler.isInBoundsTop(this.pointBuffer[1] + r10) == false) goto L20;
        if (this.mViewPortHandler.isInBoundsBottom(this.pointBuffer[1] - r10) == false) goto L20;
        if (this.mViewPortHandler.isInBoundsLeft(this.pointBuffer[0] + r10) == false) goto L20;
        if (this.mViewPortHandler.isInBoundsRight(this.pointBuffer[0] - r10) == false) goto L21;
        int r11 = r13.getColor((int) r9.getX());
        this.mRenderPaint.setColor(r11);
        float[] r14 = this.pointBuffer;
        r12.drawCircle(r14[0], r14[1], r10, this.mRenderPaint);
        goto L20
    L21:
        return;
    L20:
        r8 = r8 + 1;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValues(Canvas r28) {
        BubbleData r0 = this.mChart.getBubbleData();
        if (r0 != null) goto L6;
        return;
    L6:
        if (isDrawingValuesAllowed(this.mChart) == false) goto L43;
        List<T> r7 = r0.getDataSets();
        float r8 = Utils.calcTextHeight(this.mValuePaint, "1");
        int r10 = 0;
    L9:
        if (r10 >= r7.size()) goto L54;
        IBubbleDataSet r11 = (IBubbleDataSet) r7.get(r10);
        if (shouldDrawValues(r11) == false) goto L42;
        if (r11.getEntryCount() < 1) goto L42;
        applyValueTextStyle(r11);
        float r1 = Math.max(0.0f, Math.min(1.0f, this.mAnimator.getPhaseX()));
        float r2 = this.mAnimator.getPhaseY();
        this.mXBounds.set(this.mChart, r11);
        float[] r12 = this.mChart.getTransformer(r11.getAxisDependency()).generateTransformedValuesBubble(r11, r2, this.mXBounds.min, this.mXBounds.max);
        if (r1 != 1.0f) goto L18;
        float r13 = r2;
    L19:
        ValueFormatter r14 = r11.getValueFormatter();
        MPPointF r15 = MPPointF.getInstance(r11.getIconsOffset());
        r15.x = Utils.convertDpToPixel(r15.x);
        r15.y = Utils.convertDpToPixel(r15.y);
        int r5 = 0;
    L21:
        if (r5 >= r12.length) goto L41;
        int r3 = r5 / 2;
        int r4 = r11.getValueTextColor(this.mXBounds.min + r3);
        int r16 = Color.argb(Math.round(255.0f * r13), Color.red(r4), Color.green(r4), Color.blue(r4));
        float r6 = r12[r5];
        float r9 = r12[r5 + 1];
        if (this.mViewPortHandler.isInBoundsRight(r6) == false) goto L41;
        if (this.mViewPortHandler.isInBoundsLeft(r6) == true) goto L28;
    L39:
        r5 = r5;
    L40:
        r5 = r5 + 2;
        goto L21
    L28:
        if (this.mViewPortHandler.isInBoundsY(r9) == false) goto L39;
        BubbleEntry r17 = (BubbleEntry) r11.getEntryForIndex(r3 + this.mXBounds.min);
        if (r11.isDrawValuesEnabled() == false) goto L35;
        drawValue(r28, r14.getBubbleLabel(r17), r6, r9 + (0.5f * r8), r16);
    L35:
        if (r17.getIcon() == null) goto L40;
        if (r11.isDrawIconsEnabled() == false) goto L40;
        Drawable r22 = r17.getIcon();
        Utils.drawImage(r28, r22, (int) (r6 + r15.x), (int) (r9 + r15.y), r22.getIntrinsicWidth(), r22.getIntrinsicHeight());
    L41:
        MPPointF.recycleInstance(r15);
        goto L42
    L18:
        r13 = r1;
    L42:
        r10 = r10 + 1;
        goto L9
    L54:
        return;
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValue(Canvas r2, String r3, float r4, float r5, int r6) {
        this.mValuePaint.setColor(r6);
        r2.drawText(r3, r4, r5, this.mValuePaint);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawHighlighted(Canvas r18, Highlight[] r19) {
        BubbleData r2 = this.mChart.getBubbleData();
        float r3 = this.mAnimator.getPhaseY();
        int r4 = r19.length;
        int r6 = 0;
    L3:
        if (r6 >= r4) goto L29;
        Highlight r7 = r19[r6];
        IBubbleDataSet r8 = (IBubbleDataSet) r2.getDataSetByIndex(r7.getDataSetIndex());
        if (r8 == null) goto L28;
        if (r8.isHighlightEnabled() == false) goto L28;
        BubbleEntry r9 = (BubbleEntry) r8.getEntryForXValue(r7.getX(), r7.getY());
        if (r9.getY() != r7.getY()) goto L28;
        if (isInBoundsX(r9, r8) == false) goto L28;
        Transformer r10 = this.mChart.getTransformer(r8.getAxisDependency());
        float[] r11 = this.sizeBuffer;
        r11[0] = 0.0f;
        r11[2] = 1.0f;
        r10.pointValuesToPixel(r11);
        boolean r12 = r8.isNormalizeSizeEnabled();
        float[] r13 = this.sizeBuffer;
        float r14 = Math.min(Math.abs(this.mViewPortHandler.contentBottom() - this.mViewPortHandler.contentTop()), Math.abs(r13[2] - r13[0]));
        this.pointBuffer[0] = r9.getX();
        this.pointBuffer[1] = r9.getY() * r3;
        r10.pointValuesToPixel(this.pointBuffer);
        float[] r15 = this.pointBuffer;
        r7.setDraw(r15[0], r15[1]);
        float r16 = getShapeSize(r9.getSize(), r8.getMaxSize(), r14, r12) / 2.0f;
        if (this.mViewPortHandler.isInBoundsTop(this.pointBuffer[1] + r16) == false) goto L28;
        if (this.mViewPortHandler.isInBoundsBottom(this.pointBuffer[1] - r16) == false) goto L28;
        if (this.mViewPortHandler.isInBoundsLeft(this.pointBuffer[0] + r16) == false) goto L28;
        if (this.mViewPortHandler.isInBoundsRight(this.pointBuffer[0] - r16) == false) goto L34;
        int r17 = r8.getColor((int) r9.getX());
        Color.RGBToHSV(Color.red(r17), Color.green(r17), Color.blue(r17), this._hsvBuffer);
        float[] r110 = this._hsvBuffer;
        r110[2] = r110[2] * 0.5f;
        this.mHighlightPaint.setColor(Color.HSVToColor(Color.alpha(r17), this._hsvBuffer));
        this.mHighlightPaint.setStrokeWidth(r8.getHighlightCircleWidth());
        float[] r20 = this.pointBuffer;
        r18.drawCircle(r20[0], r20[1], r16, this.mHighlightPaint);
        goto L28
    L34:
        return;
    L28:
        r6 = r6 + 1;
        goto L3
    }
}
