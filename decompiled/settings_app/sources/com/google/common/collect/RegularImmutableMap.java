package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class RegularImmutableMap<K, V> extends ImmutableMap<K, V> {
    static final ImmutableMap<Object, Object> EMPTY = null;
    static final double HASH_FLOODING_FPP = 0.001d;
    static final int MAX_HASH_BUCKET_LENGTH = 8;
    static final double MAX_LOAD_FACTOR = 1.2d;
    private static final long serialVersionUID = 0;
    final transient Map.Entry<K, V>[] entries;
    private final transient int mask;

    @CheckForNull
    private final transient ImmutableMapEntry<K, V>[] table;

    private static final class KeySet<K> extends IndexedImmutableSet<K> {
        private final RegularImmutableMap<K, ?> map;

        private static class SerializedForm<K> implements Serializable {
            private static final long serialVersionUID = 0;
            final ImmutableMap<K, ?> map;

            SerializedForm(ImmutableMap<K, ?> r1) {
                this.map = r1;
            }

            Object readResolve() {
                return this.map.keySet();
            }
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return true;
        }

        KeySet(RegularImmutableMap<K, ?> r1) {
            this.map = r1;
        }

        @Override // com.google.common.collect.IndexedImmutableSet
        K get(int r1) {
            return this.map.entries[r1].getKey();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object r1) {
            return this.map.containsKey(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.map.size();
        }
    }

    private static final class Values<K, V> extends ImmutableList<V> {
        final RegularImmutableMap<K, V> map;

        private static class SerializedForm<V> implements Serializable {
            private static final long serialVersionUID = 0;
            final ImmutableMap<?, V> map;

            SerializedForm(ImmutableMap<?, V> r1) {
                this.map = r1;
            }

            Object readResolve() {
                return this.map.values();
            }
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return true;
        }

        Values(RegularImmutableMap<K, V> r1) {
            this.map = r1;
        }

        @Override // java.util.List
        public V get(int r1) {
            return this.map.entries[r1].getValue();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.map.size();
        }
    }

    @Override // com.google.common.collect.ImmutableMap
    boolean isPartialView() {
        return false;
    }

    static {
        EMPTY = new RegularImmutableMap(ImmutableMap.EMPTY_ENTRY_ARRAY, null, 0);
    }

    static <K, V> ImmutableMap<K, V> fromEntries(Map.Entry<K, V>... r1) {
        return fromEntryArray(r1.length, r1);
    }

    static <K, V> ImmutableMap<K, V> fromEntryArray(int r9, Map.Entry<K, V>[] r10) {
        Preconditions.checkPositionIndex(r9, r10.length);
        if (r9 != 0) goto L7;
        return (RegularImmutableMap) EMPTY;
    L7:
        if (r9 != r10.length) goto L9;
        Map.Entry<K, V>[] r0 = r10;
    L10:
        int r1 = Hashing.closedTableSize(r9, MAX_LOAD_FACTOR);
        ImmutableMapEntry[] r2 = ImmutableMapEntry.createEntryArray(r1);
        int r3 = r1 - 1;
        int r4 = 0;
    L11:
        if (r4 >= r9) goto L22;
        Map.Entry r5 = (Map.Entry) Objects.requireNonNull(r10[r4]);
        Object r6 = r5.getKey();
        Object r7 = r5.getValue();
        CollectPreconditions.checkEntryNotNull(r6, r7);
        int r8 = Hashing.smear(r6.hashCode()) & r3;
        ImmutableMapEntry r11 = r2[r8];
        if (r11 != null) goto L15;
        ImmutableMapEntry r12 = makeImmutable(r5, r6, r7);
    L16:
        r2[r8] = r12;
        r0[r4] = r12;
        if (checkNoConflictInKeyBucket(r6, r12, r11) > 8) goto L19;
        r4 = r4 + 1;
        goto L11
    L19:
        return JdkBackedImmutableMap.create(r9, r10);
    L15:
        r12 = new ImmutableMapEntry.NonTerminalImmutableMapEntry(r6, r7, r11);
        goto L16
    L22:
        return new RegularImmutableMap(r0, r2, r3);
    L9:
        r0 = ImmutableMapEntry.createEntryArray(r9);
        goto L10
    }

    static <K, V> ImmutableMapEntry<K, V> makeImmutable(Map.Entry<K, V> r1, K r2, V r3) {
        if ((r1 instanceof ImmutableMapEntry) == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L11;
        return (ImmutableMapEntry) r1;
    L11:
        return new ImmutableMapEntry(r2, r3);
    L5:
        if (((ImmutableMapEntry) r1).isReusable() == false) goto L7;
        r0 = true;
        goto L8
    }

    static <K, V> ImmutableMapEntry<K, V> makeImmutable(Map.Entry<K, V> r2) {
        return makeImmutable(r2, r2.getKey(), r2.getValue());
    }

    private RegularImmutableMap(Map.Entry<K, V>[] r1, @CheckForNull ImmutableMapEntry<K, V>[] r2, int r3) {
        this.entries = r1;
        this.table = r2;
        this.mask = r3;
    }

    static int checkNoConflictInKeyBucket(Object r3, Map.Entry<?, ?> r4, @CheckForNull ImmutableMapEntry<?, ?> r5) {
        int r0 = 0;
    L3:
        if (r5 == null) goto L5;
        checkNoConflict(!r3.equals(r5.getKey()), "key", r4, r5);
        r0 = r0 + 1;
        r5 = r5.getNextInKeyBucket();
        goto L3
    L5:
        return r0;
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    @CheckForNull
    public V get(@CheckForNull Object r2) {
        return (V) get(r2, this.table, this.mask);
    }

    @CheckForNull
    static <V> V get(@CheckForNull Object r2, @CheckForNull ImmutableMapEntry<?, V>[] r3, int r4) {
        if (r2 == null) goto L13;
        if (r3 == null) goto L13;
        ImmutableMapEntry<?, V> r5 = r3[r4 & Hashing.smear(r2.hashCode())];
    L7:
        if (r5 == null) goto L13;
        if (r2.equals(r5.getKey()) == true) goto L11;
        r5 = r5.getNextInKeyBucket();
        goto L7
    L11:
        return r5.getValue();
    L13:
        return null;
    }

    @Override // java.util.Map
    public void forEach(BiConsumer<? super K, ? super V> r5) {
        Preconditions.checkNotNull(r5);
        Map.Entry<K, V>[] r4 = this.entries;
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        Map.Entry<K, V> r2 = r4[r1];
        r5.accept(r2.getKey(), r2.getValue());
        r1 = r1 + 1;
        goto L3
    }

    @Override // java.util.Map
    public int size() {
        return this.entries.length;
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new ImmutableMapEntrySet.RegularEntrySet(this, this.entries);
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<K> createKeySet() {
        return new KeySet(this);
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableCollection<V> createValues() {
        return new Values(this);
    }
}
