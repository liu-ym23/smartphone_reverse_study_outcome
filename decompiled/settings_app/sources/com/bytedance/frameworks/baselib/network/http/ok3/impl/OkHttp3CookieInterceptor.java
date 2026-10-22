package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import com.bytedance.frameworks.baselib.network.http.util.BoeUtils;
import com.bytedance.frameworks.baselib.network.http.util.URIUtils;
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
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: loaded from: classes3.dex */
public class OkHttp3CookieInterceptor implements Interceptor {
    public OkHttp3CookieInterceptor() {
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain r13) throws IOException {
        Request r0 = r13.request();
        URI r1 = r0.url().uri();     // Catch: Exception -> L5
    L6:
        Request.Builder r2 = r0.newBuilder();
        CookieHandler r3 = CookieHandler.getDefault();
        Headers r4 = r0.headers();
        Map<String, List<String>> r5 = null;
        if (r1 == null) goto L9;
        String r6 = BoeUtils.replaceUrlWithoutBoeHttpSuffix(r1.toString());
    L87:
        HashMap r7 = new HashMap();     // Catch: Throwable -> L59
        if (r4 == null) goto L21;
        Set<String> r8 = r4.names();     // Catch: Throwable -> L59
        if (r8 == null) goto L21;
        if (r8.isEmpty() == true) goto L21;
        Iterator<String> r9 = r8.iterator();     // Catch: Throwable -> L59
    L18:
        if (r9.hasNext() == false) goto L21;
        String r10 = r9.next();     // Catch: Throwable -> L59
        r7.put(r10, r4.values(r10));     // Catch: Throwable -> L59
    L21:
        if (r0 != null) goto L23;
    L27:
        boolean r11 = false;
    L28:
        if (r3 == null) goto L36;
        if (r11 == true) goto L36;
        if (r6 == null) goto L32;
        Map<String, List<String>> r12 = r3.get(new URI(r6), r7);     // Catch: IOException -> L34 Throwable -> L59
    L33:
        r5 = r12;
    L32:
        r12 = r3.get(r1, r7);     // Catch: IOException -> L34 Throwable -> L59
    L34:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L59
    L36:
        if (r5 != null) goto L38;
    L92:
        r0 = r2.build();     // Catch: Throwable -> L63
    L65:
        Response r14 = r13.proceed(r0);
        HashMap r15 = new HashMap();
        Headers r16 = r14.headers();
        if (r16 == null) goto L75;
        Set<String> r17 = r16.names();
        if (r17 == null) goto L75;
        if (r17.isEmpty() == true) goto L75;
        Iterator<String> r18 = r17.iterator();
    L73:
        if (r18.hasNext() == false) goto L75;
        String r19 = r18.next();
        r15.put(r19, r16.values(r19));
    L75:
        if (r3 != null) goto L90;
    L82:
        return r14;
    L90:
        if (r6 == null) goto L78;
        r3.put(new URI(r6), r15);     // Catch: Throwable -> L80
    L89:
        goto L82
    L78:
        r3.put(r1, r15);     // Catch: Throwable -> L80
    L80:
        th = move-exception;
        th.printStackTrace();
    L63:
        th = move-exception;
        th.printStackTrace();
        goto L65
    L38:
        if (r5.size() <= 0) goto L92;
        Iterator<Map.Entry<String, List<String>>> r110 = r5.entrySet().iterator();     // Catch: Throwable -> L59
    L40:
        if (r110.hasNext() == false) goto L92;
        Map.Entry<String, List<String>> r20 = r110.next();     // Catch: Throwable -> L59
        String r21 = r20.getKey();     // Catch: Throwable -> L59
        StringBuilder r22 = new StringBuilder();     // Catch: Throwable -> L59
        if ("X-SS-Cookie".equalsIgnoreCase(r21) == true) goto L49;
        if ("Cookie".equalsIgnoreCase(r21) == true) goto L49;
        if ("Cookie2".equalsIgnoreCase(r21) == false) goto L40;
    L49:
        if (r20.getValue().isEmpty() == true) goto L40;
        Iterator<String> r23 = r20.getValue().iterator();     // Catch: Throwable -> L59
        int r24 = 0;
    L52:
        if (r23.hasNext() == false) goto L57;
        String r111 = r23.next();     // Catch: Throwable -> L59
        if (r24 <= 0) goto L56;
        r22.append(VectorFormat.DEFAULT_SEPARATOR);     // Catch: Throwable -> L59
    L56:
        r22.append(r111);     // Catch: Throwable -> L59
        r24 = r24 + 1;     // Catch: Throwable -> L59
        goto L52
    L57:
        r2.addHeader(r21, r22.toString());     // Catch: Throwable -> L59
        goto L40
    L23:
        if (r0.headers() == null) goto L27;
        r11 = "1".equals(r0.header(com.bytedance.retrofit2.client.Request.KEY_BYPASS_OKHTTP_COOKIE));     // Catch: Throwable -> L59
        if ("1".equals(r0.header("x-metasec-ok-bypass-downgrade-cookie")) == false) goto L28;
        r11 = true;
    L59:
        th = move-exception;
        th.printStackTrace();
        goto L92
    L9:
        r6 = null;
    L5:
        r1 = URIUtils.createUriWithOutQuery(r0.url().toString());
        goto L6
    }
}
