package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes.dex */
public class OkHttp3PureControlInterceptor implements Interceptor {
    public static final String KEY_METASEC_PREFIX = "x-metasec";
    public static final String TAG = "OkHttp3PureControlInterceptor";
    private static volatile ICheckPureRequestForUT sHook;

    public interface ICheckPureRequestForUT {
        void checkRequest(String r1, String r2, Map<String, List<String>> r3, String r4);
    }

    static {
    }

    public OkHttp3PureControlInterceptor() {
    }

    public static void setCheckRequestHook(ICheckPureRequestForUT r0) {
        sHook = r0;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain r6) throws IOException {
        Request r5 = r6.request();
        if (r5 != null) goto L5;
    L9:
        boolean r0 = false;
    L10:
        ArrayList r1 = new ArrayList();
        Iterator<Map.Entry<String, List<String>>> r2 = r5.headers().toMultimap().entrySet().iterator();
    L12:
        if (r2.hasNext() == false) goto L20;
        String r3 = r2.next().getKey();
        if (r3.equals(com.bytedance.retrofit2.client.Request.KEY_BYPASS_DISPATCH) == false) goto L17;
        if (r0 == false) goto L17;
    L18:
        r1.add(r3);
    L17:
        if (r3.startsWith(KEY_METASEC_PREFIX) == false) goto L12;
    L20:
        if (r1.size() <= 0) goto L27;
        Request.Builder r7 = r5.newBuilder();
        Iterator r4 = r1.iterator();
    L23:
        if (r4.hasNext() == false) goto L25;
        r7.removeHeader((String) r4.next());
        goto L23
    L25:
        r5 = r7.build();
    L27:
        if (sHook == null) goto L30;
        sHook.checkRequest(r5.method(), r5.url().toString(), r5.headers().toMultimap(), "");
    L30:
        return r6.proceed(r5);
    L5:
        if (r5.headers() == null) goto L9;
        if (r5.headers().get(com.bytedance.retrofit2.client.Request.KEY_BYPASS_TTNET_FEATURES) == null) goto L9;
        r0 = "1".equals(r5.headers().get(com.bytedance.retrofit2.client.Request.KEY_BYPASS_TTNET_FEATURES));
        goto L10
    }
}
