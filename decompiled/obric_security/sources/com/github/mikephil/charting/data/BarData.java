package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class BarData extends BarLineScatterCandleBubbleData<IBarDataSet> {
    private float mBarWidth;

    public BarData() {
        this.mBarWidth = 0.85f;
    }

    public BarData(IBarDataSet... r1) {
        super(r1);
        this.mBarWidth = 0.85f;
    }

    public BarData(List<IBarDataSet> r1) {
        super(r1);
        this.mBarWidth = 0.85f;
    }

    public void setBarWidth(float r1) {
        this.mBarWidth = r1;
    }

    public float getBarWidth() {
        return this.mBarWidth;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void groupBars(float r9, float r10, float r11) {
        if (this.mDataSets.size() <= 1) goto L24;
        int r0 = ((IBarDataSet) getMaxEntryCountSet()).getEntryCount();
        float r2 = r10 / 2.0f;
        float r3 = r11 / 2.0f;
        float r4 = this.mBarWidth / 2.0f;
        float r12 = getGroupWidth(r10, r11);
        int r13 = 0;
    L5:
        if (r13 >= r0) goto L21;
        float r1 = r9 + r2;
        Iterator r5 = this.mDataSets.iterator();
    L8:
        if (r5.hasNext() == false) goto L15;
        IBarDataSet r6 = (IBarDataSet) r5.next();
        float r7 = (r1 + r3) + r4;
        if (r13 >= r6.getEntryCount()) goto L14;
        BarEntry r8 = (BarEntry) r6.getEntryForIndex(r13);
        if (r8 == null) goto L14;
        r8.setX(r7);
    L14:
        r1 = (r7 + r4) + r3;
        goto L8
    L15:
        float r14 = r1 + r2;
        float r15 = r12 - (r14 - r9);
        if (r15 <= 0.0f) goto L18;
    L19:
        r14 = r14 + r15;
    L20:
        r9 = r14;
        r13 = r13 + 1;
        goto L5
    L18:
        if (r15 >= 0.0f) goto L20;
    L21:
        notifyDataChanged();
        return;
    L24:
        throw new RuntimeException("BarData needs to hold at least 2 BarDataSets to allow grouping.");
    }

    public float getGroupWidth(float r2, float r3) {
        return (this.mDataSets.size() * (this.mBarWidth + r3)) + r2;
    }
}
