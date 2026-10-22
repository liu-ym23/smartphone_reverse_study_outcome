package io.reactivex.internal.disposables;

import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.internal.fuseable.QueueDisposable;

/* JADX INFO: loaded from: classes4.dex */
public final enum EmptyDisposable extends Enum<EmptyDisposable> implements QueueDisposable<Object> {
    private static final /* synthetic */ EmptyDisposable[] $VALUES = null;
    public static final EmptyDisposable INSTANCE = null;
    public static final EmptyDisposable NEVER = null;

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        return true;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public Object poll() throws Exception {
        return null;
    }

    @Override // io.reactivex.internal.fuseable.QueueFuseable
    public int requestFusion(int r1) {
        return r1 & 2;
    }

    private EmptyDisposable(String r1, int r2) {
        super(r1, r2);
    }

    public static EmptyDisposable valueOf(String r1) {
        return (EmptyDisposable) Enum.valueOf(EmptyDisposable.class, r1);
    }

    public static EmptyDisposable[] values() {
        return (EmptyDisposable[]) $VALUES.clone();
    }

    static {
        EmptyDisposable r0 = new EmptyDisposable("INSTANCE", 0);
        INSTANCE = r0;
        EmptyDisposable r1 = new EmptyDisposable("NEVER", 1);
        NEVER = r1;
        $VALUES = new EmptyDisposable[]{r0, r1};
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (this != INSTANCE) goto L5;
        return true;
    L5:
        return false;
    }

    public static void complete(Observer<?> r1) {
        r1.onSubscribe(INSTANCE);
        r1.onComplete();
    }

    public static void complete(MaybeObserver<?> r1) {
        r1.onSubscribe(INSTANCE);
        r1.onComplete();
    }

    public static void error(Throwable r1, Observer<?> r2) {
        r2.onSubscribe(INSTANCE);
        r2.onError(r1);
    }

    public static void complete(CompletableObserver r1) {
        r1.onSubscribe(INSTANCE);
        r1.onComplete();
    }

    public static void error(Throwable r1, CompletableObserver r2) {
        r2.onSubscribe(INSTANCE);
        r2.onError(r1);
    }

    public static void error(Throwable r1, SingleObserver<?> r2) {
        r2.onSubscribe(INSTANCE);
        r2.onError(r1);
    }

    public static void error(Throwable r1, MaybeObserver<?> r2) {
        r2.onSubscribe(INSTANCE);
        r2.onError(r1);
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(Object r1) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(Object r1, Object r2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
