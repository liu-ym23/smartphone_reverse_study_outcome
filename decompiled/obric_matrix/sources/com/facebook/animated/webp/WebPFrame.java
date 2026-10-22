package com.facebook.animated.webp;

import android.graphics.Bitmap;
import d.c.i.c.a.d;

/* JADX INFO: loaded from: classes.dex */
public class WebPFrame implements d {

    @d.c.c.d.d
    private long mNativeContext;

    @d.c.c.d.d
    WebPFrame(long r1) {
        this.mNativeContext = r1;
    }

    private native void nativeDispose();

    private native void nativeFinalize();

    private native int nativeGetDurationMs();

    private native int nativeGetHeight();

    private native int nativeGetWidth();

    private native int nativeGetXOffset();

    private native int nativeGetYOffset();

    private native boolean nativeIsBlendWithPreviousFrame();

    private native void nativeRenderFrame(int r1, int r2, Bitmap r3);

    private native boolean nativeShouldDisposeToBackgroundColor();

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

    public boolean d() {
        return nativeIsBlendWithPreviousFrame();
    }

    @Override // d.c.i.c.a.d
    public void dispose() {
        nativeDispose();
    }

    public boolean e() {
        return nativeShouldDisposeToBackgroundColor();
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
