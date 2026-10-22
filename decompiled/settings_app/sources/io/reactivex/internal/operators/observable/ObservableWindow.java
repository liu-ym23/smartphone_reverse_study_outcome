package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.subjects.UnicastSubject;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableWindow<T> extends AbstractObservableWithUpstream<T, Observable<T>> {
    final int capacityHint;
    final long count;
    final long skip;

    static final class WindowExactObserver<T> extends AtomicInteger implements Observer<T>, Disposable, Runnable {
        private static final long serialVersionUID = -7481782523886138128L;
        volatile boolean cancelled;
        final int capacityHint;
        final long count;
        final Observer<? super Observable<T>> downstream;
        long size;
        Disposable upstream;
        UnicastSubject<T> window;

        WindowExactObserver(Observer<? super Observable<T>> r1, long r2, int r4) {
            this.downstream = r1;
            this.count = r2;
            this.capacityHint = r4;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r2) {
            if (DisposableHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.Observer
        public void onNext(T r6) {
            UnicastSubject<T> r0 = this.window;
            if (r0 == null) goto L5;
        L7:
            if (r0 == null) goto L14;
            r0.onNext(r6);
            long r1 = this.size + 1;
            this.size = r1;
            if (r1 < this.count) goto L15;
            this.size = 0;
            this.window = null;
            r0.onComplete();
            if (this.cancelled == false) goto L16;
            this.upstream.dispose();
            return;
        L16:
            return;
        L15:
            return;
        L14:
            return;
        L5:
            if (this.cancelled == true) goto L7;
            r0 = UnicastSubject.create(this.capacityHint, this);
            this.window = r0;
            this.downstream.onNext(r0);
            goto L7
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r3) {
            UnicastSubject<T> r0 = this.window;
            if (r0 == null) goto L5;
            this.window = null;
            r0.onError(r3);
        L5:
            this.downstream.onError(r3);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            UnicastSubject<T> r0 = this.window;
            if (r0 == null) goto L5;
            this.window = null;
            r0.onComplete();
        L5:
            this.downstream.onComplete();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.cancelled = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.cancelled == false) goto L6;
            this.upstream.dispose();
            return;
        }
    }

    static final class WindowSkipObserver<T> extends AtomicBoolean implements Observer<T>, Disposable, Runnable {
        private static final long serialVersionUID = 3366976432059579510L;
        volatile boolean cancelled;
        final int capacityHint;
        final long count;
        final Observer<? super Observable<T>> downstream;
        long firstEmission;
        long index;
        final long skip;
        Disposable upstream;
        final ArrayDeque<UnicastSubject<T>> windows;
        final AtomicInteger wip;

        WindowSkipObserver(Observer<? super Observable<T>> r2, long r3, long r5, int r7) {
            this.wip = new AtomicInteger();
            this.downstream = r2;
            this.count = r3;
            this.skip = r5;
            this.capacityHint = r7;
            this.windows = new ArrayDeque();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r2) {
            if (DisposableHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.Observer
        public void onNext(T r12) {
            ArrayDeque<UnicastSubject<T>> r0 = this.windows;
            long r1 = this.index;
            long r3 = this.skip;
            if ((r1 % r3) == 0) goto L5;
        L7:
            long r5 = this.firstEmission + 1;
            Iterator<UnicastSubject<T>> r9 = r0.iterator();
        L9:
            if (r9.hasNext() == false) goto L12;
            r9.next().onNext(r12);
            goto L9
        L12:
            if (r5 < this.count) goto L20;
            r0.poll().onComplete();
            if (r0.isEmpty() == true) goto L16;
        L19:
            this.firstEmission = r5 - r3;
        L21:
            this.index = r1 + 1;
            return;
        L16:
            if (this.cancelled == false) goto L19;
            this.upstream.dispose();
            return;
        L20:
            this.firstEmission = r5;
            goto L21
        L5:
            if (this.cancelled == true) goto L7;
            this.wip.getAndIncrement();
            UnicastSubject<T> r6 = UnicastSubject.create(this.capacityHint, this);
            r0.offer(r6);
            this.downstream.onNext(r6);
            goto L7
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r3) {
            ArrayDeque<UnicastSubject<T>> r0 = this.windows;
        L4:
            if (r0.isEmpty() == true) goto L6;
            r0.poll().onError(r3);
            goto L4
        L6:
            this.downstream.onError(r3);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            ArrayDeque<UnicastSubject<T>> r0 = this.windows;
        L4:
            if (r0.isEmpty() == true) goto L6;
            r0.poll().onComplete();
            goto L4
        L6:
            this.downstream.onComplete();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.cancelled = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.wip.decrementAndGet() == 0) goto L5;
            return;
        L5:
            if (this.cancelled == false) goto L9;
            this.upstream.dispose();
            return;
        }
    }

    public ObservableWindow(ObservableSource<T> r1, long r2, long r4, int r6) {
        super(r1);
        this.count = r2;
        this.skip = r4;
        this.capacityHint = r6;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Observable<T>> r10) {
        if (this.count != this.skip) goto L5;
        this.source.subscribe(new WindowExactObserver(r10, this.count, this.capacityHint));
        return;
    L5:
        this.source.subscribe(new WindowSkipObserver(r10, this.count, this.skip, this.capacityHint));
    }
}
