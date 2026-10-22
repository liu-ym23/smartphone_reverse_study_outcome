package io.reactivex.processors;

import io.reactivex.Scheduler;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes5.dex */
public final class ReplayProcessor<T> extends FlowableProcessor<T> {
    static final ReplaySubscription[] EMPTY = null;
    private static final Object[] EMPTY_ARRAY = null;
    static final ReplaySubscription[] TERMINATED = null;
    final ReplayBuffer<T> buffer;
    boolean done;
    final AtomicReference<ReplaySubscription<T>[]> subscribers;

    static final class Node<T> extends AtomicReference<Node<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        final T value;

        Node(T r1) {
            this.value = r1;
        }
    }

    interface ReplayBuffer<T> {
        void complete();

        void error(Throwable r1);

        Throwable getError();

        T getValue();

        T[] getValues(T[] r1);

        boolean isDone();

        void next(T r1);

        void replay(ReplaySubscription<T> r1);

        int size();

        void trimHead();
    }

    static final class ReplaySubscription<T> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 466549804534799122L;
        volatile boolean cancelled;
        final Subscriber<? super T> downstream;
        long emitted;
        Object index;
        final AtomicLong requested;
        final ReplayProcessor<T> state;

        ReplaySubscription(Subscriber<? super T> r1, ReplayProcessor<T> r2) {
            this.downstream = r1;
            this.state = r2;
            this.requested = new AtomicLong();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L6;
            BackpressureHelper.add(this.requested, r2);
            this.state.buffer.replay(this);
            return;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled == true) goto L6;
            this.cancelled = true;
            this.state.remove(this);
            return;
        }
    }

    static final class SizeAndTimeBoundReplayBuffer<T> implements ReplayBuffer<T> {
        volatile boolean done;
        Throwable error;
        volatile TimedNode<T> head;
        final long maxAge;
        final int maxSize;
        final Scheduler scheduler;
        int size;
        TimedNode<T> tail;
        final TimeUnit unit;

        SizeAndTimeBoundReplayBuffer(int r2, long r3, TimeUnit r5, Scheduler r6) {
            this.maxSize = ObjectHelper.verifyPositive(r2, "maxSize");
            this.maxAge = ObjectHelper.verifyPositive(r3, "maxAge");
            this.unit = (TimeUnit) ObjectHelper.requireNonNull(r5, "unit is null");
            this.scheduler = (Scheduler) ObjectHelper.requireNonNull(r6, "scheduler is null");
            TimedNode<T> r4 = new TimedNode(null, 0);
            this.tail = r4;
            this.head = r4;
        }

        void trim() {
            int r0 = this.size;
            if (r0 <= this.maxSize) goto L5;
            this.size = r0 - 1;
            this.head = this.head.get();
        L5:
            long r1 = this.scheduler.now(this.unit) - this.maxAge;
            TimedNode<T> r3 = this.head;
        L7:
            if (this.size <= 1) goto L8;
            TimedNode<T> r4 = r3.get();
            if (r4 == null) goto L11;
            if (r4.time > r1) goto L14;
            this.size--;
            r3 = r4;
            goto L7
        L14:
            this.head = r3;
            return;
        L11:
            this.head = r3;
            return;
        L8:
            this.head = r3;
        }

        void trimFinal() {
            long r0 = this.scheduler.now(this.unit) - this.maxAge;
            TimedNode<T> r2 = this.head;
        L3:
            TimedNode<T> r3 = r2.get();
            if (r3 == null) goto L6;
            if (r3.time > r0) goto L12;
            r2 = r3;
            goto L3
        L12:
            if (r2.value == null) goto L14;
            TimedNode<T> r1 = new TimedNode(null, 0);
            r1.lazySet(r2.get());
            this.head = r1;
            return;
        L14:
            this.head = r2;
            return;
        L6:
            if (r2.value == null) goto L8;
            this.head = new TimedNode(null, 0);
            return;
        L8:
            this.head = r2;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void trimHead() {
            if (this.head.value == null) goto L6;
            TimedNode<T> r0 = new TimedNode(null, 0);
            r0.lazySet(this.head.get());
            this.head = r0;
            return;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void next(T r4) {
            TimedNode<T> r0 = new TimedNode(r4, this.scheduler.now(this.unit));
            TimedNode<T> r5 = this.tail;
            this.tail = r0;
            this.size++;
            r5.set(r0);
            trim();
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void error(Throwable r1) {
            trimFinal();
            this.error = r1;
            this.done = true;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void complete() {
            trimFinal();
            this.done = true;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public T getValue() {
            TimedNode<T> r0 = this.head;
        L3:
            TimedNode<T> r1 = r0.get();
            if (r1 == null) goto L5;
            r0 = r1;
            goto L3
        L5:
            long r2 = this.scheduler.now(this.unit) - this.maxAge;
            if (r0.time >= r2) goto L10;
            return null;
        L10:
            return r0.value;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public T[] getValues(T[] r5) {
            TimedNode<T> r0 = getHead();
            int r4 = size(r0);
            int r2 = 0;
            if (r4 != 0) goto L8;
            if (r5.length == 0) goto L15;
            r5[0] = null;
        L15:
            return r5;
        L8:
            if (r5.length >= r4) goto L10;
            r5 = (T[]) ((Object[]) Array.newInstance(r5.getClass().getComponentType(), r4));
        L10:
            if (r2 == r4) goto L13;
            r0 = r0.get();
            T[] r6 = r5;
            r6[r2] = r0.value;
            r2 = r2 + 1;
            goto L10
        L13:
            if (r5.length <= r4) goto L15;
            r5[r4] = null;
            goto L15
        }

        TimedNode<T> getHead() {
            TimedNode<T> r0 = this.head;
            long r1 = this.scheduler.now(this.unit) - this.maxAge;
            TimedNode<T> r6 = r0.get();
        L3:
            TimedNode<T> r5 = r0;
            r0 = r6;
            if (r0 == null) goto L9;
            if (r0.time > r1) goto L9;
            r6 = r0.get();
        L9:
            return r5;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void replay(ReplaySubscription<T> r14) {
            if (r14.getAndIncrement() == 0) goto L5;
            return;
        L5:
            Subscriber<? super T> r0 = r14.downstream;
            TimedNode<T> r1 = (TimedNode) r14.index;
            if (r1 != null) goto L8;
            r1 = getHead();
        L8:
            long r2 = r14.emitted;
            int r5 = 1;
        L9:
            long r6 = r14.requested.get();
        L11:
            if (r2 == r6) goto L30;
            if (r14.cancelled == true) goto L14;
            boolean r10 = this.done;
            TimedNode<T> r11 = r1.get();
            if (r11 != null) goto L19;
            boolean r12 = true;
        L20:
            if (r10 == false) goto L27;
            if (r12 == false) goto L27;
            r14.index = null;
            r14.cancelled = true;
            Throwable r13 = this.error;
            if (r13 != null) goto L25;
            r0.onComplete();
            return;
        L25:
            r0.onError(r13);
            return;
        L27:
            if (r12 == true) goto L30;
            r0.onNext(r11.value);
            r2 = r2 + 1;
            r1 = r11;
            goto L11
        L19:
            r12 = false;
            goto L20
        L14:
            r14.index = null;
            return;
        L30:
            if (r2 == r6) goto L32;
        L44:
            r14.index = r1;
            r14.emitted = r2;
            r5 = r14.addAndGet(-r5);
            if (r5 != 0) goto L9;
            return;
        L32:
            if (r14.cancelled == true) goto L33;
            if (this.done == false) goto L44;
            if (r1.get() != null) goto L44;
            r14.index = null;
            r14.cancelled = true;
            Throwable r15 = this.error;
            if (r15 != null) goto L42;
            r0.onComplete();
            return;
        L42:
            r0.onError(r15);
            return;
        L33:
            r14.index = null;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public int size() {
            return size(getHead());
        }

        int size(TimedNode<T> r2) {
            int r1 = 0;
        L4:
            if (r1 == Integer.MAX_VALUE) goto L9;
            r2 = r2.get();
            if (r2 == null) goto L9;
            r1 = r1 + 1;
        L9:
            return r1;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public Throwable getError() {
            return this.error;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public boolean isDone() {
            return this.done;
        }
    }

    static final class SizeBoundReplayBuffer<T> implements ReplayBuffer<T> {
        volatile boolean done;
        Throwable error;
        volatile Node<T> head;
        final int maxSize;
        int size;
        Node<T> tail;

        SizeBoundReplayBuffer(int r2) {
            this.maxSize = ObjectHelper.verifyPositive(r2, "maxSize");
            Node<T> r3 = new Node(null);
            this.tail = r3;
            this.head = r3;
        }

        void trim() {
            int r0 = this.size;
            if (r0 <= this.maxSize) goto L6;
            this.size = r0 - 1;
            this.head = this.head.get();
            return;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void next(T r3) {
            Node<T> r0 = new Node(r3);
            Node<T> r4 = this.tail;
            this.tail = r0;
            this.size++;
            r4.set(r0);
            trim();
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void error(Throwable r1) {
            this.error = r1;
            trimHead();
            this.done = true;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void complete() {
            trimHead();
            this.done = true;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void trimHead() {
            if (this.head.value == null) goto L6;
            Node<T> r0 = new Node(null);
            r0.lazySet(this.head.get());
            this.head = r0;
            return;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public boolean isDone() {
            return this.done;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public Throwable getError() {
            return this.error;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public T getValue() {
            Node<T> r1 = this.head;
        L3:
            Node<T> r0 = r1.get();
            if (r0 == null) goto L6;
            r1 = r0;
            goto L3
        L6:
            return r1.value;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public T[] getValues(T[] r4) {
            Node<T> r3 = this.head;
            int r0 = 0;
            Node<T> r1 = r3;
            int r2 = 0;
        L3:
            r1 = r1.get();
            if (r1 == null) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            if (r4.length >= r2) goto L8;
            r4 = (T[]) ((Object[]) Array.newInstance(r4.getClass().getComponentType(), r2));
        L8:
            if (r0 >= r2) goto L11;
            r3 = r3.get();
            r4[r0] = r3.value;
            r0 = r0 + 1;
            goto L8
        L11:
            if (r4.length <= r2) goto L13;
            r4[r2] = null;
        L13:
            return r4;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void replay(ReplaySubscription<T> r14) {
            if (r14.getAndIncrement() == 0) goto L5;
            return;
        L5:
            Subscriber<? super T> r0 = r14.downstream;
            Node<T> r1 = (Node) r14.index;
            if (r1 != null) goto L8;
            r1 = this.head;
        L8:
            long r2 = r14.emitted;
            int r5 = 1;
        L9:
            long r6 = r14.requested.get();
        L11:
            if (r2 == r6) goto L30;
            if (r14.cancelled == true) goto L14;
            boolean r10 = this.done;
            Node<T> r11 = r1.get();
            if (r11 != null) goto L19;
            boolean r12 = true;
        L20:
            if (r10 == false) goto L27;
            if (r12 == false) goto L27;
            r14.index = null;
            r14.cancelled = true;
            Throwable r13 = this.error;
            if (r13 != null) goto L25;
            r0.onComplete();
            return;
        L25:
            r0.onError(r13);
            return;
        L27:
            if (r12 == true) goto L30;
            r0.onNext(r11.value);
            r2 = r2 + 1;
            r1 = r11;
            goto L11
        L19:
            r12 = false;
            goto L20
        L14:
            r14.index = null;
            return;
        L30:
            if (r2 == r6) goto L32;
        L44:
            r14.index = r1;
            r14.emitted = r2;
            r5 = r14.addAndGet(-r5);
            if (r5 != 0) goto L9;
            return;
        L32:
            if (r14.cancelled == true) goto L33;
            if (this.done == false) goto L44;
            if (r1.get() != null) goto L44;
            r14.index = null;
            r14.cancelled = true;
            Throwable r15 = this.error;
            if (r15 != null) goto L42;
            r0.onComplete();
            return;
        L42:
            r0.onError(r15);
            return;
        L33:
            r14.index = null;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public int size() {
            Node<T> r2 = this.head;
            int r0 = 0;
        L4:
            if (r0 == Integer.MAX_VALUE) goto L9;
            r2 = r2.get();
            if (r2 == null) goto L9;
            r0 = r0 + 1;
        L9:
            return r0;
        }
    }

    static final class TimedNode<T> extends AtomicReference<TimedNode<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        final long time;
        final T value;

        TimedNode(T r1, long r2) {
            this.value = r1;
            this.time = r2;
        }
    }

    static final class UnboundedReplayBuffer<T> implements ReplayBuffer<T> {
        final List<T> buffer;
        volatile boolean done;
        Throwable error;
        volatile int size;

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void trimHead() {
        }

        UnboundedReplayBuffer(int r3) {
            this.buffer = new ArrayList(ObjectHelper.verifyPositive(r3, "capacityHint"));
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void next(T r2) {
            this.buffer.add(r2);
            this.size++;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void error(Throwable r1) {
            this.error = r1;
            this.done = true;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void complete() {
            this.done = true;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public T getValue() {
            int r0 = this.size;
            if (r0 != 0) goto L7;
            return null;
        L7:
            return this.buffer.get(r0 - 1);
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public T[] getValues(T[] r5) {
            int r0 = this.size;
            int r2 = 0;
            if (r0 == 0) goto L5;
            List<T> r4 = this.buffer;
            if (r5.length >= r0) goto L11;
            r5 = (T[]) ((Object[]) Array.newInstance(r5.getClass().getComponentType(), r0));
        L11:
            if (r2 >= r0) goto L14;
            T[] r6 = r5;
            r6[r2] = r4.get(r2);
            r2 = r2 + 1;
            goto L11
        L14:
            if (r5.length <= r0) goto L16;
            r5[r0] = null;
        L16:
            return r5;
        L5:
            if (r5.length == 0) goto L7;
            r5[0] = null;
        L7:
            return r5;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void replay(ReplaySubscription<T> r14) {
            if (r14.getAndIncrement() == 0) goto L5;
            return;
        L5:
            List<T> r0 = this.buffer;
            Subscriber<? super T> r1 = r14.downstream;
            Integer r2 = (Integer) r14.index;
            if (r2 == null) goto L8;
            int r3 = r2.intValue();
        L9:
            long r4 = r14.emitted;
            int r6 = 1;
        L10:
            long r7 = r14.requested.get();
        L12:
            if (r4 == r7) goto L28;
            if (r14.cancelled == true) goto L15;
            boolean r11 = this.done;
            int r12 = this.size;
            if (r11 == false) goto L25;
            if (r3 != r12) goto L25;
            r14.index = null;
            r14.cancelled = true;
            Throwable r13 = this.error;
            if (r13 != null) goto L23;
            r1.onComplete();
            return;
        L23:
            r1.onError(r13);
            return;
        L25:
            if (r3 == r12) goto L28;
            r1.onNext(r0.get(r3));
            r3 = r3 + 1;
            r4 = r4 + 1;
            goto L12
        L15:
            r14.index = null;
            return;
        L28:
            if (r4 == r7) goto L30;
        L41:
            r14.index = Integer.valueOf(r3);
            r14.emitted = r4;
            r6 = r14.addAndGet(-r6);
            if (r6 != 0) goto L10;
            return;
        L30:
            if (r14.cancelled == true) goto L31;
            boolean r8 = this.done;
            int r9 = this.size;
            if (r8 == false) goto L41;
            if (r3 != r9) goto L41;
            r14.index = null;
            r14.cancelled = true;
            Throwable r15 = this.error;
            if (r15 != null) goto L39;
            r1.onComplete();
            return;
        L39:
            r1.onError(r15);
            return;
        L31:
            r14.index = null;
            return;
        L8:
            r3 = 0;
            r14.index = 0;
            goto L9
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public int size() {
            return this.size;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public boolean isDone() {
            return this.done;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public Throwable getError() {
            return this.error;
        }
    }

    static {
        EMPTY_ARRAY = new Object[0];
        EMPTY = new ReplaySubscription[0];
        TERMINATED = new ReplaySubscription[0];
    }

    @CheckReturnValue
    public static <T> ReplayProcessor<T> create() {
        return new ReplayProcessor(new UnboundedReplayBuffer(16));
    }

    @CheckReturnValue
    public static <T> ReplayProcessor<T> create(int r2) {
        return new ReplayProcessor(new UnboundedReplayBuffer(r2));
    }

    @CheckReturnValue
    public static <T> ReplayProcessor<T> createWithSize(int r2) {
        return new ReplayProcessor(new SizeBoundReplayBuffer(r2));
    }

    static <T> ReplayProcessor<T> createUnbounded() {
        return new ReplayProcessor(new SizeBoundReplayBuffer(Integer.MAX_VALUE));
    }

    @CheckReturnValue
    public static <T> ReplayProcessor<T> createWithTime(long r8, TimeUnit r10, Scheduler r11) {
        return new ReplayProcessor(new SizeAndTimeBoundReplayBuffer(Integer.MAX_VALUE, r8, r10, r11));
    }

    @CheckReturnValue
    public static <T> ReplayProcessor<T> createWithTimeAndSize(long r8, TimeUnit r10, Scheduler r11, int r12) {
        return new ReplayProcessor(new SizeAndTimeBoundReplayBuffer(r12, r8, r10, r11));
    }

    ReplayProcessor(ReplayBuffer<T> r2) {
        this.buffer = r2;
        this.subscribers = new AtomicReference(EMPTY);
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> r2) {
        ReplaySubscription<T> r0 = new ReplaySubscription(r2, this);
        r2.onSubscribe(r0);
        if (add(r0) == true) goto L5;
    L8:
        this.buffer.replay(r0);
        return;
    L5:
        if (r0.cancelled == false) goto L8;
        remove(r0);
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r3) {
        if (this.done == false) goto L6;
        r3.cancel();
        return;
    L6:
        r3.request(Long.MAX_VALUE);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r4) {
        ObjectHelper.requireNonNull(r4, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.done == false) goto L5;
        return;
    L5:
        ReplayBuffer<T> r0 = this.buffer;
        r0.next(r4);
        ReplaySubscription<T>[] r3 = this.subscribers.get();
        int r5 = r3.length;
        int r1 = 0;
    L6:
        if (r1 >= r5) goto L8;
        r0.replay(r3[r1]);
        r1 = r1 + 1;
        goto L6
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r4) {
        ObjectHelper.requireNonNull(r4, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.done == false) goto L6;
        RxJavaPlugins.onError(r4);
        return;
    L6:
        this.done = true;
        ReplayBuffer<T> r0 = this.buffer;
        r0.error(r4);
        ReplaySubscription<T>[] r3 = this.subscribers.getAndSet(TERMINATED);
        int r5 = r3.length;
        int r1 = 0;
    L7:
        if (r1 >= r5) goto L9;
        r0.replay(r3[r1]);
        r1 = r1 + 1;
        goto L7
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        ReplayBuffer<T> r0 = this.buffer;
        r0.complete();
        ReplaySubscription<T>[] r4 = this.subscribers.getAndSet(TERMINATED);
        int r1 = r4.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L8;
        r0.replay(r4[r2]);
        r2 = r2 + 1;
        goto L6
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasSubscribers() {
        if (this.subscribers.get().length == 0) goto L5;
        return true;
    L5:
        return false;
    }

    int subscriberCount() {
        return this.subscribers.get().length;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public Throwable getThrowable() {
        ReplayBuffer<T> r1 = this.buffer;
        if (r1.isDone() == true) goto L5;
        return null;
    L5:
        return r1.getError();
    }

    public void cleanupBuffer() {
        this.buffer.trimHead();
    }

    public T getValue() {
        return this.buffer.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Object[] getValues() {
        Object[] r0 = EMPTY_ARRAY;
        Object[] r2 = getValues(r0);
        if (r2 == r0) goto L5;
        return r2;
    L5:
        return new Object[0];
    }

    public T[] getValues(T[] r1) {
        return this.buffer.getValues(r1);
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasComplete() {
        ReplayBuffer<T> r1 = this.buffer;
        if (r1.isDone() == true) goto L5;
    L7:
        return false;
    L5:
        if (r1.getError() != null) goto L7;
        return true;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasThrowable() {
        ReplayBuffer<T> r1 = this.buffer;
        if (r1.isDone() == true) goto L5;
    L7:
        return false;
    L5:
        if (r1.getError() == null) goto L7;
        return true;
    }

    public boolean hasValue() {
        if (this.buffer.size() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    int size() {
        return this.buffer.size();
    }

    boolean add(ReplaySubscription<T> r5) {
    L2:
        ReplaySubscription<T>[] r0 = this.subscribers.get();
        if (r0 == TERMINATED) goto L4;
        int r1 = r0.length;
        ReplaySubscription<T>[] r3 = new ReplaySubscription[r1 + 1];
        System.arraycopy(r0, 0, r3, 0, r1);
        r3[r1] = r5;
        if (this.subscribers.compareAndSet(r0, r3) == false) goto L2;
        return true;
    L4:
        return false;
    }

    void remove(ReplaySubscription<T> r7) {
    L2:
        ReplaySubscription<T>[] r0 = this.subscribers.get();
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
        ReplaySubscription<T>[] r2 = EMPTY;
    L21:
        if (this.subscribers.compareAndSet(r0, r2) == false) goto L2;
        return;
    L19:
        ReplaySubscription<T>[] r5 = new ReplaySubscription[r1 - 1];
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
}
