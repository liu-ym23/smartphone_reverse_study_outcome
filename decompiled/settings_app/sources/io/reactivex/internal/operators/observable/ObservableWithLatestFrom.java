package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableWithLatestFrom<T, U, R> extends AbstractObservableWithUpstream<T, R> {
    final BiFunction<? super T, ? super U, ? extends R> combiner;
    final ObservableSource<? extends U> other;

    static final class WithLatestFromObserver<T, U, R> extends AtomicReference<U> implements Observer<T>, Disposable {
        private static final long serialVersionUID = -312246233408980075L;
        final BiFunction<? super T, ? super U, ? extends R> combiner;
        final Observer<? super R> downstream;
        final AtomicReference<Disposable> other;
        final AtomicReference<Disposable> upstream;

        WithLatestFromObserver(Observer<? super R> r2, BiFunction<? super T, ? super U, ? extends R> r3) {
            this.upstream = new AtomicReference();
            this.other = new AtomicReference();
            this.downstream = r2;
            this.combiner = r3;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r1) {
            DisposableHelper.setOnce(this.upstream, r1);
        }

        @Override // io.reactivex.Observer
        public void onNext(T r3) {
            U r0 = get();
            if (r0 == null) goto L11;
            Object r4 = ObjectHelper.requireNonNull(this.combiner.apply(r3, r0), "The combiner returned a null value");     // Catch: Throwable -> L6
            this.downstream.onNext(r4);
            return;
        L6:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            dispose();
            this.downstream.onError(th);
            return;
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r2) {
            DisposableHelper.dispose(this.other);
            this.downstream.onError(r2);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            DisposableHelper.dispose(this.other);
            this.downstream.onComplete();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this.other);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }

        public boolean setOther(Disposable r1) {
            return DisposableHelper.setOnce(this.other, r1);
        }

        public void otherError(Throwable r2) {
            DisposableHelper.dispose(this.upstream);
            this.downstream.onError(r2);
        }
    }

    final class WithLatestFromOtherObserver implements Observer<U> {
        private final WithLatestFromObserver<T, U, R> parent;
        final /* synthetic */ ObservableWithLatestFrom this$0;

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        WithLatestFromOtherObserver(ObservableWithLatestFrom r1, WithLatestFromObserver<T, U, R> r2) {
            this.this$0 = r1;
            this.parent = r2;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r1) {
            this.parent.setOther(r1);
        }

        @Override // io.reactivex.Observer
        public void onNext(U r1) {
            this.parent.lazySet(r1);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r1) {
            this.parent.otherError(r1);
        }
    }

    public ObservableWithLatestFrom(ObservableSource<T> r1, BiFunction<? super T, ? super U, ? extends R> r2, ObservableSource<? extends U> r3) {
        super(r1);
        this.combiner = r2;
        this.other = r3;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super R> r3) {
        SerializedObserver r0 = new SerializedObserver(r3);
        WithLatestFromObserver r4 = new WithLatestFromObserver(r0, this.combiner);
        r0.onSubscribe(r4);
        this.other.subscribe(new WithLatestFromOtherObserver(this, r4));
        this.source.subscribe(r4);
    }
}
