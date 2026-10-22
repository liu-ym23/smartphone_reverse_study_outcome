package com.ttnet.org.chromium.net.urlconnection;

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
        if (r1 == true) goto L5;
        Runnable r0 = this.mQueue.take();     // Catch: InterruptedException -> L11
    L4:
        Runnable r3 = r0;     // Catch: InterruptedException -> L11
        if (r3 == null) goto L10;
        return r3;
    L10:
        throw new SocketTimeoutException("ttnet");
    L5:
        r0 = this.mQueue.poll(r2, TimeUnit.NANOSECONDS);     // Catch: InterruptedException -> L11
    L11:
        e = move-exception;
        InterruptedIOException r4 = new InterruptedIOException();
        r4.initCause(e);
        throw r4;
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
        if (this.mLoopRunning == true) goto L32;
        this.mLoopRunning = true;
    L13:
        if (this.mLoopRunning == false) goto L30;
        if (r9 == 0) goto L33;
        Runnable r6 = take(true, (r2 - System.nanoTime()) + r0);     // Catch: RuntimeException -> L21 InterruptedIOException -> L24 SocketTimeoutException -> L27
    L18:
        r6.run();     // Catch: RuntimeException -> L21 InterruptedIOException -> L24 SocketTimeoutException -> L27
        goto L13
    L33:
        r6 = take(false, 0);     // Catch: RuntimeException -> L21 InterruptedIOException -> L24 SocketTimeoutException -> L27
    L27:
        e = move-exception;
        this.mLoopRunning = false;
        this.mLoopFailed = true;
        throw e;
    L24:
        e = move-exception;
        this.mLoopRunning = false;
        this.mLoopFailed = true;
        this.mPriorInterruptedIOException = e;
        throw e;
    L21:
        e = move-exception;
        this.mLoopRunning = false;
        this.mLoopFailed = true;
        this.mPriorRuntimeException = e;
        throw e;
    L30:
        return;
    L32:
        throw new IllegalStateException("Cannot run loop when it is already running.");
    }

    public void quit() {
        this.mLoopRunning = false;
    }

    public void reset() {
        this.mLoopFailed = false;
    }
}
