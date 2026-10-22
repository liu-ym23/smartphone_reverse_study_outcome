package kotlin.s0.w.d.l0.c;

import java.util.List;
import kotlin.s0.w.d.l0.n.r1;

/* JADX INFO: loaded from: classes2.dex */
final class c implements f1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final f1 f18855f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final m f18856g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f18857h;

    public c(f1 r2, m r3, int r4) {
        kotlin.n0.d.o.f(r2, "originalDescriptor");
        kotlin.n0.d.o.f(r3, "declarationDescriptor");
        this.f18855f = r2;
        this.f18856g = r3;
        this.f18857h = r4;
    }

    @Override // kotlin.s0.w.d.l0.c.f1
    public boolean D() {
        return this.f18855f.D();
    }

    @Override // kotlin.s0.w.d.l0.c.m
    public <R, D> R K(o<R, D> r1, D r2) {
        return (R) this.f18855f.K(r1, r2);
    }

    @Override // kotlin.s0.w.d.l0.c.f1, kotlin.s0.w.d.l0.c.h, kotlin.s0.w.d.l0.c.m
    public f1 a() {
        f1 r1 = this.f18855f.a();
        kotlin.n0.d.o.e(r1, "originalDescriptor.original");
        return r1;
    }

    @Override // kotlin.s0.w.d.l0.c.h, kotlin.s0.w.d.l0.c.m
    public /* bridge */ /* synthetic */ h a() {
        return a();
    }

    @Override // kotlin.s0.w.d.l0.c.m
    public /* bridge */ /* synthetic */ m a() {
        return a();
    }

    @Override // kotlin.s0.w.d.l0.c.n, kotlin.s0.w.d.l0.c.m
    public m c() {
        return this.f18856g;
    }

    @Override // kotlin.s0.w.d.l0.c.o1.a
    public kotlin.s0.w.d.l0.c.o1.g getAnnotations() {
        return this.f18855f.getAnnotations();
    }

    @Override // kotlin.s0.w.d.l0.c.j0
    public kotlin.s0.w.d.l0.g.f getName() {
        return this.f18855f.getName();
    }

    @Override // kotlin.s0.w.d.l0.c.p
    public a1 getSource() {
        return this.f18855f.getSource();
    }

    @Override // kotlin.s0.w.d.l0.c.f1
    public List<kotlin.s0.w.d.l0.n.e0> getUpperBounds() {
        return this.f18855f.getUpperBounds();
    }

    @Override // kotlin.s0.w.d.l0.c.f1
    public kotlin.s0.w.d.l0.m.n h0() {
        return this.f18855f.h0();
    }

    @Override // kotlin.s0.w.d.l0.c.f1
    public int j() {
        return this.f18857h + this.f18855f.j();
    }

    @Override // kotlin.s0.w.d.l0.c.f1, kotlin.s0.w.d.l0.c.h
    public kotlin.s0.w.d.l0.n.e1 k() {
        return this.f18855f.k();
    }

    @Override // kotlin.s0.w.d.l0.c.f1
    public r1 n() {
        return this.f18855f.n();
    }

    @Override // kotlin.s0.w.d.l0.c.f1
    public boolean o0() {
        return true;
    }

    @Override // kotlin.s0.w.d.l0.c.h
    public kotlin.s0.w.d.l0.n.m0 s() {
        return this.f18855f.s();
    }

    public String toString() {
        return this.f18855f + "[inner-copy]";
    }
}
