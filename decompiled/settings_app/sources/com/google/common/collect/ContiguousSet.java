package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.lang.Comparable;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public abstract class ContiguousSet<C extends Comparable> extends ImmutableSortedSet<C> {
    final DiscreteDomain<C> domain;

    abstract ContiguousSet<C> headSetImpl(C r1, boolean r2);

    public abstract ContiguousSet<C> intersection(ContiguousSet<C> r1);

    public abstract Range<C> range();

    public abstract Range<C> range(BoundType r1, BoundType r2);

    abstract ContiguousSet<C> subSetImpl(C r1, boolean r2, C r3, boolean r4);

    abstract ContiguousSet<C> tailSetImpl(C r1, boolean r2);

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet headSet(Object r1) {
        return headSet((Comparable) r1);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet headSet(Object r1, boolean r2) {
        return headSet((Comparable) r1, r2);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public /* bridge */ /* synthetic */ NavigableSet headSet(Object r1, boolean r2) {
        return headSet((Comparable) r1, r2);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public /* bridge */ /* synthetic */ SortedSet headSet(Object r1) {
        return headSet((Comparable) r1);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    /* bridge */ /* synthetic */ ImmutableSortedSet headSetImpl(Object r1, boolean r2) {
        return headSetImpl((Comparable) r1, r2);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet subSet(Object r1, Object r2) {
        return subSet((Comparable) r1, (Comparable) r2);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet subSet(Object r1, boolean r2, Object r3, boolean r4) {
        return subSet((Comparable) r1, r2, (Comparable) r3, r4);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public /* bridge */ /* synthetic */ NavigableSet subSet(Object r1, boolean r2, Object r3, boolean r4) {
        return subSet((Comparable) r1, r2, (Comparable) r3, r4);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public /* bridge */ /* synthetic */ SortedSet subSet(Object r1, Object r2) {
        return subSet((Comparable) r1, (Comparable) r2);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    /* bridge */ /* synthetic */ ImmutableSortedSet subSetImpl(Object r1, boolean r2, Object r3, boolean r4) {
        return subSetImpl((Comparable) r1, r2, (Comparable) r3, r4);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet tailSet(Object r1) {
        return tailSet((Comparable) r1);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet tailSet(Object r1, boolean r2) {
        return tailSet((Comparable) r1, r2);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public /* bridge */ /* synthetic */ NavigableSet tailSet(Object r1, boolean r2) {
        return tailSet((Comparable) r1, r2);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public /* bridge */ /* synthetic */ SortedSet tailSet(Object r1) {
        return tailSet((Comparable) r1);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    /* bridge */ /* synthetic */ ImmutableSortedSet tailSetImpl(Object r1, boolean r2) {
        return tailSetImpl((Comparable) r1, r2);
    }

    public static <C extends Comparable> ContiguousSet<C> create(Range<C> r3, DiscreteDomain<C> r4) {
        Preconditions.checkNotNull(r3);
        Preconditions.checkNotNull(r4);
    L21:
        e = move-exception;
        throw new IllegalArgumentException(e);
    L4:
        if (r3.hasLowerBound() == true) goto L6;
        Range<C> r0 = r3.intersection(Range.atLeast(r4.minValue()));     // Catch: NoSuchElementException -> L21
    L8:
        if (r3.hasUpperBound() == true) goto L10;
        r0 = r0.intersection(Range.atMost(r4.maxValue()));     // Catch: NoSuchElementException -> L21
    L10:
        boolean r2 = true;
        if (r0.isEmpty() == false) goto L14;
    L17:
        if (r2 == false) goto L20;
        return new EmptyContiguousSet(r4);
    L20:
        return new RegularContiguousSet(r0, r4);
    L14:
        if (Range.compareOrThrow((Comparable) Objects.requireNonNull(r3.lowerBound.leastValueAbove(r4)), (Comparable) Objects.requireNonNull(r3.upperBound.greatestValueBelow(r4))) > 0) goto L17;
        r2 = false;
        goto L17
    L6:
        r0 = r3;
        goto L8
    }

    public static ContiguousSet<Integer> closed(int r0, int r1) {
        return create(Range.closed(Integer.valueOf(r0), Integer.valueOf(r1)), DiscreteDomain.integers());
    }

    public static ContiguousSet<Long> closed(long r0, long r2) {
        return create(Range.closed(Long.valueOf(r0), Long.valueOf(r2)), DiscreteDomain.longs());
    }

    public static ContiguousSet<Integer> closedOpen(int r0, int r1) {
        return create(Range.closedOpen(Integer.valueOf(r0), Integer.valueOf(r1)), DiscreteDomain.integers());
    }

    public static ContiguousSet<Long> closedOpen(long r0, long r2) {
        return create(Range.closedOpen(Long.valueOf(r0), Long.valueOf(r2)), DiscreteDomain.longs());
    }

    ContiguousSet(DiscreteDomain<C> r2) {
        super(Ordering.natural());
        this.domain = r2;
    }

    public ContiguousSet<C> headSet(C r2) {
        return headSetImpl((Comparable) Preconditions.checkNotNull(r2), false);
    }

    public ContiguousSet<C> headSet(C r1, boolean r2) {
        return headSetImpl((Comparable) Preconditions.checkNotNull(r1), r2);
    }

    public ContiguousSet<C> subSet(C r4, C r5) {
        Preconditions.checkNotNull(r4);
        Preconditions.checkNotNull(r5);
        if (comparator().compare(r4, r5) > 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0);
        return subSetImpl(r4, true, r5, false);
    L5:
        r0 = false;
        goto L6
    }

    public ContiguousSet<C> subSet(C r2, boolean r3, C r4, boolean r5) {
        Preconditions.checkNotNull(r2);
        Preconditions.checkNotNull(r4);
        if (comparator().compare(r2, r4) > 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0);
        return subSetImpl(r2, r3, r4, r5);
    L5:
        r0 = false;
        goto L6
    }

    public ContiguousSet<C> tailSet(C r2) {
        return tailSetImpl((Comparable) Preconditions.checkNotNull(r2), true);
    }

    public ContiguousSet<C> tailSet(C r1, boolean r2) {
        return tailSetImpl((Comparable) Preconditions.checkNotNull(r1), r2);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    ImmutableSortedSet<C> createDescendingSet() {
        return new DescendingImmutableSortedSet(this);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return range().toString();
    }

    @Deprecated
    public static <E> ImmutableSortedSet.Builder<E> builder() {
        throw new UnsupportedOperationException();
    }
}
