package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableTimeoutTimed<T> extends AbstractFlowableWithUpstream<T, T> {
    final Publisher<? extends T> other;
    final Scheduler scheduler;
    final long timeout;
    final TimeUnit unit;

    static final class FallbackSubscriber<T> implements FlowableSubscriber<T> {
        final SubscriptionArbiter arbiter;
        final Subscriber<? super T> downstream;

        FallbackSubscriber(Subscriber<? super T> r1, SubscriptionArbiter r2) {
            this.downstream = r1;
            this.arbiter = r2;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r1) {
            this.arbiter.setSubscription(r1);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r1) {
            this.downstream.onNext(r1);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.downstream.onComplete();
        }
    }

    static final class TimeoutFallbackSubscriber<T> extends SubscriptionArbiter implements FlowableSubscriber<T>, TimeoutSupport {
        private static final long serialVersionUID = 3764492702657003550L;
        long consumed;
        final Subscriber<? super T> downstream;
        Publisher<? extends T> fallback;
        final AtomicLong index;
        final SequentialDisposable task;
        final long timeout;
        final TimeUnit unit;
        final AtomicReference<Subscription> upstream;
        final Scheduler.Worker worker;

        TimeoutFallbackSubscriber(Subscriber<? super T> r2, long r3, TimeUnit r5, Scheduler.Worker r6, Publisher<? extends T> r7) {
            super(true);
            this.downstream = r2;
            this.timeout = r3;
            this.unit = r5;
            this.worker = r6;
            this.fallback = r7;
            this.task = new SequentialDisposable();
            this.upstream = new AtomicReference();
            this.index = new AtomicLong();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r2) {
            if (SubscriptionHelper.setOnce(this.upstream, r2) == false) goto L6;
            setSubscription(r2);
            return;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r8) {
            long r0 = this.index.get();
            if (r0 == Long.MAX_VALUE) goto L9;
            long r5 = r0 + 1;
            if (this.index.compareAndSet(r0, r5) == false) goto L10;
            this.task.get().dispose();
            this.consumed++;
            this.downstream.onNext(r8);
            startTimeout(r5);
            return;
        L10:
            return;
        }

        void startTimeout(long r4) {
            this.task.replace(this.worker.schedule(new TimeoutTask(r4, this), this.timeout, this.unit));
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r6) {
            if (this.index.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L5;
            this.task.dispose();
            this.downstream.onError(r6);
            this.worker.dispose();
            return;
        L5:
            RxJavaPlugins.onError(r6);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.index.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L6;
            this.task.dispose();
            this.downstream.onComplete();
            this.worker.dispose();
            return;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableTimeoutTimed.TimeoutSupport
        public void onTimeout(long r4) {
            if (this.index.compareAndSet(r4, Long.MAX_VALUE) == false) goto L9;
            SubscriptionHelper.cancel(this.upstream);
            long r5 = this.consumed;
            if (r5 == 0) goto L7;
            produced(r5);
        L7:
            Publisher<? extends T> r6 = this.fallback;
            this.fallback = null;
            r6.subscribe(new FallbackSubscriber(this.downstream, this));
            this.worker.dispose();
            return;
        }

        @Override // io.reactivex.internal.subscriptions.SubscriptionArbiter, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.worker.dispose();
        }
    }

    static final class TimeoutSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription, TimeoutSupport {
        private static final long serialVersionUID = 3764492702657003550L;
        final Subscriber<? super T> downstream;
        final AtomicLong requested;
        final SequentialDisposable task;
        final long timeout;
        final TimeUnit unit;
        final AtomicReference<Subscription> upstream;
        final Scheduler.Worker worker;

        TimeoutSubscriber(Subscriber<? super T> r1, long r2, TimeUnit r4, Scheduler.Worker r5) {
            this.downstream = r1;
            this.timeout = r2;
            this.unit = r4;
            this.worker = r5;
            this.task = new SequentialDisposable();
            this.upstream = new AtomicReference();
            this.requested = new AtomicLong();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r2) {
            SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, r2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r5) {
            long r0 = get();
            if (r0 == Long.MAX_VALUE) goto L9;
            long r2 = 1 + r0;
            if (compareAndSet(r0, r2) == false) goto L10;
            this.task.get().dispose();
            this.downstream.onNext(r5);
            startTimeout(r2);
            return;
        L10:
            return;
        }

        void startTimeout(long r4) {
            this.task.replace(this.worker.schedule(new TimeoutTask(r4, this), this.timeout, this.unit));
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r5) {
            if (getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L5;
            this.task.dispose();
            this.downstream.onError(r5);
            this.worker.dispose();
            return;
        L5:
            RxJavaPlugins.onError(r5);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L6;
            this.task.dispose();
            this.downstream.onComplete();
            this.worker.dispose();
            return;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableTimeoutTimed.TimeoutSupport
        public void onTimeout(long r4) {
            if (compareAndSet(r4, Long.MAX_VALUE) == false) goto L6;
            SubscriptionHelper.cancel(this.upstream);
            this.downstream.onError(new TimeoutException(ExceptionHelper.timeoutMessage(this.timeout, this.unit)));
            this.worker.dispose();
            return;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r2) {
            SubscriptionHelper.deferredRequest(this.upstream, this.requested, r2);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this.upstream);
            this.worker.dispose();
        }
    }

    interface TimeoutSupport {
        void onTimeout(long r1);
    }

    static final class TimeoutTask implements Runnable {
        final long idx;
        final TimeoutSupport parent;

        TimeoutTask(long r1, TimeoutSupport r3) {
            this.idx = r1;
            this.parent = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.parent.onTimeout(this.idx);
        }
    }

    public FlowableTimeoutTimed(Flowable<T> r1, long r2, TimeUnit r4, Scheduler r5, Publisher<? extends T> r6) {
        super(r1);
        this.timeout = r2;
        this.unit = r4;
        this.scheduler = r5;
        this.other = r6;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> r11) {
        if (this.other != null) goto L5;
        TimeoutSubscriber r0 = new TimeoutSubscriber(r11, this.timeout, this.unit, this.scheduler.createWorker());
        r11.onSubscribe(r0);
        r0.startTimeout(0);
        this.source.subscribe(r0);
        return;
    L5:
        TimeoutFallbackSubscriber r1 = new TimeoutFallbackSubscriber(r11, this.timeout, this.unit, this.scheduler.createWorker(), this.other);
        r11.onSubscribe(r1);
        r1.startTimeout(0);
        this.source.subscribe(r1);
    }
}
