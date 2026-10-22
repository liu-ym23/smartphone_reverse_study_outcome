package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public final class CompletableConcatArray extends Completable {
    final CompletableSource[] sources;

    static final class ConcatInnerObserver extends AtomicInteger implements CompletableObserver {
        private static final long serialVersionUID = -7965400327305809232L;
        final CompletableObserver downstream;
        int index;
        final SequentialDisposable sd;
        final CompletableSource[] sources;

        ConcatInnerObserver(CompletableObserver r1, CompletableSource[] r2) {
            this.downstream = r1;
            this.sources = r2;
            this.sd = new SequentialDisposable();
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable r1) {
            this.sd.replace(r1);
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            next();
        }

        void next() {
            if (this.sd.isDisposed() == false) goto L6;
            return;
        L6:
            if (getAndIncrement() == 0) goto L8;
            return;
        L8:
            CompletableSource[] r0 = this.sources;
        L10:
            if (this.sd.isDisposed() == true) goto L11;
            int r1 = this.index;
            this.index = r1 + 1;
            if (r1 == r0.length) goto L14;
            r0[r1].subscribe(this);
            if (decrementAndGet() != 0) goto L10;
            return;
        L14:
            this.downstream.onComplete();
            return;
        }
    }

    public CompletableConcatArray(CompletableSource[] r1) {
        this.sources = r1;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver r2) {
        ConcatInnerObserver r0 = new ConcatInnerObserver(r2, this.sources);
        r2.onSubscribe(r0.sd);
        r0.next();
    }
}
