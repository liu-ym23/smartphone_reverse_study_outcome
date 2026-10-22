package io.reactivex.internal.operators.parallel;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.LongConsumer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes2.dex */
public final class ParallelPeek<T> extends ParallelFlowable<T> {
    final Consumer<? super T> onAfterNext;
    final Action onAfterTerminated;
    final Action onCancel;
    final Action onComplete;
    final Consumer<? super Throwable> onError;
    final Consumer<? super T> onNext;
    final LongConsumer onRequest;
    final Consumer<? super Subscription> onSubscribe;
    final ParallelFlowable<T> source;

    public static final class ParallelPeekSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        boolean done;
        final Subscriber<? super T> downstream;
        final ParallelPeek<T> parent;
        Subscription upstream;

        public ParallelPeekSubscriber(Subscriber<? super T> r1, ParallelPeek<T> r2) {
            this.downstream = r1;
            this.parent = r2;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.parent.onCancel.run();     // Catch: Throwable -> L4
        L6:
            this.upstream.cancel();
            return;
        L4:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
            goto L6
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done == true) goto L18;
            this.done = true;
            this.parent.onComplete.run();     // Catch: Throwable -> L11
            this.downstream.onComplete();
            this.parent.onAfterTerminated.run();     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
            return;
        L11:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.downstream.onError(th);
            return;
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r3) {
            if (this.done == false) goto L6;
            RxJavaPlugins.onError(r3);
            return;
        L6:
            this.done = true;
            this.parent.onError.accept(r3);     // Catch: Throwable -> L9
        L11:
            this.downstream.onError(r3);
            this.parent.onAfterTerminated.run();     // Catch: Throwable -> L14
            return;
        L14:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
            return;
        L9:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r3 = new CompositeException(new Throwable[]{r3, th});
            goto L11
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r2) {
            if (this.done == true) goto L17;
            this.parent.onNext.accept(r2);     // Catch: Throwable -> L10
            this.downstream.onNext(r2);
            this.parent.onAfterNext.accept(r2);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            onError(th);
            return;
        L10:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            onError(th);
            return;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r3) {
            if (SubscriptionHelper.validate(this.upstream, r3) == false) goto L12;
            this.upstream = r3;
            this.parent.onSubscribe.accept(r3);     // Catch: Throwable -> L7
            this.downstream.onSubscribe(this);
            return;
        L7:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r3.cancel();
            this.downstream.onSubscribe(EmptySubscription.INSTANCE);
            onError(th);
            return;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r2) {
            this.parent.onRequest.accept(r2);     // Catch: Throwable -> L4
        L6:
            this.upstream.request(r2);
            return;
        L4:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
            goto L6
        }
    }

    public ParallelPeek(ParallelFlowable<T> r1, Consumer<? super T> r2, Consumer<? super T> r3, Consumer<? super Throwable> r4, Action r5, Action r6, Consumer<? super Subscription> r7, LongConsumer r8, Action r9) {
        this.source = r1;
        this.onNext = (Consumer) ObjectHelper.requireNonNull(r2, "onNext is null");
        this.onAfterNext = (Consumer) ObjectHelper.requireNonNull(r3, "onAfterNext is null");
        this.onError = (Consumer) ObjectHelper.requireNonNull(r4, "onError is null");
        this.onComplete = (Action) ObjectHelper.requireNonNull(r5, "onComplete is null");
        this.onAfterTerminated = (Action) ObjectHelper.requireNonNull(r6, "onAfterTerminated is null");
        this.onSubscribe = (Consumer) ObjectHelper.requireNonNull(r7, "onSubscribe is null");
        this.onRequest = (LongConsumer) ObjectHelper.requireNonNull(r8, "onRequest is null");
        this.onCancel = (Action) ObjectHelper.requireNonNull(r9, "onCancel is null");
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public int parallelism() {
        return this.source.parallelism();
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public void subscribe(Subscriber<? super T>[] r6) {
        if (validate(r6) == true) goto L5;
        return;
    L5:
        int r0 = r6.length;
        Subscriber<? super T>[] r1 = new Subscriber[r0];
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L8;
        r1[r2] = new ParallelPeekSubscriber(r6[r2], this);
        r2 = r2 + 1;
        goto L6
    L8:
        this.source.subscribe(r1);
    }
}
