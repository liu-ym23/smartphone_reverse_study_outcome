package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;

/* JADX INFO: loaded from: classes.dex */
public abstract class BitmapTransformation implements Transformation<Bitmap> {
    protected abstract Bitmap transform(BitmapPool r1, Bitmap r2, int r3, int r4);

    public BitmapTransformation() {
    }

    @Override // com.bumptech.glide.load.Transformation
    public final Resource<Bitmap> transform(Context r3, Resource<Bitmap> r4, int r5, int r6) {
        if (Util.isValidDimensions(r5, r6) == false) goto L15;
        BitmapPool r7 = Glide.get(r3).getBitmapPool();
        Bitmap r0 = r4.get();
        if (r5 != Integer.MIN_VALUE) goto L7;
        r5 = r0.getWidth();
    L7:
        if (r6 != Integer.MIN_VALUE) goto L9;
        r6 = r0.getHeight();
    L9:
        Bitmap r2 = transform(r7, r0, r5, r6);
        if (r0.equals(r2) == false) goto L13;
        return r4;
    L13:
        return BitmapResource.obtain(r2, r7);
    L15:
        throw new IllegalArgumentException("Cannot apply transformation on width: " + r5 + " or height: " + r6 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }
}
