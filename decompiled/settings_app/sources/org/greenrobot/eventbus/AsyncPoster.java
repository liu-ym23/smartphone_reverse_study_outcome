package org.greenrobot.eventbus;

/* JADX INFO: loaded from: classes6.dex */
class AsyncPoster implements Runnable, Poster {
    private final EventBus eventBus;
    private final PendingPostQueue queue;

    AsyncPoster(EventBus r1) {
        this.eventBus = r1;
        this.queue = new PendingPostQueue();
    }

    @Override // org.greenrobot.eventbus.Poster
    public void enqueue(Subscription r1, Object r2) {
        PendingPost r3 = PendingPost.obtainPendingPost(r1, r2);
        this.queue.enqueue(r3);
        this.eventBus.getExecutorService().execute(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        PendingPost r0 = this.queue.poll();
        if (r0 == null) goto L7;
        this.eventBus.invokeSubscriber(r0);
        return;
    L7:
        throw new IllegalStateException("No pending post available");
    }
}
