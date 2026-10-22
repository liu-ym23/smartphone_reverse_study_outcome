package io.reactivex.internal.util;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes5.dex */
public final class ConnectConsumer implements Consumer<Disposable> {
    public Disposable disposable;

    public ConnectConsumer() {
    }

    @Override // io.reactivex.functions.Consumer
    public /* bridge */ /* synthetic */ void accept(Disposable r1) throws Exception {
        accept2(r1);
    }

    /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
    public void accept2(Disposable r1) throws Exception {
        this.disposable = r1;
    }
}
