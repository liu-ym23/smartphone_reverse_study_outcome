package com.google.common.primitives;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.DoubleConsumer;
import java.util.stream.DoubleStream;
import javax.annotation.CheckForNull;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
@Immutable
public final class ImmutableDoubleArray implements Serializable {
    private static final ImmutableDoubleArray EMPTY = null;
    private final double[] array;
    private final int end;
    private final transient int start;

    /* JADX INFO: renamed from: com.google.common.primitives.ImmutableDoubleArray$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    static class AsList extends AbstractList<Double> implements RandomAccess, Serializable {
        private final ImmutableDoubleArray parent;

        /* synthetic */ AsList(ImmutableDoubleArray r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r1) {
            return get(r1);
        }

        private AsList(ImmutableDoubleArray r1) {
            this.parent = r1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.parent.length();
        }

        @Override // java.util.AbstractList, java.util.List
        public Double get(int r1) {
            return Double.valueOf(this.parent.get(r1));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(@CheckForNull Object r1) {
            if (indexOf(r1) < 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(@CheckForNull Object r3) {
            if ((r3 instanceof Double) == true) goto L7;
            return -1;
        L7:
            return this.parent.indexOf(((Double) r3).doubleValue());
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(@CheckForNull Object r3) {
            if ((r3 instanceof Double) == true) goto L7;
            return -1;
        L7:
            return this.parent.lastIndexOf(((Double) r3).doubleValue());
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Double> subList(int r1, int r2) {
            return this.parent.subArray(r1, r2).asList();
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.List
        public Spliterator<Double> spliterator() {
            return ImmutableDoubleArray.access$500(this.parent);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@CheckForNull Object r8) {
            if ((r8 instanceof AsList) == false) goto L7;
            return this.parent.equals(((AsList) r8).parent);
        L7:
            if ((r8 instanceof List) == true) goto L9;
            return false;
        L9:
            List r9 = (List) r8;
            if (size() == r9.size()) goto L12;
            return false;
        L12:
            int r0 = ImmutableDoubleArray.access$100(this.parent);
            Iterator r10 = r9.iterator();
        L14:
            if (r10.hasNext() == false) goto L22;
            Object r2 = r10.next();
            if ((r2 instanceof Double) == false) goto L21;
            int r4 = r0 + 1;
            if (ImmutableDoubleArray.access$600(ImmutableDoubleArray.access$000(this.parent)[r0], ((Double) r2).doubleValue()) == false) goto L21;
            r0 = r4;
        L21:
            return false;
        L22:
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            return this.parent.hashCode();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return this.parent.toString();
        }
    }

    public static final class Builder {
        private double[] array;
        private int count;

        Builder(int r2) {
            this.count = 0;
            this.array = new double[r2];
        }

        public Builder add(double r4) {
            ensureRoomFor(1);
            double[] r1 = this.array;
            int r2 = this.count;
            r1[r2] = r4;
            this.count = r2 + 1;
            return this;
        }

        public Builder addAll(double[] r5) {
            ensureRoomFor(r5.length);
            System.arraycopy(r5, 0, this.array, this.count, r5.length);
            this.count += r5.length;
            return this;
        }

        public Builder addAll(Iterable<Double> r3) {
            if ((r3 instanceof Collection) == true) goto L5;
            Iterator<Double> r4 = r3.iterator();
        L8:
            if (r4.hasNext() == false) goto L10;
            add(r4.next().doubleValue());
            goto L8
        L10:
            return this;
        L5:
            return addAll((Collection) r3);
        }

        public Builder addAll(Collection<Double> r6) {
            ensureRoomFor(r6.size());
            Iterator<Double> r7 = r6.iterator();
        L4:
            if (r7.hasNext() == false) goto L6;
            Double r0 = r7.next();
            double[] r1 = this.array;
            int r2 = this.count;
            this.count = r2 + 1;
            r1[r2] = r0.doubleValue();
            goto L4
        L6:
            return this;
        }

        /* JADX WARN: Type inference failed for: r5v1, types: [java.util.Spliterator$OfDouble] */
        public Builder addAll(DoubleStream r5) {
            ?? r6 = r5.spliterator();
            long r0 = r6.getExactSizeIfKnown();
            if (r0 <= 0) goto L5;
            ensureRoomFor(Ints.saturatedCast(r0));
        L5:
            r6.forEachRemaining(new ImmutableDoubleArray$Builder$$ExternalSyntheticLambda0(this));
            return this;
        }

        public Builder addAll(ImmutableDoubleArray r6) {
            ensureRoomFor(r6.length());
            System.arraycopy(ImmutableDoubleArray.access$000(r6), ImmutableDoubleArray.access$100(r6), this.array, this.count, r6.length());
            this.count += r6.length();
            return this;
        }

        private void ensureRoomFor(int r3) {
            int r0 = this.count + r3;
            double[] r4 = this.array;
            if (r0 <= r4.length) goto L6;
            this.array = Arrays.copyOf(r4, expandedCapacity(r4.length, r0));
            return;
        }

        private static int expandedCapacity(int r1, int r2) {
            if (r2 < 0) goto L10;
            int r3 = (r1 + (r1 >> 1)) + 1;
            if (r3 >= r2) goto L6;
            r3 = Integer.highestOneBit(r2 - 1) << 1;
        L6:
            if (r3 >= 0) goto L11;
            return Integer.MAX_VALUE;
        L11:
            return r3;
        L10:
            throw new AssertionError("cannot store more than MAX_VALUE elements");
        }

        @CheckReturnValue
        public ImmutableDoubleArray build() {
            if (this.count == 0) goto L7;
            int r3 = 0;
            return new ImmutableDoubleArray(this.array, r3, this.count, null);
        L7:
            return ImmutableDoubleArray.access$200();
        }
    }

    /* synthetic */ ImmutableDoubleArray(double[] r1, int r2, int r3, AnonymousClass1 r4) {
        this(r1, r2, r3);
    }

    static /* synthetic */ double[] access$000(ImmutableDoubleArray r0) {
        return r0.array;
    }

    static /* synthetic */ int access$100(ImmutableDoubleArray r0) {
        return r0.start;
    }

    static /* synthetic */ ImmutableDoubleArray access$200() {
        return EMPTY;
    }

    static /* synthetic */ Spliterator.OfDouble access$500(ImmutableDoubleArray r0) {
        return r0.spliterator();
    }

    static /* synthetic */ boolean access$600(double r0, double r2) {
        return areEqual(r0, r2);
    }

    static {
        EMPTY = new ImmutableDoubleArray(new double[0]);
    }

    public static ImmutableDoubleArray of() {
        return EMPTY;
    }

    public static ImmutableDoubleArray of(double r3) {
        return new ImmutableDoubleArray(new double[]{r3});
    }

    public static ImmutableDoubleArray of(double r3, double r5) {
        return new ImmutableDoubleArray(new double[]{r3, r5});
    }

    public static ImmutableDoubleArray of(double r3, double r5, double r7) {
        return new ImmutableDoubleArray(new double[]{r3, r5, r7});
    }

    public static ImmutableDoubleArray of(double r3, double r5, double r7, double r9) {
        return new ImmutableDoubleArray(new double[]{r3, r5, r7, r9});
    }

    public static ImmutableDoubleArray of(double r3, double r5, double r7, double r9, double r11) {
        return new ImmutableDoubleArray(new double[]{r3, r5, r7, r9, r11});
    }

    public static ImmutableDoubleArray of(double r3, double r5, double r7, double r9, double r11, double r13) {
        return new ImmutableDoubleArray(new double[]{r3, r5, r7, r9, r11, r13});
    }

    public static ImmutableDoubleArray of(double r4, double... r6) {
        if (r6.length > 2147483646) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "the total number of elements must fit in an int");
        double[] r1 = new double[r6.length + 1];
        r1[0] = r4;
        System.arraycopy(r6, 0, r1, 1, r6.length);
        return new ImmutableDoubleArray(r1);
    L5:
        r0 = false;
        goto L6
    }

    public static ImmutableDoubleArray copyOf(double[] r2) {
        if (r2.length != 0) goto L6;
        return EMPTY;
    L6:
        return new ImmutableDoubleArray(Arrays.copyOf(r2, r2.length));
    }

    public static ImmutableDoubleArray copyOf(Collection<Double> r1) {
        if (r1.isEmpty() == false) goto L6;
        return EMPTY;
    L6:
        return new ImmutableDoubleArray(Doubles.toArray(r1));
    }

    public static ImmutableDoubleArray copyOf(Iterable<Double> r1) {
        if ((r1 instanceof Collection) == false) goto L7;
        return copyOf((Collection) r1);
    L7:
        return builder().addAll(r1).build();
    }

    public static ImmutableDoubleArray copyOf(DoubleStream r1) {
        double[] r2 = r1.toArray();
        if (r2.length != 0) goto L6;
        return EMPTY;
    L6:
        return new ImmutableDoubleArray(r2);
    }

    public static Builder builder(int r2) {
        if (r2 < 0) goto L4;
        boolean r0 = true;
    L5:
        Preconditions.checkArgument(r0, "Invalid initialCapacity: %s", r2);
        return new Builder(r2);
    L4:
        r0 = false;
        goto L5
    }

    public static Builder builder() {
        return new Builder(10);
    }

    private ImmutableDoubleArray(double[] r3) {
        this(r3, 0, r3.length);
    }

    private ImmutableDoubleArray(double[] r1, int r2, int r3) {
        this.array = r1;
        this.start = r2;
        this.end = r3;
    }

    public int length() {
        return this.end - this.start;
    }

    public boolean isEmpty() {
        if (this.end != this.start) goto L5;
        return true;
    L5:
        return false;
    }

    public double get(int r2) {
        Preconditions.checkElementIndex(r2, length());
        return this.array[this.start + r2];
    }

    public int indexOf(double r4) {
        int r0 = this.start;
    L4:
        if (r0 >= this.end) goto L10;
        if (areEqual(this.array[r0], r4) == true) goto L8;
        r0 = r0 + 1;
        goto L4
    L8:
        return r0 - this.start;
    L10:
        return -1;
    }

    public int lastIndexOf(double r4) {
        int r0 = this.end;
    L3:
        r0 = r0 - 1;
        if (r0 < this.start) goto L10;
        if (areEqual(this.array[r0], r4) == false) goto L3;
        return r0 - this.start;
    L10:
        return -1;
    }

    public boolean contains(double r1) {
        if (indexOf(r1) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void forEach(DoubleConsumer r4) {
        Preconditions.checkNotNull(r4);
        int r0 = this.start;
    L4:
        if (r0 >= this.end) goto L6;
        r4.accept(this.array[r0]);
        r0 = r0 + 1;
        goto L4
    }

    public DoubleStream stream() {
        return Arrays.stream(this.array, this.start, this.end);
    }

    public double[] toArray() {
        return Arrays.copyOfRange(this.array, this.start, this.end);
    }

    public ImmutableDoubleArray subArray(int r3, int r4) {
        Preconditions.checkPositionIndexes(r3, r4, length());
        if (r3 == r4) goto L7;
        double[] r1 = this.array;
        int r2 = this.start;
        return new ImmutableDoubleArray(r1, r3 + r2, r2 + r4);
    L7:
        return EMPTY;
    }

    private Spliterator.OfDouble spliterator() {
        return Spliterators.spliterator(this.array, this.start, this.end, 1040);
    }

    public List<Double> asList() {
        return new AsList(this, null);
    }

    public boolean equals(@CheckForNull Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof ImmutableDoubleArray) == true) goto L8;
        return false;
    L8:
        ImmutableDoubleArray r9 = (ImmutableDoubleArray) r8;
        if (length() == r9.length()) goto L11;
        return false;
    L11:
        int r1 = 0;
    L13:
        if (r1 >= length()) goto L18;
        if (areEqual(get(r1), r9.get(r1)) == false) goto L16;
        r1 = r1 + 1;
        goto L13
    L16:
        return false;
    L18:
        return true;
    }

    private static boolean areEqual(double r0, double r2) {
        if (Double.doubleToLongBits(r0) != Double.doubleToLongBits(r2)) goto L5;
        return true;
    L5:
        return false;
    }

    public int hashCode() {
        int r0 = this.start;
        int r1 = 1;
    L4:
        if (r0 >= this.end) goto L6;
        r1 = (r1 * 31) + Doubles.hashCode(this.array[r0]);
        r0 = r0 + 1;
        goto L4
    L6:
        return r1;
    }

    public String toString() {
        if (isEmpty() == false) goto L6;
        return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    L6:
        StringBuilder r0 = new StringBuilder(length() * 5);
        r0.append('[').append(this.array[this.start]);
        int r1 = this.start;
    L7:
        r1 = r1 + 1;
        if (r1 >= this.end) goto L10;
        r0.append(", ").append(this.array[r1]);
        goto L7
    L10:
        r0.append(']');
        return r0.toString();
    }

    public ImmutableDoubleArray trimmed() {
        if (isPartialView() == true) goto L5;
        return this;
    L5:
        return new ImmutableDoubleArray(toArray());
    }

    private boolean isPartialView() {
        if (this.start <= 0) goto L5;
    L8:
        return true;
    L5:
        if (this.end < this.array.length) goto L8;
        return false;
    }

    Object writeReplace() {
        return trimmed();
    }

    Object readResolve() {
        if (isEmpty() == true) goto L5;
        return this;
    L5:
        return EMPTY;
    }
}
