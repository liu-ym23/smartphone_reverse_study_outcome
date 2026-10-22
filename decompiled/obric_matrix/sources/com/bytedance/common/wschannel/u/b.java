package com.bytedance.common.wschannel.u;

import android.os.Build;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static long a() {
        if (Build.VERSION.SDK_INT < 17) goto L7;
        return SystemClock.elapsedRealtimeNanos();
    L7:
        return SystemClock.elapsedRealtime() * 1000;
    }
}
