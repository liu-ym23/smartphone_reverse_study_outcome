package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.util.Util;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class BitmapPreFiller {
    private final BitmapPool bitmapPool;
    private BitmapPreFillRunner current;
    private final DecodeFormat defaultFormat;
    private final MemoryCache memoryCache;

    public BitmapPreFiller(MemoryCache r1, BitmapPool r2, DecodeFormat r3) {
        this.memoryCache = r1;
        this.bitmapPool = r2;
        this.defaultFormat = r3;
    }

    public void preFill(PreFillType.Builder... r6) {
        BitmapPreFillRunner r0 = this.current;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        PreFillType[] r1 = new PreFillType[r6.length];
        int r2 = 0;
    L7:
        if (r2 >= r6.length) goto L16;
        PreFillType.Builder r3 = r6[r2];
        if (r3.getConfig() != null) goto L15;
        if (this.defaultFormat != DecodeFormat.PREFER_ARGB_8888) goto L13;
        Bitmap.Config r4 = Bitmap.Config.ARGB_8888;
    L14:
        r3.setConfig(r4);
        goto L15
    L13:
        r4 = Bitmap.Config.RGB_565;
    L15:
        r1[r2] = r3.build();
        r2 = r2 + 1;
        goto L7
    L16:
        PreFillQueue r7 = generateAllocationOrder(r1);
        BitmapPreFillRunner r5 = new BitmapPreFillRunner(this.bitmapPool, this.memoryCache, r7);
        this.current = r5;
        Util.postOnUiThread(r5);
    }

    PreFillQueue generateAllocationOrder(PreFillType... r7) {
        long r0 = (this.memoryCache.getMaxSize() - this.memoryCache.getCurrentSize()) + this.bitmapPool.getMaxSize();
        int r6 = r7.length;
        int r2 = 0;
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r3 >= r6) goto L5;
        r4 = r4 + r7[r3].getWeight();
        r3 = r3 + 1;
        goto L3
    L5:
        float r8 = r0 / r4;
        HashMap r1 = new HashMap();
        int r5 = r7.length;
    L6:
        if (r2 >= r5) goto L9;
        PreFillType r9 = r7[r2];
        r1.put(r9, Integer.valueOf(Math.round(r9.getWeight() * r8) / getSizeInBytes(r9)));
        r2 = r2 + 1;
        goto L6
    L9:
        return new PreFillQueue(r1);
    }

    private static int getSizeInBytes(PreFillType r2) {
        return Util.getBitmapByteSize(r2.getWidth(), r2.getHeight(), r2.getConfig());
    }
}
