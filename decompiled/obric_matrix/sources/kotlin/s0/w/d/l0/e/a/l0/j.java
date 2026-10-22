package kotlin.s0.w.d.l0.e.a.l0;

import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class j implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public kotlin.s0.w.d.l0.k.u.c f19384a;

    public j() {
    }

    @Override // kotlin.s0.w.d.l0.e.a.l0.i
    public kotlin.s0.w.d.l0.c.e a(kotlin.s0.w.d.l0.e.a.n0.g r2) {
        o.f(r2, "javaClass");
        return b().b(r2);
    }

    public final kotlin.s0.w.d.l0.k.u.c b() {
        kotlin.s0.w.d.l0.k.u.c r0 = this.f19384a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.v("resolver");
        throw null;
    }

    public final void c(kotlin.s0.w.d.l0.k.u.c r2) {
        o.f(r2, "<set-?>");
        this.f19384a = r2;
    }
}
