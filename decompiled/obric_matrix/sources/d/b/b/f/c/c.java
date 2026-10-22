package d.b.b.f.c;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
class c extends d.b.b.n.g.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AtomicBoolean f12754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d.b.b.f.d.a f12755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private d.b.w.a.a.c f12756c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private HashMap<String, d.b.b.f.c.a> f12757d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private HashMap<String, d.b.b.f.c.a> f12758e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private HashMap<String, d.b.b.f.c.a> f12759f;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12760a = null;

        static {
            int[] r0 = new int[d.b.b.f.c.a.EnumC0334a.values().length];
            f12760a = r0;
            r0[d.b.b.f.c.a.EnumC0334a.f12740f.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f12760a[d.b.b.f.c.a.EnumC0334a.f12742h.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f12760a[d.b.b.f.c.a.EnumC0334a.f12741g.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    c(d.b.w.a.a.c r3) {
        this.f12754a = new AtomicBoolean(false);
        this.f12756c = r3;
    }

    private void e(d.b.b.f.c.a.EnumC0334a r2, String r3, d.b.b.f.c.a r4) {
        int r5 = a.f12760a[r2.ordinal()];
        if (r5 != 1) goto L5;
        HashMap<String, d.b.b.f.c.a> r1 = this.f12757d;
    L12:
        r1.put(r3, r4);
        return;
    L5:
        if (r5 != 2) goto L7;
        r1 = this.f12759f;
        goto L12
    L7:
        if (r5 != 3) goto L14;
        r1 = this.f12758e;
        goto L12
    }

    private void f(d.b.b.f.c.a.EnumC0334a r17, d.b.w.a.a.c.a r18) {
        long r13 = System.currentTimeMillis();
        int r0 = a.f12760a[r17.ordinal()];
        if (r0 != 1) goto L5;
        HashMap<String, d.b.b.f.c.a> r1 = this.f12757d;
    L13:
        Iterator<Map.Entry<String, d.b.b.f.c.a>> r2 = r1.entrySet().iterator();
    L9:
        Iterator<Map.Entry<String, d.b.b.f.c.a>> r15 = r2;
        if (r15 != null) goto L17;
        return;
    L17:
        if (r15.hasNext() == false) goto L25;
        d.b.b.f.c.a r3 = r15.next().getValue();
        if ((r13 - r3.d()) <= this.f12755b.e()) goto L17;
        r15.remove();
        double r4 = r3.h() / ((double) r3.j());
        double r5 = r3.g();
        double r7 = r3.e() / ((double) r3.j());
        double r9 = r3.f();
        if (d.b.b.o.a.c() == false) goto L24;
        d.b.b.o.m.b.a("APM-CPU", "cpu cache item: " + r3);
        d.b.b.o.m.b.a("APM-CPU", "assemble cpu data, type: " + r17 + " rate: " + r4 + " maxRate: " + r5 + " speed: " + r7 + " maxSpeed: " + r9);
    L24:
        g(r17, r3.i(), r4, r5, r7, r9, r18);
        goto L17
    L25:
        return;
    L5:
        if (r0 != 2) goto L7;
        r1 = this.f12759f;
        goto L13
    L7:
        if (r0 == 3) goto L10;
        r2 = null;
        goto L9
    L10:
        r1 = this.f12758e;
        goto L13
    }

    private void g(d.b.b.f.c.a.EnumC0334a r14, String r15, double r16, double r18, double r20, double r22, d.b.w.a.a.c.a r24) {
        e r12 = new e(r14, r15, r16, r18, r20, r22, r24);
        r12.j(d.i.c.c.b(d.b.b.o.a.b()));
        r12.k(this.f12756c.h());     // Catch: Throwable -> L6
    L4:
        d.b.b.l.a.d(r12);
    }

    private d.b.b.f.c.a h(d.b.b.f.c.a.EnumC0334a r2, String r3) {
        int r4 = a.f12760a[r2.ordinal()];
        if (r4 != 1) goto L5;
        HashMap<String, d.b.b.f.c.a> r1 = this.f12757d;
    L12:
        return r1.get(r3);
    L5:
        if (r4 != 2) goto L7;
        r1 = this.f12759f;
        goto L12
    L7:
        if (r4 == 3) goto L10;
        return null;
    L10:
        r1 = this.f12758e;
        goto L12
    }

    private static d.b.b.f.c.a j(d.b.b.f.c.a.EnumC0334a r2, d.b.b.f.c.a r3, double r4, double r6) {
        if (r3 != null) goto L5;
        r3 = new d.b.b.f.c.a(r2, System.currentTimeMillis());
        r3.k(d.b.b.m.a.c.a().e());
    L5:
        if (r4 < 0.0d) goto L7;
    L8:
        r3.c();
    L9:
        r3.b(r6);
        r3.a(r4);
        r3.l(r4);
        r3.m(r6);
        return r3;
    L7:
        if (r6 < 0.0d) goto L9;
        goto L8
    }

    void d(double r10, double r12) {
        if (this.f12754a.get() == true) goto L5;
        return;
    L5:
        String r0 = d.b.b.m.a.c.a().e();
        if (d.b.b.o.a.c() == false) goto L9;
        d.b.b.o.m.b.a("APM-CPU", r0);
    L9:
        monitor-enter(c.class);
    L20:
        th = move-exception;
        throw th;
    L11:
        if (b.e().g() == false) goto L13;
        d.b.b.f.c.a.EnumC0334a r2 = d.b.b.f.c.a.EnumC0334a.f12741g;     // Catch: Throwable -> L20
    L14:
        d.b.b.f.c.a r3 = j(r2, h(r2, r0), r10, r12);     // Catch: Throwable -> L20
        e(r2, r0, r3);     // Catch: Throwable -> L20
        if (d.b.b.o.a.c() == false) goto L17;
        d.b.b.o.m.b.a("APM-CPU", "after add cache data: " + r3);     // Catch: Throwable -> L20
    L17:
        d.b.b.f.c.a.EnumC0334a r8 = d.b.b.f.c.a.EnumC0334a.f12740f;     // Catch: Throwable -> L20
        e(r8, r0, j(r8, h(r8, r0), r10, r12));     // Catch: Throwable -> L20
        monitor-exit(c.class);     // Catch: Throwable -> L20
        return;
    L13:
        r2 = d.b.b.f.c.a.EnumC0334a.f12742h;     // Catch: Throwable -> L20
        goto L14
    }

    boolean i() {
        return this.f12754a.get();
    }

    void k(d.b.b.f.d.a r4) {
        if (this.f12754a.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        this.f12757d = new HashMap();
        this.f12758e = new HashMap();
        this.f12759f = new HashMap();
        this.f12755b = r4;
    }

    public void l(d.b.w.a.a.c.a r3) {
        if (this.f12754a.get() == true) goto L6;
        return;
    L6:
        monitor-enter(c.class);
        f(d.b.b.f.c.a.EnumC0334a.f12741g, r3);     // Catch: Throwable -> L10
        f(d.b.b.f.c.a.EnumC0334a.f12742h, r3);     // Catch: Throwable -> L10
        f(d.b.b.f.c.a.EnumC0334a.f12740f, r3);     // Catch: Throwable -> L10
        monitor-exit(c.class);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
