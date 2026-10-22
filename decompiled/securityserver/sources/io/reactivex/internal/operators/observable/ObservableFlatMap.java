package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class ObservableFlatMap<T, U> extends AbstractObservableWithUpstream<T, U> {
    final int bufferSize;
    final boolean delayErrors;
    final Function<? super T, ? extends ObservableSource<? extends U>> mapper;
    final int maxConcurrency;

    public static final class InnerObserver<T, U> extends AtomicReference<Disposable> implements Observer<U> {
        private static final long serialVersionUID = -4606175640614850599L;
        volatile boolean done;
        int fusionMode;
        final long id;
        final MergeObserver<T, U> parent;
        volatile SimpleQueue<U> queue;

        public InnerObserver(MergeObserver<T, U> r1, long r2) {
            this.id = r2;
            this.parent = r1;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r2) {
            if (this.parent.errors.addThrowable(r2) == false) goto L8;
            MergeObserver<T, U> r3 = this.parent;
            if (r3.delayErrors == true) goto L7;
            r3.disposeAll();
        L7:
            this.done = true;
            this.parent.drain();
            return;
        L8:
            RxJavaPlugins.onError(r2);
        }

        @Override // io.reactivex.Observer
        public void onNext(U r2) {
            if (this.fusionMode != 0) goto L5;
            this.parent.tryEmit(r2, this);
            return;
        L5:
            this.parent.drain();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r3) {
            if (DisposableHelper.setOnce(this, r3) == true) goto L5;
            return;
        L5:
            if ((r3 instanceof QueueDisposable) == false) goto L15;
            QueueDisposable r4 = (QueueDisposable) r3;
            int r0 = r4.requestFusion(7);
            if (r0 != 1) goto L11;
            this.fusionMode = r0;
            this.queue = r4;
            this.done = true;
            this.parent.drain();
            return;
        L11:
            if (r0 != 2) goto L16;
            this.fusionMode = r0;
            this.queue = r4;
            return;
        L16:
            return;
        }
    }

    public static final class MergeObserver<T, U> extends AtomicInteger implements Disposable, Observer<T> {
        static final InnerObserver<?, ?>[] CANCELLED = null;
        static final InnerObserver<?, ?>[] EMPTY = null;
        private static final long serialVersionUID = -2117620485640801370L;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final Observer<? super U> downstream;
        final AtomicThrowable errors;
        long lastId;
        int lastIndex;
        final Function<? super T, ? extends ObservableSource<? extends U>> mapper;
        final int maxConcurrency;
        final AtomicReference<InnerObserver<?, ?>[]> observers;
        volatile SimplePlainQueue<U> queue;
        Queue<ObservableSource<? extends U>> sources;
        long uniqueId;
        Disposable upstream;
        int wip;

        static {
            EMPTY = new InnerObserver[0];
            CANCELLED = new InnerObserver[0];
        }

        public MergeObserver(Observer<? super U> r2, Function<? super T, ? extends ObservableSource<? extends U>> r3, boolean r4, int r5, int r6) {
            this.errors = new AtomicThrowable();
            this.downstream = r2;
            this.mapper = r3;
            this.delayErrors = r4;
            this.maxConcurrency = r5;
            this.bufferSize = r6;
            if (r5 == Integer.MAX_VALUE) goto L5;
            this.sources = new ArrayDeque(r5);
        L5:
            this.observers = new AtomicReference(EMPTY);
        }

        public boolean addInner(InnerObserver<T, U> r5) {
        L2:
            InnerObserver<?, ?>[] r0 = this.observers.get();
            if (r0 == CANCELLED) goto L4;
            int r1 = r0.length;
            InnerObserver[] r3 = new InnerObserver[r1 + 1];
            System.arraycopy(r0, 0, r3, 0, r1);
            r3[r1] = r5;
            if (this.observers.compareAndSet(r0, (InnerObserver<?, ?>[]) r3) == false) goto L2;
            return true;
        L4:
            r5.dispose();
            return false;
        }

        public boolean checkTerminate() {
            if (this.cancelled == false) goto L5;
            return true;
        L5:
            Throwable r0 = this.errors.get();
            if (this.delayErrors == true) goto L12;
            if (r0 == null) goto L14;
            disposeAll();
            Throwable r1 = this.errors.terminate();
            if (r1 == ExceptionHelper.TERMINATED) goto L11;
            this.downstream.onError(r1);
        L11:
            return true;
        L14:
            return false;
        L12:
            return false;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled == true) goto L12;
            this.cancelled = true;
            if (disposeAll() == false) goto L13;
            Throwable r1 = this.errors.terminate();
            if (r1 != null) goto L9;
            return;
        L9:
            if (r1 == ExceptionHelper.TERMINATED) goto L15;
            RxJavaPlugins.onError(r1);
            return;
        L15:
            return;
        L13:
            return;
        }

        public boolean disposeAll() {
            this.upstream.dispose();
            InnerObserver<?, ?>[] r0 = this.observers.get();
            InnerObserver<?, ?>[] r1 = CANCELLED;
            int r2 = 0;
            if (r0 == r1) goto L11;
            InnerObserver<?, ?>[] r3 = this.observers.getAndSet(r1);
            if (r3 == r1) goto L11;
            int r4 = r3.length;
        L7:
            if (r2 >= r4) goto L9;
            r3[r2].dispose();
            r2 = r2 + 1;
            goto L7
        L9:
            return true;
        L11:
            return false;
        }

        public void drain() {
            if (getAndIncrement() != 0) goto L6;
            drainLoop();
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void drainLoop() {
            Observer<? super U> r0 = this.downstream;
            int r2 = 1;
        L4:
            if (checkTerminate() == true) goto L5;
            SimplePlainQueue<U> r3 = this.queue;
            if (r3 != null) goto L9;
        L15:
            boolean r4 = this.done;
            SimplePlainQueue<U> r5 = this.queue;
            InnerObserver<?, ?>[] r6 = this.observers.get();
            int r7 = r6.length;
            int r9 = 0;
            if (this.maxConcurrency == Integer.MAX_VALUE) goto L24;
            monitor-enter(this);
            int r8 = this.sources.size();     // Catch: Throwable -> L21
            monitor-exit(this);     // Catch: Throwable -> L21
        L25:
            if (r4 == false) goto L37;
            if (r5 != null) goto L28;
        L29:
            if (r7 != 0) goto L37;
            if (r8 != 0) goto L37;
            Throwable r13 = this.errors.terminate();
            if (r13 == ExceptionHelper.TERMINATED) goto L143;
            if (r13 != null) goto L35;
            r0.onComplete();
            return;
        L35:
            r0.onError(r13);
            return;
        L143:
            return;
        L28:
            if (r5.isEmpty() == true) goto L29;
        L37:
            if (r7 == 0) goto L88;
            long r10 = this.lastId;
            int r11 = this.lastIndex;
            if (r7 > r11) goto L41;
        L42:
            if (r7 > r11) goto L44;
            r11 = 0;
        L44:
            int r12 = 0;
        L45:
            if (r12 >= r7) goto L53;
            if (r6[r11].id == r10) goto L53;
            r11 = r11 + 1;
            if (r11 != r7) goto L52;
            r11 = 0;
        L52:
            r12 = r12 + 1;
        L53:
            this.lastIndex = r11;
            this.lastId = r6[r11].id;
        L54:
            int r14 = 0;
            int r15 = 0;
        L55:
            if (r14 >= r7) goto L87;
            if (checkTerminate() == true) goto L58;
            InnerObserver<T, U> r16 = r6[r11];
            SimpleQueue<U> r17 = r16.queue;
            if (r17 != null) goto L109;
        L74:
            boolean r18 = r16.done;
            SimpleQueue<U> r19 = r16.queue;
            if (r18 == false) goto L83;
            if (r19 != null) goto L78;
        L79:
            removeInner(r16);
            if (checkTerminate() == true) goto L81;
            r15 = r15 + 1;
            goto L83
        L81:
            return;
        L78:
            if (r19.isEmpty() == true) goto L79;
        L83:
            r11 = r11 + 1;
            if (r11 != r7) goto L86;
        L85:
            r11 = 0;
        L86:
            r14 = r14 + 1;
        L109:
            U r110 = r17.poll();     // Catch: Throwable -> L67
            if (r110 == null) goto L74;
            r0.onNext(r110);
            if (checkTerminate() == false) goto L109;
            return;
        L67:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r16.dispose();
            this.errors.addThrowable(th);
            if (checkTerminate() == true) goto L70;
            removeInner(r16);
            r15 = r15 + 1;
            r11 = r11 + 1;
            if (r11 != r7) goto L86;
        L70:
            return;
        L58:
            return;
        L87:
            this.lastIndex = r11;
            this.lastId = r6[r11].id;
            r9 = r15;
            goto L88
        L41:
            if (r6[r11].id == r10) goto L54;
        L88:
            if (r9 != 0) goto L90;
            r2 = addAndGet(-r2);
            if (r2 != 0) goto L4;
            return;
        L90:
            if (this.maxConcurrency == Integer.MAX_VALUE) goto L4;
        L91:
            int r20 = r9 - 1;
            if (r9 == 0) goto L4;
            monitor-enter(this);
            ObservableSource<? extends U> r21 = this.sources.poll();     // Catch: Throwable -> L99
            if (r21 != null) goto L101;
            this.wip--;     // Catch: Throwable -> L99
            monitor-exit(this);     // Catch: Throwable -> L99
        L103:
            r9 = r20;
            goto L91
        L101:
            monitor-exit(this);     // Catch: Throwable -> L99
            subscribeInner(r21);
        L99:
            th = move-exception;
            throw th;
        L21:
            th = move-exception;
            throw th;
        L24:
            r8 = 0;
        L9:
            if (checkTerminate() == true) goto L10;
            U r22 = r3.poll();
            if (r22 == null) goto L15;
            r0.onNext(r22);
            goto L9
        L10:
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            drain();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r2) {
            if (this.done == false) goto L7;
            RxJavaPlugins.onError(r2);
            return;
        L7:
            if (this.errors.addThrowable(r2) == false) goto L9;
            this.done = true;
            drain();
            return;
        L9:
            RxJavaPlugins.onError(r2);
        }

        @Override // io.reactivex.Observer
        public void onNext(T r3) {
            if (this.done == false) goto L26;
            return;
        L26:
            ObservableSource<? extends U> r4 = (ObservableSource) ObjectHelper.requireNonNull(this.mapper.apply(r3), "The mapper returned a null ObservableSource");     // Catch: Throwable -> L23
            if (this.maxConcurrency == Integer.MAX_VALUE) goto L21;
            monitor-enter(this);
            int r0 = this.wip;     // Catch: Throwable -> L14
            if (r0 != this.maxConcurrency) goto L16;
            this.sources.offer(r4);     // Catch: Throwable -> L14
            monitor-exit(this);     // Catch: Throwable -> L14
            return;
        L16:
            this.wip = r0 + 1;     // Catch: Throwable -> L14
            monitor-exit(this);     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            throw th;
        L21:
            subscribeInner(r4);
            return;
        L23:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.upstream.dispose();
            onError(th);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r2) {
            if (DisposableHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void removeInner(InnerObserver<T, U> r7) {
        L2:
            InnerObserver<?, ?>[] r0 = this.observers.get();
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
            InnerObserver<?, ?>[] r2 = EMPTY;
        L19:
            if (this.observers.compareAndSet(r0, r2) == false) goto L2;
            return;
        L17:
            InnerObserver<?, ?>[] r5 = new InnerObserver[r1 - 1];
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

        public void subscribeInner(ObservableSource<? extends U> r6) {
        L3:
            if ((r6 instanceof Callable) == false) goto L20;
            if (tryEmitScalar((Callable) r6) == false) goto L33;
            if (this.maxConcurrency == Integer.MAX_VALUE) goto L34;
            monitor-enter(this);
            r6 = this.sources.poll();     // Catch: Throwable -> L12
            if (r6 != null) goto L14;
            boolean r1 = true;
            this.wip--;     // Catch: Throwable -> L12
        L15:
            monitor-exit(this);     // Catch: Throwable -> L12
            if (r1 == false) goto L3;
            drain();
            return;
        L14:
            r1 = false;
        L12:
            th = move-exception;
            throw th;
        L34:
            return;
        L33:
            return;
        L20:
            long r2 = this.uniqueId;
            this.uniqueId = 1 + r2;
            InnerObserver<T, U> r0 = new InnerObserver(this, r2);
            if (addInner(r0) == false) goto L32;
            r6.subscribe(r0);
            return;
        }

        public void tryEmit(U r3, InnerObserver<T, U> r4) {
            if (get() == 0) goto L5;
        L9:
            SimpleQueue r0 = r4.queue;
            if (r0 != null) goto L12;
            r0 = new SpscLinkedArrayQueue(this.bufferSize);
            r4.queue = r0;
        L12:
            r0.offer(r3);
            if (getAndIncrement() == 0) goto L15;
            return;
        L15:
            drainLoop();
            return;
        L5:
            if (compareAndSet(0, 1) == false) goto L9;
            this.downstream.onNext(r3);
            if (decrementAndGet() != 0) goto L15;
        }

        public boolean tryEmitScalar(Callable<? extends U> r5) {
            U r6 = r5.call();     // Catch: Throwable -> L29
            if (r6 != null) goto L7;
            return true;
        L7:
            if (get() == 0) goto L9;
        L13:
            SimplePlainQueue<U> r1 = this.queue;
            if (r1 != null) goto L21;
            if (this.maxConcurrency != Integer.MAX_VALUE) goto L18;
            r1 = new SpscLinkedArrayQueue(this.bufferSize);
        L19:
            this.queue = r1;
            goto L21
        L18:
            r1 = new SpscArrayQueue(this.maxConcurrency);
        L21:
            if (r1.offer(r6) == true) goto L25;
            onError(new IllegalStateException("Scalar queue full?!"));
            return true;
        L25:
            if (getAndIncrement() == 0) goto L27;
            return false;
        L27:
            drainLoop();
            return true;
        L9:
            if (compareAndSet(0, 1) == false) goto L13;
            this.downstream.onNext(r6);
            if (decrementAndGet() != 0) goto L27;
            return true;
        L29:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.errors.addThrowable(th);
            drain();
            return true;
        }
    }

    public ObservableFlatMap(ObservableSource<T> r1, Function<? super T, ? extends ObservableSource<? extends U>> r2, boolean r3, int r4, int r5) {
        super(r1);
        this.mapper = r2;
        this.delayErrors = r3;
        this.maxConcurrency = r4;
        this.bufferSize = r5;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super U> r9) {
        if (ObservableScalarXMap.tryScalarXMapSubscribe(this.source, r9, this.mapper) == false) goto L5;
        return;
    L5:
        this.source.subscribe(new MergeObserver(r9, this.mapper, this.delayErrors, this.maxConcurrency, this.bufferSize));
    }
}
