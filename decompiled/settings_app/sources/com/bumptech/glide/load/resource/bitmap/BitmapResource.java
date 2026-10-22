package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;

/* JADX INFO: loaded from: classes3.dex */
public class BitmapResource implements Resource<Bitmap>, Initializable {
    private final Bitmap bitmap;
    private final BitmapPool bitmapPool;

    @Override // com.bumptech.glide.load.engine.Resource
    public /* bridge */ /* synthetic */ Bitmap get() {
        return get();
    }

    public static BitmapResource obtain(Bitmap r1, BitmapPool r2) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return new BitmapResource(r1, r2);
    }

    public BitmapResource(Bitmap r2, BitmapPool r3) {
        this.bitmap = (Bitmap) Preconditions.checkNotNull(r2, "Bitmap must not be null");
        this.bitmapPool = (BitmapPool) Preconditions.checkNotNull(r3, "BitmapPool must not be null");
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public Class<Bitmap> getResourceClass() {
        return Bitmap.class;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.engine.Resource
    public Bitmap get() {
        return this.bitmap;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return Util.getBitmapByteSize(this.bitmap);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void recycle() {
        this.bitmapPool.put(this.bitmap);
    }

    @Override // com.bumptech.glide.load.engine.Initializable
    public void initialize() {
        this.bitmap.prepareToDraw();
    }
}
