package io.reactivex.subjects;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import tmsdkobf.b0$$ExternalSyntheticBackport0;

/* JADX INFO: loaded from: classes5.dex */
public final class CompletableSubject extends Completable implements CompletableObserver {
    static final CompletableDisposable[] EMPTY = null;
    static final CompletableDisposable[] TERMINATED = null;
    Throwable error;
    final AtomicReference<CompletableDisposable[]> observers;
    final AtomicBoolean once;

    static final class CompletableDisposable extends AtomicReference<CompletableSubject> implements Disposable {
        private static final long serialVersionUID = -7650903191002190468L;
        final CompletableObserver downstream;

        CompletableDisposable(CompletableObserver r1, CompletableSubject r2) {
            this.downstream = r1;
            lazySet(r2);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            CompletableSubject r0 = getAndSet(null);
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
        EMPTY = new CompletableDisposable[0];
        TERMINATED = new CompletableDisposable[0];
    }

    @CheckReturnValue
    public static CompletableSubject create() {
        return new CompletableSubject();
    }

    CompletableSubject() {
        this.once = new AtomicBoolean();
        this.observers = new AtomicReference(EMPTY);
    }

    @Override // io.reactivex.CompletableObserver
    public void onSubscribe(Disposable r2) {
        if (this.observers.get() != TERMINATED) goto L6;
        r2.dispose();
        return;
    }

    @Override // io.reactivex.CompletableObserver
    public void onError(Throwable r4) {
        ObjectHelper.requireNonNull(r4, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        int r2 = 0;
        if (this.once.compareAndSet(false, true) == false) goto L7;
        this.error = r4;
        CompletableDisposable[] r3 = this.observers.getAndSet(TERMINATED);
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

    @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
    public void onComplete() {
        int r2 = 0;
        if (this.once.compareAndSet(false, true) == false) goto L7;
        CompletableDisposable[] r3 = this.observers.getAndSet(TERMINATED);
        int r0 = r3.length;
    L5:
        if (r2 >= r0) goto L9;
        r3[r2].downstream.onComplete();
        r2 = r2 + 1;
        goto L5
    L9:
        return;
    }

    @Override // io.reactivex.Completable
    protected void subscribeActual(CompletableObserver r3) {
        CompletableDisposable r0 = new CompletableDisposable(r3, this);
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

    boolean add(CompletableDisposable r5) {
    L2:
        CompletableDisposable[] r0 = this.observers.get();
        if (r0 == TERMINATED) goto L4;
        int r1 = r0.length;
        CompletableDisposable[] r3 = new CompletableDisposable[r1 + 1];
        System.arraycopy(r0, 0, r3, 0, r1);
        r3[r1] = r5;
        if (b0$$ExternalSyntheticBackport0.m(this.observers, r0, r3) == false) goto L2;
        return true;
    L4:
        return false;
    }

    void remove(CompletableDisposable r7) {
    L2:
        CompletableDisposable[] r0 = this.observers.get();
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
        CompletableDisposable[] r2 = EMPTY;
    L19:
        if (b0$$ExternalSyntheticBackport0.m(this.observers, r0, r2) == false) goto L2;
        return;
    L17:
        CompletableDisposable[] r5 = new CompletableDisposable[r1 - 1];
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

    public boolean hasComplete() {
        if (this.observers.get() == TERMINATED) goto L5;
    L7:
        return false;
    L5:
        if (this.error != null) goto L7;
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
