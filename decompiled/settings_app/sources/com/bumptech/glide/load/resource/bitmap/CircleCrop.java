package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes3.dex */
public class CircleCrop extends BitmapTransformation {
    private static final String ID = "com.bumptech.glide.load.resource.bitmap.CircleCrop.1";
    private static final byte[] ID_BYTES = null;
    private static final int VERSION = 1;

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return 1101716364;
    }

    public CircleCrop() {
    }

    static {
        ID_BYTES = ID.getBytes(CHARSET);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    protected Bitmap transform(BitmapPool r1, Bitmap r2, int r3, int r4) {
        return TransformationUtils.circleCrop(r1, r2, r3, r4);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r1) {
        return r1 instanceof CircleCrop;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r1) {
        r1.update(ID_BYTES);
    }
}
