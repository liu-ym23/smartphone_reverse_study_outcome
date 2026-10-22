package com.bytedance.compression.zstd;

/* JADX INFO: loaded from: classes3.dex */
abstract class SharedDictBase extends AutoCloseBase {
    SharedDictBase() {
    }

    protected void finalize() {
        close();
    }
}
