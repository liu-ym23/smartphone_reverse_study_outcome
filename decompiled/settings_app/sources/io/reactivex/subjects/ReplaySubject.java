package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ReplaySubject<T> extends Subject<T> {
    static final ReplayDisposable[] EMPTY = null;
    private static final Object[] EMPTY_ARRAY = null;
    static final ReplayDisposable[] TERMINATED = null;
    final ReplayBuffer<T> buffer;
    boolean done;
    final AtomicReference<ReplayDisposable<T>[]> observers;

    static final class Node<T> extends AtomicReference<Node<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        final T value;

        Node(T r1) {
            this.value = r1;
        }
    }

    interface ReplayBuffer<T> {
        void add(T r1);

        void addFinal(Object r1);

        boolean compareAndSet(Object r1, Object r2);

        Object get();

        T getValue();

        T[] getValues(T[] r1);

        void replay(ReplayDisposable<T> r1);

        int size();

        void trimHead();
    }

    static final class ReplayDisposable<T> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 466549804534799122L;
        volatile boolean cancelled;
        final Observer<? super T> downstream;
        Object index;
        final ReplaySubject<T> state;

        ReplayDisposable(Observer<? super T> r1, ReplaySubject<T> r2) {
            this.downstream = r1;
            this.state = r2;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled == true) goto L6;
            this.cancelled = true;
            this.state.remove(this);
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }
    }

    static final class SizeAndTimeBoundReplayBuffer<T> extends AtomicReference<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = -8056260896137901749L;
        volatile boolean done;
        volatile TimedNode<Object> head;
        final long maxAge;
        final int maxSize;
        final Scheduler scheduler;
        int size;
        TimedNode<Object> tail;
        final TimeUnit unit;

        SizeAndTimeBoundReplayBuffer(int r2, long r3, TimeUnit r5, Scheduler r6) {
            this.maxSize = ObjectHelper.verifyPositive(r2, "maxSize");
            this.maxAge = ObjectHelper.verifyPositive(r3, "maxAge");
            this.unit = (TimeUnit) ObjectHelper.requireNonNull(r5, "unit is null");
            this.scheduler = (Scheduler) ObjectHelper.requireNonNull(r6, "scheduler is null");
            TimedNode<Object> r4 = new TimedNode(null, 0);
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
            TimedNode<Object> r3 = this.head;
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
            TimedNode<Object> r2 = this.head;
        L3:
            TimedNode<T> r3 = r2.get();
            if (r3.get() == null) goto L6;
            if (r3.time > r0) goto L12;
            r2 = r3;
            goto L3
        L12:
            if (r2.value == null) goto L14;
            TimedNode<Object> r1 = new TimedNode(null, 0);
            r1.lazySet(r2.get());
            this.head = r1;
            return;
        L14:
            this.head = r2;
            return;
        L6:
            if (r2.value == null) goto L8;
            TimedNode<Object> r4 = new TimedNode(null, 0);
            r4.lazySet(r2.get());
            this.head = r4;
            return;
        L8:
            this.head = r2;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void add(T r4) {
            TimedNode<Object> r0 = new TimedNode(r4, this.scheduler.now(this.unit));
            TimedNode<Object> r5 = this.tail;
            this.tail = r0;
            this.size++;
            r5.set(r0);
            trim();
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void addFinal(Object r4) {
            TimedNode<Object> r0 = new TimedNode(r4, Long.MAX_VALUE);
            TimedNode<Object> r5 = this.tail;
            this.tail = r0;
            this.size++;
            r5.lazySet(r0);
            trimFinal();
            this.done = true;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void trimHead() {
            TimedNode<Object> r0 = this.head;
            if (r0.value == null) goto L6;
            TimedNode<Object> r1 = new TimedNode(null, 0);
            r1.lazySet(r0.get());
            this.head = r1;
            return;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public T getValue() {
            TimedNode<Object> r0 = this.head;
            TimedNode<Object> r2 = null;
        L3:
            TimedNode<T> r3 = r0.get();
            if (r3 == null) goto L6;
            r2 = r0;
            r0 = r3;
            goto L3
        L6:
            if (r0.time >= (this.scheduler.now(this.unit) - this.maxAge)) goto L8;
            return null;
        L8:
            T r7 = (T) r0.value;
            if (r7 != null) goto L12;
            return null;
        L12:
            if (NotificationLite.isComplete(r7) == true) goto L18;
            if (NotificationLite.isError(r7) == true) goto L18;
            return r7;
        L18:
            return (T) r2.value;
        }

        TimedNode<Object> getHead() {
            TimedNode<Object> r0 = this.head;
            long r1 = this.scheduler.now(this.unit) - this.maxAge;
            TimedNode<T> r6 = r0.get();
        L3:
            TimedNode<Object> r5 = r0;
            r0 = r6;
            if (r0 == null) goto L9;
            if (r0.time > r1) goto L9;
            r6 = r0.get();
        L9:
            return r5;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
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

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void replay(ReplayDisposable<T> r8) {
            if (r8.getAndIncrement() == 0) goto L5;
            return;
        L5:
            Observer<? super T> r0 = r8.downstream;
            TimedNode<Object> r1 = (TimedNode) r8.index;
            if (r1 != null) goto L8;
            r1 = getHead();
        L8:
            int r3 = 1;
        L10:
            if (r8.cancelled == true) goto L11;
        L14:
            if (r8.cancelled == true) goto L15;
            TimedNode<T> r4 = r1.get();
            if (r4 == null) goto L20;
            T r2 = r4.value;
            if (this.done == false) goto L35;
            if (r4.get() != null) goto L35;
            if (NotificationLite.isComplete(r2) == false) goto L32;
            r0.onComplete();
        L33:
            r8.index = null;
            r8.cancelled = true;
            return;
        L32:
            r0.onError(NotificationLite.getError(r2));
        L35:
            r0.onNext(r2);
            r1 = r4;
            goto L14
        L20:
            if (r1.get() != null) goto L10;
            r8.index = r1;
            r3 = r8.addAndGet(-r3);
            if (r3 != 0) goto L10;
            return;
        L15:
            r8.index = null;
            return;
        L11:
            r8.index = null;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public int size() {
            return size(getHead());
        }

        int size(TimedNode<Object> r2) {
            int r1 = 0;
        L4:
            if (r1 == Integer.MAX_VALUE) goto L17;
            TimedNode<T> r0 = r2.get();
            if (r0 == null) goto L7;
            r1 = r1 + 1;
            r2 = r0;
            goto L4
        L7:
            Object r3 = r2.value;
            if (NotificationLite.isComplete(r3) == true) goto L16;
            if (NotificationLite.isError(r3) == true) goto L16;
            return r1;
        L16:
            return r1 - 1;
        L17:
            return r1;
        }
    }

    static final class SizeBoundReplayBuffer<T> extends AtomicReference<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 1107649250281456395L;
        volatile boolean done;
        volatile Node<Object> head;
        final int maxSize;
        int size;
        Node<Object> tail;

        SizeBoundReplayBuffer(int r2) {
            this.maxSize = ObjectHelper.verifyPositive(r2, "maxSize");
            Node<Object> r3 = new Node(null);
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

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void add(T r3) {
            Node<Object> r0 = new Node(r3);
            Node<Object> r4 = this.tail;
            this.tail = r0;
            this.size++;
            r4.set(r0);
            trim();
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void addFinal(Object r4) {
            Node<Object> r0 = new Node(r4);
            Node<Object> r5 = this.tail;
            this.tail = r0;
            this.size++;
            r5.lazySet(r0);
            trimHead();
            this.done = true;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void trimHead() {
            Node<Object> r0 = this.head;
            if (r0.value == null) goto L6;
            Node<Object> r1 = new Node(null);
            r1.lazySet(r0.get());
            this.head = r1;
            return;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public T getValue() {
            Node<Object> r3 = this.head;
            Node<Object> r1 = null;
        L3:
            Node<T> r2 = r3.get();
            if (r2 == null) goto L5;
            r1 = r3;
            r3 = r2;
            goto L3
        L5:
            T r4 = (T) r3.value;
            if (r4 != null) goto L9;
            return null;
        L9:
            if (NotificationLite.isComplete(r4) == true) goto L15;
            if (NotificationLite.isError(r4) == true) goto L15;
            return r4;
        L15:
            return (T) r1.value;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public T[] getValues(T[] r5) {
            Node<T> r0 = this.head;
            int r4 = size();
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

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void replay(ReplayDisposable<T> r8) {
            if (r8.getAndIncrement() == 0) goto L5;
            return;
        L5:
            Observer<? super T> r0 = r8.downstream;
            Node<Object> r1 = (Node) r8.index;
            if (r1 != null) goto L8;
            r1 = this.head;
        L8:
            int r3 = 1;
        L10:
            if (r8.cancelled == true) goto L11;
            Node<T> r4 = r1.get();
            if (r4 == null) goto L16;
            T r2 = r4.value;
            if (this.done == true) goto L24;
        L31:
            r0.onNext(r2);
            r1 = r4;
            goto L10
        L24:
            if (r4.get() != null) goto L31;
            if (NotificationLite.isComplete(r2) == false) goto L28;
            r0.onComplete();
        L29:
            r8.index = null;
            r8.cancelled = true;
            return;
        L28:
            r0.onError(NotificationLite.getError(r2));
            goto L29
        L16:
            if (r1.get() != null) goto L10;
            r8.index = r1;
            r3 = r8.addAndGet(-r3);
            if (r3 != 0) goto L10;
            return;
        L11:
            r8.index = null;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public int size() {
            Node<Object> r2 = this.head;
            int r0 = 0;
        L4:
            if (r0 == Integer.MAX_VALUE) goto L17;
            Node<T> r1 = r2.get();
            if (r1 == null) goto L7;
            r0 = r0 + 1;
            r2 = r1;
            goto L4
        L7:
            Object r3 = r2.value;
            if (NotificationLite.isComplete(r3) == true) goto L16;
            if (NotificationLite.isError(r3) == true) goto L16;
            return r0;
        L16:
            return r0 - 1;
        L17:
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

    static final class UnboundedReplayBuffer<T> extends AtomicReference<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = -733876083048047795L;
        final List<Object> buffer;
        volatile boolean done;
        volatile int size;

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void trimHead() {
        }

        UnboundedReplayBuffer(int r3) {
            this.buffer = new ArrayList(ObjectHelper.verifyPositive(r3, "capacityHint"));
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void add(T r2) {
            this.buffer.add(r2);
            this.size++;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void addFinal(Object r2) {
            this.buffer.add(r2);
            trimHead();
            this.size++;
            this.done = true;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public T getValue() {
            int r0 = this.size;
            if (r0 == 0) goto L15;
            List<Object> r4 = this.buffer;
            T r2 = (T) r4.get(r0 - 1);
            if (NotificationLite.isComplete(r2) == true) goto L11;
            if (NotificationLite.isError(r2) == true) goto L11;
            return r2;
        L11:
            if (r0 != 1) goto L14;
            return null;
        L14:
            return (T) r4.get(r0 - 2);
        L15:
            return null;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public T[] getValues(T[] r6) {
            int r0 = this.size;
            int r2 = 0;
            if (r0 == 0) goto L5;
            List<Object> r5 = this.buffer;
            Object r3 = r5.get(r0 - 1);
            if (NotificationLite.isComplete(r3) == false) goto L11;
        L12:
            r0 = r0 - 1;
            if (r0 == 0) goto L15;
        L19:
            if (r6.length >= r0) goto L21;
            r6 = (T[]) ((Object[]) Array.newInstance(r6.getClass().getComponentType(), r0));
        L21:
            if (r2 >= r0) goto L24;
            r6[r2] = r5.get(r2);
            r2 = r2 + 1;
            goto L21
        L24:
            if (r6.length <= r0) goto L26;
            r6[r0] = null;
        L26:
            return r6;
        L15:
            if (r6.length == 0) goto L17;
            r6[0] = null;
        L17:
            return r6;
        L11:
            if (NotificationLite.isError(r3) == false) goto L19;
        L5:
            if (r6.length == 0) goto L7;
            r6[0] = null;
        L7:
            return r6;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void replay(ReplayDisposable<T> r10) {
            if (r10.getAndIncrement() == 0) goto L5;
            return;
        L5:
            List<Object> r0 = this.buffer;
            Observer<? super T> r1 = r10.downstream;
            Integer r2 = (Integer) r10.index;
            if (r2 == null) goto L8;
            int r3 = r2.intValue();
        L9:
            int r4 = 1;
        L11:
            if (r10.cancelled == true) goto L12;
            int r5 = this.size;
        L15:
            if (r5 == r3) goto L34;
            if (r10.cancelled == true) goto L18;
            Object r7 = r0.get(r3);
            if (this.done == false) goto L32;
            int r8 = r3 + 1;
            if (r8 != r5) goto L32;
            r5 = this.size;
            if (r8 != r5) goto L32;
            if (NotificationLite.isComplete(r7) == false) goto L29;
            r1.onComplete();
        L30:
            r10.index = null;
            r10.cancelled = true;
            return;
        L29:
            r1.onError(NotificationLite.getError(r7));
        L32:
            r1.onNext(r7);
            r3 = r3 + 1;
            goto L15
        L18:
            r10.index = null;
            return;
        L34:
            if (r3 != this.size) goto L11;
            r10.index = Integer.valueOf(r3);
            r4 = r10.addAndGet(-r4);
            if (r4 != 0) goto L11;
            return;
        L12:
            r10.index = null;
            return;
        L8:
            r3 = 0;
            r10.index = 0;
            goto L9
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public int size() {
            int r0 = this.size;
            if (r0 == 0) goto L11;
            int r1 = r0 - 1;
            Object r3 = this.buffer.get(r1);
            if (NotificationLite.isComplete(r3) == false) goto L7;
        L10:
            return r1;
        L7:
            if (NotificationLite.isError(r3) == true) goto L10;
            return r0;
        L11:
            return 0;
        }
    }

    static {
        EMPTY = new ReplayDisposable[0];
        TERMINATED = new ReplayDisposable[0];
        EMPTY_ARRAY = new Object[0];
    }

    @CheckReturnValue
    public static <T> ReplaySubject<T> create() {
        return new ReplaySubject(new UnboundedReplayBuffer(16));
    }

    @CheckReturnValue
    public static <T> ReplaySubject<T> create(int r2) {
        return new ReplaySubject(new UnboundedReplayBuffer(r2));
    }

    @CheckReturnValue
    public static <T> ReplaySubject<T> createWithSize(int r2) {
        return new ReplaySubject(new SizeBoundReplayBuffer(r2));
    }

    static <T> ReplaySubject<T> createUnbounded() {
        return new ReplaySubject(new SizeBoundReplayBuffer(Integer.MAX_VALUE));
    }

    @CheckReturnValue
    public static <T> ReplaySubject<T> createWithTime(long r8, TimeUnit r10, Scheduler r11) {
        return new ReplaySubject(new SizeAndTimeBoundReplayBuffer(Integer.MAX_VALUE, r8, r10, r11));
    }

    @CheckReturnValue
    public static <T> ReplaySubject<T> createWithTimeAndSize(long r8, TimeUnit r10, Scheduler r11, int r12) {
        return new ReplaySubject(new SizeAndTimeBoundReplayBuffer(r12, r8, r10, r11));
    }

    ReplaySubject(ReplayBuffer<T> r2) {
        this.buffer = r2;
        this.observers = new AtomicReference(EMPTY);
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> r2) {
        ReplayDisposable<T> r0 = new ReplayDisposable(r2, this);
        r2.onSubscribe(r0);
        if (r0.cancelled == false) goto L5;
        return;
    L5:
        if (add(r0) == true) goto L7;
    L10:
        this.buffer.replay(r0);
        return;
    L7:
        if (r0.cancelled == false) goto L10;
        remove(r0);
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r1) {
        if (this.done == false) goto L6;
        r1.dispose();
        return;
    }

    @Override // io.reactivex.Observer
    public void onNext(T r4) {
        ObjectHelper.requireNonNull(r4, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.done == false) goto L5;
        return;
    L5:
        ReplayBuffer<T> r0 = this.buffer;
        r0.add(r4);
        ReplayDisposable<T>[] r3 = this.observers.get();
        int r5 = r3.length;
        int r1 = 0;
    L6:
        if (r1 >= r5) goto L8;
        r0.replay(r3[r1]);
        r1 = r1 + 1;
        goto L6
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r4) {
        ObjectHelper.requireNonNull(r4, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.done == false) goto L6;
        RxJavaPlugins.onError(r4);
        return;
    L6:
        this.done = true;
        Object r5 = NotificationLite.error(r4);
        ReplayBuffer<T> r0 = this.buffer;
        r0.addFinal(r5);
        ReplayDisposable<T>[] r3 = terminate(r5);
        int r6 = r3.length;
        int r1 = 0;
    L7:
        if (r1 >= r6) goto L9;
        r0.replay(r3[r1]);
        r1 = r1 + 1;
        goto L7
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        Object r0 = NotificationLite.complete();
        ReplayBuffer<T> r1 = this.buffer;
        r1.addFinal(r0);
        ReplayDisposable<T>[] r4 = terminate(r0);
        int r2 = r4.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L8;
        r1.replay(r4[r3]);
        r3 = r3 + 1;
        goto L6
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasObservers() {
        if (this.observers.get().length == 0) goto L5;
        return true;
    L5:
        return false;
    }

    int observerCount() {
        return this.observers.get().length;
    }

    @Override // io.reactivex.subjects.Subject
    public Throwable getThrowable() {
        Object r1 = this.buffer.get();
        if (NotificationLite.isError(r1) == true) goto L5;
        return null;
    L5:
        return NotificationLite.getError(r1);
    }

    public T getValue() {
        return this.buffer.getValue();
    }

    public void cleanupBuffer() {
        this.buffer.trimHead();
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

    @Override // io.reactivex.subjects.Subject
    public boolean hasComplete() {
        return NotificationLite.isComplete(this.buffer.get());
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasThrowable() {
        return NotificationLite.isError(this.buffer.get());
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

    boolean add(ReplayDisposable<T> r5) {
    L2:
        ReplayDisposable<T>[] r0 = this.observers.get();
        if (r0 == TERMINATED) goto L4;
        int r1 = r0.length;
        ReplayDisposable<T>[] r3 = new ReplayDisposable[r1 + 1];
        System.arraycopy(r0, 0, r3, 0, r1);
        r3[r1] = r5;
        if (this.observers.compareAndSet(r0, r3) == false) goto L2;
        return true;
    L4:
        return false;
    }

    void remove(ReplayDisposable<T> r7) {
    L2:
        ReplayDisposable<T>[] r0 = this.observers.get();
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
        ReplayDisposable<T>[] r2 = EMPTY;
    L21:
        if (this.observers.compareAndSet(r0, r2) == false) goto L2;
        return;
    L19:
        ReplayDisposable<T>[] r5 = new ReplayDisposable[r1 - 1];
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

    ReplayDisposable<T>[] terminate(Object r3) {
        if (this.buffer.compareAndSet(null, r3) == false) goto L7;
        return this.observers.getAndSet(TERMINATED);
    L7:
        return TERMINATED;
    }
}
