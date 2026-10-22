package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AssetPathFetcher<T> implements DataFetcher<T> {
    private static final String TAG = "AssetPathFetcher";
    private final AssetManager assetManager;
    private final String assetPath;
    private T data;

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
    }

    protected abstract void close(T r1) throws IOException;

    protected abstract T loadResource(AssetManager r1, String r2) throws IOException;

    public AssetPathFetcher(AssetManager r1, String r2) {
        this.assetManager = r1;
        this.assetPath = r2;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void loadData(Priority r2, DataFetcher.DataCallback<? super T> r3) {
        T r4 = loadResource(this.assetManager, this.assetPath);     // Catch: IOException -> L4
        this.data = r4;     // Catch: IOException -> L4
        r3.onDataReady(r4);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        if (Log.isLoggable(TAG, 3) == false) goto L8;
        Log.d(TAG, "Failed to load data from asset manager", e);
    L8:
        r3.onLoadFailed(e);
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
        T r0 = this.data;
        if (r0 != null) goto L8;
        return;
    L8:
        close(r0);     // Catch: IOException -> L7
        return;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }
}
