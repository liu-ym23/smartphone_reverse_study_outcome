package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes2.dex */
public final class CompletableConcat extends Completable {
    final int prefetch;
    final Publisher<? extends CompletableSource> sources;

    public static final class CompletableConcatSubscriber extends AtomicInteger implements FlowableSubscriber<CompletableSource>, Disposable {
        private static final long serialVersionUID = 9032184911934499404L;
        volatile boolean active;
        int consumed;
        volatile boolean done;
        final CompletableObserver downstream;
        final ConcatInnerObserver inner;
        final int limit;
        final AtomicBoolean once;
        final int prefetch;
        SimpleQueue<CompletableSource> queue;
        int sourceFused;
        Subscription upstream;

        public static final class ConcatInnerObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = -5454794857847146511L;
            final CompletableConcatSubscriber parent;

            public ConcatInnerObserver(CompletableConcatSubscriber r1) {
                this.parent = r1;
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onComplete() {
                this.parent.innerComplete();
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(Throwable r1) {
                this.parent.innerError(r1);
            }

            @Override // io.reactivex.CompletableObserver
            public void onSubscribe(Disposable r1) {
                DisposableHelper.replace(this, r1);
            }
        }

        public CompletableConcatSubscriber(CompletableObserver r1, int r2) {
            this.downstream = r1;
            this.prefetch = r2;
            this.inner = new ConcatInnerObserver(this);
            this.once = new AtomicBoolean();
            this.limit = r2 - (r2 >> 2);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.upstream.cancel();
            DisposableHelper.dispose(this.inner);
        }

        public void drain() {
            if (getAndIncrement() == 0) goto L6;
            return;
        L6:
            if (isDisposed() == true) goto L7;
            if (this.active == true) goto L28;
            boolean r0 = this.done;
            CompletableSource r1 = this.queue.poll();     // Catch: Throwable -> L24
            if (r1 != null) goto L15;
            boolean r4 = true;
        L16:
            if (r0 == false) goto L22;
            if (r4 == false) goto L22;
            if (this.once.compareAndSet(false, true) == false) goto L36;
            this.downstream.onComplete();
            return;
        L36:
            return;
        L22:
            if (r4 == true) goto L28;
            this.active = true;
            r1.subscribe(this.inner);
            request();
            goto L28
        L15:
            r4 = false;
        L24:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            innerError(th);
            return;
        L28:
            if (decrementAndGet() != 0) goto L6;
            return;
        }

        public void innerComplete() {
            this.active = false;
            drain();
        }

        public void innerError(Throwable r4) {
            if (this.once.compareAndSet(false, true) == false) goto L5;
            this.upstream.cancel();
            this.downstream.onError(r4);
            return;
        L5:
            RxJavaPlugins.onError(r4);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.inner.get());
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r4) {
            if (this.once.compareAndSet(false, true) == false) goto L5;
            DisposableHelper.dispose(this.inner);
            this.downstream.onError(r4);
            return;
        L5:
            RxJavaPlugins.onError(r4);
        }

        @Override // org.reactivestreams.Subscriber
        public /* bridge */ /* synthetic */ void onNext(Object r1) {
            onNext((CompletableSource) r1);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r7) {
            if (SubscriptionHelper.validate(this.upstream, r7) == false) goto L24;
            this.upstream = r7;
            int r0 = this.prefetch;
            if (r0 != Integer.MAX_VALUE) goto L7;
            long r2 = Long.MAX_VALUE;
        L9:
            if ((r7 instanceof QueueSubscription) == false) goto L19;
            QueueSubscription r1 = (QueueSubscription) r7;
            int r4 = r1.requestFusion(3);
            if (r4 != 1) goto L15;
            this.sourceFused = r4;
            this.queue = r1;
            this.done = true;
            this.downstream.onSubscribe(this);
            drain();
            return;
        L15:
            if (r4 != 2) goto L19;
            this.sourceFused = r4;
            this.queue = r1;
            this.downstream.onSubscribe(this);
            r7.request(r2);
            return;
        L19:
            if (this.prefetch != Integer.MAX_VALUE) goto L21;
            this.queue = new SpscLinkedArrayQueue(Flowable.bufferSize());
        L22:
            this.downstream.onSubscribe(this);
            r7.request(r2);
            return;
        L21:
            this.queue = new SpscArrayQueue(this.prefetch);
            goto L22
        L7:
            r2 = r0;
            goto L9
        }

        public void request() {
            if (this.sourceFused == 1) goto L9;
            int r0 = this.consumed + 1;
            if (r0 != this.limit) goto L7;
            this.consumed = 0;
            this.upstream.request(r0);
            return;
        L7:
            this.consumed = r0;
            return;
        }

        public void onNext(CompletableSource r2) {
            if (this.sourceFused == 0) goto L5;
        L8:
            drain();
            return;
        L5:
            if (this.queue.offer(r2) == true) goto L8;
            onError(new MissingBackpressureException());
        }
    }

    public CompletableConcat(Publisher<? extends CompletableSource> r1, int r2) {
        this.sources = r1;
        this.prefetch = r2;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver r3) {
        this.sources.subscribe(new CompletableConcatSubscriber(r3, this.prefetch));
    }
}
