package com.bytedance.frameworks.baselib.network.dispatcher;

import android.os.Process;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: loaded from: classes.dex */
class ApiLocalDispatcher extends Thread {
    private static final String TAG = "ApiLocalDispatcher";
    private final BlockingQueue<IRequest> mLocalQueue;
    private final BlockingQueue<IRequest> mNetworkQueue;
    private volatile boolean mQuit;

    public ApiLocalDispatcher(BlockingQueue<IRequest> r2, BlockingQueue<IRequest> r3) {
        super("ApiLocalDispatcher-Thread");
        this.mQuit = false;
        this.mLocalQueue = r2;
        this.mNetworkQueue = r3;
    }

    public void quit() {
        this.mQuit = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
    L42:
        IRequest r1 = this.mLocalQueue.take();     // Catch: InterruptedException -> L37
        if ((r1 instanceof ApiThread) == false) goto L7;
        ApiThread r2 = (ApiThread) r1;
    L8:
        if (r2 == null) goto L42;
        String r3 = Thread.currentThread().getName();
        String r4 = r2.getName();
        if (r2.isCanceled() == true) goto L42;
        if (StringUtils.isEmpty(r4) == true) goto L22;
        if (StringUtils.isEmpty(r3) == true) goto L22;
        Thread.currentThread().setName("ApiLocalDispatcher-" + r4);     // Catch: Throwable -> L19
    L22:
        if (Logger.debug() == false) goto L25;
        Logger.d(TAG, "run4Local " + r4 + ", queue size: " + this.mLocalQueue.size() + " " + this.mNetworkQueue.size());     // Catch: Throwable -> L19
    L25:
        if (r2.run4Local() == true) goto L33;
        if (r2.getPriority() != IRequest.Priority.IMMEDIATE) goto L29;
        ThreadPlus.submitRunnable(r2);     // Catch: Throwable -> L19
        goto L33
    L29:
        this.mNetworkQueue.add(r2);     // Catch: Throwable -> L19
    L33:
        if (StringUtils.isEmpty(r4) == true) goto L42;
        if (StringUtils.isEmpty(r3) == true) goto L42;
        Thread.currentThread().setName(r3);
    L19:
        th = move-exception;
        Logger.e(TAG, "Unhandled exception: " + th);
        goto L33
    L7:
        r2 = null;
    L38:
        if (this.mQuit == false) goto L42;
    }
}
