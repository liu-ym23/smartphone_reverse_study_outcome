package kotlin.s0.w.d.l0.c.s1.b;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends z implements kotlin.s0.w.d.l0.e.a.n0.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Type f19132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final z f19133c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Collection<kotlin.s0.w.d.l0.e.a.n0.a> f19134d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f19135e;

    public k(Type r3) {
        kotlin.n0.d.o.f(r3, "reflectType");
        this.f19132b = r3;
        Type r4 = R();
        if ((r4 instanceof GenericArrayType) == false) goto L7;
        z.a r0 = z.f19158a;
        Type r5 = ((GenericArrayType) r4).getGenericComponentType();
        String r1 = "genericComponentType";
    L5:
        kotlin.n0.d.o.e(r5, r1);
        this.f19133c = r0.a(r5);
        this.f19134d = kotlin.i0.r.g();
        return;
    L7:
        if ((r4 instanceof Class) == false) goto L14;
        Class r6 = (Class) r4;
        if (r6.isArray() == false) goto L14;
        r0 = z.f19158a;
        r5 = r6.getComponentType();
        r1 = "getComponentType()";
    L14:
        throw new IllegalArgumentException("Not an array type (" + R().getClass() + "): " + R());
    }

    @Override // kotlin.s0.w.d.l0.c.s1.b.z
    protected Type R() {
        return this.f19132b;
    }

    public z S() {
        return this.f19133c;
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.d
    public Collection<kotlin.s0.w.d.l0.e.a.n0.a> getAnnotations() {
        return this.f19134d;
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.d
    public boolean l() {
        return this.f19135e;
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.f
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.e.a.n0.x n() {
        return S();
    }
}
