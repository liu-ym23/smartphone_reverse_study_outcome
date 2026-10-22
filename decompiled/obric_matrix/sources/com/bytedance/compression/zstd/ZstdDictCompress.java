package com.bytedance.compression.zstd;

/* JADX INFO: loaded from: classes.dex */
public class ZstdDictCompress extends d {
    private int level;
    private long nativePtr;

    static {
        com.bytedance.compression.zstd.f.a.a();
    }

    public ZstdDictCompress(byte[] r3, int r4) {
        this(r3, 0, r3.length, r4);
    }

    public ZstdDictCompress(byte[] r4, int r5, int r6, int r7) {
        this.nativePtr = 0;
        this.level = ZstdCompress.defaultCompressionLevel();
        this.level = r7;
        if ((r4.length - r5) < 0) goto L11;
        init(r4, r5, r6, r7);
        if (0 == this.nativePtr) goto L9;
        storeFence();
        return;
    L9:
        throw new IllegalStateException("ZSTD_createCDict failed");
    L11:
        throw new IllegalArgumentException("Dictionary buffer is to short");
    }

    private native void free();

    private native void init(byte[] r1, int r2, int r3, int r4);

    @Override // com.bytedance.compression.zstd.a, java.io.Closeable, java.lang.AutoCloseable
    public /* bridge */ /* synthetic */ void close() {
        super.close();
    }

    @Override // com.bytedance.compression.zstd.a
    void doClose() {
        if (this.nativePtr == 0) goto L6;
        free();
        this.nativePtr = 0;
        return;
    }

    int level() {
        return this.level;
    }
}
