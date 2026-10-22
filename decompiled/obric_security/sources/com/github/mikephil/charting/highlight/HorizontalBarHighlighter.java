package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.MPPointD;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class HorizontalBarHighlighter extends BarHighlighter {
    public HorizontalBarHighlighter(BarDataProvider r1) {
        super(r1);
    }

    @Override // com.github.mikephil.charting.highlight.BarHighlighter, com.github.mikephil.charting.highlight.ChartHighlighter, com.github.mikephil.charting.highlight.IHighlighter
    public Highlight getHighlight(float r5, float r6) {
        BarData r0 = ((BarDataProvider) this.mChart).getBarData();
        MPPointD r1 = getValsForTouch(r6, r5);
        Highlight r7 = getHighlightForX((float) r1.y, r6, r5);
        if (r7 != null) goto L6;
        return null;
    L6:
        IBarDataSet r8 = (IBarDataSet) r0.getDataSetByIndex(r7.getDataSetIndex());
        if (r8.isStacked() == true) goto L9;
        MPPointD.recycleInstance(r1);
        return r7;
    L9:
        return getStackedHighlight(r7, r8, (float) r1.y, (float) r1.x);
    }

    @Override // com.github.mikephil.charting.highlight.ChartHighlighter
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
        MPPointD r2 = ((BarDataProvider) this.mChart).getTransformer(r11.getAxisDependency()).getPixelForValues(r17.getY(), r17.getX());
        r0.add(new Highlight(r17.getX(), r17.getY(), (float) r2.x, (float) r2.y, r12, r11.getAxisDependency()));
        goto L12
    L14:
        return r0;
    }

    @Override // com.github.mikephil.charting.highlight.BarHighlighter, com.github.mikephil.charting.highlight.ChartHighlighter
    protected float getDistance(float r1, float r2, float r3, float r4) {
        return Math.abs(r2 - r4);
    }
}
