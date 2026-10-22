package com.obric.common.oea.foundation.b;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.obric.common.oea.foundation.b.a f8186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final a f8187b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f8188c = null;

    public static final class a implements com.obric.common.oea.foundation.b.a {
        a() {
        }

        @Override // com.obric.common.oea.foundation.b.a
        public void a(String r1, String r2) {
            o.f(r1, LocationMonitorConst.TAG);
            o.f(r2, NotificationCompat.CATEGORY_MESSAGE);
            Log.d("OEA_SDK", r1 + "->" + r2);
        }

        @Override // com.obric.common.oea.foundation.b.a
        public void b(String r1, String r2) {
            o.f(r1, LocationMonitorConst.TAG);
            o.f(r2, NotificationCompat.CATEGORY_MESSAGE);
            Log.i("OEA_SDK", r1 + "->" + r2);
        }

        @Override // com.obric.common.oea.foundation.b.a
        public void e(String r1, String r2, Throwable r3) {
            o.f(r1, LocationMonitorConst.TAG);
            o.f(r2, NotificationCompat.CATEGORY_MESSAGE);
            Log.e("OEA_SDK", r1 + "->" + r2, r3);
        }
    }

    static {
        f8188c = new b();
        f8187b = new a();
    }

    private b() {
    }

    public static /* synthetic */ void c(b r0, String r1, String r2, Throwable r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.b(r1, r2, r3);
    }

    public final void a(String r1, String r2) {
        o.f(r1, LocationMonitorConst.TAG);
        o.f(r2, NotificationCompat.CATEGORY_MESSAGE);
        com.obric.common.oea.foundation.b.a r0 = f8186a;
        if (r0 == null) goto L6;
        r0.a(r1, r2);
        return;
    }

    public final void b(String r1, String r2, Throwable r3) {
        o.f(r1, LocationMonitorConst.TAG);
        o.f(r2, NotificationCompat.CATEGORY_MESSAGE);
        com.obric.common.oea.foundation.b.a r0 = f8186a;
        if (r0 == null) goto L6;
        if (r0 == null) goto L8;
        r0.e(r1, r2, r3);
        return;
    L8:
        return;
    L6:
        f8187b.e(r1, r2, r3);
    }

    public final void d(String r1, String r2) {
        o.f(r1, LocationMonitorConst.TAG);
        o.f(r2, NotificationCompat.CATEGORY_MESSAGE);
        com.obric.common.oea.foundation.b.a r0 = f8186a;
        if (r0 == null) goto L6;
        if (r0 == null) goto L8;
        r0.b(r1, r2);
        return;
    L8:
        return;
    L6:
        f8187b.b(r1, r2);
    }
}
