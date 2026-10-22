package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public class CenterCrop extends BitmapTransformation {
    private static final String ID = "com.bumptech.glide.load.resource.bitmap.CenterCrop";
    private static final byte[] ID_BYTES = null;

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return -599754482;
    }

    public CenterCrop() {
    }

    static {
        ID_BYTES = ID.getBytes(CHARSET);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    protected Bitmap transform(BitmapPool r1, Bitmap r2, int r3, int r4) {
        return TransformationUtils.centerCrop(r1, r2, r3, r4);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r1) {
        return r1 instanceof CenterCrop;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r1) {
        r1.update(ID_BYTES);
    }
}
