package kotlin.s0.w.d.l0.k.q.a;

import java.util.Collection;
import java.util.List;
import kotlin.i0.r;
import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.c.f1;
import kotlin.s0.w.d.l0.c.h;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.s0.w.d.l0.n.e1;
import kotlin.s0.w.d.l0.n.g1;
import kotlin.s0.w.d.l0.n.r1;
import kotlin.s0.w.d.l0.n.t1.g;
import kotlin.s0.w.d.l0.n.t1.j;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g1 f20558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private j f20559b;

    public c(g1 r2) {
        o.f(r2, "projection");
        this.f20558a = r2;
        f().a();
        r1 r3 = r1.f21065h;
    }

    @Override // kotlin.s0.w.d.l0.n.e1
    public Collection<e0> a() {
        if (f().a() != r1.f21067j) goto L5;
        e0 r2 = f().b();
    L6:
        o.e(r2, "if (projection.projectio… builtIns.nullableAnyType");
        return r.d(r2);
    L5:
        r2 = o().I();
        goto L6
    }

    @Override // kotlin.s0.w.d.l0.n.e1
    public /* bridge */ /* synthetic */ e1 c(g r1) {
        return i(r1);
    }

    @Override // kotlin.s0.w.d.l0.n.e1
    public /* bridge */ /* synthetic */ h d() {
        return (h) g();
    }

    @Override // kotlin.s0.w.d.l0.n.e1
    public boolean e() {
        return false;
    }

    @Override // kotlin.s0.w.d.l0.k.q.a.b
    public g1 f() {
        return this.f20558a;
    }

    public Void g() {
        return null;
    }

    @Override // kotlin.s0.w.d.l0.n.e1
    public List<f1> getParameters() {
        return r.g();
    }

    public final j h() {
        return this.f20559b;
    }

    public c i(g r2) {
        o.f(r2, "kotlinTypeRefiner");
        g1 r1 = f().c(r2);
        o.e(r1, "projection.refine(kotlinTypeRefiner)");
        return new c(r1);
    }

    public final void j(j r1) {
        this.f20559b = r1;
    }

    @Override // kotlin.s0.w.d.l0.n.e1
    public kotlin.s0.w.d.l0.b.h o() {
        kotlin.s0.w.d.l0.b.h r1 = f().b().O0().o();
        o.e(r1, "projection.type.constructor.builtIns");
        return r1;
    }

    public String toString() {
        return "CapturedTypeConstructor(" + f() + ')';
    }
}
