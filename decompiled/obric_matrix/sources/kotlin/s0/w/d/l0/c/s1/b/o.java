package kotlin.s0.w.d.l0.c.s1.b;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class o extends t implements kotlin.s0.w.d.l0.e.a.n0.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Constructor<?> f19148a;

    public o(Constructor<?> r2) {
        kotlin.n0.d.o.f(r2, "member");
        this.f19148a = r2;
    }

    @Override // kotlin.s0.w.d.l0.c.s1.b.t
    public /* bridge */ /* synthetic */ Member U() {
        return W();
    }

    public Constructor<?> W() {
        return this.f19148a;
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.z
    public List<a0> getTypeParameters() {
        TypeVariable<Constructor<?>>[] r5 = W().getTypeParameters();
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

    @Override // kotlin.s0.w.d.l0.e.a.n0.k
    public List<kotlin.s0.w.d.l0.e.a.n0.b0> h() {
        Type[] r0 = W().getGenericParameterTypes();
        kotlin.n0.d.o.e(r0, "types");
        if (r0.length != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L8;
        Class<?> r2 = W().getDeclaringClass();
        if (r2.getDeclaringClass() != null) goto L12;
    L14:
        Annotation[][] r3 = W().getParameterAnnotations();
        if (r3.length < r0.length) goto L22;
        if (r3.length <= r0.length) goto L19;
        kotlin.n0.d.o.e(r3, "annotations");
        r3 = (Annotation[][]) kotlin.i0.i.j(r3, r3.length - r0.length, r3.length);
    L19:
        kotlin.n0.d.o.e(r0, "realTypes");
        kotlin.n0.d.o.e(r3, "realAnnotations");
        return V(r0, r3, W().isVarArgs());
    L22:
        throw new IllegalStateException("Illegal generic signature: " + W());
    L12:
        if (Modifier.isStatic(r2.getModifiers()) == true) goto L14;
        r0 = (Type[]) kotlin.i0.i.j(r0, 1, r0.length);
        goto L14
    L8:
        return kotlin.i0.r.g();
    L5:
        r1 = false;
        goto L6
    }
}
