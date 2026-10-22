package com.bytedance.compression.zstd;

import com.bytedance.compression.zstd.util.Native;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class ZstdCompressCtx extends AutoCloseBase {
    private ZstdDictCompress compression_dict;
    private long nativePtr;

    private native long compressByteArray0(byte[] r1, int r2, int r3, byte[] r4, int r5, int r6);

    private native void free();

    private native void init();

    private native long loadCDict0(byte[] r1);

    private native long loadCDictFast0(ZstdDictCompress r1);

    private native long reset0();

    private native void setChecksum0(boolean r1);

    private native void setContentSize0(boolean r1);

    private native void setDictID0(boolean r1);

    private native void setLevel0(int r1);

    private native long setPledgedSrcSize0(long r1);

    @Override // com.bytedance.compression.zstd.AutoCloseBase, java.io.Closeable, java.lang.AutoCloseable
    public /* bridge */ /* synthetic */ void close() {
        super.close();
    }

    static {
        Native.load();
    }

    public ZstdCompressCtx() {
        this.nativePtr = 0;
        this.compression_dict = null;
        init();
        if (0 == this.nativePtr) goto L7;
        storeFence();
        return;
    L7:
        throw new IllegalStateException("ZSTD_createCompressCtx failed");
    }

    @Override // com.bytedance.compression.zstd.AutoCloseBase
    void doClose() {
        if (this.nativePtr == 0) goto L6;
        free();
        this.nativePtr = 0;
        return;
    }

    public ZstdCompressCtx setLevel(int r5) {
        if (this.nativePtr == 0) goto L7;
        acquireSharedLock();
        setLevel0(r5);
        releaseSharedLock();
        return this;
    L7:
        throw new IllegalStateException("Compression context is closed");
    }

    public ZstdCompressCtx setChecksum(boolean r5) {
        if (this.nativePtr == 0) goto L7;
        acquireSharedLock();
        setChecksum0(r5);
        releaseSharedLock();
        return this;
    L7:
        throw new IllegalStateException("Compression context is closed");
    }

    public ZstdCompressCtx setWorkers(int r3) {
        acquireSharedLock();
        ZstdCompress.setCompressionWorkers(this.nativePtr, r3);
        releaseSharedLock();
        return this;
    }

    public ZstdCompressCtx setContentSize(boolean r5) {
        if (this.nativePtr == 0) goto L7;
        acquireSharedLock();
        setContentSize0(r5);
        releaseSharedLock();
        return this;
    L7:
        throw new IllegalStateException("Compression context is closed");
    }

    public ZstdCompressCtx setDictID(boolean r5) {
        if (this.nativePtr == 0) goto L7;
        acquireSharedLock();
        setDictID0(r5);
        releaseSharedLock();
        return this;
    L7:
        throw new IllegalStateException("Compression context is closed");
    }

    public ZstdCompressCtx setLong(int r5) {
        if (this.nativePtr == 0) goto L7;
        acquireSharedLock();
        ZstdCompress.setCompressionLong(this.nativePtr, r5);
        releaseSharedLock();
        return this;
    L7:
        throw new IllegalStateException("Compression context is closed");
    }

    public ZstdCompressCtx loadDict(ZstdDictCompress r5) {
        if (this.nativePtr == 0) goto L16;
        acquireSharedLock();
        r5.acquireSharedLock();
        long r0 = loadCDictFast0(r5);     // Catch: Throwable -> L12
        if (Zstd.isError(r0) == true) goto L11;
        this.compression_dict = r5;     // Catch: Throwable -> L12
        r5.releaseSharedLock();
        releaseSharedLock();
        return this;
    L11:
        throw new ZstdException(r0);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        r5.releaseSharedLock();
        releaseSharedLock();
        throw th;
    L16:
        throw new IllegalStateException("Compression context is closed");
    }

    public ZstdCompressCtx loadDict(byte[] r5) {
        if (this.nativePtr == 0) goto L16;
        acquireSharedLock();
        long r0 = loadCDict0(r5);     // Catch: Throwable -> L12
        if (Zstd.isError(r0) == true) goto L11;
        this.compression_dict = null;     // Catch: Throwable -> L12
        releaseSharedLock();
        return this;
    L11:
        throw new ZstdException(r0);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        releaseSharedLock();
        throw th;
    L16:
        throw new IllegalStateException("Compression context is closed");
    }

    private void ensureOpen() {
        if (this.nativePtr == 0) goto L6;
        return;
    L6:
        throw new IllegalStateException("Compression context is closed");
    }

    public void reset() {
        ensureOpen();
        long r0 = reset0();
        if (Zstd.isError(r0) == true) goto L6;
        return;
    L6:
        throw new ZstdException(r0);
    }

    public void setPledgedSrcSize(long r1) {
        ensureOpen();
        long r0 = setPledgedSrcSize0(r1);
        if (Zstd.isError(r0) == true) goto L6;
        return;
    L6:
        throw new ZstdException(r0);
    }

    public int compressByteArray(byte[] r5, int r6, int r7, byte[] r8, int r9, int r10) {
        if (this.nativePtr == 0) goto L19;
        acquireSharedLock();
        long r11 = compressByteArray0(r5, r6, r7, r8, r9, r10);     // Catch: Throwable -> L15
        if (Zstd.isError(r11) == true) goto L14;
        if (r11 > 2147483647L) goto L12;
        int r12 = (int) r11;
        releaseSharedLock();
        return r12;
    L12:
        throw new ZstdException(Zstd.errGeneric(), "Output size is greater than MAX_INT");     // Catch: Throwable -> L15
    L14:
        throw new ZstdException(r11);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        releaseSharedLock();
        throw th;
    L19:
        throw new IllegalStateException("Compression context is closed");
    }

    public int compress(byte[] r8, byte[] r9) {
        return compressByteArray(r8, 0, r8.length, r9, 0, r9.length);
    }

    public byte[] compress(byte[] r11) {
        long r0 = ZstdCompress.compressBound(r11.length);
        if (r0 > 2147483647L) goto L7;
        int r6 = (int) r0;
        byte[] r1 = new byte[r6];
        return Arrays.copyOfRange(r1, 0, compressByteArray(r1, 0, r6, r11, 0, r11.length));
    L7:
        throw new ZstdException(Zstd.errGeneric(), "Max output size is greater than MAX_INT");
    }
}
