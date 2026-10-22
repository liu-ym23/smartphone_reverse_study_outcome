package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.DoNotMock;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Predicate;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@DoNotMock("Use ImmutableList.of or another implementation")
@ElementTypesAreNonnullByDefault
public abstract class ImmutableCollection<E> extends AbstractCollection<E> implements Serializable {
    private static final Object[] EMPTY_ARRAY = null;
    static final int SPLITERATOR_CHARACTERISTICS = 1296;

    @DoNotMock
    public static abstract class Builder<E> {
        static final int DEFAULT_INITIAL_CAPACITY = 4;

        public abstract Builder<E> add(E r1);

        public abstract ImmutableCollection<E> build();

        static int expandedCapacity(int r1, int r2) {
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

        Builder() {
        }

        public Builder<E> add(E... r4) {
            int r0 = r4.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            add(r4[r1]);
            r1 = r1 + 1;
            goto L3
        L5:
            return this;
        }

        public Builder<E> addAll(Iterable<? extends E> r2) {
            Iterator<? extends E> r3 = r2.iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            add(r3.next());
            goto L4
        L6:
            return this;
        }

        public Builder<E> addAll(Iterator<? extends E> r2) {
        L3:
            if (r2.hasNext() == false) goto L5;
            add(r2.next());
            goto L3
        L5:
            return this;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public abstract boolean contains(@CheckForNull Object r1);

    @CheckForNull
    Object[] internalArray() {
        return null;
    }

    abstract boolean isPartialView();

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
    public abstract UnmodifiableIterator<E> iterator();

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    ImmutableCollection() {
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        return Spliterators.spliterator(this, SPLITERATOR_CHARACTERISTICS);
    }

    static {
        EMPTY_ARRAY = new Object[0];
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return toArray(EMPTY_ARRAY);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final <T> T[] toArray(T[] r3) {
        Preconditions.checkNotNull(r3);
        int r0 = size();
        if (r3.length >= r0) goto L10;
        Object[] r1 = internalArray();
        if (r1 != null) goto L7;
        r3 = (T[]) ObjectArrays.newArray(r3, r0);
    L12:
        copyIntoArray(r3, 0);
        return r3;
    L7:
        return (T[]) Platform.copy(r1, internalArrayStart(), internalArrayEnd(), r3);
    L10:
        if (r3.length <= r0) goto L12;
        r3[r0] = null;
        goto L12
    }

    int internalArrayStart() {
        throw new UnsupportedOperationException();
    }

    int internalArrayEnd() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean add(E r1) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean remove(@CheckForNull Object r1) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean addAll(Collection<? extends E> r1) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean removeAll(Collection<?> r1) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    @Deprecated
    public final boolean removeIf(Predicate<? super E> r1) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean retainAll(Collection<?> r1) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public ImmutableList<E> asList() {
        int r0 = size();
        if (r0 == 0) goto L11;
        if (r0 == 1) goto L9;
        return new RegularImmutableAsList(this, toArray());
    L9:
        return ImmutableList.of(iterator().next());
    L11:
        return ImmutableList.of();
    }

    int copyIntoArray(Object[] r3, int r4) {
        UnmodifiableIterator<E> r2 = iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r3[r4] = r2.next();
        r4 = r4 + 1;
        goto L4
    L6:
        return r4;
    }

    Object writeReplace() {
        return new ImmutableList.SerializedForm(toArray());
    }
}
