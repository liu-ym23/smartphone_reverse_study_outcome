package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes2.dex */
public final class FlowablePublish<T> extends ConnectableFlowable<T> implements HasUpstreamPublisher<T>, FlowablePublishClassic<T> {
    static final long CANCELLED = Long.MIN_VALUE;
    final int bufferSize;
    final AtomicReference<PublishSubscriber<T>> current;
    final Publisher<T> onSubscribe;
    final Flowable<T> source;

    public static final class FlowablePublisher<T> implements Publisher<T> {
        private final int bufferSize;
        private final AtomicReference<PublishSubscriber<T>> curr;

        public FlowablePublisher(AtomicReference<PublishSubscriber<T>> r1, int r2) {
            this.curr = r1;
            this.bufferSize = r2;
        }

        @Override // org.reactivestreams.Publisher
        public void subscribe(Subscriber<? super T> r6) {
            InnerSubscriber<T> r0 = new InnerSubscriber(r6);
            r6.onSubscribe(r0);
        L3:
            PublishSubscriber<T> r7 = this.curr.get();
            if (r7 != null) goto L6;
        L7:
            PublishSubscriber<T> r1 = new PublishSubscriber(this.curr, this.bufferSize);
            if (this.curr.compareAndSet(r7, r1) == false) goto L3;
            r7 = r1;
        L12:
            if (r7.add(r0) == false) goto L3;
            if (r0.get() != FlowablePublish.CANCELLED) goto L16;
            r7.remove(r0);
        L17:
            r7.dispatch();
            return;
        L16:
            r0.parent = r7;
            goto L17
        L6:
            if (r7.isDisposed() == false) goto L12;
            goto L7
        }
    }

    public static final class InnerSubscriber<T> extends AtomicLong implements Subscription {
        private static final long serialVersionUID = -4453897557930727610L;
        final Subscriber<? super T> child;
        long emitted;
        volatile PublishSubscriber<T> parent;

        public InnerSubscriber(Subscriber<? super T> r1) {
            this.child = r1;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (get() != FlowablePublish.CANCELLED) goto L5;
            return;
        L5:
            if (getAndSet(FlowablePublish.CANCELLED) == FlowablePublish.CANCELLED) goto L11;
            PublishSubscriber<T> r0 = this.parent;
            if (r0 == null) goto L12;
            r0.remove(this);
            r0.dispatch();
            return;
        L12:
            return;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L8;
            BackpressureHelper.addCancel(this, r2);
            PublishSubscriber<T> r1 = this.parent;
            if (r1 == null) goto L9;
            r1.dispatch();
            return;
        L9:
            return;
        }
    }

    public static final class PublishSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Disposable {
        static final InnerSubscriber[] EMPTY = null;
        static final InnerSubscriber[] TERMINATED = null;
        private static final long serialVersionUID = -202316842419149694L;
        final int bufferSize;
        final AtomicReference<PublishSubscriber<T>> current;
        volatile SimpleQueue<T> queue;
        final AtomicBoolean shouldConnect;
        int sourceMode;
        final AtomicReference<InnerSubscriber<T>[]> subscribers;
        volatile Object terminalEvent;
        final AtomicReference<Subscription> upstream;

        static {
            EMPTY = new InnerSubscriber[0];
            TERMINATED = new InnerSubscriber[0];
        }

        public PublishSubscriber(AtomicReference<PublishSubscriber<T>> r3, int r4) {
            this.upstream = new AtomicReference();
            this.subscribers = new AtomicReference(EMPTY);
            this.current = r3;
            this.shouldConnect = new AtomicBoolean();
            this.bufferSize = r4;
        }

        public boolean add(InnerSubscriber<T> r5) {
        L2:
            InnerSubscriber<T>[] r0 = this.subscribers.get();
            if (r0 == TERMINATED) goto L4;
            int r1 = r0.length;
            InnerSubscriber<T>[] r3 = new InnerSubscriber[r1 + 1];
            System.arraycopy(r0, 0, r3, 0, r1);
            r3[r1] = r5;
            if (this.subscribers.compareAndSet(r0, r3) == false) goto L2;
            return true;
        L4:
            return false;
        }

        public boolean checkTerminated(Object r5, boolean r6) {
            int r0 = 0;
            if (r5 != null) goto L5;
        L18:
            return false;
        L5:
            if (NotificationLite.isComplete(r5) == false) goto L11;
            if (r6 == false) goto L18;
            this.current.compareAndSet(this, null);
            InnerSubscriber<T>[] r4 = this.subscribers.getAndSet(TERMINATED);
            int r7 = r4.length;
        L8:
            if (r0 >= r7) goto L10;
            r4[r0].child.onComplete();
            r0 = r0 + 1;
            goto L8
        L10:
            return true;
        L11:
            Throwable r8 = NotificationLite.getError(r5);
            this.current.compareAndSet(this, null);
            InnerSubscriber<T>[] r9 = this.subscribers.getAndSet(TERMINATED);
            if (r9.length == 0) goto L16;
            int r10 = r9.length;
        L14:
            if (r0 >= r10) goto L17;
            r9[r0].child.onError(r8);
            r0 = r0 + 1;
        L17:
            return true;
        L16:
            RxJavaPlugins.onError(r8);
            goto L17
        }

        public void dispatch() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            AtomicReference<InnerSubscriber<T>[]> r2 = this.subscribers;
            boolean r3 = true;
            InnerSubscriber<T>[] r4 = r2.get();
            int r5 = 1;
        L6:
            Object r0 = this.terminalEvent;
            SimpleQueue<T> r6 = this.queue;
            if (r6 != null) goto L9;
        L12:
            boolean r8 = r3;
        L14:
            if (checkTerminated(r0, r8) == true) goto L15;
            if (r8 == true) goto L87;
            int r1 = r4.length;
            int r9 = r4.length;
            int r12 = 0;
            int r13 = 0;
            long r14 = Long.MAX_VALUE;
        L19:
            if (r12 >= r9) goto L26;
            InnerSubscriber<T> r7 = r4[r12];
            long r18 = r7.get();
            if (r18 == FlowablePublish.CANCELLED) goto L23;
            r14 = Math.min(r14, r18 - r7.emitted);
        L24:
            r12 = r12 + 1;
            goto L19
        L23:
            r13 = r13 + 1;
            goto L24
        L26:
            if (r1 == r13) goto L27;
            int r11 = 0;
        L42:
            long r15 = r11;
            if (r15 >= r14) goto L78;
            Object r10 = this.terminalEvent;
            T r16 = r6.poll();     // Catch: Throwable -> L47
        L49:
            if (r16 != null) goto L51;
            boolean r17 = r3;
        L53:
            if (checkTerminated(r10, r17) == true) goto L54;
            if (r17 == true) goto L56;
            Object r19 = NotificationLite.getValue(r16);
            int r20 = r4.length;
            int r110 = 0;
            boolean r111 = false;
        L58:
            if (r110 >= r20) goto L68;
            InnerSubscriber<T> r21 = r4[r110];
            long r22 = r21.get();
            if (r22 != FlowablePublish.CANCELLED) goto L62;
            r6 = r6;
            r17 = r17;
            r111 = true;
        L67:
            r110 = r110 + 1;
            r6 = r6;
            r17 = r17;
            goto L58
        L62:
            if (r22 == Long.MAX_VALUE) goto L65;
            r21.emitted++;
        L65:
            r21.child.onNext(r19);
            goto L67
        L68:
            SimpleQueue<T> r23 = r6;
            boolean r24 = r17;
            r11 = r11 + 1;
            InnerSubscriber<T>[] r25 = r2.get();
            if (r111 == true) goto L73;
            if (r25 != r4) goto L73;
            r6 = r23;
            r8 = r24;
            r3 = true;
        L73:
            if (r11 != 0) goto L75;
        L77:
            r4 = r25;
            r3 = true;
            goto L6
        L75:
            if (this.sourceMode == 1) goto L77;
            this.upstream.get().request(r11);
            goto L77
        L56:
            r8 = r17;
            goto L78
        L54:
            return;
        L51:
            r17 = false;
        L47:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.upstream.get().cancel();
            r10 = NotificationLite.error(th);
            this.terminalEvent = r10;
            r16 = null;
        L78:
            if (r11 == 0) goto L82;
            r3 = true;
            if (this.sourceMode == 1) goto L84;
            this.upstream.get().request(r15);
        L84:
            if (r14 == 0) goto L87;
            if (r8 == true) goto L87;
        L82:
            r3 = true;
            goto L84
        L27:
            Object r26 = this.terminalEvent;
            T r27 = r6.poll();     // Catch: Throwable -> L30
        L32:
            if (r27 != null) goto L34;
            boolean r28 = r3;
        L36:
            if (checkTerminated(r26, r28) == true) goto L37;
            if (this.sourceMode == r3) goto L6;
            this.upstream.get().request(1);
            goto L6
        L37:
            return;
        L34:
            r28 = false;
        L30:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.upstream.get().cancel();
            r26 = NotificationLite.error(th);
            this.terminalEvent = r26;
            r27 = null;
        L87:
            r5 = addAndGet(-r5);
            if (r5 == 0) goto L89;
            r4 = r2.get();
            goto L6
        L89:
            return;
        L15:
            return;
        L9:
            if (r6.isEmpty() == true) goto L12;
            r8 = false;
            goto L14
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            InnerSubscriber<T>[] r0 = this.subscribers.get();
            InnerSubscriber<T>[] r1 = TERMINATED;
            if (r0 != r1) goto L5;
            return;
        L5:
            if (this.subscribers.getAndSet(r1) == r1) goto L9;
            this.current.compareAndSet(this, null);
            SubscriptionHelper.cancel(this.upstream);
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (this.subscribers.get() != TERMINATED) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.terminalEvent != null) goto L6;
            this.terminalEvent = NotificationLite.complete();
            dispatch();
            return;
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            if (this.terminalEvent != null) goto L5;
            this.terminalEvent = NotificationLite.error(r2);
            dispatch();
            return;
        L5:
            RxJavaPlugins.onError(r2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r2) {
            if (this.sourceMode == 0) goto L5;
        L8:
            dispatch();
            return;
        L5:
            if (this.queue.offer(r2) == true) goto L8;
            onError(new MissingBackpressureException("Prefetch queue is full?!"));
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r4) {
            if (SubscriptionHelper.setOnce(this.upstream, r4) == true) goto L5;
            return;
        L5:
            if ((r4 instanceof QueueSubscription) == false) goto L14;
            QueueSubscription r0 = (QueueSubscription) r4;
            int r1 = r0.requestFusion(7);
            if (r1 != 1) goto L11;
            this.sourceMode = r1;
            this.queue = r0;
            this.terminalEvent = NotificationLite.complete();
            dispatch();
            return;
        L11:
            if (r1 != 2) goto L14;
            this.sourceMode = r1;
            this.queue = r0;
            r4.request(this.bufferSize);
            return;
        L14:
            this.queue = new SpscArrayQueue(this.bufferSize);
            r4.request(this.bufferSize);
        }

        public void remove(InnerSubscriber<T> r7) {
        L2:
            InnerSubscriber<T>[] r0 = this.subscribers.get();
            int r1 = r0.length;
            if (r1 == 0) goto L20;
            int r3 = 0;
        L6:
            if (r3 >= r1) goto L11;
            if (r0[r3].equals(r7) == true) goto L12;
            r3 = r3 + 1;
        L12:
            if (r3 < 0) goto L13;
            if (r1 != 1) goto L17;
            InnerSubscriber<T>[] r2 = EMPTY;
        L19:
            if (this.subscribers.compareAndSet(r0, r2) == false) goto L2;
            return;
        L17:
            InnerSubscriber<T>[] r5 = new InnerSubscriber[r1 - 1];
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
    }

    private FlowablePublish(Publisher<T> r1, Flowable<T> r2, AtomicReference<PublishSubscriber<T>> r3, int r4) {
        this.onSubscribe = r1;
        this.source = r2;
        this.current = r3;
        this.bufferSize = r4;
    }

    public static <T> ConnectableFlowable<T> create(Flowable<T> r3, int r4) {
        AtomicReference r0 = new AtomicReference();
        return RxJavaPlugins.onAssembly(new FlowablePublish(new FlowablePublisher(r0, r4), r3, r0, r4));
    }

    @Override // io.reactivex.flowables.ConnectableFlowable
    public void connect(Consumer<? super Disposable> r5) {
    L2:
        PublishSubscriber<T> r0 = this.current.get();
        if (r0 != null) goto L5;
    L6:
        PublishSubscriber<T> r1 = new PublishSubscriber(this.current, this.bufferSize);
        if (this.current.compareAndSet(r0, r1) == false) goto L2;
        r0 = r1;
    L10:
        boolean r2 = false;
        if (r0.shouldConnect.get() == false) goto L13;
    L22:
        r5.accept(r0);     // Catch: Throwable -> L19
        if (r2 == false) goto L27;
        this.source.subscribe(r0);
        return;
    L27:
        return;
    L19:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        throw ExceptionHelper.wrapOrThrow(th);
    L13:
        if (r0.shouldConnect.compareAndSet(false, true) == false) goto L22;
        r2 = true;
        goto L22
    L5:
        if (r0.isDisposed() == false) goto L10;
        goto L6
    }

    @Override // io.reactivex.internal.operators.flowable.FlowablePublishClassic
    public int publishBufferSize() {
        return this.bufferSize;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowablePublishClassic
    public Publisher<T> publishSource() {
        return this.source;
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamPublisher
    public Publisher<T> source() {
        return this.source;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> r1) {
        this.onSubscribe.subscribe(r1);
    }
}
