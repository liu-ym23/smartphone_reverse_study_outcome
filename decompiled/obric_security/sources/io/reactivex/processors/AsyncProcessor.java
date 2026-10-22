package io.reactivex.processors;

import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import tmsdkobf.b0$$ExternalSyntheticBackport0;

/* JADX INFO: loaded from: classes5.dex */
public final class AsyncProcessor<T> extends FlowableProcessor<T> {
    static final AsyncSubscription[] EMPTY = null;
    static final AsyncSubscription[] TERMINATED = null;
    Throwable error;
    final AtomicReference<AsyncSubscription<T>[]> subscribers;
    T value;

    static final class AsyncSubscription<T> extends DeferredScalarSubscription<T> {
        private static final long serialVersionUID = 5629876084736248016L;
        final AsyncProcessor<T> parent;

        AsyncSubscription(Subscriber<? super T> r1, AsyncProcessor<T> r2) {
            super(r1);
            this.parent = r2;
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            if (super.tryCancel() == false) goto L6;
            this.parent.remove(this);
            return;
        }

        void onComplete() {
            if (isCancelled() == true) goto L6;
            this.downstream.onComplete();
            return;
        }

        void onError(Throwable r2) {
            if (isCancelled() == false) goto L5;
            RxJavaPlugins.onError(r2);
            return;
        L5:
            this.downstream.onError(r2);
        }
    }

    static {
        EMPTY = new AsyncSubscription[0];
        TERMINATED = new AsyncSubscription[0];
    }

    @CheckReturnValue
    public static <T> AsyncProcessor<T> create() {
        return new AsyncProcessor();
    }

    AsyncProcessor() {
        this.subscribers = new AtomicReference(EMPTY);
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r3) {
        if (this.subscribers.get() != TERMINATED) goto L6;
        r3.cancel();
        return;
    L6:
        r3.request(Long.MAX_VALUE);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r3) {
        ObjectHelper.requireNonNull(r3, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.subscribers.get() != TERMINATED) goto L5;
        return;
    L5:
        this.value = r3;
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r4) {
        ObjectHelper.requireNonNull(r4, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        AsyncSubscription<T>[] r0 = this.subscribers.get();
        AsyncSubscription<T>[] r1 = TERMINATED;
        if (r0 != r1) goto L6;
        RxJavaPlugins.onError(r4);
        return;
    L6:
        this.value = null;
        this.error = r4;
        AsyncSubscription<T>[] r3 = this.subscribers.getAndSet(r1);
        int r2 = r3.length;
        int r5 = 0;
    L7:
        if (r5 >= r2) goto L9;
        r3[r5].onError(r4);
        r5 = r5 + 1;
        goto L7
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        AsyncSubscription<T>[] r0 = this.subscribers.get();
        AsyncSubscription<T>[] r1 = TERMINATED;
        if (r0 != r1) goto L5;
        return;
    L5:
        T r2 = this.value;
        AsyncSubscription<T>[] r4 = this.subscribers.getAndSet(r1);
        int r3 = 0;
        if (r2 != null) goto L10;
        int r5 = r4.length;
    L8:
        if (r3 >= r5) goto L13;
        r4[r3].onComplete();
        r3 = r3 + 1;
        goto L8
    L13:
        return;
    L10:
        int r6 = r4.length;
    L11:
        if (r3 >= r6) goto L16;
        r4[r3].complete(r2);
        r3 = r3 + 1;
        goto L11
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
    public Throwable getThrowable() {
        if (this.subscribers.get() == TERMINATED) goto L7;
        return null;
    L7:
        return this.error;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> r3) {
        AsyncSubscription<T> r0 = new AsyncSubscription(r3, this);
        r3.onSubscribe(r0);
        if (add(r0) == true) goto L5;
        Throwable r1 = this.error;
        if (r1 == null) goto L10;
        r3.onError(r1);
        return;
    L10:
        T r2 = this.value;
        if (r2 == null) goto L13;
        r0.complete(r2);
        return;
    L13:
        r0.onComplete();
        return;
    L5:
        if (r0.isCancelled() == false) goto L15;
        remove(r0);
        return;
    }

    boolean add(AsyncSubscription<T> r5) {
    L2:
        AsyncSubscription<T>[] r0 = this.subscribers.get();
        if (r0 == TERMINATED) goto L4;
        int r1 = r0.length;
        AsyncSubscription[] r3 = new AsyncSubscription[r1 + 1];
        System.arraycopy(r0, 0, r3, 0, r1);
        r3[r1] = r5;
        if (b0$$ExternalSyntheticBackport0.m(this.subscribers, r0, r3) == false) goto L2;
        return true;
    L4:
        return false;
    }

    void remove(AsyncSubscription<T> r7) {
    L2:
        AsyncSubscription<T>[] r0 = this.subscribers.get();
        int r1 = r0.length;
        if (r1 == 0) goto L4;
        int r3 = 0;
    L6:
        if (r3 >= r1) goto L11;
        if (r0[r3] == r7) goto L12;
        r3 = r3 + 1;
    L12:
        if (r3 < 0) goto L13;
        if (r1 != 1) goto L17;
        AsyncSubscription[] r2 = EMPTY;
    L19:
        if (b0$$ExternalSyntheticBackport0.m(this.subscribers, r0, r2) == false) goto L2;
        return;
    L17:
        AsyncSubscription[] r5 = new AsyncSubscription[r1 - 1];
        System.arraycopy(r0, 0, r5, 0, r3);
        System.arraycopy(r0, r3 + 1, r5, r3, (r1 - r3) - 1);
        r2 = r5;
        goto L19
    L13:
        return;
    L11:
        r3 = -1;
        goto L12
    }

    public boolean hasValue() {
        if (this.subscribers.get() == TERMINATED) goto L5;
    L7:
        return false;
    L5:
        if (this.value == null) goto L7;
        return true;
    }

    public T getValue() {
        if (this.subscribers.get() == TERMINATED) goto L7;
        return null;
    L7:
        return this.value;
    }

    @Deprecated
    public Object[] getValues() {
        T r2 = getValue();
        if (r2 == null) goto L6;
        return new Object[]{r2};
    L6:
        return new Object[0];
    }

    @Deprecated
    public T[] getValues(T[] r5) {
        T r4 = getValue();
        if (r4 != null) goto L9;
        if (r5.length == 0) goto L7;
        r5[0] = null;
    L7:
        return r5;
    L9:
        if (r5.length != 0) goto L11;
        r5 = (T[]) Arrays.copyOf(r5, 1);
    L11:
        r5[0] = r4;
        if (r5.length == 1) goto L14;
        r5[1] = null;
    L14:
        return r5;
    }
}
