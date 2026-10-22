package com.google.crypto.tink.shaded.protobuf;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes4.dex */
final class DoubleArrayList extends AbstractProtobufList<Double> implements Internal.DoubleList, RandomAccess, PrimitiveNonBoxingCollection {
    private static final DoubleArrayList EMPTY_LIST = null;
    private double[] array;
    private int size;

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ void add(int index, Object element) {
        add(index, (Double) element);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean add(Object element) {
        return add((Double) element);
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int index) {
        return get(index);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList, com.google.crypto.tink.shaded.protobuf.Internal.BooleanList
    /* JADX INFO: renamed from: mutableCopyWithCapacity, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ Internal.ProtobufList<Double> mutableCopyWithCapacity2(int capacity) {
        return mutableCopyWithCapacity(capacity);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object remove(int index) {
        return remove(index);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object set(int index, Object element) {
        return set(index, (Double) element);
    }

    static {
        EMPTY_LIST = new DoubleArrayList(new double[0], 0, false);
    }

    public static DoubleArrayList emptyList() {
        return EMPTY_LIST;
    }

    DoubleArrayList() {
        this(new double[10], 0, true);
    }

    private DoubleArrayList(double[] other, int size, boolean isMutable) {
        super(isMutable);
        this.array = other;
        this.size = size;
    }

    @Override // java.util.AbstractList
    protected void removeRange(int fromIndex, int toIndex) {
        ensureIsMutable();
        if (toIndex < fromIndex) goto L7;
        double[] r0 = this.array;
        System.arraycopy(r0, toIndex, r0, fromIndex, this.size - toIndex);
        this.size -= toIndex - fromIndex;
        this.modCount++;
        return;
    L7:
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object o) {
        if (this != o) goto L6;
        return true;
    L6:
        if ((o instanceof DoubleArrayList) == false) goto L8;
        DoubleArrayList r9 = (DoubleArrayList) o;
        if (this.size == r9.size) goto L12;
        return false;
    L12:
        double[] r10 = r9.array;
        int r1 = 0;
    L14:
        if (r1 >= this.size) goto L19;
        if (Double.doubleToLongBits(this.array[r1]) != Double.doubleToLongBits(r10[r1])) goto L17;
        r1 = r1 + 1;
        goto L14
    L17:
        return false;
    L19:
        return true;
    L8:
        return super.equals(o);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int r0 = 1;
        int r1 = 0;
    L4:
        if (r1 >= this.size) goto L6;
        r0 = (r0 * 31) + Internal.hashLong(Double.doubleToLongBits(this.array[r1]));
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList, com.google.crypto.tink.shaded.protobuf.Internal.BooleanList
    public Internal.ProtobufList<Double> mutableCopyWithCapacity(int capacity) {
        if (capacity < this.size) goto L7;
        return new DoubleArrayList(Arrays.copyOf(this.array, capacity), this.size, true);
    L7:
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public Double get(int index) {
        return Double.valueOf(getDouble(index));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.DoubleList
    public double getDouble(int index) {
        ensureIndexInRange(index);
        return this.array[index];
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object element) {
        if ((element instanceof Double) == true) goto L5;
        return -1;
    L5:
        double r2 = ((Double) element).doubleValue();
        int r7 = size();
        int r0 = 0;
    L6:
        if (r0 >= r7) goto L11;
        if (this.array[r0] == r2) goto L9;
        r0 = r0 + 1;
        goto L6
    L9:
        return r0;
    L11:
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object element) {
        if (indexOf(element) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    public Double set(int index, Double element) {
        return Double.valueOf(setDouble(index, element.doubleValue()));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.DoubleList
    public double setDouble(int index, double element) {
        ensureIsMutable();
        ensureIndexInRange(index);
        double[] r2 = this.array;
        double r0 = r2[index];
        r2[index] = element;
        return r0;
    }

    public boolean add(Double element) {
        addDouble(element.doubleValue());
        return true;
    }

    public void add(int index, Double element) {
        addDouble(index, element.doubleValue());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.DoubleList
    public void addDouble(double element) {
        ensureIsMutable();
        int r0 = this.size;
        double[] r1 = this.array;
        if (r0 != r1.length) goto L5;
        double[] r2 = new double[((r0 * 3) / 2) + 1];
        System.arraycopy(r1, 0, r2, 0, r0);
        this.array = r2;
    L5:
        double[] r3 = this.array;
        int r4 = this.size;
        this.size = r4 + 1;
        r3[r4] = element;
    }

    private void addDouble(int index, double element) {
        ensureIsMutable();
        if (index < 0) goto L13;
        int r0 = this.size;
        if (index > r0) goto L13;
        double[] r1 = this.array;
        if (r0 >= r1.length) goto L9;
        System.arraycopy(r1, index, r1, index + 1, r0 - index);
    L10:
        this.array[index] = element;
        this.size++;
        this.modCount++;
        return;
    L9:
        double[] r2 = new double[((r0 * 3) / 2) + 1];
        System.arraycopy(r1, 0, r2, 0, index);
        System.arraycopy(this.array, index, r2, index + 1, this.size - index);
        this.array = r2;
    L13:
        throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(index));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Double> collection) {
        ensureIsMutable();
        Internal.checkNotNull(collection);
        if ((collection instanceof DoubleArrayList) == false) goto L5;
        DoubleArrayList r6 = (DoubleArrayList) collection;
        int r0 = r6.size;
        if (r0 != 0) goto L9;
        return false;
    L9:
        int r2 = this.size;
        if ((Integer.MAX_VALUE - r2) < r0) goto L17;
        int r3 = r2 + r0;
        double[] r1 = this.array;
        if (r3 <= r1.length) goto L14;
        this.array = Arrays.copyOf(r1, r3);
    L14:
        System.arraycopy(r6.array, 0, this.array, this.size, r6.size);
        this.size = r3;
        this.modCount++;
        return true;
    L17:
        throw new OutOfMemoryError();
    L5:
        return super.addAll(collection);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Double remove(int index) {
        ensureIsMutable();
        ensureIndexInRange(index);
        double[] r0 = this.array;
        double r1 = r0[index];
        int r3 = this.size;
        if (index >= (r3 - 1)) goto L5;
        System.arraycopy(r0, index + 1, r0, index, (r3 - index) - 1);
    L5:
        this.size--;
        this.modCount++;
        return Double.valueOf(r1);
    }

    private void ensureIndexInRange(int index) {
        if (index < 0) goto L7;
        if (index >= this.size) goto L7;
        return;
    L7:
        throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(index));
    }

    private String makeOutOfBoundsExceptionMessage(int index) {
        return "Index:" + index + ", Size:" + this.size;
    }
}
