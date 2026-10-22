package io.reactivex.internal.operators.observable;

import adcpeJava.adcpe.Constants;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableFlatMapMaybe<T, R> extends AbstractObservableWithUpstream<T, R> {
    final boolean delayErrors;
    final Function<? super T, ? extends MaybeSource<? extends R>> mapper;

    static final class FlatMapMaybeObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 8600231336733376951L;
        final AtomicInteger active;
        volatile boolean cancelled;
        final boolean delayErrors;
        final Observer<? super R> downstream;
        final AtomicThrowable errors;
        final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
        final AtomicReference<SpscLinkedArrayQueue<R>> queue;
        final CompositeDisposable set;
        Disposable upstream;

        final class InnerObserver extends AtomicReference<Disposable> implements MaybeObserver<R>, Disposable {
            private static final long serialVersionUID = -502562646270949838L;
            final /* synthetic */ FlatMapMaybeObserver this$0;

            InnerObserver(FlatMapMaybeObserver r1) {
                this.this$0 = r1;
            }

            @Override // io.reactivex.MaybeObserver
            public void onSubscribe(Disposable r1) {
                DisposableHelper.setOnce(this, r1);
            }

            @Override // io.reactivex.MaybeObserver
            public void onSuccess(R r2) {
                this.this$0.innerSuccess(this, r2);
            }

            @Override // io.reactivex.MaybeObserver
            public void onError(Throwable r2) {
                this.this$0.innerError(this, r2);
            }

            @Override // io.reactivex.MaybeObserver
            public void onComplete() {
                this.this$0.innerComplete(this);
            }

            @Override // io.reactivex.disposables.Disposable
            public boolean isDisposed() {
                return DisposableHelper.isDisposed(get());
            }

            @Override // io.reactivex.disposables.Disposable
            public void dispose() {
                DisposableHelper.dispose(this);
            }
        }

        FlatMapMaybeObserver(Observer<? super R> r1, Function<? super T, ? extends MaybeSource<? extends R>> r2, boolean r3) {
            this.downstream = r1;
            this.mapper = r2;
            this.delayErrors = r3;
            this.set = new CompositeDisposable();
            this.errors = new AtomicThrowable();
            this.active = new AtomicInteger(1);
            this.queue = new AtomicReference();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r2) {
            if (DisposableHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.Observer
        public void onNext(T r3) {
            MaybeSource r4 = (MaybeSource) ObjectHelper.requireNonNull(this.mapper.apply(r3), "The mapper returned a null MaybeSource");     // Catch: Throwable -> L9
            this.active.getAndIncrement();
            InnerObserver r0 = new InnerObserver(this);
            if (this.cancelled == false) goto L6;
            return;
        L6:
            if (this.set.add(r0) == false) goto L15;
            r4.subscribe(r0);
            return;
        L15:
            return;
        L9:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.upstream.dispose();
            onError(th);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r2) {
            this.active.decrementAndGet();
            if (this.errors.addThrowable(r2) == true) goto L5;
            RxJavaPlugins.onError(r2);
            return;
        L5:
            if (this.delayErrors == true) goto L7;
            this.set.dispose();
        L7:
            drain();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.active.decrementAndGet();
            drain();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.set.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        void innerSuccess(FlatMapMaybeObserver<T, R>.InnerObserver r3, R r4) {
            this.set.delete(r3);
            if (get() != 0) goto L22;
            boolean r5 = false;
            if (compareAndSet(0, 1) == false) goto L22;
            this.downstream.onNext(r4);
            if (this.active.decrementAndGet() != 0) goto L9;
            r5 = true;
        L9:
            SpscLinkedArrayQueue<R> r6 = this.queue.get();
            if (r5 == false) goto L20;
            if (r6 != null) goto L13;
        L14:
            Throwable r7 = this.errors.terminate();
            if (r7 == null) goto L17;
            this.downstream.onError(r7);
            return;
        L17:
            this.downstream.onComplete();
            return;
        L13:
            if (r6.isEmpty() == true) goto L14;
        L20:
            if (decrementAndGet() != 0) goto L29;
            return;
        L29:
            drainLoop();
            return;
        L22:
            SpscLinkedArrayQueue<R> r8 = getOrCreateQueue();
            monitor-enter(r8);
            r8.offer(r4);     // Catch: Throwable -> L31
            monitor-exit(r8);     // Catch: Throwable -> L31
            this.active.decrementAndGet();
            if (getAndIncrement() == 0) goto L29;
            return;
        L31:
            th = move-exception;
            throw th;
        }

        SpscLinkedArrayQueue<R> getOrCreateQueue() {
        L2:
            SpscLinkedArrayQueue<R> r0 = this.queue.get();
            if (r0 != null) goto L4;
            SpscLinkedArrayQueue<R> r1 = new SpscLinkedArrayQueue(Observable.bufferSize());
            if (this.queue.compareAndSet(null, r1) == false) goto L2;
            return r1;
        L4:
            return r0;
        }

        void innerError(FlatMapMaybeObserver<T, R>.InnerObserver r2, Throwable r3) {
            this.set.delete(r2);
            if (this.errors.addThrowable(r3) == true) goto L5;
            RxJavaPlugins.onError(r3);
            return;
        L5:
            if (this.delayErrors == true) goto L7;
            this.upstream.dispose();
            this.set.dispose();
        L7:
            this.active.decrementAndGet();
            drain();
        }

        void innerComplete(FlatMapMaybeObserver<T, R>.InnerObserver r3) {
            this.set.delete(r3);
            if (get() != 0) goto L23;
            boolean r4 = false;
            if (compareAndSet(0, 1) == false) goto L23;
            if (this.active.decrementAndGet() != 0) goto L9;
            r4 = true;
        L9:
            SpscLinkedArrayQueue<R> r0 = this.queue.get();
            if (r4 == false) goto L20;
            if (r0 != null) goto L13;
        L14:
            Throwable r5 = this.errors.terminate();
            if (r5 == null) goto L17;
            this.downstream.onError(r5);
            return;
        L17:
            this.downstream.onComplete();
            return;
        L13:
            if (r0.isEmpty() == true) goto L14;
        L20:
            if (decrementAndGet() != 0) goto L22;
            return;
        L22:
            drainLoop();
            return;
        L23:
            this.active.decrementAndGet();
            drain();
        }

        void drain() {
            if (getAndIncrement() != 0) goto L6;
            drainLoop();
            return;
        }

        void clear() {
            SpscLinkedArrayQueue<R> r0 = this.queue.get();
            if (r0 == null) goto L6;
            r0.clear();
            return;
        }

        void drainLoop() {
            Observer<? super R> r0 = this.downstream;
            AtomicInteger r1 = this.active;
            AtomicReference<SpscLinkedArrayQueue<R>> r2 = this.queue;
            int r4 = 1;
        L4:
            if (this.cancelled == true) goto L5;
            if (this.delayErrors == false) goto L10;
        L13:
            boolean r6 = false;
            if (r1.get() != 0) goto L16;
            boolean r5 = true;
        L17:
            SpscLinkedArrayQueue<R> r7 = r2.get();
            if (r7 == null) goto L20;
            Constants r8 = r7.poll();
        L21:
            if (r8 != null) goto L23;
            r6 = true;
        L23:
            if (r5 == false) goto L30;
            if (r6 == false) goto L30;
            Throwable r9 = this.errors.terminate();
            if (r9 == null) goto L28;
            r0.onError(r9);
            return;
        L28:
            r0.onComplete();
            return;
        L30:
            if (r6 == true) goto L31;
            r0.onNext(r8);
            goto L4
        L31:
            r4 = addAndGet(-r4);
            if (r4 != 0) goto L4;
            return;
        L20:
            r8 = null;
            goto L21
        L16:
            r5 = false;
            goto L17
        L10:
            if (this.errors.get() == null) goto L13;
            Throwable r3 = this.errors.terminate();
            clear();
            r0.onError(r3);
            return;
        L5:
            clear();
        }
    }

    public ObservableFlatMapMaybe(ObservableSource<T> r1, Function<? super T, ? extends MaybeSource<? extends R>> r2, boolean r3) {
        super(r1);
        this.mapper = r2;
        this.delayErrors = r3;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super R> r4) {
        this.source.subscribe(new FlatMapMaybeObserver(r4, this.mapper, this.delayErrors));
    }
}
