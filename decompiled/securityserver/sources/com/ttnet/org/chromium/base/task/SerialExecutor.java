package com.ttnet.org.chromium.base.task;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
class SerialExecutor implements Executor {
    Runnable mActive;
    final ArrayDeque<Runnable> mTasks;

    public SerialExecutor() {
        this.mTasks = new ArrayDeque();
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(final Runnable r3) {
        monitor-enter(this);
        this.mTasks.offer(new AnonymousClass1(this, r3));     // Catch: Throwable -> L7
        if (this.mActive != null) goto L9;
        scheduleNext();     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void scheduleNext() {
        monitor-enter(this);
        Runnable r0 = this.mTasks.poll();     // Catch: Throwable -> L7
        this.mActive = r0;     // Catch: Throwable -> L7
        if (r0 == null) goto L9;
        AsyncTask.THREAD_POOL_EXECUTOR.execute(r0);     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
