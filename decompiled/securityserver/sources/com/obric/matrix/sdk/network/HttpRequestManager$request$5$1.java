package com.obric.matrix.sdk.network;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class HttpRequestManager$request$5$1 implements HttpRequestManager.HttpErrorCallback {
    final /* synthetic */ Function1<Throwable, Unit> $callback;

    /* JADX WARN: Multi-variable type inference failed */
    public HttpRequestManager$request$5$1(Function1<? super Throwable, Unit> r1) {
        this.$callback = r1;
    }

    @Override // com.obric.matrix.sdk.network.HttpRequestManager.HttpErrorCallback
    public void onError(@NotNull Throwable r2) {
        Intrinsics.f(r2, "e");
        this.$callback.invoke(r2);
    }
}
