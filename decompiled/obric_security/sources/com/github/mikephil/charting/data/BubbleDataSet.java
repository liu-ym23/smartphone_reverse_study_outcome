package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class BubbleDataSet extends BarLineScatterCandleBubbleDataSet<BubbleEntry> implements IBubbleDataSet {
    private float mHighlightCircleWidth;
    protected float mMaxSize;
    protected boolean mNormalizeSize;

    @Override // com.github.mikephil.charting.data.DataSet
    protected /* bridge */ /* synthetic */ void calcMinMax(Entry r1) {
        calcMinMax((BubbleEntry) r1);
    }

    public BubbleDataSet(List<BubbleEntry> r1, String r2) {
        super(r1, r2);
        this.mNormalizeSize = true;
        this.mHighlightCircleWidth = 2.5f;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet
    public void setHighlightCircleWidth(float r1) {
        this.mHighlightCircleWidth = Utils.convertDpToPixel(r1);
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet
    public float getHighlightCircleWidth() {
        return this.mHighlightCircleWidth;
    }

    protected void calcMinMax(BubbleEntry r2) {
        super.calcMinMax(r2);
        float r3 = r2.getSize();
        if (r3 <= this.mMaxSize) goto L6;
        this.mMaxSize = r3;
        return;
    }

    @Override // com.github.mikephil.charting.data.DataSet
    public DataSet<BubbleEntry> copy() {
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L4:
        if (r1 >= this.mValues.size()) goto L6;
        r0.add(((BubbleEntry) this.mValues.get(r1)).copy());
        r1 = r1 + 1;
        goto L4
    L6:
        BubbleDataSet r2 = new BubbleDataSet(r0, getLabel());
        copy(r2);
        return r2;
    }

    protected void copy(BubbleDataSet r2) {
        r2.mHighlightCircleWidth = this.mHighlightCircleWidth;
        r2.mNormalizeSize = this.mNormalizeSize;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet
    public float getMaxSize() {
        return this.mMaxSize;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet
    public boolean isNormalizeSizeEnabled() {
        return this.mNormalizeSize;
    }

    public void setNormalizeSizeEnabled(boolean r1) {
        this.mNormalizeSize = r1;
    }
}
