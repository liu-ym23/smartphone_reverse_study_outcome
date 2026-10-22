package com.android.volley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: loaded from: classes.dex */
class WaitingRequestManager implements Request.NetworkRequestCompleteListener {
    private final CacheDispatcher mCacheDispatcher;
    private final BlockingQueue<Request<?>> mNetworkQueue;
    private final RequestQueue mRequestQueue;
    private final ResponseDelivery mResponseDelivery;
    private final Map<String, List<Request<?>>> mWaitingRequests;

    WaitingRequestManager(RequestQueue r2) {
        this.mWaitingRequests = new HashMap();
        this.mRequestQueue = r2;
        this.mResponseDelivery = r2.getResponseDelivery();
        this.mCacheDispatcher = null;
        this.mNetworkQueue = null;
    }

    WaitingRequestManager(CacheDispatcher r2, BlockingQueue<Request<?>> r3, ResponseDelivery r4) {
        this.mWaitingRequests = new HashMap();
        this.mRequestQueue = null;
        this.mResponseDelivery = r4;
        this.mCacheDispatcher = r2;
        this.mNetworkQueue = r3;
    }

    @Override // com.android.volley.Request.NetworkRequestCompleteListener
    public void onResponseReceived(Request<?> r6, Response<?> r7) {
        if (r7.cacheEntry != null) goto L5;
    L23:
        onNoUsableResponseReceived(r6);
        return;
    L5:
        if (r7.cacheEntry.isExpired() == true) goto L23;
        String r8 = r6.getCacheKey();
        monitor-enter(this);
        List<Request<?>> r0 = this.mWaitingRequests.remove(r8);     // Catch: Throwable -> L20
        monitor-exit(this);     // Catch: Throwable -> L20
        if (r0 != null) goto L13;
        return;
    L13:
        if (VolleyLog.DEBUG == false) goto L15;
        VolleyLog.v("Releasing %d waiting requests for cacheKey=%s.", new Object[]{Integer.valueOf(r0.size()), r8});
    L15:
        Iterator<Request<?>> r9 = r0.iterator();
    L17:
        if (r9.hasNext() == false) goto L28;
        this.mResponseDelivery.postResponse(r9.next(), r7);
        goto L17
    L28:
        return;
    L20:
        th = move-exception;
        throw th;
    }

    @Override // com.android.volley.Request.NetworkRequestCompleteListener
    public synchronized void onNoUsableResponseReceived(Request<?> r7) {
        monitor-enter(this);
        String r8 = r7.getCacheKey();     // Catch: Throwable -> L23
        List<Request<?>> r0 = this.mWaitingRequests.remove(r8);     // Catch: Throwable -> L23
        if (r0 != null) goto L6;
    L21:
        monitor-exit(this);
        return;
    L6:
        if (r0.isEmpty() == true) goto L21;
        if (VolleyLog.DEBUG == false) goto L10;
        VolleyLog.v("%d waiting requests for cacheKey=%s; resend to network", new Object[]{Integer.valueOf(r0.size()), r8});     // Catch: Throwable -> L23
    L10:
        Request<?> r1 = r0.remove(0);     // Catch: Throwable -> L23
        this.mWaitingRequests.put(r8, r0);     // Catch: Throwable -> L23
        r1.setNetworkRequestCompleteListener(this);     // Catch: Throwable -> L23
        RequestQueue r9 = this.mRequestQueue;     // Catch: Throwable -> L23
        if (r9 == null) goto L14;
        r9.sendRequestOverNetwork(r1);     // Catch: Throwable -> L23
        goto L21
    L14:
        if (this.mCacheDispatcher == null) goto L21;
        BlockingQueue<Request<?>> r10 = this.mNetworkQueue;     // Catch: Throwable -> L23
        if (r10 == null) goto L21;
        r10.put(r1);     // Catch: InterruptedException -> L19 Throwable -> L23
    L19:
        e = move-exception;
        VolleyLog.e("Couldn't add request to queue. %s", new Object[]{e.toString()});     // Catch: Throwable -> L23
        Thread.currentThread().interrupt();     // Catch: Throwable -> L23
        this.mCacheDispatcher.quit();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }

    synchronized boolean maybeAddToWaitingRequests(Request<?> r6) {
        monitor-enter(this);
        String r0 = r6.getCacheKey();     // Catch: Throwable -> L18
        if (this.mWaitingRequests.containsKey(r0) == false) goto L13;
        List<Request<?>> r1 = this.mWaitingRequests.get(r0);     // Catch: Throwable -> L18
        if (r1 != null) goto L8;
        r1 = new ArrayList();     // Catch: Throwable -> L18
    L8:
        r6.addMarker("waiting-for-response");     // Catch: Throwable -> L18
        r1.add(r6);     // Catch: Throwable -> L18
        this.mWaitingRequests.put(r0, r1);     // Catch: Throwable -> L18
        if (VolleyLog.DEBUG == false) goto L11;
        VolleyLog.d("Request for cacheKey=%s is in flight, putting on hold.", new Object[]{r0});     // Catch: Throwable -> L18
    L11:
        monitor-exit(this);
        return true;
    L13:
        this.mWaitingRequests.put(r0, null);     // Catch: Throwable -> L18
        r6.setNetworkRequestCompleteListener(this);     // Catch: Throwable -> L18
        if (VolleyLog.DEBUG == false) goto L16;
        VolleyLog.d("new request, sending to network %s", new Object[]{r0});     // Catch: Throwable -> L18
    L16:
        monitor-exit(this);
        return false;
    L18:
        th = move-exception;
        throw th;
    }
}
