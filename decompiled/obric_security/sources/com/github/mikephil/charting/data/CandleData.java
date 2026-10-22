package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.ICandleDataSet;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CandleData extends BarLineScatterCandleBubbleData<ICandleDataSet> {
    public CandleData() {
    }

    public CandleData(List<ICandleDataSet> r1) {
        super(r1);
    }

    public CandleData(ICandleDataSet... r1) {
        super(r1);
    }
}
