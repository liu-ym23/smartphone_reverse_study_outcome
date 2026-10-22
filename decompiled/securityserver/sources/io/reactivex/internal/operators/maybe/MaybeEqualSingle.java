package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class MaybeEqualSingle<T> extends Single<Boolean> {
    final BiPredicate<? super T, ? super T> isEqual;
    final MaybeSource<? extends T> source1;
    final MaybeSource<? extends T> source2;

    public static final class EqualCoordinator<T> extends AtomicInteger implements Disposable {
        final SingleObserver<? super Boolean> downstream;
        final BiPredicate<? super T, ? super T> isEqual;
        final EqualObserver<T> observer1;
        final EqualObserver<T> observer2;

        public EqualCoordinator(SingleObserver<? super Boolean> r2, BiPredicate<? super T, ? super T> r3) {
            super(2);
            this.downstream = r2;
            this.isEqual = r3;
            this.observer1 = new EqualObserver(this);
            this.observer2 = new EqualObserver(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.observer1.dispose();
            this.observer2.dispose();
        }

        public void done() {
            if (decrementAndGet() != 0) goto L21;
            Object r0 = this.observer1.value;
            Object r1 = this.observer2.value;
            if (r0 == null) goto L12;
            if (r1 == null) goto L12;
            boolean r2 = this.isEqual.test(r0, r1);     // Catch: Throwable -> L9
            this.downstream.onSuccess(Boolean.valueOf(r2));
            return;
        L9:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.downstream.onError(th);
            return;
        L12:
            SingleObserver<? super Boolean> r3 = this.downstream;
            if (r0 != null) goto L16;
            if (r1 != null) goto L16;
            boolean r4 = true;
        L17:
            r3.onSuccess(Boolean.valueOf(r4));
            return;
        L16:
            r4 = false;
            goto L17
        }

        public void error(EqualObserver<T> r2, Throwable r3) {
            if (getAndSet(0) <= 0) goto L9;
            EqualObserver<T> r0 = this.observer1;
            if (r2 != r0) goto L7;
            this.observer2.dispose();
        L8:
            this.downstream.onError(r3);
            return;
        L7:
            r0.dispose();
            goto L8
        L9:
            RxJavaPlugins.onError(r3);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.observer1.get());
        }

        public void subscribe(MaybeSource<? extends T> r2, MaybeSource<? extends T> r3) {
            r2.subscribe(this.observer1);
            r3.subscribe(this.observer2);
        }
    }

    public static final class EqualObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
        private static final long serialVersionUID = -3031974433025990931L;
        final EqualCoordinator<T> parent;
        Object value;

        public EqualObserver(EqualCoordinator<T> r1) {
            this.parent = r1;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.parent.done();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable r2) {
            this.parent.error(this, r2);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable r1) {
            DisposableHelper.setOnce(this, r1);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T r1) {
            this.value = r1;
            this.parent.done();
        }
    }

    public MaybeEqualSingle(MaybeSource<? extends T> r1, MaybeSource<? extends T> r2, BiPredicate<? super T, ? super T> r3) {
        this.source1 = r1;
        this.source2 = r2;
        this.isEqual = r3;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super Boolean> r3) {
        EqualCoordinator r0 = new EqualCoordinator(r3, this.isEqual);
        r3.onSubscribe(r0);
        r0.subscribe(this.source1, this.source2);
    }
}
