package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.DoNotMock;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collector;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public class ImmutableRangeMap<K extends Comparable<?>, V> implements RangeMap<K, V>, Serializable {
    private static final ImmutableRangeMap<Comparable<?>, Object> EMPTY = null;
    private static final long serialVersionUID = 0;
    private final transient ImmutableList<Range<K>> ranges;
    private final transient ImmutableList<V> values;

    @DoNotMock
    public static final class Builder<K extends Comparable<?>, V> {
        private final List<Map.Entry<Range<K>, V>> entries;

        public Builder() {
            this.entries = Lists.newArrayList();
        }

        public Builder<K, V> put(Range<K> r3, V r4) {
            Preconditions.checkNotNull(r3);
            Preconditions.checkNotNull(r4);
            Preconditions.checkArgument(!r3.isEmpty(), "Range must not be empty, but was %s", r3);
            this.entries.add(Maps.immutableEntry(r3, r4));
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Builder<K, V> putAll(RangeMap<K, ? extends V> r3) {
            Iterator r4 = r3.asMapOfRanges().entrySet().iterator();
        L4:
            if (r4.hasNext() == false) goto L6;
            Map.Entry r0 = (Map.Entry) r4.next();
            put((Range) r0.getKey(), r0.getValue());
            goto L4
        L6:
            return this;
        }

        Builder<K, V> combine(Builder<K, V> r2) {
            this.entries.addAll(r2.entries);
            return this;
        }

        public ImmutableRangeMap<K, V> build() {
            Collections.sort(this.entries, Range.rangeLexOrdering().onKeys());
            ImmutableList.Builder r0 = new ImmutableList.Builder(this.entries.size());
            ImmutableList.Builder r1 = new ImmutableList.Builder(this.entries.size());
            int r2 = 0;
        L4:
            if (r2 >= this.entries.size()) goto L16;
            Range<K> r3 = this.entries.get(r2).getKey();
            if (r2 <= 0) goto L14;
            Range<K> r4 = this.entries.get(r2 - 1).getKey();
            if (r3.isConnected(r4) == false) goto L14;
            if (r3.intersection(r4).isEmpty() == true) goto L14;
            String r5 = String.valueOf(r4);
            String r6 = String.valueOf(r3);
            throw new IllegalArgumentException(new StringBuilder((String.valueOf(r5).length() + 47) + String.valueOf(r6).length()).append("Overlapping ranges: range ").append(r5).append(" overlaps with entry ").append(r6).toString());
        L14:
            r0.add(r3);
            r1.add(this.entries.get(r2).getValue());
            r2 = r2 + 1;
            goto L4
        L16:
            return new ImmutableRangeMap(r0.build(), r1.build());
        }
    }

    private static class SerializedForm<K extends Comparable<?>, V> implements Serializable {
        private static final long serialVersionUID = 0;
        private final ImmutableMap<Range<K>, V> mapOfRanges;

        SerializedForm(ImmutableMap<Range<K>, V> r1) {
            this.mapOfRanges = r1;
        }

        Object readResolve() {
            if (this.mapOfRanges.isEmpty() == false) goto L7;
            return ImmutableRangeMap.of();
        L7:
            return createRangeMap();
        }

        Object createRangeMap() {
            Builder r0 = new Builder();
            UnmodifiableIterator<Map.Entry<Range<K>, V>> r3 = this.mapOfRanges.entrySet().iterator();
        L4:
            if (r3.hasNext() == false) goto L7;
            Map.Entry<Range<K>, V> r1 = r3.next();
            r0.put(r1.getKey(), r1.getValue());
            goto L4
        L7:
            return r0.build();
        }
    }

    @Override // com.google.common.collect.RangeMap
    public /* bridge */ /* synthetic */ Map asDescendingMapOfRanges() {
        return asDescendingMapOfRanges();
    }

    @Override // com.google.common.collect.RangeMap
    public /* bridge */ /* synthetic */ Map asMapOfRanges() {
        return asMapOfRanges();
    }

    @Override // com.google.common.collect.RangeMap
    public /* bridge */ /* synthetic */ RangeMap subRangeMap(Range r1) {
        return subRangeMap(r1);
    }

    static /* synthetic */ ImmutableList access$000(ImmutableRangeMap r0) {
        return r0.ranges;
    }

    static {
        EMPTY = new ImmutableRangeMap(ImmutableList.of(), ImmutableList.of());
    }

    public static <T, K extends Comparable<? super K>, V> Collector<T, ?, ImmutableRangeMap<K, V>> toImmutableRangeMap(Function<? super T, Range<K>> r0, Function<? super T, ? extends V> r1) {
        return CollectCollectors.toImmutableRangeMap(r0, r1);
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> of() {
        return (ImmutableRangeMap<K, V>) EMPTY;
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> of(Range<K> r1, V r2) {
        return new ImmutableRangeMap(ImmutableList.of(r1), ImmutableList.of(r2));
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> copyOf(RangeMap<K, ? extends V> r4) {
        if ((r4 instanceof ImmutableRangeMap) == true) goto L5;
        Map<Range<K>, ? extends V> r5 = r4.asMapOfRanges();
        ImmutableList.Builder r0 = new ImmutableList.Builder(r5.size());
        ImmutableList.Builder r1 = new ImmutableList.Builder(r5.size());
        Iterator r6 = r5.entrySet().iterator();
    L8:
        if (r6.hasNext() == false) goto L11;
        Map.Entry r2 = (Map.Entry) r6.next();
        r0.add((Range) r2.getKey());
        r1.add(r2.getValue());
        goto L8
    L11:
        return new ImmutableRangeMap(r0.build(), r1.build());
    L5:
        return (ImmutableRangeMap) r4;
    }

    public static <K extends Comparable<?>, V> Builder<K, V> builder() {
        return new Builder();
    }

    ImmutableRangeMap(ImmutableList<Range<K>> r1, ImmutableList<V> r2) {
        this.ranges = r1;
        this.values = r2;
    }

    @Override // com.google.common.collect.RangeMap
    @CheckForNull
    public V get(K r6) {
        int r0 = SortedLists.binarySearch(this.ranges, Range.lowerBoundFn(), Cut.belowValue(r6), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        if (r0 != (-1)) goto L6;
        return null;
    L6:
        if (this.ranges.get(r0).contains(r6) == true) goto L8;
        return null;
    L8:
        return this.values.get(r0);
    }

    @Override // com.google.common.collect.RangeMap
    @CheckForNull
    public Map.Entry<Range<K>, V> getEntry(K r6) {
        int r0 = SortedLists.binarySearch(this.ranges, Range.lowerBoundFn(), Cut.belowValue(r6), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        if (r0 != (-1)) goto L5;
        return null;
    L5:
        Range<K> r1 = this.ranges.get(r0);
        if (r1.contains(r6) == true) goto L8;
        return null;
    L8:
        return Maps.immutableEntry(r1, this.values.get(r0));
    }

    @Override // com.google.common.collect.RangeMap
    public Range<K> span() {
        if (this.ranges.isEmpty() == true) goto L7;
        Range<K> r0 = this.ranges.get(0);
        ImmutableList<Range<K>> r2 = this.ranges;
        return Range.create(r0.lowerBound, r2.get(r2.size() - 1).upperBound);
    L7:
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.RangeMap
    @Deprecated
    public final void put(Range<K> r1, V r2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeMap
    @Deprecated
    public final void putCoalescing(Range<K> r1, V r2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeMap
    @Deprecated
    public final void putAll(RangeMap<K, V> r1) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeMap
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeMap
    @Deprecated
    public final void remove(Range<K> r1) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeMap
    @Deprecated
    public final void merge(Range<K> r1, @CheckForNull V r2, BiFunction<? super V, ? super V, ? extends V> r3) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeMap
    public ImmutableMap<Range<K>, V> asMapOfRanges() {
        if (this.ranges.isEmpty() == false) goto L7;
        return ImmutableMap.of();
    L7:
        return new ImmutableSortedMap(new RegularImmutableSortedSet(this.ranges, Range.rangeLexOrdering()), this.values);
    }

    @Override // com.google.common.collect.RangeMap
    public ImmutableMap<Range<K>, V> asDescendingMapOfRanges() {
        if (this.ranges.isEmpty() == false) goto L7;
        return ImmutableMap.of();
    L7:
        return new ImmutableSortedMap(new RegularImmutableSortedSet(this.ranges.reverse(), Range.rangeLexOrdering().reverse()), this.values.reverse());
    }

    @Override // com.google.common.collect.RangeMap
    public ImmutableRangeMap<K, V> subRangeMap(final Range<K> r10) {
        if (((Range) Preconditions.checkNotNull(r10)).isEmpty() == false) goto L7;
        return of();
    L7:
        if (this.ranges.isEmpty() == false) goto L9;
    L17:
        return this;
    L9:
        if (r10.encloses(span()) == true) goto L17;
        final int r0 = SortedLists.binarySearch(this.ranges, Range.upperBoundFn(), r10.lowerBound, SortedLists.KeyPresentBehavior.FIRST_AFTER, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
        int r1 = SortedLists.binarySearch(this.ranges, Range.lowerBoundFn(), r10.upperBound, SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
        if (r0 >= r1) goto L14;
        final int r2 = r1 - r0;
        final ImmutableList<Range<K>> r5 = new AnonymousClass1(this, r2, r0, r10);
        final ImmutableList<V> r6 = this.values.subList(r0, r1);
        return (ImmutableRangeMap<K, V>) new AnonymousClass2(this, r5, r6, r10, this);
    L14:
        return of();
    }

    @Override // com.google.common.collect.RangeMap
    public int hashCode() {
        return asMapOfRanges().hashCode();
    }

    @Override // com.google.common.collect.RangeMap
    public boolean equals(@CheckForNull Object r2) {
        if ((r2 instanceof RangeMap) == true) goto L5;
        return false;
    L5:
        return asMapOfRanges().equals(((RangeMap) r2).asMapOfRanges());
    }

    @Override // com.google.common.collect.RangeMap
    public String toString() {
        return asMapOfRanges().toString();
    }

    Object writeReplace() {
        return new SerializedForm(asMapOfRanges());
    }
}
