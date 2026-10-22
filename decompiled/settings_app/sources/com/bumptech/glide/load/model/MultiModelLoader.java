package com.bumptech.glide.load.model;

import androidx.core.util.Pools;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
class MultiModelLoader<Model, Data> implements ModelLoader<Model, Data> {
    private final Pools.Pool<List<Throwable>> exceptionListPool;
    private final List<ModelLoader<Model, Data>> modelLoaders;

    static class MultiFetcher<Data> implements DataFetcher<Data>, DataFetcher.DataCallback<Data> {
        private DataFetcher.DataCallback<? super Data> callback;
        private int currentIndex;
        private List<Throwable> exceptions;
        private final List<DataFetcher<Data>> fetchers;
        private boolean isCancelled;
        private Priority priority;
        private final Pools.Pool<List<Throwable>> throwableListPool;

        MultiFetcher(List<DataFetcher<Data>> r1, Pools.Pool<List<Throwable>> r2) {
            this.throwableListPool = r2;
            Preconditions.checkNotEmpty(r1);
            this.fetchers = r1;
            this.currentIndex = 0;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void loadData(Priority r2, DataFetcher.DataCallback<? super Data> r3) {
            this.priority = r2;
            this.callback = r3;
            this.exceptions = this.throwableListPool.acquire();
            this.fetchers.get(this.currentIndex).loadData(r2, this);
            if (this.isCancelled == false) goto L6;
            cancel();
            return;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
            List<Throwable> r0 = this.exceptions;
            if (r0 == null) goto L5;
            this.throwableListPool.release(r0);
        L5:
            this.exceptions = null;
            Iterator<DataFetcher<Data>> r2 = this.fetchers.iterator();
        L7:
            if (r2.hasNext() == false) goto L9;
            r2.next().cleanup();
            goto L7
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
            this.isCancelled = true;
            Iterator<DataFetcher<Data>> r1 = this.fetchers.iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            r1.next().cancel();
            goto L4
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public Class<Data> getDataClass() {
            return this.fetchers.get(0).getDataClass();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public DataSource getDataSource() {
            return this.fetchers.get(0).getDataSource();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
        public void onDataReady(Data r1) {
            if (r1 == null) goto L4;
            this.callback.onDataReady(r1);
            return;
        L4:
            startNextOrFail();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
        public void onLoadFailed(Exception r2) {
            ((List) Preconditions.checkNotNull(this.exceptions)).add(r2);
            startNextOrFail();
        }

        private void startNextOrFail() {
            if (this.isCancelled == false) goto L6;
            return;
        L6:
            if (this.currentIndex >= (this.fetchers.size() - 1)) goto L8;
            this.currentIndex++;
            loadData(this.priority, this.callback);
            return;
        L8:
            Preconditions.checkNotNull(this.exceptions);
            this.callback.onLoadFailed(new GlideException("Fetch failed", new ArrayList(this.exceptions)));
        }
    }

    MultiModelLoader(List<ModelLoader<Model, Data>> r1, Pools.Pool<List<Throwable>> r2) {
        this.modelLoaders = r1;
        this.exceptionListPool = r2;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<Data> buildLoadData(Model r8, int r9, int r10, Options r11) {
        int r0 = this.modelLoaders.size();
        ArrayList r1 = new ArrayList(r0);
        int r3 = 0;
        Key r4 = null;
    L3:
        if (r3 >= r0) goto L11;
        ModelLoader<Model, Data> r5 = this.modelLoaders.get(r3);
        if (r5.handles(r8) == false) goto L9;
        ModelLoader.LoadData<Data> r6 = r5.buildLoadData(r8, r9, r10, r11);
        if (r6 == null) goto L9;
        r4 = r6.sourceKey;
        r1.add(r6.fetcher);
    L9:
        r3 = r3 + 1;
        goto L3
    L11:
        if (r1.isEmpty() == true) goto L19;
        if (r4 != null) goto L14;
        return null;
    L14:
        return new ModelLoader.LoadData(r4, new MultiFetcher(r1, this.exceptionListPool));
    L19:
        return null;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(Model r2) {
        Iterator<ModelLoader<Model, Data>> r1 = this.modelLoaders.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        if (r1.next().handles(r2) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.modelLoaders.toArray()) + '}';
    }
}
