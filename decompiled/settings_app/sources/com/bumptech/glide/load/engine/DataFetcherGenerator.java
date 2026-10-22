package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;

/* JADX INFO: loaded from: classes3.dex */
interface DataFetcherGenerator {

    public interface FetcherReadyCallback {
        void onDataFetcherFailed(Key r1, Exception r2, DataFetcher<?> r3, DataSource r4);

        void onDataFetcherReady(Key r1, Object r2, DataFetcher<?> r3, DataSource r4, Key r5);

        void reschedule();
    }

    void cancel();

    boolean startNext();
}
