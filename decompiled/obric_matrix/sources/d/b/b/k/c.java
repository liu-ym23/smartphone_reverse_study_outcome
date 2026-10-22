package d.b.b.k;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import android.text.TextUtils;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f12991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f12992b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f12993c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f12994d;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c f12995a = null;

        static {
            f12995a = new c();
        }

        static /* synthetic */ c a() {
            return f12995a;
        }
    }

    c() {
    }

    private long b() {
        if (Build.VERSION.SDK_INT >= 23) goto L6;
        return -1;
    L6:
        long r0 = Long.parseLong(Debug.getRuntimeStat("art.gc.blocking-gc-count"));
        long r2 = r0 - this.f12993c;
        this.f12993c = r0;
        if (d.b.b.o.a.c() == false) goto L9;
        d.b.b.o.m.b.a("APM-Memory", "blockingGcCount:" + this.f12993c);
    L9:
        return r2;
    }

    private long c() {
        if (Build.VERSION.SDK_INT >= 23) goto L6;
        return -1;
    L6:
        long r0 = Long.parseLong(Debug.getRuntimeStat("art.gc.blocking-gc-time"));
        long r2 = r0 - this.f12994d;
        this.f12994d = r0;
        if (d.b.b.o.a.c() == false) goto L9;
        d.b.b.o.m.b.a("APM-Memory", "blockingGcTime:" + this.f12994d);
    L9:
        return r2;
    }

    private long d(Debug.MemoryInfo r3) {
        return ((long) r3.dalvikPss) * 1024;
    }

    private long e() {
        if (Build.VERSION.SDK_INT >= 23) goto L6;
        return -1;
    L6:
        long r0 = Long.parseLong(Debug.getRuntimeStat("art.gc.gc-count"));
        long r2 = r0 - this.f12991a;
        this.f12991a = r0;
        if (d.b.b.o.a.c() == false) goto L9;
        d.b.b.o.m.b.a("APM-Memory", "gcCount:" + r0);
    L9:
        return r2;
    }

    private long f() {
        if (Build.VERSION.SDK_INT >= 23) goto L6;
        return -1;
    L6:
        long r0 = Long.parseLong(Debug.getRuntimeStat("art.gc.gc-time"));
        long r2 = r0 - this.f12992b;
        this.f12992b = r0;
        if (d.b.b.o.a.c() == false) goto L9;
        d.b.b.o.m.b.a("APM-Memory", "gcTime:" + this.f12992b);
    L9:
        return r2;
    }

    private long g(Debug.MemoryInfo r4) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return -1;
    L5:
        String r3 = r4.getMemoryStat("summary.graphics");
        if (TextUtils.isEmpty(r3) == false) goto L13;
    L12:
        return -1;
    L13:
        return ((long) Integer.parseInt(r3)) * 1024;
    L10:
        e = move-exception;
        d.b.b.o.m.b.c("APM-Memory", "getGraphics", e);
        e.printStackTrace();
        goto L12
    }

    public static c h() {
        return a.a();
    }

    private double i(long r3) {
        if (r3 > 0) goto L5;
        return -1.0d;
    L5:
        return new BigDecimal(r3).divide(new BigDecimal(Runtime.getRuntime().maxMemory()), 4, 4).doubleValue();
    }

    public static Debug.MemoryInfo j() {
        if (d.b.b.o.a.b() != null) goto L11;
        return null;
    L11:
        ActivityManager r0 = (ActivityManager) d.b.b.o.a.b().getSystemService("activity");     // Catch: Exception -> L10
        if (r0 != null) goto L8;
        return null;
    L8:
        return r0.getProcessMemoryInfo(new int[]{Process.myPid()})[0];
    L10:
        return null;
    }

    private long k() {
        long r0 = d.c() * 1024;
        if (r0 <= 0) goto L5;
        return r0;
    L5:
        return -1;
    }

    d.b.b.k.h.a a(d.b.b.k.f.a r33) {
        Debug.MemoryInfo r1 = j();
        if (r1 != null) goto L5;
        return null;
    L5:
        long r19 = d(r1);
        if (r19 >= 0) goto L8;
        return null;
    L8:
        d.b.b.n.g.a r2 = (d.b.b.n.g.a) d.b.b.n.c.a(d.b.b.n.g.a.class);
        long r13 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        double r25 = i(r13);
        long r4 = e();
        long r6 = f();
        long r8 = b();
        long r10 = c();
        boolean r12 = !r2.isForeground();
        long r21 = ((long) r1.nativePss) * 1024;
        long r17 = 1024 * ((long) r1.getTotalPss());
        long r3 = g(r1);
        long r23 = k();
        if (r25 <= r33.f()) goto L11;
        boolean r27 = true;
    L13:
        return new d.b.b.k.h.a(r4, r6, r8, r10, r12, r21, r17, r13, r19, r3, r23, r25, r27, r33.b());
    L11:
        r27 = false;
        goto L13
    }

    void l() {
        e();
        f();
        b();
        c();
    }
}
