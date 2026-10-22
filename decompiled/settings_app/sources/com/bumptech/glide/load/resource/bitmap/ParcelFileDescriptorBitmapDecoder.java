package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class ParcelFileDescriptorBitmapDecoder implements ResourceDecoder<ParcelFileDescriptor, Bitmap> {
    private static final int MAXIMUM_FILE_BYTE_SIZE_FOR_FILE_DESCRIPTOR_DECODER = 536870912;
    private final Downsampler downsampler;

    @Override // com.bumptech.glide.load.ResourceDecoder
    public /* bridge */ /* synthetic */ Resource<Bitmap> decode(ParcelFileDescriptor r1, int r2, int r3, Options r4) throws IOException {
        return decode2(r1, r2, r3, r4);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public /* bridge */ /* synthetic */ boolean handles(ParcelFileDescriptor r1, Options r2) throws IOException {
        return handles2(r1, r2);
    }

    public ParcelFileDescriptorBitmapDecoder(Downsampler r1) {
        this.downsampler = r1;
    }

    /* JADX INFO: renamed from: handles, reason: avoid collision after fix types in other method */
    public boolean handles2(ParcelFileDescriptor r1, Options r2) {
        if (isSafeToTryDecoding(r1) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.downsampler.handles(r1) == false) goto L7;
        return true;
    }

    private boolean isSafeToTryDecoding(ParcelFileDescriptor r4) {
        if ("HUAWEI".equalsIgnoreCase(Build.MANUFACTURER) == true) goto L9;
        if ("HONOR".equalsIgnoreCase(Build.MANUFACTURER) == true) goto L9;
        return true;
    L9:
        if (r4.getStatSize() <= 536870912) goto L13;
        return false;
    L13:
        return true;
    }

    /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
    public Resource<Bitmap> decode2(ParcelFileDescriptor r1, int r2, int r3, Options r4) throws IOException {
        return this.downsampler.decode(r1, r2, r3, r4);
    }
}
