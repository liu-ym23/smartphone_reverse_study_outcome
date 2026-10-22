package io.reactivex.internal.observers;

/* JADX INFO: loaded from: classes2.dex */
public final class BlockingLastObserver<T> extends BlockingBaseObserver<T> {
    public BlockingLastObserver() {
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r2) {
        this.value = null;
        this.error = r2;
        countDown();
    }

    @Override // io.reactivex.Observer
    public void onNext(T r1) {
        this.value = r1;
    }
}
