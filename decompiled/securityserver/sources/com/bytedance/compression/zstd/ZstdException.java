package com.bytedance.compression.zstd;

/* JADX INFO: loaded from: classes.dex */
public class ZstdException extends RuntimeException {
    public ZstdException(long r1) {
        Zstd.getErrorCode(r1);
        super(Zstd.getErrorName(r1));
    }
}
