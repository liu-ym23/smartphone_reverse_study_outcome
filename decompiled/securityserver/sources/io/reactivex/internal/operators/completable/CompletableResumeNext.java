package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class CompletableResumeNext extends Completable {
    final Function<? super Throwable, ? extends CompletableSource> errorMapper;
    final CompletableSource source;

    public static final class ResumeNextObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
        private static final long serialVersionUID = 5018523762564524046L;
        final CompletableObserver downstream;
        final Function<? super Throwable, ? extends CompletableSource> errorMapper;
        boolean once;

        public ResumeNextObserver(CompletableObserver r1, Function<? super Throwable, ? extends CompletableSource> r2) {
            this.downstream = r1;
            this.errorMapper = r2;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable r3) {
            if (this.once == false) goto L6;
            this.downstream.onError(r3);
            return;
        L6:
            this.once = true;
            ((CompletableSource) ObjectHelper.requireNonNull(this.errorMapper.apply(r3), "The errorMapper returned a null CompletableSource")).subscribe(this);
            return;
        L10:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.downstream.onError(new CompositeException(new Throwable[]{r3, th}));
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable r1) {
            DisposableHelper.replace(this, r1);
        }
    }

    public CompletableResumeNext(CompletableSource r1, Function<? super Throwable, ? extends CompletableSource> r2) {
        this.source = r1;
        this.errorMapper = r2;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver r3) {
        ResumeNextObserver r0 = new ResumeNextObserver(r3, this.errorMapper);
        r3.onSubscribe(r0);
        this.source.subscribe(r0);
    }
}
