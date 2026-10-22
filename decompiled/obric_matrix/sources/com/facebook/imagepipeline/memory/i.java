package com.facebook.imagepipeline.memory;

import android.util.Log;
import java.io.Closeable;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class i implements t, Closeable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ByteBuffer f6729f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f6730g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f6731h;

    public i(int r3) {
        this.f6729f = ByteBuffer.allocateDirect(r3);
        this.f6730g = r3;
        this.f6731h = System.identityHashCode(this);
    }

    private void s(int r3, t r4, int r5, int r6) {
        if ((r4 instanceof i) == false) goto L7;
        d.c.c.d.i.i(!isClosed());
        d.c.c.d.i.i(!r4.isClosed());
        v.b(r3, r4.a(), r5, r6, this.f6730g);
        this.f6729f.position(r3);
        r4.i().position(r5);
        byte[] r7 = new byte[r6];
        this.f6729f.get(r7, 0, r6);
        r4.i().put(r7, 0, r6);
        return;
    L7:
        throw new IllegalArgumentException("Cannot copy two incompatible MemoryChunks");
    }

    @Override // com.facebook.imagepipeline.memory.t
    public int a() {
        return this.f6730g;
    }

    @Override // com.facebook.imagepipeline.memory.t
    public long b() {
        return this.f6731h;
    }

    @Override // com.facebook.imagepipeline.memory.t, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        monitor-enter(this);
        this.f6729f = null;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.imagepipeline.memory.t
    public synchronized byte f(int r4) {
        monitor-enter(this);
        boolean r1 = true;
        if (isClosed() == true) goto L6;
        boolean r0 = true;
    L7:
        d.c.c.d.i.i(r0);     // Catch: Throwable -> L18
        if (r4 < 0) goto L10;
        boolean r2 = true;
    L11:
        d.c.c.d.i.b(r2);     // Catch: Throwable -> L18
        if (r4 < this.f6730g) goto L15;
        r1 = false;
    L15:
        d.c.c.d.i.b(r1);     // Catch: Throwable -> L18
        byte r5 = this.f6729f.get(r4);     // Catch: Throwable -> L18
        monitor-exit(this);
        return r5;
    L10:
        r2 = false;
        goto L11
    L6:
        r0 = false;
    L18:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.imagepipeline.memory.t
    public void g(int r5, t r6, int r7, int r8) {
        d.c.c.d.i.g(r6);
        if (r6.b() != b()) goto L6;
        Log.w("BufferMemoryChunk", "Copying from BufferMemoryChunk " + Long.toHexString(b()) + " to BufferMemoryChunk " + Long.toHexString(r6.b()) + " which are the same ");
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
    public synchronized int h(int r3, byte[] r4, int r5, int r6) {
        monitor-enter(this);
        d.c.c.d.i.g(r4);     // Catch: Throwable -> L10
        if (isClosed() == true) goto L6;
        boolean r0 = true;
    L7:
        d.c.c.d.i.i(r0);     // Catch: Throwable -> L10
        int r7 = v.a(r3, r6, this.f6730g);     // Catch: Throwable -> L10
        v.b(r3, r4.length, r5, r7, this.f6730g);     // Catch: Throwable -> L10
        this.f6729f.position(r3);     // Catch: Throwable -> L10
        this.f6729f.get(r4, r5, r7);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r7;
    L6:
        r0 = false;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.imagepipeline.memory.t
    public synchronized ByteBuffer i() {
        monitor-enter(this);
        ByteBuffer r0 = this.f6729f;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.imagepipeline.memory.t
    public synchronized boolean isClosed() {
        monitor-enter(this);
        if (this.f6729f != null) goto L6;
        boolean r0 = true;
    L7:
        monitor-exit(this);
        return r0;
    L6:
        r0 = false;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.imagepipeline.memory.t
    public long j() {
        throw new UnsupportedOperationException("Cannot get the pointer of a BufferMemoryChunk");
    }

    @Override // com.facebook.imagepipeline.memory.t
    public synchronized int l(int r3, byte[] r4, int r5, int r6) {
        monitor-enter(this);
        d.c.c.d.i.g(r4);     // Catch: Throwable -> L10
        if (isClosed() == true) goto L6;
        boolean r0 = true;
    L7:
        d.c.c.d.i.i(r0);     // Catch: Throwable -> L10
        int r7 = v.a(r3, r6, this.f6730g);     // Catch: Throwable -> L10
        v.b(r3, r4.length, r5, r7, this.f6730g);     // Catch: Throwable -> L10
        this.f6729f.position(r3);     // Catch: Throwable -> L10
        this.f6729f.put(r4, r5, r7);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r7;
    L6:
        r0 = false;
    L10:
        th = move-exception;
        throw th;
    }
}
