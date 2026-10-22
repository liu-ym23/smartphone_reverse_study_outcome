package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes3.dex */
public class Rotate extends BitmapTransformation {
    private static final String ID = "com.bumptech.glide.load.resource.bitmap.Rotate";
    private static final byte[] ID_BYTES = null;
    private final int degreesToRotate;

    static {
        ID_BYTES = ID.getBytes(CHARSET);
    }

    public Rotate(int r1) {
        this.degreesToRotate = r1;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    protected Bitmap transform(BitmapPool r1, Bitmap r2, int r3, int r4) {
        return TransformationUtils.rotateImage(r2, this.degreesToRotate);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r3) {
        if ((r3 instanceof Rotate) == true) goto L5;
        return false;
    L5:
        if (this.degreesToRotate != ((Rotate) r3).degreesToRotate) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return Util.hashCode(-950519196, Util.hashCode(this.degreesToRotate));
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r2) {
        r2.update(ID_BYTES);
        r2.update(ByteBuffer.allocate(4).putInt(this.degreesToRotate).array());
    }
}
