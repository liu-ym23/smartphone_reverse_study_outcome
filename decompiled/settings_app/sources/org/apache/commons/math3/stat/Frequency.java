package org.apache.commons.math3.stat;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public class Frequency implements Serializable {
    private static final long serialVersionUID = -3845586908418844111L;
    private final SortedMap<Comparable<?>, Long> freqTable;

    /* JADX INFO: renamed from: org.apache.commons.math3.stat.Frequency$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class NaturalComparator<T extends Comparable<T>> implements Comparator<Comparable<T>>, Serializable {
        private static final long serialVersionUID = -3852193713161395148L;

        private NaturalComparator() {
        }

        /* synthetic */ NaturalComparator(AnonymousClass1 r1) {
            this();
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object r1, Object r2) {
            return compare((Comparable) r1, (Comparable) r2);
        }

        public int compare(Comparable<T> r1, Comparable<T> r2) {
            return r1.compareTo(r2);
        }
    }

    public Frequency() {
        this.freqTable = new TreeMap();
    }

    public Frequency(Comparator<?> r2) {
        this.freqTable = new TreeMap(r2);
    }

    public String toString() {
        NumberFormat r0 = NumberFormat.getPercentInstance();
        StringBuilder r1 = new StringBuilder("Value \t Freq. \t Pct. \t Cum Pct. \n");
        Iterator<Comparable<?>> r2 = this.freqTable.keySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L7;
        Comparable<?> r3 = r2.next();
        r1.append(r3);
        r1.append('\t');
        r1.append(getCount(r3));
        r1.append('\t');
        r1.append(r0.format(getPct(r3)));
        r1.append('\t');
        r1.append(r0.format(getCumPct(r3)));
        r1.append('\n');
        goto L4
    L7:
        return r1.toString();
    }

    public void addValue(Comparable<?> r3) throws MathIllegalArgumentException {
        incrementValue(r3, 1);
    }

    public void addValue(int r3) throws MathIllegalArgumentException {
        addValue(Long.valueOf(r3));
    }

    public void addValue(long r1) throws MathIllegalArgumentException {
        addValue(Long.valueOf(r1));
    }

    public void addValue(char r1) throws MathIllegalArgumentException {
        addValue(Character.valueOf(r1));
    }

    public void incrementValue(Comparable<?> r4, long r5) throws MathIllegalArgumentException {
        if ((r4 instanceof Integer) == false) goto L5;
        Comparable<?> r0 = Long.valueOf(((Integer) r4).longValue());
    L13:
        Long r1 = this.freqTable.get(r0);     // Catch: ClassCastException -> L11
        if (r1 != null) goto L9;
        this.freqTable.put(r0, Long.valueOf(r5));     // Catch: ClassCastException -> L11
        return;
    L9:
        this.freqTable.put(r0, Long.valueOf(r1.longValue() + r5));     // Catch: ClassCastException -> L11
        return;
    L12:
        throw new MathIllegalArgumentException(LocalizedFormats.INSTANCES_NOT_COMPARABLE_TO_EXISTING_VALUES, new Object[]{r4.getClass().getName()});
    L5:
        r0 = r4;
        goto L13
    }

    public void incrementValue(int r3, long r4) throws MathIllegalArgumentException {
        incrementValue(Long.valueOf(r3), r4);
    }

    public void incrementValue(long r1, long r3) throws MathIllegalArgumentException {
        incrementValue(Long.valueOf(r1), r3);
    }

    public void incrementValue(char r1, long r2) throws MathIllegalArgumentException {
        incrementValue(Character.valueOf(r1), r2);
    }

    public void clear() {
        this.freqTable.clear();
    }

    public Iterator<Comparable<?>> valuesIterator() {
        return this.freqTable.keySet().iterator();
    }

    public Iterator<Map.Entry<Comparable<?>, Long>> entrySetIterator() {
        return this.freqTable.entrySet().iterator();
    }

    public long getSumFreq() {
        Iterator<Long> r4 = this.freqTable.values().iterator();
        long r0 = 0;
    L4:
        if (r4.hasNext() == false) goto L6;
        r0 = r0 + r4.next().longValue();
        goto L4
    L6:
        return r0;
    }

    public long getCount(Comparable<?> r3) {
        if ((r3 instanceof Integer) == false) goto L13;
        return getCount(((Integer) r3).longValue());
    L13:
        Long r2 = this.freqTable.get(r3);     // Catch: ClassCastException -> L12
        if (r2 == null) goto L15;
        return r2.longValue();
    L15:
        return 0;
    L16:
        return 0;
    }

    public long getCount(int r3) {
        return getCount(Long.valueOf(r3));
    }

    public long getCount(long r1) {
        return getCount(Long.valueOf(r1));
    }

    public long getCount(char r1) {
        return getCount(Character.valueOf(r1));
    }

    public int getUniqueCount() {
        return this.freqTable.keySet().size();
    }

    public double getPct(Comparable<?> r5) {
        long r0 = getSumFreq();
        if (r0 != 0) goto L7;
        return Double.NaN;
    L7:
        return getCount(r5) / r0;
    }

    public double getPct(int r3) {
        return getPct(Long.valueOf(r3));
    }

    public double getPct(long r1) {
        return getPct(Long.valueOf(r1));
    }

    public double getPct(char r1) {
        return getPct(Character.valueOf(r1));
    }

    public long getCumFreq(Comparable<?> r7) {
        if (getSumFreq() != 0) goto L6;
        return 0;
    L6:
        if ((r7 instanceof Integer) == true) goto L8;
        Comparator<? super Comparable<?>> r0 = this.freqTable.comparator();
        if (r0 != null) goto L32;
        r0 = new NaturalComparator(null);
    L32:
        Long r1 = this.freqTable.get(r7);     // Catch: ClassCastException -> L31
        if (r1 == null) goto L16;
        long r4 = r1.longValue();     // Catch: ClassCastException -> L31
    L18:
        if (r0.compare(r7, this.freqTable.firstKey()) >= 0) goto L21;
        return 0;
    L21:
        if (r0.compare(r7, this.freqTable.lastKey()) >= 0) goto L23;
        Iterator<Comparable<?>> r2 = valuesIterator();
    L26:
        if (r2.hasNext() == false) goto L30;
        Comparable<?> r3 = r2.next();
        if (r0.compare(r7, r3) <= 0) goto L30;
        r4 = r4 + getCount(r3);
    L30:
        return r4;
    L23:
        return getSumFreq();
    L16:
        r4 = 0;
    L31:
        return 0;
    L8:
        return getCumFreq(((Integer) r7).longValue());
    }

    public long getCumFreq(int r3) {
        return getCumFreq(Long.valueOf(r3));
    }

    public long getCumFreq(long r1) {
        return getCumFreq(Long.valueOf(r1));
    }

    public long getCumFreq(char r1) {
        return getCumFreq(Character.valueOf(r1));
    }

    public double getCumPct(Comparable<?> r5) {
        long r0 = getSumFreq();
        if (r0 != 0) goto L7;
        return Double.NaN;
    L7:
        return getCumFreq(r5) / r0;
    }

    public double getCumPct(int r3) {
        return getCumPct(Long.valueOf(r3));
    }

    public double getCumPct(long r1) {
        return getCumPct(Long.valueOf(r1));
    }

    public double getCumPct(char r1) {
        return getCumPct(Character.valueOf(r1));
    }

    public List<Comparable<?>> getMode() {
        Iterator<Long> r0 = this.freqTable.values().iterator();
        long r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L8;
        long r3 = r0.next().longValue();
        if (r3 <= r1) goto L4;
        r1 = r3;
        goto L4
    L8:
        ArrayList r2 = new ArrayList();
        Iterator<Map.Entry<Comparable<?>, Long>> r6 = this.freqTable.entrySet().iterator();
    L10:
        if (r6.hasNext() == false) goto L14;
        Map.Entry<Comparable<?>, Long> r4 = r6.next();
        if (r4.getValue().longValue() != r1) goto L10;
        r2.add(r4.getKey());
        goto L10
    L14:
        return r2;
    }

    public void merge(Frequency r5) throws NullArgumentException {
        MathUtils.checkNotNull(r5, LocalizedFormats.NULL_NOT_ALLOWED, new Object[0]);
        Iterator<Map.Entry<Comparable<?>, Long>> r6 = r5.entrySetIterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        Map.Entry<Comparable<?>, Long> r0 = r6.next();
        incrementValue(r0.getKey(), r0.getValue().longValue());
        goto L4
    }

    public void merge(Collection<Frequency> r3) throws NullArgumentException {
        MathUtils.checkNotNull(r3, LocalizedFormats.NULL_NOT_ALLOWED, new Object[0]);
        Iterator<Frequency> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        merge(r4.next());
        goto L4
    }

    public int hashCode() {
        SortedMap<Comparable<?>, Long> r1 = this.freqTable;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return 31 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof Frequency) == true) goto L8;
        return false;
    L8:
        Frequency r5 = (Frequency) r4;
        SortedMap<Comparable<?>, Long> r3 = this.freqTable;
        if (r3 != null) goto L14;
        if (r5.freqTable == null) goto L16;
        return false;
    L16:
        return true;
    L14:
        if (r3.equals(r5.freqTable) == true) goto L16;
        return false;
    }
}
