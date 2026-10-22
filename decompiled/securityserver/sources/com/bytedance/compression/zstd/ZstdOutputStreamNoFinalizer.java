package com.bytedance.compression.zstd;

import a.a;
import com.bytedance.compression.zstd.util.Native;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
class ZstdOutputStreamNoFinalizer extends FilterOutputStream {
    private static final int dstSize = 0;
    private final BufferPool bufferPool;
    private boolean closeFrameOnFlush;
    private final byte[] dst;
    private final ByteBuffer dstByteBuffer;
    private long dstPos;
    private boolean frameClosed;
    private boolean isClosed;
    private long srcPos;
    private final long stream;

    static {
        Native.a();
        dstSize = (int) recommendedCOutSize();
    }

    public ZstdOutputStreamNoFinalizer(OutputStream r2, int r3) {
        this(r2, NoPool.f4a);
        ZstdCompress.setCompressionLevel(this.stream, r3);
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
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.isClosed == true) goto L28;
        if (this.frameClosed == false) goto L8;
    L25:
        monitor-exit(this);
        return;
    L8:
        if (this.closeFrameOnFlush == false) goto L18;
    L9:
        int r0 = endStream(this.stream, this.dst, dstSize);     // Catch: Throwable -> L14
        long r2 = r0;
        if (Zstd.isError(r2) == true) goto L17;
        ((FilterOutputStream) this).out.write(this.dst, 0, (int) this.dstPos);     // Catch: Throwable -> L14
        if (r0 > 0) goto L9;
        this.frameClosed = true;     // Catch: Throwable -> L14
    L22:
        ((FilterOutputStream) this).out.flush();     // Catch: Throwable -> L14
        goto L25
    L17:
        throw new IOException("Compression error: " + Zstd.getErrorName(r2));     // Catch: Throwable -> L14
    L18:
        int r1 = flushStream(this.stream, this.dst, dstSize);     // Catch: Throwable -> L14
        long r3 = r1;
        if (Zstd.isError(r3) == true) goto L24;
        ((FilterOutputStream) this).out.write(this.dst, 0, (int) this.dstPos);     // Catch: Throwable -> L14
        if (r1 > 0) goto L18;
    L24:
        throw new IOException("Compression error: " + Zstd.getErrorName(r3));     // Catch: Throwable -> L14
    L28:
        throw new IOException("Stream closed");     // Catch: Throwable -> L14
    }

    public synchronized ZstdOutputStreamNoFinalizer setChecksum(boolean r5) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.frameClosed == false) goto L15;
        long r1 = ZstdCompress.setCompressionChecksums(this.stream, r5);     // Catch: Throwable -> L12
        if (Zstd.isError(r1) == true) goto L11;
        monitor-exit(this);
        return this;
    L11:
        throw new IOException("Compression param: " + Zstd.getErrorName(r1));     // Catch: Throwable -> L12
    L15:
        throw new IOException("Change of parameter on initialized stream");     // Catch: Throwable -> L12
    }

    public synchronized ZstdOutputStreamNoFinalizer setCloseFrameOnFlush(boolean r2) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.frameClosed == false) goto L11;
        this.closeFrameOnFlush = r2;     // Catch: Throwable -> L8
        monitor-exit(this);
        return this;
    L11:
        throw new IOException("Change of parameter on initialized stream");     // Catch: Throwable -> L8
    }

    public synchronized ZstdOutputStreamNoFinalizer setDict(byte[] r5) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.frameClosed == false) goto L15;
        long r1 = ZstdCompress.loadDictCompress(this.stream, r5, r5.length);     // Catch: Throwable -> L12
        if (Zstd.isError(r1) == true) goto L11;
        monitor-exit(this);
        return this;
    L11:
        throw new IOException("Compression param: " + Zstd.getErrorName(r1));     // Catch: Throwable -> L12
    L15:
        throw new IOException("Change of parameter on initialized stream");     // Catch: Throwable -> L12
    }

    public synchronized ZstdOutputStreamNoFinalizer setLevel(int r5) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.frameClosed == false) goto L15;
        long r1 = ZstdCompress.setCompressionLevel(this.stream, r5);     // Catch: Throwable -> L12
        if (Zstd.isError(r1) == true) goto L11;
        monitor-exit(this);
        return this;
    L11:
        throw new IOException("Compression param: " + Zstd.getErrorName(r1));     // Catch: Throwable -> L12
    L15:
        throw new IOException("Change of parameter on initialized stream");     // Catch: Throwable -> L12
    }

    public synchronized ZstdOutputStreamNoFinalizer setLong(int r5) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.frameClosed == false) goto L15;
        long r1 = ZstdCompress.setCompressionLong(this.stream, r5);     // Catch: Throwable -> L12
        if (Zstd.isError(r1) == true) goto L11;
        monitor-exit(this);
        return this;
    L11:
        throw new IOException("Compression param: " + Zstd.getErrorName(r1));     // Catch: Throwable -> L12
    L15:
        throw new IOException("Change of parameter on initialized stream");     // Catch: Throwable -> L12
    }

    public synchronized ZstdOutputStreamNoFinalizer setWorkers(int r5) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.frameClosed == false) goto L15;
        long r1 = ZstdCompress.setCompressionWorkers(this.stream, r5);     // Catch: Throwable -> L12
        if (Zstd.isError(r1) == true) goto L11;
        monitor-exit(this);
        return this;
    L11:
        throw new IOException("Compression param: " + Zstd.getErrorName(r1));     // Catch: Throwable -> L12
    L15:
        throw new IOException("Change of parameter on initialized stream");     // Catch: Throwable -> L12
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public synchronized void write(byte[] r11, int r12, int r13) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.isClosed == true) goto L28;
        if (this.frameClosed == false) goto L15;
        long r3 = resetCStream(this.stream);     // Catch: Throwable -> L11
        if (Zstd.isError(r3) == true) goto L14;
        this.frameClosed = false;     // Catch: Throwable -> L11
        goto L15
    L14:
        throw new IOException("Compression error: cannot create header: " + Zstd.getErrorName(r3));     // Catch: Throwable -> L11
    L15:
        int r14 = r13 + r12;     // Catch: Throwable -> L11
        this.srcPos = r12;     // Catch: Throwable -> L11
    L17:
        if (this.srcPos >= r14) goto L25;
        long r0 = compressStream(this.stream, this.dst, dstSize, r11, r14);     // Catch: Throwable -> L11
        if (Zstd.isError(r0) == true) goto L24;
        long r1 = this.dstPos;     // Catch: Throwable -> L11
        if (r1 <= 0) goto L17;
        ((FilterOutputStream) this).out.write(this.dst, 0, (int) r1);     // Catch: Throwable -> L11
        goto L17
    L24:
        throw new IOException("Compression error: " + Zstd.getErrorName(r0));     // Catch: Throwable -> L11
    L25:
        monitor-exit(this);
        return;
    L28:
        throw new IOException("Stream closed");     // Catch: Throwable -> L11
    }

    public ZstdOutputStreamNoFinalizer(OutputStream r2) {
        this(r2, NoPool.f4a);
    }

    private void close(boolean r7) {
        if (this.isClosed == false) goto L23;
        return;
    L23:
    L13:
        th = move-exception;
        this.isClosed = true;
        this.bufferPool.getClass();
        freeCStream(this.stream);
        throw th;
    L7:
        if (this.frameClosed == true) goto L17;
    L8:
        int r1 = endStream(this.stream, this.dst, dstSize);     // Catch: Throwable -> L13
        long r2 = r1;
        if (Zstd.isError(r2) == true) goto L16;
        ((FilterOutputStream) this).out.write(this.dst, 0, (int) this.dstPos);     // Catch: Throwable -> L13
        if (r1 > 0) goto L8;
    L16:
        throw new IOException("Compression error: " + Zstd.getErrorName(r2));     // Catch: Throwable -> L13
    L17:
        if (r7 == false) goto L19;
        ((FilterOutputStream) this).out.close();     // Catch: Throwable -> L13
    L19:
        this.isClosed = true;
        this.bufferPool.getClass();
        freeCStream(this.stream);
    }

    public ZstdOutputStreamNoFinalizer(OutputStream r1, BufferPool r2, int r3) {
        this(r1, r2);
        ZstdCompress.setCompressionLevel(this.stream, r3);
    }

    public ZstdOutputStreamNoFinalizer(OutputStream r3, BufferPool r4) {
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
        throw new IOException(a.f(r5, "Cannot get ByteBuffer of size ", " from the BufferPool"));
    }

    public synchronized ZstdOutputStreamNoFinalizer setDict(ZstdDictCompress r5) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.frameClosed == false) goto L15;
        long r1 = ZstdCompress.loadFastDictCompress(this.stream, r5);     // Catch: Throwable -> L12
        if (Zstd.isError(r1) == true) goto L11;
        monitor-exit(this);
        return this;
    L11:
        throw new IOException("Compression param: " + Zstd.getErrorName(r1));     // Catch: Throwable -> L12
    L15:
        throw new IOException("Change of parameter on initialized stream");     // Catch: Throwable -> L12
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int r4) {
        write(new byte[]{(byte) r4}, 0, 1);
    }
}
