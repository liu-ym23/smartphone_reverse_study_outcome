package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.Enum;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.ObjIntConsumer;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class EnumMultiset<E extends Enum<E>> extends AbstractMultiset<E> implements Serializable {
    private static final long serialVersionUID = 0;
    private transient int[] counts;
    private transient int distinctElements;
    private transient E[] enumConstants;
    private transient long size;
    private transient Class<E> type;

    abstract class Itr<T> implements Iterator<T> {
        int index;
        final /* synthetic */ EnumMultiset this$0;
        int toRemove;

        abstract T output(int r1);

        Itr(EnumMultiset r1) {
            this.this$0 = r1;
            this.index = 0;
            this.toRemove = -1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
        L3:
            if (this.index >= EnumMultiset.access$000(this.this$0).length) goto L9;
            int[] r0 = EnumMultiset.access$100(this.this$0);
            int r1 = this.index;
            if (r0[r1] > 0) goto L6;
            this.index = r1 + 1;
            goto L3
        L6:
            return true;
        L9:
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext() == false) goto L7;
            T r0 = output(this.index);
            int r1 = this.index;
            this.toRemove = r1;
            this.index = r1 + 1;
            return r0;
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.toRemove < 0) goto L5;
            boolean r0 = true;
        L6:
            CollectPreconditions.checkRemove(r0);
            if (EnumMultiset.access$100(this.this$0)[this.toRemove] <= 0) goto L9;
            EnumMultiset.access$210(this.this$0);
            EnumMultiset r1 = this.this$0;
            EnumMultiset.access$322(r1, EnumMultiset.access$100(r1)[this.toRemove]);
            EnumMultiset.access$100(this.this$0)[this.toRemove] = 0;
        L9:
            this.toRemove = -1;
            return;
        L5:
            r0 = false;
            goto L6
        }
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ int add(Object r1, int r2) {
        return add((Enum) r1, r2);
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean contains(@CheckForNull Object r1) {
        return super.contains(r1);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ int setCount(Object r1, int r2) {
        return setCount((Enum) r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean setCount(@ParametricNullness Object r1, int r2, int r3) {
        return super.setCount(r1, r2, r3);
    }

    static /* synthetic */ Enum[] access$000(EnumMultiset r0) {
        return r0.enumConstants;
    }

    static /* synthetic */ int[] access$100(EnumMultiset r0) {
        return r0.counts;
    }

    static /* synthetic */ int access$210(EnumMultiset r2) {
        int r0 = r2.distinctElements;
        r2.distinctElements = r0 - 1;
        return r0;
    }

    static /* synthetic */ long access$322(EnumMultiset r2, long r3) {
        long r0 = r2.size - r3;
        r2.size = r0;
        return r0;
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Class<E> r1) {
        return new EnumMultiset(r1);
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Iterable<E> r3) {
        Iterator<E> r0 = r3.iterator();
        Preconditions.checkArgument(r0.hasNext(), "EnumMultiset constructor passed empty Iterable");
        EnumMultiset<E> r1 = new EnumMultiset(r0.next().getDeclaringClass());
        Iterables.addAll(r1, r3);
        return r1;
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Iterable<E> r0, Class<E> r1) {
        EnumMultiset<E> r2 = create(r1);
        Iterables.addAll(r2, r0);
        return r2;
    }

    private EnumMultiset(Class<E> r2) {
        this.type = r2;
        Preconditions.checkArgument(r2.isEnum());
        E[] r3 = r2.getEnumConstants();
        this.enumConstants = r3;
        this.counts = new int[r3.length];
    }

    private boolean isActuallyE(@CheckForNull Object r4) {
        if ((r4 instanceof Enum) == false) goto L10;
        Enum r5 = (Enum) r4;
        int r0 = r5.ordinal();
        E[] r3 = this.enumConstants;
        if (r0 < r3.length) goto L7;
        return false;
    L7:
        if (r3[r0] != r5) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    private void checkIsE(Object r4) {
        Preconditions.checkNotNull(r4);
        if (isActuallyE(r4) == false) goto L5;
        return;
    L5:
        String r3 = String.valueOf(this.type);
        String r5 = String.valueOf(r4);
        throw new ClassCastException(new StringBuilder((String.valueOf(r3).length() + 21) + String.valueOf(r5).length()).append("Expected an ").append(r3).append(" but got ").append(r5).toString());
    }

    @Override // com.google.common.collect.AbstractMultiset
    int distinctElements() {
        return this.distinctElements;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public int size() {
        return Ints.saturatedCast(this.size);
    }

    @Override // com.google.common.collect.Multiset
    public int count(@CheckForNull Object r2) {
        if (r2 != null) goto L4;
        return 0;
    L4:
        if (isActuallyE(r2) == true) goto L7;
        return 0;
    L7:
        return this.counts[((Enum) r2).ordinal()];
    }

    public int add(E r8, int r9) {
        checkIsE(r8);
        CollectPreconditions.checkNonnegative(r9, "occurrences");
        if (r9 == 0) goto L5;
        int r10 = r8.ordinal();
        int r0 = this.counts[r10];
        long r3 = r9;
        long r1 = ((long) r0) + r3;
        if (r1 > 2147483647L) goto L9;
        boolean r11 = true;
    L10:
        Preconditions.checkArgument(r11, "too many occurrences: %s", r1);
        this.counts[r10] = (int) r1;
        if (r0 != 0) goto L13;
        this.distinctElements++;
    L13:
        this.size += r3;
        return r0;
    L9:
        r11 = false;
        goto L10
    L5:
        return count(r8);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public int remove(@CheckForNull Object r4, int r5) {
        if (r4 != null) goto L5;
    L18:
        return 0;
    L5:
        if (isActuallyE(r4) == false) goto L18;
        Enum r1 = (Enum) r4;
        CollectPreconditions.checkNonnegative(r5, "occurrences");
        if (r5 == 0) goto L10;
        int r6 = r1.ordinal();
        int[] r2 = this.counts;
        int r3 = r2[r6];
        if (r3 != 0) goto L14;
        return 0;
    L14:
        if (r3 > r5) goto L16;
        r2[r6] = 0;
        this.distinctElements--;
        this.size -= (long) r3;
    L17:
        return r3;
    L16:
        r2[r6] = r3 - r5;
        this.size -= (long) r5;
        goto L17
    L10:
        return count(r4);
    }

    public int setCount(E r7, int r8) {
        checkIsE(r7);
        CollectPreconditions.checkNonnegative(r8, "count");
        int r9 = r7.ordinal();
        int[] r0 = this.counts;
        int r1 = r0[r9];
        r0[r9] = r8;
        this.size += (long) (r8 - r1);
        if (r1 != 0) goto L6;
        if (r8 <= 0) goto L6;
        this.distinctElements++;
    L9:
        return r1;
    L6:
        if (r1 <= 0) goto L9;
        if (r8 != 0) goto L9;
        this.distinctElements--;
        goto L9
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        Arrays.fill(this.counts, 0);
        this.size = 0;
        this.distinctElements = 0;
    }

    @Override // com.google.common.collect.AbstractMultiset
    Iterator<E> elementIterator() {
        return new AnonymousClass1(this);
    }

    @Override // com.google.common.collect.AbstractMultiset
    Iterator<Multiset.Entry<E>> entryIterator() {
        return new AnonymousClass2(this);
    }

    @Override // com.google.common.collect.Multiset
    public void forEachEntry(ObjIntConsumer<? super E> r4) {
        Preconditions.checkNotNull(r4);
        int r0 = 0;
    L3:
        E[] r1 = this.enumConstants;
        if (r0 >= r1.length) goto L9;
        int r2 = this.counts[r0];
        if (r2 <= 0) goto L8;
        r4.accept(r1[r0], r2);
    L8:
        r0 = r0 + 1;
        goto L3
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
    public Iterator<E> iterator() {
        return Multisets.iteratorImpl(this);
    }

    private void writeObject(ObjectOutputStream r2) throws IOException {
        r2.defaultWriteObject();
        r2.writeObject(this.type);
        Serialization.writeMultiset(this, r2);
    }

    private void readObject(ObjectInputStream r2) throws IOException, ClassNotFoundException {
        r2.defaultReadObject();
        Class<E> r0 = (Class) r2.readObject();
        this.type = r0;
        E[] r1 = r0.getEnumConstants();
        this.enumConstants = r1;
        this.counts = new int[r1.length];
        Serialization.populateMultiset(this, r2);
    }
}
