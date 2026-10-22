package com.bytedance.compression.zstd;

import com.bytedance.compression.zstd.util.Native;

/* JADX INFO: loaded from: classes3.dex */
public class ZstdCompress {
    static native long compressBound(long r0);

    public static native int defaultCompressionLevel();

    static native int loadDictCompress(long r0, byte[] r2, int r3);

    static native int loadFastDictCompress(long r0, ZstdDictCompress r2);

    public static native int maxCompressionLevel();

    public static native int minCompressionLevel();

    static native int setCompressionChecksums(long r0, boolean r2);

    static native int setCompressionLevel(long r0, int r2);

    static native int setCompressionLong(long r0, int r2);

    static native int setCompressionWorkers(long r0, int r2);

    public ZstdCompress() {
    }

    static {
        Native.load();
    }

    public static byte[] compress(byte[] r1) throws ZstdException {
        return compress(r1, defaultCompressionLevel());
    }

    public static byte[] compress(byte[] r1, int r2) throws ZstdException {
        ZstdCompressCtx r0 = new ZstdCompressCtx();
        r0.setLevel(r2);     // Catch: Throwable -> L6
        byte[] r3 = r0.compress(r1);     // Catch: Throwable -> L6
        r0.close();
        return r3;
    L6:
        th = move-exception;
        r0.close();
        throw th;
    }

    public static byte[] compress(byte[] r1, ZstdDictCompress r2) throws ZstdException {
        ZstdCompressCtx r0 = new ZstdCompressCtx();
        r0.loadDict(r2);     // Catch: Throwable -> L6
        r0.setLevel(r2.level());     // Catch: Throwable -> L6
        byte[] r3 = r0.compress(r1);     // Catch: Throwable -> L6
        r0.close();
        return r3;
    L6:
        th = move-exception;
        r0.close();
        throw th;
    }

    public static byte[] compress(byte[] r1, byte[] r2, int r3) throws ZstdException {
        ZstdCompressCtx r0 = new ZstdCompressCtx();
        r0.loadDict(r2);     // Catch: Throwable -> L6
        r0.setLevel(r3);     // Catch: Throwable -> L6
        byte[] r4 = r0.compress(r1);     // Catch: Throwable -> L6
        r0.close();
        return r4;
    L6:
        th = move-exception;
        r0.close();
        throw th;
    }
}
