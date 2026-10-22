package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;

/* JADX INFO: loaded from: classes3.dex */
public interface MemoryCache {

    public interface ResourceRemovedListener {
        void onResourceRemoved(Resource<?> r1);
    }

    void clearMemory();

    long getCurrentSize();

    long getMaxSize();

    Resource<?> put(Key r1, Resource<?> r2);

    Resource<?> remove(Key r1);

    void setResourceRemovedListener(ResourceRemovedListener r1);

    void setSizeMultiplier(float r1);

    void trimMemory(int r1);
}
