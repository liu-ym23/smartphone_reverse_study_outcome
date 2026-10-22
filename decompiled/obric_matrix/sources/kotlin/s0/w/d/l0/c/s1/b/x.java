package kotlin.s0.w.d.l0.c.s1.b;

import java.lang.reflect.Type;
import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
public final class x extends z implements kotlin.s0.w.d.l0.e.a.n0.v {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Class<?> f19154b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Collection<kotlin.s0.w.d.l0.e.a.n0.a> f19155c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f19156d;

    public x(Class<?> r2) {
        kotlin.n0.d.o.f(r2, "reflectType");
        this.f19154b = r2;
        this.f19155c = kotlin.i0.r.g();
    }

    @Override // kotlin.s0.w.d.l0.c.s1.b.z
    public /* bridge */ /* synthetic */ Type R() {
        return S();
    }

    protected Class<?> S() {
        return this.f19154b;
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.v
    public kotlin.s0.w.d.l0.b.i b() {
        if (kotlin.n0.d.o.a(S(), Void.TYPE) == false) goto L6;
        return null;
    L6:
        return kotlin.s0.w.d.l0.k.u.e.b(S().getName()).k();
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.d
    public Collection<kotlin.s0.w.d.l0.e.a.n0.a> getAnnotations() {
        return this.f19155c;
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.d
    public boolean l() {
        return this.f19156d;
    }
}
