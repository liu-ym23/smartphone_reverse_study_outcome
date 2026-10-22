package com.ss.ttuploader;

/* JADX INFO: loaded from: classes2.dex */
public interface TTExternNetLoaderListener {
    void onComplete(TTExternResponseInfo r1);

    void onFailed(String r1, Throwable r2);

    int readFileData(byte[] r1, long r2, int r4);
}
