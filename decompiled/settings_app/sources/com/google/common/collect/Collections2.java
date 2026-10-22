package com.google.common.collect;

import com.bytedance.apm.constant.PerfConsts;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.math.IntMath;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;
import javax.annotation.CheckForNull;
import org.apache.commons.io.FileUtils;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class Collections2 {

    static class FilteredCollection<E> extends AbstractCollection<E> {
        final Predicate<? super E> predicate;
        final Collection<E> unfiltered;

        FilteredCollection(Collection<E> r1, Predicate<? super E> r2) {
            this.unfiltered = r1;
            this.predicate = r2;
        }

        FilteredCollection<E> createCombined(Predicate<? super E> r3) {
            return new FilteredCollection(this.unfiltered, Predicates.and(this.predicate, r3));
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(@ParametricNullness E r2) {
            Preconditions.checkArgument(this.predicate.apply(r2));
            return this.unfiltered.add(r2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends E> r4) {
            Iterator<? extends E> r0 = r4.iterator();
        L4:
            if (r0.hasNext() == false) goto L7;
            E r1 = r0.next();
            Preconditions.checkArgument(this.predicate.apply(r1));
            goto L4
        L7:
            return this.unfiltered.addAll(r4);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            Iterables.removeIf(this.unfiltered, this.predicate);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@CheckForNull Object r2) {
            if (Collections2.safeContains(this.unfiltered, r2) == true) goto L5;
            return false;
        L5:
            return this.predicate.apply(r2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> r1) {
            return Collections2.containsAllImpl(this, r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return !Iterables.any(this.unfiltered, this.predicate);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<E> iterator() {
            return Iterators.filter(this.unfiltered.iterator(), this.predicate);
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<E> spliterator() {
            return CollectSpliterators.filter(this.unfiltered.spliterator(), this.predicate);
        }

        @Override // java.lang.Iterable
        public void forEach(final Consumer<? super E> r3) {
            Preconditions.checkNotNull(r3);
            this.unfiltered.forEach(new Collections2$FilteredCollection$$ExternalSyntheticLambda2(this, r3));
        }

        /* JADX INFO: renamed from: lambda$forEach$0$com-google-common-collect-Collections2$FilteredCollection, reason: not valid java name */
        /* synthetic */ void m898xea94214(Consumer r1, Object r2) {
            if (this.predicate.test(r2) == false) goto L6;
            r1.accept(r2);
            return;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(@CheckForNull Object r2) {
            if (contains(r2) == true) goto L5;
        L7:
            return false;
        L5:
            if (this.unfiltered.remove(r2) == false) goto L7;
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(final Collection<?> r2) {
            Objects.requireNonNull(r2);
            return removeIf(new Collections2$FilteredCollection$$ExternalSyntheticLambda0(r2));
        }

        static /* synthetic */ boolean lambda$retainAll$1(Collection r0, Object r1) {
            return !r0.contains(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(final Collection<?> r2) {
            return removeIf(new Collections2$FilteredCollection$$ExternalSyntheticLambda1(r2));
        }

        @Override // java.util.Collection
        public boolean removeIf(final java.util.function.Predicate<? super E> r3) {
            Preconditions.checkNotNull(r3);
            return this.unfiltered.removeIf(new Collections2$FilteredCollection$$ExternalSyntheticLambda3(this, r3));
        }

        /* JADX INFO: renamed from: lambda$removeIf$2$com-google-common-collect-Collections2$FilteredCollection, reason: not valid java name */
        /* synthetic */ boolean m899xbd057a87(java.util.function.Predicate r1, Object r2) {
            if (this.predicate.apply(r2) == true) goto L5;
        L7:
            return false;
        L5:
            if (r1.test(r2) == false) goto L7;
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            Iterator<E> r0 = this.unfiltered.iterator();
            int r1 = 0;
        L4:
            if (r0.hasNext() == false) goto L8;
            E r2 = r0.next();
            if (this.predicate.apply(r2) == false) goto L4;
            r1 = r1 + 1;
            goto L4
        L8:
            return r1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return Lists.newArrayList(iterator()).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] r1) {
            return (T[]) Lists.newArrayList(iterator()).toArray(r1);
        }
    }

    private static final class OrderedPermutationCollection<E> extends AbstractCollection<List<E>> {
        final Comparator<? super E> comparator;
        final ImmutableList<E> inputList;
        final int size;

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        OrderedPermutationCollection(Iterable<E> r1, Comparator<? super E> r2) {
            ImmutableList<E> r3 = ImmutableList.sortedCopyOf(r2, r1);
            this.inputList = r3;
            this.comparator = r2;
            this.size = calculateSize(r3, r2);
        }

        private static <E> int calculateSize(List<E> r6, Comparator<? super E> r7) {
            int r1 = 1;
            int r2 = 1;
            int r3 = 1;
        L4:
            if (r1 >= r6.size()) goto L13;
            if (r7.compare(r6.get(r1 - 1), r6.get(r1)) >= 0) goto L11;
            r2 = IntMath.saturatedMultiply(r2, IntMath.binomial(r1, r3));
            if (r2 == Integer.MAX_VALUE) goto L9;
            r3 = 0;
            goto L11
        L9:
            return Integer.MAX_VALUE;
        L11:
            r1 = r1 + 1;
            r3 = r3 + 1;
            goto L4
        L13:
            return IntMath.saturatedMultiply(r2, IntMath.binomial(r1, r3));
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<List<E>> iterator() {
            return new OrderedPermutationIterator(this.inputList, this.comparator);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@CheckForNull Object r2) {
            if ((r2 instanceof List) == false) goto L6;
            ImmutableList<E> r1 = this.inputList;
            return Collections2.access$000(r1, (List) r2);
        L6:
            return false;
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            String r2 = String.valueOf(this.inputList);
            return new StringBuilder(String.valueOf(r2).length() + 30).append("orderedPermutationCollection(").append(r2).append(")").toString();
        }
    }

    private static final class OrderedPermutationIterator<E> extends AbstractIterator<List<E>> {
        final Comparator<? super E> comparator;

        @CheckForNull
        List<E> nextPermutation;

        @Override // com.google.common.collect.AbstractIterator
        @CheckForNull
        protected /* bridge */ /* synthetic */ Object computeNext() {
            return computeNext();
        }

        OrderedPermutationIterator(List<E> r1, Comparator<? super E> r2) {
            this.nextPermutation = Lists.newArrayList(r1);
            this.comparator = r2;
        }

        @Override // com.google.common.collect.AbstractIterator
        @CheckForNull
        protected List<E> computeNext() {
            List<E> r0 = this.nextPermutation;
            if (r0 == null) goto L5;
            ImmutableList r1 = ImmutableList.copyOf(r0);
            calculateNextPermutation();
            return r1;
        L5:
            return endOfData();
        }

        void calculateNextPermutation() {
            int r0 = findNextJ();
            if (r0 != (-1)) goto L6;
            this.nextPermutation = null;
            return;
        L6:
            Objects.requireNonNull(this.nextPermutation);
            int r1 = findNextL(r0);
            Collections.swap(this.nextPermutation, r0, r1);
            int r2 = this.nextPermutation.size();
            Collections.reverse(this.nextPermutation.subList(r0 + 1, r2));
        }

        int findNextJ() {
            Objects.requireNonNull(this.nextPermutation);
            int r0 = this.nextPermutation.size() - 2;
        L3:
            if (r0 < 0) goto L8;
            if (this.comparator.compare(this.nextPermutation.get(r0), this.nextPermutation.get(r0 + 1)) < 0) goto L6;
            r0 = r0 - 1;
            goto L3
        L6:
            return r0;
        L8:
            return -1;
        }

        int findNextL(int r5) {
            Objects.requireNonNull(this.nextPermutation);
            E r0 = this.nextPermutation.get(r5);
            int r1 = this.nextPermutation.size() - 1;
        L3:
            if (r1 <= r5) goto L9;
            if (this.comparator.compare(r0, this.nextPermutation.get(r1)) < 0) goto L6;
            r1 = r1 - 1;
            goto L3
        L6:
            return r1;
        L9:
            throw new AssertionError("this statement should be unreachable");
        }
    }

    private static final class PermutationCollection<E> extends AbstractCollection<List<E>> {
        final ImmutableList<E> inputList;

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        PermutationCollection(ImmutableList<E> r1) {
            this.inputList = r1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return IntMath.factorial(this.inputList.size());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<List<E>> iterator() {
            return new PermutationIterator(this.inputList);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@CheckForNull Object r2) {
            if ((r2 instanceof List) == false) goto L6;
            ImmutableList<E> r1 = this.inputList;
            return Collections2.access$000(r1, (List) r2);
        L6:
            return false;
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            String r2 = String.valueOf(this.inputList);
            return new StringBuilder(String.valueOf(r2).length() + 14).append("permutations(").append(r2).append(")").toString();
        }
    }

    private static class PermutationIterator<E> extends AbstractIterator<List<E>> {
        final int[] c;
        int j;
        final List<E> list;
        final int[] o;

        @Override // com.google.common.collect.AbstractIterator
        @CheckForNull
        protected /* bridge */ /* synthetic */ Object computeNext() {
            return computeNext();
        }

        PermutationIterator(List<E> r3) {
            this.list = new ArrayList(r3);
            int r4 = r3.size();
            int[] r0 = new int[r4];
            this.c = r0;
            int[] r5 = new int[r4];
            this.o = r5;
            Arrays.fill(r0, 0);
            Arrays.fill(r5, 1);
            this.j = Integer.MAX_VALUE;
        }

        @Override // com.google.common.collect.AbstractIterator
        @CheckForNull
        protected List<E> computeNext() {
            if (this.j <= 0) goto L5;
            ImmutableList r0 = ImmutableList.copyOf(this.list);
            calculateNextPermutation();
            return r0;
        L5:
            return endOfData();
        }

        void calculateNextPermutation() {
            int r0 = this.list.size() - 1;
            this.j = r0;
            if (r0 != (-1)) goto L5;
            return;
        L5:
            int r1 = 0;
        L6:
            int[] r2 = this.c;
            int r3 = this.j;
            int r4 = r2[r3];
            int r5 = this.o[r3] + r4;
            if (r5 < 0) goto L8;
            if (r5 != (r3 + 1)) goto L14;
            if (r3 == 0) goto L23;
            r1 = r1 + 1;
            switchDirection();
            goto L6
        L23:
            return;
        L14:
            Collections.swap(this.list, (r3 - r4) + r1, (r3 - r5) + r1);
            this.c[this.j] = r5;
            return;
        L8:
            switchDirection();
            goto L6
        }

        void switchDirection() {
            int[] r0 = this.o;
            int r1 = this.j;
            r0[r1] = -r0[r1];
            this.j = r1 - 1;
        }
    }

    static class TransformedCollection<F, T> extends AbstractCollection<T> {
        final Collection<F> fromCollection;
        final Function<? super F, ? extends T> function;

        TransformedCollection(Collection<F> r1, Function<? super F, ? extends T> r2) {
            this.fromCollection = (Collection) Preconditions.checkNotNull(r1);
            this.function = (Function) Preconditions.checkNotNull(r2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.fromCollection.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.fromCollection.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.transform(this.fromCollection.iterator(), this.function);
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<T> spliterator() {
            return CollectSpliterators.map(this.fromCollection.spliterator(), this.function);
        }

        @Override // java.lang.Iterable
        public void forEach(final Consumer<? super T> r3) {
            Preconditions.checkNotNull(r3);
            this.fromCollection.forEach(new Collections2$TransformedCollection$$ExternalSyntheticLambda1(this, r3));
        }

        /* JADX INFO: renamed from: lambda$forEach$0$com-google-common-collect-Collections2$TransformedCollection, reason: not valid java name */
        /* synthetic */ void m900x9cac3aa(Consumer r1, Object r2) {
            r1.accept(this.function.apply(r2));
        }

        @Override // java.util.Collection
        public boolean removeIf(final java.util.function.Predicate<? super T> r3) {
            Preconditions.checkNotNull(r3);
            return this.fromCollection.removeIf(new Collections2$TransformedCollection$$ExternalSyntheticLambda0(this, r3));
        }

        /* JADX INFO: renamed from: lambda$removeIf$1$com-google-common-collect-Collections2$TransformedCollection, reason: not valid java name */
        /* synthetic */ boolean m901xf35962b8(java.util.function.Predicate r1, Object r2) {
            return r1.test(this.function.apply(r2));
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.fromCollection.size();
        }
    }

    static /* synthetic */ boolean access$000(List r0, List r1) {
        return isPermutation(r0, r1);
    }

    private Collections2() {
    }

    public static <E> Collection<E> filter(Collection<E> r1, Predicate<? super E> r2) {
        if ((r1 instanceof FilteredCollection) == false) goto L7;
        return ((FilteredCollection) r1).createCombined(r2);
    L7:
        return new FilteredCollection((Collection) Preconditions.checkNotNull(r1), (Predicate) Preconditions.checkNotNull(r2));
    }

    static boolean safeContains(Collection<?> r0, @CheckForNull Object r1) {
        Preconditions.checkNotNull(r0);
        return r0.contains(r1);
    L5:
        return false;
    }

    static boolean safeRemove(Collection<?> r0, @CheckForNull Object r1) {
        Preconditions.checkNotNull(r0);
        return r0.remove(r1);
    L5:
        return false;
    }

    public static <F, T> Collection<T> transform(Collection<F> r1, Function<? super F, T> r2) {
        return new TransformedCollection(r1, r2);
    }

    static boolean containsAllImpl(Collection<?> r1, Collection<?> r2) {
        Iterator<?> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        if (r1.contains(r3.next()) == true) goto L4;
        return false;
    L9:
        return true;
    }

    static String toStringImpl(Collection<?> r4) {
        StringBuilder r0 = newStringBuilderForCollection(r4.size()).append('[');
        Iterator<?> r1 = r4.iterator();
        boolean r2 = true;
    L4:
        if (r1.hasNext() == false) goto L13;
        Object r3 = r1.next();
        if (r2 == true) goto L8;
        r0.append(", ");
    L8:
        if (r3 != r4) goto L10;
        r0.append("(this Collection)");
    L11:
        r2 = false;
        goto L4
    L10:
        r0.append(r3);
        goto L11
    L13:
        return r0.append(']').toString();
    }

    static StringBuilder newStringBuilderForCollection(int r5) {
        CollectPreconditions.checkNonnegative(r5, PerfConsts.PERF_DISK_FILE_SIZE);
        return new StringBuilder((int) Math.min(((long) r5) * 8, FileUtils.ONE_GB));
    }

    public static <E extends Comparable<? super E>> Collection<List<E>> orderedPermutations(Iterable<E> r1) {
        return orderedPermutations(r1, Ordering.natural());
    }

    public static <E> Collection<List<E>> orderedPermutations(Iterable<E> r1, Comparator<? super E> r2) {
        return new OrderedPermutationCollection(r1, r2);
    }

    public static <E> Collection<List<E>> permutations(Collection<E> r1) {
        return new PermutationCollection(ImmutableList.copyOf(r1));
    }

    private static boolean isPermutation(List<?> r2, List<?> r3) {
        if (r2.size() == r3.size()) goto L7;
        return false;
    L7:
        return HashMultiset.create(r2).equals(HashMultiset.create(r3));
    }
}
