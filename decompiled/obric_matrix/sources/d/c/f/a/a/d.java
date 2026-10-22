package d.c.f.a.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.facebook.common.time.AwakeTimeSinceBootClock;
import d.c.c.d.h;
import d.c.c.d.i;
import d.c.c.d.l;
import d.c.f.e.o;
import d.c.f.e.p;
import d.c.i.e.q;
import d.c.i.g.j;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class d extends d.c.f.c.a<d.c.c.h.a<d.c.i.l.c>, d.c.i.l.f> {
    private static final Class<?> H = null;
    private l<d.c.d.c<d.c.c.h.a<d.c.i.l.c>>> A;
    private boolean B;
    private d.c.c.d.e<d.c.i.j.a> C;
    private d.c.f.a.a.i.g D;
    private Set<d.c.i.m.d> E;
    private d.c.f.a.a.i.b F;
    private d.c.f.a.a.h.a G;
    private final d.c.i.j.a w;
    private final d.c.c.d.e<d.c.i.j.a> x;
    private final q<d.c.b.a.d, d.c.i.l.c> y;
    private d.c.b.a.d z;

    static {
        H = d.class;
    }

    public d(Resources r2, d.c.f.b.a r3, d.c.i.j.a r4, Executor r5, q<d.c.b.a.d, d.c.i.l.c> r6, d.c.c.d.e<d.c.i.j.a> r7) {
        super(r3, r5, null, null);
        this.w = new a(r2, r4);
        this.x = r7;
        this.y = r6;
    }

    private void d0(l<d.c.d.c<d.c.c.h.a<d.c.i.l.c>>> r1) {
        this.A = r1;
        h0(null);
    }

    private Drawable g0(d.c.c.d.e<d.c.i.j.a> r3, d.c.i.l.c r4) {
        if (r3 != null) goto L5;
        return null;
    L5:
        Iterator<d.c.i.j.a> r5 = r3.iterator();
    L7:
        if (r5.hasNext() == false) goto L13;
        d.c.i.j.a r0 = r5.next();
        if (r0.b(r4) == false) goto L7;
        Drawable r1 = r0.c(r4);
        if (r1 == null) goto L7;
        return r1;
    L13:
        return null;
    }

    private void h0(d.c.i.l.c r4) {
        if (this.B == true) goto L6;
        return;
    L6:
        if (o() != null) goto L9;
        d.c.f.d.a r0 = new d.c.f.d.a();
        d.c.f.d.b.a r1 = new d.c.f.d.b.a(r0);
        this.G = new d.c.f.a.a.h.a();
        k(r1);
        N(r0);
    L9:
        if (this.F != null) goto L12;
        V(this.G);
    L12:
        if ((o() instanceof d.c.f.d.a) == false) goto L23;
        d.c.f.d.a r2 = (d.c.f.d.a) o();
        r2.f(s());
        d.c.f.h.b r3 = d();
        p.b r5 = null;
        if (r3 == null) goto L18;
        o r6 = p.a(r3.e());
        if (r6 == null) goto L18;
        r5 = r6.r();
    L18:
        r2.j(r5);
        r2.i(this.G.b());
        if (r4 == null) goto L21;
        r2.g(r4.getWidth(), r4.getHeight());
        r2.h(r4.x());
        return;
    L21:
        r2.e();
        return;
    }

    @Override // d.c.f.c.a
    protected /* bridge */ /* synthetic */ void F(String r1, d.c.c.h.a<d.c.i.l.c> r2) {
        i0(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // d.c.f.c.a
    protected void I(Drawable r1) {
        if ((r1 instanceof d.c.e.a.a) == false) goto L6;
        ((d.c.e.a.a) r1).a();
        return;
    }

    @Override // d.c.f.c.a
    protected /* bridge */ /* synthetic */ void K(d.c.c.h.a<d.c.i.l.c> r1) {
        j0(r1);
    }

    public synchronized void V(d.c.f.a.a.i.b r5) {
        monitor-enter(this);
        d.c.f.a.a.i.b r0 = this.F;     // Catch: Throwable -> L11
        if ((r0 instanceof d.c.f.a.a.i.a) == false) goto L6;
        ((d.c.f.a.a.i.a) r0).b(r5);     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return;
    L6:
        if (r0 == null) goto L8;
        this.F = new d.c.f.a.a.i.a(new d.c.f.a.a.i.b[]{r0, r5});     // Catch: Throwable -> L11
        goto L9
    L8:
        this.F = r5;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public synchronized void W(d.c.i.m.d r2) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.E != null) goto L6;
        this.E = new HashSet();     // Catch: Throwable -> L9
    L6:
        this.E.add(r2);     // Catch: Throwable -> L9
        monitor-exit(this);
    }

    protected void X() {
        monitor-enter(this);
        this.F = null;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    protected Drawable Y(d.c.c.h.a<d.c.i.l.c> r3) {
    L25:
        th = move-exception;
        if (d.c.i.r.b.d() == false) goto L29;
        d.c.i.r.b.b();
    L29:
        throw th;
    L3:
        if (d.c.i.r.b.d() == false) goto L5;
        d.c.i.r.b.a("PipelineDraweeController#createDrawable");     // Catch: Throwable -> L25
    L5:
        i.i(d.c.c.h.a.S(r3));     // Catch: Throwable -> L25
        d.c.i.l.c r4 = r3.N();     // Catch: Throwable -> L25
        h0(r4);     // Catch: Throwable -> L25
        Drawable r0 = g0(this.C, r4);     // Catch: Throwable -> L25
        if (r0 != null) goto L8;
        Drawable r1 = g0(this.x, r4);     // Catch: Throwable -> L25
        if (r1 != null) goto L14;
        Drawable r2 = this.w.a(r4, q());     // Catch: Throwable -> L25
        if (r2 == null) goto L24;
        if (d.c.i.r.b.d() == false) goto L22;
        d.c.i.r.b.b();
    L22:
        return r2;
    L24:
        throw new UnsupportedOperationException("Unrecognized image class: " + r4);     // Catch: Throwable -> L25
    L14:
        if (d.c.i.r.b.d() == false) goto L16;
        d.c.i.r.b.b();
    L16:
        return r1;
    L8:
        if (d.c.i.r.b.d() == false) goto L10;
        d.c.i.r.b.b();
    L10:
        return r0;
    }

    protected d.c.c.h.a<d.c.i.l.c> Z() {
        if (d.c.i.r.b.d() == false) goto L32;
        d.c.i.r.b.a("PipelineDraweeController#getCachedImage");
    L32:
        q<d.c.b.a.d, d.c.i.l.c> r0 = this.y;     // Catch: Throwable -> L27
        if (r0 == null) goto L24;
        d.c.b.a.d r2 = this.z;     // Catch: Throwable -> L27
        if (r2 == null) goto L24;
        d.c.c.h.a<d.c.i.l.c> r3 = r0.get(r2);     // Catch: Throwable -> L27
        if (r3 == null) goto L20;
        if (r3.N().s().a() == true) goto L20;
        r3.close();     // Catch: Throwable -> L27
        if (d.c.i.r.b.d() == false) goto L18;
        d.c.i.r.b.b();
    L18:
        return null;
    L20:
        if (d.c.i.r.b.d() == false) goto L22;
        d.c.i.r.b.b();
    L22:
        return r3;
    L24:
        if (d.c.i.r.b.d() == false) goto L26;
        d.c.i.r.b.b();
    L26:
        return null;
    L27:
        th = move-exception;
        if (d.c.i.r.b.d() == false) goto L31;
        d.c.i.r.b.b();
    L31:
        throw th;
    }

    protected int a0(d.c.c.h.a<d.c.i.l.c> r1) {
        if (r1 != null) goto L6;
        return 0;
    L6:
        return r1.O();
    }

    protected d.c.i.l.f b0(d.c.c.h.a<d.c.i.l.c> r1) {
        i.i(d.c.c.h.a.S(r1));
        return r1.N();
    }

    public synchronized d.c.i.m.d c0() {
        monitor-enter(this);
        d.c.f.a.a.i.c r0 = null;
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.F == null) goto L7;
        r0 = new d.c.f.a.a.i.c(s(), this.F);     // Catch: Throwable -> L16
    L7:
        Set<d.c.i.m.d> r1 = this.E;     // Catch: Throwable -> L16
        if (r1 == null) goto L14;
        d.c.i.m.c r2 = new d.c.i.m.c(r1);     // Catch: Throwable -> L16
        if (r0 == null) goto L12;
        r2.m(r0);     // Catch: Throwable -> L16
    L12:
        monitor-exit(this);
        return r2;
    L14:
        monitor-exit(this);
        return r0;
    }

    public void e0(l<d.c.d.c<d.c.c.h.a<d.c.i.l.c>>> r2, String r3, d.c.b.a.d r4, Object r5, d.c.c.d.e<d.c.i.j.a> r6, d.c.f.a.a.i.b r7, d.c.i.q.b r8) {
        if (d.c.i.r.b.d() == false) goto L5;
        d.c.i.r.b.a("PipelineDraweeController#initialize");
    L5:
        super.z(r3, r5, r8);
        d0(r2);
        this.z = r4;
        m0(r6);
        X();
        h0(null);
        V(r7);
        if (d.c.i.r.b.d() == false) goto L9;
        d.c.i.r.b.b();
        return;
    }

    protected synchronized void f0(d.c.f.a.a.i.f r3) {
        monitor-enter(this);
        d.c.f.a.a.i.g r0 = this.D;     // Catch: Throwable -> L13
        if (r0 == null) goto L6;
        r0.r();     // Catch: Throwable -> L13
    L6:
        if (r3 != null) goto L8;
    L11:
        monitor-exit(this);
        return;
    L8:
        if (this.D != null) goto L10;
        this.D = new d.c.f.a.a.i.g(AwakeTimeSinceBootClock.get(), this);     // Catch: Throwable -> L13
    L10:
        this.D.m(r3);     // Catch: Throwable -> L13
        this.D.s(true);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    @Override // d.c.f.c.a, d.c.f.h.a
    public void g(d.c.f.h.b r1) {
        super.g(r1);
        h0(null);
    }

    protected void i0(String r4, d.c.c.h.a<d.c.i.l.c> r5) {
        super.F(r4, r5);
        monitor-enter(this);
        d.c.f.a.a.i.b r6 = this.F;     // Catch: Throwable -> L10
        if (r6 == null) goto L7;
        r6.a(r4, 5, true);     // Catch: Throwable -> L10
    L7:
        d.c.i.m.d r7 = j.o().m().j(w(), c0());     // Catch: Throwable -> L10
        r7.a(w(), null, "-1", false);     // Catch: Throwable -> L10
        r7.c(w(), "-1", false);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    protected void j0(d.c.c.h.a<d.c.i.l.c> r1) {
        d.c.c.h.a.L(r1);
    }

    public synchronized void k0(d.c.f.a.a.i.b r5) {
        monitor-enter(this);
        d.c.f.a.a.i.b r0 = this.F;     // Catch: Throwable -> L11
        if ((r0 instanceof d.c.f.a.a.i.a) == false) goto L6;
        ((d.c.f.a.a.i.a) r0).c(r5);     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return;
    L6:
        if (r0 == null) goto L8;
        this.F = new d.c.f.a.a.i.a(new d.c.f.a.a.i.b[]{r0, r5});     // Catch: Throwable -> L11
        goto L9
    L8:
        this.F = r5;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    @Override // d.c.f.c.a
    protected /* bridge */ /* synthetic */ Drawable l(d.c.c.h.a<d.c.i.l.c> r1) {
        return Y(r1);
    }

    public synchronized void l0(d.c.i.m.d r2) {
        monitor-enter(this);
        Set<d.c.i.m.d> r0 = this.E;     // Catch: Throwable -> L10
        if (r0 != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        r0.remove(r2);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // d.c.f.c.a
    protected /* bridge */ /* synthetic */ d.c.c.h.a<d.c.i.l.c> m() {
        return Z();
    }

    public void m0(d.c.c.d.e<d.c.i.j.a> r1) {
        this.C = r1;
    }

    public void n0(boolean r1) {
        this.B = r1;
    }

    @Override // d.c.f.c.a
    public d.c.d.c<d.c.c.h.a<d.c.i.l.c>> p() {
        if (d.c.i.r.b.d() == false) goto L6;
        d.c.i.r.b.a("PipelineDraweeController#getDataSource");
    L6:
        if (d.c.c.e.a.p(2) == false) goto L8;
        d.c.c.e.a.s(H, "controller %x: getDataSource", Integer.valueOf(System.identityHashCode(this)));
    L8:
        d.c.d.c<d.c.c.h.a<d.c.i.l.c>> r3 = this.A.get();
        if (d.c.i.r.b.d() == false) goto L11;
        d.c.i.r.b.b();
    L11:
        return r3;
    }

    @Override // d.c.f.c.a
    public String toString() {
        h.b r0 = h.d(this);
        r0.b("super", super.toString());
        r0.b("dataSourceSupplier", this.A);
        return r0.toString();
    }

    @Override // d.c.f.c.a
    protected /* bridge */ /* synthetic */ int u(d.c.c.h.a<d.c.i.l.c> r1) {
        return a0(r1);
    }

    @Override // d.c.f.c.a
    protected /* bridge */ /* synthetic */ d.c.i.l.f v(d.c.c.h.a<d.c.i.l.c> r1) {
        return b0(r1);
    }
}
