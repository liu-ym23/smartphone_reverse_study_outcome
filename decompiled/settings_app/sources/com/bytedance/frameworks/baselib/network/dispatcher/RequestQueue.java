package com.bytedance.frameworks.baselib.network.dispatcher;

/* JADX INFO: loaded from: classes3.dex */
public class RequestQueue implements IRequestQueue {
    private static final int DEFAULT_DOWNLOAD_THREAD_POOL_SIZE = 8;
    private static final int DEFAULT_NETWORK_THREAD_POOL_SIZE = 8;
    private static volatile boolean sDynamicAdjustThreadPoolSizeOpen = true;
    private static volatile RequestQueue sRequestQueue;
    private static volatile ThreadPoolConfig sThreadConfig;

    static {
    }

    public static synchronized void setDynamicAdjustThreadPoolSizeOpen(boolean r2) {
        monitor-enter(RequestQueue.class);
        sDynamicAdjustThreadPoolSizeOpen = r2;     // Catch: Throwable -> L9
        if (sThreadConfig == null) goto L7;
        sThreadConfig.setDynamicAdjust(sDynamicAdjustThreadPoolSizeOpen);     // Catch: Throwable -> L9
    L7:
        monitor-exit(RequestQueue.class);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public static synchronized void setThreadPoolConfig(ThreadPoolConfig r2) {
        monitor-enter(RequestQueue.class);
        sThreadConfig = r2;     // Catch: Throwable -> L7
        sThreadConfig.setDynamicAdjust(sDynamicAdjustThreadPoolSizeOpen);     // Catch: Throwable -> L7
        monitor-exit(RequestQueue.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized ThreadPoolConfig getThreadPoolConfig() {
        monitor-enter(RequestQueue.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sThreadConfig != null) goto L7;
        sThreadConfig = ThreadPoolConfig.newBuilder().setApiThreadSize(8, 8).setDownloadThreadSize(8, 8).setApiAliveTime(30).setImmediateAliveTime(10).setDownloadAliveTime(10).setDynamicAdjust(true).build();     // Catch: Throwable -> L10
    L7:
        ThreadPoolConfig r1 = sThreadConfig;     // Catch: Throwable -> L10
        monitor-exit(RequestQueue.class);
        return r1;
    }

    public static boolean isDynamicAdjustThredPool() {
        return sDynamicAdjustThreadPoolSizeOpen;
    }

    @Deprecated
    public static RequestQueue getDefaultRequestQueue() {
        if (sRequestQueue != null) goto L15;
        monitor-enter(RequestQueue.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sRequestQueue != null) goto L9;
        sRequestQueue = new RequestQueue();     // Catch: Throwable -> L11
    L9:
        monitor-exit(RequestQueue.class);     // Catch: Throwable -> L11
    L15:
        return sRequestQueue;
    }

    public RequestQueue() {
        this(8, 8);
    }

    @Deprecated
    public RequestQueue(int r1, int r2) {
        if (sThreadConfig != null) goto L6;
        sThreadConfig = ThreadPoolConfig.newBuilder().setApiThreadSize(8, 8).setDownloadThreadSize(8, 8).setApiAliveTime(30).setImmediateAliveTime(10).setDownloadAliveTime(10).setDynamicAdjust(true).build();
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.dispatcher.IRequestQueue
    public synchronized void addDownload(IApiTask r2) {
        monitor-enter(this);
        if (r2 != null) goto L11;
    L9:
        monitor-exit(this);
        return;
    L11:
        NetThreadPoolManager.INSTANCE.executeDownload(r2);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.frameworks.baselib.network.dispatcher.IRequestQueue
    public synchronized void addDownload(ApiThread r2) {
        monitor-enter(this);
        if (r2 != null) goto L11;
    L9:
        monitor-exit(this);
        return;
    L11:
        NetThreadPoolManager.INSTANCE.executeDownload(r2);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.frameworks.baselib.network.dispatcher.IRequestQueue
    public synchronized void add(IApiTask r2) {
        monitor-enter(this);
        if (r2 != null) goto L11;
    L9:
        monitor-exit(this);
        return;
    L11:
        NetThreadPoolManager.INSTANCE.executeApi(r2);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.frameworks.baselib.network.dispatcher.IRequestQueue
    public synchronized void add(ApiThread r2) {
        monitor-enter(this);
        if (r2 != null) goto L11;
    L9:
        monitor-exit(this);
        return;
    L11:
        NetThreadPoolManager.INSTANCE.executeApi(r2);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }
}
