package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class BitmapDrawableEncoder implements ResourceEncoder<BitmapDrawable> {
    private final BitmapPool bitmapPool;
    private final ResourceEncoder<Bitmap> encoder;

    @Override // com.bumptech.glide.load.Encoder
    public /* bridge */ /* synthetic */ boolean encode(Object r1, File r2, Options r3) {
        return encode((Resource) r1, r2, r3);
    }

    public BitmapDrawableEncoder(BitmapPool r1, ResourceEncoder<Bitmap> r2) {
        this.bitmapPool = r1;
        this.encoder = r2;
    }

    public boolean encode(Resource<BitmapDrawable> r3, File r4, Options r5) {
        return this.encoder.encode((Bitmap) new BitmapResource(r3.get().getBitmap(), this.bitmapPool), r4, r5);
    }

    @Override // com.bumptech.glide.load.ResourceEncoder
    public EncodeStrategy getEncodeStrategy(Options r1) {
        return this.encoder.getEncodeStrategy(r1);
    }
}
