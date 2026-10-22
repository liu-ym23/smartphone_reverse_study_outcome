package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public abstract class MultimapBuilder<K0, V0> {
    private static final int DEFAULT_EXPECTED_KEYS = 8;

    private static final class ArrayListSupplier<V> implements Supplier<List<V>>, Serializable {
        private final int expectedValuesPerKey;

        @Override // com.google.common.base.Supplier, java.util.function.Supplier
        public /* bridge */ /* synthetic */ Object get() {
            return get();
        }

        ArrayListSupplier(int r2) {
            this.expectedValuesPerKey = CollectPreconditions.checkNonnegative(r2, "expectedValuesPerKey");
        }

        @Override // com.google.common.base.Supplier, java.util.function.Supplier
        public List<V> get() {
            return new ArrayList(this.expectedValuesPerKey);
        }
    }

    private static final class EnumSetSupplier<V extends Enum<V>> implements Supplier<Set<V>>, Serializable {
        private final Class<V> clazz;

        @Override // com.google.common.base.Supplier, java.util.function.Supplier
        public /* bridge */ /* synthetic */ Object get() {
            return get();
        }

        EnumSetSupplier(Class<V> r1) {
            this.clazz = (Class) Preconditions.checkNotNull(r1);
        }

        @Override // com.google.common.base.Supplier, java.util.function.Supplier
        public Set<V> get() {
            return EnumSet.noneOf(this.clazz);
        }
    }

    private static final class HashSetSupplier<V> implements Supplier<Set<V>>, Serializable {
        private final int expectedValuesPerKey;

        @Override // com.google.common.base.Supplier, java.util.function.Supplier
        public /* bridge */ /* synthetic */ Object get() {
            return get();
        }

        HashSetSupplier(int r2) {
            this.expectedValuesPerKey = CollectPreconditions.checkNonnegative(r2, "expectedValuesPerKey");
        }

        @Override // com.google.common.base.Supplier, java.util.function.Supplier
        public Set<V> get() {
            return Platform.newHashSetWithExpectedSize(this.expectedValuesPerKey);
        }
    }

    private static final class LinkedHashSetSupplier<V> implements Supplier<Set<V>>, Serializable {
        private final int expectedValuesPerKey;

        @Override // com.google.common.base.Supplier, java.util.function.Supplier
        public /* bridge */ /* synthetic */ Object get() {
            return get();
        }

        LinkedHashSetSupplier(int r2) {
            this.expectedValuesPerKey = CollectPreconditions.checkNonnegative(r2, "expectedValuesPerKey");
        }

        @Override // com.google.common.base.Supplier, java.util.function.Supplier
        public Set<V> get() {
            return Platform.newLinkedHashSetWithExpectedSize(this.expectedValuesPerKey);
        }
    }

    private static final enum LinkedListSupplier extends Enum<LinkedListSupplier> implements Supplier<List<?>> {
        private static final /* synthetic */ LinkedListSupplier[] $VALUES = null;
        public static final LinkedListSupplier INSTANCE = null;

        private static /* synthetic */ LinkedListSupplier[] $values() {
            return new LinkedListSupplier[]{INSTANCE};
        }

        private LinkedListSupplier(String r1, int r2) {
            super(r1, r2);
        }

        public static LinkedListSupplier valueOf(String r1) {
            return (LinkedListSupplier) Enum.valueOf(LinkedListSupplier.class, r1);
        }

        public static LinkedListSupplier[] values() {
            return (LinkedListSupplier[]) $VALUES.clone();
        }

        @Override // com.google.common.base.Supplier, java.util.function.Supplier
        public /* bridge */ /* synthetic */ Object get() {
            return get();
        }

        static {
            INSTANCE = new LinkedListSupplier("INSTANCE", 0);
            $VALUES = $values();
        }

        public static <V> Supplier<List<V>> instance() {
            return INSTANCE;
        }

        @Override // com.google.common.base.Supplier, java.util.function.Supplier
        public List<?> get() {
            return new LinkedList();
        }
    }

    public static abstract class ListMultimapBuilder<K0, V0> extends MultimapBuilder<K0, V0> {
        @Override // com.google.common.collect.MultimapBuilder
        public abstract <K extends K0, V extends V0> ListMultimap<K, V> build();

        @Override // com.google.common.collect.MultimapBuilder
        public /* bridge */ /* synthetic */ Multimap build() {
            return build();
        }

        @Override // com.google.common.collect.MultimapBuilder
        public /* bridge */ /* synthetic */ Multimap build(Multimap r1) {
            return build(r1);
        }

        ListMultimapBuilder() {
            super(null);
        }

        @Override // com.google.common.collect.MultimapBuilder
        public <K extends K0, V extends V0> ListMultimap<K, V> build(Multimap<? extends K, ? extends V> r1) {
            return (ListMultimap) super.build(r1);
        }
    }

    public static abstract class MultimapBuilderWithKeys<K0> {
        private static final int DEFAULT_EXPECTED_VALUES_PER_KEY = 2;

        abstract <K extends K0, V> Map<K, Collection<V>> createMap();

        MultimapBuilderWithKeys() {
        }

        public ListMultimapBuilder<K0, Object> arrayListValues() {
            return arrayListValues(2);
        }

        public ListMultimapBuilder<K0, Object> arrayListValues(final int r2) {
            CollectPreconditions.checkNonnegative(r2, "expectedValuesPerKey");
            return new AnonymousClass1(this, r2);
        }

        public ListMultimapBuilder<K0, Object> linkedListValues() {
            return new AnonymousClass2(this);
        }

        public SetMultimapBuilder<K0, Object> hashSetValues() {
            return hashSetValues(2);
        }

        public SetMultimapBuilder<K0, Object> hashSetValues(final int r2) {
            CollectPreconditions.checkNonnegative(r2, "expectedValuesPerKey");
            return new AnonymousClass3(this, r2);
        }

        public SetMultimapBuilder<K0, Object> linkedHashSetValues() {
            return linkedHashSetValues(2);
        }

        public SetMultimapBuilder<K0, Object> linkedHashSetValues(final int r2) {
            CollectPreconditions.checkNonnegative(r2, "expectedValuesPerKey");
            return new AnonymousClass4(this, r2);
        }

        public SortedSetMultimapBuilder<K0, Comparable> treeSetValues() {
            return treeSetValues(Ordering.natural());
        }

        public <V0> SortedSetMultimapBuilder<K0, V0> treeSetValues(final Comparator<V0> r2) {
            Preconditions.checkNotNull(r2, "comparator");
            return new AnonymousClass5(this, r2);
        }

        public <V0 extends Enum<V0>> SetMultimapBuilder<K0, V0> enumSetValues(final Class<V0> r2) {
            Preconditions.checkNotNull(r2, "valueClass");
            return new AnonymousClass6(this, r2);
        }
    }

    public static abstract class SetMultimapBuilder<K0, V0> extends MultimapBuilder<K0, V0> {
        @Override // com.google.common.collect.MultimapBuilder
        public abstract <K extends K0, V extends V0> SetMultimap<K, V> build();

        @Override // com.google.common.collect.MultimapBuilder
        public /* bridge */ /* synthetic */ Multimap build() {
            return build();
        }

        @Override // com.google.common.collect.MultimapBuilder
        public /* bridge */ /* synthetic */ Multimap build(Multimap r1) {
            return build(r1);
        }

        SetMultimapBuilder() {
            super(null);
        }

        @Override // com.google.common.collect.MultimapBuilder
        public <K extends K0, V extends V0> SetMultimap<K, V> build(Multimap<? extends K, ? extends V> r1) {
            return (SetMultimap) super.build(r1);
        }
    }

    public static abstract class SortedSetMultimapBuilder<K0, V0> extends SetMultimapBuilder<K0, V0> {
        @Override // com.google.common.collect.MultimapBuilder.SetMultimapBuilder, com.google.common.collect.MultimapBuilder
        public abstract <K extends K0, V extends V0> SortedSetMultimap<K, V> build();

        @Override // com.google.common.collect.MultimapBuilder.SetMultimapBuilder, com.google.common.collect.MultimapBuilder
        public /* bridge */ /* synthetic */ Multimap build() {
            return build();
        }

        @Override // com.google.common.collect.MultimapBuilder.SetMultimapBuilder, com.google.common.collect.MultimapBuilder
        public /* bridge */ /* synthetic */ Multimap build(Multimap r1) {
            return build(r1);
        }

        @Override // com.google.common.collect.MultimapBuilder.SetMultimapBuilder, com.google.common.collect.MultimapBuilder
        public /* bridge */ /* synthetic */ SetMultimap build() {
            return build();
        }

        @Override // com.google.common.collect.MultimapBuilder.SetMultimapBuilder, com.google.common.collect.MultimapBuilder
        public /* bridge */ /* synthetic */ SetMultimap build(Multimap r1) {
            return build(r1);
        }

        SortedSetMultimapBuilder() {
        }

        @Override // com.google.common.collect.MultimapBuilder.SetMultimapBuilder, com.google.common.collect.MultimapBuilder
        public <K extends K0, V extends V0> SortedSetMultimap<K, V> build(Multimap<? extends K, ? extends V> r1) {
            return (SortedSetMultimap) super.build(r1);
        }
    }

    private static final class TreeSetSupplier<V> implements Supplier<SortedSet<V>>, Serializable {
        private final Comparator<? super V> comparator;

        @Override // com.google.common.base.Supplier, java.util.function.Supplier
        public /* bridge */ /* synthetic */ Object get() {
            return get();
        }

        TreeSetSupplier(Comparator<? super V> r1) {
            this.comparator = (Comparator) Preconditions.checkNotNull(r1);
        }

        @Override // com.google.common.base.Supplier, java.util.function.Supplier
        public SortedSet<V> get() {
            return new TreeSet(this.comparator);
        }
    }

    public abstract <K extends K0, V extends V0> Multimap<K, V> build();

    /* synthetic */ MultimapBuilder(AnonymousClass1 r1) {
        this();
    }

    private MultimapBuilder() {
    }

    public static MultimapBuilderWithKeys<Object> hashKeys() {
        return hashKeys(8);
    }

    public static MultimapBuilderWithKeys<Object> hashKeys(final int r1) {
        CollectPreconditions.checkNonnegative(r1, "expectedKeys");
        return new AnonymousClass1(r1);
    }

    public static MultimapBuilderWithKeys<Object> linkedHashKeys() {
        return linkedHashKeys(8);
    }

    public static MultimapBuilderWithKeys<Object> linkedHashKeys(final int r1) {
        CollectPreconditions.checkNonnegative(r1, "expectedKeys");
        return new AnonymousClass2(r1);
    }

    public static MultimapBuilderWithKeys<Comparable> treeKeys() {
        return treeKeys(Ordering.natural());
    }

    public static <K0> MultimapBuilderWithKeys<K0> treeKeys(final Comparator<K0> r1) {
        Preconditions.checkNotNull(r1);
        return new AnonymousClass3(r1);
    }

    public static <K0 extends Enum<K0>> MultimapBuilderWithKeys<K0> enumKeys(final Class<K0> r1) {
        Preconditions.checkNotNull(r1);
        return new AnonymousClass4(r1);
    }

    public <K extends K0, V extends V0> Multimap<K, V> build(Multimap<? extends K, ? extends V> r1) {
        Multimap<K, V> r0 = build();
        r0.putAll(r1);
        return r0;
    }
}
