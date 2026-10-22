package com.ttnet.org.chromium.net;

import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.ttnet.org.chromium.base.annotations.JNINamespace;

/* JADX INFO: loaded from: classes3.dex */
@JNINamespace(ApmTrafficStats.KEY_TRAFFIC_STATUS_NET)
public final class GURLUtils {

    public interface Natives {
        String getOrigin(String r1);
    }

    public GURLUtils() {
    }

    public static String getOrigin(String r1) {
        return GURLUtilsJni.get().getOrigin(r1);
    }
}
