package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class MaybeZipIterable<T, R> extends Maybe<R> {
    final Iterable<? extends MaybeSource<? extends T>> sources;
    final Function<? super Object[], ? extends R> zipper;

    public final class SingletonArrayFunc implements Function<T, R> {
        final /* synthetic */ MaybeZipIterable this$0;

        public SingletonArrayFunc(MaybeZipIterable r1) {
            this.this$0 = r1;
        }

        @Override // io.reactivex.functions.Function
        public R apply(T r1) {
            return (R) ObjectHelper.requireNonNull(this.this$0.zipper.apply(new Object[]{r1}), "The zipper returned a null value");
        }
    }

    public MaybeZipIterable(Iterable<? extends MaybeSource<? extends T>> r1, Function<? super Object[], ? extends R> r2) {
        this.sources = r1;
        this.zipper = r2;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(MaybeObserver<? super R> r7) {
        MaybeSource[] r0 = new MaybeSource[8];
        Iterator<? extends MaybeSource<? extends T>> r1 = this.sources.iterator();     // Catch: Throwable -> L10
        int r2 = 0;
        int r3 = 0;
    L5:
        if (r1.hasNext() == false) goto L17;
        MaybeSource<? extends T> r4 = r1.next();     // Catch: Throwable -> L10
        if (r4 == null) goto L8;
        if (r3 != r0.length) goto L15;
        r0 = (MaybeSource[]) Arrays.copyOf(r0, (r3 >> 2) + r3);     // Catch: Throwable -> L10
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
        EmptyDisposable.complete(r7);
        return;
    L21:
        if (r3 != 1) goto L24;
        r0[0].subscribe(new MaybeMap.MapMaybeObserver(r7, new SingletonArrayFunc(this)));
        return;
    L24:
        MaybeZipArray.ZipCoordinator r6 = new MaybeZipArray.ZipCoordinator(r7, r3, this.zipper);
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
