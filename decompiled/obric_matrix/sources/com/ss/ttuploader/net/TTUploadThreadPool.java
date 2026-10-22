package com.ss.ttuploader.net;

import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class TTUploadThreadPool {
    private static final String TAG = "TTUploadThreadPool";
    private static final int THREADPOOL_ALIVE_TIME_SEC = 300;
    private static final int THREADPOOL_CORE_POOL_SIZE = 3;
    private static final int THREADPOOL_MAX_POOL_SIZE = Integer.MAX_VALUE;
    private static volatile ThreadPoolExecutor mExecutorInstance;

    public TTUploadThreadPool() {
    }

    public static Future addExecuteTask(Runnable r1) {
        if (mExecutorInstance != null) goto L6;
        getExecutorInstance();
    L6:
        return mExecutorInstance.submit(r1);
    }

    public static ThreadPoolExecutor getExecutorInstance() {
        if (mExecutorInstance != null) goto L15;
        monitor-enter(TTUploadThreadPool.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mExecutorInstance != null) goto L9;
        mExecutorInstance = new ThreadPoolExecutor(3, Integer.MAX_VALUE, 300, TimeUnit.SECONDS, new SynchronousQueue());     // Catch: Throwable -> L11
    L9:
        monitor-exit(TTUploadThreadPool.class);     // Catch: Throwable -> L11
    L15:
        return mExecutorInstance;
    }

    public static int getPoolSize() {
        if (mExecutorInstance != null) goto L6;
        getExecutorInstance();
    L6:
        return mExecutorInstance.getPoolSize();
    }

    public static void shutdown() {
        if (mExecutorInstance == null) goto L6;
        mExecutorInstance.shutdown();
        return;
    }
}
