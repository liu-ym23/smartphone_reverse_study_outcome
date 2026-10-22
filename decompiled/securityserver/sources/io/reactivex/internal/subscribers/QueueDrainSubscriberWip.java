package io.reactivex.internal.subscribers;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
class QueueDrainSubscriberWip extends QueueDrainSubscriberPad0 {
    final AtomicInteger wip;

    public QueueDrainSubscriberWip() {
        this.wip = new AtomicInteger();
    }
}
