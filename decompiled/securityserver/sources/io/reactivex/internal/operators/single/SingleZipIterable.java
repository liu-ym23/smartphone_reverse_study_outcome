package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class SingleZipIterable<T, R> extends Single<R> {
    final Iterable<? extends SingleSource<? extends T>> sources;
    final Function<? super Object[], ? extends R> zipper;

    public final class SingletonArrayFunc implements Function<T, R> {
        final /* synthetic */ SingleZipIterable this$0;

        public SingletonArrayFunc(SingleZipIterable r1) {
            this.this$0 = r1;
        }

        @Override // io.reactivex.functions.Function
        public R apply(T r1) {
            return (R) ObjectHelper.requireNonNull(this.this$0.zipper.apply(new Object[]{r1}), "The zipper returned a null value");
        }
    }

    public SingleZipIterable(Iterable<? extends SingleSource<? extends T>> r1, Function<? super Object[], ? extends R> r2) {
        this.sources = r1;
        this.zipper = r2;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super R> r7) {
        SingleSource[] r0 = new SingleSource[8];
        Iterator<? extends SingleSource<? extends T>> r1 = this.sources.iterator();     // Catch: Throwable -> L10
        int r2 = 0;
        int r3 = 0;
    L5:
        if (r1.hasNext() == false) goto L17;
        SingleSource<? extends T> r4 = r1.next();     // Catch: Throwable -> L10
        if (r4 == null) goto L8;
        if (r3 != r0.length) goto L15;
        r0 = (SingleSource[]) Arrays.copyOf(r0, (r3 >> 2) + r3);     // Catch: Throwable -> L10
    L15:
        int r5 = r3 + 1;     // Catch: Throwable -> L10
        r0[r3] = r4;     // Catch: Throwable -> L10
        r3 = r5;
        goto L5
    L8:
        EmptyDisposable.error(new NullPointerException("One of the sources is null"), r7);     // Catch: Throwable -> L10
        return;
    L17:
        if (r3 != 0) goto L21;
        EmptyDisposable.error(new NoSuchElementException(), r7);
        return;
    L21:
        if (r3 != 1) goto L24;
        r0[0].subscribe(new SingleMap.MapSingleObserver(r7, new SingletonArrayFunc(this)));
        return;
    L24:
        SingleZipArray.ZipCoordinator r6 = new SingleZipArray.ZipCoordinator(r7, r3, this.zipper);
        r7.onSubscribe(r6);
    L25:
        if (r2 >= r3) goto L30;
        if (r6.isDisposed() == true) goto L28;
        r0[r2].subscribe(r6.observers[r2]);
        r2 = r2 + 1;
        goto L25
    L28:
        return;
    L30:
        return;
    L10:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptyDisposable.error(th, r7);
    }
}
