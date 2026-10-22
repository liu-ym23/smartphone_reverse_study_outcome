package com.loc;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public final class m0 implements Closeable {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Charset f7546k = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final InputStream f7547f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Charset f7548g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private byte[] f7549h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f7550i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f7551j;

    final class a extends ByteArrayOutputStream {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ m0 f7552f;

        a(m0 r1, int r2) {
            this.f7552f = r1;
            super(r2);
        }

        @Override // java.io.ByteArrayOutputStream
        public final String toString() {
            int r0 = ((ByteArrayOutputStream) this).count;
            if (r0 > 0) goto L5;
        L12:
            return new String(((ByteArrayOutputStream) this).buf, 0, r0, m0.b(this.f7552f).name());
        L9:
            e = move-exception;
            throw new AssertionError(e);
        L5:
            if (((ByteArrayOutputStream) this).buf[r0 - 1] != 13) goto L12;
            r0 = r0 - 1;
            goto L12
        }
    }

    static {
        f7546k = Charset.forName("US-ASCII");
    }

    public m0(InputStream r2, Charset r3) {
        this(r2, r3, (byte) 0);
    }

    private m0(InputStream r1, Charset r2, byte r3) {
        if (r1 == null) goto L12;
        if (r2 == null) goto L12;
        if (r2.equals(f7546k) == false) goto L10;
        this.f7547f = r1;
        this.f7548g = r2;
        this.f7549h = new byte[8192];
        return;
    L10:
        throw new IllegalArgumentException("Unsupported encoding");
    L12:
        throw null;
    }

    static /* synthetic */ Charset b(m0 r0) {
        return r0.f7548g;
    }

    private void g() {
        InputStream r0 = this.f7547f;
        byte[] r1 = this.f7549h;
        int r2 = r0.read(r1, 0, r1.length);
        if (r2 == (-1)) goto L7;
        this.f7550i = 0;
        this.f7551j = r2;
        return;
    L7:
        throw new EOFException();
    }

    public final String a() {
        InputStream r0 = this.f7547f;
        monitor-enter(r0);
    L39:
        th = move-exception;
        throw th;
    L5:
        if (this.f7549h == null) goto L38;
        if (this.f7550i < this.f7551j) goto L9;
        g();     // Catch: Throwable -> L39
    L9:
        int r1 = this.f7550i;     // Catch: Throwable -> L39
    L11:
        if (r1 == this.f7551j) goto L24;
        byte[] r2 = this.f7549h;     // Catch: Throwable -> L39
        if (r2[r1] == 10) goto L15;
        r1 = r1 + 1;     // Catch: Throwable -> L39
        goto L11
    L15:
        if (r1 == this.f7550i) goto L19;
        int r3 = r1 - 1;     // Catch: Throwable -> L39
        if (r2[r3] != 13) goto L19;
    L20:
        byte[] r4 = this.f7549h;     // Catch: Throwable -> L39
        int r5 = this.f7550i;     // Catch: Throwable -> L39
        String r6 = new String(r4, r5, r3 - r5, this.f7548g.name());     // Catch: Throwable -> L39
        this.f7550i = r1 + 1;     // Catch: Throwable -> L39
        monitor-exit(r0);     // Catch: Throwable -> L39
        return r6;
    L19:
        r3 = r1;
        goto L20
    L24:
        a r7 = new a(this, (this.f7551j - this.f7550i) + 80);     // Catch: Throwable -> L39
    L25:
        byte[] r8 = this.f7549h;     // Catch: Throwable -> L39
        int r9 = this.f7550i;     // Catch: Throwable -> L39
        r7.write(r8, r9, this.f7551j - r9);     // Catch: Throwable -> L39
        this.f7551j = -1;     // Catch: Throwable -> L39
        g();     // Catch: Throwable -> L39
        int r10 = this.f7550i;     // Catch: Throwable -> L39
    L27:
        if (r10 == this.f7551j) goto L25;
        byte[] r11 = this.f7549h;     // Catch: Throwable -> L39
        if (r11[r10] == 10) goto L30;
        r10 = r10 + 1;     // Catch: Throwable -> L39
        goto L27
    L30:
        int r12 = this.f7550i;     // Catch: Throwable -> L39
        if (r10 == r12) goto L33;
        r7.write(r11, r12, r10 - r12);     // Catch: Throwable -> L39
    L33:
        this.f7550i = r10 + 1;     // Catch: Throwable -> L39
        String r13 = r7.toString();     // Catch: Throwable -> L39
        monitor-exit(r0);     // Catch: Throwable -> L39
        return r13;
    L38:
        throw new IOException("LineReader is closed");     // Catch: Throwable -> L39
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        InputStream r0 = this.f7547f;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.f7549h == null) goto L7;
        this.f7549h = null;     // Catch: Throwable -> L9
        this.f7547f.close();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
    }
}
