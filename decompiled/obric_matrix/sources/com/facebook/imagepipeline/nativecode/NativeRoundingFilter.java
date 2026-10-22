package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes2.dex */
@d.c.c.d.d
public class NativeRoundingFilter {
    static {
        b.a();
    }

    public NativeRoundingFilter() {
    }

    @d.c.c.d.d
    private static native void nativeToCircleFilter(Bitmap r0, boolean r1);

    @d.c.c.d.d
    private static native void nativeToCircleWithBorderFilter(Bitmap r0, int r1, int r2, boolean r3);
}
