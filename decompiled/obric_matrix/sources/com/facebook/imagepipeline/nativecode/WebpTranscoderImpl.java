package com.facebook.imagepipeline.nativecode;

import android.os.Build;
import d.c.c.d.i;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
@d.c.c.d.d
public class WebpTranscoderImpl implements e {
    public WebpTranscoderImpl() {
    }

    @d.c.c.d.d
    private static native void nativeTranscodeWebpToJpeg(InputStream r0, OutputStream r1, int r2);

    @d.c.c.d.d
    private static native void nativeTranscodeWebpToPng(InputStream r0, OutputStream r1);

    @Override // com.facebook.imagepipeline.nativecode.e
    public void a(InputStream r1, OutputStream r2, int r3) {
        d.a();
        i.g(r1);
        i.g(r2);
        nativeTranscodeWebpToJpeg(r1, r2, r3);
    }

    @Override // com.facebook.imagepipeline.nativecode.e
    public void b(InputStream r1, OutputStream r2) {
        d.a();
        i.g(r1);
        i.g(r2);
        nativeTranscodeWebpToPng(r1, r2);
    }

    @Override // com.facebook.imagepipeline.nativecode.e
    public boolean c(d.c.h.d r2) {
        if (r2 != d.c.h.c.f15824f) goto L9;
        if (Build.VERSION.SDK_INT < 14) goto L22;
        return true;
    L22:
        return false;
    L9:
        if (r2 == d.c.h.c.f15825g) goto L21;
        if (r2 == d.c.h.c.f15826h) goto L21;
        if (r2 == d.c.h.c.f15827i) goto L21;
        if (r2 != d.c.h.c.f15828j) goto L19;
        return false;
    L19:
        throw new IllegalArgumentException("Image format is not a WebP.");
    L21:
        return d.c.c.l.c.f15448b;
    }
}
