package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.TreeMap;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class CollectCollectors {
    private static final Collector<Object, ?, ImmutableList<Object>> TO_IMMUTABLE_LIST = null;
    private static final Collector<Range<Comparable<?>>, ?, ImmutableRangeSet<Comparable<?>>> TO_IMMUTABLE_RANGE_SET = null;
    private static final Collector<Object, ?, ImmutableSet<Object>> TO_IMMUTABLE_SET = null;

    private static class EnumMapAccumulator<K extends Enum<K>, V> {

        @CheckForNull
        private EnumMap<K, V> map;
        private final BinaryOperator<V> mergeFunction;

        EnumMapAccumulator(BinaryOperator<V> r2) {
            this.map = null;
            this.mergeFunction = r2;
        }

        void put(K r3, V r4) {
            if (this.map != null) goto L5;
            this.map = new EnumMap(r3.getDeclaringClass());
        L5:
            this.map.merge(r3, r4, this.mergeFunction);
        }

        EnumMapAccumulator<K, V> combine(EnumMapAccumulator<K, V> r2) {
            if (this.map != null) goto L5;
            return r2;
        L5:
            EnumMap<K, V> r3 = r2.map;
            if (r3 != null) goto L8;
            return this;
        L8:
            r3.forEach(new CollectCollectors$EnumMapAccumulator$$ExternalSyntheticLambda0(this));
            return this;
        }

        ImmutableMap<K, V> toImmutableMap() {
            EnumMap<K, V> r0 = this.map;
            if (r0 != null) goto L6;
            return ImmutableMap.of();
        L6:
            return ImmutableEnumMap.asImmutable(r0);
        }
    }

    private static final class EnumSetAccumulator<E extends Enum<E>> {
        static final Collector<Enum<?>, ?, ImmutableSet<? extends Enum<?>>> TO_IMMUTABLE_ENUM_SET = null;

        @CheckForNull
        private EnumSet<E> set;

        public static /* synthetic */ EnumSetAccumulator $r8$lambda$DXK1D4ohk3Ds4wC3bR4Gyv_uoNM() {
            return new EnumSetAccumulator();
        }

        private EnumSetAccumulator() {
        }

        static {
            TO_IMMUTABLE_ENUM_SET = Collector.of(new CollectCollectors$EnumSetAccumulator$$ExternalSyntheticLambda0(), new CollectCollectors$EnumSetAccumulator$$ExternalSyntheticLambda1(), new CollectCollectors$EnumSetAccumulator$$ExternalSyntheticLambda2(), new CollectCollectors$EnumSetAccumulator$$ExternalSyntheticLambda3(), new Collector.Characteristics[]{Collector.Characteristics.UNORDERED});
        }

        void add(E r2) {
            EnumSet<E> r0 = this.set;
            if (r0 != null) goto L5;
            this.set = EnumSet.of(r2);
            return;
        L5:
            r0.add(r2);
        }

        EnumSetAccumulator<E> combine(EnumSetAccumulator<E> r2) {
            EnumSet<E> r0 = this.set;
            if (r0 != null) goto L5;
            return r2;
        L5:
            EnumSet<E> r3 = r2.set;
            if (r3 != null) goto L8;
            return this;
        L8:
            r0.addAll(r3);
            return this;
        }

        ImmutableSet<E> toImmutableSet() {
            EnumSet<E> r0 = this.set;
            if (r0 != null) goto L6;
            return ImmutableSet.of();
        L6:
            return ImmutableEnumSet.asImmutable(r0);
        }
    }

    public static /* synthetic */ LinkedHashMap $r8$lambda$Rr5wHpoNM5boD4b5K8greFBFLF8() {
        return new LinkedHashMap();
    }

    CollectCollectors() {
    }

    static {
        TO_IMMUTABLE_LIST = Collector.of(new CollectCollectors$$ExternalSyntheticLambda17(), new CollectCollectors$$ExternalSyntheticLambda20(), new CollectCollectors$$ExternalSyntheticLambda21(), new CollectCollectors$$ExternalSyntheticLambda23(), new Collector.Characteristics[0]);
        TO_IMMUTABLE_SET = Collector.of(new CollectCollectors$$ExternalSyntheticLambda24(), new CollectCollectors$$ExternalSyntheticLambda25(), new CollectCollectors$$ExternalSyntheticLambda26(), new CollectCollectors$$ExternalSyntheticLambda27(), new Collector.Characteristics[0]);
        TO_IMMUTABLE_RANGE_SET = Collector.of(new CollectCollectors$$ExternalSyntheticLambda28(), new CollectCollectors$$ExternalSyntheticLambda29(), new CollectCollectors$$ExternalSyntheticLambda18(), new CollectCollectors$$ExternalSyntheticLambda19(), new Collector.Characteristics[0]);
    }

    static <E> Collector<E, ?, ImmutableList<E>> toImmutableList() {
        return (Collector<E, ?, ImmutableList<E>>) TO_IMMUTABLE_LIST;
    }

    static <E> Collector<E, ?, ImmutableSet<E>> toImmutableSet() {
        return (Collector<E, ?, ImmutableSet<E>>) TO_IMMUTABLE_SET;
    }

    static <E> Collector<E, ?, ImmutableSortedSet<E>> toImmutableSortedSet(final Comparator<? super E> r4) {
        Preconditions.checkNotNull(r4);
        return Collector.of(new CollectCollectors$$ExternalSyntheticLambda60(r4), new CollectCollectors$$ExternalSyntheticLambda61(), new CollectCollectors$$ExternalSyntheticLambda62(), new CollectCollectors$$ExternalSyntheticLambda63(), new Collector.Characteristics[0]);
    }

    static /* synthetic */ ImmutableSortedSet.Builder lambda$toImmutableSortedSet$0(Comparator r1) {
        return new ImmutableSortedSet.Builder(r1);
    }

    static <E extends Enum<E>> Collector<E, ?, ImmutableSet<E>> toImmutableEnumSet() {
        return (Collector<E, ?, ImmutableSet<E>>) EnumSetAccumulator.TO_IMMUTABLE_ENUM_SET;
    }

    static <E extends Comparable<? super E>> Collector<Range<E>, ?, ImmutableRangeSet<E>> toImmutableRangeSet() {
        return (Collector<Range<E>, ?, ImmutableRangeSet<E>>) TO_IMMUTABLE_RANGE_SET;
    }

    static <T, E> Collector<T, ?, ImmutableMultiset<E>> toImmutableMultiset(final Function<? super T, ? extends E> r3, final ToIntFunction<? super T> r4) {
        Preconditions.checkNotNull(r3);
        Preconditions.checkNotNull(r4);
        return Collector.of(new CollectCollectors$$ExternalSyntheticLambda4(), new CollectCollectors$$ExternalSyntheticLambda5(r3, r4), new CollectCollectors$$ExternalSyntheticLambda6(), new CollectCollectors$$ExternalSyntheticLambda7(), new Collector.Characteristics[0]);
    }

    static /* synthetic */ void lambda$toImmutableMultiset$1(Function r0, ToIntFunction r1, Multiset r2, Object r3) {
        r2.add(Preconditions.checkNotNull(r0.apply(r3)), r1.applyAsInt(r3));
    }

    static /* synthetic */ Multiset lambda$toImmutableMultiset$2(Multiset r0, Multiset r1) {
        r0.addAll(r1);
        return r0;
    }

    static /* synthetic */ ImmutableMultiset lambda$toImmutableMultiset$3(Multiset r0) {
        return ImmutableMultiset.copyFromEntries(r0.entrySet());
    }

    static <T, E, M extends Multiset<E>> Collector<T, ?, M> toMultiset(final Function<? super T, E> r1, final ToIntFunction<? super T> r2, Supplier<M> r3) {
        Preconditions.checkNotNull(r1);
        Preconditions.checkNotNull(r2);
        Preconditions.checkNotNull(r3);
        return Collector.of(r3, new CollectCollectors$$ExternalSyntheticLambda0(r1, r2), new CollectCollectors$$ExternalSyntheticLambda11(), new Collector.Characteristics[0]);
    }

    static /* synthetic */ void lambda$toMultiset$4(Function r0, ToIntFunction r1, Multiset r2, Object r3) {
        r2.add(r0.apply(r3), r1.applyAsInt(r3));
    }

    static /* synthetic */ Multiset lambda$toMultiset$5(Multiset r0, Multiset r1) {
        r0.addAll(r1);
        return r0;
    }

    static <T, K, V> Collector<T, ?, ImmutableMap<K, V>> toImmutableMap(final Function<? super T, ? extends K> r3, final Function<? super T, ? extends V> r4) {
        Preconditions.checkNotNull(r3);
        Preconditions.checkNotNull(r4);
        return Collector.of(new CollectCollectors$$ExternalSyntheticLambda45(), new CollectCollectors$$ExternalSyntheticLambda46(r3, r4), new CollectCollectors$$ExternalSyntheticLambda47(), new CollectCollectors$$ExternalSyntheticLambda48(), new Collector.Characteristics[0]);
    }

    static /* synthetic */ void lambda$toImmutableMap$6(Function r0, Function r1, ImmutableMap.Builder r2, Object r3) {
        r2.put(r0.apply(r3), r1.apply(r3));
    }

    public static <T, K, V> Collector<T, ?, ImmutableMap<K, V>> toImmutableMap(Function<? super T, ? extends K> r1, Function<? super T, ? extends V> r2, BinaryOperator<V> r3) {
        Preconditions.checkNotNull(r1);
        Preconditions.checkNotNull(r2);
        Preconditions.checkNotNull(r3);
        return Collectors.collectingAndThen(Collectors.toMap(r1, r2, r3, new CollectCollectors$$ExternalSyntheticLambda2()), new CollectCollectors$$ExternalSyntheticLambda3());
    }

    static <T, K, V> Collector<T, ?, ImmutableSortedMap<K, V>> toImmutableSortedMap(final Comparator<? super K> r4, final Function<? super T, ? extends K> r5, final Function<? super T, ? extends V> r6) {
        Preconditions.checkNotNull(r4);
        Preconditions.checkNotNull(r5);
        Preconditions.checkNotNull(r6);
        return Collector.of(new CollectCollectors$$ExternalSyntheticLambda51(r4), new CollectCollectors$$ExternalSyntheticLambda52(r5, r6), new CollectCollectors$$ExternalSyntheticLambda53(), new CollectCollectors$$ExternalSyntheticLambda54(), new Collector.Characteristics[]{Collector.Characteristics.UNORDERED});
    }

    static /* synthetic */ ImmutableSortedMap.Builder lambda$toImmutableSortedMap$7(Comparator r1) {
        return new ImmutableSortedMap.Builder(r1);
    }

    static /* synthetic */ void lambda$toImmutableSortedMap$8(Function r0, Function r1, ImmutableSortedMap.Builder r2, Object r3) {
        r2.put(r0.apply(r3), r1.apply(r3));
    }

    static <T, K, V> Collector<T, ?, ImmutableSortedMap<K, V>> toImmutableSortedMap(final Comparator<? super K> r1, Function<? super T, ? extends K> r2, Function<? super T, ? extends V> r3, BinaryOperator<V> r4) {
        Preconditions.checkNotNull(r1);
        Preconditions.checkNotNull(r2);
        Preconditions.checkNotNull(r3);
        Preconditions.checkNotNull(r4);
        return Collectors.collectingAndThen(Collectors.toMap(r2, r3, r4, new CollectCollectors$$ExternalSyntheticLambda22(r1)), new CollectCollectors$$ExternalSyntheticLambda33());
    }

    static /* synthetic */ TreeMap lambda$toImmutableSortedMap$9(Comparator r1) {
        return new TreeMap(r1);
    }

    static <T, K, V> Collector<T, ?, ImmutableBiMap<K, V>> toImmutableBiMap(final Function<? super T, ? extends K> r3, final Function<? super T, ? extends V> r4) {
        Preconditions.checkNotNull(r3);
        Preconditions.checkNotNull(r4);
        return Collector.of(new CollectCollectors$$ExternalSyntheticLambda13(), new CollectCollectors$$ExternalSyntheticLambda14(r3, r4), new CollectCollectors$$ExternalSyntheticLambda15(), new CollectCollectors$$ExternalSyntheticLambda16(), new Collector.Characteristics[0]);
    }

    static /* synthetic */ void lambda$toImmutableBiMap$10(Function r0, Function r1, ImmutableBiMap.Builder r2, Object r3) {
        r2.put(r0.apply(r3), r1.apply(r3));
    }

    static <T, K extends Enum<K>, V> Collector<T, ?, ImmutableMap<K, V>> toImmutableEnumMap(final Function<? super T, ? extends K> r5, final Function<? super T, ? extends V> r6) {
        Preconditions.checkNotNull(r5);
        Preconditions.checkNotNull(r6);
        return Collector.of(new CollectCollectors$$ExternalSyntheticLambda8(), new CollectCollectors$$ExternalSyntheticLambda9(r5, r6), new CollectCollectors$$ExternalSyntheticLambda10(), new CollectCollectors$$ExternalSyntheticLambda12(), new Collector.Characteristics[]{Collector.Characteristics.UNORDERED});
    }

    static /* synthetic */ EnumMapAccumulator lambda$toImmutableEnumMap$12() {
        return new EnumMapAccumulator(new CollectCollectors$$ExternalSyntheticLambda43());
    }

    static /* synthetic */ Object lambda$toImmutableEnumMap$11(Object r3, Object r4) {
        String r5 = String.valueOf(r3);
        String r6 = String.valueOf(r4);
        throw new IllegalArgumentException(new StringBuilder((String.valueOf(r5).length() + 27) + String.valueOf(r6).length()).append("Multiple values for key: ").append(r5).append(", ").append(r6).toString());
    }

    static /* synthetic */ void lambda$toImmutableEnumMap$13(Function r1, Function r2, EnumMapAccumulator r3, Object r4) {
        Enum r5 = (Enum) r1.apply(r4);
        Object r6 = r2.apply(r4);
        r3.put((Enum) Preconditions.checkNotNull(r5, "Null key for input %s", r4), Preconditions.checkNotNull(r6, "Null value for input %s", r4));
    }

    static <T, K extends Enum<K>, V> Collector<T, ?, ImmutableMap<K, V>> toImmutableEnumMap(final Function<? super T, ? extends K> r2, final Function<? super T, ? extends V> r3, final BinaryOperator<V> r4) {
        Preconditions.checkNotNull(r2);
        Preconditions.checkNotNull(r3);
        Preconditions.checkNotNull(r4);
        return Collector.of(new CollectCollectors$$ExternalSyntheticLambda49(r4), new CollectCollectors$$ExternalSyntheticLambda50(r2, r3), new CollectCollectors$$ExternalSyntheticLambda10(), new CollectCollectors$$ExternalSyntheticLambda12(), new Collector.Characteristics[0]);
    }

    static /* synthetic */ EnumMapAccumulator lambda$toImmutableEnumMap$14(BinaryOperator r1) {
        return new EnumMapAccumulator(r1);
    }

    static /* synthetic */ void lambda$toImmutableEnumMap$15(Function r1, Function r2, EnumMapAccumulator r3, Object r4) {
        Enum r5 = (Enum) r1.apply(r4);
        Object r6 = r2.apply(r4);
        r3.put((Enum) Preconditions.checkNotNull(r5, "Null key for input %s", r4), Preconditions.checkNotNull(r6, "Null value for input %s", r4));
    }

    static <T, K extends Comparable<? super K>, V> Collector<T, ?, ImmutableRangeMap<K, V>> toImmutableRangeMap(final Function<? super T, Range<K>> r3, final Function<? super T, ? extends V> r4) {
        Preconditions.checkNotNull(r3);
        Preconditions.checkNotNull(r4);
        return Collector.of(new CollectCollectors$$ExternalSyntheticLambda39(), new CollectCollectors$$ExternalSyntheticLambda40(r3, r4), new CollectCollectors$$ExternalSyntheticLambda41(), new CollectCollectors$$ExternalSyntheticLambda42(), new Collector.Characteristics[0]);
    }

    static /* synthetic */ void lambda$toImmutableRangeMap$16(Function r0, Function r1, ImmutableRangeMap.Builder r2, Object r3) {
        r2.put((Range) r0.apply(r3), r1.apply(r3));
    }

    static <T, K, V> Collector<T, ?, ImmutableListMultimap<K, V>> toImmutableListMultimap(final Function<? super T, ? extends K> r3, final Function<? super T, ? extends V> r4) {
        Preconditions.checkNotNull(r3, "keyFunction");
        Preconditions.checkNotNull(r4, "valueFunction");
        return Collector.of(new CollectCollectors$$ExternalSyntheticLambda56(), new CollectCollectors$$ExternalSyntheticLambda57(r3, r4), new CollectCollectors$$ExternalSyntheticLambda58(), new CollectCollectors$$ExternalSyntheticLambda59(), new Collector.Characteristics[0]);
    }

    static /* synthetic */ void lambda$toImmutableListMultimap$17(Function r0, Function r1, ImmutableListMultimap.Builder r2, Object r3) {
        r2.put(r0.apply(r3), r1.apply(r3));
    }

    static <T, K, V> Collector<T, ?, ImmutableListMultimap<K, V>> flatteningToImmutableListMultimap(final Function<? super T, ? extends K> r2, final Function<? super T, ? extends Stream<? extends V>> r3) {
        Preconditions.checkNotNull(r2);
        Preconditions.checkNotNull(r3);
        Function r0 = new CollectCollectors$$ExternalSyntheticLambda44(r2);
        Function r4 = new CollectCollectors$$ExternalSyntheticLambda55(r3);
        final MultimapBuilder.ListMultimapBuilder<Object, Object> r5 = MultimapBuilder.linkedHashKeys().arrayListValues();
        Objects.requireNonNull(r5);
        return Collectors.collectingAndThen(flatteningToMultimap(r0, r4, new CollectCollectors$$ExternalSyntheticLambda66(r5)), new CollectCollectors$$ExternalSyntheticLambda68());
    }

    static /* synthetic */ Object lambda$flatteningToImmutableListMultimap$18(Function r0, Object r1) {
        return Preconditions.checkNotNull(r0.apply(r1));
    }

    static /* synthetic */ Stream lambda$flatteningToImmutableListMultimap$19(Function r0, Object r1) {
        return ((Stream) r0.apply(r1)).peek(new CollectCollectors$$ExternalSyntheticLambda1());
    }

    static <T, K, V> Collector<T, ?, ImmutableSetMultimap<K, V>> toImmutableSetMultimap(final Function<? super T, ? extends K> r3, final Function<? super T, ? extends V> r4) {
        Preconditions.checkNotNull(r3, "keyFunction");
        Preconditions.checkNotNull(r4, "valueFunction");
        return Collector.of(new CollectCollectors$$ExternalSyntheticLambda35(), new CollectCollectors$$ExternalSyntheticLambda36(r3, r4), new CollectCollectors$$ExternalSyntheticLambda37(), new CollectCollectors$$ExternalSyntheticLambda38(), new Collector.Characteristics[0]);
    }

    static /* synthetic */ void lambda$toImmutableSetMultimap$20(Function r0, Function r1, ImmutableSetMultimap.Builder r2, Object r3) {
        r2.put(r0.apply(r3), r1.apply(r3));
    }

    static <T, K, V> Collector<T, ?, ImmutableSetMultimap<K, V>> flatteningToImmutableSetMultimap(final Function<? super T, ? extends K> r2, final Function<? super T, ? extends Stream<? extends V>> r3) {
        Preconditions.checkNotNull(r2);
        Preconditions.checkNotNull(r3);
        Function r0 = new CollectCollectors$$ExternalSyntheticLambda30(r2);
        Function r4 = new CollectCollectors$$ExternalSyntheticLambda31(r3);
        final MultimapBuilder.SetMultimapBuilder<Object, Object> r5 = MultimapBuilder.linkedHashKeys().linkedHashSetValues();
        Objects.requireNonNull(r5);
        return Collectors.collectingAndThen(flatteningToMultimap(r0, r4, new CollectCollectors$$ExternalSyntheticLambda32(r5)), new CollectCollectors$$ExternalSyntheticLambda34());
    }

    static /* synthetic */ Object lambda$flatteningToImmutableSetMultimap$21(Function r0, Object r1) {
        return Preconditions.checkNotNull(r0.apply(r1));
    }

    static /* synthetic */ Stream lambda$flatteningToImmutableSetMultimap$22(Function r0, Object r1) {
        return ((Stream) r0.apply(r1)).peek(new CollectCollectors$$ExternalSyntheticLambda1());
    }

    static <T, K, V, M extends Multimap<K, V>> Collector<T, ?, M> toMultimap(final Function<? super T, ? extends K> r1, final Function<? super T, ? extends V> r2, Supplier<M> r3) {
        Preconditions.checkNotNull(r1);
        Preconditions.checkNotNull(r2);
        Preconditions.checkNotNull(r3);
        return Collector.of(r3, new CollectCollectors$$ExternalSyntheticLambda64(r1, r2), new CollectCollectors$$ExternalSyntheticLambda65(), new Collector.Characteristics[0]);
    }

    static /* synthetic */ void lambda$toMultimap$23(Function r0, Function r1, Multimap r2, Object r3) {
        r2.put(r0.apply(r3), r1.apply(r3));
    }

    static /* synthetic */ Multimap lambda$toMultimap$24(Multimap r0, Multimap r1) {
        r0.putAll(r1);
        return r0;
    }

    static <T, K, V, M extends Multimap<K, V>> Collector<T, ?, M> flatteningToMultimap(final Function<? super T, ? extends K> r1, final Function<? super T, ? extends Stream<? extends V>> r2, Supplier<M> r3) {
        Preconditions.checkNotNull(r1);
        Preconditions.checkNotNull(r2);
        Preconditions.checkNotNull(r3);
        return Collector.of(r3, new CollectCollectors$$ExternalSyntheticLambda69(r1, r2), new CollectCollectors$$ExternalSyntheticLambda70(), new Collector.Characteristics[0]);
    }

    static /* synthetic */ void lambda$flatteningToMultimap$25(Function r0, Function r1, Multimap r2, Object r3) {
        final Collection r4 = r2.get(r0.apply(r3));
        Stream r5 = (Stream) r1.apply(r3);
        Objects.requireNonNull(r4);
        r5.forEachOrdered(new CollectCollectors$$ExternalSyntheticLambda67(r4));
    }

    static /* synthetic */ Multimap lambda$flatteningToMultimap$26(Multimap r0, Multimap r1) {
        r0.putAll(r1);
        return r0;
    }
}
