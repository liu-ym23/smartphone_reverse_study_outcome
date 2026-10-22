package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class BitmapDrawableDecoder<DataType> implements ResourceDecoder<DataType, BitmapDrawable> {
    private final ResourceDecoder<DataType, Bitmap> decoder;
    private final Resources resources;

    public BitmapDrawableDecoder(Context r1, ResourceDecoder<DataType, Bitmap> r2) {
        this(r1.getResources(), r2);
    }

    @Deprecated
    public BitmapDrawableDecoder(Resources r1, BitmapPool r2, ResourceDecoder<DataType, Bitmap> r3) {
        this(r1, r3);
    }

    public BitmapDrawableDecoder(Resources r1, ResourceDecoder<DataType, Bitmap> r2) {
        this.resources = (Resources) Preconditions.checkNotNull(r1);
        this.decoder = (ResourceDecoder) Preconditions.checkNotNull(r2);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(DataType r1, Options r2) throws IOException {
        return this.decoder.handles(r1, r2);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource<BitmapDrawable> decode(DataType r2, int r3, int r4, Options r5) throws IOException {
        Resource<Bitmap> r6 = this.decoder.decode(r2, r3, r4, r5);
        return LazyBitmapDrawableResource.obtain(this.resources, r6);
    }
}
