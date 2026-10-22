package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.UnicastSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import tmsdkobf.b0$$ExternalSyntheticBackport0;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableWindowBoundarySelector<T, B, V> extends AbstractObservableWithUpstream<T, Observable<T>> {
    final int bufferSize;
    final Function<? super B, ? extends ObservableSource<V>> close;
    final ObservableSource<B> open;

    static final class OperatorWindowBoundaryCloseObserver<T, V> extends DisposableObserver<V> {
        boolean done;
        final WindowBoundaryMainObserver<T, ?, V> parent;
        final UnicastSubject<T> w;

        OperatorWindowBoundaryCloseObserver(WindowBoundaryMainObserver<T, ?, V> r1, UnicastSubject<T> r2) {
            this.parent = r1;
            this.w = r2;
        }

        @Override // io.reactivex.Observer
        public void onNext(V r1) {
            dispose();
            onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r2) {
            if (this.done == false) goto L6;
            RxJavaPlugins.onError(r2);
            return;
        L6:
            this.done = true;
            this.parent.error(r2);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            this.parent.close(this);
        }
    }

    static final class OperatorWindowBoundaryOpenObserver<T, B> extends DisposableObserver<B> {
        final WindowBoundaryMainObserver<T, B, ?> parent;

        OperatorWindowBoundaryOpenObserver(WindowBoundaryMainObserver<T, B, ?> r1) {
            this.parent = r1;
        }

        @Override // io.reactivex.Observer
        public void onNext(B r1) {
            this.parent.open(r1);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r1) {
            this.parent.error(r1);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.parent.onComplete();
        }
    }

    static final class WindowBoundaryMainObserver<T, B, V> extends QueueDrainObserver<T, Object, Observable<T>> implements Disposable {
        final AtomicReference<Disposable> boundary;
        final int bufferSize;
        final Function<? super B, ? extends ObservableSource<V>> close;
        final ObservableSource<B> open;
        final CompositeDisposable resources;
        final AtomicBoolean stopWindows;
        Disposable upstream;
        final AtomicLong windows;
        final List<UnicastSubject<T>> ws;

        @Override // io.reactivex.internal.observers.QueueDrainObserver, io.reactivex.internal.util.ObservableQueueDrain
        public void accept(Observer<? super Observable<T>> r1, Object r2) {
        }

        WindowBoundaryMainObserver(Observer<? super Observable<T>> r2, ObservableSource<B> r3, Function<? super B, ? extends ObservableSource<V>> r4, int r5) {
            super(r2, new MpscLinkedQueue());
            this.boundary = new AtomicReference();
            AtomicLong r6 = new AtomicLong();
            this.windows = r6;
            this.stopWindows = new AtomicBoolean();
            this.open = r3;
            this.close = r4;
            this.bufferSize = r5;
            this.resources = new CompositeDisposable();
            this.ws = new ArrayList();
            r6.lazySet(1);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r3) {
            if (DisposableHelper.validate(this.upstream, r3) == false) goto L11;
            this.upstream = r3;
            this.downstream.onSubscribe(this);
            if (this.stopWindows.get() == false) goto L7;
            return;
        L7:
            OperatorWindowBoundaryOpenObserver r4 = new OperatorWindowBoundaryOpenObserver(this);
            if (b0$$ExternalSyntheticBackport0.m(this.boundary, null, r4) == false) goto L12;
            this.open.subscribe(r4);
            return;
        L12:
            return;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // io.reactivex.Observer
        public void onNext(T r3) {
            if (fastEnter() == false) goto L11;
            Iterator<UnicastSubject<T>> r0 = this.ws.iterator();
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
            this.queue.offer((U) NotificationLite.next(r3));
            if (enter() == true) goto L14;
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r5) {
            if (this.done == false) goto L6;
            RxJavaPlugins.onError(r5);
            return;
        L6:
            this.error = r5;
            this.done = true;
            if (enter() == false) goto L10;
            drainLoop();
        L10:
            if (this.windows.decrementAndGet() != 0) goto L12;
            this.resources.dispose();
        L12:
            this.downstream.onError(r5);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            if (enter() == false) goto L9;
            drainLoop();
        L9:
            if (this.windows.decrementAndGet() != 0) goto L11;
            this.resources.dispose();
        L11:
            this.downstream.onComplete();
        }

        void error(Throwable r2) {
            this.upstream.dispose();
            this.resources.dispose();
            onError(r2);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.stopWindows.compareAndSet(false, true) == false) goto L8;
            DisposableHelper.dispose(this.boundary);
            if (this.windows.decrementAndGet() != 0) goto L9;
            this.upstream.dispose();
            return;
        L9:
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.stopWindows.get();
        }

        void disposeBoundary() {
            this.resources.dispose();
            DisposableHelper.dispose(this.boundary);
        }

        /* JADX WARN: Multi-variable type inference failed */
        void drainLoop() {
            MpscLinkedQueue r0 = (MpscLinkedQueue) this.queue;
            Observer<? super V> r1 = this.downstream;
            List<UnicastSubject<T>> r2 = this.ws;
            int r4 = 1;
        L3:
            boolean r5 = this.done;
            Object r6 = r0.poll();
            if (r6 != null) goto L6;
            boolean r7 = true;
        L7:
            if (r5 == false) goto L21;
            if (r7 == false) goto L21;
            disposeBoundary();
            Throwable r9 = this.error;
            if (r9 == null) goto L15;
            Iterator<UnicastSubject<T>> r3 = r2.iterator();
        L13:
            if (r3.hasNext() == false) goto L19;
            r3.next().onError(r9);
        L19:
            r2.clear();
            return;
        L15:
            Iterator<UnicastSubject<T>> r10 = r2.iterator();
        L17:
            if (r10.hasNext() == false) goto L19;
            r10.next().onComplete();
        L21:
            if (r7 == true) goto L22;
            if ((r6 instanceof WindowOperation) == true) goto L27;
            Iterator<UnicastSubject<T>> r8 = r2.iterator();
        L47:
            if (r8.hasNext() == false) goto L3;
            r8.next().onNext(NotificationLite.getValue(r6));
            goto L47
        L27:
            WindowOperation r11 = (WindowOperation) r6;
            if (r11.w != null) goto L30;
            if (this.stopWindows.get() == true) goto L3;
            UnicastSubject<T> r12 = UnicastSubject.create(this.bufferSize);
            r2.add(r12);
            r1.onNext(r12);
            ObservableSource r13 = (ObservableSource) ObjectHelper.requireNonNull(this.close.apply(r11.open), "The ObservableSource supplied is null");     // Catch: Throwable -> L43
            OperatorWindowBoundaryCloseObserver r14 = new OperatorWindowBoundaryCloseObserver(this, r12);
            if (this.resources.add(r14) == false) goto L3;
            this.windows.getAndIncrement();
            r13.subscribe(r14);
        L43:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.stopWindows.set(true);
            r1.onError(th);
            goto L3
        L30:
            if (r2.remove(r11.w) == false) goto L3;
            r11.w.onComplete();
            if (this.windows.decrementAndGet() != 0) goto L3;
            disposeBoundary();
            return;
        L22:
            r4 = leave(-r4);
            if (r4 != 0) goto L3;
            return;
        L6:
            r7 = false;
            goto L7
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        void open(B r4) {
            this.queue.offer((U) new WindowOperation(null, r4));
            if (enter() == false) goto L6;
            drainLoop();
            return;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        void close(OperatorWindowBoundaryCloseObserver<T, V> r4) {
            this.resources.delete(r4);
            this.queue.offer((U) new WindowOperation(r4.w, null));
            if (enter() == false) goto L6;
            drainLoop();
            return;
        }
    }

    static final class WindowOperation<T, B> {
        final B open;
        final UnicastSubject<T> w;

        WindowOperation(UnicastSubject<T> r1, B r2) {
            this.w = r1;
            this.open = r2;
        }
    }

    public ObservableWindowBoundarySelector(ObservableSource<T> r1, ObservableSource<B> r2, Function<? super B, ? extends ObservableSource<V>> r3, int r4) {
        super(r1);
        this.open = r2;
        this.close = r3;
        this.bufferSize = r4;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Observable<T>> r5) {
        this.source.subscribe(new WindowBoundaryMainObserver(new SerializedObserver(r5), this.open, this.close, this.bufferSize));
    }
}
