package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.renderer.LineChartRenderer;

/* JADX INFO: loaded from: classes2.dex */
public class LineChart extends BarLineChartBase<LineData> implements LineDataProvider {
    public LineChart(Context r1) {
        super(r1);
    }

    public LineChart(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public LineChart(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    protected void init() {
        super.init();
        this.mRenderer = new LineChartRenderer(this, this.mAnimator, this.mViewPortHandler);
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider
    public LineData getLineData() {
        return (LineData) this.mData;
    }

    @Override // com.github.mikephil.charting.charts.Chart, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.mRenderer != null) goto L5;
    L7:
        super.onDetachedFromWindow();
        return;
    L5:
        if ((this.mRenderer instanceof LineChartRenderer) == false) goto L7;
        ((LineChartRenderer) this.mRenderer).releaseBitmap();
        goto L7
    }
}
