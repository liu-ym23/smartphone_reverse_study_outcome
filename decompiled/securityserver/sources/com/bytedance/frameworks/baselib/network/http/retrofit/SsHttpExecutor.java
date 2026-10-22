package com.bytedance.frameworks.baselib.network.http.retrofit;

import com.bytedance.frameworks.baselib.network.dispatcher.ApiTask;
import com.bytedance.frameworks.baselib.network.dispatcher.IRequest;
import com.bytedance.frameworks.baselib.network.dispatcher.IRequestQueue;
import com.bytedance.frameworks.baselib.network.dispatcher.RequestQueue;
import com.bytedance.frameworks.baselib.network.dispatcher.ThreadPoolConfig;
import com.bytedance.retrofit2.SsRunnable;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class SsHttpExecutor implements Executor {
    private static volatile IRequestQueue sRequestQueue;

    public SsHttpExecutor() {
    }

    public static void setRequestQueue(RequestQueue r0) {
        sRequestQueue = r0;
    }

    public static void setThreadPoolConfig(ThreadPoolConfig r0) {
        RequestQueue.setThreadPoolConfig(r0);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r9) {
        if (r9 == null) goto L30;
        IRequest.Priority r8 = IRequest.Priority.NORMAL;
        if ((r9 instanceof SsRunnable) == false) goto L21;
        SsRunnable r0 = (SsRunnable) r9;
        int r1 = r0.priority();
        if (r1 != 0) goto L9;
        r8 = IRequest.Priority.LOW;
    L20:
        boolean r2 = r0.isStreaming();
        IRequest.Priority r4 = r8;
        int r5 = r0.getRequestDelayTime();
    L23:
        if (sRequestQueue != null) goto L25;
        sRequestQueue = RequestQueue.getDefaultRequestQueue();
    L25:
        ApiTask r10 = new ApiTask("NetExecutor", r4, r5, r9, r2);
        if (r2 == false) goto L28;
        sRequestQueue.addDownload(r10);
        return;
    L28:
        sRequestQueue.add(r10);
        return;
    L9:
        if (1 == r1) goto L20;
        if (2 != r1) goto L15;
        r8 = IRequest.Priority.HIGH;
        goto L20
    L15:
        if (3 != r1) goto L18;
        r8 = IRequest.Priority.IMMEDIATE;
        goto L20
    L18:
        if ((-1) != r1) goto L20;
        r8 = IRequest.Priority.LOWEST;
        goto L20
    L21:
        r2 = false;
        r4 = r8;
        r5 = 0;
        goto L23
    }
}
