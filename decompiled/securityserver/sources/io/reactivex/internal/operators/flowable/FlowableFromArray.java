package io.reactivex.internal.operators.flowable;

import a.a;
import io.reactivex.Flowable;
import io.reactivex.annotations.Nullable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes2.dex */
public final class FlowableFromArray<T> extends Flowable<T> {
    final T[] array;

    public static final class ArrayConditionalSubscription<T> extends BaseArraySubscription<T> {
        private static final long serialVersionUID = 2587302975077663557L;
        final ConditionalSubscriber<? super T> downstream;

        public ArrayConditionalSubscription(ConditionalSubscriber<? super T> r1, T[] r2) {
            super(r2);
            this.downstream = r1;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        public void fastPath() {
            T[] r0 = this.array;
            int r1 = r0.length;
            ConditionalSubscriber<? super T> r2 = this.downstream;
            int r3 = this.index;
        L3:
            if (r3 == r1) goto L13;
            if (this.cancelled == true) goto L6;
            T r4 = r0[r3];
            if (r4 == null) goto L9;
            r2.tryOnNext(r4);
            r3 = r3 + 1;
            goto L3
        L9:
            r2.onError(new NullPointerException(a.f(r3, "The element at index ", " is null")));
            return;
        L6:
            return;
        L13:
            if (this.cancelled == false) goto L15;
            return;
        L15:
            r2.onComplete();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        public void slowPath(long r11) {
            T[] r0 = this.array;
            int r1 = r0.length;
            int r2 = this.index;
            ConditionalSubscriber<? super T> r3 = this.downstream;
        L3:
            long r6 = 0;
        L5:
            if (r6 == r11) goto L18;
            if (r2 == r1) goto L18;
            if (this.cancelled == true) goto L9;
            T r8 = r0[r2];
            if (r8 == null) goto L12;
            if (r3.tryOnNext(r8) == false) goto L17;
            r6 = r6 + 1;
        L17:
            r2 = r2 + 1;
            goto L5
        L12:
            r3.onError(new NullPointerException(a.f(r2, "The element at index ", " is null")));
            return;
        L9:
            return;
        L18:
            if (r2 == r1) goto L20;
            r11 = get();
            if (r6 != r11) goto L5;
            this.index = r2;
            r11 = addAndGet(-r6);
            if (r11 != 0) goto L3;
            return;
        L20:
            if (this.cancelled == true) goto L40;
            r3.onComplete();
            return;
        }
    }

    public static final class ArraySubscription<T> extends BaseArraySubscription<T> {
        private static final long serialVersionUID = 2587302975077663557L;
        final Subscriber<? super T> downstream;

        public ArraySubscription(Subscriber<? super T> r1, T[] r2) {
            super(r2);
            this.downstream = r1;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        public void fastPath() {
            T[] r0 = this.array;
            int r1 = r0.length;
            Subscriber<? super T> r2 = this.downstream;
            int r3 = this.index;
        L3:
            if (r3 == r1) goto L13;
            if (this.cancelled == true) goto L6;
            T r4 = r0[r3];
            if (r4 == null) goto L9;
            r2.onNext(r4);
            r3 = r3 + 1;
            goto L3
        L9:
            r2.onError(new NullPointerException(a.f(r3, "The element at index ", " is null")));
            return;
        L6:
            return;
        L13:
            if (this.cancelled == false) goto L15;
            return;
        L15:
            r2.onComplete();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        public void slowPath(long r11) {
            T[] r0 = this.array;
            int r1 = r0.length;
            int r2 = this.index;
            Subscriber<? super T> r3 = this.downstream;
        L3:
            long r6 = 0;
        L5:
            if (r6 == r11) goto L15;
            if (r2 == r1) goto L15;
            if (this.cancelled == true) goto L9;
            T r8 = r0[r2];
            if (r8 == null) goto L12;
            r3.onNext(r8);
            r6 = r6 + 1;
            r2 = r2 + 1;
            goto L5
        L12:
            r3.onError(new NullPointerException(a.f(r2, "The element at index ", " is null")));
            return;
        L9:
            return;
        L15:
            if (r2 == r1) goto L17;
            r11 = get();
            if (r6 != r11) goto L5;
            this.index = r2;
            r11 = addAndGet(-r6);
            if (r11 != 0) goto L3;
            return;
        L17:
            if (this.cancelled == true) goto L37;
            r3.onComplete();
            return;
        }
    }

    public static abstract class BaseArraySubscription<T> extends BasicQueueSubscription<T> {
        private static final long serialVersionUID = -2252972430506210021L;
        final T[] array;
        volatile boolean cancelled;
        int index;

        public BaseArraySubscription(T[] r1) {
            this.array = r1;
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.cancelled = true;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final void clear() {
            this.index = this.array.length;
        }

        public abstract void fastPath();

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            if (this.index != this.array.length) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public final T poll() {
            int r0 = this.index;
            T[] r1 = this.array;
            if (r0 != r1.length) goto L6;
            return null;
        L6:
            this.index = r0 + 1;
            return (T) ObjectHelper.requireNonNull(r1[r0], "array element is null");
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

    public FlowableFromArray(T[] r1) {
        this.array = r1;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> r3) {
        if ((r3 instanceof ConditionalSubscriber) == false) goto L5;
        r3.onSubscribe(new ArrayConditionalSubscription((ConditionalSubscriber) r3, this.array));
        return;
    L5:
        r3.onSubscribe(new ArraySubscription(r3, this.array));
    }
}
