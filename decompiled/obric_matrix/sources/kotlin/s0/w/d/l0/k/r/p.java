package kotlin.s0.w.d.l0.k.r;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.s0.w.d.l0.c.f1;
import kotlin.s0.w.d.l0.c.h0;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.s0.w.d.l0.n.e1;

/* JADX INFO: loaded from: classes2.dex */
public final class p implements e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f20585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h0 f20586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayList<e0> f20587c;

    @Override // kotlin.s0.w.d.l0.n.e1
    public Collection<e0> a() {
        return this.f20587c;
    }

    @Override // kotlin.s0.w.d.l0.n.e1
    public e1 c(kotlin.s0.w.d.l0.n.t1.g r2) {
        kotlin.n0.d.o.f(r2, "kotlinTypeRefiner");
        return this;
    }

    @Override // kotlin.s0.w.d.l0.n.e1
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.h d() {
        return (kotlin.s0.w.d.l0.c.h) g();
    }

    @Override // kotlin.s0.w.d.l0.n.e1
    public boolean e() {
        return false;
    }

    public Void g() {
        return null;
    }

    @Override // kotlin.s0.w.d.l0.n.e1
    public List<f1> getParameters() {
        return kotlin.i0.r.g();
    }

    @Override // kotlin.s0.w.d.l0.n.e1
    public kotlin.s0.w.d.l0.b.h o() {
        return this.f20586b.o();
    }

    public String toString() {
        return "IntegerValueType(" + this.f20585a + ')';
    }
}
