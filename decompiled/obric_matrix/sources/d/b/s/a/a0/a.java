package d.b.s.a.a0;

import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.sdk.account.log.internal.LogWrapper;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f14633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f14634b;

    static {
        f14633a = new LogWrapper(new com.bytedance.sdk.account.log.internal.a(), true);
    }

    public static final void a(String r1, String r2) {
        o.g(r1, LocationMonitorConst.TAG);
        o.g(r2, NotificationCompat.CATEGORY_MESSAGE);
        f14633a.a(r1, r2);
    }

    public static final void b(String r1, String r2) {
        o.g(r1, LocationMonitorConst.TAG);
        o.g(r2, NotificationCompat.CATEGORY_MESSAGE);
        f14633a.c(r1, r2);
    }

    public static final void c(String r1, String r2, Throwable r3) {
        o.g(r1, LocationMonitorConst.TAG);
        o.g(r2, NotificationCompat.CATEGORY_MESSAGE);
        f14633a.e(r1, r2, r3);
    }

    public static final void d(String r1, String r2) {
        o.g(r1, LocationMonitorConst.TAG);
        o.g(r2, NotificationCompat.CATEGORY_MESSAGE);
        f14633a.b(r1, r2);
    }

    public static final boolean e() {
        return f14634b;
    }

    public static final void f(d.b.s.a.a0.c.a r4) {
        if (r4 == null) goto L5;
        f14634b = true;
        LogWrapper r3 = new LogWrapper(r4, false, 2, null);
    L6:
        f14633a = r3;
        return;
    L5:
        f14634b = false;
        r3 = new LogWrapper(new com.bytedance.sdk.account.log.internal.a(), false, 2, null);
        goto L6
    }

    public static final void g(String r1, String r2) {
        o.g(r1, LocationMonitorConst.TAG);
        o.g(r2, NotificationCompat.CATEGORY_MESSAGE);
        f14633a.e(r1, r2);
    }

    public static final void h(String r1, String r2) {
        o.g(r1, LocationMonitorConst.TAG);
        o.g(r2, NotificationCompat.CATEGORY_MESSAGE);
        f14633a.d(r1, r2);
    }

    public static final void i(String r1, String r2, Throwable r3) {
        o.g(r1, LocationMonitorConst.TAG);
        o.g(r2, NotificationCompat.CATEGORY_MESSAGE);
        f14633a.w(r1, r2, r3);
    }
}
