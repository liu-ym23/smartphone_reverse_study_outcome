package com.facebook.animated.webp;

import d.c.c.d.d;
import d.c.c.d.i;
import d.c.i.c.a.b;
import d.c.i.c.a.g;
import d.c.i.c.b.c;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
@d
public class WebPImage extends g implements c {

    @d
    private long mNativeContext;

    @d
    public WebPImage() {
    }

    @d
    WebPImage(long r1) {
        this.mNativeContext = r1;
    }

    public static WebPImage m(long r2, int r4) {
        com.facebook.imagepipeline.nativecode.d.a();
        if (r2 == 0) goto L5;
        boolean r0 = true;
    L6:
        i.b(r0);
        return nativeCreateFromNativeMemory(r2, r4);
    L5:
        r0 = false;
        goto L6
    }

    public static WebPImage n(ByteBuffer r0) {
        com.facebook.imagepipeline.nativecode.d.a();
        r0.rewind();
        return nativeCreateFromDirectByteBuffer(r0);
    }

    private static native WebPImage nativeCreateFromDirectByteBuffer(ByteBuffer r0);

    private static native WebPImage nativeCreateFromNativeMemory(long r0, int r2);

    private native void nativeDispose();

    private native void nativeFinalize();

    private native int nativeGetDuration();

    private native WebPFrame nativeGetFrame(int r1);

    private native int nativeGetFrameCount();

    private native int[] nativeGetFrameDurations();

    private native int nativeGetHeight();

    private native int nativeGetLoopCount();

    private native int nativeGetSizeInBytes();

    private native int nativeGetWidth();

    @Override // d.c.i.c.a.c
    public int a() {
        return nativeGetFrameCount();
    }

    @Override // d.c.i.c.a.c
    public int b() {
        return nativeGetLoopCount();
    }

    @Override // d.c.i.c.a.c
    public b c(int r10) {
        WebPFrame r9 = o(r10);
        int r2 = r9.b();     // Catch: Throwable -> L14
        int r3 = r9.c();     // Catch: Throwable -> L14
        int r4 = r9.getWidth();     // Catch: Throwable -> L14
        int r5 = r9.getHeight();     // Catch: Throwable -> L14
        if (r9.d() == false) goto L6;
        b.a r0 = b.a.f15849f;     // Catch: Throwable -> L14
    L7:
        b.a r6 = r0;
        if (r9.e() == false) goto L10;
        b.EnumC0426b r1 = b.EnumC0426b.f15853g;     // Catch: Throwable -> L14
    L11:
        b r8 = new b(r10, r2, r3, r4, r5, r6, r1);     // Catch: Throwable -> L14
        r9.dispose();
        return r8;
    L10:
        r1 = b.EnumC0426b.f15852f;     // Catch: Throwable -> L14
        goto L11
    L6:
        r0 = b.a.f15850g;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        r9.dispose();
        throw th;
    }

    @Override // d.c.i.c.a.c
    public d.c.h.d d() {
        return d.c.h.c.f15828j;
    }

    @Override // d.c.i.c.a.c
    public void dispose() {
        nativeDispose();
    }

    @Override // d.c.i.c.a.c
    public /* bridge */ /* synthetic */ d.c.i.c.a.d e(int r1) {
        return o(r1);
    }

    @Override // d.c.i.c.b.c
    public d.c.i.c.a.c f(long r1, int r3) {
        return m(r1, r3);
    }

    protected void finalize() {
        nativeFinalize();
    }

    @Override // d.c.i.c.a.c
    public boolean g() {
        return false;
    }

    @Override // d.c.i.c.a.c
    public int getHeight() {
        return nativeGetHeight();
    }

    @Override // d.c.i.c.a.c
    public int getWidth() {
        return nativeGetWidth();
    }

    @Override // d.c.i.c.b.c
    public d.c.i.c.a.c i(ByteBuffer r1) {
        return n(r1);
    }

    @Override // d.c.i.c.a.c
    public int[] j() {
        return nativeGetFrameDurations();
    }

    @Override // d.c.i.c.a.c
    public int k() {
        return nativeGetSizeInBytes();
    }

    public WebPFrame o(int r1) {
        return nativeGetFrame(r1);
    }
}
