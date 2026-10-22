package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.pool.GlideTrace;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class DataCacheGenerator implements DataFetcherGenerator, DataFetcher.DataCallback<Object> {
    private File cacheFile;
    private final List<Key> cacheKeys;
    private final DataFetcherGenerator.FetcherReadyCallback cb;
    private final DecodeHelper<?> helper;
    private volatile ModelLoader.LoadData<?> loadData;
    private int modelLoaderIndex;
    private List<ModelLoader<File, ?>> modelLoaders;
    private int sourceIdIndex;
    private Key sourceKey;

    DataCacheGenerator(DecodeHelper<?> r2, DataFetcherGenerator.FetcherReadyCallback r3) {
        this(r2.getCacheKeys(), r2, r3);
    }

    DataCacheGenerator(List<Key> r2, DecodeHelper<?> r3, DataFetcherGenerator.FetcherReadyCallback r4) {
        this.sourceIdIndex = -1;
        this.cacheKeys = r2;
        this.helper = r3;
        this.cb = r4;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public boolean startNext() {
        GlideTrace.beginSection("DataCacheGenerator.startNext");
    L31:
        boolean r1 = false;
        if (this.modelLoaders != null) goto L6;
    L20:
        int r0 = this.sourceIdIndex + 1;     // Catch: Throwable -> L28
        this.sourceIdIndex = r0;     // Catch: Throwable -> L28
        if (r0 >= this.cacheKeys.size()) goto L22;
        Key r2 = this.cacheKeys.get(this.sourceIdIndex);     // Catch: Throwable -> L28
        File r3 = this.helper.getDiskCache().get(new DataCacheKey(r2, this.helper.getSignature()));     // Catch: Throwable -> L28
        this.cacheFile = r3;     // Catch: Throwable -> L28
        if (r3 == null) goto L31;
        this.sourceKey = r2;     // Catch: Throwable -> L28
        this.modelLoaders = this.helper.getModelLoaders(r3);     // Catch: Throwable -> L28
        this.modelLoaderIndex = 0;     // Catch: Throwable -> L28
        goto L31
    L22:
        GlideTrace.endSection();
        return false;
    L6:
        if (hasNextModelLoader() == false) goto L20;
        this.loadData = null;     // Catch: Throwable -> L28
    L9:
        if (r1 == true) goto L18;
        if (hasNextModelLoader() == false) goto L18;
        List<ModelLoader<File, ?>> r4 = this.modelLoaders;     // Catch: Throwable -> L28
        int r5 = this.modelLoaderIndex;     // Catch: Throwable -> L28
        this.modelLoaderIndex = r5 + 1;     // Catch: Throwable -> L28
        this.loadData = r4.get(r5).buildLoadData(this.cacheFile, this.helper.getWidth(), this.helper.getHeight(), this.helper.getOptions());     // Catch: Throwable -> L28
        if (this.loadData == null) goto L9;
        if (this.helper.hasLoadPath(this.loadData.fetcher.getDataClass()) == false) goto L9;
        this.loadData.fetcher.loadData(this.helper.getPriority(), this);     // Catch: Throwable -> L28
        r1 = true;
    L18:
        GlideTrace.endSection();
        return r1;
    L28:
        th = move-exception;
        GlideTrace.endSection();
        throw th;
    }

    private boolean hasNextModelLoader() {
        if (this.modelLoaderIndex >= this.modelLoaders.size()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public void cancel() {
        ModelLoader.LoadData<?> r0 = this.loadData;
        if (r0 == null) goto L6;
        r0.fetcher.cancel();
        return;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void onDataReady(Object r7) {
        this.cb.onDataFetcherReady(this.sourceKey, r7, this.loadData.fetcher, DataSource.DATA_DISK_CACHE, this.sourceKey);
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void onLoadFailed(Exception r4) {
        this.cb.onDataFetcherFailed(this.sourceKey, r4, this.loadData.fetcher, DataSource.DATA_DISK_CACHE);
    }
}
