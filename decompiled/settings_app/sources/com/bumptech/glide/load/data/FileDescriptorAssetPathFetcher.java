package com.bumptech.glide.load.data;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class FileDescriptorAssetPathFetcher extends AssetPathFetcher<AssetFileDescriptor> {
    @Override // com.bumptech.glide.load.data.AssetPathFetcher
    protected /* bridge */ /* synthetic */ void close(AssetFileDescriptor r1) throws IOException {
        close2(r1);
    }

    @Override // com.bumptech.glide.load.data.AssetPathFetcher
    protected /* bridge */ /* synthetic */ AssetFileDescriptor loadResource(AssetManager r1, String r2) throws IOException {
        return loadResource(r1, r2);
    }

    public FileDescriptorAssetPathFetcher(AssetManager r1, String r2) {
        super(r1, r2);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.data.AssetPathFetcher
    protected AssetFileDescriptor loadResource(AssetManager r1, String r2) throws IOException {
        return r1.openFd(r2);
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
