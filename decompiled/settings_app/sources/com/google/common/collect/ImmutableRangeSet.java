package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collector;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class ImmutableRangeSet<C extends Comparable> extends AbstractRangeSet<C> implements Serializable {
    private static final ImmutableRangeSet<Comparable<?>> ALL = null;
    private static final ImmutableRangeSet<Comparable<?>> EMPTY = null;

    @CheckForNull
    @LazyInit
    private transient ImmutableRangeSet<C> complement;
    private final transient ImmutableList<Range<C>> ranges;

    private final class AsSet extends ImmutableSortedSet<C> {
        private final DiscreteDomain<C> domain;

        @CheckForNull
        private transient Integer size;
        final /* synthetic */ ImmutableRangeSet this$0;

        static /* synthetic */ DiscreteDomain access$100(AsSet r0) {
            return r0.domain;
        }

        @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
        public /* bridge */ /* synthetic */ Iterator descendingIterator() {
            return descendingIterator();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSortedSet
        /* bridge */ /* synthetic */ ImmutableSortedSet headSetImpl(Object r1, boolean r2) {
            return headSetImpl((Comparable) r1, r2);
        }

        @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet.CachingAsList, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return iterator();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSortedSet
        /* bridge */ /* synthetic */ ImmutableSortedSet subSetImpl(Object r1, boolean r2, Object r3, boolean r4) {
            return subSetImpl((Comparable) r1, r2, (Comparable) r3, r4);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSortedSet
        /* bridge */ /* synthetic */ ImmutableSortedSet tailSetImpl(Object r1, boolean r2) {
            return tailSetImpl((Comparable) r1, r2);
        }

        AsSet(ImmutableRangeSet r1, DiscreteDomain<C> r2) {
            this.this$0 = r1;
            super(Ordering.natural());
            this.domain = r2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            Integer r0 = this.size;
            if (r0 != null) goto L11;
            UnmodifiableIterator r1 = ImmutableRangeSet.access$000(this.this$0).iterator();
            long r2 = 0;
        L6:
            if (r1.hasNext() == false) goto L9;
            r2 = r2 + ((long) ContiguousSet.create((Range) r1.next(), this.domain).size());
            if (r2 < 2147483647L) goto L6;
        L9:
            r0 = Integer.valueOf(Ints.saturatedCast(r2));
            this.size = r0;
        L11:
            return r0.intValue();
        }

        @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet.CachingAsList, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
        public UnmodifiableIterator<C> iterator() {
            return new AnonymousClass1(this);
        }

        @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
        public UnmodifiableIterator<C> descendingIterator() {
            return new AnonymousClass2(this);
        }

        ImmutableSortedSet<C> subSet(Range<C> r2) {
            return this.this$0.subRangeSet(r2).asSet(this.domain);
        }

        ImmutableSortedSet<C> headSetImpl(C r1, boolean r2) {
            return subSet(Range.upTo(r1, BoundType.forBoolean(r2)));
        }

        ImmutableSortedSet<C> subSetImpl(C r2, boolean r3, C r4, boolean r5) {
            if (r3 == true) goto L9;
            if (r5 == true) goto L9;
            if (Range.compareOrThrow(r2, r4) != 0) goto L9;
            return ImmutableSortedSet.of();
        L9:
            return subSet(Range.range(r2, BoundType.forBoolean(r3), r4, BoundType.forBoolean(r5)));
        }

        ImmutableSortedSet<C> tailSetImpl(C r1, boolean r2) {
            return subSet(Range.downTo(r1, BoundType.forBoolean(r2)));
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object r2) {
            if (r2 != null) goto L8;
            return false;
        L8:
            ImmutableRangeSet r1 = this.this$0;     // Catch: ClassCastException -> L7
            return r1.contains((Comparable) r2);
        L7:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSortedSet
        int indexOf(@CheckForNull Object r6) {
            if (contains(r6) == false) goto L14;
            Comparable r7 = (Comparable) Objects.requireNonNull(r6);
            UnmodifiableIterator r0 = ImmutableRangeSet.access$000(this.this$0).iterator();
            long r1 = 0;
        L6:
            if (r0.hasNext() == false) goto L13;
            Range r3 = (Range) r0.next();
            if (r3.contains(r7) == true) goto L10;
            r1 = r1 + ((long) ContiguousSet.create(r3, this.domain).size());
            goto L6
        L10:
            return Ints.saturatedCast(r1 + ((long) ContiguousSet.create(r3, this.domain).indexOf(r7)));
        L13:
            throw new AssertionError("impossible");
        L14:
            return -1;
        }

        @Override // com.google.common.collect.ImmutableSortedSet
        ImmutableSortedSet<C> createDescendingSet() {
            return new DescendingImmutableSortedSet(this);
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return ImmutableRangeSet.access$000(this.this$0).isPartialView();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return ImmutableRangeSet.access$000(this.this$0).toString();
        }

        @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        Object writeReplace() {
            return new AsSetSerializedForm(ImmutableRangeSet.access$000(this.this$0), this.domain);
        }
    }

    private static class AsSetSerializedForm<C extends Comparable> implements Serializable {
        private final DiscreteDomain<C> domain;
        private final ImmutableList<Range<C>> ranges;

        AsSetSerializedForm(ImmutableList<Range<C>> r1, DiscreteDomain<C> r2) {
            this.ranges = r1;
            this.domain = r2;
        }

        Object readResolve() {
            return new ImmutableRangeSet(this.ranges).asSet(this.domain);
        }
    }

    public static class Builder<C extends Comparable<?>> {
        private final List<Range<C>> ranges;

        public Builder() {
            this.ranges = Lists.newArrayList();
        }

        public Builder<C> add(Range<C> r3) {
            Preconditions.checkArgument(!r3.isEmpty(), "range must not be empty, but was %s", r3);
            this.ranges.add(r3);
            return this;
        }

        public Builder<C> addAll(RangeSet<C> r1) {
            return addAll(r1.asRanges());
        }

        public Builder<C> addAll(Iterable<Range<C>> r2) {
            Iterator<Range<C>> r3 = r2.iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            add(r3.next());
            goto L4
        L6:
            return this;
        }

        Builder<C> combine(Builder<C> r1) {
            addAll(r1.ranges);
            return this;
        }

        public ImmutableRangeSet<C> build() {
            ImmutableList.Builder r0 = new ImmutableList.Builder(this.ranges.size());
            Collections.sort(this.ranges, Range.rangeLexOrdering());
            PeekingIterator r5 = Iterators.peekingIterator(this.ranges.iterator());
        L4:
            if (r5.hasNext() == false) goto L12;
            Range r1 = (Range) r5.next();
        L7:
            if (r5.hasNext() == false) goto L11;
            Range<C> r2 = (Range) r5.peek();
            if (r1.isConnected(r2) == false) goto L11;
            Preconditions.checkArgument(r1.intersection(r2).isEmpty(), "Overlapping ranges not permitted but found %s overlapping %s", r1, r2);
            r1 = r1.span((Range) r5.next());
        L11:
            r0.add(r1);
            goto L4
        L12:
            ImmutableList r6 = r0.build();
            if (r6.isEmpty() == false) goto L17;
            return ImmutableRangeSet.of();
        L17:
            if (r6.size() != 1) goto L23;
            if (((Range) Iterables.getOnlyElement(r6)).equals(Range.all()) == false) goto L23;
            return ImmutableRangeSet.all();
        L23:
            return new ImmutableRangeSet(r6);
        }
    }

    private final class ComplementRanges extends ImmutableList<Range<C>> {
        private final boolean positiveBoundedAbove;
        private final boolean positiveBoundedBelow;
        private final int size;
        final /* synthetic */ ImmutableRangeSet this$0;

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return true;
        }

        @Override // java.util.List
        public /* bridge */ /* synthetic */ Object get(int r1) {
            return get(r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        ComplementRanges(ImmutableRangeSet r3) {
            this.this$0 = r3;
            boolean r0 = ((Range) ImmutableRangeSet.access$000(r3).get(0)).hasLowerBound();
            this.positiveBoundedBelow = r0;
            boolean r1 = ((Range) Iterables.getLast(ImmutableRangeSet.access$000(r3))).hasUpperBound();
            this.positiveBoundedAbove = r1;
            int r4 = ImmutableRangeSet.access$000(r3).size() - 1;
            if (r0 == false) goto L5;
            r4 = r4 + 1;
        L5:
            if (r1 == false) goto L7;
            r4 = r4 + 1;
        L7:
            this.size = r4;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.size;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.List
        public Range<C> get(int r3) {
            Preconditions.checkElementIndex(r3, this.size);
            if (this.positiveBoundedBelow == false) goto L7;
            if (r3 != 0) goto L6;
            Cut<C> r0 = Cut.belowAll();
        L9:
            if (this.positiveBoundedAbove == true) goto L11;
        L13:
            Cut<C> r2 = ((Range) ImmutableRangeSet.access$000(this.this$0).get(r3 + (!this.positiveBoundedBelow ? 1 : 0))).lowerBound;
        L15:
            return Range.create(r0, r2);
        L11:
            if (r3 != (this.size - 1)) goto L13;
            r2 = Cut.aboveAll();
            goto L15
        L6:
            r0 = ((Range) ImmutableRangeSet.access$000(this.this$0).get(r3 - 1)).upperBound;
            goto L9
        L7:
            r0 = ((Range) ImmutableRangeSet.access$000(this.this$0).get(r3)).upperBound;
            goto L9
        }
    }

    private static final class SerializedForm<C extends Comparable> implements Serializable {
        private final ImmutableList<Range<C>> ranges;

        SerializedForm(ImmutableList<Range<C>> r1) {
            this.ranges = r1;
        }

        Object readResolve() {
            if (this.ranges.isEmpty() == false) goto L7;
            return ImmutableRangeSet.of();
        L7:
            if (this.ranges.equals(ImmutableList.of(Range.all())) == false) goto L11;
            return ImmutableRangeSet.all();
        L11:
            return new ImmutableRangeSet(this.ranges);
        }
    }

    @Override // com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ Set asDescendingSetOfRanges() {
        return asDescendingSetOfRanges();
    }

    @Override // com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ Set asRanges() {
        return asRanges();
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ RangeSet complement() {
        return complement();
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean contains(Comparable r1) {
        return super.contains(r1);
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean enclosesAll(RangeSet r1) {
        return super.enclosesAll(r1);
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean equals(@CheckForNull Object r1) {
        return super.equals(r1);
    }

    @Override // com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ RangeSet subRangeSet(Range r1) {
        return subRangeSet(r1);
    }

    static /* synthetic */ ImmutableList access$000(ImmutableRangeSet r0) {
        return r0.ranges;
    }

    static {
        EMPTY = new ImmutableRangeSet(ImmutableList.of());
        ALL = new ImmutableRangeSet(ImmutableList.of(Range.all()));
    }

    public static <E extends Comparable<? super E>> Collector<Range<E>, ?, ImmutableRangeSet<E>> toImmutableRangeSet() {
        return CollectCollectors.toImmutableRangeSet();
    }

    public static <C extends Comparable> ImmutableRangeSet<C> of() {
        return EMPTY;
    }

    public static <C extends Comparable> ImmutableRangeSet<C> of(Range<C> r1) {
        Preconditions.checkNotNull(r1);
        if (r1.isEmpty() == false) goto L7;
        return of();
    L7:
        if (r1.equals(Range.all()) == false) goto L11;
        return all();
    L11:
        return new ImmutableRangeSet(ImmutableList.of(r1));
    }

    static <C extends Comparable> ImmutableRangeSet<C> all() {
        return ALL;
    }

    public static <C extends Comparable> ImmutableRangeSet<C> copyOf(RangeSet<C> r2) {
        Preconditions.checkNotNull(r2);
        if (r2.isEmpty() == false) goto L7;
        return of();
    L7:
        if (r2.encloses(Range.all()) == false) goto L11;
        return all();
    L11:
        if ((r2 instanceof ImmutableRangeSet) == false) goto L16;
        ImmutableRangeSet<C> r0 = (ImmutableRangeSet) r2;
        if (r0.isPartialView() == true) goto L16;
        return r0;
    L16:
        return new ImmutableRangeSet(ImmutableList.copyOf(r2.asRanges()));
    }

    public static <C extends Comparable<?>> ImmutableRangeSet<C> copyOf(Iterable<Range<C>> r1) {
        return new Builder().addAll(r1).build();
    }

    public static <C extends Comparable<?>> ImmutableRangeSet<C> unionOf(Iterable<Range<C>> r0) {
        return copyOf(TreeRangeSet.create(r0));
    }

    ImmutableRangeSet(ImmutableList<Range<C>> r1) {
        this.ranges = r1;
    }

    private ImmutableRangeSet(ImmutableList<Range<C>> r1, ImmutableRangeSet<C> r2) {
        this.ranges = r1;
        this.complement = r2;
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public boolean intersects(Range<C> r7) {
        int r0 = SortedLists.binarySearch(this.ranges, Range.lowerBoundFn(), r7.lowerBound, Ordering.natural(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
        if (r0 < this.ranges.size()) goto L5;
    L9:
        if (r0 <= 0) goto L15;
        int r1 = r0 - 1;
        if (this.ranges.get(r1).isConnected(r7) == false) goto L15;
        if (this.ranges.get(r1).intersection(r7).isEmpty() == true) goto L15;
        return true;
    L15:
        return false;
    L5:
        if (this.ranges.get(r0).isConnected(r7) == false) goto L9;
        if (this.ranges.get(r0).intersection(r7).isEmpty() == true) goto L9;
        return true;
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public boolean encloses(Range<C> r7) {
        int r0 = SortedLists.binarySearch(this.ranges, Range.lowerBoundFn(), r7.lowerBound, Ordering.natural(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        if (r0 != (-1)) goto L5;
    L7:
        return false;
    L5:
        if (this.ranges.get(r0).encloses(r7) == false) goto L7;
        return true;
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    @CheckForNull
    public Range<C> rangeContaining(C r7) {
        int r0 = SortedLists.binarySearch(this.ranges, Range.lowerBoundFn(), Cut.belowValue(r7), Ordering.natural(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        if (r0 == (-1)) goto L8;
        Range<C> r6 = this.ranges.get(r0);
        if (r6.contains(r7) == true) goto L7;
        return null;
    L7:
        return r6;
    L8:
        return null;
    }

    @Override // com.google.common.collect.RangeSet
    public Range<C> span() {
        if (this.ranges.isEmpty() == true) goto L7;
        Cut<C> r0 = this.ranges.get(0).lowerBound;
        ImmutableList<Range<C>> r2 = this.ranges;
        return Range.create(r0, r2.get(r2.size() - 1).upperBound);
    L7:
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public boolean isEmpty() {
        return this.ranges.isEmpty();
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    @Deprecated
    public void add(Range<C> r1) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    @Deprecated
    public void addAll(RangeSet<C> r1) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeSet
    @Deprecated
    public void addAll(Iterable<Range<C>> r1) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    @Deprecated
    public void remove(Range<C> r1) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    @Deprecated
    public void removeAll(RangeSet<C> r1) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeSet
    @Deprecated
    public void removeAll(Iterable<Range<C>> r1) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeSet
    public ImmutableSet<Range<C>> asRanges() {
        if (this.ranges.isEmpty() == false) goto L7;
        return ImmutableSet.of();
    L7:
        return new RegularImmutableSortedSet(this.ranges, Range.rangeLexOrdering());
    }

    @Override // com.google.common.collect.RangeSet
    public ImmutableSet<Range<C>> asDescendingSetOfRanges() {
        if (this.ranges.isEmpty() == false) goto L7;
        return ImmutableSet.of();
    L7:
        return new RegularImmutableSortedSet(this.ranges.reverse(), Range.rangeLexOrdering().reverse());
    }

    @Override // com.google.common.collect.RangeSet
    public ImmutableRangeSet<C> complement() {
        ImmutableRangeSet<C> r0 = this.complement;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (this.ranges.isEmpty() == false) goto L10;
        ImmutableRangeSet<C> r1 = all();
        this.complement = r1;
        return r1;
    L10:
        if (this.ranges.size() == 1) goto L12;
    L15:
        ImmutableRangeSet<C> r2 = new ImmutableRangeSet(new ComplementRanges(this), this);
        this.complement = r2;
        return r2;
    L12:
        if (this.ranges.get(0).equals(Range.all()) == false) goto L15;
        ImmutableRangeSet<C> r3 = of();
        this.complement = r3;
        return r3;
    }

    public ImmutableRangeSet<C> union(RangeSet<C> r1) {
        return unionOf(Iterables.concat(asRanges(), r1.asRanges()));
    }

    public ImmutableRangeSet<C> intersection(RangeSet<C> r1) {
        TreeRangeSet r0 = TreeRangeSet.create(this);
        r0.removeAll(r1.complement());
        return copyOf(r0);
    }

    public ImmutableRangeSet<C> difference(RangeSet<C> r1) {
        TreeRangeSet r0 = TreeRangeSet.create(this);
        r0.removeAll(r1);
        return copyOf(r0);
    }

    private ImmutableList<Range<C>> intersectRanges(final Range<C> r7) {
        if (this.ranges.isEmpty() == true) goto L26;
        if (r7.isEmpty() == true) goto L26;
        if (r7.encloses(span()) == false) goto L12;
        return this.ranges;
    L12:
        if (r7.hasLowerBound() == false) goto L14;
        final int r0 = SortedLists.binarySearch(this.ranges, Range.upperBoundFn(), r7.lowerBound, SortedLists.KeyPresentBehavior.FIRST_AFTER, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
    L16:
        if (r7.hasUpperBound() == false) goto L18;
        int r1 = SortedLists.binarySearch(this.ranges, Range.lowerBoundFn(), r7.upperBound, SortedLists.KeyPresentBehavior.FIRST_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
    L19:
        final int r2 = r1 - r0;
        if (r2 != 0) goto L24;
        return ImmutableList.of();
    L24:
        return (ImmutableList<Range<C>>) new AnonymousClass1(this, r2, r0, r7);
    L18:
        r1 = this.ranges.size();
        goto L19
    L14:
        r0 = 0;
    L26:
        return ImmutableList.of();
    }

    @Override // com.google.common.collect.RangeSet
    public ImmutableRangeSet<C> subRangeSet(Range<C> r3) {
        if (isEmpty() == true) goto L12;
        Range<C> r0 = span();
        if (r3.encloses(r0) == false) goto L8;
        return this;
    L8:
        if (r3.isConnected(r0) == false) goto L12;
        return new ImmutableRangeSet(intersectRanges(r3));
    L12:
        return of();
    }

    public ImmutableSortedSet<C> asSet(DiscreteDomain<C> r3) {
        Preconditions.checkNotNull(r3);
        if (isEmpty() == true) goto L5;
        Range<C> r0 = span().canonical(r3);
        if (r0.hasLowerBound() == false) goto L17;
        if (r0.hasUpperBound() == true) goto L15;
        r3.maxValue();     // Catch: NoSuchElementException -> L12
    L13:
        throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded above");
    L15:
        return new AsSet(this, r3);
    L17:
        throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded below");
    L5:
        return ImmutableSortedSet.of();
    }

    boolean isPartialView() {
        return this.ranges.isPartialView();
    }

    public static <C extends Comparable<?>> Builder<C> builder() {
        return new Builder();
    }

    Object writeReplace() {
        return new SerializedForm(this.ranges);
    }
}
