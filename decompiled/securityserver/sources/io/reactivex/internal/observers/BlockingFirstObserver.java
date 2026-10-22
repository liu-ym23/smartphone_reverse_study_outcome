package io.reactivex.internal.observers;

/* JADX INFO: loaded from: classes2.dex */
public final class BlockingFirstObserver<T> extends BlockingBaseObserver<T> {
    public BlockingFirstObserver() {
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r2) {
        if (this.value != null) goto L5;
        this.error = r2;
    L5:
        countDown();
    }

    @Override // io.reactivex.Observer
    public void onNext(T r2) {
        if (this.value != null) goto L6;
        this.value = r2;
        this.upstream.dispose();
        countDown();
        return;
    }
}
