package com.bumptech.glide.load.model;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.signature.ObjectKey;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class DataUrlLoader<Model, Data> implements ModelLoader<Model, Data> {
    private static final String BASE64_TAG = ";base64";
    private static final String DATA_SCHEME_IMAGE = "data:image";
    private final DataDecoder<Data> dataDecoder;

    public interface DataDecoder<Data> {
        void close(Data r1) throws IOException;

        Data decode(String r1) throws IllegalArgumentException;

        Class<Data> getDataClass();
    }

    private static final class DataUriFetcher<Data> implements DataFetcher<Data> {
        private Data data;
        private final String dataUri;
        private final DataDecoder<Data> reader;

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
        }

        DataUriFetcher(String r1, DataDecoder<Data> r2) {
            this.dataUri = r1;
            this.reader = r2;
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [Data, java.lang.Object] */
        @Override // com.bumptech.glide.load.data.DataFetcher
        public void loadData(Priority r2, DataFetcher.DataCallback<? super Data> r3) {
            Data r4 = this.reader.decode(this.dataUri);     // Catch: IllegalArgumentException -> L4
            this.data = r4;     // Catch: IllegalArgumentException -> L4
            r3.onDataReady(r4);     // Catch: IllegalArgumentException -> L4
            return;
        L4:
            e = move-exception;
            r3.onLoadFailed(e);
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
            this.reader.close(this.data);     // Catch: IOException -> L4
            return;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public Class<Data> getDataClass() {
            return this.reader.getDataClass();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }
    }

    public static final class StreamFactory<Model> implements ModelLoaderFactory<Model, InputStream> {
        private final DataDecoder<InputStream> opener;

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        public StreamFactory() {
            this.opener = new AnonymousClass1(this);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<Model, InputStream> build(MultiModelLoaderFactory r1) {
            return new DataUrlLoader(this.opener);
        }
    }

    public DataUrlLoader(DataDecoder<Data> r1) {
        this.dataDecoder = r1;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<Data> buildLoadData(Model r1, int r2, int r3, Options r4) {
        return new ModelLoader.LoadData(new ObjectKey(r1), new DataUriFetcher(r1.toString(), this.dataDecoder));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(Model r1) {
        return r1.toString().startsWith(DATA_SCHEME_IMAGE);
    }
}
