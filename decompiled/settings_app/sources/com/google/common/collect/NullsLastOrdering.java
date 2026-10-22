package com.google.common.collect;

import java.io.Serializable;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class NullsLastOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final Ordering<? super T> ordering;

    @Override // com.google.common.collect.Ordering
    public <S extends T> Ordering<S> nullsLast() {
        return this;
    }

    NullsLastOrdering(Ordering<? super T> r1) {
        this.ordering = r1;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(@CheckForNull T r1, @CheckForNull T r2) {
        if (r1 != r2) goto L5;
        return 0;
    L5:
        if (r1 != null) goto L8;
        return 1;
    L8:
        if (r2 != null) goto L12;
        return -1;
    L12:
        return this.ordering.compare(r1, r2);
    }

    @Override // com.google.common.collect.Ordering
    public <S extends T> Ordering<S> reverse() {
        return this.ordering.reverse().nullsFirst();
    }

    @Override // com.google.common.collect.Ordering
    public <S extends T> Ordering<S> nullsFirst() {
        return this.ordering.nullsFirst();
    }

    @Override // java.util.Comparator
    public boolean equals(@CheckForNull Object r2) {
        if (r2 != this) goto L6;
        return true;
    L6:
        if ((r2 instanceof NullsLastOrdering) == true) goto L8;
        return false;
    L8:
        return this.ordering.equals(((NullsLastOrdering) r2).ordering);
    }

    public int hashCode() {
        return this.ordering.hashCode() ^ (-921210296);
    }

    public String toString() {
        String r2 = String.valueOf(this.ordering);
        return new StringBuilder(String.valueOf(r2).length() + 12).append(r2).append(".nullsLast()").toString();
    }
}
