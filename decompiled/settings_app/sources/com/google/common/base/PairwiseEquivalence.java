package com.google.common.base;

import java.io.Serializable;
import java.util.Iterator;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class PairwiseEquivalence<E, T extends E> extends Equivalence<Iterable<T>> implements Serializable {
    private static final long serialVersionUID = 1;
    final Equivalence<E> elementEquivalence;

    @Override // com.google.common.base.Equivalence
    protected /* bridge */ /* synthetic */ boolean doEquivalent(Object r1, Object r2) {
        return doEquivalent((Iterable) r1, (Iterable) r2);
    }

    @Override // com.google.common.base.Equivalence
    protected /* bridge */ /* synthetic */ int doHash(Object r1) {
        return doHash((Iterable) r1);
    }

    PairwiseEquivalence(Equivalence<E> r1) {
        this.elementEquivalence = (Equivalence) Preconditions.checkNotNull(r1);
    }

    protected boolean doEquivalent(Iterable<T> r5, Iterable<T> r6) {
        Iterator<T> r7 = r5.iterator();
        Iterator<T> r8 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L11;
        if (r8.hasNext() == false) goto L11;
        if (this.elementEquivalence.equivalent(r7.next(), r8.next()) == true) goto L4;
        return false;
    L11:
        if (r7.hasNext() == false) goto L13;
        return false;
    L13:
        if (r8.hasNext() == true) goto L21;
        return true;
    L21:
        return false;
    }

    protected int doHash(Iterable<T> r4) {
        Iterator<T> r5 = r4.iterator();
        int r0 = 78721;
    L4:
        if (r5.hasNext() == false) goto L6;
        T r1 = r5.next();
        r0 = (r0 * 24943) + this.elementEquivalence.hash(r1);
        goto L4
    L6:
        return r0;
    }

    public boolean equals(@CheckForNull Object r2) {
        if ((r2 instanceof PairwiseEquivalence) == true) goto L5;
        return false;
    L5:
        return this.elementEquivalence.equals(((PairwiseEquivalence) r2).elementEquivalence);
    }

    public int hashCode() {
        return this.elementEquivalence.hashCode() ^ 1185147655;
    }

    public String toString() {
        String r2 = String.valueOf(this.elementEquivalence);
        return new StringBuilder(String.valueOf(r2).length() + 11).append(r2).append(".pairwise()").toString();
    }
}
