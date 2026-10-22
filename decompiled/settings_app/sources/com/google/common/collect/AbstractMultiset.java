package com.google.common.collect;

import com.google.errorprone.annotations.concurrent.LazyInit;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
abstract class AbstractMultiset<E> extends AbstractCollection<E> implements Multiset<E> {

    @CheckForNull
    @LazyInit
    private transient Set<E> elementSet;

    @CheckForNull
    @LazyInit
    private transient Set<Multiset.Entry<E>> entrySet;

    class ElementSet extends Multisets.ElementSet<E> {
        final /* synthetic */ AbstractMultiset this$0;

        ElementSet(AbstractMultiset r1) {
            this.this$0 = r1;
        }

        @Override // com.google.common.collect.Multisets.ElementSet
        Multiset<E> multiset() {
            return this.this$0;
        }

        @Override // com.google.common.collect.Multisets.ElementSet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return this.this$0.elementIterator();
        }
    }

    class EntrySet extends Multisets.EntrySet<E> {
        final /* synthetic */ AbstractMultiset this$0;

        EntrySet(AbstractMultiset r1) {
            this.this$0 = r1;
        }

        @Override // com.google.common.collect.Multisets.EntrySet
        Multiset<E> multiset() {
            return this.this$0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Multiset.Entry<E>> iterator() {
            return this.this$0.entryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.this$0.distinctElements();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public abstract void clear();

    abstract int distinctElements();

    abstract Iterator<E> elementIterator();

    abstract Iterator<Multiset.Entry<E>> entryIterator();

    AbstractMultiset() {
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return entrySet().isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public boolean contains(@CheckForNull Object r1) {
        if (count(r1) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public final boolean add(@ParametricNullness E r2) {
        add(r2, 1);
        return true;
    }

    public int add(@ParametricNullness E r1, int r2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public final boolean remove(@CheckForNull Object r2) {
        if (remove(r2, 1) > 0) goto L7;
        return false;
    L7:
        return true;
    }

    public int remove(@CheckForNull Object r1, int r2) {
        throw new UnsupportedOperationException();
    }

    public int setCount(@ParametricNullness E r1, int r2) {
        return Multisets.setCountImpl(this, r1, r2);
    }

    @Override // com.google.common.collect.Multiset
    public boolean setCount(@ParametricNullness E r1, int r2, int r3) {
        return Multisets.setCountImpl(this, r1, r2, r3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection<? extends E> r1) {
        return Multisets.addAllImpl(this, r1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public final boolean removeAll(Collection<?> r1) {
        return Multisets.removeAllImpl(this, r1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public final boolean retainAll(Collection<?> r1) {
        return Multisets.retainAllImpl(this, r1);
    }

    @Override // com.google.common.collect.Multiset
    public Set<E> elementSet() {
        Set<E> r0 = this.elementSet;
        if (r0 != null) goto L6;
        Set<E> r1 = createElementSet();
        this.elementSet = r1;
        return r1;
    L6:
        return r0;
    }

    Set<E> createElementSet() {
        return new ElementSet(this);
    }

    public Set<Multiset.Entry<E>> entrySet() {
        Set<Multiset.Entry<E>> r0 = this.entrySet;
        if (r0 != null) goto L6;
        Set<Multiset.Entry<E>> r1 = createEntrySet();
        this.entrySet = r1;
        return r1;
    L6:
        return r0;
    }

    Set<Multiset.Entry<E>> createEntrySet() {
        return new EntrySet(this);
    }

    @Override // java.util.Collection, com.google.common.collect.Multiset
    public final boolean equals(@CheckForNull Object r1) {
        return Multisets.equalsImpl(this, r1);
    }

    @Override // java.util.Collection, com.google.common.collect.Multiset
    public final int hashCode() {
        return entrySet().hashCode();
    }

    @Override // java.util.AbstractCollection, com.google.common.collect.Multiset
    public final String toString() {
        return entrySet().toString();
    }
}
