package com.bytedance.frameworks.baselib.network.http.retrofit;

import android.os.Looper;
import android.os.SystemClock;
import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.commonparam.CommonParamConfig;
import com.bytedance.frameworks.baselib.network.http.commonparam.CommonParamManager;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/* JADX INFO: loaded from: classes3.dex */
public class BaseSsInterceptor implements Interceptor {
    protected void intercept(Request r1, SsResponse r2) throws Exception {
    }

    public BaseSsInterceptor() {
    }

    protected Request intercept(Request r8) throws IOException {
        if (NetworkParams.getEnableMainThreadCheck() == true) goto L5;
    L9:
        if (r8 != null) goto L11;
        return r8;
    L11:
        Long r0 = Long.valueOf(SystemClock.uptimeMillis());
        String r1 = r8.getUrl();
        if ((r8.getExtraInfo() instanceof BaseRequestContext) == false) goto L14;
        String r2 = NetworkParams.filterUrl(r1, (BaseRequestContext) r8.getExtraInfo());
    L16:
        if (r8.getMetrics() == null) goto L19;
        RetrofitMetrics r3 = r8.getMetrics();
        r3.filterUrlDuration = SystemClock.uptimeMillis() - r0.longValue();
    L19:
        if (r8.getUrl().startsWith("https:") == true) goto L21;
    L23:
        Long r4 = Long.valueOf(SystemClock.uptimeMillis());
        if (r8.isAddCommonParam() == false) goto L32;
        CommonParamConfig r5 = CommonParamManager.inst().getCommonParamConfig();
        if (r5 != null) goto L28;
    L30:
        r2 = tryAddCommonParams(r2);
        goto L32
    L28:
        if (r5.isNewStrategyEnabled() == false) goto L30;
        r2 = CommonParamManager.inst().addCommonParams(r8, r2);
    L32:
        if (r8.getMetrics() == null) goto L34;
        RetrofitMetrics r7 = r8.getMetrics();
        r7.addCommonParamDuration = SystemClock.uptimeMillis() - r4.longValue();
    L34:
        Request.Builder r9 = r8.newBuilder();
        r9.url(r2);
        return r9.build();
    L21:
        if (r2.startsWith("http:") == false) goto L23;
        URL r6 = new URL(r2);     // Catch: Throwable -> L36
        NetworkParams.monitorApiHttp(r6.getHost(), r6.getPath(), true);     // Catch: Throwable -> L36
        goto L23
    L14:
        r2 = NetworkParams.filterUrl(r1);
        goto L16
    L5:
        if (Looper.getMainLooper() != Looper.myLooper()) goto L9;
        throw new IOException("You must not send request on main thread");
    }

    private String tryAddCommonParams(String r1) {
        return NetworkParams.addCommonParams(r1, true);
    L5:
        th = move-exception;
        th.printStackTrace();
        return r1;
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public SsResponse intercept(Interceptor.Chain r9) throws Exception {
        Long r0 = Long.valueOf(SystemClock.uptimeMillis());
        Request r1 = r9.request();
        URL r3 = new URL(r1.getUrl());     // Catch: MalformedURLException -> L13
        if (r3.getProtocol().equals("http") == false) goto L6;
        NetworkParams.monitorApiHttp(r3.getHost(), r3.getPath(), false);     // Catch: MalformedURLException -> L13
    L6:
        Request r2 = intercept(r1);
        if (r2.getMetrics() == null) goto L9;
        r2.getMetrics().requestInterceptDuration.put("BaseSsInterceptor", Long.valueOf(SystemClock.uptimeMillis() - r0.longValue()));
    L9:
        SsResponse r10 = r9.proceed(r2);
        Long r4 = Long.valueOf(SystemClock.uptimeMillis());
        intercept(r2, r10);
        if (r2.getMetrics() == null) goto L12;
        r2.getMetrics().responseInterceptDuration.put("BaseSsInterceptor", Long.valueOf(SystemClock.uptimeMillis() - r4.longValue()));
    L12:
        return r10;
    }
}
