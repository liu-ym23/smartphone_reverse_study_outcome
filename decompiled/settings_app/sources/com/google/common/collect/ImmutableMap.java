package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.DoNotMock;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@DoNotMock("Use ImmutableMap.of or another implementation")
@ElementTypesAreNonnullByDefault
public abstract class ImmutableMap<K, V> implements Map<K, V>, Serializable {
    static final Map.Entry<?, ?>[] EMPTY_ENTRY_ARRAY = null;

    @CheckForNull
    @LazyInit
    private transient ImmutableSet<Map.Entry<K, V>> entrySet;

    @CheckForNull
    @LazyInit
    private transient ImmutableSet<K> keySet;

    @CheckForNull
    @LazyInit
    private transient ImmutableSetMultimap<K, V> multimapView;

    @CheckForNull
    @LazyInit
    private transient ImmutableCollection<V> values;

    @DoNotMock
    public static class Builder<K, V> {
        Map.Entry<K, V>[] entries;
        boolean entriesUsed;
        int size;

        @CheckForNull
        Comparator<? super V> valueComparator;

        public Builder() {
            this(4);
        }

        Builder(int r1) {
            this.entries = new Map.Entry[r1];
            this.size = 0;
            this.entriesUsed = false;
        }

        private void ensureCapacity(int r3) {
            Map.Entry<K, V>[] r0 = this.entries;
            if (r3 <= r0.length) goto L6;
            this.entries = (Map.Entry[]) Arrays.copyOf(r0, ImmutableCollection.Builder.expandedCapacity(r0.length, r3));
            this.entriesUsed = false;
            return;
        }

        public Builder<K, V> put(K r3, V r4) {
            ensureCapacity(this.size + 1);
            Map.Entry<K, V> r5 = ImmutableMap.entryOf(r3, r4);
            Map.Entry<K, V>[] r6 = this.entries;
            int r0 = this.size;
            this.size = r0 + 1;
            r6[r0] = r5;
            return this;
        }

        public Builder<K, V> put(Map.Entry<? extends K, ? extends V> r2) {
            return put(r2.getKey(), r2.getValue());
        }

        public Builder<K, V> putAll(Map<? extends K, ? extends V> r1) {
            return putAll(r1.entrySet());
        }

        public Builder<K, V> putAll(Iterable<? extends Map.Entry<? extends K, ? extends V>> r3) {
            if ((r3 instanceof Collection) == false) goto L5;
            ensureCapacity(this.size + ((Collection) r3).size());
        L5:
            Iterator<? extends Map.Entry<? extends K, ? extends V>> r4 = r3.iterator();
        L7:
            if (r4.hasNext() == false) goto L9;
            put(r4.next());
            goto L7
        L9:
            return this;
        }

        public Builder<K, V> orderEntriesByValue(Comparator<? super V> r3) {
            if (this.valueComparator != null) goto L5;
            boolean r0 = true;
        L6:
            Preconditions.checkState(r0, "valueComparator was already set");
            this.valueComparator = (Comparator) Preconditions.checkNotNull(r3, "valueComparator");
            return this;
        L5:
            r0 = false;
            goto L6
        }

        Builder<K, V> combine(Builder<K, V> r6) {
            Preconditions.checkNotNull(r6);
            ensureCapacity(this.size + r6.size);
            System.arraycopy(r6.entries, 0, this.entries, this.size, r6.size);
            this.size += r6.size;
            return this;
        }

        public ImmutableMap<K, V> build() {
            return buildOrThrow();
        }

        public ImmutableMap<K, V> buildOrThrow() {
            if (this.valueComparator != null) goto L5;
        L8:
            int r0 = this.size;
            if (r0 == 0) goto L17;
            if (r0 == 1) goto L14;
            this.entriesUsed = true;
            return RegularImmutableMap.fromEntryArray(r0, this.entries);
        L14:
            Map.Entry r5 = (Map.Entry) Objects.requireNonNull(this.entries[0]);
            return ImmutableMap.of(r5.getKey(), r5.getValue());
        L17:
            return ImmutableMap.of();
        L5:
            if (this.entriesUsed == false) goto L7;
            this.entries = (Map.Entry[]) Arrays.copyOf(this.entries, this.size);
        L7:
            Arrays.sort(this.entries, 0, this.size, Ordering.from(this.valueComparator).onResultOf(Maps.valueFunction()));
            goto L8
        }

        ImmutableMap<K, V> buildJdkBacked() {
            if (this.valueComparator != null) goto L5;
            boolean r0 = true;
        L6:
            Preconditions.checkState(r0, "buildJdkBacked is only for testing; can't use valueComparator");
            int r1 = this.size;
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L11;
            this.entriesUsed = true;
            return JdkBackedImmutableMap.create(r1, this.entries);
        L11:
            Map.Entry r4 = (Map.Entry) Objects.requireNonNull(this.entries[0]);
            return ImmutableMap.of(r4.getKey(), r4.getValue());
        L14:
            return ImmutableMap.of();
        L5:
            r0 = false;
            goto L6
        }
    }

    static abstract class IteratorBasedImmutableMap<K, V> extends ImmutableMap<K, V> {
        abstract UnmodifiableIterator<Map.Entry<K, V>> entryIterator();

        IteratorBasedImmutableMap() {
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Set entrySet() {
            return super.entrySet();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Set keySet() {
            return super.keySet();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map, com.google.common.collect.BiMap
        public /* bridge */ /* synthetic */ Collection values() {
            return super.values();
        }

        Spliterator<Map.Entry<K, V>> entrySpliterator() {
            return Spliterators.spliterator(entryIterator(), size(), 1297);
        }

        @Override // com.google.common.collect.ImmutableMap
        ImmutableSet<K> createKeySet() {
            return new ImmutableMapKeySet(this);
        }

        @Override // com.google.common.collect.ImmutableMap
        ImmutableSet<Map.Entry<K, V>> createEntrySet() {
            return new C1EntrySetImpl(this);
        }

        @Override // com.google.common.collect.ImmutableMap
        ImmutableCollection<V> createValues() {
            return new ImmutableMapValues(this);
        }
    }

    private final class MapViewOfValuesAsSingletonSets extends IteratorBasedImmutableMap<K, ImmutableSet<V>> {
        final /* synthetic */ ImmutableMap this$0;

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        @CheckForNull
        public /* bridge */ /* synthetic */ Object get(@CheckForNull Object r1) {
            return get(r1);
        }

        private MapViewOfValuesAsSingletonSets(ImmutableMap r1) {
            this.this$0 = r1;
        }

        /* synthetic */ MapViewOfValuesAsSingletonSets(ImmutableMap r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.util.Map
        public int size() {
            return this.this$0.size();
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap, com.google.common.collect.ImmutableMap
        ImmutableSet<K> createKeySet() {
            return this.this$0.keySet();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public boolean containsKey(@CheckForNull Object r1) {
            return this.this$0.containsKey(r1);
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        @CheckForNull
        public ImmutableSet<V> get(@CheckForNull Object r1) {
            Object r0 = this.this$0.get(r1);
            if (r0 != null) goto L6;
            return null;
        L6:
            return ImmutableSet.of(r0);
        }

        @Override // com.google.common.collect.ImmutableMap
        boolean isPartialView() {
            return this.this$0.isPartialView();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public int hashCode() {
            return this.this$0.hashCode();
        }

        @Override // com.google.common.collect.ImmutableMap
        boolean isHashCodeFast() {
            return this.this$0.isHashCodeFast();
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap
        UnmodifiableIterator<Map.Entry<K, ImmutableSet<V>>> entryIterator() {
            final UnmodifiableIterator<Map.Entry<K, V>> r0 = this.this$0.entrySet().iterator();
            return new AnonymousClass1(this, r0);
        }
    }

    static class SerializedForm<K, V> implements Serializable {
        private static final boolean USE_LEGACY_SERIALIZATION = true;
        private static final long serialVersionUID = 0;
        private final Object keys;
        private final Object values;

        SerializedForm(ImmutableMap<K, V> r6) {
            Object[] r0 = new Object[r6.size()];
            Object[] r1 = new Object[r6.size()];
            UnmodifiableIterator<Map.Entry<K, V>> r7 = r6.entrySet().iterator();
            int r2 = 0;
        L4:
            if (r7.hasNext() == false) goto L6;
            Map.Entry<K, V> r3 = r7.next();
            r0[r2] = r3.getKey();
            r1[r2] = r3.getValue();
            r2 = r2 + 1;
            goto L4
        L6:
            this.keys = r0;
            this.values = r1;
        }

        final Object readResolve() {
            Object r0 = this.keys;
            if ((r0 instanceof ImmutableSet) == false) goto L5;
            ImmutableSet r1 = (ImmutableSet) r0;
            ImmutableCollection r2 = (ImmutableCollection) this.values;
            Builder<K, V> r4 = makeBuilder(r1.size());
            UnmodifiableIterator r3 = r1.iterator();
            UnmodifiableIterator r5 = r2.iterator();
        L8:
            if (r3.hasNext() == false) goto L11;
            r4.put(r3.next(), r5.next());
            goto L8
        L11:
            return r4.build();
        L5:
            return legacyReadResolve();
        }

        /* JADX WARN: Multi-variable type inference failed */
        final Object legacyReadResolve() {
            Object[] r0 = (Object[]) this.keys;
            Object[] r1 = (Object[]) this.values;
            Builder<K, V> r5 = makeBuilder(r0.length);
            int r2 = 0;
        L4:
            if (r2 >= r0.length) goto L7;
            r5.put(r0[r2], r1[r2]);
            r2 = r2 + 1;
            goto L4
        L7:
            return r5.build();
        }

        Builder<K, V> makeBuilder(int r1) {
            return new Builder(r1);
        }
    }

    abstract ImmutableSet<Map.Entry<K, V>> createEntrySet();

    abstract ImmutableSet<K> createKeySet();

    abstract ImmutableCollection<V> createValues();

    @Override // java.util.Map
    @CheckForNull
    public abstract V get(@CheckForNull Object r1);

    boolean isHashCodeFast() {
        return false;
    }

    abstract boolean isPartialView();

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Set entrySet() {
        return entrySet();
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Set keySet() {
        return keySet();
    }

    @Override // java.util.Map, com.google.common.collect.BiMap
    public /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    public static <T, K, V> Collector<T, ?, ImmutableMap<K, V>> toImmutableMap(Function<? super T, ? extends K> r0, Function<? super T, ? extends V> r1) {
        return CollectCollectors.toImmutableMap(r0, r1);
    }

    public static <T, K, V> Collector<T, ?, ImmutableMap<K, V>> toImmutableMap(Function<? super T, ? extends K> r0, Function<? super T, ? extends V> r1, BinaryOperator<V> r2) {
        return CollectCollectors.toImmutableMap(r0, r1, r2);
    }

    public static <K, V> ImmutableMap<K, V> of() {
        return (ImmutableMap<K, V>) RegularImmutableMap.EMPTY;
    }

    public static <K, V> ImmutableMap<K, V> of(K r0, V r1) {
        return ImmutableBiMap.of(r0, r1);
    }

    public static <K, V> ImmutableMap<K, V> of(K r2, V r3, K r4, V r5) {
        return RegularImmutableMap.fromEntries(new Map.Entry[]{entryOf(r2, r3), entryOf(r4, r5)});
    }

    public static <K, V> ImmutableMap<K, V> of(K r2, V r3, K r4, V r5, K r6, V r7) {
        return RegularImmutableMap.fromEntries(new Map.Entry[]{entryOf(r2, r3), entryOf(r4, r5), entryOf(r6, r7)});
    }

    public static <K, V> ImmutableMap<K, V> of(K r2, V r3, K r4, V r5, K r6, V r7, K r8, V r9) {
        return RegularImmutableMap.fromEntries(new Map.Entry[]{entryOf(r2, r3), entryOf(r4, r5), entryOf(r6, r7), entryOf(r8, r9)});
    }

    public static <K, V> ImmutableMap<K, V> of(K r2, V r3, K r4, V r5, K r6, V r7, K r8, V r9, K r10, V r11) {
        return RegularImmutableMap.fromEntries(new Map.Entry[]{entryOf(r2, r3), entryOf(r4, r5), entryOf(r6, r7), entryOf(r8, r9), entryOf(r10, r11)});
    }

    public static <K, V> ImmutableMap<K, V> of(K r2, V r3, K r4, V r5, K r6, V r7, K r8, V r9, K r10, V r11, K r12, V r13) {
        return RegularImmutableMap.fromEntries(new Map.Entry[]{entryOf(r2, r3), entryOf(r4, r5), entryOf(r6, r7), entryOf(r8, r9), entryOf(r10, r11), entryOf(r12, r13)});
    }

    public static <K, V> ImmutableMap<K, V> of(K r2, V r3, K r4, V r5, K r6, V r7, K r8, V r9, K r10, V r11, K r12, V r13, K r14, V r15) {
        return RegularImmutableMap.fromEntries(new Map.Entry[]{entryOf(r2, r3), entryOf(r4, r5), entryOf(r6, r7), entryOf(r8, r9), entryOf(r10, r11), entryOf(r12, r13), entryOf(r14, r15)});
    }

    public static <K, V> ImmutableMap<K, V> of(K r3, V r4, K r5, V r6, K r7, V r8, K r9, V r10, K r11, V r12, K r13, V r14, K r15, V r16, K r17, V r18) {
        return RegularImmutableMap.fromEntries(new Map.Entry[]{entryOf(r3, r4), entryOf(r5, r6), entryOf(r7, r8), entryOf(r9, r10), entryOf(r11, r12), entryOf(r13, r14), entryOf(r15, r16), entryOf(r17, r18)});
    }

    public static <K, V> ImmutableMap<K, V> of(K r3, V r4, K r5, V r6, K r7, V r8, K r9, V r10, K r11, V r12, K r13, V r14, K r15, V r16, K r17, V r18, K r19, V r20) {
        return RegularImmutableMap.fromEntries(new Map.Entry[]{entryOf(r3, r4), entryOf(r5, r6), entryOf(r7, r8), entryOf(r9, r10), entryOf(r11, r12), entryOf(r13, r14), entryOf(r15, r16), entryOf(r17, r18), entryOf(r19, r20)});
    }

    public static <K, V> ImmutableMap<K, V> of(K r3, V r4, K r5, V r6, K r7, V r8, K r9, V r10, K r11, V r12, K r13, V r14, K r15, V r16, K r17, V r18, K r19, V r20, K r21, V r22) {
        return RegularImmutableMap.fromEntries(new Map.Entry[]{entryOf(r3, r4), entryOf(r5, r6), entryOf(r7, r8), entryOf(r9, r10), entryOf(r11, r12), entryOf(r13, r14), entryOf(r15, r16), entryOf(r17, r18), entryOf(r19, r20), entryOf(r21, r22)});
    }

    @SafeVarargs
    public static <K, V> ImmutableMap<K, V> ofEntries(Map.Entry<? extends K, ? extends V>... r0) {
        return RegularImmutableMap.fromEntries(r0);
    }

    static <K, V> Map.Entry<K, V> entryOf(K r1, V r2) {
        CollectPreconditions.checkEntryNotNull(r1, r2);
        return new AbstractMap.SimpleImmutableEntry(r1, r2);
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder();
    }

    public static <K, V> Builder<K, V> builderWithExpectedSize(int r1) {
        CollectPreconditions.checkNonnegative(r1, "expectedSize");
        return new Builder(r1);
    }

    static void checkNoConflict(boolean r0, String r1, Map.Entry<?, ?> r2, Map.Entry<?, ?> r3) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw conflictException(r1, r2, r3);
    }

    static IllegalArgumentException conflictException(String r3, Object r4, Object r5) {
        String r6 = String.valueOf(r4);
        String r7 = String.valueOf(r5);
        return new IllegalArgumentException(new StringBuilder(((String.valueOf(r3).length() + 34) + String.valueOf(r6).length()) + String.valueOf(r7).length()).append("Multiple entries with same ").append(r3).append(": ").append(r6).append(" and ").append(r7).toString());
    }

    public static <K, V> ImmutableMap<K, V> copyOf(Map<? extends K, ? extends V> r2) {
        if ((r2 instanceof ImmutableMap) == false) goto L10;
        if ((r2 instanceof SortedMap) == true) goto L10;
        ImmutableMap<K, V> r0 = (ImmutableMap) r2;
        if (r0.isPartialView() == true) goto L14;
        return r0;
    L14:
        return copyOf(r2.entrySet());
    L10:
        if ((r2 instanceof EnumMap) == false) goto L14;
        return copyOfEnumMap((EnumMap) r2);
    }

    public static <K, V> ImmutableMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> r2) {
        Map.Entry[] r3 = (Map.Entry[]) Iterables.toArray(r2, EMPTY_ENTRY_ARRAY);
        int r0 = r3.length;
        if (r0 == 0) goto L11;
        if (r0 != 1) goto L7;
        Map.Entry r4 = (Map.Entry) Objects.requireNonNull(r3[0]);
        return of(r4.getKey(), r4.getValue());
    L7:
        return RegularImmutableMap.fromEntries(r3);
    L11:
        return of();
    }

    private static <K extends Enum<K>, V> ImmutableMap<K, V> copyOfEnumMap(EnumMap<K, ? extends V> r3) {
        EnumMap r0 = new EnumMap(r3);
        Iterator<Map.Entry<K, V>> r4 = r0.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L7;
        Map.Entry<K, V> r1 = r4.next();
        CollectPreconditions.checkEntryNotNull(r1.getKey(), r1.getValue());
        goto L4
    L7:
        return ImmutableEnumMap.asImmutable(r0);
    }

    static {
        EMPTY_ENTRY_ARRAY = new Map.Entry[0];
    }

    ImmutableMap() {
    }

    @Override // java.util.Map
    @CheckForNull
    @Deprecated
    public final V put(K r1, V r2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @CheckForNull
    @Deprecated
    public final V putIfAbsent(K r1, V r2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final boolean replace(K r1, V r2, V r3) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @CheckForNull
    @Deprecated
    public final V replace(K r1, V r2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V computeIfAbsent(K r1, Function<? super K, ? extends V> r2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V computeIfPresent(K r1, BiFunction<? super K, ? super V, ? extends V> r2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V compute(K r1, BiFunction<? super K, ? super V, ? extends V> r2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V merge(K r1, V r2, BiFunction<? super V, ? super V, ? extends V> r3) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> r1) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void replaceAll(BiFunction<? super K, ? super V, ? extends V> r1) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @CheckForNull
    @Deprecated
    public final V remove(@CheckForNull Object r1) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final boolean remove(@CheckForNull Object r1, @CheckForNull Object r2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Map
    public boolean containsKey(@CheckForNull Object r1) {
        if (get(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Map
    public boolean containsValue(@CheckForNull Object r1) {
        return values().contains(r1);
    }

    @Override // java.util.Map
    @CheckForNull
    public final V getOrDefault(@CheckForNull Object r1, @CheckForNull V r2) {
        V r0 = get(r1);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return r2;
    }

    @Override // java.util.Map
    public ImmutableSet<Map.Entry<K, V>> entrySet() {
        ImmutableSet<Map.Entry<K, V>> r0 = this.entrySet;
        if (r0 != null) goto L6;
        ImmutableSet<Map.Entry<K, V>> r1 = createEntrySet();
        this.entrySet = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // java.util.Map
    public ImmutableSet<K> keySet() {
        ImmutableSet<K> r0 = this.keySet;
        if (r0 != null) goto L6;
        ImmutableSet<K> r1 = createKeySet();
        this.keySet = r1;
        return r1;
    L6:
        return r0;
    }

    UnmodifiableIterator<K> keyIterator() {
        final UnmodifiableIterator<Map.Entry<K, V>> r0 = entrySet().iterator();
        return new AnonymousClass1(this, r0);
    }

    Spliterator<K> keySpliterator() {
        return CollectSpliterators.map(entrySet().spliterator(), new ImmutableMap$$ExternalSyntheticLambda0());
    }

    @Override // java.util.Map, com.google.common.collect.BiMap
    public ImmutableCollection<V> values() {
        ImmutableCollection<V> r0 = this.values;
        if (r0 != null) goto L6;
        ImmutableCollection<V> r1 = createValues();
        this.values = r1;
        return r1;
    L6:
        return r0;
    }

    public ImmutableSetMultimap<K, V> asMultimap() {
        if (isEmpty() == true) goto L5;
        ImmutableSetMultimap<K, V> r0 = this.multimapView;
        if (r0 != null) goto L10;
        ImmutableSetMultimap<K, V> r1 = new ImmutableSetMultimap(new MapViewOfValuesAsSingletonSets(this, null), size(), null);
        this.multimapView = r1;
        return r1;
    L10:
        return r0;
    L5:
        return ImmutableSetMultimap.of();
    }

    @Override // java.util.Map
    public boolean equals(@CheckForNull Object r1) {
        return Maps.equalsImpl(this, r1);
    }

    @Override // java.util.Map
    public int hashCode() {
        return Sets.hashCodeImpl(entrySet());
    }

    public String toString() {
        return Maps.toStringImpl(this);
    }

    Object writeReplace() {
        return new SerializedForm(this);
    }
}
