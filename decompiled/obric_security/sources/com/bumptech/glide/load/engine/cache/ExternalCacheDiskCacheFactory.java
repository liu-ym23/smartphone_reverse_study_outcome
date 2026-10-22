package com.bumptech.glide.load.engine.cache;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class ExternalCacheDiskCacheFactory extends DiskLruCacheFactory {
    public ExternalCacheDiskCacheFactory(Context r3) {
        this(r3, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR, DiskCache.Factory.DEFAULT_DISK_CACHE_SIZE);
    }

    public ExternalCacheDiskCacheFactory(Context r2, int r3) {
        this(r2, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR, r3);
    }

    public ExternalCacheDiskCacheFactory(final Context r2, final String r3, int r4) {
        super(new AnonymousClass1(r2, r3), r4);
    }
}
