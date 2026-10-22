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

    private Request tryAddRequestVertifyParams(Request r7) {
        String r6 = r7.getUrl();     // Catch: Throwable -> L7
        Long r0 = Long.valueOf(SystemClock.uptimeMillis());     // Catch: Throwable -> L7
        String r8 = NetworkParams.tryAddRequestVertifyParams(r6, r7.isAddCommonParam(), new Object[]{r7.getBody()});     // Catch: Throwable -> L7
        if (r7.getMetrics() == null) goto L5;
        r7.getMetrics().requestVerifyDuration = SystemClock.uptimeMillis() - r0.longValue();     // Catch: Throwable -> L7
    L5:
        Request.Builder r1 = r7.newBuilder();     // Catch: Throwable -> L7
        r1.url(r8);     // Catch: Throwable -> L7
        return r1.build();
    L7:
        th = move-exception;
        th.printStackTrace();
        return r7;
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public SsResponse intercept(Interceptor.Chain r7) throws Exception {
        RetrofitMetrics r0 = r7.metrics();
        Long r1 = Long.valueOf(SystemClock.uptimeMillis());
        Request r6 = interceptofend(r7.request());
        if (r0 == null) goto L6;
        r0.requestInterceptDuration.put("RequestVerifyInterceptor", Long.valueOf(SystemClock.uptimeMillis() - r1.longValue()));
    L6:
        if (RealInterceptorChain.isProceedWithoutHookEnabled() == false) goto L9;
        return r7.proceedWithoutHook(r6);
    L9:
        return r7.proceed(r6);
    }
}
