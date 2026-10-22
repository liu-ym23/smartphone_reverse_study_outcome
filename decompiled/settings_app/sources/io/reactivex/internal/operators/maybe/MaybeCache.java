package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class MaybeCache<T> extends Maybe<T> implements MaybeObserver<T> {
    static final CacheDisposable[] EMPTY = null;
    static final CacheDisposable[] TERMINATED = null;
    Throwable error;
    final AtomicReference<CacheDisposable<T>[]> observers;
    final AtomicReference<MaybeSource<T>> source;
    T value;

    static final class CacheDisposable<T> extends AtomicReference<MaybeCache<T>> implements Disposable {
        private static final long serialVersionUID = -5791853038359966195L;
        final MaybeObserver<? super T> downstream;

        CacheDisposable(MaybeObserver<? super T> r1, MaybeCache<T> r2) {
            super(r2);
            this.downstream = r1;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            MaybeCache<T> r0 = getAndSet(null);
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

    @Override // io.reactivex.MaybeObserver
    public void onSubscribe(Disposable r1) {
    }

    static {
        EMPTY = new CacheDisposable[0];
        TERMINATED = new CacheDisposable[0];
    }

    public MaybeCache(MaybeSource<T> r2) {
        this.source = new AtomicReference(r2);
        this.observers = new AtomicReference(EMPTY);
    }

    @Override // io.reactivex.Maybe
    protected void subscribeActual(MaybeObserver<? super T> r3) {
        CacheDisposable<T> r0 = new CacheDisposable(r3, this);
        r3.onSubscribe(r0);
        if (add(r0) == false) goto L13;
        if (r0.isDisposed() == false) goto L8;
        remove(r0);
        return;
    L8:
        MaybeSource<T> r4 = this.source.getAndSet(null);
        if (r4 == null) goto L22;
        r4.subscribe(this);
        return;
    L22:
        return;
    L13:
        if (r0.isDisposed() == true) goto L23;
        Throwable r1 = this.error;
        if (r1 == null) goto L17;
        r3.onError(r1);
        return;
    L17:
        T r2 = this.value;
        if (r2 == null) goto L20;
        r3.onSuccess(r2);
        return;
    L20:
        r3.onComplete();
        return;
    }

    @Override // io.reactivex.MaybeObserver
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

    @Override // io.reactivex.MaybeObserver
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

    @Override // io.reactivex.MaybeObserver
    public void onComplete() {
        CacheDisposable<T>[] r4 = this.observers.getAndSet(TERMINATED);
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        CacheDisposable<T> r2 = r4[r1];
        if (r2.isDisposed() == true) goto L7;
        r2.downstream.onComplete();
    L7:
        r1 = r1 + 1;
        goto L3
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
}
