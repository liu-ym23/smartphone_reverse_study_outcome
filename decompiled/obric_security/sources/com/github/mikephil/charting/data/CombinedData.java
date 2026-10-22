package com.github.mikephil.charting.data;

import android.util.Log;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CombinedData extends BarLineScatterCandleBubbleData<IBarLineScatterCandleBubbleDataSet<? extends Entry>> {
    private BarData mBarData;
    private BubbleData mBubbleData;
    private CandleData mCandleData;
    private LineData mLineData;
    private ScatterData mScatterData;

    @Override // com.github.mikephil.charting.data.ChartData
    public /* bridge */ /* synthetic */ boolean removeDataSet(IDataSet r1) {
        return removeDataSet((IBarLineScatterCandleBubbleDataSet) r1);
    }

    public CombinedData() {
    }

    public void setData(LineData r1) {
        this.mLineData = r1;
        notifyDataChanged();
    }

    public void setData(BarData r1) {
        this.mBarData = r1;
        notifyDataChanged();
    }

    public void setData(ScatterData r1) {
        this.mScatterData = r1;
        notifyDataChanged();
    }

    public void setData(CandleData r1) {
        this.mCandleData = r1;
        notifyDataChanged();
    }

    public void setData(BubbleData r1) {
        this.mBubbleData = r1;
        notifyDataChanged();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.github.mikephil.charting.data.ChartData
    public void calcMinMax() {
        if (this.mDataSets != 0) goto L5;
        this.mDataSets = new ArrayList();
    L5:
        this.mDataSets.clear();
        this.mYMax = -3.4028235E38f;
        this.mYMin = Float.MAX_VALUE;
        this.mXMax = -3.4028235E38f;
        this.mXMin = Float.MAX_VALUE;
        this.mLeftAxisMax = -3.4028235E38f;
        this.mLeftAxisMin = Float.MAX_VALUE;
        this.mRightAxisMax = -3.4028235E38f;
        this.mRightAxisMin = Float.MAX_VALUE;
        Iterator<BarLineScatterCandleBubbleData> r0 = getAllData().iterator();
    L7:
        if (r0.hasNext() == false) goto L32;
        BarLineScatterCandleBubbleData r1 = r0.next();
        r1.calcMinMax();
        Collection r2 = r1.getDataSets();
        this.mDataSets.addAll((Collection<? extends T>) r2);
        if (r1.getYMax() <= this.mYMax) goto L12;
        this.mYMax = r1.getYMax();
    L12:
        if (r1.getYMin() >= this.mYMin) goto L15;
        this.mYMin = r1.getYMin();
    L15:
        if (r1.getXMax() <= this.mXMax) goto L18;
        this.mXMax = r1.getXMax();
    L18:
        if (r1.getXMin() >= this.mXMin) goto L21;
        this.mXMin = r1.getXMin();
    L21:
        if (r1.mLeftAxisMax <= this.mLeftAxisMax) goto L24;
        this.mLeftAxisMax = r1.mLeftAxisMax;
    L24:
        if (r1.mLeftAxisMin >= this.mLeftAxisMin) goto L27;
        this.mLeftAxisMin = r1.mLeftAxisMin;
    L27:
        if (r1.mRightAxisMax <= this.mRightAxisMax) goto L30;
        this.mRightAxisMax = r1.mRightAxisMax;
    L30:
        if (r1.mRightAxisMin >= this.mRightAxisMin) goto L7;
        this.mRightAxisMin = r1.mRightAxisMin;
        goto L7
    }

    public BubbleData getBubbleData() {
        return this.mBubbleData;
    }

    public LineData getLineData() {
        return this.mLineData;
    }

    public BarData getBarData() {
        return this.mBarData;
    }

    public ScatterData getScatterData() {
        return this.mScatterData;
    }

    public CandleData getCandleData() {
        return this.mCandleData;
    }

    public List<BarLineScatterCandleBubbleData> getAllData() {
        ArrayList r0 = new ArrayList();
        LineData r1 = this.mLineData;
        if (r1 == null) goto L5;
        r0.add(r1);
    L5:
        BarData r2 = this.mBarData;
        if (r2 == null) goto L8;
        r0.add(r2);
    L8:
        ScatterData r3 = this.mScatterData;
        if (r3 == null) goto L11;
        r0.add(r3);
    L11:
        CandleData r4 = this.mCandleData;
        if (r4 == null) goto L14;
        r0.add(r4);
    L14:
        BubbleData r5 = this.mBubbleData;
        if (r5 == null) goto L17;
        r0.add(r5);
    L17:
        return r0;
    }

    public BarLineScatterCandleBubbleData getDataByIndex(int r1) {
        return getAllData().get(r1);
    }

    @Override // com.github.mikephil.charting.data.ChartData
    public void notifyDataChanged() {
        LineData r0 = this.mLineData;
        if (r0 == null) goto L5;
        r0.notifyDataChanged();
    L5:
        BarData r1 = this.mBarData;
        if (r1 == null) goto L8;
        r1.notifyDataChanged();
    L8:
        CandleData r2 = this.mCandleData;
        if (r2 == null) goto L11;
        r2.notifyDataChanged();
    L11:
        ScatterData r3 = this.mScatterData;
        if (r3 == null) goto L14;
        r3.notifyDataChanged();
    L14:
        BubbleData r4 = this.mBubbleData;
        if (r4 == null) goto L17;
        r4.notifyDataChanged();
    L17:
        calcMinMax();
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [com.github.mikephil.charting.interfaces.datasets.IDataSet] */
    @Override // com.github.mikephil.charting.data.ChartData
    public Entry getEntryForHighlight(Highlight r5) {
        if (r5.getDataIndex() < getAllData().size()) goto L5;
        return null;
    L5:
        BarLineScatterCandleBubbleData r4 = getDataByIndex(r5.getDataIndex());
        if (r5.getDataSetIndex() < r4.getDataSetCount()) goto L8;
        return null;
    L8:
        Iterator r6 = r4.getDataSetByIndex(r5.getDataSetIndex()).getEntriesForXValue(r5.getX()).iterator();
    L10:
        if (r6.hasNext() == false) goto L16;
        Entry r0 = (Entry) r6.next();
        if (r0.getY() == r5.getY()) goto L15;
        if (Float.isNaN(r5.getY()) == false) goto L10;
    L15:
        return r0;
    L16:
        return null;
    }

    public IBarLineScatterCandleBubbleDataSet<? extends Entry> getDataSetByHighlight(Highlight r4) {
        if (r4.getDataIndex() < getAllData().size()) goto L5;
        return null;
    L5:
        BarLineScatterCandleBubbleData r3 = getDataByIndex(r4.getDataIndex());
        if (r4.getDataSetIndex() < r3.getDataSetCount()) goto L9;
        return null;
    L9:
        return (IBarLineScatterCandleBubbleDataSet) r3.getDataSets().get(r4.getDataSetIndex());
    }

    public int getDataIndex(ChartData r1) {
        return getAllData().indexOf(r1);
    }

    public boolean removeDataSet(IBarLineScatterCandleBubbleDataSet<? extends Entry> r3) {
        Iterator<BarLineScatterCandleBubbleData> r2 = getAllData().iterator();
        boolean r0 = false;
    L4:
        if (r2.hasNext() == false) goto L7;
        r0 = r2.next().removeDataSet(r3);
        if (r0 == false) goto L4;
    L7:
        return r0;
    }

    @Override // com.github.mikephil.charting.data.ChartData
    @Deprecated
    public boolean removeDataSet(int r1) {
        Log.e(Chart.LOG_TAG, "removeDataSet(int index) not supported for CombinedData");
        return false;
    }

    @Override // com.github.mikephil.charting.data.ChartData
    @Deprecated
    public boolean removeEntry(Entry r1, int r2) {
        Log.e(Chart.LOG_TAG, "removeEntry(...) not supported for CombinedData");
        return false;
    }

    @Override // com.github.mikephil.charting.data.ChartData
    @Deprecated
    public boolean removeEntry(float r1, int r2) {
        Log.e(Chart.LOG_TAG, "removeEntry(...) not supported for CombinedData");
        return false;
    }
}
