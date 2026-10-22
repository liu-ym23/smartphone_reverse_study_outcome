package kotlin.s0.w.d.l0.e.a.o0;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
final class c implements kotlin.s0.w.d.l0.c.o1.g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.g.c f19542f;

    public c(kotlin.s0.w.d.l0.g.c r2) {
        kotlin.n0.d.o.f(r2, "fqNameToMatch");
        this.f19542f = r2;
    }

    public b a(kotlin.s0.w.d.l0.g.c r2) {
        kotlin.n0.d.o.f(r2, "fqName");
        if (kotlin.n0.d.o.a(r2, this.f19542f) == true) goto L7;
        return null;
    L7:
        return b.f19541a;
    }

    @Override // kotlin.s0.w.d.l0.c.o1.g
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.o1.c i(kotlin.s0.w.d.l0.g.c r1) {
        return a(r1);
    }

    @Override // kotlin.s0.w.d.l0.c.o1.g
    public boolean isEmpty() {
        return false;
    }

    @Override // java.lang.Iterable
    public Iterator<kotlin.s0.w.d.l0.c.o1.c> iterator() {
        return kotlin.i0.r.g().iterator();
    }

    @Override // kotlin.s0.w.d.l0.c.o1.g
    public boolean k(kotlin.s0.w.d.l0.g.c r1) {
        return kotlin.s0.w.d.l0.c.o1.g.b.b(this, r1);
    }
}
