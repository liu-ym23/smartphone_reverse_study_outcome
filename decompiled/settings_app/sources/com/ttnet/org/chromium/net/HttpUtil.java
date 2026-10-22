package com.ttnet.org.chromium.net;

import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.ttnet.org.chromium.base.annotations.JNINamespace;

/* JADX INFO: loaded from: classes5.dex */
@JNINamespace(ApmTrafficStats.KEY_TRAFFIC_STATUS_NET)
public final class HttpUtil {

    interface Natives {
        boolean isAllowedHeader(String r1, String r2);
    }

    public HttpUtil() {
    }

    public static boolean isAllowedHeader(String r1, String r2) {
        return HttpUtilJni.get().isAllowedHeader(r1, r2);
    }
}
