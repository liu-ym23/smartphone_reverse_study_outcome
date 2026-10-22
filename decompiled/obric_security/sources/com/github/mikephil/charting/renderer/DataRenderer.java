package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.ChartInterface;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DataRenderer extends Renderer {
    protected ChartAnimator mAnimator;
    protected Paint mDrawPaint;
    protected Paint mHighlightPaint;
    protected Paint mRenderPaint;
    protected Paint mValuePaint;

    public abstract void drawData(Canvas r1);

    public abstract void drawExtras(Canvas r1);

    public abstract void drawHighlighted(Canvas r1, Highlight[] r2);

    public abstract void drawValue(Canvas r1, String r2, float r3, float r4, int r5);

    public abstract void drawValues(Canvas r1);

    public abstract void initBuffers();

    public DataRenderer(ChartAnimator r2, ViewPortHandler r3) {
        super(r3);
        this.mAnimator = r2;
        Paint r4 = new Paint(1);
        this.mRenderPaint = r4;
        r4.setStyle(Paint.Style.FILL);
        this.mDrawPaint = new Paint(4);
        Paint r5 = new Paint(1);
        this.mValuePaint = r5;
        r5.setColor(Color.rgb(63, 63, 63));
        this.mValuePaint.setTextAlign(Paint.Align.CENTER);
        this.mValuePaint.setTextSize(Utils.convertDpToPixel(9.0f));
        Paint r6 = new Paint(1);
        this.mHighlightPaint = r6;
        r6.setStyle(Paint.Style.STROKE);
        this.mHighlightPaint.setStrokeWidth(2.0f);
        this.mHighlightPaint.setColor(Color.rgb(255, 187, 115));
    }

    protected boolean isDrawingValuesAllowed(ChartInterface r2) {
        if (r2.getData().getEntryCount() >= (r2.getMaxVisibleCount() * this.mViewPortHandler.getScaleX())) goto L5;
        return true;
    L5:
        return false;
    }

    public Paint getPaintValues() {
        return this.mValuePaint;
    }

    public Paint getPaintHighlight() {
        return this.mHighlightPaint;
    }

    public Paint getPaintRender() {
        return this.mRenderPaint;
    }

    protected void applyValueTextStyle(IDataSet r3) {
        this.mValuePaint.setTypeface(r3.getValueTypeface());
        this.mValuePaint.setTextSize(r3.getValueTextSize());
    }
}
