package com.android.volley.toolbox;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class PoolingByteArrayOutputStream extends ByteArrayOutputStream {
    private static final int DEFAULT_SIZE = 256;
    private final ByteArrayPool mPool;

    public PoolingByteArrayOutputStream(ByteArrayPool r2) {
        this(r2, 256);
    }

    public PoolingByteArrayOutputStream(ByteArrayPool r2, int r3) {
        this.mPool = r2;
        this.buf = r2.getBuf(Math.max(r3, 256));
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mPool.returnBuf(this.buf);
        this.buf = null;
        super.close();
    }

    public void finalize() {
        this.mPool.returnBuf(this.buf);
    }

    private void expand(int r4) {
        if ((this.count + r4) > this.buf.length) goto L5;
        return;
    L5:
        byte[] r5 = this.mPool.getBuf((this.count + r4) * 2);
        System.arraycopy(this.buf, 0, r5, 0, this.count);
        this.mPool.returnBuf(this.buf);
        this.buf = r5;
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(byte[] r1, int r2, int r3) {
        monitor-enter(this);
        expand(r3);     // Catch: Throwable -> L6
        super.write(r1, r2, r3);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(int r2) {
        monitor-enter(this);
        expand(1);     // Catch: Throwable -> L7
        super.write(r2);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
