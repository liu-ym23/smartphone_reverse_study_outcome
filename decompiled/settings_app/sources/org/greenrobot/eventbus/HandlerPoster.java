package org.greenrobot.eventbus;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes6.dex */
public class HandlerPoster extends Handler implements Poster {
    private final EventBus eventBus;
    private boolean handlerActive;
    private final int maxMillisInsideHandleMessage;
    private final PendingPostQueue queue;

    protected HandlerPoster(EventBus r1, Looper r2, int r3) {
        super(r2);
        this.eventBus = r1;
        this.maxMillisInsideHandleMessage = r3;
        this.queue = new PendingPostQueue();
    }

    @Override // org.greenrobot.eventbus.Poster
    public void enqueue(Subscription r1, Object r2) {
        PendingPost r3 = PendingPost.obtainPendingPost(r1, r2);
        monitor-enter(this);
        this.queue.enqueue(r3);     // Catch: Throwable -> L13
        if (this.handlerActive == true) goto L11;
        this.handlerActive = true;     // Catch: Throwable -> L13
        if (sendMessage(obtainMessage()) == true) goto L11;
        throw new EventBusException("Could not send handler message");     // Catch: Throwable -> L13
    L11:
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // android.os.Handler
    public void handleMessage(Message r7) {
        long r0 = SystemClock.uptimeMillis();     // Catch: Throwable -> L25
    L4:
        PendingPost r2 = this.queue.poll();     // Catch: Throwable -> L25
        if (r2 != null) goto L17;
        monitor-enter(this);     // Catch: Throwable -> L25
        r2 = this.queue.poll();     // Catch: Throwable -> L14
        if (r2 == null) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L14
        goto L17
    L9:
        monitor-exit(this);     // Catch: Throwable -> L14
        this.handlerActive = false;
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L17:
        this.eventBus.invokeSubscriber(r2);     // Catch: Throwable -> L25
        if ((SystemClock.uptimeMillis() - r0) < this.maxMillisInsideHandleMessage) goto L4;
        if (sendMessage(obtainMessage()) == false) goto L24;
        this.handlerActive = true;
        return;
    L24:
        throw new EventBusException("Could not send handler message");     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        this.handlerActive = false;
        throw th;
    }
}
