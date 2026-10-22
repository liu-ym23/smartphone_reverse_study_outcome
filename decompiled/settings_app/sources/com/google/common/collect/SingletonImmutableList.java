package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class SingletonImmutableList<E> extends ImmutableList<E> {
    final transient E element;

    @Override // com.google.common.collect.ImmutableCollection
    boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return 1;
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public /* bridge */ /* synthetic */ List subList(int r1, int r2) {
        return subList(r1, r2);
    }

    SingletonImmutableList(E r1) {
        this.element = (E) Preconditions.checkNotNull(r1);
    }

    @Override // java.util.List
    public E get(int r2) {
        Preconditions.checkElementIndex(r2, 1);
        return this.element;
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
    public UnmodifiableIterator<E> iterator() {
        return Iterators.singletonIterator(this.element);
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        return Collections.singleton(this.element).spliterator();
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public ImmutableList<E> subList(int r2, int r3) {
        Preconditions.checkPositionIndexes(r2, r3, 1);
        if (r2 == r3) goto L5;
        return this;
    L5:
        return ImmutableList.of();
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        String r2 = this.element.toString();
        return new StringBuilder(String.valueOf(r2).length() + 2).append('[').append(r2).append(']').toString();
    }
}
