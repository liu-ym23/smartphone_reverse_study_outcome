package com.bytedance.compression.zstd;

import com.bytedance.compression.zstd.util.Native;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class ZstdCompressCtx extends AutoCloseBase {
    private ZstdDictCompress compression_dict;
    private long nativePtr;

    static {
        Native.a();
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

    private native long compressByteArray0(byte[] r1, int r2, int r3, byte[] r4, int r5, int r6);

    private void ensureOpen() {
        if (this.nativePtr == 0) goto L6;
        return;
    L6:
        throw new IllegalStateException("Compression context is closed");
    }

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

    public int compress(byte[] r8, byte[] r9) {
        return compressByteArray(r8, 0, r8.length, r9, 0, r9.length);
    }

    public int compressByteArray(byte[] r5, int r6, int r7, byte[] r8, int r9, int r10) {
        if (this.nativePtr == 0) goto L20;
        acquireSharedLock();
        long r11 = compressByteArray0(r5, r6, r7, r8, r9, r10);     // Catch: Throwable -> L13
        if (Zstd.isError(r11) == true) goto L16;
        if (r11 > 2147483647L) goto L11;
        int r12 = (int) r11;
        releaseSharedLock();
        return r12;
    L11:
        Zstd.errGeneric();     // Catch: Throwable -> L13
        throw new ZstdException("Output size is greater than MAX_INT");     // Catch: Throwable -> L13
    L16:
        throw new ZstdException(r11);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        releaseSharedLock();
        throw th;
    L20:
        throw new IllegalStateException("Compression context is closed");
    }

    @Override // com.bytedance.compression.zstd.AutoCloseBase
    public void doClose() {
        if (this.nativePtr == 0) goto L6;
        free();
        this.nativePtr = 0;
        return;
    }

    public ZstdCompressCtx loadDict(ZstdDictCompress r5) {
        if (this.nativePtr == 0) goto L17;
        acquireSharedLock();
        r5.acquireSharedLock();
        long r0 = loadCDictFast0(r5);     // Catch: Throwable -> L10
        if (Zstd.isError(r0) == true) goto L13;
        this.compression_dict = r5;     // Catch: Throwable -> L10
        r5.releaseSharedLock();
        releaseSharedLock();
        return this;
    L13:
        throw new ZstdException(r0);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        r5.releaseSharedLock();
        releaseSharedLock();
        throw th;
    L17:
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

    public ZstdCompressCtx setChecksum(boolean r5) {
        if (this.nativePtr == 0) goto L7;
        acquireSharedLock();
        setChecksum0(r5);
        releaseSharedLock();
        return this;
    L7:
        throw new IllegalStateException("Compression context is closed");
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

    public ZstdCompressCtx setLevel(int r5) {
        if (this.nativePtr == 0) goto L7;
        acquireSharedLock();
        setLevel0(r5);
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

    public void setPledgedSrcSize(long r1) {
        ensureOpen();
        long r0 = setPledgedSrcSize0(r1);
        if (Zstd.isError(r0) == true) goto L6;
        return;
    L6:
        throw new ZstdException(r0);
    }

    public ZstdCompressCtx setWorkers(int r3) {
        acquireSharedLock();
        ZstdCompress.setCompressionWorkers(this.nativePtr, r3);
        releaseSharedLock();
        return this;
    }

    public byte[] compress(byte[] r11) {
        long r0 = ZstdCompress.compressBound(r11.length);
        if (r0 > 2147483647L) goto L6;
        int r6 = (int) r0;
        byte[] r1 = new byte[r6];
        return Arrays.copyOfRange(r1, 0, compressByteArray(r1, 0, r6, r11, 0, r11.length));
    L6:
        Zstd.errGeneric();
        throw new ZstdException("Max output size is greater than MAX_INT");
    }

    public ZstdCompressCtx loadDict(byte[] r5) {
        if (this.nativePtr == 0) goto L17;
        acquireSharedLock();
        long r0 = loadCDict0(r5);     // Catch: Throwable -> L10
        if (Zstd.isError(r0) == true) goto L13;
        this.compression_dict = null;     // Catch: Throwable -> L10
        releaseSharedLock();
        return this;
    L13:
        throw new ZstdException(r0);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        releaseSharedLock();
        throw th;
    L17:
        throw new IllegalStateException("Compression context is closed");
    }
}
