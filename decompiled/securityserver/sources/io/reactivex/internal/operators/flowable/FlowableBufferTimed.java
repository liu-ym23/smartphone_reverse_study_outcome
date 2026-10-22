package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes2.dex */
public final class FlowableBufferTimed<T, U extends Collection<? super T>> extends AbstractFlowableWithUpstream<T, U> {
    final Callable<U> bufferSupplier;
    final int maxSize;
    final boolean restartTimerOnMaxSize;
    final Scheduler scheduler;
    final long timeskip;
    final long timespan;
    final TimeUnit unit;

    public static final class BufferExactBoundedSubscriber<T, U extends Collection<? super T>> extends QueueDrainSubscriber<T, U, U> implements Subscription, Runnable, Disposable {
        U buffer;
        final Callable<U> bufferSupplier;
        long consumerIndex;
        final int maxSize;
        long producerIndex;
        final boolean restartTimerOnMaxSize;
        Disposable timer;
        final long timespan;
        final TimeUnit unit;
        Subscription upstream;
        final Scheduler.Worker w;

        public BufferExactBoundedSubscriber(Subscriber<? super U> r2, Callable<U> r3, long r4, TimeUnit r6, int r7, boolean r8, Scheduler.Worker r9) {
            super(r2, new MpscLinkedQueue());
            this.bufferSupplier = r3;
            this.timespan = r4;
            this.unit = r6;
            this.maxSize = r7;
            this.restartTimerOnMaxSize = r8;
            this.w = r9;
        }

        @Override // io.reactivex.internal.subscribers.QueueDrainSubscriber, io.reactivex.internal.util.QueueDrain
        public /* bridge */ /* synthetic */ boolean accept(Subscriber r1, Object r2) {
            return accept(r1, (Collection) r2);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled == true) goto L6;
            this.cancelled = true;
            dispose();
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            monitor-enter(this);
            this.buffer = null;     // Catch: Throwable -> L8
            monitor-exit(this);     // Catch: Throwable -> L8
            this.upstream.cancel();
            this.w.dispose();
            return;
        L8:
            th = move-exception;
            throw th;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.w.isDisposed();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            monitor-enter(this);
            U r0 = this.buffer;     // Catch: Throwable -> L11
            this.buffer = null;     // Catch: Throwable -> L11
            monitor-exit(this);     // Catch: Throwable -> L11
            if (r0 == null) goto L16;
            this.queue.offer(r0);
            this.done = true;
            if (enter() == false) goto L9;
            QueueDrainHelper.drainMaxLoop(this.queue, this.downstream, false, this, this);
        L9:
            this.w.dispose();
            return;
        L16:
            return;
        L11:
            th = move-exception;
            throw th;
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            monitor-enter(this);
            this.buffer = null;     // Catch: Throwable -> L8
            monitor-exit(this);     // Catch: Throwable -> L8
            this.downstream.onError(r2);
            this.w.dispose();
            return;
        L8:
            th = move-exception;
            throw th;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r8) {
            monitor-enter(this);
            U r0 = this.buffer;     // Catch: Throwable -> L7
            if (r0 != null) goto L9;
            monitor-exit(this);     // Catch: Throwable -> L7
            return;
        L9:
            r0.add(r8);     // Catch: Throwable -> L7
            if (r0.size() >= this.maxSize) goto L13;
            monitor-exit(this);     // Catch: Throwable -> L7
            return;
        L13:
            this.buffer = null;     // Catch: Throwable -> L7
            this.producerIndex++;     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
            if (this.restartTimerOnMaxSize == false) goto L18;
            this.timer.dispose();
        L18:
            fastPathOrderedEmitMax(r0, false, this);
            U r9 = (U) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The supplied buffer is null");     // Catch: Throwable -> L30
            monitor-enter(this);
            this.buffer = r9;     // Catch: Throwable -> L27
            this.consumerIndex++;     // Catch: Throwable -> L27
            monitor-exit(this);     // Catch: Throwable -> L27
            if (this.restartTimerOnMaxSize == false) goto L40;
            Scheduler.Worker r1 = this.w;
            long r4 = this.timespan;
            this.timer = r1.schedulePeriodically(this, r4, r4, this.unit);
            return;
        L40:
            return;
        L27:
            th = move-exception;
            throw th;
        L30:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            cancel();
            this.downstream.onError(th);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r9) {
            if (SubscriptionHelper.validate(this.upstream, r9) == true) goto L5;
            return;
        L5:
            this.upstream = r9;
            this.buffer = (U) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The supplied buffer is null");
            this.downstream.onSubscribe(this);
            Scheduler.Worker r1 = this.w;
            long r5 = this.timespan;
            this.timer = r1.schedulePeriodically(this, r5, r5, this.unit);
            r9.request(Long.MAX_VALUE);
            return;
        L9:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.w.dispose();
            r9.cancel();
            EmptySubscription.error(th, this.downstream);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r1) {
            requested(r1);
        }

        @Override // java.lang.Runnable
        public void run() {
            U r0 = (U) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The supplied buffer is null");     // Catch: Throwable -> L19
            monitor-enter(this);
            U r1 = this.buffer;     // Catch: Throwable -> L13
            if (r1 != null) goto L7;
        L15:
            monitor-exit(this);     // Catch: Throwable -> L13
            return;
        L7:
            if (this.producerIndex != this.consumerIndex) goto L15;
            this.buffer = r0;     // Catch: Throwable -> L13
            monitor-exit(this);     // Catch: Throwable -> L13
            fastPathOrderedEmitMax(r1, false, this);
            return;
        L13:
            th = move-exception;
            throw th;
        L19:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            cancel();
            this.downstream.onError(th);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean accept(Subscriber<? super U> r1, U r2) {
            r1.onNext(r2);
            return true;
        }
    }

    public static final class BufferExactUnboundedSubscriber<T, U extends Collection<? super T>> extends QueueDrainSubscriber<T, U, U> implements Subscription, Runnable, Disposable {
        U buffer;
        final Callable<U> bufferSupplier;
        final Scheduler scheduler;
        final AtomicReference<Disposable> timer;
        final long timespan;
        final TimeUnit unit;
        Subscription upstream;

        public BufferExactUnboundedSubscriber(Subscriber<? super U> r2, Callable<U> r3, long r4, TimeUnit r6, Scheduler r7) {
            super(r2, new MpscLinkedQueue());
            this.timer = new AtomicReference();
            this.bufferSupplier = r3;
            this.timespan = r4;
            this.unit = r6;
            this.scheduler = r7;
        }

        @Override // io.reactivex.internal.subscribers.QueueDrainSubscriber, io.reactivex.internal.util.QueueDrain
        public /* bridge */ /* synthetic */ boolean accept(Subscriber r1, Object r2) {
            return accept(r1, (Collection) r2);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            DisposableHelper.dispose(this.timer);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            cancel();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (this.timer.get() != DisposableHelper.DISPOSED) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            DisposableHelper.dispose(this.timer);
            monitor-enter(this);
            U r0 = this.buffer;     // Catch: Throwable -> L8
            if (r0 != null) goto L10;
            monitor-exit(this);     // Catch: Throwable -> L8
            return;
        L10:
            this.buffer = null;     // Catch: Throwable -> L8
            monitor-exit(this);     // Catch: Throwable -> L8
            this.queue.offer(r0);
            this.done = true;
            if (enter() == false) goto L19;
            QueueDrainHelper.drainMaxLoop(this.queue, this.downstream, false, null, this);
            return;
        L19:
            return;
        L8:
            th = move-exception;
            throw th;
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            DisposableHelper.dispose(this.timer);
            monitor-enter(this);
            this.buffer = null;     // Catch: Throwable -> L9
            monitor-exit(this);     // Catch: Throwable -> L9
            this.downstream.onError(r2);
            return;
        L9:
            th = move-exception;
            throw th;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r2) {
            monitor-enter(this);
            U r0 = this.buffer;     // Catch: Throwable -> L6
            if (r0 == null) goto L8;
            r0.add(r2);     // Catch: Throwable -> L6
        L8:
            monitor-exit(this);     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            throw th;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r10) {
            if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L16;
            this.upstream = r10;
            this.buffer = (U) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The supplied buffer is null");
            this.downstream.onSubscribe(this);
            if (this.cancelled == true) goto L17;
            r10.request(Long.MAX_VALUE);
            Scheduler r2 = this.scheduler;
            long r6 = this.timespan;
            Disposable r11 = r2.schedulePeriodicallyDirect(this, r6, r6, this.unit);
            if (this.timer.compareAndSet(null, r11) == true) goto L18;
            r11.dispose();
            return;
        L18:
            return;
        L17:
            return;
        L11:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            cancel();
            EmptySubscription.error(th, this.downstream);
            return;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r1) {
            requested(r1);
        }

        @Override // java.lang.Runnable
        public void run() {
            U r0 = (U) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The supplied buffer is null");     // Catch: Throwable -> L16
            monitor-enter(this);
            U r1 = this.buffer;     // Catch: Throwable -> L8
            if (r1 != null) goto L10;
            monitor-exit(this);     // Catch: Throwable -> L8
            return;
        L10:
            this.buffer = r0;     // Catch: Throwable -> L8
            monitor-exit(this);     // Catch: Throwable -> L8
            fastPathEmitMax(r1, false, this);
            return;
        L8:
            th = move-exception;
            throw th;
        L16:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            cancel();
            this.downstream.onError(th);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public boolean accept(Subscriber<? super U> r1, U r2) {
            this.downstream.onNext((Object) r2);
            return true;
        }
    }

    public static final class BufferSkipBoundedSubscriber<T, U extends Collection<? super T>> extends QueueDrainSubscriber<T, U, U> implements Subscription, Runnable {
        final Callable<U> bufferSupplier;
        final List<U> buffers;
        final long timeskip;
        final long timespan;
        final TimeUnit unit;
        Subscription upstream;
        final Scheduler.Worker w;

        public final class RemoveFromBuffer implements Runnable {
            private final U buffer;
            final /* synthetic */ BufferSkipBoundedSubscriber this$0;

            public RemoveFromBuffer(BufferSkipBoundedSubscriber r1, U r2) {
                this.this$0 = r1;
                this.buffer = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                BufferSkipBoundedSubscriber r0 = this.this$0;
                monitor-enter(r0);
                this.this$0.buffers.remove(this.buffer);     // Catch: Throwable -> L8
                monitor-exit(r0);     // Catch: Throwable -> L8
                BufferSkipBoundedSubscriber r1 = this.this$0;
                BufferSkipBoundedSubscriber.access$000(r1, this.buffer, false, r1.w);
                return;
            L8:
                th = move-exception;
                throw th;
            }
        }

        public BufferSkipBoundedSubscriber(Subscriber<? super U> r2, Callable<U> r3, long r4, long r6, TimeUnit r8, Scheduler.Worker r9) {
            super(r2, new MpscLinkedQueue());
            this.bufferSupplier = r3;
            this.timespan = r4;
            this.timeskip = r6;
            this.unit = r8;
            this.w = r9;
            this.buffers = new LinkedList();
        }

        public static /* synthetic */ void access$000(BufferSkipBoundedSubscriber r0, Object r1, boolean r2, Disposable r3) {
            r0.fastPathOrderedEmitMax(r1, r2, r3);
        }

        @Override // io.reactivex.internal.subscribers.QueueDrainSubscriber, io.reactivex.internal.util.QueueDrain
        public /* bridge */ /* synthetic */ boolean accept(Subscriber r1, Object r2) {
            return accept(r1, (Collection) r2);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            this.w.dispose();
            clear();
        }

        public void clear() {
            monitor-enter(this);
            this.buffers.clear();     // Catch: Throwable -> L6
            monitor-exit(this);     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            throw th;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            monitor-enter(this);
            ArrayList r0 = new ArrayList(this.buffers);     // Catch: Throwable -> L13
            this.buffers.clear();     // Catch: Throwable -> L13
            monitor-exit(this);     // Catch: Throwable -> L13
            Iterator r1 = r0.iterator();
        L7:
            if (r1.hasNext() == false) goto L9;
            Collection r2 = (Collection) r1.next();
            this.queue.offer((U) r2);
            goto L7
        L9:
            this.done = true;
            if (enter() == false) goto L19;
            QueueDrainHelper.drainMaxLoop(this.queue, this.downstream, false, this.w, this);
            return;
        L19:
            return;
        L13:
            th = move-exception;
            throw th;
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            this.done = true;
            this.w.dispose();
            clear();
            this.downstream.onError(r2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r3) {
            monitor-enter(this);
            Iterator<U> r0 = this.buffers.iterator();     // Catch: Throwable -> L7
        L5:
            if (r0.hasNext() == false) goto L9;
            r0.next().add(r3);     // Catch: Throwable -> L7
            goto L5
        L9:
            monitor-exit(this);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r11) {
            if (SubscriptionHelper.validate(this.upstream, r11) == true) goto L5;
            return;
        L5:
            this.upstream = r11;
            Collection r0 = (Collection) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The supplied buffer is null");     // Catch: Throwable -> L9
            this.buffers.add((U) r0);
            this.downstream.onSubscribe(this);
            r11.request(Long.MAX_VALUE);
            Scheduler.Worker r3 = this.w;
            long r7 = this.timeskip;
            r3.schedulePeriodically(this, r7, r7, this.unit);
            this.w.schedule(new RemoveFromBuffer(this, r0), this.timespan, this.unit);
            return;
        L9:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.w.dispose();
            r11.cancel();
            EmptySubscription.error(th, this.downstream);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r1) {
            requested(r1);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // java.lang.Runnable
        public void run() {
            if (this.cancelled == false) goto L22;
            return;
        L22:
            Collection r0 = (Collection) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The supplied buffer is null");     // Catch: Throwable -> L19
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L8:
            if (this.cancelled == false) goto L13;
            monitor-exit(this);     // Catch: Throwable -> L11
            return;
        L13:
            this.buffers.add((U) r0);     // Catch: Throwable -> L11
            monitor-exit(this);     // Catch: Throwable -> L11
            this.w.schedule(new RemoveFromBuffer(this, r0), this.timespan, this.unit);
            return;
        L19:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            cancel();
            this.downstream.onError(th);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean accept(Subscriber<? super U> r1, U r2) {
            r1.onNext(r2);
            return true;
        }
    }

    public FlowableBufferTimed(Flowable<T> r1, long r2, long r4, TimeUnit r6, Scheduler r7, Callable<U> r8, int r9, boolean r10) {
        super(r1);
        this.timespan = r2;
        this.timeskip = r4;
        this.unit = r6;
        this.scheduler = r7;
        this.bufferSupplier = r8;
        this.maxSize = r9;
        this.restartTimerOnMaxSize = r10;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super U> r12) {
        if (this.timespan == this.timeskip) goto L5;
    L8:
        Scheduler.Worker r9 = this.scheduler.createWorker();
        if (this.timespan != this.timeskip) goto L12;
        this.source.subscribe(new BufferExactBoundedSubscriber(new SerializedSubscriber(r12), this.bufferSupplier, this.timespan, this.unit, this.maxSize, this.restartTimerOnMaxSize, r9));
        return;
    L12:
        this.source.subscribe(new BufferSkipBoundedSubscriber(new SerializedSubscriber(r12), this.bufferSupplier, this.timespan, this.timeskip, this.unit, r9));
        return;
    L5:
        if (this.maxSize != Integer.MAX_VALUE) goto L8;
        this.source.subscribe(new BufferExactUnboundedSubscriber(new SerializedSubscriber(r12), this.bufferSupplier, this.timespan, this.unit, this.scheduler));
    }
}
