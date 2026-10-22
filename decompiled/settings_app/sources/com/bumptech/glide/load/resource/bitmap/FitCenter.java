package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes3.dex */
public class FitCenter extends BitmapTransformation {
    private static final String ID = "com.bumptech.glide.load.resource.bitmap.FitCenter";
    private static final byte[] ID_BYTES = null;

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return 1572326941;
    }

    public FitCenter() {
    }

    static {
        ID_BYTES = ID.getBytes(CHARSET);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    protected Bitmap transform(BitmapPool r1, Bitmap r2, int r3, int r4) {
        return TransformationUtils.fitCenter(r1, r2, r3, r4);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r1) {
        return r1 instanceof FitCenter;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r1) {
        r1.update(ID_BYTES);
    }
}
