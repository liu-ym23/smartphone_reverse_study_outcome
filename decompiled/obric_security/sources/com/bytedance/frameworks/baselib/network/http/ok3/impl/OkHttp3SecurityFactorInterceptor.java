package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes.dex */
public class OkHttp3SecurityFactorInterceptor implements Interceptor {
    private static final String KEY_BYPASS_MSSDK = "x-metasec-bypass-mssdk";
    private static final String KEY_OEC_OPAQUE_ENABLE = "x-tt-oec-opaque-enable";

    public OkHttp3SecurityFactorInterceptor() {
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain r7) throws IOException {
        Request r6 = r7.request();
        if ("1".equals(r6.headers().get(KEY_BYPASS_MSSDK)) == false) goto L6;
        Request.Builder r8 = r6.newBuilder();
        r8.removeHeader(KEY_BYPASS_MSSDK);
        return r7.proceed(r8.build());
    L6:
        Map<String, String> r0 = NetworkParams.tryAddSecurityFactor(r6.url().toString(), r6.headers().toMultimap());
        if ("1".equals(r6.headers().get(KEY_OEC_OPAQUE_ENABLE)) == false) goto L9;
        Map<String, String> r1 = NetworkParams.tryAddOecSecurityFactor(r6.url().toString(), r6.headers().toMultimap());
    L10:
        if (r0 != null) goto L14;
        if (r1 != null) goto L14;
        return r7.proceed(r6);
    L14:
        Request.Builder r2 = new Request.Builder();
        r2.url(r6.url());
        r2.method(r6.method(), r6.body());
        r2.tag(r6.tag());
        Headers.Builder r9 = r6.headers().newBuilder();
        if (r0 == null) goto L20;
        Iterator<Map.Entry<String, String>> r3 = r0.entrySet().iterator();
    L18:
        if (r3.hasNext() == false) goto L20;
        Map.Entry<String, String> r4 = r3.next();
        r9.add(r4.getKey(), r4.getValue());
    L20:
        if (r1 == null) goto L25;
        Iterator<Map.Entry<String, String>> r5 = r1.entrySet().iterator();
    L23:
        if (r5.hasNext() == false) goto L25;
        Map.Entry<String, String> r10 = r5.next();
        r9.add(r10.getKey(), r10.getValue());
    L25:
        r9.removeAll(KEY_OEC_OPAQUE_ENABLE);
        r2.headers(r9.build());
        return r7.proceed(r2.build());
    L9:
        r1 = null;
        goto L10
    }
}
