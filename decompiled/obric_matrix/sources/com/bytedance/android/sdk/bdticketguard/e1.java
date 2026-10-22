package com.bytedance.android.sdk.bdticketguard;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;

/* JADX INFO: loaded from: classes.dex */
public final class e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final x f713a = null;

    public static final class a implements x {
        a() {
        }

        @Override // com.bytedance.android.sdk.bdticketguard.x, com.bytedance.android.sdk.bdticketguard.u
        public void a(String r1, String r2) {
            kotlin.n0.d.o.g(r1, LocationMonitorConst.TAG);
            kotlin.n0.d.o.g(r2, NotificationCompat.CATEGORY_MESSAGE);
            Log.d(r1, r2);
        }

        @Override // com.bytedance.android.sdk.bdticketguard.x
        public void log(int r1, String r2, String r3, Throwable r4) {
            kotlin.n0.d.o.g(r2, LocationMonitorConst.TAG);
            kotlin.n0.d.o.g(r3, NotificationCompat.CATEGORY_MESSAGE);
            if (r1 != 3) goto L5;
        L14:
            Log.d(r2, r3, r4);
            return;
        L5:
            if (r1 != 4) goto L7;
            Log.i(r2, r3, r4);
            return;
        L7:
            if (r1 != 5) goto L9;
            Log.w(r2, r3, r4);
            return;
        L9:
            if (r1 != 6) goto L14;
            Log.e(r2, r3, r4);
        }
    }

    static {
        f713a = new a();
    }

    public static final x a() {
        return f713a;
    }
}
