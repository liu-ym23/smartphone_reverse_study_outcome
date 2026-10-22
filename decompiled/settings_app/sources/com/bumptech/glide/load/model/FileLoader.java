package com.bumptech.glide.load.model;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.signature.ObjectKey;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class FileLoader<Data> implements ModelLoader<File, Data> {
    private static final String TAG = "FileLoader";
    private final FileOpener<Data> fileOpener;

    public static class Factory<Data> implements ModelLoaderFactory<File, Data> {
        private final FileOpener<Data> opener;

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final void teardown() {
        }

        public Factory(FileOpener<Data> r1) {
            this.opener = r1;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final ModelLoader<File, Data> build(MultiModelLoaderFactory r1) {
            return new FileLoader(this.opener);
        }
    }

    public static class FileDescriptorFactory extends Factory<ParcelFileDescriptor> {
        public FileDescriptorFactory() {
            super(new AnonymousClass1());
        }
    }

    private static final class FileFetcher<Data> implements DataFetcher<Data> {
        private Data data;
        private final File file;
        private final FileOpener<Data> opener;

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
        }

        FileFetcher(File r1, FileOpener<Data> r2) {
            this.file = r1;
            this.opener = r2;
        }

        /* JADX WARN: Type inference failed for: r2v5, types: [Data, java.lang.Object] */
        @Override // com.bumptech.glide.load.data.DataFetcher
        public void loadData(Priority r2, DataFetcher.DataCallback<? super Data> r3) {
            Data r4 = this.opener.open(this.file);     // Catch: FileNotFoundException -> L4
            this.data = r4;     // Catch: FileNotFoundException -> L4
            r3.onDataReady(r4);     // Catch: FileNotFoundException -> L4
            return;
        L4:
            e = move-exception;
            if (Log.isLoggable(FileLoader.TAG, 3) == false) goto L8;
            Log.d(FileLoader.TAG, "Failed to open file", e);
        L8:
            r3.onLoadFailed(e);
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
            Data r0 = this.data;
            if (r0 == null) goto L9;
            this.opener.close(r0);     // Catch: IOException -> L6
            return;
        L10:
            return;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public Class<Data> getDataClass() {
            return this.opener.getDataClass();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }
    }

    public interface FileOpener<Data> {
        void close(Data r1) throws IOException;

        Class<Data> getDataClass();

        Data open(File r1) throws FileNotFoundException;
    }

    public static class StreamFactory extends Factory<InputStream> {
        public StreamFactory() {
            super(new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: handles, reason: avoid collision after fix types in other method */
    public boolean handles2(File r1) {
        return true;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public /* bridge */ /* synthetic */ ModelLoader.LoadData buildLoadData(File r1, int r2, int r3, Options r4) {
        return buildLoadData2(r1, r2, r3, r4);
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public /* bridge */ /* synthetic */ boolean handles(File r1) {
        return handles2(r1);
    }

    public FileLoader(FileOpener<Data> r1) {
        this.fileOpener = r1;
    }

    /* JADX INFO: renamed from: buildLoadData, reason: avoid collision after fix types in other method */
    public ModelLoader.LoadData<Data> buildLoadData2(File r1, int r2, int r3, Options r4) {
        return new ModelLoader.LoadData(new ObjectKey(r1), new FileFetcher(r1, this.fileOpener));
    }
}
