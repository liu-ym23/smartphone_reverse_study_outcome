package com.google.common.cache;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractCache<K, V> implements Cache<K, V> {

    public static final class SimpleStatsCounter implements StatsCounter {
        private final LongAddable evictionCount;
        private final LongAddable hitCount;
        private final LongAddable loadExceptionCount;
        private final LongAddable loadSuccessCount;
        private final LongAddable missCount;
        private final LongAddable totalLoadTime;

        private static long negativeToMaxValue(long r2) {
            if (r2 >= 0) goto L7;
            return Long.MAX_VALUE;
        L7:
            return r2;
        }

        public SimpleStatsCounter() {
            this.hitCount = LongAddables.create();
            this.missCount = LongAddables.create();
            this.loadSuccessCount = LongAddables.create();
            this.loadExceptionCount = LongAddables.create();
            this.totalLoadTime = LongAddables.create();
            this.evictionCount = LongAddables.create();
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordHits(int r3) {
            this.hitCount.add(r3);
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordMisses(int r3) {
            this.missCount.add(r3);
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordLoadSuccess(long r2) {
            this.loadSuccessCount.increment();
            this.totalLoadTime.add(r2);
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordLoadException(long r2) {
            this.loadExceptionCount.increment();
            this.totalLoadTime.add(r2);
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordEviction() {
            this.evictionCount.increment();
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public CacheStats snapshot() {
            return new CacheStats(negativeToMaxValue(this.hitCount.sum()), negativeToMaxValue(this.missCount.sum()), negativeToMaxValue(this.loadSuccessCount.sum()), negativeToMaxValue(this.loadExceptionCount.sum()), negativeToMaxValue(this.totalLoadTime.sum()), negativeToMaxValue(this.evictionCount.sum()));
        }

        public void incrementBy(StatsCounter r4) {
            CacheStats r5 = r4.snapshot();
            this.hitCount.add(r5.hitCount());
            this.missCount.add(r5.missCount());
            this.loadSuccessCount.add(r5.loadSuccessCount());
            this.loadExceptionCount.add(r5.loadExceptionCount());
            this.totalLoadTime.add(r5.totalLoadTime());
            this.evictionCount.add(r5.evictionCount());
        }
    }

    public interface StatsCounter {
        void recordEviction();

        void recordHits(int r1);

        void recordLoadException(long r1);

        void recordLoadSuccess(long r1);

        void recordMisses(int r1);

        CacheStats snapshot();
    }

    @Override // com.google.common.cache.Cache
    public void cleanUp() {
    }

    protected AbstractCache() {
    }

    @Override // com.google.common.cache.Cache
    public V get(K r1, Callable<? extends V> r2) throws ExecutionException {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.cache.Cache
    public ImmutableMap<K, V> getAllPresent(Iterable<? extends Object> r4) {
        LinkedHashMap r0 = Maps.newLinkedHashMap();
        Iterator<? extends Object> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L11;
        Object r1 = r5.next();
        if (r0.containsKey(r1) == true) goto L4;
        V r2 = getIfPresent(r1);
        if (r2 == null) goto L4;
        r0.put(r1, r2);
        goto L4
    L11:
        return ImmutableMap.copyOf(r0);
    }

    @Override // com.google.common.cache.Cache
    public void put(K r1, V r2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.cache.Cache
    public void putAll(Map<? extends K, ? extends V> r3) {
        Iterator<Map.Entry<? extends K, ? extends V>> r4 = r3.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Map.Entry<? extends K, ? extends V> r0 = r4.next();
        put(r0.getKey(), r0.getValue());
        goto L4
    }

    @Override // com.google.common.cache.Cache
    public long size() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.cache.Cache
    public void invalidate(Object r1) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.cache.Cache
    public void invalidateAll(Iterable<? extends Object> r2) {
        Iterator<? extends Object> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        invalidate(r3.next());
        goto L4
    }

    @Override // com.google.common.cache.Cache
    public void invalidateAll() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.cache.Cache
    public CacheStats stats() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.cache.Cache
    public ConcurrentMap<K, V> asMap() {
        throw new UnsupportedOperationException();
    }
}
