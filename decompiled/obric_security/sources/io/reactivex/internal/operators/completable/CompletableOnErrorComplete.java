package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;

/* JADX INFO: loaded from: classes5.dex */
public final class CompletableOnErrorComplete extends Completable {
    final Predicate<? super Throwable> predicate;
    final CompletableSource source;

    final class OnError implements CompletableObserver {
        private final CompletableObserver downstream;
        final /* synthetic */ CompletableOnErrorComplete this$0;

        OnError(CompletableOnErrorComplete r1, CompletableObserver r2) {
            this.this$0 = r1;
            this.downstream = r2;
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable r5) {
            if (this.this$0.predicate.test(r5) == false) goto L5;
            this.downstream.onComplete();
            return;
        L5:
            this.downstream.onError(r5);
            return;
        L7:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.downstream.onError(new CompositeException(new Throwable[]{r5, th}));
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable r1) {
            this.downstream.onSubscribe(r1);
        }
    }

    public CompletableOnErrorComplete(CompletableSource r1, Predicate<? super Throwable> r2) {
        this.source = r1;
        this.predicate = r2;
    }

    @Override // io.reactivex.Completable
    protected void subscribeActual(CompletableObserver r3) {
        this.source.subscribe(new OnError(this, r3));
    }
}
