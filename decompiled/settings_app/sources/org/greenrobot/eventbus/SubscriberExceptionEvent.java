package org.greenrobot.eventbus;

/* JADX INFO: loaded from: classes6.dex */
public final class SubscriberExceptionEvent {
    public final Object causingEvent;
    public final Object causingSubscriber;
    public final EventBus eventBus;
    public final Throwable throwable;

    public SubscriberExceptionEvent(EventBus r1, Throwable r2, Object r3, Object r4) {
        this.eventBus = r1;
        this.throwable = r2;
        this.causingEvent = r3;
        this.causingSubscriber = r4;
    }
}
