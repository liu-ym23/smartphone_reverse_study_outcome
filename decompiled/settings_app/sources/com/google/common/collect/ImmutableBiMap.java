package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public abstract class ImmutableBiMap<K, V> extends ImmutableBiMapFauxverideShim<K, V> implements BiMap<K, V> {

    public static final class Builder<K, V> extends ImmutableMap.Builder<K, V> {
        @Override // com.google.common.collect.ImmutableMap.Builder
        public /* bridge */ /* synthetic */ ImmutableMap build() {
            return build();
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        /* bridge */ /* synthetic */ ImmutableMap buildJdkBacked() {
            return buildJdkBacked();
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

        public Builder() {
        }

        Builder(int r1) {
            super(r1);
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
        public Builder<K, V> orderEntriesByValue(Comparator<? super V> r1) {
            super.orderEntriesByValue(r1);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        Builder<K, V> combine(ImmutableMap.Builder<K, V> r1) {
            super.combine(r1);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public ImmutableBiMap<K, V> build() {
            return buildOrThrow();
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public ImmutableBiMap<K, V> buildOrThrow() {
            int r0 = this.size;
            if (r0 == 0) goto L17;
            if (r0 != 1) goto L7;
            Map.Entry r6 = (Map.Entry) Objects.requireNonNull(this.entries[0]);
            return ImmutableBiMap.of(r6.getKey(), r6.getValue());
        L7:
            if (this.valueComparator != null) goto L9;
        L12:
            this.entriesUsed = true;
            return RegularImmutableBiMap.fromEntryArray(this.size, this.entries);
        L9:
            if (this.entriesUsed == false) goto L11;
            this.entries = (Map.Entry[]) Arrays.copyOf(this.entries, this.size);
        L11:
            Arrays.sort(this.entries, 0, this.size, Ordering.from(this.valueComparator).onResultOf(Maps.valueFunction()));
            goto L12
        L17:
            return ImmutableBiMap.of();
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        ImmutableBiMap<K, V> buildJdkBacked() {
            if (this.valueComparator != null) goto L5;
            boolean r0 = true;
        L6:
            Preconditions.checkState(r0, "buildJdkBacked is for tests only, doesn't support orderEntriesByValue");
            int r1 = this.size;
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L11;
            this.entriesUsed = true;
            return RegularImmutableBiMap.fromEntryArray(this.size, this.entries);
        L11:
            Map.Entry r4 = (Map.Entry) Objects.requireNonNull(this.entries[0]);
            return ImmutableBiMap.of(r4.getKey(), r4.getValue());
        L14:
            return ImmutableBiMap.of();
        L5:
            r0 = false;
            goto L6
        }
    }

    private static class SerializedForm<K, V> extends ImmutableMap.SerializedForm<K, V> {
        private static final long serialVersionUID = 0;

        @Override // com.google.common.collect.ImmutableMap.SerializedForm
        /* bridge */ /* synthetic */ ImmutableMap.Builder makeBuilder(int r1) {
            return makeBuilder(r1);
        }

        SerializedForm(ImmutableBiMap<K, V> r1) {
            super(r1);
        }

        @Override // com.google.common.collect.ImmutableMap.SerializedForm
        Builder<K, V> makeBuilder(int r1) {
            return new Builder(r1);
        }
    }

    @Override // com.google.common.collect.BiMap
    public abstract ImmutableBiMap<V, K> inverse();

    @Override // com.google.common.collect.ImmutableMap
    /* bridge */ /* synthetic */ ImmutableCollection createValues() {
        return createValues();
    }

    @Override // com.google.common.collect.BiMap
    public /* bridge */ /* synthetic */ BiMap inverse() {
        return inverse();
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map, com.google.common.collect.BiMap
    public /* bridge */ /* synthetic */ ImmutableCollection values() {
        return values();
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map, com.google.common.collect.BiMap
    public /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map, com.google.common.collect.BiMap
    public /* bridge */ /* synthetic */ Set values() {
        return values();
    }

    public static <T, K, V> Collector<T, ?, ImmutableBiMap<K, V>> toImmutableBiMap(Function<? super T, ? extends K> r0, Function<? super T, ? extends V> r1) {
        return CollectCollectors.toImmutableBiMap(r0, r1);
    }

    public static <K, V> ImmutableBiMap<K, V> of() {
        return RegularImmutableBiMap.EMPTY;
    }

    public static <K, V> ImmutableBiMap<K, V> of(K r1, V r2) {
        return new SingletonImmutableBiMap(r1, r2);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K r2, V r3, K r4, V r5) {
        return RegularImmutableBiMap.fromEntries(new Map.Entry[]{entryOf(r2, r3), entryOf(r4, r5)});
    }

    public static <K, V> ImmutableBiMap<K, V> of(K r2, V r3, K r4, V r5, K r6, V r7) {
        return RegularImmutableBiMap.fromEntries(new Map.Entry[]{entryOf(r2, r3), entryOf(r4, r5), entryOf(r6, r7)});
    }

    public static <K, V> ImmutableBiMap<K, V> of(K r2, V r3, K r4, V r5, K r6, V r7, K r8, V r9) {
        return RegularImmutableBiMap.fromEntries(new Map.Entry[]{entryOf(r2, r3), entryOf(r4, r5), entryOf(r6, r7), entryOf(r8, r9)});
    }

    public static <K, V> ImmutableBiMap<K, V> of(K r2, V r3, K r4, V r5, K r6, V r7, K r8, V r9, K r10, V r11) {
        return RegularImmutableBiMap.fromEntries(new Map.Entry[]{entryOf(r2, r3), entryOf(r4, r5), entryOf(r6, r7), entryOf(r8, r9), entryOf(r10, r11)});
    }

    public static <K, V> ImmutableBiMap<K, V> of(K r2, V r3, K r4, V r5, K r6, V r7, K r8, V r9, K r10, V r11, K r12, V r13) {
        return RegularImmutableBiMap.fromEntries(new Map.Entry[]{entryOf(r2, r3), entryOf(r4, r5), entryOf(r6, r7), entryOf(r8, r9), entryOf(r10, r11), entryOf(r12, r13)});
    }

    public static <K, V> ImmutableBiMap<K, V> of(K r2, V r3, K r4, V r5, K r6, V r7, K r8, V r9, K r10, V r11, K r12, V r13, K r14, V r15) {
        return RegularImmutableBiMap.fromEntries(new Map.Entry[]{entryOf(r2, r3), entryOf(r4, r5), entryOf(r6, r7), entryOf(r8, r9), entryOf(r10, r11), entryOf(r12, r13), entryOf(r14, r15)});
    }

    public static <K, V> ImmutableBiMap<K, V> of(K r3, V r4, K r5, V r6, K r7, V r8, K r9, V r10, K r11, V r12, K r13, V r14, K r15, V r16, K r17, V r18) {
        return RegularImmutableBiMap.fromEntries(new Map.Entry[]{entryOf(r3, r4), entryOf(r5, r6), entryOf(r7, r8), entryOf(r9, r10), entryOf(r11, r12), entryOf(r13, r14), entryOf(r15, r16), entryOf(r17, r18)});
    }

    public static <K, V> ImmutableBiMap<K, V> of(K r3, V r4, K r5, V r6, K r7, V r8, K r9, V r10, K r11, V r12, K r13, V r14, K r15, V r16, K r17, V r18, K r19, V r20) {
        return RegularImmutableBiMap.fromEntries(new Map.Entry[]{entryOf(r3, r4), entryOf(r5, r6), entryOf(r7, r8), entryOf(r9, r10), entryOf(r11, r12), entryOf(r13, r14), entryOf(r15, r16), entryOf(r17, r18), entryOf(r19, r20)});
    }

    public static <K, V> ImmutableBiMap<K, V> of(K r3, V r4, K r5, V r6, K r7, V r8, K r9, V r10, K r11, V r12, K r13, V r14, K r15, V r16, K r17, V r18, K r19, V r20, K r21, V r22) {
        return RegularImmutableBiMap.fromEntries(new Map.Entry[]{entryOf(r3, r4), entryOf(r5, r6), entryOf(r7, r8), entryOf(r9, r10), entryOf(r11, r12), entryOf(r13, r14), entryOf(r15, r16), entryOf(r17, r18), entryOf(r19, r20), entryOf(r21, r22)});
    }

    @SafeVarargs
    public static <K, V> ImmutableBiMap<K, V> ofEntries(Map.Entry<? extends K, ? extends V>... r0) {
        return RegularImmutableBiMap.fromEntries(r0);
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder();
    }

    public static <K, V> Builder<K, V> builderWithExpectedSize(int r1) {
        CollectPreconditions.checkNonnegative(r1, "expectedSize");
        return new Builder(r1);
    }

    public static <K, V> ImmutableBiMap<K, V> copyOf(Map<? extends K, ? extends V> r2) {
        if ((r2 instanceof ImmutableBiMap) == false) goto L8;
        ImmutableBiMap<K, V> r0 = (ImmutableBiMap) r2;
        if (r0.isPartialView() == true) goto L8;
        return r0;
    L8:
        return copyOf(r2.entrySet());
    }

    public static <K, V> ImmutableBiMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> r2) {
        Map.Entry[] r3 = (Map.Entry[]) Iterables.toArray(r2, EMPTY_ENTRY_ARRAY);
        int r0 = r3.length;
        if (r0 == 0) goto L11;
        if (r0 != 1) goto L7;
        Map.Entry r4 = r3[0];
        return of(r4.getKey(), r4.getValue());
    L7:
        return RegularImmutableBiMap.fromEntries(r3);
    L11:
        return of();
    }

    ImmutableBiMap() {
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map, com.google.common.collect.BiMap
    public ImmutableSet<V> values() {
        return inverse().keySet();
    }

    @Override // com.google.common.collect.ImmutableMap
    final ImmutableSet<V> createValues() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.BiMap
    @CheckForNull
    @Deprecated
    public final V forcePut(K r1, V r2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableMap
    Object writeReplace() {
        return new SerializedForm(this);
    }
}
