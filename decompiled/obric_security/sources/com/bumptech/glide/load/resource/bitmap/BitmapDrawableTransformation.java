package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class BitmapDrawableTransformation implements Transformation<BitmapDrawable> {
    private final Transformation<Drawable> wrapped;

    private static Resource<Drawable> convertToDrawableResource(Resource<BitmapDrawable> r0) {
        return r0;
    }

    public BitmapDrawableTransformation(Transformation<Bitmap> r3) {
        this.wrapped = (Transformation) Preconditions.checkNotNull(new DrawableTransformation(r3, false));
    }

    @Override // com.bumptech.glide.load.Transformation
    public Resource<BitmapDrawable> transform(Context r1, Resource<BitmapDrawable> r2, int r3, int r4) {
        Resource<Drawable> r5 = convertToDrawableResource(r2);
        return convertToBitmapDrawableResource(this.wrapped.transform(r1, r5, r3, r4));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Resource<BitmapDrawable> convertToBitmapDrawableResource(Resource<Drawable> r3) {
        if ((r3.get() instanceof BitmapDrawable) == false) goto L6;
        return r3;
    L6:
        throw new IllegalArgumentException("Wrapped transformation unexpectedly returned a non BitmapDrawable resource: " + r3.get());
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r2) {
        if ((r2 instanceof BitmapDrawableTransformation) == true) goto L5;
        return false;
    L5:
        return this.wrapped.equals(((BitmapDrawableTransformation) r2).wrapped);
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
