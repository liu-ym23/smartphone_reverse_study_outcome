package com.obric.matrix.sdk.network;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: HttpRequestManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0015\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"com/obric/matrix/sdk/network/HttpRequestManager$request$4$1", "Lcom/obric/matrix/sdk/network/HttpRequestManager$HttpSuccessCallback;", "onSuccess", "", "responseData", "(Lcom/obric/matrix/sdk/network/BaseResponseModel;)V", "sdk_network_release"}, k = 1, mv = {1, 6, 0}, xi = 176)
public final class HttpRequestManager$request$4$1<T> implements HttpRequestManager.HttpSuccessCallback<T> {
    final /* synthetic */ Function1<T, Unit> $callback;

    /* JADX WARN: Multi-variable type inference failed */
    public HttpRequestManager$request$4$1(Function1<? super T, Unit> r1) {
        this.$callback = r1;
    }

    /* JADX WARN: Incorrect types in method signature: (TT;)V */
    @Override // com.obric.matrix.sdk.network.HttpRequestManager.HttpSuccessCallback
    public void onSuccess(BaseResponseModel r2) {
        Intrinsics.checkNotNullParameter(r2, "responseData");
        this.$callback.invoke(r2);
    }
}
