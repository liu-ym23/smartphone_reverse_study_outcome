package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes2.dex */
public final class MaybeFilter<T> extends AbstractMaybeWithUpstream<T, T> {
    final Predicate<? super T> predicate;

    public static final class FilterMaybeObserver<T> implements MaybeObserver<T>, Disposable {
        final MaybeObserver<? super T> downstream;
        final Predicate<? super T> predicate;
        Disposable upstream;

        public FilterMaybeObserver(MaybeObserver<? super T> r1, Predicate<? super T> r2) {
            this.downstream = r1;
            this.predicate = r2;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Disposable r0 = this.upstream;
            this.upstream = DisposableHelper.DISPOSED;
            r0.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream.isDisposed();
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
        public void onSubscribe(Disposable r2) {
            if (DisposableHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T r2) {
            if (this.predicate.test(r2) == false) goto L5;
            this.downstream.onSuccess(r2);
            return;
        L5:
            this.downstream.onComplete();
            return;
        L7:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.downstream.onError(th);
        }
    }

    public MaybeFilter(MaybeSource<T> r1, Predicate<? super T> r2) {
        super(r1);
        this.predicate = r2;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(MaybeObserver<? super T> r3) {
        this.source.subscribe(new FilterMaybeObserver(r3, this.predicate));
    }
}
