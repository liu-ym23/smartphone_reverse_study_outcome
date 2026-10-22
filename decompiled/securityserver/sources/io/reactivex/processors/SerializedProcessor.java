package io.reactivex.processors;

import io.reactivex.annotations.Nullable;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes2.dex */
final class SerializedProcessor<T> extends FlowableProcessor<T> {
    final FlowableProcessor<T> actual;
    volatile boolean done;
    boolean emitting;
    AppendOnlyLinkedArrayList<Object> queue;

    public SerializedProcessor(FlowableProcessor<T> r1) {
        this.actual = r1;
    }

    public void emitLoop() {
    L2:
        monitor-enter(this);
        AppendOnlyLinkedArrayList<Object> r0 = this.queue;     // Catch: Throwable -> L8
        if (r0 == null) goto L5;
        this.queue = null;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        r0.accept(this.actual);
        goto L2
    L5:
        this.emitting = false;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    @Nullable
    public Throwable getThrowable() {
        return this.actual.getThrowable();
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasComplete() {
        return this.actual.hasComplete();
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasSubscribers() {
        return this.actual.hasSubscribers();
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasThrowable() {
        return this.actual.hasThrowable();
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
        if (this.done == false) goto L12;
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L12:
        this.done = true;     // Catch: Throwable -> L10
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
        this.emitting = true;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        this.actual.onComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r3) {
        if (this.done == false) goto L6;
        RxJavaPlugins.onError(r3);
        return;
    L6:
        monitor-enter(this);
        boolean r1 = true;
        if (this.done == true) goto L21;
        this.done = true;     // Catch: Throwable -> L15
        if (this.emitting == false) goto L20;
        AppendOnlyLinkedArrayList<Object> r0 = this.queue;     // Catch: Throwable -> L15
        if (r0 != null) goto L17;
        r0 = new AppendOnlyLinkedArrayList(4);     // Catch: Throwable -> L15
        this.queue = r0;     // Catch: Throwable -> L15
    L17:
        r0.setFirst(NotificationLite.error(r3));     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
        return;
    L20:
        this.emitting = true;     // Catch: Throwable -> L15
        r1 = false;
    L21:
        monitor-exit(this);     // Catch: Throwable -> L15
        if (r1 == false) goto L25;
        RxJavaPlugins.onError(r3);
        return;
    L25:
        this.actual.onError(r3);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r3) {
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
        r0.add(NotificationLite.next(r3));     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L20:
        this.emitting = true;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        this.actual.onNext(r3);
        emitLoop();
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r3) {
        boolean r1 = true;
        if (this.done == true) goto L23;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L6:
        if (this.done == false) goto L9;
    L19:
        monitor-exit(this);     // Catch: Throwable -> L13
        goto L23
    L9:
        if (this.emitting == false) goto L18;
        AppendOnlyLinkedArrayList<Object> r0 = this.queue;     // Catch: Throwable -> L13
        if (r0 != null) goto L15;
        r0 = new AppendOnlyLinkedArrayList(4);     // Catch: Throwable -> L13
        this.queue = r0;     // Catch: Throwable -> L13
    L15:
        r0.add(NotificationLite.subscription(r3));     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L18:
        this.emitting = true;     // Catch: Throwable -> L13
        r1 = false;
    L23:
        if (r1 == false) goto L25;
        r3.cancel();
        return;
    L25:
        this.actual.onSubscribe(r3);
        emitLoop();
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> r1) {
        this.actual.subscribe(r1);
    }
}
