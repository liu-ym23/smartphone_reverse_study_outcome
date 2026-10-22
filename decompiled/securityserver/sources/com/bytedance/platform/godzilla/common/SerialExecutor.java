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

    private SerialExecutor() {
        this.mExecutor = Executors.newSingleThreadExecutor(new AnonymousClass1(this));
        this.mTasks = new ArrayDeque();
    }

    public static /* synthetic */ void access$000(SerialExecutor r0) {
        r0.scheduleNext();
    }

    public static SerialExecutor getInstance() {
        if (sINSTANCE != null) goto L16;
        monitor-enter(SerialExecutor.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (sINSTANCE != null) goto L11;
        sINSTANCE = new SerialExecutor();     // Catch: Throwable -> L9
    L11:
        monitor-exit(SerialExecutor.class);     // Catch: Throwable -> L9
    L16:
        return sINSTANCE;
    }

    private synchronized void scheduleNext() {
        monitor-enter(this);
        Runnable r0 = this.mTasks.poll();     // Catch: Throwable -> L7
        this.mActive = r0;     // Catch: Throwable -> L7
        if (r0 == null) goto L9;
        this.mExecutor.execute(r0);     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(final Runnable r3) {
        monitor-enter(this);
        this.mTasks.offer(new AnonymousClass2(this, r3));     // Catch: Throwable -> L7
        if (this.mActive != null) goto L9;
        scheduleNext();     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setExecutor(Executor r1) {
        this.mExecutor = r1;
    }
}
