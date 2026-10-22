package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.processors.UnicastProcessor;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes2.dex */
public final class FlowableWindowTimed<T> extends AbstractFlowableWithUpstream<T, Flowable<T>> {
    final int bufferSize;
    final long maxSize;
    final boolean restartTimerOnMaxSize;
    final Scheduler scheduler;
    final long timeskip;
    final long timespan;
    final TimeUnit unit;

    public static final class WindowExactBoundedSubscriber<T> extends QueueDrainSubscriber<T, Object, Flowable<T>> implements Subscription {
        final int bufferSize;
        long count;
        final long maxSize;
        long producerIndex;
        final boolean restartTimerOnMaxSize;
        final Scheduler scheduler;
        volatile boolean terminated;
        final SequentialDisposable timer;
        final long timespan;
        final TimeUnit unit;
        Subscription upstream;
        UnicastProcessor<T> window;
        final Scheduler.Worker worker;

        public static final class ConsumerIndexHolder implements Runnable {
            final long index;
            final WindowExactBoundedSubscriber<?> parent;

            public ConsumerIndexHolder(long r1, WindowExactBoundedSubscriber<?> r3) {
                this.index = r1;
                this.parent = r3;
            }

            @Override // java.lang.Runnable
            public void run() {
                WindowExactBoundedSubscriber<?> r0 = this.parent;
                if (WindowExactBoundedSubscriber.access$000(r0) == true) goto L5;
                WindowExactBoundedSubscriber.access$100(r0).offer(this);
            L7:
                if (r0.enter() == false) goto L10;
                r0.drainLoop();
                return;
            L10:
                return;
            L5:
                r0.terminated = true;
                r0.dispose();
                goto L7
            }
        }

        public WindowExactBoundedSubscriber(Subscriber<? super Flowable<T>> r2, long r3, TimeUnit r5, Scheduler r6, int r7, long r8, boolean r10) {
            super(r2, new MpscLinkedQueue());
            this.timer = new SequentialDisposable();
            this.timespan = r3;
            this.unit = r5;
            this.scheduler = r6;
            this.bufferSize = r7;
            this.maxSize = r8;
            this.restartTimerOnMaxSize = r10;
            if (r10 == false) goto L5;
            this.worker = r6.createWorker();
            return;
        L5:
            this.worker = null;
        }

        public static /* synthetic */ boolean access$000(WindowExactBoundedSubscriber r0) {
            return r0.cancelled;
        }

        public static /* synthetic */ SimplePlainQueue access$100(WindowExactBoundedSubscriber r0) {
            return r0.queue;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
        }

        public void dispose() {
            DisposableHelper.dispose(this.timer);
            Scheduler.Worker r1 = this.worker;
            if (r1 == null) goto L6;
            r1.dispose();
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
        public void drainLoop() {
            SimpleQueue r1 = this.queue;
            Subscriber<? super V> r2 = this.downstream;
            UnicastProcessor<T> r3 = this.window;
            int r5 = 1;
        L4:
            if (this.terminated == true) goto L5;
            boolean r6 = this.done;
            Object r7 = r1.poll();
            if (r7 != null) goto L10;
            boolean r8 = true;
        L11:
            boolean r9 = r7 instanceof ConsumerIndexHolder;
            if (r6 == false) goto L21;
            if (r8 == true) goto L15;
            if (r9 == false) goto L21;
        L15:
            this.window = null;
            r1.clear();
            Throwable r4 = this.error;
            if (r4 == null) goto L18;
            ((UnicastProcessor) r3).onError(r4);
        L19:
            dispose();
            return;
        L18:
            ((UnicastProcessor) r3).onComplete();
        L21:
            if (r8 == true) goto L22;
            int r10 = r5;
            if (r9 == false) goto L40;
            ConsumerIndexHolder r11 = (ConsumerIndexHolder) r7;
            if (this.restartTimerOnMaxSize == true) goto L33;
            r3 = r3;
            if (this.producerIndex == r11.index) goto L33;
        L32:
            r5 = r10;
        L33:
            ((UnicastProcessor) r3).onComplete();
            this.count = 0;
            UnicastProcessor<T> r12 = UnicastProcessor.create(this.bufferSize);
            this.window = r12;
            long r13 = requested();
            if (r13 == 0) goto L38;
            r2.onNext(r12);
            r3 = r12;
            if (r13 == Long.MAX_VALUE) goto L32;
            produced(1);
            r3 = r12;
            goto L32
        L38:
            this.window = null;
            this.queue.clear();
            this.upstream.cancel();
            r2.onError(new MissingBackpressureException("Could not deliver first window due to lack of requests."));
            dispose();
            return;
        L40:
            ((UnicastProcessor) r3).onNext(NotificationLite.getValue(r7));
            long r14 = this.count + 1;
            if (r14 < this.maxSize) goto L52;
            this.producerIndex++;
            this.count = 0;
            ((UnicastProcessor) r3).onComplete();
            long r15 = requested();
            if (r15 == 0) goto L50;
            UnicastProcessor<T> r16 = UnicastProcessor.create(this.bufferSize);
            this.window = r16;
            this.downstream.onNext(r16);
            if (r15 == Long.MAX_VALUE) goto L47;
            produced(1);
        L47:
            r3 = r16;
            if (this.restartTimerOnMaxSize == false) goto L32;
            this.timer.get().dispose();
            Scheduler.Worker r17 = this.worker;
            ConsumerIndexHolder r18 = new ConsumerIndexHolder(this.producerIndex, this);
            long r19 = this.timespan;
            this.timer.replace(r17.schedulePeriodically(r18, r19, r19, this.unit));
            r3 = r16;
            goto L32
        L50:
            this.window = null;
            this.upstream.cancel();
            this.downstream.onError(new MissingBackpressureException("Could not deliver window due to lack of requests"));
            dispose();
            return;
        L52:
            this.count = r14;
            r3 = r3;
            goto L32
        L22:
            r5 = leave(-r5);
            if (r5 != 0) goto L4;
            return;
        L10:
            r8 = false;
            goto L11
        L5:
            this.upstream.cancel();
            r1.clear();
            dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            if (enter() == false) goto L5;
            drainLoop();
        L5:
            this.downstream.onComplete();
            dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            this.error = r2;
            this.done = true;
            if (enter() == false) goto L5;
            drainLoop();
        L5:
            this.downstream.onError(r2);
            dispose();
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // org.reactivestreams.Subscriber
        public void onNext(T r8) {
            if (this.terminated == false) goto L6;
            return;
        L6:
            if (fastEnter() == false) goto L23;
            UnicastProcessor<T> r0 = this.window;
            r0.onNext(r8);
            long r1 = this.count + 1;
            if (r1 < this.maxSize) goto L19;
            this.producerIndex++;
            this.count = 0;
            r0.onComplete();
            long r5 = requested();
            if (r5 == 0) goto L17;
            UnicastProcessor<T> r9 = UnicastProcessor.create(this.bufferSize);
            this.window = r9;
            this.downstream.onNext(r9);
            if (r5 == Long.MAX_VALUE) goto L15;
            produced(1);
        L15:
            if (this.restartTimerOnMaxSize == false) goto L21;
            this.timer.get().dispose();
            Scheduler.Worker r2 = this.worker;
            ConsumerIndexHolder r3 = new ConsumerIndexHolder(this.producerIndex, this);
            long r4 = this.timespan;
            this.timer.replace(r2.schedulePeriodically(r3, r4, r4, this.unit));
        L21:
            if (leave(-1) != 0) goto L26;
            return;
        L26:
            drainLoop();
            return;
        L17:
            this.window = null;
            this.upstream.cancel();
            this.downstream.onError(new MissingBackpressureException("Could not deliver window due to lack of requests"));
            dispose();
            return;
        L19:
            this.count = r1;
            goto L21
        L23:
            this.queue.offer((U) NotificationLite.next(r8));
            if (enter() == true) goto L26;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r12) {
            if (SubscriptionHelper.validate(this.upstream, r12) == false) goto L21;
            this.upstream = r12;
            Subscriber<? super V> r0 = this.downstream;
            r0.onSubscribe(this);
            if (this.cancelled == false) goto L7;
            return;
        L7:
            UnicastProcessor<T> r1 = UnicastProcessor.create(this.bufferSize);
            this.window = r1;
            long r2 = requested();
            if (r2 == 0) goto L19;
            r0.onNext(r1);
            if (r2 == Long.MAX_VALUE) goto L12;
            produced(1);
        L12:
            ConsumerIndexHolder r5 = new ConsumerIndexHolder(this.producerIndex, this);
            if (this.restartTimerOnMaxSize == false) goto L15;
            Scheduler.Worker r4 = this.worker;
            long r8 = this.timespan;
            Disposable r3 = r4.schedulePeriodically(r5, r8, r8, this.unit);
        L17:
            if (this.timer.replace(r3) == false) goto L22;
            r12.request(Long.MAX_VALUE);
            return;
        L22:
            return;
        L15:
            Scheduler r6 = this.scheduler;
            long r9 = this.timespan;
            r3 = r6.schedulePeriodicallyDirect(r5, r9, r9, this.unit);
            goto L17
        L19:
            this.cancelled = true;
            r12.cancel();
            r0.onError(new MissingBackpressureException("Could not deliver initial window due to lack of requests."));
            return;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r1) {
            requested(r1);
        }
    }

    public static final class WindowExactUnboundedSubscriber<T> extends QueueDrainSubscriber<T, Object, Flowable<T>> implements FlowableSubscriber<T>, Subscription, Runnable {
        static final Object NEXT = null;
        final int bufferSize;
        final Scheduler scheduler;
        volatile boolean terminated;
        final SequentialDisposable timer;
        final long timespan;
        final TimeUnit unit;
        Subscription upstream;
        UnicastProcessor<T> window;

        static {
            NEXT = new Object();
        }

        public WindowExactUnboundedSubscriber(Subscriber<? super Flowable<T>> r2, long r3, TimeUnit r5, Scheduler r6, int r7) {
            super(r2, new MpscLinkedQueue());
            this.timer = new SequentialDisposable();
            this.timespan = r3;
            this.unit = r5;
            this.scheduler = r6;
            this.bufferSize = r7;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
        }

        public void dispose() {
            DisposableHelper.dispose(this.timer);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [io.reactivex.processors.UnicastProcessor<T>] */
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
        public void drainLoop() {
            SimpleQueue r0 = this.queue;
            Subscriber<? super V> r1 = this.downstream;
            UnicastProcessor<T> r2 = this.window;
            int r3 = 1;
        L3:
            boolean r4 = this.terminated;
            boolean r5 = this.done;
            Object r6 = r0.poll();
            if (r5 == false) goto L13;
            if (r6 == null) goto L8;
            if (r6 != NEXT) goto L13;
        L8:
            this.window = null;
            r0.clear();
            dispose();
            Throwable r10 = this.error;
            if (r10 == null) goto L11;
            r2.onError(r10);
            return;
        L11:
            r2.onComplete();
            return;
        L13:
            if (r6 == null) goto L14;
            if (r6 == NEXT) goto L19;
            UnicastProcessor<T> r7 = r2;
            r7.onNext(NotificationLite.getValue(r6));
            goto L3
        L19:
            r2.onComplete();
            if (r4 == false) goto L21;
            this.upstream.cancel();
            goto L3
        L21:
            r2 = (UnicastProcessor<T>) UnicastProcessor.create(this.bufferSize);
            this.window = r2;
            long r8 = requested();
            if (r8 == 0) goto L26;
            r1.onNext(r2);
            if (r8 == Long.MAX_VALUE) goto L3;
            produced(1);
            goto L3
        L26:
            this.window = null;
            this.queue.clear();
            this.upstream.cancel();
            dispose();
            r1.onError(new MissingBackpressureException("Could not deliver first window due to lack of requests."));
            return;
        L14:
            r3 = leave(-r3);
            if (r3 != 0) goto L3;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            if (enter() == false) goto L5;
            drainLoop();
        L5:
            this.downstream.onComplete();
            dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            this.error = r2;
            this.done = true;
            if (enter() == false) goto L5;
            drainLoop();
        L5:
            this.downstream.onError(r2);
            dispose();
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // org.reactivestreams.Subscriber
        public void onNext(T r2) {
            if (this.terminated == false) goto L6;
            return;
        L6:
            if (fastEnter() == false) goto L10;
            this.window.onNext(r2);
            if (leave(-1) != 0) goto L13;
            return;
        L13:
            drainLoop();
            return;
        L10:
            this.queue.offer((U) NotificationLite.next(r2));
            if (enter() == true) goto L13;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r13) {
            if (SubscriptionHelper.validate(this.upstream, r13) == false) goto L16;
            this.upstream = r13;
            this.window = UnicastProcessor.create(this.bufferSize);
            Subscriber<? super V> r0 = this.downstream;
            r0.onSubscribe(this);
            long r1 = requested();
            if (r1 == 0) goto L14;
            r0.onNext(this.window);
            if (r1 == Long.MAX_VALUE) goto L10;
            produced(1);
        L10:
            if (this.cancelled == true) goto L17;
            SequentialDisposable r2 = this.timer;
            Scheduler r5 = this.scheduler;
            long r9 = this.timespan;
            if (r2.replace(r5.schedulePeriodicallyDirect(this, r9, r9, this.unit)) == false) goto L18;
            r13.request(Long.MAX_VALUE);
            return;
        L18:
            return;
        L17:
            return;
        L14:
            this.cancelled = true;
            r13.cancel();
            r0.onError(new MissingBackpressureException("Could not deliver first window due to lack of requests."));
            return;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r1) {
            requested(r1);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // java.lang.Runnable
        public void run() {
            if (this.cancelled == false) goto L5;
            this.terminated = true;
            dispose();
        L5:
            this.queue.offer((U) NEXT);
            if (enter() == false) goto L9;
            drainLoop();
            return;
        }
    }

    public static final class WindowSkipSubscriber<T> extends QueueDrainSubscriber<T, Object, Flowable<T>> implements Subscription, Runnable {
        final int bufferSize;
        volatile boolean terminated;
        final long timeskip;
        final long timespan;
        final TimeUnit unit;
        Subscription upstream;
        final List<UnicastProcessor<T>> windows;
        final Scheduler.Worker worker;

        public final class Completion implements Runnable {
            private final UnicastProcessor<T> processor;
            final /* synthetic */ WindowSkipSubscriber this$0;

            public Completion(WindowSkipSubscriber r1, UnicastProcessor<T> r2) {
                this.this$0 = r1;
                this.processor = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.this$0.complete(this.processor);
            }
        }

        public static final class SubjectWork<T> {
            final boolean open;
            final UnicastProcessor<T> w;

            public SubjectWork(UnicastProcessor<T> r1, boolean r2) {
                this.w = r1;
                this.open = r2;
            }
        }

        public WindowSkipSubscriber(Subscriber<? super Flowable<T>> r2, long r3, long r5, TimeUnit r7, Scheduler.Worker r8, int r9) {
            super(r2, new MpscLinkedQueue());
            this.timespan = r3;
            this.timeskip = r5;
            this.unit = r7;
            this.worker = r8;
            this.bufferSize = r9;
            this.windows = new LinkedList();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public void complete(UnicastProcessor<T> r4) {
            this.queue.offer((U) new SubjectWork(r4, false));
            if (enter() == false) goto L6;
            drainLoop();
            return;
        }

        public void dispose() {
            this.worker.dispose();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public void drainLoop() {
            SimpleQueue r0 = this.queue;
            Subscriber<? super V> r1 = this.downstream;
            List<UnicastProcessor<T>> r2 = this.windows;
            int r4 = 1;
        L4:
            if (this.terminated == true) goto L5;
            boolean r5 = this.done;
            Object r6 = r0.poll();
            if (r6 != null) goto L10;
            boolean r7 = true;
        L11:
            boolean r8 = r6 instanceof SubjectWork;
            if (r5 == false) goto L27;
            if (r7 == true) goto L15;
            if (r8 == false) goto L27;
        L15:
            r0.clear();
            Throwable r3 = this.error;
            if (r3 == null) goto L21;
            Iterator<UnicastProcessor<T>> r9 = r2.iterator();
        L19:
            if (r9.hasNext() == false) goto L25;
            r9.next().onError(r3);
        L25:
            r2.clear();
            dispose();
            return;
        L21:
            Iterator<UnicastProcessor<T>> r10 = r2.iterator();
        L23:
            if (r10.hasNext() == false) goto L25;
            r10.next().onComplete();
        L27:
            if (r7 == true) goto L28;
            if (r8 == true) goto L32;
            Iterator<UnicastProcessor<T>> r11 = r2.iterator();
        L51:
            if (r11.hasNext() == false) goto L4;
            r11.next().onNext(r6);
            goto L51
        L32:
            SubjectWork r12 = (SubjectWork) r6;
            if (r12.open == true) goto L35;
            r2.remove(r12.w);
            r12.w.onComplete();
            if (r2.isEmpty() == false) goto L4;
            if (this.cancelled == false) goto L4;
            this.terminated = true;
            goto L4
        L35:
            if (this.cancelled == true) goto L4;
            long r13 = requested();
            if (r13 != 0) goto L39;
            r1.onError(new MissingBackpressureException("Can't emit window due to lack of requests"));
            goto L4
        L39:
            UnicastProcessor<T> r14 = UnicastProcessor.create(this.bufferSize);
            r2.add(r14);
            r1.onNext(r14);
            if (r13 == Long.MAX_VALUE) goto L42;
            produced(1);
        L42:
            this.worker.schedule(new Completion(this, r14), this.timespan, this.unit);
            goto L4
        L28:
            r4 = leave(-r4);
            if (r4 != 0) goto L4;
            return;
        L10:
            r7 = false;
            goto L11
        L5:
            this.upstream.cancel();
            dispose();
            r0.clear();
            r2.clear();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            if (enter() == false) goto L5;
            drainLoop();
        L5:
            this.downstream.onComplete();
            dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            this.error = r2;
            this.done = true;
            if (enter() == false) goto L5;
            drainLoop();
        L5:
            this.downstream.onError(r2);
            dispose();
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // org.reactivestreams.Subscriber
        public void onNext(T r3) {
            if (fastEnter() == false) goto L11;
            Iterator<UnicastProcessor<T>> r0 = this.windows.iterator();
        L6:
            if (r0.hasNext() == false) goto L9;
            r0.next().onNext(r3);
            goto L6
        L9:
            if (leave(-1) != 0) goto L14;
            return;
        L14:
            drainLoop();
            return;
        L11:
            this.queue.offer((U) r3);
            if (enter() == true) goto L14;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r15) {
            if (SubscriptionHelper.validate(this.upstream, r15) == false) goto L15;
            this.upstream = r15;
            this.downstream.onSubscribe(this);
            if (this.cancelled == false) goto L7;
            return;
        L7:
            long r0 = requested();
            if (r0 == 0) goto L13;
            UnicastProcessor<T> r2 = UnicastProcessor.create(this.bufferSize);
            this.windows.add(r2);
            this.downstream.onNext(r2);
            if (r0 == Long.MAX_VALUE) goto L12;
            produced(1);
        L12:
            this.worker.schedule(new Completion(this, r2), this.timespan, this.unit);
            Scheduler.Worker r7 = this.worker;
            long r11 = this.timeskip;
            r7.schedulePeriodically(this, r11, r11, this.unit);
            r15.request(Long.MAX_VALUE);
            return;
        L13:
            r15.cancel();
            this.downstream.onError(new MissingBackpressureException("Could not emit the first window due to lack of requests"));
            return;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r1) {
            requested(r1);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // java.lang.Runnable
        public void run() {
            Object r1 = new SubjectWork(UnicastProcessor.create(this.bufferSize), true);
            if (this.cancelled == true) goto L6;
            this.queue.offer((U) r1);
        L6:
            if (enter() == false) goto L9;
            drainLoop();
            return;
        }
    }

    public FlowableWindowTimed(Flowable<T> r1, long r2, long r4, TimeUnit r6, Scheduler r7, long r8, int r10, boolean r11) {
        super(r1);
        this.timespan = r2;
        this.timeskip = r4;
        this.unit = r6;
        this.scheduler = r7;
        this.maxSize = r8;
        this.bufferSize = r10;
        this.restartTimerOnMaxSize = r11;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super Flowable<T>> r12) {
        SerializedSubscriber r1 = new SerializedSubscriber(r12);
        long r2 = this.timespan;
        long r4 = this.timeskip;
        if (r2 != r4) goto L10;
        long r7 = this.maxSize;
        if (r7 != Long.MAX_VALUE) goto L8;
        this.source.subscribe(new WindowExactUnboundedSubscriber(r1, r2, this.unit, this.scheduler, this.bufferSize));
        return;
    L8:
        this.source.subscribe(new WindowExactBoundedSubscriber(r1, r2, this.unit, this.scheduler, this.bufferSize, r7, this.restartTimerOnMaxSize));
        return;
    L10:
        this.source.subscribe(new WindowSkipSubscriber(r1, r2, r4, this.unit, this.scheduler.createWorker(), this.bufferSize));
    }
}
