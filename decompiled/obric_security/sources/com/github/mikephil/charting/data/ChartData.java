package com.github.mikephil.charting.data;

import android.graphics.Typeface;
import android.util.Log;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ChartData<T extends IDataSet<? extends Entry>> {
    protected List<T> mDataSets;
    protected float mLeftAxisMax;
    protected float mLeftAxisMin;
    protected float mRightAxisMax;
    protected float mRightAxisMin;
    protected float mXMax;
    protected float mXMin;
    protected float mYMax;
    protected float mYMin;

    public ChartData() {
        this.mYMax = -3.4028235E38f;
        this.mYMin = Float.MAX_VALUE;
        this.mXMax = -3.4028235E38f;
        this.mXMin = Float.MAX_VALUE;
        this.mLeftAxisMax = -3.4028235E38f;
        this.mLeftAxisMin = Float.MAX_VALUE;
        this.mRightAxisMax = -3.4028235E38f;
        this.mRightAxisMin = Float.MAX_VALUE;
        this.mDataSets = new ArrayList();
    }

    public ChartData(T... r3) {
        this.mYMax = -3.4028235E38f;
        this.mYMin = Float.MAX_VALUE;
        this.mXMax = -3.4028235E38f;
        this.mXMin = Float.MAX_VALUE;
        this.mLeftAxisMax = -3.4028235E38f;
        this.mLeftAxisMin = Float.MAX_VALUE;
        this.mRightAxisMax = -3.4028235E38f;
        this.mRightAxisMin = Float.MAX_VALUE;
        this.mDataSets = arrayToList(r3);
        notifyDataChanged();
    }

    private List<T> arrayToList(T[] r4) {
        ArrayList r3 = new ArrayList();
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r3.add(r4[r1]);
        r1 = r1 + 1;
        goto L3
    L5:
        return r3;
    }

    public ChartData(List<T> r3) {
        this.mYMax = -3.4028235E38f;
        this.mYMin = Float.MAX_VALUE;
        this.mXMax = -3.4028235E38f;
        this.mXMin = Float.MAX_VALUE;
        this.mLeftAxisMax = -3.4028235E38f;
        this.mLeftAxisMin = Float.MAX_VALUE;
        this.mRightAxisMax = -3.4028235E38f;
        this.mRightAxisMin = Float.MAX_VALUE;
        this.mDataSets = r3;
        notifyDataChanged();
    }

    public void notifyDataChanged() {
        calcMinMax();
    }

    public void calcMinMaxY(float r3, float r4) {
        Iterator<T> r0 = this.mDataSets.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().calcMinMaxY(r3, r4);
        goto L4
    L6:
        calcMinMax();
    }

    protected void calcMinMax() {
        List<T> r0 = this.mDataSets;
        if (r0 != null) goto L5;
        return;
    L5:
        this.mYMax = -3.4028235E38f;
        this.mYMin = Float.MAX_VALUE;
        this.mXMax = -3.4028235E38f;
        this.mXMin = Float.MAX_VALUE;
        Iterator<T> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        calcMinMax(r1.next());
        goto L7
    L9:
        this.mLeftAxisMax = -3.4028235E38f;
        this.mLeftAxisMin = Float.MAX_VALUE;
        this.mRightAxisMax = -3.4028235E38f;
        this.mRightAxisMin = Float.MAX_VALUE;
        IDataSet r2 = getFirstLeft(this.mDataSets);
        if (r2 == null) goto L22;
        this.mLeftAxisMax = r2.getYMax();
        this.mLeftAxisMin = r2.getYMin();
        Iterator<T> r3 = this.mDataSets.iterator();
    L13:
        if (r3.hasNext() == false) goto L22;
        T r4 = r3.next();
        if (r4.getAxisDependency() != YAxis.AxisDependency.LEFT) goto L13;
        if (r4.getYMin() >= this.mLeftAxisMin) goto L20;
        this.mLeftAxisMin = r4.getYMin();
    L20:
        if (r4.getYMax() <= this.mLeftAxisMax) goto L13;
        this.mLeftAxisMax = r4.getYMax();
    L22:
        IDataSet r5 = getFirstRight(this.mDataSets);
        if (r5 == null) goto L35;
        this.mRightAxisMax = r5.getYMax();
        this.mRightAxisMin = r5.getYMin();
        Iterator<T> r6 = this.mDataSets.iterator();
    L26:
        if (r6.hasNext() == false) goto L51;
        T r7 = r6.next();
        if (r7.getAxisDependency() != YAxis.AxisDependency.RIGHT) goto L26;
        if (r7.getYMin() >= this.mRightAxisMin) goto L33;
        this.mRightAxisMin = r7.getYMin();
    L33:
        if (r7.getYMax() <= this.mRightAxisMax) goto L26;
        this.mRightAxisMax = r7.getYMax();
        goto L26
    L51:
        return;
    }

    public int getDataSetCount() {
        List<T> r0 = this.mDataSets;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    public float getYMin() {
        return this.mYMin;
    }

    public float getYMin(YAxis.AxisDependency r3) {
        if (r3 != YAxis.AxisDependency.LEFT) goto L9;
        float r4 = this.mLeftAxisMin;
        if (r4 == Float.MAX_VALUE) goto L7;
        return r4;
    L7:
        return this.mRightAxisMin;
    L9:
        float r5 = this.mRightAxisMin;
        if (r5 == Float.MAX_VALUE) goto L12;
        return r5;
    L12:
        return this.mLeftAxisMin;
    }

    public float getYMax() {
        return this.mYMax;
    }

    public float getYMax(YAxis.AxisDependency r3) {
        if (r3 != YAxis.AxisDependency.LEFT) goto L9;
        float r4 = this.mLeftAxisMax;
        if (r4 == (-3.4028235E38f)) goto L7;
        return r4;
    L7:
        return this.mRightAxisMax;
    L9:
        float r5 = this.mRightAxisMax;
        if (r5 == (-3.4028235E38f)) goto L12;
        return r5;
    L12:
        return this.mLeftAxisMax;
    }

    public float getXMin() {
        return this.mXMin;
    }

    public float getXMax() {
        return this.mXMax;
    }

    public List<T> getDataSets() {
        return this.mDataSets;
    }

    protected int getDataSetIndexByLabel(List<T> r1, String r2, boolean r3) {
        int r0 = 0;
        if (r3 == false) goto L11;
    L5:
        if (r0 >= r1.size()) goto L16;
        if (r2.equalsIgnoreCase(r1.get(r0).getLabel()) == true) goto L8;
        r0 = r0 + 1;
        goto L5
    L8:
        return r0;
    L16:
        return -1;
    L11:
        if (r0 >= r1.size()) goto L22;
        if (r2.equals(r1.get(r0).getLabel()) == true) goto L14;
        r0 = r0 + 1;
        goto L11
    L14:
        return r0;
    L22:
        return -1;
    }

    public String[] getDataSetLabels() {
        String[] r0 = new String[this.mDataSets.size()];
        int r1 = 0;
    L4:
        if (r1 >= this.mDataSets.size()) goto L6;
        r0[r1] = this.mDataSets.get(r1).getLabel();
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    public Entry getEntryForHighlight(Highlight r3) {
        if (r3.getDataSetIndex() < this.mDataSets.size()) goto L7;
        return null;
    L7:
        return this.mDataSets.get(r3.getDataSetIndex()).getEntryForXValue(r3.getX(), r3.getY());
    }

    public T getDataSetByLabel(String r2, boolean r3) {
        int r4 = getDataSetIndexByLabel(this.mDataSets, r2, r3);
        if (r4 >= 0) goto L5;
        return null;
    L5:
        if (r4 < this.mDataSets.size()) goto L8;
        return null;
    L8:
        return this.mDataSets.get(r4);
    }

    public T getDataSetByIndex(int r2) {
        List<T> r0 = this.mDataSets;
        if (r0 == null) goto L10;
        if (r2 >= 0) goto L6;
        return null;
    L6:
        if (r2 < r0.size()) goto L9;
        return null;
    L9:
        return this.mDataSets.get(r2);
    L10:
        return null;
    }

    public void addDataSet(T r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        calcMinMax(r1);
        this.mDataSets.add(r1);
    }

    public boolean removeDataSet(T r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        boolean r3 = this.mDataSets.remove(r2);
        if (r3 == false) goto L8;
        calcMinMax();
    L8:
        return r3;
    }

    public boolean removeDataSet(int r2) {
        if (r2 >= this.mDataSets.size()) goto L8;
        if (r2 >= 0) goto L7;
        return false;
    L7:
        return removeDataSet(this.mDataSets.get(r2));
    L8:
        return false;
    }

    public void addEntry(Entry r2, int r3) {
        if (this.mDataSets.size() <= r3) goto L9;
        if (r3 < 0) goto L9;
        T r4 = this.mDataSets.get(r3);
        if (r4.addEntry(r2) == true) goto L8;
        return;
    L8:
        calcMinMax(r2, r4.getAxisDependency());
        return;
    L9:
        Log.e("addEntry", "Cannot add Entry because dataSetIndex too high or too low.");
    }

    protected void calcMinMax(Entry r3, YAxis.AxisDependency r4) {
        if (this.mYMax >= r3.getY()) goto L6;
        this.mYMax = r3.getY();
    L6:
        if (this.mYMin <= r3.getY()) goto L9;
        this.mYMin = r3.getY();
    L9:
        if (this.mXMax >= r3.getX()) goto L12;
        this.mXMax = r3.getX();
    L12:
        if (this.mXMin <= r3.getX()) goto L15;
        this.mXMin = r3.getX();
    L15:
        if (r4 != YAxis.AxisDependency.LEFT) goto L23;
        if (this.mLeftAxisMax >= r3.getY()) goto L20;
        this.mLeftAxisMax = r3.getY();
    L20:
        if (this.mLeftAxisMin <= r3.getY()) goto L29;
        this.mLeftAxisMin = r3.getY();
        return;
    L29:
        return;
    L23:
        if (this.mRightAxisMax >= r3.getY()) goto L26;
        this.mRightAxisMax = r3.getY();
    L26:
        if (this.mRightAxisMin <= r3.getY()) goto L31;
        this.mRightAxisMin = r3.getY();
        return;
    }

    protected void calcMinMax(T r3) {
        if (this.mYMax >= r3.getYMax()) goto L6;
        this.mYMax = r3.getYMax();
    L6:
        if (this.mYMin <= r3.getYMin()) goto L9;
        this.mYMin = r3.getYMin();
    L9:
        if (this.mXMax >= r3.getXMax()) goto L12;
        this.mXMax = r3.getXMax();
    L12:
        if (this.mXMin <= r3.getXMin()) goto L15;
        this.mXMin = r3.getXMin();
    L15:
        if (r3.getAxisDependency() != YAxis.AxisDependency.LEFT) goto L23;
        if (this.mLeftAxisMax >= r3.getYMax()) goto L20;
        this.mLeftAxisMax = r3.getYMax();
    L20:
        if (this.mLeftAxisMin <= r3.getYMin()) goto L29;
        this.mLeftAxisMin = r3.getYMin();
        return;
    L29:
        return;
    L23:
        if (this.mRightAxisMax >= r3.getYMax()) goto L26;
        this.mRightAxisMax = r3.getYMax();
    L26:
        if (this.mRightAxisMin <= r3.getYMin()) goto L31;
        this.mRightAxisMin = r3.getYMin();
        return;
    }

    public boolean removeEntry(Entry r3, int r4) {
        if (r3 != null) goto L5;
    L13:
        return false;
    L5:
        if (r4 >= this.mDataSets.size()) goto L13;
        T r5 = this.mDataSets.get(r4);
        if (r5 == null) goto L13;
        boolean r6 = r5.removeEntry(r3);
        if (r6 == false) goto L12;
        calcMinMax();
    L12:
        return r6;
    }

    public boolean removeEntry(float r4, int r5) {
        if (r5 < this.mDataSets.size()) goto L5;
        return false;
    L5:
        Entry r6 = this.mDataSets.get(r5).getEntryForXValue(r4, Float.NaN);
        if (r6 != null) goto L9;
        return false;
    L9:
        return removeEntry(r6, r5);
    }

    public T getDataSetForEntry(Entry r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        int r2 = 0;
    L7:
        if (r2 >= this.mDataSets.size()) goto L16;
        T r3 = this.mDataSets.get(r2);
        int r4 = 0;
    L10:
        if (r4 >= r3.getEntryCount()) goto L15;
        if (r8.equalTo(r3.getEntryForXValue(r8.getX(), r8.getY())) == true) goto L13;
        r4 = r4 + 1;
        goto L10
    L13:
        return r3;
    L15:
        r2 = r2 + 1;
        goto L7
    L16:
        return null;
    }

    public int[] getColors() {
        if (this.mDataSets != null) goto L6;
        return null;
    L6:
        int r0 = 0;
        int r1 = 0;
        int r2 = 0;
    L8:
        if (r1 >= this.mDataSets.size()) goto L10;
        r2 = r2 + this.mDataSets.get(r1).getColors().size();
        r1 = r1 + 1;
        goto L8
    L10:
        int[] r3 = new int[r2];
        int r4 = 0;
    L12:
        if (r0 >= this.mDataSets.size()) goto L18;
        Iterator<Integer> r5 = this.mDataSets.get(r0).getColors().iterator();
    L15:
        if (r5.hasNext() == false) goto L17;
        r3[r4] = r5.next().intValue();
        r4 = r4 + 1;
        goto L15
    L17:
        r0 = r0 + 1;
        goto L12
    L18:
        return r3;
    }

    public int getIndexOfDataSet(T r1) {
        return this.mDataSets.indexOf(r1);
    }

    protected T getFirstLeft(List<T> r3) {
        Iterator<T> r2 = r3.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        T r4 = r2.next();
        if (r4.getAxisDependency() != YAxis.AxisDependency.LEFT) goto L4;
        return r4;
    L8:
        return null;
    }

    public T getFirstRight(List<T> r3) {
        Iterator<T> r2 = r3.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        T r4 = r2.next();
        if (r4.getAxisDependency() != YAxis.AxisDependency.RIGHT) goto L4;
        return r4;
    L8:
        return null;
    }

    public void setValueFormatter(ValueFormatter r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        Iterator<T> r1 = this.mDataSets.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        r1.next().setValueFormatter(r2);
        goto L6
    }

    public void setValueTextColor(int r2) {
        Iterator<T> r1 = this.mDataSets.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().setValueTextColor(r2);
        goto L4
    }

    public void setValueTextColors(List<Integer> r2) {
        Iterator<T> r1 = this.mDataSets.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().setValueTextColors(r2);
        goto L4
    }

    public void setValueTypeface(Typeface r2) {
        Iterator<T> r1 = this.mDataSets.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().setValueTypeface(r2);
        goto L4
    }

    public void setValueTextSize(float r2) {
        Iterator<T> r1 = this.mDataSets.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().setValueTextSize(r2);
        goto L4
    }

    public void setDrawValues(boolean r2) {
        Iterator<T> r1 = this.mDataSets.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().setDrawValues(r2);
        goto L4
    }

    public void setHighlightEnabled(boolean r2) {
        Iterator<T> r1 = this.mDataSets.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().setHighlightEnabled(r2);
        goto L4
    }

    public boolean isHighlightEnabled() {
        Iterator<T> r1 = this.mDataSets.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        if (r1.next().isHighlightEnabled() == true) goto L4;
        return false;
    L9:
        return true;
    }

    public void clearValues() {
        List<T> r0 = this.mDataSets;
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        notifyDataChanged();
    }

    public boolean contains(T r2) {
        Iterator<T> r1 = this.mDataSets.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        if (r1.next().equals(r2) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public int getEntryCount() {
        Iterator<T> r2 = this.mDataSets.iterator();
        int r0 = 0;
    L4:
        if (r2.hasNext() == false) goto L6;
        r0 = r0 + r2.next().getEntryCount();
        goto L4
    L6:
        return r0;
    }

    public T getMaxEntryCountSet() {
        List<T> r0 = this.mDataSets;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.isEmpty() == true) goto L21;
        T r1 = this.mDataSets.get(0);
        Iterator<T> r4 = this.mDataSets.iterator();
    L9:
        if (r4.hasNext() == false) goto L13;
        T r2 = r4.next();
        if (r2.getEntryCount() <= r1.getEntryCount()) goto L9;
        r1 = r2;
        goto L9
    L13:
        return r1;
    L21:
        return null;
    }
}
