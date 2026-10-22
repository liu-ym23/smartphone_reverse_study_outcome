package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.function.ObjIntConsumer;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class RegularImmutableSortedMultiset<E> extends ImmutableSortedMultiset<E> {
    static final ImmutableSortedMultiset<Comparable> NATURAL_EMPTY_MULTISET = null;
    private static final long[] ZERO_CUMULATIVE_COUNTS = null;
    private final transient long[] cumulativeCounts;
    final transient RegularImmutableSortedSet<E> elementSet;
    private final transient int length;
    private final transient int offset;

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ ImmutableSet elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ NavigableSet elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ SortedSet elementSet() {
        return elementSet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ SortedMultiset headMultiset(Object r1, BoundType r2) {
        return headMultiset(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ SortedMultiset tailMultiset(Object r1, BoundType r2) {
        return tailMultiset(r1, r2);
    }

    static {
        ZERO_CUMULATIVE_COUNTS = new long[]{0};
        NATURAL_EMPTY_MULTISET = new RegularImmutableSortedMultiset(Ordering.natural());
    }

    RegularImmutableSortedMultiset(Comparator<? super E> r1) {
        this.elementSet = ImmutableSortedSet.emptySet(r1);
        this.cumulativeCounts = ZERO_CUMULATIVE_COUNTS;
        this.offset = 0;
        this.length = 0;
    }

    RegularImmutableSortedMultiset(RegularImmutableSortedSet<E> r1, long[] r2, int r3, int r4) {
        this.elementSet = r1;
        this.cumulativeCounts = r2;
        this.offset = r3;
        this.length = r4;
    }

    private int getCount(int r4) {
        long[] r0 = this.cumulativeCounts;
        int r3 = this.offset;
        return (int) (r0[(r3 + r4) + 1] - r0[r3 + r4]);
    }

    @Override // com.google.common.collect.ImmutableMultiset
    Multiset.Entry<E> getEntry(int r2) {
        return Multisets.immutableEntry(this.elementSet.asList().get(r2), getCount(r2));
    }

    @Override // com.google.common.collect.Multiset
    public void forEachEntry(ObjIntConsumer<? super E> r4) {
        Preconditions.checkNotNull(r4);
        int r0 = 0;
    L4:
        if (r0 >= this.length) goto L6;
        r4.accept(this.elementSet.asList().get(r0), getCount(r0));
        r0 = r0 + 1;
        goto L4
    }

    @Override // com.google.common.collect.SortedMultiset
    @CheckForNull
    public Multiset.Entry<E> firstEntry() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return getEntry(0);
    }

    @Override // com.google.common.collect.SortedMultiset
    @CheckForNull
    public Multiset.Entry<E> lastEntry() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return getEntry(this.length - 1);
    }

    @Override // com.google.common.collect.Multiset
    public int count(@CheckForNull Object r2) {
        int r3 = this.elementSet.indexOf(r2);
        if (r3 >= 0) goto L7;
        return 0;
    L7:
        return getCount(r3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public int size() {
        long[] r0 = this.cumulativeCounts;
        int r1 = this.offset;
        return Ints.saturatedCast(r0[this.length + r1] - r0[r1]);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    public ImmutableSortedSet<E> elementSet() {
        return this.elementSet;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public ImmutableSortedMultiset<E> headMultiset(E r4, BoundType r5) {
        RegularImmutableSortedSet<E> r0 = this.elementSet;
        if (Preconditions.checkNotNull(r5) != BoundType.CLOSED) goto L5;
        boolean r6 = true;
    L7:
        return getSubMultiset(0, r0.headIndex(r4, r6));
    L5:
        r6 = false;
        goto L7
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public ImmutableSortedMultiset<E> tailMultiset(E r3, BoundType r4) {
        RegularImmutableSortedSet<E> r0 = this.elementSet;
        if (Preconditions.checkNotNull(r4) != BoundType.CLOSED) goto L5;
        boolean r5 = true;
    L7:
        return getSubMultiset(r0.tailIndex(r3, r5), this.length);
    L5:
        r5 = false;
        goto L7
    }

    ImmutableSortedMultiset<E> getSubMultiset(int r4, int r5) {
        Preconditions.checkPositionIndexes(r4, r5, this.length);
        if (r4 == r5) goto L5;
        if (r4 != 0) goto L11;
        if (r5 != this.length) goto L11;
        return this;
    L11:
        return new RegularImmutableSortedMultiset(this.elementSet.getSubSet(r4, r5), this.cumulativeCounts, this.offset + r4, r5 - r4);
    L5:
        return emptyMultiset(comparator());
    }

    @Override // com.google.common.collect.ImmutableCollection
    boolean isPartialView() {
        if (this.offset <= 0) goto L5;
        return true;
    L5:
        if (this.length < (this.cumulativeCounts.length - 1)) goto L10;
        return false;
    L10:
        return true;
    }
}
