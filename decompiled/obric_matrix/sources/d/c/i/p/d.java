package d.c.i.p;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class d implements l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.c.i.q.b f16227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f16228b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final n0 f16229c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f16230d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d.c.i.q.b.EnumC0435b f16231e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f16232f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private d.c.i.f.e f16233g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f16234h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f16235i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final List<m0> f16236j;

    public d(d.c.i.q.b r1, String r2, n0 r3, Object r4, d.c.i.q.b.EnumC0435b r5, boolean r6, boolean r7, d.c.i.f.e r8) {
        this.f16227a = r1;
        this.f16228b = r2;
        this.f16229c = r3;
        this.f16230d = r4;
        this.f16231e = r5;
        this.f16232f = r6;
        this.f16233g = r8;
        this.f16234h = r7;
        this.f16235i = false;
        this.f16236j = new ArrayList();
    }

    public static void i(List<m0> r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        Iterator<m0> r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        r2.next().a();
        goto L6
    }

    public static void j(List<m0> r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        Iterator<m0> r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        r2.next().b();
        goto L6
    }

    public static void k(List<m0> r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        Iterator<m0> r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        r2.next().d();
        goto L6
    }

    public static void l(List<m0> r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        Iterator<m0> r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        r2.next().c();
        goto L6
    }

    @Override // d.c.i.p.l0
    public Object a() {
        return this.f16230d;
    }

    @Override // d.c.i.p.l0
    public synchronized d.c.i.f.e b() {
        monitor-enter(this);
        d.c.i.f.e r0 = this.f16233g;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // d.c.i.p.l0
    public d.c.i.q.b c() {
        return this.f16227a;
    }

    @Override // d.c.i.p.l0
    public void d(m0 r2) {
        monitor-enter(this);
        this.f16236j.add(r2);     // Catch: Throwable -> L8
        boolean r0 = this.f16235i;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        if (r0 == false) goto L13;
        r2.a();
        return;
    L13:
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // d.c.i.p.l0
    public synchronized boolean e() {
        monitor-enter(this);
        boolean r0 = this.f16232f;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // d.c.i.p.l0
    public n0 f() {
        return this.f16229c;
    }

    @Override // d.c.i.p.l0
    public synchronized boolean g() {
        monitor-enter(this);
        boolean r0 = this.f16234h;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // d.c.i.p.l0
    public String getId() {
        return this.f16228b;
    }

    @Override // d.c.i.p.l0
    public d.c.i.q.b.EnumC0435b h() {
        return this.f16231e;
    }

    public void m() {
        i(n());
    }

    public synchronized List<m0> n() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.f16235i == false) goto L9;
        monitor-exit(this);
        return null;
    L9:
        this.f16235i = true;     // Catch: Throwable -> L12
        ArrayList r0 = new ArrayList(this.f16236j);     // Catch: Throwable -> L12
        monitor-exit(this);
        return r0;
    }

    public synchronized List<m0> o(boolean r2) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (r2 == this.f16234h) goto L6;
        this.f16234h = r2;     // Catch: Throwable -> L11
        ArrayList r3 = new ArrayList(this.f16236j);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r3;
    L6:
        monitor-exit(this);
        return null;
    }

    public synchronized List<m0> p(boolean r2) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (r2 == this.f16232f) goto L6;
        this.f16232f = r2;     // Catch: Throwable -> L11
        ArrayList r3 = new ArrayList(this.f16236j);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r3;
    L6:
        monitor-exit(this);
        return null;
    }

    public synchronized List<m0> q(d.c.i.f.e r2) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (r2 == this.f16233g) goto L6;
        this.f16233g = r2;     // Catch: Throwable -> L11
        ArrayList r3 = new ArrayList(this.f16236j);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r3;
    L6:
        monitor-exit(this);
        return null;
    }
}
