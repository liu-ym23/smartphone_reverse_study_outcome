package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util;

import a.a;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.SsOkHttp3Client;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.HttpDns;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.client.SsCall;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class HttpsURLConnClient {
    private static final String TAG = "HttpsURLConnClient";

    public HttpsURLConnClient() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    public static String executeGet(String r12, String r13) {
        if (Logger.debug() == false) goto L5;
        a.y("start execute httpdns get ", r12, TAG);
    L5:
        long r0 = System.currentTimeMillis();
        StringBuilder r2 = new StringBuilder();
        SsCall r3 = null;
        String r4 = null;
        BufferedReader r5 = null;
        r3 = null;
        int r6 = 0;
        Request r7 = new Request.Builder().url(r12).build();     // Catch: Throwable -> L44 Exception -> L46
        r7.setMetrics(new RetrofitMetrics());     // Catch: Throwable -> L44 Exception -> L46
        SsCall r8 = SsOkHttp3Client.inst(HttpDns.getService().getHttpDnsDepend().getContext()).newSsCall(r7);     // Catch: Throwable -> L44 Exception -> L46
        Response r9 = r8.execute();     // Catch: Throwable -> L27 Exception -> L29
        if (r9 != null) goto L10;
        ?? r10 = 0;
        InputStream r11 = null;
    L35:
        r8.cancel();
        if (r5 != null) goto L90;
    L40:
        if (r11 == null) goto L60;
        r11.close();     // Catch: IOException -> L38
    L38:
        e = move-exception;
        e.printStackTrace();
    L60:
        long r14 = System.currentTimeMillis() - r0;
        ?? r1 = new JSONObject();     // Catch: JSONException -> L65
        r1.put("request_url", r12);     // Catch: JSONException -> L65
        r1.put("httpdns_domain", r13);     // Catch: JSONException -> L65
        if (r10 != 0) goto L67;
        r1.put("result", "");     // Catch: JSONException -> L65
    L68:
        r1.put("response_code", r6);     // Catch: JSONException -> L65
        r1.put("rtt", r14);     // Catch: JSONException -> L65
        if (Logger.debug() == false) goto L73;
        Logger.d(TAG, r1.toString());     // Catch: JSONException -> L65
    L73:
        return r10;
    L67:
        r1.put("result", r10);     // Catch: JSONException -> L65
    L65:
        e = move-exception;
        e.printStackTrace();
        goto L73
    L90:
        r5.close();     // Catch: IOException -> L38
        goto L40
    L10:
        if (r9.isSuccessful() == true) goto L12;
    L31:
        r11 = null;
        BufferedReader r15 = null;
    L32:
        r4 = r2.toString();     // Catch: Throwable -> L18 Exception -> L20
        r6 = r9.getStatus();     // Catch: Throwable -> L18 Exception -> L20
        r10 = r4;
        r5 = r15;
        goto L35
    L20:
        e = e;
        ?? r16 = r4;
        r3 = r8;
    L86:
        e.printStackTrace();     // Catch: Throwable -> L74
        if (r3 == null) goto L51;
        r3.cancel();
    L51:
        if (r15 != null) goto L88;
    L55:
        if (r11 == null) goto L59;
        r11.close();     // Catch: IOException -> L53
    L53:
        e = move-exception;
        e.printStackTrace();
    L59:
        r10 = r16;
        goto L60
    L88:
        r15.close();     // Catch: IOException -> L53
    L74:
        th = th;
    L75:
        if (r3 == null) goto L77;
        r3.cancel();
    L77:
        if (r15 != null) goto L92;
    L81:
        if (r11 == null) goto L85;
        r11.close();     // Catch: IOException -> L79
    L79:
        e = move-exception;
        e.printStackTrace();
    L85:
        throw th;
    L92:
        r15.close();     // Catch: IOException -> L79
    L18:
        th = th;
    L19:
        r3 = r8;
        goto L75
    L12:
        if (r9.getBody() == null) goto L31;
        r11 = r9.getBody().in();     // Catch: Throwable -> L27 Exception -> L29
    L102:
        r15 = new BufferedReader(new InputStreamReader(r11, "UTF-8"));     // Catch: Throwable -> L22 Exception -> L24
    L98:
        String r17 = r15.readLine();     // Catch: Throwable -> L18 Exception -> L20
        if (r17 == null) goto L32;
        r2.append(r17);     // Catch: Throwable -> L18 Exception -> L20
        goto L98
    L24:
        e = e;
        r15 = null;
    L26:
        r3 = r8;
        r16 = r15;
    L22:
        th = th;
        r15 = null;
    L29:
        e = e;
        r11 = null;
        r15 = null;
    L27:
        th = th;
        r11 = null;
        r15 = null;
        goto L19
    L46:
        e = e;
        r16 = 0;
        r11 = null;
        r15 = null;
    L44:
        th = th;
        r11 = null;
        r15 = null;
        goto L75
    }
}
