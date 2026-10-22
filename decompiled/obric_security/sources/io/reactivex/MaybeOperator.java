package io.reactivex;

/* JADX INFO: loaded from: classes3.dex */
public interface MaybeOperator<Downstream, Upstream> {
    MaybeObserver<? super Upstream> apply(MaybeObserver<? super Downstream> r1) throws Exception;
}
