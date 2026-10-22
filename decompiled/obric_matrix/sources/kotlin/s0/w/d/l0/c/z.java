package kotlin.s0.w.d.l0.c;

import java.util.List;
import kotlin.s0.w.d.l0.n.w1.k;

/* JADX INFO: loaded from: classes2.dex */
public final class z<Type extends kotlin.s0.w.d.l0.n.w1.k> extends h1<Type> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.g.f f19183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Type f19184b;

    public z(kotlin.s0.w.d.l0.g.f r2, Type r3) {
        kotlin.n0.d.o.f(r2, "underlyingPropertyName");
        kotlin.n0.d.o.f(r3, "underlyingType");
        super(null);
        this.f19183a = r2;
        this.f19184b = r3;
    }

    @Override // kotlin.s0.w.d.l0.c.h1
    public List<kotlin.u<kotlin.s0.w.d.l0.g.f, Type>> a() {
        return kotlin.i0.r.d(kotlin.a0.a(this.f19183a, this.f19184b));
    }

    public final kotlin.s0.w.d.l0.g.f c() {
        return this.f19183a;
    }

    public final Type d() {
        return this.f19184b;
    }
}
