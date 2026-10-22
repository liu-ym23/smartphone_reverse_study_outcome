package com.bytedance.compression.zstd;

/* JADX INFO: loaded from: classes3.dex */
public class ZstdException extends RuntimeException {
    private long code;

    public ZstdException(long r3) {
        this(Zstd.getErrorCode(r3), Zstd.getErrorName(r3));
    }

    public ZstdException(long r1, String r3) {
        super(r3);
        this.code = r1;
    }

    public long getErrorCode() {
        return this.code;
    }
}
