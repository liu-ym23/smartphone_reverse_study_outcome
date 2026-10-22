package kotlin.s0.w.d.l0.k;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h extends i {
    public h() {
    }

    @Override // kotlin.s0.w.d.l0.k.i
    public void b(kotlin.s0.w.d.l0.c.b r2, kotlin.s0.w.d.l0.c.b r3) {
        kotlin.n0.d.o.f(r2, "first");
        kotlin.n0.d.o.f(r3, "second");
        e(r2, r3);
    }

    @Override // kotlin.s0.w.d.l0.k.i
    public void c(kotlin.s0.w.d.l0.c.b r2, kotlin.s0.w.d.l0.c.b r3) {
        kotlin.n0.d.o.f(r2, "fromSuper");
        kotlin.n0.d.o.f(r3, "fromCurrent");
        e(r2, r3);
    }

    protected abstract void e(kotlin.s0.w.d.l0.c.b r1, kotlin.s0.w.d.l0.c.b r2);
}
