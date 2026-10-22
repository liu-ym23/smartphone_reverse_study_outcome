package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes3.dex */
public final class GranularRoundedCorners extends BitmapTransformation {
    private static final String ID = "com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners";
    private static final byte[] ID_BYTES = null;
    private final float bottomLeft;
    private final float bottomRight;
    private final float topLeft;
    private final float topRight;

    static {
        ID_BYTES = ID.getBytes(CHARSET);
    }

    public GranularRoundedCorners(float r1, float r2, float r3, float r4) {
        this.topLeft = r1;
        this.topRight = r2;
        this.bottomRight = r3;
        this.bottomLeft = r4;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    protected Bitmap transform(BitmapPool r7, Bitmap r8, int r9, int r10) {
        return TransformationUtils.roundedCorners(r7, r8, this.topLeft, this.topRight, this.bottomRight, this.bottomLeft);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r4) {
        if ((r4 instanceof GranularRoundedCorners) == false) goto L14;
        GranularRoundedCorners r5 = (GranularRoundedCorners) r4;
        if (this.topLeft == r5.topLeft) goto L7;
        return false;
    L7:
        if (this.topRight == r5.topRight) goto L9;
        return false;
    L9:
        if (this.bottomRight == r5.bottomRight) goto L11;
        return false;
    L11:
        if (this.bottomLeft != r5.bottomLeft) goto L18;
        return true;
    L18:
        return false;
    L14:
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        int r0 = Util.hashCode(-2013597734, Util.hashCode(this.topLeft));
        int r1 = Util.hashCode(this.topRight, r0);
        int r2 = Util.hashCode(this.bottomRight, r1);
        return Util.hashCode(this.bottomLeft, r2);
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r3) {
        r3.update(ID_BYTES);
        r3.update(ByteBuffer.allocate(16).putFloat(this.topLeft).putFloat(this.topRight).putFloat(this.bottomRight).putFloat(this.bottomLeft).array());
    }
}
