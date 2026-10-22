package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;

/* JADX INFO: loaded from: classes3.dex */
public class MemoryCacheAdapter implements MemoryCache {
    private MemoryCache.ResourceRemovedListener listener;

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public void clearMemory() {
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public long getCurrentSize() {
        return 0;
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public long getMaxSize() {
        return 0;
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public Resource<?> remove(Key r1) {
        return null;
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public void setSizeMultiplier(float r1) {
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public void trimMemory(int r1) {
    }

    public MemoryCacheAdapter() {
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public Resource<?> put(Key r1, Resource<?> r2) {
        if (r2 == null) goto L6;
        this.listener.onResourceRemoved(r2);
        return null;
    L6:
        return null;
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public void setResourceRemovedListener(MemoryCache.ResourceRemovedListener r1) {
        this.listener = r1;
    }
}
