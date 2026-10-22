package com.github.mikephil.charting.data;

import com.github.mikephil.charting.data.Entry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DataSet<T extends Entry> extends BaseDataSet<T> {
    protected List<T> mValues;
    protected float mXMax;
    protected float mXMin;
    protected float mYMax;
    protected float mYMin;

    public static final enum Rounding extends Enum<Rounding> {
        private static final /* synthetic */ Rounding[] $VALUES = null;
        public static final Rounding CLOSEST = null;
        public static final Rounding DOWN = null;
        public static final Rounding UP = null;

        private Rounding(String r1, int r2) {
            super(r1, r2);
        }

        public static Rounding valueOf(String r1) {
            return (Rounding) Enum.valueOf(Rounding.class, r1);
        }

        public static Rounding[] values() {
            return (Rounding[]) $VALUES.clone();
        }

        static {
            Rounding r0 = new Rounding("UP", 0);
            UP = r0;
            Rounding r1 = new Rounding("DOWN", 1);
            DOWN = r1;
            Rounding r3 = new Rounding("CLOSEST", 2);
            CLOSEST = r3;
            $VALUES = new Rounding[]{r0, r1, r3};
        }
    }

    public abstract DataSet<T> copy();

    public DataSet(List<T> r2, String r3) {
        super(r3);
        this.mYMax = -3.4028235E38f;
        this.mYMin = Float.MAX_VALUE;
        this.mXMax = -3.4028235E38f;
        this.mXMin = Float.MAX_VALUE;
        this.mValues = r2;
        if (r2 != null) goto L5;
        this.mValues = new ArrayList();
    L5:
        calcMinMax();
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public void calcMinMax() {
        List<T> r0 = this.mValues;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isEmpty() == true) goto L13;
        this.mYMax = -3.4028235E38f;
        this.mYMin = Float.MAX_VALUE;
        this.mXMax = -3.4028235E38f;
        this.mXMin = Float.MAX_VALUE;
        Iterator<T> r1 = this.mValues.iterator();
    L9:
        if (r1.hasNext() == false) goto L14;
        calcMinMax(r1.next());
        goto L9
    L14:
        return;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public void calcMinMaxY(float r3, float r4) {
        List<T> r0 = this.mValues;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isEmpty() == true) goto L12;
        this.mYMax = -3.4028235E38f;
        this.mYMin = Float.MAX_VALUE;
        int r5 = getEntryIndex(r3, Float.NaN, Rounding.DOWN);
        int r6 = getEntryIndex(r4, Float.NaN, Rounding.UP);
    L8:
        if (r5 > r6) goto L13;
        calcMinMaxY(this.mValues.get(r5));
        r5 = r5 + 1;
        goto L8
    L13:
        return;
    }

    protected void calcMinMax(T r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        calcMinMaxX(r1);
        calcMinMaxY(r1);
    }

    protected void calcMinMaxX(T r3) {
        if (r3.getX() >= this.mXMin) goto L6;
        this.mXMin = r3.getX();
    L6:
        if (r3.getX() <= this.mXMax) goto L9;
        this.mXMax = r3.getX();
        return;
    }

    protected void calcMinMaxY(T r3) {
        if (r3.getY() >= this.mYMin) goto L6;
        this.mYMin = r3.getY();
    L6:
        if (r3.getY() <= this.mYMax) goto L9;
        this.mYMax = r3.getY();
        return;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public int getEntryCount() {
        return this.mValues.size();
    }

    public List<T> getValues() {
        return this.mValues;
    }

    public void setValues(List<T> r1) {
        this.mValues = r1;
        notifyDataSetChanged();
    }

    protected void copy(DataSet r1) {
        super.copy(r1);
    }

    public String toString() {
        StringBuffer r0 = new StringBuffer();
        r0.append(toSimpleString());
        int r1 = 0;
    L4:
        if (r1 >= this.mValues.size()) goto L7;
        r0.append(this.mValues.get(r1).toString() + " ");
        r1 = r1 + 1;
        goto L4
    L7:
        return r0.toString();
    }

    public String toSimpleString() {
        StringBuffer r0 = new StringBuffer();
        StringBuilder r1 = new StringBuilder("DataSet, label: ");
        if (getLabel() != null) goto L5;
        String r2 = "";
    L6:
        r0.append(r1.append(r2).append(", entries: ").append(this.mValues.size()).append(IOUtils.LINE_SEPARATOR_UNIX).toString());
        return r0.toString();
    L5:
        r2 = getLabel();
        goto L6
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public float getYMin() {
        return this.mYMin;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public float getYMax() {
        return this.mYMax;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public float getXMin() {
        return this.mXMin;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public float getXMax() {
        return this.mXMax;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public void addEntryOrdered(T r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (this.mValues != null) goto L7;
        this.mValues = new ArrayList();
    L7:
        calcMinMax(r4);
        if (this.mValues.size() <= 0) goto L12;
        List<T> r0 = this.mValues;
        if (r0.get(r0.size() - 1).getX() <= r4.getX()) goto L12;
        this.mValues.add(getEntryIndex(r4.getX(), r4.getY(), Rounding.UP), r4);
        return;
    L12:
        this.mValues.add(r4);
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public void clear() {
        this.mValues.clear();
        notifyDataSetChanged();
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public boolean addEntry(T r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        List<T> r0 = getValues();
        if (r0 != null) goto L8;
        r0 = new ArrayList();
    L8:
        calcMinMax(r2);
        return r0.add(r2);
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public boolean removeEntry(T r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        List<T> r1 = this.mValues;
        if (r1 != null) goto L8;
        return false;
    L8:
        boolean r4 = r1.remove(r3);
        if (r4 == false) goto L11;
        calcMinMax();
    L11:
        return r4;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public int getEntryIndex(Entry r1) {
        return this.mValues.indexOf(r1);
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public T getEntryForXValue(float r1, float r2, Rounding r3) {
        int r4 = getEntryIndex(r1, r2, r3);
        if (r4 > (-1)) goto L5;
        return null;
    L5:
        return this.mValues.get(r4);
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public T getEntryForXValue(float r2, float r3) {
        return (T) getEntryForXValue(r2, r3, Rounding.CLOSEST);
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public T getEntryForIndex(int r1) {
        return this.mValues.get(r1);
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public int getEntryIndex(float r11, float r12, Rounding r13) {
        List<T> r0 = this.mValues;
        if (r0 != null) goto L5;
    L53:
        return -1;
    L5:
        if (r0.isEmpty() == true) goto L53;
        int r1 = this.mValues.size() - 1;
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L21;
        int r3 = (r2 + r1) / 2;
        float r4 = this.mValues.get(r3).getX() - r11;
        int r6 = r3 + 1;
        float r5 = this.mValues.get(r6).getX() - r11;
        float r7 = Math.abs(r4);
        float r8 = Math.abs(r5);
        if (r8 < r7) goto L11;
        if (r7 < r8) goto L17;
        double r9 = r4;
        if (r9 >= 0.0d) goto L17;
        if (r9 >= 0.0d) goto L8;
    L17:
        r1 = r3;
    L11:
        r2 = r6;
        goto L8
    L21:
        if (r1 == (-1)) goto L52;
        float r10 = this.mValues.get(r1).getX();
        if (r13 != Rounding.UP) goto L30;
        if (r10 >= r11) goto L36;
        if (r1 >= (this.mValues.size() - 1)) goto L36;
        r1 = r1 + 1;
    L36:
        if (Float.isNaN(r12) == true) goto L70;
    L37:
        if (r1 <= 0) goto L41;
        if (this.mValues.get(r1 - 1).getX() != r10) goto L41;
        r1 = r1 - 1;
    L41:
        float r14 = this.mValues.get(r1).getY();
    L42:
        int r15 = r1;
    L43:
        r1 = r1 + 1;
        if (r1 >= this.mValues.size()) goto L71;
        T r16 = this.mValues.get(r1);
        if (r16.getX() != r10) goto L71;
        if (Math.abs(r16.getY() - r12) >= Math.abs(r14 - r12)) goto L43;
        r14 = r12;
    L71:
        return r15;
    L70:
        return r1;
    L30:
        if (r13 != Rounding.DOWN) goto L36;
        if (r10 <= r11) goto L36;
        if (r1 <= 0) goto L36;
        r1 = r1 - 1;
        goto L36
    L52:
        return r1;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public List<T> getEntriesForXValue(float r7) {
        ArrayList r0 = new ArrayList();
        int r1 = this.mValues.size() - 1;
        int r2 = 0;
    L3:
        if (r2 > r1) goto L19;
        int r3 = (r1 + r2) / 2;
        T r4 = this.mValues.get(r3);
        if (r7 == r4.getX()) goto L6;
        if (r7 > r4.getX()) goto L17;
        r1 = r3 - 1;
        goto L3
    L17:
        r2 = r3 + 1;
    L6:
        if (r3 <= 0) goto L10;
        if (this.mValues.get(r3 - 1).getX() != r7) goto L10;
        r3 = r3 - 1;
    L10:
        int r5 = this.mValues.size();
    L11:
        if (r3 >= r5) goto L19;
        T r6 = this.mValues.get(r3);
        if (r6.getX() != r7) goto L19;
        r0.add(r6);
        r3 = r3 + 1;
    L19:
        return r0;
    }
}
