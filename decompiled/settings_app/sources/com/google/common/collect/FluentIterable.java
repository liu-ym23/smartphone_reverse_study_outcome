package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.stream.Stream;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public abstract class FluentIterable<E> implements Iterable<E> {
    private final Optional<Iterable<E>> iterableDelegate;

    private static class FromIterableFunction<E> implements Function<Iterable<E>, FluentIterable<E>> {
        private FromIterableFunction() {
        }

        @Override // com.google.common.base.Function, java.util.function.Function
        public /* bridge */ /* synthetic */ Object apply(Object r1) {
            return apply((Iterable) r1);
        }

        public FluentIterable<E> apply(Iterable<E> r1) {
            return FluentIterable.from(r1);
        }
    }

    protected FluentIterable() {
        this.iterableDelegate = Optional.absent();
    }

    FluentIterable(Iterable<E> r1) {
        this.iterableDelegate = Optional.of(r1);
    }

    private Iterable<E> getDelegate() {
        return this.iterableDelegate.or(this);
    }

    public static <E> FluentIterable<E> from(final Iterable<E> r1) {
        if ((r1 instanceof FluentIterable) == false) goto L6;
        return (FluentIterable) r1;
    L6:
        return new AnonymousClass1(r1, r1);
    }

    public static <E> FluentIterable<E> from(E[] r0) {
        return from(Arrays.asList(r0));
    }

    @Deprecated
    public static <E> FluentIterable<E> from(FluentIterable<E> r0) {
        return (FluentIterable) Preconditions.checkNotNull(r0);
    }

    public static <T> FluentIterable<T> concat(Iterable<? extends T> r2, Iterable<? extends T> r3) {
        return concatNoDefensiveCopy(new Iterable[]{r2, r3});
    }

    public static <T> FluentIterable<T> concat(Iterable<? extends T> r2, Iterable<? extends T> r3, Iterable<? extends T> r4) {
        return concatNoDefensiveCopy(new Iterable[]{r2, r3, r4});
    }

    public static <T> FluentIterable<T> concat(Iterable<? extends T> r2, Iterable<? extends T> r3, Iterable<? extends T> r4, Iterable<? extends T> r5) {
        return concatNoDefensiveCopy(new Iterable[]{r2, r3, r4, r5});
    }

    public static <T> FluentIterable<T> concat(Iterable<? extends T>... r1) {
        return concatNoDefensiveCopy((Iterable[]) Arrays.copyOf(r1, r1.length));
    }

    public static <T> FluentIterable<T> concat(final Iterable<? extends Iterable<? extends T>> r1) {
        Preconditions.checkNotNull(r1);
        return new AnonymousClass2(r1);
    }

    private static <T> FluentIterable<T> concatNoDefensiveCopy(final Iterable<? extends T>... r3) {
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L6;
        Preconditions.checkNotNull(r3[r1]);
        r1 = r1 + 1;
        goto L3
    L6:
        return new AnonymousClass3(r3);
    }

    public static <E> FluentIterable<E> of() {
        return from(Collections.emptyList());
    }

    public static <E> FluentIterable<E> of(@ParametricNullness E r0, E... r1) {
        return from(Lists.asList(r0, r1));
    }

    public String toString() {
        return Iterables.toString(getDelegate());
    }

    public final int size() {
        return Iterables.size(getDelegate());
    }

    public final boolean contains(@CheckForNull Object r1) {
        return Iterables.contains(getDelegate(), r1);
    }

    public final FluentIterable<E> cycle() {
        return from(Iterables.cycle(getDelegate()));
    }

    public final FluentIterable<E> append(Iterable<? extends E> r1) {
        return concat(getDelegate(), r1);
    }

    public final FluentIterable<E> append(E... r1) {
        return concat(getDelegate(), Arrays.asList(r1));
    }

    public final FluentIterable<E> filter(Predicate<? super E> r1) {
        return from(Iterables.filter(getDelegate(), r1));
    }

    public final <T> FluentIterable<T> filter(Class<T> r1) {
        return from(Iterables.filter(getDelegate(), r1));
    }

    public final boolean anyMatch(Predicate<? super E> r1) {
        return Iterables.any(getDelegate(), r1);
    }

    public final boolean allMatch(Predicate<? super E> r1) {
        return Iterables.all(getDelegate(), r1);
    }

    public final Optional<E> firstMatch(Predicate<? super E> r1) {
        return Iterables.tryFind(getDelegate(), r1);
    }

    public final <T> FluentIterable<T> transform(Function<? super E, T> r1) {
        return from(Iterables.transform(getDelegate(), r1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> FluentIterable<T> transformAndConcat(Function<? super E, ? extends Iterable<? extends T>> r1) {
        return concat(transform(r1));
    }

    public final Optional<E> first() {
        Iterator<E> r1 = getDelegate().iterator();
        if (r1.hasNext() == false) goto L6;
        return Optional.of(r1.next());
    L6:
        return Optional.absent();
    }

    public final Optional<E> last() {
        Iterable<E> r2 = getDelegate();
        if ((r2 instanceof List) == false) goto L10;
        List r3 = (List) r2;
        if (r3.isEmpty() == false) goto L9;
        return Optional.absent();
    L9:
        return Optional.of(r3.get(r3.size() - 1));
    L10:
        Iterator<E> r0 = r2.iterator();
        if (r0.hasNext() == true) goto L15;
        return Optional.absent();
    L15:
        if ((r2 instanceof SortedSet) == true) goto L17;
    L18:
        E r4 = r0.next();
        if (r0.hasNext() == true) goto L18;
        return Optional.of(r4);
    L17:
        return Optional.of(((SortedSet) r2).last());
    }

    public final FluentIterable<E> skip(int r1) {
        return from(Iterables.skip(getDelegate(), r1));
    }

    public final FluentIterable<E> limit(int r1) {
        return from(Iterables.limit(getDelegate(), r1));
    }

    public final boolean isEmpty() {
        return !getDelegate().iterator().hasNext();
    }

    public final ImmutableList<E> toList() {
        return ImmutableList.copyOf(getDelegate());
    }

    public final ImmutableList<E> toSortedList(Comparator<? super E> r1) {
        return Ordering.from(r1).immutableSortedCopy(getDelegate());
    }

    public final ImmutableSet<E> toSet() {
        return ImmutableSet.copyOf(getDelegate());
    }

    public final ImmutableSortedSet<E> toSortedSet(Comparator<? super E> r1) {
        return ImmutableSortedSet.copyOf(r1, getDelegate());
    }

    public final ImmutableMultiset<E> toMultiset() {
        return ImmutableMultiset.copyOf(getDelegate());
    }

    public final <V> ImmutableMap<E, V> toMap(Function<? super E, V> r1) {
        return Maps.toMap(getDelegate(), r1);
    }

    public final <K> ImmutableListMultimap<K, E> index(Function<? super E, K> r1) {
        return Multimaps.index(getDelegate(), r1);
    }

    public final <K> ImmutableMap<K, E> uniqueIndex(Function<? super E, K> r1) {
        return Maps.uniqueIndex(getDelegate(), r1);
    }

    public final E[] toArray(Class<E> r1) {
        return (E[]) Iterables.toArray(getDelegate(), r1);
    }

    public final <C extends Collection<? super E>> C copyInto(C r2) {
        Preconditions.checkNotNull(r2);
        Iterable<E> r1 = getDelegate();
        if ((r1 instanceof Collection) == false) goto L5;
        r2.addAll((Collection) r1);
    L9:
        return r2;
    L5:
        Iterator<E> r3 = r1.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        r2.add(r3.next());
        goto L7
    }

    public final String join(Joiner r1) {
        return r1.join(this);
    }

    @ParametricNullness
    public final E get(int r1) {
        return (E) Iterables.get(getDelegate(), r1);
    }

    public final Stream<E> stream() {
        return Streams.stream(getDelegate());
    }
}
