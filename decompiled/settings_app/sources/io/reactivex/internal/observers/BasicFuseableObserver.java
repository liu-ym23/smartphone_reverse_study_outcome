package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: classes5.dex */
public abstract class BasicFuseableObserver<T, R> implements Observer<T>, QueueDisposable<R> {
    protected boolean done;
    protected final Observer<? super R> downstream;
    protected QueueDisposable<T> qd;
    protected int sourceMode;
    protected Disposable upstream;

    protected void afterDownstream() {
    }

    protected boolean beforeDownstream() {
        return true;
    }

    public BasicFuseableObserver(Observer<? super R> r1) {
        this.downstream = r1;
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable r2) {
        if (DisposableHelper.validate(this.upstream, r2) == false) goto L11;
        this.upstream = r2;
        if ((r2 instanceof QueueDisposable) == false) goto L8;
        this.qd = (QueueDisposable) r2;
    L8:
        if (beforeDownstream() == false) goto L12;
        this.downstream.onSubscribe(this);
        afterDownstream();
        return;
    L12:
        return;
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r2) {
        if (this.done == false) goto L6;
        RxJavaPlugins.onError(r2);
        return;
    L6:
        this.done = true;
        this.downstream.onError(r2);
    }

    protected final void fail(Throwable r2) {
        Exceptions.throwIfFatal(r2);
        this.upstream.dispose();
        onError(r2);
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        this.downstream.onComplete();
    }

    protected final int transitiveBoundaryFusion(int r3) {
        QueueDisposable<T> r0 = this.qd;
        if (r0 != null) goto L5;
        return 0;
    L5:
        if ((r3 & 4) != 0) goto L12;
        int r4 = r0.requestFusion(r3);
        if (r4 == 0) goto L9;
        this.sourceMode = r4;
    L9:
        return r4;
    L12:
        return 0;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.upstream.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        return this.qd.isEmpty();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
        this.qd.clear();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final boolean offer(R r1) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final boolean offer(R r1, R r2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
