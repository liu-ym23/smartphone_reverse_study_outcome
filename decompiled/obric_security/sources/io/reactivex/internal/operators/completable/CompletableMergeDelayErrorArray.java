package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public final class CompletableMergeDelayErrorArray extends Completable {
    final CompletableSource[] sources;

    static final class MergeInnerCompletableObserver implements CompletableObserver {
        final CompletableObserver downstream;
        final AtomicThrowable error;
        final CompositeDisposable set;
        final AtomicInteger wip;

        MergeInnerCompletableObserver(CompletableObserver r1, CompositeDisposable r2, AtomicThrowable r3, AtomicInteger r4) {
            this.downstream = r1;
            this.set = r2;
            this.error = r3;
            this.wip = r4;
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable r1) {
            this.set.add(r1);
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable r2) {
            if (this.error.addThrowable(r2) == false) goto L5;
            tryTerminate();
            return;
        L5:
            RxJavaPlugins.onError(r2);
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            tryTerminate();
        }

        void tryTerminate() {
            if (this.wip.decrementAndGet() != 0) goto L9;
            Throwable r0 = this.error.terminate();
            if (r0 != null) goto L7;
            this.downstream.onComplete();
            return;
        L7:
            this.downstream.onError(r0);
            return;
        }
    }

    public CompletableMergeDelayErrorArray(CompletableSource[] r1) {
        this.sources = r1;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver r8) {
        CompositeDisposable r0 = new CompositeDisposable();
        AtomicInteger r1 = new AtomicInteger(this.sources.length + 1);
        AtomicThrowable r2 = new AtomicThrowable();
        r8.onSubscribe(r0);
        CompletableSource[] r7 = this.sources;
        int r3 = r7.length;
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L12;
        CompletableSource r5 = r7[r4];
        if (r0.isDisposed() == true) goto L6;
        if (r5 != null) goto L9;
        r2.addThrowable(new NullPointerException("A completable source is null"));
        r1.decrementAndGet();
    L10:
        r4 = r4 + 1;
        goto L3
    L9:
        r5.subscribe(new MergeInnerCompletableObserver(r8, r0, r2, r1));
        goto L10
    L6:
        return;
    L12:
        if (r1.decrementAndGet() != 0) goto L22;
        Throwable r9 = r2.terminate();
        if (r9 != null) goto L16;
        r8.onComplete();
        return;
    L16:
        r8.onError(r9);
        return;
    }
}
