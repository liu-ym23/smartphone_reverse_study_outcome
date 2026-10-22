package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class Range<C extends Comparable> extends RangeGwtSerializationDependencies implements Predicate<C>, Serializable {
    private static final Range<Comparable> ALL = null;
    private static final long serialVersionUID = 0;
    final Cut<C> lowerBound;
    final Cut<C> upperBound;

    /* JADX INFO: renamed from: com.google.common.collect.Range$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$common$collect$BoundType = null;

        static {
            int[] r0 = new int[BoundType.values().length];
            $SwitchMap$com$google$common$collect$BoundType = r0;
            r0[BoundType.OPEN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$google$common$collect$BoundType[BoundType.CLOSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    static class LowerBoundFn implements Function<Range, Cut> {
        static final LowerBoundFn INSTANCE = null;

        LowerBoundFn() {
        }

        @Override // com.google.common.base.Function, java.util.function.Function
        public /* bridge */ /* synthetic */ Object apply(Object r1) {
            return apply((Range) r1);
        }

        static {
            INSTANCE = new LowerBoundFn();
        }

        public Cut apply(Range r1) {
            return r1.lowerBound;
        }
    }

    private static class RangeLexOrdering extends Ordering<Range<?>> implements Serializable {
        static final Ordering<Range<?>> INSTANCE = null;
        private static final long serialVersionUID = 0;

        private RangeLexOrdering() {
        }

        @Override // com.google.common.collect.Ordering, java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object r1, Object r2) {
            return compare((Range) r1, (Range) r2);
        }

        static {
            INSTANCE = new RangeLexOrdering();
        }

        public int compare(Range<?> r3, Range<?> r4) {
            return ComparisonChain.start().compare(r3.lowerBound, r4.lowerBound).compare(r3.upperBound, r4.upperBound).result();
        }
    }

    static class UpperBoundFn implements Function<Range, Cut> {
        static final UpperBoundFn INSTANCE = null;

        UpperBoundFn() {
        }

        @Override // com.google.common.base.Function, java.util.function.Function
        public /* bridge */ /* synthetic */ Object apply(Object r1) {
            return apply((Range) r1);
        }

        static {
            INSTANCE = new UpperBoundFn();
        }

        public Cut apply(Range r1) {
            return r1.upperBound;
        }
    }

    @Override // com.google.common.base.Predicate
    @Deprecated
    public /* bridge */ /* synthetic */ boolean apply(Object r1) {
        return apply((Comparable) r1);
    }

    static <C extends Comparable<?>> Function<Range<C>, Cut<C>> lowerBoundFn() {
        return LowerBoundFn.INSTANCE;
    }

    static <C extends Comparable<?>> Function<Range<C>, Cut<C>> upperBoundFn() {
        return UpperBoundFn.INSTANCE;
    }

    static <C extends Comparable<?>> Ordering<Range<C>> rangeLexOrdering() {
        return (Ordering<Range<C>>) RangeLexOrdering.INSTANCE;
    }

    static <C extends Comparable<?>> Range<C> create(Cut<C> r1, Cut<C> r2) {
        return new Range(r1, r2);
    }

    public static <C extends Comparable<?>> Range<C> open(C r0, C r1) {
        return create(Cut.aboveValue(r0), Cut.belowValue(r1));
    }

    public static <C extends Comparable<?>> Range<C> closed(C r0, C r1) {
        return create(Cut.belowValue(r0), Cut.aboveValue(r1));
    }

    public static <C extends Comparable<?>> Range<C> closedOpen(C r0, C r1) {
        return create(Cut.belowValue(r0), Cut.belowValue(r1));
    }

    public static <C extends Comparable<?>> Range<C> openClosed(C r0, C r1) {
        return create(Cut.aboveValue(r0), Cut.aboveValue(r1));
    }

    public static <C extends Comparable<?>> Range<C> range(C r1, BoundType r2, C r3, BoundType r4) {
        Preconditions.checkNotNull(r2);
        Preconditions.checkNotNull(r4);
        if (r2 != BoundType.OPEN) goto L5;
        Cut r5 = Cut.aboveValue(r1);
    L7:
        if (r4 != BoundType.OPEN) goto L9;
        Cut r6 = Cut.belowValue(r3);
    L11:
        return create(r5, r6);
    L9:
        r6 = Cut.aboveValue(r3);
        goto L11
    L5:
        r5 = Cut.belowValue(r1);
        goto L7
    }

    public static <C extends Comparable<?>> Range<C> lessThan(C r1) {
        return create(Cut.belowAll(), Cut.belowValue(r1));
    }

    public static <C extends Comparable<?>> Range<C> atMost(C r1) {
        return create(Cut.belowAll(), Cut.aboveValue(r1));
    }

    public static <C extends Comparable<?>> Range<C> upTo(C r1, BoundType r2) {
        int r3 = AnonymousClass1.$SwitchMap$com$google$common$collect$BoundType[r2.ordinal()];
        if (r3 == 1) goto L11;
        if (r3 != 2) goto L9;
        return atMost(r1);
    L9:
        throw new AssertionError();
    L11:
        return lessThan(r1);
    }

    public static <C extends Comparable<?>> Range<C> greaterThan(C r1) {
        return create(Cut.aboveValue(r1), Cut.aboveAll());
    }

    public static <C extends Comparable<?>> Range<C> atLeast(C r1) {
        return create(Cut.belowValue(r1), Cut.aboveAll());
    }

    public static <C extends Comparable<?>> Range<C> downTo(C r1, BoundType r2) {
        int r3 = AnonymousClass1.$SwitchMap$com$google$common$collect$BoundType[r2.ordinal()];
        if (r3 == 1) goto L11;
        if (r3 != 2) goto L9;
        return atLeast(r1);
    L9:
        throw new AssertionError();
    L11:
        return greaterThan(r1);
    }

    static {
        ALL = new Range(Cut.belowAll(), Cut.aboveAll());
    }

    public static <C extends Comparable<?>> Range<C> all() {
        return (Range<C>) ALL;
    }

    public static <C extends Comparable<?>> Range<C> singleton(C r0) {
        return closed(r0, r0);
    }

    public static <C extends Comparable<?>> Range<C> encloseAll(Iterable<C> r4) {
        Preconditions.checkNotNull(r4);
        if ((r4 instanceof SortedSet) == false) goto L9;
        SortedSet r0 = (SortedSet) r4;
        Comparator r1 = r0.comparator();
        if (Ordering.natural().equals(r1) == true) goto L8;
        if (r1 != null) goto L9;
    L8:
        return closed((Comparable) r0.first(), (Comparable) r0.last());
    L9:
        Iterator<C> r5 = r4.iterator();
        Comparable r2 = (Comparable) Preconditions.checkNotNull(r5.next());
        Comparable r3 = r2;
    L11:
        if (r5.hasNext() == false) goto L14;
        Comparable r6 = (Comparable) Preconditions.checkNotNull(r5.next());
        r2 = (Comparable) Ordering.natural().min(r2, r6);
        r3 = (Comparable) Ordering.natural().max(r3, r6);
        goto L11
    L14:
        return closed(r2, r3);
    }

    private Range(Cut<C> r2, Cut<C> r3) {
        this.lowerBound = (Cut) Preconditions.checkNotNull(r2);
        this.upperBound = (Cut) Preconditions.checkNotNull(r3);
        if (r2.compareTo(r3) <= 0) goto L5;
    L10:
        String r4 = String.valueOf(toString(r2, r3));
        if (r4.length() == 0) goto L13;
        String r5 = "Invalid range: ".concat(r4);
    L15:
        throw new IllegalArgumentException(r5);
    L13:
        r5 = new String("Invalid range: ");
        goto L15
    L5:
        if (r2 == Cut.aboveAll()) goto L10;
        if (r3 == Cut.belowAll()) goto L10;
    }

    public boolean hasLowerBound() {
        if (this.lowerBound == Cut.belowAll()) goto L5;
        return true;
    L5:
        return false;
    }

    public C lowerEndpoint() {
        return (C) this.lowerBound.endpoint();
    }

    public BoundType lowerBoundType() {
        return this.lowerBound.typeAsLowerBound();
    }

    public boolean hasUpperBound() {
        if (this.upperBound == Cut.aboveAll()) goto L5;
        return true;
    L5:
        return false;
    }

    public C upperEndpoint() {
        return (C) this.upperBound.endpoint();
    }

    public BoundType upperBoundType() {
        return this.upperBound.typeAsUpperBound();
    }

    public boolean isEmpty() {
        return this.lowerBound.equals(this.upperBound);
    }

    public boolean contains(C r2) {
        Preconditions.checkNotNull(r2);
        if (this.lowerBound.isLessThan(r2) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.upperBound.isLessThan(r2) == true) goto L7;
        return true;
    }

    @Deprecated
    public boolean apply(C r1) {
        return contains(r1);
    }

    public boolean containsAll(Iterable<? extends C> r6) {
        if (Iterables.isEmpty(r6) == false) goto L6;
        return true;
    L6:
        if ((r6 instanceof SortedSet) == false) goto L17;
        SortedSet r0 = (SortedSet) r6;
        Comparator r3 = r0.comparator();
        if (Ordering.natural().equals(r3) == true) goto L11;
        if (r3 != null) goto L17;
    L11:
        if (contains((Comparable) r0.first()) == false) goto L16;
        if (contains((Comparable) r0.last()) == false) goto L16;
        return true;
    L16:
        return false;
    L17:
        Iterator<? extends C> r7 = r6.iterator();
    L19:
        if (r7.hasNext() == false) goto L23;
        if (contains(r7.next()) == true) goto L19;
        return false;
    L23:
        return true;
    }

    public boolean encloses(Range<C> r3) {
        if (this.lowerBound.compareTo(r3.lowerBound) <= 0) goto L5;
    L7:
        return false;
    L5:
        if (this.upperBound.compareTo(r3.upperBound) < 0) goto L7;
        return true;
    }

    public boolean isConnected(Range<C> r3) {
        if (this.lowerBound.compareTo(r3.upperBound) <= 0) goto L5;
    L7:
        return false;
    L5:
        if (r3.lowerBound.compareTo(this.upperBound) > 0) goto L7;
        return true;
    }

    public Range<C> intersection(Range<C> r4) {
        int r0 = this.lowerBound.compareTo(r4.lowerBound);
        int r1 = this.upperBound.compareTo(r4.upperBound);
        if (r0 < 0) goto L6;
        if (r1 > 0) goto L6;
        return this;
    L6:
        if (r0 > 0) goto L9;
        if (r1 < 0) goto L9;
        return r4;
    L9:
        if (r0 < 0) goto L11;
        Cut<C> r2 = this.lowerBound;
    L12:
        if (r1 > 0) goto L14;
        Cut<C> r3 = this.upperBound;
    L16:
        return create(r2, r3);
    L14:
        r3 = r4.upperBound;
        goto L16
    L11:
        r2 = r4.lowerBound;
        goto L12
    }

    public Range<C> gap(Range<C> r4) {
        if (this.lowerBound.compareTo(r4.upperBound) >= 0) goto L10;
        if (r4.lowerBound.compareTo(this.upperBound) >= 0) goto L10;
        String r3 = String.valueOf(this);
        String r5 = String.valueOf(r4);
        throw new IllegalArgumentException(new StringBuilder((String.valueOf(r3).length() + 39) + String.valueOf(r5).length()).append("Ranges have a nonempty intersection: ").append(r3).append(", ").append(r5).toString());
    L10:
        if (this.lowerBound.compareTo(r4.lowerBound) >= 0) goto L12;
        boolean r0 = true;
    L13:
        if (r0 == false) goto L15;
        Range<C> r1 = this;
    L16:
        if (r0 == false) goto L19;
        Range<C> this = r4;
    L19:
        return create(r1.upperBound, this.lowerBound);
    L15:
        r1 = r4;
        goto L16
    L12:
        r0 = false;
        goto L13
    }

    public Range<C> span(Range<C> r4) {
        int r0 = this.lowerBound.compareTo(r4.lowerBound);
        int r1 = this.upperBound.compareTo(r4.upperBound);
        if (r0 > 0) goto L6;
        if (r1 < 0) goto L6;
        return this;
    L6:
        if (r0 < 0) goto L9;
        if (r1 > 0) goto L9;
        return r4;
    L9:
        if (r0 > 0) goto L11;
        Cut<C> r2 = this.lowerBound;
    L12:
        if (r1 < 0) goto L14;
        Cut<C> r3 = this.upperBound;
    L16:
        return create(r2, r3);
    L14:
        r3 = r4.upperBound;
        goto L16
    L11:
        r2 = r4.lowerBound;
        goto L12
    }

    public Range<C> canonical(DiscreteDomain<C> r3) {
        Preconditions.checkNotNull(r3);
        Cut<C> r0 = this.lowerBound.canonical(r3);
        Cut<C> r4 = this.upperBound.canonical(r3);
        if (r0 != this.lowerBound) goto L8;
        if (r4 != this.upperBound) goto L8;
        return this;
    L8:
        return create(r0, r4);
    }

    @Override // com.google.common.base.Predicate
    public boolean equals(@CheckForNull Object r4) {
        if ((r4 instanceof Range) == false) goto L10;
        Range r5 = (Range) r4;
        if (this.lowerBound.equals(r5.lowerBound) == true) goto L7;
        return false;
    L7:
        if (this.upperBound.equals(r5.upperBound) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public int hashCode() {
        return (this.lowerBound.hashCode() * 31) + this.upperBound.hashCode();
    }

    public String toString() {
        return toString(this.lowerBound, this.upperBound);
    }

    private static String toString(Cut<?> r2, Cut<?> r3) {
        StringBuilder r0 = new StringBuilder(16);
        r2.describeAsLowerBound(r0);
        r0.append("..");
        r3.describeAsUpperBound(r0);
        return r0.toString();
    }

    Object readResolve() {
        if (equals(ALL) == true) goto L5;
        return this;
    L5:
        return all();
    }

    static int compareOrThrow(Comparable r0, Comparable r1) {
        return r0.compareTo(r1);
    }
}
