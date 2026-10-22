package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class BubbleData extends BarLineScatterCandleBubbleData<IBubbleDataSet> {
    public BubbleData() {
    }

    public BubbleData(IBubbleDataSet... r1) {
        super(r1);
    }

    public BubbleData(List<IBubbleDataSet> r1) {
        super(r1);
    }

    public void setHighlightCircleWidth(float r2) {
        Iterator r1 = this.mDataSets.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((IBubbleDataSet) r1.next()).setHighlightCircleWidth(r2);
        goto L4
    }
}
