package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public final class CompletableMergeDelayErrorIterable extends Completable {
    final Iterable<? extends CompletableSource> sources;

    public CompletableMergeDelayErrorIterable(Iterable<? extends CompletableSource> r1) {
        this.sources = r1;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver r6) {
        CompositeDisposable r0 = new CompositeDisposable();
        r6.onSubscribe(r0);
        Iterator r5 = (Iterator) ObjectHelper.requireNonNull(this.sources.iterator(), "The source iterator returned is null");     // Catch: Throwable -> L30
        AtomicInteger r1 = new AtomicInteger(1);
        AtomicThrowable r2 = new AtomicThrowable();
    L6:
        if (r0.isDisposed() == true) goto L7;
        if (r5.hasNext() == false) goto L24;
        if (r0.isDisposed() == true) goto L13;
        CompletableSource r3 = (CompletableSource) ObjectHelper.requireNonNull(r5.next(), "The iterator returned a null CompletableSource");     // Catch: Throwable -> L19
        if (r0.isDisposed() == true) goto L17;
        r1.getAndIncrement();
        r3.subscribe(new CompletableMergeDelayErrorArray.MergeInnerCompletableObserver(r6, r0, r2, r1));
        goto L6
    L17:
        return;
    L19:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        r2.addThrowable(th);
        goto L24
    L13:
        return;
    L24:
        if (r1.decrementAndGet() != 0) goto L43;
        Throwable r7 = r2.terminate();
        if (r7 != null) goto L28;
        r6.onComplete();
        return;
    L28:
        r6.onError(r7);
        return;
    L43:
        return;
    L21:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        r2.addThrowable(th);
        goto L24
    L7:
        return;
    L30:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        r6.onError(th);
    }
}
