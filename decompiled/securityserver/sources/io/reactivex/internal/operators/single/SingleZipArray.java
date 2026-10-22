package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class SingleZipArray<T, R> extends Single<R> {
    final SingleSource<? extends T>[] sources;
    final Function<? super Object[], ? extends R> zipper;

    public final class SingletonArrayFunc implements Function<T, R> {
        final /* synthetic */ SingleZipArray this$0;

        public SingletonArrayFunc(SingleZipArray r1) {
            this.this$0 = r1;
        }

        @Override // io.reactivex.functions.Function
        public R apply(T r1) {
            return (R) ObjectHelper.requireNonNull(this.this$0.zipper.apply(new Object[]{r1}), "The zipper returned a null value");
        }
    }

    public static final class ZipCoordinator<T, R> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = -5556924161382950569L;
        final SingleObserver<? super R> downstream;
        final ZipSingleObserver<T>[] observers;
        final Object[] values;
        final Function<? super Object[], ? extends R> zipper;

        public ZipCoordinator(SingleObserver<? super R> r2, int r3, Function<? super Object[], ? extends R> r4) {
            super(r3);
            this.downstream = r2;
            this.zipper = r4;
            ZipSingleObserver<T>[] r5 = new ZipSingleObserver[r3];
            int r6 = 0;
        L3:
            if (r6 >= r3) goto L5;
            r5[r6] = new ZipSingleObserver(this, r6);
            r6 = r6 + 1;
            goto L3
        L5:
            this.observers = r5;
            this.values = new Object[r3];
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            int r0 = 0;
            if (getAndSet(0) <= 0) goto L7;
            ZipSingleObserver<T>[] r3 = this.observers;
            int r1 = r3.length;
        L5:
            if (r0 >= r1) goto L9;
            r3[r0].dispose();
            r0 = r0 + 1;
            goto L5
        L9:
            return;
        }

        public void disposeExcept(int r4) {
            ZipSingleObserver<T>[] r3 = this.observers;
            int r0 = r3.length;
            int r1 = 0;
        L3:
            if (r1 >= r4) goto L5;
            r3[r1].dispose();
            r1 = r1 + 1;
        L5:
            r4 = r4 + 1;
            if (r4 >= r0) goto L8;
            r3[r4].dispose();
            goto L5
        }

        public void innerError(Throwable r2, int r3) {
            if (getAndSet(0) <= 0) goto L5;
            disposeExcept(r3);
            this.downstream.onError(r2);
            return;
        L5:
            RxJavaPlugins.onError(r2);
        }

        public void innerSuccess(T r2, int r3) {
            this.values[r3] = r2;
            if (decrementAndGet() != 0) goto L11;
            Object r4 = ObjectHelper.requireNonNull(this.zipper.apply(this.values), "The zipper returned a null value");     // Catch: Throwable -> L6
            this.downstream.onSuccess(r4);
            return;
        L6:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.downstream.onError(th);
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (get() > 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class ZipSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T> {
        private static final long serialVersionUID = 3323743579927613702L;
        final int index;
        final ZipCoordinator<T, ?> parent;

        public ZipSingleObserver(ZipCoordinator<T, ?> r1, int r2) {
            this.parent = r1;
            this.index = r2;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable r2) {
            this.parent.innerError(r2, this.index);
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable r1) {
            DisposableHelper.setOnce(this, r1);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T r2) {
            this.parent.innerSuccess(r2, this.index);
        }
    }

    public SingleZipArray(SingleSource<? extends T>[] r1, Function<? super Object[], ? extends R> r2) {
        this.sources = r1;
        this.zipper = r2;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super R> r5) {
        SingleSource<? extends T>[] r0 = this.sources;
        int r1 = r0.length;
        int r3 = 0;
        if (r1 != 1) goto L6;
        r0[0].subscribe(new SingleMap.MapSingleObserver(r5, new SingletonArrayFunc(this)));
        return;
    L6:
        ZipCoordinator r2 = new ZipCoordinator(r5, r1, this.zipper);
        r5.onSubscribe(r2);
    L7:
        if (r3 >= r1) goto L16;
        if (r2.isDisposed() == true) goto L10;
        SingleSource<? extends T> r4 = r0[r3];
        if (r4 == null) goto L13;
        r4.subscribe(r2.observers[r3]);
        r3 = r3 + 1;
        goto L7
    L13:
        r2.innerError(new NullPointerException("One of the sources is null"), r3);
        return;
    L10:
        return;
    }
}
