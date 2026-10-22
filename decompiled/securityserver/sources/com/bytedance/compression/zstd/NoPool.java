package com.bytedance.compression.zstd;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class NoPool implements BufferPool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final NoPool f4a = null;

    static {
        f4a = new NoPool();
    }

    @Override // com.bytedance.compression.zstd.BufferPool
    public final ByteBuffer get(int r1) {
        return ByteBuffer.allocate(r1);
    }
}
