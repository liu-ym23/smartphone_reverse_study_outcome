package com.bytedance.retrofit2.ttnet;

import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Request;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public interface IHttpCallThrottleControl {
    boolean maybeDropRequestOrAsyncDelay(Request r1, RetrofitMetrics r2, Executor r3, Runnable r4) throws Exception;

    void maybeDropRequestOrBlockingDelay(Request r1, RetrofitMetrics r2) throws Exception;

    void notifyRequestCompleted(Request r1);

    default Request setOriginalRequestProperties(Request r1) {
        return r1;
    }
}
