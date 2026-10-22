package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class Iterables {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.google.common.collect.Iterables$1, reason: invalid class name */
    class AnonymousClass1<T> extends FluentIterable<T> {
        final /* synthetic */ Iterable val$iterable;

        static /* synthetic */ Iterable lambda$spliterator$0(Iterable r0) {
            return r0;
        }

        AnonymousClass1(Iterable r1) {
            this.val$iterable = r1;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.cycle(this.val$iterable);
        }

        @Override // java.lang.Iterable
        public Spliterator<T> spliterator() {
            final Iterable r1 = this.val$iterable;
            return Stream.generate(new Iterables$1$$ExternalSyntheticLambda0(r1)).flatMap(new Iterables$1$$ExternalSyntheticLambda1()).spliterator();
        }

        @Override // com.google.common.collect.FluentIterable
        public String toString() {
            return String.valueOf(this.val$iterable.toString()).concat(" (cycled)");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.google.common.collect.Iterables$4, reason: invalid class name */
    class AnonymousClass4<T> extends FluentIterable<T> {
        final /* synthetic */ Predicate val$retainIfTrue;
        final /* synthetic */ Iterable val$unfiltered;

        AnonymousClass4(Iterable r1, Predicate r2) {
            this.val$unfiltered = r1;
            this.val$retainIfTrue = r2;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.filter(this.val$unfiltered.iterator(), this.val$retainIfTrue);
        }

        @Override // java.lang.Iterable
        public void forEach(final Consumer<? super T> r3) {
            Preconditions.checkNotNull(r3);
            Iterable r0 = this.val$unfiltered;
            final Predicate r2 = this.val$retainIfTrue;
            r0.forEach(new Iterables$4$$ExternalSyntheticLambda0(r2, r3));
        }

        static /* synthetic */ void lambda$forEach$0(Predicate r0, Consumer r1, Object r2) {
            if (r0.test(r2) == false) goto L6;
            r1.accept(r2);
            return;
        }

        @Override // java.lang.Iterable
        public Spliterator<T> spliterator() {
            return CollectSpliterators.filter(this.val$unfiltered.spliterator(), this.val$retainIfTrue);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.google.common.collect.Iterables$5, reason: invalid class name */
    class AnonymousClass5<T> extends FluentIterable<T> {
        final /* synthetic */ Iterable val$fromIterable;
        final /* synthetic */ Function val$function;

        AnonymousClass5(Iterable r1, Function r2) {
            this.val$fromIterable = r1;
            this.val$function = r2;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.transform(this.val$fromIterable.iterator(), this.val$function);
        }

        @Override // java.lang.Iterable
        public void forEach(final Consumer<? super T> r3) {
            Preconditions.checkNotNull(r3);
            Iterable r0 = this.val$fromIterable;
            final Function r2 = this.val$function;
            r0.forEach(new Iterables$5$$ExternalSyntheticLambda0(r3, r2));
        }

        /* JADX WARN: Multi-variable type inference failed */
        static /* synthetic */ void lambda$forEach$0(Consumer r0, Function r1, Object r2) {
            r0.accept(r1.apply(r2));
        }

        @Override // java.lang.Iterable
        public Spliterator<T> spliterator() {
            return CollectSpliterators.map(this.val$fromIterable.spliterator(), this.val$function);
        }
    }

    private static final class UnmodifiableIterable<T> extends FluentIterable<T> {
        private final Iterable<? extends T> iterable;

        /* synthetic */ UnmodifiableIterable(Iterable r1, AnonymousClass1 r2) {
            this(r1);
        }

        private UnmodifiableIterable(Iterable<? extends T> r1) {
            this.iterable = r1;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.unmodifiableIterator(this.iterable.iterator());
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super T> r1) {
            this.iterable.forEach(r1);
        }

        @Override // java.lang.Iterable
        public Spliterator<T> spliterator() {
            return this.iterable.spliterator();
        }

        @Override // com.google.common.collect.FluentIterable
        public String toString() {
            return this.iterable.toString();
        }
    }

    private Iterables() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> Iterable<T> unmodifiableIterable(Iterable<? extends T> r2) {
        Preconditions.checkNotNull(r2);
        if ((r2 instanceof UnmodifiableIterable) == false) goto L5;
    L9:
        return r2;
    L5:
        if ((r2 instanceof ImmutableCollection) == true) goto L9;
        return new UnmodifiableIterable(r2, null);
    }

    @Deprecated
    public static <E> Iterable<E> unmodifiableIterable(ImmutableCollection<E> r0) {
        return (Iterable) Preconditions.checkNotNull(r0);
    }

    public static int size(Iterable<?> r1) {
        if ((r1 instanceof Collection) == false) goto L6;
        return ((Collection) r1).size();
    L6:
        return Iterators.size(r1.iterator());
    }

    public static boolean contains(Iterable<? extends Object> r1, @CheckForNull Object r2) {
        if ((r1 instanceof Collection) == false) goto L7;
        return Collections2.safeContains((Collection) r1, r2);
    L7:
        return Iterators.contains(r1.iterator(), r2);
    }

    public static boolean removeAll(Iterable<?> r1, Collection<?> r2) {
        if ((r1 instanceof Collection) == false) goto L6;
        return ((Collection) r1).removeAll((Collection) Preconditions.checkNotNull(r2));
    L6:
        return Iterators.removeAll(r1.iterator(), r2);
    }

    public static boolean retainAll(Iterable<?> r1, Collection<?> r2) {
        if ((r1 instanceof Collection) == false) goto L6;
        return ((Collection) r1).retainAll((Collection) Preconditions.checkNotNull(r2));
    L6:
        return Iterators.retainAll(r1.iterator(), r2);
    }

    public static <T> boolean removeIf(Iterable<T> r1, Predicate<? super T> r2) {
        if ((r1 instanceof Collection) == false) goto L7;
        return ((Collection) r1).removeIf(r2);
    L7:
        return Iterators.removeIf(r1.iterator(), r2);
    }

    @CheckForNull
    static <T> T removeFirstMatching(Iterable<T> r2, Predicate<? super T> r3) {
        Preconditions.checkNotNull(r3);
        Iterator<T> r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        T r0 = r4.next();
        if (r3.apply(r0) == false) goto L4;
        r4.remove();
        return r0;
    L9:
        return null;
    }

    public static boolean elementsEqual(Iterable<?> r2, Iterable<?> r3) {
        if ((r2 instanceof Collection) == false) goto L11;
        if ((r3 instanceof Collection) == false) goto L11;
        if (((Collection) r2).size() == ((Collection) r3).size()) goto L11;
        return false;
    L11:
        return Iterators.elementsEqual(r2.iterator(), r3.iterator());
    }

    public static String toString(Iterable<?> r0) {
        return Iterators.toString(r0.iterator());
    }

    @ParametricNullness
    public static <T> T getOnlyElement(Iterable<T> r0) {
        return (T) Iterators.getOnlyElement(r0.iterator());
    }

    @ParametricNullness
    public static <T> T getOnlyElement(Iterable<? extends T> r0, @ParametricNullness T r1) {
        return (T) Iterators.getOnlyElement(r0.iterator(), r1);
    }

    public static <T> T[] toArray(Iterable<? extends T> r1, Class<T> r2) {
        return (T[]) toArray(r1, ObjectArrays.newArray(r2, 0));
    }

    static <T> T[] toArray(Iterable<? extends T> r0, T[] r1) {
        return (T[]) castOrCopyToCollection(r0).toArray(r1);
    }

    static Object[] toArray(Iterable<?> r0) {
        return castOrCopyToCollection(r0).toArray();
    }

    private static <E> Collection<E> castOrCopyToCollection(Iterable<E> r1) {
        if ((r1 instanceof Collection) == false) goto L6;
        return (Collection) r1;
    L6:
        return Lists.newArrayList(r1.iterator());
    }

    public static <T> boolean addAll(Collection<T> r1, Iterable<? extends T> r2) {
        if ((r2 instanceof Collection) == false) goto L7;
        return r1.addAll((Collection) r2);
    L7:
        return Iterators.addAll(r1, ((Iterable) Preconditions.checkNotNull(r2)).iterator());
    }

    public static int frequency(Iterable<?> r1, @CheckForNull Object r2) {
        if ((r1 instanceof Multiset) == false) goto L7;
        return ((Multiset) r1).count(r2);
    L7:
        if ((r1 instanceof Set) == false) goto L11;
        return ((Set) r1).contains(r2) ? 1 : 0;
    L11:
        return Iterators.frequency(r1.iterator(), r2);
    }

    public static <T> Iterable<T> cycle(Iterable<T> r1) {
        Preconditions.checkNotNull(r1);
        return new AnonymousClass1(r1);
    }

    @SafeVarargs
    public static <T> Iterable<T> cycle(T... r0) {
        return cycle(Lists.newArrayList(r0));
    }

    public static <T> Iterable<T> concat(Iterable<? extends T> r0, Iterable<? extends T> r1) {
        return FluentIterable.concat(r0, r1);
    }

    public static <T> Iterable<T> concat(Iterable<? extends T> r0, Iterable<? extends T> r1, Iterable<? extends T> r2) {
        return FluentIterable.concat(r0, r1, r2);
    }

    public static <T> Iterable<T> concat(Iterable<? extends T> r0, Iterable<? extends T> r1, Iterable<? extends T> r2, Iterable<? extends T> r3) {
        return FluentIterable.concat(r0, r1, r2, r3);
    }

    @SafeVarargs
    public static <T> Iterable<T> concat(Iterable<? extends T>... r0) {
        return FluentIterable.concat(r0);
    }

    public static <T> Iterable<T> concat(Iterable<? extends Iterable<? extends T>> r0) {
        return FluentIterable.concat(r0);
    }

    public static <T> Iterable<List<T>> partition(final Iterable<T> r1, final int r2) {
        Preconditions.checkNotNull(r1);
        if (r2 <= 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0);
        return new AnonymousClass2(r1, r2);
    L5:
        r0 = false;
        goto L6
    }

    public static <T> Iterable<List<T>> paddedPartition(final Iterable<T> r1, final int r2) {
        Preconditions.checkNotNull(r1);
        if (r2 <= 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0);
        return new AnonymousClass3(r1, r2);
    L5:
        r0 = false;
        goto L6
    }

    public static <T> Iterable<T> filter(Iterable<T> r1, Predicate<? super T> r2) {
        Preconditions.checkNotNull(r1);
        Preconditions.checkNotNull(r2);
        return new AnonymousClass4(r1, r2);
    }

    public static <T> Iterable<T> filter(Iterable<?> r0, Class<T> r1) {
        Preconditions.checkNotNull(r0);
        Preconditions.checkNotNull(r1);
        return filter(r0, Predicates.instanceOf(r1));
    }

    public static <T> boolean any(Iterable<T> r0, Predicate<? super T> r1) {
        return Iterators.any(r0.iterator(), r1);
    }

    public static <T> boolean all(Iterable<T> r0, Predicate<? super T> r1) {
        return Iterators.all(r0.iterator(), r1);
    }

    @ParametricNullness
    public static <T> T find(Iterable<T> r0, Predicate<? super T> r1) {
        return (T) Iterators.find(r0.iterator(), r1);
    }

    @CheckForNull
    public static <T> T find(Iterable<? extends T> r0, Predicate<? super T> r1, @CheckForNull T r2) {
        return (T) Iterators.find(r0.iterator(), r1, r2);
    }

    public static <T> Optional<T> tryFind(Iterable<T> r0, Predicate<? super T> r1) {
        return Iterators.tryFind(r0.iterator(), r1);
    }

    public static <T> int indexOf(Iterable<T> r0, Predicate<? super T> r1) {
        return Iterators.indexOf(r0.iterator(), r1);
    }

    public static <F, T> Iterable<T> transform(Iterable<F> r1, Function<? super F, ? extends T> r2) {
        Preconditions.checkNotNull(r1);
        Preconditions.checkNotNull(r2);
        return new AnonymousClass5(r1, r2);
    }

    @ParametricNullness
    public static <T> T get(Iterable<T> r1, int r2) {
        Preconditions.checkNotNull(r1);
        if ((r1 instanceof List) == false) goto L6;
        return (T) ((List) r1).get(r2);
    L6:
        return (T) Iterators.get(r1.iterator(), r2);
    }

    @ParametricNullness
    public static <T> T get(Iterable<? extends T> r1, int r2, @ParametricNullness T r3) {
        Preconditions.checkNotNull(r1);
        Iterators.checkNonnegative(r2);
        if ((r1 instanceof List) == false) goto L8;
        List r4 = Lists.cast(r1);
        if (r2 < r4.size()) goto L7;
        return r3;
    L7:
        return (T) r4.get(r2);
    L8:
        Iterator<? extends T> r5 = r1.iterator();
        Iterators.advance(r5, r2);
        return (T) Iterators.getNext(r5, r3);
    }

    @ParametricNullness
    public static <T> T getFirst(Iterable<? extends T> r0, @ParametricNullness T r1) {
        return (T) Iterators.getNext(r0.iterator(), r1);
    }

    @ParametricNullness
    public static <T> T getLast(Iterable<T> r1) {
        if ((r1 instanceof List) == false) goto L11;
        List r2 = (List) r1;
        if (r2.isEmpty() == true) goto L9;
        return (T) getLastInNonemptyList(r2);
    L9:
        throw new NoSuchElementException();
    L11:
        return (T) Iterators.getLast(r1.iterator());
    }

    @ParametricNullness
    public static <T> T getLast(Iterable<? extends T> r1, @ParametricNullness T r2) {
        if ((r1 instanceof Collection) == false) goto L12;
        if (((Collection) r1).isEmpty() == false) goto L8;
        return r2;
    L8:
        if ((r1 instanceof List) == false) goto L12;
        return (T) getLastInNonemptyList(Lists.cast(r1));
    L12:
        return (T) Iterators.getLast(r1.iterator(), r2);
    }

    @ParametricNullness
    private static <T> T getLastInNonemptyList(List<T> r1) {
        return r1.get(r1.size() - 1);
    }

    public static <T> Iterable<T> skip(final Iterable<T> r2, final int r3) {
        Preconditions.checkNotNull(r2);
        if (r3 < 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "number to skip cannot be negative");
        return new AnonymousClass6(r2, r3);
    L5:
        r0 = false;
        goto L6
    }

    public static <T> Iterable<T> limit(final Iterable<T> r2, final int r3) {
        Preconditions.checkNotNull(r2);
        if (r3 < 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "limit is negative");
        return new AnonymousClass7(r2, r3);
    L5:
        r0 = false;
        goto L6
    }

    public static <T> Iterable<T> consumingIterable(final Iterable<T> r1) {
        Preconditions.checkNotNull(r1);
        return new AnonymousClass8(r1);
    }

    public static boolean isEmpty(Iterable<?> r1) {
        if ((r1 instanceof Collection) == false) goto L7;
        return ((Collection) r1).isEmpty();
    L7:
        return !r1.iterator().hasNext();
    }

    public static <T> Iterable<T> mergeSorted(final Iterable<? extends Iterable<? extends T>> r1, final Comparator<? super T> r2) {
        Preconditions.checkNotNull(r1, "iterables");
        Preconditions.checkNotNull(r2, "comparator");
        return new UnmodifiableIterable(new AnonymousClass9(r1, r2), null);
    }

    static <T> Function<Iterable<? extends T>, Iterator<? extends T>> toIterator() {
        return new AnonymousClass10();
    }
}
