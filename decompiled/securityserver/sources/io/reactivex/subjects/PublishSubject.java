package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class PublishSubject<T> extends Subject<T> {
    static final PublishDisposable[] EMPTY = null;
    static final PublishDisposable[] TERMINATED = null;
    Throwable error;
    final AtomicReference<PublishDisposable<T>[]> subscribers;

    public static final class PublishDisposable<T> extends AtomicBoolean implements Disposable {
        private static final long serialVersionUID = 3562861878281475070L;
        final Observer<? super T> downstream;
        final PublishSubject<T> parent;

        public PublishDisposable(Observer<? super T> r1, PublishSubject<T> r2) {
            this.downstream = r1;
            this.parent = r2;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (compareAndSet(false, true) == false) goto L6;
            this.parent.remove(this);
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get();
        }

        public void onComplete() {
            if (get() == true) goto L6;
            this.downstream.onComplete();
            return;
        }

        public void onError(Throwable r2) {
            if (get() == false) goto L5;
            RxJavaPlugins.onError(r2);
            return;
        L5:
            this.downstream.onError(r2);
        }

        public void onNext(T r2) {
            if (get() == true) goto L6;
            this.downstream.onNext(r2);
            return;
        }
    }

    static {
        TERMINATED = new PublishDisposable[0];
        EMPTY = new PublishDisposable[0];
    }

    public PublishSubject() {
        this.subscribers = new AtomicReference(EMPTY);
    }

    @CheckReturnValue
    @NonNull
    public static <T> PublishSubject<T> create() {
        return new PublishSubject();
    }

    public boolean add(PublishDisposable<T> r5) {
    L2:
        PublishDisposable<T>[] r0 = this.subscribers.get();
        if (r0 == TERMINATED) goto L4;
        int r1 = r0.length;
        PublishDisposable<T>[] r3 = new PublishDisposable[r1 + 1];
        System.arraycopy(r0, 0, r3, 0, r1);
        r3[r1] = r5;
        if (this.subscribers.compareAndSet(r0, r3) == false) goto L2;
        return true;
    L4:
        return false;
    }

    @Override // io.reactivex.subjects.Subject
    @Nullable
    public Throwable getThrowable() {
        if (this.subscribers.get() == TERMINATED) goto L5;
        return null;
    L5:
        return this.error;
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

    @Override // io.reactivex.Observer
    public void onComplete() {
        PublishDisposable<T>[] r0 = this.subscribers.get();
        PublishDisposable<T>[] r1 = TERMINATED;
        if (r0 != r1) goto L5;
        return;
    L5:
        PublishDisposable<T>[] r3 = this.subscribers.getAndSet(r1);
        int r2 = r3.length;
        int r4 = 0;
    L6:
        if (r4 >= r2) goto L8;
        r3[r4].onComplete();
        r4 = r4 + 1;
        goto L6
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r4) {
        ObjectHelper.requireNonNull(r4, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        PublishDisposable<T>[] r0 = this.subscribers.get();
        PublishDisposable<T>[] r1 = TERMINATED;
        if (r0 != r1) goto L6;
        RxJavaPlugins.onError(r4);
        return;
    L6:
        this.error = r4;
        PublishDisposable<T>[] r3 = this.subscribers.getAndSet(r1);
        int r2 = r3.length;
        int r5 = 0;
    L7:
        if (r5 >= r2) goto L9;
        r3[r5].onError(r4);
        r5 = r5 + 1;
        goto L7
    }

    @Override // io.reactivex.Observer
    public void onNext(T r4) {
        ObjectHelper.requireNonNull(r4, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        PublishDisposable<T>[] r3 = this.subscribers.get();
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r3[r1].onNext(r4);
        r1 = r1 + 1;
        goto L3
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r2) {
        if (this.subscribers.get() != TERMINATED) goto L6;
        r2.dispose();
        return;
    }

    public void remove(PublishDisposable<T> r7) {
    L2:
        PublishDisposable<T>[] r0 = this.subscribers.get();
        if (r0 == TERMINATED) goto L22;
        if (r0 == EMPTY) goto L30;
        int r1 = r0.length;
        int r3 = 0;
    L8:
        if (r3 >= r1) goto L13;
        if (r0[r3] == r7) goto L14;
        r3 = r3 + 1;
    L14:
        if (r3 < 0) goto L15;
        if (r1 != 1) goto L19;
        PublishDisposable<T>[] r2 = EMPTY;
    L21:
        if (this.subscribers.compareAndSet(r0, r2) == false) goto L2;
        return;
    L19:
        PublishDisposable<T>[] r5 = new PublishDisposable[r1 - 1];
        System.arraycopy(r0, 0, r5, 0, r3);
        System.arraycopy(r0, r3 + 1, r5, r3, (r1 - r3) - 1);
        r2 = r5;
        goto L21
    L15:
        return;
    L13:
        r3 = -1;
        goto L14
    L30:
        return;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> r3) {
        PublishDisposable<T> r0 = new PublishDisposable(r3, this);
        r3.onSubscribe(r0);
        if (add(r0) == true) goto L5;
        Throwable r2 = this.error;
        if (r2 == null) goto L10;
        r3.onError(r2);
        return;
    L10:
        r3.onComplete();
        return;
    L5:
        if (r0.isDisposed() == false) goto L12;
        remove(r0);
        return;
    }
}
