package com.bytedance.frameworks.baselib.network.dispatcher;

/* JADX INFO: loaded from: classes.dex */
public class DelayedApiThread extends ApiThread {
    public DelayedApiThread(String r1, IRequest.Priority r2, int r3) {
        super(r1, r2);
        this.mDelayTime = r3;
    }
}
