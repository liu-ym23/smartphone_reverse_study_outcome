package com.google.common.collect;

import java.lang.Comparable;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
abstract class AbstractRangeSet<C extends Comparable> implements RangeSet<C> {
    @Override // com.google.common.collect.RangeSet
    public abstract boolean encloses(Range<C> r1);

    @Override // com.google.common.collect.RangeSet
    @CheckForNull
    public abstract Range<C> rangeContaining(C r1);

    AbstractRangeSet() {
    }

    @Override // com.google.common.collect.RangeSet
    public boolean contains(C r1) {
        if (rangeContaining(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.common.collect.RangeSet
    public boolean isEmpty() {
        return asRanges().isEmpty();
    }

    @Override // com.google.common.collect.RangeSet
    public void add(Range<C> r1) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeSet
    public void remove(Range<C> r1) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeSet
    public void clear() {
        remove(Range.all());
    }

    @Override // com.google.common.collect.RangeSet
    public boolean enclosesAll(RangeSet<C> r1) {
        return enclosesAll(r1.asRanges());
    }

    @Override // com.google.common.collect.RangeSet
    public void addAll(RangeSet<C> r1) {
        addAll(r1.asRanges());
    }

    @Override // com.google.common.collect.RangeSet
    public void removeAll(RangeSet<C> r1) {
        removeAll(r1.asRanges());
    }

    @Override // com.google.common.collect.RangeSet
    public boolean intersects(Range<C> r1) {
        return !subRangeSet(r1).isEmpty();
    }

    @Override // com.google.common.collect.RangeSet
    public boolean equals(@CheckForNull Object r2) {
        if (r2 != this) goto L6;
        return true;
    L6:
        if ((r2 instanceof RangeSet) == true) goto L8;
        return false;
    L8:
        return asRanges().equals(((RangeSet) r2).asRanges());
    }

    @Override // com.google.common.collect.RangeSet
    public final int hashCode() {
        return asRanges().hashCode();
    }

    @Override // com.google.common.collect.RangeSet
    public final String toString() {
        return asRanges().toString();
    }
}
