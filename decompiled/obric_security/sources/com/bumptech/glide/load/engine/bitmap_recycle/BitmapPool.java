package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes.dex */
public interface BitmapPool {
    void clearMemory();

    Bitmap get(int r1, int r2, Bitmap.Config r3);

    Bitmap getDirty(int r1, int r2, Bitmap.Config r3);

    long getMaxSize();

    void put(Bitmap r1);

    void setSizeMultiplier(float r1);

    void trimMemory(int r1);
}
