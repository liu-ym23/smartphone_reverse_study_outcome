package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableSampleTimed<T> extends AbstractFlowableWithUpstream<T, T> {
    final boolean emitLast;
    final long period;
    final Scheduler scheduler;
    final TimeUnit unit;

    static final class SampleTimedEmitLast<T> extends SampleTimedSubscriber<T> {
        private static final long serialVersionUID = -7139995637533111443L;
        final AtomicInteger wip;

        SampleTimedEmitLast(Subscriber<? super T> r1, long r2, TimeUnit r4, Scheduler r5) {
            super(r1, r2, r4, r5);
            this.wip = new AtomicInteger(1);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSampleTimed.SampleTimedSubscriber
        void complete() {
            emit();
            if (this.wip.decrementAndGet() != 0) goto L6;
            this.downstream.onComplete();
            return;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.wip.incrementAndGet() != 2) goto L8;
            emit();
            if (this.wip.decrementAndGet() != 0) goto L9;
            this.downstream.onComplete();
            return;
        L9:
            return;
        }
    }

    static final class SampleTimedNoLast<T> extends SampleTimedSubscriber<T> {
        private static final long serialVersionUID = -7139995637533111443L;

        SampleTimedNoLast(Subscriber<? super T> r1, long r2, TimeUnit r4, Scheduler r5) {
            super(r1, r2, r4, r5);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSampleTimed.SampleTimedSubscriber
        void complete() {
            this.downstream.onComplete();
        }

        @Override // java.lang.Runnable
        public void run() {
            emit();
        }
    }

    static abstract class SampleTimedSubscriber<T> extends AtomicReference<T> implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = -3517602651313910099L;
        final Subscriber<? super T> downstream;
        final long period;
        final AtomicLong requested;
        final Scheduler scheduler;
        final SequentialDisposable timer;
        final TimeUnit unit;
        Subscription upstream;

        abstract void complete();

        SampleTimedSubscriber(Subscriber<? super T> r2, long r3, TimeUnit r5, Scheduler r6) {
            this.requested = new AtomicLong();
            this.timer = new SequentialDisposable();
            this.downstream = r2;
            this.period = r3;
            this.unit = r5;
            this.scheduler = r6;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r9) {
            if (SubscriptionHelper.validate(this.upstream, r9) == false) goto L6;
            this.upstream = r9;
            this.downstream.onSubscribe(this);
            SequentialDisposable r0 = this.timer;
            Scheduler r1 = this.scheduler;
            long r5 = this.period;
            r0.replace(r1.schedulePeriodicallyDirect(this, r5, r5, this.unit));
            r9.request(Long.MAX_VALUE);
            return;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r1) {
            lazySet(r1);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r1) {
            cancelTimer();
            this.downstream.onError(r1);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            cancelTimer();
            complete();
        }

        void cancelTimer() {
            DisposableHelper.dispose(this.timer);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L6;
            BackpressureHelper.add(this.requested, r2);
            return;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            cancelTimer();
            this.upstream.cancel();
        }

        void emit() {
            T r0 = getAndSet(null);
            if (r0 != null) goto L5;
            return;
        L5:
            if (this.requested.get() == 0) goto L7;
            this.downstream.onNext(r0);
            BackpressureHelper.produced(this.requested, 1);
            return;
        L7:
            cancel();
            this.downstream.onError(new MissingBackpressureException("Couldn't emit value due to lack of requests!"));
        }
    }

    public FlowableSampleTimed(Flowable<T> r1, long r2, TimeUnit r4, Scheduler r5, boolean r6) {
        super(r1);
        this.period = r2;
        this.unit = r4;
        this.scheduler = r5;
        this.emitLast = r6;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> r8) {
        SerializedSubscriber r1 = new SerializedSubscriber(r8);
        if (this.emitLast == false) goto L5;
        this.source.subscribe(new SampleTimedEmitLast(r1, this.period, this.unit, this.scheduler));
        return;
    L5:
        this.source.subscribe(new SampleTimedNoLast(r1, this.period, this.unit, this.scheduler));
    }
}
