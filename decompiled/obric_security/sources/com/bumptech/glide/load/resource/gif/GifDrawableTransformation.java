package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public class GifDrawableTransformation implements Transformation<GifDrawable> {
    private final Transformation<Bitmap> wrapped;

    public GifDrawableTransformation(Transformation<Bitmap> r1) {
        this.wrapped = (Transformation) Preconditions.checkNotNull(r1);
    }

    @Override // com.bumptech.glide.load.Transformation
    public Resource<GifDrawable> transform(Context r5, Resource<GifDrawable> r6, int r7, int r8) {
        GifDrawable r0 = r6.get();
        BitmapPool r1 = Glide.get(r5).getBitmapPool();
        Resource<Bitmap> r3 = new BitmapResource(r0.getFirstFrame(), r1);
        Resource<Bitmap> r9 = this.wrapped.transform(r5, r3, r7, r8);
        if (r3.equals(r9) == true) goto L5;
        r3.recycle();
    L5:
        Bitmap r10 = r9.get();
        r0.setFrameTransformation(this.wrapped, r10);
        return r6;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r2) {
        if ((r2 instanceof GifDrawableTransformation) == true) goto L5;
        return false;
    L5:
        return this.wrapped.equals(((GifDrawableTransformation) r2).wrapped);
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.wrapped.hashCode();
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r1) {
        this.wrapped.updateDiskCacheKey(r1);
    }
}
