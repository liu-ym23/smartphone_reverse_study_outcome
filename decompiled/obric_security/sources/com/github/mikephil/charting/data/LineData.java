package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class LineData extends BarLineScatterCandleBubbleData<ILineDataSet> {
    public LineData() {
    }

    public LineData(ILineDataSet... r1) {
        super(r1);
    }

    public LineData(List<ILineDataSet> r1) {
        super(r1);
    }
}
