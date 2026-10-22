package io.reactivex.processors;

import io.reactivex.Flowable;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes2.dex */
public final class UnicastProcessor<T> extends FlowableProcessor<T> {
    volatile boolean cancelled;
    final boolean delayError;
    volatile boolean done;
    final AtomicReference<Subscriber<? super T>> downstream;
    boolean enableOperatorFusion;
    Throwable error;
    final AtomicReference<Runnable> onTerminate;
    final AtomicBoolean once;
    final SpscLinkedArrayQueue<T> queue;
    final AtomicLong requested;
    final BasicIntQueueSubscription<T> wip;

    public final class UnicastQueueSubscription extends BasicIntQueueSubscription<T> {
        private static final long serialVersionUID = -4896760517184205454L;
        final /* synthetic */ UnicastProcessor this$0;

        public UnicastQueueSubscription(UnicastProcessor r1) {
            this.this$0 = r1;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.this$0.cancelled == false) goto L5;
            return;
        L5:
            this.this$0.cancelled = true;
            this.this$0.doTerminate();
            UnicastProcessor r0 = this.this$0;
            if (r0.enableOperatorFusion == false) goto L8;
            return;
        L8:
            if (r0.wip.getAndIncrement() != 0) goto L12;
            this.this$0.queue.clear();
            this.this$0.downstream.lazySet(null);
            return;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.this$0.queue.clear();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.this$0.queue.isEmpty();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() {
            return this.this$0.queue.poll();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L6;
            BackpressureHelper.add(this.this$0.requested, r2);
            this.this$0.drain();
            return;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int r2) {
            if ((r2 & 2) == 0) goto L6;
            this.this$0.enableOperatorFusion = true;
            return 2;
        L6:
            return 0;
        }
    }

    public UnicastProcessor(int r3) {
        this(r3, null, true);
    }

    @CheckReturnValue
    @NonNull
    public static <T> UnicastProcessor<T> create() {
        return new UnicastProcessor(Flowable.bufferSize());
    }

    public boolean checkTerminated(boolean r4, boolean r5, boolean r6, Subscriber<? super T> r7, SpscLinkedArrayQueue<T> r8) {
        if (this.cancelled == false) goto L6;
        r8.clear();
        this.downstream.lazySet(null);
        return true;
    L6:
        if (r5 == false) goto L18;
        if (r4 == true) goto L9;
    L12:
        if (r6 == false) goto L20;
        Throwable r9 = this.error;
        this.downstream.lazySet(null);
        if (r9 == null) goto L16;
        r7.onError(r9);
    L17:
        return true;
    L16:
        r7.onComplete();
        goto L17
    L20:
        return false;
    L9:
        if (this.error == null) goto L12;
        r8.clear();
        this.downstream.lazySet(null);
        r7.onError(this.error);
        return true;
    L18:
        return false;
    }

    public void doTerminate() {
        Runnable r1 = this.onTerminate.getAndSet(null);
        if (r1 == null) goto L6;
        r1.run();
        return;
    }

    public void drain() {
        if (this.wip.getAndIncrement() == 0) goto L5;
        return;
    L5:
        Subscriber<? super T> r0 = this.downstream.get();
        int r1 = 1;
    L6:
        if (r0 != null) goto L8;
        r1 = this.wip.addAndGet(-r1);
        if (r1 == 0) goto L14;
        r0 = this.downstream.get();
        goto L6
    L14:
        return;
    L8:
        if (this.enableOperatorFusion == false) goto L10;
        drainFused(r0);
        return;
    L10:
        drainRegular(r0);
    }

    public void drainFused(Subscriber<? super T> r7) {
        SpscLinkedArrayQueue<T> r0 = this.queue;
        int r2 = 1;
        boolean r1 = !this.delayError;
    L4:
        if (this.cancelled == true) goto L5;
        boolean r3 = this.done;
        if (r1 == false) goto L14;
        if (r3 == false) goto L14;
        if (this.error == null) goto L14;
        r0.clear();
        this.downstream.lazySet(null);
        r7.onError(this.error);
        return;
    L14:
        r7.onNext(null);
        if (r3 == true) goto L16;
        r2 = this.wip.addAndGet(-r2);
        if (r2 != 0) goto L4;
        return;
    L16:
        this.downstream.lazySet(null);
        Throwable r6 = this.error;
        if (r6 == null) goto L19;
        r7.onError(r6);
        return;
    L19:
        r7.onComplete();
        return;
    L5:
        r0.clear();
        this.downstream.lazySet(null);
    }

    public void drainRegular(Subscriber<? super T> r18) {
        SpscLinkedArrayQueue<T> r7 = this.queue;
        boolean r8 = true;
        boolean r9 = !this.delayError;
        int r10 = 1;
    L3:
        long r11 = this.requested.get();
        long r4 = 0;
    L5:
        if (r11 == r4) goto L16;
        boolean r2 = this.done;
        T r3 = r7.poll();
        if (r3 != null) goto L9;
        boolean r16 = r8;
    L10:
        long r13 = r4;
        if (checkTerminated(r9, r2, r16, r18, r7) == true) goto L12;
        if (r16 == true) goto L17;
        r18.onNext(r3);
        r4 = 1 + r13;
        r8 = true;
    L17:
        if (r11 != r4) goto L22;
        if (checkTerminated(r9, this.done, r7.isEmpty(), r18, r7) == false) goto L22;
        return;
    L22:
        if (r13 != 0) goto L24;
    L26:
        r10 = this.wip.addAndGet(-r10);
        if (r10 == 0) goto L28;
        r8 = true;
        goto L3
    L28:
        return;
    L24:
        if (r11 == Long.MAX_VALUE) goto L26;
        this.requested.addAndGet(-r13);
        goto L26
    L12:
        return;
    L9:
        r16 = false;
        goto L10
    L16:
        r13 = r4;
        goto L17
    }

    @Override // io.reactivex.processors.FlowableProcessor
    @Nullable
    public Throwable getThrowable() {
        if (this.done == true) goto L5;
        return null;
    L5:
        return this.error;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasComplete() {
        if (this.done == true) goto L5;
    L7:
        return false;
    L5:
        if (this.error != null) goto L7;
        return true;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasSubscribers() {
        if (this.downstream.get() == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasThrowable() {
        if (this.done == true) goto L5;
    L7:
        return false;
    L5:
        if (this.error == null) goto L7;
        return true;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        if (this.cancelled == true) goto L10;
        this.done = true;
        doTerminate();
        drain();
        return;
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r2) {
        ObjectHelper.requireNonNull(r2, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.done == false) goto L5;
    L9:
        RxJavaPlugins.onError(r2);
        return;
    L5:
        if (this.cancelled == true) goto L9;
        this.error = r2;
        this.done = true;
        doTerminate();
        drain();
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r2) {
        ObjectHelper.requireNonNull(r2, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.done == false) goto L5;
        return;
    L5:
        if (this.cancelled == true) goto L10;
        this.queue.offer(r2);
        drain();
        return;
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r3) {
        if (this.done == false) goto L5;
    L8:
        r3.cancel();
        return;
    L5:
        if (this.cancelled == true) goto L8;
        r3.request(Long.MAX_VALUE);
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> r4) {
        if (this.once.get() == false) goto L5;
    L10:
        EmptySubscription.error(new IllegalStateException("This processor allows only a single Subscriber"), r4);
        return;
    L5:
        if (this.once.compareAndSet(false, true) == false) goto L10;
        r4.onSubscribe(this.wip);
        this.downstream.set(r4);
        if (this.cancelled == false) goto L9;
        this.downstream.lazySet(null);
        return;
    L9:
        drain();
    }

    public UnicastProcessor(int r2, Runnable r3) {
        this(r2, r3, true);
    }

    @CheckReturnValue
    @NonNull
    public static <T> UnicastProcessor<T> create(int r1) {
        return new UnicastProcessor(r1);
    }

    public UnicastProcessor(int r3, Runnable r4, boolean r5) {
        this.queue = new SpscLinkedArrayQueue(ObjectHelper.verifyPositive(r3, "capacityHint"));
        this.onTerminate = new AtomicReference(r4);
        this.delayError = r5;
        this.downstream = new AtomicReference();
        this.once = new AtomicBoolean();
        this.wip = new UnicastQueueSubscription(this);
        this.requested = new AtomicLong();
    }

    @CheckReturnValue
    @NonNull
    public static <T> UnicastProcessor<T> create(boolean r3) {
        return new UnicastProcessor(Flowable.bufferSize(), null, r3);
    }

    @CheckReturnValue
    @NonNull
    public static <T> UnicastProcessor<T> create(int r1, Runnable r2) {
        ObjectHelper.requireNonNull(r2, "onTerminate");
        return new UnicastProcessor(r1, r2);
    }

    @CheckReturnValue
    @NonNull
    public static <T> UnicastProcessor<T> create(int r1, Runnable r2, boolean r3) {
        ObjectHelper.requireNonNull(r2, "onTerminate");
        return new UnicastProcessor(r1, r2, r3);
    }
}
