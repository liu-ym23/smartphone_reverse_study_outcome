package com.android.volley;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: loaded from: classes.dex */
public class NetworkDispatcher extends Thread {
    private final Cache mCache;
    private final ResponseDelivery mDelivery;
    private final Network mNetwork;
    private final BlockingQueue<Request<?>> mQueue;
    private volatile boolean mQuit;

    public NetworkDispatcher(BlockingQueue<Request<?>> r2, Network r3, Cache r4, ResponseDelivery r5) {
        this.mQuit = false;
        this.mQueue = r2;
        this.mNetwork = r3;
        this.mCache = r4;
        this.mDelivery = r5;
    }

    public void quit() {
        this.mQuit = true;
        interrupt();
    }

    private void addTrafficStatsTag(Request<?> r1) {
        TrafficStats.setThreadStatsTag(r1.getTrafficStatsTag());
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
    L10:
        processRequest();     // Catch: InterruptedException -> L5
    L6:
        if (this.mQuit == true) goto L7;
        VolleyLog.e("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
        goto L10
    L7:
        Thread.currentThread().interrupt();
    }

    private void processRequest() throws InterruptedException {
        processRequest(this.mQueue.take());
    }

    void processRequest(Request<?> r9) {
        long r0 = SystemClock.elapsedRealtime();
        r9.sendEvent(3);
        r9.addMarker("network-queue-take");     // Catch: Throwable -> L22 Exception -> L24 VolleyError -> L26
        if (r9.isCanceled() == false) goto L8;
        r9.finish("network-discard-cancelled");     // Catch: Throwable -> L22 Exception -> L24 VolleyError -> L26
        r9.notifyListenerResponseNotUsable();     // Catch: Throwable -> L22 Exception -> L24 VolleyError -> L26
        r9.sendEvent(4);
        return;
    L8:
        addTrafficStatsTag(r9);     // Catch: Throwable -> L22 Exception -> L24 VolleyError -> L26
        NetworkResponse r3 = this.mNetwork.performRequest(r9);     // Catch: Throwable -> L22 Exception -> L24 VolleyError -> L26
        r9.addMarker("network-http-complete");     // Catch: Throwable -> L22 Exception -> L24 VolleyError -> L26
        if (r3.notModified == true) goto L11;
    L15:
        Response<?> r4 = r9.parseNetworkResponse(r3);     // Catch: Throwable -> L22 Exception -> L24 VolleyError -> L26
        r9.addMarker("network-parse-complete");     // Catch: Throwable -> L22 Exception -> L24 VolleyError -> L26
        if (r9.shouldCache() == true) goto L18;
    L20:
        r9.markDelivered();     // Catch: Throwable -> L22 Exception -> L24 VolleyError -> L26
        this.mDelivery.postResponse(r9, r4);     // Catch: Throwable -> L22 Exception -> L24 VolleyError -> L26
        r9.notifyListenerResponseReceived(r4);     // Catch: Throwable -> L22 Exception -> L24 VolleyError -> L26
    L28:
        r9.sendEvent(4);
        return;
    L18:
        if (r4.cacheEntry == null) goto L20;
        this.mCache.put(r9.getCacheKey(), r4.cacheEntry);     // Catch: Throwable -> L22 Exception -> L24 VolleyError -> L26
        r9.addMarker("network-cache-written");     // Catch: Throwable -> L22 Exception -> L24 VolleyError -> L26
        goto L20
    L11:
        if (r9.hasHadResponseDelivered() == false) goto L15;
        r9.finish("not-modified");     // Catch: Throwable -> L22 Exception -> L24 VolleyError -> L26
        r9.notifyListenerResponseNotUsable();     // Catch: Throwable -> L22 Exception -> L24 VolleyError -> L26
        r9.sendEvent(4);
        return;
    L22:
        th = move-exception;
        r9.sendEvent(4);
        throw th;
    L26:
        e = move-exception;
        e.setNetworkTimeMs(SystemClock.elapsedRealtime() - r0);     // Catch: Throwable -> L22
        parseAndDeliverNetworkError(r9, e);     // Catch: Throwable -> L22
        r9.notifyListenerResponseNotUsable();     // Catch: Throwable -> L22
    L24:
        e = move-exception;
        VolleyLog.e(e, "Unhandled exception %s", new Object[]{e.toString()});     // Catch: Throwable -> L22
        VolleyError r5 = new VolleyError(e);     // Catch: Throwable -> L22
        r5.setNetworkTimeMs(SystemClock.elapsedRealtime() - r0);     // Catch: Throwable -> L22
        this.mDelivery.postError(r9, r5);     // Catch: Throwable -> L22
        r9.notifyListenerResponseNotUsable();     // Catch: Throwable -> L22
        goto L28
    }

    private void parseAndDeliverNetworkError(Request<?> r1, VolleyError r2) {
        VolleyError r3 = r1.parseNetworkError(r2);
        this.mDelivery.postError(r1, r3);
    }
}
