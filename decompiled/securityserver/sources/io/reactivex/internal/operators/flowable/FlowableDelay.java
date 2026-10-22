package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes2.dex */
public final class FlowableDelay<T> extends AbstractFlowableWithUpstream<T, T> {
    final long delay;
    final boolean delayError;
    final Scheduler scheduler;
    final TimeUnit unit;

    public static final class DelaySubscriber<T> implements FlowableSubscriber<T>, Subscription {
        final long delay;
        final boolean delayError;
        final Subscriber<? super T> downstream;
        final TimeUnit unit;
        Subscription upstream;
        final Scheduler.Worker w;

        public final class OnComplete implements Runnable {
            final /* synthetic */ DelaySubscriber this$0;

            public OnComplete(DelaySubscriber r1) {
                this.this$0 = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.this$0.downstream.onComplete();     // Catch: Throwable -> L5
                this.this$0.w.dispose();
                return;
            L5:
                th = move-exception;
                this.this$0.w.dispose();
                throw th;
            }
        }

        public final class OnError implements Runnable {
            private final Throwable t;
            final /* synthetic */ DelaySubscriber this$0;

            public OnError(DelaySubscriber r1, Throwable r2) {
                this.this$0 = r1;
                this.t = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.this$0.downstream.onError(this.t);     // Catch: Throwable -> L5
                this.this$0.w.dispose();
                return;
            L5:
                th = move-exception;
                this.this$0.w.dispose();
                throw th;
            }
        }

        public final class OnNext implements Runnable {
            private final T t;
            final /* synthetic */ DelaySubscriber this$0;

            public OnNext(DelaySubscriber r1, T r2) {
                this.this$0 = r1;
                this.t = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.this$0.downstream.onNext(this.t);
            }
        }

        public DelaySubscriber(Subscriber<? super T> r1, long r2, TimeUnit r4, Scheduler.Worker r5, boolean r6) {
            this.downstream = r1;
            this.delay = r2;
            this.unit = r4;
            this.w = r5;
            this.delayError = r6;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.upstream.cancel();
            this.w.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.w.schedule(new OnComplete(this), this.delay, this.unit);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r5) {
            Scheduler.Worker r0 = this.w;
            OnError r1 = new OnError(this, r5);
            if (this.delayError == false) goto L5;
            long r2 = this.delay;
        L6:
            r0.schedule(r1, r2, this.unit);
            return;
        L5:
            r2 = 0;
            goto L6
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r5) {
            this.w.schedule(new OnNext(this, r5), this.delay, this.unit);
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

    public FlowableDelay(Flowable<T> r1, long r2, TimeUnit r4, Scheduler r5, boolean r6) {
        super(r1);
        this.delay = r2;
        this.unit = r4;
        this.scheduler = r5;
        this.delayError = r6;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> r9) {
        if (this.delayError == false) goto L5;
        Subscriber<? super T> r2 = r9;
    L6:
        Scheduler.Worker r6 = this.scheduler.createWorker();
        this.source.subscribe(new DelaySubscriber(r2, this.delay, this.unit, r6, this.delayError));
        return;
    L5:
        r2 = new SerializedSubscriber(r9);
        goto L6
    }
}
