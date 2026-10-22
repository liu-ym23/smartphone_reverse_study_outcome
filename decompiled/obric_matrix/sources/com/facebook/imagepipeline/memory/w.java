package com.facebook.imagepipeline.memory;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class w implements d.c.c.g.h {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f6744f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    d.c.c.h.a<t> f6745g;

    public w(d.c.c.h.a<t> r2, int r3) {
        d.c.c.d.i.g(r2);
        if (r3 >= 0) goto L5;
    L7:
        boolean r0 = false;
    L8:
        d.c.c.d.i.b(r0);
        this.f6745g = r2.a();
        this.f6744f = r3;
        return;
    L5:
        if (r3 > r2.N().a()) goto L7;
        r0 = true;
        goto L8
    }

    synchronized void a() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (isClosed() == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        throw new d.c.c.g.h.a();     // Catch: Throwable -> L9
    }

    @Override // d.c.c.g.h, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        monitor-enter(this);
        d.c.c.h.a.L(this.f6745g);     // Catch: Throwable -> L6
        this.f6745g = null;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // d.c.c.g.h
    public synchronized byte f(int r4) {
        monitor-enter(this);
        a();     // Catch: Throwable -> L14
        boolean r0 = true;
        if (r4 < 0) goto L6;
        boolean r2 = true;
    L7:
        d.c.c.d.i.b(r2);     // Catch: Throwable -> L14
        if (r4 < this.f6744f) goto L11;
        r0 = false;
    L11:
        d.c.c.d.i.b(r0);     // Catch: Throwable -> L14
        byte r5 = this.f6745g.N().f(r4);     // Catch: Throwable -> L14
        monitor-exit(this);
        return r5;
    L6:
        r2 = false;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // d.c.c.g.h
    public synchronized int h(int r3, byte[] r4, int r5, int r6) {
        monitor-enter(this);
        a();     // Catch: Throwable -> L10
        if ((r3 + r6) > this.f6744f) goto L6;
        boolean r0 = true;
    L7:
        d.c.c.d.i.b(r0);     // Catch: Throwable -> L10
        int r7 = this.f6745g.N().h(r3, r4, r5, r6);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r7;
    L6:
        r0 = false;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // d.c.c.g.h
    public synchronized ByteBuffer i() {
        monitor-enter(this);
        ByteBuffer r0 = this.f6745g.N().i();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // d.c.c.g.h
    public synchronized boolean isClosed() {
        monitor-enter(this);
        boolean r0 = !d.c.c.h.a.S(this.f6745g);
        monitor-exit(this);
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // d.c.c.g.h
    public synchronized long j() {
        monitor-enter(this);
        a();     // Catch: Throwable -> L6
        long r0 = this.f6745g.N().j();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // d.c.c.g.h
    public synchronized int size() {
        monitor-enter(this);
        a();     // Catch: Throwable -> L6
        int r0 = this.f6744f;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }
}
