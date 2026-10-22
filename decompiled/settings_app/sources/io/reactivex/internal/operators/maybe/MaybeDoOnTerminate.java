package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes5.dex */
public final class MaybeDoOnTerminate<T> extends Maybe<T> {
    final Action onTerminate;
    final MaybeSource<T> source;

    final class DoOnTerminate implements MaybeObserver<T> {
        final MaybeObserver<? super T> downstream;
        final /* synthetic */ MaybeDoOnTerminate this$0;

        DoOnTerminate(MaybeDoOnTerminate r1, MaybeObserver<? super T> r2) {
            this.this$0 = r1;
            this.downstream = r2;
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable r1) {
            this.downstream.onSubscribe(r1);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T r2) {
            this.this$0.onTerminate.run();     // Catch: Throwable -> L5
            this.downstream.onSuccess(r2);
            return;
        L5:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.downstream.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable r5) {
            this.this$0.onTerminate.run();     // Catch: Throwable -> L4
        L6:
            this.downstream.onError(r5);
            return;
        L4:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r5 = new CompositeException(new Throwable[]{r5, th});
            goto L6
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.this$0.onTerminate.run();     // Catch: Throwable -> L5
            this.downstream.onComplete();
            return;
        L5:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.downstream.onError(th);
        }
    }

    public MaybeDoOnTerminate(MaybeSource<T> r1, Action r2) {
        this.source = r1;
        this.onTerminate = r2;
    }

    @Override // io.reactivex.Maybe
    protected void subscribeActual(MaybeObserver<? super T> r3) {
        this.source.subscribe(new DoOnTerminate(this, r3));
    }
}
