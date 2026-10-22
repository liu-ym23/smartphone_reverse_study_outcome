package com.bytedance.sdk.account.log.internal;

import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final class a implements d.b.s.a.a0.c.a {
    public a() {
    }

    @Override // d.b.s.a.a0.c.a
    public void a(String r1, String r2) {
        o.g(r1, LocationMonitorConst.TAG);
        o.g(r2, NotificationCompat.CATEGORY_MESSAGE);
    }

    @Override // d.b.s.a.a0.c.a
    public void b(String r1, String r2) {
        o.g(r1, LocationMonitorConst.TAG);
        o.g(r2, NotificationCompat.CATEGORY_MESSAGE);
    }

    @Override // d.b.s.a.a0.c.a
    public void e(String r1, String r2) {
        o.g(r1, LocationMonitorConst.TAG);
        o.g(r2, NotificationCompat.CATEGORY_MESSAGE);
    }

    @Override // d.b.s.a.a0.c.a
    public void e(String r1, String r2, Throwable r3) {
        o.g(r1, LocationMonitorConst.TAG);
        o.g(r2, NotificationCompat.CATEGORY_MESSAGE);
    }

    @Override // d.b.s.a.a0.c.a
    public void w(String r1, String r2, Throwable r3) {
        o.g(r1, LocationMonitorConst.TAG);
        o.g(r2, NotificationCompat.CATEGORY_MESSAGE);
    }
}
