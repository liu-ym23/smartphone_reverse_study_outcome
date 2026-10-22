package kotlin.s0.w.d.l0.c.s1.a;

import java.util.List;
import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.l.b.r;

/* JADX INFO: loaded from: classes2.dex */
public final class j implements r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j f19092b = null;

    static {
        f19092b = new j();
    }

    private j() {
    }

    @Override // kotlin.s0.w.d.l0.l.b.r
    public void a(kotlin.s0.w.d.l0.c.b r3) {
        o.f(r3, "descriptor");
        throw new IllegalStateException("Cannot infer visibility for " + r3);
    }

    @Override // kotlin.s0.w.d.l0.l.b.r
    public void b(kotlin.s0.w.d.l0.c.e r3, List<String> r4) {
        o.f(r3, "descriptor");
        o.f(r4, "unresolvedSuperClasses");
        throw new IllegalStateException("Incomplete hierarchy for class " + r3.getName() + ", unresolved classes " + r4);
    }
}
