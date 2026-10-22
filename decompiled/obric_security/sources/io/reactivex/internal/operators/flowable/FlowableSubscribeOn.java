package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableSubscribeOn<T> extends AbstractFlowableWithUpstream<T, T> {
    final boolean nonScheduledRequests;
    final Scheduler scheduler;

    static final class SubscribeOnSubscriber<T> extends AtomicReference<Thread> implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = 8094547886072529208L;
        final Subscriber<? super T> downstream;
        final boolean nonScheduledRequests;
        final AtomicLong requested;
        Publisher<T> source;
        final AtomicReference<Subscription> upstream;
        final Scheduler.Worker worker;

        static final class Request implements Runnable {
            final long n;
            final Subscription upstream;

            Request(Subscription r1, long r2) {
                this.upstream = r1;
                this.n = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.upstream.request(this.n);
            }
        }

        SubscribeOnSubscriber(Subscriber<? super T> r1, Scheduler.Worker r2, Publisher<T> r3, boolean r4) {
            this.downstream = r1;
            this.worker = r2;
            this.source = r3;
            this.upstream = new AtomicReference();
            this.requested = new AtomicLong();
            this.nonScheduledRequests = !r4;
        }

        @Override // java.lang.Runnable
        public void run() {
            lazySet(Thread.currentThread());
            Publisher<T> r0 = this.source;
            this.source = null;
            r0.subscribe(this);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r6) {
            if (SubscriptionHelper.setOnce(this.upstream, r6) == false) goto L8;
            long r3 = this.requested.getAndSet(0);
            if (r3 == 0) goto L9;
            requestUpstream(r3, r6);
            return;
        L9:
            return;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r1) {
            this.downstream.onNext(r1);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            this.downstream.onError(r2);
            this.worker.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.downstream.onComplete();
            this.worker.dispose();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r5) {
            if (SubscriptionHelper.validate(r5) == false) goto L13;
            Subscription r0 = this.upstream.get();
            if (r0 == null) goto L7;
            requestUpstream(r5, r0);
            return;
        L7:
            BackpressureHelper.add(this.requested, r5);
            Subscription r6 = this.upstream.get();
            if (r6 == null) goto L15;
            long r2 = this.requested.getAndSet(0);
            if (r2 == 0) goto L16;
            requestUpstream(r2, r6);
            return;
        L16:
            return;
        L15:
            return;
        }

        void requestUpstream(long r3, Subscription r5) {
            if (this.nonScheduledRequests == false) goto L5;
        L8:
            r5.request(r3);
            return;
        L5:
            if (Thread.currentThread() == get()) goto L8;
            this.worker.schedule(new Request(r5, r3));
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this.upstream);
            this.worker.dispose();
        }
    }

    public FlowableSubscribeOn(Flowable<T> r1, Scheduler r2, boolean r3) {
        super(r1);
        this.scheduler = r2;
        this.nonScheduledRequests = r3;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> r4) {
        Scheduler.Worker r0 = this.scheduler.createWorker();
        SubscribeOnSubscriber r1 = new SubscribeOnSubscriber(r4, r0, this.source, this.nonScheduledRequests);
        r4.onSubscribe(r1);
        r0.schedule(r1);
    }
}
