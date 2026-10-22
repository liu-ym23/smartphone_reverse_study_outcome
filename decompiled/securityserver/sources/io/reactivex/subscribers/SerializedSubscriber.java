package io.reactivex.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes2.dex */
public final class SerializedSubscriber<T> implements FlowableSubscriber<T>, Subscription {
    static final int QUEUE_LINK_SIZE = 4;
    final boolean delayError;
    volatile boolean done;
    final Subscriber<? super T> downstream;
    boolean emitting;
    AppendOnlyLinkedArrayList<Object> queue;
    Subscription upstream;

    public SerializedSubscriber(Subscriber<? super T> r2) {
        this(r2, false);
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        this.upstream.cancel();
    }

    public void emitLoop() {
    L2:
        monitor-enter(this);
        AppendOnlyLinkedArrayList<Object> r0 = this.queue;     // Catch: Throwable -> L8
        if (r0 == null) goto L5;
        this.queue = null;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        if (r0.accept(this.downstream) == false) goto L2;
        return;
    L5:
        this.emitting = false;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L7:
        if (this.done == false) goto L13;
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L13:
        if (this.emitting == false) goto L20;
        AppendOnlyLinkedArrayList<Object> r0 = this.queue;     // Catch: Throwable -> L10
        if (r0 != null) goto L17;
        r0 = new AppendOnlyLinkedArrayList(4);     // Catch: Throwable -> L10
        this.queue = r0;     // Catch: Throwable -> L10
    L17:
        r0.add(NotificationLite.complete());     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L20:
        this.done = true;     // Catch: Throwable -> L10
        this.emitting = true;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        this.downstream.onComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r3) {
        if (this.done == false) goto L6;
        RxJavaPlugins.onError(r3);
        return;
    L6:
        monitor-enter(this);
        boolean r1 = true;
        if (this.done == false) goto L11;
    L24:
        monitor-exit(this);     // Catch: Throwable -> L15
        if (r1 == false) goto L28;
        RxJavaPlugins.onError(r3);
        return;
    L28:
        this.downstream.onError(r3);
        return;
    L11:
        if (this.emitting == false) goto L23;
        this.done = true;     // Catch: Throwable -> L15
        AppendOnlyLinkedArrayList<Object> r0 = this.queue;     // Catch: Throwable -> L15
        if (r0 != null) goto L17;
        r0 = new AppendOnlyLinkedArrayList(4);     // Catch: Throwable -> L15
        this.queue = r0;     // Catch: Throwable -> L15
    L17:
        Object r4 = NotificationLite.error(r3);     // Catch: Throwable -> L15
        if (this.delayError == false) goto L20;
        r0.add(r4);     // Catch: Throwable -> L15
    L21:
        monitor-exit(this);     // Catch: Throwable -> L15
        return;
    L20:
        r0.setFirst(r4);     // Catch: Throwable -> L15
        goto L21
    L23:
        this.done = true;     // Catch: Throwable -> L15
        this.emitting = true;     // Catch: Throwable -> L15
        r1 = false;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r3) {
        if (this.done == false) goto L5;
        return;
    L5:
        if (r3 != null) goto L8;
        this.upstream.cancel();
        onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
        return;
    L8:
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L10:
        if (this.done == false) goto L16;
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L16:
        if (this.emitting == false) goto L23;
        AppendOnlyLinkedArrayList<Object> r0 = this.queue;     // Catch: Throwable -> L13
        if (r0 != null) goto L20;
        r0 = new AppendOnlyLinkedArrayList(4);     // Catch: Throwable -> L13
        this.queue = r0;     // Catch: Throwable -> L13
    L20:
        r0.add(NotificationLite.next(r3));     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L23:
        this.emitting = true;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        this.downstream.onNext(r3);
        emitLoop();
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r2) {
        if (SubscriptionHelper.validate(this.upstream, r2) == false) goto L6;
        this.upstream = r2;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r1) {
        this.upstream.request(r1);
    }

    public SerializedSubscriber(Subscriber<? super T> r1, boolean r2) {
        this.downstream = r1;
        this.delayError = r2;
    }
}
