package com.bumptech.glide.disklrucache;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
class StrictLineReader implements Closeable {
    private static final byte CR = 13;
    private static final byte LF = 10;
    private byte[] buf;
    private final Charset charset;
    private int end;
    private final InputStream in;
    private int pos;

    static /* synthetic */ Charset access$000(StrictLineReader r0) {
        return r0.charset;
    }

    public StrictLineReader(InputStream r2, Charset r3) {
        this(r2, 8192, r3);
    }

    public StrictLineReader(InputStream r2, int r3, Charset r4) {
        if (r2 == null) goto L15;
        if (r4 == null) goto L15;
        if (r3 < 0) goto L13;
        if (r4.equals(Util.US_ASCII) == false) goto L11;
        this.in = r2;
        this.charset = r4;
        this.buf = new byte[r3];
        return;
    L11:
        throw new IllegalArgumentException("Unsupported encoding");
    L13:
        throw new IllegalArgumentException("capacity <= 0");
    L15:
        throw null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream r0 = this.in;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.buf == null) goto L7;
        this.buf = null;     // Catch: Throwable -> L9
        this.in.close();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    public String readLine() throws IOException {
        InputStream r0 = this.in;
        monitor-enter(r0);
    L39:
        th = move-exception;
        throw th;
    L5:
        if (this.buf == null) goto L38;
        if (this.pos < this.end) goto L9;
        fillBuf();     // Catch: Throwable -> L39
    L9:
        int r1 = this.pos;     // Catch: Throwable -> L39
    L11:
        if (r1 == this.end) goto L24;
        byte[] r2 = this.buf;     // Catch: Throwable -> L39
        if (r2[r1] == 10) goto L15;
        r1 = r1 + 1;     // Catch: Throwable -> L39
        goto L11
    L15:
        if (r1 == this.pos) goto L19;
        int r3 = r1 - 1;     // Catch: Throwable -> L39
        if (r2[r3] != 13) goto L19;
    L20:
        byte[] r4 = this.buf;     // Catch: Throwable -> L39
        int r5 = this.pos;     // Catch: Throwable -> L39
        String r6 = new String(r4, r5, r3 - r5, this.charset.name());     // Catch: Throwable -> L39
        this.pos = r1 + 1;     // Catch: Throwable -> L39
        monitor-exit(r0);     // Catch: Throwable -> L39
        return r6;
    L19:
        r3 = r1;
        goto L20
    L24:
        final int r7 = (this.end - this.pos) + 80;     // Catch: Throwable -> L39
        ByteArrayOutputStream r8 = new AnonymousClass1(this, r7);     // Catch: Throwable -> L39
    L25:
        byte[] r9 = this.buf;     // Catch: Throwable -> L39
        int r10 = this.pos;     // Catch: Throwable -> L39
        r8.write(r9, r10, this.end - r10);     // Catch: Throwable -> L39
        this.end = -1;     // Catch: Throwable -> L39
        fillBuf();     // Catch: Throwable -> L39
        int r11 = this.pos;     // Catch: Throwable -> L39
    L27:
        if (r11 == this.end) goto L25;
        byte[] r12 = this.buf;     // Catch: Throwable -> L39
        if (r12[r11] == 10) goto L30;
        r11 = r11 + 1;     // Catch: Throwable -> L39
        goto L27
    L30:
        int r13 = this.pos;     // Catch: Throwable -> L39
        if (r11 == r13) goto L33;
        r8.write(r12, r13, r11 - r13);     // Catch: Throwable -> L39
    L33:
        this.pos = r11 + 1;     // Catch: Throwable -> L39
        String r14 = r8.toString();     // Catch: Throwable -> L39
        monitor-exit(r0);     // Catch: Throwable -> L39
        return r14;
    L38:
        throw new IOException("LineReader is closed");     // Catch: Throwable -> L39
    }

    public boolean hasUnterminatedLine() {
        if (this.end != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    private void fillBuf() throws IOException {
        InputStream r0 = this.in;
        byte[] r1 = this.buf;
        int r2 = r0.read(r1, 0, r1.length);
        if (r2 == (-1)) goto L7;
        this.pos = 0;
        this.end = r2;
        return;
    L7:
        throw new EOFException();
    }
}
