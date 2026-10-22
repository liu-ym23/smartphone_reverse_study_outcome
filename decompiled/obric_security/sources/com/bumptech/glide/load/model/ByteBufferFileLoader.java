package com.bumptech.glide.load.model;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.signature.ObjectKey;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class ByteBufferFileLoader implements ModelLoader<File, ByteBuffer> {
    private static final String TAG = "ByteBufferFileLoader";

    private static final class ByteBufferFetcher implements DataFetcher<ByteBuffer> {
        private final File file;

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
        }

        ByteBufferFetcher(File r1) {
            this.file = r1;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void loadData(Priority r2, DataFetcher.DataCallback<? super ByteBuffer> r3) {
            r3.onDataReady(ByteBufferUtil.fromFile(this.file));     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            if (Log.isLoggable(ByteBufferFileLoader.TAG, 3) == false) goto L8;
            Log.d(ByteBufferFileLoader.TAG, "Failed to obtain ByteBuffer for file", e);
        L8:
            r3.onLoadFailed(e);
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public Class<ByteBuffer> getDataClass() {
            return ByteBuffer.class;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }
    }

    public static class Factory implements ModelLoaderFactory<File, ByteBuffer> {
        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        public Factory() {
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<File, ByteBuffer> build(MultiModelLoaderFactory r1) {
            return new ByteBufferFileLoader();
        }
    }

    /* JADX INFO: renamed from: handles, reason: avoid collision after fix types in other method */
    public boolean handles2(File r1) {
        return true;
    }

    public ByteBufferFileLoader() {
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public /* bridge */ /* synthetic */ ModelLoader.LoadData<ByteBuffer> buildLoadData(File r1, int r2, int r3, Options r4) {
        return buildLoadData2(r1, r2, r3, r4);
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public /* bridge */ /* synthetic */ boolean handles(File r1) {
        return handles2(r1);
    }

    /* JADX INFO: renamed from: buildLoadData, reason: avoid collision after fix types in other method */
    public ModelLoader.LoadData<ByteBuffer> buildLoadData2(File r1, int r2, int r3, Options r4) {
        return new ModelLoader.LoadData(new ObjectKey(r1), new ByteBufferFetcher(r1));
    }
}
