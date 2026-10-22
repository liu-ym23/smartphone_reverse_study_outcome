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
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableRetryWhen<T> extends AbstractObservableWithUpstream<T, T> {
    final Function<? super Observable<Throwable>, ? extends ObservableSource<?>> handler;

    static final class RepeatWhenObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 802743776666017014L;
        volatile boolean active;
        final Observer<? super T> downstream;
        final AtomicThrowable error;
        final RepeatWhenObserver<T>.InnerRepeatObserver inner;
        final Subject<Throwable> signaller;
        final ObservableSource<T> source;
        final AtomicReference<Disposable> upstream;
        final AtomicInteger wip;

        final class InnerRepeatObserver extends AtomicReference<Disposable> implements Observer<Object> {
            private static final long serialVersionUID = 3254781284376480842L;
            final /* synthetic */ RepeatWhenObserver this$0;

            InnerRepeatObserver(RepeatWhenObserver r1) {
                this.this$0 = r1;
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable r1) {
                DisposableHelper.setOnce(this, r1);
            }

            @Override // io.reactivex.Observer
            public void onNext(Object r1) {
                this.this$0.innerNext();
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable r1) {
                this.this$0.innerError(r1);
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                this.this$0.innerComplete();
            }
        }

        RepeatWhenObserver(Observer<? super T> r1, Subject<Throwable> r2, ObservableSource<T> r3) {
            this.downstream = r1;
            this.signaller = r2;
            this.source = r3;
            this.wip = new AtomicInteger();
            this.error = new AtomicThrowable();
            this.inner = new InnerRepeatObserver(this);
            this.upstream = new AtomicReference();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r1) {
            DisposableHelper.replace(this.upstream, r1);
        }

        @Override // io.reactivex.Observer
        public void onNext(T r3) {
            HalfSerializer.onNext(this.downstream, r3, this, this.error);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r3) {
            DisposableHelper.replace(this.upstream, null);
            this.active = false;
            this.signaller.onNext(r3);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            DisposableHelper.dispose(this.inner);
            HalfSerializer.onComplete(this.downstream, this, this.error);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this.inner);
        }

        void innerNext() {
            subscribeNext();
        }

        void innerError(Throwable r3) {
            DisposableHelper.dispose(this.upstream);
            HalfSerializer.onError(this.downstream, r3, this, this.error);
        }

        void innerComplete() {
            DisposableHelper.dispose(this.upstream);
            HalfSerializer.onComplete(this.downstream, this, this.error);
        }

        void subscribeNext() {
            if (this.wip.getAndIncrement() == 0) goto L5;
            return;
        L5:
            if (isDisposed() == true) goto L6;
            if (this.active == true) goto L11;
            this.active = true;
            this.source.subscribe(this);
        L11:
            if (this.wip.decrementAndGet() != 0) goto L5;
            return;
        }
    }

    public ObservableRetryWhen(ObservableSource<T> r1, Function<? super Observable<Throwable>, ? extends ObservableSource<?>> r2) {
        super(r1);
        this.handler = r2;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> r4) {
        Subject<T> r0 = PublishSubject.create().toSerialized();
        ObservableSource r1 = (ObservableSource) ObjectHelper.requireNonNull(this.handler.apply(r0), "The handler returned a null ObservableSource");     // Catch: Throwable -> L6
        RepeatWhenObserver r2 = new RepeatWhenObserver(r4, r0, this.source);
        r4.onSubscribe(r2);
        r1.subscribe(r2.inner);
        r2.subscribeNext();
        return;
    L6:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptyDisposable.error(th, r4);
    }
}
