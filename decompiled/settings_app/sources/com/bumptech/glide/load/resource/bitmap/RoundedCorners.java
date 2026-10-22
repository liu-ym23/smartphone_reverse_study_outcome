package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes3.dex */
public final class RoundedCorners extends BitmapTransformation {
    private static final String ID = "com.bumptech.glide.load.resource.bitmap.RoundedCorners";
    private static final byte[] ID_BYTES = null;
    private final int roundingRadius;

    static {
        ID_BYTES = ID.getBytes(CHARSET);
    }

    public RoundedCorners(int r3) {
        if (r3 <= 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "roundingRadius must be greater than 0.");
        this.roundingRadius = r3;
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    protected Bitmap transform(BitmapPool r1, Bitmap r2, int r3, int r4) {
        return TransformationUtils.roundedCorners(r1, r2, this.roundingRadius);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r3) {
        if ((r3 instanceof RoundedCorners) == true) goto L5;
        return false;
    L5:
        if (this.roundingRadius != ((RoundedCorners) r3).roundingRadius) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return Util.hashCode(-569625254, Util.hashCode(this.roundingRadius));
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r2) {
        r2.update(ID_BYTES);
        r2.update(ByteBuffer.allocate(4).putInt(this.roundingRadius).array());
    }
}
