package com.obric.matrix.sdk.network;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.intercept.Interceptor;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class c implements Interceptor {
    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public final SsResponse intercept(Interceptor.Chain r1) {
        return TTNetHelper.a(r1);
    }
}
