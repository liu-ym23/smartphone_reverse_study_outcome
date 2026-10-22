package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableBufferTimed<T, U extends Collection<? super T>> extends AbstractObservableWithUpstream<T, U> {
    final Callable<U> bufferSupplier;
    final int maxSize;
    final boolean restartTimerOnMaxSize;
    final Scheduler scheduler;
    final long timeskip;
    final long timespan;
    final TimeUnit unit;

    static final class BufferExactBoundedObserver<T, U extends Collection<? super T>> extends QueueDrainObserver<T, U, U> implements Runnable, Disposable {
        U buffer;
        final Callable<U> bufferSupplier;
        long consumerIndex;
        final int maxSize;
        long producerIndex;
        final boolean restartTimerOnMaxSize;
        Disposable timer;
        final long timespan;
        final TimeUnit unit;
        Disposable upstream;
        final Scheduler.Worker w;

        @Override // io.reactivex.internal.observers.QueueDrainObserver, io.reactivex.internal.util.ObservableQueueDrain
        public /* bridge */ /* synthetic */ void accept(Observer r1, Object r2) {
            accept(r1, (Collection) r2);
        }

        BufferExactBoundedObserver(Observer<? super U> r2, Callable<U> r3, long r4, TimeUnit r6, int r7, boolean r8, Scheduler.Worker r9) {
            super(r2, new MpscLinkedQueue());
            this.bufferSupplier = r3;
            this.timespan = r4;
            this.unit = r6;
            this.maxSize = r7;
            this.restartTimerOnMaxSize = r8;
            this.w = r9;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r8) {
            if (DisposableHelper.validate(this.upstream, r8) == false) goto L12;
            this.upstream = r8;
            this.buffer = (U) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The buffer supplied is null");
            this.downstream.onSubscribe(this);
            Scheduler.Worker r0 = this.w;
            long r4 = this.timespan;
            this.timer = r0.schedulePeriodically(this, r4, r4, this.unit);
            return;
        L7:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r8.dispose();
            EmptyDisposable.error(th, this.downstream);
            this.w.dispose();
            return;
        }

        @Override // io.reactivex.Observer
        public void onNext(T r8) {
            monitor-enter(this);
            U r0 = this.buffer;     // Catch: Throwable -> L31
            if (r0 != null) goto L7;
            monitor-exit(this);     // Catch: Throwable -> L31
            return;
        L7:
            r0.add(r8);     // Catch: Throwable -> L31
            if (r0.size() >= this.maxSize) goto L11;
            monitor-exit(this);     // Catch: Throwable -> L31
            return;
        L11:
            this.buffer = null;     // Catch: Throwable -> L31
            this.producerIndex++;     // Catch: Throwable -> L31
            monitor-exit(this);     // Catch: Throwable -> L31
            if (this.restartTimerOnMaxSize == false) goto L16;
            this.timer.dispose();
        L16:
            fastPathOrderedEmit(r0, false, this);
            U r9 = (U) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The buffer supplied is null");     // Catch: Throwable -> L28
            monitor-enter(this);
            this.buffer = r9;     // Catch: Throwable -> L25
            this.consumerIndex++;     // Catch: Throwable -> L25
            monitor-exit(this);     // Catch: Throwable -> L25
            if (this.restartTimerOnMaxSize == false) goto L39;
            Scheduler.Worker r1 = this.w;
            long r4 = this.timespan;
            this.timer = r1.schedulePeriodically(this, r4, r4, this.unit);
            return;
        L39:
            return;
        L25:
            th = move-exception;
            throw th;
        L28:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.downstream.onError(th);
            dispose();
            return;
        L31:
            th = move-exception;
            throw th;
        }

        @Override // io.reactivex.Observer
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

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.w.dispose();
            monitor-enter(this);
            U r0 = this.buffer;     // Catch: Throwable -> L11
            this.buffer = null;     // Catch: Throwable -> L11
            monitor-exit(this);     // Catch: Throwable -> L11
            if (r0 == null) goto L16;
            this.queue.offer(r0);
            this.done = true;
            if (enter() == false) goto L17;
            QueueDrainHelper.drainLoop(this.queue, this.downstream, false, this, this);
            return;
        L17:
            return;
        L16:
            return;
        L11:
            th = move-exception;
            throw th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void accept(Observer<? super U> r1, U r2) {
            r1.onNext(r2);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled == true) goto L13;
            this.cancelled = true;
            this.upstream.dispose();
            this.w.dispose();
            monitor-enter(this);
            this.buffer = null;     // Catch: Throwable -> L10
            monitor-exit(this);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // java.lang.Runnable
        public void run() {
            U r0 = (U) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The bufferSupplier returned a null buffer");     // Catch: Throwable -> L18
            monitor-enter(this);
            U r1 = this.buffer;     // Catch: Throwable -> L15
            if (r1 != null) goto L7;
        L13:
            monitor-exit(this);     // Catch: Throwable -> L15
            return;
        L7:
            if (this.producerIndex != this.consumerIndex) goto L13;
            this.buffer = r0;     // Catch: Throwable -> L15
            monitor-exit(this);     // Catch: Throwable -> L15
            fastPathOrderedEmit(r1, false, this);
            return;
        L15:
            th = move-exception;
            throw th;
        L18:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            dispose();
            this.downstream.onError(th);
        }
    }

    static final class BufferExactUnboundedObserver<T, U extends Collection<? super T>> extends QueueDrainObserver<T, U, U> implements Runnable, Disposable {
        U buffer;
        final Callable<U> bufferSupplier;
        final Scheduler scheduler;
        final AtomicReference<Disposable> timer;
        final long timespan;
        final TimeUnit unit;
        Disposable upstream;

        @Override // io.reactivex.internal.observers.QueueDrainObserver, io.reactivex.internal.util.ObservableQueueDrain
        public /* bridge */ /* synthetic */ void accept(Observer r1, Object r2) {
            accept(r1, (Collection) r2);
        }

        BufferExactUnboundedObserver(Observer<? super U> r2, Callable<U> r3, long r4, TimeUnit r6, Scheduler r7) {
            super(r2, new MpscLinkedQueue());
            this.timer = new AtomicReference();
            this.bufferSupplier = r3;
            this.timespan = r4;
            this.unit = r6;
            this.scheduler = r7;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r8) {
            if (DisposableHelper.validate(this.upstream, r8) == false) goto L16;
            this.upstream = r8;
            this.buffer = (U) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The buffer supplied is null");
            this.downstream.onSubscribe(this);
            if (this.cancelled == true) goto L17;
            Scheduler r0 = this.scheduler;
            long r4 = this.timespan;
            Disposable r9 = r0.schedulePeriodicallyDirect(this, r4, r4, this.unit);
            if (this.timer.compareAndSet(null, r9) == true) goto L18;
            r9.dispose();
            return;
        L18:
            return;
        L17:
            return;
        L11:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            dispose();
            EmptyDisposable.error(th, this.downstream);
            return;
        }

        @Override // io.reactivex.Observer
        public void onNext(T r2) {
            monitor-enter(this);
            U r0 = this.buffer;     // Catch: Throwable -> L10
            if (r0 != null) goto L7;
            monitor-exit(this);     // Catch: Throwable -> L10
            return;
        L7:
            r0.add(r2);     // Catch: Throwable -> L10
            monitor-exit(this);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r2) {
            monitor-enter(this);
            this.buffer = null;     // Catch: Throwable -> L8
            monitor-exit(this);     // Catch: Throwable -> L8
            this.downstream.onError(r2);
            DisposableHelper.dispose(this.timer);
            return;
        L8:
            th = move-exception;
            throw th;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            monitor-enter(this);
            U r0 = this.buffer;     // Catch: Throwable -> L11
            this.buffer = null;     // Catch: Throwable -> L11
            monitor-exit(this);     // Catch: Throwable -> L11
            if (r0 == null) goto L9;
            this.queue.offer(r0);
            this.done = true;
            if (enter() == false) goto L9;
            QueueDrainHelper.drainLoop(this.queue, this.downstream, false, null, this);
        L9:
            DisposableHelper.dispose(this.timer);
            return;
        L11:
            th = move-exception;
            throw th;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this.timer);
            this.upstream.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (this.timer.get() != DisposableHelper.DISPOSED) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.lang.Runnable
        public void run() {
            U r0 = (U) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The bufferSupplier returned a null buffer");     // Catch: Throwable -> L16
            monitor-enter(this);
            U r1 = this.buffer;     // Catch: Throwable -> L13
            if (r1 == null) goto L7;
            this.buffer = r0;     // Catch: Throwable -> L13
        L7:
            monitor-exit(this);     // Catch: Throwable -> L13
            if (r1 != null) goto L11;
            DisposableHelper.dispose(this.timer);
            return;
        L11:
            fastPathEmit(r1, false, this);
            return;
        L13:
            th = move-exception;
            throw th;
        L16:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.downstream.onError(th);
            dispose();
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public void accept(Observer<? super U> r1, U r2) {
            this.downstream.onNext((Object) r2);
        }
    }

    static final class BufferSkipBoundedObserver<T, U extends Collection<? super T>> extends QueueDrainObserver<T, U, U> implements Runnable, Disposable {
        final Callable<U> bufferSupplier;
        final List<U> buffers;
        final long timeskip;
        final long timespan;
        final TimeUnit unit;
        Disposable upstream;
        final Scheduler.Worker w;

        final class RemoveFromBuffer implements Runnable {
            private final U b;
            final /* synthetic */ BufferSkipBoundedObserver this$0;

            RemoveFromBuffer(BufferSkipBoundedObserver r1, U r2) {
                this.this$0 = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                BufferSkipBoundedObserver r0 = this.this$0;
                monitor-enter(r0);
                this.this$0.buffers.remove(this.b);     // Catch: Throwable -> L8
                monitor-exit(r0);     // Catch: Throwable -> L8
                BufferSkipBoundedObserver r1 = this.this$0;
                BufferSkipBoundedObserver.access$000(r1, this.b, false, r1.w);
                return;
            L8:
                th = move-exception;
                throw th;
            }
        }

        final class RemoveFromBufferEmit implements Runnable {
            private final U buffer;
            final /* synthetic */ BufferSkipBoundedObserver this$0;

            RemoveFromBufferEmit(BufferSkipBoundedObserver r1, U r2) {
                this.this$0 = r1;
                this.buffer = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                BufferSkipBoundedObserver r0 = this.this$0;
                monitor-enter(r0);
                this.this$0.buffers.remove(this.buffer);     // Catch: Throwable -> L8
                monitor-exit(r0);     // Catch: Throwable -> L8
                BufferSkipBoundedObserver r1 = this.this$0;
                BufferSkipBoundedObserver.access$100(r1, this.buffer, false, r1.w);
                return;
            L8:
                th = move-exception;
                throw th;
            }
        }

        static /* synthetic */ void access$000(BufferSkipBoundedObserver r0, Object r1, boolean r2, Disposable r3) {
            r0.fastPathOrderedEmit(r1, r2, r3);
        }

        static /* synthetic */ void access$100(BufferSkipBoundedObserver r0, Object r1, boolean r2, Disposable r3) {
            r0.fastPathOrderedEmit(r1, r2, r3);
        }

        @Override // io.reactivex.internal.observers.QueueDrainObserver, io.reactivex.internal.util.ObservableQueueDrain
        public /* bridge */ /* synthetic */ void accept(Observer r1, Object r2) {
            accept(r1, (Collection) r2);
        }

        BufferSkipBoundedObserver(Observer<? super U> r2, Callable<U> r3, long r4, long r6, TimeUnit r8, Scheduler.Worker r9) {
            super(r2, new MpscLinkedQueue());
            this.bufferSupplier = r3;
            this.timespan = r4;
            this.timeskip = r6;
            this.unit = r8;
            this.w = r9;
            this.buffers = new LinkedList();
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r9) {
            if (DisposableHelper.validate(this.upstream, r9) == false) goto L12;
            this.upstream = r9;
            Collection r0 = (Collection) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The buffer supplied is null");     // Catch: Throwable -> L7
            this.buffers.add((U) r0);
            this.downstream.onSubscribe(this);
            Scheduler.Worker r1 = this.w;
            long r5 = this.timeskip;
            r1.schedulePeriodically(this, r5, r5, this.unit);
            this.w.schedule(new RemoveFromBufferEmit(this, r0), this.timespan, this.unit);
            return;
        L7:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r9.dispose();
            EmptyDisposable.error(th, this.downstream);
            this.w.dispose();
            return;
        }

        @Override // io.reactivex.Observer
        public void onNext(T r3) {
            monitor-enter(this);
            Iterator<U> r0 = this.buffers.iterator();     // Catch: Throwable -> L9
        L5:
            if (r0.hasNext() == false) goto L7;
            r0.next().add(r3);     // Catch: Throwable -> L9
            goto L5
        L7:
            monitor-exit(this);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r2) {
            this.done = true;
            clear();
            this.downstream.onError(r2);
            this.w.dispose();
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // io.reactivex.Observer
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
            QueueDrainHelper.drainLoop(this.queue, this.downstream, false, this.w, this);
            return;
        L19:
            return;
        L13:
            th = move-exception;
            throw th;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled == true) goto L6;
            this.cancelled = true;
            clear();
            this.upstream.dispose();
            this.w.dispose();
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        void clear() {
            monitor-enter(this);
            this.buffers.clear();     // Catch: Throwable -> L6
            monitor-exit(this);     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            throw th;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // java.lang.Runnable
        public void run() {
            if (this.cancelled == false) goto L21;
            return;
        L21:
            Collection r0 = (Collection) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The bufferSupplier returned a null buffer");     // Catch: Throwable -> L18
            monitor-enter(this);
        L15:
            th = move-exception;
            throw th;
        L8:
            if (this.cancelled == false) goto L11;
            monitor-exit(this);     // Catch: Throwable -> L15
            return;
        L11:
            this.buffers.add((U) r0);     // Catch: Throwable -> L15
            monitor-exit(this);     // Catch: Throwable -> L15
            this.w.schedule(new RemoveFromBuffer(this, r0), this.timespan, this.unit);
            return;
        L18:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.downstream.onError(th);
            dispose();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void accept(Observer<? super U> r1, U r2) {
            r1.onNext(r2);
        }
    }

    public ObservableBufferTimed(ObservableSource<T> r1, long r2, long r4, TimeUnit r6, Scheduler r7, Callable<U> r8, int r9, boolean r10) {
        super(r1);
        this.timespan = r2;
        this.timeskip = r4;
        this.unit = r6;
        this.scheduler = r7;
        this.bufferSupplier = r8;
        this.maxSize = r9;
        this.restartTimerOnMaxSize = r10;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super U> r12) {
        if (this.timespan == this.timeskip) goto L5;
    L8:
        Scheduler.Worker r9 = this.scheduler.createWorker();
        if (this.timespan != this.timeskip) goto L12;
        this.source.subscribe(new BufferExactBoundedObserver(new SerializedObserver(r12), this.bufferSupplier, this.timespan, this.unit, this.maxSize, this.restartTimerOnMaxSize, r9));
        return;
    L12:
        this.source.subscribe(new BufferSkipBoundedObserver(new SerializedObserver(r12), this.bufferSupplier, this.timespan, this.timeskip, this.unit, r9));
        return;
    L5:
        if (this.maxSize != Integer.MAX_VALUE) goto L8;
        this.source.subscribe(new BufferExactUnboundedObserver(new SerializedObserver(r12), this.bufferSupplier, this.timespan, this.unit, this.scheduler));
    }
}
