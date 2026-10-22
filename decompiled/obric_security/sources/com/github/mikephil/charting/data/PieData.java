package com.github.mikephil.charting.data;

import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;

/* JADX INFO: loaded from: classes2.dex */
public class PieData extends ChartData<IPieDataSet> {
    @Override // com.github.mikephil.charting.data.ChartData
    public /* bridge */ /* synthetic */ IDataSet getDataSetByIndex(int r1) {
        return getDataSetByIndex(r1);
    }

    @Override // com.github.mikephil.charting.data.ChartData
    public /* bridge */ /* synthetic */ IDataSet getDataSetByLabel(String r1, boolean r2) {
        return getDataSetByLabel(r1, r2);
    }

    public PieData() {
    }

    public PieData(IPieDataSet r3) {
        super(new IPieDataSet[]{r3});
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public void setDataSet(IPieDataSet r2) {
        this.mDataSets.clear();
        this.mDataSets.add(r2);
        notifyDataChanged();
    }

    public IPieDataSet getDataSet() {
        return (IPieDataSet) this.mDataSets.get(0);
    }

    @Override // com.github.mikephil.charting.data.ChartData
    public IPieDataSet getDataSetByIndex(int r1) {
        if (r1 == 0) goto L6;
        return null;
    L6:
        return getDataSet();
    }

    @Override // com.github.mikephil.charting.data.ChartData
    public IPieDataSet getDataSetByLabel(String r3, boolean r4) {
        if (r4 == false) goto L8;
        if (r3.equalsIgnoreCase(((IPieDataSet) this.mDataSets.get(0)).getLabel()) == true) goto L12;
        return null;
    L12:
        return (IPieDataSet) this.mDataSets.get(0);
    L8:
        if (r3.equals(((IPieDataSet) this.mDataSets.get(0)).getLabel()) == true) goto L10;
        return null;
    L10:
        return (IPieDataSet) this.mDataSets.get(0);
    }

    @Override // com.github.mikephil.charting.data.ChartData
    public Entry getEntryForHighlight(Highlight r1) {
        return getDataSet().getEntryForIndex((int) r1.getX());
    }

    public float getYValueSum() {
        float r0 = 0.0f;
        int r1 = 0;
    L4:
        if (r1 >= getDataSet().getEntryCount()) goto L6;
        r0 = r0 + getDataSet().getEntryForIndex(r1).getY();
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }
}
