package com.ss.ttuploader;

/* JADX INFO: loaded from: classes2.dex */
public interface TTExternNetLoader {
    void cancelTask();

    int sendRequest(TTExternRequestInfo r1, TTExternNetLoaderListener r2);
}
