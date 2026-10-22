package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.ResettableConnectable;
import io.reactivex.internal.fuseable.HasUpstreamObservableSource;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observables.ConnectableObservable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import tmsdkobf.b0$$ExternalSyntheticBackport0;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservablePublishAlt<T> extends ConnectableObservable<T> implements HasUpstreamObservableSource<T>, ResettableConnectable {
    final AtomicReference<PublishConnection<T>> current;
    final ObservableSource<T> source;

    static final class InnerDisposable<T> extends AtomicReference<PublishConnection<T>> implements Disposable {
        private static final long serialVersionUID = 7463222674719692880L;
        final Observer<? super T> downstream;

        public InnerDisposable(Observer<? super T> r1, PublishConnection<T> r2) {
            this.downstream = r1;
            lazySet(r2);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            PublishConnection<T> r0 = getAndSet(null);
            if (r0 == null) goto L6;
            r0.remove(this);
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (get() != null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static final class PublishConnection<T> extends AtomicReference<InnerDisposable<T>[]> implements Observer<T>, Disposable {
        static final InnerDisposable[] EMPTY = null;
        static final InnerDisposable[] TERMINATED = null;
        private static final long serialVersionUID = -3251430252873581268L;
        final AtomicBoolean connect;
        final AtomicReference<PublishConnection<T>> current;
        Throwable error;
        final AtomicReference<Disposable> upstream;

        static {
            EMPTY = new InnerDisposable[0];
            TERMINATED = new InnerDisposable[0];
        }

        public PublishConnection(AtomicReference<PublishConnection<T>> r2) {
            this.connect = new AtomicBoolean();
            this.current = r2;
            this.upstream = new AtomicReference();
            lazySet(EMPTY);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            getAndSet(TERMINATED);
            b0$$ExternalSyntheticBackport0.m(this.current, this, null);
            DisposableHelper.dispose(this.upstream);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (get() != TERMINATED) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r1) {
            DisposableHelper.setOnce(this.upstream, r1);
        }

        @Override // io.reactivex.Observer
        public void onNext(T r4) {
            InnerDisposable<T>[] r3 = get();
            int r0 = r3.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            r3[r1].downstream.onNext(r4);
            r1 = r1 + 1;
            goto L3
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r4) {
            this.error = r4;
            this.upstream.lazySet(DisposableHelper.DISPOSED);
            InnerDisposable<T>[] r3 = getAndSet(TERMINATED);
            int r0 = r3.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            r3[r1].downstream.onError(r4);
            r1 = r1 + 1;
            goto L3
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.upstream.lazySet(DisposableHelper.DISPOSED);
            InnerDisposable<T>[] r3 = getAndSet(TERMINATED);
            int r0 = r3.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            r3[r1].downstream.onComplete();
            r1 = r1 + 1;
            goto L3
        }

        public boolean add(InnerDisposable<T> r5) {
        L2:
            InnerDisposable<T>[] r0 = get();
            if (r0 == TERMINATED) goto L4;
            int r1 = r0.length;
            InnerDisposable[] r3 = new InnerDisposable[r1 + 1];
            System.arraycopy(r0, 0, r3, 0, r1);
            r3[r1] = r5;
            if (compareAndSet(r0, r3) == false) goto L2;
            return true;
        L4:
            return false;
        }

        public void remove(InnerDisposable<T> r7) {
        L2:
            InnerDisposable<T>[] r0 = get();
            int r1 = r0.length;
            if (r1 == 0) goto L4;
            int r3 = 0;
        L6:
            if (r3 >= r1) goto L11;
            if (r0[r3] == r7) goto L12;
            r3 = r3 + 1;
        L12:
            if (r3 < 0) goto L13;
            InnerDisposable[] r4 = EMPTY;
            if (r1 == 1) goto L18;
            r4 = new InnerDisposable[r1 - 1];
            System.arraycopy(r0, 0, r4, 0, r3);
            System.arraycopy(r0, r3 + 1, r4, r3, (r1 - r3) - 1);
        L18:
            if (compareAndSet(r0, r4) == false) goto L2;
            return;
        L13:
            return;
        L11:
            r3 = -1;
            goto L12
        }
    }

    public ObservablePublishAlt(ObservableSource<T> r1) {
        this.source = r1;
        this.current = new AtomicReference();
    }

    @Override // io.reactivex.observables.ConnectableObservable
    public void connect(Consumer<? super Disposable> r5) {
    L2:
        PublishConnection<T> r0 = this.current.get();
        if (r0 != null) goto L5;
    L6:
        PublishConnection<T> r1 = new PublishConnection(this.current);
        if (b0$$ExternalSyntheticBackport0.m(this.current, r0, r1) == false) goto L2;
        r0 = r1;
    L10:
        boolean r2 = false;
        if (r0.connect.get() == false) goto L13;
    L22:
        r5.accept(r0);     // Catch: Throwable -> L19
        if (r2 == false) goto L27;
        this.source.subscribe(r0);
        return;
    L27:
        return;
    L19:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        throw ExceptionHelper.wrapOrThrow(th);
    L13:
        if (r0.connect.compareAndSet(false, true) == false) goto L22;
        r2 = true;
        goto L22
    L5:
        if (r0.isDisposed() == false) goto L10;
        goto L6
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> r4) {
    L2:
        PublishConnection<T> r0 = this.current.get();
        if (r0 != null) goto L8;
        PublishConnection<T> r1 = new PublishConnection(this.current);
        if (b0$$ExternalSyntheticBackport0.m(this.current, r0, r1) == false) goto L2;
        r0 = r1;
    L8:
        InnerDisposable<T> r3 = new InnerDisposable(r4, r0);
        r4.onSubscribe(r3);
        if (r0.add(r3) == true) goto L11;
        Throwable r5 = r0.error;
        if (r5 == null) goto L17;
        r4.onError(r5);
        return;
    L17:
        r4.onComplete();
        return;
    L11:
        if (r3.isDisposed() == false) goto L22;
        r0.remove(r3);
        return;
    }

    @Override // io.reactivex.internal.disposables.ResettableConnectable
    public void resetIf(Disposable r2) {
        b0$$ExternalSyntheticBackport0.m(this.current, (PublishConnection) r2, null);
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamObservableSource
    public ObservableSource<T> source() {
        return this.source;
    }
}
