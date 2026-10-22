package kotlin.s0.w.d.l0.c.s1.b;

import java.lang.annotation.Annotation;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class u extends t implements kotlin.s0.w.d.l0.e.a.n0.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Method f19152a;

    public u(Method r2) {
        kotlin.n0.d.o.f(r2, "member");
        this.f19152a = r2;
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.r
    public boolean L() {
        return kotlin.s0.w.d.l0.e.a.n0.r.a.a(this);
    }

    @Override // kotlin.s0.w.d.l0.c.s1.b.t
    public /* bridge */ /* synthetic */ Member U() {
        return W();
    }

    public Method W() {
        return this.f19152a;
    }

    public z X() {
        z.a r0 = z.f19158a;
        Type r2 = W().getGenericReturnType();
        kotlin.n0.d.o.e(r2, "member.genericReturnType");
        return r0.a(r2);
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.r
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.e.a.n0.x getReturnType() {
        return X();
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.z
    public List<a0> getTypeParameters() {
        TypeVariable<Method>[] r5 = W().getTypeParameters();
        kotlin.n0.d.o.e(r5, "member.typeParameters");
        ArrayList r0 = new ArrayList(r5.length);
        int r1 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0.add(new a0(r5[r2]));
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.r
    public List<kotlin.s0.w.d.l0.e.a.n0.b0> h() {
        Type[] r0 = W().getGenericParameterTypes();
        kotlin.n0.d.o.e(r0, "member.genericParameterTypes");
        Annotation[][] r1 = W().getParameterAnnotations();
        kotlin.n0.d.o.e(r1, "member.parameterAnnotations");
        return V(r0, r1, W().isVarArgs());
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.r
    public kotlin.s0.w.d.l0.e.a.n0.b r() {
        Object r2 = W().getDefaultValue();
        if (r2 != null) goto L5;
        return null;
    L5:
        return f.f19128b.a(r2, null);
    }
}
