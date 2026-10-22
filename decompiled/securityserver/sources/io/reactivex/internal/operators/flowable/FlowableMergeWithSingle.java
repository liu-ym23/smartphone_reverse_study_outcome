package io.reactivex.internal.operators.flowable;

import android.R;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes2.dex */
public final class FlowableMergeWithSingle<T> extends AbstractFlowableWithUpstream<T, T> {
    final SingleSource<? extends T> other;

    public static final class MergeWithObserver<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        static final int OTHER_STATE_CONSUMED_OR_EMPTY = 2;
        static final int OTHER_STATE_HAS_VALUE = 1;
        private static final long serialVersionUID = -4592979584110982903L;
        volatile boolean cancelled;
        int consumed;
        final Subscriber<? super T> downstream;
        long emitted;
        final AtomicThrowable error;
        final int limit;
        volatile boolean mainDone;
        final AtomicReference<Subscription> mainSubscription;
        final OtherObserver<T> otherObserver;
        volatile int otherState;
        final int prefetch;
        volatile SimplePlainQueue<T> queue;
        final AtomicLong requested;
        T singleItem;

        public static final class OtherObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T> {
            private static final long serialVersionUID = -2935427570954647017L;
            final MergeWithObserver<T> parent;

            public OtherObserver(MergeWithObserver<T> r1) {
                this.parent = r1;
            }

            @Override // io.reactivex.SingleObserver
            public void onError(Throwable r1) {
                this.parent.otherError(r1);
            }

            @Override // io.reactivex.SingleObserver
            public void onSubscribe(Disposable r1) {
                DisposableHelper.setOnce(this, r1);
            }

            @Override // io.reactivex.SingleObserver
            public void onSuccess(T r1) {
                this.parent.otherSuccess(r1);
            }
        }

        public MergeWithObserver(Subscriber<? super T> r2) {
            this.downstream = r2;
            this.mainSubscription = new AtomicReference();
            this.otherObserver = new OtherObserver(this);
            this.error = new AtomicThrowable();
            this.requested = new AtomicLong();
            int r3 = Flowable.bufferSize();
            this.prefetch = r3;
            this.limit = r3 - (r3 >> 2);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            SubscriptionHelper.cancel(this.mainSubscription);
            DisposableHelper.dispose(this.otherObserver);
            if (getAndIncrement() != 0) goto L6;
            this.queue = null;
            this.singleItem = null;
            return;
        }

        public void drain() {
            if (getAndIncrement() != 0) goto L6;
            drainLoop();
            return;
        }

        public void drainLoop() {
            Subscriber<? super T> r1 = this.downstream;
            long r2 = this.emitted;
            int r4 = this.consumed;
            int r5 = this.limit;
            int r6 = 1;
            int r7 = 1;
        L3:
            long r8 = this.requested.get();
        L5:
            if (r2 == r8) goto L35;
            if (this.cancelled == true) goto L8;
            if (this.error.get() != null) goto L12;
            int r14 = this.otherState;
            if (r14 == r6) goto L16;
            boolean r9 = this.mainDone;
            SimplePlainQueue<T> r11 = this.queue;
            if (r11 == null) goto L20;
            R.animator r12 = r11.poll();
        L21:
            if (r12 != null) goto L23;
            boolean r17 = true;
        L24:
            if (r9 == false) goto L29;
            if (r17 == false) goto L29;
            if (r14 != 2) goto L29;
            this.queue = null;
            r1.onComplete();
            return;
        L29:
            if (r17 == true) goto L35;
            r1.onNext(r12);
            r2 = r2 + 1;
            r4 = r4 + 1;
            if (r4 != r5) goto L34;
            this.mainSubscription.get().request(r5);
            r4 = 0;
        L34:
            r6 = 1;
            goto L5
        L23:
            r17 = false;
            goto L24
        L20:
            r12 = null;
            goto L21
        L16:
            T r10 = this.singleItem;
            this.singleItem = null;
            this.otherState = 2;
            r1.onNext(r10);
            r2 = r2 + 1;
            goto L5
        L12:
            this.singleItem = null;
            this.queue = null;
            r1.onError(this.error.terminate());
            return;
        L8:
            this.singleItem = null;
            this.queue = null;
            return;
        L35:
            if (r2 == r8) goto L37;
        L57:
            this.emitted = r2;
            this.consumed = r4;
            r7 = addAndGet(-r7);
            if (r7 == 0) goto L59;
            r6 = 1;
            goto L3
        L59:
            return;
        L37:
            if (this.cancelled == true) goto L38;
            if (this.error.get() != null) goto L42;
            boolean r13 = this.mainDone;
            SimplePlainQueue<T> r15 = this.queue;
            if (r15 != null) goto L47;
        L50:
            boolean r16 = true;
        L51:
            if (r13 == false) goto L57;
            if (r16 == false) goto L57;
            if (this.otherState != 2) goto L57;
            this.queue = null;
            r1.onComplete();
            return;
        L47:
            if (r15.isEmpty() == true) goto L50;
            r16 = false;
            goto L51
        L42:
            this.singleItem = null;
            this.queue = null;
            r1.onError(this.error.terminate());
            return;
        L38:
            this.singleItem = null;
            this.queue = null;
        }

        public SimplePlainQueue<T> getOrCreateQueue() {
            SimplePlainQueue<T> r0 = this.queue;
            if (r0 != null) goto L6;
            SpscArrayQueue r1 = new SpscArrayQueue(Flowable.bufferSize());
            this.queue = r1;
            return r1;
        L6:
            return r0;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.mainDone = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            if (this.error.addThrowable(r2) == false) goto L5;
            DisposableHelper.dispose(this.otherObserver);
            drain();
            return;
        L5:
            RxJavaPlugins.onError(r2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r7) {
            if (compareAndSet(0, 1) == false) goto L20;
            long r2 = this.emitted;
            if (this.requested.get() == r2) goto L16;
            SimplePlainQueue<T> r4 = this.queue;
            if (r4 != null) goto L9;
        L12:
            this.emitted = r2 + 1;
            this.downstream.onNext(r7);
            int r8 = this.consumed + 1;
            if (r8 != this.limit) goto L15;
            this.consumed = 0;
            this.mainSubscription.get().request(r8);
        L18:
            if (decrementAndGet() != 0) goto L23;
            return;
        L23:
            drainLoop();
            return;
        L15:
            this.consumed = r8;
            goto L18
        L9:
            if (r4.isEmpty() == true) goto L12;
            r4.offer(r7);
            goto L18
        L16:
            getOrCreateQueue().offer(r7);
            goto L18
        L20:
            getOrCreateQueue().offer(r7);
            if (getAndIncrement() == 0) goto L23;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r4) {
            SubscriptionHelper.setOnce(this.mainSubscription, r4, this.prefetch);
        }

        public void otherError(Throwable r2) {
            if (this.error.addThrowable(r2) == false) goto L5;
            SubscriptionHelper.cancel(this.mainSubscription);
            drain();
            return;
        L5:
            RxJavaPlugins.onError(r2);
        }

        public void otherSuccess(T r7) {
            if (compareAndSet(0, 1) == false) goto L10;
            long r2 = this.emitted;
            if (this.requested.get() == r2) goto L7;
            this.emitted = r2 + 1;
            this.downstream.onNext(r7);
            this.otherState = 2;
        L13:
            drainLoop();
            return;
        L7:
            this.singleItem = r7;
            this.otherState = 1;
            if (decrementAndGet() != 0) goto L13;
            return;
        L10:
            this.singleItem = r7;
            this.otherState = 1;
            if (getAndIncrement() == 0) goto L13;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r2) {
            BackpressureHelper.add(this.requested, r2);
            drain();
        }
    }

    public FlowableMergeWithSingle(Flowable<T> r1, SingleSource<? extends T> r2) {
        super(r1);
        this.other = r2;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> r2) {
        MergeWithObserver r0 = new MergeWithObserver(r2);
        r2.onSubscribe(r0);
        this.source.subscribe(r0);
        this.other.subscribe(r0.otherObserver);
    }
}
