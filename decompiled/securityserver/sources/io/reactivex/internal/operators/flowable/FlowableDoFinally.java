package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.Nullable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes2.dex */
public final class FlowableDoFinally<T> extends AbstractFlowableWithUpstream<T, T> {
    final Action onFinally;

    public static final class DoFinallyConditionalSubscriber<T> extends BasicIntQueueSubscription<T> implements ConditionalSubscriber<T> {
        private static final long serialVersionUID = 4109457741734051389L;
        final ConditionalSubscriber<? super T> downstream;
        final Action onFinally;
        QueueSubscription<T> qs;
        boolean syncFused;
        Subscription upstream;

        public DoFinallyConditionalSubscriber(ConditionalSubscriber<? super T> r1, Action r2) {
            this.downstream = r1;
            this.onFinally = r2;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.upstream.cancel();
            runFinally();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.qs.clear();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.qs.isEmpty();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.downstream.onComplete();
            runFinally();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            this.downstream.onError(r2);
            runFinally();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r1) {
            this.downstream.onNext(r1);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r2) {
            if (SubscriptionHelper.validate(this.upstream, r2) == false) goto L9;
            this.upstream = r2;
            if ((r2 instanceof QueueSubscription) == false) goto L7;
            this.qs = (QueueSubscription) r2;
        L7:
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() {
            T r0 = this.qs.poll();
            if (r0 == null) goto L5;
        L7:
            return r0;
        L5:
            if (this.syncFused == false) goto L7;
            runFinally();
            goto L7
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r1) {
            this.upstream.request(r1);
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int r4) {
            QueueSubscription<T> r0 = this.qs;
            boolean r1 = false;
            if (r0 != null) goto L5;
        L13:
            return 0;
        L5:
            if ((r4 & 4) != 0) goto L13;
            int r5 = r0.requestFusion(r4);
            if (r5 != 0) goto L9;
        L12:
            return r5;
        L9:
            if (r5 != 1) goto L11;
            r1 = true;
        L11:
            this.syncFused = r1;
            goto L12
        }

        public void runFinally() {
            if (compareAndSet(0, 1) == false) goto L11;
            this.onFinally.run();     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
            return;
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T r1) {
            return this.downstream.tryOnNext(r1);
        }
    }

    public static final class DoFinallySubscriber<T> extends BasicIntQueueSubscription<T> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = 4109457741734051389L;
        final Subscriber<? super T> downstream;
        final Action onFinally;
        QueueSubscription<T> qs;
        boolean syncFused;
        Subscription upstream;

        public DoFinallySubscriber(Subscriber<? super T> r1, Action r2) {
            this.downstream = r1;
            this.onFinally = r2;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.upstream.cancel();
            runFinally();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.qs.clear();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.qs.isEmpty();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.downstream.onComplete();
            runFinally();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            this.downstream.onError(r2);
            runFinally();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r1) {
            this.downstream.onNext(r1);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r2) {
            if (SubscriptionHelper.validate(this.upstream, r2) == false) goto L9;
            this.upstream = r2;
            if ((r2 instanceof QueueSubscription) == false) goto L7;
            this.qs = (QueueSubscription) r2;
        L7:
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() {
            T r0 = this.qs.poll();
            if (r0 == null) goto L5;
        L7:
            return r0;
        L5:
            if (this.syncFused == false) goto L7;
            runFinally();
            goto L7
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r1) {
            this.upstream.request(r1);
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int r4) {
            QueueSubscription<T> r0 = this.qs;
            boolean r1 = false;
            if (r0 != null) goto L5;
        L13:
            return 0;
        L5:
            if ((r4 & 4) != 0) goto L13;
            int r5 = r0.requestFusion(r4);
            if (r5 != 0) goto L9;
        L12:
            return r5;
        L9:
            if (r5 != 1) goto L11;
            r1 = true;
        L11:
            this.syncFused = r1;
            goto L12
        }

        public void runFinally() {
            if (compareAndSet(0, 1) == false) goto L11;
            this.onFinally.run();     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
            return;
        }
    }

    public FlowableDoFinally(Flowable<T> r1, Action r2) {
        super(r1);
        this.onFinally = r2;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> r3) {
        if ((r3 instanceof ConditionalSubscriber) == false) goto L5;
        this.source.subscribe(new DoFinallyConditionalSubscriber((ConditionalSubscriber) r3, this.onFinally));
        return;
    L5:
        this.source.subscribe(new DoFinallySubscriber(r3, this.onFinally));
    }
}
