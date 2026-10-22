package io.reactivex.internal.operators.parallel;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes2.dex */
public final class ParallelMap<T, R> extends ParallelFlowable<R> {
    final Function<? super T, ? extends R> mapper;
    final ParallelFlowable<T> source;

    public static final class ParallelMapConditionalSubscriber<T, R> implements ConditionalSubscriber<T>, Subscription {
        boolean done;
        final ConditionalSubscriber<? super R> downstream;
        final Function<? super T, ? extends R> mapper;
        Subscription upstream;

        public ParallelMapConditionalSubscriber(ConditionalSubscriber<? super R> r1, Function<? super T, ? extends R> r2) {
            this.downstream = r1;
            this.mapper = r2;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.upstream.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            if (this.done == false) goto L6;
            RxJavaPlugins.onError(r2);
            return;
        L6:
            this.done = true;
            this.downstream.onError(r2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r2) {
            if (this.done == false) goto L11;
            return;
        L11:
            Object r3 = ObjectHelper.requireNonNull(this.mapper.apply(r2), "The mapper returned a null value");     // Catch: Throwable -> L8
            this.downstream.onNext(r3);
            return;
        L8:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            cancel();
            onError(th);
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

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T r3) {
            if (this.done == false) goto L11;
            return false;
        L11:
            Object r4 = ObjectHelper.requireNonNull(this.mapper.apply(r3), "The mapper returned a null value");     // Catch: Throwable -> L8
            return this.downstream.tryOnNext(r4);
        L8:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            cancel();
            onError(th);
            return false;
        }
    }

    public static final class ParallelMapSubscriber<T, R> implements FlowableSubscriber<T>, Subscription {
        boolean done;
        final Subscriber<? super R> downstream;
        final Function<? super T, ? extends R> mapper;
        Subscription upstream;

        public ParallelMapSubscriber(Subscriber<? super R> r1, Function<? super T, ? extends R> r2) {
            this.downstream = r1;
            this.mapper = r2;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.upstream.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            if (this.done == false) goto L6;
            RxJavaPlugins.onError(r2);
            return;
        L6:
            this.done = true;
            this.downstream.onError(r2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r2) {
            if (this.done == false) goto L11;
            return;
        L11:
            Object r3 = ObjectHelper.requireNonNull(this.mapper.apply(r2), "The mapper returned a null value");     // Catch: Throwable -> L8
            this.downstream.onNext(r3);
            return;
        L8:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            cancel();
            onError(th);
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
    }

    public ParallelMap(ParallelFlowable<T> r1, Function<? super T, ? extends R> r2) {
        this.source = r1;
        this.mapper = r2;
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public int parallelism() {
        return this.source.parallelism();
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public void subscribe(Subscriber<? super R>[] r7) {
        if (validate(r7) == true) goto L5;
        return;
    L5:
        int r0 = r7.length;
        Subscriber<? super T>[] r1 = new Subscriber[r0];
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L12;
        Subscriber<? super R> r3 = r7[r2];
        if ((r3 instanceof ConditionalSubscriber) == false) goto L10;
        r1[r2] = new ParallelMapConditionalSubscriber((ConditionalSubscriber) r3, this.mapper);
    L11:
        r2 = r2 + 1;
        goto L6
    L10:
        r1[r2] = new ParallelMapSubscriber(r3, this.mapper);
        goto L11
    L12:
        this.source.subscribe(r1);
    }
}
