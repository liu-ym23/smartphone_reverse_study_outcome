package d.c.i.h;

import d.c.c.d.i;
import d.c.i.p.k;
import d.c.i.p.k0;
import d.c.i.p.t0;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object] */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a<T> extends d.c.d.a<T> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final t0 f16142g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final d.c.i.m.d f16143h;

    /* JADX INFO: renamed from: d.c.i.h.a$a, reason: collision with other inner class name */
    class C0429a extends d.c.i.p.b<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f16144b;

        C0429a(a r1) {
            this.f16144b = r1;
        }

        @Override // d.c.i.p.b
        protected void g() {
            a.u(this.f16144b);
        }

        @Override // d.c.i.p.b
        protected void h(Throwable r1) {
            a.t(this.f16144b, r1);
        }

        @Override // d.c.i.p.b
        protected void i(T r1, int r2) {
            this.f16144b.z(r1, r2);
        }

        @Override // d.c.i.p.b
        protected void j(float r1) {
            a.v(this.f16144b, r1);
        }
    }

    protected a(k0<T> r5, t0 r6, d.c.i.m.d r7) {
        if (d.c.i.r.b.d() == false) goto L5;
        d.c.i.r.b.a("AbstractProducerToDataSourceAdapter()");
    L5:
        this.f16142g = r6;
        this.f16143h = r7;
        if (d.c.i.r.b.d() == false) goto L8;
        d.c.i.r.b.a("AbstractProducerToDataSourceAdapter()->onRequestStart");
    L8:
        r7.a(r6.c(), r6.a(), r6.getId(), r6.e());
        if (d.c.i.r.b.d() == false) goto L12;
        d.c.i.r.b.b();
    L12:
        if (d.c.i.r.b.d() == false) goto L14;
        d.c.i.r.b.a("AbstractProducerToDataSourceAdapter()->produceResult");
    L14:
        r5.b(w(), r6);
        if (d.c.i.r.b.d() == false) goto L18;
        d.c.i.r.b.b();
    L18:
        if (d.c.i.r.b.d() == false) goto L21;
        d.c.i.r.b.b();
        return;
    }

    static /* synthetic */ void t(a r0, Throwable r1) {
        r0.y(r1);
    }

    static /* synthetic */ void u(a r0) {
        r0.x();
    }

    static /* synthetic */ boolean v(a r0, float r1) {
        return r0.o(r1);
    }

    private k<T> w() {
        return new C0429a(this);
    }

    private synchronized void x() {
        monitor-enter(this);
        i.i(i());     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private void y(Throwable r4) {
        if (super.m(r4) == false) goto L6;
        this.f16143h.g(this.f16142g.c(), this.f16142g.getId(), r4, this.f16142g.e());
        return;
    }

    @Override // d.c.d.a, d.c.d.c
    public boolean close() {
        if (super.close() == true) goto L7;
        return false;
    L7:
        if (super.b() == true) goto L11;
        this.f16143h.k(this.f16142g.getId());
        this.f16142g.m();
        return true;
    L11:
        return true;
    }

    protected void z(T r2, int r3) {
        boolean r4 = d.c.i.p.b.e(r3);
        if (super.q(r2, r4) == false) goto L11;
        d.c.i.m.d r5 = this.f16143h;
        if (r4 == false) goto L8;
        r5.c(this.f16142g.c(), this.f16142g.getId(), this.f16142g.e());
        return;
    L8:
        if ((r5 instanceof d.c.i.m.b) == false) goto L13;
        ((d.c.i.m.b) r5).l(this.f16142g.c(), this.f16142g.getId(), this.f16142g.e());
        return;
    L13:
        return;
    }
}
