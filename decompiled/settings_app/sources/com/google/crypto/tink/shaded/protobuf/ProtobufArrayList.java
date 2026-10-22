package com.google.crypto.tink.shaded.protobuf;

import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes4.dex */
final class ProtobufArrayList<E> extends AbstractProtobufList<E> implements RandomAccess {
    private static final ProtobufArrayList<Object> EMPTY_LIST = null;
    private E[] array;
    private int size;

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList, com.google.crypto.tink.shaded.protobuf.Internal.BooleanList
    public /* bridge */ /* synthetic */ Internal.ProtobufList mutableCopyWithCapacity(int capacity) {
        return mutableCopyWithCapacity(capacity);
    }

    static {
        EMPTY_LIST = new ProtobufArrayList(new Object[0], 0, false);
    }

    public static <E> ProtobufArrayList<E> emptyList() {
        return (ProtobufArrayList<E>) EMPTY_LIST;
    }

    ProtobufArrayList() {
        this(new Object[10], 0, true);
    }

    private ProtobufArrayList(E[] array, int size, boolean isMutable) {
        super(isMutable);
        this.array = array;
        this.size = size;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList, com.google.crypto.tink.shaded.protobuf.Internal.BooleanList
    public ProtobufArrayList<E> mutableCopyWithCapacity(int capacity) {
        if (capacity < this.size) goto L7;
        return new ProtobufArrayList(Arrays.copyOf(this.array, capacity), this.size, true);
    L7:
        throw new IllegalArgumentException();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E r5) {
        ensureIsMutable();
        int r0 = this.size;
        E[] r1 = this.array;
        if (r0 != r1.length) goto L5;
        this.array = (E[]) Arrays.copyOf(r1, ((r0 * 3) / 2) + 1);
    L5:
        E[] r2 = this.array;
        int r3 = this.size;
        this.size = r3 + 1;
        r2[r3] = r5;
        this.modCount++;
        return true;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public void add(int r5, E r6) {
        ensureIsMutable();
        if (r5 < 0) goto L13;
        int r0 = this.size;
        if (r5 > r0) goto L13;
        E[] r1 = this.array;
        if (r0 >= r1.length) goto L9;
        System.arraycopy(r1, r5, r1, r5 + 1, r0 - r5);
    L10:
        this.array[r5] = r6;
        this.size++;
        this.modCount++;
        return;
    L9:
        E[] r2 = (E[]) createArray(((r0 * 3) / 2) + 1);
        System.arraycopy(this.array, 0, r2, 0, r5);
        System.arraycopy(this.array, r5, r2, r5 + 1, this.size - r5);
        this.array = r2;
    L13:
        throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(r5));
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int index) {
        ensureIndexInRange(index);
        return this.array[index];
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public E remove(int index) {
        ensureIsMutable();
        ensureIndexInRange(index);
        E[] r0 = this.array;
        E r1 = r0[index];
        int r2 = this.size;
        if (index >= (r2 - 1)) goto L5;
        System.arraycopy(r0, index + 1, r0, index, (r2 - index) - 1);
    L5:
        this.size--;
        this.modCount++;
        return r1;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public E set(int index, E element) {
        ensureIsMutable();
        ensureIndexInRange(index);
        E[] r0 = this.array;
        E r1 = r0[index];
        r0[index] = element;
        this.modCount++;
        return r1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    private static <E> E[] createArray(int r0) {
        return (E[]) new Object[r0];
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
