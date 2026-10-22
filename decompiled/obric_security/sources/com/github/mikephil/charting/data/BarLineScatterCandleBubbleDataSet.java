package com.github.mikephil.charting.data;

import android.graphics.Color;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BarLineScatterCandleBubbleDataSet<T extends Entry> extends DataSet<T> implements IBarLineScatterCandleBubbleDataSet<T> {
    protected int mHighLightColor;

    public BarLineScatterCandleBubbleDataSet(List<T> r2, String r3) {
        super(r2, r3);
        this.mHighLightColor = Color.rgb(255, 187, 115);
    }

    public void setHighLightColor(int r1) {
        this.mHighLightColor = r1;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet
    public int getHighLightColor() {
        return this.mHighLightColor;
    }

    protected void copy(BarLineScatterCandleBubbleDataSet r1) {
        super.copy(r1);
        r1.mHighLightColor = this.mHighLightColor;
    }
}
