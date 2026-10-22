package d.b.b.k;

import android.app.Activity;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f12977k = "b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f12978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile com.bytedance.apm.w.d f12979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private d.b.b.k.f.a f12980c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d.b.b.o.o.a f12981d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f12982e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f12983f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private c f12984g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Map<Object, Object> f12985h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile boolean f12986i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private List<d.b.b.k.g.a> f12987j;

    class a extends d.b.b.o.o.a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ b f12988i;

        a(b r1, long r2, long r4) {
            this.f12988i = r1;
            super(r2, r4);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.a(this.f12988i) == true) goto L6;
            b.b(this.f12988i);
            return;
        }
    }

    /* JADX INFO: renamed from: d.b.b.k.b$b, reason: collision with other inner class name */
    private static class C0342b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f12989a = null;

        static {
            f12989a = new b(null);
        }

        static /* synthetic */ b a() {
            return f12989a;
        }
    }

    private class c extends d.b.b.n.g.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f12990a;

        private c(b r1) {
            this.f12990a = r1;
        }

        /* synthetic */ c(b r1, a r2) {
            this(r1);
        }

        @Override // d.b.b.n.g.b, d.b.b.n.g.c
        public final void onBackground(Activity r2) {
            if (d.b.b.o.a.c() == false) goto L6;
            d.b.b.o.m.b.a("APM-Memory", "isStopWhenBackground:" + b.c(this.f12990a));
        L6:
            if (b.c(this.f12990a) == false) goto L9;
            b.e(this.f12990a);
            return;
        }

        @Override // d.b.b.n.g.b, d.b.b.n.g.c
        public final void onFront(Activity r2) {
            if (d.b.b.o.a.c() == false) goto L6;
            d.b.b.o.m.b.a("APM-Memory", "isStopWhenBackground:" + b.c(this.f12990a));
        L6:
            if (b.c(this.f12990a) == false) goto L9;
            b.d(this.f12990a);
            return;
        }
    }

    static {
    }

    private b() {
        this.f12983f = 0;
        this.f12984g = new c(this, null);
        this.f12987j = new CopyOnWriteArrayList();
    }

    /* synthetic */ b(a r1) {
        this();
    }

    static /* synthetic */ boolean a(b r0) {
        return r0.f12986i;
    }

    static /* synthetic */ void b(b r0) {
        r0.g();
    }

    static /* synthetic */ boolean c(b r0) {
        return r0.k();
    }

    static /* synthetic */ void d(b r0) {
        r0.o();
    }

    static /* synthetic */ void e(b r0) {
        r0.p();
    }

    private void f() {
        if (d.b.b.o.a.c() == false) goto L6;
        d.b.b.o.m.b.a("APM-Memory", "cancelCollectMemory");
    L6:
        if (this.f12981d == null) goto L9;
        d.b.b.o.o.b.a(d.b.b.o.o.c.f13067g).b(this.f12981d);
        this.f12981d = null;
        return;
    }

    private void g() {
        long r0 = System.currentTimeMillis();
        d.b.b.k.h.a r2 = d.b.b.k.c.h().a(this.f12980c);
        if (r2 == null) goto L5;
        r2.l(this.f12985h);
        this.f12985h = null;
        if (d.b.b.o.a.c() == false) goto L12;
        d.b.b.o.m.b.a("APM-Memory", String.format("collect[isUploadEnable=%s cost=%s]: %s", new Object[]{Boolean.valueOf(this.f12980c.d()), Long.valueOf(System.currentTimeMillis() - r0), r2.c().toString()}));
    L12:
        if (this.f12980c.d() == false) goto L15;
        n(r2);
    L18:
        if (r2.j() > this.f12980c.f()) goto L20;
    L22:
        List<d.b.b.k.g.a> r1 = this.f12987j;
        if (r1 != null) goto L25;
        return;
    L25:
        if (r1.size() <= 0) goto L38;
        d.b.b.k.e.a r3 = r2.k();     // Catch: Exception -> L32
        Iterator<d.b.b.k.g.a> r8 = this.f12987j.iterator();     // Catch: Exception -> L32
    L28:
        if (r8.hasNext() == false) goto L40;
        r8.next().a(r3);     // Catch: Exception -> L32
    L40:
        return;
    L39:
        return;
    L38:
        return;
    L20:
        if (this.f12979b == null) goto L22;
        this.f12979b.a("reach_top_java");
        goto L22
    L15:
        if (com.bytedance.apm.x.a.e() == false) goto L18;
        com.bytedance.apm.x.a.b(f12977k, r2.c().toString());
        goto L18
    L5:
        if (d.b.b.o.a.c() == false) goto L37;
        d.b.b.o.m.b.a("APM-Memory", "collectWithConfig return is null");
        return;
    }

    public static b h() {
        return C0342b.a();
    }

    private boolean k() {
        d.b.b.k.f.a r0 = this.f12980c;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.c() == false) goto L7;
        return true;
    }

    private void m() {
        if (this.f12981d == null) goto L5;
        return;
    L5:
        if (d.b.b.o.a.c() == false) goto L7;
        d.b.b.o.m.b.a("APM-Memory", "scheduleCollectMemory");
    L7:
        this.f12981d = new a(this, 0, this.f12983f);
        d.b.b.o.o.b.a(d.b.b.o.o.c.f13067g).c(this.f12981d);
    }

    private void n(d.b.b.l.b r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        d.b.b.l.a.d(r1);
    }

    private synchronized void o() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f12982e == true) goto L9;
        this.f12982e = true;     // Catch: Throwable -> L11
        if (d.b.b.o.a.c() == false) goto L8;
        d.b.b.o.m.b.a("APM-Memory", "start");     // Catch: Throwable -> L11
    L8:
        m();     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
    }

    private synchronized void p() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.f12982e == false) goto L6;
        this.f12982e = false;     // Catch: Throwable -> L8
        f();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    public final synchronized void i() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f12978a == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.f12978a = true;     // Catch: Throwable -> L11
        q(((d.b.b.k.f.b) d.b.b.n.c.a(d.b.b.k.f.b.class)).getConfig());     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public void j() {
        d.b.b.k.c.h().l();
    }

    public void l(com.bytedance.apm.w.d r1) {
        this.f12979b = r1;
    }

    public synchronized void q(d.b.b.k.f.a r7) {
        monitor-enter(this);
        if (r7 != null) goto L48;
        monitor-exit(this);
        return;
    L48:
        this.f12980c = r7;     // Catch: Throwable -> L45
        if (d.b.b.o.a.c() == false) goto L11;
        d.b.b.o.m.b.a("APM-Memory", "updateConfig: " + r7);     // Catch: Throwable -> L45
    L11:
        if (r7.a() == true) goto L20;
        p();     // Catch: Throwable -> L45
        d.b.b.n.g.a r0 = (d.b.b.n.g.a) d.b.b.n.c.a(d.b.b.n.g.a.class);     // Catch: Throwable -> L45
        if (r0 == null) goto L16;
        r0.a(this.f12984g);     // Catch: Throwable -> L45
    L16:
        if (d.b.b.o.a.c() == false) goto L18;
        d.b.b.o.m.b.a("APM-Memory", "isApm6SampleEnable: " + r7.a());     // Catch: Throwable -> L45
    L18:
        monitor-exit(this);
        return;
    L20:
        d.b.b.n.g.a r1 = (d.b.b.n.g.a) d.b.b.n.c.a(d.b.b.n.g.a.class);     // Catch: Throwable -> L45
        if (r1 != null) goto L23;
    L26:
        long r2 = r7.e() * 1000;     // Catch: Throwable -> L45
        this.f12983f = r2;     // Catch: Throwable -> L45
        if (r2 >= 30000) goto L33;
        if (d.b.b.o.a.c() == false) goto L31;
        d.b.b.o.m.b.a("APM-Memory", "pollingIntervalMillis: " + this.f12983f);     // Catch: Throwable -> L45
    L31:
        this.f12983f = 30000;     // Catch: Throwable -> L45
    L33:
        if (d.b.b.o.a.c() == false) goto L35;
        d.b.b.o.m.b.a("APM-Memory", "result pollingIntervalMillis: " + this.f12983f);     // Catch: Throwable -> L45
    L35:
        d.b.b.o.o.a r8 = this.f12981d;     // Catch: Throwable -> L45
        if (r8 != null) goto L38;
    L40:
        o();     // Catch: Throwable -> L45
        d.b.b.k.a r9 = (d.b.b.k.a) d.b.b.n.c.a(d.b.b.k.a.class);     // Catch: Throwable -> L45
        if (r9 == null) goto L43;
        r9.start();     // Catch: Throwable -> L45
    L43:
        monitor-exit(this);
        return;
    L38:
        if (r8.c() == this.f12983f) goto L40;
        p();     // Catch: Throwable -> L45
        goto L40
    L23:
        if (r7.c() == false) goto L25;
        r1.a(this.f12984g);     // Catch: Throwable -> L45
        r1.b(this.f12984g);     // Catch: Throwable -> L45
        goto L26
    L25:
        r1.a(this.f12984g);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }
}
