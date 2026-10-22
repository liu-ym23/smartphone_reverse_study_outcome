package com.facebook.imagepipeline.memory;

import android.util.Log;
import java.io.Closeable;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
@d.c.c.d.d
public class NativeMemoryChunk implements t, Closeable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f6659f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f6660g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f6661h;

    static {
        com.facebook.imagepipeline.nativecode.a.a();
    }

    public NativeMemoryChunk() {
        this.f6660g = 0;
        this.f6659f = 0;
        this.f6661h = true;
    }

    public NativeMemoryChunk(int r4) {
        if (r4 <= 0) goto L5;
        boolean r1 = true;
    L6:
        d.c.c.d.i.b(r1);
        this.f6660g = r4;
        this.f6659f = nativeAllocate(r4);
        this.f6661h = false;
        return;
    L5:
        r1 = false;
        goto L6
    }

    @d.c.c.d.d
    private static native long nativeAllocate(int r0);

    @d.c.c.d.d
    private static native void nativeCopyFromByteArray(long r0, byte[] r2, int r3, int r4);

    @d.c.c.d.d
    private static native void nativeCopyToByteArray(long r0, byte[] r2, int r3, int r4);

    @d.c.c.d.d
    private static native void nativeFree(long r0);

    @d.c.c.d.d
    private static native void nativeMemcpy(long r0, long r2, int r4);

    @d.c.c.d.d
    private static native byte nativeReadByte(long r0);

    private void s(int r3, t r4, int r5, int r6) {
        if ((r4 instanceof NativeMemoryChunk) == false) goto L7;
        d.c.c.d.i.i(!isClosed());
        d.c.c.d.i.i(!r4.isClosed());
        v.b(r3, r4.a(), r5, r6, this.f6660g);
        nativeMemcpy(r4.j() + ((long) r5), this.f6659f + ((long) r3), r6);
        return;
    L7:
        throw new IllegalArgumentException("Cannot copy two incompatible MemoryChunks");
    }

    @Override // com.facebook.imagepipeline.memory.t
    public int a() {
        return this.f6660g;
    }

    @Override // com.facebook.imagepipeline.memory.t
    public long b() {
        return this.f6659f;
    }

    @Override // com.facebook.imagepipeline.memory.t, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.f6661h == true) goto L6;
        this.f6661h = true;     // Catch: Throwable -> L8
        nativeFree(this.f6659f);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    @Override // com.facebook.imagepipeline.memory.t
    public synchronized byte f(int r5) {
        monitor-enter(this);
        boolean r1 = true;
        if (isClosed() == true) goto L6;
        boolean r0 = true;
    L7:
        d.c.c.d.i.i(r0);     // Catch: Throwable -> L18
        if (r5 < 0) goto L10;
        boolean r2 = true;
    L11:
        d.c.c.d.i.b(r2);     // Catch: Throwable -> L18
        if (r5 < this.f6660g) goto L15;
        r1 = false;
    L15:
        d.c.c.d.i.b(r1);     // Catch: Throwable -> L18
        byte r6 = nativeReadByte(this.f6659f + ((long) r5));     // Catch: Throwable -> L18
        monitor-exit(this);
        return r6;
    L10:
        r2 = false;
        goto L11
    L6:
        r0 = false;
    L18:
        th = move-exception;
        throw th;
    }

    protected void finalize() {
        if (isClosed() == false) goto L5;
        return;
    L5:
        Log.w("NativeMemoryChunk", "finalize: Chunk " + Integer.toHexString(System.identityHashCode(this)) + " still active. ");
        close();     // Catch: Throwable -> L9
        super.finalize();
        return;
    L9:
        th = move-exception;
        super.finalize();
        throw th;
    }

    @Override // com.facebook.imagepipeline.memory.t
    public void g(int r5, t r6, int r7, int r8) {
        d.c.c.d.i.g(r6);
        if (r6.b() != b()) goto L6;
        Log.w("NativeMemoryChunk", "Copying from NativeMemoryChunk " + Integer.toHexString(System.identityHashCode(this)) + " to NativeMemoryChunk " + Integer.toHexString(System.identityHashCode(r6)) + " which share the same address " + Long.toHexString(this.f6659f));
        d.c.c.d.i.b(false);
    L6:
        if (r6.b() >= b()) goto L19;
        monitor-enter(r6);
        monitor-enter(this);     // Catch: Throwable -> L16
        s(r5, r6, r7, r8);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        monitor-exit(r6);     // Catch: Throwable -> L16
        return;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    L19:
        monitor-enter(this);
        monitor-enter(r6);     // Catch: Throwable -> L28
        s(r5, r6, r7, r8);     // Catch: Throwable -> L25
        monitor-exit(r6);     // Catch: Throwable -> L25
        monitor-exit(this);     // Catch: Throwable -> L28
        return;
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.imagepipeline.memory.t
    public synchronized int h(int r5, byte[] r6, int r7, int r8) {
        monitor-enter(this);
        d.c.c.d.i.g(r6);     // Catch: Throwable -> L10
        if (isClosed() == true) goto L6;
        boolean r0 = true;
    L7:
        d.c.c.d.i.i(r0);     // Catch: Throwable -> L10
        int r9 = v.a(r5, r8, this.f6660g);     // Catch: Throwable -> L10
        v.b(r5, r6.length, r7, r9, this.f6660g);     // Catch: Throwable -> L10
        nativeCopyToByteArray(this.f6659f + ((long) r5), r6, r7, r9);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r9;
    L6:
        r0 = false;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.imagepipeline.memory.t
    public ByteBuffer i() {
        return null;
    }

    @Override // com.facebook.imagepipeline.memory.t
    public synchronized boolean isClosed() {
        monitor-enter(this);
        boolean r0 = this.f6661h;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.imagepipeline.memory.t
    public long j() {
        return this.f6659f;
    }

    @Override // com.facebook.imagepipeline.memory.t
    public synchronized int l(int r5, byte[] r6, int r7, int r8) {
        monitor-enter(this);
        d.c.c.d.i.g(r6);     // Catch: Throwable -> L10
        if (isClosed() == true) goto L6;
        boolean r0 = true;
    L7:
        d.c.c.d.i.i(r0);     // Catch: Throwable -> L10
        int r9 = v.a(r5, r8, this.f6660g);     // Catch: Throwable -> L10
        v.b(r5, r6.length, r7, r9, this.f6660g);     // Catch: Throwable -> L10
        nativeCopyFromByteArray(this.f6659f + ((long) r5), r6, r7, r9);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r9;
    L6:
        r0 = false;
    L10:
        th = move-exception;
        throw th;
    }
}
