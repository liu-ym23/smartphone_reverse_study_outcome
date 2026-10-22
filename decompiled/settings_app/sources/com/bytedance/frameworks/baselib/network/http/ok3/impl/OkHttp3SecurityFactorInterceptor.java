package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes3.dex */
public class OkHttp3SecurityFactorInterceptor implements Interceptor {
    private static final String KEY_BYPASS_MSSDK = "x-metasec-bypass-mssdk";

    public OkHttp3SecurityFactorInterceptor() {
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain r5) throws IOException {
        Request r4 = r5.request();
        if ("1".equals(r4.headers().get(KEY_BYPASS_MSSDK)) == false) goto L6;
        Request.Builder r6 = r4.newBuilder();
        r6.removeHeader(KEY_BYPASS_MSSDK);
        return r5.proceed(r6.build());
    L6:
        Map<String, String> r0 = NetworkParams.tryAddSecurityFactor(r4.url().toString(), r4.headers().toMultimap());
        if (r0 == null) goto L9;
        Request.Builder r1 = new Request.Builder();
        r1.url(r4.url());
        r1.method(r4.method(), r4.body());
        r1.tag(r4.tag());
        Headers.Builder r7 = r4.headers().newBuilder();
        Iterator<Map.Entry<String, String>> r2 = r0.entrySet().iterator();
    L12:
        if (r2.hasNext() == false) goto L14;
        Map.Entry<String, String> r3 = r2.next();
        r7.add(r3.getKey(), r3.getValue());
        goto L12
    L14:
        r1.headers(r7.build());
        return r5.proceed(r1.build());
    L9:
        return r5.proceed(r4);
    }
}
