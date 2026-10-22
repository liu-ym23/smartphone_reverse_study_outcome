package com.google.common.collect;

import com.obric.capabilitykit.entity.app.EntityType;
import java.util.Comparator;
import java.util.Objects;
import java.util.Spliterator;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class ImmutableSortedAsList<E> extends RegularImmutableAsList<E> implements SortedIterable<E> {
    @Override // com.google.common.collect.RegularImmutableAsList, com.google.common.collect.ImmutableAsList
    /* bridge */ /* synthetic */ ImmutableCollection delegateCollection() {
        return delegateCollection();
    }

    ImmutableSortedAsList(ImmutableSortedSet<E> r1, ImmutableList<E> r2) {
        super(r1, r2);
    }

    @Override // com.google.common.collect.RegularImmutableAsList, com.google.common.collect.ImmutableAsList
    ImmutableSortedSet<E> delegateCollection() {
        return (ImmutableSortedSet) super.delegateCollection();
    }

    @Override // com.google.common.collect.SortedIterable
    public Comparator<? super E> comparator() {
        return delegateCollection().comparator();
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public int indexOf(@CheckForNull Object r2) {
        int r0 = delegateCollection().indexOf(r2);
        if (r0 >= 0) goto L5;
    L7:
        return -1;
    L5:
        if (get(r0).equals(r2) == false) goto L7;
        return r0;
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public int lastIndexOf(@CheckForNull Object r1) {
        return indexOf(r1);
    }

    @Override // com.google.common.collect.ImmutableAsList, com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@CheckForNull Object r1) {
        if (indexOf(r1) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.common.collect.ImmutableList
    ImmutableList<E> subListUnchecked(int r1, int r2) {
        return new RegularImmutableSortedSet(super.subListUnchecked(r1, r2), comparator()).asList();
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        int r0 = size();
        ImmutableList<? extends E> r1 = delegateList();
        Objects.requireNonNull(r1);
        return CollectSpliterators.indexed(r0, EntityType.DOUBAO_ACCOUNT, new ImmutableList$$ExternalSyntheticLambda0(r1), comparator());
    }
}
