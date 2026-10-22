package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.flowables.GroupedFlowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.EmptyComponent;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableGroupBy<T, K, V> extends AbstractFlowableWithUpstream<T, GroupedFlowable<K, V>> {
    final int bufferSize;
    final boolean delayError;
    final Function<? super T, ? extends K> keySelector;
    final Function<? super Consumer<Object>, ? extends Map<K, Object>> mapFactory;
    final Function<? super T, ? extends V> valueSelector;

    static final class EvictionAction<K, V> implements Consumer<GroupedUnicast<K, V>> {
        final Queue<GroupedUnicast<K, V>> evictedGroups;

        @Override // io.reactivex.functions.Consumer
        public /* bridge */ /* synthetic */ void accept(Object r1) throws Exception {
            accept((GroupedUnicast) r1);
        }

        EvictionAction(Queue<GroupedUnicast<K, V>> r1) {
            this.evictedGroups = r1;
        }

        public void accept(GroupedUnicast<K, V> r1) {
            this.evictedGroups.offer(r1);
        }
    }

    public static final class GroupBySubscriber<T, K, V> extends BasicIntQueueSubscription<GroupedFlowable<K, V>> implements FlowableSubscriber<T> {
        static final Object NULL_KEY = null;
        private static final long serialVersionUID = -3688291656102519502L;
        final int bufferSize;
        final AtomicBoolean cancelled;
        final boolean delayError;
        boolean done;
        final Subscriber<? super GroupedFlowable<K, V>> downstream;
        Throwable error;
        final Queue<GroupedUnicast<K, V>> evictedGroups;
        volatile boolean finished;
        final AtomicInteger groupCount;
        final Map<Object, GroupedUnicast<K, V>> groups;
        final Function<? super T, ? extends K> keySelector;
        boolean outputFused;
        final SpscLinkedArrayQueue<GroupedFlowable<K, V>> queue;
        final AtomicLong requested;
        Subscription upstream;
        final Function<? super T, ? extends V> valueSelector;

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public /* bridge */ /* synthetic */ Object poll() throws Exception {
            return poll();
        }

        static {
            NULL_KEY = new Object();
        }

        public GroupBySubscriber(Subscriber<? super GroupedFlowable<K, V>> r3, Function<? super T, ? extends K> r4, Function<? super T, ? extends V> r5, int r6, boolean r7, Map<Object, GroupedUnicast<K, V>> r8, Queue<GroupedUnicast<K, V>> r9) {
            this.cancelled = new AtomicBoolean();
            this.requested = new AtomicLong();
            this.groupCount = new AtomicInteger(1);
            this.downstream = r3;
            this.keySelector = r4;
            this.valueSelector = r5;
            this.bufferSize = r6;
            this.delayError = r7;
            this.groups = r8;
            this.evictedGroups = r9;
            this.queue = new SpscLinkedArrayQueue(r6);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r3) {
            if (SubscriptionHelper.validate(this.upstream, r3) == false) goto L6;
            this.upstream = r3;
            this.downstream.onSubscribe(this);
            r3.request(this.bufferSize);
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // org.reactivestreams.Subscriber
        public void onNext(T r6) {
            if (this.done == false) goto L5;
            return;
        L5:
            SpscLinkedArrayQueue<GroupedFlowable<K, V>> r0 = this.queue;
            K r1 = this.keySelector.apply(r6);     // Catch: Throwable -> L25
            if (r1 == null) goto L9;
            Object r2 = r1;
        L10:
            GroupedUnicast<K, V> r3 = this.groups.get(r2);
            if (r3 == null) goto L13;
            boolean r4 = false;
            GroupedUnicast r5 = r3;
        L30:
            r5.onNext(ObjectHelper.requireNonNull(this.valueSelector.apply(r6), "The valueSelector returned null"));
            completeEvictions();
            if (r4 == false) goto L32;
            r0.offer(r5);
            drain();
            return;
        L32:
            return;
        L22:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.upstream.cancel();
            onError(th);
            return;
        L13:
            if (this.cancelled.get() == false) goto L15;
            return;
        L15:
            GroupedUnicast r7 = GroupedUnicast.createWith(r1, this.bufferSize, this, this.delayError);
            this.groups.put(r2, r7);
            this.groupCount.getAndIncrement();
            r4 = true;
            r5 = r7;
            goto L30
        L9:
            r2 = NULL_KEY;
        L25:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.upstream.cancel();
            onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r4) {
            if (this.done == false) goto L6;
            RxJavaPlugins.onError(r4);
            return;
        L6:
            this.done = true;
            Iterator<GroupedUnicast<K, V>> r1 = this.groups.values().iterator();
        L8:
            if (r1.hasNext() == false) goto L10;
            r1.next().onError(r4);
            goto L8
        L10:
            this.groups.clear();
            Queue<GroupedUnicast<K, V>> r2 = this.evictedGroups;
            if (r2 == null) goto L13;
            r2.clear();
        L13:
            this.error = r4;
            this.finished = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done == true) goto L14;
            Iterator<GroupedUnicast<K, V>> r0 = this.groups.values().iterator();
        L6:
            if (r0.hasNext() == false) goto L8;
            r0.next().onComplete();
            goto L6
        L8:
            this.groups.clear();
            Queue<GroupedUnicast<K, V>> r1 = this.evictedGroups;
            if (r1 == null) goto L11;
            r1.clear();
        L11:
            this.done = true;
            this.finished = true;
            drain();
            return;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L6;
            BackpressureHelper.add(this.requested, r2);
            drain();
            return;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled.compareAndSet(false, true) == false) goto L8;
            completeEvictions();
            if (this.groupCount.decrementAndGet() != 0) goto L9;
            this.upstream.cancel();
            return;
        L9:
            return;
        }

        private void completeEvictions() {
            if (this.evictedGroups == null) goto L12;
            int r0 = 0;
        L5:
            GroupedUnicast<K, V> r1 = this.evictedGroups.poll();
            if (r1 == null) goto L8;
            r1.onComplete();
            r0 = r0 + 1;
            goto L5
        L8:
            if (r0 == 0) goto L13;
            this.groupCount.addAndGet(-r0);
            return;
        L13:
            return;
        }

        public void cancel(K r2) {
            if (r2 != null) goto L5;
            r2 = (K) NULL_KEY;
        L5:
            this.groups.remove(r2);
            if (this.groupCount.decrementAndGet() != 0) goto L11;
            this.upstream.cancel();
            if (getAndIncrement() != 0) goto L12;
            this.queue.clear();
            return;
        L12:
            return;
        }

        void drain() {
            if (getAndIncrement() == 0) goto L6;
            return;
        L6:
            if (this.outputFused == false) goto L8;
            drainFused();
            return;
        L8:
            drainNormal();
        }

        void drainFused() {
            SpscLinkedArrayQueue<GroupedFlowable<K, V>> r0 = this.queue;
            Subscriber<? super GroupedFlowable<K, V>> r1 = this.downstream;
            int r2 = 1;
        L4:
            if (this.cancelled.get() == true) goto L5;
            boolean r3 = this.finished;
            if (r3 == true) goto L10;
        L15:
            r1.onNext(null);
            if (r3 == true) goto L17;
            r2 = addAndGet(-r2);
            if (r2 != 0) goto L4;
            return;
        L17:
            Throwable r5 = this.error;
            if (r5 == null) goto L20;
            r1.onError(r5);
            return;
        L20:
            r1.onComplete();
            return;
        L10:
            if (this.delayError == true) goto L15;
            Throwable r4 = this.error;
            if (r4 == null) goto L15;
            r0.clear();
            r1.onError(r4);
            return;
        L5:
            r0.clear();
        }

        void drainNormal() {
            SpscLinkedArrayQueue<GroupedFlowable<K, V>> r0 = this.queue;
            Subscriber<? super GroupedFlowable<K, V>> r1 = this.downstream;
            int r3 = 1;
        L3:
            long r4 = this.requested.get();
            long r8 = 0;
        L5:
            if (r8 == r4) goto L16;
            boolean r11 = this.finished;
            GroupedFlowable<K, V> r12 = r0.poll();
            if (r12 != null) goto L9;
            boolean r13 = true;
        L11:
            if (checkTerminated(r11, r13, r1, r0) == true) goto L12;
            if (r13 == true) goto L16;
            r1.onNext(r12);
            r8 = r8 + 1;
            goto L5
        L12:
            return;
        L9:
            r13 = false;
        L16:
            if (r8 != r4) goto L21;
            if (checkTerminated(this.finished, r0.isEmpty(), r1, r0) == false) goto L21;
            return;
        L21:
            if (r8 != 0) goto L23;
        L26:
            r3 = addAndGet(-r3);
            if (r3 != 0) goto L3;
            return;
        L23:
            if (r4 == Long.MAX_VALUE) goto L25;
            this.requested.addAndGet(-r8);
        L25:
            this.upstream.request(r8);
            goto L26
        }

        boolean checkTerminated(boolean r3, boolean r4, Subscriber<?> r5, SpscLinkedArrayQueue<?> r6) {
            if (this.cancelled.get() == false) goto L7;
            r6.clear();
            return true;
        L7:
            if (this.delayError == false) goto L15;
            if (r3 == false) goto L23;
            if (r4 == false) goto L25;
            Throwable r2 = this.error;
            if (r2 == null) goto L13;
            r5.onError(r2);
        L14:
            return true;
        L13:
            r5.onComplete();
            goto L14
        L25:
            return false;
        L23:
            return false;
        L15:
            if (r3 == false) goto L26;
            Throwable r7 = this.error;
            if (r7 == null) goto L20;
            r6.clear();
            r5.onError(r7);
            return true;
        L20:
            if (r4 == false) goto L27;
            r5.onComplete();
            return true;
        L27:
            return false;
        L26:
            return false;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int r2) {
            if ((r2 & 2) == 0) goto L6;
            this.outputFused = true;
            return 2;
        L6:
            return 0;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public GroupedFlowable<K, V> poll() {
            return this.queue.poll();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.queue.clear();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }
    }

    static final class GroupedUnicast<K, T> extends GroupedFlowable<K, T> {
        final State<T, K> state;

        public static <T, K> GroupedUnicast<K, T> createWith(K r1, int r2, GroupBySubscriber<?, K, T> r3, boolean r4) {
            return new GroupedUnicast(r1, new State(r2, r3, r1, r4));
        }

        protected GroupedUnicast(K r1, State<T, K> r2) {
            super(r1);
            this.state = r2;
        }

        @Override // io.reactivex.Flowable
        protected void subscribeActual(Subscriber<? super T> r1) {
            this.state.subscribe(r1);
        }

        public void onNext(T r1) {
            this.state.onNext(r1);
        }

        public void onError(Throwable r1) {
            this.state.onError(r1);
        }

        public void onComplete() {
            this.state.onComplete();
        }
    }

    static final class State<T, K> extends BasicIntQueueSubscription<T> implements Publisher<T> {
        private static final long serialVersionUID = -3852313036005250360L;
        final AtomicReference<Subscriber<? super T>> actual;
        final AtomicBoolean cancelled;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final K key;
        final AtomicBoolean once;
        boolean outputFused;
        final GroupBySubscriber<?, K, T> parent;
        int produced;
        final SpscLinkedArrayQueue<T> queue;
        final AtomicLong requested;

        State(int r2, GroupBySubscriber<?, K, T> r3, K r4, boolean r5) {
            this.requested = new AtomicLong();
            this.cancelled = new AtomicBoolean();
            this.actual = new AtomicReference();
            this.once = new AtomicBoolean();
            this.queue = new SpscLinkedArrayQueue(r2);
            this.parent = r3;
            this.key = r4;
            this.delayError = r5;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L6;
            BackpressureHelper.add(this.requested, r2);
            drain();
            return;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled.compareAndSet(false, true) == false) goto L6;
            this.parent.cancel(this.key);
            return;
        }

        @Override // org.reactivestreams.Publisher
        public void subscribe(Subscriber<? super T> r4) {
            if (this.once.compareAndSet(false, true) == false) goto L5;
            r4.onSubscribe(this);
            this.actual.lazySet(r4);
            drain();
            return;
        L5:
            EmptySubscription.error(new IllegalStateException("Only one Subscriber allowed!"), r4);
        }

        public void onNext(T r2) {
            this.queue.offer(r2);
            drain();
        }

        public void onError(Throwable r1) {
            this.error = r1;
            this.done = true;
            drain();
        }

        public void onComplete() {
            this.done = true;
            drain();
        }

        void drain() {
            if (getAndIncrement() == 0) goto L6;
            return;
        L6:
            if (this.outputFused == false) goto L8;
            drainFused();
            return;
        L8:
            drainNormal();
        }

        void drainFused() {
            SpscLinkedArrayQueue<T> r0 = this.queue;
            Subscriber<? super T> r1 = this.actual.get();
            int r2 = 1;
        L3:
            if (r1 != null) goto L5;
        L23:
            r2 = addAndGet(-r2);
            if (r2 == 0) goto L25;
            if (r1 != null) goto L3;
            r1 = this.actual.get();
            goto L3
        L25:
            return;
        L5:
            if (this.cancelled.get() == true) goto L6;
            boolean r3 = this.done;
            if (r3 == true) goto L11;
        L16:
            r1.onNext(null);
            if (r3 == false) goto L23;
            Throwable r5 = this.error;
            if (r5 == null) goto L21;
            r1.onError(r5);
            return;
        L21:
            r1.onComplete();
            return;
        L11:
            if (this.delayError == true) goto L16;
            Throwable r4 = this.error;
            if (r4 == null) goto L16;
            r0.clear();
            r1.onError(r4);
            return;
        L6:
            r0.clear();
        }

        void drainNormal() {
            SpscLinkedArrayQueue<T> r0 = this.queue;
            boolean r1 = this.delayError;
            Subscriber<? super T> r2 = this.actual.get();
            int r4 = 1;
        L3:
            if (r2 == null) goto L27;
            long r5 = this.requested.get();
            long r9 = 0;
        L6:
            if (r9 == r5) goto L17;
            boolean r12 = this.done;
            T r13 = r0.poll();
            if (r13 != null) goto L10;
            boolean r14 = true;
        L12:
            if (checkTerminated(r12, r14, r2, r1) == true) goto L13;
            if (r14 == true) goto L17;
            r2.onNext(r13);
            r9 = r9 + 1;
            goto L6
        L13:
            return;
        L10:
            r14 = false;
        L17:
            if (r9 != r5) goto L22;
            if (checkTerminated(this.done, r0.isEmpty(), r2, r1) == false) goto L22;
            return;
        L22:
            if (r9 == 0) goto L27;
            if (r5 == Long.MAX_VALUE) goto L26;
            this.requested.addAndGet(-r9);
        L26:
            this.parent.upstream.request(r9);
        L27:
            r4 = addAndGet(-r4);
            if (r4 == 0) goto L29;
            if (r2 != null) goto L3;
            r2 = this.actual.get();
            goto L3
        }

        boolean checkTerminated(boolean r3, boolean r4, Subscriber<? super T> r5, boolean r6) {
            if (this.cancelled.get() == false) goto L6;
            this.queue.clear();
            return true;
        L6:
            if (r3 == false) goto L21;
            if (r6 == false) goto L14;
            if (r4 == false) goto L23;
            Throwable r2 = this.error;
            if (r2 == null) goto L12;
            r5.onError(r2);
        L13:
            return true;
        L12:
            r5.onComplete();
            goto L13
        L23:
            return false;
        L14:
            Throwable r7 = this.error;
            if (r7 == null) goto L18;
            this.queue.clear();
            r5.onError(r7);
            return true;
        L18:
            if (r4 == false) goto L24;
            r5.onComplete();
            return true;
        L24:
            return false;
        L21:
            return false;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int r2) {
            if ((r2 & 2) == 0) goto L6;
            this.outputFused = true;
            return 2;
        L6:
            return 0;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() {
            T r0 = this.queue.poll();
            if (r0 == null) goto L6;
            this.produced++;
            return r0;
        L6:
            int r1 = this.produced;
            if (r1 == 0) goto L11;
            this.produced = 0;
            this.parent.upstream.request(r1);
            return null;
        L11:
            return null;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.queue.clear();
        }
    }

    public FlowableGroupBy(Flowable<T> r1, Function<? super T, ? extends K> r2, Function<? super T, ? extends V> r3, int r4, boolean r5, Function<? super Consumer<Object>, ? extends Map<K, Object>> r6) {
        super(r1);
        this.keySelector = r2;
        this.valueSelector = r3;
        this.bufferSize = r4;
        this.delayError = r5;
        this.mapFactory = r6;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super GroupedFlowable<K, V>> r11) {
    L10:
        e = move-exception;
        Exceptions.throwIfFatal(e);
        r11.onSubscribe(EmptyComponent.INSTANCE);
        r11.onError(e);
        return;
    L3:
        if (this.mapFactory != null) goto L6;
        Map<K, Object> r0 = new ConcurrentHashMap();     // Catch: Exception -> L10
        ConcurrentLinkedQueue r1 = null;
    L5:
        Map<K, Object> r8 = r0;
        ConcurrentLinkedQueue r9 = r1;
        GroupBySubscriber r2 = new GroupBySubscriber(r11, this.keySelector, this.valueSelector, this.bufferSize, this.delayError, r8, r9);
        this.source.subscribe(r2);
        return;
    L6:
        r1 = new ConcurrentLinkedQueue();     // Catch: Exception -> L10
        EvictionAction r3 = new EvictionAction(r1);     // Catch: Exception -> L10
        r0 = this.mapFactory.apply(r3);     // Catch: Exception -> L10
        goto L5
    }
}
