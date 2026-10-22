package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes2.dex */
public final class MaybeOnErrorComplete<T> extends AbstractMaybeWithUpstream<T, T> {
    final Predicate<? super Throwable> predicate;

    public static final class OnErrorCompleteMaybeObserver<T> implements MaybeObserver<T>, Disposable {
        final MaybeObserver<? super T> downstream;
        final Predicate<? super Throwable> predicate;
        Disposable upstream;

        public OnErrorCompleteMaybeObserver(MaybeObserver<? super T> r1, Predicate<? super Throwable> r2) {
            this.downstream = r1;
            this.predicate = r2;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.upstream.dispose();
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
        public void onError(Throwable r3) {
            if (this.predicate.test(r3) == false) goto L5;
            this.downstream.onComplete();
            return;
        L5:
            this.downstream.onError(r3);
            return;
        L7:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.downstream.onError(new CompositeException(new Throwable[]{r3, th}));
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable r2) {
            if (DisposableHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T r1) {
            this.downstream.onSuccess(r1);
        }
    }

    public MaybeOnErrorComplete(MaybeSource<T> r1, Predicate<? super Throwable> r2) {
        super(r1);
        this.predicate = r2;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(MaybeObserver<? super T> r3) {
        this.source.subscribe(new OnErrorCompleteMaybeObserver(r3, this.predicate));
    }
}
