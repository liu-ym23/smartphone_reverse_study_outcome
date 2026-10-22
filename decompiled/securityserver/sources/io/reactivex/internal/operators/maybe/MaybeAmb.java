package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public final class MaybeAmb<T> extends Maybe<T> {
    private final MaybeSource<? extends T>[] sources;
    private final Iterable<? extends MaybeSource<? extends T>> sourcesIterable;

    public static final class AmbMaybeObserver<T> implements MaybeObserver<T> {
        final MaybeObserver<? super T> downstream;
        final CompositeDisposable set;
        Disposable upstream;
        final AtomicBoolean winner;

        public AmbMaybeObserver(MaybeObserver<? super T> r1, CompositeDisposable r2, AtomicBoolean r3) {
            this.downstream = r1;
            this.set = r2;
            this.winner = r3;
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            if (this.winner.compareAndSet(false, true) == false) goto L6;
            this.set.delete(this.upstream);
            this.set.dispose();
            this.downstream.onComplete();
            return;
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable r4) {
            if (this.winner.compareAndSet(false, true) == false) goto L5;
            this.set.delete(this.upstream);
            this.set.dispose();
            this.downstream.onError(r4);
            return;
        L5:
            RxJavaPlugins.onError(r4);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable r1) {
            this.upstream = r1;
            this.set.add(r1);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T r4) {
            if (this.winner.compareAndSet(false, true) == false) goto L6;
            this.set.delete(this.upstream);
            this.set.dispose();
            this.downstream.onSuccess(r4);
            return;
        }
    }

    public MaybeAmb(MaybeSource<? extends T>[] r1, Iterable<? extends MaybeSource<? extends T>> r2) {
        this.sources = r1;
        this.sourcesIterable = r2;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(MaybeObserver<? super T> r8) {
        MaybeSource<? extends T>[] r0 = this.sources;
        if (r0 != null) goto L21;
        r0 = new MaybeSource[8];
        Iterator<? extends MaybeSource<? extends T>> r7 = this.sourcesIterable.iterator();     // Catch: Throwable -> L12
        int r2 = 0;
    L7:
        if (r7.hasNext() == false) goto L22;
        MaybeSource<? extends T> r3 = r7.next();     // Catch: Throwable -> L12
        if (r3 == null) goto L10;
        if (r2 != r0.length) goto L17;
        MaybeSource<? extends T>[] r4 = new MaybeSource[(r2 >> 2) + r2];     // Catch: Throwable -> L12
        System.arraycopy(r0, 0, r4, 0, r2);     // Catch: Throwable -> L12
        r0 = r4;
    L17:
        int r5 = r2 + 1;     // Catch: Throwable -> L12
        r0[r2] = r3;     // Catch: Throwable -> L12
        r2 = r5;
        goto L7
    L10:
        EmptyDisposable.error(new NullPointerException("One of the sources is null"), r8);     // Catch: Throwable -> L12
        return;
    L22:
        CompositeDisposable r9 = new CompositeDisposable();
        r8.onSubscribe(r9);
        AtomicBoolean r6 = new AtomicBoolean();
        int r10 = 0;
    L23:
        if (r10 >= r2) goto L34;
        MaybeSource<? extends T> r11 = r0[r10];
        if (r9.isDisposed() == true) goto L26;
        if (r11 == null) goto L28;
        r11.subscribe(new AmbMaybeObserver(r8, r9, r6));
        r10 = r10 + 1;
        goto L23
    L28:
        r9.dispose();
        NullPointerException r12 = new NullPointerException("One of the MaybeSources is null");
        if (r6.compareAndSet(false, true) == false) goto L31;
        r8.onError(r12);
        return;
    L31:
        RxJavaPlugins.onError(r12);
        return;
    L26:
        return;
    L34:
        if (r2 != 0) goto L45;
        r8.onComplete();
        return;
    L45:
        return;
    L12:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptyDisposable.error(th, r8);
        return;
    L21:
        r2 = r0.length;
        goto L22
    }
}
