package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ScatterData extends BarLineScatterCandleBubbleData<IScatterDataSet> {
    public ScatterData() {
    }

    public ScatterData(List<IScatterDataSet> r1) {
        super(r1);
    }

    public ScatterData(IScatterDataSet... r1) {
        super(r1);
    }

    public float getGreatestShapeSize() {
        Iterator r3 = this.mDataSets.iterator();
        float r0 = 0.0f;
    L4:
        if (r3.hasNext() == false) goto L8;
        float r1 = ((IScatterDataSet) r3.next()).getScatterShapeSize();
        if (r1 <= r0) goto L4;
        r0 = r1;
        goto L4
    L8:
        return r0;
    }
}
