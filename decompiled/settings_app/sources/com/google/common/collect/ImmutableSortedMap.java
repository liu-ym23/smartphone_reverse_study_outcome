package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class ImmutableSortedMap<K, V> extends ImmutableSortedMapFauxverideShim<K, V> implements NavigableMap<K, V> {
    private static final ImmutableSortedMap<Comparable, Object> NATURAL_EMPTY_MAP = null;
    private static final Comparator<Comparable> NATURAL_ORDER = null;
    private static final long serialVersionUID = 0;

    @CheckForNull
    private transient ImmutableSortedMap<K, V> descendingMap;
    private final transient RegularImmutableSortedSet<K> keySet;
    private final transient ImmutableList<V> valueList;

    public static class Builder<K, V> extends ImmutableMap.Builder<K, V> {
        private final Comparator<? super K> comparator;

        @Override // com.google.common.collect.ImmutableMap.Builder
        public /* bridge */ /* synthetic */ ImmutableMap build() {
            return build();
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public /* bridge */ /* synthetic */ ImmutableMap buildOrThrow() {
            return buildOrThrow();
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        /* bridge */ /* synthetic */ ImmutableMap.Builder combine(ImmutableMap.Builder r1) {
            return combine(r1);
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @Deprecated
        public /* bridge */ /* synthetic */ ImmutableMap.Builder orderEntriesByValue(Comparator r1) {
            return orderEntriesByValue(r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMap.Builder
        public /* bridge */ /* synthetic */ ImmutableMap.Builder put(Object r1, Object r2) {
            return put(r1, r2);
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public /* bridge */ /* synthetic */ ImmutableMap.Builder put(Map.Entry r1) {
            return put(r1);
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public /* bridge */ /* synthetic */ ImmutableMap.Builder putAll(Iterable r1) {
            return putAll(r1);
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public /* bridge */ /* synthetic */ ImmutableMap.Builder putAll(Map r1) {
            return putAll(r1);
        }

        public Builder(Comparator<? super K> r1) {
            this.comparator = (Comparator) Preconditions.checkNotNull(r1);
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public Builder<K, V> put(K r1, V r2) {
            super.put(r1, r2);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public Builder<K, V> put(Map.Entry<? extends K, ? extends V> r1) {
            super.put(r1);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public Builder<K, V> putAll(Map<? extends K, ? extends V> r1) {
            super.putAll(r1);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public Builder<K, V> putAll(Iterable<? extends Map.Entry<? extends K, ? extends V>> r1) {
            super.putAll(r1);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @Deprecated
        public final Builder<K, V> orderEntriesByValue(Comparator<? super V> r1) {
            throw new UnsupportedOperationException("Not available on ImmutableSortedMap.Builder");
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        Builder<K, V> combine(ImmutableMap.Builder<K, V> r1) {
            super.combine(r1);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public ImmutableSortedMap<K, V> build() {
            return buildOrThrow();
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public ImmutableSortedMap<K, V> buildOrThrow() {
            int r0 = this.size;
            if (r0 == 0) goto L11;
            if (r0 != 1) goto L7;
            Map.Entry r1 = (Map.Entry) Objects.requireNonNull(this.entries[0]);
            return ImmutableSortedMap.access$000(this.comparator, r1.getKey(), r1.getValue());
        L7:
            return ImmutableSortedMap.access$100(this.comparator, false, this.entries, this.size);
        L11:
            return ImmutableSortedMap.emptyMap(this.comparator);
        }
    }

    private static class SerializedForm<K, V> extends ImmutableMap.SerializedForm<K, V> {
        private static final long serialVersionUID = 0;
        private final Comparator<? super K> comparator;

        @Override // com.google.common.collect.ImmutableMap.SerializedForm
        /* bridge */ /* synthetic */ ImmutableMap.Builder makeBuilder(int r1) {
            return makeBuilder(r1);
        }

        SerializedForm(ImmutableSortedMap<K, V> r1) {
            super(r1);
            this.comparator = r1.comparator();
        }

        @Override // com.google.common.collect.ImmutableMap.SerializedForm
        Builder<K, V> makeBuilder(int r1) {
            return new Builder(this.comparator);
        }
    }

    @Override // java.util.NavigableMap
    public /* bridge */ /* synthetic */ NavigableSet descendingKeySet() {
        return descendingKeySet();
    }

    @Override // java.util.NavigableMap
    public /* bridge */ /* synthetic */ NavigableMap descendingMap() {
        return descendingMap();
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public /* bridge */ /* synthetic */ Set entrySet() {
        return entrySet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public /* bridge */ /* synthetic */ NavigableMap headMap(Object r1, boolean r2) {
        return headMap(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap, java.util.SortedMap
    public /* bridge */ /* synthetic */ SortedMap headMap(Object r1) {
        return headMap(r1);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public /* bridge */ /* synthetic */ ImmutableSet keySet() {
        return keySet();
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public /* bridge */ /* synthetic */ Set keySet() {
        return keySet();
    }

    @Override // java.util.NavigableMap
    public /* bridge */ /* synthetic */ NavigableSet navigableKeySet() {
        return navigableKeySet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public /* bridge */ /* synthetic */ NavigableMap subMap(Object r1, boolean r2, Object r3, boolean r4) {
        return subMap(r1, r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap, java.util.SortedMap
    public /* bridge */ /* synthetic */ SortedMap subMap(Object r1, Object r2) {
        return subMap(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public /* bridge */ /* synthetic */ NavigableMap tailMap(Object r1, boolean r2) {
        return tailMap(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap, java.util.SortedMap
    public /* bridge */ /* synthetic */ SortedMap tailMap(Object r1) {
        return tailMap(r1);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map, com.google.common.collect.BiMap
    public /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    static /* synthetic */ ImmutableSortedMap access$000(Comparator r0, Object r1, Object r2) {
        return of(r0, r1, r2);
    }

    static /* synthetic */ ImmutableSortedMap access$100(Comparator r0, boolean r1, Map.Entry[] r2, int r3) {
        return fromEntries(r0, r1, r2, r3);
    }

    static /* synthetic */ RegularImmutableSortedSet access$200(ImmutableSortedMap r0) {
        return r0.keySet;
    }

    static /* synthetic */ ImmutableList access$300(ImmutableSortedMap r0) {
        return r0.valueList;
    }

    public static <T, K, V> Collector<T, ?, ImmutableSortedMap<K, V>> toImmutableSortedMap(Comparator<? super K> r0, Function<? super T, ? extends K> r1, Function<? super T, ? extends V> r2) {
        return CollectCollectors.toImmutableSortedMap(r0, r1, r2);
    }

    public static <T, K, V> Collector<T, ?, ImmutableSortedMap<K, V>> toImmutableSortedMap(Comparator<? super K> r0, Function<? super T, ? extends K> r1, Function<? super T, ? extends V> r2, BinaryOperator<V> r3) {
        return CollectCollectors.toImmutableSortedMap(r0, r1, r2, r3);
    }

    static {
        NATURAL_ORDER = Ordering.natural();
        NATURAL_EMPTY_MAP = new ImmutableSortedMap(ImmutableSortedSet.emptySet(Ordering.natural()), ImmutableList.of());
    }

    static <K, V> ImmutableSortedMap<K, V> emptyMap(Comparator<? super K> r2) {
        if (Ordering.natural().equals(r2) == false) goto L7;
        return of();
    L7:
        return new ImmutableSortedMap(ImmutableSortedSet.emptySet(r2), ImmutableList.of());
    }

    public static <K, V> ImmutableSortedMap<K, V> of() {
        return (ImmutableSortedMap<K, V>) NATURAL_EMPTY_MAP;
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable r1, Object r2) {
        return of(Ordering.natural(), r1, r2);
    }

    private static <K, V> ImmutableSortedMap<K, V> of(Comparator<? super K> r2, K r3, V r4) {
        return new ImmutableSortedMap(new RegularImmutableSortedSet(ImmutableList.of(r3), (Comparator) Preconditions.checkNotNull(r2)), ImmutableList.of(r4));
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable r2, Object r3, Comparable r4, Object r5) {
        return fromEntries(new Map.Entry[]{entryOf(r2, r3), entryOf(r4, r5)});
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable r2, Object r3, Comparable r4, Object r5, Comparable r6, Object r7) {
        return fromEntries(new Map.Entry[]{entryOf(r2, r3), entryOf(r4, r5), entryOf(r6, r7)});
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable r2, Object r3, Comparable r4, Object r5, Comparable r6, Object r7, Comparable r8, Object r9) {
        return fromEntries(new Map.Entry[]{entryOf(r2, r3), entryOf(r4, r5), entryOf(r6, r7), entryOf(r8, r9)});
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable r2, Object r3, Comparable r4, Object r5, Comparable r6, Object r7, Comparable r8, Object r9, Comparable r10, Object r11) {
        return fromEntries(new Map.Entry[]{entryOf(r2, r3), entryOf(r4, r5), entryOf(r6, r7), entryOf(r8, r9), entryOf(r10, r11)});
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable r2, Object r3, Comparable r4, Object r5, Comparable r6, Object r7, Comparable r8, Object r9, Comparable r10, Object r11, Comparable r12, Object r13) {
        return fromEntries(new Map.Entry[]{entryOf(r2, r3), entryOf(r4, r5), entryOf(r6, r7), entryOf(r8, r9), entryOf(r10, r11), entryOf(r12, r13)});
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable r2, Object r3, Comparable r4, Object r5, Comparable r6, Object r7, Comparable r8, Object r9, Comparable r10, Object r11, Comparable r12, Object r13, Comparable r14, Object r15) {
        return fromEntries(new Map.Entry[]{entryOf(r2, r3), entryOf(r4, r5), entryOf(r6, r7), entryOf(r8, r9), entryOf(r10, r11), entryOf(r12, r13), entryOf(r14, r15)});
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable r3, Object r4, Comparable r5, Object r6, Comparable r7, Object r8, Comparable r9, Object r10, Comparable r11, Object r12, Comparable r13, Object r14, Comparable r15, Object r16, Comparable r17, Object r18) {
        return fromEntries(new Map.Entry[]{entryOf(r3, r4), entryOf(r5, r6), entryOf(r7, r8), entryOf(r9, r10), entryOf(r11, r12), entryOf(r13, r14), entryOf(r15, r16), entryOf(r17, r18)});
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable r3, Object r4, Comparable r5, Object r6, Comparable r7, Object r8, Comparable r9, Object r10, Comparable r11, Object r12, Comparable r13, Object r14, Comparable r15, Object r16, Comparable r17, Object r18, Comparable r19, Object r20) {
        return fromEntries(new Map.Entry[]{entryOf(r3, r4), entryOf(r5, r6), entryOf(r7, r8), entryOf(r9, r10), entryOf(r11, r12), entryOf(r13, r14), entryOf(r15, r16), entryOf(r17, r18), entryOf(r19, r20)});
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable r3, Object r4, Comparable r5, Object r6, Comparable r7, Object r8, Comparable r9, Object r10, Comparable r11, Object r12, Comparable r13, Object r14, Comparable r15, Object r16, Comparable r17, Object r18, Comparable r19, Object r20, Comparable r21, Object r22) {
        return fromEntries(new Map.Entry[]{entryOf(r3, r4), entryOf(r5, r6), entryOf(r7, r8), entryOf(r9, r10), entryOf(r11, r12), entryOf(r13, r14), entryOf(r15, r16), entryOf(r17, r18), entryOf(r19, r20), entryOf(r21, r22)});
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Map<? extends K, ? extends V> r1) {
        return copyOfInternal(r1, (Ordering) NATURAL_ORDER);
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Map<? extends K, ? extends V> r0, Comparator<? super K> r1) {
        return copyOfInternal(r0, (Comparator) Preconditions.checkNotNull(r1));
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> r1) {
        return copyOf(r1, (Ordering) NATURAL_ORDER);
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> r1, Comparator<? super K> r2) {
        return fromEntries((Comparator) Preconditions.checkNotNull(r2), false, r1);
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOfSorted(SortedMap<K, ? extends V> r3) {
        Comparator<? super K> r0 = r3.comparator();
        if (r0 != null) goto L6;
        r0 = NATURAL_ORDER;
    L6:
        if ((r3 instanceof ImmutableSortedMap) == false) goto L11;
        ImmutableSortedMap<K, V> r1 = (ImmutableSortedMap) r3;
        if (r1.isPartialView() == true) goto L11;
        return r1;
    L11:
        return fromEntries(r0, true, r3.entrySet());
    }

    private static <K, V> ImmutableSortedMap<K, V> copyOfInternal(Map<? extends K, ? extends V> r3, Comparator<? super K> r4) {
        boolean r1 = false;
        if ((r3 instanceof SortedMap) == false) goto L11;
        Comparator<? super K> r0 = ((SortedMap) r3).comparator();
        if (r0 == null) goto L7;
        boolean r2 = r4.equals(r0);
    L10:
        r1 = r2;
        goto L11
    L7:
        if (r4 != NATURAL_ORDER) goto L11;
        r2 = true;
    L11:
        if (r1 == false) goto L18;
        if ((r3 instanceof ImmutableSortedMap) == false) goto L18;
        ImmutableSortedMap<K, V> r5 = (ImmutableSortedMap) r3;
        if (r5.isPartialView() == true) goto L18;
        return r5;
    L18:
        return fromEntries(r4, r1, r3.entrySet());
    }

    private static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> fromEntries(Map.Entry<K, V>... r3) {
        return fromEntries(Ordering.natural(), false, r3, r3.length);
    }

    private static <K, V> ImmutableSortedMap<K, V> fromEntries(Comparator<? super K> r1, boolean r2, Iterable<? extends Map.Entry<? extends K, ? extends V>> r3) {
        Map.Entry[] r4 = (Map.Entry[]) Iterables.toArray(r3, EMPTY_ENTRY_ARRAY);
        return fromEntries(r1, r2, r4, r4.length);
    }

    private static <K, V> ImmutableSortedMap<K, V> fromEntries(final Comparator<? super K> r9, boolean r10, Map.Entry<K, V>[] r11, int r12) {
        if (r12 == 0) goto L21;
        int r1 = 0;
        if (r12 == 1) goto L18;
        Object[] r2 = new Object[r12];
        Object[] r3 = new Object[r12];
        if (r10 == false) goto L9;
    L7:
        if (r1 >= r12) goto L17;
        Map.Entry r13 = (Map.Entry) Objects.requireNonNull(r11[r1]);
        Object r0 = r13.getKey();
        Object r14 = r13.getValue();
        CollectPreconditions.checkEntryNotNull(r0, r14);
        r2[r1] = r0;
        r3[r1] = r14;
        r1 = r1 + 1;
    L17:
        return new ImmutableSortedMap(new RegularImmutableSortedSet(new RegularImmutableList(r2), r9), new RegularImmutableList(r3));
    L9:
        Arrays.sort(r11, 0, r12, new AnonymousClass1(r9));
        Map.Entry r15 = (Map.Entry) Objects.requireNonNull(r11[0]);
        Object r4 = r15.getKey();
        r2[0] = r4;
        Object r16 = r15.getValue();
        r3[0] = r16;
        CollectPreconditions.checkEntryNotNull(r2[0], r16);
        int r17 = 1;
    L10:
        if (r17 >= r12) goto L17;
        Map.Entry r5 = (Map.Entry) Objects.requireNonNull(r11[r17 - 1]);
        Map.Entry r6 = (Map.Entry) Objects.requireNonNull(r11[r17]);
        Object r7 = r6.getKey();
        Object r8 = r6.getValue();
        CollectPreconditions.checkEntryNotNull(r7, r8);
        r2[r17] = r7;
        r3[r17] = r8;
        if (r9.compare(r4, r7) == 0) goto L14;
        boolean r18 = true;
    L15:
        checkNoConflict(r18, "key", r5, r6);
        r17 = r17 + 1;
        r4 = r7;
        goto L10
    L14:
        r18 = false;
        goto L15
    L18:
        Map.Entry r19 = (Map.Entry) Objects.requireNonNull(r11[0]);
        return of(r9, r19.getKey(), r19.getValue());
    L21:
        return emptyMap(r9);
    }

    public static <K extends Comparable<?>, V> Builder<K, V> naturalOrder() {
        return new Builder(Ordering.natural());
    }

    public static <K, V> Builder<K, V> orderedBy(Comparator<K> r1) {
        return new Builder(r1);
    }

    public static <K extends Comparable<?>, V> Builder<K, V> reverseOrder() {
        return new Builder(Ordering.natural().reverse());
    }

    ImmutableSortedMap(RegularImmutableSortedSet<K> r2, ImmutableList<V> r3) {
        this(r2, r3, null);
    }

    ImmutableSortedMap(RegularImmutableSortedSet<K> r1, ImmutableList<V> r2, @CheckForNull ImmutableSortedMap<K, V> r3) {
        this.keySet = r1;
        this.valueList = r2;
        this.descendingMap = r3;
    }

    @Override // java.util.Map
    public int size() {
        return this.valueList.size();
    }

    @Override // java.util.Map
    public void forEach(BiConsumer<? super K, ? super V> r5) {
        Preconditions.checkNotNull(r5);
        ImmutableList r0 = this.keySet.asList();
        int r1 = 0;
    L4:
        if (r1 >= size()) goto L6;
        r5.accept((Object) r0.get(r1), this.valueList.get(r1));
        r1 = r1 + 1;
        goto L4
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    @CheckForNull
    public V get(@CheckForNull Object r2) {
        int r3 = this.keySet.indexOf(r2);
        if (r3 != (-1)) goto L6;
        return null;
    L6:
        return this.valueList.get(r3);
    }

    @Override // com.google.common.collect.ImmutableMap
    boolean isPartialView() {
        if (this.keySet.isPartialView() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.valueList.isPartialView() == true) goto L8;
        return false;
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableSet<Map.Entry<K, V>> entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        if (isEmpty() == false) goto L6;
        return ImmutableSet.of();
    L6:
        return new C1EntrySet(this);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableSortedSet<K> keySet() {
        return this.keySet;
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<K> createKeySet() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map, com.google.common.collect.BiMap
    public ImmutableCollection<V> values() {
        return this.valueList;
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableCollection<V> createValues() {
        throw new AssertionError("should never be called");
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        return keySet().comparator();
    }

    @Override // java.util.SortedMap
    public K firstKey() {
        return keySet().first();
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        return keySet().last();
    }

    private ImmutableSortedMap<K, V> getSubMap(int r3, int r4) {
        if (r3 == 0) goto L4;
    L6:
        if (r3 != r4) goto L10;
        return emptyMap(comparator());
    L10:
        return new ImmutableSortedMap(this.keySet.getSubSet(r3, r4), this.valueList.subList(r3, r4));
    L4:
        if (r4 != size()) goto L6;
        return this;
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public ImmutableSortedMap<K, V> headMap(K r2) {
        return headMap(r2, false);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> headMap(K r2, boolean r3) {
        return getSubMap(0, this.keySet.headIndex((K) Preconditions.checkNotNull(r2), r3));
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public ImmutableSortedMap<K, V> subMap(K r3, K r4) {
        return subMap(r3, true, r4, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> subMap(K r3, boolean r4, K r5, boolean r6) {
        Preconditions.checkNotNull(r3);
        Preconditions.checkNotNull(r5);
        if (comparator().compare(r3, r5) > 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "expected fromKey <= toKey but %s > %s", r3, r5);
        return headMap(r5, r6).tailMap(r3, r4);
    L5:
        r0 = false;
        goto L6
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public ImmutableSortedMap<K, V> tailMap(K r2) {
        return tailMap(r2, true);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> tailMap(K r2, boolean r3) {
        return getSubMap(this.keySet.tailIndex((K) Preconditions.checkNotNull(r2), r3), size());
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> lowerEntry(K r2) {
        return headMap(r2, false).lastEntry();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public K lowerKey(K r1) {
        return (K) Maps.keyOrNull(lowerEntry(r1));
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> floorEntry(K r2) {
        return headMap(r2, true).lastEntry();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public K floorKey(K r1) {
        return (K) Maps.keyOrNull(floorEntry(r1));
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> ceilingEntry(K r2) {
        return tailMap(r2, true).firstEntry();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public K ceilingKey(K r1) {
        return (K) Maps.keyOrNull(ceilingEntry(r1));
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> higherEntry(K r2) {
        return tailMap(r2, false).firstEntry();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public K higherKey(K r1) {
        return (K) Maps.keyOrNull(higherEntry(r1));
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> firstEntry() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return entrySet().asList().get(0);
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> lastEntry() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return entrySet().asList().get(size() - 1);
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    @Deprecated
    public final Map.Entry<K, V> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    @Deprecated
    public final Map.Entry<K, V> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> descendingMap() {
        ImmutableSortedMap<K, V> r0 = this.descendingMap;
        if (r0 == null) goto L5;
        return r0;
    L5:
        if (isEmpty() == false) goto L9;
        return emptyMap(Ordering.from(comparator()).reverse());
    L9:
        return new ImmutableSortedMap((RegularImmutableSortedSet) this.keySet.descendingSet(), this.valueList.reverse(), this);
    }

    @Override // java.util.NavigableMap
    public ImmutableSortedSet<K> navigableKeySet() {
        return this.keySet;
    }

    @Override // java.util.NavigableMap
    public ImmutableSortedSet<K> descendingKeySet() {
        return this.keySet.descendingSet();
    }

    @Override // com.google.common.collect.ImmutableMap
    Object writeReplace() {
        return new SerializedForm(this);
    }
}
