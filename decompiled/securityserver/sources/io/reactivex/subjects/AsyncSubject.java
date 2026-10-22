package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class AsyncSubject<T> extends Subject<T> {
    static final AsyncDisposable[] EMPTY = null;
    static final AsyncDisposable[] TERMINATED = null;
    Throwable error;
    final AtomicReference<AsyncDisposable<T>[]> subscribers;
    T value;

    public static final class AsyncDisposable<T> extends DeferredScalarDisposable<T> {
        private static final long serialVersionUID = 5629876084736248016L;
        final AsyncSubject<T> parent;

        public AsyncDisposable(Observer<? super T> r1, AsyncSubject<T> r2) {
            super(r1);
            this.parent = r2;
        }

        @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.disposables.Disposable
        public void dispose() {
            if (tryDispose() == false) goto L6;
            this.parent.remove(this);
            return;
        }

        public void onComplete() {
            if (isDisposed() == true) goto L6;
            this.downstream.onComplete();
            return;
        }

        public void onError(Throwable r2) {
            if (isDisposed() == false) goto L5;
            RxJavaPlugins.onError(r2);
            return;
        L5:
            this.downstream.onError(r2);
        }
    }

    static {
        EMPTY = new AsyncDisposable[0];
        TERMINATED = new AsyncDisposable[0];
    }

    public AsyncSubject() {
        this.subscribers = new AtomicReference(EMPTY);
    }

    @CheckReturnValue
    @NonNull
    public static <T> AsyncSubject<T> create() {
        return new AsyncSubject();
    }

    public boolean add(AsyncDisposable<T> r5) {
    L2:
        AsyncDisposable<T>[] r0 = this.subscribers.get();
        if (r0 == TERMINATED) goto L4;
        int r1 = r0.length;
        AsyncDisposable<T>[] r3 = new AsyncDisposable[r1 + 1];
        System.arraycopy(r0, 0, r3, 0, r1);
        r3[r1] = r5;
        if (this.subscribers.compareAndSet(r0, r3) == false) goto L2;
        return true;
    L4:
        return false;
    }

    @Override // io.reactivex.subjects.Subject
    public Throwable getThrowable() {
        if (this.subscribers.get() == TERMINATED) goto L7;
        return null;
    L7:
        return this.error;
    }

    @Nullable
    public T getValue() {
        if (this.subscribers.get() == TERMINATED) goto L7;
        return null;
    L7:
        return this.value;
    }

    @Deprecated
    public Object[] getValues() {
        T r2 = getValue();
        if (r2 == null) goto L6;
        return new Object[]{r2};
    L6:
        return new Object[0];
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasComplete() {
        if (this.subscribers.get() == TERMINATED) goto L5;
    L7:
        return false;
    L5:
        if (this.error != null) goto L7;
        return true;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasObservers() {
        if (this.subscribers.get().length == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasThrowable() {
        if (this.subscribers.get() == TERMINATED) goto L5;
    L7:
        return false;
    L5:
        if (this.error == null) goto L7;
        return true;
    }

    public boolean hasValue() {
        if (this.subscribers.get() == TERMINATED) goto L5;
    L7:
        return false;
    L5:
        if (this.value == null) goto L7;
        return true;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        AsyncDisposable<T>[] r0 = this.subscribers.get();
        AsyncDisposable<T>[] r1 = TERMINATED;
        if (r0 != r1) goto L5;
        return;
    L5:
        T r2 = this.value;
        AsyncDisposable<T>[] r4 = this.subscribers.getAndSet(r1);
        int r3 = 0;
        if (r2 != null) goto L10;
        int r5 = r4.length;
    L8:
        if (r3 >= r5) goto L13;
        r4[r3].onComplete();
        r3 = r3 + 1;
        goto L8
    L13:
        return;
    L10:
        int r6 = r4.length;
    L11:
        if (r3 >= r6) goto L16;
        r4[r3].complete(r2);
        r3 = r3 + 1;
        goto L11
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r4) {
        ObjectHelper.requireNonNull(r4, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        AsyncDisposable<T>[] r0 = this.subscribers.get();
        AsyncDisposable<T>[] r1 = TERMINATED;
        if (r0 != r1) goto L6;
        RxJavaPlugins.onError(r4);
        return;
    L6:
        this.value = null;
        this.error = r4;
        AsyncDisposable<T>[] r3 = this.subscribers.getAndSet(r1);
        int r2 = r3.length;
        int r5 = 0;
    L7:
        if (r5 >= r2) goto L9;
        r3[r5].onError(r4);
        r5 = r5 + 1;
        goto L7
    }

    @Override // io.reactivex.Observer
    public void onNext(T r3) {
        ObjectHelper.requireNonNull(r3, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.subscribers.get() != TERMINATED) goto L5;
        return;
    L5:
        this.value = r3;
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r2) {
        if (this.subscribers.get() != TERMINATED) goto L6;
        r2.dispose();
        return;
    }

    public void remove(AsyncDisposable<T> r7) {
    L2:
        AsyncDisposable<T>[] r0 = this.subscribers.get();
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
        AsyncDisposable<T>[] r2 = EMPTY;
    L19:
        if (this.subscribers.compareAndSet(r0, r2) == false) goto L2;
        return;
    L17:
        AsyncDisposable<T>[] r5 = new AsyncDisposable[r1 - 1];
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

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> r3) {
        AsyncDisposable<T> r0 = new AsyncDisposable(r3, this);
        r3.onSubscribe(r0);
        if (add(r0) == true) goto L5;
        Throwable r1 = this.error;
        if (r1 == null) goto L10;
        r3.onError(r1);
        return;
    L10:
        T r2 = this.value;
        if (r2 == null) goto L13;
        r0.complete(r2);
        return;
    L13:
        r0.onComplete();
        return;
    L5:
        if (r0.isDisposed() == false) goto L15;
        remove(r0);
        return;
    }

    @Deprecated
    public T[] getValues(T[] r5) {
        T r4 = getValue();
        if (r4 != null) goto L9;
        if (r5.length == 0) goto L7;
        r5[0] = null;
    L7:
        return r5;
    L9:
        if (r5.length != 0) goto L11;
        r5 = (T[]) Arrays.copyOf(r5, 1);
    L11:
        r5[0] = r4;
        if (r5.length == 1) goto L14;
        r5[1] = null;
    L14:
        return r5;
    }
}
