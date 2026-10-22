package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservablePublishSelector<T, R> extends AbstractObservableWithUpstream<T, R> {
    final Function<? super Observable<T>, ? extends ObservableSource<R>> selector;

    static final class SourceObserver<T, R> implements Observer<T> {
        final PublishSubject<T> subject;
        final AtomicReference<Disposable> target;

        SourceObserver(PublishSubject<T> r1, AtomicReference<Disposable> r2) {
            this.subject = r1;
            this.target = r2;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r1) {
            DisposableHelper.setOnce(this.target, r1);
        }

        @Override // io.reactivex.Observer
        public void onNext(T r1) {
            this.subject.onNext(r1);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r1) {
            this.subject.onError(r1);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.subject.onComplete();
        }
    }

    static final class TargetObserver<T, R> extends AtomicReference<Disposable> implements Observer<R>, Disposable {
        private static final long serialVersionUID = 854110278590336484L;
        final Observer<? super R> downstream;
        Disposable upstream;

        TargetObserver(Observer<? super R> r1) {
            this.downstream = r1;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r2) {
            if (DisposableHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.Observer
        public void onNext(R r1) {
            this.downstream.onNext(r1);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r1) {
            DisposableHelper.dispose(this);
            this.downstream.onError(r1);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            DisposableHelper.dispose(this);
            this.downstream.onComplete();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.upstream.dispose();
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }
    }

    public ObservablePublishSelector(ObservableSource<T> r1, Function<? super Observable<T>, ? extends ObservableSource<R>> r2) {
        super(r1);
        this.selector = r2;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super R> r4) {
        PublishSubject r0 = PublishSubject.create();
        ObservableSource r1 = (ObservableSource) ObjectHelper.requireNonNull(this.selector.apply(r0), "The selector returned a null ObservableSource");     // Catch: Throwable -> L6
        TargetObserver r2 = new TargetObserver(r4);
        r1.subscribe(r2);
        this.source.subscribe(new SourceObserver(r0, r2));
        return;
    L6:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptyDisposable.error(th, r4);
    }
}
