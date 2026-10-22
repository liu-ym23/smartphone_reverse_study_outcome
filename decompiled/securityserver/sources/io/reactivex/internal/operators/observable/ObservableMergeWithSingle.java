package io.reactivex.internal.operators.observable;

import android.R;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class ObservableMergeWithSingle<T> extends AbstractObservableWithUpstream<T, T> {
    final SingleSource<? extends T> other;

    public static final class MergeWithObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        static final int OTHER_STATE_CONSUMED_OR_EMPTY = 2;
        static final int OTHER_STATE_HAS_VALUE = 1;
        private static final long serialVersionUID = -4592979584110982903L;
        volatile boolean disposed;
        final Observer<? super T> downstream;
        final AtomicThrowable error;
        final AtomicReference<Disposable> mainDisposable;
        volatile boolean mainDone;
        final OtherObserver<T> otherObserver;
        volatile int otherState;
        volatile SimplePlainQueue<T> queue;
        T singleItem;

        public static final class OtherObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T> {
            private static final long serialVersionUID = -2935427570954647017L;
            final MergeWithObserver<T> parent;

            public OtherObserver(MergeWithObserver<T> r1) {
                this.parent = r1;
            }

            @Override // io.reactivex.SingleObserver
            public void onError(Throwable r1) {
                this.parent.otherError(r1);
            }

            @Override // io.reactivex.SingleObserver
            public void onSubscribe(Disposable r1) {
                DisposableHelper.setOnce(this, r1);
            }

            @Override // io.reactivex.SingleObserver
            public void onSuccess(T r1) {
                this.parent.otherSuccess(r1);
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
            this.disposed = true;
            DisposableHelper.dispose(this.mainDisposable);
            DisposableHelper.dispose(this.otherObserver);
            if (getAndIncrement() != 0) goto L6;
            this.queue = null;
            this.singleItem = null;
            return;
        }

        public void drain() {
            if (getAndIncrement() != 0) goto L6;
            drainLoop();
            return;
        }

        public void drainLoop() {
            Observer<? super T> r0 = this.downstream;
            int r2 = 1;
        L4:
            if (this.disposed == true) goto L5;
            if (this.error.get() != null) goto L9;
            int r3 = this.otherState;
            if (r3 != 1) goto L14;
            T r4 = this.singleItem;
            this.singleItem = null;
            this.otherState = 2;
            r0.onNext(r4);
            r3 = 2;
        L14:
            boolean r6 = this.mainDone;
            SimplePlainQueue<T> r7 = this.queue;
            if (r7 == null) goto L17;
            R.animator r8 = r7.poll();
        L18:
            if (r8 != null) goto L20;
            boolean r9 = true;
        L21:
            if (r6 == false) goto L26;
            if (r9 == false) goto L26;
            if (r3 != 2) goto L26;
            this.queue = null;
            r0.onComplete();
            return;
        L26:
            if (r9 == true) goto L27;
            r0.onNext(r8);
            goto L4
        L27:
            r2 = addAndGet(-r2);
            if (r2 != 0) goto L4;
            return;
        L20:
            r9 = false;
            goto L21
        L17:
            r8 = null;
            goto L18
        L9:
            this.singleItem = null;
            this.queue = null;
            r0.onError(this.error.terminate());
            return;
        L5:
            this.singleItem = null;
            this.queue = null;
        }

        public SimplePlainQueue<T> getOrCreateQueue() {
            SimplePlainQueue<T> r0 = this.queue;
            if (r0 != null) goto L6;
            SpscLinkedArrayQueue r1 = new SpscLinkedArrayQueue(Observable.bufferSize());
            this.queue = r1;
            return r1;
        L6:
            return r0;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.mainDisposable.get());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.mainDone = true;
            drain();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r2) {
            if (this.error.addThrowable(r2) == false) goto L5;
            DisposableHelper.dispose(this.otherObserver);
            drain();
            return;
        L5:
            RxJavaPlugins.onError(r2);
        }

        @Override // io.reactivex.Observer
        public void onNext(T r3) {
            if (compareAndSet(0, 1) == false) goto L7;
            this.downstream.onNext(r3);
            if (decrementAndGet() != 0) goto L10;
            return;
        L10:
            drainLoop();
            return;
        L7:
            getOrCreateQueue().offer(r3);
            if (getAndIncrement() == 0) goto L10;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r1) {
            DisposableHelper.setOnce(this.mainDisposable, r1);
        }

        public void otherError(Throwable r2) {
            if (this.error.addThrowable(r2) == false) goto L5;
            DisposableHelper.dispose(this.mainDisposable);
            drain();
            return;
        L5:
            RxJavaPlugins.onError(r2);
        }

        public void otherSuccess(T r3) {
            if (compareAndSet(0, 1) == false) goto L5;
            this.downstream.onNext(r3);
            this.otherState = 2;
        L8:
            drainLoop();
            return;
        L5:
            this.singleItem = r3;
            this.otherState = 1;
            if (getAndIncrement() == 0) goto L8;
        }
    }

    public ObservableMergeWithSingle(Observable<T> r1, SingleSource<? extends T> r2) {
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
