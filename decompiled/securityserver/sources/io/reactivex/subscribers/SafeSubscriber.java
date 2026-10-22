package io.reactivex.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes2.dex */
public final class SafeSubscriber<T> implements FlowableSubscriber<T>, Subscription {
    boolean done;
    final Subscriber<? super T> downstream;
    Subscription upstream;

    public SafeSubscriber(Subscriber<? super T> r1) {
        this.downstream = r1;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        this.upstream.cancel();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        if (this.upstream != null) goto L14;
        onCompleteNoSubscription();
        return;
    L14:
        this.downstream.onComplete();     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(th);
    }

    public void onCompleteNoSubscription() {
        NullPointerException r3 = new NullPointerException("Subscription not set!");
        this.downstream.onSubscribe(EmptySubscription.INSTANCE);     // Catch: Throwable -> L9
        this.downstream.onError(r3);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(new CompositeException(new Throwable[]{r3, th}));
        return;
    L9:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(new CompositeException(new Throwable[]{r3, th}));
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r8) {
        if (this.done == false) goto L6;
        RxJavaPlugins.onError(r8);
        return;
    L6:
        this.done = true;
        if (this.upstream != null) goto L18;
        NullPointerException r4 = new NullPointerException("Subscription not set!");
        this.downstream.onSubscribe(EmptySubscription.INSTANCE);     // Catch: Throwable -> L15
        this.downstream.onError(new CompositeException(new Throwable[]{r8, r4}));     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(new CompositeException(new Throwable[]{r8, r4, th}));
        return;
    L15:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(new CompositeException(new Throwable[]{r8, r4, th}));
        return;
    L18:
        if (r8 != null) goto L29;
        r8 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
    L29:
        this.downstream.onError(r8);     // Catch: Throwable -> L22
        return;
    L22:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(new CompositeException(new Throwable[]{r8, th}));
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r5) {
        if (this.done == false) goto L6;
        return;
    L6:
        if (this.upstream != null) goto L9;
        onNextNoSubscription();
        return;
    L9:
        if (r5 != null) goto L29;
        NullPointerException r6 = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        this.upstream.cancel();     // Catch: Throwable -> L14
        onError(r6);
        return;
    L14:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        onError(new CompositeException(new Throwable[]{r6, th}));
        return;
    L29:
        this.downstream.onNext(r5);     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        this.upstream.cancel();     // Catch: Throwable -> L24
        onError(th);
        return;
    L24:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        onError(new CompositeException(new Throwable[]{th, th}));
    }

    public void onNextNoSubscription() {
        this.done = true;
        NullPointerException r3 = new NullPointerException("Subscription not set!");
        this.downstream.onSubscribe(EmptySubscription.INSTANCE);     // Catch: Throwable -> L9
        this.downstream.onError(r3);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(new CompositeException(new Throwable[]{r3, th}));
        return;
    L9:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(new CompositeException(new Throwable[]{r3, th}));
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r3) {
        if (SubscriptionHelper.validate(this.upstream, r3) == false) goto L18;
        this.upstream = r3;
        this.downstream.onSubscribe(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        this.done = true;
        r3.cancel();     // Catch: Throwable -> L11
        RxJavaPlugins.onError(th);
        return;
    L11:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(new CompositeException(new Throwable[]{th, th}));
        return;
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r2) {
        this.upstream.request(r2);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        this.upstream.cancel();     // Catch: Throwable -> L9
        RxJavaPlugins.onError(th);
        return;
    L9:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(new CompositeException(new Throwable[]{th, th}));
    }
}
