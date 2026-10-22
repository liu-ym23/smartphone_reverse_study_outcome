package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicQueueDisposable;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public final class MaybeFlatMapIterableObservable<T, R> extends Observable<R> {
    final Function<? super T, ? extends Iterable<? extends R>> mapper;
    final MaybeSource<T> source;

    static final class FlatMapIterableObserver<T, R> extends BasicQueueDisposable<R> implements MaybeObserver<T> {
        volatile boolean cancelled;
        final Observer<? super R> downstream;
        volatile Iterator<? extends R> it;
        final Function<? super T, ? extends Iterable<? extends R>> mapper;
        boolean outputFused;
        Disposable upstream;

        FlatMapIterableObserver(Observer<? super R> r1, Function<? super T, ? extends Iterable<? extends R>> r2) {
            this.downstream = r1;
            this.mapper = r2;
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable r2) {
            if (DisposableHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T r3) {
            Observer<? super R> r0 = this.downstream;
            Iterator<? extends R> r4 = this.mapper.apply(r3).iterator();     // Catch: Throwable -> L28
            if (r4.hasNext() == true) goto L7;
            r0.onComplete();
            return;
        L7:
            this.it = r4;
            if (this.outputFused == false) goto L12;
            r0.onNext(null);
            r0.onComplete();
            return;
        L12:
            if (this.cancelled == true) goto L13;
            r0.onNext(r4.next());
            if (this.cancelled == true) goto L17;
            if (r4.hasNext() == true) goto L12;
            r0.onComplete();
            return;
        L22:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r0.onError(th);
            return;
        L17:
            return;
        L25:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r0.onError(th);
            return;
        L13:
            return;
        L28:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r0.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable r2) {
            this.upstream = DisposableHelper.DISPOSED;
            this.downstream.onError(r2);
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.upstream = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int r2) {
            if ((r2 & 2) == 0) goto L6;
            this.outputFused = true;
            return 2;
        L6:
            return 0;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.it = null;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            if (this.it != null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public R poll() throws Exception {
            Iterator<? extends R> r0 = this.it;
            if (r0 == null) goto L8;
            R r2 = (R) ObjectHelper.requireNonNull(r0.next(), "The iterator returned a null value");
            if (r0.hasNext() == true) goto L7;
            this.it = null;
        L7:
            return r2;
        L8:
            return null;
        }
    }

    public MaybeFlatMapIterableObservable(MaybeSource<T> r1, Function<? super T, ? extends Iterable<? extends R>> r2) {
        this.source = r1;
        this.mapper = r2;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super R> r3) {
        this.source.subscribe(new FlatMapIterableObserver(r3, this.mapper));
    }
}
