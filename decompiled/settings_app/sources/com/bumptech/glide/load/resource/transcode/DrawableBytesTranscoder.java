package com.bumptech.glide.load.resource.transcode;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.load.resource.gif.GifDrawable;

/* JADX INFO: loaded from: classes3.dex */
public final class DrawableBytesTranscoder implements ResourceTranscoder<Drawable, byte[]> {
    private final ResourceTranscoder<Bitmap, byte[]> bitmapBytesTranscoder;
    private final BitmapPool bitmapPool;
    private final ResourceTranscoder<GifDrawable, byte[]> gifDrawableBytesTranscoder;

    /* JADX WARN: Multi-variable type inference failed */
    private static Resource<GifDrawable> toGifDrawableResource(Resource<Drawable> r0) {
        return r0;
    }

    public DrawableBytesTranscoder(BitmapPool r1, ResourceTranscoder<Bitmap, byte[]> r2, ResourceTranscoder<GifDrawable, byte[]> r3) {
        this.bitmapPool = r1;
        this.bitmapBytesTranscoder = r2;
        this.gifDrawableBytesTranscoder = r3;
    }

    @Override // com.bumptech.glide.load.resource.transcode.ResourceTranscoder
    public Resource<byte[]> transcode(Resource<Drawable> r3, Options r4) {
        Drawable r0 = r3.get();
        if ((r0 instanceof BitmapDrawable) == false) goto L7;
        return this.bitmapBytesTranscoder.transcode(BitmapResource.obtain(((BitmapDrawable) r0).getBitmap(), this.bitmapPool), r4);
    L7:
        if ((r0 instanceof GifDrawable) == true) goto L9;
        return null;
    L9:
        return this.gifDrawableBytesTranscoder.transcode(toGifDrawableResource(r3), r4);
    }
}
