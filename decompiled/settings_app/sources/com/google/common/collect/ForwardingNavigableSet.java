package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public abstract class ForwardingNavigableSet<E> extends ForwardingSortedSet<E> implements NavigableSet<E> {

    protected class StandardDescendingSet extends Sets.DescendingSet<E> {
        public StandardDescendingSet(ForwardingNavigableSet r1) {
            super(r1);
        }
    }

    @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    protected abstract NavigableSet<E> delegate();

    @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ Collection delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ Set delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ SortedSet delegate() {
        return delegate();
    }

    protected ForwardingNavigableSet() {
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    public E lower(@ParametricNullness E r1) {
        return delegate().lower(r1);
    }

    @CheckForNull
    protected E standardLower(@ParametricNullness E r2) {
        return (E) Iterators.getNext(headSet(r2, false).descendingIterator(), null);
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    public E floor(@ParametricNullness E r1) {
        return delegate().floor(r1);
    }

    @CheckForNull
    protected E standardFloor(@ParametricNullness E r2) {
        return (E) Iterators.getNext(headSet(r2, true).descendingIterator(), null);
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    public E ceiling(@ParametricNullness E r1) {
        return delegate().ceiling(r1);
    }

    @CheckForNull
    protected E standardCeiling(@ParametricNullness E r2) {
        return (E) Iterators.getNext(tailSet(r2, true).iterator(), null);
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    public E higher(@ParametricNullness E r1) {
        return delegate().higher(r1);
    }

    @CheckForNull
    protected E standardHigher(@ParametricNullness E r2) {
        return (E) Iterators.getNext(tailSet(r2, false).iterator(), null);
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    public E pollFirst() {
        return delegate().pollFirst();
    }

    @CheckForNull
    protected E standardPollFirst() {
        return (E) Iterators.pollNext(iterator());
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    public E pollLast() {
        return delegate().pollLast();
    }

    @CheckForNull
    protected E standardPollLast() {
        return (E) Iterators.pollNext(descendingIterator());
    }

    @ParametricNullness
    protected E standardFirst() {
        return iterator().next();
    }

    @ParametricNullness
    protected E standardLast() {
        return descendingIterator().next();
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> descendingSet() {
        return delegate().descendingSet();
    }

    @Override // java.util.NavigableSet
    public Iterator<E> descendingIterator() {
        return delegate().descendingIterator();
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> subSet(@ParametricNullness E r1, boolean r2, @ParametricNullness E r3, boolean r4) {
        return delegate().subSet(r1, r2, r3, r4);
    }

    protected NavigableSet<E> standardSubSet(@ParametricNullness E r1, boolean r2, @ParametricNullness E r3, boolean r4) {
        return tailSet(r1, r2).headSet(r3, r4);
    }

    @Override // com.google.common.collect.ForwardingSortedSet
    protected SortedSet<E> standardSubSet(@ParametricNullness E r3, @ParametricNullness E r4) {
        return subSet(r3, true, r4, false);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> headSet(@ParametricNullness E r1, boolean r2) {
        return delegate().headSet(r1, r2);
    }

    protected SortedSet<E> standardHeadSet(@ParametricNullness E r2) {
        return headSet(r2, false);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> tailSet(@ParametricNullness E r1, boolean r2) {
        return delegate().tailSet(r1, r2);
    }

    protected SortedSet<E> standardTailSet(@ParametricNullness E r2) {
        return tailSet(r2, true);
    }
}
