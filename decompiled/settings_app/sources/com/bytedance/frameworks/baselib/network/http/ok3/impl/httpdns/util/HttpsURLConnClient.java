package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util;

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

/* JADX INFO: loaded from: classes3.dex */
public class HttpsURLConnClient {
    private static final String TAG = "HttpsURLConnClient";

    static {
    }

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
        Logger.d(TAG, "start execute httpdns get " + r12);
    L5:
        long r0 = System.currentTimeMillis();
        StringBuilder r2 = new StringBuilder();
        SsCall r3 = null;
        String r4 = null;
        BufferedReader r5 = null;
        r3 = null;
        int r6 = 0;
        Request r7 = new Request.Builder().url(r12).build();     // Catch: Throwable -> L46 Exception -> L48
        r7.setMetrics(new RetrofitMetrics());     // Catch: Throwable -> L46 Exception -> L48
        SsCall r8 = SsOkHttp3Client.inst(HttpDns.getService().getHttpDnsDepend().getContext()).newSsCall(r7);     // Catch: Throwable -> L46 Exception -> L48
        Response r9 = r8.execute();     // Catch: Throwable -> L40 Exception -> L43
        if (r9 != null) goto L10;
        ?? r10 = 0;
        InputStream r11 = null;
    L30:
        if (r8 == null) goto L32;
        r8.cancel();
    L32:
        if (r5 != null) goto L93;
    L36:
        if (r11 == null) goto L62;
        r11.close();     // Catch: IOException -> L34
    L34:
        e = move-exception;
        e.printStackTrace();
    L62:
        long r14 = System.currentTimeMillis() - r0;
        ?? r1 = new JSONObject();     // Catch: JSONException -> L72
        r1.put("request_url", r12);     // Catch: JSONException -> L72
        r1.put("httpdns_domain", r13);     // Catch: JSONException -> L72
        if (r10 != 0) goto L67;
        r1.put("result", "");     // Catch: JSONException -> L72
    L68:
        r1.put("response_code", r6);     // Catch: JSONException -> L72
        r1.put("rtt", r14);     // Catch: JSONException -> L72
        if (Logger.debug() == false) goto L74;
        Logger.d(TAG, r1.toString());     // Catch: JSONException -> L72
    L74:
        return r10;
    L67:
        r1.put("result", r10);     // Catch: JSONException -> L72
    L72:
        e = move-exception;
        e.printStackTrace();
        goto L74
    L93:
        r5.close();     // Catch: IOException -> L34
        goto L36
    L10:
        if (r9.isSuccessful() == true) goto L12;
    L22:
        r11 = null;
        BufferedReader r15 = null;
    L23:
        r4 = r2.toString();     // Catch: Throwable -> L25 Exception -> L27
        r6 = r9.getStatus();     // Catch: Throwable -> L25 Exception -> L27
        r10 = r4;
        r5 = r15;
        goto L30
    L27:
        e = e;
        ?? r16 = r4;
        r3 = r8;
    L95:
        e.printStackTrace();     // Catch: Throwable -> L75
        if (r3 == null) goto L53;
        r3.cancel();
    L53:
        if (r15 != null) goto L87;
    L57:
        if (r11 == null) goto L61;
        r11.close();     // Catch: IOException -> L55
    L55:
        e = move-exception;
        e.printStackTrace();
    L61:
        r10 = r16;
        goto L62
    L87:
        r15.close();     // Catch: IOException -> L55
    L75:
        th = th;
    L76:
        if (r3 == null) goto L78;
        r3.cancel();
    L78:
        if (r15 != null) goto L91;
    L82:
        if (r11 == null) goto L86;
        r11.close();     // Catch: IOException -> L80
    L80:
        e = move-exception;
        e.printStackTrace();
    L86:
        throw th;
    L91:
        r15.close();     // Catch: IOException -> L80
    L25:
        th = th;
    L42:
        r3 = r8;
        goto L76
    L12:
        if (r9.getBody() == null) goto L22;
        r11 = r9.getBody().in();     // Catch: Throwable -> L40 Exception -> L43
    L103:
        r15 = new BufferedReader(new InputStreamReader(r11, "UTF-8"));     // Catch: Throwable -> L18 Exception -> L20
    L99:
        String r17 = r15.readLine();     // Catch: Throwable -> L25 Exception -> L27
        if (r17 == null) goto L23;
        r2.append(r17);     // Catch: Throwable -> L25 Exception -> L27
        goto L99
    L20:
        e = e;
        r15 = null;
    L45:
        r3 = r8;
        r16 = r15;
    L18:
        th = th;
        r15 = null;
    L43:
        e = e;
        r11 = null;
        r15 = null;
    L40:
        th = th;
        r11 = null;
        r15 = null;
        goto L42
    L48:
        e = e;
        r16 = 0;
        r11 = null;
        r15 = null;
    L46:
        th = th;
        r11 = null;
        r15 = null;
        goto L76
    }
}
