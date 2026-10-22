package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.LruCache;

/* JADX INFO: loaded from: classes3.dex */
public class LruResourceCache extends LruCache<Key, Resource<?>> implements MemoryCache {
    private MemoryCache.ResourceRemovedListener listener;

    @Override // com.bumptech.glide.util.LruCache
    protected /* bridge */ /* synthetic */ int getSize(Resource<?> r1) {
        return getSize2(r1);
    }

    @Override // com.bumptech.glide.util.LruCache
    protected /* bridge */ /* synthetic */ void onItemEvicted(Key r1, Resource<?> r2) {
        onItemEvicted2(r1, r2);
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public /* bridge */ /* synthetic */ Resource put(Key r1, Resource r2) {
        return (Resource) super.put(r1, r2);
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public /* bridge */ /* synthetic */ Resource remove(Key r1) {
        return (Resource) super.remove(r1);
    }

    public LruResourceCache(long r1) {
        super(r1);
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public void setResourceRemovedListener(MemoryCache.ResourceRemovedListener r1) {
        this.listener = r1;
    }

    /* JADX INFO: renamed from: onItemEvicted, reason: avoid collision after fix types in other method */
    protected void onItemEvicted2(Key r1, Resource<?> r2) {
        MemoryCache.ResourceRemovedListener r0 = this.listener;
        if (r0 == null) goto L7;
        if (r2 == null) goto L8;
        r0.onResourceRemoved(r2);
        return;
    L8:
        return;
    }

    /* JADX INFO: renamed from: getSize, reason: avoid collision after fix types in other method */
    protected int getSize2(Resource<?> r1) {
        if (r1 != null) goto L6;
        return super.getSize(null);
    L6:
        return r1.getSize();
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public void trimMemory(int r5) {
        if (r5 < 40) goto L6;
        clearMemory();
        return;
    L6:
        if (r5 < 20) goto L8;
    L9:
        trimToSize(getMaxSize() / 2);
        return;
    L8:
        if (r5 == 15) goto L9;
    }
}
