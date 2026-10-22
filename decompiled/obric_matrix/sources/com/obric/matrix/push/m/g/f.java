package com.obric.matrix.push.m.g;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends InputStream {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final InputStream f9687f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f9688g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f9689h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f9690i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f9691j;

    public f(InputStream r2) {
        this(r2, 4096);
    }

    public f(InputStream r3, int r4) {
        this.f9691j = -1;
        if (r3.markSupported() == true) goto L5;
        r3 = new BufferedInputStream(r3, r4);
    L5:
        this.f9687f = r3;
    }

    private void g(long r5) {
        long r0 = this.f9689h;     // Catch: IOException -> L10
        long r2 = this.f9688g;     // Catch: IOException -> L10
        if (r0 < r2) goto L5;
    L7:
        this.f9689h = r2;     // Catch: IOException -> L10
        this.f9687f.mark((int) (r5 - r2));     // Catch: IOException -> L10
    L8:
        this.f9690i = r5;     // Catch: IOException -> L10
        return;
    L5:
        if (r2 > this.f9690i) goto L7;
        this.f9687f.reset();     // Catch: IOException -> L10
        this.f9687f.mark((int) (r5 - this.f9689h));     // Catch: IOException -> L10
        l(this.f9689h, this.f9688g);     // Catch: IOException -> L10
    L10:
        e = move-exception;
        throw new IllegalStateException("Unable to mark: " + e);
    }

    private void l(long r5, long r7) {
    L3:
        if (r5 >= r7) goto L11;
        long r0 = this.f9687f.skip(r7 - r5);
        if (r0 != 0) goto L10;
        if (read() == (-1)) goto L16;
        r0 = 1;
        goto L10
    L16:
        return;
    L10:
        r5 = r5 + r0;
        goto L3
    }

    public void a(long r5) {
        if (this.f9688g > this.f9690i) goto L9;
        if (r5 < this.f9689h) goto L9;
        this.f9687f.reset();
        l(this.f9689h, r5);
        this.f9688g = r5;
        return;
    L9:
        throw new IOException("Cannot reset");
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f9687f.available();
    }

    public long b(int r5) {
        long r0 = this.f9688g + ((long) r5);
        if (this.f9690i >= r0) goto L6;
        g(r0);
    L6:
        return this.f9688g;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f9687f.close();
    }

    @Override // java.io.InputStream
    public void mark(int r3) {
        this.f9691j = b(r3);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f9687f.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        int r0 = this.f9687f.read();
        if (r0 == (-1)) goto L5;
        this.f9688g++;
    L5:
        return r0;
    }

    @Override // java.io.InputStream
    public int read(byte[] r5) {
        int r6 = this.f9687f.read(r5);
        if (r6 == (-1)) goto L5;
        this.f9688g += (long) r6;
    L5:
        return r6;
    }

    @Override // java.io.InputStream
    public int read(byte[] r3, int r4, int r5) {
        int r6 = this.f9687f.read(r3, r4, r5);
        if (r6 == (-1)) goto L5;
        this.f9688g += (long) r6;
    L5:
        return r6;
    }

    @Override // java.io.InputStream
    public void reset() {
        a(this.f9691j);
    }

    @Override // java.io.InputStream
    public long skip(long r3) {
        long r4 = this.f9687f.skip(r3);
        this.f9688g += r4;
        return r4;
    }
}
