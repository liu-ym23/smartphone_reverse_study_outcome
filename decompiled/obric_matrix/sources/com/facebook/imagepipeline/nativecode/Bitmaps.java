package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import d.c.c.d.i;

/* JADX INFO: loaded from: classes2.dex */
@d.c.c.d.d
public class Bitmaps {
    static {
        a.a();
    }

    public Bitmaps() {
    }

    public static void a(Bitmap r4, Bitmap r5) {
        boolean r2 = true;
        if (r5.getConfig() != r4.getConfig()) goto L5;
        boolean r0 = true;
    L6:
        i.b(r0);
        i.b(r4.isMutable());
        if (r4.getWidth() != r5.getWidth()) goto L9;
        boolean r1 = true;
    L10:
        i.b(r1);
        if (r4.getHeight() == r5.getHeight()) goto L14;
        r2 = false;
    L14:
        i.b(r2);
        nativeCopyBitmap(r4, r4.getRowBytes(), r5, r5.getRowBytes(), r4.getHeight());
        return;
    L9:
        r1 = false;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    @d.c.c.d.d
    private static native void nativeCopyBitmap(Bitmap r0, int r1, Bitmap r2, int r3, int r4);
}
