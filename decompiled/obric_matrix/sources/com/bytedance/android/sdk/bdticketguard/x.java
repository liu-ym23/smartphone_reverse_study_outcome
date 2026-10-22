package com.bytedance.android.sdk.bdticketguard;

import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;

/* JADX INFO: loaded from: classes.dex */
public interface x extends u {
    @Override // com.bytedance.android.sdk.bdticketguard.u
    default void a(String r3, String r4) {
        kotlin.n0.d.o.g(r3, LocationMonitorConst.TAG);
        kotlin.n0.d.o.g(r4, NotificationCompat.CATEGORY_MESSAGE);
        log(3, r3, r4, null);
    }

    void log(int r1, String r2, String r3, Throwable r4);
}
