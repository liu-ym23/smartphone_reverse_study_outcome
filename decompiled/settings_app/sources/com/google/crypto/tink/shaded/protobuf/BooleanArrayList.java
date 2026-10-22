package com.google.crypto.tink.shaded.protobuf;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes4.dex */
final class BooleanArrayList extends AbstractProtobufList<Boolean> implements Internal.BooleanList, RandomAccess, PrimitiveNonBoxingCollection {
    private static final BooleanArrayList EMPTY_LIST = null;
    private boolean[] array;
    private int size;

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ void add(int index, Object element) {
        add(index, (Boolean) element);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean add(Object element) {
        return add((Boolean) element);
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int index) {
        return get(index);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList, com.google.crypto.tink.shaded.protobuf.Internal.BooleanList
    /* JADX INFO: renamed from: mutableCopyWithCapacity, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ Internal.ProtobufList<Boolean> mutableCopyWithCapacity2(int capacity) {
        return mutableCopyWithCapacity(capacity);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object remove(int index) {
        return remove(index);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object set(int index, Object element) {
        return set(index, (Boolean) element);
    }

    static {
        EMPTY_LIST = new BooleanArrayList(new boolean[0], 0, false);
    }

    public static BooleanArrayList emptyList() {
        return EMPTY_LIST;
    }

    BooleanArrayList() {
        this(new boolean[10], 0, true);
    }

    private BooleanArrayList(boolean[] other, int size, boolean isMutable) {
        super(isMutable);
        this.array = other;
        this.size = size;
    }

    @Override // java.util.AbstractList
    protected void removeRange(int fromIndex, int toIndex) {
        ensureIsMutable();
        if (toIndex < fromIndex) goto L7;
        boolean[] r0 = this.array;
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
        if ((o instanceof BooleanArrayList) == false) goto L8;
        BooleanArrayList r6 = (BooleanArrayList) o;
        if (this.size == r6.size) goto L12;
        return false;
    L12:
        boolean[] r7 = r6.array;
        int r1 = 0;
    L14:
        if (r1 >= this.size) goto L19;
        if (this.array[r1] != r7[r1]) goto L17;
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
        r0 = (r0 * 31) + Internal.hashBoolean(this.array[r1]);
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList, com.google.crypto.tink.shaded.protobuf.Internal.BooleanList
    public Internal.ProtobufList<Boolean> mutableCopyWithCapacity(int capacity) {
        if (capacity < this.size) goto L7;
        return new BooleanArrayList(Arrays.copyOf(this.array, capacity), this.size, true);
    L7:
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public Boolean get(int index) {
        return Boolean.valueOf(getBoolean(index));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.BooleanList
    public boolean getBoolean(int index) {
        ensureIndexInRange(index);
        return this.array[index];
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object element) {
        if ((element instanceof Boolean) == true) goto L5;
        return -1;
    L5:
        boolean r5 = ((Boolean) element).booleanValue();
        int r0 = size();
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L11;
        if (this.array[r2] == r5) goto L9;
        r2 = r2 + 1;
        goto L6
    L9:
        return r2;
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

    public Boolean set(int index, Boolean element) {
        return Boolean.valueOf(setBoolean(index, element.booleanValue()));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.BooleanList
    public boolean setBoolean(int index, boolean element) {
        ensureIsMutable();
        ensureIndexInRange(index);
        boolean[] r1 = this.array;
        boolean r0 = r1[index];
        r1[index] = element;
        return r0;
    }

    public boolean add(Boolean element) {
        addBoolean(element.booleanValue());
        return true;
    }

    public void add(int index, Boolean element) {
        addBoolean(index, element.booleanValue());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.BooleanList
    public void addBoolean(boolean element) {
        ensureIsMutable();
        int r0 = this.size;
        boolean[] r1 = this.array;
        if (r0 != r1.length) goto L5;
        boolean[] r2 = new boolean[((r0 * 3) / 2) + 1];
        System.arraycopy(r1, 0, r2, 0, r0);
        this.array = r2;
    L5:
        boolean[] r3 = this.array;
        int r4 = this.size;
        this.size = r4 + 1;
        r3[r4] = element;
    }

    private void addBoolean(int index, boolean element) {
        ensureIsMutable();
        if (index < 0) goto L13;
        int r0 = this.size;
        if (index > r0) goto L13;
        boolean[] r1 = this.array;
        if (r0 >= r1.length) goto L9;
        System.arraycopy(r1, index, r1, index + 1, r0 - index);
    L10:
        this.array[index] = element;
        this.size++;
        this.modCount++;
        return;
    L9:
        boolean[] r2 = new boolean[((r0 * 3) / 2) + 1];
        System.arraycopy(r1, 0, r2, 0, index);
        System.arraycopy(this.array, index, r2, index + 1, this.size - index);
        this.array = r2;
    L13:
        throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(index));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Boolean> collection) {
        ensureIsMutable();
        Internal.checkNotNull(collection);
        if ((collection instanceof BooleanArrayList) == false) goto L5;
        BooleanArrayList r6 = (BooleanArrayList) collection;
        int r0 = r6.size;
        if (r0 != 0) goto L9;
        return false;
    L9:
        int r2 = this.size;
        if ((Integer.MAX_VALUE - r2) < r0) goto L17;
        int r3 = r2 + r0;
        boolean[] r1 = this.array;
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
    public Boolean remove(int index) {
        ensureIsMutable();
        ensureIndexInRange(index);
        boolean[] r0 = this.array;
        boolean r1 = r0[index];
        int r2 = this.size;
        if (index >= (r2 - 1)) goto L5;
        System.arraycopy(r0, index + 1, r0, index, (r2 - index) - 1);
    L5:
        this.size--;
        this.modCount++;
        return Boolean.valueOf(r1);
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
