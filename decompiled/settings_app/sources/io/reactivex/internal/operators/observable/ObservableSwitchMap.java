package io.reactivex.internal.operators.observable;

import adcpeJava.adcpe.Constants;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableSwitchMap<T, R> extends AbstractObservableWithUpstream<T, R> {
    final int bufferSize;
    final boolean delayErrors;
    final Function<? super T, ? extends ObservableSource<? extends R>> mapper;

    static final class SwitchMapInnerObserver<T, R> extends AtomicReference<Disposable> implements Observer<R> {
        private static final long serialVersionUID = 3837284832786408377L;
        final int bufferSize;
        volatile boolean done;
        final long index;
        final SwitchMapObserver<T, R> parent;
        volatile SimpleQueue<R> queue;

        SwitchMapInnerObserver(SwitchMapObserver<T, R> r1, long r2, int r4) {
            this.parent = r1;
            this.index = r2;
            this.bufferSize = r4;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r3) {
            if (DisposableHelper.setOnce(this, r3) == true) goto L5;
            return;
        L5:
            if ((r3 instanceof QueueDisposable) == false) goto L14;
            QueueDisposable r4 = (QueueDisposable) r3;
            int r0 = r4.requestFusion(7);
            if (r0 != 1) goto L11;
            this.queue = r4;
            this.done = true;
            this.parent.drain();
            return;
        L11:
            if (r0 != 2) goto L14;
            this.queue = r4;
            return;
        L14:
            this.queue = new SpscLinkedArrayQueue(this.bufferSize);
        }

        @Override // io.reactivex.Observer
        public void onNext(R r5) {
            if (this.index != this.parent.unique) goto L8;
            if (r5 == null) goto L6;
            this.queue.offer(r5);
        L6:
            this.parent.drain();
            return;
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r2) {
            this.parent.innerError(this, r2);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.index != this.parent.unique) goto L6;
            this.done = true;
            this.parent.drain();
            return;
        }

        public void cancel() {
            DisposableHelper.dispose(this);
        }
    }

    static final class SwitchMapObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        static final SwitchMapInnerObserver<Object, Object> CANCELLED = null;
        private static final long serialVersionUID = -3491074160481096299L;
        final AtomicReference<SwitchMapInnerObserver<T, R>> active;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final Observer<? super R> downstream;
        final AtomicThrowable errors;
        final Function<? super T, ? extends ObservableSource<? extends R>> mapper;
        volatile long unique;
        Disposable upstream;

        static {
            SwitchMapInnerObserver<Object, Object> r0 = new SwitchMapInnerObserver(null, -1, 1);
            CANCELLED = r0;
            r0.cancel();
        }

        SwitchMapObserver(Observer<? super R> r2, Function<? super T, ? extends ObservableSource<? extends R>> r3, int r4, boolean r5) {
            this.active = new AtomicReference();
            this.downstream = r2;
            this.mapper = r3;
            this.bufferSize = r4;
            this.delayErrors = r5;
            this.errors = new AtomicThrowable();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r2) {
            if (DisposableHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.Observer
        public void onNext(T r5) {
            long r0 = this.unique + 1;
            this.unique = r0;
            SwitchMapInnerObserver<T, R> r2 = this.active.get();
            if (r2 == null) goto L17;
            r2.cancel();
        L17:
            ObservableSource r6 = (ObservableSource) ObjectHelper.requireNonNull(this.mapper.apply(r5), "The ObservableSource returned is null");     // Catch: Throwable -> L14
            SwitchMapInnerObserver<T, R> r3 = new SwitchMapInnerObserver(this, r0, this.bufferSize);
        L7:
            SwitchMapInnerObserver<T, R> r1 = this.active.get();
            if (r1 == CANCELLED) goto L22;
            if (this.active.compareAndSet(r1, r3) == false) goto L7;
            r6.subscribe(r3);
            return;
        L22:
            return;
        L14:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.upstream.dispose();
            onError(th);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r2) {
            if (this.done == false) goto L5;
        L10:
            RxJavaPlugins.onError(r2);
            return;
        L5:
            if (this.errors.addThrowable(r2) == false) goto L10;
            if (this.delayErrors == true) goto L9;
            disposeInner();
        L9:
            this.done = true;
            drain();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.done == true) goto L6;
            this.done = true;
            drain();
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled == true) goto L6;
            this.cancelled = true;
            this.upstream.dispose();
            disposeInner();
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        void disposeInner() {
            SwitchMapInnerObserver<T, R> r0 = this.active.get();
            SwitchMapInnerObserver<Object, Object> r1 = CANCELLED;
            if (r0 == r1) goto L9;
            SwitchMapInnerObserver<T, R> r2 = this.active.getAndSet((SwitchMapInnerObserver<T, R>) r1);
            if (r2 == r1) goto L10;
            if (r2 == null) goto L11;
            r2.cancel();
            return;
        L11:
            return;
        L10:
            return;
        }

        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            Observer<? super R> r0 = this.downstream;
            AtomicReference<SwitchMapInnerObserver<T, R>> r1 = this.active;
            boolean r2 = this.delayErrors;
            int r4 = 1;
        L7:
            if (this.cancelled == true) goto L8;
            if (this.done == true) goto L12;
        L29:
            SwitchMapInnerObserver<T, R> r5 = r1.get();
            if (r5 == null) goto L76;
            SimpleQueue<R> r7 = r5.queue;
            if (r7 == null) goto L76;
            if (r5.done == false) goto L45;
            boolean r8 = r7.isEmpty();
            if (r2 == true) goto L37;
            if (this.errors.get() != null) goto L41;
            if (r8 == false) goto L45;
            r1.compareAndSet(r5, null);
            goto L7
        L41:
            r0.onError(this.errors.terminate());
            return;
        L37:
            if (r8 == false) goto L45;
            r1.compareAndSet(r5, null);
        L45:
            boolean r9 = false;
        L47:
            if (this.cancelled == true) goto L48;
            if (r5 != r1.get()) goto L51;
            if (r2 == false) goto L54;
        L57:
            boolean r10 = r5.done;
            Constants r11 = r7.poll();     // Catch: Throwable -> L60
        L66:
            if (r11 != null) goto L68;
            boolean r12 = true;
        L69:
            if (r10 == false) goto L72;
            if (r12 == false) goto L72;
            r1.compareAndSet(r5, null);
        L72:
            if (r12 == true) goto L73;
            r0.onNext(r11);
        L73:
            if (r9 == false) goto L76;
        L68:
            r12 = false;
        L60:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.errors.addThrowable(th);
            r1.compareAndSet(r5, null);
            if (r2 == true) goto L64;
            disposeInner();
            this.upstream.dispose();
            this.done = true;
        L65:
            r9 = true;
            r11 = null;
            goto L66
        L64:
            r5.cancel();
            goto L65
        L54:
            if (this.errors.get() == null) goto L57;
            r0.onError(this.errors.terminate());
            return;
        L51:
            r9 = true;
            goto L73
        L48:
            return;
        L76:
            r4 = addAndGet(-r4);
            if (r4 != 0) goto L7;
            return;
        L12:
            if (r1.get() != null) goto L14;
            boolean r6 = true;
        L15:
            if (r2 == false) goto L23;
            if (r6 == false) goto L29;
            Throwable r13 = this.errors.get();
            if (r13 == null) goto L20;
            r0.onError(r13);
            return;
        L20:
            r0.onComplete();
            return;
        L23:
            if (this.errors.get() != null) goto L24;
            if (r6 == false) goto L29;
            r0.onComplete();
            return;
        L24:
            r0.onError(this.errors.terminate());
            return;
        L14:
            r6 = false;
            goto L15
        }

        void innerError(SwitchMapInnerObserver<T, R> r5, Throwable r6) {
            if (r5.index == this.unique) goto L5;
        L10:
            RxJavaPlugins.onError(r6);
            return;
        L5:
            if (this.errors.addThrowable(r6) == false) goto L10;
            if (this.delayErrors == true) goto L9;
            this.upstream.dispose();
            this.done = true;
        L9:
            r5.done = true;
            drain();
        }
    }

    public ObservableSwitchMap(ObservableSource<T> r1, Function<? super T, ? extends ObservableSource<? extends R>> r2, int r3, boolean r4) {
        super(r1);
        this.mapper = r2;
        this.bufferSize = r3;
        this.delayErrors = r4;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super R> r5) {
        if (ObservableScalarXMap.tryScalarXMapSubscribe(this.source, r5, this.mapper) == false) goto L5;
        return;
    L5:
        this.source.subscribe(new SwitchMapObserver(r5, this.mapper, this.bufferSize, this.delayErrors));
    }
}
