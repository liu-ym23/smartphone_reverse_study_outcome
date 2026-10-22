package com.bumptech.glide.load.model;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.load.Options;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class ResourceUriLoader<DataT> implements ModelLoader<Uri, DataT> {
    private static final int INVALID_RESOURCE_ID = 0;
    private static final String TAG = "ResourceUriLoader";
    private final Context context;
    private final ModelLoader<Integer, DataT> delegate;

    private static final class AssetFileDescriptorFactory implements ModelLoaderFactory<Uri, AssetFileDescriptor> {
        private final Context context;

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        AssetFileDescriptorFactory(Context r1) {
            this.context = r1;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<Uri, AssetFileDescriptor> build(MultiModelLoaderFactory r4) {
            return new ResourceUriLoader(this.context, r4.build(Integer.class, AssetFileDescriptor.class));
        }
    }

    private static final class InputStreamFactory implements ModelLoaderFactory<Uri, InputStream> {
        private final Context context;

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        InputStreamFactory(Context r1) {
            this.context = r1;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<Uri, InputStream> build(MultiModelLoaderFactory r4) {
            return new ResourceUriLoader(this.context, r4.build(Integer.class, InputStream.class));
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

    public static ModelLoaderFactory<Uri, InputStream> newStreamFactory(Context r1) {
        return new InputStreamFactory(r1);
    }

    public static ModelLoaderFactory<Uri, AssetFileDescriptor> newAssetFileDescriptorFactory(Context r1) {
        return new AssetFileDescriptorFactory(r1);
    }

    ResourceUriLoader(Context r1, ModelLoader<Integer, DataT> r2) {
        this.context = r1.getApplicationContext();
        this.delegate = r2;
    }

    /* JADX INFO: renamed from: buildLoadData, reason: avoid collision after fix types in other method */
    public ModelLoader.LoadData<DataT> buildLoadData2(Uri r4, int r5, int r6, Options r7) {
        List<String> r0 = r4.getPathSegments();
        if (r0.size() != 1) goto L7;
        return parseResourceIdUri(r4, r5, r6, r7);
    L7:
        if (r0.size() != 2) goto L11;
        return parseResourceNameUri(r4, r5, r6, r7);
    L11:
        if (Log.isLoggable(TAG, 5) == false) goto L15;
        Log.w(TAG, "Failed to parse resource uri: " + r4);
        return null;
    L15:
        return null;
    }

    private ModelLoader.LoadData<DataT> parseResourceNameUri(Uri r5, int r6, int r7, Options r8) {
        List<String> r0 = r5.getPathSegments();
        String r1 = r0.get(0);
        int r2 = this.context.getResources().getIdentifier(r0.get(1), r1, this.context.getPackageName());
        if (r2 != 0) goto L10;
        if (Log.isLoggable(TAG, 5) == false) goto L11;
        Log.w(TAG, "Failed to find resource id for: " + r5);
        return null;
    L11:
        return null;
    L10:
        return this.delegate.buildLoadData(Integer.valueOf(r2), r6, r7, r8);
    }

    private ModelLoader.LoadData<DataT> parseResourceIdUri(Uri r7, int r8, int r9, Options r10) {
        int r4 = Integer.parseInt(r7.getPathSegments().get(0));     // Catch: NumberFormatException -> L11
        if (r4 != 0) goto L10;
        if (Log.isLoggable(TAG, 5) == false) goto L8;
        Log.w(TAG, "Failed to parse a valid non-0 resource id from: " + r7);     // Catch: NumberFormatException -> L11
    L8:
        return null;
    L10:
        return this.delegate.buildLoadData(Integer.valueOf(r4), r8, r9, r10);
    L11:
        e = move-exception;
        if (Log.isLoggable(TAG, 5) == false) goto L15;
        Log.w(TAG, "Failed to parse resource id from: " + r7, e);
    L15:
        return null;
    }

    /* JADX INFO: renamed from: handles, reason: avoid collision after fix types in other method */
    public boolean handles2(Uri r3) {
        if ("android.resource".equals(r3.getScheme()) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.context.getPackageName().equals(r3.getAuthority()) == false) goto L7;
        return true;
    }
}
