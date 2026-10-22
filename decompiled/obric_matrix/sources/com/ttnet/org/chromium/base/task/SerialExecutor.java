package com.ttnet.org.chromium.base.task;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
class SerialExecutor implements Executor {
    Runnable mActive;
    final ArrayDeque<Runnable> mTasks;

    SerialExecutor() {
        this.mTasks = new ArrayDeque();
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(final Runnable r3) {
        monitor-enter(this);
        this.mTasks.offer(new AnonymousClass1(this, r3));     // Catch: Throwable -> L8
        if (this.mActive != null) goto L6;
        scheduleNext();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    protected synchronized void scheduleNext() {
        monitor-enter(this);
        Runnable r0 = this.mTasks.poll();     // Catch: Throwable -> L8
        this.mActive = r0;     // Catch: Throwable -> L8
        if (r0 == null) goto L6;
        AsyncTask.THREAD_POOL_EXECUTOR.execute(r0);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
