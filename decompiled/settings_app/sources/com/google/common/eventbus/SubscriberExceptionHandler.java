package com.google.common.eventbus;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public interface SubscriberExceptionHandler {
    void handleException(Throwable r1, SubscriberExceptionContext r2);
}
