package com.bytedance.compression.zstd;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public interface BufferPool {
    ByteBuffer get(int r1);
}
