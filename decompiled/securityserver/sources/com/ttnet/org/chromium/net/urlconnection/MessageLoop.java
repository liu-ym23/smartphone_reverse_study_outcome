package com.ttnet.org.chromium.net.urlconnection;

import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
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

    public static void disableVaildThreadAssert(boolean r1) {
        mDisableValidThreadAssert.set(r1);
    }

    private Runnable take(boolean r1, long r2) {
        if (r1 == true) goto L6;
        Runnable r0 = this.mQueue.take();     // Catch: InterruptedException -> L4
    L7:
        if (r0 == null) goto L10;
        return r0;
    L10:
        throw new SocketTimeoutException(ApmTrafficStats.KEY_TRAFFIC_SOURCE_TTNET);
    L6:
        r0 = this.mQueue.poll(r2, TimeUnit.NANOSECONDS);     // Catch: InterruptedException -> L4
    L4:
        e = move-exception;
        InterruptedIOException r3 = new InterruptedIOException();
        r3.initCause(e);
        throw r3;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r1) {
        if (r1 == null) goto L9;
        this.mQueue.put(r1);     // Catch: InterruptedException -> L5
        return;
    L5:
        e = move-exception;
        throw new RejectedExecutionException(e);
    L9:
        throw new IllegalArgumentException();
    }

    public boolean hasLoopFailed() {
        return this.mLoopFailed;
    }

    public boolean isRunning() {
        return this.mLoopRunning;
    }

    public void loop() {
        loop(0);
    }

    public void quit() {
        this.mLoopRunning = false;
    }

    public void reset() {
        this.mLoopFailed = false;
    }

    public void loop(int r9) {
        long r0 = System.nanoTime();
        long r2 = TimeUnit.NANOSECONDS.convert(r9, TimeUnit.MILLISECONDS);
        if (this.mLoopFailed == false) goto L10;
        InterruptedIOException r10 = this.mPriorInterruptedIOException;
        if (r10 == null) goto L8;
        throw r10;
    L8:
        throw this.mPriorRuntimeException;
    L10:
        if (this.mLoopRunning == true) goto L34;
        this.mLoopRunning = true;
    L13:
        if (this.mLoopRunning == false) goto L32;
        if (r9 == 0) goto L35;
        take(true, (r2 - System.nanoTime()) + r0).run();     // Catch: RuntimeException -> L18 InterruptedIOException -> L20 SocketTimeoutException -> L22
        goto L13
    L35:
        take(false, 0).run();     // Catch: RuntimeException -> L18 InterruptedIOException -> L20 SocketTimeoutException -> L22
    L20:
        e = move-exception;
        this.mLoopRunning = false;
        this.mLoopFailed = true;
        this.mPriorInterruptedIOException = e;
        throw e;
    L18:
        e = move-exception;
        this.mLoopRunning = false;
        this.mLoopFailed = true;
        this.mPriorRuntimeException = e;
        throw e;
    L22:
        e = move-exception;
        this.mLoopRunning = false;
        this.mLoopFailed = true;
        throw e;
    L32:
        return;
    L34:
        throw new IllegalStateException("Cannot run loop when it is already running.");
    }
}
