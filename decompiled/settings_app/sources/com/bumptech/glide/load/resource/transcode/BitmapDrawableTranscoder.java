package com.bumptech.glide.load.resource.transcode;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.LazyBitmapDrawableResource;
import com.bumptech.glide.util.Preconditions;

/* JADX INFO: loaded from: classes3.dex */
public class BitmapDrawableTranscoder implements ResourceTranscoder<Bitmap, BitmapDrawable> {
    private final Resources resources;

    public BitmapDrawableTranscoder(Context r1) {
        this(r1.getResources());
    }

    @Deprecated
    public BitmapDrawableTranscoder(Resources r1, BitmapPool r2) {
        this(r1);
    }

    public BitmapDrawableTranscoder(Resources r1) {
        this.resources = (Resources) Preconditions.checkNotNull(r1);
    }

    @Override // com.bumptech.glide.load.resource.transcode.ResourceTranscoder
    public Resource<BitmapDrawable> transcode(Resource<Bitmap> r1, Options r2) {
        return LazyBitmapDrawableResource.obtain(this.resources, r1);
    }
}
