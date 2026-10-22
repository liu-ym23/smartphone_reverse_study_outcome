package com.bumptech.glide.load.model;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.signature.ObjectKey;
import java.io.File;
import java.io.FileNotFoundException;

/* JADX INFO: loaded from: classes.dex */
public final class MediaStoreFileLoader implements ModelLoader<Uri, File> {
    private final Context context;

    public static final class Factory implements ModelLoaderFactory<Uri, File> {
        private final Context context;

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        public Factory(Context r1) {
            this.context = r1;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<Uri, File> build(MultiModelLoaderFactory r1) {
            return new MediaStoreFileLoader(this.context);
        }
    }

    private static class FilePathFetcher implements DataFetcher<File> {
        private static final String[] PROJECTION = null;
        private final Context context;
        private final Uri uri;

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
        }

        static {
            PROJECTION = new String[]{"_data"};
        }

        FilePathFetcher(Context r1, Uri r2) {
            this.context = r1;
            this.uri = r2;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void loadData(Priority r7, DataFetcher.DataCallback<? super File> r8) {
            Cursor r9 = this.context.getContentResolver().query(this.uri, PROJECTION, null, null, null);
            String r0 = null;
            if (r9 == null) goto L12;
        L8:
            th = move-exception;
            r9.close();
            throw th;
        L5:
            if (r9.moveToFirst() == false) goto L7;
            r0 = r9.getString(r9.getColumnIndexOrThrow("_data"));     // Catch: Throwable -> L8
        L7:
            r9.close();
        L12:
            if (TextUtils.isEmpty(r0) == false) goto L14;
            r8.onLoadFailed(new FileNotFoundException("Failed to find file path for: " + this.uri));
            return;
        L14:
            r8.onDataReady(new File(r0));
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public Class<File> getDataClass() {
            return File.class;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public /* bridge */ /* synthetic */ ModelLoader.LoadData<File> buildLoadData(Uri r1, int r2, int r3, Options r4) {
        return buildLoadData2(r1, r2, r3, r4);
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public /* bridge */ /* synthetic */ boolean handles(Uri r1) {
        return handles2(r1);
    }

    public MediaStoreFileLoader(Context r1) {
        this.context = r1;
    }

    /* JADX INFO: renamed from: buildLoadData, reason: avoid collision after fix types in other method */
    public ModelLoader.LoadData<File> buildLoadData2(Uri r1, int r2, int r3, Options r4) {
        return new ModelLoader.LoadData(new ObjectKey(r1), new FilePathFetcher(this.context, r1));
    }

    /* JADX INFO: renamed from: handles, reason: avoid collision after fix types in other method */
    public boolean handles2(Uri r1) {
        return MediaStoreUtil.isMediaStoreUri(r1);
    }
}
