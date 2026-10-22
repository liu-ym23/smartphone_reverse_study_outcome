package com.ttnet.org.chromium.net;

import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace(ApmTrafficStats.KEY_TRAFFIC_STATUS_NET)
public class TTPatternUtil {
    public TTPatternUtil() {
    }

    @CalledByNative
    public static boolean isPatternStringValid(String r0) {
        Pattern.compile(r0);     // Catch: Throwable -> L5
        return true;
    L5:
        return false;
    }
}
