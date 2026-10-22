package com.bytedance.compression.zstd;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
class ZstdOutputStreamNoFinalizer extends FilterOutputStream {
    private static final int dstSize = 0;
    private final b bufferPool;
    private boolean closeFrameOnFlush;
    private final byte[] dst;
    private final ByteBuffer dstByteBuffer;
    private long dstPos;
    private boolean frameClosed;
    private boolean isClosed;
    private long srcPos;
    private final long stream;

    static {
        com.bytedance.compression.zstd.f.a.a();
        dstSize = (int) recommendedCOutSize();
    }

    public ZstdOutputStreamNoFinalizer(OutputStream r2) {
        this(r2, c.f3825a);
    }

    public ZstdOutputStreamNoFinalizer(OutputStream r2, int r3) {
        this(r2, c.f3825a);
        ZstdCompress.setCompressionLevel(this.stream, r3);
    }

    public ZstdOutputStreamNoFinalizer(OutputStream r3, b r4) {
        super(r3);
        this.srcPos = 0;
        this.dstPos = 0;
        this.isClosed = false;
        this.closeFrameOnFlush = false;
        this.frameClosed = true;
        this.stream = createCStream();
        this.bufferPool = r4;
        int r5 = dstSize;
        ByteBuffer r6 = r4.get(r5);
        this.dstByteBuffer = r6;
        if (r6 == null) goto L7;
        this.dst = Zstd.extractArray(r6);
        return;
    L7:
        throw new IOException("Cannot get ByteBuffer of size " + r5 + " from the BufferPool");
    }

    public ZstdOutputStreamNoFinalizer(OutputStream r1, b r2, int r3) {
        this(r1, r2);
        ZstdCompress.setCompressionLevel(this.stream, r3);
    }

    private void close(boolean r8) {
        if (this.isClosed == false) goto L22;
        return;
    L22:
    L19:
        th = move-exception;
        this.isClosed = true;
        this.bufferPool.a(this.dstByteBuffer);
        freeCStream(this.stream);
        throw th;
    L7:
        if (this.frameClosed == true) goto L15;
    L8:
        int r1 = endStream(this.stream, this.dst, dstSize);     // Catch: Throwable -> L19
        long r2 = r1;
        if (Zstd.isError(r2) == true) goto L14;
        ((FilterOutputStream) this).out.write(this.dst, 0, (int) this.dstPos);     // Catch: Throwable -> L19
        if (r1 > 0) goto L8;
    L14:
        throw new IOException("Compression error: " + Zstd.getErrorName(r2));     // Catch: Throwable -> L19
    L15:
        if (r8 == false) goto L17;
        ((FilterOutputStream) this).out.close();     // Catch: Throwable -> L19
    L17:
        this.isClosed = true;
        this.bufferPool.a(this.dstByteBuffer);
        freeCStream(this.stream);
    }

    private native int compressStream(long r1, byte[] r3, int r4, byte[] r5, int r6);

    private static native long createCStream();

    private native int endStream(long r1, byte[] r3, int r4);

    private native int flushStream(long r1, byte[] r3, int r4);

    private static native int freeCStream(long r0);

    public static native long recommendedCOutSize();

    private native int resetCStream(long r1);

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        monitor-enter(this);
        close(true);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void closeWithoutClosingParentStream() {
        monitor-enter(this);
        close(false);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public synchronized void flush() {
        monitor-enter(this);
    L27:
        th = move-exception;
        throw th;
    L4:
        if (this.isClosed == true) goto L26;
        if (this.frameClosed == false) goto L8;
    L23:
        monitor-exit(this);
        return;
    L8:
        if (this.closeFrameOnFlush == false) goto L16;
    L9:
        int r0 = endStream(this.stream, this.dst, dstSize);     // Catch: Throwable -> L27
        long r2 = r0;
        if (Zstd.isError(r2) == true) goto L15;
        ((FilterOutputStream) this).out.write(this.dst, 0, (int) this.dstPos);     // Catch: Throwable -> L27
        if (r0 > 0) goto L9;
        this.frameClosed = true;     // Catch: Throwable -> L27
    L20:
        ((FilterOutputStream) this).out.flush();     // Catch: Throwable -> L27
        goto L23
    L15:
        throw new IOException("Compression error: " + Zstd.getErrorName(r2));     // Catch: Throwable -> L27
    L16:
        int r1 = flushStream(this.stream, this.dst, dstSize);     // Catch: Throwable -> L27
        long r3 = r1;
        if (Zstd.isError(r3) == true) goto L22;
        ((FilterOutputStream) this).out.write(this.dst, 0, (int) this.dstPos);     // Catch: Throwable -> L27
        if (r1 > 0) goto L16;
    L22:
        throw new IOException("Compression error: " + Zstd.getErrorName(r3));     // Catch: Throwable -> L27
    L26:
        throw new IOException("Stream closed");     // Catch: Throwable -> L27
    }

    public synchronized ZstdOutputStreamNoFinalizer setChecksum(boolean r5) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.frameClosed == false) goto L12;
        long r0 = ZstdCompress.setCompressionChecksums(this.stream, r5);     // Catch: Throwable -> L13
        if (Zstd.isError(r0) == true) goto L10;
        monitor-exit(this);
        return this;
    L10:
        throw new IOException("Compression param: " + Zstd.getErrorName(r0));     // Catch: Throwable -> L13
    L12:
        throw new IOException("Change of parameter on initialized stream");     // Catch: Throwable -> L13
    }

    public synchronized ZstdOutputStreamNoFinalizer setCloseFrameOnFlush(boolean r2) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.frameClosed == false) goto L9;
        this.closeFrameOnFlush = r2;     // Catch: Throwable -> L10
        monitor-exit(this);
        return this;
    L9:
        throw new IOException("Change of parameter on initialized stream");     // Catch: Throwable -> L10
    }

    public synchronized ZstdOutputStreamNoFinalizer setDict(ZstdDictCompress r5) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.frameClosed == false) goto L12;
        long r0 = ZstdCompress.loadFastDictCompress(this.stream, r5);     // Catch: Throwable -> L13
        if (Zstd.isError(r0) == true) goto L10;
        monitor-exit(this);
        return this;
    L10:
        throw new IOException("Compression param: " + Zstd.getErrorName(r0));     // Catch: Throwable -> L13
    L12:
        throw new IOException("Change of parameter on initialized stream");     // Catch: Throwable -> L13
    }

    public synchronized ZstdOutputStreamNoFinalizer setDict(byte[] r5) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.frameClosed == false) goto L12;
        long r0 = ZstdCompress.loadDictCompress(this.stream, r5, r5.length);     // Catch: Throwable -> L13
        if (Zstd.isError(r0) == true) goto L10;
        monitor-exit(this);
        return this;
    L10:
        throw new IOException("Compression param: " + Zstd.getErrorName(r0));     // Catch: Throwable -> L13
    L12:
        throw new IOException("Change of parameter on initialized stream");     // Catch: Throwable -> L13
    }

    public synchronized ZstdOutputStreamNoFinalizer setLevel(int r5) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.frameClosed == false) goto L12;
        long r0 = ZstdCompress.setCompressionLevel(this.stream, r5);     // Catch: Throwable -> L13
        if (Zstd.isError(r0) == true) goto L10;
        monitor-exit(this);
        return this;
    L10:
        throw new IOException("Compression param: " + Zstd.getErrorName(r0));     // Catch: Throwable -> L13
    L12:
        throw new IOException("Change of parameter on initialized stream");     // Catch: Throwable -> L13
    }

    public synchronized ZstdOutputStreamNoFinalizer setLong(int r5) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.frameClosed == false) goto L12;
        long r0 = ZstdCompress.setCompressionLong(this.stream, r5);     // Catch: Throwable -> L13
        if (Zstd.isError(r0) == true) goto L10;
        monitor-exit(this);
        return this;
    L10:
        throw new IOException("Compression param: " + Zstd.getErrorName(r0));     // Catch: Throwable -> L13
    L12:
        throw new IOException("Change of parameter on initialized stream");     // Catch: Throwable -> L13
    }

    public synchronized ZstdOutputStreamNoFinalizer setWorkers(int r5) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.frameClosed == false) goto L12;
        long r0 = ZstdCompress.setCompressionWorkers(this.stream, r5);     // Catch: Throwable -> L13
        if (Zstd.isError(r0) == true) goto L10;
        monitor-exit(this);
        return this;
    L10:
        throw new IOException("Compression param: " + Zstd.getErrorName(r0));     // Catch: Throwable -> L13
    L12:
        throw new IOException("Change of parameter on initialized stream");     // Catch: Throwable -> L13
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int r4) {
        write(new byte[]{(byte) r4}, 0, 1);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public synchronized void write(byte[] r10, int r11, int r12) {
        monitor-enter(this);
    L26:
        th = move-exception;
        throw th;
    L4:
        if (this.isClosed == true) goto L25;
        if (this.frameClosed == false) goto L12;
        long r2 = resetCStream(this.stream);     // Catch: Throwable -> L26
        if (Zstd.isError(r2) == true) goto L11;
        this.frameClosed = false;     // Catch: Throwable -> L26
        goto L12
    L11:
        throw new IOException("Compression error: cannot create header: " + Zstd.getErrorName(r2));     // Catch: Throwable -> L26
    L12:
        int r13 = r12 + r11;     // Catch: Throwable -> L26
        this.srcPos = r11;     // Catch: Throwable -> L26
    L14:
        if (this.srcPos >= r13) goto L22;
        long r3 = compressStream(this.stream, this.dst, dstSize, r10, r13);     // Catch: Throwable -> L26
        if (Zstd.isError(r3) == true) goto L21;
        long r4 = this.dstPos;     // Catch: Throwable -> L26
        if (r4 <= 0) goto L14;
        ((FilterOutputStream) this).out.write(this.dst, 0, (int) r4);     // Catch: Throwable -> L26
        goto L14
    L21:
        throw new IOException("Compression error: " + Zstd.getErrorName(r3));     // Catch: Throwable -> L26
    L22:
        monitor-exit(this);
        return;
    L25:
        throw new IOException("Stream closed");     // Catch: Throwable -> L26
    }
}
