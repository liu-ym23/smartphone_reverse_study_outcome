package com.google.common.collect;

import com.google.errorprone.annotations.DoNotMock;
import java.lang.Comparable;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@DoNotMock("Use ImmutableRangeSet or TreeRangeSet")
@ElementTypesAreNonnullByDefault
public interface RangeSet<C extends Comparable> {
    void add(Range<C> r1);

    void addAll(RangeSet<C> r1);

    Set<Range<C>> asDescendingSetOfRanges();

    Set<Range<C>> asRanges();

    void clear();

    RangeSet<C> complement();

    boolean contains(C r1);

    boolean encloses(Range<C> r1);

    boolean enclosesAll(RangeSet<C> r1);

    boolean equals(@CheckForNull Object r1);

    int hashCode();

    boolean intersects(Range<C> r1);

    boolean isEmpty();

    @CheckForNull
    Range<C> rangeContaining(C r1);

    void remove(Range<C> r1);

    void removeAll(RangeSet<C> r1);

    Range<C> span();

    RangeSet<C> subRangeSet(Range<C> r1);

    String toString();

    default boolean enclosesAll(Iterable<Range<C>> r2) {
        Iterator<Range<C>> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        if (encloses(r3.next()) == true) goto L4;
        return false;
    L9:
        return true;
    }

    default void addAll(Iterable<Range<C>> r2) {
        Iterator<Range<C>> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        add(r3.next());
        goto L4
    }

    default void removeAll(Iterable<Range<C>> r2) {
        Iterator<Range<C>> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        remove(r3.next());
        goto L4
    }
}
