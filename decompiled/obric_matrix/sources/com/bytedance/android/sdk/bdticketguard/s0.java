package com.bytedance.android.sdk.bdticketguard;

import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;

/* JADX INFO: loaded from: classes.dex */
public final class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s0 f1065a = null;

    static {
        f1065a = new s0();
    }

    private s0() {
    }

    private final u d() {
        f1 r0 = d1.f706b.a();
        if (r0 == null) goto L8;
        u r1 = r0.z();
        if (r1 == null) goto L8;
        return r1;
    L8:
        return e1.a();
    }

    private final void f(int r3, String r4, String r5, Throwable r6) {
        u r0 = d();
        if ((r0 instanceof x) == false) goto L5;
        ((x) r0).log(r3, i(r4), r5, r6);
        return;
    L5:
        r0.a(i(r4), r5);
    }

    static /* synthetic */ void g(s0 r0, int r1, String r2, String r3, Throwable r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = null;
    L5:
        r0.f(r1, r2, r3, r4);
    }

    private final String i(String r2) {
        return "BDTicketGuard/" + r2;
    }

    public final void a(String r9, String r10) {
        kotlin.n0.d.o.g(r9, LocationMonitorConst.TAG);
        kotlin.n0.d.o.g(r10, NotificationCompat.CATEGORY_MESSAGE);
        g(this, 3, r9, r10, null, 8, null);
    }

    public final void b(String r9, String r10) {
        kotlin.n0.d.o.g(r9, LocationMonitorConst.TAG);
        kotlin.n0.d.o.g(r10, NotificationCompat.CATEGORY_MESSAGE);
        g(this, 6, r9, r10, null, 8, null);
    }

    public final void c(String r2, String r3, Throwable r4) {
        kotlin.n0.d.o.g(r2, LocationMonitorConst.TAG);
        kotlin.n0.d.o.g(r3, NotificationCompat.CATEGORY_MESSAGE);
        f(6, r2, r3, r4);
    }

    public final void e(String r9, String r10) {
        kotlin.n0.d.o.g(r9, LocationMonitorConst.TAG);
        kotlin.n0.d.o.g(r10, NotificationCompat.CATEGORY_MESSAGE);
        g(this, 4, r9, r10, null, 8, null);
    }

    public final void h(String r9, String r10) {
        kotlin.n0.d.o.g(r9, LocationMonitorConst.TAG);
        kotlin.n0.d.o.g(r10, NotificationCompat.CATEGORY_MESSAGE);
        g(this, 5, r9, r10, null, 8, null);
    }
}
