package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class RegularImmutableSortedSet<E> extends ImmutableSortedSet<E> {
    static final RegularImmutableSortedSet<Comparable> NATURAL_EMPTY_SET = null;
    private final transient ImmutableList<E> elements;

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public /* bridge */ /* synthetic */ Iterator descendingIterator() {
        return descendingIterator();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet.CachingAsList, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    static {
        NATURAL_EMPTY_SET = new RegularImmutableSortedSet(ImmutableList.of(), Ordering.natural());
    }

    RegularImmutableSortedSet(ImmutableList<E> r1, Comparator<? super E> r2) {
        super(r2);
        this.elements = r1;
    }

    @Override // com.google.common.collect.ImmutableCollection
    @CheckForNull
    Object[] internalArray() {
        return this.elements.internalArray();
    }

    @Override // com.google.common.collect.ImmutableCollection
    int internalArrayStart() {
        return this.elements.internalArrayStart();
    }

    @Override // com.google.common.collect.ImmutableCollection
    int internalArrayEnd() {
        return this.elements.internalArrayEnd();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet.CachingAsList, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
    public UnmodifiableIterator<E> iterator() {
        return this.elements.iterator();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public UnmodifiableIterator<E> descendingIterator() {
        return this.elements.reverse().iterator();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        return asList().spliterator();
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer<? super E> r1) {
        this.elements.forEach(r1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.elements.size();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@CheckForNull Object r2) {
        if (r2 == null) goto L11;
        if (unsafeBinarySearch(r2) < 0) goto L12;
        return true;
    L12:
        return false;
    L13:
        return false;
    L11:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> r7) {
        if ((r7 instanceof Multiset) == false) goto L6;
        r7 = ((Multiset) r7).elementSet();
    L6:
        if (SortedIterables.hasSameComparator(comparator(), r7) == false) goto L29;
        if (r7.size() <= 1) goto L29;
        UnmodifiableIterator<E> r0 = iterator();
        Iterator<?> r8 = r7.iterator();
        if (r0.hasNext() == true) goto L13;
        return false;
    L13:
        Object r2 = r8.next();
        E r4 = r0.next();
    L31:
        int r5 = unsafeCompare(r4, r2);     // Catch: Throwable -> L30
        if (r5 < 0) goto L17;
        if (r5 == 0) goto L22;
        if (r5 <= 0) goto L31;
    L22:
        if (r8.hasNext() == false) goto L23;
        r2 = r8.next();     // Catch: Throwable -> L30
        goto L31
    L23:
        return true;
    L17:
        if (r0.hasNext() == false) goto L18;
        r4 = r0.next();     // Catch: Throwable -> L30
        goto L31
    L18:
        return false;
    L27:
        return false;
    L29:
        return super.containsAll(r7);
    }

    private int unsafeBinarySearch(Object r2) throws ClassCastException {
        return Collections.binarySearch(this.elements, r2, unsafeComparator());
    }

    @Override // com.google.common.collect.ImmutableCollection
    boolean isPartialView() {
        return this.elements.isPartialView();
    }

    @Override // com.google.common.collect.ImmutableCollection
    int copyIntoArray(Object[] r1, int r2) {
        return this.elements.copyIntoArray(r1, r2);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public boolean equals(@CheckForNull Object r6) {
        if (r6 != this) goto L6;
        return true;
    L6:
        if ((r6 instanceof Set) == true) goto L8;
        return false;
    L8:
        Set r7 = (Set) r6;
        if (size() == r7.size()) goto L12;
        return false;
    L12:
        if (isEmpty() == false) goto L15;
        return true;
    L15:
        if (SortedIterables.hasSameComparator(this.comparator, r7) == false) goto L28;
        Iterator<E> r8 = r7.iterator();
        UnmodifiableIterator<E> r1 = iterator();     // Catch: Throwable -> L26
    L19:
        if (r1.hasNext() == false) goto L25;
        E r3 = r1.next();     // Catch: Throwable -> L26
        E r4 = r8.next();     // Catch: Throwable -> L26
        if (r4 == null) goto L24;
        if (unsafeCompare(r3, r4) == 0) goto L19;
    L24:
        return false;
    L25:
        return true;
    L26:
        return false;
    L28:
        return containsAll(r7);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public E first() {
        if (isEmpty() == true) goto L7;
        return this.elements.get(0);
    L7:
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public E last() {
        if (isEmpty() == true) goto L7;
        return this.elements.get(size() - 1);
    L7:
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    @CheckForNull
    public E lower(E r2) {
        int r3 = headIndex(r2, false) - 1;
        if (r3 != (-1)) goto L6;
        return null;
    L6:
        return this.elements.get(r3);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    @CheckForNull
    public E floor(E r2) {
        int r3 = headIndex(r2, true) - 1;
        if (r3 != (-1)) goto L6;
        return null;
    L6:
        return this.elements.get(r3);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    @CheckForNull
    public E ceiling(E r2) {
        int r3 = tailIndex(r2, true);
        if (r3 != size()) goto L6;
        return null;
    L6:
        return this.elements.get(r3);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    @CheckForNull
    public E higher(E r2) {
        int r3 = tailIndex(r2, false);
        if (r3 != size()) goto L6;
        return null;
    L6:
        return this.elements.get(r3);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    ImmutableSortedSet<E> headSetImpl(E r2, boolean r3) {
        return getSubSet(0, headIndex(r2, r3));
    }

    int headIndex(E r2, boolean r3) {
        int r1 = Collections.binarySearch(this.elements, Preconditions.checkNotNull(r2), comparator());
        if (r1 < 0) goto L8;
        if (r3 == true) goto L6;
        return r1;
    L6:
        return r1 + 1;
    L8:
        return ~r1;
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    ImmutableSortedSet<E> subSetImpl(E r1, boolean r2, E r3, boolean r4) {
        return tailSetImpl(r1, r2).headSetImpl(r3, r4);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    ImmutableSortedSet<E> tailSetImpl(E r1, boolean r2) {
        return getSubSet(tailIndex(r1, r2), size());
    }

    int tailIndex(E r2, boolean r3) {
        int r1 = Collections.binarySearch(this.elements, Preconditions.checkNotNull(r2), comparator());
        if (r1 < 0) goto L9;
        if (r3 == false) goto L7;
        return r1;
    L7:
        return r1 + 1;
    L9:
        return ~r1;
    }

    Comparator<Object> unsafeComparator() {
        return this.comparator;
    }

    RegularImmutableSortedSet<E> getSubSet(int r3, int r4) {
        if (r3 == 0) goto L4;
    L6:
        if (r3 >= r4) goto L10;
        return new RegularImmutableSortedSet(this.elements.subList(r3, r4), this.comparator);
    L10:
        return emptySet(this.comparator);
    L4:
        if (r4 != size()) goto L6;
        return this;
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    int indexOf(@CheckForNull Object r3) {
        if (r3 != null) goto L10;
        return -1;
    L10:
        int r2 = Collections.binarySearch(this.elements, r3, unsafeComparator());     // Catch: ClassCastException -> L9
        if (r2 >= 0) goto L8;
        return -1;
    L8:
        return r2;
    L13:
        return -1;
    }

    @Override // com.google.common.collect.ImmutableSet.CachingAsList
    ImmutableList<E> createAsList() {
        if (size() > 1) goto L6;
        return this.elements;
    L6:
        return new ImmutableSortedAsList(this, this.elements);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    ImmutableSortedSet<E> createDescendingSet() {
        Comparator r0 = Collections.reverseOrder(this.comparator);
        if (isEmpty() == false) goto L6;
        return emptySet(r0);
    L6:
        return new RegularImmutableSortedSet(this.elements.reverse(), r0);
    }
}
