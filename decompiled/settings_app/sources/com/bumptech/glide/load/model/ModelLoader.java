package com.bumptech.glide.load.model;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.util.Preconditions;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface ModelLoader<Model, Data> {

    public static class LoadData<Data> {
        public final List<Key> alternateKeys;
        public final DataFetcher<Data> fetcher;
        public final Key sourceKey;

        public LoadData(Key r2, DataFetcher<Data> r3) {
            this(r2, Collections.emptyList(), r3);
        }

        public LoadData(Key r1, List<Key> r2, DataFetcher<Data> r3) {
            this.sourceKey = (Key) Preconditions.checkNotNull(r1);
            this.alternateKeys = (List) Preconditions.checkNotNull(r2);
            this.fetcher = (DataFetcher) Preconditions.checkNotNull(r3);
        }
    }

    LoadData<Data> buildLoadData(Model r1, int r2, int r3, Options r4);

    boolean handles(Model r1);
}
