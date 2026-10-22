package com.google.common.eventbus;

import com.google.common.base.Preconditions;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public class SubscriberExceptionContext {
    private final Object event;
    private final EventBus eventBus;
    private final Object subscriber;
    private final Method subscriberMethod;

    SubscriberExceptionContext(EventBus r1, Object r2, Object r3, Method r4) {
        this.eventBus = (EventBus) Preconditions.checkNotNull(r1);
        this.event = Preconditions.checkNotNull(r2);
        this.subscriber = Preconditions.checkNotNull(r3);
        this.subscriberMethod = (Method) Preconditions.checkNotNull(r4);
    }

    public EventBus getEventBus() {
        return this.eventBus;
    }

    public Object getEvent() {
        return this.event;
    }

    public Object getSubscriber() {
        return this.subscriber;
    }

    public Method getSubscriberMethod() {
        return this.subscriberMethod;
    }
}
