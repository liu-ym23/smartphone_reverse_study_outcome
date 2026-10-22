package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.CombinedDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CombinedHighlighter extends ChartHighlighter<CombinedDataProvider> implements IHighlighter {
    protected BarHighlighter barHighlighter;

    public CombinedHighlighter(CombinedDataProvider r1, BarDataProvider r2) {
        super(r1);
        if (r2.getBarData() != null) goto L5;
        BarHighlighter r3 = null;
    L6:
        this.barHighlighter = r3;
        return;
    L5:
        r3 = new BarHighlighter(r2);
        goto L6
    }

    @Override // com.github.mikephil.charting.highlight.ChartHighlighter
    protected List<Highlight> getHighlightsAtXValue(float r9, float r10, float r11) {
        this.mHighlightBuffer.clear();
        List<BarLineScatterCandleBubbleData> r0 = ((CombinedDataProvider) this.mChart).getCombinedData().getAllData();
        int r2 = 0;
    L4:
        if (r2 >= r0.size()) goto L24;
        BarLineScatterCandleBubbleData r3 = r0.get(r2);
        BarHighlighter r4 = this.barHighlighter;
        if (r4 != null) goto L8;
    L12:
        int r5 = r3.getDataSetCount();
        int r6 = 0;
    L13:
        if (r6 >= r5) goto L22;
        IDataSet r7 = r0.get(r2).getDataSetByIndex(r6);
        if (r7.isHighlightEnabled() == false) goto L21;
        Iterator<Highlight> r8 = buildHighlights(r7, r6, r9, DataSet.Rounding.CLOSEST).iterator();
    L19:
        if (r8.hasNext() == false) goto L21;
        Highlight r12 = r8.next();
        r12.setDataIndex(r2);
        this.mHighlightBuffer.add(r12);
    L21:
        r6 = r6 + 1;
    L22:
        r2 = r2 + 1;
        goto L4
    L8:
        if ((r3 instanceof BarData) == false) goto L12;
        Highlight r13 = r4.getHighlight(r10, r11);
        if (r13 == null) goto L22;
        r13.setDataIndex(r2);
        this.mHighlightBuffer.add(r13);
        goto L22
    L24:
        return this.mHighlightBuffer;
    }
}
