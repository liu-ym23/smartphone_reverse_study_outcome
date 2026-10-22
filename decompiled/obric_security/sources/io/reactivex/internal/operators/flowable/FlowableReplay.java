package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.ResettableConnectable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.internal.subscribers.SubscriberResourceWrapper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Timed;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import tmsdkobf.b0$$ExternalSyntheticBackport0;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableReplay<T> extends ConnectableFlowable<T> implements HasUpstreamPublisher<T>, ResettableConnectable {
    static final Callable DEFAULT_UNBOUNDED_FACTORY = null;
    final Callable<? extends ReplayBuffer<T>> bufferFactory;
    final AtomicReference<ReplaySubscriber<T>> current;
    final Publisher<T> onSubscribe;
    final Flowable<T> source;

    static class BoundedReplayBuffer<T> extends AtomicReference<Node> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 2346567790059478686L;
        long index;
        int size;
        Node tail;

        Object enterTransform(Object r1) {
            return r1;
        }

        Object leaveTransform(Object r1) {
            return r1;
        }

        void truncate() {
        }

        BoundedReplayBuffer() {
            Node r0 = new Node(null, 0);
            this.tail = r0;
            set(r0);
        }

        final void addLast(Node r2) {
            this.tail.set(r2);
            this.tail = r2;
            this.size++;
        }

        final void removeFirst() {
            Node r0 = get().get();
            if (r0 == null) goto L7;
            this.size--;
            setFirst(r0);
            return;
        L7:
            throw new IllegalStateException("Empty list!");
        }

        final void removeSome(int r3) {
            Node r0 = get();
        L3:
            if (r3 <= 0) goto L5;
            r0 = r0.get();
            r3 = r3 - 1;
            this.size--;
            goto L3
        L5:
            setFirst(r0);
            Node r4 = get();
            if (r4.get() != null) goto L10;
            this.tail = r4;
            return;
        }

        final void setFirst(Node r1) {
            set(r1);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public final void next(T r6) {
            Object r7 = enterTransform(NotificationLite.next(r6));
            long r1 = this.index + 1;
            this.index = r1;
            addLast(new Node(r7, r1));
            truncate();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public final void error(Throwable r6) {
            Object r7 = enterTransform(NotificationLite.error(r6));
            long r1 = this.index + 1;
            this.index = r1;
            addLast(new Node(r7, r1));
            truncateFinal();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public final void complete() {
            Object r0 = enterTransform(NotificationLite.complete());
            long r2 = this.index + 1;
            this.index = r2;
            addLast(new Node(r0, r2));
            truncateFinal();
        }

        final void trimHead() {
            Node r0 = get();
            if (r0.value == null) goto L6;
            Node r1 = new Node(null, 0);
            r1.lazySet(r0.get());
            set(r1);
            return;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public final void replay(InnerSubscription<T> r15) {
            monitor-enter(r15);
        L60:
            th = move-exception;
            throw th;
        L4:
            if (r15.emitting == false) goto L8;
            r15.missed = true;     // Catch: Throwable -> L60
            monitor-exit(r15);     // Catch: Throwable -> L60
            return;
        L8:
            r15.emitting = true;     // Catch: Throwable -> L60
            monitor-exit(r15);     // Catch: Throwable -> L60
        L11:
            if (r15.isDisposed() == true) goto L12;
            long r3 = r15.get();
            if (r3 != Long.MAX_VALUE) goto L17;
            boolean r0 = true;
        L18:
            Node r6 = (Node) r15.index();
            if (r6 != null) goto L21;
            r6 = getHead();
            r15.index = r6;
            BackpressureHelper.add(r15.totalRequested, r6.index);
        L21:
            long r9 = 0;
        L23:
            if (r3 == 0) goto L44;
            Node r11 = r6.get();
            if (r11 == null) goto L44;
            Object r7 = leaveTransform(r11.value);
        L36:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r15.index = null;
            r15.dispose();
            if (NotificationLite.isError(r7) == false) goto L40;
            return;
        L40:
            if (NotificationLite.isComplete(r7) == true) goto L75;
            r15.child.onError(th);
            return;
        L75:
            return;
        L28:
            if (NotificationLite.accept(r7, r15.child) == true) goto L29;
            r9 = r9 + 1;
            r3 = r3 - 1;
            if (r15.isDisposed() == true) goto L33;
            r6 = r11;
            goto L23
        L33:
            r15.index = null;
            return;
        L29:
            r15.index = null;     // Catch: Throwable -> L36
            return;
        L44:
            if (r9 == 0) goto L48;
            r15.index = r6;
            if (r0 == true) goto L48;
            r15.produced(r9);
        L48:
            monitor-enter(r15);
        L57:
            th = move-exception;
            throw th;
        L50:
            if (r15.missed == false) goto L51;
            r15.missed = false;     // Catch: Throwable -> L57
            monitor-exit(r15);     // Catch: Throwable -> L57
            goto L11
        L51:
            r15.emitting = false;     // Catch: Throwable -> L57
            monitor-exit(r15);     // Catch: Throwable -> L57
            return;
        L17:
            r0 = false;
            goto L18
        L12:
            r15.index = null;
        }

        void truncateFinal() {
            trimHead();
        }

        final void collect(Collection<? super T> r4) {
            Node r0 = getHead();
        L3:
            r0 = r0.get();
            if (r0 == null) goto L11;
            Object r1 = leaveTransform(r0.value);
            if (NotificationLite.isComplete(r1) == true) goto L15;
            if (NotificationLite.isError(r1) == true) goto L16;
            r4.add((Object) NotificationLite.getValue(r1));
            goto L3
        L16:
            return;
        L15:
            return;
        }

        boolean hasError() {
            if (this.tail.value != null) goto L5;
        L7:
            return false;
        L5:
            if (NotificationLite.isError(leaveTransform(this.tail.value)) == false) goto L7;
            return true;
        }

        boolean hasCompleted() {
            if (this.tail.value != null) goto L5;
        L7:
            return false;
        L5:
            if (NotificationLite.isComplete(leaveTransform(this.tail.value)) == false) goto L7;
            return true;
        }

        Node getHead() {
            return get();
        }
    }

    static final class ConnectableFlowableReplay<T> extends ConnectableFlowable<T> {
        private final ConnectableFlowable<T> cf;
        private final Flowable<T> flowable;

        ConnectableFlowableReplay(ConnectableFlowable<T> r1, Flowable<T> r2) {
            this.cf = r1;
            this.flowable = r2;
        }

        @Override // io.reactivex.flowables.ConnectableFlowable
        public void connect(Consumer<? super Disposable> r1) {
            this.cf.connect(r1);
        }

        @Override // io.reactivex.Flowable
        protected void subscribeActual(Subscriber<? super T> r1) {
            this.flowable.subscribe(r1);
        }
    }

    static final class DefaultUnboundedFactory implements Callable<Object> {
        DefaultUnboundedFactory() {
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return new UnboundedReplayBuffer(16);
        }
    }

    static final class InnerSubscription<T> extends AtomicLong implements Subscription, Disposable {
        static final long CANCELLED = Long.MIN_VALUE;
        private static final long serialVersionUID = -4453897557930727610L;
        final Subscriber<? super T> child;
        boolean emitting;
        Object index;
        boolean missed;
        final ReplaySubscriber<T> parent;
        final AtomicLong totalRequested;

        InnerSubscription(ReplaySubscriber<T> r1, Subscriber<? super T> r2) {
            this.parent = r1;
            this.child = r2;
            this.totalRequested = new AtomicLong();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r5) {
            if (SubscriptionHelper.validate(r5) == true) goto L5;
            return;
        L5:
            if (BackpressureHelper.addCancel(this, r5) == Long.MIN_VALUE) goto L9;
            BackpressureHelper.add(this.totalRequested, r5);
            this.parent.manageRequests();
            this.parent.buffer.replay(this);
            return;
        }

        public long produced(long r1) {
            return BackpressureHelper.producedCancel(this, r1);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (get() != Long.MIN_VALUE) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE) goto L6;
            this.parent.remove(this);
            this.parent.manageRequests();
            this.index = null;
            return;
        }

        <U> U index() {
            return (U) this.index;
        }
    }

    static final class MulticastFlowable<R, U> extends Flowable<R> {
        private final Callable<? extends ConnectableFlowable<U>> connectableFactory;
        private final Function<? super Flowable<U>, ? extends Publisher<R>> selector;

        final class DisposableConsumer implements Consumer<Disposable> {
            private final SubscriberResourceWrapper<R> srw;
            final /* synthetic */ MulticastFlowable this$0;

            @Override // io.reactivex.functions.Consumer
            public /* bridge */ /* synthetic */ void accept(Disposable r1) throws Exception {
                accept2(r1);
            }

            DisposableConsumer(MulticastFlowable r1, SubscriberResourceWrapper<R> r2) {
                this.this$0 = r1;
                this.srw = r2;
            }

            /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
            public void accept2(Disposable r1) {
                this.srw.setResource(r1);
            }
        }

        MulticastFlowable(Callable<? extends ConnectableFlowable<U>> r1, Function<? super Flowable<U>, ? extends Publisher<R>> r2) {
            this.connectableFactory = r1;
            this.selector = r2;
        }

        @Override // io.reactivex.Flowable
        protected void subscribeActual(Subscriber<? super R> r4) {
            ConnectableFlowable r0 = (ConnectableFlowable) ObjectHelper.requireNonNull(this.connectableFactory.call(), "The connectableFactory returned null");     // Catch: Throwable -> L9
            Publisher r1 = (Publisher) ObjectHelper.requireNonNull(this.selector.apply(r0), "The selector returned a null Publisher");     // Catch: Throwable -> L6
            SubscriberResourceWrapper r2 = new SubscriberResourceWrapper(r4);
            r1.subscribe(r2);
            r0.connect(new DisposableConsumer(this, r2));
            return;
        L6:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, r4);
            return;
        L9:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, r4);
        }
    }

    static final class Node extends AtomicReference<Node> {
        private static final long serialVersionUID = 245354315435971818L;
        final long index;
        final Object value;

        Node(Object r1, long r2) {
            this.value = r1;
            this.index = r2;
        }
    }

    interface ReplayBuffer<T> {
        void complete();

        void error(Throwable r1);

        void next(T r1);

        void replay(InnerSubscription<T> r1);
    }

    static final class ReplayBufferTask<T> implements Callable<ReplayBuffer<T>> {
        private final int bufferSize;

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() throws Exception {
            return call();
        }

        ReplayBufferTask(int r1) {
            this.bufferSize = r1;
        }

        @Override // java.util.concurrent.Callable
        public ReplayBuffer<T> call() {
            return new SizeBoundReplayBuffer(this.bufferSize);
        }
    }

    static final class ReplayPublisher<T> implements Publisher<T> {
        private final Callable<? extends ReplayBuffer<T>> bufferFactory;
        private final AtomicReference<ReplaySubscriber<T>> curr;

        ReplayPublisher(AtomicReference<ReplaySubscriber<T>> r1, Callable<? extends ReplayBuffer<T>> r2) {
            this.curr = r1;
            this.bufferFactory = r2;
        }

        @Override // org.reactivestreams.Publisher
        public void subscribe(Subscriber<? super T> r4) {
        L2:
            ReplaySubscriber<T> r0 = this.curr.get();
            if (r0 != null) goto L12;
            ReplaySubscriber<T> r1 = new ReplaySubscriber(this.bufferFactory.call());
            if (b0$$ExternalSyntheticBackport0.m(this.curr, null, r1) == false) goto L2;
            r0 = r1;
        L9:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, r4);
            return;
        L12:
            InnerSubscription<T> r3 = new InnerSubscription(r0, r4);
            r4.onSubscribe(r3);
            r0.add(r3);
            if (r3.isDisposed() == false) goto L16;
            r0.remove(r3);
            return;
        L16:
            r0.manageRequests();
            r0.buffer.replay(r3);
        }
    }

    static final class ReplaySubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Disposable {
        static final InnerSubscription[] EMPTY = null;
        static final InnerSubscription[] TERMINATED = null;
        private static final long serialVersionUID = 7224554242710036740L;
        final ReplayBuffer<T> buffer;
        boolean done;
        final AtomicInteger management;
        long maxChildRequested;
        long maxUpstreamRequested;
        final AtomicBoolean shouldConnect;
        final AtomicReference<InnerSubscription<T>[]> subscribers;

        static {
            EMPTY = new InnerSubscription[0];
            TERMINATED = new InnerSubscription[0];
        }

        ReplaySubscriber(ReplayBuffer<T> r2) {
            this.buffer = r2;
            this.management = new AtomicInteger();
            this.subscribers = new AtomicReference(EMPTY);
            this.shouldConnect = new AtomicBoolean();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (this.subscribers.get() != TERMINATED) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.subscribers.set(TERMINATED);
            SubscriptionHelper.cancel(this);
        }

        boolean add(InnerSubscription<T> r5) {
            r5.getClass();
        L3:
            InnerSubscription<T>[] r0 = this.subscribers.get();
            if (r0 == TERMINATED) goto L5;
            int r1 = r0.length;
            InnerSubscription[] r3 = new InnerSubscription[r1 + 1];
            System.arraycopy(r0, 0, r3, 0, r1);
            r3[r1] = r5;
            if (b0$$ExternalSyntheticBackport0.m(this.subscribers, r0, r3) == false) goto L3;
            return true;
        L5:
            return false;
        }

        void remove(InnerSubscription<T> r7) {
        L2:
            InnerSubscription<T>[] r0 = this.subscribers.get();
            int r1 = r0.length;
            if (r1 == 0) goto L4;
            int r3 = 0;
        L6:
            if (r3 >= r1) goto L11;
            if (r0[r3].equals(r7) == true) goto L12;
            r3 = r3 + 1;
        L12:
            if (r3 < 0) goto L13;
            if (r1 != 1) goto L17;
            InnerSubscription[] r2 = EMPTY;
        L19:
            if (b0$$ExternalSyntheticBackport0.m(this.subscribers, r0, r2) == false) goto L2;
            return;
        L17:
            InnerSubscription[] r5 = new InnerSubscription[r1 - 1];
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

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r5) {
            if (SubscriptionHelper.setOnce(this, r5) == false) goto L7;
            manageRequests();
            InnerSubscription<T>[] r6 = this.subscribers.get();
            int r0 = r6.length;
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L9;
            InnerSubscription<T> r2 = r6[r1];
            this.buffer.replay(r2);
            r1 = r1 + 1;
            goto L5
        L9:
            return;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r5) {
            if (this.done == true) goto L7;
            this.buffer.next(r5);
            InnerSubscription<T>[] r6 = this.subscribers.get();
            int r0 = r6.length;
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L9;
            InnerSubscription<T> r2 = r6[r1];
            this.buffer.replay(r2);
            r1 = r1 + 1;
            goto L5
        L9:
            return;
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r5) {
            if (this.done == true) goto L7;
            this.done = true;
            this.buffer.error(r5);
            InnerSubscription<T>[] r6 = this.subscribers.getAndSet(TERMINATED);
            int r0 = r6.length;
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L10;
            InnerSubscription<T> r2 = r6[r1];
            this.buffer.replay(r2);
            r1 = r1 + 1;
            goto L5
        L10:
            return;
        L7:
            RxJavaPlugins.onError(r5);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done == true) goto L7;
            this.done = true;
            this.buffer.complete();
            InnerSubscription<T>[] r0 = this.subscribers.getAndSet(TERMINATED);
            int r1 = r0.length;
            int r2 = 0;
        L5:
            if (r2 >= r1) goto L9;
            InnerSubscription<T> r3 = r0[r2];
            this.buffer.replay(r3);
            r2 = r2 + 1;
            goto L5
        L9:
            return;
        }

        void manageRequests() {
            if (this.management.getAndIncrement() == 0) goto L5;
            return;
        L5:
            int r0 = 1;
        L7:
            if (isDisposed() == true) goto L8;
            InnerSubscription<T>[] r1 = this.subscribers.get();
            long r2 = this.maxChildRequested;
            int r4 = r1.length;
            int r5 = 0;
            long r6 = r2;
        L10:
            if (r5 >= r4) goto L12;
            r6 = Math.max(r6, r1[r5].totalRequested.get());
            r5 = r5 + 1;
            goto L10
        L12:
            long r7 = this.maxUpstreamRequested;
            Subscription r3 = get();
            long r8 = r6 - r2;
            if (r8 == 0) goto L25;
            this.maxChildRequested = r6;
            if (r3 != null) goto L17;
            long r9 = r7 + r8;
            if (r9 >= 0) goto L23;
            r9 = Long.MAX_VALUE;
        L23:
            this.maxUpstreamRequested = r9;
        L28:
            r0 = this.management.addAndGet(-r0);
            if (r0 != 0) goto L7;
            return;
        L17:
            if (r7 == 0) goto L19;
            this.maxUpstreamRequested = 0;
            r3.request(r7 + r8);
            goto L28
        L19:
            r3.request(r8);
            goto L28
        L25:
            if (r7 == 0) goto L28;
            if (r3 == null) goto L28;
            this.maxUpstreamRequested = 0;
            r3.request(r7);
            goto L28
        }
    }

    static final class ScheduledReplayBufferTask<T> implements Callable<ReplayBuffer<T>> {
        private final int bufferSize;
        private final long maxAge;
        private final Scheduler scheduler;
        private final TimeUnit unit;

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() throws Exception {
            return call();
        }

        ScheduledReplayBufferTask(int r1, long r2, TimeUnit r4, Scheduler r5) {
            this.bufferSize = r1;
            this.maxAge = r2;
            this.unit = r4;
            this.scheduler = r5;
        }

        @Override // java.util.concurrent.Callable
        public ReplayBuffer<T> call() {
            return new SizeAndTimeBoundReplayBuffer(this.bufferSize, this.maxAge, this.unit, this.scheduler);
        }
    }

    static final class SizeAndTimeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = 3457957419649567404L;
        final int limit;
        final long maxAge;
        final Scheduler scheduler;
        final TimeUnit unit;

        SizeAndTimeBoundReplayBuffer(int r1, long r2, TimeUnit r4, Scheduler r5) {
            this.scheduler = r5;
            this.limit = r1;
            this.maxAge = r2;
            this.unit = r4;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        Object enterTransform(Object r4) {
            return new Timed(r4, this.scheduler.now(this.unit), this.unit);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        Object leaveTransform(Object r1) {
            return ((Timed) r1).value();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        void truncate() {
            long r0 = this.scheduler.now(this.unit) - this.maxAge;
            Node r2 = (Node) get();
            Node r3 = r2.get();
            int r4 = 0;
        L3:
            Node r8 = r3;
            Node r5 = r2;
            r2 = r8;
            if (r2 == null) goto L13;
            if (this.size <= this.limit) goto L11;
            if (this.size <= 1) goto L11;
            r4 = r4 + 1;
            this.size--;
            r3 = r2.get();
        L11:
            if (((Timed) r2.value).time() > r0) goto L13;
            r4 = r4 + 1;
            this.size--;
            r3 = r2.get();
        L13:
            if (r4 == 0) goto L24;
            setFirst(r5);
            return;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        void truncateFinal() {
            long r0 = this.scheduler.now(this.unit) - this.maxAge;
            Node r2 = (Node) get();
            Node r3 = r2.get();
            int r4 = 0;
        L3:
            Node r9 = r3;
            Node r5 = r2;
            r2 = r9;
            if (r2 == null) goto L10;
            if (this.size <= 1) goto L10;
            if (((Timed) r2.value).time() > r0) goto L10;
            r4 = r4 + 1;
            this.size--;
            r3 = r2.get();
        L10:
            if (r4 == 0) goto L16;
            setFirst(r5);
            return;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        Node getHead() {
            long r0 = this.scheduler.now(this.unit) - this.maxAge;
            Node r6 = (Node) get();
            Node r2 = r6.get();
        L3:
            Node r3 = r2;
            Node r4 = r6;
            r6 = r3;
            if (r6 == null) goto L14;
            Timed r5 = (Timed) r6.value;
            if (NotificationLite.isComplete(r5.value()) == true) goto L14;
            if (NotificationLite.isError(r5.value()) == true) goto L14;
            if (r5.time() > r0) goto L14;
            r2 = r6.get();
        L14:
            return r4;
        }
    }

    static final class SizeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = -5898283885385201806L;
        final int limit;

        SizeBoundReplayBuffer(int r1) {
            this.limit = r1;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        void truncate() {
            if (this.size <= this.limit) goto L6;
            removeFirst();
            return;
        }
    }

    static final class UnboundedReplayBuffer<T> extends ArrayList<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 7063189396499112664L;
        volatile int size;

        UnboundedReplayBuffer(int r1) {
            super(r1);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public void next(T r1) {
            add(NotificationLite.next(r1));
            this.size++;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public void error(Throwable r1) {
            add(NotificationLite.error(r1));
            this.size++;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public void complete() {
            add(NotificationLite.complete());
            this.size++;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public void replay(InnerSubscription<T> r15) {
            monitor-enter(r15);
        L54:
            th = move-exception;
            throw th;
        L4:
            if (r15.emitting == false) goto L8;
            r15.missed = true;     // Catch: Throwable -> L54
            monitor-exit(r15);     // Catch: Throwable -> L54
            return;
        L8:
            r15.emitting = true;     // Catch: Throwable -> L54
            monitor-exit(r15);     // Catch: Throwable -> L54
            Subscriber<? super T> r0 = r15.child;
        L12:
            if (r15.isDisposed() == true) goto L13;
            int r1 = this.size;
            Integer r2 = (Integer) r15.index();
            if (r2 == null) goto L17;
            int r3 = r2.intValue();
        L18:
            long r4 = r15.get();
            long r8 = r4;
            long r10 = 0;
        L20:
            if (r8 == 0) goto L38;
            if (r3 >= r1) goto L38;
            Object r12 = get(r3);
            if (NotificationLite.accept(r12, r0) == true) goto L25;
            if (r15.isDisposed() == true) goto L28;
            r3 = r3 + 1;
            r8 = r8 - 1;
            r10 = r10 + 1;
            goto L20
        L28:
            return;
        L25:
            return;
        L30:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r15.dispose();
            if (NotificationLite.isError(r12) == false) goto L34;
            return;
        L34:
            if (NotificationLite.isComplete(r12) == true) goto L69;
            r0.onError(th);
            return;
        L69:
            return;
        L38:
            if (r10 == 0) goto L42;
            r15.index = Integer.valueOf(r3);
            if (r4 == Long.MAX_VALUE) goto L42;
            r15.produced(r10);
        L42:
            monitor-enter(r15);
        L51:
            th = move-exception;
            throw th;
        L44:
            if (r15.missed == false) goto L45;
            r15.missed = false;     // Catch: Throwable -> L51
            monitor-exit(r15);     // Catch: Throwable -> L51
            goto L12
        L45:
            r15.emitting = false;     // Catch: Throwable -> L51
            monitor-exit(r15);     // Catch: Throwable -> L51
            return;
        L17:
            r3 = 0;
            goto L18
        }
    }

    static {
        DEFAULT_UNBOUNDED_FACTORY = new DefaultUnboundedFactory();
    }

    public static <U, R> Flowable<R> multicastSelector(Callable<? extends ConnectableFlowable<U>> r1, Function<? super Flowable<U>, ? extends Publisher<R>> r2) {
        return new MulticastFlowable(r1, r2);
    }

    public static <T> ConnectableFlowable<T> observeOn(ConnectableFlowable<T> r1, Scheduler r2) {
        return RxJavaPlugins.onAssembly(new ConnectableFlowableReplay(r1, r1.observeOn(r2)));
    }

    public static <T> ConnectableFlowable<T> createFrom(Flowable<? extends T> r1) {
        return create(r1, DEFAULT_UNBOUNDED_FACTORY);
    }

    public static <T> ConnectableFlowable<T> create(Flowable<T> r1, int r2) {
        if (r2 != Integer.MAX_VALUE) goto L7;
        return createFrom(r1);
    L7:
        return create(r1, new ReplayBufferTask(r2));
    }

    public static <T> ConnectableFlowable<T> create(Flowable<T> r6, long r7, TimeUnit r9, Scheduler r10) {
        return create(r6, r7, r9, r10, Integer.MAX_VALUE);
    }

    public static <T> ConnectableFlowable<T> create(Flowable<T> r7, long r8, TimeUnit r10, Scheduler r11, int r12) {
        return create(r7, new ScheduledReplayBufferTask(r12, r8, r10, r11));
    }

    static <T> ConnectableFlowable<T> create(Flowable<T> r3, Callable<? extends ReplayBuffer<T>> r4) {
        AtomicReference r0 = new AtomicReference();
        return RxJavaPlugins.onAssembly(new FlowableReplay(new ReplayPublisher(r0, r4), r3, r0, r4));
    }

    private FlowableReplay(Publisher<T> r1, Flowable<T> r2, AtomicReference<ReplaySubscriber<T>> r3, Callable<? extends ReplayBuffer<T>> r4) {
        this.onSubscribe = r1;
        this.source = r2;
        this.current = r3;
        this.bufferFactory = r4;
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamPublisher
    public Publisher<T> source() {
        return this.source;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> r1) {
        this.onSubscribe.subscribe(r1);
    }

    @Override // io.reactivex.internal.disposables.ResettableConnectable
    public void resetIf(Disposable r2) {
        b0$$ExternalSyntheticBackport0.m(this.current, (ReplaySubscriber) r2, null);
    }

    @Override // io.reactivex.flowables.ConnectableFlowable
    public void connect(Consumer<? super Disposable> r5) {
    L2:
        ReplaySubscriber<T> r0 = this.current.get();
        if (r0 != null) goto L5;
    L29:
        ReplaySubscriber<T> r2 = new ReplaySubscriber(this.bufferFactory.call());
        if (b0$$ExternalSyntheticBackport0.m(this.current, r0, r2) == false) goto L2;
        r0 = r2;
    L12:
        if (r0.shouldConnect.get() == false) goto L14;
    L16:
        boolean r1 = false;
    L31:
        r5.accept(r0);     // Catch: Throwable -> L21
        if (r1 == false) goto L36;
        this.source.subscribe(r0);
        return;
    L36:
        return;
    L21:
        th = move-exception;
        if (r1 == false) goto L24;
        r0.shouldConnect.compareAndSet(true, false);
    L24:
        Exceptions.throwIfFatal(th);
        throw ExceptionHelper.wrapOrThrow(th);
    L14:
        if (r0.shouldConnect.compareAndSet(false, true) == false) goto L16;
        r1 = true;
    L26:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        throw ExceptionHelper.wrapOrThrow(th);
    L5:
        if (r0.isDisposed() == false) goto L12;
        goto L29
    }
}
