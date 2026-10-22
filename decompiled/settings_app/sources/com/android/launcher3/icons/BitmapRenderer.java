package com.android.launcher3.icons;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.graphics.Rect;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes.dex */
public interface BitmapRenderer {
    public static final boolean USE_HARDWARE_BITMAP = false;

    void draw(Canvas r1);

    static {
        USE_HARDWARE_BITMAP = true;
    }

    static Bitmap createSoftwareBitmap(int r1, int r2, BitmapRenderer r3) {
        GraphicsUtils.noteNewBitmapCreated();
        Bitmap r4 = Bitmap.createBitmap(r1, r2, Bitmap.Config.ARGB_8888);
        r3.draw(new Canvas(r4));
        return r4;
    }

    static Bitmap createHardwareBitmap(int r1, int r2, BitmapRenderer r3) {
        if (USE_HARDWARE_BITMAP == false) goto L5;
        GraphicsUtils.noteNewBitmapCreated();
        Picture r0 = new Picture();
        r3.draw(r0.beginRecording(r1, r2));
        r0.endRecording();
        return Bitmap.createBitmap(r0);
    L5:
        return createSoftwareBitmap(r1, r2, r3);
    }

    static Bitmap createBitmap(final Bitmap r8, final int r9, final int r10, final int r11, final int r12) {
        if (r8.getConfig() == Bitmap.Config.HARDWARE) goto L5;
        GraphicsUtils.noteNewBitmapCreated();
        return Bitmap.createBitmap(r8, r9, r10, r11, r12);
    L5:
        return createHardwareBitmap(r11, r12, new BitmapRenderer$$ExternalSyntheticLambda0(r8, r9, r10, r11, r12));
    }

    static /* synthetic */ void lambda$createBitmap$0(Bitmap r3, int r4, int r5, int r6, int r7, Canvas r8) {
        r8.drawBitmap(r3, new Rect(r4, r5, r4 + r6, r5 + r7), new RectF(0.0f, 0.0f, r6, r7), null);
    }
}
