package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public class CenterInside extends BitmapTransformation {
    private static final String ID = "com.bumptech.glide.load.resource.bitmap.CenterInside";
    private static final byte[] ID_BYTES = null;

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return -670243078;
    }

    public CenterInside() {
    }

    static {
        ID_BYTES = ID.getBytes(CHARSET);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    protected Bitmap transform(BitmapPool r1, Bitmap r2, int r3, int r4) {
        return TransformationUtils.centerInside(r1, r2, r3, r4);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r1) {
        return r1 instanceof CenterInside;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r1) {
        r1.update(ID_BYTES);
    }
}
