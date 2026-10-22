package org.greenrobot.eventbus;

/* JADX INFO: loaded from: classes6.dex */
final class PendingPostQueue {
    private PendingPost head;
    private PendingPost tail;

    PendingPostQueue() {
    }

    synchronized void enqueue(PendingPost r2) {
        monitor-enter(this);
        if (r2 == null) goto L18;
        PendingPost r0 = this.tail;     // Catch: Throwable -> L15
        if (r0 == null) goto L8;
        r0.next = r2;     // Catch: Throwable -> L15
        this.tail = r2;     // Catch: Throwable -> L15
    L10:
        notifyAll();     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L8:
        if (this.head != null) goto L14;
        this.tail = r2;     // Catch: Throwable -> L15
        this.head = r2;     // Catch: Throwable -> L15
        goto L10
    L14:
        throw new IllegalStateException("Head present, but no tail");     // Catch: Throwable -> L15
    L18:
        throw new NullPointerException("null cannot be enqueued");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    synchronized PendingPost poll() {
        monitor-enter(this);
        PendingPost r0 = this.head;     // Catch: Throwable -> L10
        if (r0 == null) goto L8;
        PendingPost r1 = r0.next;     // Catch: Throwable -> L10
        this.head = r1;     // Catch: Throwable -> L10
        if (r1 != null) goto L8;
        this.tail = null;     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return r0;
    L10:
        th = move-exception;
        throw th;
    }

    synchronized PendingPost poll(int r3) throws InterruptedException {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.head != null) goto L6;
        wait(r3);     // Catch: Throwable -> L9
    L6:
        PendingPost r4 = poll();     // Catch: Throwable -> L9
        monitor-exit(this);
        return r4;
    }
}
