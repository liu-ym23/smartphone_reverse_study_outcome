package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.signature.ObjectKey;
import com.bytedanceos.security.permission.NativePermissionManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class QMediaStoreUriLoader<DataT> implements ModelLoader<Uri, DataT> {
    private final Context context;
    private final Class<DataT> dataClass;
    private final ModelLoader<File, DataT> fileDelegate;
    private final ModelLoader<Uri, DataT> uriDelegate;

    private static abstract class Factory<DataT> implements ModelLoaderFactory<Uri, DataT> {
        private final Context context;
        private final Class<DataT> dataClass;

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final void teardown() {
        }

        Factory(Context r1, Class<DataT> r2) {
            this.context = r1;
            this.dataClass = r2;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final ModelLoader<Uri, DataT> build(MultiModelLoaderFactory r6) {
            return new QMediaStoreUriLoader(this.context, r6.build(File.class, this.dataClass), r6.build(Uri.class, this.dataClass), this.dataClass);
        }
    }

    public static final class FileDescriptorFactory extends Factory<ParcelFileDescriptor> {
        public FileDescriptorFactory(Context r2) {
            super(r2, ParcelFileDescriptor.class);
        }
    }

    public static final class InputStreamFactory extends Factory<InputStream> {
        public InputStreamFactory(Context r2) {
            super(r2, InputStream.class);
        }
    }

    private static final class QMediaStoreUriFetcher<DataT> implements DataFetcher<DataT> {
        private static final String[] PROJECTION = null;
        private final Context context;
        private final Class<DataT> dataClass;
        private volatile DataFetcher<DataT> delegate;
        private final ModelLoader<File, DataT> fileDelegate;
        private final int height;
        private volatile boolean isCancelled;
        private final Options options;
        private final Uri uri;
        private final ModelLoader<Uri, DataT> uriDelegate;
        private final int width;

        static {
            PROJECTION = new String[]{"_data"};
        }

        QMediaStoreUriFetcher(Context r1, ModelLoader<File, DataT> r2, ModelLoader<Uri, DataT> r3, Uri r4, int r5, int r6, Options r7, Class<DataT> r8) {
            this.context = r1.getApplicationContext();
            this.fileDelegate = r2;
            this.uriDelegate = r3;
            this.uri = r4;
            this.width = r5;
            this.height = r6;
            this.options = r7;
            this.dataClass = r8;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void loadData(Priority r3, DataFetcher.DataCallback<? super DataT> r4) {
            DataFetcher<DataT> r1 = buildDelegateFetcher();     // Catch: FileNotFoundException -> L12
            if (r1 != null) goto L7;
            r4.onLoadFailed(new IllegalArgumentException("Failed to build fetcher for: " + this.uri));     // Catch: FileNotFoundException -> L12
            return;
        L7:
            this.delegate = r1;     // Catch: FileNotFoundException -> L12
            if (this.isCancelled == false) goto L10;
            cancel();     // Catch: FileNotFoundException -> L12
            return;
        L10:
            r1.loadData(r3, r4);     // Catch: FileNotFoundException -> L12
            return;
        L12:
            e = move-exception;
            r4.onLoadFailed(e);
        }

        private DataFetcher<DataT> buildDelegateFetcher() throws FileNotFoundException {
            ModelLoader.LoadData<DataT> r0 = buildDelegateData();
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.fetcher;
        }

        private ModelLoader.LoadData<DataT> buildDelegateData() throws FileNotFoundException {
            if (Environment.isExternalStorageLegacy() == false) goto L7;
            return this.fileDelegate.buildLoadData(queryForFilePath(this.uri), this.width, this.height, this.options);
        L7:
            if (MediaStoreUtil.isAndroidPickerUri(this.uri) == false) goto L11;
            return this.uriDelegate.buildLoadData(this.uri, this.width, this.height, this.options);
        L11:
            if (isAccessMediaLocationGranted() == false) goto L13;
            Uri r0 = MediaStore.setRequireOriginal(this.uri);
        L15:
            return this.uriDelegate.buildLoadData(r0, this.width, this.height, this.options);
        L13:
            r0 = this.uri;
            goto L15
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
            DataFetcher<DataT> r0 = this.delegate;
            if (r0 == null) goto L6;
            r0.cleanup();
            return;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
            this.isCancelled = true;
            DataFetcher<DataT> r1 = this.delegate;
            if (r1 == null) goto L6;
            r1.cancel();
            return;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public Class<DataT> getDataClass() {
            return this.dataClass;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }

        private File queryForFilePath(Uri r10) throws FileNotFoundException {
            Cursor r2 = null;
            Cursor r3 = this.context.getContentResolver().query(r10, PROJECTION, null, null, null);     // Catch: Throwable -> L17
            if (r3 == null) goto L16;
            if (r3.moveToFirst() == false) goto L16;
            String r9 = r3.getString(r3.getColumnIndexOrThrow("_data"));     // Catch: Throwable -> L17
            if (TextUtils.isEmpty(r9) == true) goto L14;
            File r11 = new File(r9);     // Catch: Throwable -> L17
            if (r3 == null) goto L12;
            r3.close();
        L12:
            return r11;
        L14:
            throw new FileNotFoundException("File path was empty in media store for: " + r10);     // Catch: Throwable -> L17
        L16:
            throw new FileNotFoundException("Failed to media store entry for: " + r10);     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            if (0 == 0) goto L20;
            r2.close();
        L20:
            throw th;
        }

        private boolean isAccessMediaLocationGranted() {
            if (this.context.checkSelfPermission(NativePermissionManager.NATIVE_PERMISSION_ACCESS_MEDIA_LOCATION) != 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public /* bridge */ /* synthetic */ ModelLoader.LoadData buildLoadData(Uri r1, int r2, int r3, Options r4) {
        return buildLoadData2(r1, r2, r3, r4);
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public /* bridge */ /* synthetic */ boolean handles(Uri r1) {
        return handles2(r1);
    }

    QMediaStoreUriLoader(Context r1, ModelLoader<File, DataT> r2, ModelLoader<Uri, DataT> r3, Class<DataT> r4) {
        this.context = r1.getApplicationContext();
        this.fileDelegate = r2;
        this.uriDelegate = r3;
        this.dataClass = r4;
    }

    /* JADX INFO: renamed from: buildLoadData, reason: avoid collision after fix types in other method */
    public ModelLoader.LoadData<DataT> buildLoadData2(Uri r14, int r15, int r16, Options r17) {
        return new ModelLoader.LoadData(new ObjectKey(r14), new QMediaStoreUriFetcher(this.context, this.fileDelegate, this.uriDelegate, r14, r15, r16, r17, this.dataClass));
    }

    /* JADX INFO: renamed from: handles, reason: avoid collision after fix types in other method */
    public boolean handles2(Uri r1) {
        if (MediaStoreUtil.isMediaStoreUri(r1) == false) goto L5;
        return true;
    L5:
        return false;
    }
}
