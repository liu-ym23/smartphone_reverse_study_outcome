package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class MaybeDoOnEvent<T> extends AbstractMaybeWithUpstream<T, T> {
    final BiConsumer<? super T, ? super Throwable> onEvent;

    static final class DoOnEventMaybeObserver<T> implements MaybeObserver<T>, Disposable {
        final MaybeObserver<? super T> downstream;
        final BiConsumer<? super T, ? super Throwable> onEvent;
        Disposable upstream;

        DoOnEventMaybeObserver(MaybeObserver<? super T> r1, BiConsumer<? super T, ? super Throwable> r2) {
            this.downstream = r1;
            this.onEvent = r2;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.upstream.dispose();
            this.upstream = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream.isDisposed();
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
            this.upstream = DisposableHelper.DISPOSED;
            this.onEvent.accept(r3, null);     // Catch: Throwable -> L6
            this.downstream.onSuccess(r3);
            return;
        L6:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.downstream.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable r5) {
            this.upstream = DisposableHelper.DISPOSED;
            this.onEvent.accept(null, r5);     // Catch: Throwable -> L5
        L7:
            this.downstream.onError(r5);
            return;
        L5:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r5 = new CompositeException(new Throwable[]{r5, th});
            goto L7
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.upstream = DisposableHelper.DISPOSED;
            this.onEvent.accept(null, null);     // Catch: Throwable -> L6
            this.downstream.onComplete();
            return;
        L6:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.downstream.onError(th);
        }
    }

    public MaybeDoOnEvent(MaybeSource<T> r1, BiConsumer<? super T, ? super Throwable> r2) {
        super(r1);
        this.onEvent = r2;
    }

    @Override // io.reactivex.Maybe
    protected void subscribeActual(MaybeObserver<? super T> r3) {
        this.source.subscribe(new DoOnEventMaybeObserver(r3, this.onEvent));
    }
}
