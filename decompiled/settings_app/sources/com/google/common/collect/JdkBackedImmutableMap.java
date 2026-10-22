package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class JdkBackedImmutableMap<K, V> extends ImmutableMap<K, V> {
    private final transient Map<K, V> delegateMap;
    private final transient ImmutableList<Map.Entry<K, V>> entries;

    @Override // com.google.common.collect.ImmutableMap
    boolean isPartialView() {
        return false;
    }

    static <K, V> ImmutableMap<K, V> create(int r4, Map.Entry<K, V>[] r5) {
        HashMap r0 = Maps.newHashMapWithExpectedSize(r4);
        int r1 = 0;
    L3:
        if (r1 >= r4) goto L10;
        ImmutableMapEntry r2 = RegularImmutableMap.makeImmutable((Map.Entry) Objects.requireNonNull(r5[r1]));
        r5[r1] = r2;
        Object r3 = r0.putIfAbsent(r2.getKey(), r5[r1].getValue());
        if (r3 != null) goto L7;
        r1 = r1 + 1;
        goto L3
    L7:
        Map.Entry<K, V> r6 = r5[r1];
        String r7 = String.valueOf(r6.getKey());
        String r8 = String.valueOf(r3);
        throw conflictException("key", r6, new StringBuilder((String.valueOf(r7).length() + 1) + String.valueOf(r8).length()).append(r7).append("=").append(r8).toString());
    L10:
        return new JdkBackedImmutableMap(r0, ImmutableList.asImmutableList(r5, r4));
    }

    JdkBackedImmutableMap(Map<K, V> r1, ImmutableList<Map.Entry<K, V>> r2) {
        this.delegateMap = r1;
        this.entries = r2;
    }

    @Override // java.util.Map
    public int size() {
        return this.entries.size();
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    @CheckForNull
    public V get(@CheckForNull Object r1) {
        return this.delegateMap.get(r1);
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new ImmutableMapEntrySet.RegularEntrySet(this, this.entries);
    }

    @Override // java.util.Map
    public void forEach(final BiConsumer<? super K, ? super V> r2) {
        Preconditions.checkNotNull(r2);
        this.entries.forEach(new JdkBackedImmutableMap$$ExternalSyntheticLambda0(r2));
    }

    static /* synthetic */ void lambda$forEach$0(BiConsumer r1, Map.Entry r2) {
        r1.accept(r2.getKey(), r2.getValue());
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<K> createKeySet() {
        return new ImmutableMapKeySet(this);
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableCollection<V> createValues() {
        return new ImmutableMapValues(this);
    }
}
