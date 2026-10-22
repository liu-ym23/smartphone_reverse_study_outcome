package com.bytedance.frameworks.baselib.network.dispatcher;

import android.os.Process;
import com.android.settings.utils.HanziToPinyin;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: loaded from: classes3.dex */
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
    L41:
        IRequest r1 = this.mLocalQueue.take();     // Catch: InterruptedException -> L36
        if ((r1 instanceof ApiThread) == false) goto L7;
        ApiThread r2 = (ApiThread) r1;
    L8:
        if (r2 == null) goto L41;
        String r3 = Thread.currentThread().getName();
        String r4 = r2.getName();
        if (r2.isCanceled() == true) goto L41;
        if (StringUtils.isEmpty(r4) == true) goto L20;
        if (StringUtils.isEmpty(r3) == true) goto L20;
        Thread.currentThread().setName("ApiLocalDispatcher-" + r4);     // Catch: Throwable -> L29
    L20:
        if (Logger.debug() == false) goto L23;
        Logger.d(TAG, "run4Local " + r4 + ", queue size: " + this.mLocalQueue.size() + HanziToPinyin.Token.SEPARATOR + this.mNetworkQueue.size());     // Catch: Throwable -> L29
    L23:
        if (r2.run4Local() == true) goto L32;
        if (r2.getPriority() != IRequest.Priority.IMMEDIATE) goto L27;
        ThreadPlus.submitRunnable(r2);     // Catch: Throwable -> L29
        goto L32
    L27:
        this.mNetworkQueue.add(r2);     // Catch: Throwable -> L29
    L32:
        if (StringUtils.isEmpty(r4) == true) goto L41;
        if (StringUtils.isEmpty(r3) == true) goto L41;
        Thread.currentThread().setName(r3);
    L29:
        th = move-exception;
        Logger.e(TAG, "Unhandled exception: " + th);
        goto L32
    L7:
        r2 = null;
    L37:
        if (this.mQuit == false) goto L41;
    }
}
