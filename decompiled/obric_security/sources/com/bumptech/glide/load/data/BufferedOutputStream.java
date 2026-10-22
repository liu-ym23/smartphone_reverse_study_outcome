package com.bumptech.glide.load.data;

import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public final class BufferedOutputStream extends OutputStream {
    private ArrayPool arrayPool;
    private byte[] buffer;
    private int index;
    private final OutputStream out;

    public BufferedOutputStream(OutputStream r2, ArrayPool r3) {
        this(r2, r3, 65536);
    }

    BufferedOutputStream(OutputStream r1, ArrayPool r2, int r3) {
        this.out = r1;
        this.arrayPool = r2;
        this.buffer = (byte[]) r2.get(r3, byte[].class);
    }

    @Override // java.io.OutputStream
    public void write(int r4) throws IOException {
        byte[] r0 = this.buffer;
        int r1 = this.index;
        this.index = r1 + 1;
        r0[r1] = (byte) r4;
        maybeFlushBuffer();
    }

    @Override // java.io.OutputStream
    public void write(byte[] r3) throws IOException {
        write(r3, 0, r3.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] r6, int r7, int r8) throws IOException {
        int r0 = 0;
    L3:
        int r1 = r8 - r0;
        int r2 = r7 + r0;
        int r3 = this.index;
        if (r3 == 0) goto L6;
    L9:
        int r4 = Math.min(r1, this.buffer.length - r3);
        System.arraycopy(r6, r2, this.buffer, this.index, r4);
        this.index += r4;
        r0 = r0 + r4;
        maybeFlushBuffer();
        if (r0 < r8) goto L3;
        return;
    L6:
        if (r1 < this.buffer.length) goto L9;
        this.out.write(r6, r2, r1);
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        flushBuffer();
        this.out.flush();
    }

    private void flushBuffer() throws IOException {
        int r0 = this.index;
        if (r0 <= 0) goto L6;
        this.out.write(this.buffer, 0, r0);
        this.index = 0;
        return;
    }

    private void maybeFlushBuffer() throws IOException {
        if (this.index != this.buffer.length) goto L6;
        flushBuffer();
        return;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        flush();     // Catch: Throwable -> L5
        this.out.close();
        release();
        return;
    L5:
        th = move-exception;
        this.out.close();
        throw th;
    }

    private void release() {
        byte[] r0 = this.buffer;
        if (r0 == null) goto L6;
        this.arrayPool.put(r0);
        this.buffer = null;
        return;
    }
}
