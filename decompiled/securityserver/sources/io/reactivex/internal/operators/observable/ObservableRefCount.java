package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.ResettableConnectable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class ObservableRefCount<T> extends Observable<T> {
    RefConnection connection;
    final int n;
    final Scheduler scheduler;
    final ConnectableObservable<T> source;
    final long timeout;
    final TimeUnit unit;

    public static final class RefConnection extends AtomicReference<Disposable> implements Runnable, Consumer<Disposable> {
        private static final long serialVersionUID = -4552101107598366241L;
        boolean connected;
        boolean disconnectedEarly;
        final ObservableRefCount<?> parent;
        long subscriberCount;
        Disposable timer;

        public RefConnection(ObservableRefCount<?> r1) {
            this.parent = r1;
        }

        @Override // io.reactivex.functions.Consumer
        public /* bridge */ /* synthetic */ void accept(Disposable r1) {
            accept2(r1);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.parent.timeout(this);
        }

        /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
        public void accept2(Disposable r3) {
            DisposableHelper.replace(this, r3);
            ObservableRefCount<?> r0 = this.parent;
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (this.disconnectedEarly == false) goto L9;
            ((ResettableConnectable) this.parent.source).resetIf(r3);     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
        }
    }

    public static final class RefCountObserver<T> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long serialVersionUID = -7419642935409022375L;
        final RefConnection connection;
        final Observer<? super T> downstream;
        final ObservableRefCount<T> parent;
        Disposable upstream;

        public RefCountObserver(Observer<? super T> r1, ObservableRefCount<T> r2, RefConnection r3) {
            this.downstream = r1;
            this.parent = r2;
            this.connection = r3;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.upstream.dispose();
            if (compareAndSet(false, true) == false) goto L6;
            this.parent.cancel(this.connection);
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (compareAndSet(false, true) == false) goto L6;
            this.parent.terminated(this.connection);
            this.downstream.onComplete();
            return;
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r3) {
            if (compareAndSet(false, true) == false) goto L5;
            this.parent.terminated(this.connection);
            this.downstream.onError(r3);
            return;
        L5:
            RxJavaPlugins.onError(r3);
        }

        @Override // io.reactivex.Observer
        public void onNext(T r1) {
            this.downstream.onNext(r1);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r2) {
            if (DisposableHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }
    }

    public ObservableRefCount(ConnectableObservable<T> r8) {
        this(r8, 1, 0, TimeUnit.NANOSECONDS, null);
    }

    public void cancel(RefConnection r5) {
        monitor-enter(this);
        RefConnection r0 = this.connection;     // Catch: Throwable -> L17
        if (r0 == null) goto L25;
        if (r0 != r5) goto L25;
        long r1 = r5.subscriberCount - 1;     // Catch: Throwable -> L17
        r5.subscriberCount = r1;     // Catch: Throwable -> L17
        if (r1 == 0) goto L10;
    L23:
        monitor-exit(this);     // Catch: Throwable -> L17
        return;
    L10:
        if (r5.connected == false) goto L23;
        if (this.timeout != 0) goto L19;
        timeout(r5);     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L17
        return;
    L19:
        SequentialDisposable r2 = new SequentialDisposable();     // Catch: Throwable -> L17
        r5.timer = r2;     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L17
        r2.replace(this.scheduler.scheduleDirect(r5, this.timeout, this.unit));
        return;
    L25:
        monitor-exit(this);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public void clearTimer(RefConnection r1) {
        Disposable r0 = r1.timer;
        if (r0 == null) goto L6;
        r0.dispose();
        r1.timer = null;
        return;
    }

    public void reset(RefConnection r2) {
        ConnectableObservable<T> r1 = this.source;
        if ((r1 instanceof Disposable) == false) goto L6;
        ((Disposable) r1).dispose();
        return;
    L6:
        if ((r1 instanceof ResettableConnectable) == false) goto L10;
        ((ResettableConnectable) r1).resetIf(r2.get());
        return;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> r6) {
        monitor-enter(this);
        RefConnection r0 = this.connection;     // Catch: Throwable -> L6
        if (r0 != null) goto L8;
        r0 = new RefConnection(this);     // Catch: Throwable -> L6
        this.connection = r0;     // Catch: Throwable -> L6
    L8:
        long r1 = r0.subscriberCount;     // Catch: Throwable -> L6
        if (r1 != 0) goto L13;
        Disposable r3 = r0.timer;     // Catch: Throwable -> L6
        if (r3 == null) goto L13;
        r3.dispose();     // Catch: Throwable -> L6
    L13:
        long r2 = r1 + 1;     // Catch: Throwable -> L6
        r0.subscriberCount = r2;     // Catch: Throwable -> L6
        if (r0.connected == false) goto L16;
    L18:
        boolean r4 = false;
    L19:
        monitor-exit(this);     // Catch: Throwable -> L6
        this.source.subscribe(new RefCountObserver(r6, this, r0));
        if (r4 == false) goto L28;
        this.source.connect(r0);
        return;
    L28:
        return;
    L16:
        if (r2 != this.n) goto L18;
        r4 = true;
        r0.connected = true;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    public void terminated(RefConnection r9) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if ((this.source instanceof ObservablePublishClassic) == false) goto L14;
        RefConnection r0 = this.connection;     // Catch: Throwable -> L9
        if (r0 == null) goto L11;
        if (r0 != r9) goto L11;
        this.connection = null;     // Catch: Throwable -> L9
        clearTimer(r9);     // Catch: Throwable -> L9
    L11:
        long r5 = r9.subscriberCount - 1;     // Catch: Throwable -> L9
        r9.subscriberCount = r5;     // Catch: Throwable -> L9
        if (r5 != 0) goto L20;
        reset(r9);     // Catch: Throwable -> L9
    L20:
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L14:
        RefConnection r1 = this.connection;     // Catch: Throwable -> L9
        if (r1 == null) goto L20;
        if (r1 != r9) goto L20;
        clearTimer(r9);     // Catch: Throwable -> L9
        long r6 = r9.subscriberCount - 1;     // Catch: Throwable -> L9
        r9.subscriberCount = r6;     // Catch: Throwable -> L9
        if (r6 != 0) goto L20;
        this.connection = null;     // Catch: Throwable -> L9
        reset(r9);     // Catch: Throwable -> L9
        goto L20
    }

    public void timeout(RefConnection r5) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (r5.subscriberCount == 0) goto L6;
    L17:
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L6:
        if (r5 != this.connection) goto L17;
        this.connection = null;     // Catch: Throwable -> L10
        Disposable r0 = r5.get();     // Catch: Throwable -> L10
        DisposableHelper.dispose(r5);     // Catch: Throwable -> L10
        ConnectableObservable<T> r1 = this.source;     // Catch: Throwable -> L10
        if ((r1 instanceof Disposable) == false) goto L13;
        ((Disposable) r1).dispose();     // Catch: Throwable -> L10
        goto L17
    L13:
        if ((r1 instanceof ResettableConnectable) == false) goto L17;
        if (r0 != null) goto L16;
        r5.disconnectedEarly = true;     // Catch: Throwable -> L10
        goto L17
    L16:
        ((ResettableConnectable) r1).resetIf(r0);     // Catch: Throwable -> L10
        goto L17
    }

    public ObservableRefCount(ConnectableObservable<T> r1, int r2, long r3, TimeUnit r5, Scheduler r6) {
        this.source = r1;
        this.n = r2;
        this.timeout = r3;
        this.unit = r5;
        this.scheduler = r6;
    }
}
