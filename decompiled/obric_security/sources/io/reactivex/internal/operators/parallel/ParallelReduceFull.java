package io.reactivex.internal.operators.parallel;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import tmsdkobf.b0$$ExternalSyntheticBackport0;

/* JADX INFO: loaded from: classes5.dex */
public final class ParallelReduceFull<T> extends Flowable<T> {
    final BiFunction<T, T, T> reducer;
    final ParallelFlowable<? extends T> source;

    static final class ParallelReduceFullInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -7954444275102466525L;
        boolean done;
        final ParallelReduceFullMainSubscriber<T> parent;
        final BiFunction<T, T, T> reducer;
        T value;

        ParallelReduceFullInnerSubscriber(ParallelReduceFullMainSubscriber<T> r1, BiFunction<T, T, T> r2) {
            this.parent = r1;
            this.reducer = r2;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r3) {
            SubscriptionHelper.setOnce(this, r3, Long.MAX_VALUE);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r3) {
            if (this.done == true) goto L14;
            T r0 = this.value;
            if (r0 != null) goto L12;
            this.value = r3;
            return;
        L12:
            this.value = (T) ObjectHelper.requireNonNull(this.reducer.apply(r0, r3), "The reducer returned a null value");
            return;
        L9:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            get().cancel();
            onError(th);
            return;
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            if (this.done == false) goto L6;
            RxJavaPlugins.onError(r2);
            return;
        L6:
            this.done = true;
            this.parent.innerError(r2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done == true) goto L6;
            this.done = true;
            this.parent.innerComplete(this.value);
            return;
        }

        void cancel() {
            SubscriptionHelper.cancel(this);
        }
    }

    static final class ParallelReduceFullMainSubscriber<T> extends DeferredScalarSubscription<T> {
        private static final long serialVersionUID = -5370107872170712765L;
        final AtomicReference<SlotPair<T>> current;
        final AtomicReference<Throwable> error;
        final BiFunction<T, T, T> reducer;
        final AtomicInteger remaining;
        final ParallelReduceFullInnerSubscriber<T>[] subscribers;

        ParallelReduceFullMainSubscriber(Subscriber<? super T> r3, int r4, BiFunction<T, T, T> r5) {
            super(r3);
            this.current = new AtomicReference();
            this.remaining = new AtomicInteger();
            this.error = new AtomicReference();
            ParallelReduceFullInnerSubscriber<T>[] r6 = new ParallelReduceFullInnerSubscriber[r4];
            int r0 = 0;
        L3:
            if (r0 >= r4) goto L5;
            r6[r0] = new ParallelReduceFullInnerSubscriber(this, r5);
            r0 = r0 + 1;
            goto L3
        L5:
            this.subscribers = r6;
            this.reducer = r5;
            this.remaining.lazySet(r4);
        }

        SlotPair<T> addValue(T r4) {
        L2:
            SlotPair<T> r0 = this.current.get();
            if (r0 != null) goto L7;
            r0 = new SlotPair();
            if (b0$$ExternalSyntheticBackport0.m(this.current, null, r0) == false) goto L2;
        L7:
            int r2 = r0.tryAcquireSlot();
            if (r2 >= 0) goto L10;
            b0$$ExternalSyntheticBackport0.m(this.current, r0, null);
            goto L2
        L10:
            if (r2 != 0) goto L12;
            r0.first = r4;
        L14:
            if (r0.releaseSlot() == false) goto L17;
            b0$$ExternalSyntheticBackport0.m(this.current, r0, null);
            return r0;
        L17:
            return null;
        L12:
            r0.second = r4;
            goto L14
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            ParallelReduceFullInnerSubscriber<T>[] r3 = this.subscribers;
            int r0 = r3.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            r3[r1].cancel();
            r1 = r1 + 1;
            goto L3
        }

        void innerError(Throwable r3) {
            if (b0$$ExternalSyntheticBackport0.m(this.error, null, r3) == false) goto L6;
            cancel();
            this.downstream.onError(r3);
            return;
        L6:
            if (r3 == this.error.get()) goto L10;
            RxJavaPlugins.onError(r3);
            return;
        }

        void innerComplete(T r3) {
            if (r3 == null) goto L11;
        L3:
            SlotPair<T> r4 = addValue(r3);
            if (r4 == null) goto L11;
            r3 = (T) ObjectHelper.requireNonNull(this.reducer.apply(r4.first, r4.second), "The reducer returned a null value");
        L7:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            innerError(th);
            return;
        L11:
            if (this.remaining.decrementAndGet() != 0) goto L21;
            SlotPair<T> r5 = this.current.get();
            this.current.lazySet(null);
            if (r5 == null) goto L15;
            complete(r5.first);
            return;
        L15:
            this.downstream.onComplete();
            return;
        }
    }

    static final class SlotPair<T> extends AtomicInteger {
        private static final long serialVersionUID = 473971317683868662L;
        T first;
        final AtomicInteger releaseIndex;
        T second;

        SlotPair() {
            this.releaseIndex = new AtomicInteger();
        }

        int tryAcquireSlot() {
        L2:
            int r0 = get();
            if (r0 >= 2) goto L4;
            if (compareAndSet(r0, r0 + 1) == false) goto L2;
            return r0;
        L4:
            return -1;
        }

        boolean releaseSlot() {
            if (this.releaseIndex.incrementAndGet() != 2) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public ParallelReduceFull(ParallelFlowable<? extends T> r1, BiFunction<T, T, T> r2) {
        this.source = r1;
        this.reducer = r2;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> r4) {
        ParallelReduceFullMainSubscriber r0 = new ParallelReduceFullMainSubscriber(r4, this.source.parallelism(), this.reducer);
        r4.onSubscribe(r0);
        this.source.subscribe(r0.subscribers);
    }
}
