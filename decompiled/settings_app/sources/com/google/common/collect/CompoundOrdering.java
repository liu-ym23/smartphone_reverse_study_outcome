package com.google.common.collect;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class CompoundOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final Comparator<? super T>[] comparators;

    CompoundOrdering(Comparator<? super T> r3, Comparator<? super T> r4) {
        this.comparators = new Comparator[]{r3, r4};
    }

    CompoundOrdering(Iterable<? extends Comparator<? super T>> r2) {
        this.comparators = (Comparator[]) Iterables.toArray(r2, new Comparator[0]);
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(@ParametricNullness T r5, @ParametricNullness T r6) {
        int r1 = 0;
    L3:
        Comparator<? super T>[] r2 = this.comparators;
        if (r1 >= r2.length) goto L9;
        int r3 = r2[r1].compare(r5, r6);
        if (r3 != 0) goto L7;
        r1 = r1 + 1;
        goto L3
    L7:
        return r3;
    L9:
        return 0;
    }

    @Override // java.util.Comparator
    public boolean equals(@CheckForNull Object r2) {
        if (r2 != this) goto L6;
        return true;
    L6:
        if ((r2 instanceof CompoundOrdering) == true) goto L8;
        return false;
    L8:
        return Arrays.equals(this.comparators, ((CompoundOrdering) r2).comparators);
    }

    public int hashCode() {
        return Arrays.hashCode(this.comparators);
    }

    public String toString() {
        String r2 = Arrays.toString(this.comparators);
        return new StringBuilder(String.valueOf(r2).length() + 19).append("Ordering.compound(").append(r2).append(")").toString();
    }
}
