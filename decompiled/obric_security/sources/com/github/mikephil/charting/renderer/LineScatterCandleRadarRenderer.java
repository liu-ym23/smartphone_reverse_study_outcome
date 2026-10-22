package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Path;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX INFO: loaded from: classes2.dex */
public abstract class LineScatterCandleRadarRenderer extends BarLineScatterCandleBubbleRenderer {
    private Path mHighlightLinePath;

    public LineScatterCandleRadarRenderer(ChartAnimator r1, ViewPortHandler r2) {
        super(r1, r2);
        this.mHighlightLinePath = new Path();
    }

    protected void drawHighlightLines(Canvas r3, float r4, float r5, ILineScatterCandleRadarDataSet r6) {
        this.mHighlightPaint.setColor(r6.getHighLightColor());
        this.mHighlightPaint.setStrokeWidth(r6.getHighlightLineWidth());
        this.mHighlightPaint.setPathEffect(r6.getDashPathEffectHighlight());
        if (r6.isVerticalHighlightIndicatorEnabled() == false) goto L6;
        this.mHighlightLinePath.reset();
        this.mHighlightLinePath.moveTo(r4, this.mViewPortHandler.contentTop());
        this.mHighlightLinePath.lineTo(r4, this.mViewPortHandler.contentBottom());
        r3.drawPath(this.mHighlightLinePath, this.mHighlightPaint);
    L6:
        if (r6.isHorizontalHighlightIndicatorEnabled() == false) goto L9;
        this.mHighlightLinePath.reset();
        this.mHighlightLinePath.moveTo(this.mViewPortHandler.contentLeft(), r5);
        this.mHighlightLinePath.lineTo(this.mViewPortHandler.contentRight(), r5);
        r3.drawPath(this.mHighlightLinePath, this.mHighlightPaint);
        return;
    }
}
