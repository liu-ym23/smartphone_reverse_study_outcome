package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class AssetFileDescriptorLocalUriFetcher extends LocalUriFetcher<AssetFileDescriptor> {
    @Override // com.bumptech.glide.load.data.LocalUriFetcher
    protected /* bridge */ /* synthetic */ void close(AssetFileDescriptor r1) throws IOException {
        close2(r1);
    }

    @Override // com.bumptech.glide.load.data.LocalUriFetcher
    protected /* bridge */ /* synthetic */ AssetFileDescriptor loadResource(Uri r1, ContentResolver r2) throws FileNotFoundException {
        return loadResource(r1, r2);
    }

    public AssetFileDescriptorLocalUriFetcher(ContentResolver r1, Uri r2) {
        super(r1, r2);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.data.LocalUriFetcher
    protected AssetFileDescriptor loadResource(Uri r2, ContentResolver r3) throws FileNotFoundException {
        AssetFileDescriptor r1 = r3.openAssetFileDescriptor(r2, "r");
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new FileNotFoundException("FileDescriptor is null for: " + r2);
    }

    /* JADX INFO: renamed from: close, reason: avoid collision after fix types in other method */
    protected void close2(AssetFileDescriptor r1) throws IOException {
        r1.close();
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public Class<AssetFileDescriptor> getDataClass() {
        return AssetFileDescriptor.class;
    }
}
