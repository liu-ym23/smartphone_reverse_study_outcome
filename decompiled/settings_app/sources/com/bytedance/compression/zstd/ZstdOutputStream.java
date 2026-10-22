package com.bytedance.compression.zstd;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public class ZstdOutputStream extends FilterOutputStream {
    private ZstdOutputStreamNoFinalizer inner;

    @Deprecated
    public void setFinalize(boolean r1) {
    }

    public ZstdOutputStream(OutputStream r2, int r3) throws IOException {
        this(r2, NoPool.INSTANCE);
        this.inner.setLevel(r3);
    }

    public ZstdOutputStream(OutputStream r2) throws IOException {
        this(r2, NoPool.INSTANCE);
    }

    private ZstdOutputStream(OutputStream r2, BufferPool r3) throws IOException {
        super(r2);
        this.inner = new ZstdOutputStreamNoFinalizer(r2, r3);
    }

    protected void finalize() throws Throwable {
        close();
    }

    public static long recommendedCOutSize() {
        return ZstdOutputStreamNoFinalizer.recommendedCOutSize();
    }

    public ZstdOutputStream setChecksum(boolean r2) throws IOException {
        this.inner.setChecksum(r2);
        return this;
    }

    public ZstdOutputStream setLevel(int r2) throws IOException {
        this.inner.setLevel(r2);
        return this;
    }

    public ZstdOutputStream setLong(int r2) throws IOException {
        this.inner.setLong(r2);
        return this;
    }

    public ZstdOutputStream setWorkers(int r2) throws IOException {
        this.inner.setWorkers(r2);
        return this;
    }

    public ZstdOutputStream setCloseFrameOnFlush(boolean r2) throws IOException {
        this.inner.setCloseFrameOnFlush(r2);
        return this;
    }

    public ZstdOutputStream setDict(byte[] r2) throws IOException {
        this.inner.setDict(r2);
        return this;
    }

    public ZstdOutputStream setDict(ZstdDictCompress r2) throws IOException {
        this.inner.setDict(r2);
        return this;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] r1, int r2, int r3) throws IOException {
        this.inner.write(r1, r2, r3);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int r1) throws IOException {
        this.inner.write(r1);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.inner.flush();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.inner.close();
    }
}
