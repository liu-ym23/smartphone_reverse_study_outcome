package io.reactivex.processors;

import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes5.dex */
final class SerializedProcessor<T> extends FlowableProcessor<T> {
    final FlowableProcessor<T> actual;
    volatile boolean done;
    boolean emitting;
    AppendOnlyLinkedArrayList<Object> queue;

    SerializedProcessor(FlowableProcessor<T> r1) {
        this.actual = r1;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> r1) {
        this.actual.subscribe(r1);
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r3) {
        boolean r1 = true;
        if (this.done == true) goto L22;
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L6:
        if (this.done == false) goto L9;
    L17:
        monitor-exit(this);     // Catch: Throwable -> L19
        goto L22
    L9:
        if (this.emitting == false) goto L16;
        AppendOnlyLinkedArrayList<Object> r0 = this.queue;     // Catch: Throwable -> L19
        if (r0 != null) goto L13;
        r0 = new AppendOnlyLinkedArrayList(4);     // Catch: Throwable -> L19
        this.queue = r0;     // Catch: Throwable -> L19
    L13:
        r0.add(NotificationLite.subscription(r3));     // Catch: Throwable -> L19
        monitor-exit(this);     // Catch: Throwable -> L19
        return;
    L16:
        this.emitting = true;     // Catch: Throwable -> L19
        r1 = false;
    L22:
        if (r1 == false) goto L24;
        r3.cancel();
        return;
    L24:
        this.actual.onSubscribe(r3);
        emitLoop();
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r3) {
        if (this.done == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L7:
        if (this.done == false) goto L11;
        monitor-exit(this);     // Catch: Throwable -> L22
        return;
    L11:
        if (this.emitting == false) goto L18;
        AppendOnlyLinkedArrayList<Object> r0 = this.queue;     // Catch: Throwable -> L22
        if (r0 != null) goto L15;
        r0 = new AppendOnlyLinkedArrayList(4);     // Catch: Throwable -> L22
        this.queue = r0;     // Catch: Throwable -> L22
    L15:
        r0.add(NotificationLite.next(r3));     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
        return;
    L18:
        this.emitting = true;     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
        this.actual.onNext(r3);
        emitLoop();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r3) {
        if (this.done == false) goto L6;
        RxJavaPlugins.onError(r3);
        return;
    L6:
        monitor-enter(this);
        boolean r1 = true;
        if (this.done == true) goto L19;
        this.done = true;     // Catch: Throwable -> L25
        if (this.emitting == false) goto L18;
        AppendOnlyLinkedArrayList<Object> r0 = this.queue;     // Catch: Throwable -> L25
        if (r0 != null) goto L15;
        r0 = new AppendOnlyLinkedArrayList(4);     // Catch: Throwable -> L25
        this.queue = r0;     // Catch: Throwable -> L25
    L15:
        r0.setFirst(NotificationLite.error(r3));     // Catch: Throwable -> L25
        monitor-exit(this);     // Catch: Throwable -> L25
        return;
    L18:
        this.emitting = true;     // Catch: Throwable -> L25
        r1 = false;
    L19:
        monitor-exit(this);     // Catch: Throwable -> L25
        if (r1 == false) goto L23;
        RxJavaPlugins.onError(r3);
        return;
    L23:
        this.actual.onError(r3);
        return;
    L25:
        th = move-exception;
        throw th;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L7:
        if (this.done == false) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L22
        return;
    L10:
        this.done = true;     // Catch: Throwable -> L22
        if (this.emitting == false) goto L18;
        AppendOnlyLinkedArrayList<Object> r0 = this.queue;     // Catch: Throwable -> L22
        if (r0 != null) goto L15;
        r0 = new AppendOnlyLinkedArrayList(4);     // Catch: Throwable -> L22
        this.queue = r0;     // Catch: Throwable -> L22
    L15:
        r0.add(NotificationLite.complete());     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
        return;
    L18:
        this.emitting = true;     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
        this.actual.onComplete();
    }

    void emitLoop() {
    L2:
        monitor-enter(this);
        AppendOnlyLinkedArrayList<Object> r0 = this.queue;     // Catch: Throwable -> L11
        if (r0 == null) goto L5;
        this.queue = null;     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        r0.accept(this.actual);
        goto L2
    L5:
        this.emitting = false;     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasSubscribers() {
        return this.actual.hasSubscribers();
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasThrowable() {
        return this.actual.hasThrowable();
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public Throwable getThrowable() {
        return this.actual.getThrowable();
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasComplete() {
        return this.actual.hasComplete();
    }
}
