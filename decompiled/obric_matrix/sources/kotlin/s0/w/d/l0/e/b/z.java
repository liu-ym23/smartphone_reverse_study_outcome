package kotlin.s0.w.d.l0.e.b;

import java.util.Collection;
import kotlin.s0.w.d.l0.n.e0;

/* JADX INFO: loaded from: classes2.dex */
public final class z implements y<l> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z f19799a = null;

    static {
        f19799a = new z();
    }

    private z() {
    }

    @Override // kotlin.s0.w.d.l0.e.b.y
    public /* bridge */ /* synthetic */ l a(kotlin.s0.w.d.l0.c.e r1) {
        return g(r1);
    }

    @Override // kotlin.s0.w.d.l0.e.b.y
    public String b(kotlin.s0.w.d.l0.c.e r1) {
        return y.a.a(this, r1);
    }

    @Override // kotlin.s0.w.d.l0.e.b.y
    public e0 c(Collection<? extends e0> r12) {
        kotlin.n0.d.o.f(r12, "types");
        throw new AssertionError("There should be no intersection type in existing descriptors, but found: " + kotlin.i0.r.Z(r12, null, null, null, 0, null, null, 63, null));
    }

    @Override // kotlin.s0.w.d.l0.e.b.y
    public String d(kotlin.s0.w.d.l0.c.e r1) {
        kotlin.n0.d.o.f(r1, "classDescriptor");
        return null;
    }

    @Override // kotlin.s0.w.d.l0.e.b.y
    public e0 e(e0 r1) {
        return y.a.b(this, r1);
    }

    @Override // kotlin.s0.w.d.l0.e.b.y
    public void f(e0 r1, kotlin.s0.w.d.l0.c.e r2) {
        kotlin.n0.d.o.f(r1, "kotlinType");
        kotlin.n0.d.o.f(r2, "descriptor");
    }

    public l g(kotlin.s0.w.d.l0.c.e r1) {
        kotlin.n0.d.o.f(r1, "classDescriptor");
        return null;
    }
}
