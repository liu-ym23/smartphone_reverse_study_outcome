package kotlin.s0.w.d.l0.c.s1.b;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
public final class c0 extends z implements kotlin.s0.w.d.l0.e.a.n0.c0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WildcardType f19118b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Collection<kotlin.s0.w.d.l0.e.a.n0.a> f19119c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f19120d;

    public c0(WildcardType r2) {
        kotlin.n0.d.o.f(r2, "reflectType");
        this.f19118b = r2;
        this.f19119c = kotlin.i0.r.g();
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.c0
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.e.a.n0.x B() {
        return S();
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.c0
    public boolean J() {
        Type[] r1 = T().getUpperBounds();
        kotlin.n0.d.o.e(r1, "reflectType.upperBounds");
        return !kotlin.n0.d.o.a(kotlin.i0.i.x(r1), Object.class);
    }

    @Override // kotlin.s0.w.d.l0.c.s1.b.z
    public /* bridge */ /* synthetic */ Type R() {
        return T();
    }

    public z S() {
        Type[] r0 = T().getUpperBounds();
        Type[] r1 = T().getLowerBounds();
        if (r0.length > 1) goto L16;
        if (r1.length > 1) goto L16;
        if (r1.length != 1) goto L10;
        z.a r4 = z.f19158a;
        kotlin.n0.d.o.e(r1, "lowerBounds");
        Object r2 = kotlin.i0.i.S(r1);
        kotlin.n0.d.o.e(r2, "lowerBounds.single()");
        return r4.a((Type) r2);
    L10:
        if (r0.length != 1) goto L18;
        kotlin.n0.d.o.e(r0, "upperBounds");
        Type r5 = (Type) kotlin.i0.i.S(r0);
        if (kotlin.n0.d.o.a(r5, Object.class) == true) goto L19;
        z.a r3 = z.f19158a;
        kotlin.n0.d.o.e(r5, "ub");
        return r3.a(r5);
    L19:
        return null;
    L18:
        return null;
    L16:
        throw new UnsupportedOperationException("Wildcard types with many bounds are not yet supported: " + T());
    }

    protected WildcardType T() {
        return this.f19118b;
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.d
    public Collection<kotlin.s0.w.d.l0.e.a.n0.a> getAnnotations() {
        return this.f19119c;
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.d
    public boolean l() {
        return this.f19120d;
    }
}
