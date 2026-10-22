package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class FileDescriptorLocalUriFetcher extends LocalUriFetcher<ParcelFileDescriptor> {
    @Override // com.bumptech.glide.load.data.LocalUriFetcher
    protected /* bridge */ /* synthetic */ void close(ParcelFileDescriptor r1) throws IOException {
        close2(r1);
    }

    @Override // com.bumptech.glide.load.data.LocalUriFetcher
    protected /* bridge */ /* synthetic */ ParcelFileDescriptor loadResource(Uri r1, ContentResolver r2) throws FileNotFoundException {
        return loadResource(r1, r2);
    }

    public FileDescriptorLocalUriFetcher(ContentResolver r1, Uri r2) {
        super(r1, r2);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.data.LocalUriFetcher
    protected ParcelFileDescriptor loadResource(Uri r2, ContentResolver r3) throws FileNotFoundException {
        AssetFileDescriptor r1 = r3.openAssetFileDescriptor(r2, "r");
        if (r1 == null) goto L7;
        return r1.getParcelFileDescriptor();
    L7:
        throw new FileNotFoundException("FileDescriptor is null for: " + r2);
    }

    /* JADX INFO: renamed from: close, reason: avoid collision after fix types in other method */
    protected void close2(ParcelFileDescriptor r1) throws IOException {
        r1.close();
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public Class<ParcelFileDescriptor> getDataClass() {
        return ParcelFileDescriptor.class;
    }
}
