package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class CompletableTakeUntilCompletable extends Completable {
    final CompletableSource other;
    final Completable source;

    public static final class TakeUntilMainObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
        private static final long serialVersionUID = 3533011714830024923L;
        final CompletableObserver downstream;
        final AtomicBoolean once;
        final OtherObserver other;

        public static final class OtherObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = 5176264485428790318L;
            final TakeUntilMainObserver parent;

            public OtherObserver(TakeUntilMainObserver r1) {
                this.parent = r1;
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onComplete() {
                this.parent.innerComplete();
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(Throwable r1) {
                this.parent.innerError(r1);
            }

            @Override // io.reactivex.CompletableObserver
            public void onSubscribe(Disposable r1) {
                DisposableHelper.setOnce(this, r1);
            }
        }

        public TakeUntilMainObserver(CompletableObserver r1) {
            this.downstream = r1;
            this.other = new OtherObserver(this);
            this.once = new AtomicBoolean();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.once.compareAndSet(false, true) == false) goto L6;
            DisposableHelper.dispose(this);
            DisposableHelper.dispose(this.other);
            return;
        }

        public void innerComplete() {
            if (this.once.compareAndSet(false, true) == false) goto L6;
            DisposableHelper.dispose(this);
            this.downstream.onComplete();
            return;
        }

        public void innerError(Throwable r4) {
            if (this.once.compareAndSet(false, true) == false) goto L5;
            DisposableHelper.dispose(this);
            this.downstream.onError(r4);
            return;
        L5:
            RxJavaPlugins.onError(r4);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.once.get();
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            if (this.once.compareAndSet(false, true) == false) goto L6;
            DisposableHelper.dispose(this.other);
            this.downstream.onComplete();
            return;
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable r4) {
            if (this.once.compareAndSet(false, true) == false) goto L5;
            DisposableHelper.dispose(this.other);
            this.downstream.onError(r4);
            return;
        L5:
            RxJavaPlugins.onError(r4);
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable r1) {
            DisposableHelper.setOnce(this, r1);
        }
    }

    public CompletableTakeUntilCompletable(Completable r1, CompletableSource r2) {
        this.source = r1;
        this.other = r2;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver r3) {
        TakeUntilMainObserver r0 = new TakeUntilMainObserver(r3);
        r3.onSubscribe(r0);
        this.other.subscribe(r0.other);
        this.source.subscribe(r0);
    }
}
