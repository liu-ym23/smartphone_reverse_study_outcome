package d.g.d.f.f;

import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.Iterator;
import kotlin.n0.d.o;
import kotlin.u0.k;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f16938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final a f16939b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f16940c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f16941d = null;

    public interface a {
        void a(String r1, int r2, String r3, Throwable r4);
    }

    static {
        f16941d = new b();
        f16939b = new d.g.d.f.f.a("OUI_SDK", false, 2, null);
        f16940c = 31;
    }

    private b() {
    }

    public static final void a(String r9, String r10) {
        o.f(r9, LocationMonitorConst.TAG);
        o.f(r10, NotificationCompat.CATEGORY_MESSAGE);
        h(f16941d, r9, 2, r10, null, false, 24, null);
    }

    public static final void b(String r9, String r10) {
        o.f(r9, LocationMonitorConst.TAG);
        o.f(r10, NotificationCompat.CATEGORY_MESSAGE);
        h(f16941d, r9, 16, r10, null, false, 24, null);
    }

    public static final void c(String r9, String r10, Throwable r11) {
        o.f(r9, LocationMonitorConst.TAG);
        o.f(r10, NotificationCompat.CATEGORY_MESSAGE);
        h(f16941d, r9, 16, r10, r11, false, 16, null);
    }

    public static final void e(String r9, String r10) {
        o.f(r9, LocationMonitorConst.TAG);
        o.f(r10, NotificationCompat.CATEGORY_MESSAGE);
        h(f16941d, r9, 4, r10, null, false, 24, null);
    }

    private final void g(String r7, int r8, String r9, Throwable r10, boolean r11) {
        if (f(r8) == false) goto L5;
        return;
    L5:
        if (r11 == true) goto L7;
        d().a(r7, r8, r9, r10);
        return;
    L7:
        Iterator r6 = k.n0(r9, new String[]{"\n"}, false, 0, 6, null).iterator();
    L9:
        if (r6.hasNext() == false) goto L13;
        String r12 = (String) r6.next();
        f16941d.d().a(r7, r8, r12, null);
        goto L9
    }

    static /* synthetic */ void h(b r6, String r7, int r8, String r9, Throwable r10, boolean r11, int r12, Object r13) {
        if ((r12 & 8) == 0) goto L5;
        r10 = null;
    L5:
        Throwable r4 = r10;
        if ((r12 & 16) == 0) goto L8;
        r11 = false;
    L8:
        r6.g(r7, r8, r9, r4, r11);
    }

    public static final void i(String r9, String r10) {
        o.f(r9, LocationMonitorConst.TAG);
        o.f(r10, NotificationCompat.CATEGORY_MESSAGE);
        h(f16941d, r9, 1, r10, null, false, 24, null);
    }

    public static final void j(String r9, String r10) {
        o.f(r9, LocationMonitorConst.TAG);
        o.f(r10, NotificationCompat.CATEGORY_MESSAGE);
        h(f16941d, r9, 8, r10, null, false, 24, null);
    }

    public static final void k(String r9, String r10, Throwable r11) {
        o.f(r9, LocationMonitorConst.TAG);
        o.f(r10, NotificationCompat.CATEGORY_MESSAGE);
        h(f16941d, r9, 8, r10, r11, false, 16, null);
    }

    public final a d() {
        a r0 = f16938a;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return f16939b;
    }

    public final boolean f(int r1) {
        if ((f16940c & r1) != 0) goto L5;
        return true;
    L5:
        return false;
    }
}
