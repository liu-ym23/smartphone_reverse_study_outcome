package com.obric.matrix.sdk.network;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class HttpRequestManager$request$4$1<T> implements HttpRequestManager.HttpSuccessCallback<T> {
    final /* synthetic */ Function1<T, Unit> $callback;

    /* JADX WARN: Multi-variable type inference failed */
    public HttpRequestManager$request$4$1(Function1<? super T, Unit> r1) {
        this.$callback = r1;
    }

    /* JADX WARN: Incorrect types in method signature: (TT;)V */
    @Override // com.obric.matrix.sdk.network.HttpRequestManager.HttpSuccessCallback
    public void onSuccess(@NotNull BaseResponseModel r2) {
        Intrinsics.f(r2, "responseData");
        this.$callback.invoke(r2);
    }
}
