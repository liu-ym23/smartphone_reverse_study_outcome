package com.google.common.collect;

import com.bytedance.apm.constant.PerfConsts;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.math.IntMath;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Stream;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class Sets {

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: renamed from: com.google.common.collect.Sets$1, reason: invalid class name */
    class AnonymousClass1<E> extends SetView<E> {
        final /* synthetic */ Set val$set1;
        final /* synthetic */ Set val$set2;

        AnonymousClass1(Set r1, Set r2) {
            this.val$set1 = r1;
            this.val$set2 = r2;
            super(null);
        }

        @Override // com.google.common.collect.Sets.SetView, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return iterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            int r0 = this.val$set1.size();
            Iterator<E> r1 = this.val$set2.iterator();
        L4:
            if (r1.hasNext() == false) goto L8;
            E r2 = r1.next();
            if (this.val$set1.contains(r2) == true) goto L4;
            r0 = r0 + 1;
            goto L4
        L8:
            return r0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            if (this.val$set1.isEmpty() == true) goto L5;
        L7:
            return false;
        L5:
            if (this.val$set2.isEmpty() == false) goto L7;
            return true;
        }

        @Override // com.google.common.collect.Sets.SetView, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public UnmodifiableIterator<E> iterator() {
            return new C00651(this);
        }

        static /* synthetic */ boolean lambda$stream$0(Set r0, Object r1) {
            return !r0.contains(r1);
        }

        @Override // java.util.Collection
        public Stream<E> stream() {
            Stream<E> r0 = this.val$set1.stream();
            Stream<E> r1 = this.val$set2.stream();
            final Set r3 = this.val$set1;
            return Stream.concat(r0, r1.filter(new Sets$1$$ExternalSyntheticLambda0(r3)));
        }

        @Override // java.util.Collection
        public Stream<E> parallelStream() {
            return (Stream) stream().parallel();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object r2) {
            if (this.val$set1.contains(r2) == false) goto L5;
        L8:
            return true;
        L5:
            if (this.val$set2.contains(r2) == true) goto L8;
            return false;
        }

        @Override // com.google.common.collect.Sets.SetView
        public <S extends Set<E>> S copyInto(S r2) {
            r2.addAll(this.val$set1);
            r2.addAll(this.val$set2);
            return r2;
        }

        @Override // com.google.common.collect.Sets.SetView
        public ImmutableSet<E> immutableCopy() {
            return new ImmutableSet.Builder().addAll(this.val$set1).addAll(this.val$set2).build();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: renamed from: com.google.common.collect.Sets$3, reason: invalid class name */
    class AnonymousClass3<E> extends SetView<E> {
        final /* synthetic */ Set val$set1;
        final /* synthetic */ Set val$set2;

        AnonymousClass3(Set r1, Set r2) {
            this.val$set1 = r1;
            this.val$set2 = r2;
            super(null);
        }

        @Override // com.google.common.collect.Sets.SetView, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return iterator();
        }

        @Override // com.google.common.collect.Sets.SetView, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public UnmodifiableIterator<E> iterator() {
            return new AnonymousClass1(this);
        }

        static /* synthetic */ boolean lambda$stream$0(Set r0, Object r1) {
            return !r0.contains(r1);
        }

        @Override // java.util.Collection
        public Stream<E> stream() {
            Stream<E> r0 = this.val$set1.stream();
            final Set r2 = this.val$set2;
            return r0.filter(new Sets$3$$ExternalSyntheticLambda1(r2));
        }

        static /* synthetic */ boolean lambda$parallelStream$1(Set r0, Object r1) {
            return !r0.contains(r1);
        }

        @Override // java.util.Collection
        public Stream<E> parallelStream() {
            Stream<E> r0 = this.val$set1.parallelStream();
            final Set r2 = this.val$set2;
            return r0.filter(new Sets$3$$ExternalSyntheticLambda0(r2));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            Iterator<E> r0 = this.val$set1.iterator();
            int r1 = 0;
        L4:
            if (r0.hasNext() == false) goto L8;
            E r2 = r0.next();
            if (this.val$set2.contains(r2) == true) goto L4;
            r1 = r1 + 1;
            goto L4
        L8:
            return r1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.val$set2.containsAll(this.val$set1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object r2) {
            if (this.val$set1.contains(r2) == true) goto L5;
        L7:
            return false;
        L5:
            if (this.val$set2.contains(r2) == true) goto L7;
            return true;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: renamed from: com.google.common.collect.Sets$5, reason: invalid class name */
    class AnonymousClass5<E> extends AbstractSet<Set<E>> {
        final /* synthetic */ ImmutableMap val$index;
        final /* synthetic */ int val$size;

        /* JADX INFO: renamed from: com.google.common.collect.Sets$5$1, reason: invalid class name */
        class AnonymousClass1 extends AbstractIterator<Set<E>> {
            final BitSet bits;
            final /* synthetic */ AnonymousClass5 this$0;

            AnonymousClass1(AnonymousClass5 r2) {
                this.this$0 = r2;
                this.bits = new BitSet(r2.val$index.size());
            }

            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            protected /* bridge */ /* synthetic */ Object computeNext() {
                return computeNext();
            }

            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            protected Set<E> computeNext() {
                if (this.bits.isEmpty() == false) goto L5;
                this.bits.set(0, this.this$0.val$size);
            L10:
                final BitSet r0 = (BitSet) this.bits.clone();
                return new C00661(this, r0);
            L5:
                int r1 = this.bits.nextSetBit(0);
                int r2 = this.bits.nextClearBit(r1);
                if (r2 == this.this$0.val$index.size()) goto L8;
                int r3 = (r2 - r1) - 1;
                this.bits.set(0, r3);
                this.bits.clear(r3, r2);
                this.bits.set(r2);
                goto L10
            L8:
                return endOfData();
            }
        }

        AnonymousClass5(int r1, ImmutableMap r2) {
            this.val$size = r1;
            this.val$index = r2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object r4) {
            if ((r4 instanceof Set) == false) goto L10;
            Set r5 = (Set) r4;
            if (r5.size() == this.val$size) goto L7;
            return false;
        L7:
            if (this.val$index.keySet().containsAll(r5) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Set<E>> iterator() {
            return new AnonymousClass1(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return IntMath.binomial(this.val$index.size(), this.val$size);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            String r0 = String.valueOf(this.val$index.keySet());
            int r3 = this.val$size;
            return new StringBuilder(String.valueOf(r0).length() + 32).append("Sets.combinations(").append(r0).append(", ").append(r3).append(")").toString();
        }
    }

    private static final class CartesianSet<E> extends ForwardingCollection<List<E>> implements Set<List<E>> {
        private final transient ImmutableList<ImmutableSet<E>> axes;
        private final transient CartesianList<E> delegate;

        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        static <E> Set<List<E>> create(List<? extends Set<? extends E>> r3) {
            ImmutableList.Builder r0 = new ImmutableList.Builder(r3.size());
            Iterator<? extends Set<? extends E>> r4 = r3.iterator();
        L4:
            if (r4.hasNext() == false) goto L10;
            ImmutableSet r1 = ImmutableSet.copyOf(r4.next());
            if (r1.isEmpty() == true) goto L8;
            r0.add(r1);
            goto L4
        L8:
            return ImmutableSet.of();
        L10:
            final ImmutableList<E> r5 = r0.build();
            return new CartesianSet(r5, new CartesianList(new AnonymousClass1(r5)));
        }

        private CartesianSet(ImmutableList<ImmutableSet<E>> r1, CartesianList<E> r2) {
            this.axes = r1;
            this.delegate = r2;
        }

        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected Collection<List<E>> delegate() {
            return this.delegate;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object r5) {
            if ((r5 instanceof List) == true) goto L5;
            return false;
        L5:
            List r6 = (List) r5;
            if (r6.size() == this.axes.size()) goto L8;
            return false;
        L8:
            Iterator<E> r7 = r6.iterator();
            int r0 = 0;
        L10:
            if (r7.hasNext() == false) goto L15;
            if (this.axes.get(r0).contains(r7.next()) == false) goto L13;
            r0 = r0 + 1;
            goto L10
        L13:
            return false;
        L15:
            return true;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(@CheckForNull Object r2) {
            if ((r2 instanceof CartesianSet) == false) goto L7;
            return this.axes.equals(((CartesianSet) r2).axes);
        L7:
            return super.equals(r2);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            int r1 = 1;
            int r0 = size() - 1;
            int r2 = 0;
        L4:
            if (r2 >= this.axes.size()) goto L6;
            r0 = ~(~(r0 * 31));
            r2 = r2 + 1;
            goto L4
        L6:
            UnmodifiableIterator<ImmutableSet<E>> r3 = this.axes.iterator();
        L8:
            if (r3.hasNext() == false) goto L11;
            ImmutableSet<E> r4 = r3.next();
            r1 = ~(~((r1 * 31) + ((size() / r4.size()) * r4.hashCode())));
            goto L8
        L11:
            return ~(~(r1 + r0));
        }
    }

    static class DescendingSet<E> extends ForwardingNavigableSet<E> {
        private final NavigableSet<E> forward;

        @Override // com.google.common.collect.ForwardingNavigableSet, com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Set delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ SortedSet delegate() {
            return delegate();
        }

        DescendingSet(NavigableSet<E> r1) {
            this.forward = r1;
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected NavigableSet<E> delegate() {
            return this.forward;
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        @CheckForNull
        public E lower(@ParametricNullness E r1) {
            return this.forward.higher(r1);
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        @CheckForNull
        public E floor(@ParametricNullness E r1) {
            return this.forward.ceiling(r1);
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        @CheckForNull
        public E ceiling(@ParametricNullness E r1) {
            return this.forward.floor(r1);
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        @CheckForNull
        public E higher(@ParametricNullness E r1) {
            return this.forward.lower(r1);
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        @CheckForNull
        public E pollFirst() {
            return this.forward.pollLast();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        @CheckForNull
        public E pollLast() {
            return this.forward.pollFirst();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            return this.forward;
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return this.forward.iterator();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public NavigableSet<E> subSet(@ParametricNullness E r1, boolean r2, @ParametricNullness E r3, boolean r4) {
            return this.forward.subSet(r3, r4, r1, r2).descendingSet();
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public SortedSet<E> subSet(@ParametricNullness E r1, @ParametricNullness E r2) {
            return standardSubSet(r1, r2);
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public NavigableSet<E> headSet(@ParametricNullness E r1, boolean r2) {
            return this.forward.tailSet(r1, r2).descendingSet();
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public SortedSet<E> headSet(@ParametricNullness E r1) {
            return standardHeadSet(r1);
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public NavigableSet<E> tailSet(@ParametricNullness E r1, boolean r2) {
            return this.forward.headSet(r1, r2).descendingSet();
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public SortedSet<E> tailSet(@ParametricNullness E r1) {
            return standardTailSet(r1);
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public Comparator<? super E> comparator() {
            Comparator<? super E> r0 = this.forward.comparator();
            if (r0 != null) goto L7;
            return Ordering.natural().reverse();
        L7:
            return reverse(r0);
        }

        private static <T> Ordering<T> reverse(Comparator<T> r0) {
            return Ordering.from(r0).reverse();
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        @ParametricNullness
        public E first() {
            return this.forward.last();
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        @ParametricNullness
        public E last() {
            return this.forward.first();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return this.forward.descendingIterator();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] r1) {
            return (T[]) standardToArray(r1);
        }

        @Override // com.google.common.collect.ForwardingObject
        public String toString() {
            return standardToString();
        }
    }

    private static class FilteredNavigableSet<E> extends FilteredSortedSet<E> implements NavigableSet<E> {
        FilteredNavigableSet(NavigableSet<E> r1, Predicate<? super E> r2) {
            super(r1, r2);
        }

        NavigableSet<E> unfiltered() {
            return (NavigableSet) this.unfiltered;
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E lower(@ParametricNullness E r3) {
            return (E) Iterators.find(unfiltered().headSet(r3, false).descendingIterator(), this.predicate, null);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E floor(@ParametricNullness E r3) {
            return (E) Iterators.find(unfiltered().headSet(r3, true).descendingIterator(), this.predicate, null);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E ceiling(@ParametricNullness E r3) {
            return (E) Iterables.find(unfiltered().tailSet(r3, true), this.predicate, null);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E higher(@ParametricNullness E r3) {
            return (E) Iterables.find(unfiltered().tailSet(r3, false), this.predicate, null);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E pollFirst() {
            return (E) Iterables.removeFirstMatching(unfiltered(), this.predicate);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E pollLast() {
            return (E) Iterables.removeFirstMatching(unfiltered().descendingSet(), this.predicate);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            return Sets.filter(unfiltered().descendingSet(), this.predicate);
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return Iterators.filter(unfiltered().descendingIterator(), this.predicate);
        }

        @Override // com.google.common.collect.Sets.FilteredSortedSet, java.util.SortedSet
        @ParametricNullness
        public E last() {
            return (E) Iterators.find(unfiltered().descendingIterator(), this.predicate);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(@ParametricNullness E r2, boolean r3, @ParametricNullness E r4, boolean r5) {
            return Sets.filter(unfiltered().subSet(r2, r3, r4, r5), this.predicate);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(@ParametricNullness E r2, boolean r3) {
            return Sets.filter(unfiltered().headSet(r2, r3), this.predicate);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(@ParametricNullness E r2, boolean r3) {
            return Sets.filter(unfiltered().tailSet(r2, r3), this.predicate);
        }
    }

    private static class FilteredSet<E> extends Collections2.FilteredCollection<E> implements Set<E> {
        FilteredSet(Set<E> r1, Predicate<? super E> r2) {
            super(r1, r2);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(@CheckForNull Object r1) {
            return Sets.equalsImpl(this, r1);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return Sets.hashCodeImpl(this);
        }
    }

    private static class FilteredSortedSet<E> extends FilteredSet<E> implements SortedSet<E> {
        FilteredSortedSet(SortedSet<E> r1, Predicate<? super E> r2) {
            super(r1, r2);
        }

        @Override // java.util.SortedSet
        @CheckForNull
        public Comparator<? super E> comparator() {
            return ((SortedSet) this.unfiltered).comparator();
        }

        @Override // java.util.SortedSet
        public SortedSet<E> subSet(@ParametricNullness E r3, @ParametricNullness E r4) {
            return new FilteredSortedSet(((SortedSet) this.unfiltered).subSet(r3, r4), this.predicate);
        }

        @Override // java.util.SortedSet
        public SortedSet<E> headSet(@ParametricNullness E r3) {
            return new FilteredSortedSet(((SortedSet) this.unfiltered).headSet(r3), this.predicate);
        }

        @Override // java.util.SortedSet
        public SortedSet<E> tailSet(@ParametricNullness E r3) {
            return new FilteredSortedSet(((SortedSet) this.unfiltered).tailSet(r3), this.predicate);
        }

        @Override // java.util.SortedSet
        @ParametricNullness
        public E first() {
            return (E) Iterators.find(this.unfiltered.iterator(), this.predicate);
        }

        @ParametricNullness
        public E last() {
            SortedSet r0 = (SortedSet) this.unfiltered;
        L3:
            E r1 = (Object) r0.last();
            if (this.predicate.apply(r1) == true) goto L5;
            r0 = r0.headSet(r1);
            goto L3
        L5:
            return r1;
        }
    }

    static abstract class ImprovedAbstractSet<E> extends AbstractSet<E> {
        ImprovedAbstractSet() {
        }

        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> r1) {
            return Sets.removeAllImpl(this, r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> r1) {
            return super.retainAll((Collection) Preconditions.checkNotNull(r1));
        }
    }

    private static final class PowerSet<E> extends AbstractSet<Set<E>> {
        final ImmutableMap<E, Integer> inputSet;

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return false;
        }

        PowerSet(Set<E> r4) {
            if (r4.size() > 30) goto L5;
            boolean r0 = true;
        L6:
            Preconditions.checkArgument(r0, "Too many elements to create power set: %s > 30", r4.size());
            this.inputSet = Maps.indexMap(r4);
            return;
        L5:
            r0 = false;
            goto L6
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return 1 << this.inputSet.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Set<E>> iterator() {
            final int r1 = size();
            return new AnonymousClass1(this, r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object r2) {
            if ((r2 instanceof Set) == false) goto L6;
            ImmutableSet<E> r1 = this.inputSet.keySet();
            return r1.containsAll((Set) r2);
        L6:
            return false;
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(@CheckForNull Object r2) {
            if ((r2 instanceof PowerSet) == false) goto L7;
            return this.inputSet.keySet().equals(((PowerSet) r2).inputSet.keySet());
        L7:
            return super.equals(r2);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return this.inputSet.keySet().hashCode() << (this.inputSet.size() - 1);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            String r2 = String.valueOf(this.inputSet);
            return new StringBuilder(String.valueOf(r2).length() + 10).append("powerSet(").append(r2).append(")").toString();
        }
    }

    public static abstract class SetView<E> extends AbstractSet<E> {
        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public abstract UnmodifiableIterator<E> iterator();

        /* synthetic */ SetView(AnonymousClass1 r1) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return iterator();
        }

        private SetView() {
        }

        public ImmutableSet<E> immutableCopy() {
            return ImmutableSet.copyOf(this);
        }

        public <S extends Set<E>> S copyInto(S r1) {
            r1.addAll(this);
            return r1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final boolean add(@ParametricNullness E r1) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final boolean remove(@CheckForNull Object r1) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final boolean addAll(Collection<? extends E> r1) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final boolean removeAll(Collection<?> r1) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        @Deprecated
        public final boolean removeIf(java.util.function.Predicate<? super E> r1) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final boolean retainAll(Collection<?> r1) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final void clear() {
            throw new UnsupportedOperationException();
        }
    }

    private static final class SubSet<E> extends AbstractSet<E> {
        private final ImmutableMap<E, Integer> inputSet;
        private final int mask;

        static /* synthetic */ ImmutableMap access$100(SubSet r0) {
            return r0.inputSet;
        }

        static /* synthetic */ int access$200(SubSet r0) {
            return r0.mask;
        }

        SubSet(ImmutableMap<E, Integer> r1, int r2) {
            this.inputSet = r1;
            this.mask = r2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return new AnonymousClass1(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Integer.bitCount(this.mask);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object r2) {
            Integer r3 = this.inputSet.get(r2);
            if (r3 != null) goto L5;
        L7:
            return false;
        L5:
            if ((this.mask & (1 << r3.intValue())) == 0) goto L7;
            return true;
        }
    }

    static final class UnmodifiableNavigableSet<E> extends ForwardingSortedSet<E> implements NavigableSet<E>, Serializable {
        private static final long serialVersionUID = 0;
        private final NavigableSet<E> delegate;

        @CheckForNull
        private transient UnmodifiableNavigableSet<E> descendingSet;
        private final SortedSet<E> unmodifiableDelegate;

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

        UnmodifiableNavigableSet(NavigableSet<E> r2) {
            this.delegate = (NavigableSet) Preconditions.checkNotNull(r2);
            this.unmodifiableDelegate = Collections.unmodifiableSortedSet(r2);
        }

        @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected SortedSet<E> delegate() {
            return this.unmodifiableDelegate;
        }

        @Override // java.util.Collection
        public boolean removeIf(java.util.function.Predicate<? super E> r1) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public Stream<E> stream() {
            return this.delegate.stream();
        }

        @Override // java.util.Collection
        public Stream<E> parallelStream() {
            return this.delegate.parallelStream();
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super E> r1) {
            this.delegate.forEach(r1);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E lower(@ParametricNullness E r1) {
            return this.delegate.lower(r1);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E floor(@ParametricNullness E r1) {
            return this.delegate.floor(r1);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E ceiling(@ParametricNullness E r1) {
            return this.delegate.ceiling(r1);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E higher(@ParametricNullness E r1) {
            return this.delegate.higher(r1);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E pollFirst() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E pollLast() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            UnmodifiableNavigableSet<E> r0 = this.descendingSet;
            if (r0 != null) goto L6;
            UnmodifiableNavigableSet<E> r1 = new UnmodifiableNavigableSet(this.delegate.descendingSet());
            this.descendingSet = r1;
            r1.descendingSet = this;
            return r1;
        L6:
            return r0;
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return Iterators.unmodifiableIterator(this.delegate.descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(@ParametricNullness E r1, boolean r2, @ParametricNullness E r3, boolean r4) {
            return Sets.unmodifiableNavigableSet(this.delegate.subSet(r1, r2, r3, r4));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(@ParametricNullness E r1, boolean r2) {
            return Sets.unmodifiableNavigableSet(this.delegate.headSet(r1, r2));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(@ParametricNullness E r1, boolean r2) {
            return Sets.unmodifiableNavigableSet(this.delegate.tailSet(r1, r2));
        }
    }

    private Sets() {
    }

    public static <E extends Enum<E>> ImmutableSet<E> immutableEnumSet(E r0, E... r1) {
        return ImmutableEnumSet.asImmutable(EnumSet.of(r0, r1));
    }

    public static <E extends Enum<E>> ImmutableSet<E> immutableEnumSet(Iterable<E> r1) {
        if ((r1 instanceof ImmutableEnumSet) == false) goto L7;
        return (ImmutableEnumSet) r1;
    L7:
        if ((r1 instanceof Collection) == false) goto L14;
        Collection r2 = (Collection) r1;
        if (r2.isEmpty() == false) goto L13;
        return ImmutableSet.of();
    L13:
        return ImmutableEnumSet.asImmutable(EnumSet.copyOf(r2));
    L14:
        Iterator<E> r3 = r1.iterator();
        if (r3.hasNext() == false) goto L19;
        EnumSet r0 = EnumSet.of(r3.next());
        Iterators.addAll(r0, r3);
        return ImmutableEnumSet.asImmutable(r0);
    L19:
        return ImmutableSet.of();
    }

    public static <E extends Enum<E>> Collector<E, ?, ImmutableSet<E>> toImmutableEnumSet() {
        return CollectCollectors.toImmutableEnumSet();
    }

    public static <E extends Enum<E>> EnumSet<E> newEnumSet(Iterable<E> r0, Class<E> r1) {
        EnumSet<E> r2 = EnumSet.noneOf(r1);
        Iterables.addAll(r2, r0);
        return r2;
    }

    public static <E> HashSet<E> newHashSet() {
        return new HashSet();
    }

    public static <E> HashSet<E> newHashSet(E... r1) {
        HashSet<E> r0 = newHashSetWithExpectedSize(r1.length);
        Collections.addAll(r0, r1);
        return r0;
    }

    public static <E> HashSet<E> newHashSet(Iterable<? extends E> r1) {
        if ((r1 instanceof Collection) == false) goto L6;
        return new HashSet((Collection) r1);
    L6:
        return newHashSet(r1.iterator());
    }

    public static <E> HashSet<E> newHashSet(Iterator<? extends E> r1) {
        HashSet<E> r0 = newHashSet();
        Iterators.addAll(r0, r1);
        return r0;
    }

    public static <E> HashSet<E> newHashSetWithExpectedSize(int r1) {
        return new HashSet(Maps.capacity(r1));
    }

    public static <E> Set<E> newConcurrentHashSet() {
        return Platform.newConcurrentHashSet();
    }

    public static <E> Set<E> newConcurrentHashSet(Iterable<? extends E> r1) {
        Set<E> r0 = newConcurrentHashSet();
        Iterables.addAll(r0, r1);
        return r0;
    }

    public static <E> LinkedHashSet<E> newLinkedHashSet() {
        return new LinkedHashSet();
    }

    public static <E> LinkedHashSet<E> newLinkedHashSet(Iterable<? extends E> r1) {
        if ((r1 instanceof Collection) == true) goto L5;
        LinkedHashSet<E> r0 = newLinkedHashSet();
        Iterables.addAll(r0, r1);
        return r0;
    L5:
        return new LinkedHashSet((Collection) r1);
    }

    public static <E> LinkedHashSet<E> newLinkedHashSetWithExpectedSize(int r1) {
        return new LinkedHashSet(Maps.capacity(r1));
    }

    public static <E extends Comparable> TreeSet<E> newTreeSet() {
        return new TreeSet();
    }

    public static <E extends Comparable> TreeSet<E> newTreeSet(Iterable<? extends E> r1) {
        TreeSet<E> r0 = newTreeSet();
        Iterables.addAll(r0, r1);
        return r0;
    }

    public static <E> TreeSet<E> newTreeSet(Comparator<? super E> r1) {
        return new TreeSet((Comparator) Preconditions.checkNotNull(r1));
    }

    public static <E> Set<E> newIdentityHashSet() {
        return Collections.newSetFromMap(Maps.newIdentityHashMap());
    }

    public static <E> CopyOnWriteArraySet<E> newCopyOnWriteArraySet() {
        return new CopyOnWriteArraySet();
    }

    public static <E> CopyOnWriteArraySet<E> newCopyOnWriteArraySet(Iterable<? extends E> r1) {
        if ((r1 instanceof Collection) == false) goto L5;
        Collection r2 = (Collection) r1;
    L7:
        return new CopyOnWriteArraySet(r2);
    L5:
        r2 = Lists.newArrayList(r1);
        goto L7
    }

    public static <E extends Enum<E>> EnumSet<E> complementOf(Collection<E> r2) {
        if ((r2 instanceof EnumSet) == true) goto L5;
        Preconditions.checkArgument(!r2.isEmpty(), "collection is empty; use the other version of this method");
        return makeComplementByHand(r2, r2.iterator().next().getDeclaringClass());
    L5:
        return EnumSet.complementOf((EnumSet) r2);
    }

    public static <E extends Enum<E>> EnumSet<E> complementOf(Collection<E> r1, Class<E> r2) {
        Preconditions.checkNotNull(r1);
        if ((r1 instanceof EnumSet) == false) goto L6;
        return EnumSet.complementOf((EnumSet) r1);
    L6:
        return makeComplementByHand(r1, r2);
    }

    private static <E extends Enum<E>> EnumSet<E> makeComplementByHand(Collection<E> r0, Class<E> r1) {
        EnumSet<E> r2 = EnumSet.allOf(r1);
        r2.removeAll(r0);
        return r2;
    }

    @Deprecated
    public static <E> Set<E> newSetFromMap(Map<E, Boolean> r0) {
        return Collections.newSetFromMap(r0);
    }

    public static <E> SetView<E> union(Set<? extends E> r1, Set<? extends E> r2) {
        Preconditions.checkNotNull(r1, "set1");
        Preconditions.checkNotNull(r2, "set2");
        return new AnonymousClass1(r1, r2);
    }

    public static <E> SetView<E> intersection(final Set<E> r1, final Set<?> r2) {
        Preconditions.checkNotNull(r1, "set1");
        Preconditions.checkNotNull(r2, "set2");
        return new AnonymousClass2(r1, r2);
    }

    public static <E> SetView<E> difference(Set<E> r1, Set<?> r2) {
        Preconditions.checkNotNull(r1, "set1");
        Preconditions.checkNotNull(r2, "set2");
        return new AnonymousClass3(r1, r2);
    }

    public static <E> SetView<E> symmetricDifference(final Set<? extends E> r1, final Set<? extends E> r2) {
        Preconditions.checkNotNull(r1, "set1");
        Preconditions.checkNotNull(r2, "set2");
        return new AnonymousClass4(r1, r2);
    }

    public static <E> Set<E> filter(Set<E> r1, Predicate<? super E> r2) {
        if ((r1 instanceof SortedSet) == false) goto L7;
        return filter((SortedSet) r1, r2);
    L7:
        if ((r1 instanceof FilteredSet) == false) goto L11;
        FilteredSet r3 = (FilteredSet) r1;
        Predicate r4 = Predicates.and(r3.predicate, r2);
        return new FilteredSet((Set) r3.unfiltered, r4);
    L11:
        return new FilteredSet((Set) Preconditions.checkNotNull(r1), (Predicate) Preconditions.checkNotNull(r2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> SortedSet<E> filter(SortedSet<E> r1, Predicate<? super E> r2) {
        if ((r1 instanceof FilteredSet) == false) goto L7;
        FilteredSet r3 = (FilteredSet) r1;
        Predicate r4 = Predicates.and(r3.predicate, r2);
        return new FilteredSortedSet((SortedSet) r3.unfiltered, r4);
    L7:
        return new FilteredSortedSet((SortedSet) Preconditions.checkNotNull(r1), (Predicate) Preconditions.checkNotNull(r2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> NavigableSet<E> filter(NavigableSet<E> r1, Predicate<? super E> r2) {
        if ((r1 instanceof FilteredSet) == false) goto L7;
        FilteredSet r3 = (FilteredSet) r1;
        Predicate r4 = Predicates.and(r3.predicate, r2);
        return new FilteredNavigableSet((NavigableSet) r3.unfiltered, r4);
    L7:
        return new FilteredNavigableSet((NavigableSet) Preconditions.checkNotNull(r1), (Predicate) Preconditions.checkNotNull(r2));
    }

    public static <B> Set<List<B>> cartesianProduct(List<? extends Set<? extends B>> r0) {
        return CartesianSet.create(r0);
    }

    @SafeVarargs
    public static <B> Set<List<B>> cartesianProduct(Set<? extends B>... r0) {
        return cartesianProduct(Arrays.asList(r0));
    }

    public static <E> Set<Set<E>> powerSet(Set<E> r1) {
        return new PowerSet(r1);
    }

    public static <E> Set<Set<E>> combinations(Set<E> r3, int r4) {
        ImmutableMap r5 = Maps.indexMap(r3);
        CollectPreconditions.checkNonnegative(r4, PerfConsts.PERF_DISK_FILE_SIZE);
        if (r4 > r5.size()) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "size (%s) must be <= set.size() (%s)", r4, r5.size());
        if (r4 != 0) goto L11;
        return ImmutableSet.of(ImmutableSet.of());
    L11:
        if (r4 != r5.size()) goto L15;
        return ImmutableSet.of(r5.keySet());
    L15:
        return new AnonymousClass5(r4, r5);
    L5:
        r0 = false;
        goto L6
    }

    static int hashCodeImpl(Set<?> r3) {
        Iterator<?> r4 = r3.iterator();
        int r1 = 0;
    L4:
        if (r4.hasNext() == false) goto L10;
        Object r2 = r4.next();
        if (r2 == null) goto L8;
        int r5 = r2.hashCode();
    L9:
        r1 = ~(~(r1 + r5));
        goto L4
    L8:
        r5 = 0;
        goto L9
    L10:
        return r1;
    }

    static boolean equalsImpl(Set<?> r4, @CheckForNull Object r5) {
        if (r4 != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Set) == false) goto L15;
        Set r6 = (Set) r5;
        if (r4.size() != r6.size()) goto L14;
        if (r4.containsAll(r6) == false) goto L14;
        return true;
    L14:
        return false;
    L15:
        return false;
    }

    public static <E> NavigableSet<E> unmodifiableNavigableSet(NavigableSet<E> r1) {
        if ((r1 instanceof ImmutableCollection) == false) goto L5;
    L9:
        return r1;
    L5:
        if ((r1 instanceof UnmodifiableNavigableSet) == true) goto L9;
        return new UnmodifiableNavigableSet(r1);
    }

    public static <E> NavigableSet<E> synchronizedNavigableSet(NavigableSet<E> r0) {
        return Synchronized.navigableSet(r0);
    }

    static boolean removeAllImpl(Set<?> r2, Iterator<?> r3) {
        boolean r0 = false;
    L4:
        if (r3.hasNext() == false) goto L6;
        r0 = r0 | r2.remove(r3.next());
        goto L4
    L6:
        return r0;
    }

    static boolean removeAllImpl(Set<?> r2, Collection<?> r3) {
        Preconditions.checkNotNull(r3);
        if ((r3 instanceof Multiset) == false) goto L6;
        r3 = ((Multiset) r3).elementSet();
    L6:
        if ((r3 instanceof Set) == false) goto L12;
        if (r3.size() <= r2.size()) goto L12;
        return Iterators.removeAll(r2.iterator(), r3);
    L12:
        return removeAllImpl(r2, r3.iterator());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K extends Comparable<? super K>> NavigableSet<K> subSet(NavigableSet<K> r6, Range<K> r7) {
        boolean r1 = true;
        if (r6.comparator() == null) goto L16;
        if (r6.comparator() == Ordering.natural()) goto L16;
        if (r7.hasLowerBound() == false) goto L16;
        if (r7.hasUpperBound() == false) goto L16;
        if (r6.comparator().compare(r7.lowerEndpoint(), r7.upperEndpoint()) > 0) goto L13;
        boolean r0 = true;
    L14:
        Preconditions.checkArgument(r0, "set is using a custom comparator which is inconsistent with the natural ordering.");
        goto L16
    L13:
        r0 = false;
    L16:
        if (r7.hasLowerBound() == false) goto L30;
        if (r7.hasUpperBound() == false) goto L30;
        Comparable r2 = r7.lowerEndpoint();
        if (r7.lowerBoundType() != BoundType.CLOSED) goto L22;
        boolean r3 = true;
    L23:
        Comparable r4 = r7.upperEndpoint();
        if (r7.upperBoundType() == BoundType.CLOSED) goto L28;
        r1 = false;
    L28:
        return r6.subSet(r2, r3, r4, r1);
    L22:
        r3 = false;
    L30:
        if (r7.hasLowerBound() == false) goto L38;
        Comparable r5 = r7.lowerEndpoint();
        if (r7.lowerBoundType() == BoundType.CLOSED) goto L36;
        r1 = false;
    L36:
        return r6.tailSet(r5, r1);
    L38:
        if (r7.hasUpperBound() == false) goto L46;
        Comparable r8 = r7.upperEndpoint();
        if (r7.upperBoundType() == BoundType.CLOSED) goto L44;
        r1 = false;
    L44:
        return r6.headSet(r8, r1);
    L46:
        return (NavigableSet) Preconditions.checkNotNull(r6);
    }
}
