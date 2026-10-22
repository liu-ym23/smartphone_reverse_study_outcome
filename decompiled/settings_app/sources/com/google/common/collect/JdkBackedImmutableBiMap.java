package com.google.common.collect;

import com.google.errorprone.annotations.concurrent.LazyInit;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class JdkBackedImmutableBiMap<K, V> extends ImmutableBiMap<K, V> {
    private final Map<V, K> backwardDelegate;
    private final transient ImmutableList<Map.Entry<K, V>> entries;
    private final Map<K, V> forwardDelegate;

    @CheckForNull
    @LazyInit
    private transient JdkBackedImmutableBiMap<V, K> inverse;

    /* JADX INFO: renamed from: com.google.common.collect.JdkBackedImmutableBiMap$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private final class InverseEntries extends ImmutableList<Map.Entry<V, K>> {
        final /* synthetic */ JdkBackedImmutableBiMap this$0;

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return false;
        }

        @Override // java.util.List
        public /* bridge */ /* synthetic */ Object get(int r1) {
            return get(r1);
        }

        private InverseEntries(JdkBackedImmutableBiMap r1) {
            this.this$0 = r1;
        }

        /* synthetic */ InverseEntries(JdkBackedImmutableBiMap r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.util.List
        public Map.Entry<V, K> get(int r1) {
            Map.Entry r0 = (Map.Entry) JdkBackedImmutableBiMap.access$100(this.this$0).get(r1);
            return Maps.immutableEntry(r0.getValue(), r0.getKey());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return JdkBackedImmutableBiMap.access$100(this.this$0).size();
        }
    }

    @Override // com.google.common.collect.ImmutableMap
    boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableBiMap, com.google.common.collect.BiMap
    public /* bridge */ /* synthetic */ BiMap inverse() {
        return inverse();
    }

    static /* synthetic */ ImmutableList access$100(JdkBackedImmutableBiMap r0) {
        return r0.entries;
    }

    static <K, V> ImmutableBiMap<K, V> create(int r7, Map.Entry<K, V>[] r8) {
        HashMap r0 = Maps.newHashMapWithExpectedSize(r7);
        HashMap r1 = Maps.newHashMapWithExpectedSize(r7);
        int r2 = 0;
    L3:
        if (r2 >= r7) goto L14;
        ImmutableMapEntry r3 = RegularImmutableMap.makeImmutable((Map.Entry) Objects.requireNonNull(r8[r2]));
        r8[r2] = r3;
        Object r4 = r0.putIfAbsent(r3.getKey(), r3.getValue());
        if (r4 != null) goto L11;
        Object r5 = r1.putIfAbsent(r3.getValue(), r3.getKey());
        if (r5 != null) goto L9;
        r2 = r2 + 1;
        goto L3
    L9:
        String r9 = String.valueOf(r5);
        String r6 = String.valueOf(r3.getValue());
        throw conflictException("value", new StringBuilder((String.valueOf(r9).length() + 1) + String.valueOf(r6).length()).append(r9).append("=").append(r6).toString(), r8[r2]);
    L11:
        String r10 = String.valueOf(r3.getKey());
        String r11 = String.valueOf(r4);
        throw conflictException("key", new StringBuilder((String.valueOf(r10).length() + 1) + String.valueOf(r11).length()).append(r10).append("=").append(r11).toString(), r8[r2]);
    L14:
        return new JdkBackedImmutableBiMap(ImmutableList.asImmutableList(r8, r7), r0, r1);
    }

    private JdkBackedImmutableBiMap(ImmutableList<Map.Entry<K, V>> r1, Map<K, V> r2, Map<V, K> r3) {
        this.entries = r1;
        this.forwardDelegate = r2;
        this.backwardDelegate = r3;
    }

    @Override // java.util.Map
    public int size() {
        return this.entries.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableBiMap, com.google.common.collect.BiMap
    public ImmutableBiMap<V, K> inverse() {
        JdkBackedImmutableBiMap<V, K> r0 = this.inverse;
        if (r0 != null) goto L6;
        JdkBackedImmutableBiMap<V, K> r1 = new JdkBackedImmutableBiMap(new InverseEntries(this, null), this.backwardDelegate, this.forwardDelegate);
        this.inverse = r1;
        r1.inverse = this;
        return r1;
    L6:
        return r0;
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    @CheckForNull
    public V get(@CheckForNull Object r1) {
        return this.forwardDelegate.get(r1);
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new ImmutableMapEntrySet.RegularEntrySet(this, this.entries);
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<K> createKeySet() {
        return new ImmutableMapKeySet(this);
    }
}
