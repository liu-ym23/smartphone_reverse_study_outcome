package com.bytedance.compression.zstd;

/* JADX INFO: loaded from: classes.dex */
public class e extends RuntimeException {
    public e(long r3) {
        this(Zstd.getErrorCode(r3), Zstd.getErrorName(r3));
    }

    public e(long r1, String r3) {
        super(r3);
    }
}
