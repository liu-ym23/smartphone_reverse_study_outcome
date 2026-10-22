package com.google.common.collect;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public abstract class ForwardingSortedSet<E> extends ForwardingSet<E> implements SortedSet<E> {
    @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    protected abstract SortedSet<E> delegate();

    @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ Collection delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ Set delegate() {
        return delegate();
    }

    protected ForwardingSortedSet() {
    }

    @Override // java.util.SortedSet
    @CheckForNull
    public Comparator<? super E> comparator() {
        return delegate().comparator();
    }

    @Override // java.util.SortedSet
    @ParametricNullness
    public E first() {
        return delegate().first();
    }

    @Override // java.util.SortedSet
    public SortedSet<E> headSet(@ParametricNullness E r1) {
        return delegate().headSet(r1);
    }

    @Override // java.util.SortedSet
    @ParametricNullness
    public E last() {
        return delegate().last();
    }

    @Override // java.util.SortedSet
    public SortedSet<E> subSet(@ParametricNullness E r1, @ParametricNullness E r2) {
        return delegate().subSet(r1, r2);
    }

    @Override // java.util.SortedSet
    public SortedSet<E> tailSet(@ParametricNullness E r1) {
        return delegate().tailSet(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ForwardingCollection
    protected boolean standardContains(@CheckForNull Object r3) {
        E r1 = tailSet(r3).first();     // Catch: Throwable -> L7
        if (ForwardingSortedMap.unsafeCompare(comparator(), r1, r3) != 0) goto L10;
        return true;
    L10:
        return false;
    L11:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ForwardingCollection
    protected boolean standardRemove(@CheckForNull Object r4) {
        Iterator<E> r1 = tailSet(r4).iterator();     // Catch: Throwable -> L11
        if (r1.hasNext() == false) goto L10;
        E r2 = r1.next();     // Catch: Throwable -> L11
        if (ForwardingSortedMap.unsafeCompare(comparator(), r2, r4) != 0) goto L10;
        r1.remove();     // Catch: Throwable -> L11
        return true;
    L10:
        return false;
    }

    protected SortedSet<E> standardSubSet(@ParametricNullness E r1, @ParametricNullness E r2) {
        return tailSet(r1).headSet(r2);
    }
}
