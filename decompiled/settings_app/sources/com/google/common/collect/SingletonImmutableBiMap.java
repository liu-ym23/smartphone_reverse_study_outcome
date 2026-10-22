package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.util.Map;
import java.util.function.BiConsumer;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class SingletonImmutableBiMap<K, V> extends ImmutableBiMap<K, V> {

    @CheckForNull
    private final transient ImmutableBiMap<V, K> inverse;

    @CheckForNull
    @LazyInit
    private transient ImmutableBiMap<V, K> lazyInverse;
    final transient K singleKey;
    final transient V singleValue;

    @Override // com.google.common.collect.ImmutableMap
    boolean isPartialView() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return 1;
    }

    @Override // com.google.common.collect.ImmutableBiMap, com.google.common.collect.BiMap
    public /* bridge */ /* synthetic */ BiMap inverse() {
        return inverse();
    }

    SingletonImmutableBiMap(K r1, V r2) {
        CollectPreconditions.checkEntryNotNull(r1, r2);
        this.singleKey = r1;
        this.singleValue = r2;
        this.inverse = null;
    }

    private SingletonImmutableBiMap(K r1, V r2, ImmutableBiMap<V, K> r3) {
        this.singleKey = r1;
        this.singleValue = r2;
        this.inverse = r3;
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    @CheckForNull
    public V get(@CheckForNull Object r2) {
        if (this.singleKey.equals(r2) == true) goto L7;
        return null;
    L7:
        return this.singleValue;
    }

    @Override // java.util.Map
    public void forEach(BiConsumer<? super K, ? super V> r2) {
        ((BiConsumer) Preconditions.checkNotNull(r2)).accept(this.singleKey, this.singleValue);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean containsKey(@CheckForNull Object r1) {
        return this.singleKey.equals(r1);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean containsValue(@CheckForNull Object r1) {
        return this.singleValue.equals(r1);
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return ImmutableSet.of(Maps.immutableEntry(this.singleKey, this.singleValue));
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<K> createKeySet() {
        return ImmutableSet.of(this.singleKey);
    }

    @Override // com.google.common.collect.ImmutableBiMap, com.google.common.collect.BiMap
    public ImmutableBiMap<V, K> inverse() {
        ImmutableBiMap<V, K> r0 = this.inverse;
        if (r0 == null) goto L5;
        return r0;
    L5:
        ImmutableBiMap<V, K> r1 = this.lazyInverse;
        if (r1 != null) goto L9;
        SingletonImmutableBiMap r2 = new SingletonImmutableBiMap(this.singleValue, this.singleKey, this);
        this.lazyInverse = r2;
        return r2;
    L9:
        return r1;
    }
}
