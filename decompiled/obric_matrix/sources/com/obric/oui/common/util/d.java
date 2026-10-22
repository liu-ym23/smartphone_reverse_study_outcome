package com.obric.oui.common.util;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static c f10943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f10944b = null;

    static {
        f10944b = new d();
    }

    private d() {
    }

    public final void a(String r1, String r2) {
        o.f(r1, LocationMonitorConst.TAG);
        o.f(r2, NotificationCompat.CATEGORY_MESSAGE);
        c r0 = f10943a;
        if (r0 == null) goto L5;
        r0.a(r1, r2);
        return;
    L5:
        Log.d(r1, r2);
    }

    public final void b(String r1, String r2) {
        o.f(r1, LocationMonitorConst.TAG);
        o.f(r2, NotificationCompat.CATEGORY_MESSAGE);
        c r0 = f10943a;
        if (r0 == null) goto L5;
        r0.b(r1, r2);
        return;
    L5:
        Log.i(r1, r2);
    }
}
