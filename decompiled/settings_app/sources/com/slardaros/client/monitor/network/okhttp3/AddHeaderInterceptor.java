package com.slardaros.client.monitor.network.okhttp3;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;

/* JADX INFO: loaded from: classes5.dex */
public class AddHeaderInterceptor implements Interceptor {
    public AddHeaderInterceptor() {
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain r1) throws IOException {
        return r1.proceed(r1.request().newBuilder().build());
    }
}
