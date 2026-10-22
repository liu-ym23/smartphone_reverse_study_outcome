package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class SortedIterables {
    private SortedIterables() {
    }

    public static boolean hasSameComparator(Comparator<?> r1, Iterable<?> r2) {
        Preconditions.checkNotNull(r1);
        Preconditions.checkNotNull(r2);
        if ((r2 instanceof SortedSet) == false) goto L6;
        Comparator r3 = comparator((SortedSet) r2);
    L9:
        return r1.equals(r3);
    L6:
        if ((r2 instanceof SortedIterable) == false) goto L10;
        r3 = ((SortedIterable) r2).comparator();
        goto L9
    L10:
        return false;
    }

    public static <E> Comparator<? super E> comparator(SortedSet<E> r0) {
        Comparator<? super E> r1 = r0.comparator();
        if (r1 == null) goto L5;
        return r1;
    L5:
        return Ordering.natural();
    }
}
