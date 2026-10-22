package com.google.common.collect;

import java.io.Serializable;
import java.util.List;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class ExplicitOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final ImmutableMap<T, Integer> rankMap;

    ExplicitOrdering(List<T> r1) {
        this(Maps.indexMap(r1));
    }

    ExplicitOrdering(ImmutableMap<T, Integer> r1) {
        this.rankMap = r1;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(T r1, T r2) {
        return rank(r1) - rank(r2);
    }

    private int rank(T r1) {
        Integer r0 = this.rankMap.get(r1);
        if (r0 == null) goto L7;
        return r0.intValue();
    L7:
        throw new Ordering.IncomparableValueException(r1);
    }

    @Override // java.util.Comparator
    public boolean equals(@CheckForNull Object r2) {
        if ((r2 instanceof ExplicitOrdering) == true) goto L5;
        return false;
    L5:
        return this.rankMap.equals(((ExplicitOrdering) r2).rankMap);
    }

    public int hashCode() {
        return this.rankMap.hashCode();
    }

    public String toString() {
        String r2 = String.valueOf(this.rankMap.keySet());
        return new StringBuilder(String.valueOf(r2).length() + 19).append("Ordering.explicit(").append(r2).append(")").toString();
    }
}
