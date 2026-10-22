package io.reactivex;

/* JADX INFO: loaded from: classes3.dex */
public interface FlowableConverter<T, R> {
    R apply(Flowable<T> r1);
}
