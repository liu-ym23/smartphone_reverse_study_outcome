package com.ttnet.org.chromium.net.urlconnection;

import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class MessageLoop implements Executor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long INVALID_THREAD_ID = -1;
    private static final AtomicBoolean mDisableValidThreadAssert = null;
    private boolean mLoopFailed;
    private boolean mLoopRunning;
    private InterruptedIOException mPriorInterruptedIOException;
    private RuntimeException mPriorRuntimeException;
    private final BlockingQueue<Runnable> mQueue;
    private long mThreadId;

    static {
        mDisableValidThreadAssert = new AtomicBoolean(false);
    }

    public MessageLoop() {
        this.mThreadId = -1;
        this.mQueue = new LinkedBlockingQueue();
    }

    private boolean calledOnValidThread() {
        if (mDisableValidThreadAssert.get() == false) goto L5;
        return true;
    L5:
        long r2 = this.mThreadId;
        if (r2 != (-1)) goto L10;
        this.mThreadId = Thread.currentThread().getId();
        return true;
    L10:
        if (r2 == Thread.currentThread().getId()) goto L14;
        return false;
    L14:
        return true;
    }

    private Runnable take(boolean r1, long r2) throws InterruptedIOException {
        if (r1 == true) goto L4;
        Runnable r0 = this.mQueue.take();     // Catch: InterruptedException -> L9
    L5:
        if (r0 == null) goto L8;
        return r0;
    L8:
        throw new SocketTimeoutException(ApmTrafficStats.KEY_TRAFFIC_SOURCE_TTNET);
    L4:
        r0 = this.mQueue.poll(r2, TimeUnit.NANOSECONDS);     // Catch: InterruptedException -> L9
    L9:
        e = move-exception;
        InterruptedIOException r3 = new InterruptedIOException();
        r3.initCause(e);
        throw r3;
    }

    public void loop() throws IOException {
        loop(0);
    }

    public void loop(int r9) throws IOException {
        long r0 = System.nanoTime();
        long r2 = TimeUnit.NANOSECONDS.convert(r9, TimeUnit.MILLISECONDS);
        if (this.mLoopFailed == false) goto L10;
        InterruptedIOException r10 = this.mPriorInterruptedIOException;
        if (r10 == null) goto L8;
        throw r10;
    L8:
        throw this.mPriorRuntimeException;
    L10:
        if (this.mLoopRunning == true) goto L31;
        this.mLoopRunning = true;
    L13:
        if (this.mLoopRunning == false) goto L29;
        if (r9 == 0) goto L32;
        take(true, (r2 - System.nanoTime()) + r0).run();     // Catch: RuntimeException -> L20 InterruptedIOException -> L23 SocketTimeoutException -> L26
        goto L13
    L32:
        take(false, 0).run();     // Catch: RuntimeException -> L20 InterruptedIOException -> L23 SocketTimeoutException -> L26
    L26:
        e = move-exception;
        this.mLoopRunning = false;
        this.mLoopFailed = true;
        throw e;
    L23:
        e = move-exception;
        this.mLoopRunning = false;
        this.mLoopFailed = true;
        this.mPriorInterruptedIOException = e;
        throw e;
    L20:
        e = move-exception;
        this.mLoopRunning = false;
        this.mLoopFailed = true;
        this.mPriorRuntimeException = e;
        throw e;
    L29:
        return;
    L31:
        throw new IllegalStateException("Cannot run loop when it is already running.");
    }

    public void reset() {
        this.mLoopFailed = false;
    }

    public static void disableVaildThreadAssert(boolean r1) {
        mDisableValidThreadAssert.set(r1);
    }

    public void quit() {
        this.mLoopRunning = false;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r1) throws RejectedExecutionException {
        if (r1 == null) goto L9;
        this.mQueue.put(r1);     // Catch: InterruptedException -> L5
        return;
    L5:
        e = move-exception;
        throw new RejectedExecutionException(e);
    L9:
        throw new IllegalArgumentException();
    }

    public boolean isRunning() {
        return this.mLoopRunning;
    }

    public boolean hasLoopFailed() {
        return this.mLoopFailed;
    }
}
