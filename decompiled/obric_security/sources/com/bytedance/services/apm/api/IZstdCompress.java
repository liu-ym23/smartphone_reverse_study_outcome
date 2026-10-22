package com.bytedance.services.apm.api;

/* JADX INFO: loaded from: classes.dex */
public interface IZstdCompress {
    byte[] compress(byte[] r1, int r2);

    byte[] compress(byte[] r1, IZstdDict r2, int r3);

    byte[] compress(byte[] r1, byte[] r2, int r3);
}
