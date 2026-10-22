package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

/* JADX INFO: loaded from: classes.dex */
public final class GifBitmapProvider implements GifDecoder.BitmapProvider {
    private final ArrayPool arrayPool;
    private final BitmapPool bitmapPool;

    public GifBitmapProvider(BitmapPool r2) {
        this(r2, null);
    }

    public GifBitmapProvider(BitmapPool r1, ArrayPool r2) {
        this.bitmapPool = r1;
        this.arrayPool = r2;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public Bitmap obtain(int r1, int r2, Bitmap.Config r3) {
        return this.bitmapPool.getDirty(r1, r2, r3);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public void release(Bitmap r1) {
        this.bitmapPool.put(r1);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public byte[] obtainByteArray(int r2) {
        ArrayPool r1 = this.arrayPool;
        if (r1 != null) goto L7;
        return new byte[r2];
    L7:
        return (byte[]) r1.get(r2, byte[].class);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public void release(byte[] r1) {
        ArrayPool r0 = this.arrayPool;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.put(r1);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public int[] obtainIntArray(int r2) {
        ArrayPool r1 = this.arrayPool;
        if (r1 != null) goto L7;
        return new int[r2];
    L7:
        return (int[]) r1.get(r2, int[].class);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public void release(int[] r1) {
        ArrayPool r0 = this.arrayPool;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.put(r1);
    }
}
