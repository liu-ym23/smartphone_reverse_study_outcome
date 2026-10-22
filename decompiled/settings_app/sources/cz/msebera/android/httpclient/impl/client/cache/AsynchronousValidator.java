package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.client.cache.HttpCacheEntry;
import cz.msebera.android.httpclient.client.methods.HttpExecutionAware;
import cz.msebera.android.httpclient.client.methods.HttpRequestWrapper;
import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import java.io.Closeable;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes5.dex */
class AsynchronousValidator implements Closeable {
    private final CacheKeyGenerator cacheKeyGenerator;
    private final FailureCache failureCache;
    public HttpClientAndroidLog log;
    private final Set<String> queued;
    private final SchedulingStrategy schedulingStrategy;

    public AsynchronousValidator(CacheConfig r2) {
        this(new ImmediateSchedulingStrategy(r2));
    }

    AsynchronousValidator(SchedulingStrategy r3) {
        this.log = new HttpClientAndroidLog(getClass());
        this.schedulingStrategy = r3;
        this.queued = new HashSet();
        this.cacheKeyGenerator = new CacheKeyGenerator();
        this.failureCache = new DefaultFailureCache();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.schedulingStrategy.close();
    }

    public synchronized void revalidateCacheEntry(CachingExec r15, HttpRoute r16, HttpRequestWrapper r17, HttpClientContext r18, HttpExecutionAware r19, HttpCacheEntry r20) {
        monitor-enter(this);
        String r13 = this.cacheKeyGenerator.getVariantURI(r18.getTargetHost(), r17, r20);     // Catch: Throwable -> L13
        if (this.queued.contains(r13) == false) goto L16;
    L11:
        monitor-exit(this);
        return;
    L16:
        this.schedulingStrategy.schedule(new AsynchronousValidationRequest(this, r15, r16, r17, r18, r19, r20, r13, this.failureCache.getErrorCount(r13)));     // Catch: RejectedExecutionException -> L9 Throwable -> L13
        this.queued.add(r13);     // Catch: RejectedExecutionException -> L9 Throwable -> L13
    L9:
        e = move-exception;
        this.log.debug("Revalidation for [" + r13 + "] not scheduled: " + e);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    synchronized void markComplete(String r2) {
        monitor-enter(this);
        this.queued.remove(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    void jobSuccessful(String r1) {
        this.failureCache.resetErrorCount(r1);
    }

    void jobFailed(String r1) {
        this.failureCache.increaseErrorCount(r1);
    }

    Set<String> getScheduledIdentifiers() {
        return Collections.unmodifiableSet(this.queued);
    }
}
