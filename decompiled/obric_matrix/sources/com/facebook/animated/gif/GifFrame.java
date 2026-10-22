package com.facebook.animated.gif;

import android.graphics.Bitmap;
import d.c.i.c.a.d;

/* JADX INFO: loaded from: classes.dex */
public class GifFrame implements d {

    @d.c.c.d.d
    private long mNativeContext;

    @d.c.c.d.d
    GifFrame(long r1) {
        this.mNativeContext = r1;
    }

    @d.c.c.d.d
    private native void nativeDispose();

    @d.c.c.d.d
    private native void nativeFinalize();

    @d.c.c.d.d
    private native int nativeGetDisposalMode();

    @d.c.c.d.d
    private native int nativeGetDurationMs();

    @d.c.c.d.d
    private native int nativeGetHeight();

    @d.c.c.d.d
    private native int nativeGetTransparentPixelColor();

    @d.c.c.d.d
    private native int nativeGetWidth();

    @d.c.c.d.d
    private native int nativeGetXOffset();

    @d.c.c.d.d
    private native int nativeGetYOffset();

    @d.c.c.d.d
    private native boolean nativeHasTransparency();

    @d.c.c.d.d
    private native void nativeRenderFrame(int r1, int r2, Bitmap r3);

    @Override // d.c.i.c.a.d
    public void a(int r1, int r2, Bitmap r3) {
        nativeRenderFrame(r1, r2, r3);
    }

    @Override // d.c.i.c.a.d
    public int b() {
        return nativeGetXOffset();
    }

    @Override // d.c.i.c.a.d
    public int c() {
        return nativeGetYOffset();
    }

    public int d() {
        return nativeGetDisposalMode();
    }

    @Override // d.c.i.c.a.d
    public void dispose() {
        nativeDispose();
    }

    protected void finalize() {
        nativeFinalize();
    }

    @Override // d.c.i.c.a.d
    public int getHeight() {
        return nativeGetHeight();
    }

    @Override // d.c.i.c.a.d
    public int getWidth() {
        return nativeGetWidth();
    }
}
