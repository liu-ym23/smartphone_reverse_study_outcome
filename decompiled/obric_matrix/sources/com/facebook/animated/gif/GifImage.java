package com.facebook.animated.gif;

import d.c.c.d.d;
import d.c.c.d.i;
import d.c.i.c.a.b;
import d.c.i.c.a.g;
import d.c.i.c.b.c;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
@d
public class GifImage extends g implements c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f6623b;

    @d
    private long mNativeContext;

    @d
    public GifImage() {
    }

    @d
    GifImage(long r1) {
        this.mNativeContext = r1;
    }

    public static GifImage m(ByteBuffer r1, d.c.i.f.c r2) {
        o();
        r1.rewind();
        return nativeCreateFromDirectByteBuffer(r1, Integer.MAX_VALUE, false);
    }

    public static GifImage n(long r2, int r4, d.c.i.f.c r5) {
        o();
        if (r2 == 0) goto L5;
        boolean r6 = true;
    L6:
        i.b(r6);
        return nativeCreateFromNativeMemory(r2, r4, Integer.MAX_VALUE, false);
    L5:
        r6 = false;
        goto L6
    }

    @d
    private static native GifImage nativeCreateFromDirectByteBuffer(ByteBuffer r0, int r1, boolean r2);

    @d
    private static native GifImage nativeCreateFromFileDescriptor(int r0, int r1, boolean r2);

    @d
    private static native GifImage nativeCreateFromNativeMemory(long r0, int r2, int r3, boolean r4);

    @d
    private native void nativeDispose();

    @d
    private native void nativeFinalize();

    @d
    private native int nativeGetDuration();

    @d
    private native GifFrame nativeGetFrame(int r1);

    @d
    private native int nativeGetFrameCount();

    @d
    private native int[] nativeGetFrameDurations();

    @d
    private native int nativeGetHeight();

    @d
    private native int nativeGetLoopCount();

    @d
    private native int nativeGetSizeInBytes();

    @d
    private native int nativeGetWidth();

    @d
    private native boolean nativeIsAnimated();

    private static synchronized void o() {
        monitor-enter(GifImage.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (f6623b == true) goto L7;
        f6623b = true;     // Catch: Throwable -> L9
        com.facebook.imageutils.c.b("gifimage");     // Catch: Throwable -> L9
    L7:
        monitor-exit(GifImage.class);
    }

    private static b.EnumC0426b p(int r1) {
        if (r1 != 0) goto L6;
        return b.EnumC0426b.f15852f;
    L6:
        if (r1 != 1) goto L10;
        return b.EnumC0426b.f15852f;
    L10:
        if (r1 != 2) goto L14;
        return b.EnumC0426b.f15853g;
    L14:
        if (r1 != 3) goto L18;
        return b.EnumC0426b.f15854h;
    L18:
        return b.EnumC0426b.f15852f;
    }

    @Override // d.c.i.c.a.c
    public int a() {
        return nativeGetFrameCount();
    }

    @Override // d.c.i.c.a.c
    public int b() {
        int r2 = nativeGetLoopCount();
        if (r2 == (-1)) goto L9;
        if (r2 != 0) goto L6;
        return 0;
    L6:
        return r2 + 1;
    L9:
        return 1;
    }

    @Override // d.c.i.c.a.c
    public b c(int r10) {
        GifFrame r9 = q(r10);
        b r8 = new b(r10, r9.b(), r9.c(), r9.getWidth(), r9.getHeight(), b.a.f15849f, p(r9.d()));     // Catch: Throwable -> L6
        r9.dispose();
        return r8;
    L6:
        th = move-exception;
        r9.dispose();
        throw th;
    }

    @Override // d.c.i.c.a.c
    public d.c.h.d d() {
        return d.c.h.c.f15821c;
    }

    @Override // d.c.i.c.a.c
    public void dispose() {
        nativeDispose();
    }

    @Override // d.c.i.c.a.c
    public /* bridge */ /* synthetic */ d.c.i.c.a.d e(int r1) {
        return q(r1);
    }

    @Override // d.c.i.c.b.c
    public d.c.i.c.a.c f(long r1, int r3) {
        return n(r1, r3, null);
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
        return m(r1, null);
    }

    @Override // d.c.i.c.a.c
    public int[] j() {
        return nativeGetFrameDurations();
    }

    @Override // d.c.i.c.a.c
    public int k() {
        return nativeGetSizeInBytes();
    }

    public GifFrame q(int r1) {
        return nativeGetFrame(r1);
    }
}
