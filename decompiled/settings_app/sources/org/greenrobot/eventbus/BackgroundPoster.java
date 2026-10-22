package org.greenrobot.eventbus;

import java.util.logging.Level;

/* JADX INFO: loaded from: classes6.dex */
final class BackgroundPoster implements Runnable, Poster {
    private final EventBus eventBus;
    private volatile boolean executorRunning;
    private final PendingPostQueue queue;

    BackgroundPoster(EventBus r1) {
        this.eventBus = r1;
        this.queue = new PendingPostQueue();
    }

    @Override // org.greenrobot.eventbus.Poster
    public void enqueue(Subscription r1, Object r2) {
        PendingPost r3 = PendingPost.obtainPendingPost(r1, r2);
        monitor-enter(this);
        this.queue.enqueue(r3);     // Catch: Throwable -> L9
        if (this.executorRunning == true) goto L7;
        this.executorRunning = true;     // Catch: Throwable -> L9
        this.eventBus.getExecutorService().execute(this);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // java.lang.Runnable
    public void run() {
    L27:
        PendingPost r1 = this.queue.poll(1000);     // Catch: Throwable -> L19 InterruptedException -> L21
        if (r1 != null) goto L17;
        monitor-enter(this);     // Catch: Throwable -> L19 InterruptedException -> L21
        r1 = this.queue.poll();     // Catch: Throwable -> L14
        if (r1 == null) goto L8;
        monitor-exit(this);     // Catch: Throwable -> L14
        goto L17
    L8:
        this.executorRunning = false;     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        this.executorRunning = false;
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19 InterruptedException -> L21
    L17:
        this.eventBus.invokeSubscriber(r1);     // Catch: Throwable -> L19 InterruptedException -> L21
    L19:
        th = move-exception;
        this.executorRunning = false;
        throw th;
    L21:
        e = move-exception;
        this.eventBus.getLogger().log(Level.WARNING, Thread.currentThread().getName() + " was interruppted", e);     // Catch: Throwable -> L19
        this.executorRunning = false;
    }
}
