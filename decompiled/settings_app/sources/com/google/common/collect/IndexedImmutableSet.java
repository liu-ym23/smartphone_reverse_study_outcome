package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
abstract class IndexedImmutableSet<E> extends ImmutableSet.CachingAsList<E> {
    abstract E get(int r1);

    @Override // com.google.common.collect.ImmutableSet.CachingAsList, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    IndexedImmutableSet() {
    }

    @Override // com.google.common.collect.ImmutableSet.CachingAsList, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
    public UnmodifiableIterator<E> iterator() {
        return asList().iterator();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        return CollectSpliterators.indexed(size(), 1297, new IndexedImmutableSet$$ExternalSyntheticLambda0(this));
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer<? super E> r4) {
        Preconditions.checkNotNull(r4);
        int r0 = size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r4.accept(get(r1));
        r1 = r1 + 1;
        goto L3
    }

    @Override // com.google.common.collect.ImmutableCollection
    int copyIntoArray(Object[] r1, int r2) {
        return asList().copyIntoArray(r1, r2);
    }

    @Override // com.google.common.collect.ImmutableSet.CachingAsList
    ImmutableList<E> createAsList() {
        return new AnonymousClass1(this);
    }
}
