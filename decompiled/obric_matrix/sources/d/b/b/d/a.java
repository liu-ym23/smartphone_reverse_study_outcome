package d.b.b.d;

import android.text.TextUtils;
import d.b.b.d.c.d;
import d.b.b.l.b;
import d.b.b.n.c;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f12553a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile d.b.b.d.b.a f12554b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f12555c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static d.b.b.o.l.a<b> f12556d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f12557e;

    /* JADX INFO: renamed from: d.b.b.d.a$a, reason: collision with other inner class name */
    static class C0327a implements d.b.b.o.l.a.InterfaceC0345a<b> {
        C0327a() {
        }

        @Override // d.b.b.o.l.a.InterfaceC0345a
        public /* bridge */ /* synthetic */ void a(b r1) {
            b(r1);
        }

        public void b(b r2) {
            if (a.a() == false) goto L6;
            d.b.b.o.m.b.b("APM-CommonEvent", "evicted Monitorable " + r2);
            return;
        }
    }

    static {
        d.b.b.o.l.a<b> r0 = new d.b.b.o.l.a(1000);
        f12556d = r0;
        f12557e = true;
        r0.d(new C0327a());
    }

    static /* synthetic */ boolean a() {
        return f12557e;
    }

    private static synchronized void b() {
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (f12555c == true) goto L9;
        d.b.b.d.b.b r1 = (d.b.b.d.b.b) c.a(d.b.b.d.b.b.class);     // Catch: Throwable -> L11
        if (r1 == null) goto L9;
        p(r1.getConfig());     // Catch: Throwable -> L11
        f12555c = true;     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);
    }

    public static void c(d.b.b.d.c.b r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (f12554b != null) goto L12;
        f12556d.c(r4);
        if (d.b.b.o.a.c() == false) goto L9;
        d.b.b.o.m.b.a("APM-CommonEvent", "Cached CommonLog: " + r4);
    L9:
        b();
        return;
    L12:
        if (f12554b.a(r4.a()) == false) goto L18;
        r4.d();
        if (d.b.b.o.a.c() == false) goto L16;
        d.b.b.o.m.b.a("APM-CommonEvent", "Sampled CommonLog:" + r4);
    L16:
        d.b.b.l.a.d(r4);
        return;
    L18:
        if (d.b.b.o.a.c() == false) goto L22;
        r4.d();
        com.bytedance.apm.doctor.a.b(r4.a(), r4.c(), false);
        d.b.b.o.m.b.a("APM-CommonEvent", "UnSampled CommonLog:" + r4);
        return;
    }

    public static void d(String r1, JSONObject r2) {
        if (TextUtils.isEmpty(r1) == true) goto L5;
        c(new d.b.b.d.c.b(r1, r2));
        return;
    L5:
        if (d.b.b.o.a.c() == false) goto L10;
        d.b.b.o.m.b.a("APM-CommonEvent", "logType must be not empty");
        return;
    }

    public static void e(String r8, JSONObject r9, JSONObject r10) {
        f(new d.b.b.d.c.a(r8, 0, r9, null, null, r10));
    }

    public static void f(d.b.b.d.c.a r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (f12554b != null) goto L12;
        f12556d.c(r3);
        if (d.b.b.o.a.c() == false) goto L9;
        d.b.b.o.m.b.a("APM-CommonEvent", "cached CommonEvent:" + r3);
    L9:
        b();
        return;
    L12:
        if (f12554b.b(r3.h()) == false) goto L17;
        r3.d();
        d.b.b.l.a.d(r3);
        if (d.b.b.o.a.c() == false) goto L23;
        d.b.b.o.m.b.a("APM-CommonEvent", "Sampled CommonEvent:" + r3);
        return;
    L23:
        return;
    L17:
        if (d.b.b.o.a.c() == false) goto L20;
        d.b.b.o.m.b.a("APM-CommonEvent", "UnSampled CommonEvent:" + r3);
    L20:
        if (d.b.b.o.a.c() == false) goto L25;
        r3.d();
        com.bytedance.apm.doctor.a.b(r3.a(), r3.c(), false);
        return;
    }

    public static void g(String r8, int r9, JSONObject r10, JSONObject r11, JSONObject r12, JSONObject r13) {
        f(new d.b.b.d.c.a(r8, r9, r10, r11, r12, r13));
    }

    public static void h(String r1, JSONObject r2, JSONObject r3, JSONObject r4) {
        k(r1, 0, r2, r3, r4);
    }

    public static void i(d.b.b.d.c.c r0) {
        if (r0 != null) goto L4;
        return;
    L4:
        d.b.b.l.a.d(r0);
    }

    public static void j(String r8, int r9, JSONObject r10, JSONObject r11) {
        f(new d.b.b.d.c.a(r8, r9, r10, null, null, r11));
    }

    public static void k(String r6, int r7, JSONObject r8, JSONObject r9, JSONObject r10) {
        g(r6, r7, null, r8, r9, r10);
    }

    public static void l(String r1, int r2, JSONObject r3) {
        k(r1, r2, null, null, r3);
    }

    public static void m(d r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (d.b.b.o.a.c() == false) goto L7;
        d.b.b.o.m.b.a("APM-CommonEvent", "trace_data:" + r2.c());
    L7:
        d.b.b.l.a.d(r2);
    }

    public static boolean n(String r2, Boolean r3) {
        if (f12553a == true) goto L5;
        return false;
    L5:
        if (f12554b != null) goto L7;
        return false;
    L7:
        if (TextUtils.isEmpty(r2) == false) goto L10;
        return false;
    L10:
        if (r3.booleanValue() == false) goto L15;
        if (f12554b.b(r2) == true) goto L22;
    L16:
        return true;
    L22:
        return false;
    L15:
        if (f12554b.a(r2) == false) goto L16;
        return false;
    }

    public static synchronized void o(boolean r1) {
        monitor-enter(a.class);
        f12557e = r1;     // Catch: Throwable -> L7
        monitor-exit(a.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void p(d.b.b.d.b.a r4) {
        monitor-enter(a.class);
        if (r4 != null) goto L28;
    L26:
        monitor-exit(a.class);
        return;
    L28:
    L23:
        th = move-exception;
        throw th;
    L6:
        if (f12554b == r4) goto L26;
        if (d.b.b.o.a.c() == false) goto L11;
        d.b.b.o.m.b.a("APM-CommonEvent", "updateConfig " + r4);     // Catch: Throwable -> L23
    L11:
        f12554b = r4;     // Catch: Throwable -> L23
    L12:
        if (f12556d.a() == true) goto L21;
        b r5 = f12556d.b();     // Catch: Throwable -> L23
        if ((r5 instanceof d.b.b.d.c.a) == true) goto L16;
        if ((r5 instanceof d.b.b.d.c.b) == false) goto L12;
        c((d.b.b.d.c.b) r5);     // Catch: Throwable -> L23
        goto L12
    L16:
        f((d.b.b.d.c.a) r5);     // Catch: Throwable -> L23
        goto L12
    L21:
        monitor-exit(a.class);
    }
}
