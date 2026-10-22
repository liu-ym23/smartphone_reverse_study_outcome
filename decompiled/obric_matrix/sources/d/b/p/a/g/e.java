package d.b.p.a.g;

import d.b.p.a.d.h;
import d.b.p.a.d.i;

/* JADX INFO: loaded from: classes.dex */
public abstract class e extends a implements i {
    public e() {
    }

    @Override // d.b.p.a.g.a
    public void d() {
        super.d();
        if (g() == false) goto L6;
        d.b.p.a.b.f14211g.a(this);
        h.c(b(), "start called.");
        return;
    }

    @Override // d.b.p.a.g.a
    public d e() {
        return d.f14304g;
    }

    @Override // d.b.p.a.g.a
    public void f() {
        super.f();
        if (g() == false) goto L6;
        d.b.p.a.b.f14211g.g(this);
        h.c(b(), "stop called.");
        return;
    }

    public abstract boolean g();
}
