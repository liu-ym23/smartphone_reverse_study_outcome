package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class CompletableConcatIterable extends Completable {
    final Iterable<? extends CompletableSource> sources;

    public static final class ConcatInnerObserver extends AtomicInteger implements CompletableObserver {
        private static final long serialVersionUID = -7965400327305809232L;
        final CompletableObserver downstream;
        final SequentialDisposable sd;
        final Iterator<? extends CompletableSource> sources;

        public ConcatInnerObserver(CompletableObserver r1, Iterator<? extends CompletableSource> r2) {
            this.downstream = r1;
            this.sources = r2;
            this.sd = new SequentialDisposable();
        }

        public void next() {
            if (this.sd.isDisposed() == false) goto L6;
            return;
        L6:
            if (getAndIncrement() == 0) goto L8;
            return;
        L8:
            Iterator<? extends CompletableSource> r0 = this.sources;
        L10:
            if (this.sd.isDisposed() == true) goto L11;
            if (r0.hasNext() == false) goto L14;
            ((CompletableSource) ObjectHelper.requireNonNull(r0.next(), "The CompletableSource returned is null")).subscribe(this);
            if (decrementAndGet() != 0) goto L10;
            return;
        L20:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.downstream.onError(th);
            return;
        L14:
            this.downstream.onComplete();
            return;
        L23:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.downstream.onError(th);
            return;
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            next();
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable r1) {
            this.sd.replace(r1);
        }
    }

    public CompletableConcatIterable(Iterable<? extends CompletableSource> r1) {
        this.sources = r1;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver r2) {
        ConcatInnerObserver r0 = new ConcatInnerObserver(r2, (Iterator) ObjectHelper.requireNonNull(this.sources.iterator(), "The iterator returned is null"));
        r2.onSubscribe(r0.sd);
        r0.next();
        return;
    L5:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptyDisposable.error(th, r2);
    }
}
