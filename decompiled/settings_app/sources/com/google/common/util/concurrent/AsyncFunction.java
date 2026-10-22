package com.google.common.util.concurrent;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
@FunctionalInterface
public interface AsyncFunction<I, O> {
    ListenableFuture<O> apply(@ParametricNullness I r1) throws Exception;
}
