package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.ScatterDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.renderer.scatter.IShapeRenderer;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ScatterChartRenderer extends LineScatterCandleRadarRenderer {
    protected ScatterDataProvider mChart;
    float[] mPixelBuffer;

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawExtras(Canvas r1) {
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
    }

    public ScatterChartRenderer(ScatterDataProvider r1, ChartAnimator r2, ViewPortHandler r3) {
        super(r2, r3);
        this.mPixelBuffer = new float[2];
        this.mChart = r1;
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawData(Canvas r4) {
        Iterator r0 = this.mChart.getScatterData().getDataSets().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        IScatterDataSet r1 = (IScatterDataSet) r0.next();
        if (r1.isVisible() == false) goto L4;
        drawDataSet(r4, r1);
        goto L4
    }

    /* JADX WARN: Type inference failed for: r1v9, types: [com.github.mikephil.charting.data.Entry] */
    protected void drawDataSet(Canvas r19, IScatterDataSet r20) {
        if (r20.getEntryCount() >= 1) goto L5;
        return;
    L5:
        ViewPortHandler r10 = this.mViewPortHandler;
        Transformer r11 = this.mChart.getTransformer(r20.getAxisDependency());
        float r12 = this.mAnimator.getPhaseY();
        IShapeRenderer r13 = r20.getShapeRenderer();
        if (r13 != null) goto L9;
        Log.i("MISSING", "There's no IShapeRenderer specified for ScatterDataSet");
        return;
    L9:
        int r14 = (int) Math.min(Math.ceil(r20.getEntryCount() * this.mAnimator.getPhaseX()), r20.getEntryCount());
        int r7 = 0;
    L10:
        if (r7 >= r14) goto L22;
        ?? r1 = r20.getEntryForIndex(r7);
        this.mPixelBuffer[0] = r1.getX();
        this.mPixelBuffer[1] = r1.getY() * r12;
        r11.pointValuesToPixel(this.mPixelBuffer);
        if (r10.isInBoundsRight(this.mPixelBuffer[0]) == false) goto L27;
        if (r10.isInBoundsLeft(this.mPixelBuffer[0]) == false) goto L21;
        if (r10.isInBoundsY(this.mPixelBuffer[1]) == false) goto L21;
        this.mRenderPaint.setColor(r20.getColor(r7 / 2));
        ViewPortHandler r4 = this.mViewPortHandler;
        float[] r2 = this.mPixelBuffer;
        r13.renderShape(r19, r20, r4, r2[0], r2[1], this.mRenderPaint);
    L21:
        r7 = r7 + 1;
        goto L10
    L27:
        return;
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValues(Canvas r26) {
        if (isDrawingValuesAllowed(this.mChart) == false) goto L36;
        List<T> r7 = this.mChart.getScatterData().getDataSets();
        int r9 = 0;
    L6:
        if (r9 >= this.mChart.getScatterData().getDataSetCount()) goto L47;
        IScatterDataSet r5 = (IScatterDataSet) r7.get(r9);
        if (shouldDrawValues(r5) == false) goto L35;
        if (r5.getEntryCount() < 1) goto L35;
        applyValueTextStyle(r5);
        this.mXBounds.set(this.mChart, r5);
        float[] r10 = this.mChart.getTransformer(r5.getAxisDependency()).generateTransformedValuesScatter(r5, this.mAnimator.getPhaseX(), this.mAnimator.getPhaseY(), this.mXBounds.min, this.mXBounds.max);
        float r11 = Utils.convertDpToPixel(r5.getScatterShapeSize());
        ValueFormatter r12 = r5.getValueFormatter();
        MPPointF r13 = MPPointF.getInstance(r5.getIconsOffset());
        r13.x = Utils.convertDpToPixel(r13.x);
        r13.y = Utils.convertDpToPixel(r13.y);
        int r14 = 0;
    L14:
        if (r14 >= r10.length) goto L34;
        if (this.mViewPortHandler.isInBoundsRight(r10[r14]) == false) goto L34;
        if (this.mViewPortHandler.isInBoundsLeft(r10[r14]) == false) goto L32;
        int r15 = r14 + 1;
        if (this.mViewPortHandler.isInBoundsY(r10[r15]) == false) goto L32;
        int r0 = r14 / 2;
        Entry r4 = r5.getEntryForIndex(this.mXBounds.min + r0);
        if (r5.isDrawValuesEnabled() == false) goto L28;
        drawValue(r26, r12.getPointLabel(r4), r10[r14], r10[r15] - r11, r5.getValueTextColor(r0 + this.mXBounds.min));
    L28:
        if (r4.getIcon() == null) goto L33;
        if (r5.isDrawIconsEnabled() == false) goto L33;
        Drawable r20 = r4.getIcon();
        Utils.drawImage(r26, r20, (int) (r10[r14] + r13.x), (int) (r10[r15] + r13.y), r20.getIntrinsicWidth(), r20.getIntrinsicHeight());
    L33:
        r14 = r14 + 2;
        r5 = r5;
    L32:
        r5 = r5;
    L34:
        MPPointF.recycleInstance(r13);
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
    /* JADX WARN: Type inference failed for: r5v2, types: [com.github.mikephil.charting.data.Entry] */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawHighlighted(Canvas r10, Highlight[] r11) {
        ScatterData r0 = this.mChart.getScatterData();
        int r1 = r11.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L14;
        Highlight r3 = r11[r2];
        IScatterDataSet r4 = (IScatterDataSet) r0.getDataSetByIndex(r3.getDataSetIndex());
        if (r4 == null) goto L13;
        if (r4.isHighlightEnabled() == false) goto L13;
        ?? r5 = r4.getEntryForXValue(r3.getX(), r3.getY());
        if (isInBoundsX(r5, r4) == false) goto L13;
        MPPointD r6 = this.mChart.getTransformer(r4.getAxisDependency()).getPixelForValues(r5.getX(), r5.getY() * this.mAnimator.getPhaseY());
        r3.setDraw((float) r6.x, (float) r6.y);
        drawHighlightLines(r10, (float) r6.x, (float) r6.y, r4);
    L13:
        r2 = r2 + 1;
        goto L3
    }
}
