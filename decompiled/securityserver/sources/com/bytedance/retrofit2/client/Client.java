package com.bytedance.retrofit2.client;

/* JADX INFO: loaded from: classes.dex */
public interface Client {

    public interface Provider {
        Client get();
    }

    SsCall newSsCall(Request r1);
}
