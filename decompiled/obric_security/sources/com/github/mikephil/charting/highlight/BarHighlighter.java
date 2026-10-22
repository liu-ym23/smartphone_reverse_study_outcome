package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.MPPointD;

/* JADX INFO: loaded from: classes2.dex */
public class BarHighlighter extends ChartHighlighter<BarDataProvider> {
    public BarHighlighter(BarDataProvider r1) {
        super(r1);
    }

    @Override // com.github.mikephil.charting.highlight.ChartHighlighter, com.github.mikephil.charting.highlight.IHighlighter
    public Highlight getHighlight(float r5, float r6) {
        Highlight r0 = super.getHighlight(r5, r6);
        if (r0 != null) goto L6;
        return null;
    L6:
        MPPointD r7 = getValsForTouch(r5, r6);
        IBarDataSet r8 = (IBarDataSet) ((BarDataProvider) this.mChart).getBarData().getDataSetByIndex(r0.getDataSetIndex());
        if (r8.isStacked() == true) goto L9;
        MPPointD.recycleInstance(r7);
        return r0;
    L9:
        return getStackedHighlight(r0, r8, (float) r7.x, (float) r7.y);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Highlight getStackedHighlight(Highlight r12, IBarDataSet r13, float r14, float r15) {
        BarEntry r16 = (BarEntry) r13.getEntryForXValue(r14, r15);
        if (r16 != null) goto L6;
        return null;
    L6:
        if (r16.getYVals() != null) goto L8;
        return r12;
    L8:
        Range[] r1 = r16.getRanges();
        if (r1.length <= 0) goto L12;
        int r9 = getClosestStackIndex(r1, r15);
        MPPointD r11 = ((BarDataProvider) this.mChart).getTransformer(r13.getAxisDependency()).getPixelForValues(r12.getX(), r1[r9].to);
        Highlight r17 = new Highlight(r16.getX(), r16.getY(), (float) r11.x, (float) r11.y, r12.getDataSetIndex(), r9, r12.getAxis());
        MPPointD.recycleInstance(r11);
        return r17;
    L12:
        return null;
    }

    protected int getClosestStackIndex(Range[] r5, float r6) {
        if (r5 != null) goto L5;
        return 0;
    L5:
        if (r5.length == 0) goto L21;
        int r0 = r5.length;
        int r1 = 0;
        int r2 = 0;
    L8:
        if (r1 >= r0) goto L13;
        if (r5[r1].contains(r6) == true) goto L11;
        r2 = r2 + 1;
        r1 = r1 + 1;
        goto L8
    L11:
        return r2;
    L13:
        int r3 = Math.max(r5.length - 1, 0);
        if (r6 > r5[r3].to) goto L16;
        return 0;
    L16:
        return r3;
    L21:
        return 0;
    }

    @Override // com.github.mikephil.charting.highlight.ChartHighlighter
    protected float getDistance(float r1, float r2, float r3, float r4) {
        return Math.abs(r1 - r3);
    }

    @Override // com.github.mikephil.charting.highlight.ChartHighlighter
    protected BarLineScatterCandleBubbleData getData() {
        return ((BarDataProvider) this.mChart).getBarData();
    }
}
