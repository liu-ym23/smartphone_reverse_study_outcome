package com.bytedance.frameworks.baselib.network.http.retrofit;

import android.os.SystemClock;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.retrofit2.intercept.RealInterceptorChain;

/* JADX INFO: loaded from: classes.dex */
public final class RequestVertifyInterceptor implements Interceptor {
    public RequestVertifyInterceptor() {
    }

    private Request interceptofend(Request r2) {
        if (r2 != null) goto L5;
        return r2;
    L5:
        if (r2.isResponseStreaming() == false) goto L7;
        return r2;
    L7:
        return tryAddRequestVertifyParams(r2);
    }

    private Request tryAddRequestVertifyParams(Request r6) {
        String r5 = r6.getUrl();     // Catch: Throwable -> L5
        long r0 = SystemClock.uptimeMillis();     // Catch: Throwable -> L5
        String r7 = NetworkParams.tryAddRequestVertifyParams(r5, r6.isAddCommonParam(), new Object[]{r6.getBody()});     // Catch: Throwable -> L5
        if (r6.getMetrics() == null) goto L7;
        RetrofitMetrics r2 = r6.getMetrics();     // Catch: Throwable -> L5
        r2.requestVerifyDuration = SystemClock.uptimeMillis() - r0;     // Catch: Throwable -> L5
    L7:
        Request.Builder r1 = r6.newBuilder();     // Catch: Throwable -> L5
        r1.url(r7);     // Catch: Throwable -> L5
        return r1.build();
    L5:
        th = move-exception;
        th.printStackTrace();
        return r6;
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public SsResponse intercept(Interceptor.Chain r6) {
        RetrofitMetrics r0 = r6.metrics();
        long r1 = SystemClock.uptimeMillis();
        Request r5 = interceptofend(r6.request());
        if (r0 == null) goto L6;
        r0.requestInterceptDuration.put("RequestVerifyInterceptor", Long.valueOf(SystemClock.uptimeMillis() - r1));
    L6:
        if (RealInterceptorChain.isProceedWithoutHookEnabled() == false) goto L9;
        return r6.proceedWithoutHook(r5);
    L9:
        return r6.proceed(r5);
    }
}
