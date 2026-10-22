package com.bytedance.platform.godzilla.common;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public final class SerialExecutor implements Executor {
    private static SerialExecutor sINSTANCE;
    private Runnable mActive;
    private Executor mExecutor;
    final ArrayDeque<Runnable> mTasks;

    static /* synthetic */ void access$000(SerialExecutor r0) {
        r0.scheduleNext();
    }

    private SerialExecutor() {
        this.mExecutor = Executors.newSingleThreadExecutor(new AnonymousClass1(this));
        this.mTasks = new ArrayDeque();
    }

    public static SerialExecutor getInstance() {
        if (sINSTANCE != null) goto L15;
        monitor-enter(SerialExecutor.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sINSTANCE != null) goto L9;
        sINSTANCE = new SerialExecutor();     // Catch: Throwable -> L11
    L9:
        monitor-exit(SerialExecutor.class);     // Catch: Throwable -> L11
    L15:
        return sINSTANCE;
    }

    public void setExecutor(Executor r1) {
        this.mExecutor = r1;
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(final Runnable r3) {
        monitor-enter(this);
        this.mTasks.offer(new AnonymousClass2(this, r3));     // Catch: Throwable -> L8
        if (this.mActive != null) goto L6;
        scheduleNext();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private synchronized void scheduleNext() {
        monitor-enter(this);
        Runnable r0 = this.mTasks.poll();     // Catch: Throwable -> L8
        this.mActive = r0;     // Catch: Throwable -> L8
        if (r0 == null) goto L6;
        this.mExecutor.execute(r0);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
