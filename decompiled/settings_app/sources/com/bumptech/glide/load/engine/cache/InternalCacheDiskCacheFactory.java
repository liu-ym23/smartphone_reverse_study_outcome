package com.bumptech.glide.load.engine.cache;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public final class InternalCacheDiskCacheFactory extends DiskLruCacheFactory {
    public InternalCacheDiskCacheFactory(Context r4) {
        this(r4, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR, 262144000);
    }

    public InternalCacheDiskCacheFactory(Context r2, long r3) {
        this(r2, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR, r3);
    }

    public InternalCacheDiskCacheFactory(final Context r2, final String r3, long r4) {
        super(new AnonymousClass1(r2, r3), r4);
    }
}
