package com.android.volley;

import android.os.Handler;
import android.os.Looper;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class RequestQueue {
    private static final int DEFAULT_NETWORK_THREAD_POOL_SIZE = 4;
    private final Cache mCache;
    private CacheDispatcher mCacheDispatcher;
    private final PriorityBlockingQueue<Request<?>> mCacheQueue;
    private final Set<Request<?>> mCurrentRequests;
    private final ResponseDelivery mDelivery;
    private final NetworkDispatcher[] mDispatchers;
    private final List<RequestEventListener> mEventListeners;
    private final List<RequestFinishedListener> mFinishedListeners;
    private final Network mNetwork;
    private final PriorityBlockingQueue<Request<?>> mNetworkQueue;
    private final AtomicInteger mSequenceGenerator;

    @Retention(RetentionPolicy.SOURCE)
    public @interface RequestEvent {
        public static final int REQUEST_CACHE_LOOKUP_FINISHED = 2;
        public static final int REQUEST_CACHE_LOOKUP_STARTED = 1;
        public static final int REQUEST_FINISHED = 5;
        public static final int REQUEST_NETWORK_DISPATCH_FINISHED = 4;
        public static final int REQUEST_NETWORK_DISPATCH_STARTED = 3;
        public static final int REQUEST_QUEUED = 0;
    }

    public interface RequestEventListener {
        void onRequestEvent(Request<?> r1, int r2);
    }

    public interface RequestFilter {
        boolean apply(Request<?> r1);
    }

    @Deprecated
    public interface RequestFinishedListener<T> {
        void onRequestFinished(Request<T> r1);
    }

    public RequestQueue(Cache r2, Network r3, int r4, ResponseDelivery r5) {
        this.mSequenceGenerator = new AtomicInteger();
        this.mCurrentRequests = new HashSet();
        this.mCacheQueue = new PriorityBlockingQueue();
        this.mNetworkQueue = new PriorityBlockingQueue();
        this.mFinishedListeners = new ArrayList();
        this.mEventListeners = new ArrayList();
        this.mCache = r2;
        this.mNetwork = r3;
        this.mDispatchers = new NetworkDispatcher[r4];
        this.mDelivery = r5;
    }

    public RequestQueue(Cache r4, Network r5, int r6) {
        this(r4, r5, r6, new ExecutorDelivery(new Handler(Looper.getMainLooper())));
    }

    public RequestQueue(Cache r2, Network r3) {
        this(r2, r3, 4);
    }

    public void start() {
        stop();
        CacheDispatcher r0 = new CacheDispatcher(this.mCacheQueue, this.mNetworkQueue, this.mCache, this.mDelivery);
        this.mCacheDispatcher = r0;
        r0.start();
        int r1 = 0;
    L4:
        if (r1 >= this.mDispatchers.length) goto L6;
        NetworkDispatcher r2 = new NetworkDispatcher(this.mNetworkQueue, this.mNetwork, this.mCache, this.mDelivery);
        this.mDispatchers[r1] = r2;
        r2.start();
        r1 = r1 + 1;
        goto L4
    }

    public void stop() {
        CacheDispatcher r0 = this.mCacheDispatcher;
        if (r0 == null) goto L5;
        r0.quit();
    L5:
        NetworkDispatcher[] r3 = this.mDispatchers;
        int r1 = r3.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L11;
        NetworkDispatcher r4 = r3[r2];
        if (r4 == null) goto L10;
        r4.quit();
    L10:
        r2 = r2 + 1;
        goto L6
    }

    public int getSequenceNumber() {
        return this.mSequenceGenerator.incrementAndGet();
    }

    public Cache getCache() {
        return this.mCache;
    }

    public void cancelAll(RequestFilter r4) {
        Set<Request<?>> r0 = this.mCurrentRequests;
        monitor-enter(r0);
        Iterator<Request<?>> r3 = this.mCurrentRequests.iterator();     // Catch: Throwable -> L12
    L6:
        if (r3.hasNext() == false) goto L10;
        Request<?> r1 = r3.next();     // Catch: Throwable -> L12
        if (r4.apply(r1) == false) goto L6;
        r1.cancel();     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void cancelAll(final Object r2) {
        if (r2 == null) goto L6;
        cancelAll(new AnonymousClass1(this, r2));
        return;
    L6:
        throw new IllegalArgumentException("Cannot cancelAll with a null tag");
    }

    public <T> Request<T> add(Request<T> r3) {
        r3.setRequestQueue(this);
        Set<Request<?>> r0 = this.mCurrentRequests;
        monitor-enter(r0);
        this.mCurrentRequests.add(r3);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        r3.setSequence(getSequenceNumber());
        r3.addMarker("add-to-queue");
        sendRequestEvent(r3, 0);
        beginRequest(r3);
        return r3;
    L8:
        th = move-exception;
        throw th;
    }

    <T> void beginRequest(Request<T> r2) {
        if (r2.shouldCache() == true) goto L5;
        sendRequestOverNetwork(r2);
        return;
    L5:
        this.mCacheQueue.add(r2);
    }

    <T> void finish(Request<T> r4) {
        Set<Request<?>> r0 = this.mCurrentRequests;
        monitor-enter(r0);
        this.mCurrentRequests.remove(r4);     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        List<RequestFinishedListener> r1 = this.mFinishedListeners;
        monitor-enter(r1);
        Iterator<RequestFinishedListener> r2 = this.mFinishedListeners.iterator();     // Catch: Throwable -> L15
    L10:
        if (r2.hasNext() == false) goto L12;
        r2.next().onRequestFinished(r4);     // Catch: Throwable -> L15
        goto L10
    L12:
        monitor-exit(r1);     // Catch: Throwable -> L15
        sendRequestEvent(r4, 5);
        return;
    L15:
        th = move-exception;
        throw th;
    L18:
        th = move-exception;
        throw th;
    }

    void sendRequestEvent(Request<?> r3, int r4) {
        List<RequestEventListener> r0 = this.mEventListeners;
        monitor-enter(r0);
        Iterator<RequestEventListener> r2 = this.mEventListeners.iterator();     // Catch: Throwable -> L10
    L6:
        if (r2.hasNext() == false) goto L8;
        r2.next().onRequestEvent(r3, r4);     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void addRequestEventListener(RequestEventListener r2) {
        List<RequestEventListener> r0 = this.mEventListeners;
        monitor-enter(r0);
        this.mEventListeners.add(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeRequestEventListener(RequestEventListener r2) {
        List<RequestEventListener> r0 = this.mEventListeners;
        monitor-enter(r0);
        this.mEventListeners.remove(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Deprecated
    public <T> void addRequestFinishedListener(RequestFinishedListener<T> r2) {
        List<RequestFinishedListener> r0 = this.mFinishedListeners;
        monitor-enter(r0);
        this.mFinishedListeners.add(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Deprecated
    public <T> void removeRequestFinishedListener(RequestFinishedListener<T> r2) {
        List<RequestFinishedListener> r0 = this.mFinishedListeners;
        monitor-enter(r0);
        this.mFinishedListeners.remove(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public ResponseDelivery getResponseDelivery() {
        return this.mDelivery;
    }

    <T> void sendRequestOverNetwork(Request<T> r1) {
        this.mNetworkQueue.add(r1);
    }
}
