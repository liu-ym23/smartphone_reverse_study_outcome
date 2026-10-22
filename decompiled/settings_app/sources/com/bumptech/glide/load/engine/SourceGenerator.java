package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.LogTime;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
class SourceGenerator implements DataFetcherGenerator, DataFetcherGenerator.FetcherReadyCallback {
    private static final String TAG = "SourceGenerator";
    private final DataFetcherGenerator.FetcherReadyCallback cb;
    private volatile Object dataToCache;
    private final DecodeHelper<?> helper;
    private volatile ModelLoader.LoadData<?> loadData;
    private volatile int loadDataListIndex;
    private volatile DataCacheKey originalKey;
    private volatile DataCacheGenerator sourceCacheGenerator;

    SourceGenerator(DecodeHelper<?> r1, DataFetcherGenerator.FetcherReadyCallback r2) {
        this.helper = r1;
        this.cb = r2;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public boolean startNext() {
        if (this.dataToCache == null) goto L13;
        Object r0 = this.dataToCache;
        this.dataToCache = null;
        if (cacheData(r0) == true) goto L13;
        return true;
    L8:
        e = move-exception;
        if (Log.isLoggable(TAG, 3) == false) goto L13;
        Log.d(TAG, "Failed to properly rewind or write data to cache", e);
    L13:
        if (this.sourceCacheGenerator != null) goto L15;
    L17:
        this.sourceCacheGenerator = null;
        this.loadData = null;
        boolean r1 = false;
    L18:
        if (r1 == true) goto L28;
        if (hasNextModelLoader() == false) goto L28;
        List<ModelLoader.LoadData<?>> r2 = this.helper.getLoadData();
        int r3 = this.loadDataListIndex;
        this.loadDataListIndex = r3 + 1;
        this.loadData = r2.get(r3);
        if (this.loadData == null) goto L18;
        if (this.helper.getDiskCacheStrategy().isDataCacheable(this.loadData.fetcher.getDataSource()) == true) goto L27;
        if (this.helper.hasLoadPath(this.loadData.fetcher.getDataClass()) == false) goto L18;
    L27:
        startNextLoad(this.loadData);
        r1 = true;
    L28:
        return r1;
    L15:
        if (this.sourceCacheGenerator.startNext() == false) goto L17;
        return true;
    }

    private void startNextLoad(final ModelLoader.LoadData<?> r4) {
        this.loadData.fetcher.loadData(this.helper.getPriority(), new AnonymousClass1(this, r4));
    }

    boolean isCurrentRequest(ModelLoader.LoadData<?> r1) {
        ModelLoader.LoadData<?> r0 = this.loadData;
        if (r0 == null) goto L6;
        if (r0 != r1) goto L6;
        return true;
    L6:
        return false;
    }

    private boolean hasNextModelLoader() {
        if (this.loadDataListIndex >= this.helper.getLoadData().size()) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean cacheData(Object r13) throws IOException {
        long r3 = LogTime.getLogTime();
        boolean r5 = false;
        DataRewinder<T> r6 = this.helper.getRewinder(r13);     // Catch: Throwable -> L20
        Object r7 = r6.rewindAndGet();     // Catch: Throwable -> L20
        Encoder<X> r8 = this.helper.getSourceEncoder(r7);     // Catch: Throwable -> L20
        DataCacheWriter r9 = new DataCacheWriter(r8, r7, this.helper.getOptions());     // Catch: Throwable -> L20
        DataCacheKey r10 = new DataCacheKey(this.loadData.sourceKey, this.helper.getSignature());     // Catch: Throwable -> L20
        DiskCache r11 = this.helper.getDiskCache();     // Catch: Throwable -> L20
        r11.put(r10, r9);     // Catch: Throwable -> L20
        if (Log.isLoggable(TAG, 2) == false) goto L8;
        Log.v(TAG, "Finished encoding source to cache, key: " + r10 + ", data: " + r13 + ", encoder: " + r8 + ", duration: " + LogTime.getElapsedMillis(r3));     // Catch: Throwable -> L20
    L8:
        if (r11.get(r10) == null) goto L14;
        this.originalKey = r10;     // Catch: Throwable -> L20
        this.sourceCacheGenerator = new DataCacheGenerator(Collections.singletonList(this.loadData.sourceKey), this.helper, this);     // Catch: Throwable -> L20
        this.loadData.fetcher.cleanup();
        return true;
    L14:
        if (Log.isLoggable(TAG, 3) == false) goto L25;
        Log.d(TAG, "Attempt to write: " + this.originalKey + ", data: " + r13 + " to the disk cache failed, maybe the disk cache is disabled? Trying to decode the data directly...");     // Catch: Throwable -> L20
    L25:
        this.cb.onDataFetcherReady(this.loadData.sourceKey, r6.rewindAndGet(), this.loadData.fetcher, this.loadData.fetcher.getDataSource(), this.loadData.sourceKey);     // Catch: Throwable -> L18
        return false;
    L18:
        th = th;
        r5 = true;
    L21:
        if (r5 == true) goto L23;
        this.loadData.fetcher.cleanup();
    L23:
        throw th;
    L20:
        th = th;
        goto L21
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public void cancel() {
        ModelLoader.LoadData<?> r0 = this.loadData;
        if (r0 == null) goto L6;
        r0.fetcher.cancel();
        return;
    }

    void onDataReadyInternal(ModelLoader.LoadData<?> r7, Object r8) {
        DiskCacheStrategy r0 = this.helper.getDiskCacheStrategy();
        if (r8 != null) goto L5;
    L7:
        this.cb.onDataFetcherReady(r7.sourceKey, r8, r7.fetcher, r7.fetcher.getDataSource(), this.originalKey);
        return;
    L5:
        if (r0.isDataCacheable(r7.fetcher.getDataSource()) == false) goto L7;
        this.dataToCache = r8;
        this.cb.reschedule();
    }

    void onLoadFailedInternal(ModelLoader.LoadData<?> r3, Exception r4) {
        this.cb.onDataFetcherFailed(this.originalKey, r4, r3.fetcher, r3.fetcher.getDataSource());
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void reschedule() {
        throw new UnsupportedOperationException();
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void onDataFetcherReady(Key r7, Object r8, DataFetcher<?> r9, DataSource r10, Key r11) {
        this.cb.onDataFetcherReady(r7, r8, r9, this.loadData.fetcher.getDataSource(), r7);
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void onDataFetcherFailed(Key r1, Exception r2, DataFetcher<?> r3, DataSource r4) {
        this.cb.onDataFetcherFailed(r1, r2, r3, this.loadData.fetcher.getDataSource());
    }
}
