package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class Comparators {
    private Comparators() {
    }

    public static <T, S extends T> Comparator<Iterable<S>> lexicographical(Comparator<T> r1) {
        return new LexicographicalOrdering((Comparator) Preconditions.checkNotNull(r1));
    }

    public static <T> boolean isInOrder(Iterable<? extends T> r2, Comparator<T> r3) {
        Preconditions.checkNotNull(r3);
        Iterator<? extends T> r4 = r2.iterator();
        if (r4.hasNext() == false) goto L12;
        T r0 = r4.next();
    L6:
        if (r4.hasNext() == false) goto L16;
        T r1 = r4.next();
        if (r3.compare(r0, r1) > 0) goto L9;
        r0 = r1;
        goto L6
    L9:
        return false;
    L16:
        return true;
    L12:
        return true;
    }

    public static <T> boolean isInStrictOrder(Iterable<? extends T> r2, Comparator<T> r3) {
        Preconditions.checkNotNull(r3);
        Iterator<? extends T> r4 = r2.iterator();
        if (r4.hasNext() == false) goto L12;
        T r0 = r4.next();
    L6:
        if (r4.hasNext() == false) goto L16;
        T r1 = r4.next();
        if (r3.compare(r0, r1) >= 0) goto L9;
        r0 = r1;
        goto L6
    L9:
        return false;
    L16:
        return true;
    L12:
        return true;
    }

    public static <T> Collector<T, ?, List<T>> least(final int r5, final Comparator<? super T> r6) {
        CollectPreconditions.checkNonnegative(r5, "k");
        Preconditions.checkNotNull(r6);
        return Collector.of(new Comparators$$ExternalSyntheticLambda2(r5, r6), new Comparators$$ExternalSyntheticLambda3(), new Comparators$$ExternalSyntheticLambda4(), new Comparators$$ExternalSyntheticLambda5(), new Collector.Characteristics[]{Collector.Characteristics.UNORDERED});
    }

    static /* synthetic */ TopKSelector lambda$least$0(int r0, Comparator r1) {
        return TopKSelector.least(r0, r1);
    }

    public static <T> Collector<T, ?, List<T>> greatest(int r0, Comparator<? super T> r1) {
        return least(r0, r1.reversed());
    }

    public static <T> Comparator<Optional<T>> emptiesFirst(Comparator<? super T> r1) {
        Preconditions.checkNotNull(r1);
        return Comparator.comparing(new Comparators$$ExternalSyntheticLambda0(), Comparator.nullsFirst(r1));
    }

    static /* synthetic */ Object lambda$emptiesFirst$1(Optional r1) {
        return r1.orElse(null);
    }

    public static <T> Comparator<Optional<T>> emptiesLast(Comparator<? super T> r1) {
        Preconditions.checkNotNull(r1);
        return Comparator.comparing(new Comparators$$ExternalSyntheticLambda1(), Comparator.nullsLast(r1));
    }

    static /* synthetic */ Object lambda$emptiesLast$2(Optional r1) {
        return r1.orElse(null);
    }

    public static <T extends Comparable<? super T>> T min(T r1, T r2) {
        if (r1.compareTo(r2) > 0) goto L6;
        return r1;
    L6:
        return r2;
    }

    @ParametricNullness
    public static <T> T min(@ParametricNullness T r0, @ParametricNullness T r1, Comparator<T> r2) {
        if (r2.compare(r0, r1) > 0) goto L6;
        return r0;
    L6:
        return r1;
    }

    public static <T extends Comparable<? super T>> T max(T r1, T r2) {
        if (r1.compareTo(r2) < 0) goto L6;
        return r1;
    L6:
        return r2;
    }

    @ParametricNullness
    public static <T> T max(@ParametricNullness T r0, @ParametricNullness T r1, Comparator<T> r2) {
        if (r2.compare(r0, r1) < 0) goto L6;
        return r0;
    L6:
        return r1;
    }
}
