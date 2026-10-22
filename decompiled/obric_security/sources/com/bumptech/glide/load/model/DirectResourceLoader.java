package com.bumptech.glide.load.model;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.resource.drawable.DrawableDecoderCompat;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;
import com.bumptech.glide.signature.ObjectKey;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class DirectResourceLoader<DataT> implements ModelLoader<Integer, DataT> {
    private final Context context;
    private final ResourceOpener<DataT> resourceOpener;

    private static final class AssetFileDescriptorFactory implements ModelLoaderFactory<Integer, AssetFileDescriptor>, ResourceOpener<AssetFileDescriptor> {
        private final Context context;

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        @Override // com.bumptech.glide.load.model.DirectResourceLoader.ResourceOpener
        public /* bridge */ /* synthetic */ void close(AssetFileDescriptor r1) throws IOException {
            close2(r1);
        }

        @Override // com.bumptech.glide.load.model.DirectResourceLoader.ResourceOpener
        public /* bridge */ /* synthetic */ AssetFileDescriptor open(Resources.Theme r1, Resources r2, int r3) {
            return open(r1, r2, r3);
        }

        AssetFileDescriptorFactory(Context r1) {
            this.context = r1;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bumptech.glide.load.model.DirectResourceLoader.ResourceOpener
        public AssetFileDescriptor open(Resources.Theme r1, Resources r2, int r3) {
            return r2.openRawResourceFd(r3);
        }

        /* JADX INFO: renamed from: close, reason: avoid collision after fix types in other method */
        public void close2(AssetFileDescriptor r1) throws IOException {
            r1.close();
        }

        @Override // com.bumptech.glide.load.model.DirectResourceLoader.ResourceOpener
        public Class<AssetFileDescriptor> getDataClass() {
            return AssetFileDescriptor.class;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<Integer, AssetFileDescriptor> build(MultiModelLoaderFactory r2) {
            return new DirectResourceLoader(this.context, this);
        }
    }

    private static final class DrawableFactory implements ModelLoaderFactory<Integer, Drawable>, ResourceOpener<Drawable> {
        private final Context context;

        /* JADX INFO: renamed from: close, reason: avoid collision after fix types in other method */
        public void close2(Drawable r1) throws IOException {
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        @Override // com.bumptech.glide.load.model.DirectResourceLoader.ResourceOpener
        public /* bridge */ /* synthetic */ void close(Drawable r1) throws IOException {
            close2(r1);
        }

        @Override // com.bumptech.glide.load.model.DirectResourceLoader.ResourceOpener
        public /* bridge */ /* synthetic */ Drawable open(Resources.Theme r1, Resources r2, int r3) {
            return open(r1, r2, r3);
        }

        DrawableFactory(Context r1) {
            this.context = r1;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bumptech.glide.load.model.DirectResourceLoader.ResourceOpener
        public Drawable open(Resources.Theme r1, Resources r2, int r3) {
            return DrawableDecoderCompat.getDrawable(this.context, r3, r1);
        }

        @Override // com.bumptech.glide.load.model.DirectResourceLoader.ResourceOpener
        public Class<Drawable> getDataClass() {
            return Drawable.class;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<Integer, Drawable> build(MultiModelLoaderFactory r2) {
            return new DirectResourceLoader(this.context, this);
        }
    }

    private static final class InputStreamFactory implements ModelLoaderFactory<Integer, InputStream>, ResourceOpener<InputStream> {
        private final Context context;

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        @Override // com.bumptech.glide.load.model.DirectResourceLoader.ResourceOpener
        public /* bridge */ /* synthetic */ void close(InputStream r1) throws IOException {
            close2(r1);
        }

        @Override // com.bumptech.glide.load.model.DirectResourceLoader.ResourceOpener
        public /* bridge */ /* synthetic */ InputStream open(Resources.Theme r1, Resources r2, int r3) {
            return open(r1, r2, r3);
        }

        InputStreamFactory(Context r1) {
            this.context = r1;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<Integer, InputStream> build(MultiModelLoaderFactory r2) {
            return new DirectResourceLoader(this.context, this);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bumptech.glide.load.model.DirectResourceLoader.ResourceOpener
        public InputStream open(Resources.Theme r1, Resources r2, int r3) {
            return r2.openRawResource(r3);
        }

        /* JADX INFO: renamed from: close, reason: avoid collision after fix types in other method */
        public void close2(InputStream r1) throws IOException {
            r1.close();
        }

        @Override // com.bumptech.glide.load.model.DirectResourceLoader.ResourceOpener
        public Class<InputStream> getDataClass() {
            return InputStream.class;
        }
    }

    private static final class ResourceDataFetcher<DataT> implements DataFetcher<DataT> {
        private DataT data;
        private final int resourceId;
        private final ResourceOpener<DataT> resourceOpener;
        private final Resources resources;
        private final Resources.Theme theme;

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
        }

        ResourceDataFetcher(Resources.Theme r1, Resources r2, ResourceOpener<DataT> r3, int r4) {
            this.theme = r1;
            this.resources = r2;
            this.resourceOpener = r3;
            this.resourceId = r4;
        }

        /* JADX WARN: Type inference failed for: r4v2, types: [DataT, java.lang.Object] */
        @Override // com.bumptech.glide.load.data.DataFetcher
        public void loadData(Priority r4, DataFetcher.DataCallback<? super DataT> r5) {
            DataT r6 = this.resourceOpener.open(this.theme, this.resources, this.resourceId);     // Catch: Resources.NotFoundException -> L4
            this.data = r6;     // Catch: Resources.NotFoundException -> L4
            r5.onDataReady(r6);     // Catch: Resources.NotFoundException -> L4
            return;
        L4:
            e = move-exception;
            r5.onLoadFailed(e);
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
            DataT r0 = this.data;
            if (r0 == null) goto L9;
            this.resourceOpener.close(r0);     // Catch: IOException -> L6
            return;
        L10:
            return;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public Class<DataT> getDataClass() {
            return this.resourceOpener.getDataClass();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }
    }

    private interface ResourceOpener<DataT> {
        void close(DataT r1) throws IOException;

        Class<DataT> getDataClass();

        DataT open(Resources.Theme r1, Resources r2, int r3);
    }

    /* JADX INFO: renamed from: handles, reason: avoid collision after fix types in other method */
    public boolean handles2(Integer r1) {
        return true;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public /* bridge */ /* synthetic */ ModelLoader.LoadData buildLoadData(Integer r1, int r2, int r3, Options r4) {
        return buildLoadData2(r1, r2, r3, r4);
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public /* bridge */ /* synthetic */ boolean handles(Integer r1) {
        return handles2(r1);
    }

    public static ModelLoaderFactory<Integer, InputStream> inputStreamFactory(Context r1) {
        return new InputStreamFactory(r1);
    }

    public static ModelLoaderFactory<Integer, AssetFileDescriptor> assetFileDescriptorFactory(Context r1) {
        return new AssetFileDescriptorFactory(r1);
    }

    public static ModelLoaderFactory<Integer, Drawable> drawableFactory(Context r1) {
        return new DrawableFactory(r1);
    }

    DirectResourceLoader(Context r1, ResourceOpener<DataT> r2) {
        this.context = r1.getApplicationContext();
        this.resourceOpener = r2;
    }

    /* JADX INFO: renamed from: buildLoadData, reason: avoid collision after fix types in other method */
    public ModelLoader.LoadData<DataT> buildLoadData2(Integer r3, int r4, int r5, Options r6) {
        Resources.Theme r7 = (Resources.Theme) r6.get(ResourceDrawableDecoder.THEME);
        if (r7 == null) goto L5;
        Resources r8 = r7.getResources();
    L7:
        return new ModelLoader.LoadData(new ObjectKey(r3), new ResourceDataFetcher(r7, r8, this.resourceOpener, r3.intValue()));
    L5:
        r8 = this.context.getResources();
        goto L7
    }
}
