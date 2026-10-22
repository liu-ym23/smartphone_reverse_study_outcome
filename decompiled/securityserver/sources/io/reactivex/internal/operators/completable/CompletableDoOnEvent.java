package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes2.dex */
public final class CompletableDoOnEvent extends Completable {
    final Consumer<? super Throwable> onEvent;
    final CompletableSource source;

    public final class DoOnEvent implements CompletableObserver {
        private final CompletableObserver observer;
        final /* synthetic */ CompletableDoOnEvent this$0;

        public DoOnEvent(CompletableDoOnEvent r1, CompletableObserver r2) {
            this.this$0 = r1;
            this.observer = r2;
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            this.this$0.onEvent.accept(null);     // Catch: Throwable -> L5
            this.observer.onComplete();
            return;
        L5:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.observer.onError(th);
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable r3) {
            this.this$0.onEvent.accept(r3);     // Catch: Throwable -> L4
        L6:
            this.observer.onError(r3);
            return;
        L4:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r3 = new CompositeException(new Throwable[]{r3, th});
            goto L6
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable r1) {
            this.observer.onSubscribe(r1);
        }
    }

    public CompletableDoOnEvent(CompletableSource r1, Consumer<? super Throwable> r2) {
        this.source = r1;
        this.onEvent = r2;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver r3) {
        this.source.subscribe(new DoOnEvent(this, r3));
    }
}
