package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class LocalUriFetcher<T> implements DataFetcher<T> {
    private static final String TAG = "LocalUriFetcher";
    private final ContentResolver contentResolver;
    private T data;
    private final Uri uri;

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
    }

    protected abstract void close(T r1) throws IOException;

    protected abstract T loadResource(Uri r1, ContentResolver r2) throws FileNotFoundException;

    public LocalUriFetcher(ContentResolver r1, Uri r2) {
        this.contentResolver = r1;
        this.uri = r2;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void loadData(Priority r2, DataFetcher.DataCallback<? super T> r3) {
        T r4 = loadResource(this.uri, this.contentResolver);     // Catch: FileNotFoundException -> L4
        this.data = r4;     // Catch: FileNotFoundException -> L4
        r3.onDataReady(r4);     // Catch: FileNotFoundException -> L4
        return;
    L4:
        e = move-exception;
        if (Log.isLoggable(TAG, 3) == false) goto L8;
        Log.d(TAG, "Failed to open Uri", e);
    L8:
        r3.onLoadFailed(e);
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
        T r0 = this.data;
        if (r0 == null) goto L9;
        close(r0);     // Catch: IOException -> L6
        return;
    L10:
        return;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }
}
