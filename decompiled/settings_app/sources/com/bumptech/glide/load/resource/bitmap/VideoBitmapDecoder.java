package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class VideoBitmapDecoder extends VideoDecoder<ParcelFileDescriptor> {
    public VideoBitmapDecoder(Context r1) {
        this(Glide.get(r1).getBitmapPool());
    }

    public VideoBitmapDecoder(BitmapPool r2) {
        super(r2, new VideoDecoder.ParcelFileDescriptorInitializer());
    }
}
