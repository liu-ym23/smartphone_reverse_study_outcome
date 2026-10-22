package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public class DrawableTransformation implements Transformation<Drawable> {
    private final boolean isRequired;
    private final Transformation<Bitmap> wrapped;

    public Transformation<BitmapDrawable> asBitmapDrawable() {
        return this;
    }

    public DrawableTransformation(Transformation<Bitmap> r1, boolean r2) {
        this.wrapped = r1;
        this.isRequired = r2;
    }

    @Override // com.bumptech.glide.load.Transformation
    public Resource<Drawable> transform(Context r3, Resource<Drawable> r4, int r5, int r6) {
        BitmapPool r0 = Glide.get(r3).getBitmapPool();
        Drawable r1 = r4.get();
        Resource<Bitmap> r2 = DrawableToBitmapConverter.convert(r0, r1, r5, r6);
        if (r2 == null) goto L5;
        Resource<Bitmap> r7 = this.wrapped.transform(r3, r2, r5, r6);
        if (r7.equals(r2) == false) goto L14;
        r7.recycle();
        return r4;
    L14:
        return newDrawableResource(r3, r7);
    L5:
        if (this.isRequired == true) goto L8;
        return r4;
    L8:
        throw new IllegalArgumentException("Unable to convert " + r1 + " to a Bitmap");
    }

    private Resource<Drawable> newDrawableResource(Context r1, Resource<Bitmap> r2) {
        return LazyBitmapDrawableResource.obtain(r1.getResources(), r2);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r2) {
        if ((r2 instanceof DrawableTransformation) == true) goto L5;
        return false;
    L5:
        return this.wrapped.equals(((DrawableTransformation) r2).wrapped);
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
