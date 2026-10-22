package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class SingleCache<T> extends Single<T> implements SingleObserver<T> {
    static final CacheDisposable[] EMPTY = null;
    static final CacheDisposable[] TERMINATED = null;
    Throwable error;
    final AtomicReference<CacheDisposable<T>[]> observers;
    final SingleSource<? extends T> source;
    T value;
    final AtomicInteger wip;

    static final class CacheDisposable<T> extends AtomicBoolean implements Disposable {
        private static final long serialVersionUID = 7514387411091976596L;
        final SingleObserver<? super T> downstream;
        final SingleCache<T> parent;

        CacheDisposable(SingleObserver<? super T> r1, SingleCache<T> r2) {
            this.downstream = r1;
            this.parent = r2;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (compareAndSet(false, true) == false) goto L6;
            this.parent.remove(this);
            return;
        }
    }

    @Override // io.reactivex.SingleObserver
    public void onSubscribe(Disposable r1) {
    }

    static {
        EMPTY = new CacheDisposable[0];
        TERMINATED = new CacheDisposable[0];
    }

    public SingleCache(SingleSource<? extends T> r2) {
        this.source = r2;
        this.wip = new AtomicInteger();
        this.observers = new AtomicReference(EMPTY);
    }

    @Override // io.reactivex.Single
    protected void subscribeActual(SingleObserver<? super T> r3) {
        CacheDisposable<T> r0 = new CacheDisposable(r3, this);
        r3.onSubscribe(r0);
        if (add(r0) == true) goto L5;
        Throwable r1 = this.error;
        if (r1 == null) goto L14;
        r3.onError(r1);
        return;
    L14:
        r3.onSuccess(this.value);
        return;
    L5:
        if (r0.isDisposed() == false) goto L8;
        remove(r0);
    L8:
        if (this.wip.getAndIncrement() != 0) goto L16;
        this.source.subscribe(this);
        return;
    }

    boolean add(CacheDisposable<T> r5) {
    L2:
        CacheDisposable<T>[] r0 = this.observers.get();
        if (r0 == TERMINATED) goto L4;
        int r1 = r0.length;
        CacheDisposable<T>[] r3 = new CacheDisposable[r1 + 1];
        System.arraycopy(r0, 0, r3, 0, r1);
        r3[r1] = r5;
        if (this.observers.compareAndSet(r0, r3) == false) goto L2;
        return true;
    L4:
        return false;
    }

    void remove(CacheDisposable<T> r7) {
    L2:
        CacheDisposable<T>[] r0 = this.observers.get();
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
        CacheDisposable<T>[] r2 = EMPTY;
    L19:
        if (this.observers.compareAndSet(r0, r2) == false) goto L2;
        return;
    L17:
        CacheDisposable<T>[] r5 = new CacheDisposable[r1 - 1];
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

    @Override // io.reactivex.SingleObserver
    public void onSuccess(T r5) {
        this.value = r5;
        CacheDisposable<T>[] r4 = this.observers.getAndSet(TERMINATED);
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        CacheDisposable<T> r2 = r4[r1];
        if (r2.isDisposed() == true) goto L7;
        r2.downstream.onSuccess(r5);
    L7:
        r1 = r1 + 1;
        goto L3
    }

    @Override // io.reactivex.SingleObserver
    public void onError(Throwable r5) {
        this.error = r5;
        CacheDisposable<T>[] r4 = this.observers.getAndSet(TERMINATED);
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        CacheDisposable<T> r2 = r4[r1];
        if (r2.isDisposed() == true) goto L7;
        r2.downstream.onError(r5);
    L7:
        r1 = r1 + 1;
        goto L3
    }
}
