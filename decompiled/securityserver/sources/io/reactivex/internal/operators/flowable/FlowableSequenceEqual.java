package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes2.dex */
public final class FlowableSequenceEqual<T> extends Flowable<Boolean> {
    final BiPredicate<? super T, ? super T> comparer;
    final Publisher<? extends T> first;
    final int prefetch;
    final Publisher<? extends T> second;

    public static final class EqualCoordinator<T> extends DeferredScalarSubscription<Boolean> implements EqualCoordinatorHelper {
        private static final long serialVersionUID = -6178010334400373240L;
        final BiPredicate<? super T, ? super T> comparer;
        final AtomicThrowable error;
        final EqualSubscriber<T> first;
        final EqualSubscriber<T> second;
        T v1;
        T v2;
        final AtomicInteger wip;

        public EqualCoordinator(Subscriber<? super Boolean> r1, int r2, BiPredicate<? super T, ? super T> r3) {
            super(r1);
            this.comparer = r3;
            this.wip = new AtomicInteger();
            this.first = new EqualSubscriber(this, r2);
            this.second = new EqualSubscriber(this, r2);
            this.error = new AtomicThrowable();
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.first.cancel();
            this.second.cancel();
            if (this.wip.getAndIncrement() != 0) goto L6;
            this.first.clear();
            this.second.clear();
            return;
        }

        public void cancelAndClear() {
            this.first.cancel();
            this.first.clear();
            this.second.cancel();
            this.second.clear();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSequenceEqual.EqualCoordinatorHelper
        public void drain() {
            if (this.wip.getAndIncrement() == 0) goto L5;
            return;
        L5:
            int r1 = 1;
        L6:
            SimpleQueue<T> r2 = this.first.queue;
            SimpleQueue<T> r3 = this.second.queue;
            if (r2 == null) goto L60;
            if (r3 == null) goto L60;
        L10:
            if (isCancelled() == true) goto L11;
            if (this.error.get() != null) goto L15;
            boolean r4 = this.first.done;
            T r5 = this.v1;
            if (r5 == null) goto L70;
        L24:
            boolean r6 = false;
            if (r5 != null) goto L27;
            boolean r7 = true;
        L28:
            boolean r8 = this.second.done;
            T r9 = this.v2;
            if (r9 == null) goto L74;
        L35:
            if (r9 != null) goto L37;
            r6 = true;
        L37:
            if (r4 == false) goto L43;
            if (r8 == false) goto L43;
            if (r7 == false) goto L43;
            if (r6 == false) goto L43;
            complete(Boolean.TRUE);
            return;
        L43:
            if (r4 == false) goto L48;
            if (r8 == false) goto L48;
            if (r7 == r6) goto L48;
            cancelAndClear();
            complete(Boolean.FALSE);
            return;
        L48:
            if (r7 == true) goto L67;
            if (r6 == true) goto L67;
            if (this.comparer.test(r5, r9) == false) goto L53;
            this.v1 = null;
            this.v2 = null;
            this.first.request();
            this.second.request();
            goto L10
        L53:
            cancelAndClear();
            complete(Boolean.FALSE);
            return;
        L56:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            cancelAndClear();
            this.error.addThrowable(th);
            this.downstream.onError(this.error.terminate());
            return;
        L67:
            r1 = this.wip.addAndGet(-r1);
            if (r1 != 0) goto L6;
            return;
        L74:
            r9 = r3.poll();     // Catch: Throwable -> L32
            this.v2 = r9;
        L32:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            cancelAndClear();
            this.error.addThrowable(th);
            this.downstream.onError(this.error.terminate());
            return;
        L27:
            r7 = false;
            goto L28
        L70:
            r5 = r2.poll();     // Catch: Throwable -> L21
            this.v1 = r5;
        L21:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            cancelAndClear();
            this.error.addThrowable(th);
            this.downstream.onError(this.error.terminate());
            return;
        L15:
            cancelAndClear();
            this.downstream.onError(this.error.terminate());
            return;
        L11:
            this.first.clear();
            this.second.clear();
            return;
        L60:
            if (isCancelled() == true) goto L61;
            if (this.error.get() == null) goto L67;
            cancelAndClear();
            this.downstream.onError(this.error.terminate());
            return;
        L61:
            this.first.clear();
            this.second.clear();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSequenceEqual.EqualCoordinatorHelper
        public void innerError(Throwable r2) {
            if (this.error.addThrowable(r2) == false) goto L5;
            drain();
            return;
        L5:
            RxJavaPlugins.onError(r2);
        }

        public void subscribe(Publisher<? extends T> r2, Publisher<? extends T> r3) {
            r2.subscribe(this.first);
            r3.subscribe(this.second);
        }
    }

    public interface EqualCoordinatorHelper {
        void drain();

        void innerError(Throwable r1);
    }

    public static final class EqualSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = 4804128302091633067L;
        volatile boolean done;
        final int limit;
        final EqualCoordinatorHelper parent;
        final int prefetch;
        long produced;
        volatile SimpleQueue<T> queue;
        int sourceMode;

        public EqualSubscriber(EqualCoordinatorHelper r1, int r2) {
            this.parent = r1;
            this.limit = r2 - (r2 >> 2);
            this.prefetch = r2;
        }

        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        public void clear() {
            SimpleQueue<T> r0 = this.queue;
            if (r0 == null) goto L6;
            r0.clear();
            return;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r1) {
            this.parent.innerError(r1);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r2) {
            if (this.sourceMode == 0) goto L5;
        L8:
            this.parent.drain();
            return;
        L5:
            if (this.queue.offer(r2) == true) goto L8;
            onError(new MissingBackpressureException());
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r4) {
            if (SubscriptionHelper.setOnce(this, r4) == true) goto L5;
            return;
        L5:
            if ((r4 instanceof QueueSubscription) == false) goto L14;
            QueueSubscription r0 = (QueueSubscription) r4;
            int r1 = r0.requestFusion(3);
            if (r1 != 1) goto L11;
            this.sourceMode = r1;
            this.queue = r0;
            this.done = true;
            this.parent.drain();
            return;
        L11:
            if (r1 != 2) goto L14;
            this.sourceMode = r1;
            this.queue = r0;
            r4.request(this.prefetch);
            return;
        L14:
            this.queue = new SpscArrayQueue(this.prefetch);
            r4.request(this.prefetch);
        }

        public void request() {
            if (this.sourceMode == 1) goto L9;
            long r0 = this.produced + 1;
            if (r0 < this.limit) goto L7;
            this.produced = 0;
            get().request(r0);
            return;
        L7:
            this.produced = r0;
            return;
        }
    }

    public FlowableSequenceEqual(Publisher<? extends T> r1, Publisher<? extends T> r2, BiPredicate<? super T, ? super T> r3, int r4) {
        this.first = r1;
        this.second = r2;
        this.comparer = r3;
        this.prefetch = r4;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super Boolean> r4) {
        EqualCoordinator r0 = new EqualCoordinator(r4, this.prefetch, this.comparer);
        r4.onSubscribe(r0);
        r0.subscribe(this.first, this.second);
    }
}
