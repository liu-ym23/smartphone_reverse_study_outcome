package io.reactivex.internal.operators.mixed;

import android.R;
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

/* JADX INFO: loaded from: classes2.dex */
final class ScalarXMapZHelper {
    private ScalarXMapZHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> boolean tryAsCompletable(Object r1, Function<? super T, ? extends CompletableSource> r2, CompletableObserver r3) {
        if ((r1 instanceof Callable) == true) goto L20;
        return false;
    L20:
        R.anim r4 = (Object) ((Callable) r1).call();
        if (r4 == null) goto L11;
        CompletableSource r5 = (CompletableSource) ObjectHelper.requireNonNull(r2.apply(r4), "The mapper returned a null CompletableSource");     // Catch: Throwable -> L9
    L12:
        if (r5 != null) goto L14;
        EmptyDisposable.complete(r3);
    L15:
        return true;
    L14:
        r5.subscribe(r3);
        goto L15
    L11:
        r5 = null;
    L9:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptyDisposable.error(th, r3);
        return true;
    }

    public static <T, R> boolean tryAsMaybe(Object r1, Function<? super T, ? extends MaybeSource<? extends R>> r2, Observer<? super R> r3) {
        if ((r1 instanceof Callable) == true) goto L20;
        return false;
    L20:
        R.anim r4 = (Object) ((Callable) r1).call();
        if (r4 == null) goto L11;
        MaybeSource r5 = (MaybeSource) ObjectHelper.requireNonNull(r2.apply(r4), "The mapper returned a null MaybeSource");     // Catch: Throwable -> L9
    L12:
        if (r5 != null) goto L14;
        EmptyDisposable.complete(r3);
    L15:
        return true;
    L14:
        r5.subscribe(MaybeToObservable.create(r3));
        goto L15
    L11:
        r5 = null;
    L9:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptyDisposable.error(th, r3);
        return true;
    }

    public static <T, R> boolean tryAsSingle(Object r1, Function<? super T, ? extends SingleSource<? extends R>> r2, Observer<? super R> r3) {
        if ((r1 instanceof Callable) == true) goto L20;
        return false;
    L20:
        R.anim r4 = (Object) ((Callable) r1).call();
        if (r4 == null) goto L11;
        SingleSource r5 = (SingleSource) ObjectHelper.requireNonNull(r2.apply(r4), "The mapper returned a null SingleSource");     // Catch: Throwable -> L9
    L12:
        if (r5 != null) goto L14;
        EmptyDisposable.complete(r3);
    L15:
        return true;
    L14:
        r5.subscribe(SingleToObservable.create(r3));
        goto L15
    L11:
        r5 = null;
    L9:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptyDisposable.error(th, r3);
        return true;
    }
}
