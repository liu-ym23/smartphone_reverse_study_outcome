package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Iterator;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class ReverseOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final Ordering<? super T> forwardOrder;

    ReverseOrdering(Ordering<? super T> r1) {
        this.forwardOrder = (Ordering) Preconditions.checkNotNull(r1);
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(@ParametricNullness T r1, @ParametricNullness T r2) {
        return this.forwardOrder.compare(r2, r1);
    }

    @Override // com.google.common.collect.Ordering
    public <S extends T> Ordering<S> reverse() {
        return this.forwardOrder;
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E min(@ParametricNullness E r1, @ParametricNullness E r2) {
        return (E) this.forwardOrder.max(r1, r2);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E min(@ParametricNullness E r1, @ParametricNullness E r2, @ParametricNullness E r3, E... r4) {
        return (E) this.forwardOrder.max(r1, r2, r3, r4);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E min(Iterator<E> r1) {
        return (E) this.forwardOrder.max(r1);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E min(Iterable<E> r1) {
        return (E) this.forwardOrder.max(r1);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E max(@ParametricNullness E r1, @ParametricNullness E r2) {
        return (E) this.forwardOrder.min(r1, r2);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E max(@ParametricNullness E r1, @ParametricNullness E r2, @ParametricNullness E r3, E... r4) {
        return (E) this.forwardOrder.min(r1, r2, r3, r4);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E max(Iterator<E> r1) {
        return (E) this.forwardOrder.min(r1);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E max(Iterable<E> r1) {
        return (E) this.forwardOrder.min(r1);
    }

    public int hashCode() {
        return -this.forwardOrder.hashCode();
    }

    @Override // java.util.Comparator
    public boolean equals(@CheckForNull Object r2) {
        if (r2 != this) goto L6;
        return true;
    L6:
        if ((r2 instanceof ReverseOrdering) == true) goto L8;
        return false;
    L8:
        return this.forwardOrder.equals(((ReverseOrdering) r2).forwardOrder);
    }

    public String toString() {
        String r2 = String.valueOf(this.forwardOrder);
        return new StringBuilder(String.valueOf(r2).length() + 10).append(r2).append(".reverse()").toString();
    }
}
