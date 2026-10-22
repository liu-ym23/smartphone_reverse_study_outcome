package io.reactivex.processors;

import io.reactivex.Flowable;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes2.dex */
@SchedulerSupport(SchedulerSupport.NONE)
@BackpressureSupport(BackpressureKind.FULL)
public final class MulticastProcessor<T> extends FlowableProcessor<T> {
    static final MulticastSubscription[] EMPTY = null;
    static final MulticastSubscription[] TERMINATED = null;
    final int bufferSize;
    int consumed;
    volatile boolean done;
    volatile Throwable error;
    int fusionMode;
    final int limit;
    final AtomicBoolean once;
    volatile SimpleQueue<T> queue;
    final boolean refcount;
    final AtomicReference<MulticastSubscription<T>[]> subscribers;
    final AtomicReference<Subscription> upstream;
    final AtomicInteger wip;

    public static final class MulticastSubscription<T> extends AtomicLong implements Subscription {
        private static final long serialVersionUID = -363282618957264509L;
        final Subscriber<? super T> downstream;
        long emitted;
        final MulticastProcessor<T> parent;

        public MulticastSubscription(Subscriber<? super T> r1, MulticastProcessor<T> r2) {
            this.downstream = r1;
            this.parent = r2;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE) goto L6;
            this.parent.remove(this);
            return;
        }

        public void onComplete() {
            if (get() == Long.MIN_VALUE) goto L6;
            this.downstream.onComplete();
            return;
        }

        public void onError(Throwable r5) {
            if (get() == Long.MIN_VALUE) goto L6;
            this.downstream.onError(r5);
            return;
        }

        public void onNext(T r5) {
            if (get() == Long.MIN_VALUE) goto L6;
            this.emitted++;
            this.downstream.onNext(r5);
            return;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r9) {
            if (SubscriptionHelper.validate(r9) == false) goto L21;
        L4:
            long r0 = get();
            if (r0 == Long.MIN_VALUE) goto L22;
            long r2 = Long.MAX_VALUE;
            if (r0 == Long.MAX_VALUE) goto L23;
            long r4 = r0 + r9;
            if (r4 < 0) goto L14;
            r2 = r4;
        L14:
            if (compareAndSet(r0, r2) == false) goto L4;
            this.parent.drain();
            return;
        L23:
            return;
        L22:
            return;
        }
    }

    static {
        EMPTY = new MulticastSubscription[0];
        TERMINATED = new MulticastSubscription[0];
    }

    public MulticastProcessor(int r2, boolean r3) {
        ObjectHelper.verifyPositive(r2, "bufferSize");
        this.bufferSize = r2;
        this.limit = r2 - (r2 >> 2);
        this.wip = new AtomicInteger();
        this.subscribers = new AtomicReference(EMPTY);
        this.upstream = new AtomicReference();
        this.refcount = r3;
        this.once = new AtomicBoolean();
    }

    @CheckReturnValue
    @NonNull
    public static <T> MulticastProcessor<T> create() {
        return new MulticastProcessor(Flowable.bufferSize(), false);
    }

    public boolean add(MulticastSubscription<T> r5) {
    L2:
        MulticastSubscription<T>[] r0 = this.subscribers.get();
        if (r0 == TERMINATED) goto L4;
        int r1 = r0.length;
        MulticastSubscription<T>[] r3 = new MulticastSubscription[r1 + 1];
        System.arraycopy(r0, 0, r3, 0, r1);
        r3[r1] = r5;
        if (this.subscribers.compareAndSet(r0, r3) == false) goto L2;
        return true;
    L4:
        return false;
    }

    public void drain() {
        if (this.wip.getAndIncrement() == 0) goto L5;
        return;
    L5:
        AtomicReference<MulticastSubscription<T>[]> r2 = this.subscribers;
        int r0 = this.consumed;
        int r3 = this.limit;
        int r4 = this.fusionMode;
        int r6 = 1;
    L6:
        SimpleQueue<T> r7 = this.queue;
        if (r7 == null) goto L79;
        MulticastSubscription<T>[] r8 = r2.get();
        if (r8.length == 0) goto L79;
        int r9 = r8.length;
        long r10 = -1;
        long r14 = -1;
        int r13 = 0;
    L12:
        if (r13 >= r9) goto L20;
        MulticastSubscription<T> r12 = r8[r13];
        long r18 = r12.get();
        if (r18 < 0) goto L19;
        if (r14 != r10) goto L18;
        r14 = r18 - r12.emitted;
        goto L19
    L18:
        r14 = Math.min(r14, r18 - r12.emitted);
    L19:
        r13 = r13 + 1;
        r10 = -1;
        goto L12
    L20:
        int r11 = r0;
    L22:
        if (r14 <= 0) goto L58;
        MulticastSubscription<T>[] r1 = r2.get();
        if (r1 == TERMINATED) goto L25;
        if (r8 != r1) goto L64;
        boolean r5 = this.done;
        T r15 = r7.poll();     // Catch: Throwable -> L32
    L34:
        if (r15 != null) goto L36;
        boolean r16 = true;
    L37:
        if (r5 == false) goto L48;
        if (r16 == false) goto L48;
        Throwable r17 = this.error;
        if (r17 == null) goto L44;
        MulticastSubscription<T>[] r19 = r2.getAndSet(TERMINATED);
        int r20 = r19.length;
        int r110 = 0;
    L42:
        if (r110 >= r20) goto L47;
        r19[r110].onError(r17);
        r110 = r110 + 1;
        goto L42
    L47:
        return;
    L44:
        MulticastSubscription<T>[] r21 = r2.getAndSet(TERMINATED);
        int r22 = r21.length;
        int r111 = 0;
    L45:
        if (r111 >= r22) goto L115;
        r21[r111].onComplete();
        r111 = r111 + 1;
        goto L45
    L115:
        return;
    L48:
        if (r16 == true) goto L58;
        int r23 = r8.length;
        int r112 = 0;
    L51:
        if (r112 >= r23) goto L53;
        r8[r112].onNext(r15);
        r112 = r112 + 1;
        goto L51
    L53:
        r14 = r14 - 1;
        if (r4 == 1) goto L22;
        r11 = r11 + 1;
        if (r11 != r3) goto L22;
        this.upstream.get().request(r3);
        r11 = 0;
        goto L22
    L36:
        r16 = false;
    L32:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        SubscriptionHelper.cancel(this.upstream);
        this.error = th;
        this.done = true;
        r15 = null;
        r5 = true;
    L64:
        r0 = r11;
        goto L6
    L25:
        r7.clear();
        return;
    L58:
        if (r14 != 0) goto L78;
        MulticastSubscription<T>[] r24 = r2.get();
        MulticastSubscription<T>[] r113 = TERMINATED;
        if (r24 == r113) goto L61;
        if (r8 != r24) goto L64;
        if (this.done == false) goto L78;
        if (r7.isEmpty() == false) goto L78;
        Throwable r25 = this.error;
        if (r25 == null) goto L74;
        MulticastSubscription<T>[] r26 = r2.getAndSet(r113);
        int r27 = r26.length;
        int r114 = 0;
    L72:
        if (r114 >= r27) goto L77;
        r26[r114].onError(r25);
        r114 = r114 + 1;
        goto L72
    L77:
        return;
    L74:
        MulticastSubscription<T>[] r28 = r2.getAndSet(r113);
        int r29 = r28.length;
        int r115 = 0;
    L75:
        if (r115 >= r29) goto L116;
        r28[r115].onComplete();
        r115 = r115 + 1;
        goto L75
    L116:
        return;
    L61:
        r7.clear();
        return;
    L78:
        r0 = r11;
    L79:
        r6 = this.wip.addAndGet(-r6);
        if (r6 != 0) goto L6;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public Throwable getThrowable() {
        if (this.once.get() == true) goto L7;
        return null;
    L7:
        return this.error;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasComplete() {
        if (this.once.get() == true) goto L5;
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
        if (this.once.get() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.error == null) goto L7;
        return true;
    }

    public boolean offer(T r3) {
        if (this.once.get() == false) goto L5;
        return false;
    L5:
        ObjectHelper.requireNonNull(r3, "offer called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.fusionMode == 0) goto L8;
    L11:
        return false;
    L8:
        if (this.queue.offer(r3) == false) goto L11;
        drain();
        return true;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.once.compareAndSet(false, true) == false) goto L6;
        this.done = true;
        drain();
        return;
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r4) {
        ObjectHelper.requireNonNull(r4, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.once.compareAndSet(false, true) == false) goto L5;
        this.error = r4;
        this.done = true;
        drain();
        return;
    L5:
        RxJavaPlugins.onError(r4);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r2) {
        if (this.once.get() == false) goto L6;
        return;
    L6:
        if (this.fusionMode != 0) goto L11;
        ObjectHelper.requireNonNull(r2, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.queue.offer(r2) == true) goto L11;
        SubscriptionHelper.cancel(this.upstream);
        onError(new MissingBackpressureException());
        return;
    L11:
        drain();
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r4) {
        if (SubscriptionHelper.setOnce(this.upstream, r4) == true) goto L5;
        return;
    L5:
        if ((r4 instanceof QueueSubscription) == false) goto L14;
        QueueSubscription r0 = (QueueSubscription) r4;
        int r1 = r0.requestFusion(3);
        if (r1 != 1) goto L11;
        this.fusionMode = r1;
        this.queue = r0;
        this.done = true;
        drain();
        return;
    L11:
        if (r1 != 2) goto L14;
        this.fusionMode = r1;
        this.queue = r0;
        r4.request(this.bufferSize);
        return;
    L14:
        this.queue = new SpscArrayQueue(this.bufferSize);
        r4.request(this.bufferSize);
    }

    public void remove(MulticastSubscription<T> r7) {
    L2:
        MulticastSubscription<T>[] r0 = this.subscribers.get();
        int r1 = r0.length;
        if (r1 == 0) goto L4;
        int r3 = 0;
    L6:
        if (r3 >= r1) goto L11;
        if (r0[r3] == r7) goto L12;
        r3 = r3 + 1;
    L12:
        if (r3 < 0) goto L42;
        if (r1 == 1) goto L17;
        MulticastSubscription<T>[] r5 = new MulticastSubscription[r1 - 1];
        System.arraycopy(r0, 0, r5, 0, r3);
        System.arraycopy(r0, r3 + 1, r5, r3, (r1 - r3) - 1);
        if (this.subscribers.compareAndSet(r0, r5) == false) goto L2;
        return;
    L17:
        if (this.refcount == true) goto L19;
        if (this.subscribers.compareAndSet(r0, EMPTY) == false) goto L2;
        return;
    L19:
        if (this.subscribers.compareAndSet(r0, TERMINATED) == false) goto L2;
        SubscriptionHelper.cancel(this.upstream);
        this.once.set(true);
        return;
    L42:
        return;
    L11:
        r3 = -1;
        goto L12
    }

    public void start() {
        if (SubscriptionHelper.setOnce(this.upstream, EmptySubscription.INSTANCE) == false) goto L6;
        this.queue = new SpscArrayQueue(this.bufferSize);
        return;
    }

    public void startUnbounded() {
        if (SubscriptionHelper.setOnce(this.upstream, EmptySubscription.INSTANCE) == false) goto L6;
        this.queue = new SpscLinkedArrayQueue(this.bufferSize);
        return;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> r6) {
        MulticastSubscription<T> r0 = new MulticastSubscription(r6, this);
        r6.onSubscribe(r0);
        if (add(r0) == false) goto L9;
        if (r0.get() != Long.MIN_VALUE) goto L7;
        remove(r0);
        return;
    L7:
        drain();
        return;
    L9:
        if (this.once.get() == false) goto L11;
    L12:
        Throwable r5 = this.error;
        if (r5 == null) goto L16;
        r6.onError(r5);
        return;
    L16:
        r6.onComplete();
        return;
    L11:
        if (this.refcount == true) goto L16;
        goto L12
    }

    @CheckReturnValue
    @NonNull
    public static <T> MulticastProcessor<T> create(boolean r2) {
        return new MulticastProcessor(Flowable.bufferSize(), r2);
    }

    @CheckReturnValue
    @NonNull
    public static <T> MulticastProcessor<T> create(int r2) {
        return new MulticastProcessor(r2, false);
    }

    @CheckReturnValue
    @NonNull
    public static <T> MulticastProcessor<T> create(int r1, boolean r2) {
        return new MulticastProcessor(r1, r2);
    }
}
