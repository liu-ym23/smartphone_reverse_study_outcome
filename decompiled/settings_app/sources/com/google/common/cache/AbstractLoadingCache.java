package com.google.common.cache;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.UncheckedExecutionException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractLoadingCache<K, V> extends AbstractCache<K, V> implements LoadingCache<K, V> {
    protected AbstractLoadingCache() {
    }

    @Override // com.google.common.cache.LoadingCache
    public V getUnchecked(K r1) {
        return get(r1);
    L4:
        e = move-exception;
        throw new UncheckedExecutionException(e.getCause());
    }

    @Override // com.google.common.cache.LoadingCache
    public ImmutableMap<K, V> getAll(Iterable<? extends K> r4) throws ExecutionException {
        LinkedHashMap r0 = Maps.newLinkedHashMap();
        Iterator<? extends K> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        K r1 = r5.next();
        if (r0.containsKey(r1) == true) goto L4;
        r0.put(r1, get(r1));
        goto L4
    L9:
        return ImmutableMap.copyOf(r0);
    }

    @Override // com.google.common.cache.LoadingCache, com.google.common.base.Function, java.util.function.Function
    public final V apply(K r1) {
        return getUnchecked(r1);
    }

    @Override // com.google.common.cache.LoadingCache
    public void refresh(K r1) {
        throw new UnsupportedOperationException();
    }
}
