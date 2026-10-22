package com.bumptech.glide.load.data;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;

/* JADX INFO: loaded from: classes3.dex */
public interface DataFetcher<T> {

    public interface DataCallback<T> {
        void onDataReady(T r1);

        void onLoadFailed(Exception r1);
    }

    void cancel();

    void cleanup();

    Class<T> getDataClass();

    DataSource getDataSource();

    void loadData(Priority r1, DataCallback<? super T> r2);
}
