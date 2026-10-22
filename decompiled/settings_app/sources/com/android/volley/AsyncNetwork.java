package com.android.volley;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class AsyncNetwork implements Network {
    private ExecutorService mBlockingExecutor;
    private ExecutorService mNonBlockingExecutor;
    private ScheduledExecutorService mNonBlockingScheduledExecutor;

    public interface OnRequestComplete {
        void onError(VolleyError r1);

        void onSuccess(NetworkResponse r1);
    }

    public abstract void performRequest(Request<?> r1, OnRequestComplete r2);

    protected AsyncNetwork() {
    }

    @Override // com.android.volley.Network
    public NetworkResponse performRequest(Request<?> r5) throws VolleyError {
        final CountDownLatch r0 = new CountDownLatch(1);
        final AtomicReference r1 = new AtomicReference();
        final AtomicReference r2 = new AtomicReference();
        performRequest(r5, new AnonymousClass1(this, r1, r0, r2));
        r0.await();     // Catch: InterruptedException -> L14
        if (r1.get() == null) goto L9;
        return (NetworkResponse) r1.get();
    L9:
        if (r2.get() == null) goto L13;
        throw ((VolleyError) r2.get());
    L13:
        throw new VolleyError("Neither response entry was set");
    L14:
        e = move-exception;
        VolleyLog.e(e, "while waiting for CountDownLatch", new Object[0]);
        Thread.currentThread().interrupt();
        throw new VolleyError(e);
    }

    public void setNonBlockingExecutor(ExecutorService r1) {
        this.mNonBlockingExecutor = r1;
    }

    public void setBlockingExecutor(ExecutorService r1) {
        this.mBlockingExecutor = r1;
    }

    public void setNonBlockingScheduledExecutor(ScheduledExecutorService r1) {
        this.mNonBlockingScheduledExecutor = r1;
    }

    protected ExecutorService getBlockingExecutor() {
        return this.mBlockingExecutor;
    }

    protected ExecutorService getNonBlockingExecutor() {
        return this.mNonBlockingExecutor;
    }

    protected ScheduledExecutorService getNonBlockingScheduledExecutor() {
        return this.mNonBlockingScheduledExecutor;
    }
}
