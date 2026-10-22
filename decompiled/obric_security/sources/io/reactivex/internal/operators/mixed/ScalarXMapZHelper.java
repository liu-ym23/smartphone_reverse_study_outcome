package io.reactivex.internal.operators.mixed;

import a.a.a.a.a.b.b;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.MaybeSource;
import io.reactivex.Observer;
import io.reactivex.SingleSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.maybe.MaybeToObservable;
import io.reactivex.internal.operators.single.SingleToObservable;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
final class ScalarXMapZHelper {
    private ScalarXMapZHelper() {
        throw new IllegalStateException("No instances!");
    }

    static <T> boolean tryAsCompletable(Object r1, Function<? super T, ? extends CompletableSource> r2, CompletableObserver r3) {
        if ((r1 instanceof Callable) == true) goto L19;
        return false;
    L19:
        b.a r4 = (Object) ((Callable) r1).call();
        if (r4 == null) goto L9;
        CompletableSource r5 = (CompletableSource) ObjectHelper.requireNonNull(r2.apply(r4), "The mapper returned a null CompletableSource");     // Catch: Throwable -> L14
    L10:
        if (r5 != null) goto L12;
        EmptyDisposable.complete(r3);
    L13:
        return true;
    L12:
        r5.subscribe(r3);
        goto L13
    L9:
        r5 = null;
    L14:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptyDisposable.error(th, r3);
        return true;
    }

    static <T, R> boolean tryAsMaybe(Object r1, Function<? super T, ? extends MaybeSource<? extends R>> r2, Observer<? super R> r3) {
        if ((r1 instanceof Callable) == true) goto L19;
        return false;
    L19:
        b.a r4 = (Object) ((Callable) r1).call();
        if (r4 == null) goto L9;
        MaybeSource r5 = (MaybeSource) ObjectHelper.requireNonNull(r2.apply(r4), "The mapper returned a null MaybeSource");     // Catch: Throwable -> L14
    L10:
        if (r5 != null) goto L12;
        EmptyDisposable.complete(r3);
    L13:
        return true;
    L12:
        r5.subscribe(MaybeToObservable.create(r3));
        goto L13
    L9:
        r5 = null;
    L14:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptyDisposable.error(th, r3);
        return true;
    }

    static <T, R> boolean tryAsSingle(Object r1, Function<? super T, ? extends SingleSource<? extends R>> r2, Observer<? super R> r3) {
        if ((r1 instanceof Callable) == true) goto L19;
        return false;
    L19:
        b.a r4 = (Object) ((Callable) r1).call();
        if (r4 == null) goto L9;
        SingleSource r5 = (SingleSource) ObjectHelper.requireNonNull(r2.apply(r4), "The mapper returned a null SingleSource");     // Catch: Throwable -> L14
    L10:
        if (r5 != null) goto L12;
        EmptyDisposable.complete(r3);
    L13:
        return true;
    L12:
        r5.subscribe(SingleToObservable.create(r3));
        goto L13
    L9:
        r5 = null;
    L14:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptyDisposable.error(th, r3);
        return true;
    }
}
