package com.ttnet.org.chromium.net;

import android.net.TrafficStats;
import android.os.Process;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("net::android::traffic_stats")
public class AndroidTrafficStats {
    private AndroidTrafficStats() {
    }

    @CalledByNative
    private static long getCurrentUidRxBytes() {
        long r0 = TrafficStats.getUidRxBytes(Process.myUid());
        if (r0 != (-1)) goto L7;
        return 0;
    L7:
        return r0;
    }

    @CalledByNative
    private static long getCurrentUidTxBytes() {
        long r0 = TrafficStats.getUidTxBytes(Process.myUid());
        if (r0 != (-1)) goto L7;
        return 0;
    L7:
        return r0;
    }

    @CalledByNative
    private static long getTotalRxBytes() {
        long r0 = TrafficStats.getTotalRxBytes();
        if (r0 != (-1)) goto L7;
        return 0;
    L7:
        return r0;
    }

    @CalledByNative
    private static long getTotalTxBytes() {
        long r0 = TrafficStats.getTotalTxBytes();
        if (r0 != (-1)) goto L7;
        return 0;
    L7:
        return r0;
    }
}
