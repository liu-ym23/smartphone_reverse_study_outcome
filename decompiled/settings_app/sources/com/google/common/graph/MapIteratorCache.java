package com.google.common.graph;

import com.google.common.base.Preconditions;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
class MapIteratorCache<K, V> {
    private final Map<K, V> backingMap;

    @CheckForNull
    private volatile transient Map.Entry<K, V> cacheEntry;

    static /* synthetic */ Map access$000(MapIteratorCache r0) {
        return r0.backingMap;
    }

    static /* synthetic */ Map.Entry access$102(MapIteratorCache r0, Map.Entry r1) {
        r0.cacheEntry = r1;
        return r1;
    }

    MapIteratorCache(Map<K, V> r1) {
        this.backingMap = (Map) Preconditions.checkNotNull(r1);
    }

    @CheckForNull
    final V put(K r1, V r2) {
        Preconditions.checkNotNull(r1);
        Preconditions.checkNotNull(r2);
        clearCache();
        return this.backingMap.put(r1, r2);
    }

    @CheckForNull
    final V remove(Object r1) {
        Preconditions.checkNotNull(r1);
        clearCache();
        return this.backingMap.remove(r1);
    }

    final void clear() {
        clearCache();
        this.backingMap.clear();
    }

    @CheckForNull
    V get(Object r2) {
        Preconditions.checkNotNull(r2);
        V r0 = getIfCached(r2);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return getWithoutCaching(r2);
    }

    @CheckForNull
    final V getWithoutCaching(Object r1) {
        Preconditions.checkNotNull(r1);
        return this.backingMap.get(r1);
    }

    final boolean containsKey(@CheckForNull Object r2) {
        if (getIfCached(r2) == null) goto L5;
    L8:
        return true;
    L5:
        if (this.backingMap.containsKey(r2) == true) goto L8;
        return false;
    }

    final Set<K> unmodifiableKeySet() {
        return new AnonymousClass1(this);
    }

    @CheckForNull
    V getIfCached(@CheckForNull Object r2) {
        Map.Entry<K, V> r1 = this.cacheEntry;
        if (r1 != null) goto L5;
        return null;
    L5:
        if (r1.getKey() == r2) goto L7;
        return null;
    L7:
        return r1.getValue();
    }

    void clearCache() {
        this.cacheEntry = null;
    }
}
