package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.annotations.Nullable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.Iterator;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes2.dex */
public final class FlowableFromIterable<T> extends Flowable<T> {
    final Iterable<? extends T> source;

    public static abstract class BaseRangeSubscription<T> extends BasicQueueSubscription<T> {
        private static final long serialVersionUID = -2252972430506210021L;
        volatile boolean cancelled;
        Iterator<? extends T> it;
        boolean once;

        public BaseRangeSubscription(Iterator<? extends T> r1) {
            this.it = r1;
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.cancelled = true;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final void clear() {
            this.it = null;
        }

        public abstract void fastPath();

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            Iterator<? extends T> r0 = this.it;
            if (r0 != null) goto L5;
        L8:
            return true;
        L5:
            if (r0.hasNext() == false) goto L8;
            return false;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public final T poll() {
            Iterator<? extends T> r0 = this.it;
            if (r0 != null) goto L6;
            return null;
        L6:
            if (this.once == true) goto L9;
            this.once = true;
        L12:
            return (T) ObjectHelper.requireNonNull(this.it.next(), "Iterator.next() returned a null value");
        L9:
            if (r0.hasNext() == true) goto L12;
            return null;
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long r5) {
            if (SubscriptionHelper.validate(r5) == true) goto L5;
            return;
        L5:
            if (BackpressureHelper.add(this, r5) == 0) goto L7;
            return;
        L7:
            if (r5 != Long.MAX_VALUE) goto L9;
            fastPath();
            return;
        L9:
            slowPath(r5);
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public final int requestFusion(int r1) {
            return r1 & 1;
        }

        public abstract void slowPath(long r1);
    }

    public static final class IteratorConditionalSubscription<T> extends BaseRangeSubscription<T> {
        private static final long serialVersionUID = -6022804456014692607L;
        final ConditionalSubscriber<? super T> downstream;

        public IteratorConditionalSubscription(ConditionalSubscriber<? super T> r1, Iterator<? extends T> r2) {
            super(r2);
            this.downstream = r1;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable.BaseRangeSubscription
        public void fastPath() {
            Iterator<? extends T> r0 = this.it;
            ConditionalSubscriber<? super T> r1 = this.downstream;
        L4:
            if (this.cancelled == true) goto L5;
            T r2 = r0.next();     // Catch: Throwable -> L25
            if (this.cancelled == true) goto L9;
            if (r2 == null) goto L11;
            r1.tryOnNext(r2);
            if (this.cancelled == true) goto L15;
            if (r0.hasNext() == true) goto L4;
            if (this.cancelled == true) goto L38;
            r1.onComplete();
            return;
        L38:
            return;
        L22:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r1.onError(th);
            return;
        L15:
            return;
        L11:
            r1.onError(new NullPointerException("Iterator.next() returned a null value"));
            return;
        L9:
            return;
        L25:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r1.onError(th);
            return;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable.BaseRangeSubscription
        public void slowPath(long r9) {
            Iterator<? extends T> r0 = this.it;
            ConditionalSubscriber<? super T> r1 = this.downstream;
        L3:
            long r4 = 0;
        L5:
            if (r4 != r9) goto L7;
            r9 = get();
            if (r4 != r9) goto L5;
            r9 = addAndGet(-r4);
            if (r9 != 0) goto L3;
            return;
        L7:
            if (this.cancelled == true) goto L8;
            T r6 = r0.next();     // Catch: Throwable -> L30
            if (this.cancelled == true) goto L12;
            if (r6 == null) goto L14;
            boolean r7 = r1.tryOnNext(r6);
            if (this.cancelled == true) goto L18;
            if (r0.hasNext() == false) goto L22;
            if (r7 == false) goto L5;
            r4 = r4 + 1;
            goto L5
        L22:
            if (this.cancelled == true) goto L57;
            r1.onComplete();
            return;
        L57:
            return;
        L27:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r1.onError(th);
            return;
        L18:
            return;
        L14:
            r1.onError(new NullPointerException("Iterator.next() returned a null value"));
            return;
        L12:
            return;
        L30:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r1.onError(th);
            return;
        }
    }

    public static final class IteratorSubscription<T> extends BaseRangeSubscription<T> {
        private static final long serialVersionUID = -6022804456014692607L;
        final Subscriber<? super T> downstream;

        public IteratorSubscription(Subscriber<? super T> r1, Iterator<? extends T> r2) {
            super(r2);
            this.downstream = r1;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable.BaseRangeSubscription
        public void fastPath() {
            Iterator<? extends T> r0 = this.it;
            Subscriber<? super T> r1 = this.downstream;
        L4:
            if (this.cancelled == true) goto L5;
            T r2 = r0.next();     // Catch: Throwable -> L25
            if (this.cancelled == true) goto L9;
            if (r2 == null) goto L11;
            r1.onNext(r2);
            if (this.cancelled == true) goto L15;
            if (r0.hasNext() == true) goto L4;
            if (this.cancelled == true) goto L38;
            r1.onComplete();
            return;
        L38:
            return;
        L22:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r1.onError(th);
            return;
        L15:
            return;
        L11:
            r1.onError(new NullPointerException("Iterator.next() returned a null value"));
            return;
        L9:
            return;
        L25:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r1.onError(th);
            return;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable.BaseRangeSubscription
        public void slowPath(long r9) {
            Iterator<? extends T> r0 = this.it;
            Subscriber<? super T> r1 = this.downstream;
        L3:
            long r4 = 0;
        L5:
            if (r4 != r9) goto L7;
            r9 = get();
            if (r4 != r9) goto L5;
            r9 = addAndGet(-r4);
            if (r9 != 0) goto L3;
            return;
        L7:
            if (this.cancelled == true) goto L8;
            T r6 = r0.next();     // Catch: Throwable -> L29
            if (this.cancelled == true) goto L12;
            if (r6 == null) goto L14;
            r1.onNext(r6);
            if (this.cancelled == true) goto L18;
            if (r0.hasNext() == false) goto L22;
            r4 = r4 + 1;
            goto L5
        L22:
            if (this.cancelled == true) goto L54;
            r1.onComplete();
            return;
        L54:
            return;
        L26:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r1.onError(th);
            return;
        L18:
            return;
        L14:
            r1.onError(new NullPointerException("Iterator.next() returned a null value"));
            return;
        L12:
            return;
        L29:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r1.onError(th);
            return;
        }
    }

    public FlowableFromIterable(Iterable<? extends T> r1) {
        this.source = r1;
    }

    public static <T> void subscribe(Subscriber<? super T> r2, Iterator<? extends T> r3) {
        if (r3.hasNext() == true) goto L7;
        EmptySubscription.complete(r2);
        return;
    L7:
        if ((r2 instanceof ConditionalSubscriber) == false) goto L9;
        r2.onSubscribe(new IteratorConditionalSubscription((ConditionalSubscriber) r2, r3));
        return;
    L9:
        r2.onSubscribe(new IteratorSubscription(r2, r3));
        return;
    L11:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptySubscription.error(th, r2);
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> r1) {
        subscribe(r1, this.source.iterator());
        return;
    L5:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptySubscription.error(th, r1);
    }
}
