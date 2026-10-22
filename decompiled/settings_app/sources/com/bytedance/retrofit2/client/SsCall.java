package com.bytedance.retrofit2.client;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public interface SsCall {
    void cancel();

    Response execute() throws IOException;

    Request getRequest();

    boolean setThrottleNetSpeed(long r1);
}
