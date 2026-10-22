package io.reactivex.subjects;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import tmsdkobf.b0$$ExternalSyntheticBackport0;

/* JADX INFO: loaded from: classes5.dex */
public final class SingleSubject<T> extends Single<T> implements SingleObserver<T> {
    static final SingleDisposable[] EMPTY = null;
    static final SingleDisposable[] TERMINATED = null;
    Throwable error;
    final AtomicReference<SingleDisposable<T>[]> observers;
    final AtomicBoolean once;
    T value;

    static final class SingleDisposable<T> extends AtomicReference<SingleSubject<T>> implements Disposable {
        private static final long serialVersionUID = -7650903191002190468L;
        final SingleObserver<? super T> downstream;

        SingleDisposable(SingleObserver<? super T> r1, SingleSubject<T> r2) {
            this.downstream = r1;
            lazySet(r2);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            SingleSubject<T> r0 = getAndSet(null);
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

    static {
        EMPTY = new SingleDisposable[0];
        TERMINATED = new SingleDisposable[0];
    }

    @CheckReturnValue
    public static <T> SingleSubject<T> create() {
        return new SingleSubject();
    }

    SingleSubject() {
        this.once = new AtomicBoolean();
        this.observers = new AtomicReference(EMPTY);
    }

    @Override // io.reactivex.SingleObserver
    public void onSubscribe(Disposable r2) {
        if (this.observers.get() != TERMINATED) goto L6;
        r2.dispose();
        return;
    }

    @Override // io.reactivex.SingleObserver
    public void onSuccess(T r4) {
        ObjectHelper.requireNonNull(r4, "onSuccess called with null. Null values are generally not allowed in 2.x operators and sources.");
        int r2 = 0;
        if (this.once.compareAndSet(false, true) == false) goto L7;
        this.value = r4;
        SingleDisposable<T>[] r3 = this.observers.getAndSet(TERMINATED);
        int r0 = r3.length;
    L5:
        if (r2 >= r0) goto L9;
        r3[r2].downstream.onSuccess(r4);
        r2 = r2 + 1;
        goto L5
    L9:
        return;
    }

    @Override // io.reactivex.SingleObserver
    public void onError(Throwable r4) {
        ObjectHelper.requireNonNull(r4, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        int r2 = 0;
        if (this.once.compareAndSet(false, true) == false) goto L7;
        this.error = r4;
        SingleDisposable<T>[] r3 = this.observers.getAndSet(TERMINATED);
        int r0 = r3.length;
    L5:
        if (r2 >= r0) goto L10;
        r3[r2].downstream.onError(r4);
        r2 = r2 + 1;
        goto L5
    L10:
        return;
    L7:
        RxJavaPlugins.onError(r4);
    }

    @Override // io.reactivex.Single
    protected void subscribeActual(SingleObserver<? super T> r3) {
        SingleDisposable<T> r0 = new SingleDisposable(r3, this);
        r3.onSubscribe(r0);
        if (add(r0) == true) goto L5;
        Throwable r1 = this.error;
        if (r1 == null) goto L10;
        r3.onError(r1);
        return;
    L10:
        r3.onSuccess(this.value);
        return;
    L5:
        if (r0.isDisposed() == false) goto L12;
        remove(r0);
        return;
    }

    boolean add(SingleDisposable<T> r5) {
    L2:
        SingleDisposable<T>[] r0 = this.observers.get();
        if (r0 == TERMINATED) goto L4;
        int r1 = r0.length;
        SingleDisposable[] r3 = new SingleDisposable[r1 + 1];
        System.arraycopy(r0, 0, r3, 0, r1);
        r3[r1] = r5;
        if (b0$$ExternalSyntheticBackport0.m(this.observers, r0, r3) == false) goto L2;
        return true;
    L4:
        return false;
    }

    void remove(SingleDisposable<T> r7) {
    L2:
        SingleDisposable<T>[] r0 = this.observers.get();
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
        SingleDisposable[] r2 = EMPTY;
    L19:
        if (b0$$ExternalSyntheticBackport0.m(this.observers, r0, r2) == false) goto L2;
        return;
    L17:
        SingleDisposable[] r5 = new SingleDisposable[r1 - 1];
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

    public T getValue() {
        if (this.observers.get() == TERMINATED) goto L5;
        return null;
    L5:
        return this.value;
    }

    public boolean hasValue() {
        if (this.observers.get() == TERMINATED) goto L5;
    L7:
        return false;
    L5:
        if (this.value == null) goto L7;
        return true;
    }

    public Throwable getThrowable() {
        if (this.observers.get() == TERMINATED) goto L5;
        return null;
    L5:
        return this.error;
    }

    public boolean hasThrowable() {
        if (this.observers.get() == TERMINATED) goto L5;
    L7:
        return false;
    L5:
        if (this.error == null) goto L7;
        return true;
    }

    public boolean hasObservers() {
        if (this.observers.get().length == 0) goto L5;
        return true;
    L5:
        return false;
    }

    int observerCount() {
        return this.observers.get().length;
    }
}
