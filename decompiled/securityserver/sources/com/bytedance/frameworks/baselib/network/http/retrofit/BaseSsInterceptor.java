package com.bytedance.frameworks.baselib.network.http.retrofit;

import android.os.Looper;
import android.os.SystemClock;
import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.commonparam.CommonParamConfig;
import com.bytedance.frameworks.baselib.network.http.commonparam.CommonParamManager;
import com.bytedance.frameworks.baselib.network.http.util.HttpHost;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.retrofit2.intercept.RealInterceptorChain;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public class BaseSsInterceptor implements Interceptor {
    public BaseSsInterceptor() {
    }

    private String tryAddCommonParams(String r1) {
        return NetworkParams.addCommonParams(r1, true);
    L5:
        th = move-exception;
        th.printStackTrace();
        return r1;
    }

    public void intercept(Request r1, SsResponse r2) {
    }

    public Request intercept(Request r7) {
        if (NetworkParams.getEnableMainThreadCheck() == true) goto L5;
    L9:
        if (r7 != null) goto L11;
        return r7;
    L11:
        long r0 = SystemClock.uptimeMillis();
        String r2 = r7.getUrl();
        if ((r7.getExtraInfo() instanceof BaseRequestContext) == false) goto L14;
        String r3 = NetworkParams.filterUrl(r2, (BaseRequestContext) r7.getExtraInfo());
    L16:
        if (r7.getMetrics() == null) goto L19;
        RetrofitMetrics r4 = r7.getMetrics();
        r4.filterUrlDuration = SystemClock.uptimeMillis() - r0;
    L19:
        if (r7.getUrl().startsWith("https:") == true) goto L21;
    L23:
        long r1 = SystemClock.uptimeMillis();
        if (r7.isAddCommonParam() == false) goto L32;
        CommonParamConfig r5 = CommonParamManager.inst().getCommonParamConfig();
        if (r5 != null) goto L28;
    L30:
        r3 = tryAddCommonParams(r3);
        goto L32
    L28:
        if (r5.isNewStrategyEnabled() == false) goto L30;
        r3 = CommonParamManager.inst().addCommonParams(r7, r3);
    L32:
        if (r7.getMetrics() == null) goto L34;
        RetrofitMetrics r6 = r7.getMetrics();
        r6.addCommonParamDuration = SystemClock.uptimeMillis() - r1;
    L34:
        Request.Builder r8 = r7.newBuilder();
        r8.url(r3);
        return r8.build();
    L21:
        if (r3.startsWith("http:") == false) goto L23;
        URL r9 = new URL(r3);     // Catch: Throwable -> L36
        NetworkParams.monitorApiHttp(r9.getHost(), r9.getPath(), true);     // Catch: Throwable -> L36
        goto L23
    L14:
        r3 = NetworkParams.filterUrl(r2);
        goto L16
    L5:
        if (Looper.getMainLooper() != Looper.myLooper()) goto L9;
        throw new IOException("You must not send request on main thread");
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public SsResponse intercept(Interceptor.Chain r8) {
        long r0 = SystemClock.uptimeMillis();
        Request r2 = r8.request();
        URL r4 = new URL(r2.getUrl());     // Catch: MalformedURLException -> L17
        if (r4.getProtocol().equals(HttpHost.DEFAULT_SCHEME_NAME) == false) goto L6;
        NetworkParams.monitorApiHttp(r4.getHost(), r4.getPath(), false);     // Catch: MalformedURLException -> L17
    L6:
        Request r3 = intercept(r2);
        if (r3.getMetrics() == null) goto L10;
        r3.getMetrics().requestInterceptDuration.put("BaseSsInterceptor", Long.valueOf(SystemClock.uptimeMillis() - r0));
    L10:
        if (RealInterceptorChain.isProceedWithoutHookEnabled() == false) goto L12;
        SsResponse r9 = r8.proceedWithoutHook(r3);
    L13:
        long r1 = SystemClock.uptimeMillis();
        intercept(r3, r9);
        if (r3.getMetrics() == null) goto L16;
        r3.getMetrics().responseInterceptDuration.put("BaseSsInterceptor", Long.valueOf(SystemClock.uptimeMillis() - r1));
    L16:
        return r9;
    L12:
        r9 = r8.proceed(r3);
        goto L13
    }
}
