package d.b.b.g;

import android.app.Application;
import android.content.SharedPreferences;
import com.bytedance.apm.w.f;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static a f12871e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d.b.b.g.d.a f12872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f12873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f12874c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d.b.b.o.o.a f12875d;

    /* JADX INFO: renamed from: d.b.b.g.a$a, reason: collision with other inner class name */
    class C0338a extends d.b.b.o.o.a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ a f12876i;

        C0338a(a r1) {
            this.f12876i = r1;
        }

        @Proxy("getSharedPreferences")
        @TargetClass(scope = Scope.ALL, value = "android.content.Context")
        public static SharedPreferences f(Application r0, String r1, int r2) {
            return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
        }

        @Override // java.lang.Runnable
        public void run() {
            long r0 = System.currentTimeMillis();
            if (d.b.b.o.a.c() == false) goto L5;
            d.b.b.o.m.b.a("APM-Disk", "startCollect:");
        L5:
            SharedPreferences r2 = f(d.b.b.o.a.b(), "monitor_config", 0);
            long r5 = 0;
            if (r2 == null) goto L8;
            r5 = r2.getLong("check_disk_last_time", 0);
        L8:
            long r7 = System.currentTimeMillis() - r5;
            if (d.b.b.o.a.c() == false) goto L12;
            d.b.b.o.m.b.a("APM-Disk", "durationMs:" + r7);
        L12:
            if (r7 < 86400000) goto L17;
            b r6 = c.x().n(a.a(this.f12876i));
            if (d.b.b.o.a.c() == false) goto L16;
            d.b.b.o.m.b.a("APM-Disk", "durationMs:" + r6.c());
        L16:
            d.b.b.l.a.d(r6);
            r2.edit().putLong("check_disk_last_time", System.currentTimeMillis()).commit();
        L17:
            d.b.b.o.o.b.a(d.b.b.o.o.c.f13067g).b(a.b(this.f12876i));
            if (d.b.b.o.a.c() == false) goto L21;
            d.b.b.o.m.b.a("APM-Disk", "collect end and cost time:" + (System.currentTimeMillis() - r0));
            return;
        }
    }

    static {
        f12871e = new a();
    }

    public a() {
    }

    static /* synthetic */ d.b.b.g.d.a a(a r0) {
        return r0.f12872a;
    }

    static /* synthetic */ d.b.b.o.o.a b(a r0) {
        return r0.f12875d;
    }

    private synchronized void c() {
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L4:
        if (this.f12874c == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        d.b.b.g.d.a r0 = this.f12872a;     // Catch: Throwable -> L22
        if (r0 != null) goto L10;
    L20:
        monitor-exit(this);
        return;
    L10:
        if (r0.k() == false) goto L20;
        if (d.b.b.i.c.a.A() == true) goto L17;
        monitor-exit(this);
        return;
    L17:
        this.f12874c = true;     // Catch: Throwable -> L22
        this.f12875d = new C0338a(this);     // Catch: Throwable -> L22
        d.b.b.o.o.b.a(d.b.b.o.o.c.f13067g).c(this.f12875d);     // Catch: Throwable -> L22
        monitor-exit(this);
    }

    public static a d() {
        return f12871e;
    }

    public void e() {
        if (this.f12873b == false) goto L5;
        return;
    L5:
        this.f12873b = true;
        d.b.b.g.d.b r0 = (d.b.b.g.d.b) d.b.b.n.c.a(d.b.b.g.d.b.class);
        if (r0 == null) goto L9;
        g(r0.getConfig());
        return;
    }

    public void f(f r1) {
        c.x().I(r1);
    }

    public synchronized void g(d.b.b.g.d.a r4) {
        monitor-enter(this);
        if (r4 != null) goto L26;
        monitor-exit(this);
        return;
    L26:
        this.f12872a = r4;     // Catch: Throwable -> L23
        if (d.b.b.o.a.c() == false) goto L10;
        d.b.b.o.m.b.a("APM-Disk", "updateConfig:" + r4);     // Catch: Throwable -> L23
    L10:
        if (this.f12873b == true) goto L13;
        monitor-exit(this);
        return;
    L13:
        d.b.b.n.g.a r5 = (d.b.b.n.g.a) d.b.b.n.c.a(d.b.b.n.g.a.class);     // Catch: Throwable -> L23
        if (r5 != null) goto L16;
    L21:
        monitor-exit(this);
        return;
    L16:
        if (r5.isForeground() == true) goto L21;
        c();     // Catch: Throwable -> L23
        monitor-exit(this);
        return;
    L23:
        th = move-exception;
        throw th;
    }
}
