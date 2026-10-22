package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import com.bytedance.frameworks.baselib.network.http.util.BoeUtils;
import com.bytedance.frameworks.baselib.network.http.util.URIUtils;
import com.ss.android.http.legacy.cookie.SM;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes.dex */
public class OkHttp3CookieInterceptor implements Interceptor {
    public OkHttp3CookieInterceptor() {
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain r13) {
        Request r0 = r13.request();
        if (r0 != null) goto L5;
    L101:
        URI r1 = r0.url().uri();     // Catch: Exception -> L12
    L13:
        Request.Builder r2 = r0.newBuilder();
        CookieHandler r3 = CookieHandler.getDefault();
        Headers r4 = r0.headers();
        Map<String, List<String>> r5 = null;
        if (r1 == null) goto L16;
        String r6 = BoeUtils.replaceUrlWithoutBoeHttpSuffix(r1.toString());
    L96:
        HashMap r7 = new HashMap();     // Catch: Throwable -> L27
        if (r4 == null) goto L30;
        Set<String> r8 = r4.names();     // Catch: Throwable -> L27
        if (r8 == null) goto L30;
        if (r8.isEmpty() == true) goto L30;
        Iterator<String> r9 = r8.iterator();     // Catch: Throwable -> L27
    L25:
        if (r9.hasNext() == false) goto L30;
        String r10 = r9.next();     // Catch: Throwable -> L27
        r7.put(r10, r4.values(r10));     // Catch: Throwable -> L27
    L30:
        if (r0.headers() == null) goto L34;
        boolean r11 = "1".equals(r0.header(com.bytedance.retrofit2.client.Request.KEY_BYPASS_OKHTTP_COOKIE));     // Catch: Throwable -> L27
        if ("1".equals(r0.header("x-metasec-ok-bypass-downgrade-cookie")) == false) goto L35;
        r11 = true;
    L35:
        if (r3 == null) goto L45;
        if (r11 == true) goto L45;
        if (r6 == null) goto L42;
        Map<String, List<String>> r12 = r3.get(new URI(r6), r7);     // Catch: Throwable -> L27 IOException -> L40
    L39:
        r5 = r12;
    L42:
        r12 = r3.get(r1, r7);     // Catch: Throwable -> L27 IOException -> L40
    L40:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L27
    L45:
        if (r5 != null) goto L47;
    L94:
        r0 = r2.build();     // Catch: Throwable -> L71
    L73:
        Response r14 = r13.proceed(r0);
        HashMap r15 = new HashMap();
        Headers r16 = r14.headers();
        if (r16 == null) goto L83;
        Set<String> r17 = r16.names();
        if (r17 == null) goto L83;
        if (r17.isEmpty() == true) goto L83;
        Iterator<String> r18 = r17.iterator();
    L81:
        if (r18.hasNext() == false) goto L83;
        String r19 = r18.next();
        r15.put(r19, r16.values(r19));
    L83:
        if (r3 != null) goto L99;
    L91:
        return r14;
    L99:
        if (r6 == null) goto L88;
        r3.put(new URI(r6), r15);     // Catch: Throwable -> L86
    L98:
        goto L91
    L88:
        r3.put(r1, r15);     // Catch: Throwable -> L86
    L86:
        th = move-exception;
        th.printStackTrace();
    L71:
        th = move-exception;
        th.printStackTrace();
        goto L73
    L47:
        if (r5.size() <= 0) goto L94;
        Iterator<Map.Entry<String, List<String>>> r110 = r5.entrySet().iterator();     // Catch: Throwable -> L27
    L49:
        if (r110.hasNext() == false) goto L94;
        Map.Entry<String, List<String>> r20 = r110.next();     // Catch: Throwable -> L27
        String r21 = r20.getKey();     // Catch: Throwable -> L27
        StringBuilder r22 = new StringBuilder();     // Catch: Throwable -> L27
        if ("X-SS-Cookie".equalsIgnoreCase(r21) == true) goto L58;
        if ("Cookie".equalsIgnoreCase(r21) == true) goto L58;
        if (SM.COOKIE2.equalsIgnoreCase(r21) == false) goto L49;
    L58:
        if (r20.getValue().isEmpty() == true) goto L49;
        Iterator<String> r23 = r20.getValue().iterator();     // Catch: Throwable -> L27
        int r24 = 0;
    L61:
        if (r23.hasNext() == false) goto L66;
        String r111 = r23.next();     // Catch: Throwable -> L27
        if (r24 <= 0) goto L65;
        r22.append("; ");     // Catch: Throwable -> L27
    L65:
        r22.append(r111);     // Catch: Throwable -> L27
        r24 = r24 + 1;     // Catch: Throwable -> L27
        goto L61
    L66:
        r2.addHeader(r21, r22.toString());     // Catch: Throwable -> L27
        goto L49
    L34:
        r11 = false;
    L27:
        th = move-exception;
        th.printStackTrace();
        goto L94
    L16:
        r6 = null;
    L12:
        r1 = URIUtils.createUriWithOutQuery(r0.url().toString());
        goto L13
    L5:
        if (r0.headers() == null) goto L101;
        if ("0".equals(r0.header(com.bytedance.retrofit2.client.Request.KEY_BYPASS_TTNET_COOKIE_HEADER)) == false) goto L101;
        Request.Builder r112 = r0.newBuilder();
        r112.removeHeader(com.bytedance.retrofit2.client.Request.KEY_BYPASS_TTNET_COOKIE_HEADER);
        return r13.proceed(r112.build());
    }
}
