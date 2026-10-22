package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes2.dex */
@d.c.c.d.d
public class NativeBlurFilter {
    static {
        b.a();
    }

    public NativeBlurFilter() {
    }

    @d.c.c.d.d
    private static native void nativeIterativeBoxBlur(Bitmap r0, int r1, int r2);
}
