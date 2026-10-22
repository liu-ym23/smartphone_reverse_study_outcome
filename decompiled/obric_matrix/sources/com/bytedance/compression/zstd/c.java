package com.bytedance.compression.zstd;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f3825a = null;

    static {
        f3825a = new c();
    }

    private c() {
    }

    @Override // com.bytedance.compression.zstd.b
    public void a(ByteBuffer r1) {
    }

    @Override // com.bytedance.compression.zstd.b
    public ByteBuffer get(int r1) {
        return ByteBuffer.allocate(r1);
    }
}
