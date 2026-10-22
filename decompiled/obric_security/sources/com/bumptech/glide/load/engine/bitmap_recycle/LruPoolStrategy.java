package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes.dex */
interface LruPoolStrategy {
    Bitmap get(int r1, int r2, Bitmap.Config r3);

    int getSize(Bitmap r1);

    String logBitmap(int r1, int r2, Bitmap.Config r3);

    String logBitmap(Bitmap r1);

    void put(Bitmap r1);

    Bitmap removeLast();
}
