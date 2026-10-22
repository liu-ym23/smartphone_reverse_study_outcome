package com.bytedance.bdlocation.network.request;

import android.util.Pair;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.obric.matrix.common_api.INetworkApi;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import d.b.r.h0.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class RequestUtil {
    public RequestUtil() {
    }

    public static List<b> headerList(List<b> r4, final int r5) {
        if (r4 != null) goto L5;
        r4 = new ArrayList();
    L5:
        if (BDLocationConfig.isDebug() == true) goto L7;
    L16:
        Pair<String, String> r6 = BDNetworkTagManager.d().a(new AnonymousClass1(r5));     // Catch: Throwable -> L15
        if (r6 == null) goto L14;
        r4.add(new b((String) r6.first, (String) r6.second));     // Catch: Throwable -> L15
    L14:
        return r4;
    L7:
        if (BDLocationConfig.isOnline() == true) goto L16;
        Pair r0 = BDLocationConfig.getEnv();
        if (r0 == null) goto L16;
        r4.add(new b((String) r0.first, LocationInfoConst.ALLOW_USE_LOCATION));
        r4.add(new b("x-tt-env", (String) r0.second));
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Map<String, String> headerMap(Map<String, String> r3, final int r4) {
        if (r3 != null) goto L5;
        Map<String, String> r5 = new HashMap();
    L5:
        if (BDLocationConfig.isDebug() == true) goto L7;
    L16:
        Pair<String, String> r6 = BDNetworkTagManager.d().a(new AnonymousClass2(r4));     // Catch: Throwable -> L15
        if (r6 == null) goto L14;
        r5.put(r6.first, r6.second);     // Catch: Throwable -> L15
    L14:
        return r5;
    L7:
        if (BDLocationConfig.isOnline() == true) goto L16;
        Pair r0 = BDLocationConfig.getEnv();
        if (r0 == null) goto L16;
        r5.put(r0.first, LocationInfoConst.ALLOW_USE_LOCATION);
        r5.put("x-tt-env", r0.second);
        goto L16
    }

    public static List<b> overseaHeaderList(List<b> r3) {
        if (r3 != null) goto L4;
        r3 = new ArrayList();
    L4:
        r3.add(new b(INetworkApi.CONTENT_TYPE, "application/json"));
        return r3;
    }
}
