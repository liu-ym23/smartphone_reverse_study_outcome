package io.reactivex.internal.util;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes2.dex */
public final class ConnectConsumer implements Consumer<Disposable> {
    public Disposable disposable;

    public ConnectConsumer() {
    }

    @Override // io.reactivex.functions.Consumer
    public /* bridge */ /* synthetic */ void accept(Disposable r1) {
        accept2(r1);
    }

    /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
    public void accept2(Disposable r1) {
        this.disposable = r1;
    }
}
