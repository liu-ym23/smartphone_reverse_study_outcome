package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;

/* JADX INFO: loaded from: classes.dex */
public abstract class DiskCacheStrategy {
    public static final DiskCacheStrategy ALL = null;
    public static final DiskCacheStrategy AUTOMATIC = null;
    public static final DiskCacheStrategy DATA = null;
    public static final DiskCacheStrategy NONE = null;
    public static final DiskCacheStrategy RESOURCE = null;

    public abstract boolean decodeCachedData();

    public abstract boolean decodeCachedResource();

    public abstract boolean isDataCacheable(DataSource r1);

    public abstract boolean isResourceCacheable(boolean r1, DataSource r2, EncodeStrategy r3);

    public DiskCacheStrategy() {
    }

    static {
        ALL = new AnonymousClass1();
        NONE = new AnonymousClass2();
        DATA = new AnonymousClass3();
        RESOURCE = new AnonymousClass4();
        AUTOMATIC = new AnonymousClass5();
    }
}
