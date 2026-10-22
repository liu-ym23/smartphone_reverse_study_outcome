package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes2.dex */
public final class FlowableWithLatestFromMany<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final Function<? super Object[], R> combiner;

    @Nullable
    final Publisher<?>[] otherArray;

    @Nullable
    final Iterable<? extends Publisher<?>> otherIterable;

    public final class SingletonArrayFunc implements Function<T, R> {
        final /* synthetic */ FlowableWithLatestFromMany this$0;

        public SingletonArrayFunc(FlowableWithLatestFromMany r1) {
            this.this$0 = r1;
        }

        @Override // io.reactivex.functions.Function
        public R apply(T r1) {
            return (R) ObjectHelper.requireNonNull(this.this$0.combiner.apply(new Object[]{r1}), "The combiner returned a null value");
        }
    }

    public static final class WithLatestFromSubscriber<T, R> extends AtomicInteger implements ConditionalSubscriber<T>, Subscription {
        private static final long serialVersionUID = 1577321883966341961L;
        final Function<? super Object[], R> combiner;
        volatile boolean done;
        final Subscriber<? super R> downstream;
        final AtomicThrowable error;
        final AtomicLong requested;
        final WithLatestInnerSubscriber[] subscribers;
        final AtomicReference<Subscription> upstream;
        final AtomicReferenceArray<Object> values;

        public WithLatestFromSubscriber(Subscriber<? super R> r2, Function<? super Object[], R> r3, int r4) {
            this.downstream = r2;
            this.combiner = r3;
            WithLatestInnerSubscriber[] r5 = new WithLatestInnerSubscriber[r4];
            int r6 = 0;
        L3:
            if (r6 >= r4) goto L5;
            r5[r6] = new WithLatestInnerSubscriber(this, r6);
            r6 = r6 + 1;
            goto L3
        L5:
            this.subscribers = r5;
            this.values = new AtomicReferenceArray(r4);
            this.upstream = new AtomicReference();
            this.requested = new AtomicLong();
            this.error = new AtomicThrowable();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this.upstream);
            WithLatestInnerSubscriber[] r3 = this.subscribers;
            int r0 = r3.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            r3[r1].dispose();
            r1 = r1 + 1;
            goto L3
        }

        public void cancelAllBut(int r3) {
            WithLatestInnerSubscriber[] r2 = this.subscribers;
            int r0 = 0;
        L4:
            if (r0 >= r2.length) goto L8;
            if (r0 == r3) goto L7;
            r2[r0].dispose();
        L7:
            r0 = r0 + 1;
            goto L4
        }

        public void innerComplete(int r1, boolean r2) {
            if (r2 == true) goto L5;
            this.done = true;
            SubscriptionHelper.cancel(this.upstream);
            cancelAllBut(r1);
            HalfSerializer.onComplete(this.downstream, this, this.error);
            return;
        }

        public void innerError(int r2, Throwable r3) {
            this.done = true;
            SubscriptionHelper.cancel(this.upstream);
            cancelAllBut(r2);
            HalfSerializer.onError(this.downstream, r3, this, this.error);
        }

        public void innerNext(int r1, Object r2) {
            this.values.set(r1, r2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done == true) goto L6;
            this.done = true;
            cancelAllBut(-1);
            HalfSerializer.onComplete(this.downstream, this, this.error);
            return;
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r3) {
            if (this.done == false) goto L6;
            RxJavaPlugins.onError(r3);
            return;
        L6:
            this.done = true;
            cancelAllBut(-1);
            HalfSerializer.onError(this.downstream, r3, this, this.error);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r3) {
            if (tryOnNext(r3) == false) goto L5;
            return;
        L5:
            if (this.done == true) goto L9;
            this.upstream.get().request(1);
            return;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r2) {
            SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, r2);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r2) {
            SubscriptionHelper.deferredRequest(this.upstream, this.requested, r2);
        }

        public void subscribe(Publisher<?>[] r5, int r6) {
            WithLatestInnerSubscriber[] r0 = this.subscribers;
            AtomicReference<Subscription> r4 = this.upstream;
            int r1 = 0;
        L3:
            if (r1 >= r6) goto L8;
            if (r4.get() == SubscriptionHelper.CANCELLED) goto L6;
            r5[r1].subscribe(r0[r1]);
            r1 = r1 + 1;
            goto L3
        L6:
            return;
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T r6) {
            if (this.done == false) goto L5;
            return false;
        L5:
            AtomicReferenceArray<Object> r0 = this.values;
            int r2 = r0.length();
            Object[] r3 = new Object[r2 + 1];
            r3[0] = r6;
            int r7 = 0;
        L6:
            if (r7 >= r2) goto L17;
            Object r4 = r0.get(r7);
            if (r4 == null) goto L9;
            r7 = r7 + 1;
            r3[r7] = r4;
            goto L6
        L9:
            return false;
        L17:
            HalfSerializer.onNext(this.downstream, ObjectHelper.requireNonNull(this.combiner.apply(r3), "The combiner returned a null value"), this, this.error);
            return true;
        L14:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            cancel();
            onError(th);
            return false;
        }
    }

    public static final class WithLatestInnerSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
        private static final long serialVersionUID = 3256684027868224024L;
        boolean hasValue;
        final int index;
        final WithLatestFromSubscriber<?, ?> parent;

        public WithLatestInnerSubscriber(WithLatestFromSubscriber<?, ?> r1, int r2) {
            this.parent = r1;
            this.index = r2;
        }

        public void dispose() {
            SubscriptionHelper.cancel(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.parent.innerComplete(this.index, this.hasValue);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            this.parent.innerError(this.index, r2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object r2) {
            if (this.hasValue == true) goto L5;
            this.hasValue = true;
        L5:
            this.parent.innerNext(this.index, r2);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r3) {
            SubscriptionHelper.setOnce(this, r3, Long.MAX_VALUE);
        }
    }

    public FlowableWithLatestFromMany(@NonNull Flowable<T> r1, @NonNull Publisher<?>[] r2, Function<? super Object[], R> r3) {
        super(r1);
        this.otherArray = r2;
        this.otherIterable = null;
        this.combiner = r3;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super R> r6) {
        Publisher<?>[] r0 = this.otherArray;
        if (r0 != null) goto L17;
        r0 = new Publisher[8];
        Iterator<? extends Publisher<?>> r1 = this.otherIterable.iterator();     // Catch: Throwable -> L11
        int r2 = 0;
    L6:
        if (r1.hasNext() == false) goto L18;
        Publisher<?> r3 = r1.next();     // Catch: Throwable -> L11
        if (r2 != r0.length) goto L13;
        r0 = (Publisher[]) Arrays.copyOf(r0, (r2 >> 1) + r2);     // Catch: Throwable -> L11
    L13:
        int r4 = r2 + 1;     // Catch: Throwable -> L11
        r0[r2] = r3;     // Catch: Throwable -> L11
        r2 = r4;
    L18:
        if (r2 != 0) goto L21;
        new FlowableMap(this.source, new SingletonArrayFunc(this)).subscribeActual(r6);
        return;
    L21:
        WithLatestFromSubscriber r5 = new WithLatestFromSubscriber(r6, this.combiner, r2);
        r6.onSubscribe(r5);
        r5.subscribe(r0, r2);
        this.source.subscribe(r5);
        return;
    L11:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptySubscription.error(th, r6);
        return;
    L17:
        r2 = r0.length;
        goto L18
    }

    public FlowableWithLatestFromMany(@NonNull Flowable<T> r1, @NonNull Iterable<? extends Publisher<?>> r2, @NonNull Function<? super Object[], R> r3) {
        super(r1);
        this.otherArray = null;
        this.otherIterable = r2;
        this.combiner = r3;
    }
}
