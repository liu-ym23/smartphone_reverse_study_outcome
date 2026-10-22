package org.greenrobot.eventbus;

/* JADX INFO: loaded from: classes6.dex */
public final class NoSubscriberEvent {
    public final EventBus eventBus;
    public final Object originalEvent;

    public NoSubscriberEvent(EventBus r1, Object r2) {
        this.eventBus = r1;
        this.originalEvent = r2;
    }
}
