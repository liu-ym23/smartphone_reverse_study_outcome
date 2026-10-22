package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.primitives.Ints;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class Iterators {

    private static final class ArrayItr<T> extends AbstractIndexedListIterator<T> {
        static final UnmodifiableListIterator<Object> EMPTY = null;
        private final T[] array;
        private final int offset;

        static {
            EMPTY = new ArrayItr(new Object[0], 0, 0, 0);
        }

        ArrayItr(T[] r1, int r2, int r3, int r4) {
            super(r3, r4);
            this.array = r1;
            this.offset = r2;
        }

        @Override // com.google.common.collect.AbstractIndexedListIterator
        @ParametricNullness
        protected T get(int r2) {
            return this.array[this.offset + r2];
        }
    }

    private static class ConcatenatedIterator<T> implements Iterator<T> {
        private Iterator<? extends T> iterator;

        @CheckForNull
        private Deque<Iterator<? extends Iterator<? extends T>>> metaIterators;

        @CheckForNull
        private Iterator<? extends T> toRemove;

        @CheckForNull
        private Iterator<? extends Iterator<? extends T>> topMetaIterator;

        ConcatenatedIterator(Iterator<? extends Iterator<? extends T>> r2) {
            this.iterator = Iterators.emptyIterator();
            this.topMetaIterator = (Iterator) Preconditions.checkNotNull(r2);
        }

        @CheckForNull
        private Iterator<? extends Iterator<? extends T>> getTopMetaIterator() {
        L2:
            Iterator<? extends Iterator<? extends T>> r0 = this.topMetaIterator;
            if (r0 != null) goto L5;
        L9:
            Deque<Iterator<? extends Iterator<? extends T>>> r1 = this.metaIterators;
            if (r1 == null) goto L14;
            if (r1.isEmpty() == true) goto L19;
            this.topMetaIterator = this.metaIterators.removeFirst();
            goto L2
        L19:
            return null;
        L14:
            return null;
        L5:
            if (r0.hasNext() == false) goto L9;
            return this.topMetaIterator;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
        L3:
            if (((Iterator) Preconditions.checkNotNull(this.iterator)).hasNext() == true) goto L19;
            Iterator<? extends Iterator<? extends T>> r0 = getTopMetaIterator();
            this.topMetaIterator = r0;
            if (r0 == null) goto L6;
            Iterator<? extends T> r1 = r0.next();
            this.iterator = r1;
            if ((r1 instanceof ConcatenatedIterator) == false) goto L3;
            ConcatenatedIterator r2 = (ConcatenatedIterator) r1;
            this.iterator = r2.iterator;
            if (this.metaIterators != null) goto L13;
            this.metaIterators = new ArrayDeque();
        L13:
            this.metaIterators.addFirst(this.topMetaIterator);
            if (r2.metaIterators != null) goto L16;
        L18:
            this.topMetaIterator = r2.topMetaIterator;
        L16:
            if (r2.metaIterators.isEmpty() == true) goto L18;
            this.metaIterators.addFirst(r2.metaIterators.removeLast());
            goto L16
        L6:
            return false;
        L19:
            return true;
        }

        @Override // java.util.Iterator
        @ParametricNullness
        public T next() {
            if (hasNext() == false) goto L7;
            Iterator<? extends T> r0 = this.iterator;
            this.toRemove = r0;
            return r0.next();
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            Iterator<? extends T> r0 = this.toRemove;
            if (r0 == null) goto L7;
            r0.remove();
            this.toRemove = null;
            return;
        L7:
            throw new IllegalStateException("no calls to next() since the last call to remove()");
        }
    }

    private static final enum EmptyModifiableIterator extends Enum<EmptyModifiableIterator> implements Iterator<Object> {
        private static final /* synthetic */ EmptyModifiableIterator[] $VALUES = null;
        public static final EmptyModifiableIterator INSTANCE = null;

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        private static /* synthetic */ EmptyModifiableIterator[] $values() {
            return new EmptyModifiableIterator[]{INSTANCE};
        }

        private EmptyModifiableIterator(String r1, int r2) {
            super(r1, r2);
        }

        public static EmptyModifiableIterator valueOf(String r1) {
            return (EmptyModifiableIterator) Enum.valueOf(EmptyModifiableIterator.class, r1);
        }

        public static EmptyModifiableIterator[] values() {
            return (EmptyModifiableIterator[]) $VALUES.clone();
        }

        static {
            INSTANCE = new EmptyModifiableIterator("INSTANCE", 0);
            $VALUES = $values();
        }

        @Override // java.util.Iterator
        public Object next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            CollectPreconditions.checkRemove(false);
        }
    }

    private static class MergingIterator<T> extends UnmodifiableIterator<T> {
        final Queue<PeekingIterator<T>> queue;

        public MergingIterator(Iterable<? extends Iterator<? extends T>> r3, final Comparator<? super T> r4) {
            this.queue = new PriorityQueue(2, new AnonymousClass1(this, r4));
            Iterator<? extends Iterator<? extends T>> r5 = r3.iterator();
        L4:
            if (r5.hasNext() == false) goto L8;
            Iterator<? extends T> r6 = r5.next();
            if (r6.hasNext() == false) goto L4;
            this.queue.add(Iterators.peekingIterator(r6));
            goto L4
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.queue.isEmpty();
        }

        @Override // java.util.Iterator
        @ParametricNullness
        public T next() {
            PeekingIterator<T> r0 = this.queue.remove();
            T r1 = r0.next();
            if (r0.hasNext() == false) goto L5;
            this.queue.add(r0);
        L5:
            return r1;
        }
    }

    private static class PeekingImpl<E> implements PeekingIterator<E> {
        private boolean hasPeeked;
        private final Iterator<? extends E> iterator;

        @CheckForNull
        private E peekedElement;

        public PeekingImpl(Iterator<? extends E> r1) {
            this.iterator = (Iterator) Preconditions.checkNotNull(r1);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.hasPeeked == false) goto L5;
        L8:
            return true;
        L5:
            if (this.iterator.hasNext() == true) goto L8;
            return false;
        }

        @Override // com.google.common.collect.PeekingIterator, java.util.Iterator
        @ParametricNullness
        public E next() {
            if (this.hasPeeked == false) goto L5;
            E r0 = (E) NullnessCasts.uncheckedCastNullableTToT(this.peekedElement);
            this.hasPeeked = false;
            this.peekedElement = null;
            return r0;
        L5:
            return this.iterator.next();
        }

        @Override // com.google.common.collect.PeekingIterator, java.util.Iterator
        public void remove() {
            Preconditions.checkState(!this.hasPeeked, "Can't remove after you've peeked at next");
            this.iterator.remove();
        }

        @Override // com.google.common.collect.PeekingIterator
        @ParametricNullness
        public E peek() {
            if (this.hasPeeked == true) goto L6;
            this.peekedElement = this.iterator.next();
            this.hasPeeked = true;
        L6:
            return (E) NullnessCasts.uncheckedCastNullableTToT(this.peekedElement);
        }
    }

    private Iterators() {
    }

    static <T> UnmodifiableIterator<T> emptyIterator() {
        return emptyListIterator();
    }

    static <T> UnmodifiableListIterator<T> emptyListIterator() {
        return (UnmodifiableListIterator<T>) ArrayItr.EMPTY;
    }

    static <T> Iterator<T> emptyModifiableIterator() {
        return EmptyModifiableIterator.INSTANCE;
    }

    public static <T> UnmodifiableIterator<T> unmodifiableIterator(final Iterator<? extends T> r1) {
        Preconditions.checkNotNull(r1);
        if ((r1 instanceof UnmodifiableIterator) == false) goto L7;
        return (UnmodifiableIterator) r1;
    L7:
        return new AnonymousClass1(r1);
    }

    @Deprecated
    public static <T> UnmodifiableIterator<T> unmodifiableIterator(UnmodifiableIterator<T> r0) {
        return (UnmodifiableIterator) Preconditions.checkNotNull(r0);
    }

    public static int size(Iterator<?> r4) {
        long r0 = 0;
    L4:
        if (r4.hasNext() == false) goto L7;
        r4.next();
        r0 = r0 + 1;
        goto L4
    L7:
        return Ints.saturatedCast(r0);
    }

    public static boolean contains(Iterator<?> r2, @CheckForNull Object r3) {
        if (r3 != null) goto L10;
    L5:
        if (r2.hasNext() == false) goto L14;
        if (r2.next() != null) goto L5;
        return true;
    L14:
        return false;
    L10:
        if (r2.hasNext() == false) goto L22;
        if (r3.equals(r2.next()) == false) goto L10;
        return true;
    L22:
        return false;
    }

    public static boolean removeAll(Iterator<?> r2, Collection<?> r3) {
        Preconditions.checkNotNull(r3);
        boolean r0 = false;
    L4:
        if (r2.hasNext() == false) goto L8;
        if (r3.contains(r2.next()) == false) goto L4;
        r2.remove();
        r0 = true;
        goto L4
    L8:
        return r0;
    }

    public static <T> boolean removeIf(Iterator<T> r2, Predicate<? super T> r3) {
        Preconditions.checkNotNull(r3);
        boolean r0 = false;
    L4:
        if (r2.hasNext() == false) goto L8;
        if (r3.apply(r2.next()) == false) goto L4;
        r2.remove();
        r0 = true;
        goto L4
    L8:
        return r0;
    }

    public static boolean retainAll(Iterator<?> r2, Collection<?> r3) {
        Preconditions.checkNotNull(r3);
        boolean r0 = false;
    L4:
        if (r2.hasNext() == false) goto L8;
        if (r3.contains(r2.next()) == true) goto L4;
        r2.remove();
        r0 = true;
        goto L4
    L8:
        return r0;
    }

    public static boolean elementsEqual(Iterator<?> r3, Iterator<?> r4) {
    L3:
        if (r3.hasNext() == false) goto L11;
        if (r4.hasNext() == false) goto L6;
        if (Objects.equal(r3.next(), r4.next()) == true) goto L3;
        return false;
    L6:
        return false;
    L11:
        return !r4.hasNext();
    }

    public static String toString(Iterator<?> r3) {
        StringBuilder r0 = new StringBuilder("[");
        boolean r1 = true;
    L4:
        if (r3.hasNext() == false) goto L9;
        if (r1 == true) goto L7;
        r0.append(", ");
    L7:
        r0.append(r3.next());
        r1 = false;
        goto L4
    L9:
        return r0.append(']').toString();
    }

    @ParametricNullness
    public static <T> T getOnlyElement(Iterator<T> r4) {
        T r0 = r4.next();
        if (r4.hasNext() == true) goto L5;
        return r0;
    L5:
        StringBuilder r1 = new StringBuilder("expected one element but was: <").append(r0);
        int r2 = 0;
    L7:
        if (r2 >= 4) goto L12;
        if (r4.hasNext() == false) goto L12;
        r1.append(", ").append(r4.next());
        r2 = r2 + 1;
    L12:
        if (r4.hasNext() == false) goto L14;
        r1.append(", ...");
    L14:
        r1.append('>');
        throw new IllegalArgumentException(r1.toString());
    }

    @ParametricNullness
    public static <T> T getOnlyElement(Iterator<? extends T> r1, @ParametricNullness T r2) {
        if (r1.hasNext() == true) goto L5;
        return r2;
    L5:
        return (T) getOnlyElement(r1);
    }

    public static <T> T[] toArray(Iterator<? extends T> r0, Class<T> r1) {
        return (T[]) Iterables.toArray(Lists.newArrayList(r0), r1);
    }

    public static <T> boolean addAll(Collection<T> r2, Iterator<? extends T> r3) {
        Preconditions.checkNotNull(r2);
        Preconditions.checkNotNull(r3);
        boolean r0 = false;
    L4:
        if (r3.hasNext() == false) goto L6;
        r0 = r0 | r2.add(r3.next());
        goto L4
    L6:
        return r0;
    }

    public static int frequency(Iterator<?> r2, @CheckForNull Object r3) {
        int r0 = 0;
    L4:
        if (contains(r2, r3) == false) goto L6;
        r0 = r0 + 1;
        goto L4
    L6:
        return r0;
    }

    public static <T> Iterator<T> cycle(final Iterable<T> r1) {
        Preconditions.checkNotNull(r1);
        return new AnonymousClass2(r1);
    }

    @SafeVarargs
    public static <T> Iterator<T> cycle(T... r0) {
        return cycle(Lists.newArrayList(r0));
    }

    private static <I extends Iterator<?>> Iterator<I> consumingForArray(final I... r1) {
        return new AnonymousClass3(r1);
    }

    public static <T> Iterator<T> concat(Iterator<? extends T> r2, Iterator<? extends T> r3) {
        Preconditions.checkNotNull(r2);
        Preconditions.checkNotNull(r3);
        return concat(consumingForArray(new Iterator[]{r2, r3}));
    }

    public static <T> Iterator<T> concat(Iterator<? extends T> r2, Iterator<? extends T> r3, Iterator<? extends T> r4) {
        Preconditions.checkNotNull(r2);
        Preconditions.checkNotNull(r3);
        Preconditions.checkNotNull(r4);
        return concat(consumingForArray(new Iterator[]{r2, r3, r4}));
    }

    public static <T> Iterator<T> concat(Iterator<? extends T> r2, Iterator<? extends T> r3, Iterator<? extends T> r4, Iterator<? extends T> r5) {
        Preconditions.checkNotNull(r2);
        Preconditions.checkNotNull(r3);
        Preconditions.checkNotNull(r4);
        Preconditions.checkNotNull(r5);
        return concat(consumingForArray(new Iterator[]{r2, r3, r4, r5}));
    }

    public static <T> Iterator<T> concat(Iterator<? extends T>... r1) {
        return concatNoDefensiveCopy((Iterator[]) Arrays.copyOf(r1, r1.length));
    }

    public static <T> Iterator<T> concat(Iterator<? extends Iterator<? extends T>> r1) {
        return new ConcatenatedIterator(r1);
    }

    static <T> Iterator<T> concatNoDefensiveCopy(Iterator<? extends T>... r4) {
        Iterator[] r0 = (Iterator[]) Preconditions.checkNotNull(r4);
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        Preconditions.checkNotNull(r0[r2]);
        r2 = r2 + 1;
        goto L3
    L6:
        return concat(consumingForArray(r4));
    }

    public static <T> UnmodifiableIterator<List<T>> partition(Iterator<T> r1, int r2) {
        return partitionImpl(r1, r2, false);
    }

    public static <T> UnmodifiableIterator<List<T>> paddedPartition(Iterator<T> r1, int r2) {
        return partitionImpl(r1, r2, true);
    }

    private static <T> UnmodifiableIterator<List<T>> partitionImpl(final Iterator<T> r1, final int r2, final boolean r3) {
        Preconditions.checkNotNull(r1);
        if (r2 <= 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0);
        return new AnonymousClass4(r1, r2, r3);
    L5:
        r0 = false;
        goto L6
    }

    public static <T> UnmodifiableIterator<T> filter(final Iterator<T> r1, final Predicate<? super T> r2) {
        Preconditions.checkNotNull(r1);
        Preconditions.checkNotNull(r2);
        return new AnonymousClass5(r1, r2);
    }

    public static <T> UnmodifiableIterator<T> filter(Iterator<?> r0, Class<T> r1) {
        return filter(r0, Predicates.instanceOf(r1));
    }

    public static <T> boolean any(Iterator<T> r0, Predicate<? super T> r1) {
        if (indexOf(r0, r1) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public static <T> boolean all(Iterator<T> r1, Predicate<? super T> r2) {
        Preconditions.checkNotNull(r2);
    L4:
        if (r1.hasNext() == false) goto L9;
        if (r2.apply(r1.next()) == true) goto L4;
        return false;
    L9:
        return true;
    }

    @ParametricNullness
    public static <T> T find(Iterator<T> r2, Predicate<? super T> r3) {
        Preconditions.checkNotNull(r2);
        Preconditions.checkNotNull(r3);
    L4:
        if (r2.hasNext() == false) goto L9;
        T r0 = r2.next();
        if (r3.apply(r0) == false) goto L4;
        return r0;
    L9:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
    @CheckForNull
    public static <T> T find(Iterator<? extends T> r2, Predicate<? super T> r3, @CheckForNull T r4) {
        Preconditions.checkNotNull(r2);
        Preconditions.checkNotNull(r3);
    L4:
        if (r2.hasNext() == false) goto L8;
        T r0 = r2.next();
        if (r3.apply(r0) == false) goto L4;
        return r0;
    L8:
        return r4;
    }

    public static <T> Optional<T> tryFind(Iterator<T> r2, Predicate<? super T> r3) {
        Preconditions.checkNotNull(r2);
        Preconditions.checkNotNull(r3);
    L4:
        if (r2.hasNext() == false) goto L10;
        T r0 = r2.next();
        if (r3.apply(r0) == false) goto L4;
        return Optional.of(r0);
    L10:
        return Optional.absent();
    }

    public static <T> int indexOf(Iterator<T> r2, Predicate<? super T> r3) {
        Preconditions.checkNotNull(r3, "predicate");
        int r0 = 0;
    L4:
        if (r2.hasNext() == false) goto L9;
        if (r3.apply(r2.next()) == true) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r0;
    L9:
        return -1;
    }

    public static <F, T> Iterator<T> transform(final Iterator<F> r1, final Function<? super F, ? extends T> r2) {
        Preconditions.checkNotNull(r2);
        return new AnonymousClass6(r1, r2);
    }

    @ParametricNullness
    public static <T> T get(Iterator<T> r3, int r4) {
        checkNonnegative(r4);
        int r0 = advance(r3, r4);
        if (r3.hasNext() == false) goto L7;
        return r3.next();
    L7:
        throw new IndexOutOfBoundsException(new StringBuilder(91).append("position (").append(r4).append(") must be less than the number of elements that remained (").append(r0).append(")").toString());
    }

    @ParametricNullness
    public static <T> T get(Iterator<? extends T> r0, int r1, @ParametricNullness T r2) {
        checkNonnegative(r1);
        advance(r0, r1);
        return (T) getNext(r0, r2);
    }

    static void checkNonnegative(int r3) {
        if (r3 < 0) goto L5;
        return;
    L5:
        throw new IndexOutOfBoundsException(new StringBuilder(43).append("position (").append(r3).append(") must not be negative").toString());
    }

    @ParametricNullness
    public static <T> T getNext(Iterator<? extends T> r1, @ParametricNullness T r2) {
        if (r1.hasNext() == true) goto L5;
        return r2;
    L5:
        return r1.next();
    }

    @ParametricNullness
    public static <T> T getLast(Iterator<T> r2) {
    L2:
        T r0 = r2.next();
        if (r2.hasNext() == true) goto L2;
        return r0;
    }

    @ParametricNullness
    public static <T> T getLast(Iterator<? extends T> r1, @ParametricNullness T r2) {
        if (r1.hasNext() == true) goto L5;
        return r2;
    L5:
        return (T) getLast(r1);
    }

    public static int advance(Iterator<?> r3, int r4) {
        Preconditions.checkNotNull(r3);
        int r0 = 0;
        if (r4 < 0) goto L5;
        boolean r1 = true;
    L6:
        Preconditions.checkArgument(r1, "numberToAdvance must be nonnegative");
    L7:
        if (r0 >= r4) goto L11;
        if (r3.hasNext() == false) goto L11;
        r3.next();
        r0 = r0 + 1;
    L11:
        return r0;
    L5:
        r1 = false;
        goto L6
    }

    public static <T> Iterator<T> limit(final Iterator<T> r2, final int r3) {
        Preconditions.checkNotNull(r2);
        if (r3 < 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "limit is negative");
        return new AnonymousClass7(r3, r2);
    L5:
        r0 = false;
        goto L6
    }

    public static <T> Iterator<T> consumingIterator(final Iterator<T> r1) {
        Preconditions.checkNotNull(r1);
        return new AnonymousClass8(r1);
    }

    @CheckForNull
    static <T> T pollNext(Iterator<T> r1) {
        if (r1.hasNext() == false) goto L6;
        T r0 = r1.next();
        r1.remove();
        return r0;
    L6:
        return null;
    }

    static void clear(Iterator<?> r1) {
        Preconditions.checkNotNull(r1);
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next();
        r1.remove();
        goto L4
    }

    @SafeVarargs
    public static <T> UnmodifiableIterator<T> forArray(T... r2) {
        return forArray(r2, 0, r2.length, 0);
    }

    static <T> UnmodifiableListIterator<T> forArray(T[] r2, int r3, int r4, int r5) {
        if (r4 < 0) goto L4;
        boolean r0 = true;
    L5:
        Preconditions.checkArgument(r0);
        Preconditions.checkPositionIndexes(r3, r3 + r4, r2.length);
        Preconditions.checkPositionIndex(r5, r4);
        if (r4 != 0) goto L10;
        return emptyListIterator();
    L10:
        return new ArrayItr(r2, r3, r4, r5);
    L4:
        r0 = false;
        goto L5
    }

    public static <T> UnmodifiableIterator<T> singletonIterator(@ParametricNullness final T r1) {
        return new AnonymousClass9(r1);
    }

    public static <T> UnmodifiableIterator<T> forEnumeration(final Enumeration<T> r1) {
        Preconditions.checkNotNull(r1);
        return new AnonymousClass10(r1);
    }

    public static <T> Enumeration<T> asEnumeration(final Iterator<T> r1) {
        Preconditions.checkNotNull(r1);
        return new AnonymousClass11(r1);
    }

    public static <T> PeekingIterator<T> peekingIterator(Iterator<? extends T> r1) {
        if ((r1 instanceof PeekingImpl) == false) goto L7;
        return (PeekingImpl) r1;
    L7:
        return new PeekingImpl(r1);
    }

    @Deprecated
    public static <T> PeekingIterator<T> peekingIterator(PeekingIterator<T> r0) {
        return (PeekingIterator) Preconditions.checkNotNull(r0);
    }

    public static <T> UnmodifiableIterator<T> mergeSorted(Iterable<? extends Iterator<? extends T>> r1, Comparator<? super T> r2) {
        Preconditions.checkNotNull(r1, "iterators");
        Preconditions.checkNotNull(r2, "comparator");
        return new MergingIterator(r1, r2);
    }

    static <T> ListIterator<T> cast(Iterator<T> r0) {
        return (ListIterator) r0;
    }
}
