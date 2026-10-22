package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.pool.GlideTrace;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
class ResourceCacheGenerator implements DataFetcherGenerator, DataFetcher.DataCallback<Object> {
    private File cacheFile;
    private final DataFetcherGenerator.FetcherReadyCallback cb;
    private ResourceCacheKey currentKey;
    private final DecodeHelper<?> helper;
    private volatile ModelLoader.LoadData<?> loadData;
    private int modelLoaderIndex;
    private List<ModelLoader<File, ?>> modelLoaders;
    private int resourceClassIndex;
    private int sourceIdIndex;
    private Key sourceKey;

    ResourceCacheGenerator(DecodeHelper<?> r2, DataFetcherGenerator.FetcherReadyCallback r3) {
        this.resourceClassIndex = -1;
        this.helper = r2;
        this.cb = r3;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public boolean startNext() {
        GlideTrace.beginSection("ResourceCacheGenerator.startNext");
        List<Key> r1 = this.helper.getCacheKeys();     // Catch: Throwable -> L44
        boolean r3 = false;
        if (r1.isEmpty() == false) goto L8;
        GlideTrace.endSection();
        return false;
    L8:
        List<Class<?>> r2 = this.helper.getRegisteredResourceClasses();     // Catch: Throwable -> L44
        if (r2.isEmpty() == false) goto L17;
        if (File.class.equals(this.helper.getTranscodeClass()) == false) goto L15;
        GlideTrace.endSection();
        return false;
    L15:
        throw new IllegalStateException("Failed to find any load path from " + this.helper.getModelClass() + " to " + this.helper.getTranscodeClass());     // Catch: Throwable -> L44
    L17:
        if (this.modelLoaders != null) goto L19;
    L33:
        int r0 = this.resourceClassIndex + 1;     // Catch: Throwable -> L44
        this.resourceClassIndex = r0;     // Catch: Throwable -> L44
        if (r0 < r2.size()) goto L40;
        int r4 = this.sourceIdIndex + 1;     // Catch: Throwable -> L44
        this.sourceIdIndex = r4;     // Catch: Throwable -> L44
        if (r4 >= r1.size()) goto L37;
        this.resourceClassIndex = 0;     // Catch: Throwable -> L44
        goto L40
    L37:
        GlideTrace.endSection();
        return false;
    L40:
        Key r5 = r1.get(this.sourceIdIndex);     // Catch: Throwable -> L44
        Class<?> r11 = r2.get(this.resourceClassIndex);     // Catch: Throwable -> L44
        this.currentKey = new ResourceCacheKey(this.helper.getArrayPool(), r5, this.helper.getSignature(), this.helper.getWidth(), this.helper.getHeight(), this.helper.getTransformation(r11), r11, this.helper.getOptions());     // Catch: Throwable -> L44
        File r6 = this.helper.getDiskCache().get(this.currentKey);     // Catch: Throwable -> L44
        this.cacheFile = r6;     // Catch: Throwable -> L44
        if (r6 == null) goto L17;
        this.sourceKey = r5;     // Catch: Throwable -> L44
        this.modelLoaders = this.helper.getModelLoaders(r6);     // Catch: Throwable -> L44
        this.modelLoaderIndex = 0;     // Catch: Throwable -> L44
        goto L17
    L19:
        if (hasNextModelLoader() == false) goto L33;
        this.loadData = null;     // Catch: Throwable -> L44
    L22:
        if (r3 == true) goto L31;
        if (hasNextModelLoader() == false) goto L31;
        List<ModelLoader<File, ?>> r7 = this.modelLoaders;     // Catch: Throwable -> L44
        int r8 = this.modelLoaderIndex;     // Catch: Throwable -> L44
        this.modelLoaderIndex = r8 + 1;     // Catch: Throwable -> L44
        this.loadData = r7.get(r8).buildLoadData(this.cacheFile, this.helper.getWidth(), this.helper.getHeight(), this.helper.getOptions());     // Catch: Throwable -> L44
        if (this.loadData == null) goto L22;
        if (this.helper.hasLoadPath(this.loadData.fetcher.getDataClass()) == false) goto L22;
        this.loadData.fetcher.loadData(this.helper.getPriority(), this);     // Catch: Throwable -> L44
        r3 = true;
    L31:
        GlideTrace.endSection();
        return r3;
    L44:
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
        this.cb.onDataFetcherReady(this.sourceKey, r7, this.loadData.fetcher, DataSource.RESOURCE_DISK_CACHE, this.currentKey);
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void onLoadFailed(Exception r4) {
        this.cb.onDataFetcherFailed(this.currentKey, r4, this.loadData.fetcher, DataSource.RESOURCE_DISK_CACHE);
    }
}
