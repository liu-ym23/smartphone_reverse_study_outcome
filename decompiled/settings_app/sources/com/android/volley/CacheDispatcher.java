package com.android.volley;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: loaded from: classes.dex */
public class CacheDispatcher extends Thread {
    private static final boolean DEBUG = false;
    private final Cache mCache;
    private final BlockingQueue<Request<?>> mCacheQueue;
    private final ResponseDelivery mDelivery;
    private final BlockingQueue<Request<?>> mNetworkQueue;
    private volatile boolean mQuit;
    private final WaitingRequestManager mWaitingRequestManager;

    static /* synthetic */ BlockingQueue access$000(CacheDispatcher r0) {
        return r0.mNetworkQueue;
    }

    static {
        DEBUG = VolleyLog.DEBUG;
    }

    public CacheDispatcher(BlockingQueue<Request<?>> r2, BlockingQueue<Request<?>> r3, Cache r4, ResponseDelivery r5) {
        this.mQuit = false;
        this.mCacheQueue = r2;
        this.mNetworkQueue = r3;
        this.mCache = r4;
        this.mDelivery = r5;
        this.mWaitingRequestManager = new WaitingRequestManager(this, r3, r5);
    }

    public void quit() {
        this.mQuit = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (DEBUG == false) goto L5;
        VolleyLog.v("start new dispatcher", new Object[0]);
    L5:
        Process.setThreadPriority(10);
        this.mCache.initialize();
    L13:
        processRequest();     // Catch: InterruptedException -> L8
    L9:
        if (this.mQuit == true) goto L10;
        VolleyLog.e("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
        goto L13
    L10:
        Thread.currentThread().interrupt();
    }

    private void processRequest() throws InterruptedException {
        processRequest(this.mCacheQueue.take());
    }

    void processRequest(final Request<?> r9) throws InterruptedException {
        r9.addMarker("cache-queue-take");
        r9.sendEvent(1);
    L38:
        th = move-exception;
        r9.sendEvent(2);
        throw th;
    L4:
        if (r9.isCanceled() == false) goto L8;
        r9.finish("cache-discard-canceled");     // Catch: Throwable -> L38
        r9.sendEvent(2);
        return;
    L8:
        Cache.Entry r2 = this.mCache.get(r9.getCacheKey());     // Catch: Throwable -> L38
        if (r2 != null) goto L15;
        r9.addMarker("cache-miss");     // Catch: Throwable -> L38
        if (this.mWaitingRequestManager.maybeAddToWaitingRequests(r9) == true) goto L13;
        this.mNetworkQueue.put(r9);     // Catch: Throwable -> L38
    L13:
        r9.sendEvent(2);
        return;
    L15:
        long r3 = System.currentTimeMillis();     // Catch: Throwable -> L38
        if (r2.isExpired(r3) == false) goto L22;
        r9.addMarker("cache-hit-expired");     // Catch: Throwable -> L38
        r9.setCacheEntry(r2);     // Catch: Throwable -> L38
        if (this.mWaitingRequestManager.maybeAddToWaitingRequests(r9) == true) goto L20;
        this.mNetworkQueue.put(r9);     // Catch: Throwable -> L38
    L20:
        r9.sendEvent(2);
        return;
    L22:
        r9.addMarker("cache-hit");     // Catch: Throwable -> L38
        Response<?> r5 = r9.parseNetworkResponse(new NetworkResponse(r2.data, r2.responseHeaders));     // Catch: Throwable -> L38
        r9.addMarker("cache-hit-parsed");     // Catch: Throwable -> L38
        if (r5.isSuccess() == true) goto L30;
        r9.addMarker("cache-parsing-failed");     // Catch: Throwable -> L38
        this.mCache.invalidate(r9.getCacheKey(), true);     // Catch: Throwable -> L38
        r9.setCacheEntry(null);     // Catch: Throwable -> L38
        if (this.mWaitingRequestManager.maybeAddToWaitingRequests(r9) == true) goto L27;
        this.mNetworkQueue.put(r9);     // Catch: Throwable -> L38
    L27:
        r9.sendEvent(2);
        return;
    L30:
        if (r2.refreshNeeded(r3) == true) goto L32;
        this.mDelivery.postResponse(r9, r5);     // Catch: Throwable -> L38
    L36:
        r9.sendEvent(2);
        return;
    L32:
        r9.addMarker("cache-hit-refresh-needed");     // Catch: Throwable -> L38
        r9.setCacheEntry(r2);     // Catch: Throwable -> L38
        r5.intermediate = true;     // Catch: Throwable -> L38
        if (this.mWaitingRequestManager.maybeAddToWaitingRequests(r9) == true) goto L35;
        this.mDelivery.postResponse(r9, r5, new AnonymousClass1(this, r9));     // Catch: Throwable -> L38
        goto L36
    L35:
        this.mDelivery.postResponse(r9, r5);     // Catch: Throwable -> L38
        goto L36
    }
}
