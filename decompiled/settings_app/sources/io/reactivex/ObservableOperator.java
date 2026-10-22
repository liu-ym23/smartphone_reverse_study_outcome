package io.reactivex;

/* JADX INFO: loaded from: classes5.dex */
public interface ObservableOperator<Downstream, Upstream> {
    Observer<? super Upstream> apply(Observer<? super Downstream> r1) throws Exception;
}
