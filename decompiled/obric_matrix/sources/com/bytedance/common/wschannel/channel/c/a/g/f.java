package com.bytedance.common.wschannel.channel.c.a.g;

import java.io.IOException;
import java.util.Objects;
import java.util.Random;
import k.a0;
import k.h;
import k.x;

/* JADX INFO: loaded from: classes.dex */
final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final boolean f3476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Random f3477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final k.f f3478c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final k.e f3479d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f3480e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final k.e f3481f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final a f3482g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f3483h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final byte[] f3484i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final k.e.a f3485j;

    final class a implements x {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f3486f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        long f3487g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f3488h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        boolean f3489i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ f f3490j;

        a(f r1) {
            this.f3490j = r1;
        }

        @Override // k.x
        public void J(k.e r7, long r8) {
            if (this.f3489i == true) goto L18;
            this.f3490j.f3481f.J(r7, r8);
            if (this.f3488h == true) goto L7;
        L11:
            boolean r9 = false;
        L12:
            long r2 = this.f3490j.f3481f.E();
            if (r2 <= 0) goto L19;
            if (r9 == true) goto L20;
            this.f3490j.d(this.f3486f, r2, this.f3488h, false);
            this.f3488h = false;
            return;
        L20:
            return;
        L19:
            return;
        L7:
            if (this.f3487g == (-1)) goto L11;
            if (this.f3490j.f3481f.k0() <= (this.f3487g - 8192)) goto L11;
            r9 = true;
            goto L12
        L18:
            throw new IOException("closed");
        }

        @Override // k.x, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f3489i == true) goto L7;
            f r1 = this.f3490j;
            r1.d(this.f3486f, r1.f3481f.k0(), this.f3488h, true);
            this.f3489i = true;
            this.f3490j.f3483h = false;
            return;
        L7:
            throw new IOException("closed");
        }

        @Override // k.x
        public a0 e() {
            return this.f3490j.f3478c.e();
        }

        @Override // k.x, java.io.Flushable
        public void flush() {
            if (this.f3489i == true) goto L7;
            f r1 = this.f3490j;
            r1.d(this.f3486f, r1.f3481f.k0(), this.f3488h, false);
            this.f3488h = false;
            return;
        L7:
            throw new IOException("closed");
        }
    }

    f(boolean r2, k.f r3, Random r4) {
        this.f3481f = new k.e();
        this.f3482g = new a(this);
        Objects.requireNonNull(r3, "sink == null");
        Objects.requireNonNull(r4, "random == null");
        this.f3476a = r2;
        this.f3478c = r3;
        this.f3479d = r3.c();
        this.f3477b = r4;
        k.e.a r5 = null;
        if (r2 == false) goto L5;
        byte[] r6 = new byte[4];
    L6:
        this.f3484i = r6;
        if (r2 == false) goto L9;
        r5 = new k.e.a();
    L9:
        this.f3485j = r5;
        return;
    L5:
        r6 = null;
        goto L6
    }

    private void c(int r6, h r7) {
        if (this.f3480e == true) goto L17;
        int r0 = r7.size();
        if (r0 > 125) goto L15;
        this.f3479d.s0(r6 | 128);
        if (this.f3476a == false) goto L11;
        this.f3479d.s0(r0 | 128);
        this.f3477b.nextBytes(this.f3484i);
        this.f3479d.p0(this.f3484i);
        if (r0 <= 0) goto L12;
        long r1 = this.f3479d.k0();
        this.f3479d.o0(r7);
        this.f3479d.Y(this.f3485j);
        this.f3485j.b(r1);
        d.b(this.f3485j, this.f3484i);
        this.f3485j.close();
    L12:
        this.f3478c.flush();
        return;
    L11:
        this.f3479d.s0(r0);
        this.f3479d.o0(r7);
        goto L12
    L15:
        throw new IllegalArgumentException("Payload size must be less than or equal to 125");
    L17:
        throw new IOException("closed");
    }

    x a(int r2, long r3) {
        if (this.f3483h == true) goto L7;
        this.f3483h = true;
        a r1 = this.f3482g;
        r1.f3486f = r2;
        r1.f3487g = r3;
        r1.f3488h = true;
        r1.f3489i = false;
        return r1;
    L7:
        throw new IllegalStateException("Another message writer is active. Did you call close()?");
    }

    void b(int r2, h r3) {
        h r0 = h.f18266i;
        if (r2 != 0) goto L5;
        if (r3 != null) goto L5;
    L18:
        c(8, r0);     // Catch: Throwable -> L15
        this.f3480e = true;
        return;
    L15:
        th = move-exception;
        this.f3480e = true;
        throw th;
    L5:
        if (r2 == 0) goto L7;
        d.c(r2);
    L7:
        k.e r1 = new k.e();
        r1.z0(r2);
        if (r3 == null) goto L10;
        r1.o0(r3);
    L10:
        r0 = r1.d0();
        goto L18
    }

    void d(int r2, long r3, boolean r5, boolean r6) {
        if (this.f3480e == true) goto L29;
        int r0 = 0;
        if (r5 == true) goto L8;
        r2 = 0;
    L8:
        if (r6 == false) goto L10;
        r2 = r2 | 128;
    L10:
        this.f3479d.s0(r2);
        if (this.f3476a == false) goto L14;
        r0 = 128;
    L14:
        if (r3 > 125) goto L17;
        this.f3479d.s0(((int) r3) | r0);
    L21:
        if (this.f3476a == false) goto L25;
        this.f3477b.nextBytes(this.f3484i);
        this.f3479d.p0(this.f3484i);
        if (r3 <= 0) goto L26;
        long r7 = this.f3479d.k0();
        this.f3479d.J(this.f3481f, r3);
        this.f3479d.Y(this.f3485j);
        this.f3485j.b(r7);
        d.b(this.f3485j, this.f3484i);
        this.f3485j.close();
    L26:
        this.f3478c.o();
        return;
    L25:
        this.f3479d.J(this.f3481f, r3);
        goto L26
    L17:
        if (r3 > 65535) goto L19;
        this.f3479d.s0(r0 | 126);
        this.f3479d.z0((int) r3);
        goto L21
    L19:
        this.f3479d.s0(r0 | 127);
        this.f3479d.x0(r3);
        goto L21
    L29:
        throw new IOException("closed");
    }

    void e(h r2) {
        c(9, r2);
    }

    void f(h r2) {
        c(10, r2);
    }
}
