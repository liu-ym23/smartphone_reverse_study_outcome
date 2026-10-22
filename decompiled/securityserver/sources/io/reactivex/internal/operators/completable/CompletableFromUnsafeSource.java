package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;

/* JADX INFO: loaded from: classes2.dex */
public final class CompletableFromUnsafeSource extends Completable {
    final CompletableSource source;

    public CompletableFromUnsafeSource(CompletableSource r1) {
        this.source = r1;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver r1) {
        this.source.subscribe(r1);
    }
}
