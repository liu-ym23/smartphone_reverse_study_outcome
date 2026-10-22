package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes.dex */
public class OkHttp3TTPSandBoxInterceptor implements Interceptor {
    private static volatile ITncSandBox sSandBox;

    public interface ITncSandBox {
        boolean isTncRequestProceed(String r1, String r2, Map<String, List<String>> r3, String r4);
    }

    static {
    }

    public OkHttp3TTPSandBoxInterceptor() {
    }

    public static void setTncSandbox(ITncSandBox r0) {
        sSandBox = r0;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain r6) throws IOException {
        Request r5 = r6.request();
        if (sSandBox == null) goto L12;
        if ("/get_domains/v5/".equals(r5.url().encodedPath()) == false) goto L12;
        if (sSandBox.isTncRequestProceed(r5.method(), r5.url().toString(), r5.headers().toMultimap(), "") == true) goto L12;
        throw new IOException("TNC requsest dropped by sandbox");
    L12:
        return r6.proceed(r5);
    }
}
