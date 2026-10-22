package com.bytedance.badger;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import kotlin.n0.d.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile c f2525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f2526b = null;

    static {
        f2526b = new d();
    }

    private d() {
    }

    public static final void b(String r1, String r2) {
        o.g(r1, LocationMonitorConst.TAG);
        o.g(r2, NotificationCompat.CATEGORY_MESSAGE);
        c r0 = f2525a;
        if (r0 == null) goto L5;
        r0.a(r1, r2);
        return;
    L5:
        Log.d(r1, r2);
    }

    public static final void c(String r1, String r2, Throwable r3) {
        o.g(r1, LocationMonitorConst.TAG);
        o.g(r2, NotificationCompat.CATEGORY_MESSAGE);
        c r0 = f2525a;
        if (r0 == null) goto L5;
        r0.e(r1, r2, r3);
        return;
    L5:
        Log.e(r1, r2, r3);
    }

    public static final void e(String r1, String r2) {
        o.g(r1, LocationMonitorConst.TAG);
        o.g(r2, NotificationCompat.CATEGORY_MESSAGE);
        c r0 = f2525a;
        if (r0 == null) goto L5;
        r0.c(r1, r2);
        return;
    L5:
        Log.e(r1, r2);
    }

    public static final void f(String r1, String r2) {
        o.g(r1, LocationMonitorConst.TAG);
        o.g(r2, NotificationCompat.CATEGORY_MESSAGE);
        c r0 = f2525a;
        if (r0 == null) goto L5;
        r0.b(r1, r2);
        return;
    L5:
        Log.i(r1, r2);
    }

    public static final void g(String r1, String r2) {
        o.g(r1, LocationMonitorConst.TAG);
        o.g(r2, NotificationCompat.CATEGORY_MESSAGE);
        c r0 = f2525a;
        if (r0 == null) goto L5;
        r0.d(r1, r2);
        return;
    L5:
        Log.w(r1, r2);
    }

    public final void a(c r1) {
        o.g(r1, "logger");
        f2525a = r1;
    }

    public final void d(String r2, JSONObject r3) {
        o.g(r2, NotificationCompat.CATEGORY_EVENT);
        o.g(r3, "params");
        c r1 = f2525a;
        if (r1 == null) goto L5;
        r1.e(r2, r3);
        return;
    L5:
        Log.i("[MONITOR] " + r2, r3.toString(2));
    }
}
