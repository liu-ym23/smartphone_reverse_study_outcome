package com.obric.matrix.opush;

import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004J\"\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004J\u0016\u0010\r\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004J\u0016\u0010\u000e\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004J\"\u0010\u000f\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/matrix/opush/PLog;", "", "()V", "TAG", "", "d", "", NotificationCompat.CATEGORY_MESSAGE, LocationMonitorConst.TAG, "e", "tr", "", "formatMessage", "i", BaseSwitches.V, "w", "o_push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f9247a = null;

    static {
        f9247a = new c();
    }

    private c() {
    }

    public static /* synthetic */ void e(c r0, String r1, String r2, Throwable r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.d(r1, r2, r3);
    }

    private final String f(String r1, String r2) {
        return r1 + " ---> " + r2;
    }

    public static /* synthetic */ void j(c r0, String r1, String r2, Throwable r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.i(r1, r2, r3);
    }

    public final void a(String r2) {
        o.f(r2, NotificationCompat.CATEGORY_MESSAGE);
        com.obric.matrix.r.c.c.b("Push_TAG", f("", r2));
    }

    public final void b(String r2, String r3) {
        o.f(r2, LocationMonitorConst.TAG);
        o.f(r3, NotificationCompat.CATEGORY_MESSAGE);
        com.obric.matrix.r.c.c.b("Push_TAG", f(r2, r3));
    }

    public final void c(String r2) {
        o.f(r2, NotificationCompat.CATEGORY_MESSAGE);
        com.obric.matrix.r.c.c.f("Push_TAG", f("", r2));
    }

    public final void d(String r2, String r3, Throwable r4) {
        o.f(r2, LocationMonitorConst.TAG);
        o.f(r3, NotificationCompat.CATEGORY_MESSAGE);
        com.obric.matrix.r.c.c.g("Push_TAG", f(r2, r3), r4);
    }

    public final void g(String r2) {
        o.f(r2, NotificationCompat.CATEGORY_MESSAGE);
        com.obric.matrix.r.c.c.j("Push_TAG", f("", r2));
    }

    public final void h(String r2, String r3) {
        o.f(r2, LocationMonitorConst.TAG);
        o.f(r3, NotificationCompat.CATEGORY_MESSAGE);
        com.obric.matrix.r.c.c.j("Push_TAG", f(r2, r3));
    }

    public final void i(String r2, String r3, Throwable r4) {
        o.f(r2, LocationMonitorConst.TAG);
        o.f(r3, NotificationCompat.CATEGORY_MESSAGE);
        com.obric.matrix.r.c.c.t("Push_TAG", f(r2, r3), r4);
    }
}
