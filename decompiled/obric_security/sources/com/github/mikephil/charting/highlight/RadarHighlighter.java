package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class RadarHighlighter extends PieRadarHighlighter<RadarChart> {
    public RadarHighlighter(RadarChart r1) {
        super(r1);
    }

    @Override // com.github.mikephil.charting.highlight.PieRadarHighlighter
    protected Highlight getClosestHighlight(int r5, float r6, float r7) {
        List<Highlight> r8 = getHighlightsAtIndex(r5);
        float r9 = ((RadarChart) this.mChart).distanceToCenter(r6, r7) / ((RadarChart) this.mChart).getFactor();
        Highlight r4 = null;
        float r10 = Float.MAX_VALUE;
        int r0 = 0;
    L4:
        if (r0 >= r8.size()) goto L9;
        Highlight r1 = r8.get(r0);
        float r2 = Math.abs(r1.getY() - r9);
        if (r2 >= r10) goto L8;
        r4 = r1;
        r10 = r2;
    L8:
        r0 = r0 + 1;
        goto L4
    L9:
        return r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.github.mikephil.charting.data.Entry] */
    protected List<Highlight> getHighlightsAtIndex(int r18) {
        this.mHighlightBuffer.clear();
        float r2 = ((RadarChart) this.mChart).getAnimator().getPhaseX();
        float r3 = ((RadarChart) this.mChart).getAnimator().getPhaseY();
        float r4 = ((RadarChart) this.mChart).getSliceAngle();
        float r5 = ((RadarChart) this.mChart).getFactor();
        MPPointF r6 = MPPointF.getInstance(0.0f, 0.0f);
        int r7 = 0;
    L4:
        if (r7 >= ((RadarData) ((RadarChart) this.mChart).getData()).getDataSetCount()) goto L7;
        IRadarDataSet r8 = ((RadarData) ((RadarChart) this.mChart).getData()).getDataSetByIndex(r7);
        ?? r9 = r8.getEntryForIndex(r18);
        float r12 = r18;
        Utils.getPosition(((RadarChart) this.mChart).getCenterOffsets(), ((r9.getY() - ((RadarChart) this.mChart).getYChartMin()) * r5) * r3, ((r4 * r12) * r2) + ((RadarChart) this.mChart).getRotationAngle(), r6);
        this.mHighlightBuffer.add(new Highlight(r12, r9.getY(), r6.x, r6.y, r7, r8.getAxisDependency()));
        r7 = r7 + 1;
        goto L4
    L7:
        return this.mHighlightBuffer;
    }
}
