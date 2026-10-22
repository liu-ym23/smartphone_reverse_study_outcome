package kotlin.s0.w.d.l0.c.s1.b;

import java.lang.reflect.Member;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public final class y extends t implements kotlin.s0.w.d.l0.e.a.n0.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f19157a;

    public y(Object r2) {
        kotlin.n0.d.o.f(r2, "recordComponent");
        this.f19157a = r2;
    }

    @Override // kotlin.s0.w.d.l0.c.s1.b.t
    public Member U() {
        Method r1 = a.f19099a.c(this.f19157a);
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new NoSuchMethodError("Can't find `getAccessor` method");
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.w
    public kotlin.s0.w.d.l0.e.a.n0.x b() {
        Class<?> r1 = a.f19099a.d(this.f19157a);
        if (r1 == null) goto L7;
        return new n(r1);
    L7:
        throw new NoSuchMethodError("Can't find `getType` method");
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.w
    public boolean c() {
        return false;
    }
}
