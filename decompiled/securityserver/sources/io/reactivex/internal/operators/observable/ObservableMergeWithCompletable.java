package io.reactivex.internal.operators.observable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class ObservableMergeWithCompletable<T> extends AbstractObservableWithUpstream<T, T> {
    final CompletableSource other;

    public static final class MergeWithObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -4592979584110982903L;
        final Observer<? super T> downstream;
        final AtomicThrowable error;
        final AtomicReference<Disposable> mainDisposable;
        volatile boolean mainDone;
        volatile boolean otherDone;
        final OtherObserver otherObserver;

        public static final class OtherObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = -2935427570954647017L;
            final MergeWithObserver<?> parent;

            public OtherObserver(MergeWithObserver<?> r1) {
                this.parent = r1;
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onComplete() {
                this.parent.otherComplete();
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(Throwable r1) {
                this.parent.otherError(r1);
            }

            @Override // io.reactivex.CompletableObserver
            public void onSubscribe(Disposable r1) {
                DisposableHelper.setOnce(this, r1);
            }
        }

        public MergeWithObserver(Observer<? super T> r1) {
            this.downstream = r1;
            this.mainDisposable = new AtomicReference();
            this.otherObserver = new OtherObserver(this);
            this.error = new AtomicThrowable();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this.mainDisposable);
            DisposableHelper.dispose(this.otherObserver);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.mainDisposable.get());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.mainDone = true;
            if (this.otherDone == false) goto L6;
            HalfSerializer.onComplete(this.downstream, this, this.error);
            return;
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r3) {
            DisposableHelper.dispose(this.otherObserver);
            HalfSerializer.onError(this.downstream, r3, this, this.error);
        }

        @Override // io.reactivex.Observer
        public void onNext(T r3) {
            HalfSerializer.onNext(this.downstream, r3, this, this.error);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r1) {
            DisposableHelper.setOnce(this.mainDisposable, r1);
        }

        public void otherComplete() {
            this.otherDone = true;
            if (this.mainDone == false) goto L6;
            HalfSerializer.onComplete(this.downstream, this, this.error);
            return;
        }

        public void otherError(Throwable r3) {
            DisposableHelper.dispose(this.mainDisposable);
            HalfSerializer.onError(this.downstream, r3, this, this.error);
        }
    }

    public ObservableMergeWithCompletable(Observable<T> r1, CompletableSource r2) {
        super(r1);
        this.other = r2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> r2) {
        MergeWithObserver r0 = new MergeWithObserver(r2);
        r2.onSubscribe(r0);
        this.source.subscribe(r0);
        this.other.subscribe(r0.otherObserver);
    }
}
