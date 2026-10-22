package com.bumptech.glide.load.engine.cache;

import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class DiskLruCacheFactory implements DiskCache.Factory {
    private final CacheDirectoryGetter cacheDirectoryGetter;
    private final long diskCacheSize;

    public interface CacheDirectoryGetter {
        File getCacheDirectory();
    }

    public DiskLruCacheFactory(final String r2, long r3) {
        this(new AnonymousClass1(r2), r3);
    }

    public DiskLruCacheFactory(final String r2, final String r3, long r4) {
        this(new AnonymousClass2(r2, r3), r4);
    }

    public DiskLruCacheFactory(CacheDirectoryGetter r1, long r2) {
        this.diskCacheSize = r2;
        this.cacheDirectoryGetter = r1;
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache.Factory
    public DiskCache build() {
        File r0 = this.cacheDirectoryGetter.getCacheDirectory();
        if (r0 != null) goto L6;
        return null;
    L6:
        if (r0.isDirectory() == true) goto L12;
        if (r0.mkdirs() == true) goto L12;
        return null;
    L12:
        return DiskLruCacheWrapper.create(r0, this.diskCacheSize);
    }
}
