package com.google.common.collect;

import adcpeJava.adcpe.Constants;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.stream.Collector;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public abstract class ImmutableSortedSet<E> extends ImmutableSortedSetFauxverideShim<E> implements NavigableSet<E>, SortedIterable<E> {
    static final int SPLITERATOR_CHARACTERISTICS = 1301;
    final transient Comparator<? super E> comparator;

    @CheckForNull
    @LazyInit
    transient ImmutableSortedSet<E> descendingSet;

    public static final class Builder<E> extends ImmutableSet.Builder<E> {
        private final Comparator<? super E> comparator;
        private E[] elements;
        private int n;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.ImmutableCollection.Builder
        public /* bridge */ /* synthetic */ ImmutableCollection.Builder add(Object r1) {
            return add(r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.ImmutableCollection.Builder
        public /* bridge */ /* synthetic */ ImmutableCollection.Builder add(Object[] r1) {
            return add(r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.ImmutableCollection.Builder
        public /* bridge */ /* synthetic */ ImmutableSet.Builder add(Object r1) {
            return add(r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.ImmutableCollection.Builder
        public /* bridge */ /* synthetic */ ImmutableSet.Builder add(Object[] r1) {
            return add(r1);
        }

        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.ImmutableCollection.Builder
        public /* bridge */ /* synthetic */ ImmutableCollection.Builder addAll(Iterable r1) {
            return addAll(r1);
        }

        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.ImmutableCollection.Builder
        public /* bridge */ /* synthetic */ ImmutableCollection.Builder addAll(Iterator r1) {
            return addAll(r1);
        }

        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.ImmutableCollection.Builder
        public /* bridge */ /* synthetic */ ImmutableSet.Builder addAll(Iterable r1) {
            return addAll(r1);
        }

        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.ImmutableCollection.Builder
        public /* bridge */ /* synthetic */ ImmutableSet.Builder addAll(Iterator r1) {
            return addAll(r1);
        }

        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.ImmutableCollection.Builder
        public /* bridge */ /* synthetic */ ImmutableCollection build() {
            return build();
        }

        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.ImmutableCollection.Builder
        public /* bridge */ /* synthetic */ ImmutableSet build() {
            return build();
        }

        @Override // com.google.common.collect.ImmutableSet.Builder
        /* bridge */ /* synthetic */ ImmutableSet.Builder combine(ImmutableSet.Builder r1) {
            return combine(r1);
        }

        public Builder(Comparator<? super E> r2) {
            super(true);
            this.comparator = (Comparator) Preconditions.checkNotNull(r2);
            this.elements = (E[]) new Object[4];
            this.n = 0;
        }

        @Override // com.google.common.collect.ImmutableSet.Builder
        void copy() {
            E[] r0 = this.elements;
            this.elements = (E[]) Arrays.copyOf(r0, r0.length);
        }

        private void sortAndDedup() {
            int r0 = this.n;
            if (r0 != 0) goto L5;
            return;
        L5:
            Arrays.sort(this.elements, 0, r0, this.comparator);
            int r1 = 1;
            int r2 = 1;
        L6:
            int r3 = this.n;
            if (r1 >= r3) goto L15;
            Comparator<? super E> r4 = this.comparator;
            E[] r5 = this.elements;
            int r6 = r4.compare(r5[r2 - 1], r5[r1]);
            if (r6 >= 0) goto L11;
            E[] r7 = this.elements;
            r7[r2] = r7[r1];
            r2 = r2 + 1;
        L12:
            r1 = r1 + 1;
            goto L6
        L11:
            if (r6 <= 0) goto L12;
            String r8 = String.valueOf(this.comparator);
            throw new AssertionError(new StringBuilder(String.valueOf(r8).length() + 48).append("Comparator ").append(r8).append(" compare method violates its contract").toString());
        L15:
            Arrays.fill(this.elements, r2, r3, null);
            this.n = r2;
        }

        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.ImmutableCollection.Builder
        public Builder<E> add(E r4) {
            Preconditions.checkNotNull(r4);
            copyIfNecessary();
            if (this.n != this.elements.length) goto L7;
            sortAndDedup();
            int r0 = this.n;
            int r1 = ImmutableCollection.Builder.expandedCapacity(r0, r0 + 1);
            E[] r2 = this.elements;
            if (r1 <= r2.length) goto L7;
            this.elements = (E[]) Arrays.copyOf(r2, r1);
        L7:
            E[] r3 = this.elements;
            int r5 = this.n;
            this.n = r5 + 1;
            r3[r5] = r4;
            return this;
        }

        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.ImmutableCollection.Builder
        public Builder<E> add(E... r4) {
            ObjectArrays.checkElementsNotNull(r4);
            int r0 = r4.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            add(r4[r1]);
            r1 = r1 + 1;
            goto L3
        L5:
            return this;
        }

        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.ImmutableCollection.Builder
        public Builder<E> addAll(Iterable<? extends E> r1) {
            super.addAll(r1);
            return this;
        }

        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.ImmutableCollection.Builder
        public Builder<E> addAll(Iterator<? extends E> r1) {
            super.addAll(r1);
            return this;
        }

        @Override // com.google.common.collect.ImmutableSet.Builder
        Builder<E> combine(ImmutableSet.Builder<E> r3) {
            copyIfNecessary();
            Builder r4 = (Builder) r3;
            int r0 = 0;
        L4:
            if (r0 >= r4.n) goto L6;
            add(r4.elements[r0]);
            r0 = r0 + 1;
            goto L4
        L6:
            return this;
        }

        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.ImmutableCollection.Builder
        public ImmutableSortedSet<E> build() {
            sortAndDedup();
            if (this.n == 0) goto L5;
            this.forceCopy = true;
            return new RegularImmutableSortedSet(ImmutableList.asImmutableList(this.elements, this.n), this.comparator);
        L5:
            return ImmutableSortedSet.emptySet(this.comparator);
        }
    }

    private static class SerializedForm<E> implements Serializable {
        private static final long serialVersionUID = 0;
        final Comparator<? super E> comparator;
        final Object[] elements;

        public SerializedForm(Comparator<? super E> r1, Object[] r2) {
            this.comparator = r1;
            this.elements = r2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        Object readResolve() {
            return new Builder(this.comparator).add(this.elements).build();
        }
    }

    abstract ImmutableSortedSet<E> createDescendingSet();

    public abstract UnmodifiableIterator<E> descendingIterator();

    abstract ImmutableSortedSet<E> headSetImpl(E r1, boolean r2);

    abstract int indexOf(@CheckForNull Object r1);

    @Override // com.google.common.collect.ImmutableSet.CachingAsList, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
    public abstract UnmodifiableIterator<E> iterator();

    abstract ImmutableSortedSet<E> subSetImpl(E r1, boolean r2, E r3, boolean r4);

    abstract ImmutableSortedSet<E> tailSetImpl(E r1, boolean r2);

    @Override // com.google.common.collect.ImmutableSet.CachingAsList, com.google.common.collect.ImmutableCollection
    public /* bridge */ /* synthetic */ ImmutableList asList() {
        return super.asList();
    }

    public /* bridge */ /* synthetic */ Iterator descendingIterator() {
        return descendingIterator();
    }

    public /* bridge */ /* synthetic */ NavigableSet descendingSet() {
        return descendingSet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ NavigableSet headSet(Object r1, boolean r2) {
        return headSet(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ SortedSet headSet(Object r1) {
        return headSet(r1);
    }

    @Override // com.google.common.collect.ImmutableSet.CachingAsList, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ NavigableSet subSet(Object r1, boolean r2, Object r3, boolean r4) {
        return subSet(r1, r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ SortedSet subSet(Object r1, Object r2) {
        return subSet(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ NavigableSet tailSet(Object r1, boolean r2) {
        return tailSet(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ SortedSet tailSet(Object r1) {
        return tailSet(r1);
    }

    public static <E> Collector<E, ?, ImmutableSortedSet<E>> toImmutableSortedSet(Comparator<? super E> r0) {
        return CollectCollectors.toImmutableSortedSet(r0);
    }

    static <E> RegularImmutableSortedSet<E> emptySet(Comparator<? super E> r2) {
        if (Ordering.natural().equals(r2) == false) goto L7;
        return (RegularImmutableSortedSet<E>) RegularImmutableSortedSet.NATURAL_EMPTY_SET;
    L7:
        return new RegularImmutableSortedSet(ImmutableList.of(), r2);
    }

    public static <E> ImmutableSortedSet<E> of() {
        return RegularImmutableSortedSet.NATURAL_EMPTY_SET;
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable r2) {
        return new RegularImmutableSortedSet(ImmutableList.of(r2), Ordering.natural());
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable r4, Comparable r5) {
        return construct(Ordering.natural(), 2, new Comparable[]{r4, r5});
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable r4, Comparable r5, Comparable r6) {
        return construct(Ordering.natural(), 3, new Comparable[]{r4, r5, r6});
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable r4, Comparable r5, Comparable r6, Comparable r7) {
        return construct(Ordering.natural(), 4, new Comparable[]{r4, r5, r6, r7});
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable r4, Comparable r5, Comparable r6, Comparable r7, Comparable r8) {
        return construct(Ordering.natural(), 5, new Comparable[]{r4, r5, r6, r7, r8});
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;TE;[TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable r4, Comparable r5, Comparable r6, Comparable r7, Comparable r8, Comparable r9, Comparable... r10) {
        int r0 = r10.length + 6;
        Comparable[] r2 = new Comparable[r0];
        r2[0] = r4;
        r2[1] = r5;
        r2[2] = r6;
        r2[3] = r7;
        r2[4] = r8;
        r2[5] = r9;
        System.arraycopy(r10, 0, r2, 6, r10.length);
        return construct(Ordering.natural(), r0, r2);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>([TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet copyOf(Comparable[] r2) {
        return construct(Ordering.natural(), r2.length, (Comparable[]) r2.clone());
    }

    public static <E> ImmutableSortedSet<E> copyOf(Iterable<? extends E> r1) {
        return copyOf(Ordering.natural(), r1);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Collection<? extends E> r1) {
        return copyOf(Ordering.natural(), r1);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Iterator<? extends E> r1) {
        return copyOf(Ordering.natural(), r1);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> r1, Iterator<? extends E> r2) {
        return new Builder(r1).addAll(r2).build();
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> r2, Iterable<? extends E> r3) {
        Preconditions.checkNotNull(r2);
        if (SortedIterables.hasSameComparator(r2, r3) == true) goto L5;
    L9:
        Object[] r4 = Iterables.toArray(r3);
        return construct(r2, r4.length, r4);
    L5:
        if ((r3 instanceof ImmutableSortedSet) == false) goto L9;
        ImmutableSortedSet<E> r0 = (ImmutableSortedSet) r3;
        if (r0.isPartialView() == true) goto L9;
        return r0;
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> r0, Collection<? extends E> r1) {
        return copyOf(r0, r1);
    }

    public static <E> ImmutableSortedSet<E> copyOfSorted(SortedSet<E> r2) {
        Comparator r0 = SortedIterables.comparator(r2);
        ImmutableList r3 = ImmutableList.copyOf(r2);
        if (r3.isEmpty() == false) goto L7;
        return emptySet(r0);
    L7:
        return new RegularImmutableSortedSet(r3, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <E> ImmutableSortedSet<E> construct(Comparator<? super E> r4, int r5, E... r6) {
        if (r5 == 0) goto L4;
        ObjectArrays.checkElementsNotNull(r6, r5);
        Arrays.sort(r6, 0, r5, r4);
        int r0 = 1;
        int r1 = 1;
    L6:
        if (r0 >= r5) goto L11;
        Constants r2 = (Object) r6[r0];
        if (r4.compare(r2, (Object) r6[r1 - 1]) == 0) goto L10;
        r6[r1] = r2;
        r1 = r1 + 1;
    L10:
        r0 = r0 + 1;
        goto L6
    L11:
        Arrays.fill(r6, r1, r5, null);
        return new RegularImmutableSortedSet(ImmutableList.asImmutableList(r6, r1), r4);
    L4:
        return emptySet(r4);
    }

    public static <E> Builder<E> orderedBy(Comparator<E> r1) {
        return new Builder(r1);
    }

    public static <E extends Comparable<?>> Builder<E> reverseOrder() {
        return new Builder(Collections.reverseOrder());
    }

    public static <E extends Comparable<?>> Builder<E> naturalOrder() {
        return new Builder(Ordering.natural());
    }

    int unsafeCompare(Object r1, @CheckForNull Object r2) {
        return unsafeCompare(this.comparator, r1, r2);
    }

    static int unsafeCompare(Comparator<?> r0, Object r1, @CheckForNull Object r2) {
        return r0.compare(r1, r2);
    }

    ImmutableSortedSet(Comparator<? super E> r1) {
        this.comparator = r1;
    }

    @Override // java.util.SortedSet, com.google.common.collect.SortedIterable
    public Comparator<? super E> comparator() {
        return this.comparator;
    }

    public ImmutableSortedSet<E> headSet(E r2) {
        return headSet(r2, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ImmutableSortedSet<E> headSet(E r1, boolean r2) {
        return headSetImpl(Preconditions.checkNotNull(r1), r2);
    }

    public ImmutableSortedSet<E> subSet(E r3, E r4) {
        return subSet(r3, true, r4, false);
    }

    public ImmutableSortedSet<E> subSet(E r2, boolean r3, E r4, boolean r5) {
        Preconditions.checkNotNull(r2);
        Preconditions.checkNotNull(r4);
        if (this.comparator.compare(r2, r4) > 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0);
        return subSetImpl(r2, r3, r4, r5);
    L5:
        r0 = false;
        goto L6
    }

    public ImmutableSortedSet<E> tailSet(E r2) {
        return tailSet(r2, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ImmutableSortedSet<E> tailSet(E r1, boolean r2) {
        return tailSetImpl(Preconditions.checkNotNull(r1), r2);
    }

    @CheckForNull
    public E lower(E r2) {
        return (E) Iterators.getNext(headSet(r2, false).descendingIterator(), null);
    }

    @CheckForNull
    public E floor(E r2) {
        return (E) Iterators.getNext(headSet(r2, true).descendingIterator(), null);
    }

    @CheckForNull
    public E ceiling(E r2) {
        return (E) Iterables.getFirst(tailSet(r2, true), null);
    }

    @CheckForNull
    public E higher(E r2) {
        return (E) Iterables.getFirst(tailSet(r2, false), null);
    }

    public E first() {
        return iterator().next();
    }

    public E last() {
        return descendingIterator().next();
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    @Deprecated
    public final E pollFirst() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    @Deprecated
    public final E pollLast() {
        throw new UnsupportedOperationException();
    }

    public ImmutableSortedSet<E> descendingSet() {
        ImmutableSortedSet<E> r0 = this.descendingSet;
        if (r0 != null) goto L6;
        ImmutableSortedSet<E> r1 = createDescendingSet();
        this.descendingSet = r1;
        r1.descendingSet = this;
        return r1;
    L6:
        return r0;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        final long r1 = size();
        final int r3 = 1365;
        return new AnonymousClass1(this, r1, r3);
    }

    private void readObject(ObjectInputStream r1) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new SerializedForm(this.comparator, toArray());
    }
}
