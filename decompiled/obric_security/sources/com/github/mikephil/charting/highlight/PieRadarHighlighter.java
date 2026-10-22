package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.charts.PieRadarChartBase;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PieRadarHighlighter<T extends PieRadarChartBase> implements IHighlighter {
    protected T mChart;
    protected List<Highlight> mHighlightBuffer;

    protected abstract Highlight getClosestHighlight(int r1, float r2, float r3);

    public PieRadarHighlighter(T r2) {
        this.mHighlightBuffer = new ArrayList();
        this.mChart = r2;
    }

    @Override // com.github.mikephil.charting.highlight.IHighlighter
    public Highlight getHighlight(float r5, float r6) {
        if (this.mChart.distanceToCenter(r5, r6) <= this.mChart.getRadius()) goto L5;
        return null;
    L5:
        float r0 = this.mChart.getAngleForPoint(r5, r6);
        T r2 = this.mChart;
        if ((r2 instanceof PieChart) == false) goto L8;
        r0 = r0 / r2.getAnimator().getPhaseY();
    L8:
        int r1 = this.mChart.getIndexForAngle(r0);
        if (r1 >= 0) goto L11;
    L15:
        return null;
    L11:
        if (r1 >= this.mChart.getData().getMaxEntryCountSet().getEntryCount()) goto L15;
        return getClosestHighlight(r1, r5, r6);
    }
}
