package io.reactivex.internal.operators.maybe;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class MaybeFlatMapCompletable<T> extends Completable {
    final Function<? super T, ? extends CompletableSource> mapper;
    final MaybeSource<T> source;

    public static final class FlatMapCompletableObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, CompletableObserver, Disposable {
        private static final long serialVersionUID = -2177128922851101253L;
        final CompletableObserver downstream;
        final Function<? super T, ? extends CompletableSource> mapper;

        public FlatMapCompletableObserver(CompletableObserver r1, Function<? super T, ? extends CompletableSource> r2) {
            this.downstream = r1;
            this.mapper = r2;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable r1) {
            DisposableHelper.replace(this, r1);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T r2) {
            CompletableSource r3 = (CompletableSource) ObjectHelper.requireNonNull(this.mapper.apply(r2), "The mapper returned a null CompletableSource");     // Catch: Throwable -> L7
            if (isDisposed() == true) goto L12;
            r3.subscribe(this);
            return;
        L12:
            return;
        L7:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            onError(th);
        }
    }

    public MaybeFlatMapCompletable(MaybeSource<T> r1, Function<? super T, ? extends CompletableSource> r2) {
        this.source = r1;
        this.mapper = r2;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver r3) {
        FlatMapCompletableObserver r0 = new FlatMapCompletableObserver(r3, this.mapper);
        r3.onSubscribe(r0);
        this.source.subscribe(r0);
    }
}
