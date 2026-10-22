package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public abstract class Ordering<T> implements Comparator<T> {
    static final int LEFT_IS_GREATER = 1;
    static final int RIGHT_IS_GREATER = -1;

    static class ArbitraryOrdering extends Ordering<Object> {
        private final AtomicInteger counter;
        private final ConcurrentMap<Object, Integer> uids;

        public String toString() {
            return "Ordering.arbitrary()";
        }

        ArbitraryOrdering() {
            this.counter = new AtomicInteger(0);
            this.uids = Platform.tryWeakKeys(new MapMaker()).makeMap();
        }

        private Integer getUid(Object r2) {
            Integer r0 = this.uids.get(r2);
            if (r0 != null) goto L8;
            Integer r1 = Integer.valueOf(this.counter.getAndIncrement());
            Integer r3 = this.uids.putIfAbsent(r2, r1);
            if (r3 != null) goto L7;
            return r1;
        L7:
            return r3;
        L8:
            return r0;
        }

        @Override // com.google.common.collect.Ordering, java.util.Comparator
        public int compare(@CheckForNull Object r5, @CheckForNull Object r6) {
            if (r5 != r6) goto L6;
            return 0;
        L6:
            if (r5 != null) goto L9;
            return -1;
        L9:
            if (r6 != null) goto L11;
            return 1;
        L11:
            int r2 = identityHashCode(r5);
            int r3 = identityHashCode(r6);
            if (r2 == r3) goto L17;
            if (r2 >= r3) goto L16;
            return -1;
        L16:
            return 1;
        L17:
            int r4 = getUid(r5).compareTo(getUid(r6));
            if (r4 == 0) goto L21;
            return r4;
        L21:
            throw new AssertionError();
        }

        int identityHashCode(Object r1) {
            return System.identityHashCode(r1);
        }
    }

    private static class ArbitraryOrderingHolder {
        static final Ordering<Object> ARBITRARY_ORDERING = null;

        private ArbitraryOrderingHolder() {
        }

        static {
            ARBITRARY_ORDERING = new ArbitraryOrdering();
        }
    }

    static class IncomparableValueException extends ClassCastException {
        private static final long serialVersionUID = 0;
        final Object value;

        IncomparableValueException(Object r4) {
            String r0 = String.valueOf(r4);
            super(new StringBuilder(String.valueOf(r0).length() + 22).append("Cannot compare value: ").append(r0).toString());
            this.value = r4;
        }
    }

    @Override // java.util.Comparator
    public abstract int compare(@ParametricNullness T r1, @ParametricNullness T r2);

    public static <C extends Comparable> Ordering<C> natural() {
        return NaturalOrdering.INSTANCE;
    }

    public static <T> Ordering<T> from(Comparator<T> r1) {
        if ((r1 instanceof Ordering) == false) goto L6;
        return (Ordering) r1;
    L6:
        return new ComparatorOrdering(r1);
    }

    @Deprecated
    public static <T> Ordering<T> from(Ordering<T> r0) {
        return (Ordering) Preconditions.checkNotNull(r0);
    }

    public static <T> Ordering<T> explicit(List<T> r1) {
        return new ExplicitOrdering(r1);
    }

    public static <T> Ordering<T> explicit(T r0, T... r1) {
        return explicit(Lists.asList(r0, r1));
    }

    public static Ordering<Object> allEqual() {
        return AllEqualOrdering.INSTANCE;
    }

    public static Ordering<Object> usingToString() {
        return UsingToStringOrdering.INSTANCE;
    }

    public static Ordering<Object> arbitrary() {
        return ArbitraryOrderingHolder.ARBITRARY_ORDERING;
    }

    protected Ordering() {
    }

    public <S extends T> Ordering<S> reverse() {
        return new ReverseOrdering(this);
    }

    public <S extends T> Ordering<S> nullsFirst() {
        return new NullsFirstOrdering(this);
    }

    public <S extends T> Ordering<S> nullsLast() {
        return new NullsLastOrdering(this);
    }

    public <F> Ordering<F> onResultOf(Function<F, ? extends T> r2) {
        return new ByFunctionOrdering(r2, this);
    }

    <T2 extends T> Ordering<Map.Entry<T2, ?>> onKeys() {
        return (Ordering<Map.Entry<T2, ?>>) onResultOf(Maps.keyFunction());
    }

    public <U extends T> Ordering<U> compound(Comparator<? super U> r2) {
        return new CompoundOrdering(this, (Comparator) Preconditions.checkNotNull(r2));
    }

    public static <T> Ordering<T> compound(Iterable<? extends Comparator<? super T>> r1) {
        return new CompoundOrdering(r1);
    }

    public <S extends T> Ordering<Iterable<S>> lexicographical() {
        return new LexicographicalOrdering(this);
    }

    @ParametricNullness
    public <E extends T> E min(Iterator<E> r3) {
        E r0 = r3.next();
    L4:
        if (r3.hasNext() == false) goto L6;
        E r1 = r0;
        r0 = (E) min(r1, r3.next());
        goto L4
    L6:
        return r0;
    }

    @ParametricNullness
    public <E extends T> E min(Iterable<E> r1) {
        return (E) min(r1.iterator());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @ParametricNullness
    public <E extends T> E min(@ParametricNullness E r1, @ParametricNullness E r2) {
        if (compare(r1, r2) > 0) goto L6;
        return r1;
    L6:
        return r2;
    }

    @ParametricNullness
    public <E extends T> E min(@ParametricNullness E r2, @ParametricNullness E r3, @ParametricNullness E r4, E... r5) {
        E r6 = (E) min(min(r2, r3), r4);
        int r7 = r5.length;
        int r8 = 0;
    L3:
        if (r8 >= r7) goto L5;
        E r9 = r6;
        r6 = (E) min(r9, r5[r8]);
        r8 = r8 + 1;
        goto L3
    L5:
        return r6;
    }

    @ParametricNullness
    public <E extends T> E max(Iterator<E> r3) {
        E r0 = r3.next();
    L4:
        if (r3.hasNext() == false) goto L6;
        E r1 = r0;
        r0 = (E) max(r1, r3.next());
        goto L4
    L6:
        return r0;
    }

    @ParametricNullness
    public <E extends T> E max(Iterable<E> r1) {
        return (E) max(r1.iterator());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @ParametricNullness
    public <E extends T> E max(@ParametricNullness E r1, @ParametricNullness E r2) {
        if (compare(r1, r2) < 0) goto L6;
        return r1;
    L6:
        return r2;
    }

    @ParametricNullness
    public <E extends T> E max(@ParametricNullness E r2, @ParametricNullness E r3, @ParametricNullness E r4, E... r5) {
        E r6 = (E) max(max(r2, r3), r4);
        int r7 = r5.length;
        int r8 = 0;
    L3:
        if (r8 >= r7) goto L5;
        E r9 = r6;
        r6 = (E) max(r9, r5[r8]);
        r8 = r8 + 1;
        goto L3
    L5:
        return r6;
    }

    public <E extends T> List<E> leastOf(Iterable<E> r8, int r9) {
        if ((r8 instanceof Collection) == false) goto L12;
        Collection r0 = (Collection) r8;
        if (r0.size() > (((long) r9) * 2)) goto L12;
        Object[] r10 = r0.toArray();
        Arrays.sort(r10, this);
        if (r10.length <= r9) goto L10;
        r10 = Arrays.copyOf(r10, r9);
    L10:
        return Collections.unmodifiableList(Arrays.asList(r10));
    L12:
        return leastOf(r8.iterator(), r9);
    }

    public <E extends T> List<E> leastOf(Iterator<E> r2, int r3) {
        Preconditions.checkNotNull(r2);
        CollectPreconditions.checkNonnegative(r3, "k");
        if (r3 == 0) goto L17;
        if (r2.hasNext() == false) goto L17;
        if (r3 < 1073741823) goto L14;
        ArrayList r4 = Lists.newArrayList(r2);
        Collections.sort(r4, this);
        if (r4.size() <= r3) goto L12;
        r4.subList(r3, r4.size()).clear();
    L12:
        r4.trimToSize();
        return Collections.unmodifiableList(r4);
    L14:
        TopKSelector r1 = TopKSelector.least(r3, this);
        r1.offerAll(r2);
        return r1.topK();
    L17:
        return Collections.emptyList();
    }

    public <E extends T> List<E> greatestOf(Iterable<E> r1, int r2) {
        return reverse().leastOf(r1, r2);
    }

    public <E extends T> List<E> greatestOf(Iterator<E> r1, int r2) {
        return reverse().leastOf(r1, r2);
    }

    public <E extends T> List<E> sortedCopy(Iterable<E> r1) {
        Object[] r2 = Iterables.toArray(r1);
        Arrays.sort(r2, this);
        return Lists.newArrayList(Arrays.asList(r2));
    }

    public <E extends T> ImmutableList<E> immutableSortedCopy(Iterable<E> r1) {
        return ImmutableList.sortedCopyOf(this, r1);
    }

    public boolean isOrdered(Iterable<? extends T> r3) {
        Iterator<? extends T> r4 = r3.iterator();
        if (r4.hasNext() == false) goto L12;
        T r0 = r4.next();
    L6:
        if (r4.hasNext() == false) goto L16;
        T r1 = r4.next();
        if (compare(r0, r1) > 0) goto L9;
        r0 = r1;
        goto L6
    L9:
        return false;
    L16:
        return true;
    L12:
        return true;
    }

    public boolean isStrictlyOrdered(Iterable<? extends T> r3) {
        Iterator<? extends T> r4 = r3.iterator();
        if (r4.hasNext() == false) goto L12;
        T r0 = r4.next();
    L6:
        if (r4.hasNext() == false) goto L16;
        T r1 = r4.next();
        if (compare(r0, r1) >= 0) goto L9;
        r0 = r1;
        goto L6
    L9:
        return false;
    L16:
        return true;
    L12:
        return true;
    }

    @Deprecated
    public int binarySearch(List<? extends T> r1, @ParametricNullness T r2) {
        return Collections.binarySearch(r1, r2, this);
    }
}
