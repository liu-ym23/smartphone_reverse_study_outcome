package androidx.work.impl.utils;

import androidx.work.impl.utils.taskexecutor.SerialExecutor;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class SerialExecutorImpl implements SerialExecutor {
    private Runnable mActive;
    private final Executor mExecutor;
    final Object mLock;
    private final ArrayDeque<Task> mTasks;

    static class Task implements Runnable {
        final Runnable mRunnable;
        final SerialExecutorImpl mSerialExecutor;

        Task(SerialExecutorImpl serialExecutor, Runnable runnable) {
            this.mSerialExecutor = serialExecutor;
            this.mRunnable = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mRunnable.run();     // Catch: Throwable -> L11
            Object r0 = this.mSerialExecutor.mLock;
            monitor-enter(r0);
            this.mSerialExecutor.scheduleNext();     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        L11:
            th = move-exception;
            monitor-enter(this.mSerialExecutor.mLock);
            this.mSerialExecutor.scheduleNext();     // Catch: Throwable -> L17
            throw th;
        L17:
            th = move-exception;
            throw th;
        }
    }

    public SerialExecutorImpl(Executor executor) {
        this.mExecutor = executor;
        this.mTasks = new ArrayDeque();
        this.mLock = new Object();
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable command) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mTasks.add(new Task(this, command));     // Catch: Throwable -> L9
        if (this.mActive != null) goto L7;
        scheduleNext();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    void scheduleNext() {
        Task r0 = this.mTasks.poll();
        this.mActive = r0;
        if (r0 == null) goto L6;
        this.mExecutor.execute(r0);
        return;
    }

    @Override // androidx.work.impl.utils.taskexecutor.SerialExecutor
    public boolean hasPendingTasks() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mTasks.isEmpty() == true) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    public Executor getDelegatedExecutor() {
        return this.mExecutor;
    }
}
