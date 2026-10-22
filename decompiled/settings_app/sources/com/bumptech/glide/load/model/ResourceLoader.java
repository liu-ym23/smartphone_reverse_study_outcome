package com.bumptech.glide.load.model;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.load.Options;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes3.dex */
public class ResourceLoader<Data> implements ModelLoader<Integer, Data> {
    private static final String TAG = "ResourceLoader";
    private final Resources resources;
    private final ModelLoader<Uri, Data> uriLoader;

    public static final class AssetFileDescriptorFactory implements ModelLoaderFactory<Integer, AssetFileDescriptor> {
        private final Resources resources;

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        public AssetFileDescriptorFactory(Resources r1) {
            this.resources = r1;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<Integer, AssetFileDescriptor> build(MultiModelLoaderFactory r4) {
            return new ResourceLoader(this.resources, r4.build(Uri.class, AssetFileDescriptor.class));
        }
    }

    @Deprecated
    public static class FileDescriptorFactory implements ModelLoaderFactory<Integer, ParcelFileDescriptor> {
        private final Resources resources;

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        public FileDescriptorFactory(Resources r1) {
            this.resources = r1;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<Integer, ParcelFileDescriptor> build(MultiModelLoaderFactory r4) {
            return new ResourceLoader(this.resources, r4.build(Uri.class, ParcelFileDescriptor.class));
        }
    }

    public static class StreamFactory implements ModelLoaderFactory<Integer, InputStream> {
        private final Resources resources;

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        public StreamFactory(Resources r1) {
            this.resources = r1;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<Integer, InputStream> build(MultiModelLoaderFactory r4) {
            return new ResourceLoader(this.resources, r4.build(Uri.class, InputStream.class));
        }
    }

    public static class UriFactory implements ModelLoaderFactory<Integer, Uri> {
        private final Resources resources;

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        public UriFactory(Resources r1) {
            this.resources = r1;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<Integer, Uri> build(MultiModelLoaderFactory r2) {
            return new ResourceLoader(this.resources, UnitModelLoader.getInstance());
        }
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

    public ResourceLoader(Resources r1, ModelLoader<Uri, Data> r2) {
        this.resources = r1;
        this.uriLoader = r2;
    }

    /* JADX INFO: renamed from: buildLoadData, reason: avoid collision after fix types in other method */
    public ModelLoader.LoadData<Data> buildLoadData2(Integer r1, int r2, int r3, Options r4) {
        Uri r5 = getResourceUri(r1);
        if (r5 != null) goto L6;
        return null;
    L6:
        return this.uriLoader.buildLoadData(r5, r2, r3, r4);
    }

    private Uri getResourceUri(Integer r5) {
        return Uri.parse("android.resource://" + this.resources.getResourcePackageName(r5.intValue()) + IOUtils.DIR_SEPARATOR_UNIX + this.resources.getResourceTypeName(r5.intValue()) + IOUtils.DIR_SEPARATOR_UNIX + this.resources.getResourceEntryName(r5.intValue()));
    L5:
        e = move-exception;
        if (Log.isLoggable(TAG, 5) == false) goto L13;
        Log.w(TAG, "Received invalid resource id: " + r5, e);
        return null;
    L13:
        return null;
    }
}
