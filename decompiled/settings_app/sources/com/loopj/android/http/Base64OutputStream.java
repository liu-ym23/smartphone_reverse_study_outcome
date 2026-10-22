package com.loopj.android.http;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes4.dex */
public class Base64OutputStream extends FilterOutputStream {
    private static final byte[] EMPTY = null;
    private int bpos;
    private byte[] buffer;
    private final Base64.Coder coder;
    private final int flags;

    static {
        EMPTY = new byte[0];
    }

    public Base64OutputStream(OutputStream r2, int r3) {
        this(r2, r3, true);
    }

    public Base64OutputStream(OutputStream r2, int r3, boolean r4) {
        super(r2);
        this.buffer = null;
        this.bpos = 0;
        this.flags = r3;
        if (r4 == false) goto L5;
        this.coder = new Base64.Encoder(r3, null);
        return;
    L5:
        this.coder = new Base64.Decoder(r3, null);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int r4) throws IOException {
        if (this.buffer != null) goto L5;
        this.buffer = new byte[1024];
    L5:
        int r0 = this.bpos;
        byte[] r1 = this.buffer;
        if (r0 < r1.length) goto L8;
        internalWrite(r1, 0, r0, false);
        this.bpos = 0;
    L8:
        byte[] r2 = this.buffer;
        int r3 = this.bpos;
        this.bpos = r3 + 1;
        r2[r3] = (byte) r4;
    }

    private void flushBuffer() throws IOException {
        int r0 = this.bpos;
        if (r0 <= 0) goto L6;
        internalWrite(this.buffer, 0, r0, false);
        this.bpos = 0;
        return;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] r2, int r3, int r4) throws IOException {
        if (r4 > 0) goto L4;
        return;
    L4:
        flushBuffer();
        internalWrite(r2, r3, r4, false);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        flushBuffer();     // Catch: IOException -> L4
        internalWrite(EMPTY, 0, 0, true);     // Catch: IOException -> L4
        e = null;
    L16:
    L10:
        e = move-exception;
        if (e == null) goto L13;
        e = e;
    L13:
        if (e != null) goto L15;
        return;
    L15:
        throw e;
    L6:
        if ((this.flags & 16) != 0) goto L8;
        this.out.close();     // Catch: IOException -> L10
        goto L13
    L8:
        this.out.flush();     // Catch: IOException -> L10
    L4:
        e = e;
        goto L16
    }

    private void internalWrite(byte[] r4, int r5, int r6, boolean r7) throws IOException {
        Base64.Coder r0 = this.coder;
        r0.output = embiggen(r0.output, this.coder.maxOutputSize(r6));
        if (this.coder.process(r4, r5, r6, r7) == false) goto L7;
        this.out.write(this.coder.output, 0, this.coder.op);
        return;
    L7:
        throw new Base64DataException("bad base-64");
    }

    private byte[] embiggen(byte[] r1, int r2) {
        if (r1 == null) goto L8;
        if (r1.length < r2) goto L8;
        return r1;
    L8:
        return new byte[r2];
    }
}
