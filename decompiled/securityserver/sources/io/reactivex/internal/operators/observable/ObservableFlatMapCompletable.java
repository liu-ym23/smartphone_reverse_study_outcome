package io.reactivex.internal.operators.observable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class ObservableFlatMapCompletable<T> extends AbstractObservableWithUpstream<T, T> {
    final boolean delayErrors;
    final Function<? super T, ? extends CompletableSource> mapper;

    public static final class FlatMapCompletableMainObserver<T> extends BasicIntQueueDisposable<T> implements Observer<T> {
        private static final long serialVersionUID = 8443155186132538303L;
        final boolean delayErrors;
        volatile boolean disposed;
        final Observer<? super T> downstream;
        final AtomicThrowable errors;
        final Function<? super T, ? extends CompletableSource> mapper;
        final CompositeDisposable set;
        Disposable upstream;

        public final class InnerObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
            private static final long serialVersionUID = 8606673141535671828L;
            final /* synthetic */ FlatMapCompletableMainObserver this$0;

            public InnerObserver(FlatMapCompletableMainObserver r1) {
                this.this$0 = r1;
            }

            @Override // io.reactivex.disposables.Disposable
            public void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.disposables.Disposable
            public boolean isDisposed() {
                return DisposableHelper.isDisposed(get());
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onComplete() {
                this.this$0.innerComplete(this);
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(Throwable r2) {
                this.this$0.innerError(this, r2);
            }

            @Override // io.reactivex.CompletableObserver
            public void onSubscribe(Disposable r1) {
                DisposableHelper.setOnce(this, r1);
            }
        }

        public FlatMapCompletableMainObserver(Observer<? super T> r1, Function<? super T, ? extends CompletableSource> r2, boolean r3) {
            this.downstream = r1;
            this.mapper = r2;
            this.delayErrors = r3;
            this.errors = new AtomicThrowable();
            this.set = new CompositeDisposable();
            lazySet(1);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.disposed = true;
            this.upstream.dispose();
            this.set.dispose();
        }

        public void innerComplete(FlatMapCompletableMainObserver<T>.InnerObserver r2) {
            this.set.delete(r2);
            onComplete();
        }

        public void innerError(FlatMapCompletableMainObserver<T>.InnerObserver r2, Throwable r3) {
            this.set.delete(r2);
            onError(r3);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return true;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (decrementAndGet() != 0) goto L9;
            Throwable r0 = this.errors.terminate();
            if (r0 == null) goto L7;
            this.downstream.onError(r0);
            return;
        L7:
            this.downstream.onComplete();
            return;
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r2) {
            if (this.errors.addThrowable(r2) == true) goto L5;
            RxJavaPlugins.onError(r2);
            return;
        L5:
            if (this.delayErrors == true) goto L7;
            dispose();
            if (getAndSet(0) <= 0) goto L16;
            Throwable r3 = this.errors.terminate();
            this.downstream.onError(r3);
            return;
        L16:
            return;
        L7:
            if (decrementAndGet() != 0) goto L14;
            Throwable r4 = this.errors.terminate();
            this.downstream.onError(r4);
            return;
        }

        @Override // io.reactivex.Observer
        public void onNext(T r3) {
            CompletableSource r4 = (CompletableSource) ObjectHelper.requireNonNull(this.mapper.apply(r3), "The mapper returned a null CompletableSource");     // Catch: Throwable -> L9
            getAndIncrement();
            InnerObserver r0 = new InnerObserver(this);
            if (this.disposed == false) goto L6;
            return;
        L6:
            if (this.set.add(r0) == false) goto L15;
            r4.subscribe(r0);
            return;
        L15:
            return;
        L9:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.upstream.dispose();
            onError(th);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r2) {
            if (DisposableHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() {
            return null;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int r1) {
            return r1 & 2;
        }
    }

    public ObservableFlatMapCompletable(ObservableSource<T> r1, Function<? super T, ? extends CompletableSource> r2, boolean r3) {
        super(r1);
        this.mapper = r2;
        this.delayErrors = r3;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> r4) {
        this.source.subscribe(new FlatMapCompletableMainObserver(r4, this.mapper, this.delayErrors));
    }
}
