package io.reactivex.processors;

import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes2.dex */
public final class PublishProcessor<T> extends FlowableProcessor<T> {
    static final PublishSubscription[] EMPTY = null;
    static final PublishSubscription[] TERMINATED = null;
    Throwable error;
    final AtomicReference<PublishSubscription<T>[]> subscribers;

    public static final class PublishSubscription<T> extends AtomicLong implements Subscription {
        private static final long serialVersionUID = 3562861878281475070L;
        final Subscriber<? super T> downstream;
        final PublishProcessor<T> parent;

        public PublishSubscription(Subscriber<? super T> r1, PublishProcessor<T> r2) {
            this.downstream = r1;
            this.parent = r2;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE) goto L6;
            this.parent.remove(this);
            return;
        }

        public boolean isCancelled() {
            if (get() != Long.MIN_VALUE) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isFull() {
            if (get() != 0) goto L5;
            return true;
        L5:
            return false;
        }

        public void onComplete() {
            if (get() == Long.MIN_VALUE) goto L6;
            this.downstream.onComplete();
            return;
        }

        public void onError(Throwable r5) {
            if (get() == Long.MIN_VALUE) goto L5;
            this.downstream.onError(r5);
            return;
        L5:
            RxJavaPlugins.onError(r5);
        }

        public void onNext(T r5) {
            long r0 = get();
            if (r0 != Long.MIN_VALUE) goto L6;
            return;
        L6:
            if (r0 == 0) goto L8;
            this.downstream.onNext(r5);
            BackpressureHelper.producedCancel(this, 1);
            return;
        L8:
            cancel();
            this.downstream.onError(new MissingBackpressureException("Could not emit value due to lack of requests"));
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L6;
            BackpressureHelper.addCancel(this, r2);
            return;
        }
    }

    static {
        TERMINATED = new PublishSubscription[0];
        EMPTY = new PublishSubscription[0];
    }

    public PublishProcessor() {
        this.subscribers = new AtomicReference(EMPTY);
    }

    @CheckReturnValue
    @NonNull
    public static <T> PublishProcessor<T> create() {
        return new PublishProcessor();
    }

    public boolean add(PublishSubscription<T> r5) {
    L2:
        PublishSubscription<T>[] r0 = this.subscribers.get();
        if (r0 == TERMINATED) goto L4;
        int r1 = r0.length;
        PublishSubscription<T>[] r3 = new PublishSubscription[r1 + 1];
        System.arraycopy(r0, 0, r3, 0, r1);
        r3[r1] = r5;
        if (this.subscribers.compareAndSet(r0, r3) == false) goto L2;
        return true;
    L4:
        return false;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    @Nullable
    public Throwable getThrowable() {
        if (this.subscribers.get() == TERMINATED) goto L5;
        return null;
    L5:
        return this.error;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasComplete() {
        if (this.subscribers.get() == TERMINATED) goto L5;
    L7:
        return false;
    L5:
        if (this.error != null) goto L7;
        return true;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasSubscribers() {
        if (this.subscribers.get().length == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasThrowable() {
        if (this.subscribers.get() == TERMINATED) goto L5;
    L7:
        return false;
    L5:
        if (this.error == null) goto L7;
        return true;
    }

    public boolean offer(T r6) {
        if (r6 != null) goto L6;
        onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
        return true;
    L6:
        PublishSubscription<T>[] r5 = this.subscribers.get();
        int r1 = r5.length;
        int r2 = 0;
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L12;
        if (r5[r3].isFull() == true) goto L10;
        r3 = r3 + 1;
        goto L7
    L10:
        return false;
    L12:
        int r4 = r5.length;
    L13:
        if (r2 >= r4) goto L15;
        r5[r2].onNext(r6);
        r2 = r2 + 1;
        goto L13
    L15:
        return true;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        PublishSubscription<T>[] r0 = this.subscribers.get();
        PublishSubscription<T>[] r1 = TERMINATED;
        if (r0 != r1) goto L5;
        return;
    L5:
        PublishSubscription<T>[] r3 = this.subscribers.getAndSet(r1);
        int r2 = r3.length;
        int r4 = 0;
    L6:
        if (r4 >= r2) goto L8;
        r3[r4].onComplete();
        r4 = r4 + 1;
        goto L6
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r4) {
        ObjectHelper.requireNonNull(r4, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        PublishSubscription<T>[] r0 = this.subscribers.get();
        PublishSubscription<T>[] r1 = TERMINATED;
        if (r0 != r1) goto L6;
        RxJavaPlugins.onError(r4);
        return;
    L6:
        this.error = r4;
        PublishSubscription<T>[] r3 = this.subscribers.getAndSet(r1);
        int r2 = r3.length;
        int r5 = 0;
    L7:
        if (r5 >= r2) goto L9;
        r3[r5].onError(r4);
        r5 = r5 + 1;
        goto L7
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r4) {
        ObjectHelper.requireNonNull(r4, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        PublishSubscription<T>[] r3 = this.subscribers.get();
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r3[r1].onNext(r4);
        r1 = r1 + 1;
        goto L3
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r3) {
        if (this.subscribers.get() != TERMINATED) goto L6;
        r3.cancel();
        return;
    L6:
        r3.request(Long.MAX_VALUE);
    }

    public void remove(PublishSubscription<T> r7) {
    L2:
        PublishSubscription<T>[] r0 = this.subscribers.get();
        if (r0 == TERMINATED) goto L22;
        if (r0 == EMPTY) goto L30;
        int r1 = r0.length;
        int r3 = 0;
    L8:
        if (r3 >= r1) goto L13;
        if (r0[r3] == r7) goto L14;
        r3 = r3 + 1;
    L14:
        if (r3 < 0) goto L15;
        if (r1 != 1) goto L19;
        PublishSubscription<T>[] r2 = EMPTY;
    L21:
        if (this.subscribers.compareAndSet(r0, r2) == false) goto L2;
        return;
    L19:
        PublishSubscription<T>[] r5 = new PublishSubscription[r1 - 1];
        System.arraycopy(r0, 0, r5, 0, r3);
        System.arraycopy(r0, r3 + 1, r5, r3, (r1 - r3) - 1);
        r2 = r5;
        goto L21
    L15:
        return;
    L13:
        r3 = -1;
        goto L14
    L30:
        return;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> r3) {
        PublishSubscription<T> r0 = new PublishSubscription(r3, this);
        r3.onSubscribe(r0);
        if (add(r0) == true) goto L5;
        Throwable r2 = this.error;
        if (r2 == null) goto L10;
        r3.onError(r2);
        return;
    L10:
        r3.onComplete();
        return;
    L5:
        if (r0.isCancelled() == false) goto L12;
        remove(r0);
        return;
    }
}
