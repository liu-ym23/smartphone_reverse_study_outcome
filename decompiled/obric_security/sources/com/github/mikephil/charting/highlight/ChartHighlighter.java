package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.MPPointD;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ChartHighlighter<T extends BarLineScatterCandleBubbleDataProvider> implements IHighlighter {
    protected T mChart;
    protected List<Highlight> mHighlightBuffer;

    public ChartHighlighter(T r2) {
        this.mHighlightBuffer = new ArrayList();
        this.mChart = r2;
    }

    @Override // com.github.mikephil.charting.highlight.IHighlighter
    public Highlight getHighlight(float r4, float r5) {
        MPPointD r0 = getValsForTouch(r4, r5);
        float r1 = (float) r0.x;
        MPPointD.recycleInstance(r0);
        return getHighlightForX(r1, r4, r5);
    }

    protected MPPointD getValsForTouch(float r2, float r3) {
        return this.mChart.getTransformer(YAxis.AxisDependency.LEFT).getValuesByTouchPoint(r2, r3);
    }

    protected Highlight getHighlightForX(float r7, float r8, float r9) {
        List<Highlight> r1 = getHighlightsAtXValue(r7, r8, r9);
        if (r1.isEmpty() == false) goto L7;
        return null;
    L7:
        if (getMinimumDistance(r1, r9, YAxis.AxisDependency.LEFT) >= getMinimumDistance(r1, r9, YAxis.AxisDependency.RIGHT)) goto L9;
        YAxis.AxisDependency r10 = YAxis.AxisDependency.LEFT;
    L11:
        return getClosestHighlightByPixel(r1, r8, r9, r10, this.mChart.getMaxHighlightDistance());
    L9:
        r10 = YAxis.AxisDependency.RIGHT;
        goto L11
    }

    protected float getMinimumDistance(List<Highlight> r5, float r6, YAxis.AxisDependency r7) {
        float r0 = Float.MAX_VALUE;
        int r1 = 0;
    L4:
        if (r1 >= r5.size()) goto L11;
        Highlight r2 = r5.get(r1);
        if (r2.getAxis() != r7) goto L10;
        float r3 = Math.abs(getHighlightPos(r2) - r6);
        if (r3 >= r0) goto L10;
        r0 = r3;
    L10:
        r1 = r1 + 1;
        goto L4
    L11:
        return r0;
    }

    protected float getHighlightPos(Highlight r1) {
        return r1.getYPx();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.github.mikephil.charting.interfaces.datasets.IDataSet] */
    protected List<Highlight> getHighlightsAtXValue(float r5, float r6, float r7) {
        this.mHighlightBuffer.clear();
        BarLineScatterCandleBubbleData r8 = getData();
        if (r8 == null) goto L5;
        int r9 = r8.getDataSetCount();
        int r0 = 0;
    L7:
        if (r0 >= r9) goto L14;
        ?? r1 = r8.getDataSetByIndex(r0);
        if (r1.isHighlightEnabled() == false) goto L12;
        this.mHighlightBuffer.addAll(buildHighlights(r1, r0, r5, DataSet.Rounding.CLOSEST));
    L12:
        r0 = r0 + 1;
        goto L7
    L14:
        return this.mHighlightBuffer;
    L5:
        return this.mHighlightBuffer;
    }

    protected List<Highlight> buildHighlights(IDataSet r11, int r12, float r13, DataSet.Rounding r14) {
        ArrayList r0 = new ArrayList();
        List r1 = r11.getEntriesForXValue(r13);
        if (r1.size() != 0) goto L8;
        Entry r15 = r11.getEntryForXValue(r13, Float.NaN, r14);
        if (r15 == null) goto L8;
        r1 = r11.getEntriesForXValue(r15.getX());
    L8:
        if (r1.size() != 0) goto L10;
        return r0;
    L10:
        Iterator r16 = r1.iterator();
    L12:
        if (r16.hasNext() == false) goto L14;
        Entry r17 = (Entry) r16.next();
        MPPointD r2 = this.mChart.getTransformer(r11.getAxisDependency()).getPixelForValues(r17.getX(), r17.getY());
        r0.add(new Highlight(r17.getX(), r17.getY(), (float) r2.x, (float) r2.y, r12, r11.getAxisDependency()));
        goto L12
    L14:
        return r0;
    }

    public Highlight getClosestHighlightByPixel(List<Highlight> r6, float r7, float r8, YAxis.AxisDependency r9, float r10) {
        Highlight r0 = null;
        int r1 = 0;
    L4:
        if (r1 >= r6.size()) goto L13;
        Highlight r2 = r6.get(r1);
        if (r9 != null) goto L8;
    L9:
        float r3 = getDistance(r7, r8, r2.getXPx(), r2.getYPx());
        if (r3 >= r10) goto L12;
        r0 = r2;
        r10 = r3;
    L12:
        r1 = r1 + 1;
        goto L4
    L8:
        if (r2.getAxis() != r9) goto L12;
    L13:
        return r0;
    }

    protected float getDistance(float r1, float r2, float r3, float r4) {
        return (float) Math.hypot(r1 - r3, r2 - r4);
    }

    protected BarLineScatterCandleBubbleData getData() {
        return this.mChart.getData();
    }
}
