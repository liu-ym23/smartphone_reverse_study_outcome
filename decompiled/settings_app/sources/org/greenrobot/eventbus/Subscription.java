package org.greenrobot.eventbus;

/* JADX INFO: loaded from: classes6.dex */
final class Subscription {
    volatile boolean active;
    final Object subscriber;
    final SubscriberMethod subscriberMethod;

    Subscription(Object r1, SubscriberMethod r2) {
        this.subscriber = r1;
        this.subscriberMethod = r2;
        this.active = true;
    }

    public boolean equals(Object r4) {
        if ((r4 instanceof Subscription) == false) goto L10;
        Subscription r5 = (Subscription) r4;
        if (this.subscriber == r5.subscriber) goto L7;
        return false;
    L7:
        if (this.subscriberMethod.equals(r5.subscriberMethod) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public int hashCode() {
        return this.subscriber.hashCode() + this.subscriberMethod.methodString.hashCode();
    }
}
