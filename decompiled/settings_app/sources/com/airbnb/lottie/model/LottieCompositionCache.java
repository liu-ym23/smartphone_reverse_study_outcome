package com.airbnb.lottie.model;

import androidx.collection.LruCache;
import com.airbnb.lottie.LottieComposition;

/* JADX INFO: loaded from: classes.dex */
public class LottieCompositionCache {
    private static final LottieCompositionCache INSTANCE = null;
    private final LruCache<String, LottieComposition> cache;

    static {
        INSTANCE = new LottieCompositionCache();
    }

    public static LottieCompositionCache getInstance() {
        return INSTANCE;
    }

    LottieCompositionCache() {
        this.cache = new LruCache(20);
    }

    public LottieComposition get(String r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return this.cache.get(r1);
    }

    public void put(String r1, LottieComposition r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.cache.put(r1, r2);
    }

    public void clear() {
        this.cache.evictAll();
    }

    public void resize(int r1) {
        this.cache.resize(r1);
    }
}
