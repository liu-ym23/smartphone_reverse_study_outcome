package com.android.volley;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public class AsyncRequestQueue extends RequestQueue {
    private static final int DEFAULT_BLOCKING_THREAD_POOL_SIZE = 4;
    private final AsyncCache mAsyncCache;
    private ExecutorService mBlockingExecutor;
    private final Object mCacheInitializationLock;
    private ExecutorFactory mExecutorFactory;
    private volatile boolean mIsCacheInitialized;
    private final AsyncNetwork mNetwork;
    private ExecutorService mNonBlockingExecutor;
    private ScheduledExecutorService mNonBlockingScheduledExecutor;
    private final List<Request<?>> mRequestsAwaitingCacheInitialization;
    private final WaitingRequestManager mWaitingRequestManager;

    public static class Builder {
        private AsyncCache mAsyncCache;
        private Cache mCache;
        private ExecutorFactory mExecutorFactory;
        private final AsyncNetwork mNetwork;
        private ResponseDelivery mResponseDelivery;

        public Builder(AsyncNetwork r2) {
            this.mAsyncCache = null;
            this.mCache = null;
            this.mExecutorFactory = null;
            this.mResponseDelivery = null;
            if (r2 == null) goto L7;
            this.mNetwork = r2;
            return;
        L7:
            throw new IllegalArgumentException("Network cannot be null");
        }

        public Builder setExecutorFactory(ExecutorFactory r1) {
            this.mExecutorFactory = r1;
            return this;
        }

        public Builder setResponseDelivery(ResponseDelivery r1) {
            this.mResponseDelivery = r1;
            return this;
        }

        public Builder setAsyncCache(AsyncCache r1) {
            this.mAsyncCache = r1;
            return this;
        }

        public Builder setCache(Cache r1) {
            this.mCache = r1;
            return this;
        }

        private ExecutorFactory getDefaultExecutorFactory() {
            return new AnonymousClass1(this);
        }

        public AsyncRequestQueue build() {
            Cache r0 = this.mCache;
            if (r0 == null) goto L5;
        L9:
            if (r0 != null) goto L12;
            this.mCache = new ThrowingCache(null);
        L12:
            if (this.mResponseDelivery != null) goto L15;
            this.mResponseDelivery = new ExecutorDelivery(new Handler(Looper.getMainLooper()));
        L15:
            if (this.mExecutorFactory != null) goto L18;
            this.mExecutorFactory = getDefaultExecutorFactory();
        L18:
            return new AsyncRequestQueue(this.mCache, this.mNetwork, this.mAsyncCache, this.mResponseDelivery, this.mExecutorFactory, null);
        L5:
            if (this.mAsyncCache != null) goto L9;
            throw new IllegalArgumentException("You must set one of the cache objects");
        }
    }

    private class CacheParseTask<T> extends RequestTask<T> {
        Cache.Entry entry;
        long startTimeMillis;
        final /* synthetic */ AsyncRequestQueue this$0;

        CacheParseTask(AsyncRequestQueue r1, Request<T> r2, Cache.Entry r3, long r4) {
            this.this$0 = r1;
            super(r2);
            this.entry = r3;
            this.startTimeMillis = r4;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mRequest.addMarker("cache-hit");
            Response<T> r0 = this.mRequest.parseNetworkResponse(new NetworkResponse(200, this.entry.data, false, 0, this.entry.allResponseHeaders));
            this.mRequest.addMarker("cache-hit-parsed");
            if (this.entry.refreshNeeded(this.startTimeMillis) == true) goto L5;
            this.this$0.getResponseDelivery().postResponse(this.mRequest, r0);
            return;
        L5:
            this.mRequest.addMarker("cache-hit-refresh-needed");
            this.mRequest.setCacheEntry(this.entry);
            r0.intermediate = true;
            if (AsyncRequestQueue.access$400(this.this$0).maybeAddToWaitingRequests(this.mRequest) == true) goto L8;
            this.this$0.getResponseDelivery().postResponse(this.mRequest, r0, new AnonymousClass1(this));
            return;
        L8:
            this.this$0.getResponseDelivery().postResponse(this.mRequest, r0);
        }
    }

    private class CachePutTask<T> extends RequestTask<T> {
        Response<?> response;
        final /* synthetic */ AsyncRequestQueue this$0;

        CachePutTask(AsyncRequestQueue r1, Request<T> r2, Response<?> r3) {
            this.this$0 = r1;
            super(r2);
            this.response = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AsyncRequestQueue.access$100(this.this$0) == null) goto L5;
            AsyncRequestQueue.access$100(this.this$0).put(this.mRequest.getCacheKey(), this.response.cacheEntry, new AnonymousClass1(this));
            return;
        L5:
            this.this$0.getCache().put(this.mRequest.getCacheKey(), this.response.cacheEntry);
            AsyncRequestQueue.access$700(this.this$0, this.mRequest, this.response, true);
        }
    }

    private class CacheTask<T> extends RequestTask<T> {
        final /* synthetic */ AsyncRequestQueue this$0;

        CacheTask(AsyncRequestQueue r1, Request<T> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mRequest.isCanceled() == false) goto L6;
            this.mRequest.finish("cache-discard-canceled");
            return;
        L6:
            this.mRequest.addMarker("cache-queue-take");
            if (AsyncRequestQueue.access$100(this.this$0) == null) goto L9;
            AsyncRequestQueue.access$100(this.this$0).get(this.mRequest.getCacheKey(), new AnonymousClass1(this));
            return;
        L9:
            Cache.Entry r0 = this.this$0.getCache().get(this.mRequest.getCacheKey());
            AsyncRequestQueue.access$300(this.this$0, r0, this.mRequest);
        }
    }

    public static abstract class ExecutorFactory {
        public abstract ExecutorService createBlockingExecutor(BlockingQueue<Runnable> r1);

        public abstract ExecutorService createNonBlockingExecutor(BlockingQueue<Runnable> r1);

        public abstract ScheduledExecutorService createNonBlockingScheduledExecutor();

        public ExecutorFactory() {
        }
    }

    private class NetworkParseTask<T> extends RequestTask<T> {
        NetworkResponse networkResponse;
        final /* synthetic */ AsyncRequestQueue this$0;

        NetworkParseTask(AsyncRequestQueue r1, Request<T> r2, NetworkResponse r3) {
            this.this$0 = r1;
            super(r2);
            this.networkResponse = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Response<T> r0 = this.mRequest.parseNetworkResponse(this.networkResponse);
            this.mRequest.addMarker("network-parse-complete");
            if (this.mRequest.shouldCache() == true) goto L5;
        L10:
            AsyncRequestQueue.access$700(this.this$0, this.mRequest, r0, false);
            return;
        L5:
            if (r0.cacheEntry == null) goto L10;
            if (AsyncRequestQueue.access$100(this.this$0) == null) goto L9;
            AsyncRequestQueue.access$200(this.this$0).execute(new CachePutTask(this.this$0, this.mRequest, r0));
            return;
        L9:
            AsyncRequestQueue.access$500(this.this$0).execute(new CachePutTask(this.this$0, this.mRequest, r0));
        }
    }

    private class NetworkTask<T> extends RequestTask<T> {
        final /* synthetic */ AsyncRequestQueue this$0;

        NetworkTask(AsyncRequestQueue r1, Request<T> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mRequest.isCanceled() == false) goto L6;
            this.mRequest.finish("network-discard-cancelled");
            this.mRequest.notifyListenerResponseNotUsable();
            return;
        L6:
            final long r0 = SystemClock.elapsedRealtime();
            this.mRequest.addMarker("network-queue-take");
            AsyncRequestQueue.access$600(this.this$0).performRequest(this.mRequest, new AnonymousClass1(this, r0));
        }
    }

    private class ParseErrorTask<T> extends RequestTask<T> {
        final /* synthetic */ AsyncRequestQueue this$0;
        VolleyError volleyError;

        ParseErrorTask(AsyncRequestQueue r1, Request<T> r2, VolleyError r3) {
            this.this$0 = r1;
            super(r2);
            this.volleyError = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            VolleyError r0 = this.mRequest.parseNetworkError(this.volleyError);
            this.this$0.getResponseDelivery().postError(this.mRequest, r0);
            this.mRequest.notifyListenerResponseNotUsable();
        }
    }

    private static class ThrowingCache implements Cache {
        private ThrowingCache() {
        }

        /* synthetic */ ThrowingCache(AnonymousClass1 r1) {
            this();
        }

        @Override // com.android.volley.Cache
        public Cache.Entry get(String r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.android.volley.Cache
        public void put(String r1, Cache.Entry r2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.android.volley.Cache
        public void initialize() {
            throw new UnsupportedOperationException();
        }

        @Override // com.android.volley.Cache
        public void invalidate(String r1, boolean r2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.android.volley.Cache
        public void remove(String r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.android.volley.Cache
        public void clear() {
            throw new UnsupportedOperationException();
        }
    }

    /* synthetic */ AsyncRequestQueue(Cache r1, AsyncNetwork r2, AsyncCache r3, ResponseDelivery r4, ExecutorFactory r5, AnonymousClass1 r6) {
        this(r1, r2, r3, r4, r5);
    }

    static /* synthetic */ void access$000(AsyncRequestQueue r0) {
        r0.onCacheInitializationComplete();
    }

    static /* synthetic */ AsyncCache access$100(AsyncRequestQueue r0) {
        return r0.mAsyncCache;
    }

    static /* synthetic */ ExecutorService access$200(AsyncRequestQueue r0) {
        return r0.mNonBlockingExecutor;
    }

    static /* synthetic */ void access$300(AsyncRequestQueue r0, Cache.Entry r1, Request r2) {
        r0.handleEntry(r1, r2);
    }

    static /* synthetic */ WaitingRequestManager access$400(AsyncRequestQueue r0) {
        return r0.mWaitingRequestManager;
    }

    static /* synthetic */ ExecutorService access$500(AsyncRequestQueue r0) {
        return r0.mBlockingExecutor;
    }

    static /* synthetic */ AsyncNetwork access$600(AsyncRequestQueue r0) {
        return r0.mNetwork;
    }

    static /* synthetic */ void access$700(AsyncRequestQueue r0, Request r1, Response r2, boolean r3) {
        r0.finishRequest(r1, r2, r3);
    }

    private AsyncRequestQueue(Cache r2, AsyncNetwork r3, AsyncCache r4, ResponseDelivery r5, ExecutorFactory r6) {
        super(r2, r3, 0, r5);
        this.mWaitingRequestManager = new WaitingRequestManager(this);
        this.mRequestsAwaitingCacheInitialization = new ArrayList();
        this.mIsCacheInitialized = false;
        this.mCacheInitializationLock = new Object[0];
        this.mAsyncCache = r4;
        this.mNetwork = r3;
        this.mExecutorFactory = r6;
    }

    @Override // com.android.volley.RequestQueue
    public void start() {
        stop();
        this.mNonBlockingExecutor = this.mExecutorFactory.createNonBlockingExecutor(getBlockingQueue());
        this.mBlockingExecutor = this.mExecutorFactory.createBlockingExecutor(getBlockingQueue());
        this.mNonBlockingScheduledExecutor = this.mExecutorFactory.createNonBlockingScheduledExecutor();
        this.mNetwork.setBlockingExecutor(this.mBlockingExecutor);
        this.mNetwork.setNonBlockingExecutor(this.mNonBlockingExecutor);
        this.mNetwork.setNonBlockingScheduledExecutor(this.mNonBlockingScheduledExecutor);
        if (this.mAsyncCache == null) goto L5;
        this.mNonBlockingExecutor.execute(new AnonymousClass1(this));
        return;
    L5:
        this.mBlockingExecutor.execute(new AnonymousClass2(this));
    }

    @Override // com.android.volley.RequestQueue
    public void stop() {
        ExecutorService r0 = this.mNonBlockingExecutor;
        if (r0 == null) goto L5;
        r0.shutdownNow();
        this.mNonBlockingExecutor = null;
    L5:
        ExecutorService r1 = this.mBlockingExecutor;
        if (r1 == null) goto L8;
        r1.shutdownNow();
        this.mBlockingExecutor = null;
    L8:
        ScheduledExecutorService r2 = this.mNonBlockingScheduledExecutor;
        if (r2 == null) goto L12;
        r2.shutdownNow();
        this.mNonBlockingScheduledExecutor = null;
        return;
    }

    @Override // com.android.volley.RequestQueue
    <T> void beginRequest(Request<T> r3) {
        if (this.mIsCacheInitialized == true) goto L17;
        Object r0 = this.mCacheInitializationLock;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.mIsCacheInitialized == true) goto L11;
        this.mRequestsAwaitingCacheInitialization.add(r3);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
    L17:
        if (r3.shouldCache() == true) goto L19;
        sendRequestOverNetwork(r3);
        return;
    L19:
        if (this.mAsyncCache == null) goto L21;
        this.mNonBlockingExecutor.execute(new CacheTask(this, r3));
        return;
    L21:
        this.mBlockingExecutor.execute(new CacheTask(this, r3));
    }

    private void onCacheInitializationComplete() {
        Object r0 = this.mCacheInitializationLock;
        monitor-enter(r0);
        ArrayList r1 = new ArrayList(this.mRequestsAwaitingCacheInitialization);     // Catch: Throwable -> L11
        this.mRequestsAwaitingCacheInitialization.clear();     // Catch: Throwable -> L11
        this.mIsCacheInitialized = true;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        Iterator r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        beginRequest((Request) r2.next());
        goto L8
    L10:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.android.volley.RequestQueue
    <T> void sendRequestOverNetwork(Request<T> r3) {
        this.mNonBlockingExecutor.execute(new NetworkTask(this, r3));
    }

    private void handleEntry(Cache.Entry r9, Request<?> r10) {
        if (r9 != null) goto L7;
        r10.addMarker("cache-miss");
        if (this.mWaitingRequestManager.maybeAddToWaitingRequests(r10) == true) goto L15;
        sendRequestOverNetwork(r10);
        return;
    L15:
        return;
    L7:
        long r4 = System.currentTimeMillis();
        if (r9.isExpired(r4) == false) goto L13;
        r10.addMarker("cache-hit-expired");
        r10.setCacheEntry(r9);
        if (this.mWaitingRequestManager.maybeAddToWaitingRequests(r10) == true) goto L16;
        sendRequestOverNetwork(r10);
        return;
    L16:
        return;
    L13:
        this.mBlockingExecutor.execute(new CacheParseTask(this, r10, r9, r4));
    }

    private void finishRequest(Request<?> r1, Response<?> r2, boolean r3) {
        if (r3 == false) goto L4;
        r1.addMarker("network-cache-written");
    L4:
        r1.markDelivered();
        getResponseDelivery().postResponse(r1, r2);
        r1.notifyListenerResponseReceived(r2);
    }

    private static PriorityBlockingQueue<Runnable> getBlockingQueue() {
        return new PriorityBlockingQueue(11, new AnonymousClass3());
    }
}
