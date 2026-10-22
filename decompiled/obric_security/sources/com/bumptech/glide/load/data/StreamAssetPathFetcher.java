package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class StreamAssetPathFetcher extends AssetPathFetcher<InputStream> {
    @Override // com.bumptech.glide.load.data.AssetPathFetcher
    protected /* bridge */ /* synthetic */ void close(InputStream r1) throws IOException {
        close2(r1);
    }

    @Override // com.bumptech.glide.load.data.AssetPathFetcher
    protected /* bridge */ /* synthetic */ InputStream loadResource(AssetManager r1, String r2) throws IOException {
        return loadResource(r1, r2);
    }

    public StreamAssetPathFetcher(AssetManager r1, String r2) {
        super(r1, r2);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.data.AssetPathFetcher
    protected InputStream loadResource(AssetManager r1, String r2) throws IOException {
        return r1.open(r2);
    }

    /* JADX INFO: renamed from: close, reason: avoid collision after fix types in other method */
    protected void close2(InputStream r1) throws IOException {
        r1.close();
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }
}
