package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes.dex */
final class DrawableToBitmapConverter {
    private static final BitmapPool NO_RECYCLE_BITMAP_POOL = null;
    private static final String TAG = "DrawableToBitmap";

    static {
        NO_RECYCLE_BITMAP_POOL = new AnonymousClass1();
    }

    private DrawableToBitmapConverter() {
    }

    static Resource<Bitmap> convert(BitmapPool r2, Drawable r3, int r4, int r5) {
        Drawable r6 = r3.getCurrent();
        boolean r1 = false;
        if ((r6 instanceof BitmapDrawable) == false) goto L6;
        Bitmap r7 = ((BitmapDrawable) r6).getBitmap();
    L9:
        if (r1 == true) goto L13;
        r2 = NO_RECYCLE_BITMAP_POOL;
    L13:
        return BitmapResource.obtain(r7, r2);
    L6:
        if ((r6 instanceof Animatable) == true) goto L8;
        r7 = drawToBitmap(r2, r6, r4, r5);
        r1 = true;
        goto L9
    L8:
        r7 = null;
        goto L9
    }

    private static Bitmap drawToBitmap(BitmapPool r6, Drawable r7, int r8, int r9) {
        if (r8 == Integer.MIN_VALUE) goto L5;
    L10:
        if (r9 != Integer.MIN_VALUE) goto L18;
        if (r7.getIntrinsicHeight() > 0) goto L18;
        if (Log.isLoggable(TAG, 5) == false) goto L16;
        Log.w(TAG, "Unable to draw " + r7 + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
    L16:
        return null;
    L18:
        if (r7.getIntrinsicWidth() <= 0) goto L21;
        r8 = r7.getIntrinsicWidth();
    L21:
        if (r7.getIntrinsicHeight() <= 0) goto L23;
        r9 = r7.getIntrinsicHeight();
    L23:
        Lock r0 = TransformationUtils.getBitmapDrawableLock();
        r0.lock();
        Bitmap r10 = r6.get(r8, r9, Bitmap.Config.ARGB_8888);
        Canvas r1 = new Canvas(r10);     // Catch: Throwable -> L27
        r7.setBounds(0, 0, r8, r9);     // Catch: Throwable -> L27
        r7.draw(r1);     // Catch: Throwable -> L27
        r1.setBitmap(null);     // Catch: Throwable -> L27
        r0.unlock();
        return r10;
    L27:
        th = move-exception;
        r0.unlock();
        throw th;
    L5:
        if (r7.getIntrinsicWidth() > 0) goto L10;
        if (Log.isLoggable(TAG, 5) == false) goto L9;
        Log.w(TAG, "Unable to draw " + r7 + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
    L9:
        return null;
    }
}
