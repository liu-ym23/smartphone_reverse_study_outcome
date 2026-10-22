package com.bytedance.compression.zstd;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public interface BufferPool {
    ByteBuffer get(int r1);

    void release(ByteBuffer r1);
}
