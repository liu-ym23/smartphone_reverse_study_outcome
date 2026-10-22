package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes2.dex */
public final class FlowableCache<T> extends AbstractFlowableWithUpstream<T, T> implements FlowableSubscriber<T> {
    static final CacheSubscription[] EMPTY = null;
    static final CacheSubscription[] TERMINATED = null;
    final int capacityHint;
    volatile boolean done;
    Throwable error;
    final Node<T> head;
    final AtomicBoolean once;
    volatile long size;
    final AtomicReference<CacheSubscription<T>[]> subscribers;
    Node<T> tail;
    int tailOffset;

    public static final class CacheSubscription<T> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 6770240836423125754L;
        final Subscriber<? super T> downstream;
        long index;
        Node<T> node;
        int offset;
        final FlowableCache<T> parent;
        final AtomicLong requested;

        public CacheSubscription(Subscriber<? super T> r1, FlowableCache<T> r2) {
            this.downstream = r1;
            this.parent = r2;
            this.node = r2.head;
            this.requested = new AtomicLong();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.requested.getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE) goto L6;
            this.parent.remove(this);
            return;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L6;
            BackpressureHelper.addCancel(this.requested, r2);
            this.parent.replay(this);
            return;
        }
    }

    public static final class Node<T> {
        volatile Node<T> next;
        final T[] values;

        public Node(int r1) {
            this.values = (T[]) new Object[r1];
        }
    }

    static {
        EMPTY = new CacheSubscription[0];
        TERMINATED = new CacheSubscription[0];
    }

    public FlowableCache(Flowable<T> r1, int r2) {
        super(r1);
        this.capacityHint = r2;
        this.once = new AtomicBoolean();
        Node<T> r3 = new Node(r2);
        this.head = r3;
        this.tail = r3;
        this.subscribers = new AtomicReference(EMPTY);
    }

    public void add(CacheSubscription<T> r5) {
    L2:
        CacheSubscription<T>[] r0 = this.subscribers.get();
        if (r0 == TERMINATED) goto L4;
        int r1 = r0.length;
        CacheSubscription<T>[] r2 = new CacheSubscription[r1 + 1];
        System.arraycopy(r0, 0, r2, 0, r1);
        r2[r1] = r5;
        if (this.subscribers.compareAndSet(r0, r2) == false) goto L2;
        return;
    }

    public long cachedEventCount() {
        return this.size;
    }

    public boolean hasSubscribers() {
        if (this.subscribers.get().length == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isConnected() {
        return this.once.get();
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.done = true;
        CacheSubscription<T>[] r0 = this.subscribers.getAndSet(TERMINATED);
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        replay(r0[r2]);
        r2 = r2 + 1;
        goto L3
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r4) {
        if (this.done == false) goto L6;
        RxJavaPlugins.onError(r4);
        return;
    L6:
        this.error = r4;
        this.done = true;
        CacheSubscription<T>[] r5 = this.subscribers.getAndSet(TERMINATED);
        int r0 = r5.length;
        int r1 = 0;
    L7:
        if (r1 >= r0) goto L9;
        replay(r5[r1]);
        r1 = r1 + 1;
        goto L7
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r6) {
        int r0 = this.tailOffset;
        int r2 = 0;
        if (r0 != this.capacityHint) goto L5;
        Node<T> r1 = new Node(r0);
        r1.values[0] = r6;
        this.tailOffset = 1;
        this.tail.next = r1;
        this.tail = r1;
    L6:
        this.size++;
        CacheSubscription<T>[] r7 = this.subscribers.get();
        int r3 = r7.length;
    L7:
        if (r2 >= r3) goto L9;
        replay(r7[r2]);
        r2 = r2 + 1;
        goto L7
    L9:
        return;
    L5:
        this.tail.values[r0] = r6;
        this.tailOffset = r0 + 1;
        goto L6
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r3) {
        r3.request(Long.MAX_VALUE);
    }

    public void remove(CacheSubscription<T> r7) {
    L2:
        CacheSubscription<T>[] r0 = this.subscribers.get();
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
        CacheSubscription<T>[] r2 = EMPTY;
    L19:
        if (this.subscribers.compareAndSet(r0, r2) == false) goto L2;
        return;
    L17:
        CacheSubscription<T>[] r5 = new CacheSubscription[r1 - 1];
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

    public void replay(CacheSubscription<T> r18) {
        if (r18.getAndIncrement() == 0) goto L5;
        return;
    L5:
        long r2 = r18.index;
        int r4 = r18.offset;
        Node<T> r5 = r18.node;
        AtomicLong r6 = r18.requested;
        Subscriber<? super T> r7 = r18.downstream;
        int r8 = this.capacityHint;
        int r10 = 1;
    L6:
        boolean r11 = this.done;
        if (this.size != r2) goto L9;
        boolean r12 = true;
    L11:
        if (r11 == false) goto L18;
        if (r12 == false) goto L18;
        r18.node = null;
        Throwable r0 = this.error;
        if (r0 == null) goto L16;
        r7.onError(r0);
        return;
    L16:
        r7.onComplete();
        return;
    L18:
        if (r12 == true) goto L28;
        long r13 = r6.get();
        if (r13 == Long.MIN_VALUE) goto L21;
        if (r13 == r2) goto L28;
        if (r4 != r8) goto L27;
        r5 = r5.next;
        r4 = 0;
    L27:
        r7.onNext(r5.values[r4]);
        r4 = r4 + 1;
        r2 = r2 + 1;
        goto L6
    L21:
        r18.node = null;
        return;
    L28:
        r18.index = r2;
        r18.offset = r4;
        r18.node = r5;
        r10 = r18.addAndGet(-r10);
        if (r10 != 0) goto L6;
        return;
    L9:
        r12 = false;
        goto L11
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> r4) {
        CacheSubscription<T> r0 = new CacheSubscription(r4, this);
        r4.onSubscribe(r0);
        add(r0);
        if (this.once.get() == false) goto L5;
    L7:
        replay(r0);
        return;
    L5:
        if (this.once.compareAndSet(false, true) == false) goto L7;
        this.source.subscribe(this);
    }
}
